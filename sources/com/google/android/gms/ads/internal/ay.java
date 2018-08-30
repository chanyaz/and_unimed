package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.common.a.c;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.agt;
import com.google.android.gms.internal.ads.aib;
import com.google.android.gms.internal.ads.akc;
import com.google.android.gms.internal.ads.amn;
import com.google.android.gms.internal.ads.ana;
import com.google.android.gms.internal.ads.ary;
import com.google.android.gms.internal.ads.aup;
import com.google.android.gms.internal.ads.bw;
import com.google.android.gms.internal.ads.cp;
import com.google.android.gms.internal.ads.de;
import com.google.android.gms.internal.ads.gr;
import com.google.android.gms.internal.ads.gt;
import com.google.android.gms.internal.ads.gv;
import com.google.android.gms.internal.ads.hg;
import com.google.android.gms.internal.ads.hr;
import com.google.android.gms.internal.ads.ht;
import com.google.android.gms.internal.ads.hz;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.kq;
import com.google.android.gms.internal.ads.lf;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzang;
import com.google.android.gms.internal.ads.zzaqw;
import com.google.android.gms.internal.ads.zzhu.zza.zzb;
import com.google.android.gms.internal.ads.zzjj;
import com.google.android.gms.internal.ads.zzjn;
import com.google.android.gms.internal.ads.zzlu;
import com.google.android.gms.internal.ads.zzpl;
import com.google.android.gms.internal.ads.zzqs;
import com.google.android.gms.internal.ads.zzrc;
import com.google.android.gms.internal.ads.zzwz;
import com.google.android.gms.internal.ads.zzxn;
import com.mopub.mobileads.VastIconXmlManager;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzadh
@ParametersAreNonnullByDefault
public abstract class ay extends a implements zzn, zzbo, zzwz {
    protected final zzxn j;
    private transient boolean k;

    public ay(Context context, zzjn zzjn, String str, zzxn zzxn, zzang zzang, br brVar) {
        this(new av(context, zzjn, str, zzang), zzxn, null, brVar);
    }

    @VisibleForTesting
    private ay(av avVar, zzxn zzxn, @Nullable al alVar, br brVar) {
        super(avVar, null, brVar);
        this.j = zzxn;
        this.k = false;
    }

    private final cp a(zzjj zzjj, Bundle bundle, gv gvVar, int i) {
        PackageInfo b;
        int i2;
        int i3;
        ApplicationInfo applicationInfo = this.e.c.getApplicationInfo();
        try {
            b = c.b(this.e.c).b(applicationInfo.packageName, 0);
        } catch (NameNotFoundException e) {
            b = null;
        }
        DisplayMetrics displayMetrics = this.e.c.getResources().getDisplayMetrics();
        Bundle bundle2 = null;
        if (!(this.e.f == null || this.e.f.getParent() == null)) {
            int[] iArr = new int[2];
            this.e.f.getLocationOnScreen(iArr);
            i2 = iArr[0];
            int i4 = iArr[1];
            int width = this.e.f.getWidth();
            int height = this.e.f.getHeight();
            i3 = 0;
            if (this.e.f.isShown() && i2 + width > 0 && i4 + height > 0 && i2 <= displayMetrics.widthPixels && i4 <= displayMetrics.heightPixels) {
                i3 = 1;
            }
            bundle2 = new Bundle(5);
            bundle2.putInt("x", i2);
            bundle2.putInt("y", i4);
            bundle2.putInt(VastIconXmlManager.WIDTH, width);
            bundle2.putInt(VastIconXmlManager.HEIGHT, height);
            bundle2.putInt("visible", i3);
        }
        String a = au.i().a().a();
        this.e.l = new gt(a, this.e.b);
        this.e.l.a(zzjj);
        au.e();
        String a2 = ht.a(this.e.c, this.e.f, this.e.i);
        long j = 0;
        if (this.e.q != null) {
            try {
                j = this.e.q.getValue();
            } catch (RemoteException e2) {
                kk.e("Cannot get correlation id, default to 0.");
            }
        }
        String uuid = UUID.randomUUID().toString();
        Bundle a3 = au.j().a(this.e.c, this, a);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        i3 = 0;
        while (true) {
            i2 = i3;
            if (i2 >= this.e.v.size()) {
                break;
            }
            String str = (String) this.e.v.b(i2);
            arrayList.add(str);
            if (this.e.u.containsKey(str) && this.e.u.get(str) != null) {
                arrayList2.add(str);
            }
            i3 = i2 + 1;
        }
        Future a4 = hr.a(new bb(this));
        Future a5 = hr.a(new bc(this));
        String str2 = null;
        if (gvVar != null) {
            str2 = gvVar.c();
        }
        String str3 = null;
        if (this.e.F != null && this.e.F.size() > 0) {
            i3 = 0;
            if (b != null) {
                i3 = b.versionCode;
            }
            if (i3 > au.i().l().g()) {
                au.i().l().m();
                au.i().l().a(i3);
            } else {
                JSONObject l = au.i().l().l();
                if (l != null) {
                    JSONArray optJSONArray = l.optJSONArray(this.e.b);
                    if (optJSONArray != null) {
                        str3 = optJSONArray.toString();
                    }
                }
            }
        }
        zzjn zzjn = this.e.i;
        String str4 = this.e.b;
        String c = akc.c();
        zzang zzang = this.e.e;
        List list = this.e.F;
        boolean a6 = au.i().l().a();
        int i5 = displayMetrics.widthPixels;
        int i6 = displayMetrics.heightPixels;
        float f = displayMetrics.density;
        List a7 = amn.a();
        String str5 = this.e.a;
        zzpl zzpl = this.e.w;
        String f2 = this.e.f();
        float a8 = au.D().a();
        boolean b2 = au.D().b();
        au.e();
        int i7 = ht.i(this.e.c);
        au.e();
        int d = ht.d(this.e.f);
        boolean z = this.e.c instanceof Activity;
        boolean f3 = au.i().l().f();
        boolean d2 = au.i().d();
        int a9 = au.z().a();
        au.e();
        Bundle c2 = ht.c();
        String a10 = au.o().a();
        zzlu zzlu = this.e.y;
        boolean b3 = au.o().b();
        Bundle j2 = ary.a().j();
        boolean e3 = au.i().l().e(this.e.b);
        List list2 = this.e.A;
        boolean a11 = c.b(this.e.c).a();
        boolean e4 = au.i().e();
        au.g();
        return new cp(bundle2, zzjj, zzjn, str4, applicationInfo, b, a, c, zzang, a3, list, arrayList, bundle, a6, i5, i6, f, a2, j, uuid, a7, str5, zzpl, f2, a8, b2, i7, d, z, f3, a4, str2, d2, a9, c2, a10, zzlu, b3, j2, e3, a5, list2, str3, arrayList2, i, a11, e4, hz.e(), (ArrayList) kq.a(au.i().n(), null, 1000, TimeUnit.MILLISECONDS));
    }

    @Nullable
    static String b(gr grVar) {
        if (grVar == null) {
            return null;
        }
        String str = grVar.q;
        Object obj = ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) ? 1 : null;
        if (obj == null || grVar.o == null) {
            return str;
        }
        try {
            return new JSONObject(grVar.o.k).getString("class_name");
        } catch (JSONException e) {
            return str;
        } catch (NullPointerException e2) {
            return str;
        }
    }

    protected void a(@Nullable gr grVar, boolean z) {
        if (grVar == null) {
            kk.e("Ad state was null when trying to ping impression URLs.");
            return;
        }
        if (grVar == null) {
            kk.e("Ad state was null when trying to ping impression URLs.");
        } else {
            kk.b("Pinging Impression URLs.");
            if (this.e.l != null) {
                this.e.l.a();
            }
            grVar.K.a(zzb.AD_IMPRESSION);
            if (!(grVar.e == null || grVar.D)) {
                au.e();
                ht.a(this.e.c, this.e.e.a, b(grVar.e));
                grVar.D = true;
            }
        }
        if (!grVar.F || z) {
            if (!(grVar.r == null || grVar.r.d == null)) {
                au.x();
                aup.a(this.e.c, this.e.e.a, grVar, this.e.b, z, b(grVar.r.d));
            }
            if (!(grVar.o == null || grVar.o.g == null)) {
                au.x();
                aup.a(this.e.c, this.e.e.a, grVar, this.e.b, z, grVar.o.g);
            }
            grVar.F = true;
        }
    }

    public final boolean a(cp cpVar, ana ana) {
        this.a = ana;
        ana.a("seq_num", cpVar.g);
        ana.a("request_id", cpVar.v);
        ana.a("session_id", cpVar.h);
        if (cpVar.f != null) {
            ana.a("app_version", String.valueOf(cpVar.f.versionCode));
        }
        av avVar = this.e;
        au.a();
        Context context = this.e.c;
        aib aib = this.i.d;
        hg deVar = cpVar.b.c.getBundle("sdk_less_server_data") != null ? new de(context, cpVar, this, aib) : new bw(context, cpVar, this, aib);
        deVar.f();
        avVar.g = deVar;
        return true;
    }

    final boolean a(gr grVar) {
        zzjj zzjj;
        boolean z = false;
        if (this.f != null) {
            zzjj = this.f;
            this.f = null;
        } else {
            zzjj = grVar.a;
            if (zzjj.c != null) {
                z = zzjj.c.getBoolean("_noRefresh", false);
            }
        }
        return a(zzjj, grVar, z);
    }

    protected boolean a(@Nullable gr grVar, gr grVar2) {
        int i;
        int i2 = 0;
        if (!(grVar == null || grVar.s == null)) {
            grVar.s.a(null);
        }
        if (grVar2.s != null) {
            grVar2.s.a((zzwz) this);
        }
        if (grVar2.r != null) {
            i = grVar2.r.r;
            i2 = grVar2.r.s;
        } else {
            i = 0;
        }
        this.e.G.a(i, i2);
        return true;
    }

    public boolean a(zzjj zzjj, ana ana) {
        return a(zzjj, ana, 1);
    }

    public final boolean a(zzjj zzjj, ana ana, int i) {
        if (!r()) {
            return false;
        }
        gv h;
        au.e();
        agt a = au.i().a(this.e.c);
        Bundle a2 = a == null ? null : ht.a(a);
        this.d.a();
        this.e.I = 0;
        if (((Boolean) akc.f().a(amn.cs)).booleanValue()) {
            h = au.i().l().h();
            au.m().a(this.e.c, this.e.e, false, h, h != null ? h.d() : null, this.e.b, null);
        } else {
            h = null;
        }
        return a(a(zzjj, a2, h, i), ana);
    }

    protected boolean a(zzjj zzjj, gr grVar, boolean z) {
        if (!z && this.e.d()) {
            if (grVar.i > 0) {
                this.d.a(zzjj, grVar.i);
            } else if (grVar.r != null && grVar.r.j > 0) {
                this.d.a(zzjj, grVar.r.j);
            } else if (!grVar.n && grVar.d == 2) {
                this.d.b(zzjj);
            }
        }
        return this.d.e();
    }

    protected final void b(@Nullable gr grVar, boolean z) {
        if (grVar != null) {
            if (!(grVar == null || grVar.f == null || grVar.E)) {
                au.e();
                ht.a(this.e.c, this.e.e.a, a(grVar.f));
                grVar.E = true;
            }
            if (!grVar.G || z) {
                if (!(grVar.r == null || grVar.r.e == null)) {
                    au.x();
                    aup.a(this.e.c, this.e.e.a, grVar, this.e.b, z, a(grVar.r.e));
                }
                if (!(grVar.o == null || grVar.o.h == null)) {
                    au.x();
                    aup.a(this.e.c, this.e.e.a, grVar, this.e.b, z, grVar.o.h);
                }
                grVar.G = true;
            }
        }
    }

    protected final boolean b(zzjj zzjj) {
        return super.b(zzjj) && !this.k;
    }

    @Nullable
    public final String getMediationAdapterClassName() {
        return this.e.j == null ? null : this.e.j.q;
    }

    public void onAdClicked() {
        if (this.e.j == null) {
            kk.e("Ad state was null when trying to ping click URLs.");
            return;
        }
        if (!(this.e.j.r == null || this.e.j.r.c == null)) {
            au.x();
            aup.a(this.e.c, this.e.e.a, this.e.j, this.e.b, false, b(this.e.j.r.c));
        }
        if (!(this.e.j.o == null || this.e.j.o.f == null)) {
            au.x();
            aup.a(this.e.c, this.e.e.a, this.e.j, this.e.b, false, this.e.j.o.f);
        }
        super.onAdClicked();
    }

    public final void onPause() {
        this.g.c(this.e.j);
    }

    public final void onResume() {
        this.g.d(this.e.j);
    }

    public void pause() {
        ar.b("pause must be called on the main UI thread.");
        if (!(this.e.j == null || this.e.j.b == null || !this.e.d())) {
            au.g();
            hz.a(this.e.j.b);
        }
        if (!(this.e.j == null || this.e.j.p == null)) {
            try {
                this.e.j.p.pause();
            } catch (RemoteException e) {
                kk.e("Could not pause mediation adapter.");
            }
        }
        this.g.c(this.e.j);
        this.d.b();
    }

    protected boolean r() {
        au.e();
        if (ht.a(this.e.c, "android.permission.INTERNET")) {
            au.e();
            if (ht.a(this.e.c)) {
                return true;
            }
        }
        return false;
    }

    public final void recordImpression() {
        a(this.e.j, false);
    }

    public void resume() {
        ar.b("resume must be called on the main UI thread.");
        zzaqw zzaqw = null;
        if (!(this.e.j == null || this.e.j.b == null)) {
            zzaqw = this.e.j.b;
        }
        if (zzaqw != null && this.e.d()) {
            au.g();
            hz.b(this.e.j.b);
        }
        if (!(this.e.j == null || this.e.j.p == null)) {
            try {
                this.e.j.p.resume();
            } catch (RemoteException e) {
                kk.e("Could not resume mediation adapter.");
            }
        }
        if (zzaqw == null || !zzaqw.zzum()) {
            this.d.c();
        }
        this.g.d(this.e.j);
    }

    public void showInterstitial() {
        kk.e("showInterstitial is not supported for current ad type");
    }

    public final void zza(zzqs zzqs, String str) {
        Object customTemplateId;
        zzrc zzrc = null;
        if (zzqs != null) {
            try {
                customTemplateId = zzqs.getCustomTemplateId();
            } catch (Throwable e) {
                kk.c("Unable to call onCustomClick.", e);
                return;
            }
        }
        customTemplateId = null;
        if (!(this.e.u == null || customTemplateId == null)) {
            zzrc = (zzrc) this.e.u.get(customTemplateId);
        }
        if (zzrc == null) {
            kk.e("Mediation adapter invoked onCustomClick but no listeners were set.");
        } else {
            zzrc.zzb(zzqs, str);
        }
    }

    public final void zzb(gr grVar) {
        super.zzb(grVar);
        if (grVar.o != null) {
            kk.b("Disable the debug gesture detector on the mediation ad frame.");
            if (this.e.f != null) {
                this.e.f.d();
            }
            kk.b("Pinging network fill URLs.");
            au.x();
            aup.a(this.e.c, this.e.e.a, grVar, this.e.b, false, grVar.o.j);
            if (!(grVar.r == null || grVar.r.g == null || grVar.r.g.size() <= 0)) {
                kk.b("Pinging urls remotely");
                au.e().a(this.e.c, grVar.r.g);
            }
        } else {
            kk.b("Enable the debug gesture detector on the admob ad frame.");
            if (this.e.f != null) {
                this.e.f.c();
            }
        }
        if (grVar.d == 3 && grVar.r != null && grVar.r.f != null) {
            kk.b("Pinging no fill URLs.");
            au.x();
            aup.a(this.e.c, this.e.e.a, grVar, this.e.b, false, grVar.r.f);
        }
    }

    public final void zzb(String str, String str2) {
        onAppEvent(str, str2);
    }

    public void zzcb() {
        this.k = false;
        b();
        this.e.l.c();
    }

    public void zzcc() {
        this.k = true;
        d();
    }

    public void zzcd() {
        kk.e("Mediated ad does not support onVideoEnd callback");
    }

    public void zzce() {
        onAdClicked();
    }

    public final void zzcf() {
        zzcb();
    }

    public final void zzcg() {
        c();
    }

    public final void zzch() {
        zzcc();
    }

    public final void zzci() {
        if (this.e.j != null) {
            String str = this.e.j.q;
            kk.e(new StringBuilder(String.valueOf(str).length() + 74).append("Mediation adapter ").append(str).append(" refreshed, but mediation adapters should never refresh.").toString());
        }
        a(this.e.j, true);
        b(this.e.j, true);
        e();
    }

    public void zzcj() {
        recordImpression();
    }

    @Nullable
    public final String zzck() {
        return this.e.j == null ? null : b(this.e.j);
    }

    public final void zzcl() {
        Executor executor = lf.a;
        al alVar = this.d;
        alVar.getClass();
        executor.execute(az.a(alVar));
    }

    public final void zzcm() {
        Executor executor = lf.a;
        al alVar = this.d;
        alVar.getClass();
        executor.execute(ba.a(alVar));
    }
}
