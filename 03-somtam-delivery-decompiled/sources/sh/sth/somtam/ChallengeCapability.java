package sh.sth.somtam;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: ActivationActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lsh/sth/somtam/ChallengeCapability;", "", "()V", "EXPIRY_SAFETY_MS", "", "PREFS", "", "activationRequired", "", "context", "Landroid/content/Context;", "clear", "", "get", "launch", "store", "capability", "expiresInSeconds", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ChallengeCapability {
    private static final long EXPIRY_SAFETY_MS = 10000;
    public static final ChallengeCapability INSTANCE = new ChallengeCapability();
    private static final String PREFS = "challenge_access";

    private ChallengeCapability() {
    }

    public final String get(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences preferences = context.getSharedPreferences(PREFS, 0);
        if (preferences.getLong("expires_at_ms", 0L) <= System.currentTimeMillis()) {
            clear(context);
            return null;
        }
        return preferences.getString("capability", null);
    }

    public final void clear(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.getSharedPreferences(PREFS, 0).edit().remove("capability").remove("expires_at_ms").apply();
    }

    public final void store(Context context, String capability, long expiresInSeconds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(capability, "capability");
        if (!StringsKt.startsWith$default(capability, "ctcap1.", false, 2, (Object) null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        long expiresAt = (System.currentTimeMillis() + (1000 * expiresInSeconds)) - EXPIRY_SAFETY_MS;
        context.getSharedPreferences(PREFS, 0).edit().putString("capability", capability).putLong("expires_at_ms", expiresAt).remove("pending_state").remove("pkce_verifier").remove("pending_at_ms").apply();
    }

    public final boolean activationRequired(Context context) throws IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        URLConnection uRLConnectionOpenConnection = new URL(context.getString(R.string.api_base_url) + "/activation/status").openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection connection = (HttpURLConnection) uRLConnectionOpenConnection;
        try {
            connection.setConnectTimeout(8000);
            connection.setReadTimeout(8000);
            connection.setRequestProperty("X-API-Key", context.getString(R.string.api_key));
            AppRequestProfile.INSTANCE.apply(connection, context);
            int responseCode = connection.getResponseCode();
            if (!(200 <= responseCode && responseCode < 300)) {
                throw new IllegalStateException("activation status unavailable".toString());
            }
            InputStream inputStream = connection.getInputStream();
            Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
            Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            try {
                BufferedReader it = bufferedReader;
                String body = TextStreamsKt.readText(it);
                CloseableKt.closeFinally(bufferedReader, null);
                return new JSONObject(body).optBoolean("required", false);
            } finally {
            }
        } finally {
            connection.disconnect();
        }
    }

    public final void launch(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.startActivity(new Intent(context, (Class<?>) ActivationActivity.class));
    }
}
