package com.appnext.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.mopub.common.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ResultActivity extends Activity {
    private Intent lj;
    private WebView o;

    private Intent aJ(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        return intent;
    }

    private static List b(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        List arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            arrayList.add(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
        }
        return arrayList;
    }

    private void di() {
        onBackPressed();
    }

    private void openLink(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.addFlags(268435456);
        startActivity(intent);
    }

    public final boolean hasNewResolver(Intent intent) {
        if (this.lj == null) {
            return intent != null;
        } else if (intent == null) {
            return false;
        } else {
            List<ComponentName> b = b((Context) this, intent);
            HashSet hashSet = new HashSet();
            hashSet.addAll(b((Context) this, this.lj));
            for (ComponentName contains : b) {
                if (!hashSet.contains(contains)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void onBackPressed() {
        try {
            if (this.o == null || !this.o.canGoBack()) {
                super.onBackPressed();
            } else {
                this.o.goBack();
            }
        } catch (Throwable th) {
            g.c(th);
            finish();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    protected void onCreate(@Nullable Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        View linearLayout = new LinearLayout(this);
        setContentView(linearLayout);
        linearLayout.setOrientation(1);
        this.o = new WebView(getApplicationContext());
        this.o.getSettings().setTextZoom(100);
        this.o.getSettings().setJavaScriptEnabled(true);
        this.o.getSettings().setAllowFileAccess(true);
        this.o.getSettings().setAppCacheEnabled(true);
        this.o.getSettings().setDomStorageEnabled(true);
        this.o.getSettings().setDatabaseEnabled(true);
        if (VERSION.SDK_INT >= 21) {
            this.o.getSettings().setMixedContentMode(0);
        }
        if (VERSION.SDK_INT >= 17) {
            this.o.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        if (VERSION.SDK_INT >= 19) {
            this.o.setLayerType(2, null);
        } else {
            this.o.setLayerType(1, null);
        }
        this.o.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str == null) {
                    return false;
                }
                g.X("result page url " + str);
                Intent parseUri;
                if (str.startsWith(Constants.HTTP)) {
                    if (ResultActivity.this.hasNewResolver(ResultActivity.this.aJ(str).setComponent(null))) {
                        ResultActivity.this.openLink(str);
                    } else {
                        webView.loadUrl(str);
                    }
                    return true;
                } else if (str.startsWith("intent://")) {
                    try {
                        parseUri = Intent.parseUri(str, 1);
                        if (ResultActivity.this.getPackageManager().resolveActivity(parseUri, 65536) != null) {
                            ResultActivity.this.openLink(parseUri.getData().toString());
                            return true;
                        }
                        String string;
                        if (parseUri.getExtras() != null && parseUri.getExtras().containsKey("browser_fallback_url") && !parseUri.getExtras().getString("browser_fallback_url").equals("")) {
                            string = parseUri.getExtras().getString("browser_fallback_url");
                        } else if (!parseUri.getExtras().containsKey("market_referrer") || parseUri.getExtras().getString("market_referrer").equals("")) {
                            return true;
                        } else {
                            string = "market://details?id=" + parseUri.getPackage() + "&referrer=" + parseUri.getExtras().getString("market_referrer");
                        }
                        ResultActivity.this.openLink(string);
                        return true;
                    } catch (Throwable th) {
                        g.c(th);
                        return false;
                    }
                } else {
                    parseUri = new Intent("android.intent.action.VIEW");
                    parseUri.setData(Uri.parse(str));
                    try {
                        if (ResultActivity.this.getPackageManager().queryIntentActivities(parseUri, 0).size() <= 0) {
                            return false;
                        }
                        ResultActivity.this.openLink(str);
                        return true;
                    } catch (Throwable th2) {
                        g.c(th2);
                        return false;
                    }
                }
            }
        });
        linearLayout.addView(this.o);
        this.o.setLayoutParams(new LayoutParams(-1, 0));
        ((LayoutParams) this.o.getLayoutParams()).weight = 1.0f;
        try {
            String string = getIntent().getExtras().getString("url");
            getIntent().getExtras().getString("title");
            g.X("loading result page " + string);
            this.lj = new Intent(aJ(string)).setComponent(null);
            if (VERSION.SDK_INT >= 15) {
                Intent selector = this.lj.getSelector();
                if (selector != null) {
                    selector.setComponent(null);
                }
            }
            this.o.loadUrl(string);
        } catch (Throwable th) {
            g.c(th);
            finish();
        }
    }
}
