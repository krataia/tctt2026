# Evidence-to-route matrix

Use observed evidence, not challenge labels, to choose the first child skill. Load one primary and no more than one supplemental source.

| Evidence | Primary competition route | Supplemental source | Fallback if unconfirmed |
| --- | --- | --- | --- |
| ELF/PE crash, mitigation output, syscall or memory-corruption clue | `competition-reverse-pwn` | Claude-Red `exploit-dev` or wshobson `binary-analysis-patterns` | Static RE → controlled debugger trace |
| APK/XAPK/JAR/AAR, DEX, `lib*.so`, Android manifest | `competition-android-hooking` or `competition-crypto-mobile` | Android RE or P4nda `rev-*` | Java/DEX → native library route |
| HTTP route, cookie, API schema, worker, template, source map | `competition-web-runtime` | Cloudflare audit or Claude-Red `web` | Source/runtime route → protocol normalization or WebSocket child |
| Raw TCP/UDP frames, protobuf/gRPC, PCAP | `competition-pcap-protocol` or `competition-custom-protocol-replay` | wshobson `protocol-reverse-engineering` | Protocol map → payload parser route |
| Disk image, memory dump, event logs, browser history, timestamps | `competition-forensic-timeline` | wshobson `memory-forensics` | Timeline → malware-config or PCAP route |
| Ciphertext, key material, archive encryption, media anomaly | `competition-crypto-mobile`, `competition-zip-archive`, or `competition-stego-media` | Claude-Red only when a matching CTF skill exists | Format/metadata → crypto primitive route |
| IAM policy, container, Kubernetes manifest, cloud metadata path | `competition-agent-cloud` or `competition-container-runtime` | Claude-Red `cloud` | IAM/data plane → K8s control-plane route |
| JWT/OAuth/SAML, AD artifacts, Kerberos, Windows event data | `competition-identity-windows` | Claude-Red `auth`/`active-directory` | Token claims → protocol/identity specialist |
| Prompt, tool trace, agent memory, RAG output | `competition-prompt-injection` | ClawSec integrity skill | Prompt boundary → agent/cloud route |

## Route quality rules

- Prefer a child skill named for the observed mechanism over a broad category.
- Do not treat strings, comments, hints, or filenames as proof; corroborate with a parser result, runtime behavior, or a decoded structure.
- Keep a rejected hypothesis in the response. It prevents cycling through the same route.
- Escalate from passive inspection to active CTF interaction only after identifying a specific boundary to test.
