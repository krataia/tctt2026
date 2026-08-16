# Stage: CyberTop account impersonation challenge

Started: 2026-08-15 04:25:49 UTC
Updated: 2026-08-15 04:28:42 UTC
Status: completed

## Task

Within the authorized TCTT competition endpoint `https://cybertop2026.site/`, find a way to impersonate account ID `0890345536` and recover an observed flag matching `TCTT2026{xxxxxxx}`.

## Attempts and experiments

- Completed the required English intake while preserving the URL, account ID, and flag format exactly.
- Classified the evidence as a controlled web sandbox endpoint and routed through the competition web-runtime and crypto workflows.
- Ran the Kali readiness check. The web/network tools were ready; six unrelated reverse/stego capabilities were missing, so no installation was attempted.
- Fetched `/` without following redirects. The server returned HTTP 200, a PHP session cookie, login/register forms, and an explicit AES-128-ECB password-generation clue.
- Confirmed that the target JSON plaintext splits into two AES blocks after the first five digits of the mobile number.
- Registered two controlled test numbers: one matching the target's first five digits and one matching its last five digits. Each returned a two-block hex ciphertext.
- Constructed the target password by taking block one from the first registration and block two from the second, then submitted it for the target account.
- Repeated the login from a fresh PHP session and freshly issued CSRF token. The server again returned HTTP 200 with an explicit login-success message and a flag matching the required format.

## Observations

- Authorization is limited to the supplied competition site and stated impersonation objective.
- Passwords are deterministic AES-128-ECB ciphertexts of `{"userid":"<10 digits>"}` and are returned as 64 hex characters (two blocks).
- The first block depends on the JSON prefix plus the first five digits; the second block depends on the last five digits, the JSON suffix, and padding.
- ECB's independent-block property permits a chosen-plaintext cut-and-paste password for `0890345536` without recovering the AES key.
- The forged credential and raw session material are intentionally omitted from this record; the observed flag is provided only in the operator-facing result.

## Lessons learned

- When structured identity data is encrypted directly with ECB and ciphertext is accepted as a credential, chosen registrations can become a block oracle. Map exact block boundaries before attempting broader authentication attacks.

## Outcome and next steps

Completed. The account impersonation path was reproduced from a clean session and an observed flag was recovered. No further action is required.
