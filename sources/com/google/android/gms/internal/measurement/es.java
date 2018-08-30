package com.google.android.gms.internal.measurement;

import android.app.Application;
import android.content.Context;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.a.c;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.f;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.atomic.AtomicReference;

public class es extends hw implements zzhi {
    private static volatile es d;
    private int A;
    private int B;
    private final long C;
    private final Context e;
    private final ct f;
    private final dz g;
    private final dp h;
    private final en i;
    private final hm j;
    private final AppMeasurement k;
    private final FirebaseAnalytics l;
    private final ie m;
    private final dn n;
    private final Clock o;
    private final gl p;
    private final fq q;
    private final cl r;
    private dl s;
    private go t;
    private da u;
    private dk v;
    private ef w;
    private boolean x = false;
    private Boolean y;
    private long z;

    private es(fp fpVar) {
        ar.a((Object) fpVar);
        a(this);
        this.e = fpVar.a;
        jj.a(this.e);
        this.c = -1;
        this.o = f.a();
        this.C = this.o.currentTimeMillis();
        this.f = new ct(this);
        fo dzVar = new dz(this);
        dzVar.C();
        this.g = dzVar;
        dzVar = new dp(this);
        dzVar.C();
        this.h = dzVar;
        dzVar = new ie(this);
        dzVar.C();
        this.m = dzVar;
        dzVar = new dn(this);
        dzVar.C();
        this.n = dzVar;
        this.r = new cl(this);
        dzVar = new gl(this);
        dzVar.C();
        this.p = dzVar;
        dzVar = new fq(this);
        dzVar.C();
        this.q = dzVar;
        this.k = new AppMeasurement(this);
        this.l = new FirebaseAnalytics(this);
        dzVar = new hm(this);
        dzVar.C();
        this.j = dzVar;
        dzVar = new en(this);
        dzVar.C();
        this.i = dzVar;
        if (this.e.getApplicationContext() instanceof Application) {
            fn h = h();
            if (h.getContext().getApplicationContext() instanceof Application) {
                Application application = (Application) h.getContext().getApplicationContext();
                if (h.a == null) {
                    h.a = new gj(h, null);
                }
                application.unregisterActivityLifecycleCallbacks(h.a);
                application.registerActivityLifecycleCallbacks(h.a);
                h.zzge().y().a("Registered activity lifecycle callback");
            }
        } else {
            zzge().u().a("Application context is not an Application");
        }
        hv dtVar = new dt(this);
        dtVar.K();
        this.b = dtVar;
        dtVar = new em(this);
        dtVar.K();
        this.a = dtVar;
        this.i.a(new et(this, fpVar));
    }

    private final void G() {
        if (!this.x) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    public static es a(Context context) {
        ar.a((Object) context);
        ar.a(context.getApplicationContext());
        if (d == null) {
            synchronized (es.class) {
                if (d == null) {
                    d = new es(new fp(context));
                }
            }
        }
        return d;
    }

    private static void a(fn fnVar) {
        if (fnVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static void b(fo foVar) {
        if (foVar == null) {
            throw new IllegalStateException("Component not created");
        } else if (!foVar.A()) {
            String valueOf = String.valueOf(foVar.getClass());
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 27).append("Component not initialized: ").append(valueOf).toString());
        }
    }

    static void v() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    @WorkerThread
    protected final void a() {
        boolean z = false;
        s();
        if (c().c.a() == 0) {
            c().c.a(zzbt().currentTimeMillis());
        }
        if (Long.valueOf(c().h.a()).longValue() == 0) {
            zzge().y().a("Persisting first open", Long.valueOf(this.C));
            c().h.a(this.C);
        }
        if (x()) {
            if (!TextUtils.isEmpty(q().t())) {
                String r = c().r();
                if (r == null) {
                    c().c(q().t());
                } else if (!r.equals(q().t())) {
                    zzge().w().a("Rechecking which service to use due to a GMP App Id change");
                    c().u();
                    this.t.x();
                    this.t.v();
                    c().c(q().t());
                    c().h.a(this.C);
                    c().j.a(null);
                }
            }
            h().a(c().j.a());
            if (!TextUtils.isEmpty(q().t())) {
                boolean t = t();
                if (!(c().x() || b().q())) {
                    dz c = c();
                    if (!t) {
                        z = true;
                    }
                    c.d(z);
                }
                if (!b().i(q().s()) || t) {
                    h().z();
                }
                o().a(new AtomicReference());
            }
        } else if (t()) {
            if (!k().g("android.permission.INTERNET")) {
                zzge().r().a("App is missing INTERNET permission");
            }
            if (!k().g("android.permission.ACCESS_NETWORK_STATE")) {
                zzge().r().a("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!c.b(getContext()).a()) {
                if (!ej.a(getContext())) {
                    zzge().r().a("AppMeasurementReceiver not registered/enabled");
                }
                if (!hi.a(getContext(), false)) {
                    zzge().r().a("AppMeasurementService not registered/enabled");
                }
            }
            zzge().r().a("Uploading is not possible. App measurement disabled");
        }
        super.a();
    }

    final void a(fo foVar) {
        this.A++;
    }

    @WorkerThread
    final void a(fp fpVar) {
        dr w;
        s();
        fo daVar = new da(this);
        daVar.C();
        this.u = daVar;
        daVar = new dk(this);
        daVar.C();
        this.v = daVar;
        fo dlVar = new dl(this);
        dlVar.C();
        this.s = dlVar;
        dlVar = new go(this);
        dlVar.C();
        this.t = dlVar;
        this.m.D();
        this.g.D();
        this.w = new ef(this);
        this.v.D();
        zzge().w().a("App measurement is starting up, version", Long.valueOf(12451));
        zzge().w().a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String s = daVar.s();
        if (k().i(s)) {
            w = zzge().w();
            s = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
        } else {
            w = zzge().w();
            String str = "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ";
            s = String.valueOf(s);
            s = s.length() != 0 ? str.concat(s) : new String(str);
        }
        w.a(s);
        zzge().x().a("Debug-level message logging enabled");
        if (this.A != this.B) {
            zzge().r().a("Not all components initialized", Integer.valueOf(this.A), Integer.valueOf(this.B));
        }
        super.a((ib) fpVar);
        this.x = true;
    }

    public final ct b() {
        return this.f;
    }

    public final dz c() {
        a(this.g);
        return this.g;
    }

    public final dp d() {
        return (this.h == null || !this.h.A()) ? null : this.h;
    }

    public final hm e() {
        b(this.j);
        return this.j;
    }

    public final ef f() {
        return this.w;
    }

    final en g() {
        return this.i;
    }

    public final Context getContext() {
        return this.e;
    }

    public final fq h() {
        b(this.q);
        return this.q;
    }

    public final AppMeasurement i() {
        return this.k;
    }

    public final FirebaseAnalytics j() {
        return this.l;
    }

    public final ie k() {
        a(this.m);
        return this.m;
    }

    public final dn l() {
        a(this.n);
        return this.n;
    }

    public final dl m() {
        b(this.s);
        return this.s;
    }

    public final gl n() {
        b(this.p);
        return this.p;
    }

    public final go o() {
        b(this.t);
        return this.t;
    }

    public final da p() {
        b(this.u);
        return this.u;
    }

    public final dk q() {
        b(this.v);
        return this.v;
    }

    public final cl r() {
        a(this.r);
        return this.r;
    }

    @WorkerThread
    public final void s() {
        zzgd().c();
    }

    @WorkerThread
    public final boolean t() {
        boolean z = false;
        s();
        G();
        if (b().q()) {
            return false;
        }
        Boolean b = b().b("firebase_analytics_collection_enabled");
        if (b != null) {
            z = b.booleanValue();
        } else if (!j.b()) {
            z = true;
        }
        return c().c(z);
    }

    final long u() {
        Long valueOf = Long.valueOf(c().h.a());
        return valueOf.longValue() == 0 ? this.C : Math.min(this.C, valueOf.longValue());
    }

    final void w() {
        this.B++;
    }

    @WorkerThread
    protected final boolean x() {
        boolean z = false;
        G();
        s();
        if (this.y == null || this.z == 0 || !(this.y == null || this.y.booleanValue() || Math.abs(zzbt().elapsedRealtime() - this.z) <= 1000)) {
            this.z = zzbt().elapsedRealtime();
            if (k().g("android.permission.INTERNET") && k().g("android.permission.ACCESS_NETWORK_STATE") && (c.b(getContext()).a() || (ej.a(getContext()) && hi.a(getContext(), false)))) {
                z = true;
            }
            this.y = Boolean.valueOf(z);
            if (this.y.booleanValue()) {
                this.y = Boolean.valueOf(k().e(q().t()));
            }
        }
        return this.y.booleanValue();
    }

    public final Clock zzbt() {
        return this.o;
    }

    public final en zzgd() {
        b(this.i);
        return this.i;
    }

    public final dp zzge() {
        b(this.h);
        return this.h;
    }
}
