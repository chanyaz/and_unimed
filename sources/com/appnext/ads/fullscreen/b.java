package com.appnext.ads.fullscreen;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Pair;
import com.appnext.ads.a;
import com.appnext.core.Ad;
import com.appnext.core.AppnextAd;
import com.appnext.core.c;
import com.appnext.core.g;
import com.appnext.core.i;
import com.appnext.core.r;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.json.JSONArray;

public class b extends c {
    private static b dK;
    private final int dL = 30;
    private HashMap<Ad, String> dM = new HashMap();

    private b() {
    }

    protected static String O(String str) {
        String substring = str.substring(str.lastIndexOf("/") + 1);
        if (substring.contains("?")) {
            substring = substring.substring(0, substring.indexOf("?"));
        }
        try {
            String queryParameter = Uri.parse(str).getQueryParameter("rnd");
            return (queryParameter == null || queryParameter.equals("")) ? substring : substring.substring(0, substring.lastIndexOf(46)) + "_" + queryParameter + substring.substring(substring.lastIndexOf(46));
        } catch (Throwable th) {
            return substring;
        }
    }

    private void a(Context context, Ad ad) {
        int i = 0;
        try {
            File[] listFiles = new File(context.getFilesDir().getAbsolutePath() + com.appnext.base.b.c.jf + com.appnext.base.b.c.jg).listFiles();
            Arrays.sort(listFiles, new Comparator<File>() {
                /* renamed from: a */
                public int compare(File file, File file2) {
                    return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
                }
            });
            r1 = Video.getCacheVideo() ? ad instanceof FullScreenVideo ? Integer.parseInt(c.aj().get("num_saved_videos")) - 1 : Integer.parseInt(f.al().get("num_saved_videos")) - 1 : 0;
            if (listFiles.length > r1) {
                while (i < listFiles.length - r1) {
                    listFiles[i].delete();
                    i++;
                }
            }
        } catch (Throwable th) {
        }
    }

    private void a(Context context, Ad ad, AppnextAd appnextAd) {
        if (!appnextAd.getImageURL().equals("")) {
            g.aN(appnextAd.getImageURL());
        }
        if (!appnextAd.getWideImageURL().equals("")) {
            g.aN(appnextAd.getWideImageURL());
        }
        String videoUrl = getVideoUrl(appnextAd, ((Video) ad).getVideoLength());
        String O = O(videoUrl);
        String str = Video.getCacheVideo() ? context.getFilesDir().getAbsolutePath() + com.appnext.base.b.c.jf + com.appnext.base.b.c.jg : context.getFilesDir().getAbsolutePath() + com.appnext.base.b.c.jf + com.appnext.base.b.c.jg + "tmp/vid" + ((Video) ad).rnd + "/";
        File file = new File(str + O);
        if (file.exists()) {
            file.setLastModified(System.currentTimeMillis());
            g.X(file.getPath() + " exists");
            this.dM.put(ad, file.getAbsolutePath());
        } else if (!Video.isStreamingModeEnabled()) {
            new File(str).mkdirs();
            URL url = new URL(videoUrl);
            url.openConnection().connect();
            InputStream bufferedInputStream = new BufferedInputStream(url.openStream(), com.appnext.base.b.c.jk);
            OutputStream fileOutputStream = new FileOutputStream(str + O + com.appnext.base.b.c.jh);
            byte[] bArr = new byte[com.appnext.base.b.c.jk];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    g.X("downloaded " + str + O);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    bufferedInputStream.close();
                    File file2 = new File(str + O + com.appnext.base.b.c.jh);
                    file2.renameTo(new File(str + O));
                    file2.delete();
                    this.dM.put(ad, file.getAbsolutePath());
                    return;
                }
            }
        }
    }

    private boolean a(Context context, AppnextAd appnextAd) {
        FullscreenAd fullscreenAd = new FullscreenAd(appnextAd);
        return (fullscreenAd.getCampaignGoal().equals("new") && g.h(context, fullscreenAd.getAdPackage())) ? false : !fullscreenAd.getCampaignGoal().equals("existing") || g.h(context, fullscreenAd.getAdPackage());
    }

    public static synchronized b ag() {
        b bVar;
        synchronized (b.class) {
            if (dK == null) {
                dK = new b();
            }
            bVar = dK;
        }
        return bVar;
    }

    private boolean b(Context context, AppnextAd appnextAd) {
        FullscreenAd fullscreenAd = new FullscreenAd(appnextAd);
        if (fullscreenAd.getCptList().equals("") || fullscreenAd.getCptList().equals("[]")) {
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(fullscreenAd.getCptList());
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

    private boolean b(AppnextAd appnextAd) {
        return (appnextAd.getVideoUrlHigh().equals("") && appnextAd.getVideoUrlHigh30Sec().equals("")) ? false : true;
    }

    protected static String getVideoUrl(AppnextAd appnextAd, String str) {
        String videoUrlHigh30Sec;
        if (str.equals("30")) {
            videoUrlHigh30Sec = appnextAd.getVideoUrlHigh30Sec();
            if (videoUrlHigh30Sec.equals("")) {
                videoUrlHigh30Sec = appnextAd.getVideoUrlHigh();
            }
        } else {
            videoUrlHigh30Sec = appnextAd.getVideoUrlHigh();
            if (videoUrlHigh30Sec.equals("")) {
                videoUrlHigh30Sec = appnextAd.getVideoUrlHigh30Sec();
            }
        }
        g.X("returning video url for: " + appnextAd.getBannerID() + " with len: " + str + " url: " + videoUrlHigh30Sec);
        return videoUrlHigh30Sec;
    }

    private boolean h(Ad ad) {
        return Video.isStreamingModeEnabled() ? true : !this.dM.containsKey(ad) ? false : new File((String) this.dM.get(ad)).exists();
    }

    protected AppnextAd a(Context context, Ad ad, String str) {
        if (j(ad) == null) {
            return null;
        }
        ArrayList cQ = j(ad).cQ();
        return cQ != null ? a(context, ad, cQ, str) : null;
    }

    protected AppnextAd a(Context context, Ad ad, ArrayList<AppnextAd> arrayList, String str) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            AppnextAd appnextAd = (AppnextAd) it.next();
            if (b(appnextAd) && !c(appnextAd.getBannerID(), ad.getPlacementID()) && !appnextAd.getBannerID().equals(str)) {
                return appnextAd;
            }
        }
        return null;
    }

    protected String a(Context context, Ad ad, String str, ArrayList<Pair<String, String>> arrayList) {
        g.a(ad != null ? ad.getTID() : "301", ad != null ? ad.getVID() : "2.3.0.469", ad != null ? ad.getAUID() : "700", str, ad != null ? ((Video) ad).getSessionId() : "", a.cq, "sdk", "", "");
        return "https://global.appnext.com" + "/offerWallApi.aspx?ext=t&pimp=1&igroup=sdk&m=1&osid=100&auid=" + (ad != null ? ad.getAUID() : "700") + "&type=json&id=" + str + "&cnt=" + 30 + "&tid=" + (ad != null ? ad.getTID() : "301") + "&vid=" + (ad != null ? ad.getVID() : "2.3.0.469") + "&cat=" + (ad != null ? ad.getCategories() : "") + "&pbk=" + (ad != null ? ad.getPostback() : "") + "&vidmin=" + (ad == null ? "" : Integer.valueOf(ad.getMinVideoLength())) + "&vidmax=" + (ad == null ? "" : Integer.valueOf(ad.getMaxVideoLength())) + "&did=" + g.c(context, false) + "&devn=" + g.da() + "&dosv=" + VERSION.SDK_INT + "&dct=" + g.aO(g.x(context)) + "&lang=" + g.cB() + "&dcc=" + g.y(context) + "&dds=" + ((int) g.dc()) + "&packageId=" + context.getPackageName() + "&rnd=" + new Random().nextInt();
    }

    protected void a(Context context, Ad ad, com.appnext.core.a aVar) {
        a(context, ad);
        AppnextAd appnextAd = null;
        try {
            appnextAd = b(context, ad);
            if (appnextAd == null) {
                throw new Exception("No video ads");
            }
            a(context, ad, appnextAd);
            if (ad instanceof RewardedVideo) {
                String mode = ((RewardedVideo) ad).getMode();
                if (mode.equals(RewardedVideo.VIDEO_MODE_DEFAULT)) {
                    mode = f.al().get("default_mode");
                }
                if (mode.equals("multi")) {
                    appnextAd = a(context, ad, appnextAd.getBannerID());
                    if (appnextAd != null) {
                        a(context, ad, appnextAd);
                    }
                }
            }
        } catch (Throwable th) {
            if (appnextAd != null) {
                a(appnextAd.getBannerID(), ad);
            }
        }
    }

    protected void a(Ad ad, String str, String str2) {
        if (ad != null) {
            g.a(ad.getTID(), ad.getVID(), ad.getAUID(), str2, str, a.cp, "sdk", "", "");
        } else {
            g.a("300", "2.3.0.469", "700", str2, str, a.cp, "sdk", "", "");
        }
        g.X("error " + str);
    }

    protected void a(String str, Ad ad) {
        super.a(str, ad);
        if (this.dM.containsKey(ad)) {
            this.dM.remove(ad);
        }
    }

    protected <T> void a(String str, Ad ad, T t) {
        g.a(ad.getTID(), ad.getVID(), ad.getAUID(), str, ((Video) ad).getSessionId(), a.co, "sdk", "", "");
    }

    protected boolean a(Context context, Ad ad, ArrayList<?> arrayList) {
        return a(context, ad, (ArrayList) arrayList, "") != null;
    }

    protected boolean a(Context context, i iVar) {
        return a(context, (AppnextAd) iVar) && b(context, (AppnextAd) iVar);
    }

    protected boolean a(Ad ad) {
        return super.a(ad) && h(ad);
    }

    protected AppnextAd b(Context context, Ad ad) {
        return a(context, ad, "");
    }

    protected r d(Ad ad) {
        return ad instanceof RewardedVideo ? f.al() : c.aj();
    }

    protected boolean e(Ad ad) {
        try {
            return a(ad) && h(ad);
        } catch (Throwable th) {
            g.c(th);
            return false;
        }
    }

    protected ArrayList<AppnextAd> f(Ad ad) {
        return j(ad).cQ();
    }

    protected boolean g(Ad ad) {
        try {
            return b(ad) && (j(ad).cP().longValue() + i(ad)) + 300000 >= System.currentTimeMillis() && h(ad);
        } catch (Throwable th) {
            g.c(th);
            return false;
        }
    }
}
