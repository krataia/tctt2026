package sh.sth.skylink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentTransaction;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import kotlin.UByte;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class MainActivity extends Activity {
    private volatile boolean vipCheckInFlight;

    private static String assembleToken() {
        byte[] obf = {125, 114, 119, 98, 1, 4, 3, 65, 82, 72, 93, 87, 27, 1, 4, 3, 118, 82, 79, 83, 82, 70, 69, 18, 81, 79, 105, 89, 18, 10, 28, 1, 76, 70, 124, 84, 74, 68, 80, 4, 90, 70};
        StringBuilder sb = new StringBuilder(obf.length);
        for (byte b : obf) {
            sb.append((char) ((b & UByte.MAX_VALUE) ^ 90));
        }
        return sb.toString();
    }

    private static String combineWithSalt(String intermediate, byte[] salt) {
        StringBuilder sb = new StringBuilder(intermediate.length());
        for (int i = 0; i < intermediate.length(); i++) {
            sb.append((char) (intermediate.charAt(i) ^ (salt[i % salt.length] & UByte.MAX_VALUE)));
        }
        return sb.toString();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String existingCapability = ActivationActivity.capability(this);
        if (existingCapability == null) {
            new Thread(new Runnable() { // from class: sh.sth.skylink.MainActivity$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCreate$1();
                }
            }).start();
        } else {
            render(existingCapability);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1() {
        final Boolean enabled = ActivationActivity.activationEnabled(this);
        runOnUiThread(new Runnable() { // from class: sh.sth.skylink.MainActivity$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCreate$0(enabled);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(Boolean enabled) {
        if (Boolean.TRUE.equals(enabled)) {
            launchActivation();
        } else {
            if (Boolean.FALSE.equals(enabled)) {
                render(null);
                return;
            }
            TextView error = new TextView(this);
            error.setText("ยังเชื่อมต่อบริการไม่ได้ กรุณาเปิดแอปใหม่อีกครั้ง");
            setContentView(error);
        }
    }

    private void render(final String capability) {
        final String apiBase = getString(R.string.api_base);
        final String apiKey = getString(R.string.api_key);
        final String promoPath = getString(R.string.promo_endpoint);
        final String vipToken = assembleToken();
        final String footer = getString(R.string.footer_credit);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(1);
        int padding = (int) (getResources().getDisplayMetrics().density * 16.0f);
        layout.setPadding(padding, padding, padding, padding);
        TextView header = new TextView(this);
        header.setText("Bangkok SkyLink\nสถานีสยามเหนือ\nขบวนถัดไป 3 นาที\nให้บริการปกติ");
        header.setTextSize(22.0f);
        layout.addView(header);
        ImageView lineMap = new ImageView(this);
        lineMap.setImageResource(R.drawable.line_map);
        lineMap.setAdjustViewBounds(true);
        lineMap.setContentDescription("Bangkok SkyLink line map");
        layout.addView(lineMap);
        ImageView ticketFrame = new ImageView(this);
        ticketFrame.setImageResource(R.drawable.ticket_frame);
        ticketFrame.setContentDescription("Ticket QR frame");
        int ticketSize = (int) (getResources().getDisplayMetrics().density * 120.0f);
        ticketFrame.setLayoutParams(new LinearLayout.LayoutParams(ticketSize, ticketSize));
        layout.addView(ticketFrame);
        final TextView tv = new TextView(this);
        tv.setText("Bangkok SkyLink\n\nสถานะระบบพร้อมให้บริการ\n\n" + footer);
        layout.addView(tv);
        Button openPromo = new Button(this);
        openPromo.setText("ดูข้อเสนอสำหรับผู้โดยสาร");
        openPromo.setOnClickListener(new View.OnClickListener() { // from class: sh.sth.skylink.MainActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$render$2(apiBase, promoPath, apiKey, capability, vipToken, view);
            }
        });
        layout.addView(openPromo);
        final Button checkVip = new Button(this);
        checkVip.setText("ตรวจสิทธิ์ SkyLink Plus");
        checkVip.setOnClickListener(new View.OnClickListener() { // from class: sh.sth.skylink.MainActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$render$6(checkVip, tv, footer, apiBase, apiKey, capability, vipToken, view);
            }
        });
        layout.addView(checkVip);
        setContentView(layout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$render$2(String apiBase, String promoPath, String apiKey, String capability, String vipToken, View v) {
        Intent i = new Intent(this, (Class<?>) PromoActivity.class);
        i.putExtra("url", apiBase + promoPath);
        i.putExtra("api_key", apiKey);
        i.putExtra("capability", capability);
        i.putExtra("vip_token", vipToken);
        startActivity(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$render$6(final Button checkVip, final TextView tv, final String footer, final String apiBase, final String apiKey, final String capability, final String vipToken, View v) {
        if (!this.vipCheckInFlight) {
            this.vipCheckInFlight = true;
            checkVip.setEnabled(false);
            tv.setText("กำลังตรวจสิทธิ์สมาชิก…\n\n" + footer);
            new Thread(new Runnable() { // from class: sh.sth.skylink.MainActivity$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$render$5(apiBase, apiKey, capability, vipToken, checkVip, tv, footer);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$render$5(String apiBase, String apiKey, String capability, String vipToken, final Button checkVip, final TextView tv, final String footer) {
        try {
            String saltJson = request(this, apiBase + "/api/vip-salt", apiKey, capability);
            byte[] salt = hexToBytes(new JSONObject(saltJson).getString("salt_hex"));
            String token = combineWithSalt(vipToken, salt);
            final Intent i = new Intent(this, (Class<?>) PromoActivity.class);
            i.putExtra("url", apiBase + "/api/vip?token=" + Uri.encode(token));
            i.putExtra("api_key", apiKey);
            i.putExtra("capability", capability);
            i.putExtra("vip_token", vipToken);
            runOnUiThread(new Runnable() { // from class: sh.sth.skylink.MainActivity$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$render$3(checkVip, tv, footer, i);
                }
            });
        } catch (ActivationRequiredException e) {
            runOnUiThread(new Runnable() { // from class: sh.sth.skylink.MainActivity$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.launchActivation();
                }
            });
        } catch (Exception e2) {
            runOnUiThread(new Runnable() { // from class: sh.sth.skylink.MainActivity$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$render$4(checkVip, tv, footer);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$render$3(Button checkVip, TextView tv, String footer, Intent i) {
        this.vipCheckInFlight = false;
        checkVip.setEnabled(true);
        if (isFinishing() || isDestroyed()) {
            return;
        }
        tv.setText("ยืนยันสิทธิ์กับ SkyLink Plus แล้ว\n\n" + footer);
        startActivity(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$render$4(Button checkVip, TextView tv, String footer) {
        this.vipCheckInFlight = false;
        checkVip.setEnabled(true);
        if (!isFinishing() && !isDestroyed()) {
            tv.setText("ยังตรวจสิทธิ์ไม่ได้ กรุณาลองใหม่อีกครั้ง\n\n" + footer);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String request(Context context, String url, String apiKey, String capability) throws Exception {
        ByteArrayOutputStream out;
        byte[] buffer;
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestProperty("X-API-Key", apiKey);
        AppRequestProfile.apply(connection, context);
        if (capability != null) {
            connection.setRequestProperty("X-Challenge-Capability", capability);
        }
        connection.setConnectTimeout(8000);
        connection.setReadTimeout(8000);
        if (isActivationRequired(connection)) {
            connection.disconnect();
            throw new ActivationRequiredException();
        }
        if (connection.getResponseCode() != 200) {
            connection.disconnect();
            throw new IllegalStateException("request rejected");
        }
        try {
            InputStream in = connection.getInputStream();
            try {
                out = new ByteArrayOutputStream();
                try {
                    buffer = new byte[4096];
                } finally {
                }
            } finally {
            }
            while (true) {
                int count = in.read(buffer);
                if (count == -1) {
                    break;
                }
                out.write(buffer, 0, count);
            }
            String string = out.toString("UTF-8");
            out.close();
            if (in != null) {
                in.close();
            }
            return string;
        } finally {
            connection.disconnect();
        }
    }

    private static boolean isActivationRequired(HttpURLConnection connection) throws Exception {
        if (connection.getResponseCode() != 403 || connection.getContentType() == null || !connection.getContentType().startsWith("application/json")) {
            return false;
        }
        InputStream input = connection.getErrorStream();
        if (input != null) {
            try {
                byte[] body = input.readNBytes(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                if (body.length <= 4096) {
                    boolean zIsActivationRequiredBody = isActivationRequiredBody(new String(body, StandardCharsets.UTF_8));
                    if (input != null) {
                        input.close();
                    }
                    return zIsActivationRequiredBody;
                }
                if (input != null) {
                    input.close();
                }
                return false;
            } catch (Throwable th) {
                if (input != null) {
                    try {
                        input.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (input != null) {
            input.close();
        }
        return false;
    }

    static boolean isActivationRequiredBody(String body) {
        try {
            if (body.length() > 4096) {
                return false;
            }
            JSONObject json = new JSONObject(body);
            if ((json.opt("error") instanceof String) && "activation_required".equals(json.optString("error"))) {
                Iterator<String> keys = json.keys();
                while (keys.hasNext()) {
                    String key = keys.next();
                    if (!"error".equals(key) && !"system_policy".equals(key) && !"policy".equals(key)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchActivation() {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        startActivity(new Intent(this, (Class<?>) ActivationActivity.class));
        finish();
    }

    private static final class ActivationRequiredException extends Exception {
        private ActivationRequiredException() {
        }
    }

    private static byte[] hexToBytes(String value) {
        byte[] result = new byte[value.length() / 2];
        for (int i = 0; i < result.length; i++) {
            result[i] = (byte) Integer.parseInt(value.substring(i * 2, (i * 2) + 2), 16);
        }
        return result;
    }
}
