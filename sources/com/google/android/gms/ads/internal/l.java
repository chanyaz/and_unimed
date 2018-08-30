package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Window;
import com.appnext.base.b.c;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.gmsg.zzai;
import com.google.android.gms.ads.internal.gmsg.zzz;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.k;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.p;
import com.google.android.gms.internal.ads.agc;
import com.google.android.gms.internal.ads.akc;
import com.google.android.gms.internal.ads.amn;
import com.google.android.gms.internal.ads.ana;
import com.google.android.gms.internal.ads.auh;
import com.google.android.gms.internal.ads.aui;
import com.google.android.gms.internal.ads.du;
import com.google.android.gms.internal.ads.eo;
import com.google.android.gms.internal.ads.gi;
import com.google.android.gms.internal.ads.gr;
import com.google.android.gms.internal.ads.gs;
import com.google.android.gms.internal.ads.ht;
import com.google.android.gms.internal.ads.hz;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.nw;
import com.google.android.gms.internal.ads.op;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzaej;
import com.google.android.gms.internal.ads.zzaig;
import com.google.android.gms.internal.ads.zzait;
import com.google.android.gms.internal.ads.zzang;
import com.google.android.gms.internal.ads.zzaqw;
import com.google.android.gms.internal.ads.zzasc;
import com.google.android.gms.internal.ads.zzjj;
import com.google.android.gms.internal.ads.zzjn;
import com.google.android.gms.internal.ads.zzxn;
import java.util.Collections;
import java.util.HashMap;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@zzadh
@ParametersAreNonnullByDefault
public final class l extends bd implements zzai, zzz {
    private transient boolean k = false;
    private int l = -1;
    private boolean m;
    private float n;
    private boolean o;
    private gi p;
    private String q;
    private final String r;
    private final eo s;

    public l(Context context, zzjn zzjn, String str, zzxn zzxn, zzang zzang, br brVar) {
        super(context, zzjn, str, zzxn, zzang, brVar);
        boolean z = zzjn != null && "reward_mb".equals(zzjn.a);
        this.r = z ? "/Rewarded" : "/Interstitial";
        this.s = z ? new eo(this.e, this.j, new n(this), this, this) : null;
    }

    @VisibleForTesting
    private static gs a(gs gsVar) {
        try {
            String jSONObject = du.a(gsVar.b).toString();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, gsVar.a.e);
            auh auh = new auh(jSONObject, null, Collections.singletonList("com.google.ads.mediation.admob.AdMobAdapter"), null, null, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), jSONObject2.toString(), null, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, null, null, null, null, Collections.emptyList(), null, -1);
            zzaej zzaej = gsVar.b;
            aui aui = new aui(Collections.singletonList(auh), ((Long) akc.f().a(amn.bB)).longValue(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), zzaej.H, zzaej.I, "", -1, 0, 1, null, 0, -1, -1, false);
            return new gs(gsVar.a, new zzaej(gsVar.a, zzaej.a, zzaej.b, Collections.emptyList(), Collections.emptyList(), zzaej.f, true, zzaej.h, Collections.emptyList(), zzaej.j, zzaej.k, zzaej.l, zzaej.m, zzaej.n, zzaej.o, zzaej.p, null, zzaej.r, zzaej.s, zzaej.t, zzaej.u, zzaej.v, zzaej.x, zzaej.y, zzaej.z, null, Collections.emptyList(), Collections.emptyList(), zzaej.D, zzaej.E, zzaej.F, zzaej.G, zzaej.H, zzaej.I, zzaej.J, null, zzaej.L, zzaej.M, zzaej.N, zzaej.O, 0, zzaej.Q, Collections.emptyList(), zzaej.S, zzaej.T), aui, gsVar.d, gsVar.e, gsVar.f, gsVar.g, null, gsVar.i, null);
        } catch (Throwable e) {
            kk.b("Unable to generate ad state for an interstitial ad with pooling.", e);
            return gsVar;
        }
    }

    private final void a(Bundle bundle) {
        au.e().b(this.e.c, this.e.e.a, "gmob-apps", bundle, false);
    }

    private final boolean b(boolean z) {
        return this.s != null && z;
    }

    protected final zzaqw a(gs gsVar, @Nullable bs bsVar, @Nullable zzait zzait) {
        au.f();
        zzaqw a = nw.a(this.e.c, op.a(this.e.i), this.e.i.a, false, false, this.e.d, this.e.e, this.a, this, this.i, gsVar.i);
        a.zzuf().zza(this, this, null, this, this, ((Boolean) akc.f().a(amn.ai)).booleanValue(), this, bsVar, this, zzait);
        a(a);
        a.zzdr(gsVar.a.v);
        a.zza("/reward", new com.google.android.gms.ads.internal.gmsg.l(this));
        return a;
    }

    public final void a(gs gsVar, ana ana) {
        Object obj = 1;
        if (gsVar.e != -2) {
            super.a(gsVar, ana);
            return;
        }
        if (b(gsVar.c != null)) {
            this.s.c();
            return;
        }
        if (((Boolean) akc.f().a(amn.aT)).booleanValue()) {
            if (gsVar.b.g) {
                obj = null;
            }
            if (a.a(gsVar.a.c) && obj != null) {
                this.e.k = a(gsVar);
            }
            super.a(this.e.k, ana);
            return;
        }
        super.a(gsVar, ana);
    }

    public final boolean a(@Nullable gr grVar, gr grVar2) {
        if (b(grVar2.n)) {
            return eo.a(grVar, grVar2);
        }
        if (!super.a(grVar, grVar2)) {
            return false;
        }
        if (!(this.e.d() || this.e.H == null || grVar2.k == null)) {
            this.g.a(this.e.i, grVar2, this.e.H);
        }
        b(grVar2, false);
        return true;
    }

    public final boolean a(zzjj zzjj, ana ana) {
        if (this.e.j != null) {
            kk.e("An interstitial is already loading. Aborting.");
            return false;
        }
        if (this.p == null && a.a(zzjj) && au.B().d(this.e.c) && !TextUtils.isEmpty(this.e.b)) {
            this.p = new gi(this.e.c, this.e.b);
        }
        return super.a(zzjj, ana);
    }

    protected final boolean a(zzjj zzjj, gr grVar, boolean z) {
        if (this.e.d() && grVar.b != null) {
            au.g();
            hz.a(grVar.b);
        }
        return this.d.e();
    }

    protected final void b() {
        k();
        super.b();
    }

    protected final void e() {
        zzaqw zzaqw = this.e.j != null ? this.e.j.b : null;
        gs gsVar = this.e.k;
        if (!(gsVar == null || gsVar.b == null || !gsVar.b.Q || zzaqw == null || !au.u().a(this.e.c))) {
            this.h = au.u().a(this.e.e.b + "." + this.e.e.c, zzaqw.getWebView(), "", "javascript", i());
            if (!(this.h == null || zzaqw.getView() == null)) {
                au.u().a(this.h, zzaqw.getView());
                au.u().a(this.h);
            }
        }
        super.e();
        this.k = true;
    }

    protected final boolean j() {
        if (!(this.e.c instanceof Activity)) {
            return false;
        }
        Window window = ((Activity) this.e.c).getWindow();
        if (window == null || window.getDecorView() == null) {
            return false;
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        window.getDecorView().getGlobalVisibleRect(rect, null);
        window.getDecorView().getWindowVisibleDisplayFrame(rect2);
        return (rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top) ? false : true;
    }

    public final void k() {
        au.y().b(Integer.valueOf(this.l));
        if (this.e.d()) {
            this.e.b();
            this.e.j = null;
            this.e.J = false;
            this.k = false;
        }
    }

    public final void setImmersiveMode(boolean z) {
        ar.b("setImmersiveMode must be called on the main UI thread.");
        this.o = z;
    }

    public final void showInterstitial() {
        ar.b("showInterstitial must be called on the main UI thread.");
        boolean z = this.e.j != null && this.e.j.n;
        if (b(z)) {
            this.s.a(this.o);
            return;
        }
        String valueOf;
        if (au.B().d(this.e.c)) {
            this.q = au.B().g(this.e.c);
            String valueOf2 = String.valueOf(this.q);
            valueOf = String.valueOf(this.r);
            this.q = valueOf.length() != 0 ? valueOf2.concat(valueOf) : new String(valueOf2);
        }
        if (this.e.j == null) {
            kk.e("The interstitial has not loaded.");
            return;
        }
        if (((Boolean) akc.f().a(amn.br)).booleanValue()) {
            Bundle bundle;
            valueOf = this.e.c.getApplicationContext() != null ? this.e.c.getApplicationContext().getPackageName() : this.e.c.getPackageName();
            if (!this.k) {
                kk.e("It is not recommended to show an interstitial before onAdLoaded completes.");
                bundle = new Bundle();
                bundle.putString("appid", valueOf);
                bundle.putString(c.jD, "show_interstitial_before_load_finish");
                a(bundle);
            }
            au.e();
            if (!ht.g(this.e.c)) {
                kk.e("It is not recommended to show an interstitial when app is not in foreground.");
                bundle = new Bundle();
                bundle.putString("appid", valueOf);
                bundle.putString(c.jD, "show_interstitial_app_not_in_foreground");
                a(bundle);
            }
        }
        if (!this.e.e()) {
            if (this.e.j.n && this.e.j.p != null) {
                try {
                    if (((Boolean) akc.f().a(amn.aQ)).booleanValue()) {
                        this.e.j.p.setImmersiveMode(this.o);
                    }
                    this.e.j.p.showInterstitial();
                } catch (Throwable e) {
                    kk.c("Could not show interstitial.", e);
                    k();
                }
            } else if (this.e.j.b == null) {
                kk.e("The interstitial failed to load.");
            } else if (this.e.j.b.zzuj()) {
                kk.e("The interstitial is already showing.");
            } else {
                Bitmap h;
                this.e.j.b.zzai(true);
                this.e.a(this.e.j.b.getView());
                if (this.e.j.k != null) {
                    this.g.a(this.e.i, this.e.j);
                }
                if (p.b()) {
                    gr grVar = this.e.j;
                    if (grVar.a()) {
                        new agc(this.e.c, grVar.b.getView()).a(grVar.b);
                    } else {
                        grVar.b.zzuf().zza(new m(this, grVar));
                    }
                }
                if (this.e.J) {
                    au.e();
                    h = ht.h(this.e.c);
                } else {
                    h = null;
                }
                this.l = au.y().a(h);
                if (!((Boolean) akc.f().a(amn.bR)).booleanValue() || h == null) {
                    zzaq zzaq = new zzaq(this.e.J, j(), false, 0.0f, -1, this.o, this.e.j.L, this.e.j.O);
                    int requestedOrientation = this.e.j.b.getRequestedOrientation();
                    if (requestedOrientation == -1) {
                        requestedOrientation = this.e.j.h;
                    }
                    AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(this, this, this, this.e.j.b, requestedOrientation, this.e.e, this.e.j.A, zzaq);
                    au.c();
                    k.a(this.e.c, adOverlayInfoParcel, true);
                    return;
                }
                new o(this, this.l).f();
            }
        }
    }

    public final void zza(boolean z, float f) {
        this.m = z;
        this.n = f;
    }

    public final void zzb(zzaig zzaig) {
        boolean z = this.e.j != null && this.e.j.n;
        if (b(z)) {
            a(this.s.a(zzaig));
            return;
        }
        if (this.e.j != null) {
            if (this.e.j.x != null) {
                au.e();
                ht.a(this.e.c, this.e.e.a, this.e.j.x);
            }
            if (this.e.j.v != null) {
                zzaig = this.e.j.v;
            }
        }
        a(zzaig);
    }

    public final void zzcb() {
        super.zzcb();
        this.g.a(this.e.j);
        if (this.p != null) {
            this.p.a(false);
        }
        h();
    }

    public final void zzcc() {
        recordImpression();
        super.zzcc();
        if (!(this.e.j == null || this.e.j.b == null)) {
            zzasc zzuf = this.e.j.b.zzuf();
            if (zzuf != null) {
                zzuf.zzuz();
            }
        }
        if (!(!au.B().d(this.e.c) || this.e.j == null || this.e.j.b == null)) {
            au.B().c(this.e.j.b.getContext(), this.q);
        }
        if (this.p != null) {
            this.p.a(true);
        }
        if (this.h != null && this.e.j != null && this.e.j.b != null) {
            this.e.j.b.zza("onSdkImpression", new HashMap());
        }
    }

    public final void zzcz() {
        com.google.android.gms.ads.internal.overlay.c zzub = this.e.j.b.zzub();
        if (zzub != null) {
            zzub.a();
        }
    }

    public final void zzd(boolean z) {
        this.e.J = z;
    }

    public final void zzdk() {
        boolean z = this.e.j != null && this.e.j.n;
        if (b(z)) {
            this.s.g();
            f();
            return;
        }
        if (!(this.e.j == null || this.e.j.w == null)) {
            au.e();
            ht.a(this.e.c, this.e.e.a, this.e.j.w);
        }
        f();
    }

    public final void zzdl() {
        boolean z = this.e.j != null && this.e.j.n;
        if (b(z)) {
            this.s.h();
        }
        g();
    }
}
