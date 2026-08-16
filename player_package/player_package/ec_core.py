"""
Minimal pure-Python secp256k1 + ECDSA implementation.
Not for production use -- built for a CTF challenge dataset generator/solver,
where we need full control over the per-signature nonce (k) to simulate
historical RNG bugs.
"""

import hashlib

# --- secp256k1 domain parameters ---
P  = 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F
A  = 0
B  = 7
Gx = 0x79BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798
Gy = 0x483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8
N  = 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141
G  = (Gx, Gy)


def inv_mod(x, m):
    return pow(x, -1, m)


def point_add(p1, p2):
    if p1 is None:
        return p2
    if p2 is None:
        return p1
    x1, y1 = p1
    x2, y2 = p2
    if x1 == x2 and (y1 + y2) % P == 0:
        return None
    if p1 == p2:
        lam = (3 * x1 * x1 + A) * inv_mod(2 * y1, P) % P
    else:
        lam = (y2 - y1) * inv_mod((x2 - x1) % P, P) % P
    x3 = (lam * lam - x1 - x2) % P
    y3 = (lam * (x1 - x3) - y1) % P
    return (x3, y3)


def scalar_mult(k, point):
    result = None
    addend = point
    k = k % N
    while k:
        if k & 1:
            result = point_add(result, addend)
        addend = point_add(addend, addend)
        k >>= 1
    return result


def sha256_int(msg: bytes) -> int:
    return int.from_bytes(hashlib.sha256(msg).digest(), "big")


def ecdsa_sign(msg: bytes, d: int, k: int):
    """Sign msg with private key d using an explicitly supplied nonce k.
    Returns (r, s). Caller is responsible for k's provenance -- that's the
    whole point of this challenge generator."""
    h = sha256_int(msg) % N
    R = scalar_mult(k, G)
    r = R[0] % N
    if r == 0:
        raise ValueError("bad k, r=0")
    s = (inv_mod(k, N) * (h + r * d)) % N
    if s == 0:
        raise ValueError("bad k, s=0")
    return r, s


def ecdsa_verify(msg: bytes, r: int, s: int, Q):
    h = sha256_int(msg) % N
    w = inv_mod(s, N)
    u1 = (h * w) % N
    u2 = (r * w) % N
    X = point_add(scalar_mult(u1, G), scalar_mult(u2, Q))
    if X is None:
        return False
    return (X[0] % N) == r


def privkey_to_pubkey(d: int):
    return scalar_mult(d, G)
