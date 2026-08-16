# Stage: re-toolchain-routing-test

- Started: 2026-08-13 07:58:00
- Updated: 2026-08-13 08:12:06
- Status: in_progress

## Task

Operator request (faithful summary, Thai → EN): "Go ahead" — proceeding with the two offered actions from the RE-index task:
1. Install the missing RE toolchain on Kali.
2. Test orchestrator routing on .exe/.apk (and other format) samples.

## Attempts and experiments

### Toolchain installation (user-space, no sudo — sudo requires a password)
- `pip3 install --user frida-tools==14.10.4` → **frida 17.17.0** + frida-ps ✅
- jq 1.7.1 static binary → `~/.local/bin/jq` ✅
- **jadx v1.5.6** → `~/tools/jadx` (sha256 verified vs manifest pin `545ea2be…`), symlink `~/.local/bin/jadx` ✅
- **apktool v3.0.2** → `~/tools/apktool/apktool.jar` + wrapper `~/.local/bin/apktool` (sha256 verified `eee4669a…`) ✅
- **bkcrack 1.8.1** (Linux-x86_64) → `~/.local/bin/bkcrack` (digest verified from GitHub API; first attempt grabbed the aarch64 build → exec format error, corrected) ✅
- `pip3 install --user volatility3` → `vol` 2.28.0 ✅

### Ghidra manual install — ABANDONED (environment issue)
- Attempted Ghidra 12.1.2 download+verify+extract 4× (to /tmp, to /home, background, foreground, sandboxed and non-sandboxed).
- Repeatedly corrupts: file sha256 verified correct against GitHub digest immediately after download, then **changes within the same command** and `unzip -t`/extraction report random bad CRCs at different offsets each attempt. Small downloads (jadx/apktool/bkcrack/frida/jq) are consistently fine; only the ~570 MB archive is affected.
- Conclusion: unreliable large-file read-back on this environment's storage — not a script bug. Deferred Ghidra to the `apt` route (dpkg verifies checksums).

### Routing test (all passed)
- Built synthetic signature stubs (clearly labeled, NOT real malware): `work/re-routing-test/sample_x64.exe` (PE32+ x86-64, 1024 B) and `work/re-routing-test/sample.apk` (Android package with classes.dex, 408 B).
- `triage-artifact.sh` results:
  - `router` (real ELF) → **competition-reverse-pwn** + wshobson-binary-analysis-or-claude-red-exploit-dev + ELF_HEADER dump ✅
  - `sample_x64.exe` (PE32+) → **competition-reverse-pwn** + same supplement ✅ (note: script then attempts `readelf -h` on the PE, which errors cosmetically — harmless, route is correct)
  - `sample.apk` (Android) → **competition-android-hooking-or-competition-crypto-mobile** + android-reverse-engineering-skill-or-p4nda-rev-dex-dumper ✅
  - directory → **source-or-forensics-intake** ✅
- `refresh-tool-index.sh` regenerated: **63 tools detected** (was missing jadx/apktool/frida/bkcrack; now present). `.tctt-tool-index.json` is a stub (jq required — now installed).
- `kali-preflight.sh`: missing count dropped 9 → **8** after volatility3. Remaining: gdb, ghidra, adb, apksigner, zipalign, gef, yara, foremost, zsteg, steghide, seclists — all apt-gated.

## Observations

- All user-space RE toolchain installs verified working (version checks pass).
- Large single-file downloads corrupt on read-back in this environment; small files are unaffected. Flag for future installs.
- Routing is verified end-to-end for ELF, PE32, APK, and directory intake via `triage-artifact.sh`.

## Lessons learned

- Verify every downloaded asset with the pinned sha256/digest — this caught the truncated /tmp download and the transient byte corruption of the first /home download.
- /tmp on this host is a ~985 MB tmpfs — never stage large downloads there.
- The bootstrap script's jadx/ghidra paths install to `~/tools/`; symlinking `~/tools/<tool>/bin/*` (or wrappers) into `~/.local/bin` makes them PATH-visible and tool-index-detected.

## Outcome and next steps

- Done (user-space): jadx, apktool, frida, frida-ps, jq, bkcrack, volatility3 installed; routing test passed for all artifact classes.
- Blocked (needs sudo password): gdb, ghidra, adb, apksigner, zipalign, gef, yara, foremost, zsteg, steghide, seclists. **Next:** user runs the prepared `sudo apt-get install` command via `!` prefix; then regenerate `.tctt-tool-index.md` + re-run `kali-preflight.sh` (expect 0 missing).
- Optional improvement: fix `triage-artifact.sh` so the ELF_HEADER dump is skipped for non-ELF routes (currently emits a cosmetic readelf error on PE files).
