package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.af;
import com.google.android.gms.internal.measurement.ah;
import com.google.android.gms.internal.measurement.br;
import com.google.android.gms.internal.measurement.ci;
import com.google.android.gms.internal.measurement.cj;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

@VisibleForTesting
public class i extends af {
    private boolean a;
    private final Map<String, String> b = new HashMap();
    private final Map<String, String> c = new HashMap();
    private final br d;
    private final j e;
    private a f;
    private ci g;

    i(ah ahVar, String str, br brVar) {
        super(ahVar);
        if (str != null) {
            this.b.put("&tid", str);
        }
        this.b.put("useSecure", "1");
        this.b.put("&a", Integer.toString(new Random().nextInt(MoPubClientPositioning.NO_REPEAT) + 1));
        this.d = new br("tracking", i());
        this.e = new j(this, ahVar);
    }

    private static String a(Entry<String, String> entry) {
        String str = (String) entry.getKey();
        int i = (!str.startsWith("&") || str.length() < 2) ? 0 : 1;
        return i == 0 ? null : ((String) entry.getKey()).substring(1);
    }

    private static void a(Map<String, String> map, Map<String, String> map2) {
        ar.a((Object) map2);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                String a = a(entry);
                if (a != null) {
                    map2.put(a, (String) entry.getValue());
                }
            }
        }
    }

    protected final void a() {
        this.e.z();
        String c = q().c();
        if (c != null) {
            a("&an", c);
        }
        c = q().b();
        if (c != null) {
            a("&av", c);
        }
    }

    public void a(long j) {
        this.e.a(1000 * j);
    }

    public void a(Uri uri) {
        if (uri != null && !uri.isOpaque()) {
            CharSequence queryParameter = uri.getQueryParameter("referrer");
            if (!TextUtils.isEmpty(queryParameter)) {
                String str = "http://hostname/?";
                String valueOf = String.valueOf(queryParameter);
                Uri parse = Uri.parse(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                str = parse.getQueryParameter("utm_id");
                if (str != null) {
                    this.c.put("&ci", str);
                }
                str = parse.getQueryParameter("anid");
                if (str != null) {
                    this.c.put("&anid", str);
                }
                str = parse.getQueryParameter("utm_campaign");
                if (str != null) {
                    this.c.put("&cn", str);
                }
                str = parse.getQueryParameter("utm_content");
                if (str != null) {
                    this.c.put("&cc", str);
                }
                str = parse.getQueryParameter("utm_medium");
                if (str != null) {
                    this.c.put("&cm", str);
                }
                str = parse.getQueryParameter("utm_source");
                if (str != null) {
                    this.c.put("&cs", str);
                }
                str = parse.getQueryParameter("utm_term");
                if (str != null) {
                    this.c.put("&ck", str);
                }
                str = parse.getQueryParameter("dclid");
                if (str != null) {
                    this.c.put("&dclid", str);
                }
                str = parse.getQueryParameter("gclid");
                if (str != null) {
                    this.c.put("&gclid", str);
                }
                valueOf = parse.getQueryParameter("aclid");
                if (valueOf != null) {
                    this.c.put("&aclid", valueOf);
                }
            }
        }
    }

    final void a(ci ciVar) {
        String str;
        boolean z;
        boolean z2 = true;
        b("Loading Tracker config values");
        this.g = ciVar;
        if (this.g.a != null) {
            str = this.g.a;
            a("&tid", str);
            a("trackingId loaded", str);
        }
        if (this.g.b >= 0.0d) {
            str = Double.toString(this.g.b);
            a("&sf", str);
            a("Sample frequency loaded", str);
        }
        if (this.g.c >= 0) {
            int i = this.g.c;
            a((long) i);
            a("Session timeout loaded", Integer.valueOf(i));
        }
        if (this.g.d != -1) {
            z = this.g.d == 1;
            b(z);
            a("Auto activity tracking loaded", Boolean.valueOf(z));
        }
        if (this.g.e != -1) {
            z = this.g.e == 1;
            if (z) {
                a("&aip", "1");
            }
            a("Anonymize ip loaded", Boolean.valueOf(z));
        }
        if (this.g.f != 1) {
            z2 = false;
        }
        a(z2);
    }

    public void a(String str) {
        a("&cd", str);
    }

    public void a(String str, String str2) {
        ar.a((Object) str, (Object) "Key should be non-null");
        if (!TextUtils.isEmpty(str)) {
            this.b.put(str, str2);
        }
    }

    public void a(Map<String, String> map) {
        long currentTimeMillis = i().currentTimeMillis();
        if (n().e()) {
            c("AppOptOut is set to true. Not sending Google Analytics hit");
            return;
        }
        boolean d = n().d();
        Map hashMap = new HashMap();
        a(this.b, hashMap);
        a((Map) map, hashMap);
        boolean a = cj.a((String) this.b.get("useSecure"), true);
        Map map2 = this.c;
        ar.a((Object) hashMap);
        if (map2 != null) {
            for (Entry entry : map2.entrySet()) {
                String a2 = a(entry);
                if (!(a2 == null || hashMap.containsKey(a2))) {
                    hashMap.put(a2, (String) entry.getValue());
                }
            }
        }
        this.c.clear();
        String str = (String) hashMap.get("t");
        if (TextUtils.isEmpty(str)) {
            h().a(hashMap, "Missing hit type parameter");
            return;
        }
        String str2 = (String) hashMap.get("tid");
        if (TextUtils.isEmpty(str2)) {
            h().a(hashMap, "Missing tracking id parameter");
            return;
        }
        boolean z = this.a;
        synchronized (this) {
            if ("screenview".equalsIgnoreCase(str) || "pageview".equalsIgnoreCase(str) || "appview".equalsIgnoreCase(str) || TextUtils.isEmpty(str)) {
                int parseInt = Integer.parseInt((String) this.b.get("&a")) + 1;
                if (parseInt >= MoPubClientPositioning.NO_REPEAT) {
                    parseInt = 1;
                }
                this.b.put("&a", Integer.toString(parseInt));
            }
        }
        m().a(new z(this, hashMap, z, str, currentTimeMillis, d, a, str2));
    }

    /* JADX WARNING: Missing block: B:17:?, code:
            return;
     */
    public void a(boolean r4) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.f;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x000a;
    L_0x0005:
        r0 = 1;
    L_0x0006:
        if (r0 != r4) goto L_0x000c;
    L_0x0008:
        monitor-exit(r3);	 Catch:{ all -> 0x0029 }
    L_0x0009:
        return;
    L_0x000a:
        r0 = 0;
        goto L_0x0006;
    L_0x000c:
        if (r4 == 0) goto L_0x002c;
    L_0x000e:
        r0 = r3.j();	 Catch:{ all -> 0x0029 }
        r1 = java.lang.Thread.getDefaultUncaughtExceptionHandler();	 Catch:{ all -> 0x0029 }
        r2 = new com.google.android.gms.analytics.a;	 Catch:{ all -> 0x0029 }
        r2.<init>(r3, r1, r0);	 Catch:{ all -> 0x0029 }
        r3.f = r2;	 Catch:{ all -> 0x0029 }
        r0 = r3.f;	 Catch:{ all -> 0x0029 }
        java.lang.Thread.setDefaultUncaughtExceptionHandler(r0);	 Catch:{ all -> 0x0029 }
        r0 = "Uncaught exceptions will be reported to Google Analytics";
        r3.b(r0);	 Catch:{ all -> 0x0029 }
    L_0x0027:
        monitor-exit(r3);	 Catch:{ all -> 0x0029 }
        goto L_0x0009;
    L_0x0029:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0029 }
        throw r0;
    L_0x002c:
        r0 = r3.f;	 Catch:{ all -> 0x0029 }
        r0 = r0.a();	 Catch:{ all -> 0x0029 }
        java.lang.Thread.setDefaultUncaughtExceptionHandler(r0);	 Catch:{ all -> 0x0029 }
        r0 = "Uncaught exceptions will not be reported to Google Analytics";
        r3.b(r0);	 Catch:{ all -> 0x0029 }
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.i.a(boolean):void");
    }

    public void b(boolean z) {
        this.e.a(z);
    }
}
