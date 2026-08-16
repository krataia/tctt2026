package sh.sth.skylink;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.webkit.WebView;
import java.net.HttpURLConnection;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class AppRequestProfile {
    public static final String APP_ID = "sh.sth.skylink";
    public static final String APP_VERSION = "1";
    private static final String INSTALL_ID = "install_id_v1";
    private static final String PREFS = "request_profile";
    private static final SecureRandom RANDOM = new SecureRandom();
    public static final String USER_AGENT = "THCTT-Mobile02/1 (Android; sh.sth.skylink)";

    private AppRequestProfile() {
    }

    public static synchronized String installId(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS, 0);
        String existing = prefs.getString(INSTALL_ID, null);
        if (isCanonicalInstallId(existing)) {
            return existing;
        }
        byte[] bytes = new byte[16];
        RANDOM.nextBytes(bytes);
        String value = Base64.encodeToString(bytes, 11);
        if (!prefs.edit().putString(INSTALL_ID, value).commit()) {
            throw new IllegalStateException("cannot persist install profile");
        }
        if (context.getSharedPreferences("activation", 0).edit().remove("capability").remove("expiry").commit()) {
            return value;
        }
        throw new IllegalStateException("cannot reset bound capability");
    }

    private static boolean isCanonicalInstallId(String value) {
        if (value == null || !value.matches("[A-Za-z0-9_-]{22}")) {
            return false;
        }
        try {
            byte[] decoded = Base64.decode(value, 11);
            if (decoded.length == 16) {
                return value.equals(Base64.encodeToString(decoded, 11));
            }
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static void apply(HttpURLConnection connection, Context context) {
        connection.setRequestProperty("User-Agent", USER_AGENT);
        connection.setRequestProperty("X-THCTT-App-ID", APP_ID);
        connection.setRequestProperty("X-THCTT-App-Version", APP_VERSION);
        connection.setRequestProperty("X-THCTT-Install-ID", installId(context));
    }

    public static Map<String, String> webHeaders(Context context) {
        Map<String, String> headers = new HashMap<>();
        headers.put("X-THCTT-App-ID", APP_ID);
        headers.put("X-THCTT-App-Version", APP_VERSION);
        headers.put("X-THCTT-Install-ID", installId(context));
        return headers;
    }

    public static void configure(WebView webView) {
        webView.getSettings().setUserAgentString(USER_AGENT);
    }
}
