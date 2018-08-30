package com.appnext.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.appnext.base.Appnext;
import com.appnext.core.callbacks.OnAdClicked;
import com.appnext.core.callbacks.OnAdClosed;
import com.appnext.core.callbacks.OnAdError;
import com.appnext.core.callbacks.OnAdLoaded;
import com.appnext.core.callbacks.OnAdOpened;
import com.appnext.core.callbacks.OnECPMLoaded;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public abstract class Ad {
    public static final String ORIENTATION_AUTO = "automatic";
    public static final String ORIENTATION_DEFAULT = "not_set";
    public static final String ORIENTATION_LANDSCAPE = "landscape";
    public static final String ORIENTATION_PORTRAIT = "portrait";
    protected static boolean checked_fq = false;
    protected static boolean fq = false;
    private OnAdOpened adOpenedCallback;
    private b adRequest;
    private String cat = "";
    private OnAdClosed closeCallback;
    private int cnt = 50;
    protected Context context;
    private int maxVideoLength = 0;
    private int minVideoLength = 0;
    private boolean mute = false;
    private OnAdClicked onAdClicked;
    private OnAdError onAdError;
    private OnAdLoaded onAdLoaded;
    private String orientation = ORIENTATION_DEFAULT;
    private String pbk = "";
    private String placementID = "";
    private String sessionId = "";
    protected boolean setMeute = false;

    public Ad(final Context context, String str) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null");
        } else if (str == null) {
            throw new IllegalArgumentException("placementID cannot be null");
        } else {
            this.context = context;
            setPlacementID(str);
            l.dg().i(context, str);
            Appnext.init(context);
            if (g.cZ().equals("")) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        g.v(context);
                    }
                });
            }
            new Thread(new Runnable() {
                public void run() {
                    Ad.this.setSessionId(g.z(context));
                }
            }).start();
        }
    }

    protected Ad(Ad ad) {
        this.context = ad.context;
        setPlacementID(ad.getPlacementID());
        setCategories(ad.cat);
        setPostback(ad.getPostback());
        setCount(ad.getCount());
        setMinVideoLength(ad.getMinVideoLength());
        setMaxVideoLength(ad.getMaxVideoLength());
        setSessionId(ad.getSessionId());
        this.onAdClicked = ad.onAdClicked;
        this.onAdError = ad.onAdError;
        this.onAdLoaded = ad.onAdLoaded;
        this.closeCallback = ad.closeCallback;
        this.adOpenedCallback = ad.adOpenedCallback;
    }

    public void destroy() {
        this.context = null;
        this.onAdClicked = null;
        this.onAdError = null;
        this.onAdLoaded = null;
        this.closeCallback = null;
        this.adOpenedCallback = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!getClass().isInstance(obj) && !obj.getClass().isInstance(this)) {
            return false;
        }
        if (!(obj instanceof Ad)) {
            return super.equals(obj);
        }
        boolean z = ((Ad) obj).getPlacementID().equals(getPlacementID()) && ((Ad) obj).getCategories().equals(getCategories()) && ((Ad) obj).getPostback().equals(getPostback()) && ((Ad) obj).getMinVideoLength() == getMinVideoLength() && ((Ad) obj).getMaxVideoLength() == getMaxVideoLength() && ((Ad) obj).getCount() == getCount();
        return z;
    }

    public abstract String getAUID();

    protected b getAdRequest() {
        return this.adRequest;
    }

    public String getCategories() {
        return this.cat;
    }

    protected Context getContext() {
        return this.context;
    }

    protected int getCount() {
        return this.cnt;
    }

    public abstract void getECPM(OnECPMLoaded onECPMLoaded);

    public int getMaxVideoLength() {
        return this.maxVideoLength;
    }

    public int getMinVideoLength() {
        return this.minVideoLength;
    }

    public boolean getMute() {
        return this.mute;
    }

    public OnAdClicked getOnAdClickedCallback() {
        return this.onAdClicked;
    }

    public OnAdClosed getOnAdClosedCallback() {
        return this.closeCallback;
    }

    public OnAdError getOnAdErrorCallback() {
        return this.onAdError;
    }

    public OnAdLoaded getOnAdLoadedCallback() {
        return this.onAdLoaded;
    }

    public OnAdOpened getOnAdOpenedCallback() {
        return this.adOpenedCallback;
    }

    public String getOrientation() {
        return this.orientation;
    }

    public String getPlacementID() {
        return this.placementID;
    }

    public String getPostback() {
        return this.pbk;
    }

    protected String getSessionId() {
        return this.sessionId;
    }

    public abstract String getTID();

    public abstract String getVID();

    public int hashCode() {
        return (((((((((getPlacementID().hashCode() * 31) + getCategories().hashCode()) * 31) + getPostback().hashCode()) * 31) + getCount()) * 31) + getMinVideoLength()) * 31) + getMaxVideoLength();
    }

    public abstract boolean isAdLoaded();

    public abstract void loadAd();

    protected void setAdRequest(b bVar) {
        this.adRequest = bVar;
    }

    public void setCategories(String str) {
        String str2 = str == null ? "" : str;
        try {
            if (str2.equals(URLDecoder.decode(str2, "UTF-8"))) {
                str2 = URLEncoder.encode(str2, "UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            str2 = "";
        }
        this.cat = str2;
    }

    protected void setCount(int i) {
        this.cnt = i;
    }

    public void setMaxVideoLength(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Max Length must be higher than 0");
        } else if (i <= 0 || getMinVideoLength() <= 0 || i >= getMinVideoLength()) {
            this.maxVideoLength = i;
        } else {
            throw new IllegalArgumentException("Max Length cannot be lower than min length");
        }
    }

    public void setMinVideoLength(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Min Length must be higher than 0");
        } else if (i <= 0 || getMaxVideoLength() <= 0 || i <= getMaxVideoLength()) {
            this.minVideoLength = i;
        } else {
            throw new IllegalArgumentException("Min Length cannot be higher than max length");
        }
    }

    public void setMute(boolean z) {
        this.setMeute = true;
        this.mute = z;
    }

    public void setOnAdClickedCallback(OnAdClicked onAdClicked) {
        this.onAdClicked = onAdClicked;
    }

    public void setOnAdClosedCallback(OnAdClosed onAdClosed) {
        this.closeCallback = onAdClosed;
    }

    public void setOnAdErrorCallback(OnAdError onAdError) {
        this.onAdError = onAdError;
    }

    public void setOnAdLoadedCallback(OnAdLoaded onAdLoaded) {
        this.onAdLoaded = onAdLoaded;
    }

    public void setOnAdOpenedCallback(OnAdOpened onAdOpened) {
        this.adOpenedCallback = onAdOpened;
    }

    public void setOrientation(String str) {
        if (str == null) {
            throw new IllegalArgumentException("orientation type");
        } else if (str.equals(ORIENTATION_AUTO) || str.equals(ORIENTATION_DEFAULT) || str.equals(ORIENTATION_LANDSCAPE) || str.equals(ORIENTATION_PORTRAIT)) {
            this.orientation = str;
        } else {
            throw new IllegalArgumentException("Wrong orientation type");
        }
    }

    protected void setPlacementID(String str) {
        this.placementID = str;
    }

    public void setPostback(String str) {
        String str2 = str == null ? "" : str;
        try {
            if (str2.equals(URLDecoder.decode(str2, "UTF-8"))) {
                str2 = URLEncoder.encode(str2, "UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            str2 = "";
        }
        this.pbk = str2;
    }

    protected void setSessionId(String str) {
        this.sessionId = str;
    }

    public abstract void showAd();
}
