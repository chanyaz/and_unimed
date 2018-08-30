package com.appnext.ads.interstitial;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Pair;
import com.appnext.core.Ad;
import com.appnext.core.AppnextAd;
import com.appnext.core.c;
import com.appnext.core.g;
import com.appnext.core.i;
import com.appnext.core.r;
import com.appnext.core.webview.AppnextWebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.json.JSONArray;

public class a extends c {
    private static final int dL = 30;
    private static a fc;
    private HashMap<Ad, String> dM = new HashMap();
    private String eO;

    private a() {
    }

    private ArrayList<AppnextAd> a(ArrayList<AppnextAd> arrayList, AppnextAd appnextAd) {
        arrayList.remove(appnextAd);
        arrayList.add(0, appnextAd);
        return arrayList;
    }

    private boolean a(Context context, AppnextAd appnextAd) {
        InterstitialAd interstitialAd = new InterstitialAd(appnextAd);
        return (interstitialAd.getCampaignGoal().equals("new") && g.h(context, interstitialAd.getAdPackage())) ? false : !interstitialAd.getCampaignGoal().equals("existing") || g.h(context, interstitialAd.getAdPackage());
    }

    private boolean a(AppnextAd appnextAd, String str, Ad ad) {
        boolean z = true;
        switch (str.hashCode()) {
            case -892481938:
                if (str.equals("static")) {
                    z = true;
                    break;
                }
                break;
            case 112202875:
                if (str.equals("video")) {
                    z = true;
                    break;
                }
                break;
            case 835260319:
                if (str.equals(Interstitial.TYPE_MANAGED)) {
                    z = false;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                if ((c(appnextAd) || hasVideo(appnextAd)) && !c(appnextAd.getBannerID(), ad.getPlacementID())) {
                    return true;
                }
            case true:
                if (hasVideo(appnextAd) && !c(appnextAd.getBannerID(), ad.getPlacementID())) {
                    return true;
                }
            case true:
                if (c(appnextAd) && !c(appnextAd.getBannerID(), ad.getPlacementID())) {
                    return true;
                }
        }
        return false;
    }

    public static synchronized a au() {
        a aVar;
        synchronized (a.class) {
            if (fc == null) {
                fc = new a();
            }
            aVar = fc;
        }
        return aVar;
    }

    private boolean b(Context context, AppnextAd appnextAd) {
        InterstitialAd interstitialAd = new InterstitialAd(appnextAd);
        if (interstitialAd.getCptList().equals("") || interstitialAd.getCptList().equals("[]")) {
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(interstitialAd.getCptList());
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

    private boolean c(AppnextAd appnextAd) {
        return !appnextAd.getWideImageURL().equals("");
    }

    private boolean hasVideo(AppnextAd appnextAd) {
        return (appnextAd.getVideoUrl().equals("") && appnextAd.getVideoUrlHigh().equals("") && appnextAd.getVideoUrl30Sec().equals("") && appnextAd.getVideoUrlHigh30Sec().equals("")) ? false : true;
    }

    protected AppnextAd a(Context context, ArrayList<AppnextAd> arrayList, String str, Ad ad) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            AppnextAd appnextAd = (AppnextAd) it.next();
            if (a(appnextAd, str, ad)) {
                return appnextAd;
            }
        }
        return null;
    }

    protected String a(Context context, Ad ad, String str, ArrayList<Pair<String, String>> arrayList) {
        return "https://global.appnext.com" + "/offerWallApi.aspx?ext=t&pimp=1&type=json&igroup=sdk&m=1&osid=100&auid=" + (ad != null ? ad.getAUID() : "600") + "&id=" + str + "&cnt=" + 30 + "&vid=" + (ad != null ? ad.getVID() : "2.3.0.469") + "&tid=" + (ad != null ? ad.getTID() : "301") + "&cat=" + (ad == null ? "" : ad.getCategories()) + "&pbk=" + (ad == null ? "" : ad.getPostback()) + "&vidmin=" + (ad == null ? "" : Integer.valueOf(ad.getMinVideoLength())) + "&vidmax=" + (ad == null ? "" : Integer.valueOf(ad.getMaxVideoLength())) + "&did=" + g.c(context, false) + "&devn=" + g.da() + "&dosv=" + VERSION.SDK_INT + "&dct=" + g.aO(g.x(context)) + "&lang=" + g.cB() + "&dcc=" + g.y(context) + "&dds=" + ((int) g.dc()) + (this.eO.equals("static") ? "&creative=0" : "") + "&packageId=" + context.getPackageName() + "&rnd=" + new Random().nextInt();
    }

    protected void a(Context context, Ad ad, com.appnext.core.a aVar) {
        AppnextWebView.D(context).a(((Interstitial) ad).getPageUrl(), null);
    }

    public void a(Context context, Ad ad, String str, com.appnext.core.c.a aVar, String str2) {
        this.eO = str2;
        super.a(context, ad, str, aVar);
    }

    protected void a(Ad ad, String str, String str2) {
        g.X("error " + str);
    }

    protected void a(String str, Ad ad) {
        super.a(str, ad);
        if (this.dM.containsKey(ad)) {
            this.dM.remove(ad);
        }
    }

    protected <T> void a(String str, Ad ad, T t) {
    }

    protected boolean a(Context context, Ad ad, ArrayList<?> arrayList) {
        return a(context, (ArrayList) arrayList, ((Interstitial) ad).getCreativeType(), ad) != null;
    }

    protected boolean a(Context context, i iVar) {
        return a(context, (AppnextAd) iVar) && b(context, (AppnextAd) iVar);
    }

    protected ArrayList<AppnextAd> b(Context context, Ad ad, String str) {
        if (j(ad) == null) {
            return null;
        }
        ArrayList cQ = j(ad).cQ();
        if (cQ == null) {
            return null;
        }
        AppnextAd a = a(context, cQ, str, ad);
        return a != null ? a(cQ, a) : null;
    }

    protected r d(Ad ad) {
        return c.ax();
    }

    protected String d(ArrayList<AppnextAd> arrayList) {
        return super.d((ArrayList) arrayList);
    }

    protected boolean e(Ad ad) {
        return b(ad) && j(ad).cQ() != null && j(ad).cQ().size() > 0;
    }
}
