# Reverse-Engineering Skills Index (TCTT workspace)

Consolidated, source-locked catalogue of every reverse-engineering (RE) skill in this workspace, organized by binary/file format. Compiled **2026-08-13** by a 7-agent sweep workflow (6 parallel source sweeps + 1 verification pass, ~481k tokens): all 87 reported skill paths exist (`invalid_paths=[]`), no RE skill was missed (`missed_skills=[]`), and all 13 target formats are covered by 2+ skills.

Use this to answer *"which skill handles `.exe` / `.apk` / …?"* or to route an artifact to the right RE workflow. Paths are relative to the repo root.

## Quick map: format → best-fit skills

| Format | Primary specialist(s) | Also covers |
| --- | --- | --- |
| **.exe / PE32** (Windows) | `ida-reverse`, `radare2`, `malware-analysis`, `binary-diff`, `patch-diff-exploit`, `edr-bypass-re`, `thick-client` | wshobson `memory-forensics`, `binary-analysis-patterns`; claude-red `offensive-windows-mitigations`, `offensive-edr-evasion`, exploit-dev set |
| **.apk / DEX** (Android) | `apk-reverse`, `mobile-reverse`, `rev-dex-dumper`, `android-reverse-engineering` (SimoneAvogadro) | `competition-android-hooking`, `competition-crypto-mobile`, claude-red `offensive-mobile` |
| **.jar / .aar** (Java bytecode) | `android-reverse-engineering`, `mobile-reverse` | claude-red `offensive-mobile` |
| **.NET / DLL** (C#/VB) | `dotnet-reverse` (specialist) | `thick-client`, `malware-analysis`, `edr-bypass-re`, `rev-idapython`, wshobson `memory-forensics` |
| **ELF** (Linux/BSD) | `ghidra-reverse`, `ida-reverse`, `radare2`, `go-rust-reverse`, `pwn-chain` | `rev-unicorn-debug`, wshobson `anti-reversing-techniques`, `binary-analysis-patterns`; claude-red exploit-dev; `competition-reverse-pwn` |
| **iOS .ipa / Mach-O** | `macos-reverse`, `rev-ios-dump`, `mobile-reverse` | `competition-ios-runtime`, claude-red `offensive-mobile` |
| **macOS .app / .dylib** | `macos-reverse` | `rev-frida`, `mobile-reverse` |
| **.so (native lib)** | `mobile-reverse`, `rev-frida`, `rev-idapython`, `rev-u3d-dump` | `apk-reverse`, `go-rust-reverse`, `pwn-chain`, `android-reverse-engineering`, claude-red `offensive-mobile` |
| **firmware / embedded** | `firmware-pentest`, `competition-firmware-layout` | `hardware-security`, claude-red `offensive-iot`, `ghidra-reverse` |
| **Unity IL2CPP** | `rev-u3d-dump` (authoritative) | `dotnet-reverse` (Mono layer), `reverse-engineering` |
| **JS / WASM** | `js-reverse`, `dsl-vm-reverse` | `competition-bundle-sourcemap-recovery`, `browser-extension-reverse`, `rev-frida` |
| **memory dump** | wshobson `memory-forensics`, `digital-forensics` | `rev-frida`, `rev-unicorn-debug`, `competition-lsass-ticket-material`, `competition-dpapi-credential-chain`, `competition-reverse-pwn` |
| **protocol / pcap** | `protocol-reverse`, `protocol-reverse-engineering` | `competition-pcap-protocol`, `competition-custom-protocol-replay`, `malware-analysis`, `digital-forensics` |
| **zip / archive** (encrypted) | `competition-zip-archive` (bkcrack/PKZIP) | `browser-extension-reverse`, `competition-file-parser-chain` |

## Full catalogue by source area

### 1. `reverse-skill/` local package — specialist catalogue (`reverse-skill/skills/`)

Master index: `reverse-skill/skills/SKILL.md` (routes to 40+ modules). Note: the package scripts are Windows PowerShell-oriented (`.ps1`); Linux/Kali invocation of many bundled scripts is not covered in the SKILL.md files. [gap]

| Skill | Path | Formats | What it does |
| --- | --- | --- | --- |
| reverse-engineering | `skills/reverse-engineering/SKILL.md` | ELF, PE32, DEX, Mach-O, .so, WASM, .NET, Py bytecode, kernel drivers, memory dump, IL2CPP | General-purpose RE of compiled/obfuscated/packed/virtualized targets; big reference library; tools GDB/Frida/angr/Qiling/Unicorn/Triton/r2/Ghidra/IDA. **Primary binary-understanding entry.** |
| dsl-vm-reverse | `skills/reverse-engineering/dsl-vm-reverse/SKILL.md` | JS/webpack, WASM, custom JS DSL/VM bytecode | Reverse JS custom-DSL VM / risk-control engines (opcode dispatchers, constant tables). |
| apk-reverse | `skills/apk-reverse/SKILL.md` | .apk/DEX, smali, .so, AndroidManifest | APK CLI RE: jadx decompile, apktool unpack/smali patch/rebuild-sign-install, Frida hooking. |
| dotnet-reverse | `skills/dotnet-reverse/SKILL.md` | .NET (C#/VB DLLs), .exe, .dll, obfuscated assemblies | .NET managed RE: de4dot deobfuscation, dnSpyEx IL patch, Sharp* tool analysis. Routes native/IL2CPP out. |
| ghidra-reverse | `skills/ghidra-reverse/SKILL.md` | ELF, PE32, Mach-O, .so, firmware, DEX, WASM | Free Ghidra RE (GUI/headless), scripting, Ghidra MCP, ghidriff. No-IDA entry. |
| ida-reverse | `skills/ida-reverse/SKILL.md` | PE32, .dll, ELF, .so, .sys, DEX, Mach-O, firmware, WASM | IDA Pro via idalib-mcp (72 tools): decompile, xrefs, patch, types. |
| radare2 | `skills/radare2/SKILL.md` | PE32, .dll, .so, ELF, Mach-O, DEX, WASM | r2 CLI recon/disasm/patch (r2pipe). Imports-table check is a hard gate. |
| go-rust-reverse | `skills/go-rust-reverse/SKILL.md` | ELF, stripped Go (pclntab), Rust, .so | Stripped Go/Rust RE: GoReSym symbol recovery, panic-string-driven Rust analysis. |
| js-reverse | `skills/js-reverse/SKILL.md` | JS/webpack, browser scripts, Node runtime | Front-end JS RE via js-reverse MCP: signature/crypto params, runtime sampling, AST deobfuscation. |
| macos-reverse | `skills/macos-reverse/SKILL.md` | macOS .app/.dylib, iOS Mach-O, frameworks, LaunchAgent/Daemon | macOS/Mach-O RE: codesign, ObjC/Swift symbol recovery, Apple malware. |
| mobile-reverse | `skills/mobile-reverse/SKILL.md` | .apk/DEX, iOS .ipa/Mach-O, .so, smali | Unified Android+iOS app RE: static (JADX/Ghidra/Hopper) + dynamic (Frida/Objection/MobSF). |
| binary-diff | `skills/binary-diff/SKILL.md` | PE32, ELF, .so, kernel images | Cross-version symbol migration (PDB-absent kernels), LLM structured diff. |
| edr-bypass-re | `skills/edr-bypass-re/SKILL.md` | PE32, .dll, .sys, hook tables, ETW/AMSI | Reverse defenders → targeted bypass (indirect syscalls, unhook). Authorized-red-team only. |
| thick-client | `skills/thick-client/SKILL.md` | .NET, PE32, ELF, .so, Electron asar, JS | Desktop thick-client security testing (DLL hijack, IPC, credential vaults, update/signing checks). |
| malware-analysis | `skills/malware-analysis/SKILL.md` | PE32, ELF, Mach-O, .apk/DEX, packed, memory dump | 6-phase static+dynamic+behavioral malware analysis (YARA/Sigma, sandboxes, IOC). |
| firmware-pentest | `skills/firmware-pentest/SKILL.md` | firmware, .bin/.img/.trx/OTA, squashfs/UBI/JFFS2, ARM/MIPS ELF, U-Boot | OWASP FSTM 9-stage firmware/IoT chain (binwalk/unblob, EMBA, QEMU emulation, AFL++). |
| protocol-reverse | `skills/protocol-reverse/SKILL.md` | protocol/pcap, Protobuf/gRPC/FlatBuffers/MessagePack, MQTT/WebSocket | Custom binary protocol + serialization RE, .proto recovery, frame reconstruction. |
| patch-diff-exploit | `skills/patch-diff-exploit/SKILL.md` | PE32, ELF, kernel images, drivers, patch packages | N-day patch-diff-to-exploit (BinDiff/ghidriff/Diaphora). |
| pwn-chain | `skills/pwn-chain/SKILL.md` | ELF, PE32, kernel pwn, libc/.so | Vuln point → working exploit (pwntools, heap/kernel pwn, ROP, remote stabilization). |
| code-audit | `skills/code-audit/SKILL.md` | source code (multi-language) | Source SAST/audit (Semgrep/CodeQL); routes no-source binaries to RE skills. |
| browser-extension-reverse | `skills/browser-extension-reverse/SKILL.md` | crx/xpi, zip/archive, JS/webpack, manifest | Chrome/Edge/Firefox extension RE (MV2/MV3 workers, storage, crypto/signing logic). |
| hardware-security | `skills/hardware-security/SKILL.md` | firmware, UART/JTAG/SWD, SPI flash dumps | Hardware debug-port security (physical-access authorization gate). |
| digital-forensics | `skills/digital-forensics/SKILL.md` | memory dump, protocol/pcap, disk images/E01, Windows artifacts | DFIR: Volatility 3, timelines, PCAP attribution, host artifacts. |

### 2. `reverse-skill/` — competition routes (`reverse-skill/CTF-Sandbox-Orchestrator/`)

Primary router: `ctf-sandbox-orchestrator/SKILL.md` (default competition entry, routes to the narrowest `competition-*` child). RE-relevant children:

| Route | Path | Formats | Purpose |
| --- | --- | --- | --- |
| competition-reverse-pwn | `competition-reverse-pwn/SKILL.md` | ELF, PE32, .so, memory dump, firmware, pcap | Core RE/exploit/DFIR: triage, native+exploit path, crash-state. **Primary ELF/PE route.** |
| competition-android-hooking | `competition-android-hooking/SKILL.md` | .apk/DEX, .so, in-app prefs/DB | APK hooking: Frida, request-signing, pinning bypass, JNI. **Primary APK route.** |
| competition-ios-runtime | `competition-ios-runtime/SKILL.md` | iOS .ipa/Mach-O, macOS .app/.dylib | IPA runtime: Frida ObjC/Swift hooks, Keychain, signing. |
| competition-malware-config | `competition-malware-config/SKILL.md` | ELF, PE32, memory dump, pcap | Malware config/C2/IOC decode chain. |
| competition-firmware-layout | `competition-firmware-layout/SKILL.md` | firmware, zip/archive | Firmware layout: partitions, boot chain, update packages, extracted configs. |
| competition-crypto-mobile | `competition-crypto-mobile/SKILL.md` | .apk/DEX, iOS Mach-O, pcap | Crypto/encoding transform chain + mobile trust boundaries. |
| competition-file-parser-chain | `competition-file-parser-chain/SKILL.md` | Office/docs, zip, source | Upload/parse pipeline tracing (MIME/extension-driven parser surface). |
| competition-browser-persistence | `competition-browser-persistence/SKILL.md` | JS/webpack, memory dump | Client-side storage state (cookies/IndexedDB/SW/cache). |
| competition-zip-archive | `competition-zip-archive/SKILL.md` | zip/archive | Encrypted PKZIP/ZipCrypto known-plaintext (bkcrack). |
| competition-pcap-protocol | `competition-pcap-protocol/SKILL.md` | protocol/pcap | Packet capture: session map, reassembly, binary protocol decode. |
| competition-identity-windows | `competition-identity-windows/SKILL.md` | memory dump, PE32, pcap, Office | Windows/AD identity: Kerberos tickets, host artifacts, lateral chains. |
| competition-lsass-ticket-material | `competition-lsass-ticket-material/SKILL.md` | memory dump, PE32, pcap | LSASS-resident secrets / Kerberos ticket caches. |
| competition-dpapi-credential-chain | `competition-dpapi-credential-chain/SKILL.md` | memory dump, PE32 | DPAPI blob/masterkey unwrap → access. |
| competition-runtime-routing | `competition-runtime-routing/SKILL.md` | protocol/pcap, source | Reverse-proxy/vhost routing reconstruction (web-infra, not binary). |
| competition-stego-media | `competition-stego-media/SKILL.md` | Office/docs, media containers | Stego in image/audio/video/document/metadata. |
| competition-custom-protocol-replay | `competition-custom-protocol-replay/SKILL.md` | protocol/pcap | Custom protocol state machine + replay harness. |
| competition-forensic-timeline | `competition-forensic-timeline/SKILL.md` | memory dump, pcap, Office | DFIR chronology across EVTX/registry/disk/PCAP/memory. |
| competition-kernel-container-escape | `competition-kernel-container-escape/SKILL.md` | ELF, source | Kernel/container exploit work (namespaces, seccomp, boundary-crossing). |
| competition-bundle-sourcemap-recovery | `competition-bundle-sourcemap-recovery/SKILL.md` | JS/webpack, source | Frontend runtime recovery from built assets/source maps. |
| competition-windows-pivot | `competition-windows-pivot/SKILL.md` | memory dump, PE32, pcap | Host-to-host pivot chains (replay material, WinRM/SMB/RDP). |
| competition-kerberos-delegation | `competition-kerberos-delegation/SKILL.md` | memory dump, pcap | Kerberos delegation (constrained/RBCD/S4U) analysis. |

### 3. `vendor/p4nda0s-reverse-skills/` (pinned `a2baa31`, **unlicensed — private local use only**)

| Skill | Path | Formats | What it does |
| --- | --- | --- | --- |
| rev-dex-dumper | `skills/rev-dex-dumper/SKILL.md` | .apk/DEX, memory dump | Dump DEX from a running Android app (panda-dex-dumper + ADB) to unpack packed apps. |
| rev-frida | `skills/rev-frida/SKILL.md` | .so, .apk/DEX, iOS Mach-O, binaries | Generate modern Frida scripts (Interceptor, NativeFunction, Java/ObjC hooks, memory scan). |
| rev-idapython | `skills/rev-idapython/SKILL.md` | .so, ELF, firmware, binaries | IDAPython + IDALib (IDA 9 headless) script reference. |
| rev-struct | `skills/rev-struct/SKILL.md` | source (decompiled) | Reconstruct structs from memory-access patterns (needs IDA MCP or exported decompiles). |
| rev-symbol | `skills/rev-symbol/SKILL.md` | source (decompiled) | Restore function symbols in stripped binaries (needs IDA MCP or exported data). |
| rev-u3d-dump | `skills/rev-u3d-dump/SKILL.md` | Unity IL2CPP, .so, iOS Mach-O, .apk/DEX | Dump C# symbols from Unity IL2CPP builds + global-metadata.dat → IDA/Ghidra scripts. **Authoritative IL2CPP tool.** |
| rev-unicorn-debug | `skills/rev-unicorn-debug/SKILL.md` | binaries, ELF, .so, Mach-O, PE, firmware | Unicorn-engine function emulation debugger (JNI/syscall/libc stubs). |
| rev-ios-dump | `skills/rev-ios-dump/skill.md` | iOS .ipa/Mach-O, memory dump | Decrypt/dump iOS app Mach-O from device (frida-ios-dump fork). **NOTE: filename is lowercase `skill.md` — may not auto-discover.** |

### 4. `vendor/wshobson-agents/` — RE plugin (pinned `c4b82b0`)

| Skill | Path | Formats | What it does |
| --- | --- | --- | --- |
| anti-reversing-techniques | `plugins/reverse-engineering/skills/anti-reversing-techniques/SKILL.md` | PE32, .dll, ELF/.so, Mach-O, firmware, memory dump | Anti-debug/packer identification + bypass (UPX/Themida/VMProtect), OEP finding. |
| binary-analysis-patterns | `plugins/reverse-engineering/skills/binary-analysis-patterns/SKILL.md` | PE32, ELF, Mach-O, firmware | Static binary analysis: disassembly, control-flow, compiler idioms, data structures. |
| memory-forensics | `plugins/reverse-engineering/skills/memory-forensics/SKILL.md` | memory dump (.raw/.lime/.vmem), .exe, .dll, .NET-in-dump | RAM acquisition + Volatility 3/Rekall triage. |
| protocol-reverse-engineering | `plugins/reverse-engineering/skills/protocol-reverse-engineering/SKILL.md` | protocol/pcap, binary/custom, TLS | Network protocol RE: dissection, TLV/length-prefixed parsing, TLS analysis. |

### 5. `vendor/claude-red/` (pinned `aeb41ec`) — RE-relevant offensive skills

| Skill | Path | Formats | What it does |
| --- | --- | --- | --- |
| offensive-basic-exploitation | `Skills/exploit-dev/offensive-basic-exploitation/SKILL.md` | ELF, PE32, memory dump | Stack/heap overflow, ROP, ret2libc, shellcode, ASLR/NX/canary bypass (week-5 curriculum). |
| offensive-crash-analysis | `Skills/exploit-dev/offensive-crash-analysis/SKILL.md` | memory dump/minidump, ELF, PE32 | Crash triage/exploitability (WinDbg/GDB, ASAN/MSAN, register/stack-trace). |
| offensive-exploit-dev-course | `Skills/exploit-dev/offensive-exploit-dev-course/SKILL.md` | source, ELF, PE32, shellcode | Exploit-development roadmap/syllabus. |
| offensive-exploit-development | `Skills/exploit-dev/offensive-exploit-development/SKILL.md` | PE32, ELF, shellcode, DLL | Operational exploit development (heap/UAF, ROP/JOP, PE-to-shellcode, mitigations). |
| offensive-mitigations | `Skills/exploit-dev/offensive-mitigations/SKILL.md` | ELF, PE32, shellcode | Mitigation reference + bypass catalog (ASLR/DEP/RELRO/canaries/CFI/seccomp). |
| offensive-toctou | `Skills/exploit-dev/offensive-toctou/SKILL.md` | ELF, PE32, source | TOCTOU race exploitation (symlink/descriptor races, kernel double-fetch, container escapes). |
| offensive-bug-identification | `Skills/fuzzing/offensive-bug-identification/SKILL.md` | source, ELF/PE, patch/diff, memory dump | Systematic vuln identification (source review + binary RE + patch diff + taint). |
| offensive-fuzzing | `Skills/fuzzing/offensive-fuzzing/SKILL.md` | file parsers, firmware, protocol, ELF/PE, kernel/drivers | Fuzzing methodology (AFL++, libFuzzer, Honggfuzz, Boofuzz, syzkaller), crash triage. |
| offensive-fuzzing-course | `Skills/fuzzing/offensive-fuzzing-course/SKILL.md` | source, ELF/.exe | Coverage-guided fuzzing curriculum (week-2). |
| offensive-vuln-classes | `Skills/fuzzing/offensive-vuln-classes/SKILL.md` | source, ELF/PE, memory dump | Memory-corruption vuln classes with CVE case studies (week-1). |
| offensive-mobile | `Skills/mobile/offensive-mobile/SKILL.md` | .apk/DEX, iOS Mach-O, .so, smali | Android+iOS app pentest RE (static + Frida/Objection, pinning/root bypass). |
| offensive-iot | `Skills/iot/offensive-iot/SKILL.md` | firmware, .bin, SquashFS/JFFS2/UBIFS, UART/JTAG/SWD | IoT/embedded: hardware recon, firmware acquisition + analysis, bootloader/secure-boot. |
| offensive-shellcode | `Skills/infrastructure/offensive-shellcode/SKILL.md` | shellcode, PE32, DLL, ELF | Shellcode dev: PIC, PEB/EAT resolution, encoders, PE-to-shellcode (Donut/sRDI). |
| offensive-windows-mitigations | `Skills/infrastructure/offensive-windows-mitigations/SKILL.md` | PE32, memory dump/minidump, ELF | Windows exploit mitigations deep-dive (ASLR/DEP/CFG/CET/SEHOP/ACG). |
| offensive-edr-evasion | `Skills/infrastructure/offensive-edr-evasion/SKILL.md` | PE32, shellcode, DLL | EDR/AV evasion (hook unhooking, direct syscalls, AMSI/ETW, PE/API analysis). |

### 6. `vendor/android-reverse-engineering-skill/` (pinned `e8dde9d`)

| Skill | Path | Formats | What it does |
| --- | --- | --- | --- |
| android-reverse-engineering | `plugins/android-reverse-engineering/skills/android-reverse-engineering/SKILL.md` | .apk/DEX, .xapk, .jar, .aar, .so | jadx/Fernflower decompile, framework fingerprinting (Flutter/RN/Cordova/Xamarin), endpoint extraction, Kotlin metadata recovery. |

### 7. Routing / integration layer (how RE work is entered)

| Item | Path | Role |
| --- | --- | --- |
| tctt-2026-orchestrator | `tctt-2026-orchestrator/SKILL.md` | Triage + gate (Kali preflight, artifact triage) → route to ctf-sandbox-orchestrator + ≤1 vendored RE supplement. **Read this first.** |
| SKILLS.md catalogue | `SKILLS.md` | Source-locked top-level catalogue (entry points + Kali bootstrap). Never invent a tool path. |
| ctf-routing evidence matrix | `tctt-2026-orchestrator/references/ctf-routing.md` | Evidence→route: ELF/PE→reverse-pwn; APK/DEX→android-hooking/crypto-mobile; PCAP→pcap-protocol; memory→forensic-timeline. |
| triage-artifact.sh | `tctt-2026-orchestrator/scripts/triage-artifact.sh` | Read-only signature sniffer (file + sha256) → route hint. |
| kali-preflight.sh | `tctt-2026-orchestrator/scripts/kali-preflight.sh` | Toolchain gate. RE groups: r2/rabin2/ghidra/jadx/apktool/frida/adb; binwalk/volatility3/tshark; etc. |
| .tctt-tool-index.md | `.tctt-tool-index.md` | Generated inventory of the current host's RE tools (see gaps below). |
| reverse-skill master router | `reverse-skill/skills/SKILL.md` | Specialist-catalogue master control (MASTER-ROUTING.md / master-route.ps1). |
| ctf-sandbox-orchestrator | `reverse-skill/CTF-Sandbox-Orchestrator/ctf-sandbox-orchestrator/SKILL.md` | Primary competition workflow; internally routes to competition-* children. |

**Supplemental-source mapping (exact, from orchestrator):** Android APK/XAPK/JAR/AAR → `android-reverse-engineering`; DEX/Frida/IDAPython/struct/symbol/IL2CPP/Unicorn → `p4nda0s-reverse-skills/**`; binary analysis / anti-reversing / memory forensics / protocol RE → `wshobson-agents/plugins/reverse-engineering/skills/**`; pwn → `claude-red/Skills/**`. Primary route is always `ctf-sandbox-orchestrator` + **at most one** supplement.

## Known gaps / caveats

- **Host toolchain incomplete** (`.tctt-tool-index.md`): present r2/rabin2/rasm2/radiff2/rahash2/rax2, java, python/pip, node/npx, binwalk, objdump, strings, file. **Missing:** jadx, apktool, adb, apksigner, zipalign, frida/frida-ps, gdb/gef, analyzeHeadless (Ghidra), jeb-pro, bkcrack. Install only via `reverse-skill/kali/scripts/bootstrap-reverse.sh` (approval-gated).
- `vendor/p4nda0s-reverse-skills` is **unlicensed** — private local use only, do not redistribute.
- `rev-ios-dump` uses lowercase `skill.md` — case-sensitive discovery may not auto-route it.
- `rev-struct` / `rev-symbol` are inert without a live IDA MCP connection or IDA-NO-MCP exported data.
- `reverse-skill` scripts are Windows PowerShell-oriented; Linux/Kali-native invocation is not documented in the SKILL.md files.
- No dedicated Unity-IL2CPP standalone skill in `reverse-skill` (handled by `rev-u3d-dump` + `dotnet-reverse` routing).
- No encrypted-container formats beyond ZipCrypto (no LUKS/VeraCrypt) in `reverse-skill` competition routes.
- claude-red `offensive-exploit-dev-course`, `offensive-vuln-classes`, `offensive-fuzzing-course` are syllabus/curriculum docs (format tags inferred, not stated).
- The orchestrator's supplemental line also lists wshobson `security-scanning` skills (SAST/threat-modeling) alongside binary RE — those are **not** binary RE skills.
- Workspace's own `skills/` (guarding-thai-ctf-wordplay, normalizing-ctf-prompts-to-english, tctt-2025-knowledge-base) and `tctt-2026-orchestrator` do **routing/intake only**, no RE work.
