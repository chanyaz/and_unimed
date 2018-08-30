package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

final class ade implements zzcv {
    private final /* synthetic */ Activity a;
    private final /* synthetic */ Bundle b;

    ade(add add, Activity activity, Bundle bundle) {
        this.a = activity;
        this.b = bundle;
    }

    public final void zza(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.a, this.b);
    }
}
