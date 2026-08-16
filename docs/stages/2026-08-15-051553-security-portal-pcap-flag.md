# Stage: Security portal PCAP flag recovery

- Started: 2026-08-15 05:15:53 UTC
- Updated: 2026-08-15 05:30:35 UTC
- Status: completed

## Task

Analyze the supplied `traffic.pcap` from an authorized internal audit of `security-portal.tctt.local`, identify weak TLS and related operational-security failures, recover all three flag parts, and return the flag in `TCTT2026{md5}` format.

## Attempts and experiments

- Applied the required English-normalization intake while preserving the PCAP and flag syntax as protected evidence.
- Confirmed the request concerns a supplied artifact within an explicitly authorized audit/CTF scope.
- Began the source-locked TCTT orchestration workflow; packet-level analysis has not yet started.
- Read the workspace catalogue, finalized the English intake packet, and routed the artifact through `ctf-sandbox-orchestrator` to `competition-pcap-protocol` with the single permitted protocol-reverse-engineering supplement.
- The first Superpowers Codex-reference lookup used the package's parent `references/` directory and failed; locating the installed file showed it resides under `skills/using-superpowers/references/`, after which the full reference was read.
- Ran the read-only artifact triage, Kali readiness check, and local tool-index refresh. No packages were installed and no network target was contacted.
- Mapped 142 packets across seven complete TCP streams over 14.023 seconds: six HTTPS streams to `10.13.37.100:443` and one plaintext debug HTTP stream to port 8080. No UDP traffic is present.
- Reassembled TLS stream 0 and observed a NULL-encryption RSA suite exposing the part-1 API exchange and token.
- Reassembled debug stream 5, extracted its captured TLS master-secret line in memory, correlated its client random to TLS stream 4, and decrypted the part-3 API exchange and token.
- Extracted the stream-2 certificate in a temporary location, confirmed a 512-bit RSA public key with exponent 65537, and removed the temporary certificate files after validation.
- Tested the RSA-512 modulus with 2,000,001 Fermat iterations, bounded SymPy trial/Pollard p-1/Pollard rho/ECM methods, cross-certificate GCD reasoning, certificate-signature validation, and a ciphertext/modulus GCD check. None recovered a factor or alternate break.
- Searched locally for CADO-NFS, msieve, YAFU, GMP-ECM, PARI/Sage, cached packages, and usable container images. None is available; Docker's daemon socket is permission-denied and was not bypassed.
- Resumed after the operator instructed continuation, treating that response to the prior explicit choice as authorization for the recommended narrowly scoped public FactorDB lookup.
- Queried FactorDB's documented read-only API with the public RSA-512 modulus; it returned a complete two-prime factorization. Verified locally that the factors multiply to the certificate modulus.
- Used the factors to decrypt the captured PKCS#1 v1.5 premaster secret in memory, validated its TLS 1.2 version and length, derived the master secret, and reassembled stream 2 with `tshark` without persisting private-key material.
- Performed a fresh end-to-end verification that independently re-extracted all three labeled response fragments, checked their lengths and hexadecimal form, concatenated them in part order, and validated the final flag against `TCTT2026\{[0-9a-f]{32}\}`.

## Observations

- The workspace contains one matching capture artifact at `./traffic.pcap`.
- The operator states that the flag has three parts and that HTTPS/TLS weaknesses plus surrounding infrastructure failures are relevant.
- Artifact triage identifies a 20,989-byte classic libpcap capture with SHA-256 `553761daab05a4bd88c813f72726be7d6cdde3a2c9766704498b5c59e9de7430`.
- The required packet and TLS tools (`tshark`, `openssl`) are available; six unrelated toolchain checks are missing and are not needed for this task.
- Stream 0 negotiates cipher suite `0x0002` (`TLS_RSA_WITH_NULL_SHA`) and packets 14–18 expose `PART1_OF_3:53917362945`.
- Plaintext stream 5 exposes an internal debug endpoint and TLS master-secret material. The leaked client random matches stream 4; decrypted packets 102–107 expose `PART3_OF_3:19ec239277e`.
- Stream 2 negotiates `0x002f` (`TLS_RSA_WITH_AES_128_CBC_SHA`) and uses a self-signed RSA-512 certificate in frame 50. Its encrypted premaster secret is 64 bytes and coprime to the modulus; recovering part 2 requires factoring that modulus or an equivalent dedicated RSA recovery.
- The capture is internally consistent and complete enough for TLS reconstruction; no packet-loss or asymmetric-capture issue explains the remaining encryption boundary.
- Decrypted stream 2 packets 58–63 expose `PART2_OF_3:dd1b802920` and the hint that the 512-bit key is the intended weakness.
- The three fragment lengths are 11, 10, and 11 characters. Their direct ordered concatenation is already a 32-character lowercase hexadecimal value, so no second MD5 operation is indicated.
- Fresh verification produced `TCTT2026{53917362945dd1b80292019ec239277e}` with `verification=PASS`.

## Lessons learned

- TLS suite selection must be evaluated per stream: one server endpoint negotiated NULL encryption, RSA-512, a non-forward-secret RSA/AES suite with leaked key material, and TLS 1.3 across different clients.
- Operational debug exposure can nullify otherwise strong record encryption; correlating a leaked `CLIENT_RANDOM` value to the handshake is a decisive, reproducible decryption path.
- Bounded lightweight factoring tests are insufficient for a balanced RSA-512 modulus when no intentional arithmetic shortcut is present; a GNFS-capable tool or an approved public factor lookup is the practical next gate.
- When labeled flag fragments already concatenate to the exact required 32-hex payload, applying MD5 again would be an unsupported extra transform; validate the format and preserve the observed fragment order.

## Outcome and next steps

All three components were observed in reconstructed HTTP responses and verified from a fresh extraction. The completed flag is `TCTT2026{53917362945dd1b80292019ec239277e}`. No further work is required.
