package com.appnext.banners;

import android.content.Context;
import com.appnext.core.Ad;
import com.appnext.core.b;
import com.appnext.core.callbacks.OnECPMLoaded;
import com.appnext.core.g;
import org.json.JSONObject;

class BannerAd extends Ad {
    protected static final String TID = "301";
    protected static final String VID = "2.3.0.469";
    boolean fq_status = false;

    public BannerAd(Context context, String str) {
        super(context, str);
        if (checked_fq) {
            this.fq_status = Ad.fq;
        } else {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        String a = g.a("https://admin.appnext.com/AdminService.asmx/checkA?z=" + BannerAd.this.getPlacementID() + "&callback=", null);
                        BannerAd.fq = new JSONObject(a.substring(a.indexOf("(") + 1, a.lastIndexOf(")"))).getBoolean("status");
                        BannerAd.this.fq_status = BannerAd.fq;
                        g.X("fq " + BannerAd.this.fq_status);
                        BannerAd.checked_fq = true;
                    } catch (Throwable th) {
                        g.c(th);
                    }
                }
            }).start();
        }
    }

    protected BannerAd(Ad ad) {
        super(ad);
    }

    public String getAUID() {
        return "1000";
    }

    protected b getAdRequest() {
        return super.getAdRequest();
    }

    public void getECPM(OnECPMLoaded onECPMLoaded) {
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

    public boolean isAdLoaded() {
        return false;
    }

    public void loadAd() {
    }

    protected void setAdRequest(b bVar) {
        super.setAdRequest(bVar);
    }

    public void showAd() {
    }
}
