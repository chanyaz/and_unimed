package com.google.android.gms.internal.ads;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.ads.internal.ay;
import com.google.android.gms.ads.internal.br;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Arrays;
import java.util.Collections;
import org.json.JSONObject;

@zzadh
public final class er extends ay implements zzahu {
    private static er k;
    private boolean l;
    private boolean m;
    @VisibleForTesting
    private final gi n;
    private final eo o = new eo(this.e, this.j, this, this, this);

    public er(Context context, br brVar, zzjn zzjn, zzxn zzxn, zzang zzang) {
        super(context, zzjn, null, zzxn, zzang, brVar);
        k = this;
        this.n = new gi(context, null);
    }

    private static gs a(gs gsVar) {
        hl.a("Creating mediation ad response for non-mediated rewarded ad.");
        try {
            JSONObject a = du.a(gsVar.b);
            a.remove("impression_urls");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, gsVar.a.e);
            String jSONObject2 = jSONObject.toString();
            auh auh = new auh(a.toString(), null, Arrays.asList(new String[]{"com.google.ads.mediation.admob.AdMobAdapter"}), null, null, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), jSONObject2, null, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, null, null, null, null, Collections.emptyList(), null, -1);
            return new gs(gsVar.a, gsVar.b, new aui(Arrays.asList(new auh[]{auh}), ((Long) akc.f().a(amn.bB)).longValue(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), false, "", -1, 0, 1, null, 0, -1, -1, false), gsVar.d, gsVar.e, gsVar.f, gsVar.g, gsVar.h, gsVar.i, null);
        } catch (Throwable e) {
            kk.b("Unable to generate ad state for non-mediated rewarded video.", e);
            return new gs(gsVar.a, gsVar.b, null, gsVar.d, 0, gsVar.f, gsVar.g, gsVar.h, gsVar.i, null);
        }
    }

    public static er j() {
        return k;
    }

    @Nullable
    public final fs a(String str) {
        return this.o.a(str);
    }

    public final void a(Context context) {
        this.o.a(context);
    }

    public final void a(gs gsVar, ana ana) {
        if (gsVar.e != -2) {
            ht.a.post(new et(this, gsVar));
            return;
        }
        this.e.k = gsVar;
        if (gsVar.c == null) {
            this.e.k = a(gsVar);
        }
        this.o.c();
    }

    public final void a(zzahk zzahk) {
        ar.b("loadAd must be called on the main UI thread.");
        if (TextUtils.isEmpty(zzahk.b)) {
            kk.e("Invalid ad unit id. Aborting.");
            ht.a.post(new es(this));
            return;
        }
        this.l = false;
        this.e.b = zzahk.b;
        this.n.a(zzahk.b);
        super.zzb(zzahk.a);
    }

    public final boolean a(gr grVar, gr grVar2) {
        b(grVar2, false);
        return eo.a(grVar, grVar2);
    }

    protected final boolean a(zzjj zzjj, gr grVar, boolean z) {
        return false;
    }

    protected final void b() {
        this.e.j = null;
        super.b();
    }

    public final void destroy() {
        this.o.f();
        super.destroy();
    }

    public final void k() {
        ar.b("showAd must be called on the main UI thread.");
        if (l()) {
            this.o.a(this.m);
        } else {
            kk.e("The reward video has not loaded.");
        }
    }

    public final boolean l() {
        ar.b("isLoaded must be called on the main UI thread.");
        return this.e.g == null && this.e.h == null && this.e.j != null;
    }

    public final void onRewardedVideoAdClosed() {
        if (au.B().e(this.e.c)) {
            this.n.a(false);
        }
        b();
    }

    public final void onRewardedVideoAdLeftApplication() {
        c();
    }

    public final void onRewardedVideoAdOpened() {
        if (au.B().e(this.e.c)) {
            this.n.a(true);
        }
        a(this.e.j, false);
        d();
    }

    public final void onRewardedVideoCompleted() {
        this.o.h();
        g();
    }

    public final void onRewardedVideoStarted() {
        this.o.g();
        f();
    }

    public final void pause() {
        this.o.d();
    }

    public final void resume() {
        this.o.e();
    }

    public final void setImmersiveMode(boolean z) {
        ar.b("setImmersiveMode must be called on the main UI thread.");
        this.m = z;
    }

    public final void zzc(@Nullable zzaig zzaig) {
        zzaig a = this.o.a(zzaig);
        if (au.B().e(this.e.c) && a != null) {
            au.B().a(this.e.c, au.B().j(this.e.c), this.e.b, a.a, a.b);
        }
        a(a);
    }

    public final void zzdm() {
        onAdClicked();
    }
}
