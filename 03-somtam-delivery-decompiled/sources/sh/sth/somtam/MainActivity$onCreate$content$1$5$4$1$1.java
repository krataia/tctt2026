package sh.sth.somtam;

import android.widget.Button;
import android.widget.Toast;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class MainActivity$onCreate$content$1$5$4$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Button $this_apply;
    final /* synthetic */ MainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainActivity$onCreate$content$1$5$4$1$1(MainActivity mainActivity, Button button) {
        super(0);
        this.this$0 = mainActivity;
        this.$this_apply = button;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        MainActivity mainActivity;
        Runnable runnable;
        byte[] payload;
        byte[] keyNonce;
        try {
            try {
                InputStream inputStreamOpen = this.this$0.getAssets().open("payload.bin");
                try {
                    InputStream it = inputStreamOpen;
                    Intrinsics.checkNotNull(it);
                    payload = ByteStreamsKt.readBytes(it);
                    CloseableKt.closeFinally(inputStreamOpen, null);
                    keyNonce = this.this$0.fetchKeyNonce();
                } finally {
                }
            } catch (ActivationRequiredException e) {
                MainActivity mainActivity2 = this.this$0;
                final MainActivity mainActivity3 = this.this$0;
                mainActivity2.runOnUiThread(new Runnable() { // from class: sh.sth.somtam.MainActivity$onCreate$content$1$5$4$1$1$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainActivity$onCreate$content$1$5$4$1$1.invoke$lambda$3(mainActivity3);
                    }
                });
                mainActivity = this.this$0;
                final Button button = this.$this_apply;
                runnable = new Runnable() { // from class: sh.sth.somtam.MainActivity$onCreate$content$1$5$4$1$1$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainActivity$onCreate$content$1$5$4$1$1.invoke$lambda$5(button);
                    }
                };
            } catch (Exception e2) {
                MainActivity mainActivity4 = this.this$0;
                final MainActivity mainActivity5 = this.this$0;
                mainActivity4.runOnUiThread(new Runnable() { // from class: sh.sth.somtam.MainActivity$onCreate$content$1$5$4$1$1$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainActivity$onCreate$content$1$5$4$1$1.invoke$lambda$4(mainActivity5);
                    }
                });
                mainActivity = this.this$0;
                final Button button2 = this.$this_apply;
                runnable = new Runnable() { // from class: sh.sth.somtam.MainActivity$onCreate$content$1$5$4$1$1$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainActivity$onCreate$content$1$5$4$1$1.invoke$lambda$5(button2);
                    }
                };
            }
            if (!(keyNonce.length == 16)) {
                throw new IllegalArgumentException("invalid key nonce".toString());
            }
            this.this$0.processPayload(payload, keyNonce);
            MainActivity mainActivity6 = this.this$0;
            final MainActivity mainActivity7 = this.this$0;
            mainActivity6.runOnUiThread(new Runnable() { // from class: sh.sth.somtam.MainActivity$onCreate$content$1$5$4$1$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity$onCreate$content$1$5$4$1$1.invoke$lambda$2(mainActivity7);
                }
            });
            mainActivity = this.this$0;
            final Button button3 = this.$this_apply;
            runnable = new Runnable() { // from class: sh.sth.somtam.MainActivity$onCreate$content$1$5$4$1$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity$onCreate$content$1$5$4$1$1.invoke$lambda$5(button3);
                }
            };
            mainActivity.runOnUiThread(runnable);
        } catch (Throwable th) {
            MainActivity mainActivity8 = this.this$0;
            final Button button4 = this.$this_apply;
            mainActivity8.runOnUiThread(new Runnable() { // from class: sh.sth.somtam.MainActivity$onCreate$content$1$5$4$1$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity$onCreate$content$1$5$4$1$1.invoke$lambda$5(button4);
                }
            });
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2(MainActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Toast.makeText(this$0, "Keep earning points to unlock Chef's Special.", 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$3(MainActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Toast.makeText(this$0, "กรุณายืนยันการใช้งานในเบราว์เซอร์", 1).show();
        this$0.launchActivation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$4(MainActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Toast.makeText(this$0, "Chef's Special service is temporarily unavailable.", 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$5(Button this_apply) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.setEnabled(true);
    }
}
