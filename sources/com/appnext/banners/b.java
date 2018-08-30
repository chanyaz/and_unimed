package com.appnext.banners;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Pair;
import com.appnext.core.Ad;
import com.appnext.core.AppnextAd;
import com.appnext.core.AppnextError;
import com.appnext.core.a;
import com.appnext.core.c;
import com.appnext.core.g;
import com.appnext.core.i;
import com.appnext.core.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import org.json.JSONArray;

class b extends c {
    private static b fE;
    private final int dL = 50;

    private b() {
    }

    private boolean a(Context context, BannerAdData bannerAdData) {
        if (bannerAdData.getCptList().equals("") || bannerAdData.getCptList().equals("[]")) {
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(bannerAdData.getCptList());
            for (int i = 0; i < jSONArray.length(); i++) {
                if (g.h(context, jSONArray.getString(i))) {
                    return true;
                }
            }
            return false;
        } catch (Throwable e) {
            g.c(e);
            return true;
        }
    }

    private boolean a(AppnextAd appnextAd, String str) {
        boolean z = true;
        switch (str.hashCode()) {
            case -892481938:
                if (str.equals("static")) {
                    z = true;
                    break;
                }
                break;
            case 96673:
                if (str.equals(BannerAdRequest.TYPE_ALL)) {
                    z = false;
                    break;
                }
                break;
            case 112202875:
                if (str.equals("video")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                return c(appnextAd) || hasVideo(appnextAd);
            case true:
                return c(appnextAd);
            case true:
                return hasVideo(appnextAd);
            default:
                return false;
        }
    }

    public static synchronized b aE() {
        b bVar;
        synchronized (b.class) {
            if (fE == null) {
                fE = new b();
            }
            bVar = fE;
        }
        return bVar;
    }

    static boolean c(AppnextAd appnextAd) {
        return !appnextAd.getWideImageURL().equals("");
    }

    static boolean hasVideo(AppnextAd appnextAd) {
        return (appnextAd.getVideoUrl().equals("") && appnextAd.getVideoUrlHigh().equals("") && appnextAd.getVideoUrl30Sec().equals("") && appnextAd.getVideoUrlHigh30Sec().equals("")) ? false : true;
    }

    protected AppnextAd a(Context context, Ad ad, String str) {
        if (j(ad) == null) {
            return null;
        }
        ArrayList cQ = j(ad).cQ();
        return cQ != null ? a(context, ad, cQ, str) : null;
    }

    protected AppnextAd a(Context context, Ad ad, ArrayList<?> arrayList, String str) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            AppnextAd appnextAd = (AppnextAd) it.next();
            if (a(appnextAd, str) && !c(appnextAd.getBannerID(), ad.getPlacementID())) {
                return appnextAd;
            }
        }
        return null;
    }

    protected String a(Context context, Ad ad, String str, ArrayList<Pair<String, String>> arrayList) {
        return "https://global.appnext.com" + "/offerWallApi.aspx?ext=t&pimp=1&igroup=sdk&m=1&osid=100&auid=" + (ad != null ? ad.getAUID() : "1000") + "&type=json&id=" + str + "&cnt=" + 50 + "&tid=" + (ad != null ? ad.getTID() : "301") + "&vid=" + (ad != null ? ad.getVID() : "2.3.0.469") + "&cat=" + (ad != null ? ad.getCategories() : "") + "&pbk=" + (ad != null ? ad.getPostback() : "") + "&did=" + g.c(context, false) + "&devn=" + g.da() + "&dosv=" + VERSION.SDK_INT + "&dct=" + g.aO(g.x(context)) + "&lang=" + g.cB() + "&dcc=" + g.y(context) + "&dds=" + ((int) g.dc()) + "&packageId=" + context.getPackageName() + "&rnd=" + new Random().nextInt();
    }

    protected void a(Context context, Ad ad, a aVar) {
        AppnextAd a = a(context, ad, ((BannerAdRequest) ((BannerAd) ad).getAdRequest()).getCreativeType());
        if (a == null) {
            throw new Exception(AppnextError.NO_ADS);
        }
        g.aN(a.getImageURL());
        if (ad instanceof MediumRectangleAd) {
            g.aN(a.getWideImageURL());
        }
    }

    public void a(Context context, Ad ad, String str, c.a aVar, BannerAdRequest bannerAdRequest) {
        ((BannerAd) ad).setAdRequest(new BannerAdRequest(bannerAdRequest));
        super.a(context, ad, str, aVar);
    }

    protected void a(Ad ad, String str, String str2) {
        g.X("error " + str);
    }

    protected <T> void a(String str, Ad ad, T t) {
    }

    protected boolean a(Context context, Ad ad, ArrayList<?> arrayList) {
        return a(context, ad, (ArrayList) arrayList, ((BannerAdRequest) ((BannerAd) ad).getAdRequest()).getCreativeType()) != null;
    }

    protected boolean a(Context context, i iVar) {
        BannerAdData bannerAdData = new BannerAdData((AppnextAd) iVar);
        return !a(context, bannerAdData) ? false : (bannerAdData.getCampaignGoal().equals("new") && g.h(context, bannerAdData.getAdPackage())) ? false : (!bannerAdData.getCampaignGoal().equals("existing") || g.h(context, bannerAdData.getAdPackage())) ? c((AppnextAd) iVar) : false;
    }

    protected r d(Ad ad) {
        return c.aF();
    }
}
