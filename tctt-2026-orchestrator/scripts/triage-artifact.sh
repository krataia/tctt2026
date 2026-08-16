#!/usr/bin/env bash
set -euo pipefail

usage() {
    echo 'Usage: triage-artifact.sh <local-file-or-directory>' >&2
}

if [[ $# -ne 1 ]]; then
    usage
    exit 64
fi

target=$1
if [[ ! -e "$target" ]]; then
    echo "NOT_FOUND: $target" >&2
    exit 66
fi
if ! command -v file >/dev/null 2>&1 || ! command -v sha256sum >/dev/null 2>&1; then
    echo 'MISSING_DEPENDENCY: file and sha256sum are required.' >&2
    exit 69
fi

if [[ -d "$target" ]]; then
    echo "KIND=directory"
    echo "PATH=$target"
    echo 'ROUTE_HINT=source-or-forensics-intake'
    echo 'FILES_FIRST_25='
    find "$target" -maxdepth 2 -type f -printf '%s\t%p\n' | sort -n | sed -n '1,25p'
    exit 0
fi

kind=$(file -b "$target")
hash=$(sha256sum "$target" | awk '{print $1}')
size=$(stat -c '%s' "$target")
route='manual-triage'
supplement='none'

case "$target:$kind" in
    *.apk:*|*.xapk:*|*.aar:*|*.jar:*|*'Android package'*|*'Dalvik dex'* )
        route='competition-android-hooking-or-competition-crypto-mobile'
        supplement='android-reverse-engineering-skill-or-p4nda-rev-dex-dumper'
        ;;
    *'ELF '*|*'PE32'*|*'MS-DOS executable'*)
        route='competition-reverse-pwn'
        supplement='wshobson-binary-analysis-or-claude-red-exploit-dev'
        ;;
    *'pcap capture file'*|*'pcapng capture file'*)
        route='competition-pcap-protocol'
        supplement='wshobson-protocol-reverse-engineering'
        ;;
    *'Zip archive data'*|*.zip:*)
        route='competition-zip-archive'
        supplement='competition-stego-media-if-format-anomaly'
        ;;
    *'image data'*|*'JPEG image data'*|*'PNG image data'*|*'GIF image data'*)
        route='competition-stego-media'
        supplement='none'
        ;;
    *.pcap|*.pcapng)
        route='competition-pcap-protocol'
        supplement='wshobson-protocol-reverse-engineering'
        ;;
    *.c|*.cc|*.cpp|*.go|*.rs|*.py|*.js|*.ts|*.php|*.java|*.kt|*.cs)
        route='competition-web-runtime-or-competition-reverse-pwn'
        supplement='cloudflare-security-audit-skill'
        ;;
esac

printf 'KIND=file\nPATH=%s\nSIZE_BYTES=%s\nSHA256=%s\nFILE=%s\nROUTE_HINT=%s\nSUPPLEMENT_HINT=%s\n' "$target" "$size" "$hash" "$kind" "$route" "$supplement"

if [[ "$route" == 'competition-reverse-pwn' ]] && command -v readelf >/dev/null 2>&1; then
    echo 'ELF_HEADER='
    readelf -h "$target" | awk -F: '/Class:|Data:|Machine:|Type:/ {gsub(/^[[:space:]]+/, "", $2); print $1 ":" $2}'
fi
