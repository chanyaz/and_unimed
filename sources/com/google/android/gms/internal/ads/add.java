package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.lang.ref.WeakReference;

final class add implements ActivityLifecycleCallbacks {
    private final Application a;
    private final WeakReference<ActivityLifecycleCallbacks> b;
    private boolean c = false;

    public add(Application application, ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.b = new WeakReference(activityLifecycleCallbacks);
        this.a = application;
    }

    private final void a(zzcv zzcv) {
        try {
            ActivityLifecycleCallbacks activityLifecycleCallbacks = (ActivityLifecycleCallbacks) this.b.get();
            if (activityLifecycleCallbacks != null) {
                zzcv.zza(activityLifecycleCallbacks);
            } else if (!this.c) {
                this.a.unregisterActivityLifecycleCallbacks(this);
                this.c = true;
            }
        } catch (Exception e) {
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(new ade(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        a(new adk(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        a(new adh(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        a(new adg(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        a(new adj(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        a(new adf(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        a(new adi(this, activity));
    }
}
