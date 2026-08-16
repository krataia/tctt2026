#!/usr/bin/env python3
"""SessionStart hook: FORCE the TCTT intake/routing skills to be invoked EVERY session.

Emits JSON with hookSpecificOutput.additionalContext containing:
1. A MANDATORY directive ordering the model to invoke each skill via the Skill
   tool at every session start (no skipping, no deferring).
2. The SKILL.md bodies as fallback reference only.
Paths are derived from this script's location so the repo can be moved.
"""
import json
import sys
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]  # <repo>/.claude/hooks/<file> -> <repo>

# Single source of truth: .claude/skills/ is where Claude Code registers the
# skills for the Skill tool — the hook reads from the same place so the injected
# bodies always match what Skill(skill=...) would load.
# tctt-request-router is FIRST: it is the entry point that every request passes through.
SKILLS = [
    ("tctt-request-router", ROOT / ".claude/skills/tctt-request-router/SKILL.md"),
    ("guarding-thai-ctf-wordplay", ROOT / ".claude/skills/guarding-thai-ctf-wordplay/SKILL.md"),
    ("normalizing-ctf-prompts-to-english", ROOT / ".claude/skills/normalizing-ctf-prompts-to-english/SKILL.md"),
    ("tctt-2025-knowledge-base", ROOT / ".claude/skills/tctt-2025-knowledge-base/SKILL.md"),
]

# MANDATORY directive — placed at the very top of the injected context so it is
# the first thing the model sees at every session start.
directive = (
    "# ⚠️ MANDATORY — INVOKE THESE SKILLS AT EVERY SESSION START (DO NOT SKIP)\n\n"
    "At the start of THIS session — before any other action, question, or tool use — you MUST invoke the "
    "Skill tool for ALL of the following skills, in order, using their exact names:\n\n"
    "1. Skill(skill=\"tctt-request-router\") — request router: ALWAYS process every incoming request through it FIRST\n"
    "2. Skill(skill=\"guarding-thai-ctf-wordplay\") — Thai CTF wordplay guard\n"
    "3. Skill(skill=\"normalizing-ctf-prompts-to-english\") — CTF prompt normalizer\n"
    "4. Skill(skill=\"tctt-2025-knowledge-base\") — TCTT knowledge base retrieval\n\n"
    "This is REQUIRED at EVERY session start, without exception — always, again and again. "
    "Never skip, defer, merge, or batch them. Even though the skill bodies are also injected below, "
    "you MUST still invoke the Skill tool for each one. "
    "The bodies below are only a fallback reference in case a Skill tool call fails.\n"
)

parts = [directive, "# TCTT intake skills — fallback reference (bodies auto-loaded)\n"]
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
