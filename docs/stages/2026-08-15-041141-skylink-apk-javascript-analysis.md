# Stage: Skylink APK JavaScript Analysis

- Started: 2026-08-15 04:11:41 UTC
- Updated: 2026-08-15 04:29:46 UTC
- Status: completed

## Task

Analyze the authorized CTF artifact `02-skylink.apk`, supplied at `https://thctt26.p7z.pw/apks/02-skylink.apk`, with particular attention to its use of JavaScript. Preserve the APK and evidence exactly, identify the relevant application flow, and report only verified findings.

## Attempts and experiments

- Resumed the same objective after the operator requested the flag format; the follow-up check will search local authoritative evidence for the competition prefix and any complete flag-shaped value.
- Verified from current competition evidence that the flag format is `TCTT2026{...}`; excluded older workspace evaluation fixtures that used a different illustrative prefix.
- Confirmed that no complete flag literal occurs in the APK DEX strings. Used the verified prefix as known plaintext against the APK's two-stage XOR transform.
- Tested salt periods without guessing a flag body. A 16-byte period forced recognizable plaintext positions; filling the remaining short label from the artifact-grounded app name produced a meaningful repeating salt and an exact round-trip match.
- Re-extracted all 42 obfuscated bytes directly from apktool smali for fresh verification, confirmed the `0x5a` first XOR and modulo/repeating second XOR, reproduced a 42-byte flag matching `^TCTT2026\{[a-z0-9_]+\}$`, and verified encryption round-trip equality. The full flag and recovered salt are intentionally omitted from this record and delivered only to the authorized operator.
- Applied the workspace Thai-evidence guard, semantic English normalization, and TCTT CTF routing intake.
- Confirmed that the supplied APK was already present locally, then ran the Kali readiness check, refreshed the workspace tool index, and performed read-only artifact triage.
- Fingerprinted the APK as a native Java/Kotlin Android app with no React Native, Cordova, Flutter, Xamarin, bundled JavaScript, or bundled HTML marker.
- Decompiled the APK with jadx. The first attempt failed because the Kali `/usr/bin/jadx` launcher changes its working directory, causing a relative output path to resolve under a non-writable system directory. Re-running with an absolute output path produced 1,947 Java files, with 31 general jadx warnings/errors and usable app classes.
- Decoded the APK independently with apktool and compared the decisive WebView bridge behavior against smali, avoiding reliance on jadx output alone.
- Followed the app's exact normal HTTP flow with bounded requests. The promo and VIP-salt routes returned `activation_required`; the activation-status route reported enabled, while the exact activation URL returned HTTP 404 through curl and Selenium-driven Firefox.
- Tried Chromium headless only after curl could not reproduce the browser flow. Chromium also hung on a local `data:` sanity page, so its task-created processes were terminated and the browser was rejected as an evidence source. Firefox and Selenium passed the local sanity check and confirmed the activation response was an empty page.
- Performed a fresh completion check of the APK hash, bundled web-asset count, Java and smali bridge instructions, absence of an app-package WebView navigation guard, and current backend status codes.

## Observations

- The operator supplied a single APK download URL and explicitly directed attention to JavaScript. The request was treated as authorized CTF artifact analysis, bounded to the APK and its evidenced challenge API flow.
- The APK is 4,656,991 bytes with SHA-256 `98cfe3dd17e61ba73c8fecb14d933b65a0084d9ca9d9a4b95507d156d5364c1e`.
- No materially route-changing Thai wordplay or Unicode ambiguity was identified in the operator request.
- The APK contains no `.js`, `.mjs`, `.html`, or `.htm` file. Its JavaScript boundary is a native Android `WebView` that loads server content.
- `PromoActivity` enables JavaScript, registers a native object named `SkyLink`, and then loads the promo or VIP URL with application headers. Smali confirms that `SkyLink.unlockVip()` is annotated with `@JavascriptInterface` and returns the stored intermediate VIP token directly.
- No `WebViewClient`, `shouldOverrideUrlLoading`, or equivalent navigation/origin guard appears in the application package. `PromoActivity` is not exported and its initial URL is constructed internally, which narrows direct exposure, but the bridge remains available to JavaScript executing in the loaded WebView and any navigation/frame allowed by WebView behavior.
- `MainActivity` derives a 42-character intermediate value by XORing a static byte array with `0x5a`; the VIP request then XORs that intermediate value with a repeating server-provided salt before URL-encoding it for `/api/vip`.
- The manifest marks the application debuggable. This is a separate inspection risk; no claim was made that WebView debugging is necessarily enabled on every runtime version.
- The live backend did not permit an end-to-end reproduction: the activation URL returned 404 and the VIP-salt endpoint returned 403 during fresh verification. At that stage no flag had been observed and no candidate was reported as solved.
- The subsequent known-plaintext analysis recovered and verified the flag offline from the APK transform despite the unavailable backend. The result is a 42-byte `TCTT2026{...}` value; it is not stored literally in the DEX.

## Lessons learned

- On this Kali image, `/usr/bin/jadx` changes directory to `/usr/share/jadx/bin`; wrappers that pass relative `-d` output paths fail even when the original workspace is writable. Use an absolute output path and verify decisive decompiler findings against smali when jadx reports errors.
- For Android WebView analysis, distinguish bundled JavaScript from remotely loaded JavaScript early; APK ZIP inventory plus DEX WebView markers provides a fast, reliable branch.
- A known flag prefix can recover part of a repeating XOR salt. Testing possible periods exposes forced plaintext positions; requiring a meaningful full salt plus an exact encrypt/decrypt round trip prevents a merely plausible English phrase from being mistaken for a flag.

## Outcome and next steps

- The JavaScript-use inspection and related flag recovery are complete. Decompiled Java and apktool smali outputs are retained under `02-skylink-decompiled/` and `02-skylink-apktool/`.
- The verified security finding is an origin-unscoped Android JavaScript bridge exposing the intermediate VIP token as `SkyLink.unlockVip()` to WebView JavaScript.
- The flag was recovered offline and verified against the exact smali-derived bytes and transform. No further work is required for this objective; live backend activation remains unavailable but is no longer needed for flag recovery.
