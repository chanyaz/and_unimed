package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.Nullable;
import android.util.Base64;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class aru {
    private final Map<arv, arw> a = new HashMap();
    private final LinkedList<arv> b = new LinkedList();
    @Nullable
    private aqr c;

    static Set<String> a(zzjj zzjj) {
        Set<String> hashSet = new HashSet();
        hashSet.addAll(zzjj.c.keySet());
        Bundle bundle = zzjj.m.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle != null) {
            hashSet.addAll(bundle.keySet());
        }
        return hashSet;
    }

    private static void a(Bundle bundle, String str) {
        while (true) {
            String[] split = str.split("/", 2);
            if (split.length != 0) {
                String str2 = split[0];
                if (split.length == 1) {
                    bundle.remove(str2);
                    return;
                }
                bundle = bundle.getBundle(str2);
                if (bundle != null) {
                    str = split[1];
                } else {
                    return;
                }
            }
            return;
        }
    }

    private static void a(String str, arv arv) {
        if (kk.a(2)) {
            hl.a(String.format(str, new Object[]{arv}));
        }
    }

    private static String[] a(String str) {
        try {
            String[] split = str.split("\u0000");
            for (int i = 0; i < split.length; i++) {
                split[i] = new String(Base64.decode(split[i], 0), "UTF-8");
            }
            return split;
        } catch (UnsupportedEncodingException e) {
            return new String[0];
        }
    }

    static zzjj b(zzjj zzjj) {
        zzjj d = d(zzjj);
        String str = "_skipMediation";
        Bundle bundle = d.m.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle != null) {
            bundle.putBoolean(str, true);
        }
        d.c.putBoolean(str, true);
        return d;
    }

    private final String b() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                stringBuilder.append(Base64.encodeToString(((arv) it.next()).toString().getBytes("UTF-8"), 0));
                if (it.hasNext()) {
                    stringBuilder.append("\u0000");
                }
            }
            return stringBuilder.toString();
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    private static boolean b(String str) {
        try {
            return Pattern.matches((String) akc.f().a(amn.ba), str);
        } catch (Throwable e) {
            au.i().a(e, "InterstitialAdPool.isExcludedAdUnit");
            return false;
        }
    }

    @VisibleForTesting
    private static zzjj c(zzjj zzjj) {
        zzjj d = d(zzjj);
        for (String str : ((String) akc.f().a(amn.aW)).split(",")) {
            a(d.m, str);
            String str2 = "com.google.ads.mediation.admob.AdMobAdapter/";
            if (str.startsWith(str2)) {
                a(d.c, str.replaceFirst(str2, ""));
            }
        }
        return d;
    }

    @VisibleForTesting
    private static String c(String str) {
        try {
            Matcher matcher = Pattern.compile("([^/]+/[0-9]+).*").matcher(str);
            return matcher.matches() ? matcher.group(1) : str;
        } catch (RuntimeException e) {
            return str;
        }
    }

    @VisibleForTesting
    private static zzjj d(zzjj zzjj) {
        Parcel obtain = Parcel.obtain();
        zzjj.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        zzjj zzjj2 = (zzjj) zzjj.CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return ((Boolean) akc.f().a(amn.aN)).booleanValue() ? zzjj2.a() : zzjj2;
    }

    @Nullable
    final arx a(zzjj zzjj, String str) {
        if (b(str)) {
            return null;
        }
        arw arw;
        int i = new ed(this.c.a()).a().n;
        zzjj c = c(zzjj);
        String c2 = c(str);
        arv arv = new arv(c, c2, i);
        arw arw2 = (arw) this.a.get(arv);
        if (arw2 == null) {
            a("Interstitial pool created at %s.", arv);
            arw2 = new arw(c, c2, i);
            this.a.put(arv, arw2);
            arw = arw2;
        } else {
            arw = arw2;
        }
        this.b.remove(arv);
        this.b.add(arv);
        arw.g();
        while (true) {
            if (this.b.size() <= ((Integer) akc.f().a(amn.aX)).intValue()) {
                break;
            }
            arv arv2 = (arv) this.b.remove();
            arw arw3 = (arw) this.a.get(arv2);
            a("Evicting interstitial queue for %s.", arv2);
            while (arw3.d() > 0) {
                arx a = arw3.a(null);
                if (a.e) {
                    ary.a().c();
                }
                a.a.k();
            }
            this.a.remove(arv2);
        }
        while (arw.d() > 0) {
            arx a2 = arw.a(c);
            if (a2.e) {
                if (au.l().currentTimeMillis() - a2.d > 1000 * ((long) ((Integer) akc.f().a(amn.aZ)).intValue())) {
                    a("Expired interstitial at %s.", arv);
                    ary.a().b();
                }
            }
            String str2 = a2.b != null ? " (inline) " : " ";
            a(new StringBuilder(String.valueOf(str2).length() + 34).append("Pooled interstitial").append(str2).append("returned at %s.").toString(), arv);
            return a2;
        }
        return null;
    }

    /* JADX WARNING: Missing block: B:7:0x002f, code:
            r2 = r0.d();
     */
    final void a() {
        /*
        r9 = this;
        r8 = 2;
        r7 = 0;
        r0 = r9.c;
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = r9.a;
        r0 = r0.entrySet();
        r4 = r0.iterator();
    L_0x0011:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x008c;
    L_0x0017:
        r0 = r4.next();
        r0 = (java.util.Map.Entry) r0;
        r1 = r0.getKey();
        r1 = (com.google.android.gms.internal.ads.arv) r1;
        r0 = r0.getValue();
        r0 = (com.google.android.gms.internal.ads.arw) r0;
        r2 = com.google.android.gms.internal.ads.kk.a(r8);
        if (r2 == 0) goto L_0x0056;
    L_0x002f:
        r2 = r0.d();
        r3 = r0.e();
        if (r3 >= r2) goto L_0x0056;
    L_0x0039:
        r5 = "Loading %s/%s pooled interstitials for %s.";
        r6 = 3;
        r6 = new java.lang.Object[r6];
        r3 = r2 - r3;
        r3 = java.lang.Integer.valueOf(r3);
        r6[r7] = r3;
        r3 = 1;
        r2 = java.lang.Integer.valueOf(r2);
        r6[r3] = r2;
        r6[r8] = r1;
        r2 = java.lang.String.format(r5, r6);
        com.google.android.gms.internal.ads.hl.a(r2);
    L_0x0056:
        r2 = r0.f();
        r2 = r2 + 0;
        r3 = r2;
    L_0x005d:
        r5 = r0.d();
        r2 = com.google.android.gms.internal.ads.amn.aY;
        r6 = com.google.android.gms.internal.ads.akc.f();
        r2 = r6.a(r2);
        r2 = (java.lang.Integer) r2;
        r2 = r2.intValue();
        if (r5 >= r2) goto L_0x0084;
    L_0x0073:
        r2 = "Pooling and loading one new interstitial for %s.";
        a(r2, r1);
        r2 = r9.c;
        r2 = r0.a(r2);
        if (r2 == 0) goto L_0x005d;
    L_0x0080:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x005d;
    L_0x0084:
        r0 = com.google.android.gms.internal.ads.ary.a();
        r0.a(r3);
        goto L_0x0011;
    L_0x008c:
        r0 = r9.c;
        if (r0 == 0) goto L_0x0006;
    L_0x0090:
        r0 = r9.c;
        r0 = r0.a();
        r1 = "com.google.android.gms.ads.internal.interstitial.InterstitialAdPool";
        r0 = r0.getSharedPreferences(r1, r7);
        r2 = r0.edit();
        r2.clear();
        r0 = r9.a;
        r0 = r0.entrySet();
        r3 = r0.iterator();
    L_0x00ad:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x00e1;
    L_0x00b3:
        r0 = r3.next();
        r0 = (java.util.Map.Entry) r0;
        r1 = r0.getKey();
        r1 = (com.google.android.gms.internal.ads.arv) r1;
        r0 = r0.getValue();
        r0 = (com.google.android.gms.internal.ads.arw) r0;
        r4 = r0.h();
        if (r4 == 0) goto L_0x00ad;
    L_0x00cb:
        r4 = new com.google.android.gms.internal.ads.asa;
        r4.<init>(r0);
        r0 = r4.a();
        r4 = r1.toString();
        r2.putString(r4, r0);
        r0 = "Saved interstitial queue for %s.";
        a(r0, r1);
        goto L_0x00ad;
    L_0x00e1:
        r0 = "PoolKeys";
        r1 = r9.b();
        r2.putString(r0, r1);
        r2.apply();
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aru.a():void");
    }

    final void a(aqr aqr) {
        Throwable e;
        if (this.c == null) {
            this.c = aqr.b();
            if (this.c != null) {
                arv arv;
                SharedPreferences sharedPreferences = this.c.a().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0);
                while (this.b.size() > 0) {
                    arv = (arv) this.b.remove();
                    arw arw = (arw) this.a.get(arv);
                    a("Flushing interstitial queue for %s.", arv);
                    while (arw.d() > 0) {
                        arw.a(null).a.k();
                    }
                    this.a.remove(arv);
                }
                try {
                    Map hashMap = new HashMap();
                    for (Entry entry : sharedPreferences.getAll().entrySet()) {
                        if (!((String) entry.getKey()).equals("PoolKeys")) {
                            asa a = asa.a((String) entry.getValue());
                            arv arv2 = new arv(a.a, a.b, a.c);
                            if (!this.a.containsKey(arv2)) {
                                this.a.put(arv2, new arw(a.a, a.b, a.c));
                                hashMap.put(arv2.toString(), arv2);
                                a("Restored interstitial queue for %s.", arv2);
                            }
                        }
                    }
                    for (Object obj : a(sharedPreferences.getString("PoolKeys", ""))) {
                        arv = (arv) hashMap.get(obj);
                        if (this.a.containsKey(arv)) {
                            this.b.add(arv);
                        }
                    }
                } catch (RuntimeException e2) {
                    e = e2;
                    au.i().a(e, "InterstitialAdPool.restore");
                    kk.c("Malformed preferences value for InterstitialAdPool.", e);
                    this.a.clear();
                    this.b.clear();
                } catch (IOException e3) {
                    e = e3;
                    au.i().a(e, "InterstitialAdPool.restore");
                    kk.c("Malformed preferences value for InterstitialAdPool.", e);
                    this.a.clear();
                    this.b.clear();
                }
            }
        }
    }

    final void b(zzjj zzjj, String str) {
        if (this.c != null) {
            int i = new ed(this.c.a()).a().n;
            zzjj c = c(zzjj);
            String c2 = c(str);
            arv arv = new arv(c, c2, i);
            arw arw = (arw) this.a.get(arv);
            if (arw == null) {
                a("Interstitial pool created at %s.", arv);
                arw = new arw(c, c2, i);
                this.a.put(arv, arw);
            }
            arw.a(this.c, zzjj);
            arw.g();
            a("Inline entry added to the queue at %s.", arv);
        }
    }
}
