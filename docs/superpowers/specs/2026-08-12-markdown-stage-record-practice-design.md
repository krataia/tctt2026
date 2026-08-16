# Markdown Stage Record Practice Design

## Purpose

Create a durable Markdown record for every task performed in this workspace so later work can reuse prior experiments, observations, and lessons. The practice applies without exception to implementation, analysis, read-only checks, and quick answers.

## Requirements

- Create exactly one stage record for each task.
- Store records in `docs/stages/`.
- Name records `YYYY-MM-DD-HHMMSS-<task-slug>.md` using local workspace time.
- Create the record at task start, after mandatory instruction and skill intake but before substantive work.
- Update the record before every final response.
- Keep trivial-task records concise, but never omit them.
- Capture failed, abandoned, and inconclusive experiments as well as successful work.
- Do not copy credentials, secrets, or unnecessary sensitive evidence into a record.

## Task Boundary

A task is one coherent operator objective. Clarifications and follow-up messages that continue the same objective update the existing record. A new or unrelated objective starts a new record. If a single request explicitly contains independent objectives, each independently executed objective receives its own record.

## Enforcement Architecture

The root `AGENTS.md` will define a mandatory stage-record lifecycle after the existing intake sequence. This is the enforcement point because it governs code changes, read-only investigations, and conversational answers alike.

The policy will require agents to:

1. Resolve the current task boundary.
2. Create or resume its stage record.
3. Record meaningful attempts and observations while working.
4. Finalize the current state, outcome, and lessons before responding.
5. Verify that the record exists and reflects the work actually performed.

No helper script or CI gate is required initially. Those mechanisms cannot observe every conversational task and would add maintenance without improving coverage beyond the workspace instruction.

## Record Schema

Each record will use this compact structure:

```markdown
# Stage: <task title>

- Started: <ISO 8601 timestamp>
- Updated: <ISO 8601 timestamp>
- Status: in_progress | completed | blocked | interrupted

## Task

<Operator request or faithful redacted summary when sensitive material is involved.>

## Attempts and experiments

- <Action, hypothesis, command category, or check and its result.>

## Observations

- <Evidence-backed finding.>

## Lessons learned

- <Reusable lesson, or a concise statement that no additional reusable lesson emerged.>

## Outcome and next steps

<Current outcome and any remaining action.>
```

Records for trivial tasks retain every section but may use one short sentence per section. When no experiment is necessary, the record says so explicitly rather than inventing activity.

## Lifecycle and Data Flow

After the mandatory workspace intake, the agent creates a timestamped record with `in_progress` status and the task statement. During work, it appends only useful experiments and observations. Before a final answer, it refreshes the `Updated` timestamp, sets the truthful status, records lessons, and states the outcome or next step.

If the operator continues the same objective, the same record returns to `in_progress` and is updated. If work is interrupted and later resumed, the record notes the interruption and subsequent continuation rather than creating a duplicate.

## Failure Handling

- A failed command or hypothesis is recorded with its observed result when it may help future work.
- A task that cannot finish is marked `blocked` with the concrete blocker and next action.
- A deliberately stopped or superseded task is marked `interrupted` with the reason.
- If a filename collision occurs, append a two-digit sequence such as `-02` after the task slug.
- If a record was missed because of an interruption or because this policy was not yet installed, create a clearly labeled backfill at the next safe opportunity.
- Sensitive values are replaced with a descriptive redaction; the record may point to an authorized evidence location without reproducing the value.

## Verification

Before every final response, verify:

1. A record exists at the required path for the current task.
2. Its filename follows the timestamped convention.
3. Every required section is present.
4. Status and timestamps match the current state.
5. Attempts, observations, lessons, and outcome agree with the work performed.
6. The record contains no exposed credentials or unnecessary sensitive evidence.

Implementation verification will inspect the updated `AGENTS.md`, the current task's backfilled record, and their Markdown structure. A dry-run review will cover both a trivial read-only question and a multi-step task to confirm that the rules are unambiguous.

## Acceptance Criteria

- Root workspace instructions explicitly mandate a stage record for every task with no trivial-task exception.
- The required path, filename convention, schema, lifecycle, task-boundary rule, failure behavior, and final verification gate are documented.
- The policy-design task has its own record in `docs/stages/`.
- A future agent can follow the instructions without needing an undocumented convention or helper tool.

## Non-goals

- Building a database, index, CI workflow, or record-generation application.
- Retrofitting records for unrelated historical workspace activity.
- Duplicating raw evidence, full command output, or secrets in stage records.
