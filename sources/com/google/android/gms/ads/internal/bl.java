package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.internal.ads.ad;
import com.google.android.gms.internal.ads.ana;
import com.google.android.gms.internal.ads.ano;
import com.google.android.gms.internal.ads.anq;
import com.google.android.gms.internal.ads.anv;
import com.google.android.gms.internal.ads.anx;
import com.google.android.gms.internal.ads.aui;
import com.google.android.gms.internal.ads.gr;
import com.google.android.gms.internal.ads.gs;
import com.google.android.gms.internal.ads.ht;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzang;
import com.google.android.gms.internal.ads.zzaqw;
import com.google.android.gms.internal.ads.zzjj;
import com.google.android.gms.internal.ads.zzjn;
import com.google.android.gms.internal.ads.zzlo;
import com.google.android.gms.internal.ads.zzod;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zzoz;
import com.google.android.gms.internal.ads.zzpa;
import com.google.android.gms.internal.ads.zzpb;
import com.google.android.gms.internal.ads.zzqs;
import com.google.android.gms.internal.ads.zzrc;
import com.google.android.gms.internal.ads.zzxn;
import com.google.android.gms.internal.ads.zzxz;
import com.google.android.gms.internal.ads.zzyc;
import com.google.android.gms.internal.ads.zzyf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class bl extends ay implements zzpa {
    private boolean k;
    private gr l;
    private boolean m = false;

    public bl(Context context, br brVar, zzjn zzjn, String str, zzxn zzxn, zzang zzang) {
        super(context, zzjn, str, zzxn, zzang, brVar);
    }

    private static gr a(gs gsVar, int i) {
        return new gr(gsVar.a.c, null, gsVar.b.c, i, gsVar.b.e, gsVar.b.i, gsVar.b.k, gsVar.b.j, gsVar.a.i, gsVar.b.g, null, null, null, gsVar.c, null, gsVar.b.h, gsVar.d, gsVar.b.f, gsVar.f, gsVar.g, gsVar.b.n, gsVar.h, null, gsVar.b.A, gsVar.b.B, gsVar.b.B, gsVar.b.D, gsVar.b.E, null, gsVar.b.H, gsVar.b.L, gsVar.i, gsVar.b.O, gsVar.j, gsVar.b.Q, gsVar.b.R, gsVar.b.S, gsVar.b.T);
    }

    private final void a(anv anv) {
        ht.a.post(new bn(this, anv));
    }

    private final boolean b(gr grVar, gr grVar2) {
        c(null);
        if (this.e.d()) {
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
                            ht.a.post(new bo(this, ano));
                        }
                    }
                    if (zzmp != null && this.e.t != null) {
                        anv = new anv(zzmp.getHeadline(), zzmp.getImages(), zzmp.getBody(), zzmp.zzkg() != null ? zzmp.zzkg() : null, zzmp.getCallToAction(), zzmp.getAdvertiser(), -1.0d, null, null, null, zzmp.getVideoController(), zzmp.zzmw() != null ? (View) c.a(zzmp.zzmw()) : null, zzmp.zzke(), b, zzmp.getExtras());
                        anv.zzb(new anx(this.e.c, (zzpa) this, this.e.d, zzmp, (zzpb) anv));
                        a(anv);
                    } else if (zzmp != null && this.e.s != null) {
                        anq anq = new anq(zzmp.getHeadline(), zzmp.getImages(), zzmp.getBody(), zzmp.zzkg() != null ? zzmp.zzkg() : null, zzmp.getCallToAction(), zzmp.getAdvertiser(), null, zzmp.getExtras(), zzmp.getVideoController(), zzmp.zzmw() != null ? (View) c.a(zzmp.zzmw()) : null, zzmp.zzke(), b);
                        anq.zzb(new anx(this.e.c, (zzpa) this, this.e.d, zzmp, (zzpb) anq));
                        ht.a.post(new bp(this, anq));
                    } else if (zzmt == null || this.e.v == null || this.e.v.get(zzmt.getCustomTemplateId()) == null) {
                        kk.e("No matching mapper/listener for retrieved native ad template.");
                        a(0);
                        return false;
                    } else {
                        ht.a.post(new bq(this, zzmt));
                    }
                } else {
                    anv = new anv(zzmu.getHeadline(), zzmu.getImages(), zzmu.getBody(), zzmu.zzjz() != null ? zzmu.zzjz() : null, zzmu.getCallToAction(), zzmu.getAdvertiser(), zzmu.getStarRating(), zzmu.getStore(), zzmu.getPrice(), null, zzmu.getVideoController(), zzmu.zzmw() != null ? (View) c.a(zzmu.zzmw()) : null, zzmu.zzke(), b, zzmu.getExtras());
                    anv.zzb(new anx(this.e.c, (zzpa) this, this.e.d, zzmu, (zzpb) anv));
                    a(anv);
                }
                return super.a(grVar, grVar2);
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
                a(0);
                return false;
            }
        }
        kk.e("Native ad does not have custom rendering mode.");
        a(0);
        return false;
    }

    private final boolean c(gr grVar, gr grVar2) {
        View a = r.a(grVar2);
        if (a == null) {
            return false;
        }
        View nextView = this.e.f.getNextView();
        if (nextView != null) {
            if (nextView instanceof zzaqw) {
                ((zzaqw) nextView).destroy();
            }
            this.e.f.removeView(nextView);
        }
        if (!r.b(grVar2)) {
            try {
                a(a);
            } catch (Throwable th) {
                au.i().a(th, "AdLoaderManager.swapBannerViews");
                kk.c("Could not add mediation view to view hierarchy.", th);
                return false;
            }
        }
        if (this.e.f.getChildCount() > 1) {
            this.e.f.showNext();
        }
        if (grVar != null) {
            View nextView2 = this.e.f.getNextView();
            if (nextView2 != null) {
                this.e.f.removeView(nextView2);
            }
            this.e.c();
        }
        this.e.f.setMinimumWidth(zzbk().f);
        this.e.f.setMinimumHeight(zzbk().c);
        this.e.f.requestLayout();
        this.e.f.setVisibility(0);
        return true;
    }

    @Nullable
    private final aui j() {
        return (this.e.j == null || !this.e.j.n) ? null : this.e.j.r;
    }

    protected final void a(@Nullable IObjectWrapper iObjectWrapper) {
        Object a = iObjectWrapper != null ? c.a(iObjectWrapper) : null;
        if (a instanceof zzoz) {
            ((zzoz) a).zzkl();
        }
        super.b(this.e.j, false);
    }

    public final void a(gs gsVar, ana ana) {
        this.l = null;
        if (gsVar.e != -2) {
            this.l = a(gsVar, gsVar.e);
        } else if (!gsVar.b.g) {
            kk.e("partialAdState is not mediation");
            this.l = a(gsVar, 0);
        }
        if (this.l != null) {
            ht.a.post(new bm(this));
            return;
        }
        if (gsVar.d != null) {
            this.e.i = gsVar.d;
        }
        this.e.I = 0;
        av avVar = this.e;
        au.d();
        avVar.h = ad.a(this.e.c, this, gsVar, this.e.d, null, this.j, this, ana);
    }

    protected final boolean a(@Nullable gr grVar, gr grVar2) {
        if (!this.e.d()) {
            throw new IllegalStateException("AdLoader API does not support custom rendering.");
        } else if (grVar2.n) {
            if (grVar2.o != null && grVar2.o.a()) {
                boolean z;
                if (this.e.d() && this.e.f != null) {
                    this.e.f.a().c(grVar2.A);
                }
                if (!super.a(grVar, grVar2)) {
                    z = false;
                } else if (!this.e.d() || c(grVar, grVar2)) {
                    if (!this.e.e()) {
                        super.a(grVar2, false);
                    }
                    z = true;
                } else {
                    a(0);
                    z = false;
                }
                if (!z) {
                    return false;
                }
                this.m = true;
            } else if (grVar2.o == null || !grVar2.o.b()) {
                a(0);
                kk.e("Response is neither banner nor native.");
                return false;
            } else if (!b(grVar, grVar2)) {
                return false;
            }
            d(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(2)})));
            return true;
        } else {
            a(0);
            kk.e("newState is not mediation.");
            return false;
        }
    }

    protected final boolean a(zzjj zzjj, gr grVar, boolean z) {
        return false;
    }

    public final void c(@Nullable List<String> list) {
        ar.b("setNativeTemplates must be called on the main UI thread.");
        this.e.F = list;
    }

    public final void d(List<Integer> list) {
        ar.b("setAllowedAdTypes must be called on the main UI thread.");
        this.e.A = list;
    }

    protected final void e() {
        super.e();
        gr grVar = this.e.j;
        if (grVar != null && grVar.o != null && grVar.o.a() && this.e.z != null) {
            try {
                this.e.z.zza(this, c.a(this.e.c));
                super.b(this.e.j, false);
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
            }
        }
    }

    @Nullable
    public final zzlo getVideoController() {
        return null;
    }

    public final void pause() {
        if (this.m) {
            super.pause();
            return;
        }
        throw new IllegalStateException("Native Ad does not support pause().");
    }

    public final void resume() {
        if (this.m) {
            super.resume();
            return;
        }
        throw new IllegalStateException("Native Ad does not support resume().");
    }

    public final void setManualImpressionsEnabled(boolean z) {
        ar.b("setManualImpressionsEnabled must be called from the main thread.");
        this.k = z;
    }

    public final void showInterstitial() {
        throw new IllegalStateException("Interstitial is not supported by AdLoaderManager.");
    }

    public final void zza(zzod zzod) {
        throw new IllegalStateException("CustomRendering is not supported by AdLoaderManager.");
    }

    public final void zza(zzox zzox) {
        kk.d("#005 Unexpected call to an abstract (unimplemented) method.", null);
    }

    public final void zza(zzoz zzoz) {
        kk.d("#005 Unexpected call to an abstract (unimplemented) method.", null);
    }

    public final boolean zzb(zzjj zzjj) {
        Object obj = (this.e.A != null && this.e.A.size() == 1 && ((Integer) this.e.A.get(0)).intValue() == 2) ? 1 : null;
        if (obj != null) {
            kk.c("Requesting only banner Ad from AdLoader or calling loadAd on returned banner is not yet supported");
            a(0);
            return false;
        } else if (this.e.z == null) {
            return super.zzb(zzjj);
        } else {
            if (zzjj.h != this.k) {
                int i = zzjj.a;
                long j = zzjj.b;
                Bundle bundle = zzjj.c;
                int i2 = zzjj.d;
                List list = zzjj.e;
                boolean z = zzjj.f;
                int i3 = zzjj.g;
                boolean z2 = zzjj.h || this.k;
                zzjj = new zzjj(i, j, bundle, i2, list, z, i3, z2, zzjj.i, zzjj.j, zzjj.k, zzjj.l, zzjj.m, zzjj.n, zzjj.o, zzjj.p, zzjj.q, zzjj.r);
            }
            return super.zzb(zzjj);
        }
    }

    public final void zzce() {
        if (this.e.j == null || !"com.google.ads.mediation.admob.AdMobAdapter".equals(this.e.j.q) || this.e.j.o == null || !this.e.j.o.b()) {
            super.zzce();
        } else {
            zzbs();
        }
    }

    public final void zzcj() {
        if (this.e.j == null || !"com.google.ads.mediation.admob.AdMobAdapter".equals(this.e.j.q) || this.e.j.o == null || !this.e.j.o.b()) {
            super.zzcj();
        } else {
            zzbr();
        }
    }

    public final void zzcr() {
        kk.d("#005 Unexpected call to an abstract (unimplemented) method.", null);
    }

    public final void zzcs() {
        kk.d("#005 Unexpected call to an abstract (unimplemented) method.", null);
    }

    public final void zzct() {
        kk.d("#005 Unexpected call to an abstract (unimplemented) method.", null);
    }

    public final boolean zzcu() {
        return j() != null ? j().p : false;
    }

    public final boolean zzcv() {
        return j() != null ? j().q : false;
    }

    public final void zzi(View view) {
        kk.d("#005 Unexpected call to an abstract (unimplemented) method.", null);
    }

    @Nullable
    public final zzrc zzr(String str) {
        ar.b("getOnCustomClickListener must be called on the main UI thread.");
        return (zzrc) this.e.u.get(str);
    }
}
