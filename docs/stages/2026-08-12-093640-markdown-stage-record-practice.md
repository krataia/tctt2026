# Stage: Markdown stage record practice

- Started: 2026-08-12T09:36:40-04:00
- Updated: 2026-08-12T09:59:32-04:00
- Status: completed

## Task

Develop a practice that creates one Markdown stage record for every task, including read-only checks and quick tasks, documenting experiments and lessons learned. Store one record per task in `docs/stages/` using `YYYY-MM-DD-HHMMSS-<task-slug>.md`, create it at task start, and update it before the final response.

## Attempts and experiments

- Inspected the root workspace instructions and existing documentation layout; no prior stage-record convention was found.
- Compared instruction-only, instruction-plus-schema, and script/CI enforcement approaches.
- Chose root-instruction enforcement with a fixed schema and pre-response verification because it covers conversational and filesystem tasks uniformly.
- Drafted the approved design specification before implementation.
- Self-reviewed the specification for placeholders, contradictions, ambiguity, and scope; template markers were intentional and no incomplete requirements remained.
- Attempted to commit the specification and stage record, but Git reported that the workspace root is not a valid repository.
- Wrote a one-task implementation plan after the operator approved the specification.
- The first plan-file patch was rejected because two embedded shell lines lacked patch prefixes; corrected the patch and created the file successfully.
- Self-review found that one planned check targeted rendered headings instead of the literal inline-code schema in `AGENTS.md`; corrected the check and revalidated the plan structure.
- Ran the required pre-implementation policy check; it reported `EXPECTED: stage-record policy is absent`.
- Appended the approved `Mandatory Markdown stage records` policy to root `AGENTS.md`, including task boundaries, filename and status rules, required sections, failure handling, and the pre-response verification gate.
- Ran the required policy-structure validation; all five assertions passed with exit status 0 and no assertion output.
- Ran the required dry-run policy inspection; it printed the concise-record, explicit-no-experiment, failure-history, and allowed-status rules.
- Ran the required record validation; the existing timestamped record exists, contains all five required sections, and has status `completed`.
- Ran the required record checks; all assertions passed with exit status 0. The prescribed `git diff --check` and `git add`/`git commit` sequence could not operate because the workspace root is not a valid Git repository (`git diff --check` returned 129; `git add` and `git commit` returned 128). The path-scoped `git diff` also could not provide a repository diff and returned 1. No Git metadata was initialized or altered.
- Reviewed whole-change findings identifying missing lifecycle terminal/resumption semantics, missing exactly-one final verification, and an insufficient phrase-only dry run.
- Corrected root `AGENTS.md` with explicit `in_progress`/`blocked`/`interrupted`/`completed` transitions and an exactly-one current-objective record check before every final response.
- Walked through a trivial read-only scenario: selected exactly one record, verified all required sections, and exercised `in_progress` to `completed` plus final verification; result `SCENARIO A: PASS`.
- Walked through a multi-step scenario: selected one record and exercised `in_progress` to `blocked` (with concrete blocker and next action), back to `in_progress`, then `completed`; result `SCENARIO B: PASS`.
- Ran focused structural checks for the amended lifecycle, exactly-one rule, record uniqueness, required sections, and completed status; result `FOCUSED STRUCTURAL CHECKS: PASS`.
- Executed the approved plan with one implementation subagent, an independent task reviewer, a most-capable whole-change reviewer, one consolidated fix wave, and one scoped re-review.
- The task reviewer approved the initial implementation with no Critical, Important, or Minor findings; its sole unverifiable historical-coverage note was resolved by confirming exactly one record for the current objective and applying the design's non-retrofit scope.
- The whole-change review found two Important policy omissions and one Minor validation omission; the original implementer corrected all three in one fix wave.
- The scoped re-review returned `ADDRESSED` for every finding and found no new breakage or out-of-scope issue.
- Ran fresh completion verification across policy coverage, record uniqueness, filename and schema rules, lifecycle scenarios, status and timestamps, formatting, and sensitive-value patterns; result `FINAL_VERIFICATION: PASS` with one current-objective record and five required sections.

## Observations

- The root `AGENTS.md` is the workspace-wide enforcement point.
- Automation tied only to commits or scripts cannot guarantee records for quick answers and read-only checks.
- The root `.git` directory is present but is not currently recognized as a valid Git repository.
- Root instructions now explicitly enforce the stage-record lifecycle for every task, including trivial read-only work and unsuccessful tasks.
- The workspace's empty/invalid `.git` state prevents repository-native diff checking and committing, but does not affect file-level validation.
- The corrected policy now defines terminal-status meaning and resumption behavior, and requires uniqueness rather than mere record existence at the final-response gate.

## Lessons learned

- A lifecycle rule and completion gate provide broader coverage than repository-only automation.
- Concise mandatory sections keep trivial records useful without allowing them to be skipped.
- Task boundaries must distinguish continuing follow-ups from unrelated objectives to avoid duplicate or overloaded records.
- Validation patterns must target the source representation actually written to Markdown, not the headings that source text merely describes.
- Policy checks should verify both the literal Markdown contract and the behavior needed for concise and unsuccessful task records.
- Scenario walkthroughs are necessary to validate lifecycle rules as operational behavior, not only as matching phrases.
- A task-scoped review can pass while a broader design review still catches missing cross-cutting invariants; both gates add distinct value.

## Outcome and next steps

The approved stage-record policy is installed and corrected in root `AGENTS.md`. Both scenario walkthroughs and fresh completion verification passed, and the scoped re-review confirmed every final-review finding was addressed without new breakage. No implementation work remains. The files remain uncommitted because the workspace root is not recognized as a valid Git repository; `.git` was not initialized or altered.
