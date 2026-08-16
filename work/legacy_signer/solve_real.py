import hashlib, json, sys
from fpylll import IntegerMatrix, LLL
sys.path.insert(0, '/home/azureuser/Desktop/tctt/player_package/player_package')
from ec_core import privkey_to_pubkey, ecdsa_sign

N = 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141
Gx = 0x79BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798
Gy = 0x483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8

def sha256_int(msg: bytes) -> int:
    return int.from_bytes(hashlib.sha256(msg).digest(), "big")

def recover_d(sigs, l_bits, Q):
    """sigs: list of (h, r, s). Returns d with d*G==Q, or None."""
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
    for row in range(m + 2):
        vm = M[row, m]
        if vm % B == 0:
            cand = vm // B
            for c in (cand, -cand, cand % n, (-cand) % n):
                if c != 0 and privkey_to_pubkey(c) == Q:
                    return c
    return None

def main():
    base = '/home/azureuser/Desktop/tctt/player_package/player_package'
    data = json.load(open(f'{base}/signatures.json'))
    pub = json.load(open(f'{base}/pubkey.json'))
    Q = (int(pub['Qx'], 16), int(pub['Qy'], 16))
    print("Q =", hex(Q[0]), hex(Q[1]))

    # sanity: verify Q is on curve and Q = some d*G handled later
    for l_bits, src_filter in [(8, 'signer-v2'), (12, 'proto-alpha')]:
        sigs = []
        for s in data:
            if s['message'].split('"src":"')[1].split('"')[0] != src_filter:
                continue
            h = sha256_int(s['message'].encode('utf-8')) % N
            r = int(s['r'], 16)
            sval = int(s['s'], 16)
            sigs.append((h, r, sval))
        print(f"\n{src_filter}: {len(sigs)} signatures, l_bits={l_bits}")
        # try increasing m until found (or all)
        for m in [40, 60, 80, 100, 150, len(sigs)]:
            m = min(m, len(sigs))
            d = recover_d(sigs[:m], l_bits, Q)
            if d is not None:
                print(f"  RECOVERED with m={m}: d = {hex(d)}")
                print(f"  d*G == Q: {privkey_to_pubkey(d) == Q}")
                # sign challenge
                msg = b"give-me-the-flag"
                # choose k arbitrarily (any valid nonce) for the proof signature
                k = 0x1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef
                r, s = ecdsa_sign(msg, d, k)
                print(f"  signature of 'give-me-the-flag': r={hex(r)}, s={hex(s)}")
                hx = hex(d)
                flag = "TCTT2026{" + hashlib.sha256(hx.encode()).hexdigest()[:32] + "}"
                print(f"  hex(d) = {hx}")
                print(f"  FLAG = {flag}")
                return
            else:
                print(f"  m={m}: not found")
    print("FAILED")

if __name__ == "__main__":
    main()
