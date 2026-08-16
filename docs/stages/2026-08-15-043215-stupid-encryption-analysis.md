# Stage: Stupid Encryption analysis

Started: 2026-08-15 04:32:15 UTC
Updated: 2026-08-15 04:40:09 UTC
Status: in_progress

## Task

Analyze the authorized CTF artifact `StupidEncryption.txt`, determine whether the junior developer's encryption algorithm is secure, and recover an observed flag matching `TCTT2026{xxxxxxx}` if possible.

## Attempts and experiments

- Completed the required English intake while preserving the filename and flag format exactly.
- Classified the dominant evidence as a local cryptographic artifact and routed it through the competition sandbox and crypto workflows.
- Ran the Kali readiness check. Required baseline and crypto tools were present; six unrelated capabilities were absent, so no installation was attempted.
- Ran the mandated read-only artifact triage. It identified a 2,154-byte ASCII file with one long CRLF-terminated line and SHA-256 `b5c7093ea94236c00e080f3632a5f5284c025d6ad5b2b9b3792f17f6c496d7c9`.
- Identified and decoded the outer Base64 layer. Strict GNU Base64 reported invalid input after producing output; a focused comparison proved the trailing carriage return was the sole cause, while removing only that byte yielded a clean 1,613-byte decode.
- Measured the decoded layer as 538 fixed-width, two-character symbols. Frequency and word-pattern analysis identified a deterministic substitution, including a highly repeated symbol representing spaces.
- Recovered the substitution table incrementally from repeated English structures, then decoded the full plaintext and the embedded flag.
- Re-ran SHA-256 and full decoding from the original artifact. The hash matched, all 538 symbols decoded without an unmapped marker, and the plaintext explicitly included a flag matching the requested format.
- Reopened the task after the operator reported that the submitted flag was incorrect. The prior decoder had assigned one flag-only symbol from an inferred English spelling rather than an independently derived mapping.

## Observations

- The outer Base64 layer is encoding, not encryption.
- The inner construction is deterministic per-character substitution and preserves spaces, word lengths, repeated characters, and language frequency. These leaks make known-plaintext and frequency recovery straightforward.
- No key brute force was needed. The recovered prose itself states that the construction is insecure and pattern-decodable.
- The recovered flag is intentionally omitted from this stage record and is returned only to the operator.

## Lessons learned

- A custom cipher that deterministically substitutes individual characters provides no semantic security. Base64 wrapping does not mitigate frequency, repetition, or word-boundary leakage.
- When strict Base64 rejects a CRLF artifact, isolate line-ending behavior before assuming ciphertext corruption; preserve the original and normalize only in the analysis pipeline.

## Outcome and next steps

In progress again after operator validation failed. Derive the disputed flag symbol from the cipher rule itself, correct the decoder, and independently verify the resulting exact flag before resubmission.
