
router:     file format elf64-x86-64


Disassembly of section .init:

0000000000001000 <_init>:
    1000:	f3 0f 1e fa          	endbr64
    1004:	48 83 ec 08          	sub    rsp,0x8
    1008:	48 8b 05 d9 3f 00 00 	mov    rax,QWORD PTR [rip+0x3fd9]        # 4fe8 <__gmon_start__@Base>
    100f:	48 85 c0             	test   rax,rax
    1012:	74 02                	je     1016 <_init+0x16>
    1014:	ff d0                	call   rax
    1016:	48 83 c4 08          	add    rsp,0x8
    101a:	c3                   	ret

Disassembly of section .plt:

0000000000001020 <.plt>:
    1020:	ff 35 e2 3e 00 00    	push   QWORD PTR [rip+0x3ee2]        # 4f08 <_GLOBAL_OFFSET_TABLE_+0x8>
    1026:	f2 ff 25 e3 3e 00 00 	bnd jmp QWORD PTR [rip+0x3ee3]        # 4f10 <_GLOBAL_OFFSET_TABLE_+0x10>
    102d:	0f 1f 00             	nop    DWORD PTR [rax]
    1030:	f3 0f 1e fa          	endbr64
    1034:	68 00 00 00 00       	push   0x0
    1039:	f2 e9 e1 ff ff ff    	bnd jmp 1020 <_init+0x20>
    103f:	90                   	nop
    1040:	f3 0f 1e fa          	endbr64
    1044:	68 01 00 00 00       	push   0x1
    1049:	f2 e9 d1 ff ff ff    	bnd jmp 1020 <_init+0x20>
    104f:	90                   	nop
    1050:	f3 0f 1e fa          	endbr64
    1054:	68 02 00 00 00       	push   0x2
    1059:	f2 e9 c1 ff ff ff    	bnd jmp 1020 <_init+0x20>
    105f:	90                   	nop
    1060:	f3 0f 1e fa          	endbr64
    1064:	68 03 00 00 00       	push   0x3
    1069:	f2 e9 b1 ff ff ff    	bnd jmp 1020 <_init+0x20>
    106f:	90                   	nop
    1070:	f3 0f 1e fa          	endbr64
    1074:	68 04 00 00 00       	push   0x4
    1079:	f2 e9 a1 ff ff ff    	bnd jmp 1020 <_init+0x20>
    107f:	90                   	nop
    1080:	f3 0f 1e fa          	endbr64
    1084:	68 05 00 00 00       	push   0x5
    1089:	f2 e9 91 ff ff ff    	bnd jmp 1020 <_init+0x20>
    108f:	90                   	nop
    1090:	f3 0f 1e fa          	endbr64
    1094:	68 06 00 00 00       	push   0x6
    1099:	f2 e9 81 ff ff ff    	bnd jmp 1020 <_init+0x20>
    109f:	90                   	nop
    10a0:	f3 0f 1e fa          	endbr64
    10a4:	68 07 00 00 00       	push   0x7
    10a9:	f2 e9 71 ff ff ff    	bnd jmp 1020 <_init+0x20>
    10af:	90                   	nop
    10b0:	f3 0f 1e fa          	endbr64
    10b4:	68 08 00 00 00       	push   0x8
    10b9:	f2 e9 61 ff ff ff    	bnd jmp 1020 <_init+0x20>
    10bf:	90                   	nop
    10c0:	f3 0f 1e fa          	endbr64
    10c4:	68 09 00 00 00       	push   0x9
    10c9:	f2 e9 51 ff ff ff    	bnd jmp 1020 <_init+0x20>
    10cf:	90                   	nop
    10d0:	f3 0f 1e fa          	endbr64
    10d4:	68 0a 00 00 00       	push   0xa
    10d9:	f2 e9 41 ff ff ff    	bnd jmp 1020 <_init+0x20>
    10df:	90                   	nop
    10e0:	f3 0f 1e fa          	endbr64
    10e4:	68 0b 00 00 00       	push   0xb
    10e9:	f2 e9 31 ff ff ff    	bnd jmp 1020 <_init+0x20>
    10ef:	90                   	nop
    10f0:	f3 0f 1e fa          	endbr64
    10f4:	68 0c 00 00 00       	push   0xc
    10f9:	f2 e9 21 ff ff ff    	bnd jmp 1020 <_init+0x20>
    10ff:	90                   	nop
    1100:	f3 0f 1e fa          	endbr64
    1104:	68 0d 00 00 00       	push   0xd
    1109:	f2 e9 11 ff ff ff    	bnd jmp 1020 <_init+0x20>
    110f:	90                   	nop
    1110:	f3 0f 1e fa          	endbr64
    1114:	68 0e 00 00 00       	push   0xe
    1119:	f2 e9 01 ff ff ff    	bnd jmp 1020 <_init+0x20>
    111f:	90                   	nop
    1120:	f3 0f 1e fa          	endbr64
    1124:	68 0f 00 00 00       	push   0xf
    1129:	f2 e9 f1 fe ff ff    	bnd jmp 1020 <_init+0x20>
    112f:	90                   	nop
    1130:	f3 0f 1e fa          	endbr64
    1134:	68 10 00 00 00       	push   0x10
    1139:	f2 e9 e1 fe ff ff    	bnd jmp 1020 <_init+0x20>
    113f:	90                   	nop
    1140:	f3 0f 1e fa          	endbr64
    1144:	68 11 00 00 00       	push   0x11
    1149:	f2 e9 d1 fe ff ff    	bnd jmp 1020 <_init+0x20>
    114f:	90                   	nop
    1150:	f3 0f 1e fa          	endbr64
    1154:	68 12 00 00 00       	push   0x12
    1159:	f2 e9 c1 fe ff ff    	bnd jmp 1020 <_init+0x20>
    115f:	90                   	nop
    1160:	f3 0f 1e fa          	endbr64
    1164:	68 13 00 00 00       	push   0x13
    1169:	f2 e9 b1 fe ff ff    	bnd jmp 1020 <_init+0x20>
    116f:	90                   	nop
    1170:	f3 0f 1e fa          	endbr64
    1174:	68 14 00 00 00       	push   0x14
    1179:	f2 e9 a1 fe ff ff    	bnd jmp 1020 <_init+0x20>
    117f:	90                   	nop
    1180:	f3 0f 1e fa          	endbr64
    1184:	68 15 00 00 00       	push   0x15
    1189:	f2 e9 91 fe ff ff    	bnd jmp 1020 <_init+0x20>
    118f:	90                   	nop
    1190:	f3 0f 1e fa          	endbr64
    1194:	68 16 00 00 00       	push   0x16
    1199:	f2 e9 81 fe ff ff    	bnd jmp 1020 <_init+0x20>
    119f:	90                   	nop
    11a0:	f3 0f 1e fa          	endbr64
    11a4:	68 17 00 00 00       	push   0x17
    11a9:	f2 e9 71 fe ff ff    	bnd jmp 1020 <_init+0x20>
    11af:	90                   	nop

Disassembly of section .plt.got:

00000000000011b0 <__cxa_finalize@plt>:
    11b0:	f3 0f 1e fa          	endbr64
    11b4:	f2 ff 25 3d 3e 00 00 	bnd jmp QWORD PTR [rip+0x3e3d]        # 4ff8 <__cxa_finalize@GLIBC_2.2.5>
    11bb:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]

Disassembly of section .plt.sec:

00000000000011c0 <__snprintf_chk@plt>:
    11c0:	f3 0f 1e fa          	endbr64
    11c4:	f2 ff 25 4d 3d 00 00 	bnd jmp QWORD PTR [rip+0x3d4d]        # 4f18 <__snprintf_chk@GLIBC_2.3.4>
    11cb:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]

00000000000011d0 <free@plt>:
    11d0:	f3 0f 1e fa          	endbr64
    11d4:	f2 ff 25 45 3d 00 00 	bnd jmp QWORD PTR [rip+0x3d45]        # 4f20 <free@GLIBC_2.2.5>
    11db:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]

00000000000011e0 <puts@plt>:
    11e0:	f3 0f 1e fa          	endbr64
    11e4:	f2 ff 25 3d 3d 00 00 	bnd jmp QWORD PTR [rip+0x3d3d]        # 4f28 <puts@GLIBC_2.2.5>
    11eb:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]

00000000000011f0 <fclose@plt>:
    11f0:	f3 0f 1e fa          	endbr64
    11f4:	f2 ff 25 35 3d 00 00 	bnd jmp QWORD PTR [rip+0x3d35]        # 4f30 <fclose@GLIBC_2.2.5>
    11fb:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]

0000000000001200 <strlen@plt>:
    1200:	f3 0f 1e fa          	endbr64
    1204:	f2 ff 25 2d 3d 00 00 	bnd jmp QWORD PTR [rip+0x3d2d]        # 4f38 <strlen@GLIBC_2.2.5>
    120b:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]

0000000000001210 <__stack_chk_fail@plt>:
    1210:	f3 0f 1e fa          	endbr64
    1214:	f2 ff 25 25 3d 00 00 	bnd jmp QWORD PTR [rip+0x3d25]        # 4f40 <__stack_chk_fail@GLIBC_2.4>
    121b:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]

0000000000001220 <memset@plt>:
    1220:	f3 0f 1e fa          	endbr64
    1224:	f2 ff 25 1d 3d 00 00 	bnd jmp QWORD PTR [rip+0x3d1d]        # 4f48 <memset@GLIBC_2.2.5>
    122b:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]

0000000000001230 <alarm@plt>:
    1230:	f3 0f 1e fa          	endbr64
    1234:	f2 ff 25 15 3d 00 00 	bnd jmp QWORD PTR [rip+0x3d15]        # 4f50 <alarm@GLIBC_2.2.5>
    123b:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]

0000000000001240 <close@plt>:
    1240:	f3 0f 1e fa          	endbr64
    1244:	f2 ff 25 0d 3d 00 00 	bnd jmp QWORD PTR [rip+0x3d0d]        # 4f58 <close@GLIBC_2.2.5>
    124b:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]

0000000000001250 <read@plt>:
    1250:	f3 0f 1e fa          	endbr64
    1254:	f2 ff 25 05 3d 00 00 	bnd jmp QWORD PTR [rip+0x3d05]        # 4f60 <read@GLIBC_2.2.5>
    125b:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]

0000000000001260 <fgets@plt>:
    1260:	f3 0f 1e fa          	endbr64
    1264:	f2 ff 25 fd 3c 00 00 	bnd jmp QWORD PTR [rip+0x3cfd]        # 4f68 <fgets@GLIBC_2.2.5>
    126b:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]

0000000000001270 <calloc@plt>:
    1270:	f3 0f 1e fa          	endbr64
    1274:	f2 ff 25 f5 3c 00 00 	bnd jmp QWORD PTR [rip+0x3cf5]        # 4f70 <calloc@GLIBC_2.2.5>
    127b:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]

0000000000001280 <strcmp@plt>:
    1280:	f3 0f 1e fa          	endbr64
    1284:	f2 ff 25 ed 3c 00 00 	bnd jmp QWORD PTR [rip+0x3ced]        # 4f78 <strcmp@GLIBC_2.2.5>
    128b:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]

0000000000001290 <strtol@plt>:
    1290:	f3 0f 1e fa          	endbr64
    1294:	f2 ff 25 e5 3c 00 00 	bnd jmp QWORD PTR [rip+0x3ce5]        # 4f80 <strtol@GLIBC_2.2.5>
    129b:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]

00000000000012a0 <prctl@plt>:
    12a0:	f3 0f 1e fa          	endbr64
    12a4:	f2 ff 25 dd 3c 00 00 	bnd jmp QWORD PTR [rip+0x3cdd]        # 4f88 <prctl@GLIBC_2.2.5>
    12ab:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]

00000000000012b0 <malloc@plt>:
    12b0:	f3 0f 1e fa          	endbr64
    12b4:	f2 ff 25 d5 3c 00 00 	bnd jmp QWORD PTR [rip+0x3cd5]        # 4f90 <malloc@GLIBC_2.2.5>
    12bb:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]

00000000000012c0 <setrlimit@plt>:
    12c0:	f3 0f 1e fa          	endbr64
    12c4:	f2 ff 25 cd 3c 00 00 	bnd jmp QWORD PTR [rip+0x3ccd]        # 4f98 <setrlimit@GLIBC_2.2.5>
    12cb:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]

00000000000012d0 <__printf_chk@plt>:
    12d0:	f3 0f 1e fa          	endbr64
    12d4:	f2 ff 25 c5 3c 00 00 	bnd jmp QWORD PTR [rip+0x3cc5]        # 4fa0 <__printf_chk@GLIBC_2.3.4>
    12db:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]

00000000000012e0 <setvbuf@plt>:
    12e0:	f3 0f 1e fa          	endbr64
    12e4:	f2 ff 25 bd 3c 00 00 	bnd jmp QWORD PTR [rip+0x3cbd]        # 4fa8 <setvbuf@GLIBC_2.2.5>
    12eb:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]

00000000000012f0 <open@plt>:
    12f0:	f3 0f 1e fa          	endbr64
    12f4:	f2 ff 25 b5 3c 00 00 	bnd jmp QWORD PTR [rip+0x3cb5]        # 4fb0 <open@GLIBC_2.2.5>
    12fb:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]

0000000000001300 <fopen@plt>:
    1300:	f3 0f 1e fa          	endbr64
    1304:	f2 ff 25 ad 3c 00 00 	bnd jmp QWORD PTR [rip+0x3cad]        # 4fb8 <fopen@GLIBC_2.2.5>
    130b:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]

0000000000001310 <perror@plt>:
    1310:	f3 0f 1e fa          	endbr64
    1314:	f2 ff 25 a5 3c 00 00 	bnd jmp QWORD PTR [rip+0x3ca5]        # 4fc0 <perror@GLIBC_2.2.5>
    131b:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]

0000000000001320 <strtok@plt>:
    1320:	f3 0f 1e fa          	endbr64
    1324:	f2 ff 25 9d 3c 00 00 	bnd jmp QWORD PTR [rip+0x3c9d]        # 4fc8 <strtok@GLIBC_2.2.5>
    132b:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]

0000000000001330 <exit@plt>:
    1330:	f3 0f 1e fa          	endbr64
    1334:	f2 ff 25 95 3c 00 00 	bnd jmp QWORD PTR [rip+0x3c95]        # 4fd0 <exit@GLIBC_2.2.5>
    133b:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]

Disassembly of section .text:

0000000000001340 <main>:
    1340:	f3 0f 1e fa          	endbr64
    1344:	55                   	push   rbp
    1345:	31 c9                	xor    ecx,ecx
    1347:	ba 02 00 00 00       	mov    edx,0x2
    134c:	31 f6                	xor    esi,esi
    134e:	48 89 e5             	mov    rbp,rsp
    1351:	41 57                	push   r15
    1353:	41 56                	push   r14
    1355:	41 55                	push   r13
    1357:	4c 8d ad c0 fe ff ff 	lea    r13,[rbp-0x140]
    135e:	41 54                	push   r12
    1360:	53                   	push   rbx
    1361:	48 81 ec b8 01 00 00 	sub    rsp,0x1b8
    1368:	48 8b 3d c1 3c 00 00 	mov    rdi,QWORD PTR [rip+0x3cc1]        # 5030 <stdin@GLIBC_2.2.5>
    136f:	64 48 8b 04 25 28 00 	mov    rax,QWORD PTR fs:0x28
    1376:	00 00 
    1378:	48 89 45 c8          	mov    QWORD PTR [rbp-0x38],rax
    137c:	31 c0                	xor    eax,eax
    137e:	e8 5d ff ff ff       	call   12e0 <setvbuf@plt>
    1383:	48 8b 3d 96 3c 00 00 	mov    rdi,QWORD PTR [rip+0x3c96]        # 5020 <stdout@GLIBC_2.2.5>
    138a:	31 c9                	xor    ecx,ecx
    138c:	31 f6                	xor    esi,esi
    138e:	ba 02 00 00 00       	mov    edx,0x2
    1393:	e8 48 ff ff ff       	call   12e0 <setvbuf@plt>
    1398:	48 8b 3d a1 3c 00 00 	mov    rdi,QWORD PTR [rip+0x3ca1]        # 5040 <stderr@GLIBC_2.2.5>
    139f:	31 c9                	xor    ecx,ecx
    13a1:	31 f6                	xor    esi,esi
    13a3:	ba 02 00 00 00       	mov    edx,0x2
    13a8:	e8 33 ff ff ff       	call   12e0 <setvbuf@plt>
    13ad:	48 8d b5 80 fe ff ff 	lea    rsi,[rbp-0x180]
    13b4:	bf 04 00 00 00       	mov    edi,0x4
    13b9:	48 c7 85 88 fe ff ff 	mov    QWORD PTR [rbp-0x178],0x0
    13c0:	00 00 00 00 
    13c4:	48 c7 85 80 fe ff ff 	mov    QWORD PTR [rbp-0x180],0x0
    13cb:	00 00 00 00 
    13cf:	e8 ec fe ff ff       	call   12c0 <setrlimit@plt>
    13d4:	45 31 c0             	xor    r8d,r8d
    13d7:	31 c9                	xor    ecx,ecx
    13d9:	31 d2                	xor    edx,edx
    13db:	31 f6                	xor    esi,esi
    13dd:	bf 04 00 00 00       	mov    edi,0x4
    13e2:	31 c0                	xor    eax,eax
    13e4:	e8 b7 fe ff ff       	call   12a0 <prctl@plt>
    13e9:	45 31 c0             	xor    r8d,r8d
    13ec:	31 c9                	xor    ecx,ecx
    13ee:	31 d2                	xor    edx,edx
    13f0:	be 01 00 00 00       	mov    esi,0x1
    13f5:	bf 26 00 00 00       	mov    edi,0x26
    13fa:	31 c0                	xor    eax,eax
    13fc:	e8 9f fe ff ff       	call   12a0 <prctl@plt>
    1401:	bf b4 00 00 00       	mov    edi,0xb4
    1406:	e8 25 fe ff ff       	call   1230 <alarm@plt>
    140b:	48 8d 3d 76 1d 00 00 	lea    rdi,[rip+0x1d76]        # 3188 <_IO_stdin_used+0x188>
    1412:	e8 c9 fd ff ff       	call   11e0 <puts@plt>
    1417:	48 8d 3d 35 1c 00 00 	lea    rdi,[rip+0x1c35]        # 3053 <_IO_stdin_used+0x53>
    141e:	e8 5d 0e 00 00       	call   2280 <load_map>
    1423:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]
    1428:	48 8d 35 2a 1c 00 00 	lea    rsi,[rip+0x1c2a]        # 3059 <_IO_stdin_used+0x59>
    142f:	bf 01 00 00 00       	mov    edi,0x1
    1434:	31 c0                	xor    eax,eax
    1436:	e8 95 fe ff ff       	call   12d0 <__printf_chk@plt>
    143b:	48 8b 15 ee 3b 00 00 	mov    rdx,QWORD PTR [rip+0x3bee]        # 5030 <stdin@GLIBC_2.2.5>
    1442:	be 00 01 00 00       	mov    esi,0x100
    1447:	4c 89 ef             	mov    rdi,r13
    144a:	e8 11 fe ff ff       	call   1260 <fgets@plt>
    144f:	48 85 c0             	test   rax,rax
    1452:	0f 84 08 02 00 00    	je     1660 <main+0x320>
    1458:	4c 89 ef             	mov    rdi,r13
    145b:	e8 a0 fd ff ff       	call   1200 <strlen@plt>
    1460:	48 85 c0             	test   rax,rax
    1463:	74 1b                	je     1480 <main+0x140>
    1465:	80 bc 05 bf fe ff ff 	cmp    BYTE PTR [rbp+rax*1-0x141],0xa
    146c:	0a 
    146d:	75 11                	jne    1480 <main+0x140>
    146f:	c6 84 05 bf fe ff ff 	mov    BYTE PTR [rbp+rax*1-0x141],0x0
    1476:	00 
    1477:	66 0f 1f 84 00 00 00 	nop    WORD PTR [rax+rax*1+0x0]
    147e:	00 00 
    1480:	48 8d 35 e4 1b 00 00 	lea    rsi,[rip+0x1be4]        # 306b <_IO_stdin_used+0x6b>
    1487:	4c 89 ef             	mov    rdi,r13
    148a:	e8 91 fe ff ff       	call   1320 <strtok@plt>
    148f:	49 89 c4             	mov    r12,rax
    1492:	48 85 c0             	test   rax,rax
    1495:	74 91                	je     1428 <main+0xe8>
    1497:	48 8d 35 d0 1b 00 00 	lea    rsi,[rip+0x1bd0]        # 306e <_IO_stdin_used+0x6e>
    149e:	48 89 c7             	mov    rdi,rax
    14a1:	e8 da fd ff ff       	call   1280 <strcmp@plt>
    14a6:	85 c0                	test   eax,eax
    14a8:	0f 84 42 01 00 00    	je     15f0 <main+0x2b0>
    14ae:	48 8d 35 be 1b 00 00 	lea    rsi,[rip+0x1bbe]        # 3073 <_IO_stdin_used+0x73>
    14b5:	4c 89 e7             	mov    rdi,r12
    14b8:	e8 c3 fd ff ff       	call   1280 <strcmp@plt>
    14bd:	85 c0                	test   eax,eax
    14bf:	0f 84 8f 01 00 00    	je     1654 <main+0x314>
    14c5:	48 8d 35 b0 1b 00 00 	lea    rsi,[rip+0x1bb0]        # 307c <_IO_stdin_used+0x7c>
    14cc:	4c 89 e7             	mov    rdi,r12
    14cf:	e8 ac fd ff ff       	call   1280 <strcmp@plt>
    14d4:	85 c0                	test   eax,eax
    14d6:	0f 84 2c 01 00 00    	je     1608 <main+0x2c8>
    14dc:	48 8d 35 b0 1b 00 00 	lea    rsi,[rip+0x1bb0]        # 3093 <_IO_stdin_used+0x93>
    14e3:	4c 89 e7             	mov    rdi,r12
    14e6:	e8 95 fd ff ff       	call   1280 <strcmp@plt>
    14eb:	85 c0                	test   eax,eax
    14ed:	0f 84 2d 01 00 00    	je     1620 <main+0x2e0>
    14f3:	48 8d 35 a8 1b 00 00 	lea    rsi,[rip+0x1ba8]        # 30a2 <_IO_stdin_used+0xa2>
    14fa:	4c 89 e7             	mov    rdi,r12
    14fd:	e8 7e fd ff ff       	call   1280 <strcmp@plt>
    1502:	85 c0                	test   eax,eax
    1504:	0f 84 86 01 00 00    	je     1690 <main+0x350>
    150a:	48 8d 35 da 1b 00 00 	lea    rsi,[rip+0x1bda]        # 30eb <_IO_stdin_used+0xeb>
    1511:	4c 89 e7             	mov    rdi,r12
    1514:	e8 67 fd ff ff       	call   1280 <strcmp@plt>
    1519:	89 c3                	mov    ebx,eax
    151b:	85 c0                	test   eax,eax
    151d:	0f 84 f5 04 00 00    	je     1a18 <main+0x6d8>
    1523:	48 8d 35 c8 1b 00 00 	lea    rsi,[rip+0x1bc8]        # 30f2 <_IO_stdin_used+0xf2>
    152a:	4c 89 e7             	mov    rdi,r12
    152d:	e8 4e fd ff ff       	call   1280 <strcmp@plt>
    1532:	89 c3                	mov    ebx,eax
    1534:	85 c0                	test   eax,eax
    1536:	0f 84 79 05 00 00    	je     1ab5 <main+0x775>
    153c:	48 8d 35 c9 1b 00 00 	lea    rsi,[rip+0x1bc9]        # 310c <_IO_stdin_used+0x10c>
    1543:	4c 89 e7             	mov    rdi,r12
    1546:	e8 35 fd ff ff       	call   1280 <strcmp@plt>
    154b:	89 c3                	mov    ebx,eax
    154d:	85 c0                	test   eax,eax
    154f:	0f 84 10 06 00 00    	je     1b65 <main+0x825>
    1555:	48 8d 35 d1 1b 00 00 	lea    rsi,[rip+0x1bd1]        # 312d <_IO_stdin_used+0x12d>
    155c:	4c 89 e7             	mov    rdi,r12
    155f:	e8 1c fd ff ff       	call   1280 <strcmp@plt>
    1564:	89 c3                	mov    ebx,eax
    1566:	85 c0                	test   eax,eax
    1568:	0f 84 aa 06 00 00    	je     1c18 <main+0x8d8>
    156e:	48 8d 35 ce 1b 00 00 	lea    rsi,[rip+0x1bce]        # 3143 <_IO_stdin_used+0x143>
    1575:	4c 89 e7             	mov    rdi,r12
    1578:	e8 03 fd ff ff       	call   1280 <strcmp@plt>
    157d:	89 c3                	mov    ebx,eax
    157f:	85 c0                	test   eax,eax
    1581:	0f 85 80 06 00 00    	jne    1c07 <main+0x8c7>
    1587:	31 ff                	xor    edi,edi
    1589:	48 8d 35 db 1a 00 00 	lea    rsi,[rip+0x1adb]        # 306b <_IO_stdin_used+0x6b>
    1590:	e8 8b fd ff ff       	call   1320 <strtok@plt>
    1595:	48 89 c7             	mov    rdi,rax
    1598:	48 85 c0             	test   rax,rax
    159b:	0f 84 9f 04 00 00    	je     1a40 <main+0x700>
    15a1:	ba 0a 00 00 00       	mov    edx,0xa
    15a6:	31 f6                	xor    esi,esi
    15a8:	e8 e3 fc ff ff       	call   1290 <strtol@plt>
    15ad:	8b 0d ad 3a 00 00    	mov    ecx,DWORD PTR [rip+0x3aad]        # 5060 <ORD_N>
    15b3:	85 c9                	test   ecx,ecx
    15b5:	7e 26                	jle    15dd <main+0x29d>
    15b7:	48 8d 15 c2 3a 00 00 	lea    rdx,[rip+0x3ac2]        # 5080 <ORD>
    15be:	66 90                	xchg   ax,ax
    15c0:	8b 72 10             	mov    esi,DWORD PTR [rdx+0x10]
    15c3:	85 f6                	test   esi,esi
    15c5:	74 08                	je     15cf <main+0x28f>
    15c7:	3b 02                	cmp    eax,DWORD PTR [rdx]
    15c9:	0f 84 7b 0a 00 00    	je     204a <main+0xd0a>
    15cf:	83 c3 01             	add    ebx,0x1
    15d2:	48 81 c2 38 10 00 00 	add    rdx,0x1038
    15d9:	39 d9                	cmp    ecx,ebx
    15db:	75 e3                	jne    15c0 <main+0x280>
    15dd:	48 8d 3d 69 1b 00 00 	lea    rdi,[rip+0x1b69]        # 314d <_IO_stdin_used+0x14d>
    15e4:	e8 f7 fb ff ff       	call   11e0 <puts@plt>
    15e9:	e9 3a fe ff ff       	jmp    1428 <main+0xe8>
    15ee:	66 90                	xchg   ax,ax
    15f0:	48 8d 3d b9 1b 00 00 	lea    rdi,[rip+0x1bb9]        # 31b0 <_IO_stdin_used+0x1b0>
    15f7:	e8 e4 fb ff ff       	call   11e0 <puts@plt>
    15fc:	e9 27 fe ff ff       	jmp    1428 <main+0xe8>
    1601:	0f 1f 80 00 00 00 00 	nop    DWORD PTR [rax+0x0]
    1608:	48 8d 3d 72 1a 00 00 	lea    rdi,[rip+0x1a72]        # 3081 <_IO_stdin_used+0x81>
    160f:	e8 cc fb ff ff       	call   11e0 <puts@plt>
    1614:	e9 0f fe ff ff       	jmp    1428 <main+0xe8>
    1619:	0f 1f 80 00 00 00 00 	nop    DWORD PTR [rax+0x0]
    1620:	31 ff                	xor    edi,edi
    1622:	48 8d 35 42 1a 00 00 	lea    rsi,[rip+0x1a42]        # 306b <_IO_stdin_used+0x6b>
    1629:	e8 f2 fc ff ff       	call   1320 <strtok@plt>
    162e:	48 89 c7             	mov    rdi,rax
    1631:	48 85 c0             	test   rax,rax
    1634:	74 0d                	je     1643 <main+0x303>
    1636:	e8 45 0c 00 00       	call   2280 <load_map>
    163b:	85 c0                	test   eax,eax
    163d:	0f 84 11 05 00 00    	je     1b54 <main+0x814>
    1643:	48 8d 3d 51 1a 00 00 	lea    rdi,[rip+0x1a51]        # 309b <_IO_stdin_used+0x9b>
    164a:	e8 91 fb ff ff       	call   11e0 <puts@plt>
    164f:	e9 d4 fd ff ff       	jmp    1428 <main+0xe8>
    1654:	48 8d 3d 1d 1a 00 00 	lea    rdi,[rip+0x1a1d]        # 3078 <_IO_stdin_used+0x78>
    165b:	e8 80 fb ff ff       	call   11e0 <puts@plt>
    1660:	48 8b 45 c8          	mov    rax,QWORD PTR [rbp-0x38]
    1664:	64 48 2b 04 25 28 00 	sub    rax,QWORD PTR fs:0x28
    166b:	00 00 
    166d:	0f 85 e3 0a 00 00    	jne    2156 <main+0xe16>
    1673:	48 81 c4 b8 01 00 00 	add    rsp,0x1b8
    167a:	31 c0                	xor    eax,eax
    167c:	5b                   	pop    rbx
    167d:	41 5c                	pop    r12
    167f:	41 5d                	pop    r13
    1681:	41 5e                	pop    r14
    1683:	41 5f                	pop    r15
    1685:	5d                   	pop    rbp
    1686:	c3                   	ret
    1687:	66 0f 1f 84 00 00 00 	nop    WORD PTR [rax+rax*1+0x0]
    168e:	00 00 
    1690:	48 8d 35 d4 19 00 00 	lea    rsi,[rip+0x19d4]        # 306b <_IO_stdin_used+0x6b>
    1697:	31 ff                	xor    edi,edi
    1699:	e8 82 fc ff ff       	call   1320 <strtok@plt>
    169e:	48 8d 35 c6 19 00 00 	lea    rsi,[rip+0x19c6]        # 306b <_IO_stdin_used+0x6b>
    16a5:	31 ff                	xor    edi,edi
    16a7:	49 89 c4             	mov    r12,rax
    16aa:	e8 71 fc ff ff       	call   1320 <strtok@plt>
    16af:	49 89 c6             	mov    r14,rax
    16b2:	4d 85 e4             	test   r12,r12
    16b5:	0f 84 85 03 00 00    	je     1a40 <main+0x700>
    16bb:	48 85 c0             	test   rax,rax
    16be:	0f 84 7c 03 00 00    	je     1a40 <main+0x700>
    16c4:	31 f6                	xor    esi,esi
    16c6:	4c 89 e7             	mov    rdi,r12
    16c9:	ba 0a 00 00 00       	mov    edx,0xa
    16ce:	e8 bd fb ff ff       	call   1290 <strtol@plt>
    16d3:	31 f6                	xor    esi,esi
    16d5:	ba 0a 00 00 00       	mov    edx,0xa
    16da:	4c 89 f7             	mov    rdi,r14
    16dd:	49 89 c4             	mov    r12,rax
    16e0:	89 85 3c fe ff ff    	mov    DWORD PTR [rbp-0x1c4],eax
    16e6:	e8 a5 fb ff ff       	call   1290 <strtol@plt>
    16eb:	89 c3                	mov    ebx,eax
    16ed:	48 89 85 40 fe ff ff 	mov    QWORD PTR [rbp-0x1c0],rax
    16f4:	44 09 e3             	or     ebx,r12d
    16f7:	0f 88 a7 03 00 00    	js     1aa4 <main+0x764>
    16fd:	8b 1d 7d 40 02 00    	mov    ebx,DWORD PTR [rip+0x2407d]        # 25780 <G>
    1703:	41 39 dc             	cmp    r12d,ebx
    1706:	0f 8d 98 03 00 00    	jge    1aa4 <main+0x764>
    170c:	8b 0d 72 40 02 00    	mov    ecx,DWORD PTR [rip+0x24072]        # 25784 <G+0x4>
    1712:	89 8d 7c fe ff ff    	mov    DWORD PTR [rbp-0x184],ecx
    1718:	39 c8                	cmp    eax,ecx
    171a:	0f 8d 84 03 00 00    	jge    1aa4 <main+0x764>
    1720:	48 98                	cdqe
    1722:	48 8d 0d 57 40 02 00 	lea    rcx,[rip+0x24057]        # 25780 <G>
    1729:	49 63 d4             	movsxd rdx,r12d
    172c:	48 c1 e0 05          	shl    rax,0x5
    1730:	48 01 c8             	add    rax,rcx
    1733:	80 7c 02 08 23       	cmp    BYTE PTR [rdx+rax*1+0x8],0x23
    1738:	0f 84 66 03 00 00    	je     1aa4 <main+0x764>
    173e:	8b 05 1c 39 00 00    	mov    eax,DWORD PTR [rip+0x391c]        # 5060 <ORD_N>
    1744:	89 85 48 fe ff ff    	mov    DWORD PTR [rbp-0x1b8],eax
    174a:	83 f8 1f             	cmp    eax,0x1f
    174d:	0f 8f e6 08 00 00    	jg     2039 <main+0xcf9>
    1753:	48 63 85 48 fe ff ff 	movsxd rax,DWORD PTR [rbp-0x1b8]
    175a:	48 8d 15 1f 39 00 00 	lea    rdx,[rip+0x391f]        # 5080 <ORD>
    1761:	b9 07 02 00 00       	mov    ecx,0x207
    1766:	48 89 c6             	mov    rsi,rax
    1769:	48 89 85 50 fe ff ff 	mov    QWORD PTR [rbp-0x1b0],rax
    1770:	48 69 c0 38 10 00 00 	imul   rax,rax,0x1038
    1777:	48 01 c2             	add    rdx,rax
    177a:	48 89 85 28 fe ff ff 	mov    QWORD PTR [rbp-0x1d8],rax
    1781:	31 c0                	xor    eax,eax
    1783:	48 89 d7             	mov    rdi,rdx
    1786:	f3 48 ab             	rep stos QWORD PTR [rdi],rax
    1789:	48 8b 8d 40 fe ff ff 	mov    rcx,QWORD PTR [rbp-0x1c0]
    1790:	b8 01 00 00 00       	mov    eax,0x1
    1795:	89 32                	mov    DWORD PTR [rdx],esi
    1797:	48 c1 e0 20          	shl    rax,0x20
    179b:	44 89 62 04          	mov    DWORD PTR [rdx+0x4],r12d
    179f:	be 04 00 00 00       	mov    esi,0x4
    17a4:	89 4a 08             	mov    DWORD PTR [rdx+0x8],ecx
    17a7:	48 89 42 0c          	mov    QWORD PTR [rdx+0xc],rax
    17ab:	8b 95 7c fe ff ff    	mov    edx,DWORD PTR [rbp-0x184]
    17b1:	8b 05 d5 43 02 00    	mov    eax,DWORD PTR [rip+0x243d5]        # 25b8c <G+0x40c>
    17b7:	0f af d3             	imul   edx,ebx
    17ba:	0f af c3             	imul   eax,ebx
    17bd:	03 05 c5 43 02 00    	add    eax,DWORD PTR [rip+0x243c5]        # 25b88 <G+0x408>
    17c3:	89 85 4c fe ff ff    	mov    DWORD PTR [rbp-0x1b4],eax
    17c9:	89 c8                	mov    eax,ecx
    17cb:	0f af c3             	imul   eax,ebx
    17ce:	4c 63 f2             	movsxd r14,edx
    17d1:	89 95 68 fe ff ff    	mov    DWORD PTR [rbp-0x198],edx
    17d7:	4c 89 f7             	mov    rdi,r14
    17da:	49 c1 e6 02          	shl    r14,0x2
    17de:	41 01 c4             	add    r12d,eax
    17e1:	e8 8a fa ff ff       	call   1270 <calloc@plt>
    17e6:	4c 89 f7             	mov    rdi,r14
    17e9:	49 89 c7             	mov    r15,rax
    17ec:	e8 bf fa ff ff       	call   12b0 <malloc@plt>
    17f1:	8b 95 68 fe ff ff    	mov    edx,DWORD PTR [rbp-0x198]
    17f7:	48 89 85 70 fe ff ff 	mov    QWORD PTR [rbp-0x190],rax
    17fe:	85 d2                	test   edx,edx
    1800:	7e 24                	jle    1826 <main+0x4e6>
    1802:	4c 89 f2             	mov    rdx,r14
    1805:	be 3f 00 00 00       	mov    esi,0x3f
    180a:	4c 89 ff             	mov    rdi,r15
    180d:	e8 0e fa ff ff       	call   1220 <memset@plt>
    1812:	48 8b bd 70 fe ff ff 	mov    rdi,QWORD PTR [rbp-0x190]
    1819:	4c 89 f2             	mov    rdx,r14
    181c:	be ff 00 00 00       	mov    esi,0xff
    1821:	e8 fa f9 ff ff       	call   1220 <memset@plt>
    1826:	48 63 85 4c fe ff ff 	movsxd rax,DWORD PTR [rbp-0x1b4]
    182d:	be 01 00 00 00       	mov    esi,0x1
    1832:	bf 40 04 00 00       	mov    edi,0x440
    1837:	41 c7 04 87 00 00 00 	mov    DWORD PTR [r15+rax*4],0x0
    183e:	00 
    183f:	e8 2c fa ff ff       	call   1270 <calloc@plt>
    1844:	48 89 85 68 fe ff ff 	mov    QWORD PTR [rbp-0x198],rax
    184b:	48 85 c0             	test   rax,rax
    184e:	0f 84 ec 08 00 00    	je     2140 <main+0xe00>
    1854:	48 8b 95 68 fe ff ff 	mov    rdx,QWORD PTR [rbp-0x198]
    185b:	48 8d 35 1e 38 00 00 	lea    rsi,[rip+0x381e]        # 5080 <ORD>
    1862:	44 89 a5 78 fe ff ff 	mov    DWORD PTR [rbp-0x188],r12d
    1869:	41 bb 01 00 00 00    	mov    r11d,0x1
    186f:	4c 89 ad 30 fe ff ff 	mov    QWORD PTR [rbp-0x1d0],r13
    1876:	48 8d 82 20 04 00 00 	lea    rax,[rdx+0x420]
    187d:	48 8d 4a 18          	lea    rcx,[rdx+0x18]
    1881:	c7 02 80 00 00 00    	mov    DWORD PTR [rdx],0x80
    1887:	48 89 42 10          	mov    QWORD PTR [rdx+0x10],rax
    188b:	48 8d 05 de 09 00 00 	lea    rax,[rip+0x9de]        # 2270 <fx_finish_dummy>
    1892:	48 89 82 30 04 00 00 	mov    QWORD PTR [rdx+0x430],rax
    1899:	48 8d 05 c0 09 00 00 	lea    rax,[rip+0x9c0]        # 2260 <fx_draw_basic>
    18a0:	48 89 82 38 04 00 00 	mov    QWORD PTR [rdx+0x438],rax
    18a7:	48 69 85 50 fe ff ff 	imul   rax,QWORD PTR [rbp-0x1b0],0x1038
    18ae:	38 10 00 00 
    18b2:	48 89 4a 08          	mov    QWORD PTR [rdx+0x8],rcx
    18b6:	48 c7 82 20 04 00 00 	mov    QWORD PTR [rdx+0x420],0x6e6f656e
    18bd:	6e 65 6f 6e 
    18c1:	48 c7 82 28 04 00 00 	mov    QWORD PTR [rdx+0x428],0x0
    18c8:	00 00 00 00 
    18cc:	48 01 f0             	add    rax,rsi
    18cf:	48 89 90 28 10 00 00 	mov    QWORD PTR [rax+0x1028],rdx
    18d6:	48 89 90 30 10 00 00 	mov    QWORD PTR [rax+0x1030],rdx
    18dd:	8b 85 4c fe ff ff    	mov    eax,DWORD PTR [rbp-0x1b4]
    18e3:	89 42 20             	mov    DWORD PTR [rdx+0x20],eax
    18e6:	48 8d 85 94 fe ff ff 	lea    rax,[rbp-0x16c]
    18ed:	48 89 85 58 fe ff ff 	mov    QWORD PTR [rbp-0x1a8],rax
    18f4:	0f 1f 40 00          	nop    DWORD PTR [rax+0x0]
    18f8:	45 8d 43 ff          	lea    r8d,[r11-0x1]
    18fc:	4d 63 db             	movsxd r11,r11d
    18ff:	48 8b 95 68 fe ff ff 	mov    rdx,QWORD PTR [rbp-0x198]
    1906:	4a 8b 04 d9          	mov    rax,QWORD PTR [rcx+r11*8]
    190a:	44 8b 62 20          	mov    r12d,DWORD PTR [rdx+0x20]
    190e:	44 89 42 04          	mov    DWORD PTR [rdx+0x4],r8d
    1912:	48 89 42 20          	mov    QWORD PTR [rdx+0x20],rax
    1916:	ba 01 00 00 00       	mov    edx,0x1
    191b:	eb 3d                	jmp    195a <main+0x61a>
    191d:	0f 1f 00             	nop    DWORD PTR [rax]
    1920:	48 63 fa             	movsxd rdi,edx
    1923:	4c 63 ce             	movsxd r9,esi
    1926:	44 8b 74 f9 04       	mov    r14d,DWORD PTR [rcx+rdi*8+0x4]
    192b:	46 39 74 c9 04       	cmp    DWORD PTR [rcx+r9*8+0x4],r14d
    1930:	7d 33                	jge    1965 <main+0x625>
    1932:	41 39 c0             	cmp    r8d,eax
    1935:	0f 8d 20 08 00 00    	jge    215b <main+0xe1b>
    193b:	89 f0                	mov    eax,esi
    193d:	39 c2                	cmp    edx,eax
    193f:	74 3f                	je     1980 <main+0x640>
    1941:	48 63 d0             	movsxd rdx,eax
    1944:	48 8d 34 f9          	lea    rsi,[rcx+rdi*8]
    1948:	48 8d 14 d1          	lea    rdx,[rcx+rdx*8]
    194c:	48 8b 3e             	mov    rdi,QWORD PTR [rsi]
    194f:	4c 8b 0a             	mov    r9,QWORD PTR [rdx]
    1952:	4c 89 0e             	mov    QWORD PTR [rsi],r9
    1955:	48 89 3a             	mov    QWORD PTR [rdx],rdi
    1958:	89 c2                	mov    edx,eax
    195a:	8d 34 12             	lea    esi,[rdx+rdx*1]
    195d:	8d 46 01             	lea    eax,[rsi+0x1]
    1960:	41 39 f0             	cmp    r8d,esi
    1963:	7d bb                	jge    1920 <main+0x5e0>
    1965:	41 39 c0             	cmp    r8d,eax
    1968:	7c 16                	jl     1980 <main+0x640>
    196a:	48 63 fa             	movsxd rdi,edx
    196d:	48 63 f0             	movsxd rsi,eax
    1970:	44 8b 74 f9 04       	mov    r14d,DWORD PTR [rcx+rdi*8+0x4]
    1975:	44 39 74 f1 04       	cmp    DWORD PTR [rcx+rsi*8+0x4],r14d
    197a:	7c c1                	jl     193d <main+0x5fd>
    197c:	0f 1f 40 00          	nop    DWORD PTR [rax+0x0]
    1980:	44 39 a5 78 fe ff ff 	cmp    DWORD PTR [rbp-0x188],r12d
    1987:	0f 84 8d 03 00 00    	je     1d1a <main+0x9da>
    198d:	44 89 e0             	mov    eax,r12d
    1990:	31 f6                	xor    esi,esi
    1992:	45 31 db             	xor    r11d,r11d
    1995:	45 31 d2             	xor    r10d,r10d
    1998:	99                   	cdq
    1999:	48 bf 01 00 00 00 ff 	movabs rdi,0xffffffff00000001
    19a0:	ff ff ff 
    19a3:	c7 85 a4 fe ff ff ff 	mov    DWORD PTR [rbp-0x15c],0xffffffff
    19aa:	ff ff ff 
    19ad:	41 b9 01 00 00 00    	mov    r9d,0x1
    19b3:	f7 fb                	idiv   ebx
    19b5:	48 89 bd b8 fe ff ff 	mov    QWORD PTR [rbp-0x148],rdi
    19bc:	48 c7 85 a8 fe ff ff 	mov    QWORD PTR [rbp-0x158],0x0
    19c3:	00 00 00 00 
    19c7:	c7 85 b4 fe ff ff 00 	mov    DWORD PTR [rbp-0x14c],0x0
    19ce:	00 00 00 
    19d1:	41 01 d1             	add    r9d,edx
    19d4:	01 c6                	add    esi,eax
    19d6:	44 89 cf             	mov    edi,r9d
    19d9:	09 f7                	or     edi,esi
    19db:	f7 d7                	not    edi
    19dd:	c1 ef 1f             	shr    edi,0x1f
    19e0:	44 39 cb             	cmp    ebx,r9d
    19e3:	41 0f 9f c5          	setg   r13b
    19e7:	41 84 fd             	test   r13b,dil
    19ea:	74 0c                	je     19f8 <main+0x6b8>
    19ec:	39 b5 7c fe ff ff    	cmp    DWORD PTR [rbp-0x184],esi
    19f2:	0f 8f 88 02 00 00    	jg     1c80 <main+0x940>
    19f8:	49 83 c2 04          	add    r10,0x4
    19fc:	49 83 fa 10          	cmp    r10,0x10
    1a00:	0f 84 bc 02 00 00    	je     1cc2 <main+0x982>
    1a06:	46 8b 8c 15 a0 fe ff 	mov    r9d,DWORD PTR [rbp+r10*1-0x160]
    1a0d:	ff 
    1a0e:	42 8b b4 15 b0 fe ff 	mov    esi,DWORD PTR [rbp+r10*1-0x150]
    1a15:	ff 
    1a16:	eb b9                	jmp    19d1 <main+0x691>
    1a18:	48 8d 35 4c 16 00 00 	lea    rsi,[rip+0x164c]        # 306b <_IO_stdin_used+0x6b>
    1a1f:	31 ff                	xor    edi,edi
    1a21:	e8 fa f8 ff ff       	call   1320 <strtok@plt>
    1a26:	48 8d 35 3e 16 00 00 	lea    rsi,[rip+0x163e]        # 306b <_IO_stdin_used+0x6b>
    1a2d:	31 ff                	xor    edi,edi
    1a2f:	49 89 c4             	mov    r12,rax
    1a32:	e8 e9 f8 ff ff       	call   1320 <strtok@plt>
    1a37:	49 89 c6             	mov    r14,rax
    1a3a:	4d 85 e4             	test   r12,r12
    1a3d:	75 12                	jne    1a51 <main+0x711>
    1a3f:	90                   	nop
    1a40:	48 8d 3d 9e 16 00 00 	lea    rdi,[rip+0x169e]        # 30e5 <_IO_stdin_used+0xe5>
    1a47:	e8 94 f7 ff ff       	call   11e0 <puts@plt>
    1a4c:	e9 d7 f9 ff ff       	jmp    1428 <main+0xe8>
    1a51:	48 85 c0             	test   rax,rax
    1a54:	74 ea                	je     1a40 <main+0x700>
    1a56:	ba 0a 00 00 00       	mov    edx,0xa
    1a5b:	31 f6                	xor    esi,esi
    1a5d:	4c 89 e7             	mov    rdi,r12
    1a60:	e8 2b f8 ff ff       	call   1290 <strtol@plt>
    1a65:	8b 0d f5 35 00 00    	mov    ecx,DWORD PTR [rip+0x35f5]        # 5060 <ORD_N>
    1a6b:	85 c9                	test   ecx,ecx
    1a6d:	0f 8e 6a fb ff ff    	jle    15dd <main+0x29d>
    1a73:	48 8d 15 06 36 00 00 	lea    rdx,[rip+0x3606]        # 5080 <ORD>
    1a7a:	66 0f 1f 44 00 00    	nop    WORD PTR [rax+rax*1+0x0]
    1a80:	44 8b 52 10          	mov    r10d,DWORD PTR [rdx+0x10]
    1a84:	45 85 d2             	test   r10d,r10d
    1a87:	74 08                	je     1a91 <main+0x751>
    1a89:	3b 02                	cmp    eax,DWORD PTR [rdx]
    1a8b:	0f 84 33 01 00 00    	je     1bc4 <main+0x884>
    1a91:	83 c3 01             	add    ebx,0x1
    1a94:	48 81 c2 38 10 00 00 	add    rdx,0x1038
    1a9b:	39 cb                	cmp    ebx,ecx
    1a9d:	75 e1                	jne    1a80 <main+0x740>
    1a9f:	e9 39 fb ff ff       	jmp    15dd <main+0x29d>
    1aa4:	48 8d 3d 01 16 00 00 	lea    rdi,[rip+0x1601]        # 30ac <_IO_stdin_used+0xac>
    1aab:	e8 30 f7 ff ff       	call   11e0 <puts@plt>
    1ab0:	e9 73 f9 ff ff       	jmp    1428 <main+0xe8>
    1ab5:	31 ff                	xor    edi,edi
    1ab7:	48 8d 35 ad 15 00 00 	lea    rsi,[rip+0x15ad]        # 306b <_IO_stdin_used+0x6b>
    1abe:	e8 5d f8 ff ff       	call   1320 <strtok@plt>
    1ac3:	31 ff                	xor    edi,edi
    1ac5:	48 8d 35 9f 15 00 00 	lea    rsi,[rip+0x159f]        # 306b <_IO_stdin_used+0x6b>
    1acc:	49 89 c7             	mov    r15,rax
    1acf:	e8 4c f8 ff ff       	call   1320 <strtok@plt>
    1ad4:	31 ff                	xor    edi,edi
    1ad6:	48 8d 35 8e 15 00 00 	lea    rsi,[rip+0x158e]        # 306b <_IO_stdin_used+0x6b>
    1add:	49 89 c4             	mov    r12,rax
    1ae0:	e8 3b f8 ff ff       	call   1320 <strtok@plt>
    1ae5:	4d 85 ff             	test   r15,r15
    1ae8:	0f 95 c2             	setne  dl
    1aeb:	4d 85 e4             	test   r12,r12
    1aee:	49 89 c6             	mov    r14,rax
    1af1:	0f 95 c0             	setne  al
    1af4:	84 c2                	test   dl,al
    1af6:	0f 84 44 ff ff ff    	je     1a40 <main+0x700>
    1afc:	4d 85 f6             	test   r14,r14
    1aff:	0f 84 3b ff ff ff    	je     1a40 <main+0x700>
    1b05:	ba 0a 00 00 00       	mov    edx,0xa
    1b0a:	31 f6                	xor    esi,esi
    1b0c:	4c 89 ff             	mov    rdi,r15
    1b0f:	e8 7c f7 ff ff       	call   1290 <strtol@plt>
    1b14:	8b 0d 46 35 00 00    	mov    ecx,DWORD PTR [rip+0x3546]        # 5060 <ORD_N>
    1b1a:	85 c9                	test   ecx,ecx
    1b1c:	0f 8e bb fa ff ff    	jle    15dd <main+0x29d>
    1b22:	48 8d 15 57 35 00 00 	lea    rdx,[rip+0x3557]        # 5080 <ORD>
    1b29:	0f 1f 80 00 00 00 00 	nop    DWORD PTR [rax+0x0]
    1b30:	44 8b 4a 10          	mov    r9d,DWORD PTR [rdx+0x10]
    1b34:	45 85 c9             	test   r9d,r9d
    1b37:	74 08                	je     1b41 <main+0x801>
    1b39:	3b 02                	cmp    eax,DWORD PTR [rdx]
    1b3b:	0f 84 42 04 00 00    	je     1f83 <main+0xc43>
    1b41:	83 c3 01             	add    ebx,0x1
    1b44:	48 81 c2 38 10 00 00 	add    rdx,0x1038
    1b4b:	39 d9                	cmp    ecx,ebx
    1b4d:	75 e1                	jne    1b30 <main+0x7f0>
    1b4f:	e9 89 fa ff ff       	jmp    15dd <main+0x29d>
    1b54:	48 8d 3d 3d 15 00 00 	lea    rdi,[rip+0x153d]        # 3098 <_IO_stdin_used+0x98>
    1b5b:	e8 80 f6 ff ff       	call   11e0 <puts@plt>
    1b60:	e9 c3 f8 ff ff       	jmp    1428 <main+0xe8>
    1b65:	31 ff                	xor    edi,edi
    1b67:	48 8d 35 fd 14 00 00 	lea    rsi,[rip+0x14fd]        # 306b <_IO_stdin_used+0x6b>
    1b6e:	e8 ad f7 ff ff       	call   1320 <strtok@plt>
    1b73:	48 89 c7             	mov    rdi,rax
    1b76:	48 85 c0             	test   rax,rax
    1b79:	0f 84 c1 fe ff ff    	je     1a40 <main+0x700>
    1b7f:	ba 0a 00 00 00       	mov    edx,0xa
    1b84:	31 f6                	xor    esi,esi
    1b86:	e8 05 f7 ff ff       	call   1290 <strtol@plt>
    1b8b:	8b 0d cf 34 00 00    	mov    ecx,DWORD PTR [rip+0x34cf]        # 5060 <ORD_N>
    1b91:	85 c9                	test   ecx,ecx
    1b93:	0f 8e 44 fa ff ff    	jle    15dd <main+0x29d>
    1b99:	48 8d 15 e0 34 00 00 	lea    rdx,[rip+0x34e0]        # 5080 <ORD>
    1ba0:	44 8b 42 10          	mov    r8d,DWORD PTR [rdx+0x10]
    1ba4:	45 85 c0             	test   r8d,r8d
    1ba7:	74 08                	je     1bb1 <main+0x871>
    1ba9:	3b 02                	cmp    eax,DWORD PTR [rdx]
    1bab:	0f 84 03 03 00 00    	je     1eb4 <main+0xb74>
    1bb1:	83 c3 01             	add    ebx,0x1
    1bb4:	48 81 c2 38 10 00 00 	add    rdx,0x1038
    1bbb:	39 d9                	cmp    ecx,ebx
    1bbd:	75 e1                	jne    1ba0 <main+0x860>
    1bbf:	e9 19 fa ff ff       	jmp    15dd <main+0x29d>
    1bc4:	31 f6                	xor    esi,esi
    1bc6:	4c 89 f7             	mov    rdi,r14
    1bc9:	ba 0a 00 00 00       	mov    edx,0xa
    1bce:	e8 bd f6 ff ff       	call   1290 <strtol@plt>
    1bd3:	48 63 cb             	movsxd rcx,ebx
    1bd6:	bf 01 00 00 00       	mov    edi,0x1
    1bdb:	48 8d 1d 9e 34 00 00 	lea    rbx,[rip+0x349e]        # 5080 <ORD>
    1be2:	48 69 c9 38 10 00 00 	imul   rcx,rcx,0x1038
    1be9:	48 8d 35 68 16 00 00 	lea    rsi,[rip+0x1668]        # 3258 <_IO_stdin_used+0x258>
    1bf0:	48 01 d9             	add    rcx,rbx
    1bf3:	8b 51 0c             	mov    edx,DWORD PTR [rcx+0xc]
    1bf6:	01 c2                	add    edx,eax
    1bf8:	31 c0                	xor    eax,eax
    1bfa:	89 51 0c             	mov    DWORD PTR [rcx+0xc],edx
    1bfd:	e8 ce f6 ff ff       	call   12d0 <__printf_chk@plt>
    1c02:	e9 21 f8 ff ff       	jmp    1428 <main+0xe8>
    1c07:	48 8d 3d 3d 15 00 00 	lea    rdi,[rip+0x153d]        # 314b <_IO_stdin_used+0x14b>
    1c0e:	e8 cd f5 ff ff       	call   11e0 <puts@plt>
    1c13:	e9 10 f8 ff ff       	jmp    1428 <main+0xe8>
    1c18:	31 ff                	xor    edi,edi
    1c1a:	48 8d 35 4a 14 00 00 	lea    rsi,[rip+0x144a]        # 306b <_IO_stdin_used+0x6b>
    1c21:	e8 fa f6 ff ff       	call   1320 <strtok@plt>
    1c26:	48 89 c7             	mov    rdi,rax
    1c29:	48 85 c0             	test   rax,rax
    1c2c:	0f 84 0e fe ff ff    	je     1a40 <main+0x700>
    1c32:	ba 0a 00 00 00       	mov    edx,0xa
    1c37:	31 f6                	xor    esi,esi
    1c39:	e8 52 f6 ff ff       	call   1290 <strtol@plt>
    1c3e:	8b 0d 1c 34 00 00    	mov    ecx,DWORD PTR [rip+0x341c]        # 5060 <ORD_N>
    1c44:	85 c9                	test   ecx,ecx
    1c46:	0f 8e 91 f9 ff ff    	jle    15dd <main+0x29d>
    1c4c:	48 8d 15 2d 34 00 00 	lea    rdx,[rip+0x342d]        # 5080 <ORD>
    1c53:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]
    1c58:	8b 7a 10             	mov    edi,DWORD PTR [rdx+0x10]
    1c5b:	85 ff                	test   edi,edi
    1c5d:	74 08                	je     1c67 <main+0x927>
    1c5f:	3b 02                	cmp    eax,DWORD PTR [rdx]
    1c61:	0f 84 25 04 00 00    	je     208c <main+0xd4c>
    1c67:	83 c3 01             	add    ebx,0x1
    1c6a:	48 81 c2 38 10 00 00 	add    rdx,0x1038
    1c71:	39 d9                	cmp    ecx,ebx
    1c73:	75 e3                	jne    1c58 <main+0x918>
    1c75:	e9 63 f9 ff ff       	jmp    15dd <main+0x29d>
    1c7a:	66 0f 1f 44 00 00    	nop    WORD PTR [rax+rax*1+0x0]
    1c80:	48 63 fe             	movsxd rdi,esi
    1c83:	4c 8d 35 f6 3a 02 00 	lea    r14,[rip+0x23af6]        # 25780 <G>
    1c8a:	4d 63 e9             	movsxd r13,r9d
    1c8d:	48 c1 e7 05          	shl    rdi,0x5
    1c91:	4c 01 f7             	add    rdi,r14
    1c94:	41 80 7c 3d 08 23    	cmp    BYTE PTR [r13+rdi*1+0x8],0x23
    1c9a:	0f 84 58 fd ff ff    	je     19f8 <main+0x6b8>
    1ca0:	0f af f3             	imul   esi,ebx
    1ca3:	49 63 fb             	movsxd rdi,r11d
    1ca6:	49 83 c2 04          	add    r10,0x4
    1caa:	41 83 c3 01          	add    r11d,0x1
    1cae:	44 01 ce             	add    esi,r9d
    1cb1:	89 b4 bd 90 fe ff ff 	mov    DWORD PTR [rbp+rdi*4-0x170],esi
    1cb8:	49 83 fa 10          	cmp    r10,0x10
    1cbc:	0f 85 44 fd ff ff    	jne    1a06 <main+0x6c6>
    1cc2:	45 85 db             	test   r11d,r11d
    1cc5:	0f 84 e1 01 00 00    	je     1eac <main+0xb6c>
    1ccb:	49 63 c4             	movsxd rax,r12d
    1cce:	48 8b 95 58 fe ff ff 	mov    rdx,QWORD PTR [rbp-0x1a8]
    1cd5:	48 8d bd 90 fe ff ff 	lea    rdi,[rbp-0x170]
    1cdc:	4d 8d 34 87          	lea    r14,[r15+rax*4]
    1ce0:	41 8d 43 ff          	lea    eax,[r11-0x1]
    1ce4:	45 89 c3             	mov    r11d,r8d
    1ce7:	4c 8d 2c 82          	lea    r13,[rdx+rax*4]
    1ceb:	48 63 17             	movsxd rdx,DWORD PTR [rdi]
    1cee:	49 63 06             	movsxd rax,DWORD PTR [r14]
    1cf1:	49 8d 34 97          	lea    rsi,[r15+rdx*4]
    1cf5:	48 83 c0 01          	add    rax,0x1
    1cf9:	49 89 d0             	mov    r8,rdx
    1cfc:	4c 63 0e             	movsxd r9,DWORD PTR [rsi]
    1cff:	4c 39 c8             	cmp    rax,r9
    1d02:	0f 8c 20 01 00 00    	jl     1e28 <main+0xae8>
    1d08:	48 83 c7 04          	add    rdi,0x4
    1d0c:	49 39 fd             	cmp    r13,rdi
    1d0f:	75 da                	jne    1ceb <main+0x9ab>
    1d11:	45 85 db             	test   r11d,r11d
    1d14:	0f 85 de fb ff ff    	jne    18f8 <main+0x5b8>
    1d1a:	4c 63 a5 78 fe ff ff 	movsxd r12,DWORD PTR [rbp-0x188]
    1d21:	48 8d 0d 58 33 00 00 	lea    rcx,[rip+0x3358]        # 5080 <ORD>
    1d28:	4c 8b ad 30 fe ff ff 	mov    r13,QWORD PTR [rbp-0x1d0]
    1d2f:	48 69 85 50 fe ff ff 	imul   rax,QWORD PTR [rbp-0x1b0],0x1038
    1d36:	38 10 00 00 
    1d3a:	c7 84 01 18 10 00 00 	mov    DWORD PTR [rcx+rax*1+0x1018],0x0
    1d41:	00 00 00 00 
    1d45:	41 83 fc ff          	cmp    r12d,0xffffffff
    1d49:	74 73                	je     1dbe <main+0xa7e>
    1d4b:	48 89 c8             	mov    rax,rcx
    1d4e:	48 8b 8d 28 fe ff ff 	mov    rcx,QWORD PTR [rbp-0x1d8]
    1d55:	44 8b 85 4c fe ff ff 	mov    r8d,DWORD PTR [rbp-0x1b4]
    1d5c:	4c 8b 8d 70 fe ff ff 	mov    r9,QWORD PTR [rbp-0x190]
    1d63:	48 8d 74 08 18       	lea    rsi,[rax+rcx*1+0x18]
    1d68:	b9 01 00 00 00       	mov    ecx,0x1
    1d6d:	0f 1f 00             	nop    DWORD PTR [rax]
    1d70:	44 89 e0             	mov    eax,r12d
    1d73:	89 cf                	mov    edi,ecx
    1d75:	99                   	cdq
    1d76:	f7 fb                	idiv   ebx
    1d78:	89 16                	mov    DWORD PTR [rsi],edx
    1d7a:	89 46 04             	mov    DWORD PTR [rsi+0x4],eax
    1d7d:	45 39 e0             	cmp    r8d,r12d
    1d80:	0f 84 df 01 00 00    	je     1f65 <main+0xc25>
    1d86:	4f 63 24 a1          	movsxd r12,DWORD PTR [r9+r12*4]
    1d8a:	41 83 fc ff          	cmp    r12d,0xffffffff
    1d8e:	0f 84 d1 01 00 00    	je     1f65 <main+0xc25>
    1d94:	48 83 c1 01          	add    rcx,0x1
    1d98:	48 83 c6 08          	add    rsi,0x8
    1d9c:	48 81 f9 01 02 00 00 	cmp    rcx,0x201
    1da3:	75 cb                	jne    1d70 <main+0xa30>
    1da5:	48 69 85 50 fe ff ff 	imul   rax,QWORD PTR [rbp-0x1b0],0x1038
    1dac:	38 10 00 00 
    1db0:	48 8d 1d c9 32 00 00 	lea    rbx,[rip+0x32c9]        # 5080 <ORD>
    1db7:	89 bc 03 18 10 00 00 	mov    DWORD PTR [rbx+rax*1+0x1018],edi
    1dbe:	48 69 85 50 fe ff ff 	imul   rax,QWORD PTR [rbp-0x1b0],0x1038
    1dc5:	38 10 00 00 
    1dc9:	48 8d 0d 90 04 00 00 	lea    rcx,[rip+0x490]        # 2260 <fx_draw_basic>
    1dd0:	4c 89 ff             	mov    rdi,r15
    1dd3:	48 8d 1d a6 32 00 00 	lea    rbx,[rip+0x32a6]        # 5080 <ORD>
    1dda:	48 89 8c 03 20 10 00 	mov    QWORD PTR [rbx+rax*1+0x1020],rcx
    1de1:	00 
    1de2:	e8 e9 f3 ff ff       	call   11d0 <free@plt>
    1de7:	48 8b bd 70 fe ff ff 	mov    rdi,QWORD PTR [rbp-0x190]
    1dee:	e8 dd f3 ff ff       	call   11d0 <free@plt>
    1df3:	44 8b 85 40 fe ff ff 	mov    r8d,DWORD PTR [rbp-0x1c0]
    1dfa:	31 c0                	xor    eax,eax
    1dfc:	8b 8d 3c fe ff ff    	mov    ecx,DWORD PTR [rbp-0x1c4]
    1e02:	8b 95 48 fe ff ff    	mov    edx,DWORD PTR [rbp-0x1b8]
    1e08:	48 8d 35 bf 12 00 00 	lea    rsi,[rip+0x12bf]        # 30ce <_IO_stdin_used+0xce>
    1e0f:	bf 01 00 00 00       	mov    edi,0x1
    1e14:	e8 b7 f4 ff ff       	call   12d0 <__printf_chk@plt>
    1e19:	83 05 40 32 00 00 01 	add    DWORD PTR [rip+0x3240],0x1        # 5060 <ORD_N>
    1e20:	e9 03 f6 ff ff       	jmp    1428 <main+0xe8>
    1e25:	0f 1f 00             	nop    DWORD PTR [rax]
    1e28:	89 06                	mov    DWORD PTR [rsi],eax
    1e2a:	48 8b b5 70 fe ff ff 	mov    rsi,QWORD PTR [rbp-0x190]
    1e31:	41 89 c1             	mov    r9d,eax
    1e34:	44 89 24 96          	mov    DWORD PTR [rsi+rdx*4],r12d
    1e38:	41 83 fb 7f          	cmp    r11d,0x7f
    1e3c:	0f 8f c6 fe ff ff    	jg     1d08 <main+0x9c8>
    1e42:	41 83 c3 01          	add    r11d,0x1
    1e46:	48 8b 95 68 fe ff ff 	mov    rdx,QWORD PTR [rbp-0x198]
    1e4d:	49 63 f3             	movsxd rsi,r11d
    1e50:	44 89 5a 04          	mov    DWORD PTR [rdx+0x4],r11d
    1e54:	48 8d 14 f1          	lea    rdx,[rcx+rsi*8]
    1e58:	44 89 02             	mov    DWORD PTR [rdx],r8d
    1e5b:	89 42 04             	mov    DWORD PTR [rdx+0x4],eax
    1e5e:	44 89 da             	mov    edx,r11d
    1e61:	41 83 fb 01          	cmp    r11d,0x1
    1e65:	0f 84 9d fe ff ff    	je     1d08 <main+0x9c8>
    1e6b:	48 89 bd 60 fe ff ff 	mov    QWORD PTR [rbp-0x1a0],rdi
    1e72:	eb 19                	jmp    1e8d <main+0xb4d>
    1e74:	0f 1f 40 00          	nop    DWORD PTR [rax+0x0]
    1e78:	45 8b 10             	mov    r10d,DWORD PTR [r8]
    1e7b:	48 8b 38             	mov    rdi,QWORD PTR [rax]
    1e7e:	49 89 38             	mov    QWORD PTR [r8],rdi
    1e81:	44 89 10             	mov    DWORD PTR [rax],r10d
    1e84:	44 89 48 04          	mov    DWORD PTR [rax+0x4],r9d
    1e88:	83 fa 01             	cmp    edx,0x1
    1e8b:	74 13                	je     1ea0 <main+0xb60>
    1e8d:	d1 fa                	sar    edx,1
    1e8f:	4c 8d 04 f1          	lea    r8,[rcx+rsi*8]
    1e93:	48 63 f2             	movsxd rsi,edx
    1e96:	48 8d 04 f1          	lea    rax,[rcx+rsi*8]
    1e9a:	44 3b 48 04          	cmp    r9d,DWORD PTR [rax+0x4]
    1e9e:	7c d8                	jl     1e78 <main+0xb38>
    1ea0:	48 8b bd 60 fe ff ff 	mov    rdi,QWORD PTR [rbp-0x1a0]
    1ea7:	e9 5c fe ff ff       	jmp    1d08 <main+0x9c8>
    1eac:	45 89 c3             	mov    r11d,r8d
    1eaf:	e9 5d fe ff ff       	jmp    1d11 <main+0x9d1>
    1eb4:	48 63 db             	movsxd rbx,ebx
    1eb7:	48 8d 3d 57 12 00 00 	lea    rdi,[rip+0x1257]        # 3115 <_IO_stdin_used+0x115>
    1ebe:	e8 1d f3 ff ff       	call   11e0 <puts@plt>
    1ec3:	4c 69 fb 38 10 00 00 	imul   r15,rbx,0x1038
    1eca:	48 8d 05 af 31 00 00 	lea    rax,[rip+0x31af]        # 5080 <ORD>
    1ed1:	4c 01 f8             	add    rax,r15
    1ed4:	48 83 b8 28 10 00 00 	cmp    QWORD PTR [rax+0x1028],0x0
    1edb:	00 
    1edc:	0f 84 46 f5 ff ff    	je     1428 <main+0xe8>
    1ee2:	8b 90 18 10 00 00    	mov    edx,DWORD PTR [rax+0x1018]
    1ee8:	83 fa 01             	cmp    edx,0x1
    1eeb:	7e 56                	jle    1f43 <main+0xc03>
    1eed:	48 69 c3 07 02 00 00 	imul   rax,rbx,0x207
    1ef4:	48 63 ca             	movsxd rcx,edx
    1ef7:	83 ea 02             	sub    edx,0x2
    1efa:	48 01 c8             	add    rax,rcx
    1efd:	48 8d 0d 7c 31 00 00 	lea    rcx,[rip+0x317c]        # 5080 <ORD>
    1f04:	4c 8d 64 c1 08       	lea    r12,[rcx+rax*8+0x8]
    1f09:	48 29 d0             	sub    rax,rdx
    1f0c:	4c 8d 34 c1          	lea    r14,[rcx+rax*8]
    1f10:	48 8d 05 69 31 00 00 	lea    rax,[rip+0x3169]        # 5080 <ORD>
    1f17:	41 8b 4c 24 04       	mov    ecx,DWORD PTR [r12+0x4]
    1f1c:	41 8b 74 24 0c       	mov    esi,DWORD PTR [r12+0xc]
    1f21:	49 83 ec 08          	sub    r12,0x8
    1f25:	4a 8b 84 38 28 10 00 	mov    rax,QWORD PTR [rax+r15*1+0x1028]
    1f2c:	00 
    1f2d:	41 8b 7c 24 10       	mov    edi,DWORD PTR [r12+0x10]
    1f32:	41 8b 54 24 08       	mov    edx,DWORD PTR [r12+0x8]
    1f37:	48 8b 40 10          	mov    rax,QWORD PTR [rax+0x10]
    1f3b:	ff 50 18             	call   QWORD PTR [rax+0x18]
    1f3e:	4d 39 e6             	cmp    r14,r12
    1f41:	75 cd                	jne    1f10 <main+0xbd0>
    1f43:	48 69 db 38 10 00 00 	imul   rbx,rbx,0x1038
    1f4a:	48 8d 05 2f 31 00 00 	lea    rax,[rip+0x312f]        # 5080 <ORD>
    1f51:	48 8b 84 18 28 10 00 	mov    rax,QWORD PTR [rax+rbx*1+0x1028]
    1f58:	00 
    1f59:	48 8b 40 10          	mov    rax,QWORD PTR [rax+0x10]
    1f5d:	ff 50 10             	call   QWORD PTR [rax+0x10]
    1f60:	e9 c3 f4 ff ff       	jmp    1428 <main+0xe8>
    1f65:	48 69 85 50 fe ff ff 	imul   rax,QWORD PTR [rbp-0x1b0],0x1038
    1f6c:	38 10 00 00 
    1f70:	48 8d 1d 09 31 00 00 	lea    rbx,[rip+0x3109]        # 5080 <ORD>
    1f77:	89 8c 03 18 10 00 00 	mov    DWORD PTR [rbx+rax*1+0x1018],ecx
    1f7e:	e9 3b fe ff ff       	jmp    1dbe <main+0xa7e>
    1f83:	48 63 db             	movsxd rbx,ebx
    1f86:	48 8d 05 f3 30 00 00 	lea    rax,[rip+0x30f3]        # 5080 <ORD>
    1f8d:	48 69 db 38 10 00 00 	imul   rbx,rbx,0x1038
    1f94:	48 01 c3             	add    rbx,rax
    1f97:	48 83 bb 28 10 00 00 	cmp    QWORD PTR [rbx+0x1028],0x0
    1f9e:	00 
    1f9f:	0f 84 38 f6 ff ff    	je     15dd <main+0x29d>
    1fa5:	31 f6                	xor    esi,esi
    1fa7:	4c 89 e7             	mov    rdi,r12
    1faa:	ba 0a 00 00 00       	mov    edx,0xa
    1faf:	e8 dc f2 ff ff       	call   1290 <strtol@plt>
    1fb4:	31 f6                	xor    esi,esi
    1fb6:	ba 0a 00 00 00       	mov    edx,0xa
    1fbb:	4c 89 f7             	mov    rdi,r14
    1fbe:	49 89 c7             	mov    r15,rax
    1fc1:	41 89 c4             	mov    r12d,eax
    1fc4:	e8 c7 f2 ff ff       	call   1290 <strtol@plt>
    1fc9:	48 8b 93 28 10 00 00 	mov    rdx,QWORD PTR [rbx+0x1028]
    1fd0:	89 c7                	mov    edi,eax
    1fd2:	48 8b 72 08          	mov    rsi,QWORD PTR [rdx+0x8]
    1fd6:	49 63 d7             	movsxd rdx,r15d
    1fd9:	48 8d 0c d6          	lea    rcx,[rsi+rdx*8]
    1fdd:	8b 53 08             	mov    edx,DWORD PTR [rbx+0x8]
    1fe0:	0f af 15 99 37 02 00 	imul   edx,DWORD PTR [rip+0x23799]        # 25780 <G>
    1fe7:	03 53 04             	add    edx,DWORD PTR [rbx+0x4]
    1fea:	89 41 04             	mov    DWORD PTR [rcx+0x4],eax
    1fed:	89 11                	mov    DWORD PTR [rcx],edx
    1fef:	49 63 d7             	movsxd rdx,r15d
    1ff2:	41 83 ef 01          	sub    r15d,0x1
    1ff6:	7f 1d                	jg     2015 <main+0xcd5>
    1ff8:	eb 2e                	jmp    2028 <main+0xce8>
    1ffa:	66 0f 1f 44 00 00    	nop    WORD PTR [rax+rax*1+0x0]
    2000:	44 8b 01             	mov    r8d,DWORD PTR [rcx]
    2003:	4c 8b 08             	mov    r9,QWORD PTR [rax]
    2006:	4c 89 09             	mov    QWORD PTR [rcx],r9
    2009:	44 89 00             	mov    DWORD PTR [rax],r8d
    200c:	89 78 04             	mov    DWORD PTR [rax+0x4],edi
    200f:	41 83 fc 01          	cmp    r12d,0x1
    2013:	74 13                	je     2028 <main+0xce8>
    2015:	41 d1 fc             	sar    r12d,1
    2018:	48 8d 0c d6          	lea    rcx,[rsi+rdx*8]
    201c:	49 63 d4             	movsxd rdx,r12d
    201f:	48 8d 04 d6          	lea    rax,[rsi+rdx*8]
    2023:	3b 78 04             	cmp    edi,DWORD PTR [rax+0x4]
    2026:	7c d8                	jl     2000 <main+0xcc0>
    2028:	48 8d 3d cb 10 00 00 	lea    rdi,[rip+0x10cb]        # 30fa <_IO_stdin_used+0xfa>
    202f:	e8 ac f1 ff ff       	call   11e0 <puts@plt>
    2034:	e9 ef f3 ff ff       	jmp    1428 <main+0xe8>
    2039:	48 8d 3d 77 10 00 00 	lea    rdi,[rip+0x1077]        # 30b7 <_IO_stdin_used+0xb7>
    2040:	e8 9b f1 ff ff       	call   11e0 <puts@plt>
    2045:	e9 de f3 ff ff       	jmp    1428 <main+0xe8>
    204a:	48 63 c3             	movsxd rax,ebx
    204d:	48 8d 1d 2c 30 00 00 	lea    rbx,[rip+0x302c]        # 5080 <ORD>
    2054:	48 8d 35 4d 12 00 00 	lea    rsi,[rip+0x124d]        # 32a8 <_IO_stdin_used+0x2a8>
    205b:	bf 01 00 00 00       	mov    edi,0x1
    2060:	48 69 c0 38 10 00 00 	imul   rax,rax,0x1038
    2067:	48 01 d8             	add    rax,rbx
    206a:	8b 90 18 10 00 00    	mov    edx,DWORD PTR [rax+0x1018]
    2070:	8b 48 0c             	mov    ecx,DWORD PTR [rax+0xc]
    2073:	4c 8b 88 30 10 00 00 	mov    r9,QWORD PTR [rax+0x1030]
    207a:	31 c0                	xor    eax,eax
    207c:	41 89 d0             	mov    r8d,edx
    207f:	41 29 c8             	sub    r8d,ecx
    2082:	e8 49 f2 ff ff       	call   12d0 <__printf_chk@plt>
    2087:	e9 9c f3 ff ff       	jmp    1428 <main+0xe8>
    208c:	48 63 db             	movsxd rbx,ebx
    208f:	48 8d 05 ea 2f 00 00 	lea    rax,[rip+0x2fea]        # 5080 <ORD>
    2096:	bf 01 00 00 00       	mov    edi,0x1
    209b:	4c 69 e3 38 10 00 00 	imul   r12,rbx,0x1038
    20a2:	48 8d 35 df 11 00 00 	lea    rsi,[rip+0x11df]        # 3288 <_IO_stdin_used+0x288>
    20a9:	49 01 c4             	add    r12,rax
    20ac:	31 c0                	xor    eax,eax
    20ae:	49 8b 8c 24 20 10 00 	mov    rcx,QWORD PTR [r12+0x1020]
    20b5:	00 
    20b6:	41 8b 94 24 18 10 00 	mov    edx,DWORD PTR [r12+0x1018]
    20bd:	00 
    20be:	e8 0d f2 ff ff       	call   12d0 <__printf_chk@plt>
    20c3:	49 63 84 24 18 10 00 	movsxd rax,DWORD PTR [r12+0x1018]
    20ca:	00 
    20cb:	41 89 c4             	mov    r12d,eax
    20ce:	41 83 ec 01          	sub    r12d,0x1
    20d2:	0f 88 50 f3 ff ff    	js     1428 <main+0xe8>
    20d8:	48 69 db 07 02 00 00 	imul   rbx,rbx,0x207
    20df:	4c 8d 3d 53 10 00 00 	lea    r15,[rip+0x1053]        # 3139 <_IO_stdin_used+0x139>
    20e6:	4c 8d 35 47 10 00 00 	lea    r14,[rip+0x1047]        # 3134 <_IO_stdin_used+0x134>
    20ed:	48 01 d8             	add    rax,rbx
    20f0:	48 8d 1d 89 2f 00 00 	lea    rbx,[rip+0x2f89]        # 5080 <ORD>
    20f7:	48 8d 1c c3          	lea    rbx,[rbx+rax*8]
    20fb:	eb 1d                	jmp    211a <main+0xdda>
    20fd:	0f 1f 00             	nop    DWORD PTR [rax]
    2100:	4d 89 f0             	mov    r8,r14
    2103:	4c 89 fe             	mov    rsi,r15
    2106:	bf 01 00 00 00       	mov    edi,0x1
    210b:	31 c0                	xor    eax,eax
    210d:	e8 be f1 ff ff       	call   12d0 <__printf_chk@plt>
    2112:	41 83 ec 01          	sub    r12d,0x1
    2116:	48 83 eb 08          	sub    rbx,0x8
    211a:	8b 53 10             	mov    edx,DWORD PTR [rbx+0x10]
    211d:	8b 4b 14             	mov    ecx,DWORD PTR [rbx+0x14]
    2120:	45 85 e4             	test   r12d,r12d
    2123:	75 db                	jne    2100 <main+0xdc0>
    2125:	4c 8d 05 b7 0f 00 00 	lea    r8,[rip+0xfb7]        # 30e3 <_IO_stdin_used+0xe3>
    212c:	4c 89 fe             	mov    rsi,r15
    212f:	bf 01 00 00 00       	mov    edi,0x1
    2134:	31 c0                	xor    eax,eax
    2136:	e8 95 f1 ff ff       	call   12d0 <__printf_chk@plt>
    213b:	e9 e8 f2 ff ff       	jmp    1428 <main+0xe8>
    2140:	48 8d 3d 80 0f 00 00 	lea    rdi,[rip+0xf80]        # 30c7 <_IO_stdin_used+0xc7>
    2147:	e8 c4 f1 ff ff       	call   1310 <perror@plt>
    214c:	bf 01 00 00 00       	mov    edi,0x1
    2151:	e8 da f1 ff ff       	call   1330 <exit@plt>
    2156:	e8 b5 f0 ff ff       	call   1210 <__stack_chk_fail@plt>
    215b:	4c 63 d0             	movsxd r10,eax
    215e:	46 8b 5c c9 04       	mov    r11d,DWORD PTR [rcx+r9*8+0x4]
    2163:	46 39 5c d1 04       	cmp    DWORD PTR [rcx+r10*8+0x4],r11d
    2168:	0f 4d c6             	cmovge eax,esi
    216b:	e9 cd f7 ff ff       	jmp    193d <main+0x5fd>

0000000000002170 <_start>:
    2170:	f3 0f 1e fa          	endbr64
    2174:	31 ed                	xor    ebp,ebp
    2176:	49 89 d1             	mov    r9,rdx
    2179:	5e                   	pop    rsi
    217a:	48 89 e2             	mov    rdx,rsp
    217d:	48 83 e4 f0          	and    rsp,0xfffffffffffffff0
    2181:	50                   	push   rax
    2182:	54                   	push   rsp
    2183:	45 31 c0             	xor    r8d,r8d
    2186:	31 c9                	xor    ecx,ecx
    2188:	48 8d 3d b1 f1 ff ff 	lea    rdi,[rip+0xfffffffffffff1b1]        # 1340 <main>
    218f:	ff 15 43 2e 00 00    	call   QWORD PTR [rip+0x2e43]        # 4fd8 <__libc_start_main@GLIBC_2.34>
    2195:	f4                   	hlt
    2196:	66 2e 0f 1f 84 00 00 	cs nop WORD PTR [rax+rax*1+0x0]
    219d:	00 00 00 

00000000000021a0 <deregister_tm_clones>:
    21a0:	48 8d 3d 69 2e 00 00 	lea    rdi,[rip+0x2e69]        # 5010 <__TMC_END__>
    21a7:	48 8d 05 62 2e 00 00 	lea    rax,[rip+0x2e62]        # 5010 <__TMC_END__>
    21ae:	48 39 f8             	cmp    rax,rdi
    21b1:	74 15                	je     21c8 <deregister_tm_clones+0x28>
    21b3:	48 8b 05 26 2e 00 00 	mov    rax,QWORD PTR [rip+0x2e26]        # 4fe0 <_ITM_deregisterTMCloneTable@Base>
    21ba:	48 85 c0             	test   rax,rax
    21bd:	74 09                	je     21c8 <deregister_tm_clones+0x28>
    21bf:	ff e0                	jmp    rax
    21c1:	0f 1f 80 00 00 00 00 	nop    DWORD PTR [rax+0x0]
    21c8:	c3                   	ret
    21c9:	0f 1f 80 00 00 00 00 	nop    DWORD PTR [rax+0x0]

00000000000021d0 <register_tm_clones>:
    21d0:	48 8d 3d 39 2e 00 00 	lea    rdi,[rip+0x2e39]        # 5010 <__TMC_END__>
    21d7:	48 8d 35 32 2e 00 00 	lea    rsi,[rip+0x2e32]        # 5010 <__TMC_END__>
    21de:	48 29 fe             	sub    rsi,rdi
    21e1:	48 89 f0             	mov    rax,rsi
    21e4:	48 c1 ee 3f          	shr    rsi,0x3f
    21e8:	48 c1 f8 03          	sar    rax,0x3
    21ec:	48 01 c6             	add    rsi,rax
    21ef:	48 d1 fe             	sar    rsi,1
    21f2:	74 14                	je     2208 <register_tm_clones+0x38>
    21f4:	48 8b 05 f5 2d 00 00 	mov    rax,QWORD PTR [rip+0x2df5]        # 4ff0 <_ITM_registerTMCloneTable@Base>
    21fb:	48 85 c0             	test   rax,rax
    21fe:	74 08                	je     2208 <register_tm_clones+0x38>
    2200:	ff e0                	jmp    rax
    2202:	66 0f 1f 44 00 00    	nop    WORD PTR [rax+rax*1+0x0]
    2208:	c3                   	ret
    2209:	0f 1f 80 00 00 00 00 	nop    DWORD PTR [rax+0x0]

0000000000002210 <__do_global_dtors_aux>:
    2210:	f3 0f 1e fa          	endbr64
    2214:	80 3d 2d 2e 00 00 00 	cmp    BYTE PTR [rip+0x2e2d],0x0        # 5048 <completed.0>
    221b:	75 2b                	jne    2248 <__do_global_dtors_aux+0x38>
    221d:	55                   	push   rbp
    221e:	48 83 3d d2 2d 00 00 	cmp    QWORD PTR [rip+0x2dd2],0x0        # 4ff8 <__cxa_finalize@GLIBC_2.2.5>
    2225:	00 
    2226:	48 89 e5             	mov    rbp,rsp
    2229:	74 0c                	je     2237 <__do_global_dtors_aux+0x27>
    222b:	48 8b 3d d6 2d 00 00 	mov    rdi,QWORD PTR [rip+0x2dd6]        # 5008 <__dso_handle>
    2232:	e8 79 ef ff ff       	call   11b0 <__cxa_finalize@plt>
    2237:	e8 64 ff ff ff       	call   21a0 <deregister_tm_clones>
    223c:	c6 05 05 2e 00 00 01 	mov    BYTE PTR [rip+0x2e05],0x1        # 5048 <completed.0>
    2243:	5d                   	pop    rbp
    2244:	c3                   	ret
    2245:	0f 1f 00             	nop    DWORD PTR [rax]
    2248:	c3                   	ret
    2249:	0f 1f 80 00 00 00 00 	nop    DWORD PTR [rax+0x0]

0000000000002250 <frame_dummy>:
    2250:	f3 0f 1e fa          	endbr64
    2254:	e9 77 ff ff ff       	jmp    21d0 <register_tm_clones>
    2259:	0f 1f 80 00 00 00 00 	nop    DWORD PTR [rax+0x0]

0000000000002260 <fx_draw_basic>:
    2260:	f3 0f 1e fa          	endbr64
    2264:	48 8d 3d 99 0d 00 00 	lea    rdi,[rip+0xd99]        # 3004 <_IO_stdin_used+0x4>
    226b:	e9 70 ef ff ff       	jmp    11e0 <puts@plt>

0000000000002270 <fx_finish_dummy>:
    2270:	f3 0f 1e fa          	endbr64
    2274:	48 8d 3d 9b 0d 00 00 	lea    rdi,[rip+0xd9b]        # 3016 <_IO_stdin_used+0x16>
    227b:	e9 60 ef ff ff       	jmp    11e0 <puts@plt>

0000000000002280 <load_map>:
    2280:	55                   	push   rbp
    2281:	49 89 f9             	mov    r9,rdi
    2284:	be 80 00 00 00       	mov    esi,0x80
    2289:	4c 8d 05 a0 0d 00 00 	lea    r8,[rip+0xda0]        # 3030 <_IO_stdin_used+0x30>
    2290:	b9 80 00 00 00       	mov    ecx,0x80
    2295:	ba 01 00 00 00       	mov    edx,0x1
    229a:	48 89 e5             	mov    rbp,rsp
    229d:	41 57                	push   r15
    229f:	41 56                	push   r14
    22a1:	41 55                	push   r13
    22a3:	41 54                	push   r12
    22a5:	4c 8d a5 c0 fe ff ff 	lea    r12,[rbp-0x140]
    22ac:	53                   	push   rbx
    22ad:	4c 89 e7             	mov    rdi,r12
    22b0:	48 81 ec 28 01 00 00 	sub    rsp,0x128
    22b7:	64 48 8b 04 25 28 00 	mov    rax,QWORD PTR fs:0x28
    22be:	00 00 
    22c0:	48 89 45 c8          	mov    QWORD PTR [rbp-0x38],rax
    22c4:	31 c0                	xor    eax,eax
    22c6:	e8 f5 ee ff ff       	call   11c0 <__snprintf_chk@plt>
    22cb:	48 8d 35 d8 0d 00 00 	lea    rsi,[rip+0xdd8]        # 30aa <_IO_stdin_used+0xaa>
    22d2:	4c 89 e7             	mov    rdi,r12
    22d5:	e8 26 f0 ff ff       	call   1300 <fopen@plt>
    22da:	48 85 c0             	test   rax,rax
    22dd:	0f 84 6e 01 00 00    	je     2451 <load_map+0x1d1>
    22e3:	49 89 c7             	mov    r15,rax
    22e6:	b9 82 00 00 00       	mov    ecx,0x82
    22eb:	31 c0                	xor    eax,eax
    22ed:	45 31 e4             	xor    r12d,r12d
    22f0:	48 8d 3d 89 34 02 00 	lea    rdi,[rip+0x23489]        # 25780 <G>
    22f7:	4c 8d 35 82 34 02 00 	lea    r14,[rip+0x23482]        # 25780 <G>
    22fe:	31 db                	xor    ebx,ebx
    2300:	f3 48 ab             	rep stos QWORD PTR [rdi],rax
    2303:	4c 8d ad 40 ff ff ff 	lea    r13,[rbp-0xc0]
    230a:	66 0f 1f 44 00 00    	nop    WORD PTR [rax+rax*1+0x0]
    2310:	4c 89 fa             	mov    rdx,r15
    2313:	be 80 00 00 00       	mov    esi,0x80
    2318:	4c 89 ef             	mov    rdi,r13
    231b:	e8 40 ef ff ff       	call   1260 <fgets@plt>
    2320:	48 85 c0             	test   rax,rax
    2323:	0f 84 dc 00 00 00    	je     2405 <load_map+0x185>
    2329:	4c 89 ef             	mov    rdi,r13
    232c:	e8 cf ee ff ff       	call   1200 <strlen@plt>
    2331:	48 85 c0             	test   rax,rax
    2334:	74 1a                	je     2350 <load_map+0xd0>
    2336:	80 bc 05 3f ff ff ff 	cmp    BYTE PTR [rbp+rax*1-0xc1],0xa
    233d:	0a 
    233e:	75 10                	jne    2350 <load_map+0xd0>
    2340:	c6 84 05 3f ff ff ff 	mov    BYTE PTR [rbp+rax*1-0xc1],0x0
    2347:	00 
    2348:	0f 1f 84 00 00 00 00 	nop    DWORD PTR [rax+rax*1+0x0]
    234f:	00 
    2350:	0f b6 95 40 ff ff ff 	movzx  edx,BYTE PTR [rbp-0xc0]
    2357:	84 d2                	test   dl,dl
    2359:	88 95 b7 fe ff ff    	mov    BYTE PTR [rbp-0x149],dl
    235f:	74 af                	je     2310 <load_map+0x90>
    2361:	4c 89 ef             	mov    rdi,r13
    2364:	e8 97 ee ff ff       	call   1200 <strlen@plt>
    2369:	48 8d 0d 10 34 02 00 	lea    rcx,[rip+0x23410]        # 25780 <G>
    2370:	89 01                	mov    DWORD PTR [rcx],eax
    2372:	89 c7                	mov    edi,eax
    2374:	48 85 c0             	test   rax,rax
    2377:	74 7c                	je     23f5 <load_map+0x175>
    2379:	0f b6 95 b7 fe ff ff 	movzx  edx,BYTE PTR [rbp-0x149]
    2380:	b8 01 00 00 00       	mov    eax,0x1
    2385:	45 31 c9             	xor    r9d,r9d
    2388:	eb 1e                	jmp    23a8 <load_map+0x128>
    238a:	66 0f 1f 44 00 00    	nop    WORD PTR [rax+rax*1+0x0]
    2390:	41 88 54 06 07       	mov    BYTE PTR [r14+rax*1+0x7],dl
    2395:	83 f8 20             	cmp    eax,0x20
    2398:	74 3e                	je     23d8 <load_map+0x158>
    239a:	39 c7                	cmp    edi,eax
    239c:	7e 3a                	jle    23d8 <load_map+0x158>
    239e:	41 0f b6 54 05 00    	movzx  edx,BYTE PTR [r13+rax*1+0x0]
    23a4:	48 83 c0 01          	add    rax,0x1
    23a8:	8d 70 ff             	lea    esi,[rax-0x1]
    23ab:	80 fa 53             	cmp    dl,0x53
    23ae:	75 e0                	jne    2390 <load_map+0x110>
    23b0:	41 c6 44 06 07 2e    	mov    BYTE PTR [r14+rax*1+0x7],0x2e
    23b6:	41 b9 01 00 00 00    	mov    r9d,0x1
    23bc:	41 bc 01 00 00 00    	mov    r12d,0x1
    23c2:	89 9d b8 fe ff ff    	mov    DWORD PTR [rbp-0x148],ebx
    23c8:	89 b5 bc fe ff ff    	mov    DWORD PTR [rbp-0x144],esi
    23ce:	83 f8 20             	cmp    eax,0x20
    23d1:	75 c7                	jne    239a <load_map+0x11a>
    23d3:	0f 1f 44 00 00       	nop    DWORD PTR [rax+rax*1+0x0]
    23d8:	45 84 c9             	test   r9b,r9b
    23db:	74 18                	je     23f5 <load_map+0x175>
    23dd:	8b 85 b8 fe ff ff    	mov    eax,DWORD PTR [rbp-0x148]
    23e3:	89 05 a3 37 02 00    	mov    DWORD PTR [rip+0x237a3],eax        # 25b8c <G+0x40c>
    23e9:	8b 85 bc fe ff ff    	mov    eax,DWORD PTR [rbp-0x144]
    23ef:	89 05 93 37 02 00    	mov    DWORD PTR [rip+0x23793],eax        # 25b88 <G+0x408>
    23f5:	83 c3 01             	add    ebx,0x1
    23f8:	49 83 c6 20          	add    r14,0x20
    23fc:	83 fb 20             	cmp    ebx,0x20
    23ff:	0f 85 0b ff ff ff    	jne    2310 <load_map+0x90>
    2405:	4c 89 ff             	mov    rdi,r15
    2408:	89 1d 76 33 02 00    	mov    DWORD PTR [rip+0x23376],ebx        # 25784 <G+0x4>
    240e:	e8 dd ed ff ff       	call   11f0 <fclose@plt>
    2413:	45 85 e4             	test   r12d,r12d
    2416:	74 27                	je     243f <load_map+0x1bf>
    2418:	45 31 e4             	xor    r12d,r12d
    241b:	48 8b 45 c8          	mov    rax,QWORD PTR [rbp-0x38]
    241f:	64 48 2b 04 25 28 00 	sub    rax,QWORD PTR fs:0x28
    2426:	00 00 
    2428:	75 22                	jne    244c <load_map+0x1cc>
    242a:	48 81 c4 28 01 00 00 	add    rsp,0x128
    2431:	44 89 e0             	mov    eax,r12d
    2434:	5b                   	pop    rbx
    2435:	41 5c                	pop    r12
    2437:	41 5d                	pop    r13
    2439:	41 5e                	pop    r14
    243b:	41 5f                	pop    r15
    243d:	5d                   	pop    rbp
    243e:	c3                   	ret
    243f:	48 c7 05 3e 37 02 00 	mov    QWORD PTR [rip+0x2373e],0x0        # 25b88 <G+0x408>
    2446:	00 00 00 00 
    244a:	eb cf                	jmp    241b <load_map+0x19b>
    244c:	e8 bf ed ff ff       	call   1210 <__stack_chk_fail@plt>
    2451:	41 83 cc ff          	or     r12d,0xffffffff
    2455:	eb c4                	jmp    241b <load_map+0x19b>
    2457:	66 0f 1f 84 00 00 00 	nop    WORD PTR [rax+rax*1+0x0]
    245e:	00 00 

0000000000002460 <win>:
    2460:	f3 0f 1e fa          	endbr64
    2464:	55                   	push   rbp
    2465:	48 8d 3d ec 0c 00 00 	lea    rdi,[rip+0xcec]        # 3158 <_IO_stdin_used+0x158>
    246c:	48 89 e5             	mov    rbp,rsp
    246f:	41 55                	push   r13
    2471:	41 54                	push   r12
    2473:	48 81 ec 10 01 00 00 	sub    rsp,0x110
    247a:	64 48 8b 04 25 28 00 	mov    rax,QWORD PTR fs:0x28
    2481:	00 00 
    2483:	48 89 45 e8          	mov    QWORD PTR [rbp-0x18],rax
    2487:	31 c0                	xor    eax,eax
    2489:	e8 52 ed ff ff       	call   11e0 <puts@plt>
    248e:	31 f6                	xor    esi,esi
    2490:	31 c0                	xor    eax,eax
    2492:	48 8d 3d a3 0b 00 00 	lea    rdi,[rip+0xba3]        # 303c <_IO_stdin_used+0x3c>
    2499:	e8 52 ee ff ff       	call   12f0 <open@plt>
    249e:	85 c0                	test   eax,eax
    24a0:	78 5e                	js     2500 <win+0xa0>
    24a2:	4c 8d ad e0 fe ff ff 	lea    r13,[rbp-0x120]
    24a9:	ba ff 00 00 00       	mov    edx,0xff
    24ae:	89 c7                	mov    edi,eax
    24b0:	41 89 c4             	mov    r12d,eax
    24b3:	4c 89 ee             	mov    rsi,r13
    24b6:	e8 95 ed ff ff       	call   1250 <read@plt>
    24bb:	48 85 c0             	test   rax,rax
    24be:	7f 28                	jg     24e8 <win+0x88>
    24c0:	44 89 e7             	mov    edi,r12d
    24c3:	e8 78 ed ff ff       	call   1240 <close@plt>
    24c8:	48 8b 45 e8          	mov    rax,QWORD PTR [rbp-0x18]
    24cc:	64 48 2b 04 25 28 00 	sub    rax,QWORD PTR fs:0x28
    24d3:	00 00 
    24d5:	75 50                	jne    2527 <win+0xc7>
    24d7:	48 81 c4 10 01 00 00 	add    rsp,0x110
    24de:	41 5c                	pop    r12
    24e0:	41 5d                	pop    r13
    24e2:	5d                   	pop    rbp
    24e3:	c3                   	ret
    24e4:	0f 1f 40 00          	nop    DWORD PTR [rax+0x0]
    24e8:	4c 89 ef             	mov    rdi,r13
    24eb:	c6 84 05 e0 fe ff ff 	mov    BYTE PTR [rbp+rax*1-0x120],0x0
    24f2:	00 
    24f3:	e8 e8 ec ff ff       	call   11e0 <puts@plt>
    24f8:	eb c6                	jmp    24c0 <win+0x60>
    24fa:	66 0f 1f 44 00 00    	nop    WORD PTR [rax+rax*1+0x0]
    2500:	48 8b 45 e8          	mov    rax,QWORD PTR [rbp-0x18]
    2504:	64 48 2b 04 25 28 00 	sub    rax,QWORD PTR fs:0x28
    250b:	00 00 
    250d:	75 18                	jne    2527 <win+0xc7>
    250f:	48 81 c4 10 01 00 00 	add    rsp,0x110
    2516:	48 8d 3d 28 0b 00 00 	lea    rdi,[rip+0xb28]        # 3045 <_IO_stdin_used+0x45>
    251d:	41 5c                	pop    r12
    251f:	41 5d                	pop    r13
    2521:	5d                   	pop    rbp
    2522:	e9 b9 ec ff ff       	jmp    11e0 <puts@plt>
    2527:	e8 e4 ec ff ff       	call   1210 <__stack_chk_fail@plt>

Disassembly of section .fini:

000000000000252c <_fini>:
    252c:	f3 0f 1e fa          	endbr64
    2530:	48 83 ec 08          	sub    rsp,0x8
    2534:	48 83 c4 08          	add    rsp,0x8
    2538:	c3                   	ret
