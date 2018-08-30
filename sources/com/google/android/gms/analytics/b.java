package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

@TargetApi(14)
final class b implements ActivityLifecycleCallbacks {
    private final /* synthetic */ GoogleAnalytics a;

    b(GoogleAnalytics googleAnalytics) {
        this.a = googleAnalytics;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        this.a.a(activity);
    }

    public final void onActivityStopped(Activity activity) {
        this.a.b(activity);
    }
}
