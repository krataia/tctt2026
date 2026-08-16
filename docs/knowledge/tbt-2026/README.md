# TBT 2026 Knowledge Base — Thailand Blue Team Community CTF

Snapshot compiled **2026-08-16** from an operator-provided challenge write-up (Thailand Blue Team Community 2026 CTF, DFIR category). This is a **separate event** from TCTT (Thailand Cyber Top Talent / NCSA) — see the sibling KB in `../tctt-2025/`. All content here is **single-source (operator's own solve record)**; competition-level facts (dates, scale, organizers) are **not yet verified** against any official page.

## Quick facts

| Fact | Value |
| --- | --- |
| Competition | **Thailand Blue Team Community 2026 CTF** (community blue-team event; distinct from TCTT/NCSA) |
| Challenge | **Ransomware Ledger** — Digital Forensics / Incident Response (DFIR) |
| Target of investigation | Suspect `d4ag0n`'s Windows 10 triage image; Signal Desktop chat logs; a public Google Sheets ransomware ledger |
| Solve path | NTFS boot-sector repair → DPAPI masterkey unwrap (password `Zeph!r_T1d3s`) → Signal `Local State` AES-256-GCM key → `config.json` v10 key → SQLCipher passphrase → chat message with `tinyurl.com/dr4g0nia` → Google Sheets ledger → sum of BTC Paid = **21.0** |
| Flag | `TCTT2026{9bfd0a8df0d02679f02a45b507f64385}` (MD5 of `"21.0"`) |
| Confidence | Challenge solve steps: **high** (operator's own record). Competition meta-facts: **unverified** (no official sources recorded yet) |

## File map

| File | Contents |
| --- | --- |
| `README.md` | Quick facts, confidence notes, file map |
| `writeups.md` | Full step-by-step write-up: **Ransomware Ledger** (DFIR) |
| `sources.md` | Source registry |

## Confidence legend

- **high** — confirmed by official/institutional source or multiple independent sources; re-checked in a verification pass.
- **medium** — single credible source, or official source without full detail.
- **low / unverified** — community, self-reported, or single weak source; treat as a lead, not a fact.

## Gaps / open items

- No official TBT 2026 site or announcement recorded; competition dates, divisions, prize structure, and organizer identity unverified.
- Flag format is `TCTT2026{...}` even though the event is branded "Blue Team Community" — the naming/format mapping is unverified.
- Challenge files (the image, `Local State`, `config.json`, ledger CSV) were not preserved in this KB — only the solve record.
