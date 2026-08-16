# Timeline (append-only)

## 2026-08-12T03:37:38-04:00 | lead | init
- action: case-init
- command_or_ref: skills/scripts/case-init.sh
- result_summary: case directory created; scope ready_for_act=true
- artifacts: [scope.md, workitems.md]
- evidence_ids: []
- next: open PRIMARY SKILL.md and ACT within scope

## 2026-08-12T03:38:00-04:00 | lead+cce | local triage
- action: resolve and triage the supplied local artifact
- command_or_ref: `bash tctt-2026-orchestrator/scripts/triage-artifact.sh 'หลักฐาน/เพลา.bin'`
- result_summary: blocked; the exact artifact path is absent from the workspace, so no artifact hash, decisive offset, plaintext, or observed flag can be recorded
- artifacts: []
- evidence_ids: [E-001]
- next: obtain the unchanged artifact at the exact path `หลักฐาน/เพลา.bin`, then rerun read-only triage
