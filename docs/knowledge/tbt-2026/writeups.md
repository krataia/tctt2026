# TBT 2026 — Challenge Write-ups

> Source: operator's own solve record [S1]. Confidence: **high** for the technical steps (firsthand record), **unverified** for competition meta-facts.

## Ransomware Ledger (Digital Forensics / Incident Response)

**Objective:** find the ransomware group's ledger hidden in the suspect's machine, sum the Bitcoin the victims actually paid (BTC Paid), and build the flag from the sum.

**Flag:** `TCTT2026{9bfd0a8df0d02679f02a45b507f64385}` — computed as `md5("21.0")`.

### Step 1 — Repair and mount the image (VHDX / NTFS repair)

- Provided file: Windows 10 triage image (`.raw` / `.vhdx`). `fls` / `mmls` initially fail — the NTFS partition's **boot sector signature is missing**.
- Fix: patch the last two bytes of the boot sector to the correct Magic bytes **`0x55 0xAA`** (offset 510–511 of the sector).
- After repair, `fls` + `icat` can list and carve files from the image.

### Step 2 — Extract and decrypt Windows Registry & DPAPI

Modern Windows apps (incl. most Electron apps) protect secrets with **DPAPI**. Recovery chain:

1. Carve Registry hives from the image:
   - `C:\Windows\System32\config\SYSTEM`
   - `C:\Windows\System32\config\SAM`
   - `C:\Windows\System32\config\SECURITY`
2. Pull the user `d4ag0n`'s DPAPI master key (`C:\Users\d4ag0n\AppData\Roaming\Microsoft\Protect\...`).
3. Use **pypykatz** to read LSA secrets and the NT hash from the hives.
4. Recover the user's login password from stored/browser credential material (or cracking) → **`Zeph!r_T1d3s`**.
5. Build the prekey with this password and decrypt the DPAPI master key (`masterkey.bak`) to plaintext.

### Step 3 — Unwrap the Signal Desktop database key

Signal stores chats in an encrypted **SQLCipher** DB (`db.sqlite`); the key is itself protected:

1. Signal stores its master key DPAPI-encrypted in `C:\Users\d4ag0n\AppData\Roaming\Signal\Local State` → field **`encrypted_key`** (Base64).
2. Decode Base64 and strip the `DPAPI` prefix → DPAPI blob.
3. `pypykatz dpapi blob` + the unwrapped master key from Step 2 → **AES-256-GCM key (32 bytes)**.
4. The real DB key is in `config.json` field **`encryptedKey`**, prefixed **`v10`**.
5. Strip `v10` and the nonce, AES-decrypt the remaining ciphertext → **SQLCipher passphrase (hex)**.
   - Example unwrapped key: `a0ac8537247b4e5f9c4eecab8862fa65def596614aa1eee288c10e9043176bfd`

### Step 4 — Extract chat messages from Signal

Open the DB with `sqlcipher`:

```sql
PRAGMA key = "x'a0ac8537247b4e5f9c4eecab8862fa65def596614aa1eee288c10e9043176bfd'";
SELECT body FROM messages;
```

Key messages found:

```
q4 numbers are in
updated ledger: https://tinyurl.com/dr4g0nia
rotate wallets after payout...
```

### Step 5 — Find the ledger and compute the flag

`https://tinyurl.com/dr4g0nia` redirects to a **publicly shared Google Sheets** (Ransomware Ledger). Pulled as CSV:

| Victim ID | Date | BTC Demanded | BTC Paid | Status | Notes |
| --- | --- | --- | --- | --- | --- |
| VIC-001 | 2025-11-03 | 2.50 | 2.50 | Paid | decrypt sent 11-04 |
| VIC-002 | 2025-11-15 | 2.50 | 1.75 | Paid | negotiated down from 2.5 |
| VIC-003 | 2025-12-01 | 3.00 | 0.00 | Refused | contacted FBI - dropped 12-09 |
| VIC-004 | 2025-12-20 | 1.25 | 1.25 | Paid | regional retailer, paid in two tranches |
| VIC-005 | 2026-01-08 | 4.50 | 4.50 | Paid | logistics - backups encrypted as well |
| VIC-006 | 2026-01-22 | 0.75 | 0.75 | Paid | partial leak used as leverage |
| VIC-007 | 2026-02-10 | 2.00 | 2.00 | Paid | paid after leak-site listing |
| VIC-008 | 2026-02-28 | 5.00 | 5.00 | Paid | largest to date, 6d negotiation |
| VIC-009 | 2026-03-15 | 1.50 | 0.00 | Ongoing | negotiating, offered 0.9 |
| VIC-010 | 2026-03-30 | 3.25 | 3.25 | Paid | manufacturer, paid same day |

Sum of **BTC Paid** only (not demanded):

```
2.50 + 1.75 + 0.00 + 1.25 + 4.50 + 0.75 + 2.00 + 5.00 + 0.00 + 3.25 = 21.0
```

Hash with MD5:

```
md5("21.0") = 9bfd0a8df0d02679f02a45b507f64385
```

### Flag

```
TCTT2026{9bfd0a8df0d02679f02a45b507f64385}
```

### Key lessons (reusable technique chain)

- NTFS boot-sector signature `0x55 0xAA` missing → patch before `fls`/`icat` analysis.
- DPAPI chain: user password → prekey → master key → app blob → app key.
- Electron app secrets: Signal `Local State` `encrypted_key` + `config.json` `encryptedKey` (`v10` prefix, AES-256-GCM).
- Triage images may leak operational artifacts (chat messages with public ledger links); public cloud documents are a valid DFIR pivot target.
