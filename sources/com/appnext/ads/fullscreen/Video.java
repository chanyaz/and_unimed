package com.appnext.ads.fullscreen;

import android.content.Context;
import android.content.Intent;
import com.appnext.ads.AdsError;
import com.appnext.base.b.c;
import com.appnext.core.Ad;
import com.appnext.core.AppnextAd;
import com.appnext.core.AppnextError;
import com.appnext.core.ECPM;
import com.appnext.core.callbacks.OnAdError;
import com.appnext.core.callbacks.OnECPMLoaded;
import com.appnext.core.callbacks.OnVideoEnded;
import com.appnext.core.g;
import com.appnext.core.l;
import com.appnext.core.r;
import com.appnext.core.r.a;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.io.File;
import java.util.HashMap;
import java.util.Random;
import org.json.JSONObject;

public abstract class Video extends Ad {
    protected static final int FULL_SCREEN_VIDEO = 1;
    protected static final int REWARDED_VIDEO = 2;
    protected static final String TID = "301";
    protected static final String VID = "2.3.0.469";
    public static final String VIDEO_LENGTH_LONG = "30";
    public static final String VIDEO_LENGTH_SHORT = "15";
    private static boolean cacheVideo = true;
    protected static Video currentAd;
    private static boolean init = false;
    private static boolean streamingEnable = false;
    protected boolean fq_status = false;
    protected long rnd;
    private int rollCaptionTime = -2;
    private boolean showCta = true;
    private int type;
    private OnAdError userOnAdError;
    private OnVideoEnded videoEnded;
    private String videoLength = "15";

    public Video(Context context, int i, String str) {
        super(context, str);
        this.type = i;
        this.rnd = (long) new Random(System.currentTimeMillis()).nextInt(MoPubClientPositioning.NO_REPEAT);
        init();
    }

    public Video(Context context, int i, String str, VideoConfig videoConfig) {
        super(context, str);
        this.type = i;
        this.rnd = (long) new Random(System.currentTimeMillis()).nextInt();
        init();
        if (videoConfig != null) {
            setPostback(videoConfig.getPostback());
            setCategories(videoConfig.getCategories());
            setOrientation(videoConfig.getOrientation());
            if (videoConfig.ap()) {
                setShowCta(videoConfig.isShowCta());
            }
            setRollCaptionTime(videoConfig.getRollCaptionTime());
            setVideoLength(videoConfig.getVideoLength());
            if (videoConfig.ao()) {
                setMute(videoConfig.getMute());
            }
            setMinVideoLength(videoConfig.getMinVideoLength());
            setMaxVideoLength(videoConfig.getMaxVideoLength());
        }
    }

    public static boolean getCacheVideo() {
        return cacheVideo;
    }

    private void init() {
        getConfig().a(new a() {
            public void a(HashMap<String, Object> hashMap) {
                l.dg().c(Integer.parseInt(Video.this.getConfig().get("banner_expiration_time")));
            }

            public void error(String str) {
                l.dg().c(Integer.parseInt(Video.this.getConfig().get("banner_expiration_time")));
            }
        });
        if (checked_fq) {
            this.fq_status = Ad.fq;
        } else {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        String a = g.a("https://admin.appnext.com/AdminService.asmx/checkA?z=" + Video.this.getPlacementID() + "&callback=", null);
                        Video.fq = new JSONObject(a.substring(a.indexOf("(") + 1, a.lastIndexOf(")"))).getBoolean("status");
                        Video.this.fq_status = Video.fq;
                        g.X("fq " + Video.this.fq_status);
                        Video.checked_fq = true;
                    } catch (Throwable th) {
                        g.c(th);
                    }
                }
            }).start();
        }
        new Thread(new Runnable() {
            public void run() {
                if (!Video.init) {
                    Video.init = true;
                    g.b(new File(Video.this.context.getFilesDir().getAbsolutePath() + c.jf + c.jg + "tmp/"));
                }
            }
        }).start();
        super.setOnAdErrorCallback(new OnAdError() {
            public void adError(String str) {
                String str2 = "";
                Object obj = -1;
                switch (str.hashCode()) {
                    case -2026653947:
                        if (str.equals(AppnextError.INTERNAL_ERROR)) {
                            int obj2 = 1;
                            break;
                        }
                        break;
                    case -1958363695:
                        if (str.equals(AppnextError.NO_ADS)) {
                            obj2 = 2;
                            break;
                        }
                        break;
                    case -1477010874:
                        if (str.equals(AppnextError.CONNECTION_ERROR)) {
                            obj2 = null;
                            break;
                        }
                        break;
                    case -507110949:
                        if (str.equals(AppnextError.NO_MARKET)) {
                            obj2 = 3;
                            break;
                        }
                        break;
                    case 297538105:
                        if (str.equals(AdsError.AD_NOT_READY)) {
                            obj2 = 6;
                            break;
                        }
                        break;
                    case 350741825:
                        if (str.equals(AppnextError.TIMEOUT)) {
                            obj2 = 5;
                            break;
                        }
                        break;
                    case 844170097:
                        if (str.equals(AppnextError.SLOW_CONNECTION)) {
                            obj2 = 4;
                            break;
                        }
                        break;
                }
                switch (obj2) {
                    case null:
                        str2 = com.appnext.ads.a.cy;
                        break;
                    case 1:
                        str2 = com.appnext.ads.a.cC;
                        break;
                    case 2:
                        str2 = com.appnext.ads.a.cB;
                        break;
                    case 3:
                        str2 = com.appnext.ads.a.cD;
                        break;
                    case 4:
                        str2 = com.appnext.ads.a.cz;
                        break;
                    case 5:
                        str2 = com.appnext.ads.a.cE;
                        break;
                    case 6:
                        str2 = com.appnext.ads.a.cA;
                        break;
                }
                g.a(Video.this.getTID(), Video.this.getVID(), Video.this.getAUID(), Video.this.getPlacementID(), Video.this.getSessionId(), str2, Video.this.type == 1 ? "fullscreen" : "rewarded", "", "");
                if (Video.this.userOnAdError != null) {
                    Video.this.userOnAdError.adError(str);
                }
            }
        });
    }

    public static boolean isStreamingModeEnabled() {
        return streamingEnable;
    }

    public static void setCacheVideo(boolean z) {
        cacheVideo = z;
    }

    public static void setStreamingMode(boolean z) {
        streamingEnable = z;
    }

    public void destroy() {
        super.destroy();
        this.videoEnded = null;
        try {
            g.b(new File(this.context.getFilesDir().getAbsolutePath() + c.jf + c.jg + "tmp/vid" + this.rnd + "/"));
        } catch (Throwable th) {
        }
    }

    protected void finalize() {
        try {
            destroy();
        } catch (Throwable th) {
        } finally {
            super.finalize();
        }
    }

    protected r getConfig() {
        return this.type == 2 ? f.al() : this.type == 1 ? c.aj() : null;
    }

    public void getECPM(final OnECPMLoaded onECPMLoaded) {
        if (onECPMLoaded == null) {
            throw new IllegalArgumentException("Callback cannot be null");
        }
        b.ag().a(this.context, this, getPlacementID(), new com.appnext.core.c.a() {
            public <T> void a(T t) {
                AppnextAd b = b.ag().b(Video.this.context, Video.this);
                if (b != null) {
                    onECPMLoaded.ecpm(new ECPM(b.getECPM(), b.getPPR(), b.getBannerID()));
                } else {
                    onECPMLoaded.error(AppnextError.NO_ADS);
                }
            }

            public void error(String str) {
                onECPMLoaded.error(str);
            }
        }, false);
    }

    public OnAdError getOnAdErrorCallback() {
        return super.getOnAdErrorCallback();
    }

    public OnVideoEnded getOnVideoEndedCallback() {
        return this.videoEnded;
    }

    public int getRollCaptionTime() {
        return this.rollCaptionTime;
    }

    protected String getSessionId() {
        return super.getSessionId();
    }

    public String getTID() {
        return TID;
    }

    public String getVID() {
        return "2.3.0.469";
    }

    public String getVideoLength() {
        return this.videoLength;
    }

    public boolean isAdLoaded() {
        return getPlacementID().equals("") ? false : b.ag().g(this);
    }

    public boolean isShowCta() {
        return this.showCta;
    }

    public void loadAd() {
        if (getPlacementID().equals("")) {
            throw new IllegalArgumentException("Placement ID cannot be empty");
        } else if (g.g(this.context, "android.permission.INTERNET")) {
            b.ag().a(this.context, (Ad) this, getPlacementID(), new com.appnext.core.c.a() {
                public <T> void a(T t) {
                    AppnextAd b = b.ag().b(Video.this.context, Video.this);
                    if (Video.this.getOnAdLoadedCallback() == null) {
                        return;
                    }
                    if (b != null) {
                        Video.this.getOnAdLoadedCallback().adLoaded(b.getBannerID());
                    } else if (Video.this.getOnAdErrorCallback() != null) {
                        Video.this.getOnAdErrorCallback().adError(AppnextError.NO_ADS);
                    }
                }

                public void error(String str) {
                    if (Video.this.getOnAdErrorCallback() != null) {
                        Video.this.getOnAdErrorCallback().adError(str);
                    }
                }
            });
        } else if (getOnAdErrorCallback() != null) {
            getOnAdErrorCallback().adError(AppnextError.CONNECTION_ERROR);
        }
    }

    public void setOnAdErrorCallback(OnAdError onAdError) {
        this.userOnAdError = onAdError;
    }

    public void setOnVideoEndedCallback(OnVideoEnded onVideoEnded) {
        this.videoEnded = onVideoEnded;
    }

    public void setParams(String str, String str2) {
        getConfig().b(str, str2);
    }

    public void setRollCaptionTime(int i) {
        if (i == -1 || (i >= 3 && i <= 10)) {
            this.rollCaptionTime = i;
        }
    }

    public void setShowCta(boolean z) {
        this.showCta = z;
    }

    public void setVideoLength(String str) {
        if (str.equals("15") || str.equals("30")) {
            this.videoLength = str;
            return;
        }
        throw new IllegalArgumentException("Wrong video length");
    }

    public void showAd() {
        if (getPlacementID().equals("")) {
            throw new IllegalArgumentException("Placement ID cannot be empty");
        } else if (g.g(this.context, "android.permission.INTERNET")) {
            int aO = g.aO(getConfig().get("min_internet_connection_video"));
            int aO2 = g.aO(g.x(this.context));
            if (aO2 == -1) {
                if (getOnAdErrorCallback() != null) {
                    getOnAdErrorCallback().adError(AppnextError.CONNECTION_ERROR);
                }
            } else if (aO2 >= aO) {
                g.a(getTID(), getVID(), getAUID(), getPlacementID(), getSessionId(), com.appnext.ads.a.ch, this.type == 1 ? "fullscreen" : "rewarded", "", "");
                if (b.ag().g(this)) {
                    Intent intent = new Intent(this.context, FullscreenActivity.class);
                    intent.setFlags(268435456);
                    intent.putExtra("id", getPlacementID());
                    intent.putExtra("type", this.type);
                    currentAd = this;
                    this.context.startActivity(intent);
                    return;
                }
                if (getOnAdErrorCallback() != null) {
                    getOnAdErrorCallback().adError(AdsError.AD_NOT_READY);
                }
                b.ag().a(this.context, (Ad) this, getPlacementID(), null);
                g.a(getTID(), getVID(), getAUID(), getPlacementID(), getSessionId(), com.appnext.ads.a.AD_NOT_READY, this.type == 1 ? "fullscreen" : "rewarded", "", "");
            } else if (getOnAdErrorCallback() != null) {
                getOnAdErrorCallback().adError(AppnextError.SLOW_CONNECTION);
            }
        } else if (getOnAdErrorCallback() != null) {
            getOnAdErrorCallback().adError(AppnextError.CONNECTION_ERROR);
        }
    }
}
