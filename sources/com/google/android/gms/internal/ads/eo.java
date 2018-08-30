package com.google.android.gms.internal.ads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.ads.internal.av;
import com.google.android.gms.ads.internal.gmsg.zzb;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.dynamic.c;
import java.util.HashMap;
import java.util.Map;

@zzadh
public final class eo {
    private static final auv a = new auv();
    private final zzxn b;
    private final av c;
    private final Map<String, fs> d = new HashMap();
    private final zzahu e;
    private final zzb f;
    private final zzabm g;

    public eo(av avVar, zzxn zzxn, zzahu zzahu, zzb zzb, zzabm zzabm) {
        this.c = avVar;
        this.b = zzxn;
        this.e = zzahu;
        this.f = zzb;
        this.g = zzabm;
    }

    public static boolean a(gr grVar, gr grVar2) {
        return true;
    }

    public final zzb a() {
        return this.f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    @android.support.annotation.Nullable
    public final com.google.android.gms.internal.ads.fs a(java.lang.String r6) {
        /*
        r5 = this;
        r0 = r5.d;
        r0 = r0.get(r6);
        r0 = (com.google.android.gms.internal.ads.fs) r0;
        if (r0 != 0) goto L_0x0028;
    L_0x000a:
        r1 = r5.b;	 Catch:{ Exception -> 0x0029 }
        r2 = "com.google.ads.mediation.admob.AdMobAdapter";
        r2 = r2.equals(r6);	 Catch:{ Exception -> 0x0029 }
        if (r2 == 0) goto L_0x004a;
    L_0x0014:
        r1 = a;	 Catch:{ Exception -> 0x0029 }
        r2 = r1;
    L_0x0017:
        r1 = new com.google.android.gms.internal.ads.fs;	 Catch:{ Exception -> 0x0029 }
        r2 = r2.zzbm(r6);	 Catch:{ Exception -> 0x0029 }
        r3 = r5.e;	 Catch:{ Exception -> 0x0029 }
        r1.<init>(r2, r3);	 Catch:{ Exception -> 0x0029 }
        r0 = r5.d;	 Catch:{ Exception -> 0x0047 }
        r0.put(r6, r1);	 Catch:{ Exception -> 0x0047 }
        r0 = r1;
    L_0x0028:
        return r0;
    L_0x0029:
        r1 = move-exception;
        r2 = r1;
        r1 = r0;
    L_0x002c:
        r3 = "Fail to instantiate adapter ";
        r0 = java.lang.String.valueOf(r6);
        r4 = r0.length();
        if (r4 == 0) goto L_0x0041;
    L_0x0038:
        r0 = r3.concat(r0);
    L_0x003c:
        com.google.android.gms.internal.ads.kk.c(r0, r2);
        r0 = r1;
        goto L_0x0028;
    L_0x0041:
        r0 = new java.lang.String;
        r0.<init>(r3);
        goto L_0x003c;
    L_0x0047:
        r0 = move-exception;
        r2 = r0;
        goto L_0x002c;
    L_0x004a:
        r2 = r1;
        goto L_0x0017;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.eo.a(java.lang.String):com.google.android.gms.internal.ads.fs");
    }

    public final zzaig a(zzaig zzaig) {
        if (!(this.c.j == null || this.c.j.r == null || TextUtils.isEmpty(this.c.j.r.k))) {
            zzaig = new zzaig(this.c.j.r.k, this.c.j.r.l);
        }
        if (!(this.c.j == null || this.c.j.o == null)) {
            au.x();
            aup.a(this.c.c, this.c.e.a, this.c.j.o.m, this.c.E, zzaig);
        }
        return zzaig;
    }

    public final void a(@NonNull Context context) {
        for (fs a : this.d.values()) {
            try {
                a.a().zzi(c.a((Object) context));
            } catch (Throwable e) {
                kk.b("Unable to call Adapter.onContextChanged.", e);
            }
        }
    }

    public final void a(boolean z) {
        fs a = a(this.c.j.q);
        if (a != null && a.a() != null) {
            try {
                a.a().setImmersiveMode(z);
                a.a().showVideo();
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
            }
        }
    }

    public final zzabm b() {
        return this.g;
    }

    public final void c() {
        this.c.I = 0;
        av avVar = this.c;
        au.d();
        zzalc foVar = new fo(this.c.c, this.c.k, this);
        String str = "AdRenderer: ";
        String valueOf = String.valueOf(foVar.getClass().getName());
        kk.b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        foVar.zznt();
        avVar.h = foVar;
    }

    public final void d() {
        ar.b("pause must be called on the main UI thread.");
        for (String str : this.d.keySet()) {
            try {
                fs fsVar = (fs) this.d.get(str);
                if (!(fsVar == null || fsVar.a() == null)) {
                    fsVar.a().pause();
                }
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
            }
        }
    }

    public final void e() {
        ar.b("resume must be called on the main UI thread.");
        for (String str : this.d.keySet()) {
            try {
                fs fsVar = (fs) this.d.get(str);
                if (!(fsVar == null || fsVar.a() == null)) {
                    fsVar.a().resume();
                }
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
            }
        }
    }

    public final void f() {
        ar.b("destroy must be called on the main UI thread.");
        for (String str : this.d.keySet()) {
            try {
                fs fsVar = (fs) this.d.get(str);
                if (!(fsVar == null || fsVar.a() == null)) {
                    fsVar.a().destroy();
                }
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
            }
        }
    }

    public final void g() {
        if (this.c.j != null && this.c.j.o != null) {
            au.x();
            aup.a(this.c.c, this.c.e.a, this.c.j, this.c.b, false, this.c.j.o.l);
        }
    }

    public final void h() {
        if (this.c.j != null && this.c.j.o != null) {
            au.x();
            aup.a(this.c.c, this.c.e.a, this.c.j, this.c.b, false, this.c.j.o.n);
        }
    }
}
