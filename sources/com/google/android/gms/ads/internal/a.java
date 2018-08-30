package com.google.android.gms.ads.internal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.gmsg.zzb;
import com.google.android.gms.ads.internal.gmsg.zzd;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.g;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.internal.ads.afg;
import com.google.android.gms.internal.ads.ajo;
import com.google.android.gms.internal.ads.akc;
import com.google.android.gms.internal.ads.ako;
import com.google.android.gms.internal.ads.amn;
import com.google.android.gms.internal.ads.amy;
import com.google.android.gms.internal.ads.ana;
import com.google.android.gms.internal.ads.ep;
import com.google.android.gms.internal.ads.gn;
import com.google.android.gms.internal.ads.gr;
import com.google.android.gms.internal.ads.gs;
import com.google.android.gms.internal.ads.gt;
import com.google.android.gms.internal.ads.hd;
import com.google.android.gms.internal.ads.hi;
import com.google.android.gms.internal.ads.hl;
import com.google.android.gms.internal.ads.ht;
import com.google.android.gms.internal.ads.kb;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.op;
import com.google.android.gms.internal.ads.zzaaw;
import com.google.android.gms.internal.ads.zzabc;
import com.google.android.gms.internal.ads.zzabm;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzagu;
import com.google.android.gms.internal.ads.zzagx;
import com.google.android.gms.internal.ads.zzahe;
import com.google.android.gms.internal.ads.zzaig;
import com.google.android.gms.internal.ads.zzajs;
import com.google.android.gms.internal.ads.zzhu.zza;
import com.google.android.gms.internal.ads.zzjd;
import com.google.android.gms.internal.ads.zzjj;
import com.google.android.gms.internal.ads.zzjn;
import com.google.android.gms.internal.ads.zzke;
import com.google.android.gms.internal.ads.zzkh;
import com.google.android.gms.internal.ads.zzkx;
import com.google.android.gms.internal.ads.zzla;
import com.google.android.gms.internal.ads.zzlg;
import com.google.android.gms.internal.ads.zzlo;
import com.google.android.gms.internal.ads.zzlu;
import com.google.android.gms.internal.ads.zzms;
import com.google.android.gms.internal.ads.zzmu;
import com.google.android.gms.internal.ads.zzod;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.CountDownLatch;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@zzadh
@ParametersAreNonnullByDefault
public abstract class a extends ako implements zzb, zzd, zzt, zzabm, zzadj, zzajs, zzjd {
    protected ana a;
    protected amy b;
    protected boolean c = false;
    protected final al d;
    protected final av e;
    @Nullable
    protected transient zzjj f;
    protected final afg g;
    @Nullable
    protected IObjectWrapper h;
    protected final br i;
    private amy j;
    private final Bundle k = new Bundle();
    private boolean l = false;

    @VisibleForTesting
    a(av avVar, @Nullable al alVar, br brVar) {
        this.e = avVar;
        this.d = new al(this);
        this.i = brVar;
        au.e().b(this.e.c);
        au.e().c(this.e.c);
        hi.a(this.e.c);
        au.C().a(this.e.c);
        au.i().a(this.e.c, this.e.e);
        au.k().a(this.e.c);
        this.g = au.i().g();
        au.h().a(this.e.c);
        au.E().a(this.e.c);
        if (((Boolean) akc.f().a(amn.cn)).booleanValue()) {
            Timer timer = new Timer();
            timer.schedule(new z(this, new CountDownLatch(((Integer) akc.f().a(amn.cp)).intValue()), timer), 0, ((Long) akc.f().a(amn.co)).longValue());
        }
    }

    @VisibleForTesting
    private static long a(String str) {
        Throwable e;
        int indexOf = str.indexOf("ufe");
        int indexOf2 = str.indexOf(44, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        try {
            return Long.parseLong(str.substring(indexOf + 4, indexOf2));
        } catch (IndexOutOfBoundsException e2) {
            e = e2;
        } catch (NumberFormatException e3) {
            e = e3;
        }
        kk.b("", e);
        return -1;
    }

    protected static boolean a(zzjj zzjj) {
        Bundle bundle = zzjj.m.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        return bundle == null || !bundle.containsKey("gw");
    }

    public final br a() {
        return this.i;
    }

    protected final List<String> a(List<String> list) {
        List arrayList = new ArrayList(list.size());
        for (String b : list) {
            arrayList.add(gn.b(b, this.e.c));
        }
        return arrayList;
    }

    protected void a(int i) {
        a(i, false);
    }

    protected void a(int i, boolean z) {
        kk.e("Failed to load ad: " + i);
        this.c = z;
        if (this.e.n != null) {
            try {
                this.e.n.onAdFailedToLoad(i);
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
            }
        }
        if (this.e.C != null) {
            try {
                this.e.C.onRewardedVideoAdFailedToLoad(i);
            } catch (Throwable e2) {
                kk.d("#007 Could not call remote method.", e2);
            }
        }
    }

    protected final void a(View view) {
        aw awVar = this.e.f;
        if (awVar != null) {
            awVar.addView(view, au.g().d());
        }
    }

    public final void a(amy amy) {
        this.a = new ana(((Boolean) akc.f().a(amn.N)).booleanValue(), "load_ad", this.e.i.a);
        this.j = new amy(-1, null, null);
        if (amy == null) {
            this.b = new amy(-1, null, null);
        } else {
            this.b = new amy(amy.a(), amy.b(), amy.c());
        }
    }

    protected abstract void a(gs gsVar, ana ana);

    public final void a(zzagx zzagx) {
        ar.b("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.e.D = zzagx;
    }

    protected final void a(@Nullable zzaig zzaig) {
        if (this.e.C != null) {
            try {
                String str = "";
                int i = 1;
                if (zzaig != null) {
                    str = zzaig.a;
                    i = zzaig.b;
                }
                zzagu epVar = new ep(str, i);
                this.e.C.zza(epVar);
                if (this.e.D != null) {
                    this.e.D.zza(epVar, this.e.k.a.v);
                }
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
            }
        }
    }

    protected void a(boolean z) {
        hl.a("Ad finished loading.");
        this.c = z;
        this.l = true;
        if (this.e.n != null) {
            try {
                this.e.n.onAdLoaded();
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
            }
        }
        if (this.e.C != null) {
            try {
                this.e.C.onRewardedVideoAdLoaded();
            } catch (Throwable e2) {
                kk.d("#007 Could not call remote method.", e2);
            }
        }
        if (this.e.p != null) {
            try {
                this.e.p.zzt();
            } catch (Throwable e22) {
                kk.d("#007 Could not call remote method.", e22);
            }
        }
    }

    boolean a(gr grVar) {
        return false;
    }

    protected abstract boolean a(@Nullable gr grVar, gr grVar2);

    protected abstract boolean a(zzjj zzjj, ana ana);

    protected final List<String> b(List<String> list) {
        List arrayList = new ArrayList(list.size());
        for (String a : list) {
            arrayList.add(gn.a(a, this.e.c));
        }
        return arrayList;
    }

    protected void b() {
        hl.a("Ad closing.");
        if (this.e.n != null) {
            try {
                this.e.n.onAdClosed();
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
            }
        }
        if (this.e.C != null) {
            try {
                this.e.C.onRewardedVideoAdClosed();
            } catch (Throwable e2) {
                kk.d("#007 Could not call remote method.", e2);
            }
        }
    }

    protected boolean b(zzjj zzjj) {
        if (this.e.f == null) {
            return false;
        }
        ViewParent parent = this.e.f.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        return au.e().a(view, view.getContext());
    }

    protected final void c() {
        hl.a("Ad leaving application.");
        if (this.e.n != null) {
            try {
                this.e.n.onAdLeftApplication();
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
            }
        }
        if (this.e.C != null) {
            try {
                this.e.C.onRewardedVideoAdLeftApplication();
            } catch (Throwable e2) {
                kk.d("#007 Could not call remote method.", e2);
            }
        }
    }

    protected final void d() {
        hl.a("Ad opening.");
        if (this.e.n != null) {
            try {
                this.e.n.onAdOpened();
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
            }
        }
        if (this.e.C != null) {
            try {
                this.e.C.onRewardedVideoAdOpened();
            } catch (Throwable e2) {
                kk.d("#007 Could not call remote method.", e2);
            }
        }
    }

    public void destroy() {
        ar.b("#008 Must be called on the main UI thread.: destroy");
        this.d.a();
        this.g.b(this.e.j);
        av avVar = this.e;
        if (avVar.f != null) {
            avVar.f.b();
        }
        avVar.n = null;
        avVar.p = null;
        avVar.o = null;
        avVar.B = null;
        avVar.q = null;
        avVar.a(false);
        if (avVar.f != null) {
            avVar.f.removeAllViews();
        }
        avVar.b();
        avVar.c();
        avVar.j = null;
    }

    protected void e() {
        a(false);
    }

    protected final void f() {
        if (this.e.C != null) {
            try {
                this.e.C.onRewardedVideoStarted();
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
            }
        }
    }

    protected final void g() {
        if (this.e.C != null) {
            try {
                this.e.C.onRewardedVideoCompleted();
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
            }
        }
    }

    public String getAdUnitId() {
        return this.e.b;
    }

    public zzlo getVideoController() {
        return null;
    }

    protected final void h() {
        if (this.h != null) {
            au.u().b(this.h);
            this.h = null;
        }
    }

    @Nullable
    protected final String i() {
        gs gsVar = this.e.k;
        if (gsVar == null) {
            return "javascript";
        }
        if (gsVar.b == null) {
            return "javascript";
        }
        Object obj = gsVar.b.T;
        if (TextUtils.isEmpty(obj)) {
            return "javascript";
        }
        try {
            return new JSONObject(obj).optInt("media_type", -1) == 0 ? null : "javascript";
        } catch (Throwable e) {
            kk.c("", e);
            return "javascript";
        }
    }

    public final boolean isLoading() {
        return this.c;
    }

    public final boolean isReady() {
        ar.b("#008 Must be called on the main UI thread.: isLoaded");
        return this.e.g == null && this.e.h == null && this.e.j != null;
    }

    public void onAdClicked() {
        if (this.e.j == null) {
            kk.e("Ad state was null when trying to ping click URLs.");
            return;
        }
        kk.b("Pinging click URLs.");
        if (this.e.l != null) {
            this.e.l.b();
        }
        if (this.e.j.c != null) {
            au.e();
            ht.a(this.e.c, this.e.e.a, b(this.e.j.c));
        }
        if (this.e.m != null) {
            try {
                this.e.m.onAdClicked();
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
            }
        }
    }

    public final void onAppEvent(String str, @Nullable String str2) {
        if (this.e.o != null) {
            try {
                this.e.o.onAppEvent(str, str2);
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
            }
        }
    }

    public void pause() {
        ar.b("#008 Must be called on the main UI thread.: pause");
    }

    public void resume() {
        ar.b("#008 Must be called on the main UI thread.: resume");
    }

    public void setImmersiveMode(boolean z) {
        throw new IllegalStateException("#005 Unexpected call to an abstract (unimplemented) method.");
    }

    public void setManualImpressionsEnabled(boolean z) {
        kk.e("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
    }

    public final void setUserId(String str) {
        ar.b("#008 Must be called on the main UI thread.: setUserId");
        this.e.E = str;
    }

    public final void stopLoading() {
        ar.b("#008 Must be called on the main UI thread.: stopLoading");
        this.c = false;
        this.e.a(true);
    }

    public final void zza(gs gsVar) {
        if (!(gsVar.b.m == -1 || TextUtils.isEmpty(gsVar.b.w))) {
            long a = a(gsVar.b.w);
            if (a != -1) {
                amy a2 = this.a.a(a + gsVar.b.m);
                this.a.a(a2, "stc");
            }
        }
        this.a.a(gsVar.b.w);
        this.a.a(this.b, "arf");
        this.j = this.a.a();
        this.a.a("gqi", gsVar.b.x);
        this.e.g = null;
        this.e.k = gsVar;
        gsVar.i.a(new ax(this, gsVar));
        gsVar.i.a(zza.zzb.AD_LOADED);
        a(gsVar, this.a);
    }

    public void zza(zzaaw zzaaw) {
        kk.e("#006 Unexpected call to a deprecated method.");
    }

    public final void zza(zzabc zzabc, String str) {
        kk.e("#006 Unexpected call to a deprecated method.");
    }

    public final void zza(zzahe zzahe) {
        ar.b("#008 Must be called on the main UI thread.: setRewardedVideoAdListener");
        this.e.C = zzahe;
    }

    public final void zza(zzjn zzjn) {
        ar.b("#008 Must be called on the main UI thread.: setAdSize");
        this.e.i = zzjn;
        if (!(this.e.j == null || this.e.j.b == null || this.e.I != 0)) {
            this.e.j.b.zza(op.a(zzjn));
        }
        if (this.e.f != null) {
            if (this.e.f.getChildCount() > 1) {
                this.e.f.removeView(this.e.f.getNextView());
            }
            this.e.f.setMinimumWidth(zzjn.f);
            this.e.f.setMinimumHeight(zzjn.c);
            this.e.f.requestLayout();
        }
    }

    public final void zza(zzke zzke) {
        ar.b("#008 Must be called on the main UI thread.: setAdClickListener");
        this.e.m = zzke;
    }

    public final void zza(zzkh zzkh) {
        ar.b("#008 Must be called on the main UI thread.: setAdListener");
        this.e.n = zzkh;
    }

    public final void zza(zzkx zzkx) {
        this.e.p = zzkx;
    }

    public final void zza(zzla zzla) {
        ar.b("#008 Must be called on the main UI thread.: setAppEventListener");
        this.e.o = zzla;
    }

    public final void zza(zzlg zzlg) {
        ar.b("#008 Must be called on the main UI thread.: setCorrelationIdProvider");
        this.e.q = zzlg;
    }

    public final void zza(@Nullable zzlu zzlu) {
        ar.b("#008 Must be called on the main UI thread.: setIconAdOptions");
        this.e.y = zzlu;
    }

    public final void zza(@Nullable zzmu zzmu) {
        ar.b("#008 Must be called on the main UI thread.: setVideoOptions");
        this.e.x = zzmu;
    }

    public void zza(zzod zzod) {
        throw new IllegalStateException("#005 Unexpected call to an abstract (unimplemented) method.");
    }

    public final void zza(String str, Bundle bundle) {
        this.k.putAll(bundle);
        if (this.l && this.e.p != null) {
            try {
                this.e.p.zzt();
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
            }
        }
    }

    public final void zza(HashSet<gt> hashSet) {
        this.e.a((HashSet) hashSet);
    }

    public void zzb(gr grVar) {
        this.a.a(this.j, "awr");
        this.e.h = null;
        if (!(grVar.d == -2 || grVar.d == 3 || this.e.a() == null)) {
            au.j().a(this.e.a());
        }
        if (grVar.d == -1) {
            this.c = false;
            return;
        }
        if (a(grVar)) {
            kk.b("Ad refresh scheduled.");
        }
        if (grVar.d != -2) {
            if (grVar.d == 3) {
                grVar.K.a(zza.zzb.AD_FAILED_TO_LOAD_NO_FILL);
            } else {
                grVar.K.a(zza.zzb.AD_FAILED_TO_LOAD);
            }
            a(grVar.d);
            return;
        }
        if (this.e.G == null) {
            this.e.G = new hd(this.e.b);
        }
        if (this.e.f != null) {
            this.e.f.a().d(grVar.B);
        }
        this.g.a(this.e.j);
        if (a(this.e.j, grVar)) {
            this.e.j = grVar;
            av avVar = this.e;
            if (avVar.l != null) {
                if (avVar.j != null) {
                    avVar.l.a(avVar.j.y);
                    avVar.l.b(avVar.j.z);
                    avVar.l.b(avVar.j.n);
                }
                avVar.l.a(avVar.i.d);
            }
            this.a.a("is_mraid", this.e.j.a() ? "1" : "0");
            this.a.a("is_mediation", this.e.j.n ? "1" : "0");
            if (!(this.e.j.b == null || this.e.j.b.zzuf() == null)) {
                this.a.a("is_delay_pl", this.e.j.b.zzuf().zzux() ? "1" : "0");
            }
            this.a.a(this.b, "ttc");
            if (au.i().b() != null) {
                au.i().b().a(this.a);
            }
            zzbv();
            if (this.e.d()) {
                e();
            }
        }
        if (grVar.J != null) {
            au.e().a(this.e.c, grVar.J);
        }
    }

    public boolean zzb(zzjj zzjj) {
        ar.b("#008 Must be called on the main UI thread.: loadAd");
        au.k().a();
        this.k.clear();
        this.l = false;
        if (((Boolean) akc.f().a(amn.aN)).booleanValue()) {
            zzjj = zzjj.a();
            if (((Boolean) akc.f().a(amn.aO)).booleanValue()) {
                zzjj.c.putBoolean(AdMobAdapter.NEW_BUNDLE, true);
            }
        }
        if (g.c(this.e.c) && zzjj.k != null) {
            zzjj = new ajo(zzjj).a(null).a();
        }
        if (this.e.g == null && this.e.h == null) {
            kk.d("Starting ad request.");
            a(null);
            this.b = this.a.a();
            if (zzjj.f) {
                kk.d("This request is sent from a test device.");
            } else {
                akc.a();
                String a = kb.a(this.e.c);
                kk.d(new StringBuilder(String.valueOf(a).length() + 71).append("Use AdRequest.Builder.addTestDevice(\"").append(a).append("\") to get test ads on this device.").toString());
            }
            this.d.a(zzjj);
            this.c = a(zzjj, this.a);
            return this.c;
        }
        if (this.f != null) {
            kk.e("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
        } else {
            kk.e("Loading already in progress, saving this object for future refreshes.");
        }
        this.f = zzjj;
        return false;
    }

    public final Bundle zzba() {
        return this.l ? this.k : new Bundle();
    }

    public final IObjectWrapper zzbj() {
        ar.b("#008 Must be called on the main UI thread.: getAdFrame");
        return c.a(this.e.f);
    }

    @Nullable
    public final zzjn zzbk() {
        ar.b("#008 Must be called on the main UI thread.: getAdSize");
        return this.e.i == null ? null : new zzms(this.e.i);
    }

    public final void zzbl() {
        c();
    }

    public final void zzbm() {
        ar.b("#008 Must be called on the main UI thread.: recordManualImpression");
        if (this.e.j == null) {
            kk.e("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        kk.b("Pinging manual tracking URLs.");
        if (!this.e.j.H) {
            List arrayList = new ArrayList();
            if (this.e.j.g != null) {
                arrayList.addAll(this.e.j.g);
            }
            if (!(this.e.j.o == null || this.e.j.o.i == null)) {
                arrayList.addAll(this.e.j.o.i);
            }
            if (!arrayList.isEmpty()) {
                au.e();
                ht.a(this.e.c, this.e.e.a, arrayList);
                this.e.j.H = true;
            }
        }
    }

    public final void zzbr() {
        kk.d("Ad impression.");
        if (this.e.n != null) {
            try {
                this.e.n.onAdImpression();
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
            }
        }
    }

    public final void zzbs() {
        kk.d("Ad clicked.");
        if (this.e.n != null) {
            try {
                this.e.n.onAdClicked();
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
            }
        }
    }

    public final void zzbv() {
        gr grVar = this.e.j;
        if (grVar != null && !TextUtils.isEmpty(grVar.B) && !grVar.I && au.o().b()) {
            kk.b("Sending troubleshooting signals to the server.");
            au.o().b(this.e.c, this.e.e.a, grVar.B, this.e.b);
            grVar.I = true;
        }
    }

    public final zzla zzbw() {
        return this.e.o;
    }

    public final zzkh zzbx() {
        return this.e.n;
    }
}
