# Markdown Stage Record Practice Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Enforce one timestamped Markdown stage record for every task performed in the TCTT workspace, including quick answers and read-only checks.

**Architecture:** Add the complete lifecycle and schema to the root `AGENTS.md`, which is the only enforcement point shared by conversational and filesystem tasks. Reuse the existing record for this continuing objective, then validate policy coverage and record structure before responding.

**Tech Stack:** Markdown workspace instructions and POSIX shell validation with `rg`, `test`, `basename`, and `date`.

## Global Constraints

- Create exactly one stage record for each task.
- Store records in `docs/stages/`.
- Name records `YYYY-MM-DD-HHMMSS-<task-slug>.md` using local workspace time.
- Create the record at task start, after mandatory instruction and skill intake but before substantive work.
- Update the record before every final response.
- Keep trivial-task records concise, but never omit them.
- Capture failed, abandoned, and inconclusive experiments as well as successful work.
- Do not copy credentials, secrets, or unnecessary sensitive evidence into a record.
- Do not initialize, repair, or otherwise alter `.git` merely to make a commit possible.

---

### Task 1: Enforce and verify the stage-record lifecycle

**Files:**

- Modify: `AGENTS.md`
- Modify: `docs/stages/2026-08-12-093640-markdown-stage-record-practice.md`
- Reference: `docs/superpowers/specs/2026-08-12-markdown-stage-record-practice-design.md`

**Interfaces:**

- Consumes: The existing four-step TCTT intake sequence in root `AGENTS.md` and the approved design specification.
- Produces: A workspace-wide instruction contract that every future task can follow without a helper script, plus a finalized record for this implementation task.

- [ ] **Step 1: Run the pre-implementation policy check**

Run:

```bash
if rg -q '^## Mandatory Markdown stage records$' AGENTS.md; then
  echo 'UNEXPECTED: policy already present'
  exit 1
else
  echo 'EXPECTED: stage-record policy is absent'
fi
```

Expected: `EXPECTED: stage-record policy is absent`. This demonstrates that the requested enforcement is not yet installed.

- [ ] **Step 2: Add the exact policy to root workspace instructions**

Append this content to `AGENTS.md` after the existing safety paragraph:

```markdown
## Mandatory Markdown stage records

Create one Markdown stage record for every task performed in this workspace. This includes implementation, analysis, read-only checks, quick answers, and tasks that fail or stop early. Trivial tasks may have concise records, but no task may skip its record.

Treat one coherent operator objective as one task. Continue updating the same record for clarifications and follow-ups toward that objective. Start a new record for an unrelated objective; when one request contains independently executed objectives, give each objective its own record.

After the mandatory intake sequence and before substantive work:

1. Create or resume the task's record in `docs/stages/`.
2. For a new task, use local workspace time and the filename `YYYY-MM-DD-HHMMSS-<task-slug>.md`. If a collision occurs, append a two-digit sequence such as `-02` after the slug.
3. Set the initial status to `in_progress`. If a prior record was missed because of interruption or predates this policy, create a clearly identified backfill at the next safe opportunity.

Every record must contain:

- A `# Stage:` title.
- `Started`, `Updated`, and `Status` fields. Allowed statuses are `in_progress`, `completed`, `blocked`, and `interrupted`.
- `## Task`, containing the operator request or a faithful redacted summary when it contains sensitive material.
- `## Attempts and experiments`, covering useful actions, hypotheses, checks, and results. State explicitly when no experiment was needed.
- `## Observations`, containing evidence-backed findings.
- `## Lessons learned`, containing reusable lessons or a concise statement that no additional reusable lesson emerged.
- `## Outcome and next steps`, containing the current result and remaining work.

Record failed, abandoned, and inconclusive experiments when they could help future work. Do not copy credentials, secrets, raw evidence, full command output, or unnecessary sensitive material into a stage record; use descriptive redaction and point to an authorized evidence location when needed.

Before every final response:

1. Confirm that the current task's record exists and follows the timestamped filename convention.
2. Update its timestamp, truthful status, attempts, observations, lessons, outcome, and next steps.
3. Confirm that all required sections are present and agree with the work performed.
4. Check that the record exposes no credentials or unnecessary sensitive evidence.
```

- [ ] **Step 3: Validate the installed policy structure**

Run:

```bash
test "$(rg -c '^## Mandatory Markdown stage records$' AGENTS.md)" = 1
test "$(rg -c '^- `## (Task|Attempts and experiments|Observations|Lessons learned|Outcome and next steps)`' AGENTS.md)" = 5
rg -q 'read-only checks, quick answers' AGENTS.md
rg -q 'no task may skip its record' AGENTS.md
rg -q 'Before every final response:' AGENTS.md
```

Expected: exit status `0` with no output.

- [ ] **Step 4: Dry-run the two required task classes by policy inspection**

Run:

```bash
rg -n 'Trivial tasks may have concise records|State explicitly when no experiment was needed' AGENTS.md
rg -n 'Record failed, abandoned, and inconclusive experiments|Allowed statuses are' AGENTS.md
```

Expected: the first command prints the concise-record rules for a trivial read-only question, and the second prints the history/status rules for a multi-step or unsuccessful task.

- [ ] **Step 5: Finalize and validate this task's existing stage record**

Update `docs/stages/2026-08-12-093640-markdown-stage-record-practice.md` by:

- Refreshing `Updated` with the current local ISO 8601 timestamp.
- Setting `Status` to `completed` after every validation passes.
- Adding the policy edit and each validation result to `Attempts and experiments`.
- Recording that root instructions now enforce the lifecycle under `Observations`.
- Adding any reusable lesson from the dry run under `Lessons learned`.
- Replacing the pending-review outcome with the completed result and no remaining implementation step.

Run:

```bash
record='docs/stages/2026-08-12-093640-markdown-stage-record-practice.md'
test -f "$record"
basename "$record" | rg -q '^[0-9]{4}-[0-9]{2}-[0-9]{2}-[0-9]{6}-[a-z0-9]+(-[a-z0-9]+)*\.md$'
test "$(rg -c '^## (Task|Attempts and experiments|Observations|Lessons learned|Outcome and next steps)$' "$record")" = 5
rg -q '^- Status: completed$' "$record"
```

Expected: exit status `0` with no output.

- [ ] **Step 6: Review the complete diff and attempt a commit safely**

Run:

```bash
git diff --check
git diff -- AGENTS.md docs/stages/2026-08-12-093640-markdown-stage-record-practice.md
git add AGENTS.md docs/stages/2026-08-12-093640-markdown-stage-record-practice.md docs/superpowers/specs/2026-08-12-markdown-stage-record-practice-design.md docs/superpowers/plans/2026-08-12-markdown-stage-record-practice.md
git commit -m "docs: require stage records for every task"
```

Expected when Git metadata is valid: `git diff --check` produces no output and the commit succeeds. The workspace currently reports `fatal: not a git repository`; if that persists, record the failed commit attempt in the stage record, leave all files uncommitted, and do not initialize or repair `.git` without operator authorization.
