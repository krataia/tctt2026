# Stage: Songkran gallery target file

Started: 2026-08-15T05:42:25Z  
Updated: 2026-08-15T06:02:08Z  
Status: blocked

## Task

Solve the authorized Songkran gallery web CTF at `https://thctt-web02.p7z.pw`: investigate its external-image preview feature, reach the non-public secret page, and continue to the target file. Preserve the original Thai operator request as authoritative conversation evidence.

## Attempts and experiments

- Resumed the same objective to answer the operator's direct question about the flag and re-applied the required CTF intake. No new target experiment was needed for this clarification.
- Completed the required Thai-evidence guard and semantic English intake without changing the supplied URL or clue.
- Routed the sandbox endpoint through `ctf-sandbox-orchestrator` to `competition-ssrf-metadata-pivot`, with the pinned Claude-Red offensive SSRF checklist as the sole supplement.
- Mapped `GET /`, `/gallery`, and `/photo-story`. The home page exposes `POST /api/import` with form field `url`; gallery downloads use `GET /download?file=...`.
- Submitted a harmless same-host asset URL to `/api/import` without a Turnstile response, with the standard dummy response, and with `X-Forwarded-For: 127.0.0.1`; all three requests stopped at the same `403` verification page before a fetch was observable.
- Tested Chromium headless and headful under Xvfb. Input delivery was independently confirmed through the URL field. The first headful environment had WebGL blocklisted; a second environment enabled software WebGL successfully, but the Turnstile iframe entered `failure_retry` and never issued a response token. Browser attempts were stopped after the failure was reproducible.
- Checked `robots.txt`, `sitemap.xml`, the linked pages, all 27 documented `/photo-story` option combinations, and a bounded set of clue-derived hidden-route names. No hidden route, hint, or manifest was exposed; candidate routes returned the normal 404 page.
- Tested `/download` with a one-level traversal, double encoding, and an absolute path to a small standard system file. The server rejected traversal, preserved the double-encoded name as a literal missing file, and treated the absolute path as missing.
- Inspected the three published JPEGs and the logo SVG. The JPEGs contained no useful metadata. The SVG contained only the displayed `สาดสี` / `Sat See` branding and no internal endpoint.
- Stopped task-created browser processes after testing.

## Observations

- In response to the operator's direct question, no flag value exists in the collected evidence and none can be truthfully reported.
- The clue explicitly connects an external-web image preview, a page unavailable from the Internet, and a target file.
- The dominant evidence type is a sandbox endpoint.
- No material Thai wordplay or normalization ambiguity was identified.
- The confirmed SSRF source candidate is `POST /api/import` with `url`, but Turnstile verification occurs before the fetch.
- Public route enumeration did not find an access-controlled page, supporting the model that the secret page is a separate service or port reachable only from the fetcher.
- The download route accepts legitimate paths such as `songkran-001/khao_san_splash.jpg`, but the tested traversal and absolute-path forms did not escape its storage namespace.
- No flag or target-file content was observed.

## Lessons learned

- For CAPTCHA-gated CTF endpoints, distinguish input-delivery failure, browser-capability failure, and external attestation failure separately. Here X11 input worked, WebGL was restored, and the decisive remaining evidence was Turnstile's `failure_retry` state.
- When a hidden route wordlist yields only the identical application 404, the stronger model is a separate internal service rather than an unlinked route on the public application.

## Outcome and next steps

- Work is blocked at the external Turnstile attestation boundary in the available automated browser environment.
- The flag is not yet recovered; do not infer or fabricate it.
- Next action: use a regular human browser on the supplied challenge page, solve the widget, submit `http://127.0.0.1/` as the Photo URL, and provide the resulting page text/HTML or screenshot. Resume this same record and continue from the returned internal-service evidence toward the target file.
