package sh.sth.somtam;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: compiled from: ActivationActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0016H\u0014J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001f"}, d2 = {"Lsh/sth/somtam/ActivationActivity;", "Landroid/app/Activity;", "()V", "preferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getPreferences", "()Landroid/content/SharedPreferences;", "preferences$delegate", "Lkotlin/Lazy;", "base64", "", "value", "", "beginActivation", "", "exchange", "Lorg/json/JSONObject;", "code", "verifier", "handle", "incoming", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "randomBase64", "size", "", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ActivationActivity extends Activity {

    /* JADX INFO: renamed from: preferences$delegate, reason: from kotlin metadata */
    private final Lazy preferences = LazyKt.lazy(new Function0<SharedPreferences>() { // from class: sh.sth.somtam.ActivationActivity$preferences$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SharedPreferences invoke() {
            return this.this$0.getSharedPreferences("challenge_access", 0);
        }
    });

    private final SharedPreferences getPreferences() {
        return (SharedPreferences) this.preferences.getValue();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) throws NoSuchAlgorithmException {
        super.onCreate(savedInstanceState);
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
        if (callback == null) {
            beginActivation();
            return;
        }
        if (!Intrinsics.areEqual(callback.getScheme(), "thctt-mob03") || !Intrinsics.areEqual(callback.getHost(), "activate")) {
            finish();
            return;
        }
        final String code = callback.getQueryParameter("code");
        if (code == null) {
            finish();
            return;
        }
        String returnedState = callback.getQueryParameter("state");
        if (returnedState == null) {
            finish();
            return;
        }
        String expectedState = getPreferences().getString("pending_state", null);
        if (expectedState == null) {
            finish();
            return;
        }
        final String verifier = getPreferences().getString("pkce_verifier", null);
        if (verifier == null) {
            finish();
            return;
        }
        long pendingAt = getPreferences().getLong("pending_at_ms", 0L);
        if (!Intrinsics.areEqual(returnedState, expectedState) || System.currentTimeMillis() - pendingAt > 300000) {
            finish();
        } else {
            new Thread(new Runnable() { // from class: sh.sth.somtam.ActivationActivity$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ActivationActivity.handle$lambda$1(this.f$0, code, verifier);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handle$lambda$1(ActivationActivity this$0, String code, String verifier) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(code, "$code");
        Intrinsics.checkNotNullParameter(verifier, "$verifier");
        try {
            JSONObject response = this$0.exchange(code, verifier);
            String string = response.getString("capability");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ChallengeCapability.INSTANCE.store(this$0, string, response.getLong("expires_in"));
            Intent $this$handle_u24lambda_u241_u24lambda_u240 = new Intent(this$0, (Class<?>) MainActivity.class);
            $this$handle_u24lambda_u241_u24lambda_u240.addFlags(603979776);
            this$0.startActivity($this$handle_u24lambda_u241_u24lambda_u240);
        } catch (Exception e) {
        } catch (Throwable th) {
            this$0.finish();
            throw th;
        }
        this$0.finish();
    }

    private final void beginActivation() throws NoSuchAlgorithmException {
        String state = randomBase64(32);
        String verifier = randomBase64(48);
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = verifier.getBytes(Charsets.US_ASCII);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] digest = messageDigest.digest(bytes);
        Intrinsics.checkNotNull(digest);
        String challenge = base64(digest);
        getPreferences().edit().putString("pending_state", state).putString("pkce_verifier", verifier).putLong("pending_at_ms", System.currentTimeMillis()).apply();
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
            String body = new JSONObject(MapsKt.mapOf(TuplesKt.to("code", code), TuplesKt.to("verifier", verifier))).toString();
            Intrinsics.checkNotNullExpressionValue(body, "toString(...)");
            BufferedReader outputStream = connection.getOutputStream();
            try {
                OutputStream it = outputStream;
                byte[] bytes = body.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                it.write(bytes);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(outputStream, null);
                int responseCode = connection.getResponseCode();
                if (200 > responseCode || responseCode >= 300) {
                    z = false;
                }
                if (!z) {
                    throw new IllegalStateException("activation exchange rejected".toString());
                }
                InputStream inputStream = connection.getInputStream();
                Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
                Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
                outputStream = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    BufferedReader it2 = outputStream;
                    String text = TextStreamsKt.readText(it2);
                    CloseableKt.closeFinally(outputStream, null);
                    return new JSONObject(text);
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

    private final String randomBase64(int size) {
        byte[] it = new byte[size];
        new SecureRandom().nextBytes(it);
        return base64(it);
    }

    private final String base64(byte[] value) {
        String strEncodeToString = Base64.encodeToString(value, 11);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }
}
