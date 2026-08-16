package sh.sth.lotterychecker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import sh.sth.lotterychecker.MainActivity;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0015\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\rH\u0000¢\u0006\u0002\b\u0019J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\u0012\u0010\u001b\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\"\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0004H\u0002J\u0010\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lsh/sth/lotterychecker/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "activationLaunchStarted", "", "buySpecialButton", "Landroid/widget/Button;", "checkButton", "lotteryInput", "Landroid/widget/EditText;", "resultText", "Landroid/widget/TextView;", "sharedPrefsName", "", "storageMask", "", "buySpecialTicket", "", "checkActivationState", "checkLottery", "isActivationRequired", "connection", "Ljava/net/HttpURLConnection;", "isActivationRequiredBody", "body", "isActivationRequiredBody$app_debug", "launchActivation", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "request", "url", "apiKey", "capability", "setActionsEnabled", "enabled", "storeWinnerSecretInsecurely", "secret", "ActivationRequiredException", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class MainActivity extends AppCompatActivity {
    private boolean activationLaunchStarted;
    private Button buySpecialButton;
    private Button checkButton;
    private EditText lotteryInput;
    private TextView resultText;
    private final String sharedPrefsName = StringsKt.replace$default("winner_secrets.xml", ".xml", "", false, 4, (Object) null);
    private final int storageMask = 90;

    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lsh/sth/lotterychecker/MainActivity$ActivationRequiredException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private static final class ActivationRequiredException extends Exception {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View viewFindViewById = findViewById(R.id.lotteryInput);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.lotteryInput = (EditText) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.resultText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.resultText = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.checkButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.checkButton = (Button) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.buySpecialButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.buySpecialButton = (Button) viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.footerText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        TextView footerText = (TextView) viewFindViewById5;
        footerText.setText(getString(R.string.about_text, new Object[]{getString(R.string.footer_credit)}));
        Button button = this.checkButton;
        Button button2 = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkButton");
            button = null;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: sh.sth.lotterychecker.MainActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.onCreate$lambda$0(this.f$0, view);
            }
        });
        Button button3 = this.buySpecialButton;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buySpecialButton");
        } else {
            button2 = button3;
        }
        button2.setOnClickListener(new View.OnClickListener() { // from class: sh.sth.lotterychecker.MainActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.onCreate$lambda$1(this.f$0, view);
            }
        });
        checkActivationState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(MainActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.checkLottery();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(MainActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.buySpecialTicket();
    }

    private final void checkActivationState() {
        if (CapabilityStore.INSTANCE.get(this) != null) {
            setActionsEnabled(true);
            return;
        }
        setActionsEnabled(false);
        TextView textView = this.resultText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultText");
            textView = null;
        }
        textView.setText("กำลังตรวจสอบสถานะการเปิดใช้งาน…");
        ThreadsKt.thread((21 & 1) != 0, (21 & 2) != 0 ? false : false, (21 & 4) != 0 ? null : null, (21 & 8) != 0 ? null : null, (21 & 16) != 0 ? -1 : 0, new C01331());
    }

    /* JADX INFO: renamed from: sh.sth.lotterychecker.MainActivity$checkActivationState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    static final class C01331 extends Lambda implements Function0<Unit> {
        C01331() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws IOException {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws IOException {
            final Boolean enabled = ActivationActivity.INSTANCE.activationEnabled(MainActivity.this);
            MainActivity mainActivity = MainActivity.this;
            final MainActivity mainActivity2 = MainActivity.this;
            mainActivity.runOnUiThread(new Runnable() { // from class: sh.sth.lotterychecker.MainActivity$checkActivationState$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.C01331.invoke$lambda$0(enabled, mainActivity2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(Boolean $enabled, MainActivity this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (Intrinsics.areEqual((Object) $enabled, (Object) true)) {
                this$0.launchActivation();
                return;
            }
            TextView textView = null;
            if (Intrinsics.areEqual((Object) $enabled, (Object) false)) {
                TextView textView2 = this$0.resultText;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("resultText");
                } else {
                    textView = textView2;
                }
                textView.setText("พร้อมตรวจผลสลาก");
                this$0.setActionsEnabled(true);
                return;
            }
            if ($enabled == null) {
                TextView textView3 = this$0.resultText;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("resultText");
                } else {
                    textView = textView3;
                }
                textView.setText("ยังเชื่อมต่อบริการไม่ได้ กรุณาเปิดแอปใหม่อีกครั้ง");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setActionsEnabled(boolean enabled) {
        Button button = this.checkButton;
        Button button2 = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkButton");
            button = null;
        }
        button.setEnabled(enabled);
        Button button3 = this.buySpecialButton;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buySpecialButton");
        } else {
            button2 = button3;
        }
        button2.setEnabled(enabled);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchActivation() {
        if (this.activationLaunchStarted || isFinishing() || isDestroyed()) {
            return;
        }
        this.activationLaunchStarted = true;
        startActivity(new Intent(this, (Class<?>) ActivationActivity.class));
        finish();
    }

    private final void checkLottery() {
        EditText editText = this.lotteryInput;
        TextView textView = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lotteryInput");
            editText = null;
        }
        String number = StringsKt.trim((CharSequence) editText.getText().toString()).toString();
        if (number.length() == 6) {
            String $this$all$iv = number;
            boolean z = false;
            int i = 0;
            while (true) {
                if (i < $this$all$iv.length()) {
                    char element$iv = $this$all$iv.charAt(i);
                    if (!Character.isDigit(element$iv)) {
                        break;
                    } else {
                        i++;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            if (z) {
                String apiKey = getString(R.string.api_key);
                Intrinsics.checkNotNullExpressionValue(apiKey, "getString(...)");
                String capability = CapabilityStore.INSTANCE.get(this);
                String baseUrl = getString(R.string.api_base_url);
                Intrinsics.checkNotNullExpressionValue(baseUrl, "getString(...)");
                String url = baseUrl + "/check?number=" + number;
                ThreadsKt.thread((21 & 1) != 0, (21 & 2) != 0 ? false : false, (21 & 4) != 0 ? null : null, (21 & 8) != 0 ? null : null, (21 & 16) != 0 ? -1 : 0, new AnonymousClass2(url, apiKey, capability, number));
                return;
            }
        }
        TextView textView2 = this.resultText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultText");
        } else {
            textView = textView2;
        }
        textView.setText("กรุณาใส่เลขสลาก 6 หลัก");
    }

    /* JADX INFO: renamed from: sh.sth.lotterychecker.MainActivity$checkLottery$2, reason: invalid class name */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        final /* synthetic */ String $apiKey;
        final /* synthetic */ String $capability;
        final /* synthetic */ String $number;
        final /* synthetic */ String $url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, String str2, String str3, String str4) {
            super(0);
            this.$url = str;
            this.$apiKey = str2;
            this.$capability = str3;
            this.$number = str4;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            try {
                String response = MainActivity.this.request(this.$url, this.$apiKey, this.$capability);
                final JSONObject result = new JSONObject(response);
                MainActivity mainActivity = MainActivity.this;
                final MainActivity mainActivity2 = MainActivity.this;
                final String str = this.$number;
                mainActivity.runOnUiThread(new Runnable() { // from class: sh.sth.lotterychecker.MainActivity$checkLottery$2$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainActivity.AnonymousClass2.invoke$lambda$0(mainActivity2, result, str);
                    }
                });
            } catch (ActivationRequiredException e) {
                MainActivity mainActivity3 = MainActivity.this;
                final MainActivity mainActivity4 = MainActivity.this;
                mainActivity3.runOnUiThread(new Runnable() { // from class: sh.sth.lotterychecker.MainActivity$checkLottery$2$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainActivity.AnonymousClass2.invoke$lambda$1(mainActivity4);
                    }
                });
            } catch (Exception e2) {
                MainActivity mainActivity5 = MainActivity.this;
                final MainActivity mainActivity6 = MainActivity.this;
                mainActivity5.runOnUiThread(new Runnable() { // from class: sh.sth.lotterychecker.MainActivity$checkLottery$2$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainActivity.AnonymousClass2.invoke$lambda$2(mainActivity6);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(MainActivity this$0, JSONObject result, String number) {
            String str;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(result, "$result");
            Intrinsics.checkNotNullParameter(number, "$number");
            TextView textView = this$0.resultText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resultText");
                textView = null;
            }
            if (Intrinsics.areEqual(result.getString("result"), "win")) {
                str = "ยินดีด้วย เลข " + number + " ถูกรางวัล " + result.getString("prize") + "\nเงินรางวัล " + result.getInt("amount_baht") + " บาท";
            } else {
                str = "เลข " + number + " ไม่ถูกรางวัลในงวดนี้\nขอให้โชคดีในครั้งต่อไป";
            }
            textView.setText(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$1(MainActivity this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.launchActivation();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$2(MainActivity this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            TextView textView = this$0.resultText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resultText");
                textView = null;
            }
            textView.setText("ยังตรวจผลสลากไม่ได้ กรุณาลองใหม่อีกครั้ง");
        }
    }

    private final void buySpecialTicket() {
        TextView textView = this.resultText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultText");
            textView = null;
        }
        textView.setText("กำลังยืนยันการซื้อสลากพิเศษ…");
        String apiKey = getString(R.string.api_key);
        Intrinsics.checkNotNullExpressionValue(apiKey, "getString(...)");
        String capability = CapabilityStore.INSTANCE.get(this);
        String url = getString(R.string.api_base_url) + "/api/purchase-material";
        ThreadsKt.thread((21 & 1) != 0, (21 & 2) != 0 ? false : false, (21 & 4) != 0 ? null : null, (21 & 8) != 0 ? null : null, (21 & 16) != 0 ? -1 : 0, new AnonymousClass1(url, apiKey, capability));
    }

    /* JADX INFO: renamed from: sh.sth.lotterychecker.MainActivity$buySpecialTicket$1, reason: invalid class name */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        final /* synthetic */ String $apiKey;
        final /* synthetic */ String $capability;
        final /* synthetic */ String $url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, String str3) {
            super(0);
            this.$url = str;
            this.$apiKey = str2;
            this.$capability = str3;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            try {
                String body = MainActivity.this.request(this.$url, this.$apiKey, this.$capability);
                String encoded = new JSONObject(body).getString("winner_secret");
                MainActivity mainActivity = MainActivity.this;
                Intrinsics.checkNotNull(encoded);
                mainActivity.storeWinnerSecretInsecurely(encoded);
                MainActivity mainActivity2 = MainActivity.this;
                final MainActivity mainActivity3 = MainActivity.this;
                mainActivity2.runOnUiThread(new Runnable() { // from class: sh.sth.lotterychecker.MainActivity$buySpecialTicket$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainActivity.AnonymousClass1.invoke$lambda$0(mainActivity3);
                    }
                });
            } catch (ActivationRequiredException e) {
                MainActivity mainActivity4 = MainActivity.this;
                final MainActivity mainActivity5 = MainActivity.this;
                mainActivity4.runOnUiThread(new Runnable() { // from class: sh.sth.lotterychecker.MainActivity$buySpecialTicket$1$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainActivity.AnonymousClass1.invoke$lambda$1(mainActivity5);
                    }
                });
            } catch (Exception e2) {
                MainActivity mainActivity6 = MainActivity.this;
                final MainActivity mainActivity7 = MainActivity.this;
                mainActivity6.runOnUiThread(new Runnable() { // from class: sh.sth.lotterychecker.MainActivity$buySpecialTicket$1$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainActivity.AnonymousClass1.invoke$lambda$2(mainActivity7);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(MainActivity this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            TextView textView = this$0.resultText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resultText");
                textView = null;
            }
            textView.setText("สลากพิเศษพร้อมตรวจสอบในบัญชีของคุณ");
            Toast.makeText(this$0, "สั่งซื้อสลากพิเศษเรียบร้อย!", 0).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$1(MainActivity this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.launchActivation();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$2(MainActivity this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            TextView textView = this$0.resultText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resultText");
                textView = null;
            }
            textView.setText("ยังสั่งซื้อสลากพิเศษไม่ได้ กรุณาลองใหม่อีกครั้ง");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void storeWinnerSecretInsecurely(String secret) {
        long now = System.currentTimeMillis();
        SharedPreferences prefs = getSharedPreferences(this.sharedPrefsName, 0);
        prefs.edit().putBoolean("special_ticket_purchased", true).putLong("purchase_timestamp_ms", now).putString("winner_secret", secret).putString("ticket_id", "TH-LOTO-2026-SPECIAL-0007").apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String request(String url, String apiKey, String capability) throws IOException {
        URLConnection uRLConnectionOpenConnection = new URL(url).openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection connection = (HttpURLConnection) uRLConnectionOpenConnection;
        try {
            connection.setRequestProperty("X-API-Key", apiKey);
            AppRequestProfile.INSTANCE.apply(connection, this);
            if (capability != null) {
                connection.setRequestProperty("X-Challenge-Capability", capability);
            }
            connection.setConnectTimeout(8000);
            connection.setReadTimeout(8000);
            if (isActivationRequired(connection)) {
                throw new ActivationRequiredException();
            }
            if (!(connection.getResponseCode() == 200)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            InputStream inputStream = connection.getInputStream();
            Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
            Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            try {
                BufferedReader it = bufferedReader;
                String text = TextStreamsKt.readText(it);
                CloseableKt.closeFinally(bufferedReader, null);
                return text;
            } finally {
            }
        } finally {
            connection.disconnect();
        }
    }

    private final boolean isActivationRequired(HttpURLConnection connection) {
        if (connection.getResponseCode() == 403) {
            String contentType = connection.getContentType();
            if (contentType == null) {
                contentType = "";
            }
            if (StringsKt.startsWith$default(contentType, "application/json", false, 2, (Object) null)) {
                try {
                    InputStream errorStream = connection.getErrorStream();
                    if (errorStream != null) {
                        Reader inputStreamReader = new InputStreamReader(errorStream, Charsets.UTF_8);
                        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                        try {
                            BufferedReader it = bufferedReader;
                            String body = TextStreamsKt.readText(it);
                            CloseableKt.closeFinally(bufferedReader, null);
                            if (body != null) {
                                return isActivationRequiredBody$app_debug(body);
                            }
                        } finally {
                        }
                    }
                    return false;
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return false;
    }

    public final boolean isActivationRequiredBody$app_debug(String body) {
        boolean z;
        Intrinsics.checkNotNullParameter(body, "body");
        if (body.length() > 4096) {
            return false;
        }
        try {
            JSONObject json = new JSONObject(body);
            if ((json.opt("error") instanceof String) && Intrinsics.areEqual(json.optString("error"), "activation_required")) {
                Iterator<String> itKeys = json.keys();
                Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
                Sequence $this$all$iv = SequencesKt.asSequence(itKeys);
                Iterator it = $this$all$iv.iterator();
                do {
                    z = true;
                    if (!it.hasNext()) {
                        return true;
                    }
                    Object element$iv = it.next();
                    String it2 = (String) element$iv;
                    if (!Intrinsics.areEqual(it2, "error") && !Intrinsics.areEqual(it2, "system_policy") && !Intrinsics.areEqual(it2, "policy")) {
                        z = false;
                    }
                } while (z);
                return false;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
