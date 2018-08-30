package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.au;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

@TargetApi(14)
final class agr implements ActivityLifecycleCallbacks {
    @Nullable
    private Activity a;
    private Context b;
    private final Object c = new Object();
    private boolean d = true;
    private boolean e = false;
    @GuardedBy("mLock")
    private final List<zzgj> f = new ArrayList();
    @GuardedBy("mLock")
    private final List<zzgw> g = new ArrayList();
    private Runnable h;
    private boolean i = false;
    private long j;

    agr() {
    }

    private final void a(Activity activity) {
        synchronized (this.c) {
            if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                this.a = activity;
            }
        }
    }

    @Nullable
    public final Activity a() {
        return this.a;
    }

    public final void a(Application application, Context context) {
        if (!this.i) {
            application.registerActivityLifecycleCallbacks(this);
            if (context instanceof Activity) {
                a((Activity) context);
            }
            this.b = application;
            this.j = ((Long) akc.f().a(amn.aH)).longValue();
            this.i = true;
        }
    }

    public final void a(zzgj zzgj) {
        synchronized (this.c) {
            this.f.add(zzgj);
        }
    }

    @Nullable
    public final Context b() {
        return this.b;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.c) {
            if (this.a == null) {
                return;
            }
            if (this.a.equals(activity)) {
                this.a = null;
            }
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                try {
                    if (((zzgw) it.next()).zza(activity)) {
                        it.remove();
                    }
                } catch (Throwable e) {
                    au.i().a(e, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                    kk.b("", e);
                }
            }
        }
    }

    public final void onActivityPaused(Activity activity) {
        a(activity);
        synchronized (this.c) {
            for (zzgw onActivityPaused : this.g) {
                try {
                    onActivityPaused.onActivityPaused(activity);
                } catch (Throwable e) {
                    au.i().a(e, "AppActivityTracker.ActivityListener.onActivityPaused");
                    kk.b("", e);
                }
            }
        }
        this.e = true;
        if (this.h != null) {
            ht.a.removeCallbacks(this.h);
        }
        Handler handler = ht.a;
        Runnable ags = new ags(this);
        this.h = ags;
        handler.postDelayed(ags, this.j);
    }

    public final void onActivityResumed(Activity activity) {
        boolean z = false;
        a(activity);
        this.e = false;
        if (!this.d) {
            z = true;
        }
        this.d = true;
        if (this.h != null) {
            ht.a.removeCallbacks(this.h);
        }
        synchronized (this.c) {
            for (zzgw onActivityResumed : this.g) {
                try {
                    onActivityResumed.onActivityResumed(activity);
                } catch (Throwable e) {
                    au.i().a(e, "AppActivityTracker.ActivityListener.onActivityResumed");
                    kk.b("", e);
                }
            }
            if (z) {
                for (zzgj zzh : this.f) {
                    try {
                        zzh.zzh(true);
                    } catch (Throwable e2) {
                        kk.b("", e2);
                    }
                }
            } else {
                kk.b("App is still foreground.");
            }
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        a(activity);
    }

    public final void onActivityStopped(Activity activity) {
    }
}
