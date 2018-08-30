package com.google.android.gms.internal.measurement;

import android.annotation.SuppressLint;
import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.t;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.f;

@SuppressLint({"StaticFieldLeak"})
public class ah {
    private static volatile ah a;
    private final Context b;
    private final Context c;
    private final Clock d = f.a();
    private final bd e = new bd(this);
    private final bt f;
    private final t g;
    private final y h;
    private final bi i;
    private final ck j;
    private final bx k;
    private final GoogleAnalytics l;
    private final ay m;
    private final x n;
    private final as o;
    private final bh p;

    private ah(aj ajVar) {
        Context a = ajVar.a();
        ar.a((Object) a, (Object) "Application context can't be null");
        Object b = ajVar.b();
        ar.a(b);
        this.b = a;
        this.c = b;
        af btVar = new bt(this);
        btVar.z();
        this.f = btVar;
        ae e = e();
        String str = ag.a;
        e.d(new StringBuilder(String.valueOf(str).length() + 134).append("Google Analytics ").append(str).append(" is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4").toString());
        btVar = new bx(this);
        btVar.z();
        this.k = btVar;
        btVar = new ck(this);
        btVar.z();
        this.j = btVar;
        btVar = new y(this, ajVar);
        af ayVar = new ay(this);
        af xVar = new x(this);
        af asVar = new as(this);
        af bhVar = new bh(this);
        t a2 = t.a(a);
        a2.a(new ai(this));
        this.g = a2;
        GoogleAnalytics googleAnalytics = new GoogleAnalytics(this);
        ayVar.z();
        this.m = ayVar;
        xVar.z();
        this.n = xVar;
        asVar.z();
        this.o = asVar;
        bhVar.z();
        this.p = bhVar;
        ayVar = new bi(this);
        ayVar.z();
        this.i = ayVar;
        btVar.z();
        this.h = btVar;
        googleAnalytics.a();
        this.l = googleAnalytics;
        btVar.b();
    }

    public static ah a(Context context) {
        ar.a((Object) context);
        if (a == null) {
            synchronized (ah.class) {
                if (a == null) {
                    Clock a = f.a();
                    long elapsedRealtime = a.elapsedRealtime();
                    ah ahVar = new ah(new aj(context));
                    a = ahVar;
                    GoogleAnalytics.c();
                    elapsedRealtime = a.elapsedRealtime() - elapsedRealtime;
                    long longValue = ((Long) bk.E.a()).longValue();
                    if (elapsedRealtime > longValue) {
                        ahVar.e().c("Slow initialization (ms)", Long.valueOf(elapsedRealtime), Long.valueOf(longValue));
                    }
                }
            }
        }
        return a;
    }

    private static void a(af afVar) {
        ar.a((Object) afVar, (Object) "Analytics service not created/initialized");
        ar.b(afVar.x(), "Analytics service not initialized");
    }

    public final Context a() {
        return this.b;
    }

    public final Context b() {
        return this.c;
    }

    public final Clock c() {
        return this.d;
    }

    public final bd d() {
        return this.e;
    }

    public final bt e() {
        a(this.f);
        return this.f;
    }

    public final bt f() {
        return this.f;
    }

    public final t g() {
        ar.a(this.g);
        return this.g;
    }

    public final y h() {
        a(this.h);
        return this.h;
    }

    public final bi i() {
        a(this.i);
        return this.i;
    }

    public final GoogleAnalytics j() {
        ar.a(this.l);
        ar.b(this.l.b(), "Analytics instance not initialized");
        return this.l;
    }

    public final ck k() {
        a(this.j);
        return this.j;
    }

    public final bx l() {
        a(this.k);
        return this.k;
    }

    public final bx m() {
        return (this.k == null || !this.k.x()) ? null : this.k;
    }

    public final x n() {
        a(this.n);
        return this.n;
    }

    public final ay o() {
        a(this.m);
        return this.m;
    }

    public final as p() {
        a(this.o);
        return this.o;
    }

    public final bh q() {
        return this.p;
    }
}
