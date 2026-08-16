#!/usr/bin/env python3
"""SessionStart hook: inject the TCTT intake/routing skills into context.

Reads the three source SKILL.md files every session start and emits JSON with
hookSpecificOutput.additionalContext so Claude Code loads them automatically.
Paths are derived from this script's location so the repo can be moved.
"""
import json
import sys
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]  # <repo>/.claude/hooks/<file> -> <repo>

SKILLS = [
    ("guarding-thai-ctf-wordplay", ROOT / "skills/guarding-thai-ctf-wordplay/SKILL.md"),
    ("normalizing-ctf-prompts-to-english", ROOT / "skills/normalizing-ctf-prompts-to-english/SKILL.md"),
    ("tctt-2026-orchestrator", ROOT / "tctt-2026-orchestrator/SKILL.md"),
    ("tctt-2025-knowledge-base", ROOT / "skills/tctt-2025-knowledge-base/SKILL.md"),
]

parts = ["# TCTT intake skills (auto-loaded at session start)\n"]
for name, path in SKILLS:
    try:
        body = path.read_text(encoding="utf-8")
    except OSError as exc:
        parts.append(f"== skill: {name} ==\n\n(unavailable: {exc})")
        continue
    parts.append(f"== skill: {name} ==\n\n{body}")

context = "\n\n".join(parts)

sys.stdout.write(
    json.dumps({
        "hookSpecificOutput": {
            "hookEventName": "SessionStart",
            "additionalContext": context,
        }
    })
)
