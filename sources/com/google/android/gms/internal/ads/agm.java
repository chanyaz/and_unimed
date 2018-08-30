package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

final class agm implements zzgc {
    private final /* synthetic */ Activity a;
    private final /* synthetic */ Bundle b;

    agm(agg agg, Activity activity, Bundle bundle) {
        this.a = activity;
        this.b = bundle;
    }

    public final void zza(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.a, this.b);
    }
}
