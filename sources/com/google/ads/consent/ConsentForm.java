package com.google.ads.consent;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.appnext.base.b.c;
import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;

public class ConsentForm {
    private final boolean adFreeOption;
    private final URL appPrivacyPolicyURL;
    private final Context context;
    private final Dialog dialog;
    private final ConsentFormListener listener;
    private LoadState loadState;
    private final boolean nonPersonalizedAdsOption;
    private final boolean personalizedAdsOption;
    private final WebView webView;

    /* renamed from: com.google.ads.consent.ConsentForm$1 */
    class AnonymousClass1 extends ConsentFormListener {
    }

    /* renamed from: com.google.ads.consent.ConsentForm$2 */
    class AnonymousClass2 extends WebViewClient {
        boolean isInternalRedirect;
        final /* synthetic */ ConsentForm this$0;

        private boolean a(String str) {
            return !TextUtils.isEmpty(str) && str.startsWith("consent://");
        }

        private void b(String str) {
            if (a(str)) {
                this.isInternalRedirect = true;
                Uri parse = Uri.parse(str);
                String queryParameter = parse.getQueryParameter(c.jD);
                String queryParameter2 = parse.getQueryParameter("status");
                String queryParameter3 = parse.getQueryParameter("url");
                boolean z = true;
                switch (queryParameter.hashCode()) {
                    case -1370505102:
                        if (queryParameter.equals("load_complete")) {
                            z = false;
                            break;
                        }
                        break;
                    case 150940456:
                        if (queryParameter.equals("browser")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1671672458:
                        if (queryParameter.equals("dismiss")) {
                            z = true;
                            break;
                        }
                        break;
                }
                switch (z) {
                    case false:
                        this.this$0.a(queryParameter2);
                        return;
                    case true:
                        this.isInternalRedirect = false;
                        this.this$0.c(queryParameter2);
                        return;
                    case true:
                        this.this$0.b(queryParameter3);
                        return;
                    default:
                        return;
                }
            }
        }

        public void onLoadResource(WebView webView, String str) {
            b(str);
        }

        public void onPageFinished(WebView webView, String str) {
            if (!this.isInternalRedirect) {
                this.this$0.a(webView);
            }
            super.onPageFinished(webView, str);
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            this.this$0.loadState = LoadState.NOT_READY;
            this.this$0.listener.a(webResourceError.toString());
        }

        @TargetApi(24)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            String uri = webResourceRequest.getUrl().toString();
            if (!a(uri)) {
                return false;
            }
            b(uri);
            return true;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!a(str)) {
                return false;
            }
            b(str);
            return true;
        }
    }

    /* renamed from: com.google.ads.consent.ConsentForm$3 */
    class AnonymousClass3 implements OnShowListener {
        final /* synthetic */ ConsentForm this$0;

        public void onShow(DialogInterface dialogInterface) {
            this.this$0.listener.b();
        }
    }

    public class Builder {
        private boolean adFreeOption;
        private final URL appPrivacyPolicyURL;
        private final Context context;
        private ConsentFormListener listener;
        private boolean nonPersonalizedAdsOption;
        private boolean personalizedAdsOption;
    }

    enum LoadState {
        NOT_READY,
        LOADING,
        LOADED
    }

    private static String a(Context context) {
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }

    private static String a(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("info", str2);
        new HashMap().put("args", hashMap);
        return String.format("javascript:%s(%s)", new Object[]{str, new Gson().toJson(r1)});
    }

    private void a(WebView webView) {
        Object hashMap = new HashMap();
        hashMap.put("app_name", a(this.context));
        hashMap.put("app_icon", b(this.context));
        hashMap.put("offer_personalized", Boolean.valueOf(this.personalizedAdsOption));
        hashMap.put("offer_non_personalized", Boolean.valueOf(this.nonPersonalizedAdsOption));
        hashMap.put("offer_ad_free", Boolean.valueOf(this.adFreeOption));
        hashMap.put("is_request_in_eea_or_unknown", Boolean.valueOf(ConsentInformation.a(this.context).d()));
        hashMap.put("app_privacy_url", this.appPrivacyPolicyURL);
        ConsentData c = ConsentInformation.a(this.context).c();
        hashMap.put("plat", c.g());
        hashMap.put("consent_info", c);
        webView.loadUrl(a("setUpConsentDialog", new Gson().toJson(hashMap)));
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.loadState = LoadState.NOT_READY;
            this.listener.a("No information");
        } else if (str.contains("Error")) {
            this.loadState = LoadState.NOT_READY;
            this.listener.a(str);
        } else {
            this.loadState = LoadState.LOADED;
            this.listener.a();
        }
    }

    private static String b(Context context) {
        Drawable applicationIcon = context.getPackageManager().getApplicationIcon(context.getApplicationInfo());
        Bitmap createBitmap = Bitmap.createBitmap(applicationIcon.getIntrinsicWidth(), applicationIcon.getIntrinsicHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        applicationIcon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        applicationIcon.draw(canvas);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        String str = "data:image/png;base64,";
        String valueOf = String.valueOf(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
        return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
    }

    private void b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.listener.a("No valid URL for browser navigation.");
            return;
        }
        try {
            this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (ActivityNotFoundException e) {
            this.listener.a("No Activity found to handle browser intent.");
        }
    }

    private void c(String str) {
        boolean z = false;
        this.loadState = LoadState.NOT_READY;
        this.dialog.dismiss();
        if (TextUtils.isEmpty(str)) {
            this.listener.a("No information provided.");
        } else if (str.contains("Error")) {
            this.listener.a(str);
        } else {
            ConsentStatus consentStatus;
            boolean z2 = true;
            switch (str.hashCode()) {
                case -1152655096:
                    if (str.equals("ad_free")) {
                        z2 = true;
                        break;
                    }
                    break;
                case -258041904:
                    if (str.equals("personalized")) {
                        z2 = false;
                        break;
                    }
                    break;
                case 1666911234:
                    if (str.equals("non_personalized")) {
                        z2 = true;
                        break;
                    }
                    break;
            }
            switch (z2) {
                case false:
                    consentStatus = ConsentStatus.PERSONALIZED;
                    break;
                case true:
                    consentStatus = ConsentStatus.NON_PERSONALIZED;
                    break;
                case true:
                    consentStatus = ConsentStatus.UNKNOWN;
                    z = true;
                    break;
                default:
                    consentStatus = ConsentStatus.UNKNOWN;
                    break;
            }
            ConsentInformation.a(this.context).a(consentStatus, "form");
            this.listener.a(consentStatus, Boolean.valueOf(z));
        }
    }
}
