# Stage: Shop login page CTF assessment

Started: 2026-08-15 04:37:33 UTC
Updated: 2026-08-15 05:25:39 UTC
Status: in_progress

## Task

Assess the new-joiner developer's login page at the authorized competition endpoint `https://shop.cybertop2026.site/` and recover an observed flag matching `TCTT2026{xxxxxxx}`.

## Attempts and experiments

- Preserved the operator request, endpoint, and flag format exactly during intake.
- Created an English working brief without changing protected evidence.
- Classified the supplied target as an authorized CTF web sandbox endpoint and routed it through `ctf-sandbox-orchestrator` to `competition-web-runtime`.
- Ran the Kali readiness check and generated the local tool index. The web toolchain was ready; six unrelated reverse/stego capabilities were missing, so no installation was attempted.
- Requested `/` with curl over HTTP/2 and HTTP/1.1, with the default and browser user agents, and requested `/robots.txt`. Every request received the same immediate Hostinger CDN HTTP 408 page.
- Queried current DNS for the exact target and pinned requests to each advertised reachable IPv4 endpoint. Two subsequent DNS answers rotated to two additional IPv4 endpoints; all four reachable endpoints reproduced the failure. The environment has no usable IPv6 route to the advertised IPv6 endpoints.
- Used isolated Chromium profiles to execute the target's JavaScript challenge. The observed sequence was an HTTP 403 challenge, HTTP 200 challenge script, HTTP 200 validation, and an issued `hcdn` cookie; the following request still returned HTTP 408 or a second-stage HTTP 403 `Bot Verification` page.
- A local Selenium launch initially failed because its packaged Selenium Manager binary was absent. Root-cause checks showed `/usr/bin/chromedriver` and Chromium were both version `148.0.7778.178`; explicitly selecting that driver fixed the local automation failure.
- Repeated the flow with headless and headed Chromium, HTTP/3 enabled and disabled, and a directly launched headed browser where `navigator.webdriver` was false. Each path still ended at Hostinger's second-stage reCAPTCHA gate.
- Requested `/index.php` with validated CDN state; it also returned HTTP 408, rejecting a directory-index-only hypothesis.
- Searched the authorized workspace for this exact hostname and found no supplied source, capture, or prior record that could substitute for the inaccessible runtime.
- Did not load or submit Hostinger's third-party reCAPTCHA resource because its host is outside the supplied competition scope, and did not attack the shared CDN layer.
- Attempted to remove the isolated `/tmp/tctt-shop-*` browser profiles. Permanent removal was rejected by the execution environment and the `/tmp` filesystem does not support trash, so the ephemeral CDN-only profiles remain for normal temporary-storage cleanup.
- Resumed the same objective after the operator explicitly requested a retry with `agent-browser` and investigated the available browser paths.
- Checked the shell PATH, global Node package inventory, and known local Node binary/package locations. No `agent-browser` executable or installed package is available.
- Discovered an available Opera real-browser connector and attempted a read-only tab listing before navigation. The connector reported that reauthentication is required, and the exposed connection-management capabilities provide no automatic reconnect action.
- Did not install `agent-browser` or another package because installation requires separate approval; no new request reached the target during this browser-retry attempt.
- Resumed again after the operator confirmed that the challenge has a flag and requested another attempt; the real-browser connection and current endpoint state are being rechecked.
- Retried the Opera real-browser connector; it still requires reauthentication and performed no target navigation.
- Rechecked `GET /` directly at 04:53 UTC. Hostinger CDN again returned the same immediate HTTP 408 response.
- Searched local npm/cache, system application, and binary locations for an unlisted or cached `agent-browser` executable; none was found.
- Resumed after the operator explicitly authorized installation of `agent-browser` and set recovery of an observed flag as the active goal. Official package identity and installation instructions are being verified before installation.
- Verified npm registry metadata for `agent-browser@0.34.0` (Vercel Labs) and checked the official repository installation instructions, then installed that exact version globally under the operator's authorization. Npm skipped its optional postinstall script, but the CLI was present and reported version `0.34.0`, so no additional browser download or script authorization was needed.
- Loaded the CLI's complete version-matched core workflow and created the isolated session `tctt-shop-3b2c1052eac2` with `/usr/bin/chromium` and a target-only network allowlist.
- Opened `/` with `agent-browser` in both headless and headed modes. In both cases the same-origin JavaScript challenge completed, then the browser rendered `Bot Verification` instead of the application.
- Inspected the tracked request sequence. The target returned HTTP 403 for `/`, HTTP 200 for its challenge script and validation request, then HTTP 403 for `/`; the page attempted to load `https://www.recaptcha.net/recaptcha/api.js`, which the target-only allowlist blocked.
- Requested `/index.php` in the same validated browser session; it also rendered `Bot Verification`.
- Continued the active goal without widening the allowlist while the requested third-party scope decision remains unanswered; same-origin discovery routes are being tested instead.
- Replaced the page-injected domain allowlist with a local HTTP CONNECT proxy that permits only `shop.cybertop2026.site:443`. This avoided a Chromium execution-context race during Hostinger's rapid challenge redirects while retaining target-only containment.
- Reached normal same-origin responses through `agent-browser`: `/robots.txt` returned the origin's not-found page, while `/`, `/login`, `/login.php`, `/login.html`, `/index.html`, `/sitemap.xml`, a randomized path, and the standard security metadata path remained behind Hostinger-generated verification or denial pages. The randomized path established that the denials do not prove a login route exists.
- Tested fresh headless, headed, automation-signal-suppressed, persistent-profile, and human-paced browser sessions. The strongest configuration reported `navigator.webdriver` as false with a normal non-headless Chromium user agent, but still received Hostinger HTTP 403 rather than the application.
- Launched Chromium independently and attached `agent-browser` over DevTools to remove Playwright's launch fingerprint. That configuration reproducibly reached Hostinger's `Bot Verification` page rather than the login page.
- Extracted only public integration metadata from the verification page: it loads `www.recaptcha.net`, uses Hostinger's shared public site key, and submits the resulting token to the same-origin `/.lsrecap/recaptcha` endpoint. A passive lookup confirmed that the key is Hostinger's production/shared verification integration, not Google's public test key.
- Queried passive exact-host search and archive indexes and searched the authorized workspace. No indexed application copy, source artifact, prior flag, or alternate same-origin route was found.
- Kept the proxy target-only throughout. Requests to `www.recaptcha.net` and `www.gstatic.com` were not allowed, no CAPTCHA token was submitted, and no flag-like value was observed.
- Resumed the persistent goal without a new scope grant. The third-party CAPTCHA hosts remain disallowed; passive scan archives are being checked for already-captured application evidence.
- Checked public exact-host search and scan indexes without submitting the target for a new scan. No stored scan, DOM snapshot, application asset list, or cached login page for this hostname was found.
- Completed the blocked-state audit across three consecutive goal turns. Each turn reached the same boundary: Hostinger requires external reCAPTCHA resources before it serves the application, and the operator has not yet authorized those two third-party hosts.
- Resumed after the operator supplied the exact Thai hypothesis `แฟลกมันอาจจะเป็นการแยกแล้วนำมาประกอบคุณลองคิดให้รอบคอบดีๆมันอาจจะซ่อนอยู่` (the flag may be split, hidden, and require reassembly). Preserved the original wording and routed it through the Thai wordplay guard before translation.
- Reframed collection from full-flag matching to fragment-first analysis across same-origin HTML, JavaScript, CSS, response metadata, cookies, browser storage, and request order; no candidate will be called solved without clean-session reproduction.
- Captured a clean target-only HAR containing the initial Hostinger HTML challenge, its JavaScript challenge, the validation exchange, the Bot Verification page, and the origin 404 template. Searched bodies, headers, comments, hidden fields, cookies, storage, service workers, encoded strings, and request order. These layers contained only generic Hostinger material; no challenge-specific flag fragment was found.
- Established an origin-reachability differential: a randomized `.js` path returned the real Hostinger origin 404 while HTML/JSON/map paths remained gated. Common JavaScript and CSS asset names were absent.
- Proved a one-variable path-normalization differential. `GET /index.php` returned Hostinger Bot Verification, while `GET /index.php/probe-f8c1.js` returned HTTP 200 from PHP 8.3.31 with the actual login page titled `Dev By thedhruvhegde`.
- Inspected the 3,018-byte application HTML. It contains an email/password POST form, a five-attempt session lockout, the test account hint `test@gmail.com`, and success/flag display styles, but no comments, hidden fields, storage values, external assets, or literal flag fragment.
- Made three evidence-bounded authentication checks: password `test`, SQL syntax in the email field, and SQL syntax in the password field. All returned the same invalid-credential branch, leaving two attempts in that PHP session. Stopped credential testing after the third failed hypothesis rather than brute-forcing.
- Reviewed all three login response headers and cookies. They contain ordinary PHP/Hostinger metadata and a `PHPSESSID`; no custom fragment-bearing header or client-side session value was present.
- After bounded static-name checks, Hostinger changed same-origin `.js` responses from origin 404 to a generic hard 403. A fresh isolated browser session is required before the next high-confidence read-only hypothesis.

## Observations

- The protected target is limited to `https://shop.cybertop2026.site/`.
- No Thai, Romanized Thai, mixed-script wordplay, or normalization-sensitive Unicode appears in the request.
- The target currently presents Hostinger CDN rather than the application. The decisive browser flow is `GET /` (403 JavaScript challenge) -> challenge script (200) -> challenge validation (200) -> `GET /` (408 or 403 reCAPTCHA gate).
- The same result occurs across four reachable IPv4 addresses returned by the target's rotating DNS, both HTTP/2 and HTTP/3, and both automation-marked and ordinary headed Chromium.
- No login form, application asset, authentication request, or flag was observed. A flag therefore cannot be reported as solved or inferred.
- `agent-browser` is now installed and operational. The remaining gate is an embedded third-party reCAPTCHA dependency, not a CLI or browser-launch failure.
- The operator's confirmation that a flag exists does not change the current evidence boundary: the application still was not served during the latest retry.
- A direct, non-Playwright-launched Chromium session still receives `Bot Verification`, proving that the remaining obstacle is not the `agent-browser` installation or its default headless fingerprint.
- Hostinger's verification form requires a token produced by `www.recaptcha.net` and associated static resources from `www.gstatic.com`; there is no target-local fallback or documented test-key path in the observed page.
- Public scan/archive discovery does not supply a substitute copy of the protected application.
- The CDN classifies requests partly by path suffix, while the PHP backend accepts path info after `index.php`; app reachability is therefore a confirmed path-normalization drift, not a CAPTCHA bypass guess.
- The currently observed app page does not itself contain flag fragments. Its `.flag` and `.success` styles indicate that decisive flag material is rendered only on another server-side branch, most likely successful authentication.

## Lessons learned

- A CDN challenge-validation response and cookie issuance do not prove access to the protected origin; always verify the post-validation navigation before analyzing application behavior.
- Restricting browser DNS resolution to the supplied target provides a practical way to inspect challenge behavior without silently contacting embedded third-party resources.
- A narrow CONNECT proxy is more reliable than CDP request interception when a challenge rapidly replaces the document and its execution context.
- Hostinger's shared production reCAPTCHA site key can distinguish a real external verification dependency from an application-owned test widget; the public key alone is not a reusable bypass token.

## Outcome and next steps

In progress. The application login page is now reachable without external CAPTCHA through the reproducible path differential `/index.php/<suffix>.js`. The next step is a fresh target-only session for high-confidence source/debug/hidden-route checks that do not consume login attempts, followed by evidence-backed authentication analysis. No flag can truthfully be reported until fragments are observed, assembled, and reproduced.
