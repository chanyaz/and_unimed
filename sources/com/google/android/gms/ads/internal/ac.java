package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.util.s;
import android.util.Log;
import android.view.View;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.internal.ads.ad;
import com.google.android.gms.internal.ads.afj;
import com.google.android.gms.internal.ads.akc;
import com.google.android.gms.internal.ads.amn;
import com.google.android.gms.internal.ads.ana;
import com.google.android.gms.internal.ads.ano;
import com.google.android.gms.internal.ads.anq;
import com.google.android.gms.internal.ads.ans;
import com.google.android.gms.internal.ads.anv;
import com.google.android.gms.internal.ads.anx;
import com.google.android.gms.internal.ads.anz;
import com.google.android.gms.internal.ads.aui;
import com.google.android.gms.internal.ads.bf;
import com.google.android.gms.internal.ads.gr;
import com.google.android.gms.internal.ads.gs;
import com.google.android.gms.internal.ads.hl;
import com.google.android.gms.internal.ads.hr;
import com.google.android.gms.internal.ads.ht;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.lk;
import com.google.android.gms.internal.ads.zzaaw;
import com.google.android.gms.internal.ads.zzacm;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzang;
import com.google.android.gms.internal.ads.zzanz;
import com.google.android.gms.internal.ads.zzaqw;
import com.google.android.gms.internal.ads.zzjj;
import com.google.android.gms.internal.ads.zzjn;
import com.google.android.gms.internal.ads.zzlo;
import com.google.android.gms.internal.ads.zzlr;
import com.google.android.gms.internal.ads.zzod;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zzoz;
import com.google.android.gms.internal.ads.zzpa;
import com.google.android.gms.internal.ads.zzpb;
import com.google.android.gms.internal.ads.zzqs;
import com.google.android.gms.internal.ads.zzrc;
import com.google.android.gms.internal.ads.zzrf;
import com.google.android.gms.internal.ads.zzxn;
import com.google.android.gms.internal.ads.zzxq;
import com.google.android.gms.internal.ads.zzxz;
import com.google.android.gms.internal.ads.zzyc;
import com.google.android.gms.internal.ads.zzyf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONObject;

@zzadh
@ParametersAreNonnullByDefault
public final class ac extends ay implements zzpa {
    private final Object k;
    @VisibleForTesting
    private boolean l;
    private lk<zzpb> m;
    private zzaqw n;
    @Nullable
    private zzaqw o;
    private boolean p;
    private int q;
    @GuardedBy("mLock")
    private zzacm r;
    private final String s;

    public ac(Context context, br brVar, zzjn zzjn, String str, zzxn zzxn, zzang zzang) {
        this(context, brVar, zzjn, str, zzxn, zzang, false);
    }

    public ac(Context context, br brVar, zzjn zzjn, String str, zzxn zzxn, zzang zzang, boolean z) {
        super(context, zzjn, str, zzxn, zzang, brVar);
        this.k = new Object();
        this.m = new lk();
        this.q = 1;
        this.s = UUID.randomUUID().toString();
        this.l = z;
    }

    private static void a(av avVar, av avVar2) {
        if (avVar2.r == null) {
            avVar2.r = avVar.r;
        }
        if (avVar2.s == null) {
            avVar2.s = avVar.s;
        }
        if (avVar2.u == null) {
            avVar2.u = avVar.u;
        }
        if (avVar2.v == null) {
            avVar2.v = avVar.v;
        }
        if (avVar2.x == null) {
            avVar2.x = avVar.x;
        }
        if (avVar2.w == null) {
            avVar2.w = avVar.w;
        }
        if (avVar2.F == null) {
            avVar2.F = avVar.F;
        }
        if (avVar2.l == null) {
            avVar2.l = avVar.l;
        }
        if (avVar2.G == null) {
            avVar2.G = avVar.G;
        }
        if (avVar2.m == null) {
            avVar2.m = avVar.m;
        }
        if (avVar2.n == null) {
            avVar2.n = avVar.n;
        }
        if (avVar2.i == null) {
            avVar2.i = avVar.i;
        }
        if (avVar2.j == null) {
            avVar2.j = avVar.j;
        }
        if (avVar2.k == null) {
            avVar2.k = avVar.k;
        }
    }

    private final void a(ano ano) {
        ht.a.post(new ag(this, ano));
    }

    private final void a(anq anq) {
        ht.a.post(new ai(this, anq));
    }

    private final void a(anv anv) {
        ht.a.post(new ah(this, anv));
    }

    private static anv b(zzpb zzpb) {
        anv anv = null;
        Object obj = null;
        if (zzpb instanceof anq) {
            anq anq = (anq) zzpb;
            anv = new anv(anq.getHeadline(), anq.getImages(), anq.getBody(), anq.zzkg(), anq.getCallToAction(), anq.getAdvertiser(), -1.0d, null, null, anq.zzkc(), anq.getVideoController(), anq.zzkd(), anq.zzke(), anq.getMediationAdapterClassName(), anq.getExtras());
            obj = anq.zzka() != null ? c.a(anq.zzka()) : null;
        } else if (zzpb instanceof ano) {
            ano ano = (ano) zzpb;
            anv = new anv(ano.getHeadline(), ano.getImages(), ano.getBody(), ano.zzjz(), ano.getCallToAction(), null, ano.getStarRating(), ano.getStore(), ano.getPrice(), ano.zzkc(), ano.getVideoController(), ano.zzkd(), ano.zzke(), ano.getMediationAdapterClassName(), ano.getExtras());
            obj = ano.zzka() != null ? c.a(ano.zzka()) : null;
        }
        if (obj instanceof anz) {
            anv.zzb((anz) obj);
        }
        return anv;
    }

    private final boolean s() {
        return this.e.j != null && this.e.j.N;
    }

    @Nullable
    private final aui t() {
        return (this.e.j == null || !this.e.j.n) ? null : this.e.j.r;
    }

    private final void u() {
        zzacm l = l();
        if (l != null) {
            l.zzmc();
        }
    }

    protected final void a(int i) {
        a(i, false);
    }

    protected final void a(int i, boolean z) {
        u();
        super.a(i, z);
    }

    protected final void a(@Nullable IObjectWrapper iObjectWrapper) {
        Object a = iObjectWrapper != null ? c.a(iObjectWrapper) : null;
        if (a instanceof zzoz) {
            ((zzoz) a).zzkl();
        }
        super.b(this.e.j, false);
    }

    public final void a(gs gsVar, ana ana) {
        Throwable e;
        if (gsVar.d != null) {
            this.e.i = gsVar.d;
        }
        if (gsVar.e != -2) {
            ht.a.post(new ad(this, gsVar));
            return;
        }
        int i = gsVar.a.Y;
        if (i == 1) {
            this.e.I = 0;
            av avVar = this.e;
            au.d();
            avVar.h = ad.a(this.e.c, this, gsVar, this.e.d, null, this.j, this, ana);
            String str = "AdRenderer: ";
            String valueOf = String.valueOf(this.e.h.getClass().getName());
            kk.b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            return;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            int i2;
            JSONArray jSONArray2 = new JSONObject(gsVar.b.b).getJSONArray("slots");
            for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                JSONArray jSONArray3 = jSONArray2.getJSONObject(i3).getJSONArray("ads");
                for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                    jSONArray.put(jSONArray3.get(i4));
                }
            }
            u();
            List arrayList = new ArrayList();
            for (i2 = 0; i2 < i; i2++) {
                arrayList.add(hr.a(new ae(this, i2, jSONArray, i, gsVar)));
            }
            for (i2 = 0; i2 < arrayList.size(); i2++) {
                try {
                    ht.a.post(new af(this, (zzpb) ((zzanz) arrayList.get(i2)).get(((Long) akc.f().a(amn.bB)).longValue(), TimeUnit.MILLISECONDS), i2, arrayList));
                } catch (Throwable e2) {
                    kk.c("", e2);
                    Thread.currentThread().interrupt();
                } catch (CancellationException e3) {
                    e2 = e3;
                    kk.c("", e2);
                } catch (ExecutionException e4) {
                    e2 = e4;
                    kk.c("", e2);
                } catch (TimeoutException e5) {
                    e2 = e5;
                    kk.c("", e2);
                }
            }
        } catch (Throwable e22) {
            kk.c("Malformed native ad response", e22);
            a(0);
        }
    }

    public final void a(zzaqw zzaqw) {
        this.n = zzaqw;
    }

    protected final void a(boolean z) {
        String str = null;
        super.a(z);
        if (this.p) {
            if (((Boolean) akc.f().a(amn.cg)).booleanValue()) {
                n();
            }
        }
        if (!s()) {
            return;
        }
        if (this.o != null || this.n != null) {
            zzaqw zzaqw;
            if (this.o != null) {
                zzaqw = this.o;
            } else if (this.n != null) {
                str = "javascript";
                zzaqw = this.n;
            } else {
                zzaqw = null;
            }
            if (zzaqw.getWebView() != null && au.u().a(this.e.c)) {
                int i = this.e.e.b;
                this.h = au.u().a(i + "." + this.e.e.c, zzaqw.getWebView(), "", "javascript", str);
                if (this.h != null) {
                    au.u().a(this.h);
                }
            }
        }
    }

    protected final boolean a(gr grVar, gr grVar2) {
        c(null);
        if (this.e.d()) {
            if (grVar2.n) {
                u();
                try {
                    zzyf zzmu = grVar2.p != null ? grVar2.p.zzmu() : null;
                    zzxz zzmo = grVar2.p != null ? grVar2.p.zzmo() : null;
                    zzyc zzmp = grVar2.p != null ? grVar2.p.zzmp() : null;
                    zzqs zzmt = grVar2.p != null ? grVar2.p.zzmt() : null;
                    String b = ay.b(grVar2);
                    anv anv;
                    if (zzmu == null || this.e.t == null) {
                        if (zzmo != null) {
                            if (this.e.t != null) {
                                anv = new anv(zzmo.getHeadline(), zzmo.getImages(), zzmo.getBody(), zzmo.zzjz() != null ? zzmo.zzjz() : null, zzmo.getCallToAction(), null, zzmo.getStarRating(), zzmo.getStore(), zzmo.getPrice(), null, zzmo.getVideoController(), zzmo.zzmw() != null ? (View) c.a(zzmo.zzmw()) : null, zzmo.zzke(), b, zzmo.getExtras());
                                anv.zzb(new anx(this.e.c, (zzpa) this, this.e.d, zzmo, (zzpb) anv));
                                a(anv);
                            }
                        }
                        if (zzmo != null) {
                            if (this.e.r != null) {
                                ano ano = new ano(zzmo.getHeadline(), zzmo.getImages(), zzmo.getBody(), zzmo.zzjz() != null ? zzmo.zzjz() : null, zzmo.getCallToAction(), zzmo.getStarRating(), zzmo.getStore(), zzmo.getPrice(), null, zzmo.getExtras(), zzmo.getVideoController(), zzmo.zzmw() != null ? (View) c.a(zzmo.zzmw()) : null, zzmo.zzke(), b);
                                ano.zzb(new anx(this.e.c, (zzpa) this, this.e.d, zzmo, (zzpb) ano));
                                a(ano);
                            }
                        }
                        if (zzmp != null && this.e.t != null) {
                            anv = new anv(zzmp.getHeadline(), zzmp.getImages(), zzmp.getBody(), zzmp.zzkg() != null ? zzmp.zzkg() : null, zzmp.getCallToAction(), zzmp.getAdvertiser(), -1.0d, null, null, null, zzmp.getVideoController(), zzmp.zzmw() != null ? (View) c.a(zzmp.zzmw()) : null, zzmp.zzke(), b, zzmp.getExtras());
                            anv.zzb(new anx(this.e.c, (zzpa) this, this.e.d, zzmp, (zzpb) anv));
                            a(anv);
                        } else if (zzmp != null && this.e.s != null) {
                            anq anq = new anq(zzmp.getHeadline(), zzmp.getImages(), zzmp.getBody(), zzmp.zzkg() != null ? zzmp.zzkg() : null, zzmp.getCallToAction(), zzmp.getAdvertiser(), null, zzmp.getExtras(), zzmp.getVideoController(), zzmp.zzmw() != null ? (View) c.a(zzmp.zzmw()) : null, zzmp.zzke(), b);
                            anq.zzb(new anx(this.e.c, (zzpa) this, this.e.d, zzmp, (zzpb) anq));
                            a(anq);
                        } else if (zzmt == null || this.e.v == null || this.e.v.get(zzmt.getCustomTemplateId()) == null) {
                            kk.e("No matching mapper/listener for retrieved native ad template.");
                            a(0);
                            return false;
                        } else {
                            ht.a.post(new ak(this, zzmt));
                        }
                    } else {
                        anv = new anv(zzmu.getHeadline(), zzmu.getImages(), zzmu.getBody(), zzmu.zzjz() != null ? zzmu.zzjz() : null, zzmu.getCallToAction(), zzmu.getAdvertiser(), zzmu.getStarRating(), zzmu.getStore(), zzmu.getPrice(), null, zzmu.getVideoController(), zzmu.zzmw() != null ? (View) c.a(zzmu.zzmw()) : null, zzmu.zzke(), b, zzmu.getExtras());
                        anv.zzb(new anx(this.e.c, (zzpa) this, this.e.d, zzmu, (zzpb) anv));
                        a(anv);
                    }
                } catch (Throwable e) {
                    kk.d("#007 Could not call remote method.", e);
                }
            } else {
                zzpb zzpb = grVar2.C;
                if (this.l) {
                    this.m.b(zzpb);
                } else if ((zzpb instanceof anq) && this.e.t != null) {
                    a(b(grVar2.C));
                } else if ((zzpb instanceof anq) && this.e.s != null) {
                    a((anq) grVar2.C);
                } else if ((zzpb instanceof ano) && this.e.t != null) {
                    a(b(grVar2.C));
                } else if ((zzpb instanceof ano) && this.e.r != null) {
                    a((ano) grVar2.C);
                } else if (!(zzpb instanceof ans) || this.e.v == null || this.e.v.get(((ans) zzpb).getCustomTemplateId()) == null) {
                    kk.e("No matching listener for retrieved native ad template.");
                    a(0);
                    return false;
                } else {
                    ht.a.post(new aj(this, ((ans) zzpb).getCustomTemplateId(), grVar2));
                }
            }
            return super.a(grVar, grVar2);
        }
        throw new IllegalStateException("Native ad DOES NOT have custom rendering mode.");
    }

    public final boolean a(zzjj zzjj, ana ana) {
        try {
            k();
            return super.a(zzjj, ana, this.q);
        } catch (Throwable e) {
            String str = "Error initializing webview.";
            if (kk.a(4)) {
                Log.i("Ads", str, e);
            }
            return false;
        }
    }

    protected final boolean a(zzjj zzjj, gr grVar, boolean z) {
        return this.d.e();
    }

    public final void b(int i) {
        ar.b("setMaxNumberOfAds must be called on the main UI thread.");
        this.q = i;
    }

    public final void b(@Nullable zzaqw zzaqw) {
        this.o = zzaqw;
    }

    public final void c(@Nullable List<String> list) {
        ar.b("setNativeTemplates must be called on the main UI thread.");
        this.e.F = list;
    }

    protected final void e() {
        a(false);
    }

    public final String getAdUnitId() {
        return this.e.b;
    }

    public final String j() {
        return this.s;
    }

    final void k() {
        synchronized (this.k) {
            hl.a("Initializing webview native ads utills");
            this.r = new bf(this.e.c, this, this.s, this.e.d, this.e.e);
        }
    }

    @Nullable
    public final zzacm l() {
        zzacm zzacm;
        synchronized (this.k) {
            zzacm = this.r;
        }
        return zzacm;
    }

    protected final Future<zzpb> m() {
        return this.m;
    }

    public final void n() {
        if (this.e.j == null || this.n == null) {
            this.p = true;
            kk.e("Request to enable ActiveView before adState is available.");
            return;
        }
        au.i().g().a(this.e.i, this.e.j, this.n.getView(), this.n);
        this.p = false;
    }

    public final void o() {
        this.p = false;
        if (this.e.j == null || this.n == null) {
            kk.e("Request to enable ActiveView before adState is available.");
        } else {
            au.i().g().a(this.e.j);
        }
    }

    public final s<String, zzrf> p() {
        ar.b("getOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        return this.e.v;
    }

    public final void pause() {
        throw new IllegalStateException("Native Ad DOES NOT support pause().");
    }

    public final void q() {
        if (this.n != null && this.n.zztm() != null && this.e.w != null && this.e.w.f != null) {
            this.n.zztm().a(this.e.w.f);
        }
    }

    public final void resume() {
        throw new IllegalStateException("Native Ad DOES NOT support resume().");
    }

    public final void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
    }

    public final void zza(zzaaw zzaaw) {
        throw new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
    }

    public final void zza(zzod zzod) {
        throw new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
    }

    public final void zza(zzox zzox) {
        if (this.n != null) {
            this.n.zzb(zzox);
        }
    }

    public final void zza(zzoz zzoz) {
        if (this.e.j.k != null) {
            au.i().g().a(this.e.i, this.e.j, new afj(zzoz), null);
        }
    }

    public final void zzcd() {
        gr grVar = this.e.j;
        if (grVar.p == null) {
            super.zzcd();
            return;
        }
        try {
            zzxq zzxq = grVar.p;
            zzlo zzlo = null;
            zzxz zzmo = zzxq.zzmo();
            if (zzmo != null) {
                zzlo = zzmo.getVideoController();
            } else {
                zzyc zzmp = zzxq.zzmp();
                if (zzmp != null) {
                    zzlo = zzmp.getVideoController();
                } else {
                    zzqs zzmt = zzxq.zzmt();
                    if (zzmt != null) {
                        zzlo = zzmt.getVideoController();
                    }
                }
            }
            if (zzlo != null) {
                zzlr zzio = zzlo.zzio();
                if (zzio != null) {
                    zzio.onVideoEnd();
                }
            }
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void zzce() {
        if (this.e.j == null || !"com.google.ads.mediation.admob.AdMobAdapter".equals(this.e.j.q)) {
            super.zzce();
        } else {
            zzbs();
        }
    }

    public final void zzcj() {
        if (this.e.j == null || !"com.google.ads.mediation.admob.AdMobAdapter".equals(this.e.j.q)) {
            super.zzcj();
        } else {
            zzbr();
        }
    }

    public final void zzcr() {
        if (s() && this.h != null) {
            zzaqw zzaqw = null;
            if (this.o != null) {
                zzaqw = this.o;
            } else if (this.n != null) {
                zzaqw = this.n;
            }
            if (zzaqw != null) {
                zzaqw.zza("onSdkImpression", new HashMap());
            }
        }
    }

    public final void zzcs() {
        super.h();
        if (this.o != null) {
            this.o.destroy();
            this.o = null;
        }
    }

    public final void zzct() {
        if (this.n != null) {
            this.n.destroy();
            this.n = null;
        }
    }

    public final boolean zzcu() {
        return t() != null ? t().p : false;
    }

    public final boolean zzcv() {
        return t() != null ? t().q : false;
    }

    public final void zzi(View view) {
        if (this.h != null) {
            au.u().a(this.h, view);
        }
    }

    @Nullable
    public final zzrc zzr(String str) {
        ar.b("getOnCustomClickListener must be called on the main UI thread.");
        return this.e.u == null ? null : (zzrc) this.e.u.get(str);
    }
}
