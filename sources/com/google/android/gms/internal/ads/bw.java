package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzhu.zza.zzb;
import javax.annotation.concurrent.GuardedBy;

@zzadh
public final class bw extends hg implements zzadx {
    @GuardedBy("mCancelLock")
    @VisibleForTesting
    zzalc a;
    private final zzadj b;
    private final cp c;
    private final Object d = new Object();
    private final Context e;
    private final ahx f;
    private final aib g;
    @VisibleForTesting
    private zzaef h;
    private Runnable i;
    @VisibleForTesting
    private zzaej j;
    @VisibleForTesting
    private aui k;

    public bw(Context context, cp cpVar, zzadj zzadj, aib aib) {
        this.b = zzadj;
        this.e = context;
        this.c = cpVar;
        this.g = aib;
        this.f = new ahx(this.g);
        this.f.a(new bx(this));
        aiy aiy = new aiy();
        aiy.a = Integer.valueOf(this.c.j.b);
        aiy.b = Integer.valueOf(this.c.j.c);
        aiy.c = Integer.valueOf(this.c.j.d ? 0 : 2);
        this.f.a(new by(aiy));
        if (this.c.f != null) {
            this.f.a(new bz(this));
        }
        zzjn zzjn = this.c.c;
        if (zzjn.d && "interstitial_mb".equals(zzjn.a)) {
            this.f.a(ca.a);
        } else if (zzjn.d && "reward_mb".equals(zzjn.a)) {
            this.f.a(cb.a);
        } else if (zzjn.h || zzjn.d) {
            this.f.a(cd.a);
        } else {
            this.f.a(cc.a);
        }
        this.f.a(zzb.AD_REQUEST);
    }

    @VisibleForTesting
    private final zzjn a(zzaef zzaef) {
        int i = 1;
        if (this.h == null || this.h.V == null || this.h.V.size() <= 1) {
            i = 0;
        }
        if (i != 0 && this.k != null && !this.k.t) {
            return null;
        }
        if (this.j.y) {
            for (zzjn zzjn : zzaef.d.g) {
                if (zzjn.i) {
                    return new zzjn(zzjn, zzaef.d.g);
                }
            }
        }
        if (this.j.l == null) {
            throw new cg("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] split = this.j.l.split("x");
        String str;
        String valueOf;
        if (split.length != 2) {
            str = "Invalid ad size format from the ad response: ";
            valueOf = String.valueOf(this.j.l);
            throw new cg(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), 0);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            for (zzjn zzjn2 : zzaef.d.g) {
                float f = this.e.getResources().getDisplayMetrics().density;
                i = zzjn2.e == -1 ? (int) (((float) zzjn2.f) / f) : zzjn2.e;
                int i2 = zzjn2.b == -2 ? (int) (((float) zzjn2.c) / f) : zzjn2.b;
                if (parseInt == i && parseInt2 == i2 && !zzjn2.i) {
                    return new zzjn(zzjn2, zzaef.d.g);
                }
            }
            str = "The ad size from the ad response was not one of the requested sizes: ";
            valueOf = String.valueOf(this.j.l);
            throw new cg(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), 0);
        } catch (NumberFormatException e) {
            str = "Invalid ad size number from the ad response: ";
            valueOf = String.valueOf(this.j.l);
            throw new cg(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), 0);
        }
    }

    private final void a(int i, String str) {
        if (i == 3 || i == -1) {
            kk.d(str);
        } else {
            kk.e(str);
        }
        if (this.j == null) {
            this.j = new zzaej(i);
        } else {
            this.j = new zzaej(i, this.j.j);
        }
        this.b.zza(new gs(this.h != null ? this.h : new zzaef(this.c, -1, null, null, null), this.j, this.k, null, i, -1, this.j.m, null, this.f, null));
    }

    @VisibleForTesting
    final zzalc a(zzang zzang, zzaol<zzaef> zzaol) {
        Context context = this.e;
        if (new ci(context).zza(zzang)) {
            kk.b("Fetching ad response from local ad request service.");
            zzalc cmVar = new cm(context, zzaol, this);
            cmVar.zznt();
            return cmVar;
        }
        kk.b("Fetching ad response from remote ad request service.");
        akc.a();
        if (kb.c(context)) {
            return new cn(context, zzang, zzaol, this);
        }
        kk.e("Failed to connect to remote ad request service.");
        return null;
    }

    public final void a() {
        kk.b("AdLoaderBackgroundTask started.");
        this.i = new ce(this);
        ht.a.postDelayed(this.i, ((Long) akc.f().a(amn.bA)).longValue());
        long elapsedRealtime = au.l().elapsedRealtime();
        if (((Boolean) akc.f().a(amn.by)).booleanValue() && this.c.b.c != null) {
            String string = this.c.b.c.getString("_ad");
            if (string != null) {
                this.h = new zzaef(this.c, elapsedRealtime, null, null, null);
                zza(du.a(this.e, this.h, string));
                return;
            }
        }
        zzaol lnVar = new ln();
        hr.a(new cf(this, lnVar));
        String h = au.B().h(this.e);
        String i = au.B().i(this.e);
        String j = au.B().j(this.e);
        au.B().f(this.e, j);
        this.h = new zzaef(this.c, elapsedRealtime, h, i, j);
        lnVar.zzk(this.h);
    }

    public final void b() {
        synchronized (this.d) {
            if (this.a != null) {
                this.a.cancel();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01a1  */
    public final void zza(@android.support.annotation.NonNull com.google.android.gms.internal.ads.zzaej r14) {
        /*
        r13 = this;
        r9 = 0;
        r5 = -2;
        r3 = -3;
        r8 = 1;
        r1 = 0;
        r0 = "Received ad response.";
        com.google.android.gms.internal.ads.kk.b(r0);
        r13.j = r14;
        r0 = com.google.android.gms.ads.internal.au.l();
        r6 = r0.elapsedRealtime();
        r2 = r13.d;
        monitor-enter(r2);
        r0 = 0;
        r13.a = r0;	 Catch:{ all -> 0x0094 }
        monitor-exit(r2);	 Catch:{ all -> 0x0094 }
        r0 = com.google.android.gms.ads.internal.au.i();
        r0 = r0.l();
        r2 = r13.j;
        r2 = r2.F;
        r0.d(r2);
        r0 = com.google.android.gms.internal.ads.amn.aT;
        r2 = com.google.android.gms.internal.ads.akc.f();
        r0 = r2.a(r0);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x0051;
    L_0x003c:
        r0 = r13.j;
        r0 = r0.N;
        if (r0 == 0) goto L_0x0097;
    L_0x0042:
        r0 = com.google.android.gms.ads.internal.au.i();
        r0 = r0.l();
        r2 = r13.h;
        r2 = r2.e;
        r0.c(r2);
    L_0x0051:
        r0 = r13.j;	 Catch:{ cg -> 0x0080 }
        r0 = r0.d;	 Catch:{ cg -> 0x0080 }
        if (r0 == r5) goto L_0x00a7;
    L_0x0057:
        r0 = r13.j;	 Catch:{ cg -> 0x0080 }
        r0 = r0.d;	 Catch:{ cg -> 0x0080 }
        if (r0 == r3) goto L_0x00a7;
    L_0x005d:
        r0 = new com.google.android.gms.internal.ads.cg;	 Catch:{ cg -> 0x0080 }
        r1 = r13.j;	 Catch:{ cg -> 0x0080 }
        r1 = r1.d;	 Catch:{ cg -> 0x0080 }
        r2 = 66;
        r3 = new java.lang.StringBuilder;	 Catch:{ cg -> 0x0080 }
        r3.<init>(r2);	 Catch:{ cg -> 0x0080 }
        r2 = "There was a problem getting an ad response. ErrorCode: ";
        r2 = r3.append(r2);	 Catch:{ cg -> 0x0080 }
        r1 = r2.append(r1);	 Catch:{ cg -> 0x0080 }
        r1 = r1.toString();	 Catch:{ cg -> 0x0080 }
        r2 = r13.j;	 Catch:{ cg -> 0x0080 }
        r2 = r2.d;	 Catch:{ cg -> 0x0080 }
        r0.<init>(r1, r2);	 Catch:{ cg -> 0x0080 }
        throw r0;	 Catch:{ cg -> 0x0080 }
    L_0x0080:
        r0 = move-exception;
        r1 = r0.a();
        r0 = r0.getMessage();
        r13.a(r1, r0);
        r0 = com.google.android.gms.internal.ads.ht.a;
        r1 = r13.i;
        r0.removeCallbacks(r1);
    L_0x0093:
        return;
    L_0x0094:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0094 }
        throw r0;
    L_0x0097:
        r0 = com.google.android.gms.ads.internal.au.i();
        r0 = r0.l();
        r2 = r13.h;
        r2 = r2.e;
        r0.d(r2);
        goto L_0x0051;
    L_0x00a7:
        r0 = r13.j;	 Catch:{ cg -> 0x0080 }
        r0 = r0.d;	 Catch:{ cg -> 0x0080 }
        if (r0 == r3) goto L_0x0121;
    L_0x00ad:
        r0 = r13.j;	 Catch:{ cg -> 0x0080 }
        r0 = r0.b;	 Catch:{ cg -> 0x0080 }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ cg -> 0x0080 }
        if (r0 == 0) goto L_0x00c0;
    L_0x00b7:
        r0 = new com.google.android.gms.internal.ads.cg;	 Catch:{ cg -> 0x0080 }
        r1 = "No fill from ad server.";
        r2 = 3;
        r0.<init>(r1, r2);	 Catch:{ cg -> 0x0080 }
        throw r0;	 Catch:{ cg -> 0x0080 }
    L_0x00c0:
        r0 = com.google.android.gms.ads.internal.au.i();	 Catch:{ cg -> 0x0080 }
        r0 = r0.l();	 Catch:{ cg -> 0x0080 }
        r2 = r13.j;	 Catch:{ cg -> 0x0080 }
        r2 = r2.t;	 Catch:{ cg -> 0x0080 }
        r0.a(r2);	 Catch:{ cg -> 0x0080 }
        r0 = r13.j;	 Catch:{ cg -> 0x0080 }
        r0 = r0.g;	 Catch:{ cg -> 0x0080 }
        if (r0 == 0) goto L_0x01f3;
    L_0x00d5:
        r0 = new com.google.android.gms.internal.ads.aui;	 Catch:{ JSONException -> 0x01cc }
        r2 = r13.j;	 Catch:{ JSONException -> 0x01cc }
        r2 = r2.b;	 Catch:{ JSONException -> 0x01cc }
        r0.<init>(r2);	 Catch:{ JSONException -> 0x01cc }
        r13.k = r0;	 Catch:{ JSONException -> 0x01cc }
        r0 = com.google.android.gms.ads.internal.au.i();	 Catch:{ JSONException -> 0x01cc }
        r2 = r13.k;	 Catch:{ JSONException -> 0x01cc }
        r2 = r2.h;	 Catch:{ JSONException -> 0x01cc }
        r0.a(r2);	 Catch:{ JSONException -> 0x01cc }
    L_0x00eb:
        r0 = r13.j;	 Catch:{ cg -> 0x0080 }
        r0 = r0.G;	 Catch:{ cg -> 0x0080 }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ cg -> 0x0080 }
        if (r0 != 0) goto L_0x0121;
    L_0x00f5:
        r0 = com.google.android.gms.internal.ads.amn.cC;	 Catch:{ cg -> 0x0080 }
        r2 = com.google.android.gms.internal.ads.akc.f();	 Catch:{ cg -> 0x0080 }
        r0 = r2.a(r0);	 Catch:{ cg -> 0x0080 }
        r0 = (java.lang.Boolean) r0;	 Catch:{ cg -> 0x0080 }
        r0 = r0.booleanValue();	 Catch:{ cg -> 0x0080 }
        if (r0 == 0) goto L_0x0121;
    L_0x0107:
        r0 = "Received cookie from server. Setting webview cookie in CookieManager.";
        com.google.android.gms.internal.ads.kk.b(r0);	 Catch:{ cg -> 0x0080 }
        r0 = com.google.android.gms.ads.internal.au.g();	 Catch:{ cg -> 0x0080 }
        r2 = r13.e;	 Catch:{ cg -> 0x0080 }
        r0 = r0.c(r2);	 Catch:{ cg -> 0x0080 }
        if (r0 == 0) goto L_0x0121;
    L_0x0118:
        r2 = "googleads.g.doubleclick.net";
        r3 = r13.j;	 Catch:{ cg -> 0x0080 }
        r3 = r3.G;	 Catch:{ cg -> 0x0080 }
        r0.setCookie(r2, r3);	 Catch:{ cg -> 0x0080 }
    L_0x0121:
        r0 = r13.h;	 Catch:{ cg -> 0x0080 }
        r0 = r0.d;	 Catch:{ cg -> 0x0080 }
        r0 = r0.g;	 Catch:{ cg -> 0x0080 }
        if (r0 == 0) goto L_0x0223;
    L_0x0129:
        r0 = r13.h;	 Catch:{ cg -> 0x0080 }
        r4 = r13.a(r0);	 Catch:{ cg -> 0x0080 }
    L_0x012f:
        r0 = com.google.android.gms.ads.internal.au.i();
        r0 = r0.l();
        r2 = r13.j;
        r2 = r2.u;
        r0.b(r2);
        r0 = com.google.android.gms.ads.internal.au.i();
        r0 = r0.l();
        r2 = r13.j;
        r2 = r2.M;
        r0.c(r2);
        r0 = r13.j;
        r0 = r0.q;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x0206;
    L_0x0157:
        r10 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0200 }
        r0 = r13.j;	 Catch:{ Exception -> 0x0200 }
        r0 = r0.q;	 Catch:{ Exception -> 0x0200 }
        r10.<init>(r0);	 Catch:{ Exception -> 0x0200 }
    L_0x0160:
        r0 = r13.j;
        r0 = r0.P;
        r2 = 2;
        if (r0 != r2) goto L_0x0191;
    L_0x0167:
        r2 = java.lang.Boolean.valueOf(r8);
        r0 = r13.h;
        r0 = r0.c;
        r1 = r0.m;
        if (r1 == 0) goto L_0x0209;
    L_0x0173:
        r0 = r0.m;
    L_0x0175:
        r1 = com.google.ads.mediation.admob.AdMobAdapter.class;
        r1 = r1.getName();
        r1 = r0.getBundle(r1);
        if (r1 == 0) goto L_0x0210;
    L_0x0181:
        r1 = com.google.ads.mediation.admob.AdMobAdapter.class;
        r1 = r1.getName();
        r0 = r0.getBundle(r1);
    L_0x018b:
        r1 = "render_test_label";
        r0.putBoolean(r1, r8);
        r1 = r2;
    L_0x0191:
        r0 = r13.j;
        r0 = r0.P;
        if (r0 != r8) goto L_0x019b;
    L_0x0197:
        r1 = java.lang.Boolean.valueOf(r9);
    L_0x019b:
        r0 = r13.j;
        r0 = r0.P;
        if (r0 != 0) goto L_0x0221;
    L_0x01a1:
        r0 = r13.h;
        r0 = r0.c;
        r0 = com.google.android.gms.internal.ads.jt.a(r0);
        r12 = java.lang.Boolean.valueOf(r0);
    L_0x01ad:
        r0 = new com.google.android.gms.internal.ads.gs;
        r1 = r13.h;
        r2 = r13.j;
        r3 = r13.k;
        r8 = r13.j;
        r8 = r8.m;
        r11 = r13.f;
        r0.<init>(r1, r2, r3, r4, r5, r6, r8, r10, r11, r12);
        r1 = r13.b;
        r1.zza(r0);
        r0 = com.google.android.gms.internal.ads.ht.a;
        r1 = r13.i;
        r0.removeCallbacks(r1);
        goto L_0x0093;
    L_0x01cc:
        r0 = move-exception;
        r1 = "Could not parse mediation config.";
        com.google.android.gms.internal.ads.kk.b(r1, r0);	 Catch:{ cg -> 0x0080 }
        r1 = new com.google.android.gms.internal.ads.cg;	 Catch:{ cg -> 0x0080 }
        r2 = "Could not parse mediation config: ";
        r0 = r13.j;	 Catch:{ cg -> 0x0080 }
        r0 = r0.b;	 Catch:{ cg -> 0x0080 }
        r0 = java.lang.String.valueOf(r0);	 Catch:{ cg -> 0x0080 }
        r3 = r0.length();	 Catch:{ cg -> 0x0080 }
        if (r3 == 0) goto L_0x01ed;
    L_0x01e4:
        r0 = r2.concat(r0);	 Catch:{ cg -> 0x0080 }
    L_0x01e8:
        r2 = 0;
        r1.<init>(r0, r2);	 Catch:{ cg -> 0x0080 }
        throw r1;	 Catch:{ cg -> 0x0080 }
    L_0x01ed:
        r0 = new java.lang.String;	 Catch:{ cg -> 0x0080 }
        r0.<init>(r2);	 Catch:{ cg -> 0x0080 }
        goto L_0x01e8;
    L_0x01f3:
        r0 = com.google.android.gms.ads.internal.au.i();	 Catch:{ cg -> 0x0080 }
        r2 = r13.j;	 Catch:{ cg -> 0x0080 }
        r2 = r2.I;	 Catch:{ cg -> 0x0080 }
        r0.a(r2);	 Catch:{ cg -> 0x0080 }
        goto L_0x00eb;
    L_0x0200:
        r0 = move-exception;
        r2 = "Error parsing the JSON for Active View.";
        com.google.android.gms.internal.ads.kk.b(r2, r0);
    L_0x0206:
        r10 = r1;
        goto L_0x0160;
    L_0x0209:
        r0 = new android.os.Bundle;
        r0.<init>();
        goto L_0x0175;
    L_0x0210:
        r1 = new android.os.Bundle;
        r1.<init>();
        r3 = com.google.ads.mediation.admob.AdMobAdapter.class;
        r3 = r3.getName();
        r0.putBundle(r3, r1);
        r0 = r1;
        goto L_0x018b;
    L_0x0221:
        r12 = r1;
        goto L_0x01ad;
    L_0x0223:
        r4 = r1;
        goto L_0x012f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bw.zza(com.google.android.gms.internal.ads.zzaej):void");
    }
}
