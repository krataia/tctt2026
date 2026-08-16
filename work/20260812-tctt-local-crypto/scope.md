# Case Scope

## meta
- case_id: 20260812-tctt-local-crypto
- created: 2026-08-12T03:37:38-04:00
- operator: local
- primary_skill: CTF-Sandbox-Orchestrator/competition-crypto-mobile/SKILL.md
- primary_id: competition-crypto-mobile
- lead_role: lead
- specialist_roles: [cce]
- hint: authorized local TCTT crypto artifact; clue ตากลม คึกฤทธิ์; no network
- preset: none

## auth
- status: granted
- basis: ctf_public
- evidence_of_auth: user-authorized-local-CTF
- MUST NOT proceed if status != granted

## in_scope
- assets:
  - หลักฐาน/เพลา.bin
- surfaces: [local_artifact, crypto]
- activities: [read_only_triage, crypto_analysis, flag_validation]

## out_of_scope
- assets: []
- activities: [dos, phishing_real_users, unrestricted_exfil]

## network_profile
- mode: offline
- notes: |
    offline | lab_only | authorized_target_only | unrestricted_lab
    Change mode only after auth.status = granted.
    Presets: offline-sample | ctf-public | own-system

## deliverables
- report: true
- field_journal: true
- diagrams: true
- timeline: true

## constraints
- timebox: {}
- stealth: low
- data_handling: anonymize

## signoff
- ready_for_act: true
- checklist:
  - [x] auth.status = granted
  - [x] in_scope.assets non-empty OR offline sample path set
  - [x] network_profile.mode chosen
  - [x] out_of_scope reviewed
  - [x] roles assigned (see skills/ops/role-map.md)

## ops_refs
- skills/ops/scope-contract.md
- skills/ops/evidence-finding-path.md
- skills/ops/role-map.md
- skills/ops/timeline-workitem.md
- skills/ops/IDENTITY.md
