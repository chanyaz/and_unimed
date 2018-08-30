package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.appnext.core.Ad;
import com.google.android.gms.ads.internal.au;
import com.mopub.mobileads.VastIconXmlManager;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@zzadh
public final class dz {
    private boolean A = false;
    private zzael B;
    private boolean C = false;
    private String D;
    private List<String> E;
    private boolean F;
    private String G;
    private zzaiq H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private String M;
    private final zzaef N;
    private String a;
    private String b;
    private String c;
    private List<String> d;
    private String e;
    private String f;
    private String g;
    private List<String> h;
    private List<String> i;
    private long j = -1;
    private boolean k = false;
    private final long l = -1;
    private List<String> m;
    private long n = -1;
    private int o = -1;
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;
    private boolean s = true;
    private boolean t = true;
    private String u = "";
    private boolean v = false;
    private boolean w = false;
    private zzaig x;
    private List<String> y;
    private List<String> z;

    public dz(zzaef zzaef, String str) {
        this.b = str;
        this.N = zzaef;
    }

    private static String a(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        return (list == null || list.isEmpty()) ? null : (String) list.get(0);
    }

    private static long b(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            try {
                return (long) (Float.parseFloat(str2) * 1000.0f);
            } catch (NumberFormatException e) {
                kk.e(new StringBuilder((String.valueOf(str).length() + 36) + String.valueOf(str2).length()).append("Could not parse float from ").append(str).append(" header: ").append(str2).toString());
            }
        }
        return -1;
    }

    private static List<String> c(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            if (str2 != null) {
                return Arrays.asList(str2.trim().split("\\s+"));
            }
        }
        return null;
    }

    private static boolean d(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        return (list == null || list.isEmpty()) ? false : Boolean.valueOf((String) list.get(0)).booleanValue();
    }

    public final zzaej a(long j, boolean z) {
        return new zzaej(this.N, this.b, this.c, this.d, this.h, this.j, this.k, -1, this.m, this.n, this.o, this.a, j, this.f, this.g, this.p, this.q, this.r, this.s, false, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.C, this.D, this.E, this.F, this.G, this.H, this.e, this.t, this.I, this.J, z ? 2 : 1, this.K, this.i, this.L, this.M);
    }

    public final void a(String str, Map<String, List<String>> map, String str2) {
        this.c = str2;
        a(map);
    }

    public final void a(Map<String, List<String>> map) {
        String str;
        this.a = a((Map) map, "X-Afma-Ad-Size");
        this.G = a((Map) map, "X-Afma-Ad-Slot-Size");
        List c = c(map, "X-Afma-Click-Tracking-Urls");
        if (c != null) {
            this.d = c;
        }
        this.e = a((Map) map, "X-Afma-Debug-Signals");
        c = (List) map.get("X-Afma-Debug-Dialog");
        if (!(c == null || c.isEmpty())) {
            this.f = (String) c.get(0);
        }
        c = c(map, "X-Afma-Tracking-Urls");
        if (c != null) {
            this.h = c;
        }
        c = c(map, "X-Afma-Downloaded-Impression-Urls");
        if (c != null) {
            this.i = c;
        }
        long b = b(map, "X-Afma-Interstitial-Timeout");
        if (b != -1) {
            this.j = b;
        }
        this.k |= d(map, "X-Afma-Mediation");
        c = c(map, "X-Afma-Manual-Tracking-Urls");
        if (c != null) {
            this.m = c;
        }
        b = b(map, "X-Afma-Refresh-Rate");
        if (b != -1) {
            this.n = b;
        }
        c = (List) map.get("X-Afma-Orientation");
        if (!(c == null || c.isEmpty())) {
            str = (String) c.get(0);
            if (Ad.ORIENTATION_PORTRAIT.equalsIgnoreCase(str)) {
                this.o = au.g().b();
            } else if (Ad.ORIENTATION_LANDSCAPE.equalsIgnoreCase(str)) {
                this.o = au.g().a();
            }
        }
        this.g = a((Map) map, "X-Afma-ActiveView");
        c = (List) map.get("X-Afma-Use-HTTPS");
        if (!(c == null || c.isEmpty())) {
            this.r = Boolean.valueOf((String) c.get(0)).booleanValue();
        }
        this.p |= d(map, "X-Afma-Custom-Rendering-Allowed");
        this.q = "native".equals(a((Map) map, "X-Afma-Ad-Format"));
        c = (List) map.get("X-Afma-Content-Url-Opted-Out");
        if (!(c == null || c.isEmpty())) {
            this.s = Boolean.valueOf((String) c.get(0)).booleanValue();
        }
        c = (List) map.get("X-Afma-Content-Vertical-Opted-Out");
        if (!(c == null || c.isEmpty())) {
            this.t = Boolean.valueOf((String) c.get(0)).booleanValue();
        }
        c = (List) map.get("X-Afma-Gws-Query-Id");
        if (!(c == null || c.isEmpty())) {
            this.u = (String) c.get(0);
        }
        str = a((Map) map, "X-Afma-Fluid");
        if (str != null && str.equals(VastIconXmlManager.HEIGHT)) {
            this.v = true;
        }
        this.w = "native_express".equals(a((Map) map, "X-Afma-Ad-Format"));
        this.x = zzaig.a(a((Map) map, "X-Afma-Rewards"));
        if (this.y == null) {
            this.y = c(map, "X-Afma-Reward-Video-Start-Urls");
        }
        if (this.z == null) {
            this.z = c(map, "X-Afma-Reward-Video-Complete-Urls");
        }
        this.A |= d(map, "X-Afma-Use-Displayed-Impression");
        this.C |= d(map, "X-Afma-Auto-Collect-Location");
        this.D = a((Map) map, "Set-Cookie");
        Object a = a((Map) map, "X-Afma-Auto-Protection-Configuration");
        if (a == null || TextUtils.isEmpty(a)) {
            Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204").buildUpon();
            buildUpon.appendQueryParameter("id", "gmob-apps-blocked-navigation");
            if (!TextUtils.isEmpty(this.f)) {
                buildUpon.appendQueryParameter("debugDialog", this.f);
            }
            boolean booleanValue = ((Boolean) akc.f().a(amn.g)).booleanValue();
            String[] strArr = new String[1];
            String builder = buildUpon.toString();
            strArr[0] = new StringBuilder(String.valueOf(builder).length() + 31).append(builder).append("&navigationURL={NAVIGATION_URL}").toString();
            this.B = new zzael(booleanValue, Arrays.asList(strArr));
        } else {
            try {
                this.B = zzael.a(new JSONObject(a));
            } catch (Throwable e) {
                kk.c("Error parsing configuration JSON", e);
                this.B = new zzael();
            }
        }
        c = c(map, "X-Afma-Remote-Ping-Urls");
        if (c != null) {
            this.E = c;
        }
        a = a((Map) map, "X-Afma-Safe-Browsing");
        if (!TextUtils.isEmpty(a)) {
            try {
                this.H = zzaiq.a(new JSONObject(a));
            } catch (Throwable e2) {
                kk.c("Error parsing safe browsing header", e2);
            }
        }
        this.F |= d(map, "X-Afma-Render-In-Browser");
        a = a((Map) map, "X-Afma-Pool");
        if (!TextUtils.isEmpty(a)) {
            try {
                this.I = new JSONObject(a).getBoolean("never_pool");
            } catch (Throwable e22) {
                kk.c("Error parsing interstitial pool header", e22);
            }
        }
        this.J = d(map, "X-Afma-Custom-Close-Blocked");
        this.K = d(map, "X-Afma-Enable-Omid");
        this.L = d(map, "X-Afma-Disable-Closable-Area");
        this.M = a((Map) map, "X-Afma-Omid-Settings");
    }
}
