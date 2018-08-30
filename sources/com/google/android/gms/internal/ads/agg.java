package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.lang.ref.WeakReference;

final class agg implements ActivityLifecycleCallbacks {
    private final Application a;
    private final WeakReference<ActivityLifecycleCallbacks> b;
    private boolean c = false;

    public agg(Application application, ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.b = new WeakReference(activityLifecycleCallbacks);
        this.a = application;
    }

    private final void a(zzgc zzgc) {
        try {
            ActivityLifecycleCallbacks activityLifecycleCallbacks = (ActivityLifecycleCallbacks) this.b.get();
            if (activityLifecycleCallbacks != null) {
                zzgc.zza(activityLifecycleCallbacks);
            } else if (!this.c) {
                this.a.unregisterActivityLifecycleCallbacks(this);
                this.c = true;
            }
        } catch (Throwable e) {
            kk.b("Error while dispatching lifecycle callback.", e);
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(new agh(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        a(new agn(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        a(new agk(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        a(new agj(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        a(new agm(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        a(new agi(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        a(new agl(this, activity));
    }
}
