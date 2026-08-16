package sh.sth.somtam;

import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class MainActivity$onCreate$content$1$4$2$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TextView $deliveryStatus;
    final /* synthetic */ Button $this_apply;
    final /* synthetic */ MainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainActivity$onCreate$content$1$4$2$1$1(MainActivity mainActivity, TextView textView, Button button) {
        super(0);
        this.this$0 = mainActivity;
        this.$deliveryStatus = textView;
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
        try {
            try {
                try {
                    final String status = this.this$0.fetchDeliveryStatus();
                    MainActivity mainActivity2 = this.this$0;
                    final TextView textView = this.$deliveryStatus;
                    mainActivity2.runOnUiThread(new Runnable() { // from class: sh.sth.somtam.MainActivity$onCreate$content$1$4$2$1$1$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            MainActivity$onCreate$content$1$4$2$1$1.invoke$lambda$0(textView, status);
                        }
                    });
                    mainActivity = this.this$0;
                    final Button button = this.$this_apply;
                    runnable = new Runnable() { // from class: sh.sth.somtam.MainActivity$onCreate$content$1$4$2$1$1$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            MainActivity$onCreate$content$1$4$2$1$1.invoke$lambda$3(button);
                        }
                    };
                } catch (ActivationRequiredException e) {
                    MainActivity mainActivity3 = this.this$0;
                    final TextView textView2 = this.$deliveryStatus;
                    final MainActivity mainActivity4 = this.this$0;
                    mainActivity3.runOnUiThread(new Runnable() { // from class: sh.sth.somtam.MainActivity$onCreate$content$1$4$2$1$1$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            MainActivity$onCreate$content$1$4$2$1$1.invoke$lambda$1(textView2, mainActivity4);
                        }
                    });
                    mainActivity = this.this$0;
                    final Button button2 = this.$this_apply;
                    runnable = new Runnable() { // from class: sh.sth.somtam.MainActivity$onCreate$content$1$4$2$1$1$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            MainActivity$onCreate$content$1$4$2$1$1.invoke$lambda$3(button2);
                        }
                    };
                }
            } catch (Exception error) {
                Log.w("SomtamDelivery", "delivery-status request failed", error);
                MainActivity mainActivity5 = this.this$0;
                final TextView textView3 = this.$deliveryStatus;
                mainActivity5.runOnUiThread(new Runnable() { // from class: sh.sth.somtam.MainActivity$onCreate$content$1$4$2$1$1$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainActivity$onCreate$content$1$4$2$1$1.invoke$lambda$2(textView3);
                    }
                });
                mainActivity = this.this$0;
                final Button button3 = this.$this_apply;
                runnable = new Runnable() { // from class: sh.sth.somtam.MainActivity$onCreate$content$1$4$2$1$1$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainActivity$onCreate$content$1$4$2$1$1.invoke$lambda$3(button3);
                    }
                };
            }
            mainActivity.runOnUiThread(runnable);
        } catch (Throwable th) {
            MainActivity mainActivity6 = this.this$0;
            final Button button4 = this.$this_apply;
            mainActivity6.runOnUiThread(new Runnable() { // from class: sh.sth.somtam.MainActivity$onCreate$content$1$4$2$1$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity$onCreate$content$1$4$2$1$1.invoke$lambda$3(button4);
                }
            });
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(TextView deliveryStatus, String status) {
        Intrinsics.checkNotNullParameter(deliveryStatus, "$deliveryStatus");
        Intrinsics.checkNotNullParameter(status, "$status");
        deliveryStatus.setText(status);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(TextView deliveryStatus, MainActivity this$0) {
        Intrinsics.checkNotNullParameter(deliveryStatus, "$deliveryStatus");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        deliveryStatus.setText("กรุณายืนยันการใช้งานในเบราว์เซอร์");
        this$0.launchActivation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2(TextView deliveryStatus) {
        Intrinsics.checkNotNullParameter(deliveryStatus, "$deliveryStatus");
        deliveryStatus.setText("ยังตรวจพื้นที่จัดส่งไม่ได้ กรุณาลองอีกครั้ง");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$3(Button this_apply) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.setEnabled(true);
    }
}
