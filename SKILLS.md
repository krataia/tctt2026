# TCTT 2026 — CTF Skills Catalogue

This is the source-locked entry point for authorized Thailand Cyber Top Talent 2026 / CTF work. It combines the pre-existing local CTF package with high-signal public GitHub sources. It is not a claim that the internet has been exhaustively searched; it is the vetted, reproducible set available in this workspace as of 2026-08-11.

## Invoke it

The project discovery directory `.agents/` is mounted read-only, so this workspace cannot add a project skill there. Invoke the orchestrator explicitly:

```bash
cd /path/to/tctt
codex -C "$PWD" "Read tctt-2026-orchestrator/SKILL.md and analyze this authorized CTF challenge: <artifact or scope>"
```

Or in an existing session: “Read `tctt-2026-orchestrator/SKILL.md` and triage this authorized CTF challenge.” The orchestrator loads only the source skill relevant to the challenge.

For a supplied local artifact, obtain an evidence-based route before loading a specialist:

```bash
bash tctt-2026-orchestrator/scripts/triage-artifact.sh <artifact>
```

The helper is read-only: it identifies the format, records SHA-256, and emits a primary route plus one optional supplement. The routing rules are in `tctt-2026-orchestrator/references/ctf-routing.md`.

## Bilingual TCTT intake

Apply these skills before challenge routing:

| Order | Skill | Purpose |
| ---: | --- | --- |
| 1 when Thai signals exist | `skills/guarding-thai-ctf-wordplay/SKILL.md` | Preserve Thai wordplay, alternate readings, and Unicode-sensitive clues as testable hypotheses. |
| 2 for every request | `skills/normalizing-ctf-prompts-to-english/SKILL.md` | Create an English working brief without changing evidence or the user's response language. |
| 3 for authorized challenge work | `tctt-2026-orchestrator/SKILL.md` | Route the evidence to the narrowest CTF workflow. |

Direct invocation:

```text
Read skills/guarding-thai-ctf-wordplay/SKILL.md when Thai signals exist, then read skills/normalizing-ctf-prompts-to-english/SKILL.md, then route the authorized challenge through tctt-2026-orchestrator/SKILL.md.
```

## TCTT knowledge base

`docs/knowledge/tctt-2025/` is the recorded knowledge base for the Thailand Cyber Top Talent 2025 competition (dates, format, rounds, rules, eligibility, prizes, categories, past years, official pages — all source-cited and confidence-marked; compiled 2026-08-13 by a 7-agent research workflow). Query it through the retrieval skill:

| Skill | Purpose |
| --- | --- |
| `skills/tctt-2025-knowledge-base/SKILL.md` | Pull source-cited TCTT facts from the knowledge base; answer from the KB, never from model memory. |

For a TCTT fact question, read the KB file for the topic (file map in `docs/knowledge/tctt-2025/README.md`) and answer with the source reference and confidence. Note: TCTT 2026 dates are **conflicting/unverified** in the KB — re-check official pages (`thnca.or.th`, `ctf.in.th`) before relying on them.

## Reverse-engineering skill index

`docs/knowledge/reverse-engineering-skills-index.md` is the consolidated, source-locked catalogue of every RE skill in this workspace (compiled 2026-08-13, 87 verified skill paths). Use it to answer "which skill handles `.exe` / `.apk` / …?" — it maps each binary/file format to its best-fit skills and lists the full catalogue by source area (`reverse-skill`, `vendor/p4nda0s-reverse-skills`, `vendor/wshobson-agents`, `vendor/claude-red`, `vendor/android-reverse-engineering-skill`) plus the routing/integration layer and known toolchain gaps.

## Safety boundary

Use active techniques only against a supplied challenge, a competition sandbox, or a target with explicit authorization. Vendored skills are documentation, not trusted executables: do not run their install, update, `sudo`, package-manager, or external-network commands without separate approval.

## Kali Linux portability

On Kali, run the read-only readiness check first:

```bash
bash tctt-2026-orchestrator/scripts/kali-preflight.sh
```

It returns `0` only when the full CTF toolchain is found, `1` for missing tools, and `2` when the host is not Kali. To generate the real tool-path inventory in a challenge directory:

```bash
bash reverse-skill/kali/scripts/refresh-tool-index.sh "$PWD/.tctt-tool-index.md" "$PWD/.tctt-tool-index.json"
```

Use `bash reverse-skill/kali/scripts/bootstrap-reverse.sh --list` to discover existing installer capability names. The orchestrator must request approval before invoking that installer.

## Existing local CTF package

Start every contest task here:

| Source | Entry point | Coverage |
| --- | --- | --- |
| Existing `reverse-skill` package | `reverse-skill/CTF-Sandbox-Orchestrator/ctf-sandbox-orchestrator/SKILL.md` | 41 competition routes: web, pwn/RE, crypto, stego, DFIR, mobile, cloud, K8s, identity/AD, AI, firmware, protocol and more |
| Existing specialist catalogue | `reverse-skill/skills/SKILL.md` | 44+ supporting workflows: Ghidra/IDA/radare2, malware, hardware, RF, OT, Wi-Fi, API, browser, cloud, forensics, code audit and threat hunting |
| Existing global skills | `/home/krataib/.agents/skills/` | Security review/scan, framework security, network and cloud tooling already installed on this machine |

Use `rg --files reverse-skill -g SKILL.md` to list the exact installed local skills. Do not copy or overwrite these existing sources.

## Imported public sources

All sources below are shallow-cloned under `vendor/`, kept separate, and pinned to the recorded commit. No third-party script has been executed.

| Source | Stars checked | License | Pinned commit | Use it for |
| --- | ---: | --- | --- | --- |
| [SimoneAvogadro/android-reverse-engineering-skill](https://github.com/SimoneAvogadro/android-reverse-engineering-skill) | 6,744 | Apache-2.0 | `e8dde9d058badbd5a62265d5d23e81f0ea8f04dd` | Android APK/XAPK/JAR/AAR triage, decompilation, Kotlin metadata recovery, endpoint and call-flow extraction |
| [SnailSploit/Claude-Red](https://github.com/SnailSploit/Claude-Red) | 2,895 | MIT | `aeb41eca7088a703c3a35fbcba3086d4a6c1aa4e` | Controlled CTF web, pwn, fuzzing, mobile, cloud, AD, IoT, OSINT and wireless categories (58 skills) |
| [Cloudflare/security-audit-skill](https://github.com/cloudflare/security-audit-skill) | 2,837 | MIT | `8bac42001ddd90a4dcd8d5a5045199283a8eba75` | Source-first audit of a local challenge codebase with independent finding validation |
| [wshobson/agents](https://github.com/wshobson/agents) | 38,714 | MIT | `c4b82b0ad771190355eb8e204b1329732a18449a` | Binary analysis, anti-reversing, memory forensics, protocol RE, SAST, attack trees, STRIDE and mitigations (9 relevant skills) |
| [prompt-security/clawsec](https://github.com/prompt-security/clawsec) | 1,082 | AGPL-3.0 | `c3086b22252b7ec319789a69c34cba76afc1dec6` | Inspecting agent-skill integrity and prompt/skill supply-chain risks; not a CTF exploitation route |
| [P4nda0s/reverse-skills](https://github.com/P4nda0s/reverse-skills) | 1,932 | Not stated — retained for private local use only | `a2baa31c58a3567977188414da68c8c842057152` | DEX dumping, Frida, IDAPython, structure/symbol recovery, Unity IL2CPP dump and Unicorn debugging (7 skills) |

### Exact vendor entry points

| Challenge / task | Load this original `SKILL.md` |
| --- | --- |
| Android reverse | `vendor/android-reverse-engineering-skill/plugins/android-reverse-engineering/skills/android-reverse-engineering/SKILL.md` |
| Code audit | `vendor/cloudflare-security-audit-skill/skills/security-audit/SKILL.md` |
| Any CTF offensive category | `vendor/claude-red/Skills/<category>/<skill>/SKILL.md` |
| Binary / protocol / memory RE | `vendor/wshobson-agents/plugins/reverse-engineering/skills/<skill>/SKILL.md` |
| SAST / threat modeling | `vendor/wshobson-agents/plugins/security-scanning/skills/<skill>/SKILL.md` |
| Android/Unity/Frida/IDA/Unicorn RE | `vendor/p4nda0s-reverse-skills/skills/<skill>/SKILL.md` |
| Agent-skill integrity | `vendor/clawsec/skills/<skill>/SKILL.md` |

List the available imported entry points without guessing names:

```bash
rg --files vendor -g SKILL.md
```

### Claude-Red CTF routing

| Domain | Directory |
| --- | --- |
| Web | `vendor/claude-red/Skills/web/` |
| Exploit development / pwn | `vendor/claude-red/Skills/exploit-dev/` |
| Fuzzing | `vendor/claude-red/Skills/fuzzing/` |
| Auth, Active Directory | `vendor/claude-red/Skills/auth/`, `vendor/claude-red/Skills/active-directory/` |
| Cloud, AI, mobile, IoT | `vendor/claude-red/Skills/{cloud,ai,mobile,iot}/` |
| OSINT | `vendor/claude-red/Skills/recon/` |
| Wireless | `vendor/claude-red/Skills/wireless/` |

### wshobson CTF routing

`plugins/reverse-engineering/skills/` contains `anti-reversing-techniques`, `binary-analysis-patterns`, `memory-forensics`, and `protocol-reverse-engineering`. `plugins/security-scanning/skills/` contains `attack-tree-construction`, `sast-configuration`, `security-requirement-extraction`, `stride-analysis-patterns`, and `threat-mitigation-mapping`.

### P4nda0s reverse routing

`vendor/p4nda0s-reverse-skills/skills/` contains `rev-dex-dumper`, `rev-frida`, `rev-idapython`, `rev-struct`, `rev-symbol`, `rev-u3d-dump`, and `rev-unicorn-debug`. The repository does not state a license; retain it only in this private workspace and do not redistribute its contents.

## Source integrity and updates

Before any update, inspect changes first:

```bash
git -C vendor/<source> fetch --depth 1 origin
git -C vendor/<source> log --oneline HEAD..origin/HEAD
git -C vendor/<source> diff --stat HEAD origin/HEAD
```

Only fast-forward after reviewing the diff and license. Re-run `git -C vendor/<source> rev-parse HEAD` and update the pin in this file. Never use a vendor’s auto-update, installer, or feed command implicitly.
