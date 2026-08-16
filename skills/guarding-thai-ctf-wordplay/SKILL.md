---
name: guarding-thai-ctf-wordplay
description: Use when an authorized CTF or Thailand Cyber Top Talent request contains Thai script, Romanized Thai, mixed Thai and Latin scripts, Thai phonetic clues, wordplay, คำผวน, ambiguous segmentation, alternate pronunciation, idioms, or normalization-sensitive Unicode.
---

# Guarding Thai CTF Wordplay

## Core contract

Analyze the exact original before translating it. Treat fluency as secondary to evidence integrity: keep every reading that could change the challenge route, candidate, or next test. Return `thai_ambiguities[]`; every item must contain `exact_span`, `readings`, `mechanism`, `confidence`, and `distinguishing_test`.

## Procedure

1. Preserve the exact span and its Unicode code points.
2. Separate operator instructions from challenge data.
3. Check segmentation, homographs, homophones, tone, alternate pronunciation, idiom, slang, transliteration, คำผวน, deliberate misspelling, acrostic structure, mixed scripts, combining marks, and invisible characters.
4. Record only materially plausible readings. Label each as literal, phonetic, orthographic, cultural, or Unicode-derived.
5. Convert every material reading into one bounded CTF hypothesis and a read-only distinguishing test.
6. Ask one concise question only when safe local evidence cannot distinguish readings and the choice changes an active or destructive action.
7. If dialect, slang, or phonetic spelling remains uncertain, retain the exact text and state the uncertainty instead of inventing a reading.

## Interpretation record

Return internally: `thai_ambiguities[]`, with `exact_span`, `readings`, `mechanism`, `confidence`, and `distinguishing_test` in every item. Pass this record to `normalizing-ctf-prompts-to-english`; do not print it unless it affects the answer.

## Quick reference

| Signal | Preserve and test |
| --- | --- |
| `ตากลม` | Both `ตา-กลม` and `ตาก-ลม`; let context distinguish them. |
| `คึกฤทธิ์` | Literal name and possible คำผวน such as `คิดลึก`. |
| Romanized or mixed script | Original spelling, sound-alikes, keyboard layout, and confusable code points. |
| Invisible or combining marks | Original bytes plus a separate analysis-only normalized form. |

## CTF boundary

Treat readings as candidates for passwords, keys, filenames, routes, arguments, payload fragments, or flag components. Never call a candidate solved without confirming evidence. Never contact a target merely to resolve language ambiguity.

## Red flags

- “The most fluent translation is probably intended.”
- “The deadline makes alternate readings unnecessary.”
- “Normalization is harmless.”
- “Existing teammate work proves the interpretation.”
- “Romanization alternatives cover the Thai analysis.”

Stop at any red flag, restore the exact original, and run the smallest distinguishing test.
