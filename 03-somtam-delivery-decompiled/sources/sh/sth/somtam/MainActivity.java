package sh.sth.somtam;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import sh.sth.somtam.MainActivity;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0012\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u000fH\u0014J\u0019\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\rH\u0082 J)\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010\u001dJ\u001c\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lsh/sth/somtam/MainActivity;", "Landroid/app/Activity;", "()V", "activationLaunching", "", "dp", "", "value", "fetchApiText", "", "path", "fetchDeliveryStatus", "fetchKeyNonce", "", "launchActivation", "", "looksRooted", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "processPayload", "payload", "keyNonce", "rounded", "Landroid/graphics/drawable/GradientDrawable;", "color", "radius", "strokeColor", "(IILjava/lang/Integer;)Landroid/graphics/drawable/GradientDrawable;", "verticalParams", "Landroid/widget/LinearLayout$LayoutParams;", "height", "top", "Companion", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MainActivity extends Activity {
    private static final int NETWORK_TIMEOUT_MS = 8000;
    private static final String TAG = "SomtamDelivery";
    private volatile boolean activationLaunching;

    /* JADX INFO: Access modifiers changed from: private */
    public final native String processPayload(byte[] payload, byte[] keyNonce);

    static {
        System.loadLibrary("core");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] fetchKeyNonce() throws JSONException, IOException {
        String body = fetchApiText("/api/delivery/config");
        String hex = new JSONObject(body).getString("key_nonce_hex");
        Intrinsics.checkNotNull(hex);
        Iterable $this$map$iv = StringsKt.chunked(hex, 2);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(Byte.valueOf((byte) Integer.parseInt(it, CharsKt.checkRadix(16))));
        }
        return CollectionsKt.toByteArray((List) destination$iv$iv);
    }

    private final String fetchApiText(String path) throws IOException {
        String base = getString(R.string.api_base_url);
        Intrinsics.checkNotNullExpressionValue(base, "getString(...)");
        URLConnection uRLConnectionOpenConnection = new URL(base + path).openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection connection = (HttpURLConnection) uRLConnectionOpenConnection;
        connection.setConnectTimeout(NETWORK_TIMEOUT_MS);
        connection.setReadTimeout(NETWORK_TIMEOUT_MS);
        connection.setRequestProperty("X-API-Key", getString(R.string.api_key));
        AppRequestProfile.INSTANCE.apply(connection, this);
        String it = ChallengeCapability.INSTANCE.get(this);
        if (it != null) {
            connection.setRequestProperty("X-Challenge-Capability", it);
        }
        try {
            if (connection.getResponseCode() == 403) {
                ChallengeCapability.INSTANCE.clear(this);
                throw new ActivationRequiredException();
            }
            int responseCode = connection.getResponseCode();
            boolean z = false;
            if (200 <= responseCode && responseCode < 300) {
                z = true;
            }
            if (!z) {
                throw new IllegalStateException("API request rejected".toString());
            }
            InputStream inputStream = connection.getInputStream();
            Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
            Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
            BufferedReader it2 = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            try {
                String text = TextStreamsKt.readText(it2);
                CloseableKt.closeFinally(it2, null);
                return text;
            } finally {
            }
        } finally {
            connection.disconnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchActivation() {
        if (this.activationLaunching) {
            return;
        }
        this.activationLaunching = true;
        ChallengeCapability.INSTANCE.launch(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String fetchDeliveryStatus() throws JSONException, IOException {
        String localizedArea;
        String body = fetchApiText("/api/delivery/status");
        JSONObject json = new JSONObject(body);
        int eta = json.getInt("eta_minutes");
        String serviceArea = json.getString("service_area");
        if (StringsKt.equals(serviceArea, "Bangkok metropolitan area", true)) {
            localizedArea = "กรุงเทพฯ และปริมณฑล";
        } else {
            localizedArea = serviceArea;
        }
        return "ให้บริการใน " + localizedArea + "\nถึงโดยเฉลี่ย " + eta + " นาที";
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.rgb(255, 249, 242));
        getWindow().getDecorView().setSystemUiVisibility(8192);
        if (ChallengeCapability.INSTANCE.get(this) == null) {
            ThreadsKt.thread((23 & 1) != 0, (23 & 2) != 0 ? false : false, (23 & 4) != 0 ? null : null, (23 & 8) != 0 ? null : "activation-status", (23 & 16) != 0 ? -1 : 0, new AnonymousClass1());
        }
        LinearLayout $this$onCreate_u24lambda_u2419 = new LinearLayout(this);
        $this$onCreate_u24lambda_u2419.setOrientation(1);
        $this$onCreate_u24lambda_u2419.setPadding(dp(20), dp(28), dp(20), dp(28));
        $this$onCreate_u24lambda_u2419.setBackgroundColor(Color.rgb(255, 249, 242));
        TextView $this$onCreate_u24lambda_u2419_u24lambda_u244 = new TextView(this);
        $this$onCreate_u24lambda_u2419_u24lambda_u244.setText("Somtam Delivery");
        $this$onCreate_u24lambda_u2419_u24lambda_u244.setTextSize(28.0f);
        $this$onCreate_u24lambda_u2419_u24lambda_u244.setTextColor(Color.rgb(46, 32, 24));
        $this$onCreate_u24lambda_u2419.addView($this$onCreate_u24lambda_u2419_u24lambda_u244);
        TextView $this$onCreate_u24lambda_u2419_u24lambda_u245 = new TextView(this);
        $this$onCreate_u24lambda_u2419_u24lambda_u245.setText("ส้มตำรสจัด ส่งตรงจากครัวถึงบ้านคุณ");
        $this$onCreate_u24lambda_u2419_u24lambda_u245.setTextSize(16.0f);
        $this$onCreate_u24lambda_u2419_u24lambda_u245.setTextColor(Color.rgb(117, 92, 76));
        $this$onCreate_u24lambda_u2419_u24lambda_u245.setLayoutParams(verticalParams$default(this, 0, 4, 1, null));
        $this$onCreate_u24lambda_u2419.addView($this$onCreate_u24lambda_u2419_u24lambda_u245);
        ImageView $this$onCreate_u24lambda_u2419_u24lambda_u246 = new ImageView(this);
        $this$onCreate_u24lambda_u2419_u24lambda_u246.setImageResource(R.drawable.dish_somtam_thai);
        $this$onCreate_u24lambda_u2419_u24lambda_u246.setContentDescription("ส้มตำไทย");
        $this$onCreate_u24lambda_u2419_u24lambda_u246.setScaleType(ImageView.ScaleType.CENTER_CROP);
        $this$onCreate_u24lambda_u2419_u24lambda_u246.setBackground(rounded$default(this, -1, 20, null, 4, null));
        $this$onCreate_u24lambda_u2419_u24lambda_u246.setClipToOutline(true);
        $this$onCreate_u24lambda_u2419_u24lambda_u246.setElevation(dp(2));
        $this$onCreate_u24lambda_u2419_u24lambda_u246.setLayoutParams(verticalParams(184, 22));
        $this$onCreate_u24lambda_u2419.addView($this$onCreate_u24lambda_u2419_u24lambda_u246);
        final TextView $this$onCreate_u24lambda_u2419_u24lambda_u247 = new TextView(this);
        $this$onCreate_u24lambda_u2419_u24lambda_u247.setText("ตรวจสอบพื้นที่จัดส่งและเวลาถึงโดยประมาณ");
        $this$onCreate_u24lambda_u2419_u24lambda_u247.setTextSize(14.0f);
        $this$onCreate_u24lambda_u2419_u24lambda_u247.setTextColor(Color.rgb(67, 86, 71));
        $this$onCreate_u24lambda_u2419_u24lambda_u247.setLayoutParams(verticalParams$default(this, 0, 8, 1, null));
        LinearLayout $this$onCreate_u24lambda_u2419_u24lambda_u2411 = new LinearLayout(this);
        $this$onCreate_u24lambda_u2419_u24lambda_u2411.setOrientation(1);
        $this$onCreate_u24lambda_u2419_u24lambda_u2411.setPadding(dp(16), dp(16), dp(16), dp(16));
        $this$onCreate_u24lambda_u2419_u24lambda_u2411.setBackground(rounded$default(this, Color.rgb(234, 245, 237), 18, null, 4, null));
        $this$onCreate_u24lambda_u2419_u24lambda_u2411.setLayoutParams(verticalParams$default(this, 0, 18, 1, null));
        TextView $this$onCreate_u24lambda_u2419_u24lambda_u2411_u24lambda_u248 = new TextView(this);
        $this$onCreate_u24lambda_u2419_u24lambda_u2411_u24lambda_u248.setText("จัดส่งถึงบ้านทุกวัน");
        $this$onCreate_u24lambda_u2419_u24lambda_u2411_u24lambda_u248.setTextSize(18.0f);
        $this$onCreate_u24lambda_u2419_u24lambda_u2411_u24lambda_u248.setTextColor(Color.rgb(38, 113, 61));
        $this$onCreate_u24lambda_u2419_u24lambda_u2411.addView($this$onCreate_u24lambda_u2419_u24lambda_u2411_u24lambda_u248);
        $this$onCreate_u24lambda_u2419_u24lambda_u2411.addView($this$onCreate_u24lambda_u2419_u24lambda_u247);
        final Button $this$onCreate_u24lambda_u2419_u24lambda_u2411_u24lambda_u2410 = new Button(this);
        $this$onCreate_u24lambda_u2419_u24lambda_u2411_u24lambda_u2410.setText("ตรวจสอบพื้นที่จัดส่ง");
        $this$onCreate_u24lambda_u2419_u24lambda_u2411_u24lambda_u2410.setTextColor(-1);
        $this$onCreate_u24lambda_u2419_u24lambda_u2411_u24lambda_u2410.setBackground(rounded$default(this, Color.rgb(38, 113, 61), 12, null, 4, null));
        $this$onCreate_u24lambda_u2419_u24lambda_u2411_u24lambda_u2410.setLayoutParams(verticalParams$default(this, 0, 12, 1, null));
        $this$onCreate_u24lambda_u2419_u24lambda_u2411_u24lambda_u2410.setOnClickListener(new View.OnClickListener() { // from class: sh.sth.somtam.MainActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.onCreate$lambda$19$lambda$11$lambda$10$lambda$9($this$onCreate_u24lambda_u2419_u24lambda_u2411_u24lambda_u2410, $this$onCreate_u24lambda_u2419_u24lambda_u247, this, view);
            }
        });
        $this$onCreate_u24lambda_u2419_u24lambda_u2411.addView($this$onCreate_u24lambda_u2419_u24lambda_u2411_u24lambda_u2410);
        $this$onCreate_u24lambda_u2419.addView($this$onCreate_u24lambda_u2419_u24lambda_u2411);
        LinearLayout $this$onCreate_u24lambda_u2419_u24lambda_u2417 = new LinearLayout(this);
        $this$onCreate_u24lambda_u2419_u24lambda_u2417.setOrientation(1);
        $this$onCreate_u24lambda_u2419_u24lambda_u2417.setPadding(dp(16), dp(18), dp(16), dp(16));
        $this$onCreate_u24lambda_u2419_u24lambda_u2417.setBackground(rounded(-1, 18, Integer.valueOf(Color.rgb(232, 218, 204))));
        $this$onCreate_u24lambda_u2419_u24lambda_u2417.setElevation(dp(1));
        $this$onCreate_u24lambda_u2419_u24lambda_u2417.setLayoutParams(verticalParams$default(this, 0, 18, 1, null));
        TextView $this$onCreate_u24lambda_u2419_u24lambda_u2417_u24lambda_u2412 = new TextView(this);
        $this$onCreate_u24lambda_u2419_u24lambda_u2417_u24lambda_u2412.setText("เมนูประจำฤดูกาล");
        $this$onCreate_u24lambda_u2419_u24lambda_u2417_u24lambda_u2412.setTextSize(12.0f);
        $this$onCreate_u24lambda_u2419_u24lambda_u2417_u24lambda_u2412.setLetterSpacing(0.08f);
        $this$onCreate_u24lambda_u2419_u24lambda_u2417_u24lambda_u2412.setTextColor(Color.rgb(38, 113, 61));
        $this$onCreate_u24lambda_u2419_u24lambda_u2417.addView($this$onCreate_u24lambda_u2419_u24lambda_u2417_u24lambda_u2412);
        TextView $this$onCreate_u24lambda_u2419_u24lambda_u2417_u24lambda_u2413 = new TextView(this);
        $this$onCreate_u24lambda_u2419_u24lambda_u2417_u24lambda_u2413.setText("สิทธิพิเศษสำหรับสมาชิก");
        $this$onCreate_u24lambda_u2419_u24lambda_u2417_u24lambda_u2413.setTextSize(20.0f);
        $this$onCreate_u24lambda_u2419_u24lambda_u2417_u24lambda_u2413.setTextColor(Color.rgb(46, 32, 24));
        $this$onCreate_u24lambda_u2419_u24lambda_u2417_u24lambda_u2413.setLayoutParams(verticalParams$default(this, 0, 4, 1, null));
        $this$onCreate_u24lambda_u2419_u24lambda_u2417.addView($this$onCreate_u24lambda_u2419_u24lambda_u2417_u24lambda_u2413);
        TextView $this$onCreate_u24lambda_u2419_u24lambda_u2417_u24lambda_u2414 = new TextView(this);
        $this$onCreate_u24lambda_u2419_u24lambda_u2417_u24lambda_u2414.setText("สะสมแต้มเพื่อรับสิทธิ์ดูเมนูเพิ่มเติม");
        $this$onCreate_u24lambda_u2419_u24lambda_u2417_u24lambda_u2414.setTextSize(14.0f);
        $this$onCreate_u24lambda_u2419_u24lambda_u2417_u24lambda_u2414.setTextColor(Color.rgb(117, 92, 76));
        $this$onCreate_u24lambda_u2419_u24lambda_u2417_u24lambda_u2414.setLayoutParams(verticalParams$default(this, 0, 4, 1, null));
        $this$onCreate_u24lambda_u2419_u24lambda_u2417.addView($this$onCreate_u24lambda_u2419_u24lambda_u2417_u24lambda_u2414);
        final Button $this$onCreate_u24lambda_u2419_u24lambda_u2417_u24lambda_u2416 = new Button(this);
        $this$onCreate_u24lambda_u2419_u24lambda_u2417_u24lambda_u2416.setText("ดูสิทธิพิเศษ");
        $this$onCreate_u24lambda_u2419_u24lambda_u2417_u24lambda_u2416.setTextColor(Color.rgb(38, 113, 61));
        $this$onCreate_u24lambda_u2419_u24lambda_u2417_u24lambda_u2416.setBackground(rounded(0, 12, Integer.valueOf(Color.rgb(38, 113, 61))));
        $this$onCreate_u24lambda_u2419_u24lambda_u2417_u24lambda_u2416.setLayoutParams(verticalParams$default(this, 0, 12, 1, null));
        $this$onCreate_u24lambda_u2419_u24lambda_u2417_u24lambda_u2416.setOnClickListener(new View.OnClickListener() { // from class: sh.sth.somtam.MainActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.onCreate$lambda$19$lambda$17$lambda$16$lambda$15(this.f$0, $this$onCreate_u24lambda_u2419_u24lambda_u2417_u24lambda_u2416, view);
            }
        });
        $this$onCreate_u24lambda_u2419_u24lambda_u2417.addView($this$onCreate_u24lambda_u2419_u24lambda_u2417_u24lambda_u2416);
        $this$onCreate_u24lambda_u2419.addView($this$onCreate_u24lambda_u2419_u24lambda_u2417);
        TextView $this$onCreate_u24lambda_u2419_u24lambda_u2418 = new TextView(this);
        $this$onCreate_u24lambda_u2419_u24lambda_u2418.setText(getString(R.string.footer_credit));
        $this$onCreate_u24lambda_u2419_u24lambda_u2418.setTextSize(12.0f);
        $this$onCreate_u24lambda_u2419_u24lambda_u2418.setTextColor(Color.rgb(142, 122, 106));
        $this$onCreate_u24lambda_u2419_u24lambda_u2418.setLayoutParams(verticalParams$default(this, 0, 20, 1, null));
        $this$onCreate_u24lambda_u2419.addView($this$onCreate_u24lambda_u2419_u24lambda_u2418);
        ScrollView $this$onCreate_u24lambda_u2420 = new ScrollView(this);
        $this$onCreate_u24lambda_u2420.setFillViewport(true);
        $this$onCreate_u24lambda_u2420.setBackgroundColor(Color.rgb(255, 249, 242));
        $this$onCreate_u24lambda_u2420.addView($this$onCreate_u24lambda_u2419);
        setContentView($this$onCreate_u24lambda_u2420);
    }

    /* JADX INFO: renamed from: sh.sth.somtam.MainActivity$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Object objM42constructorimpl;
            MainActivity $this$invoke_u24lambda_u240 = MainActivity.this;
            try {
                Result.Companion companion = Result.INSTANCE;
                objM42constructorimpl = Result.m42constructorimpl(Boolean.valueOf(ChallengeCapability.INSTANCE.activationRequired($this$invoke_u24lambda_u240)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM42constructorimpl = Result.m42constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m48isFailureimpl(objM42constructorimpl)) {
                objM42constructorimpl = null;
            }
            Boolean required = (Boolean) objM42constructorimpl;
            if (!Intrinsics.areEqual((Object) required, (Object) false)) {
                MainActivity mainActivity = MainActivity.this;
                final MainActivity mainActivity2 = MainActivity.this;
                mainActivity.runOnUiThread(new Runnable() { // from class: sh.sth.somtam.MainActivity$onCreate$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainActivity.AnonymousClass1.invoke$lambda$1(mainActivity2);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$1(MainActivity this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.launchActivation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$19$lambda$11$lambda$10$lambda$9(Button this_apply, TextView deliveryStatus, MainActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(deliveryStatus, "$deliveryStatus");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this_apply.setEnabled(false);
        deliveryStatus.setText("กำลังตรวจสอบพื้นที่จัดส่ง…");
        ThreadsKt.thread((23 & 1) != 0, (23 & 2) != 0 ? false : false, (23 & 4) != 0 ? null : null, (23 & 8) != 0 ? null : "delivery-status", (23 & 16) != 0 ? -1 : 0, new MainActivity$onCreate$content$1$4$2$1$1(this$0, deliveryStatus, this_apply));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$19$lambda$17$lambda$16$lambda$15(MainActivity this$0, Button this_apply, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        if (this$0.looksRooted()) {
            Toast.makeText(this$0, "Chef's Special is unavailable on this device.", 1).show();
        } else {
            this_apply.setEnabled(false);
            ThreadsKt.thread((23 & 1) != 0, (23 & 2) != 0 ? false : false, (23 & 4) != 0 ? null : null, (23 & 8) != 0 ? null : "chef-special", (23 & 16) != 0 ? -1 : 0, new MainActivity$onCreate$content$1$5$4$1$1(this$0, this_apply));
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.activationLaunching = false;
    }

    private final int dp(int value) {
        return (int) (value * getResources().getDisplayMetrics().density);
    }

    static /* synthetic */ LinearLayout.LayoutParams verticalParams$default(MainActivity mainActivity, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = -2;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return mainActivity.verticalParams(i, i2);
    }

    private final LinearLayout.LayoutParams verticalParams(int height, int top) {
        LinearLayout.LayoutParams $this$verticalParams_u24lambda_u2421 = new LinearLayout.LayoutParams(-1, height > 0 ? dp(height) : height);
        $this$verticalParams_u24lambda_u2421.topMargin = dp(top);
        return $this$verticalParams_u24lambda_u2421;
    }

    private final GradientDrawable rounded(int color, int radius, Integer strokeColor) {
        GradientDrawable $this$rounded_u24lambda_u2423 = new GradientDrawable();
        $this$rounded_u24lambda_u2423.setColor(color);
        $this$rounded_u24lambda_u2423.setCornerRadius(dp(radius));
        if (strokeColor != null) {
            int it = strokeColor.intValue();
            $this$rounded_u24lambda_u2423.setStroke(dp(1), it);
        }
        return $this$rounded_u24lambda_u2423;
    }

    static /* synthetic */ GradientDrawable rounded$default(MainActivity mainActivity, int i, int i2, Integer num, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        return mainActivity.rounded(i, i2, num);
    }

    private final boolean looksRooted() {
        return new File("/system/xbin/su").exists();
    }
}
