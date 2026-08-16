# Stage: pizza-drone-router-flag

- Started: 2026-08-13 06:40:46
- Updated: 2026-08-13 06:40:46
- Status: in_progress

## Task

Operator request (verbatim intent): "Plan the fastest pizza drone routes and snag a slice of the flag." Reverse-engineer the supplied `router` binary (ELF64 PIE, unstripped, x86-64) that plans drone delivery paths on city maps. No source provided. Maps: `city1.map`, `city2.map`, `city3.map`. Binary supports commands `load`, `add_order`, `reroute`, `dispatch` (full command set per strings: `maps`, `coupon`, `replay`, `receipt`, `help`, `quit`). Remote service: `nc mysterious-sea.picoctf.net 61817`. Goal: retrieve the flag.

## Attempts and experiments

### Intake
- Ran `triage-artifact.sh router` → `ROUTE_HINT=competition-reverse-pwn`, `SUPPLEMENT_HINT=wshobson-binary-analysis-or-claude-red-exploit-dev`.
- Ran `kali-preflight.sh` → toolchain ready (r2, rabin2, nc, objdump, readelf); missing gdb, ghidra, jq.
- SHA-256 of router: `d889f22b5ce9497e3cfebbd80746aa2c855227a9f690320b025e22176d71d471`.

### Observations
- `strings`: `maps/%s.map`, `flag.txt`, `(no flag.txt)`, `*** 30 minutes or FLAG free! ***`.
- Command help: `load <map>`, `maps`, `add_order <x> <y>`, `coupon <id> <amt>`, `reroute <id> <heap_idx> <new_cost>`, `dispatch <id>`, `replay <id>`, `receipt <id>`, `help`, `quit`.
- Notable format strings: `coupon applied: %d (can underflow total)`, `receipt: hops=%d coupon=%d total=%d hint=%p`, `replay: %d points; renderer=%p`.
- Symbol table (readelf -s): `fx_draw_basic` @0x2260 (16B), `fx_finish_dummy` @0x2270 (16B), `load_map` @0x2280 (471B), `win` @0x2460 (204B), `main` @0x1340 (3632B). Globals: `G` (1040B, .bss), `ORD` (.bss, size 0x20700), `ORD_N` (4B, .bss).
- Imports: fgets, __printf_chk, strcmp, fopen, strtok, strtol, malloc, free, calloc, read, alarm, setrlimit, prctl, open, close, perror, memset, strlen, setvbuf, __stack_chk_fail, exit, puts.

### Lessons learned
- (pending)

## Outcome and next steps
- Binary is a heap/control-flow pwn challenge (win function present, renderer/hint pointer leaks). Next: full disassembly of `main`/`win`/`load_map` and command handlers, set up local env (maps/ + flag.txt), identify vulnerable primitives, build exploit, verify on remote.
