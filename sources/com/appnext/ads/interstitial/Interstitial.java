package com.appnext.ads.interstitial;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.appnext.ads.AdsError;
import com.appnext.ads.a;
import com.appnext.core.Ad;
import com.appnext.core.AppnextAd;
import com.appnext.core.AppnextError;
import com.appnext.core.ECPM;
import com.appnext.core.c;
import com.appnext.core.callbacks.OnAdError;
import com.appnext.core.callbacks.OnECPMLoaded;
import com.appnext.core.g;
import com.appnext.core.l;
import com.appnext.core.r;
import com.appnext.core.webview.AppnextWebView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

public class Interstitial extends Ad {
    private static final String JS_URL = "https://cdn.appnext.com/tools/sdk/interstitial/v70/script.min.js";
    protected static final String TID = "301";
    public static final String TYPE_MANAGED = "managed";
    public static final String TYPE_STATIC = "static";
    public static final String TYPE_VIDEO = "video";
    protected static final String VID = "2.3.0.469";
    protected static Interstitial currentAd;
    private boolean autoPlay = true;
    private String buttonColor = "";
    private boolean calledShow = false;
    private Boolean canClose;
    private boolean configLoaded = false;
    private String creativeType = TYPE_MANAGED;
    protected boolean fq_status = false;
    private boolean setAutoPlay = false;
    private boolean setCanClose = false;
    private String skipText = "";
    private String titleText = "";
    private OnAdError userOnAdError;

    public Interstitial(Context context, String str) {
        super(context, str);
        init();
    }

    public Interstitial(Context context, String str, InterstitialConfig interstitialConfig) {
        super(context, str);
        init();
        if (interstitialConfig != null) {
            setPostback(interstitialConfig.getPostback());
            setCategories(interstitialConfig.getCategories());
            setButtonColor(interstitialConfig.getButtonColor());
            if (interstitialConfig.aw()) {
                setBackButtonCanClose(interstitialConfig.isBackButtonCanClose());
            }
            setSkipText(interstitialConfig.getSkipText());
            if (interstitialConfig.av()) {
                setAutoPlay(interstitialConfig.isAutoPlay());
            }
            setCreativeType(interstitialConfig.getCreativeType());
            setOrientation(interstitialConfig.getOrientation());
            if (interstitialConfig.ao()) {
                setMute(interstitialConfig.getMute());
            }
            setMinVideoLength(interstitialConfig.getMinVideoLength());
            setMaxVideoLength(interstitialConfig.getMaxVideoLength());
        }
    }

    private String getCreative() {
        int aO = g.aO(getConfig().get("min_internet_connection"));
        int aO2 = g.aO(getConfig().get("min_internet_connection_video"));
        int aO3 = g.aO(g.x(this.context));
        return (aO3 < aO || aO3 >= aO2) ? getCreativeType() : "static";
    }

    private boolean hasVideo(AppnextAd appnextAd) {
        return (appnextAd.getVideoUrl().equals("") && appnextAd.getVideoUrlHigh().equals("") && appnextAd.getVideoUrl30Sec().equals("") && appnextAd.getVideoUrlHigh30Sec().equals("")) ? false : true;
    }

    private void init() {
        loadConfig();
        AppnextWebView.D(this.context).a(getPageUrl(), null);
        if (checked_fq) {
            this.fq_status = Ad.fq;
        } else {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        String a = g.a("https://admin.appnext.com/AdminService.asmx/checkA?z=" + Interstitial.this.getPlacementID() + "&callback=", null);
                        Interstitial.fq = new JSONObject(a.substring(a.indexOf("(") + 1, a.lastIndexOf(")"))).getBoolean("status");
                        Interstitial.this.fq_status = Interstitial.fq;
                        g.X("fq " + Interstitial.this.fq_status);
                        Interstitial.checked_fq = true;
                    } catch (Throwable th) {
                        g.c(th);
                    }
                }
            }).start();
        }
        super.setOnAdErrorCallback(new OnAdError() {
            public void adError(String str) {
                String str2 = "";
                Object obj = -1;
                switch (str.hashCode()) {
                    case -2026653947:
                        if (str.equals(AppnextError.INTERNAL_ERROR)) {
                            obj = 1;
                            break;
                        }
                        break;
                    case -1958363695:
                        if (str.equals(AppnextError.NO_ADS)) {
                            obj = 2;
                            break;
                        }
                        break;
                    case -1477010874:
                        if (str.equals(AppnextError.CONNECTION_ERROR)) {
                            obj = null;
                            break;
                        }
                        break;
                    case -507110949:
                        if (str.equals(AppnextError.NO_MARKET)) {
                            obj = 3;
                            break;
                        }
                        break;
                    case 297538105:
                        if (str.equals(AdsError.AD_NOT_READY)) {
                            obj = 6;
                            break;
                        }
                        break;
                    case 350741825:
                        if (str.equals(AppnextError.TIMEOUT)) {
                            obj = 5;
                            break;
                        }
                        break;
                    case 844170097:
                        if (str.equals(AppnextError.SLOW_CONNECTION)) {
                            obj = 4;
                            break;
                        }
                        break;
                }
                switch (obj) {
                    case null:
                        str2 = a.cy;
                        break;
                    case 1:
                        str2 = a.cC;
                        break;
                    case 2:
                        str2 = a.cB;
                        break;
                    case 3:
                        str2 = a.cD;
                        break;
                    case 4:
                        str2 = a.cz;
                        break;
                    case 5:
                        str2 = a.cE;
                        break;
                    case 6:
                        str2 = a.cA;
                        break;
                }
                g.a(Interstitial.this.getTID(), Interstitial.this.getVID(), Interstitial.this.getAUID(), Interstitial.this.getPlacementID(), Interstitial.this.getSessionId(), str2, "current_interstitial", "", "");
                if (Interstitial.this.userOnAdError != null) {
                    Interstitial.this.userOnAdError.adError(str);
                }
            }
        });
    }

    private void loadConfig() {
        getConfig().a(new r.a() {
            public void a(HashMap<String, Object> hashMap) {
                Interstitial.this.configLoaded = true;
                l.dg().c(Integer.parseInt(Interstitial.this.getConfig().get("banner_expiration_time")));
                if (Interstitial.this.calledShow) {
                    Interstitial.this.showAd();
                }
            }

            public void error(String str) {
                Interstitial.this.configLoaded = true;
                l.dg().c(Integer.parseInt(Interstitial.this.getConfig().get("banner_expiration_time")));
                if (Interstitial.this.calledShow) {
                    Interstitial.this.showAd();
                }
            }
        });
    }

    public void destroy() {
        super.destroy();
        currentAd = null;
    }

    public String getAUID() {
        return "600";
    }

    protected Intent getActivityIntent() {
        Intent intent = new Intent(this.context, InterstitialActivity.class);
        intent.setFlags(268435456);
        intent.addFlags(67108864);
        intent.putExtra("id", getPlacementID());
        if (this.setAutoPlay) {
            intent.putExtra("auto_play", this.autoPlay);
        }
        if (this.setCanClose) {
            intent.putExtra("can_close", isBackButtonCanClose());
        }
        if (this.setMeute) {
            intent.putExtra("mute", getMute());
        }
        intent.putExtra("cat", getCategories());
        intent.putExtra("pbk", getPostback());
        intent.putExtra("b_color", getButtonColor());
        intent.putExtra("skip_title", getSkipText());
        intent.putExtra("creative", getCreative());
        return intent;
    }

    public String getButtonColor() {
        return this.buttonColor;
    }

    protected r getConfig() {
        return c.ax();
    }

    public String getCreativeType() {
        return this.creativeType;
    }

    public void getECPM(final OnECPMLoaded onECPMLoaded) {
        if (onECPMLoaded == null) {
            throw new IllegalArgumentException("Callback cannot be null");
        }
        a.au().a(this.context, this, getPlacementID(), new c.a() {
            public <T> void a(T t) {
                AppnextAd a = a.au().a(Interstitial.this.context, (ArrayList) t, Interstitial.this.getCreative(), Interstitial.this);
                if (a != null) {
                    onECPMLoaded.ecpm(new ECPM(a.getECPM(), a.getPPR(), a.getBannerID()));
                } else {
                    onECPMLoaded.error(AppnextError.NO_ADS);
                }
            }

            public void error(String str) {
                onECPMLoaded.error(str);
            }
        }, false);
    }

    protected com.appnext.core.webview.a getFallback() {
        return new b();
    }

    public OnAdError getOnAdErrorCallback() {
        return super.getOnAdErrorCallback();
    }

    protected String getPageUrl() {
        return JS_URL;
    }

    protected String getSessionId() {
        return super.getSessionId();
    }

    public String getSkipText() {
        return this.skipText;
    }

    public String getTID() {
        return TID;
    }

    public String getVID() {
        return "2.3.0.469";
    }

    public boolean isAdLoaded() {
        return !getPlacementID().equals("") && a.au().e(this);
    }

    public boolean isAutoPlay() {
        return this.autoPlay;
    }

    public boolean isBackButtonCanClose() {
        return this.canClose == null ? false : this.canClose.booleanValue();
    }

    public void loadAd() {
        if (getPlacementID().equals("")) {
            throw new IllegalArgumentException("Placement ID cannot be empty");
        } else if (g.g(this.context, "android.permission.INTERNET")) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        if (Interstitial.this.context.checkPermission("android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) != 0) {
                            g.a("http://www.appnext.com/myid.html", null);
                        } else {
                            NetworkInfo activeNetworkInfo = ((ConnectivityManager) Interstitial.this.context.getSystemService("connectivity")).getActiveNetworkInfo();
                            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                                throw new IOException();
                            }
                        }
                        a.au().a(Interstitial.this.context, Interstitial.this, Interstitial.this.getPlacementID(), new c.a() {
                            public <T> void a(T t) {
                                AppnextAd appnextAd = null;
                                try {
                                    appnextAd = a.au().a(Interstitial.this.context, (ArrayList) t, Interstitial.this.getCreative(), Interstitial.this);
                                } catch (Throwable th) {
                                    if (Interstitial.this.getOnAdErrorCallback() != null) {
                                        Interstitial.this.getOnAdErrorCallback().adError(AppnextError.NO_ADS);
                                    }
                                }
                                if (appnextAd != null) {
                                    if (Interstitial.this.getOnAdLoadedCallback() != null) {
                                        Interstitial.this.getOnAdLoadedCallback().adLoaded(appnextAd.getBannerID());
                                    }
                                } else if (Interstitial.this.getOnAdErrorCallback() != null) {
                                    Interstitial.this.getOnAdErrorCallback().adError(AppnextError.NO_ADS);
                                }
                            }

                            public void error(String str) {
                                if (Interstitial.this.getOnAdErrorCallback() != null) {
                                    Interstitial.this.getOnAdErrorCallback().adError(str);
                                }
                            }
                        }, Interstitial.this.getCreative());
                    } catch (Throwable th) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                if (Interstitial.this.getOnAdErrorCallback() != null) {
                                    Interstitial.this.getOnAdErrorCallback().adError(AppnextError.CONNECTION_ERROR);
                                }
                            }
                        });
                    }
                }
            }).start();
        } else if (getOnAdErrorCallback() != null) {
            getOnAdErrorCallback().adError(AppnextError.CONNECTION_ERROR);
        }
    }

    public void setAutoPlay(boolean z) {
        this.setAutoPlay = true;
        this.autoPlay = z;
    }

    public void setBackButtonCanClose(boolean z) {
        this.setCanClose = true;
        this.canClose = Boolean.valueOf(z);
    }

    public void setButtonColor(String str) {
        if (str == null || str.equals("")) {
            this.buttonColor = "";
            return;
        }
        if (!str.startsWith("#")) {
            str = "#" + str;
        }
        try {
            Color.parseColor(str);
            this.buttonColor = str;
        } catch (Throwable th) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown color");
        }
    }

    public void setCreativeType(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Wrong creative type");
        } else if (str.equals(TYPE_MANAGED) || str.equals("static") || str.equals("video")) {
            this.creativeType = str;
        } else {
            throw new IllegalArgumentException("Wrong creative type");
        }
    }

    public void setOnAdErrorCallback(OnAdError onAdError) {
        this.userOnAdError = onAdError;
    }

    public void setParams(String str, String str2) {
        getConfig().b(str, str2);
    }

    public void setSkipText(String str) {
        if (str == null) {
            str = "";
        }
        this.skipText = str;
    }

    public void showAd() {
        if (getPlacementID().equals("")) {
            throw new IllegalArgumentException("Placement ID cannot be empty");
        } else if (g.g(this.context, "android.permission.INTERNET")) {
            int aO = g.aO(getConfig().get("min_internet_connection"));
            int aO2 = g.aO(g.x(this.context));
            if (aO2 == -1) {
                if (getOnAdErrorCallback() != null) {
                    getOnAdErrorCallback().adError(AppnextError.CONNECTION_ERROR);
                }
            } else if (aO2 >= aO) {
                currentAd = this;
                Intent activityIntent = getActivityIntent();
                if (activityIntent == null) {
                    throw new IllegalArgumentException("null intent");
                }
                this.context.startActivity(activityIntent);
            } else if (getOnAdErrorCallback() != null) {
                getOnAdErrorCallback().adError(AppnextError.SLOW_CONNECTION);
            }
        } else if (getOnAdErrorCallback() != null) {
            getOnAdErrorCallback().adError(AppnextError.CONNECTION_ERROR);
        }
    }
}
