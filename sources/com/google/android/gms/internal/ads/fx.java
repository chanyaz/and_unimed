package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.view.View;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.a.c;
import com.google.android.gms.common.g;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@zzadh
@ParametersAreNonnullByDefault
public final class fx implements zzait {
    private static List<Future<Void>> a = Collections.synchronizedList(new ArrayList());
    private static ScheduledExecutorService b = Executors.newSingleThreadScheduledExecutor();
    @GuardedBy("mLock")
    private final abn c;
    @GuardedBy("mLock")
    private final LinkedHashMap<String, abv> d;
    @GuardedBy("mLock")
    private final List<String> e = new ArrayList();
    @GuardedBy("mLock")
    private final List<String> f = new ArrayList();
    private final Context g;
    private final zzaiv h;
    @VisibleForTesting
    private boolean i;
    private final zzaiq j;
    private final gh k;
    private final Object l = new Object();
    private HashSet<String> m = new HashSet();
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;

    public fx(Context context, zzang zzang, zzaiq zzaiq, String str, zzaiv zzaiv) {
        ar.a((Object) zzaiq, (Object) "SafeBrowsing config is not present.");
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.g = context;
        this.d = new LinkedHashMap();
        this.h = zzaiv;
        this.j = zzaiq;
        for (String toLowerCase : this.j.e) {
            this.m.add(toLowerCase.toLowerCase(Locale.ENGLISH));
        }
        this.m.remove("cookie".toLowerCase(Locale.ENGLISH));
        abn abn = new abn();
        abn.a = Integer.valueOf(8);
        abn.b = str;
        abn.c = str;
        abn.d = new abo();
        abn.d.a = this.j.a;
        abw abw = new abw();
        abw.a = zzang.a;
        abw.c = Boolean.valueOf(c.b(this.g).a());
        long b = (long) g.b().b(this.g);
        if (b > 0) {
            abw.b = Long.valueOf(b);
        }
        abn.h = abw;
        this.c = abn;
        this.k = new gh(this.g, this.j.h, this);
    }

    @VisibleForTesting
    private final zzanz<Void> b() {
        Object obj = 1;
        if (!(this.i && this.j.g) && (!(this.p && this.j.f) && (this.i || !this.j.d))) {
            obj = null;
        }
        if (obj == null) {
            return kq.a(null);
        }
        zzanz a;
        synchronized (this.l) {
            this.c.e = new abv[this.d.size()];
            this.d.values().toArray(this.c.e);
            this.c.i = (String[]) this.e.toArray(new String[0]);
            this.c.j = (String[]) this.f.toArray(new String[0]);
            if (gg.a()) {
                String str = this.c.b;
                String str2 = this.c.f;
                StringBuilder stringBuilder = new StringBuilder(new StringBuilder((String.valueOf(str).length() + 53) + String.valueOf(str2).length()).append("Sending SB report\n  url: ").append(str).append("\n  clickUrl: ").append(str2).append("\n  resources: \n").toString());
                for (abv abv : this.c.e) {
                    stringBuilder.append("    [");
                    stringBuilder.append(abv.e.length);
                    stringBuilder.append("] ");
                    stringBuilder.append(abv.b);
                }
                gg.a(stringBuilder.toString());
            }
            a = new jb(this.g).a(1, this.j.b, null, abj.a(this.c));
            if (gg.a()) {
                a.zza(new gc(this), hr.a);
            }
        }
        return kq.a(a, fz.a, lf.b);
    }

    @Nullable
    private final abv d(String str) {
        abv abv;
        synchronized (this.l) {
            abv = (abv) this.d.get(str);
        }
        return abv;
    }

    final void a(String str) {
        synchronized (this.l) {
            this.e.add(str);
        }
    }

    final void b(String str) {
        synchronized (this.l) {
            this.f.add(str);
        }
    }

    /* JADX WARNING: Missing block: B:46:?, code:
            return;
     */
    public final void zza(java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10, int r11) {
        /*
        r8 = this;
        r1 = 3;
        r2 = r8.l;
        monitor-enter(r2);
        if (r11 != r1) goto L_0x0009;
    L_0x0006:
        r0 = 1;
        r8.p = r0;	 Catch:{ all -> 0x00ac }
    L_0x0009:
        r0 = r8.d;	 Catch:{ all -> 0x00ac }
        r0 = r0.containsKey(r9);	 Catch:{ all -> 0x00ac }
        if (r0 == 0) goto L_0x0023;
    L_0x0011:
        if (r11 != r1) goto L_0x0021;
    L_0x0013:
        r0 = r8.d;	 Catch:{ all -> 0x00ac }
        r0 = r0.get(r9);	 Catch:{ all -> 0x00ac }
        r0 = (com.google.android.gms.internal.ads.abv) r0;	 Catch:{ all -> 0x00ac }
        r1 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x00ac }
        r0.d = r1;	 Catch:{ all -> 0x00ac }
    L_0x0021:
        monitor-exit(r2);	 Catch:{ all -> 0x00ac }
    L_0x0022:
        return;
    L_0x0023:
        r3 = new com.google.android.gms.internal.ads.abv;	 Catch:{ all -> 0x00ac }
        r3.<init>();	 Catch:{ all -> 0x00ac }
        r0 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x00ac }
        r3.d = r0;	 Catch:{ all -> 0x00ac }
        r0 = r8.d;	 Catch:{ all -> 0x00ac }
        r0 = r0.size();	 Catch:{ all -> 0x00ac }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x00ac }
        r3.a = r0;	 Catch:{ all -> 0x00ac }
        r3.b = r9;	 Catch:{ all -> 0x00ac }
        r0 = new com.google.android.gms.internal.ads.abq;	 Catch:{ all -> 0x00ac }
        r0.<init>();	 Catch:{ all -> 0x00ac }
        r3.c = r0;	 Catch:{ all -> 0x00ac }
        r0 = r8.m;	 Catch:{ all -> 0x00ac }
        r0 = r0.size();	 Catch:{ all -> 0x00ac }
        if (r0 <= 0) goto L_0x00c2;
    L_0x004b:
        if (r10 == 0) goto L_0x00c2;
    L_0x004d:
        r4 = new java.util.ArrayList;	 Catch:{ all -> 0x00ac }
        r4.<init>();	 Catch:{ all -> 0x00ac }
        r0 = r10.entrySet();	 Catch:{ all -> 0x00ac }
        r5 = r0.iterator();	 Catch:{ all -> 0x00ac }
    L_0x005a:
        r0 = r5.hasNext();	 Catch:{ all -> 0x00ac }
        if (r0 == 0) goto L_0x00b5;
    L_0x0060:
        r0 = r5.next();	 Catch:{ all -> 0x00ac }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x00ac }
        r1 = r0.getKey();	 Catch:{ UnsupportedEncodingException -> 0x00a5 }
        if (r1 == 0) goto L_0x00af;
    L_0x006c:
        r1 = r0.getKey();	 Catch:{ UnsupportedEncodingException -> 0x00a5 }
        r1 = (java.lang.String) r1;	 Catch:{ UnsupportedEncodingException -> 0x00a5 }
    L_0x0072:
        r6 = r0.getValue();	 Catch:{ UnsupportedEncodingException -> 0x00a5 }
        if (r6 == 0) goto L_0x00b2;
    L_0x0078:
        r0 = r0.getValue();	 Catch:{ UnsupportedEncodingException -> 0x00a5 }
        r0 = (java.lang.String) r0;	 Catch:{ UnsupportedEncodingException -> 0x00a5 }
    L_0x007e:
        r6 = java.util.Locale.ENGLISH;	 Catch:{ UnsupportedEncodingException -> 0x00a5 }
        r6 = r1.toLowerCase(r6);	 Catch:{ UnsupportedEncodingException -> 0x00a5 }
        r7 = r8.m;	 Catch:{ UnsupportedEncodingException -> 0x00a5 }
        r6 = r7.contains(r6);	 Catch:{ UnsupportedEncodingException -> 0x00a5 }
        if (r6 == 0) goto L_0x005a;
    L_0x008c:
        r6 = new com.google.android.gms.internal.ads.abp;	 Catch:{ UnsupportedEncodingException -> 0x00a5 }
        r6.<init>();	 Catch:{ UnsupportedEncodingException -> 0x00a5 }
        r7 = "UTF-8";
        r1 = r1.getBytes(r7);	 Catch:{ UnsupportedEncodingException -> 0x00a5 }
        r6.a = r1;	 Catch:{ UnsupportedEncodingException -> 0x00a5 }
        r1 = "UTF-8";
        r0 = r0.getBytes(r1);	 Catch:{ UnsupportedEncodingException -> 0x00a5 }
        r6.b = r0;	 Catch:{ UnsupportedEncodingException -> 0x00a5 }
        r4.add(r6);	 Catch:{ UnsupportedEncodingException -> 0x00a5 }
        goto L_0x005a;
    L_0x00a5:
        r0 = move-exception;
        r0 = "Cannot convert string to bytes, skip header.";
        com.google.android.gms.internal.ads.gg.a(r0);	 Catch:{ all -> 0x00ac }
        goto L_0x005a;
    L_0x00ac:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x00ac }
        throw r0;
    L_0x00af:
        r1 = "";
        goto L_0x0072;
    L_0x00b2:
        r0 = "";
        goto L_0x007e;
    L_0x00b5:
        r0 = r4.size();	 Catch:{ all -> 0x00ac }
        r0 = new com.google.android.gms.internal.ads.abp[r0];	 Catch:{ all -> 0x00ac }
        r4.toArray(r0);	 Catch:{ all -> 0x00ac }
        r1 = r3.c;	 Catch:{ all -> 0x00ac }
        r1.a = r0;	 Catch:{ all -> 0x00ac }
    L_0x00c2:
        r0 = r8.d;	 Catch:{ all -> 0x00ac }
        r0.put(r9, r3);	 Catch:{ all -> 0x00ac }
        monitor-exit(r2);	 Catch:{ all -> 0x00ac }
        goto L_0x0022;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.fx.zza(java.lang.String, java.util.Map, int):void");
    }

    public final String[] zzb(String[] strArr) {
        return (String[]) this.k.a(strArr).toArray(new String[0]);
    }

    public final void zzcf(String str) {
        synchronized (this.l) {
            this.c.f = str;
        }
    }

    public final zzaiq zzpg() {
        return this.j;
    }

    public final boolean zzph() {
        return p.g() && this.j.c && !this.o;
    }

    public final void zzpi() {
        this.n = true;
    }

    public final void zzpj() {
        synchronized (this.l) {
            zzanz a = kq.a(this.h.zza(this.g, this.d.keySet()), new fy(this), lf.b);
            zzanz a2 = kq.a(a, 10, TimeUnit.SECONDS, b);
            kq.a(a, new gb(this, a2), lf.b);
            a.add(a2);
        }
    }

    public final void zzr(View view) {
        if (this.j.c && !this.o) {
            au.e();
            Bitmap b = ht.b(view);
            if (b == null) {
                gg.a("Failed to capture the webview bitmap.");
                return;
            }
            this.o = true;
            ht.a(new ga(this, b));
        }
    }
}
