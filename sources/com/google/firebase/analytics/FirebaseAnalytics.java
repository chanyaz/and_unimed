package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import android.support.annotation.Size;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.internal.measurement.es;
import com.google.android.gms.tasks.a;

@Keep
public final class FirebaseAnalytics {
    private final es zzacw;

    public FirebaseAnalytics(es esVar) {
        ar.a((Object) esVar);
        this.zzacw = esVar;
    }

    @Keep
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @NonNull
    public static FirebaseAnalytics getInstance(@NonNull Context context) {
        return es.a(context).j();
    }

    @NonNull
    public final a<String> getAppInstanceId() {
        return this.zzacw.h().w();
    }

    public final void logEvent(@Size(max = 40, min = 1) @NonNull String str, @Nullable Bundle bundle) {
        this.zzacw.i().logEvent(str, bundle);
    }

    public final void resetAnalyticsData() {
        this.zzacw.h().y();
    }

    public final void setAnalyticsCollectionEnabled(boolean z) {
        this.zzacw.i().setMeasurementEnabled(z);
    }

    @Keep
    @MainThread
    public final void setCurrentScreen(@NonNull Activity activity, @Nullable @Size(max = 36, min = 1) String str, @Nullable @Size(max = 36, min = 1) String str2) {
        this.zzacw.n().a(activity, str, str2);
    }

    public final void setMinimumSessionDuration(long j) {
        this.zzacw.i().setMinimumSessionDuration(j);
    }

    public final void setSessionTimeoutDuration(long j) {
        this.zzacw.i().setSessionTimeoutDuration(j);
    }

    public final void setUserId(@Nullable String str) {
        this.zzacw.i().setUserPropertyInternal("app", "_id", str);
    }

    public final void setUserProperty(@Size(max = 24, min = 1) @NonNull String str, @Nullable @Size(max = 36) String str2) {
        this.zzacw.i().setUserProperty(str, str2);
    }
}
