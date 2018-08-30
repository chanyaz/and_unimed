package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.af;
import com.google.android.gms.internal.measurement.ah;
import com.google.android.gms.internal.measurement.cg;
import com.google.android.gms.internal.measurement.ci;
import com.google.android.gms.internal.measurement.ck;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@VisibleForTesting
public final class GoogleAnalytics extends k {
    private static List<Runnable> b = new ArrayList();
    private boolean c;
    private Set<zza> d = new HashSet();
    private boolean e;
    private boolean f;
    private volatile boolean g;

    interface zza {
        void zzc(Activity activity);

        void zzd(Activity activity);
    }

    @VisibleForTesting
    public GoogleAnalytics(ah ahVar) {
        super(ahVar);
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public static GoogleAnalytics a(Context context) {
        return ah.a(context).j();
    }

    public static void c() {
        synchronized (GoogleAnalytics.class) {
            if (b != null) {
                for (Runnable run : b) {
                    run.run();
                }
                b = null;
            }
        }
    }

    public final i a(int i) {
        af iVar;
        synchronized (this) {
            iVar = new i(g(), null, null);
            if (i > 0) {
                ci ciVar = (ci) new cg(g()).a(i);
                if (ciVar != null) {
                    iVar.a(ciVar);
                }
            }
            iVar.z();
        }
        return iVar;
    }

    public final void a() {
        ck k = g().k();
        k.d();
        if (k.e()) {
            a(k.f());
        }
        k.d();
        this.c = true;
    }

    @VisibleForTesting
    final void a(Activity activity) {
        for (zza zzc : this.d) {
            zzc.zzc(activity);
        }
    }

    @TargetApi(14)
    public final void a(Application application) {
        if (!this.e) {
            application.registerActivityLifecycleCallbacks(new b(this));
            this.e = true;
        }
    }

    final void a(zza zza) {
        this.d.add(zza);
        Context a = g().a();
        if (a instanceof Application) {
            a((Application) a);
        }
    }

    public final void a(boolean z) {
        this.f = z;
    }

    @VisibleForTesting
    final void b(Activity activity) {
        for (zza zzd : this.d) {
            zzd.zzd(activity);
        }
    }

    final void b(zza zza) {
        this.d.remove(zza);
    }

    public final boolean b() {
        return this.c;
    }

    public final boolean d() {
        return this.f;
    }

    public final boolean e() {
        return this.g;
    }

    public final void f() {
        g().h().c();
    }
}
