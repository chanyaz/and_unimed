package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.util.s;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.internal.ads.akc;
import com.google.android.gms.internal.ads.akj;
import com.google.android.gms.internal.ads.amn;
import com.google.android.gms.internal.ads.ht;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzang;
import com.google.android.gms.internal.ads.zzjj;
import com.google.android.gms.internal.ads.zzjn;
import com.google.android.gms.internal.ads.zzkh;
import com.google.android.gms.internal.ads.zzlg;
import com.google.android.gms.internal.ads.zzpl;
import com.google.android.gms.internal.ads.zzqw;
import com.google.android.gms.internal.ads.zzqz;
import com.google.android.gms.internal.ads.zzrc;
import com.google.android.gms.internal.ads.zzrf;
import com.google.android.gms.internal.ads.zzri;
import com.google.android.gms.internal.ads.zzrl;
import com.google.android.gms.internal.ads.zzxn;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class h extends akj {
    private final Context a;
    private final zzkh b;
    private final zzxn c;
    @Nullable
    private final zzqw d;
    @Nullable
    private final zzrl e;
    @Nullable
    private final zzqz f;
    @Nullable
    private final zzri g;
    @Nullable
    private final zzjn h;
    @Nullable
    private final PublisherAdViewOptions i;
    private final s<String, zzrf> j;
    private final s<String, zzrc> k;
    private final zzpl l;
    private final List<String> m;
    private final zzlg n;
    private final String o;
    private final zzang p;
    @Nullable
    private WeakReference<ay> q;
    private final br r;
    private final Object s = new Object();

    h(Context context, String str, zzxn zzxn, zzang zzang, zzkh zzkh, zzqw zzqw, zzrl zzrl, zzqz zzqz, s<String, zzrf> sVar, s<String, zzrc> sVar2, zzpl zzpl, zzlg zzlg, br brVar, zzri zzri, zzjn zzjn, PublisherAdViewOptions publisherAdViewOptions) {
        this.a = context;
        this.o = str;
        this.c = zzxn;
        this.p = zzang;
        this.b = zzkh;
        this.f = zzqz;
        this.d = zzqw;
        this.e = zzrl;
        this.j = sVar;
        this.k = sVar2;
        this.l = zzpl;
        this.m = c();
        this.n = zzlg;
        this.r = brVar;
        this.g = zzri;
        this.h = zzjn;
        this.i = publisherAdViewOptions;
        amn.a(this.a);
    }

    private final void a(int i) {
        if (this.b != null) {
            try {
                this.b.onAdFailedToLoad(0);
            } catch (Throwable e) {
                kk.c("Failed calling onAdFailedToLoad.", e);
            }
        }
    }

    private final void a(zzjj zzjj) {
        if (((Boolean) akc.f().a(amn.cl)).booleanValue() || this.e == null) {
            a blVar = new bl(this.a, this.r, this.h, this.o, this.c, this.p);
            this.q = new WeakReference(blVar);
            zzri zzri = this.g;
            ar.b("setOnPublisherAdViewLoadedListener must be called on the main UI thread.");
            blVar.e.z = zzri;
            if (this.i != null) {
                if (this.i.b() != null) {
                    blVar.zza(this.i.b());
                }
                blVar.setManualImpressionsEnabled(this.i.a());
            }
            zzqw zzqw = this.d;
            ar.b("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
            blVar.e.r = zzqw;
            zzrl zzrl = this.e;
            ar.b("setOnUnifiedNativeAdLoadedListener must be called on the main UI thread.");
            blVar.e.t = zzrl;
            zzqz zzqz = this.f;
            ar.b("setOnContentAdLoadedListener must be called on the main UI thread.");
            blVar.e.s = zzqz;
            s sVar = this.j;
            ar.b("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
            blVar.e.v = sVar;
            sVar = this.k;
            ar.b("setOnCustomClickListener must be called on the main UI thread.");
            blVar.e.u = sVar;
            zzpl zzpl = this.l;
            ar.b("setNativeAdOptions must be called on the main UI thread.");
            blVar.e.w = zzpl;
            blVar.c(c());
            blVar.zza(this.b);
            blVar.zza(this.n);
            List arrayList = new ArrayList();
            if (b()) {
                arrayList.add(Integer.valueOf(1));
            }
            if (this.g != null) {
                arrayList.add(Integer.valueOf(2));
            }
            blVar.d(arrayList);
            if (b()) {
                zzjj.c.putBoolean("ina", true);
            }
            if (this.g != null) {
                zzjj.c.putBoolean("iba", true);
            }
            blVar.zzb(zzjj);
            return;
        }
        a(0);
    }

    private final void a(zzjj zzjj, int i) {
        if (((Boolean) akc.f().a(amn.cl)).booleanValue() || this.e == null) {
            a acVar = new ac(this.a, this.r, zzjn.a(this.a), this.o, this.c, this.p);
            this.q = new WeakReference(acVar);
            zzqw zzqw = this.d;
            ar.b("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
            acVar.e.r = zzqw;
            zzrl zzrl = this.e;
            ar.b("setOnUnifiedNativeAdLoadedListener must be called on the main UI thread.");
            acVar.e.t = zzrl;
            zzqz zzqz = this.f;
            ar.b("setOnContentAdLoadedListener must be called on the main UI thread.");
            acVar.e.s = zzqz;
            s sVar = this.j;
            ar.b("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
            acVar.e.v = sVar;
            acVar.zza(this.b);
            sVar = this.k;
            ar.b("setOnCustomClickListener must be called on the main UI thread.");
            acVar.e.u = sVar;
            acVar.c(c());
            zzpl zzpl = this.l;
            ar.b("setNativeAdOptions must be called on the main UI thread.");
            acVar.e.w = zzpl;
            acVar.zza(this.n);
            acVar.b(i);
            acVar.zzb(zzjj);
            return;
        }
        a(0);
    }

    private static void a(Runnable runnable) {
        ht.a.post(runnable);
    }

    private final boolean a() {
        return ((Boolean) akc.f().a(amn.aM)).booleanValue() && this.g != null;
    }

    private final boolean b() {
        return (this.d == null && this.f == null && this.e == null && (this.j == null || this.j.size() <= 0)) ? false : true;
    }

    private final List<String> c() {
        List<String> arrayList = new ArrayList();
        if (this.f != null) {
            arrayList.add("1");
        }
        if (this.d != null) {
            arrayList.add("2");
        }
        if (this.e != null) {
            arrayList.add("6");
        }
        if (this.j.size() > 0) {
            arrayList.add("3");
        }
        return arrayList;
    }

    /* JADX WARNING: Missing block: B:15:?, code:
            return r0;
     */
    @android.support.annotation.Nullable
    public final java.lang.String getMediationAdapterClassName() {
        /*
        r3 = this;
        r1 = 0;
        r2 = r3.s;
        monitor-enter(r2);
        r0 = r3.q;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x001a;
    L_0x0008:
        r0 = r3.q;	 Catch:{ all -> 0x001d }
        r0 = r0.get();	 Catch:{ all -> 0x001d }
        r0 = (com.google.android.gms.ads.internal.ay) r0;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0018;
    L_0x0012:
        r0 = r0.getMediationAdapterClassName();	 Catch:{ all -> 0x001d }
    L_0x0016:
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
    L_0x0017:
        return r0;
    L_0x0018:
        r0 = r1;
        goto L_0x0016;
    L_0x001a:
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
        r0 = r1;
        goto L_0x0017;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.h.getMediationAdapterClassName():java.lang.String");
    }

    /* JADX WARNING: Missing block: B:15:?, code:
            return r0;
     */
    public final boolean isLoading() {
        /*
        r3 = this;
        r1 = 0;
        r2 = r3.s;
        monitor-enter(r2);
        r0 = r3.q;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x001a;
    L_0x0008:
        r0 = r3.q;	 Catch:{ all -> 0x001d }
        r0 = r0.get();	 Catch:{ all -> 0x001d }
        r0 = (com.google.android.gms.ads.internal.ay) r0;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0018;
    L_0x0012:
        r0 = r0.isLoading();	 Catch:{ all -> 0x001d }
    L_0x0016:
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
    L_0x0017:
        return r0;
    L_0x0018:
        r0 = r1;
        goto L_0x0016;
    L_0x001a:
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
        r0 = r1;
        goto L_0x0017;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.h.isLoading():boolean");
    }

    public final void zza(zzjj zzjj, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Number of ads has to be more than 0");
        }
        a(new j(this, zzjj, i));
    }

    /* JADX WARNING: Missing block: B:15:?, code:
            return r0;
     */
    @android.support.annotation.Nullable
    public final java.lang.String zzck() {
        /*
        r3 = this;
        r1 = 0;
        r2 = r3.s;
        monitor-enter(r2);
        r0 = r3.q;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x001a;
    L_0x0008:
        r0 = r3.q;	 Catch:{ all -> 0x001d }
        r0 = r0.get();	 Catch:{ all -> 0x001d }
        r0 = (com.google.android.gms.ads.internal.ay) r0;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0018;
    L_0x0012:
        r0 = r0.zzck();	 Catch:{ all -> 0x001d }
    L_0x0016:
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
    L_0x0017:
        return r0;
    L_0x0018:
        r0 = r1;
        goto L_0x0016;
    L_0x001a:
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
        r0 = r1;
        goto L_0x0017;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.h.zzck():java.lang.String");
    }

    public final void zzd(zzjj zzjj) {
        a(new i(this, zzjj));
    }
}
