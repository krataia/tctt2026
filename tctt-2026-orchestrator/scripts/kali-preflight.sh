#!/usr/bin/env bash
set -euo pipefail

usage() {
    cat <<'EOF'
Usage: kali-preflight.sh [--minimum]

Read-only Kali Linux CTF toolchain check.
  --minimum  Check only the universal baseline; omit it for all CTF domains.
EOF
}

minimum=false
case "${1:-}" in
    "") ;;
    --minimum) minimum=true ;;
    -h|--help) usage; exit 0 ;;
    *) usage >&2; exit 64 ;;
esac

if [[ ! -r /etc/os-release ]]; then
    echo 'KALI_REQUIRED: /etc/os-release is unavailable.' >&2
    exit 2
fi

. /etc/os-release
if [[ "${ID:-}" != 'kali' ]]; then
    echo "KALI_REQUIRED: detected ${ID:-unknown} ${VERSION_ID:-unknown}; run this check on Kali Linux." >&2
    exit 2
fi

check_group() {
    local name="$1"
    shift
    local missing=0
    printf '\n[%s]\n' "$name"
    for spec in "$@"; do
        IFS='|' read -r -a candidates <<< "$spec"
        local resolved=''
        local candidate
        for candidate in "${candidates[@]}"; do
            if command -v "$candidate" >/dev/null 2>&1; then
                resolved=$(command -v "$candidate")
                break
            fi
        done
        if [[ -n "$resolved" ]]; then
            printf 'READY   %-24s %s\n' "$spec" "$resolved"
        else
            printf 'MISSING %-24s\n' "$spec"
            missing=$((missing + 1))
        fi
    done
    GROUP_MISSING=$missing
}

failures=0
check_group 'baseline' file strings readelf objdump gdb python3 node jq curl openssl nc
failures=$((failures + GROUP_MISSING))

if [[ "$minimum" == false ]]; then
    check_group 'reverse-and-pwn' r2 rabin2 'ghidra|ghidraRun' jadx apktool frida frida-ps adb
    failures=$((failures + GROUP_MISSING))
    check_group 'forensics-and-firmware' binwalk yara tshark exiftool foremost 'volatility3|vol|vol.py'
    failures=$((failures + GROUP_MISSING))
    check_group 'crypto-and-stego' john hashcat zsteg steghide bkcrack
    failures=$((failures + GROUP_MISSING))
    check_group 'web-and-network' nmap ffuf sqlmap nuclei gobuster
    failures=$((failures + GROUP_MISSING))
fi

for path in /usr/share/seclists /usr/share/wordlists; do
    if [[ -d "$path" ]]; then
        printf 'READY   %-14s %s\n' "$(basename "$path")" "$path"
    else
        printf 'MISSING %-14s\n' "$(basename "$path")"
        failures=$((failures + 1))
    fi
done

if (( failures > 0 )); then
    printf '\nRESULT: %d capability checks are missing. Use reverse-skill/kali/scripts/bootstrap-reverse.sh --list, then approve only the capabilities you need.\n' "$failures" >&2
    exit 1
fi

printf '\nRESULT: Kali CTF toolchain check passed.\n'
