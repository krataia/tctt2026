# TCTT 2025 — Challenge Categories & Tracks

## Round 1 (online qualifier) — official categories

Official rules list these categories: **Web Application, Digital Forensic, Reverse Engineering & Pwnable, Network Security, Mobile Security, Programming, Cryptography**. [high]

Participant write-ups for the **Online-Senior** qualifier report **9 total categories**, 8 itemized with challenge counts: [medium]

| Category | Challenges (per write-ups) | Notes |
| --- | ---: | --- |
| Cryptography | 4 | e.g. "Advanced Strings Secret" (Base85→Base45→Malbolge), "New Base64" (custom Thai-character base64), "Bad62" (Base62, brute-forced) |
| Programming | 4 | incl. **lucky_but_unlucky** (300 pts; MT19937 PRNG prediction + input-filter bypasses), "Get High Fly Flag" (Scratch .sb3), "Shape of You", "Lost Character" |
| Digital Forensics | 3–4 | recycle_secrets (100), hidden_partition (100), **hidden_payload** (200; AES-128-ECB ISO, `J`×16 key), **Shadow-Hive** (300; Windows registry `.hiv`) |
| Network Forensics | 4 | "New Router" (100; hex from filtered IPv6 packets), "Upgraded Router" (100; XOR brute force), "Whisper in the Wire" (zlib streams), "Custom Protocol V2" |
| Reverse Engineering & Pwnable | 3 | **nuke** (RE, 100; .NET decompilation), **Snot_doom** (pwn, 200), **cyber_user** (pwn, 300); also `not_doom` (RE buffer overflow, offset 40, password `0xdeadb33fdeadb33f`) |
| Web Application | 4 | names not published in accessible write-ups |
| Mobile Security | 3 | names not published |
| Miscellaneous | 2 | names not published |
| (9th category) | — | not itemized |

Points scale with difficulty (observed 100/200/300). Whether Junior and Open used the same category set is unconfirmed. [gap]

## Round 2 (final) — "Attack the Virtual World" tracks

The final was split into two tracks, **Red (offensive)** and **Blue (defensive)**, **20 challenges each** (per the winning team's member blog). [medium]

- **Red (offensive)** included: ICS/SCADA (LeakRegConfig — Modbus register reading; PacketSniffer — PLC replay via pylogix; SensorSpoof — pH sensor spoofing), web exploitation (Internal E-Learning — Moodle webshell plugin; Pyload Server — pyLoad CVE exploit; LaTeXforYourThesis — SUID privilege escalation), and AI/prompt-injection (Selfinvite, CatAI, HeyChatWhoami, AiMyPrecious). [medium]
- **Blue (defensive)** = DFIR / incident response: e.g. "First Entry" (pcap credential leak via Roundcube HTTP login) and "Lateral Movement Phase" (Docker logs ~40k lines, Kubernetes audit logs ~50k entries, network captures, memory dumps; flag parts encoded ROT13+Base64 / Hex / XOR / plaintext combined into an MD5 answer). [medium]

## Where to find write-ups

- Aggregated: `https://ctf.in.th/write-up/4124/` [high]
- fifafayya (O-Opsifiz): `https://medium.com/@fifafayya/thailand-cyber-top-talent2025-senior-8a9b62d83c19` [medium]
- pammer434 (d3kc@rt_1) RE/Pwnable: `https://medium.com/@pammer434/thailand-cyber-top-talent-2025-online-senior-ctf-write-up-reverse-engineering-pwnable-b504347c762f` [medium]
- pipe2bot Forensics: `https://medium.com/@pipe2bot/thctt25-forensics-write-up-by-pipe2bot-d56a84962d69` [medium]
- Kiatisak Programming (300p): `https://medium.com/@kiatisakforstudy/thailand-cyber-top-talent-2025-senior-writeup-programming-300p-lucky-but-unlucky-5d0b272351fe` [medium]
- corra_nt general: `https://medium.com/@corra_nt/write-up-thailand-cyber-top-talent-2025-b4d3148443f5` [medium]
- noonomyen Senior final: `https://blog.noonomyen.com/posts/ctf/thailand-cyber-top-talent-2025-senior-final-writeups/` [medium]
