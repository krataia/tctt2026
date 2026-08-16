import hashlib, json, random
from fpylll import IntegerMatrix, LLL, BKZ

# secp256k1
N = 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141

def sha256_int(msg: bytes) -> int:
    return int.from_bytes(hashlib.sha256(msg).digest(), "big")

def recover_d(sigs, l_bits):
    """sigs: list of (h, r, s) ints. l_bits = number of leading zero bits of nonce.
    Returns candidate d (int) or None."""
    n = N
    m = len(sigs)
    B = 2 ** (256 - l_bits)
    # uniform scale by n to make rational B/n integer
    # rational lattice rows:
    #   Row_i (i<m): n at col i
    #   Row_d:      t_i at col i, B/n at col m
    #   Row_a:      a_i at col i,        B at col m+1
    # scale all by n:
    M = IntegerMatrix(m + 2, m + 2)
    for i in range(m):
        M[i, i] = n * n          # n^2
    for i, (h, r, s) in enumerate(sigs):
        inv_s = pow(s, -1, n)
        t_i = (r * inv_s) % n
        a_i = (-(h * inv_s)) % n
        M[m, i] = n * t_i        # n * t_i
        M[m + 1, i] = n * a_i    # n * a_i
    M[m, m] = B                 # B (from (B/n)*n)
    M[m + 1, m + 1] = n * B     # n*B
    LLL.reduction(M)
    # search reduced basis for target vector (n*k_0,...,n*k_{m-1}, d*B, -n*B)
    nB = n * B
    for row in range(m + 2):
        v = [M[row, j] for j in range(m + 2)]
        # last coord should be +/- nB (the -nB or nB), col m is d*B
        last = v[m + 1]
        if last != 0 and last % B == 0 and (abs(last) % nB == 0):
            d = v[m] // B
            # validate: col m+1 should be +/- nB
            if d != 0 and abs(last) == nB:
                return d, row
        # also try d = v[m]/B even if last not exactly nB
    # fallback: just take first row's col m / B
    d = M[0, m] // B
    return d, None

# ---- synthetic self-test ----
def test():
    d_true = random.randrange(1, N)
    m = 60
    l_bits = 8
    B = 2 ** (256 - l_bits)
    sigs = []
    for i in range(m):
        msg = f"test-{i}".encode()
        h = sha256_int(msg) % N
        k = random.randrange(1, B)
        # k = random with top 8 bits zero
        # sign: s = k^{-1}(h + r d); r = (k G).x
        # reuse ec_core logic inline
        import sys
        sys.path.insert(0, '/home/azureuser/Desktop/tctt/player_package/player_package')
        from ec_core import ecdsa_sign, G
        r, s = ecdsa_sign(msg, d_true, k)
        sigs.append((h, r, s))
    d, row = recover_d(sigs, l_bits)
    print("true d:", hex(d_true))
    print("rec  d:", hex(d) if d else None)
    print("match:", d == d_true)

if __name__ == "__main__":
    test()
