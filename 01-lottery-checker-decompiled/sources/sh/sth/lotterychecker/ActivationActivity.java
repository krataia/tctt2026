package sh.sth.lotterychecker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: ActivationActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\u000b0\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0016H\u0014J\u0018\u0010\u001c\u001a\n \u0005*\u0004\u0018\u00010\u000b0\u000b2\u0006\u0010\f\u001a\u00020\u001dH\u0002R#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001f"}, d2 = {"Lsh/sth/lotterychecker/ActivationActivity;", "Landroid/app/Activity;", "()V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getPrefs", "()Landroid/content/SharedPreferences;", "prefs$delegate", "Lkotlin/Lazy;", "b64", "", "bytes", "", "begin", "", "exchange", "Lorg/json/JSONObject;", "code", "verifier", "handle", "incoming", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "random", "", "Companion", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ActivationActivity extends Activity {
    private static final String CALLBACK_HOST = "activate";
    private static final String CALLBACK_SCHEME = "thctt-mob01";
    private static final String PREFS = "activation";

    /* JADX INFO: renamed from: prefs$delegate, reason: from kotlin metadata */
    private final Lazy prefs = LazyKt.lazy(new Function0<SharedPreferences>() { // from class: sh.sth.lotterychecker.ActivationActivity$prefs$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SharedPreferences invoke() {
            return this.this$0.getSharedPreferences("activation", 0);
        }
    });

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SecureRandom RANDOM = new SecureRandom();

    private final SharedPreferences getPrefs() {
        return (SharedPreferences) this.prefs.getValue();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) throws NoSuchAlgorithmException {
        super.onCreate(savedInstanceState);
        TextView $this$onCreate_u24lambda_u240 = new TextView(this);
        $this$onCreate_u24lambda_u240.setText("กำลังยืนยันการเปิดใช้งาน…");
        setContentView($this$onCreate_u24lambda_u240);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        handle(intent);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
        handle(intent);
    }

    private final void handle(Intent incoming) throws NoSuchAlgorithmException {
        Uri callback = incoming.getData();
        final String code = callback != null ? callback.getQueryParameter("code") : null;
        if (code == null) {
            begin();
            return;
        }
        if (!Intrinsics.areEqual(callback.getScheme(), CALLBACK_SCHEME) || !Intrinsics.areEqual(callback.getHost(), CALLBACK_HOST)) {
            finish();
            return;
        }
        String state = callback.getQueryParameter("state");
        final String verifier = getPrefs().getString("verifier", null);
        if (state == null || !Intrinsics.areEqual(state, getPrefs().getString("state", null)) || verifier == null) {
            finish();
        } else {
            new Thread(new Runnable() { // from class: sh.sth.lotterychecker.ActivationActivity$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ActivationActivity.handle$lambda$3(this.f$0, code, verifier);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handle$lambda$3(final ActivationActivity this$0, String $code, String $verifier) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            JSONObject response = this$0.exchange($code, $verifier);
            String capability = response.getString("capability");
            long expiresIn = RangesKt.coerceIn(response.optLong("expires_in", 3600L), 60L, 3600L);
            Intrinsics.checkNotNull(capability);
            if (!StringsKt.startsWith$default(capability, "ctcap1.", false, 2, (Object) null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this$0.getPrefs().edit().putString("capability", capability).putLong("expiry", (System.currentTimeMillis() + (((long) 1000) * expiresIn)) - ((long) 10000)).remove("state").remove("verifier").apply();
            this$0.runOnUiThread(new Runnable() { // from class: sh.sth.lotterychecker.ActivationActivity$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    ActivationActivity.handle$lambda$3$lambda$1(this.f$0);
                }
            });
        } catch (Exception e) {
            this$0.runOnUiThread(new Runnable() { // from class: sh.sth.lotterychecker.ActivationActivity$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ActivationActivity.handle$lambda$3$lambda$2(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handle$lambda$3$lambda$1(ActivationActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) MainActivity.class).addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL));
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handle$lambda$3$lambda$2(ActivationActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Toast.makeText(this$0, "ยังเปิดใช้งานไม่ได้ กรุณาลองใหม่", 1).show();
        this$0.finish();
    }

    private final void begin() throws NoSuchAlgorithmException {
        String state = random(32);
        String verifier = random(48);
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        Intrinsics.checkNotNull(verifier);
        Charset US_ASCII = StandardCharsets.US_ASCII;
        Intrinsics.checkNotNullExpressionValue(US_ASCII, "US_ASCII");
        byte[] bytes = verifier.getBytes(US_ASCII);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bArrDigest = messageDigest.digest(bytes);
        Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest(...)");
        String challenge = b64(bArrDigest);
        getPrefs().edit().putString("state", state).putString("verifier", verifier).apply();
        Uri uri = Uri.parse(getString(R.string.api_base_url) + "/activate").buildUpon().appendQueryParameter("state", state).appendQueryParameter("code_challenge", challenge).build();
        startActivity(new Intent("android.intent.action.VIEW", uri));
        finish();
    }

    private final JSONObject exchange(String code, String verifier) throws IOException {
        URLConnection uRLConnectionOpenConnection = new URL(getString(R.string.api_base_url) + "/activate/exchange").openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection connection = (HttpURLConnection) uRLConnectionOpenConnection;
        try {
            connection.setRequestMethod("POST");
            boolean z = true;
            connection.setDoOutput(true);
            connection.setConnectTimeout(8000);
            connection.setReadTimeout(8000);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("X-API-Key", getString(R.string.api_key));
            AppRequestProfile.INSTANCE.apply(connection, this);
            String string = new JSONObject(MapsKt.mapOf(TuplesKt.to("code", code), TuplesKt.to("verifier", verifier))).toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            byte[] body = string.getBytes(UTF_8);
            Intrinsics.checkNotNullExpressionValue(body, "getBytes(...)");
            BufferedReader outputStream = connection.getOutputStream();
            try {
                OutputStream it = outputStream;
                it.write(body);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(outputStream, null);
                if (!(connection.getResponseCode() == 200)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                InputStream inputStream = connection.getInputStream();
                Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
                Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
                outputStream = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    BufferedReader it2 = outputStream;
                    String response = TextStreamsKt.readText(it2);
                    CloseableKt.closeFinally(outputStream, null);
                    if (response.length() > 4096) {
                        z = false;
                    }
                    if (!z) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    return new JSONObject(response);
                } finally {
                }
            } finally {
                try {
                    throw th;
                } finally {
                }
            }
        } finally {
            connection.disconnect();
        }
    }

    private final String random(int bytes) {
        byte[] it = new byte[bytes];
        RANDOM.nextBytes(it);
        return b64(it);
    }

    private final String b64(byte[] bytes) {
        return Base64.encodeToString(bytes, 11);
    }

    /* JADX INFO: compiled from: ActivationActivity.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lsh/sth/lotterychecker/ActivationActivity$Companion;", "", "()V", "CALLBACK_HOST", "", "CALLBACK_SCHEME", "PREFS", "RANDOM", "Ljava/security/SecureRandom;", "activationEnabled", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)Ljava/lang/Boolean;", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Boolean activationEnabled(Context context) throws IOException {
            Intrinsics.checkNotNullParameter(context, "context");
            URLConnection uRLConnectionOpenConnection = new URL(context.getString(R.string.api_base_url) + "/activation/status").openConnection();
            Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection connection = (HttpURLConnection) uRLConnectionOpenConnection;
            try {
                connection.setConnectTimeout(8000);
                connection.setReadTimeout(8000);
                connection.setRequestProperty("X-API-Key", context.getString(R.string.api_key));
                AppRequestProfile.INSTANCE.apply(connection, context);
            } catch (Exception e) {
            } catch (Throwable th) {
                connection.disconnect();
                throw th;
            }
            if (connection.getResponseCode() == 200) {
                InputStream inputStream = connection.getInputStream();
                Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
                Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    BufferedReader it = bufferedReader;
                    String response = TextStreamsKt.readText(it);
                    CloseableKt.closeFinally(bufferedReader, null);
                    boolValueOf = response.length() <= 4096 ? Boolean.valueOf(new JSONObject(response).getBoolean("enabled")) : null;
                    connection.disconnect();
                    return boolValueOf;
                } finally {
                }
            } else {
                connection.disconnect();
                return null;
            }
        }
    }
}
