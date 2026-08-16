import hashlib, random, sys
from fpylll import IntegerMatrix, LLL
sys.path.insert(0, '/home/azureuser/Desktop/tctt/player_package/player_package')
from ec_core import ecdsa_sign, privkey_to_pubkey, N as _N
N = 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141

def sha256_int(msg):
    return int.from_bytes(hashlib.sha256(msg).digest(), "big")

d_true = random.randrange(1, N)
m = 60
l_bits = 8
B = 2 ** (256 - l_bits)
n = N
sigs = []
for i in range(m):
    msg = f"test-{i}".encode()
    h = sha256_int(msg) % N
    k = random.randrange(1, B)
    r, s = ecdsa_sign(msg, d_true, k)
    sigs.append((h, r, s))

Q_true = privkey_to_pubkey(d_true)

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

print("true d =", hex(d_true))
nB = n * B
found = False
for row in range(m + 2):
    vm = M[row, m]
    vlast = M[row, m + 1]
    if vm % B == 0:
        cand = vm // B
        if cand != 0 and privkey_to_pubkey(cand) == Q_true:
            print(f"FOUND at row {row}: d = {hex(cand)}")
            found = True
        cand2 = -cand
        if cand2 != 0 and privkey_to_pubkey(cand2) == Q_true:
            print(f"FOUND (neg) at row {row}: d = {hex(cand2)}")
            found = True
if not found:
    print("not found in basis. Showing candidate d values per row:")
    for row in range(m + 2):
        vm = M[row, m]
        vlast = M[row, m + 1]
        print(f"row {row}: col[m]/B={vm//B if vm%B==0 else 'X'} last={vlast} last==nB?{vlast==nB}")
    # try BKZ
    print("trying BKZ...")
    from fpylll import BKZ
    M2 = IntegerMatrix(m + 2, m + 2)
    for i in range(m):
        M2[i, i] = n * n
    for i, (h, r, s) in enumerate(sigs):
        inv_s = pow(s, -1, n)
        t_i = (r * inv_s) % n
        a_i = (-(h * inv_s)) % n
        M2[m, i] = n * t_i
        M2[m + 1, i] = n * a_i
    M2[m, m] = B
    M2[m + 1, m + 1] = n * B
    BKZ.reduction(M2, BKZ.Param(block_size=20))
    for row in range(m + 2):
        vm = M2[row, m]
        if vm % B == 0:
            cand = vm // B
            if cand != 0 and privkey_to_pubkey(cand) == Q_true:
                print(f"BKZ FOUND at row {row}: d = {hex(cand)}")
            cand2 = -cand
            if cand2 != 0 and privkey_to_pubkey(cand2) == Q_true:
                print(f"BKZ FOUND (neg) at row {row}: d = {hex(cand2)}")
