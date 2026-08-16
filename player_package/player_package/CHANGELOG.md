# signer-svc — history

Internal signing microservice used to authorize account transactions.
Below is the abridged commit history covering all nonce-generation
implementations this service has used. Full signature log for audit
purposes is in `signatures.json`. Public key is in `pubkey.json`.

---

commit 1a5f7c2 (2019-01-14)
Author: bank.d
    proto: internal alpha test

    First cut of the signer, deployed to a small internal test
    environment only. Nonce is drawn from os.urandom() and masked to
    fit a legacy fixed-width wire field inherited from the old
    settlement gateway: top 12 bits forced to zero. Rolled into the
    v2 rewrite below within a few weeks -- the alpha environment saw
    very light traffic before being retired.

commit 4e88b10 (2019-02-06)
Author: bank.d
    signer: v2 — production rewrite

    Full rewrite for production traffic. Same legacy wire-format
    constraint applies, but the field width was renegotiated with the
    settlement gateway team down to a single byte: nonce now masks
    only the top 8 bits to zero (rather than 12). Ran as the primary
    signer for close to a year.

commit 88b2ee1 (2020-01-16)
Author: natte.dd
    signer: v3 — remove wire-format nonce masking entirely

    The legacy settlement gateway was decommissioned, removing the
    fixed-width wire constraint that motivated the masking in v1/v2.
    Nonce generation now goes through an HMAC-DRBG reseeded from
    os.urandom() before every signature, with no masking of any kind.

commit 3f0d64e (2020-08-21)
Author: natte.dd
    signer: v4 — perf: drop DRBG reseed path

    The per-signature DRBG reseed was showing up in profiling under
    sustained load. Replaced with Python's standard `random` module
    (Mersenne Twister), seeded once at process start from os.urandom().
    Raw generator output is hashed (SHA-256) before use as the nonce.
    Throughput improved ~4x under load testing.

commit (unreleased)
    signer: v5 — planned migration to hardware HSM signing

    Tracked in JIRA-4471. Not yet implemented; v4 remains in production.
