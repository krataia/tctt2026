# Stage: Lottery Checker Local Winner Data Recovery

- Started: 2026-08-15 04:52:39 UTC
- Updated: 2026-08-15 05:39:12 UTC
- Status: blocked

## Task

วิเคราะห์แอปตรวจสลากและฟีเจอร์ซื้อสลากพิเศษ แล้วกู้ข้อมูลผู้ถูกรางวัลที่แอปเก็บไว้ภายในเครื่อง จาก artifact ที่ผู้ใช้ระบุ: `01-lottery-checker.apk` ที่ `https://thctt26.p7z.pw/apks/01-lottery-checker.apk`

## Attempts and experiments

- เก็บคำขอภาษาไทยและหลักฐานที่ระบุไว้โดยไม่เปลี่ยนรูป แล้วสร้าง working brief ภาษาอังกฤษภายในตามลำดับ intake ของ workspace
- ตรวจคำไทยที่อาจเปลี่ยนเส้นทางโจทย์ ไม่พบคำผวนหรือความกำกวมที่ต้องถามผู้ใช้; กำหนด read-only distinguishing test เป็นการตรวจ storage API, local database, preferences, assets และ internal files
- Route เบื้องต้นผ่าน `ctf-sandbox-orchestrator` ไปยัง `competition-android-hooking` โดยใช้ Android reverse-engineering supplement และเลือก static analysis ก่อน runtime instrumentation
- พบ APK อยู่ใน workspace แล้ว จึงไม่ดาวน์โหลดซ้ำ; บันทึก SHA-256 และตรวจชนิดไฟล์ด้วย triage helper
- Kali preflight พบ `jadx`, `apktool` และ `adb` พร้อมใช้; Frida ขาดแต่ยังไม่จำเป็นกับ static-first path
- Fingerprint ระบุ Native Android (Java/Kotlin), obfuscation ต่ำ, ไม่มี native library หรือ HTTP stack
- apktool ถอด manifest/resources/smali สำเร็จ ส่วน decompile wrapper ล้มเหลวตอนส่ง output path แบบ relative ให้ JADX (`Can't create directory .../sources`)
- ตรวจ permission และสภาพ directory ไม่พบ output ค้าง; ทดสอบสมมติฐานเดียวโดยรัน JADX ด้วย absolute output path ซึ่งสำเร็จและได้ Java 2,829 ไฟล์กับ resource 1,122 ไฟล์
- ตาม call-flow จากปุ่มซื้อสลากพิเศษไปยัง `GET /api/purchase-material`, การอ่าน field `winner_secret` จาก JSON และการเขียน SharedPreferences
- ตรวจ smali ซ้ำเพื่อยืนยันว่า field `storageMask` ถูกกำหนดเป็น `0x5a` เท่านั้นและไม่เคยถูกอ่าน; ค่าจาก server ถูกเก็บโดยตรงโดยไม่มี XOR/ถอดรหัสฝั่งแอป
- ตรวจ backend ตาม flow ที่ APK ระบุโดยใช้เฉพาะ host/route ของ challenge: `/activation/status` ตอบ 200 และระบุว่า activation เปิดอยู่ ขณะที่ purchase โดยไม่มี capability ตอบ 403 `activation_required`
- ทดสอบ PKCE start route `/activate` ด้วย state/challenge ที่มีขนาดถูกต้อง ทั้งค่าทดสอบและค่า SecureRandom, browser User-Agent, Chromium จริง, trailing slash, namespace `/activation`, install ID แบบสุ่มตามโค้ด และ `code_challenge_method=S256`; ทุกกรณีตอบ 404
- ทดสอบ capability ที่ผ่านเฉพาะ prefix check ของแอปหนึ่งค่าและ exchange ด้วย code สมมติหนึ่งครั้ง ทั้งคู่ถูก backend ปฏิเสธ; หยุดโดยไม่ brute-force
- ค้น exact challenge strings แบบ read-only บนเว็บ ไม่พบ source หรือ write-up สาธารณะ
- ดาวน์โหลด APK จาก URL ที่ผู้ใช้ให้มาใหม่ลง `/tmp` แล้วเทียบ SHA-256 และ byte-for-byte กับไฟล์ที่วิเคราะห์ พบว่าตรงกัน จึงตัดสมมติฐานว่าเป็น build เก่า
- ตรวจ ADB นอก sandbox แบบ read-only ไม่พบ device หรือ emulator ที่เชื่อมต่อ จึงไม่มี runtime preferences ให้ดึง
- Verification รอบสุดท้ายยืนยัน hash, call-flow, storage keys, การไม่มีการอ่าน `storageMask` และไม่พบ flag รูปแบบ `TCTT2026{...}` ฝังใน output ของ JADX/apktool
- ผู้ใช้สั่งให้ดำเนินงานต่อ จึงเปิด stage เดิมกลับเป็น `in_progress`, คงหลักฐานเดิม และ re-route จาก Android static analysis ไปยัง OAuth/PKCE boundary ซึ่งเป็น blocker ปัจจุบัน
- ตรวจ OAuth/PKCE contract เพิ่มเติมแบบ bounded: metadata มาตรฐาน, fallback authorization paths, trailing-slash/path variants และ `OPTIONS` ไม่เปิดเผย route ที่ใช้งานได้; `/activate` ของ Mobile02 และ Mobile03 ก็มีอาการ 404 เดียวกัน จึงเป็นเงื่อนไขของ activation layer ร่วม ไม่ใช่ parsing bug เฉพาะ Mobile01
- เปรียบเทียบ flow ของ APK ใกล้เคียง พบรูปแบบ `/activate` → `/activate/exchange` → capability prefix เดียวกัน แต่ไม่มี client-side parser, signing key หรือ capability ตัวอย่างที่นำมาสร้าง token ที่ backend ยอมรับได้
- สร้าง `work/LotteryHttpProbe.java` เพื่อจำลอง header profile ของแอปด้วย Java `HttpURLConnection` โดยอ่าน API key จาก resource ตอน runtime และไม่พิมพ์/คัดลอกค่าออกมา; compile สำเร็จ
- ทดสอบ `/activation/status` ผ่าน Java network stack ได้ HTTP 200 และ `enabled:true` เหมือน curl/Chromium จึงตัดสมมติฐานว่า backend แยก Java/Android HTTP stack
- ทดสอบเลข `000007` ที่อนุมานตรงจาก ticket ID ผ่าน `/check` หนึ่งครั้ง ได้ 403 `activation_required`; response ของ purchase route ไม่มี activation URL, cookie หรือ `WWW-Authenticate` เพิ่มเติม
- ทดสอบ activation navigation ด้วย canonical PKCE shape, exact app headers, Android Chrome/Thai locale headers และ Android app referrer อย่างละ bounded case; ทุกกรณียังตอบ 404
- ตรวจ archive inventory, raw/asset/unknown files, app-package DEX strings และ array payload อีกรอบ พบเพียง Kotlin debug metadata; ไม่มี ciphertext, bundled winner data หรือ flag literal ที่ใช้แก้ offline ได้
- ตรวจ ADB นอก sandbox แบบ read-only ซ้ำ ไม่พบ device ที่เชื่อมต่อ และระบบไม่มี emulator binary/AVD จึงไม่สามารถสร้าง purchased runtime state หรืออ่าน SharedPreferences จริงใน workspace นี้
- Verification ล่าสุดยืนยันว่า APK ที่ดาวน์โหลดใหม่ตรง byte-for-byte, call-flow/storage keys ยังตรงกับ smali/Java, ไม่มี `TCTT2026{...}` ใน output และมี stage record ของ objective นี้เพียงไฟล์เดียว
- ผู้ใช้ถามย้ำว่า `what flag?`; เปิด stage เดิมกลับเป็น `in_progress` เพื่อทำ bounded recovery pass เพิ่ม โดยยังไม่ยกระดับค่าที่เดาเป็นผลลัพธ์
- ค้น workspace และ task-related temporary files หา Android backup, purchased SharedPreferences หรือ winner-state artifact เพิ่มเติม ไม่พบข้อมูล runtime นอก APK/decompile outputs เดิม
- เมื่อ OAuth/PKCE branch ไม่มี session state ให้ใช้ จึง re-route ผ่าน request-normalization workflow และทดสอบ purchase path แบบเปลี่ยนทีละตัวแปร: trailing slash, literal dot segment และ percent-encoded dot segment; ทั้งสามแบบเข้าถึง authorization branch เดิมและตอบ 403 `activation_required`
- หยุด path-variant probing หลังผลสอดคล้องสามครั้ง เพราะหลักฐานชี้ว่า proxy/backend normalize path ก่อน capability check; ไม่ทำ broad fuzzing หรือเดา token/flag

## Observations

- ขอบเขตที่ได้รับอนุญาตคือ APK ที่ผู้ใช้ให้มาและเส้นทางการแข่งขันที่ artifact ระบุเท่านั้น
- คำใบ้หลักคือฟีเจอร์ซื้อสลากพิเศษและข้อมูลผู้ถูกรางวัลที่เก็บภายในเครื่อง จึงให้น้ำหนักกับ SharedPreferences, SQLite/Room, assets และ internal files
- Artifact มี SHA-256 `e78f1623fb7b2e0db2210262d0c2b23ee8c41478d4a2eb9e80d3046752bdcb6e` และ triage route ยืนยัน Android hooking/crypto-mobile
- ความล้มเหลวของ wrapper เป็นปัญหา path resolution ของเครื่องมือในสภาพแวดล้อมนี้ ไม่ใช่ APK เสีย เพราะคำสั่ง JADX เดิมสำเร็จเมื่อใช้ absolute output path
- Package คือ `sh.sth.lotterychecker`; manifest ตั้ง `android:debuggable="true"` และ `android:allowBackup="false"`
- ชื่อ SharedPreferences คือ `winner_secrets` จึงอยู่ที่ `<app-data>/shared_prefs/winner_secrets.xml` เช่น `/data/user/0/sh.sth.lotterychecker/shared_prefs/winner_secrets.xml` (หรือ alias `/data/data/...`)
- เมื่อซื้อสำเร็จ แอปเก็บ `special_ticket_purchased=true`, `purchase_timestamp_ms`, `winner_secret` และ `ticket_id=TH-LOTO-2026-SPECIAL-0007`
- ค่า `winner_secret` มาจาก response ของ `/api/purchase-material` และถูกเก็บตรง ๆ; ไม่มีค่าจริงดังกล่าวอยู่ใน APK
- การเปลี่ยน network stack, browser headers, locale และ Android app referrer ไม่ทำให้ activation route เปิด; live API ยังคงบังคับ capability ที่ต้องมาจาก activation/session ภายนอก
- ไม่มี Android runtime state ใน workspace และไม่มีข้อมูลเข้ารหัสใน APK ที่ให้ validation oracle แบบ Mobile02/Mobile03 ดังนั้น naming pattern จากโจทย์ข้างเคียงไม่เพียงพอสำหรับอนุมาน flag อย่างมีหลักฐาน
- Path normalization variants ไม่เปลี่ยน authorization outcome จึงไม่มีหลักฐานของ middleware/handler differential ที่ใช้ดึง `winner_secret` ได้
- ยังไม่พบ flag ที่สังเกตได้จริง จึงห้ามสรุปหรือเดา flag

## Lessons learned

- สำหรับ JADX 1.5.5 ในสภาพแวดล้อมนี้ ควรใช้ absolute output path เมื่อ wrapper ส่ง relative path แล้วสร้าง `sources` ไม่ได้; ยืนยันด้วยการเปลี่ยนตัวแปรเดียวก่อน retry
- สำหรับ SharedPreferences ที่สร้างด้วย `getSharedPreferences("winner_secrets", MODE_PRIVATE)` อย่าเติม `.xml` ซ้ำในชื่อ API; Android เติมนามสกุลให้บนดิสก์เอง
- Field ที่ดูเหมือน crypto clue ต้องยืนยันการใช้งานจาก bytecode; ใน artifact นี้ `storageMask=0x5a` เป็น dead field ไม่ใช่ขั้นตอนถอดรหัส
- ความเหมือนของชื่อ secret ในโจทย์ข้างเคียงใช้สร้างสมมติฐานได้เฉพาะเมื่อมี ciphertext/round-trip oracle ให้ตรวจ; ห้ามยกระดับ pattern เป็น flag candidate หากไม่มีหลักฐานตรวจสอบ
- เมื่อ client เปิด external browser สำหรับ PKCE แต่ route ตอบ 404 ในทุก browser profile และไม่มี token fixture ใน artifact จุดตัดสินใจที่ถูกต้องคือขอ runtime state ที่ซื้อสำเร็จ ไม่ใช่ forge capability แบบเดาสุ่ม
- เมื่อ path variants หลายแบบถูก normalize ไปยัง auth branch เดียวกัน ควรหยุดการไล่ encoding เพิ่มและกลับไปยัง prerequisite ที่พิสูจน์แล้วคือ valid capability/purchased state

## Outcome and next steps

- งานถูกบล็อกก่อนการกู้ค่า flag จริง: live API ต้องการ valid activation capability แต่ `/activate` ตอบ 404 และ workspace ไม่มี authenticated/purchased Android runtime ให้ดึงข้อมูล
- หลักฐานที่ต้องการเพื่อทำต่อมีเพียงไฟล์จากเครื่องที่ซื้อสลากสำเร็จ: `shared_prefs/winner_secrets.xml` หรือ output ของ `adb exec-out run-as sh.sth.lotterychecker cat shared_prefs/winner_secrets.xml`; จากนั้นอ่านค่า `winner_secret` และตรวจรูปแบบ flag ได้ทันที
- หากยังไม่ได้ซื้อสำเร็จ ผู้ใช้ต้องเปิดแอป/activation ใน browser session ของการแข่งขันและกด Buy Special Ticket ก่อน; ห้ามส่งหรือบันทึก session cookie/credential ใน stage record
- Bounded recovery pass ล่าสุดไม่พบ flag; สถานะกลับเป็น `blocked` โดย next gate เดิมยังคงเป็น human-browser activation หรือ output จาก `winner_secrets.xml`
