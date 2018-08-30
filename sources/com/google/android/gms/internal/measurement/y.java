package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.t;
import com.google.android.gms.common.internal.ar;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class y extends af {
    private final at a;

    public y(ah ahVar, aj ajVar) {
        super(ahVar);
        ar.a((Object) ajVar);
        this.a = new at(ahVar, ajVar);
    }

    public final long a(ak akVar) {
        y();
        ar.a((Object) akVar);
        t.d();
        long a = this.a.a(akVar, true);
        if (a == 0) {
            this.a.a(akVar);
        }
        return a;
    }

    protected final void a() {
        this.a.z();
    }

    public final void a(bp bpVar) {
        ar.a((Object) bpVar);
        y();
        b("Hit delivery requested", bpVar);
        m().a(new ab(this, bpVar));
    }

    public final void a(zzca zzca) {
        y();
        m().a(new ac(this, zzca));
    }

    public final void a(String str, Runnable runnable) {
        ar.a(str, (Object) "campaign param can't be empty");
        m().a(new aa(this, str, runnable));
    }

    public final void b() {
        this.a.b();
    }

    public final void c() {
        y();
        Context j = j();
        if (ca.a(j) && cb.a(j)) {
            Intent intent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            intent.setComponent(new ComponentName(j, "com.google.android.gms.analytics.AnalyticsService"));
            j.startService(intent);
            return;
        }
        a(null);
    }

    public final boolean d() {
        y();
        try {
            m().a(new ad(this)).get(4, TimeUnit.SECONDS);
            return true;
        } catch (InterruptedException e) {
            d("syncDispatchLocalHits interrupted", e);
            return false;
        } catch (ExecutionException e2) {
            e("syncDispatchLocalHits failed", e2);
            return false;
        } catch (TimeoutException e3) {
            d("syncDispatchLocalHits timed out", e3);
            return false;
        }
    }

    public final void e() {
        y();
        t.d();
        ae aeVar = this.a;
        t.d();
        aeVar.y();
        aeVar.b("Service disconnected");
    }

    final void f() {
        t.d();
        this.a.e();
    }

    final void g() {
        t.d();
        this.a.d();
    }
}
