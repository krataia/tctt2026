package sh.sth.somtam;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import java.net.HttpURLConnection;
import java.security.SecureRandom;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: compiled from: AppRequestProfile.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lsh/sth/somtam/AppRequestProfile;", "", "()V", "APP_ID", "", "APP_VERSION", "INSTALL_ID", "PREFS", "USER_AGENT", "installPattern", "Lkotlin/text/Regex;", "random", "Ljava/security/SecureRandom;", "apply", "", "connection", "Ljava/net/HttpURLConnection;", "context", "Landroid/content/Context;", "installId", "isCanonicalInstallId", "", "value", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppRequestProfile {
    public static final String APP_ID = "sh.sth.somtam";
    public static final String APP_VERSION = "1";
    private static final String INSTALL_ID = "install_id_v1";
    private static final String PREFS = "request_profile";
    public static final String USER_AGENT = "THCTT-Mobile03/1 (Android; sh.sth.somtam)";
    public static final AppRequestProfile INSTANCE = new AppRequestProfile();
    private static final SecureRandom random = new SecureRandom();
    private static final Regex installPattern = new Regex("^[A-Za-z0-9_-]{22}$");

    private AppRequestProfile() {
    }

    public final synchronized String installId(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences prefs = context.getSharedPreferences(PREFS, 0);
        String p0 = prefs.getString(INSTALL_ID, null);
        if (p0 != null) {
            String str = isCanonicalInstallId(p0) ? p0 : null;
            if (str != null) {
                String it = str;
                return it;
            }
        }
        byte[] p02 = new byte[16];
        random.nextBytes(p02);
        String value = Base64.encodeToString(p02, 11);
        if (!prefs.edit().putString(INSTALL_ID, value).commit()) {
            throw new IllegalStateException("cannot persist install profile".toString());
        }
        if (!context.getSharedPreferences("challenge_access", 0).edit().remove("capability").remove("expires_at_ms").commit()) {
            throw new IllegalStateException("cannot reset bound capability".toString());
        }
        Intrinsics.checkNotNull(value);
        return value;
    }

    private final boolean isCanonicalInstallId(String value) {
        Object objM42constructorimpl;
        if (!installPattern.matches(value)) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            AppRequestProfile appRequestProfile = this;
            byte[] decoded = Base64.decode(value, 11);
            objM42constructorimpl = Result.m42constructorimpl(Boolean.valueOf(decoded.length == 16 && Intrinsics.areEqual(Base64.encodeToString(decoded, 11), value)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM42constructorimpl = Result.m42constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m48isFailureimpl(objM42constructorimpl)) {
            objM42constructorimpl = false;
        }
        return ((Boolean) objM42constructorimpl).booleanValue();
    }

    public final void apply(HttpURLConnection connection, Context context) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(context, "context");
        connection.setRequestProperty("User-Agent", USER_AGENT);
        connection.setRequestProperty("X-THCTT-App-ID", APP_ID);
        connection.setRequestProperty("X-THCTT-App-Version", APP_VERSION);
        connection.setRequestProperty("X-THCTT-Install-ID", installId(context));
    }
}
