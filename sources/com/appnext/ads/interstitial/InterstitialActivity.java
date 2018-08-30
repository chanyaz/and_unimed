package com.appnext.ads.interstitial;

import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.appnext.R;
import com.appnext.ads.AdsError;
import com.appnext.ads.a;
import com.appnext.ads.b;
import com.appnext.core.AppnextActivity;
import com.appnext.core.AppnextAd;
import com.appnext.core.AppnextError;
import com.appnext.core.c;
import com.appnext.core.e;
import com.appnext.core.g;
import com.appnext.core.m;
import com.appnext.core.r;
import com.appnext.core.webview.AppnextWebView;
import com.appnext.core.webview.WebAppInterface;
import com.mopub.common.AdType;
import com.mopub.common.Constants;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONObject;

public class InterstitialActivity extends AppnextActivity {
    private ArrayList<AppnextAd> aL;
    private Boolean autoPlay;
    private Boolean canClose;
    private boolean closed = false;
    private AppnextAd dB;
    private AppnextAd dC;
    private b dD;
    Runnable dG = new Runnable() {
        public void run() {
            if (InterstitialActivity.this.userAction != null) {
                InterstitialActivity.this.userAction.e(InterstitialActivity.this.dB);
                InterstitialActivity.this.report(a.cL);
            }
            try {
                if (Boolean.parseBoolean(InterstitialActivity.this.getConfig().get("fq_control")) && Interstitial.currentAd.fq_status) {
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                g.a("https://www.fqtag.com/pixel.cgi?org=TkBXEI5C3FBIr4zXwnmK&p=" + InterstitialActivity.this.placementID + "&a=" + InterstitialActivity.this.dB.getBannerID() + "&cmp=" + InterstitialActivity.this.dB.getCampaignID() + "&fmt=banner&dmn=" + InterstitialActivity.this.dB.getAdPackage() + "&ad=&rt=displayImg&gid=" + g.u(InterstitialActivity.this) + "&aid=&applng=" + Locale.getDefault().toString() + "&app=" + InterstitialActivity.this.getPackageName() + "&c1=100&c2=" + Interstitial.currentAd.getTID() + "&c3=" + Interstitial.currentAd.getAUID() + "&c4=" + Interstitial.currentAd.getVID() + "&sl=1&fq=1", null);
                            } catch (Throwable th) {
                                g.c(th);
                            }
                        }
                    }).start();
                }
            } catch (Throwable th) {
            }
        }
    };
    Runnable dH = new Runnable() {
        public void run() {
            InterstitialActivity.this.a(InterstitialActivity.this.dB, null);
        }
    };
    protected WebView eL;
    private boolean eM = false;
    private Interstitial eN;
    private String eO = "";
    private int eP = 0;
    private Handler eQ;
    private e.a eR;
    private WebAppInterface eS;
    private boolean eT = false;
    private boolean eU = false;
    private String eV = "";
    private Runnable eW = new Runnable() {
        public void run() {
            InterstitialActivity.this.F();
        }
    };
    private Boolean mute;

    public class WebInterface extends WebAppInterface {
        public WebInterface() {
            super(InterstitialActivity.this);
        }

        @JavascriptInterface
        public void destroy(String str) {
            if (str.equals("close")) {
                InterstitialActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        InterstitialActivity.this.onClose();
                        InterstitialActivity.this.finish();
                    }
                });
            } else {
                InterstitialActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        InterstitialActivity.this.onError(AdsError.AD_NOT_READY);
                        InterstitialActivity.this.finish();
                    }
                });
            }
        }

        @JavascriptInterface
        public String filterAds(String str) {
            return str;
        }

        @JavascriptInterface
        public void gotoAppWall() {
        }

        @JavascriptInterface
        public void jsError(String str) {
            if (!str.contains("is not a function") && !str.contains("has no method")) {
                g.X("jsError " + str);
                InterstitialActivity.this.onError(AppnextError.INTERNAL_ERROR);
                InterstitialActivity.this.finish();
            } else if (InterstitialActivity.this.eP = InterstitialActivity.this.eP + 1 < 5) {
                InterstitialActivity.this.eQ.postDelayed(InterstitialActivity.this.eW, 500);
            } else {
                InterstitialActivity.this.onError(AppnextError.INTERNAL_ERROR);
                InterstitialActivity.this.finish();
            }
        }

        @JavascriptInterface
        public String loadAds() {
            return "";
        }

        @JavascriptInterface
        public void notifyImpression(String str) {
            super.notifyImpression(str);
            InterstitialActivity.this.handler.postDelayed(InterstitialActivity.this.dG, Long.parseLong(InterstitialActivity.this.getConfig().get("postpone_impression_sec")) * 1000);
            if (InterstitialActivity.this.autoPlay.booleanValue()) {
                play();
            }
        }

        @JavascriptInterface
        public void openLink(String str) {
            InterstitialActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        }

        @JavascriptInterface
        public void openStore(final String str) {
            InterstitialActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    InterstitialActivity.this.Q(str);
                }
            });
        }

        @JavascriptInterface
        public void play() {
            InterstitialActivity.this.b(InterstitialActivity.this.placementID, "", a.ci);
            InterstitialActivity.this.play();
        }

        @JavascriptInterface
        public void postView(String str) {
            if (Boolean.parseBoolean(InterstitialActivity.this.aL != null ? "false" : InterstitialActivity.this.P("pview"))) {
                InterstitialActivity.this.handler.postDelayed(InterstitialActivity.this.dH, Long.parseLong(InterstitialActivity.this.getConfig().get("postpone_vta_sec")) * 1000);
            }
        }

        @JavascriptInterface
        public void videoPlayed() {
        }
    }

    private void F() {
        this.eQ.removeCallbacks(this.eW);
        this.eM = true;
        this.eO = getIntent().getExtras().getString("creative");
        if (this.eO == null || this.eO.equals(Interstitial.TYPE_MANAGED)) {
            this.eO = P("creative");
        }
        as();
        if (this.eL == null) {
            onError(AppnextError.INTERNAL_ERROR);
            finish();
            return;
        }
        if (this.eL.getParent() != null) {
            ((ViewGroup) this.eL.getParent()).removeView(this.eL);
        }
        this.kU.addView(this.eL);
        this.eL.getLayoutParams().width = -1;
        this.eL.getLayoutParams().height = -1;
    }

    private String P(String str) {
        String str2 = getConfig().get(str);
        return str2 == null ? "" : str2;
    }

    private void Q(String str) {
        AppnextAd appnextAd = (AppnextAd) a.au().g(str);
        if (appnextAd != null) {
            this.dC = appnextAd;
            if (!(this.eN == null || this.eN.getOnAdClickedCallback() == null)) {
                this.eN.getOnAdClickedCallback().adClicked();
            }
            b(appnextAd, this.eR);
            report(a.da);
            if (appnextAd.getBannerID().equals(this.dB != null ? this.dB.getBannerID() : "")) {
                b(this.placementID, "", a.cj);
                if (!this.eT) {
                    this.eT = true;
                    report(a.dp);
                    return;
                }
                return;
            }
            b(this.placementID, "", a.ck);
            if (!this.eU) {
                this.eU = true;
                report(a.do);
            }
        }
    }

    private void aq() {
        try {
            AppnextWebView D = AppnextWebView.D(this);
            this.eL = D.aW(this.aL != null ? "fullscreen" : AdType.INTERSTITIAL);
            this.eL = D.a(this, this.eN.getPageUrl(), ar(), this.eN.getFallback(), this.aL != null ? "fullscreen" : AdType.INTERSTITIAL);
            this.eL.setWebViewClient(new WebViewClient() {
                public void onPageFinished(WebView webView, String str) {
                    super.onPageFinished(webView, str);
                    InterstitialActivity.this.eQ.removeCallbacksAndMessages(null);
                    InterstitialActivity.this.F();
                }

                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    if (str == null) {
                        return false;
                    }
                    if (!str.startsWith(Constants.HTTP)) {
                        return super.shouldOverrideUrlLoading(webView, str);
                    }
                    webView.loadUrl(str);
                    return true;
                }
            });
            this.eL.setWebChromeClient(new WebChromeClient() {
                public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                    g.X("console " + consoleMessage.message());
                    if (!consoleMessage.message().contains("pause") && (consoleMessage.message().contains("TypeError") || consoleMessage.message().contains("has no method") || consoleMessage.message().contains("is not a function"))) {
                        InterstitialActivity.this.onError(AppnextError.INTERNAL_ERROR);
                        InterstitialActivity.this.finish();
                    }
                    return true;
                }
            });
        } catch (Throwable th) {
            g.c(th);
            onError(AppnextError.INTERNAL_ERROR);
            finish();
        }
    }

    private void b(final String str) {
        runOnUiThread(new Runnable() {
            public void run() {
                if (InterstitialActivity.this.eL != null) {
                    g.X(str);
                    InterstitialActivity.this.eL.loadUrl("javascript:(function() { try { " + str + "} catch(err){ Appnext.jsError(err.message); }})()");
                }
            }
        });
    }

    private boolean hasVideo(AppnextAd appnextAd) {
        return (appnextAd.getVideoUrl().equals("") && appnextAd.getVideoUrlHigh().equals("") && appnextAd.getVideoUrl30Sec().equals("") && appnextAd.getVideoUrlHigh30Sec().equals("")) ? false : true;
    }

    private void onClose() {
        if (this.eN != null && this.eN.getOnAdClosedCallback() != null) {
            this.eN.getOnAdClosedCallback().onAdClosed();
        }
    }

    private void play() {
        b("Appnext.Layout.Video.play();");
    }

    private void report(String str) {
        if (this.eN != null) {
            g.a(this.eN.getTID(), this.eN.getVID(), this.eN.getAUID(), this.eN.getPlacementID(), this.eN.getSessionId(), str, "current_interstitial", this.dB != null ? this.dB.getBannerID() : "", this.dB != null ? this.dB.getCampaignID() : "");
        }
    }

    private void stop() {
        if (this.eL != null) {
            g.X("stop");
            this.eL.loadUrl("javascript:(function() { Appnext.Layout.Video.pause();})()");
        }
    }

    protected WebAppInterface ar() {
        if (this.eS == null) {
            this.eS = new WebInterface();
        }
        return this.eS;
    }

    protected synchronized void as() {
        if (this.aL != null) {
            String str = "Appnext.loadRewarded(" + a.au().d(this.aL) + ");";
            g.X(str);
            b(str);
            this.dB = (AppnextAd) this.aL.get(0);
        } else {
            a.au().a(this, this.eN, this.placementID, new c.a() {
                public <T> void a(T t) {
                    if (t == null) {
                        try {
                            Log.d("appnext SDK", "IA GAL 1");
                            InterstitialActivity.this.finish();
                            InterstitialActivity.this.onError(AppnextError.NO_ADS);
                        } catch (Throwable th) {
                            InterstitialActivity.this.finish();
                            InterstitialActivity.this.onError(AppnextError.INTERNAL_ERROR);
                            g.c(th);
                            InterstitialActivity.this.b(InterstitialActivity.this.placementID, g.b(th), "InterstitialActivity_error");
                        }
                    } else if (((ArrayList) t).size() == 0) {
                        Log.d("appnext SDK", "IA GAL 2");
                        InterstitialActivity.this.finish();
                        InterstitialActivity.this.onError(AppnextError.NO_ADS);
                    } else {
                        ArrayList b = a.au().b(InterstitialActivity.this, InterstitialActivity.this.eN, InterstitialActivity.this.eO);
                        if (b == null) {
                            Log.d("appnext SDK", "IA GAL 3");
                            InterstitialActivity.this.finish();
                            InterstitialActivity.this.onError(AppnextError.NO_ADS);
                            return;
                        }
                        String d = a.au().d(b);
                        if (d == null) {
                            Log.d("appnext SDK", "IA GAL 4");
                            InterstitialActivity.this.finish();
                            InterstitialActivity.this.onError(AppnextError.NO_ADS);
                            return;
                        }
                        String replace = d.replace(" ", "\\u2028").replace(" ", "\\u2029");
                        InterstitialActivity.this.dB = (AppnextAd) b.get(0);
                        JSONObject at = InterstitialActivity.this.at();
                        if (InterstitialActivity.this.hasVideo((AppnextAd) b.get(0))) {
                            at.put("remote_auto_play", "" + InterstitialActivity.this.autoPlay);
                        } else {
                            at.put("remote_auto_play", "false");
                        }
                        InterstitialAd interstitialAd = new InterstitialAd((AppnextAd) b.get(0));
                        Object b2 = interstitialAd.getButtonText().equals("") ? g.h(InterstitialActivity.this, interstitialAd.getAdPackage()) ? InterstitialActivity.this.P("existing_button_text") : InterstitialActivity.this.P("new_button_text") : interstitialAd.getButtonText();
                        at.put("b_title", b2);
                        InterstitialActivity.this.b("Appnext.setParams(" + at.toString() + ");");
                        InterstitialActivity.this.b("Appnext.loadInterstitial(" + replace + ");");
                        a.au().a(InterstitialActivity.this.dB.getBannerID(), Interstitial.currentAd);
                        if (Interstitial.currentAd.getOnAdOpenedCallback() != null) {
                            Interstitial.currentAd.getOnAdOpenedCallback().adOpened();
                        }
                    }
                }

                public void error(final String str) {
                    InterstitialActivity.this.runOnUiThread(new Runnable() {
                        public void run() {
                            g.X("ads error");
                            InterstitialActivity.this.b(InterstitialActivity.this.placementID, str, "ads error");
                            InterstitialActivity.this.onError(str);
                            InterstitialActivity.this.finish();
                        }
                    });
                }
            }, this.eO);
        }
    }

    protected JSONObject at() {
        Object P = this.eN.getButtonColor().equals("") ? P("button_color") : this.eN.getButtonColor();
        if (P.startsWith("#")) {
            P = P.substring(1);
        }
        if (this.autoPlay == null) {
            this.autoPlay = Boolean.valueOf(Boolean.parseBoolean(P("auto_play")));
        }
        if (this.mute == null) {
            this.mute = Boolean.valueOf(Boolean.parseBoolean(P("mute")));
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.placementID);
        jSONObject.put("cat", this.eN.getCategories());
        jSONObject.put("pbk", this.eN.getPostback());
        jSONObject.put("b_color", P);
        if (this.aL == null) {
            jSONObject.put("skip_title", this.eN.getSkipText().equals("") ? P("skip_title") : this.eN.getSkipText());
            jSONObject.put("pview", this.aL != null ? "false" : P("pview"));
            jSONObject.put("video_length", P("video_length"));
            jSONObject.put("min_internet_connection", P("min_internet_connection"));
            jSONObject.put("min_internet_connection_video", P("min_internet_connection_video"));
            jSONObject.put("mute", "" + this.mute);
            jSONObject.put("auto_play", "" + this.autoPlay);
            jSONObject.put("remove_poster_on_auto_play", P("remove_poster_on_auto_play"));
            jSONObject.put("show_rating", P("show_rating"));
            jSONObject.put("show_desc", P("show_desc"));
            jSONObject.put("creative", this.eO);
            jSONObject.put("remote_auto_play", true);
        }
        jSONObject.put("ext", "t");
        jSONObject.put("dct", g.x(this));
        jSONObject.put("did", this.eV);
        jSONObject.put("devn", g.da());
        jSONObject.put("dosv", VERSION.SDK_INT);
        jSONObject.put("dds", "0");
        jSONObject.put("urlApp_protection", P("urlApp_protection"));
        jSONObject.put("vid", this.eN.getVID());
        jSONObject.put("tid", this.eN.getTID());
        jSONObject.put("auid", this.eN.getAUID());
        jSONObject.put("osid", "100");
        jSONObject.put("ads_type", AdType.INTERSTITIAL);
        jSONObject.put("country", this.dB.getCountry());
        jSONObject.put("gdpr", m.a(this.dB, getConfig()));
        if (getIntent() != null && getIntent().hasExtra("show_desc")) {
            jSONObject.put("show_desc", getIntent().getStringExtra("show_desc"));
        }
        return jSONObject;
    }

    protected void b(AppnextAd appnextAd, e.a aVar) {
        a(this.kU, getResources().getDrawable(R.drawable.apnxt_loader));
        super.b(appnextAd, aVar);
    }

    protected void b(String str, String str2, String str3) {
    }

    protected r getConfig() {
        return c.ax();
    }

    public void onBackPressed() {
        if (this.canClose != null) {
            if (!this.canClose.booleanValue()) {
                return;
            }
        } else if (!Boolean.parseBoolean(P("can_close"))) {
            return;
        }
        b("Appnext.Layout.destroy('internal');");
        b(this.placementID, "", a.ct);
        this.closed = true;
        onClose();
        super.onBackPressed();
    }

    protected void onCreate(android.os.Bundle r8) {
        /*
        r7 = this;
        r6 = 7;
        r3 = 2;
        r5 = 6;
        r1 = -1;
        r2 = 1;
        r0 = com.appnext.ads.interstitial.Interstitial.currentAd;
        if (r0 == 0) goto L_0x0026;
    L_0x0009:
        r0 = r7.getIntent();
        r4 = "orientation";
        r0 = r0.getBooleanExtra(r4, r2);
        if (r0 == 0) goto L_0x0026;
    L_0x0015:
        r0 = com.appnext.ads.interstitial.Interstitial.currentAd;
        r0 = r0.getOrientation();
        r4 = r0.hashCode();
        switch(r4) {
            case 729267099: goto L_0x004f;
            case 1430647483: goto L_0x0045;
            case 1673671211: goto L_0x003b;
            case 2129065206: goto L_0x0031;
            default: goto L_0x0022;
        };
    L_0x0022:
        r0 = r1;
    L_0x0023:
        switch(r0) {
            case 0: goto L_0x0059;
            case 1: goto L_0x0059;
            case 2: goto L_0x006d;
            case 3: goto L_0x0071;
            default: goto L_0x0026;
        };
    L_0x0026:
        super.onCreate(r8);
        r0 = com.appnext.ads.interstitial.Interstitial.currentAd;
        if (r0 != 0) goto L_0x0075;
    L_0x002d:
        r7.finish();
    L_0x0030:
        return;
    L_0x0031:
        r4 = "not_set";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x0022;
    L_0x0039:
        r0 = 0;
        goto L_0x0023;
    L_0x003b:
        r4 = "automatic";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x0022;
    L_0x0043:
        r0 = r2;
        goto L_0x0023;
    L_0x0045:
        r4 = "landscape";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x0022;
    L_0x004d:
        r0 = r3;
        goto L_0x0023;
    L_0x004f:
        r4 = "portrait";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x0022;
    L_0x0057:
        r0 = 3;
        goto L_0x0023;
    L_0x0059:
        r0 = r7.getResources();
        r0 = r0.getConfiguration();
        r0 = r0.orientation;
        if (r0 != r3) goto L_0x0069;
    L_0x0065:
        r7.setRequestedOrientation(r5);
        goto L_0x0026;
    L_0x0069:
        r7.setRequestedOrientation(r6);
        goto L_0x0026;
    L_0x006d:
        r7.setRequestedOrientation(r5);
        goto L_0x0026;
    L_0x0071:
        r7.setRequestedOrientation(r6);
        goto L_0x0026;
    L_0x0075:
        r0 = com.appnext.ads.interstitial.Interstitial.currentAd;
        r7.eN = r0;
        r0 = r7.getRequestedOrientation();
        if (r0 != r5) goto L_0x01a7;
    L_0x007f:
        r0 = "loaded_landscape";
        r7.report(r0);
    L_0x0084:
        r0 = new android.widget.RelativeLayout;
        r0.<init>(r7);
        r7.kU = r0;
        r0 = r7.kU;
        r7.setContentView(r0);
        r0 = r7.kU;
        r0 = r0.getLayoutParams();
        r0.width = r1;
        r0 = r7.kU;
        r0 = r0.getLayoutParams();
        r0.height = r1;
        r0 = r7.kU;
        r1 = -16777216; // 0xffffffffff000000 float:-1.7014118E38 double:NaN;
        r0.setBackgroundColor(r1);
        r0 = r7.getIntent();	 Catch:{ Throwable -> 0x01ae }
        r0 = r0.getExtras();	 Catch:{ Throwable -> 0x01ae }
        r1 = "id";
        r0 = r0.getString(r1);	 Catch:{ Throwable -> 0x01ae }
        r7.placementID = r0;	 Catch:{ Throwable -> 0x01ae }
        r0 = r7.getIntent();
        r1 = "auto_play";
        r0 = r0.hasExtra(r1);
        if (r0 == 0) goto L_0x00e0;
    L_0x00c3:
        r0 = r7.getIntent();
        r1 = "auto_play";
        r0 = r0.getBooleanExtra(r1, r2);
        r0 = java.lang.Boolean.valueOf(r0);
        r7.autoPlay = r0;
        r0 = r7.autoPlay;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x01b4;
    L_0x00db:
        r0 = "auto_play_on";
        r7.report(r0);
    L_0x00e0:
        r0 = r7.getIntent();
        r1 = "can_close";
        r0 = r0.hasExtra(r1);
        if (r0 == 0) goto L_0x00fc;
    L_0x00ec:
        r0 = r7.getIntent();
        r1 = "can_close";
        r0 = r0.getBooleanExtra(r1, r2);
        r0 = java.lang.Boolean.valueOf(r0);
        r7.canClose = r0;
    L_0x00fc:
        r0 = r7.getIntent();
        r1 = "mute";
        r0 = r0.hasExtra(r1);
        if (r0 == 0) goto L_0x0125;
    L_0x0108:
        r0 = r7.getIntent();
        r1 = "mute";
        r0 = r0.getBooleanExtra(r1, r2);
        r0 = java.lang.Boolean.valueOf(r0);
        r7.mute = r0;
        r0 = r7.mute;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x01bb;
    L_0x0120:
        r0 = "mute_on";
        r7.report(r0);
    L_0x0125:
        r0 = r7.getIntent();
        r1 = "pview";
        r0 = r0.hasExtra(r1);
        if (r0 == 0) goto L_0x0155;
    L_0x0131:
        r0 = r7.getIntent();
        r1 = "pview";
        r0 = r0.getStringExtra(r1);
        r7.kS = r0;
        r0 = r7.getIntent();
        r1 = "banner";
        r0 = r0.getStringExtra(r1);
        r7.banner = r0;
        r0 = r7.getIntent();
        r1 = "guid";
        r0 = r0.getStringExtra(r1);
        r7.guid = r0;
    L_0x0155:
        r0 = r7.getIntent();
        r1 = "ads";
        r0 = r0.getSerializableExtra(r1);
        r0 = (java.util.ArrayList) r0;
        r7.aL = r0;
        r0 = r7.placementID;
        r1 = "";
        r2 = "show_request";
        r7.b(r0, r1, r2);
        r0 = new android.os.Handler;
        r0.<init>();
        r7.eQ = r0;
        r0 = com.appnext.core.webview.AppnextWebView.D(r7);
        r1 = r7.eN;
        r1 = r1.getPageUrl();
        r2 = new com.appnext.ads.interstitial.InterstitialActivity$1;
        r2.<init>();
        r0.a(r1, r2);
        r0 = new com.appnext.ads.interstitial.InterstitialActivity$5;
        r0.<init>();
        r7.eR = r0;
        r0 = new com.appnext.core.s;
        r1 = new com.appnext.ads.interstitial.InterstitialActivity$6;
        r1.<init>();
        r0.<init>(r7, r1);
        r7.userAction = r0;
        r0 = new java.lang.Thread;
        r1 = new com.appnext.ads.interstitial.InterstitialActivity$7;
        r1.<init>();
        r0.<init>(r1);
        r0.start();
        goto L_0x0030;
    L_0x01a7:
        r0 = "loaded_portrait";
        r7.report(r0);
        goto L_0x0084;
    L_0x01ae:
        r0 = move-exception;
        r7.finish();
        goto L_0x0030;
    L_0x01b4:
        r0 = "auto_play_off";
        r7.report(r0);
        goto L_0x00e0;
    L_0x01bb:
        r0 = "mute_off";
        r7.report(r0);
        goto L_0x0125;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.ads.interstitial.InterstitialActivity.onCreate(android.os.Bundle):void");
    }

    protected void onDestroy() {
        super.onDestroy();
        try {
            this.eN = null;
            if (this.eQ != null) {
                this.eQ.removeCallbacksAndMessages(null);
            }
            this.eQ = null;
            this.eW = null;
            this.dB = null;
            if (this.eL != null) {
                this.eL.stopLoading();
                if (this.eL.getParent() != null) {
                    ((ViewGroup) this.eL.getParent()).removeView(this.eL);
                }
                this.eL.setWebChromeClient(null);
                this.eL.setWebViewClient(null);
                this.eL = null;
            }
            AppnextWebView.D(this).a(ar());
            this.eS = null;
            this.eR = null;
            if (this.dD != null) {
                this.dD.d(this);
                this.dD = null;
            }
        } catch (Throwable th) {
        }
    }

    protected void onError(final String str) {
        runOnUiThread(new Runnable() {
            public void run() {
                if (InterstitialActivity.this.eN != null && InterstitialActivity.this.eN.getOnAdErrorCallback() != null) {
                    InterstitialActivity.this.eN.getOnAdErrorCallback().adError(str);
                }
            }
        });
    }

    protected void onPause() {
        super.onPause();
        if (!this.closed) {
            stop();
        }
        if (this.handler != null) {
            this.handler.removeCallbacks(this.dG);
            this.handler.removeCallbacks(this.dH);
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.eM && this.autoPlay.booleanValue()) {
            play();
        }
    }
}
