package sh.sth.lotterychecker;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ActivationActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lsh/sth/lotterychecker/CapabilityStore;", "", "()V", "get", "", "context", "Landroid/content/Context;", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CapabilityStore {
    public static final CapabilityStore INSTANCE = new CapabilityStore();

    private CapabilityStore() {
    }

    public final String get(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences prefs = context.getSharedPreferences("activation", 0);
        if (prefs.getLong("expiry", 0L) <= System.currentTimeMillis()) {
            prefs.edit().remove("capability").remove("expiry").apply();
            return null;
        }
        String it = prefs.getString("capability", null);
        if (it == null || !StringsKt.startsWith$default(it, "ctcap1.", false, 2, (Object) null)) {
            return null;
        }
        return it;
    }
}
