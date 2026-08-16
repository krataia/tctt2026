const crypto = require("crypto");
const fs = require("fs");

const xml = fs.readFileSync(
  "03-somtam-delivery-decompiled/resources/res/values/strings.xml",
  "utf8",
);
const apiKey = xml.match(/<string name="api_key">([^<]+)<\/string>/)?.[1];
if (!apiKey) throw new Error("api_key resource missing");

const payload = fs.readFileSync(
  "03-somtam-delivery-apktool/assets/payload.bin",
);
const iv = payload.subarray(0, 16);
const ciphertext = payload.subarray(16);
const mask8 = Buffer.from("5a3c6f1e7b2d4a90", "hex");
const mask16 = Buffer.from("74b331043756d79f60527355f60210ee", "hex");

const texts = [
  apiKey,
  apiKey.replaceAll("-", ""),
  "sh.sth.somtam",
  "Somtam Delivery",
  "somtam-delivery",
  "03-somtam-delivery",
  "Chef's Special",
  "chef-special",
  "THCTT-Mobile03/1 (Android; sh.sth.somtam)",
  "https://thctt-mob03-api.p7z.pw",
  "TCTT2026",
  "TCTT2026{",
  "b34fca47ccda6030c4236d4efa818e8668d3dc39",
  "b015c88d1c493b04e1a2305641e066f1c2380de8c46a63a439d32ee754506176",
  "1b4a7b3082538726614691a6b5ec4ca4e5e955449b61f4d272e41900d9e3b875",
];

const material = new Map();
function add(name, value) {
  if (value.length === 16) material.set(name, Buffer.from(value));
}

function addHexSlices(name, hex) {
  const value = Buffer.from(hex, "hex");
  add(`${name}:raw:first`, value.subarray(0, 16));
  add(`${name}:raw:last`, value.subarray(Math.max(0, value.length - 16)));
}

for (const text of texts) {
  const label = text === apiKey ? "api_key" : text.replace(/[^A-Za-z0-9]+/g, "_").slice(0, 36);
  const raw = Buffer.from(text);
  add(`${label}:first`, raw.subarray(0, 16));
  add(`${label}:last`, raw.subarray(Math.max(0, raw.length - 16)));
  if (raw.length > 0) {
    const repeated = Buffer.alloc(16);
    for (let i = 0; i < 16; i++) repeated[i] = raw[i % raw.length];
    add(`${label}:repeat`, repeated);
  }
  for (const algorithm of ["md5", "sha1", "sha256", "sha512"]) {
    const digest = crypto.createHash(algorithm).update(raw).digest();
    add(`${label}:${algorithm}:first`, digest.subarray(0, 16));
    add(`${label}:${algorithm}:last`, digest.subarray(digest.length - 16));
  }
}

if (/^[0-9a-f-]{36}$/i.test(apiKey)) {
  add("api_key:uuid", Buffer.from(apiKey.replaceAll("-", ""), "hex"));
}
addHexSlices("native_build_id", "b34fca47ccda6030c4236d4efa818e8668d3dc39");
addHexSlices("signer_sha256", "b015c88d1c493b04e1a2305641e066f1c2380de8c46a63a439d32ee754506176");
addHexSlices("apk_sha256", "1b4a7b3082538726614691a6b5ec4ca4e5e955449b61f4d272e41900d9e3b875");
for (const [name, file] of [
  ["payload", "03-somtam-delivery-apktool/assets/payload.bin"],
  ["native", "03-somtam-delivery-apktool/lib/arm64-v8a/libcore.so"],
]) {
  const value = fs.readFileSync(file);
  for (const algorithm of ["md5", "sha1", "sha256", "sha512"]) {
    const digest = crypto.createHash(algorithm).update(value).digest();
    add(`${name}:${algorithm}:first`, digest.subarray(0, 16));
    add(`${name}:${algorithm}:last`, digest.subarray(digest.length - 16));
  }
}
add("zeros", Buffer.alloc(16));
add("iv", iv);
add("mask16", mask16);
add("mask8repeat", Buffer.concat([mask8, mask8]));

// Mobile02's recovered backend salt is the 16-byte ASCII value
// "skylink-salt-202". Probe the same evidence-derived naming grammar for
// Mobile03, including deterministic truncation to a 16-byte server value.
const prefixes = [
  "somtam", "som-tam", "somtam-delivery", "delivery", "chef",
  "chefspecial", "chef-special", "mob03", "mobile03", "thctt-mob03",
];
const labels = [
  "nonce", "keynonce", "key-nonce", "key_nonce", "key", "salt", "aes",
  "config", "payload", "special",
];
const suffixes = [
  "", "2", "20", "202", "2026", "26", "03", "v1", "v01", "1", "!",
  "-202", "-2026", "_202", "_2026", "-v1", "_v1",
];
for (const prefix of prefixes) {
  for (const label of labels) {
    for (const separator1 of ["", "-", "_"]) {
      for (const separator2 of ["", "-", "_"]) {
        for (const suffix of suffixes) {
          const candidate = `${prefix}${separator1}${label}${separator2}${suffix}`;
          const raw = Buffer.from(candidate);
          add(`grammar:${candidate}`, raw);
          if (raw.length > 16) {
            add(`grammar:${candidate}:first16`, raw.subarray(0, 16));
            add(`grammar:${candidate}:last16`, raw.subarray(raw.length - 16));
          }
        }
      }
    }
  }
}

for (const left of texts.slice(0, 3)) {
  for (const right of texts.slice(0, 12)) {
    for (const [name, key, message] of [
      ["hmac", left, right],
      ["hmac-reverse", right, left],
    ]) {
      const digest = crypto.createHmac("sha256", key).update(message).digest();
      add(`${name}:${texts.indexOf(left)}:${texts.indexOf(right)}:first`, digest.subarray(0, 16));
      add(`${name}:${texts.indexOf(left)}:${texts.indexOf(right)}:last`, digest.subarray(16));
    }
  }
}

function decrypt(key) {
  const decipher = crypto.createDecipheriv("aes-128-cbc", key, iv);
  return Buffer.concat([decipher.update(ciphertext), decipher.final()]);
}

const results = [];
for (const [name, candidate] of material) {
  const derived = Buffer.alloc(16);
  for (let i = 0; i < 16; i++) {
    derived[i] = candidate[i] ^ mask8[i & 7] ^ mask16[i];
  }
  for (const [mode, key] of [["nonce", derived], ["direct-key", candidate]]) {
    try {
      const plaintext = decrypt(key);
      const printable = [...plaintext].filter(
        (byte) => byte === 9 || byte === 10 || byte === 13 || (byte >= 32 && byte < 127),
      ).length / plaintext.length;
      if (plaintext.includes("TCTT") || printable >= 0.8) {
        results.push({ name, mode, printable, plaintext: plaintext.toString("utf8") });
      }
    } catch {
      // Invalid PKCS#7 padding rejects the candidate.
    }
  }
}

console.log(`tested=${material.size * 2}`);
for (const result of results) {
  console.log(`${result.mode}:${result.name}:printable=${result.printable.toFixed(3)}`);
  console.log(result.plaintext);
}
