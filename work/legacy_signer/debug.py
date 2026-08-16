import hashlib, random
from fpylll import IntegerMatrix, LLL
N = 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141

def sha256_int(msg: bytes) -> int:
    return int.from_bytes(hashlib.sha256(msg).digest(), "big")

def recover_d_debug(sigs, l_bits):
    n = N
    m = len(sigs)
    B = 2 ** (256 - l_bits)
    M = IntegerMatrix(m + 2, m + 2)
    for i in range(m):
        M[i, i] = n * n
    for i, (h, r, s) in enumerate(sigs):
        inv_s = pow(s, -1, n)
        t_i = (r * inv_s) % n
        a_i = (-(h * inv_s)) % n
        M[m, i] = n * t_i
        M[m + 1, i] = n * a_i
    M[m, m] = B
    M[m + 1, m + 1] = n * B
    LLL.reduction(M)
    nB = n * B
    print("=== reduced basis (last 3 cols + col m // B) ===")
    for row in range(m + 2):
        vm = M[row, m]
        vlast = M[row, m + 1]
        # also show first component magnitude to gauge short
        v0 = M[row, 0]
        print(f"row {row}: col[m]={vm}, col[m]/B={vm//B if vm % B == 0 else 'X'}, last={vlast}, last//(nB)={vlast//nB if vlast % nB == 0 else 'X'}, v0={v0}")
    return M

# build synthetic
d_true = random.randrange(1, N)
m = 60
l_bits = 8
B = 2 ** (256 - l_bits)
sigs = []
for i in range(m):
    msg = f"test-{i}".encode()
    h = sha256_int(msg) % N
    k = random.randrange(1, B)
    import sys; sys.path.insert(0, '/home/azureuser/Desktop/tctt/player_package/player_package')
    from ec_core import ecdsa_sign
    r, s = ecdsa_sign(msg, d_true, k)
    sigs.append((h, r, s))
print("true d =", hex(d_true))
M = recover_d_debug(sigs, l_bits)
