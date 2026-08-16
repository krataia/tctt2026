package sh.sth.skylink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivationActivity extends Activity {
    private static final String CALLBACK_HOST = "activate";
    private static final String CALLBACK_SCHEME = "thctt-mob02";
    private static final String PREFS = "activation";
    private static final SecureRandom RANDOM = new SecureRandom();
    private SharedPreferences prefs;

    @Override // android.app.Activity
    public void onCreate(Bundle state) {
        super.onCreate(state);
        this.prefs = getSharedPreferences(PREFS, 0);
        TextView progress = new TextView(this);
        progress.setText("กำลังยืนยันการเปิดใช้งาน…");
        setContentView(progress);
        handle(getIntent());
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        handle(intent);
    }

    private void handle(Intent intent) {
        Uri callback = intent.getData();
        final String code = callback == null ? null : callback.getQueryParameter("code");
        if (code == null) {
            begin();
            return;
        }
        if (!CALLBACK_SCHEME.equals(callback.getScheme()) || !CALLBACK_HOST.equals(callback.getHost())) {
            finish();
            return;
        }
        String state = callback.getQueryParameter("state");
        final String verifier = this.prefs.getString("verifier", null);
        if (state == null || !state.equals(this.prefs.getString("state", null)) || verifier == null) {
            finish();
        } else {
            new Thread(new Runnable() { // from class: sh.sth.skylink.ActivationActivity$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$handle$2(code, verifier);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handle$2(String code, String verifier) {
        try {
            JSONObject response = exchange(code, verifier);
            String capability = response.getString("capability");
            long expiresIn = Math.max(60L, Math.min(3600L, response.optLong("expires_in", 3600L)));
            if (!capability.startsWith("ctcap1.")) {
                throw new IllegalStateException("invalid capability");
            }
            this.prefs.edit().putString("capability", capability).putLong("expiry", (System.currentTimeMillis() + (1000 * expiresIn)) - 10000).remove("state").remove("verifier").apply();
            runOnUiThread(new Runnable() { // from class: sh.sth.skylink.ActivationActivity$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$handle$0();
                }
            });
        } catch (Exception e) {
            runOnUiThread(new Runnable() { // from class: sh.sth.skylink.ActivationActivity$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$handle$1();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handle$0() {
        startActivity(new Intent(this, (Class<?>) MainActivity.class).addFlags(67108864));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handle$1() {
        Toast.makeText(this, "ยังเปิดใช้งานไม่ได้ กรุณาลองใหม่", 1).show();
        finish();
    }

    private void begin() {
        try {
            String state = random(32);
            String verifier = random(48);
            String challenge = b64(MessageDigest.getInstance("SHA-256").digest(verifier.getBytes(StandardCharsets.US_ASCII)));
            this.prefs.edit().putString("state", state).putString("verifier", verifier).apply();
            Uri uri = Uri.parse(getString(R.string.api_base) + "/activate").buildUpon().appendQueryParameter("state", state).appendQueryParameter("code_challenge", challenge).build();
            startActivity(new Intent("android.intent.action.VIEW", uri));
        } catch (Exception e) {
            Toast.makeText(this, "ยังเปิดหน้าการยืนยันไม่ได้", 1).show();
        }
        finish();
    }

    private JSONObject exchange(String code, String verifier) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) new URL(getString(R.string.api_base) + "/activate/exchange").openConnection();
        try {
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setConnectTimeout(8000);
            connection.setReadTimeout(8000);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("X-API-Key", getString(R.string.api_key));
            AppRequestProfile.apply(connection, this);
            byte[] body = new JSONObject().put("code", code).put("verifier", verifier).toString().getBytes(StandardCharsets.UTF_8);
            connection.getOutputStream().write(body);
            if (connection.getResponseCode() != 200) {
                throw new IllegalStateException("exchange rejected");
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            try {
                String response = reader.readLine();
                reader.close();
                if (response == null || response.length() > 4096) {
                    throw new IllegalStateException("invalid response");
                }
                return new JSONObject(response);
            } finally {
            }
        } finally {
            connection.disconnect();
        }
    }

    static Boolean activationEnabled(Context context) {
        HttpURLConnection connection = null;
        Boolean boolValueOf = null;
        try {
            HttpURLConnection connection2 = (HttpURLConnection) new URL(context.getString(R.string.api_base) + "/activation/status").openConnection();
            connection2.setConnectTimeout(8000);
            connection2.setReadTimeout(8000);
            connection2.setRequestProperty("X-API-Key", context.getString(R.string.api_key));
            AppRequestProfile.apply(connection2, context);
            if (connection2.getResponseCode() != 200) {
                if (connection2 != null) {
                    connection2.disconnect();
                }
                return null;
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection2.getInputStream(), StandardCharsets.UTF_8));
            try {
                String response = reader.readLine();
                reader.close();
                if (response != null && response.length() <= 4096) {
                    boolValueOf = Boolean.valueOf(new JSONObject(response).getBoolean("enabled"));
                }
                if (connection2 != null) {
                    connection2.disconnect();
                }
                return boolValueOf;
            } catch (Throwable th) {
                try {
                    reader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e) {
            if (0 != 0) {
                connection.disconnect();
            }
            return null;
        } catch (Throwable th3) {
            if (0 != 0) {
                connection.disconnect();
            }
            throw th3;
        }
    }

    static String capability(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS, 0);
        if (prefs.getLong("expiry", 0L) <= System.currentTimeMillis()) {
            prefs.edit().remove("capability").remove("expiry").apply();
            return null;
        }
        String value = prefs.getString("capability", null);
        if (value == null || !value.startsWith("ctcap1.")) {
            return null;
        }
        return value;
    }

    private static String random(int size) {
        byte[] value = new byte[size];
        RANDOM.nextBytes(value);
        return b64(value);
    }

    private static String b64(byte[] value) {
        return Base64.encodeToString(value, 11);
    }
}
