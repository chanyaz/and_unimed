package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.os.RemoteException;
import com.google.android.gms.analytics.t;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.stats.b;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;

@VisibleForTesting
public final class al extends af {
    private final an a = new an(this);
    private zzci b;
    private final bf c;
    private final cf d;

    protected al(ah ahVar) {
        super(ahVar);
        this.d = new cf(ahVar.c());
        this.c = new am(this, ahVar);
    }

    private final void a(ComponentName componentName) {
        t.d();
        if (this.b != null) {
            this.b = null;
            a("Disconnected from device AnalyticsService", componentName);
            j().e();
        }
    }

    private final void a(zzci zzci) {
        t.d();
        this.b = zzci;
        e();
        j().f();
    }

    private final void e() {
        this.d.a();
        this.c.a(((Long) bk.A.a()).longValue());
    }

    private final void f() {
        t.d();
        if (b()) {
            b("Inactivity, disconnecting from device AnalyticsService");
            d();
        }
    }

    protected final void a() {
    }

    public final boolean a(bp bpVar) {
        ar.a((Object) bpVar);
        t.d();
        y();
        zzci zzci = this.b;
        if (zzci == null) {
            return false;
        }
        try {
            zzci.zza(bpVar.b(), bpVar.d(), bpVar.f() ? bd.h() : bd.i(), Collections.emptyList());
            e();
            return true;
        } catch (RemoteException e) {
            b("Failed to send hits to AnalyticsService");
            return false;
        }
    }

    public final boolean b() {
        t.d();
        y();
        return this.b != null;
    }

    public final boolean c() {
        t.d();
        y();
        if (this.b != null) {
            return true;
        }
        zzci a = this.a.a();
        if (a == null) {
            return false;
        }
        this.b = a;
        e();
        return true;
    }

    public final void d() {
        t.d();
        y();
        try {
            b.a().a(j(), this.a);
        } catch (IllegalStateException e) {
        } catch (IllegalArgumentException e2) {
        }
        if (this.b != null) {
            this.b = null;
            j().e();
        }
    }
}
