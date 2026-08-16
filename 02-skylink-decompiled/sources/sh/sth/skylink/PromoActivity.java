package sh.sth.skylink;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class PromoActivity extends Activity {

    public static final class SkyLinkBridge {
        private final String vipToken;

        SkyLinkBridge(String t) {
            this.vipToken = t;
        }

        @JavascriptInterface
        public String unlockVip() {
            return this.vipToken;
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String url = getIntent().getStringExtra("url");
        String vipToken = getIntent().getStringExtra("vip_token");
        String apiKey = getIntent().getStringExtra("api_key");
        String capability = getIntent().getStringExtra("capability");
        WebView wv = new WebView(this);
        wv.getSettings().setJavaScriptEnabled(true);
        AppRequestProfile.configure(wv);
        wv.addJavascriptInterface(new SkyLinkBridge(vipToken), "SkyLink");
        if (url != null && apiKey != null) {
            Map<String, String> headers = AppRequestProfile.webHeaders(this);
            headers.put("X-API-Key", apiKey);
            if (capability != null) {
                headers.put("X-Challenge-Capability", capability);
            }
            wv.loadUrl(url, headers);
        } else {
            wv.loadUrl("about:blank");
        }
        TextView credit = new TextView(this);
        credit.setText(getString(R.string.footer_credit));
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(1);
        layout.addView(wv, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        layout.addView(credit, new LinearLayout.LayoutParams(-1, -2));
        setContentView(layout);
    }
}
