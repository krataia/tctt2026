# Stage: ShadowCouncil VHDX ransomware-ledger DFIR

- Started: 2026-08-15 08:58 UTC
- Updated: 2026-08-15 08:58 UTC
- Status: in_progress

## Task

Operator request (preserved verbatim intent): A Windows 10 workstation was seized from "d4ag0n," suspected of running ransomware operations. Law enforcement pulled a triage image. The brief says the suspect coordinated with affiliates and kept a ledger of ransom payments somewhere off the machine. Flag format is TCTT2026{md5} where the MD5 comes from the total BTC paid in a ledger, to one decimal place (e.g. md5(10.5) or md5(5.8)). Supplied artifact: `2026-08-11T001838_ShadowCouncil.vhdx`.

Intake packet (per normalizing-ctf-prompts-to-english):
- response_language: English
- operator_intent_en: Analyze seized Windows 10 triage image; locate the off-machine ransom payment ledger; sum BTC to one decimal place; submit TCTT2026{md5(<total>)}.
- protected_evidence: `2026-08-11T001838_ShadowCouncil.vhdx` (1,379,926,016 bytes, SHA-256 bb2ee7d686d78708f5df3d19fd6b9b403006f9b5bc0548c145e0913b1ffc44bf). Flag format `TCTT2026{md5}` with decimal BTC total as MD5 input.
- thai_ambiguities: none (English-only request)
- normalization_changes: none (no evidence rewritten)
- authorization_scope: supplied CTF artifact, TCTT 2026 authorized challenge workspace; read-only forensics on the image.

## Attempts and experiments

- Triaged artifact with `tctt-2026-orchestrator/scripts/triage-artifact.sh`: KIND=file, ROUTE_HINT=manual-triage; `file` identifies Microsoft Disk Image eXtended (VHDX, .NET DiscUtils).
- No experiment yet beyond identification; conversion/mount/ledger hunt pending.

## Observations

- Artifact is a 1.38 GB VHDX disk image (Microsoft DiscUtils-generated). Forensic toolchain present: 7z, qemu-img, sleuthkit (mmls/fls). libguestfs/guestmount NOT installed.
- Task text has no Thai script; Thai guard skill not applicable.

## Lessons learned

- VHDX from DiscUtils has no log signature; qemu-img convert is the direct path to a raw image for partition analysis.

## Outcome and next steps

- Next steps: convert VHDX to raw with qemu-img; run mmls/fls to map partitions and NTFS volumes; extract Windows user data and hunt for the off-machine ransom ledger (likely browser/cloud/chat artifacts); derive total BTC, MD5, and flag.
