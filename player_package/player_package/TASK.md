# Legacy Signer

We pulled the audit log and commit history off an old internal signing
service before it was decommissioned. Recover the service's private key
and prove it by signing our challenge string.

## Provided

- `CHANGELOG.md` — the service's commit history (nonce-generation
  implementation details included, nothing redacted).
- `signatures.json` — every signature the service ever issued, each with
  its timestamp, the message it signed, and (r, s).
- `pubkey.json` — the service's public key (secp256k1).
- `ec_core.py` — basic EC point arithmetic / sign / verify helpers for
  secp256k1, in case you want a starting point instead of writing your
  own or pulling in a library.

## Goal

Recover the private key `d` such that `d * G == Q` (the published
pubkey). Then sign the ASCII string "give-me-the-flag" with it.

## Flag format

Once you have the private key `d` as a Python int, compute:

```python
import hashlib
flag = "TCTT2026{" + hashlib.sha256(hex(d).encode()).hexdigest()[:32] + "}"
```

Note `hex(d)` includes Python's `0x` prefix — use exactly that string
(not a stripped or zero-padded variant) as the hash input.

## Notes

- Every signature in the log was produced by the "same private key".
