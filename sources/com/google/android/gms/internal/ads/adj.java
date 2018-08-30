package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

final class adj implements zzcv {
    private final /* synthetic */ Activity a;
    private final /* synthetic */ Bundle b;

    adj(add add, Activity activity, Bundle bundle) {
        this.a = activity;
        this.b = bundle;
    }

    public final void zza(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.a, this.b);
    }
}
