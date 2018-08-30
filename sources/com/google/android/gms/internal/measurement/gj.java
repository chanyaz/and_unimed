package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.text.TextUtils;

@TargetApi(14)
@MainThread
final class gj implements ActivityLifecycleCallbacks {
    private final /* synthetic */ fq a;

    private gj(fq fqVar) {
        this.a = fqVar;
    }

    /* synthetic */ gj(fq fqVar, fr frVar) {
        this(fqVar);
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            this.a.zzge().y().a("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                if (data != null && data.isHierarchical()) {
                    if (bundle == null) {
                        Bundle a = this.a.l().a(data);
                        this.a.l();
                        String str = ie.a(intent) ? "gs" : "auto";
                        if (a != null) {
                            this.a.a(str, "_cmp", a);
                        }
                    }
                    Object queryParameter = data.getQueryParameter("referrer");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        Object obj = (queryParameter.contains("gclid") && (queryParameter.contains("utm_campaign") || queryParameter.contains("utm_source") || queryParameter.contains("utm_medium") || queryParameter.contains("utm_term") || queryParameter.contains("utm_content"))) ? 1 : null;
                        if (obj == null) {
                            this.a.zzge().x().a("Activity created with data 'referrer' param without gclid and at least one utm field");
                            return;
                        }
                        this.a.zzge().x().a("Activity created with referrer", queryParameter);
                        if (!TextUtils.isEmpty(queryParameter)) {
                            this.a.a("auto", "_ldl", queryParameter);
                        }
                    } else {
                        return;
                    }
                }
            }
        } catch (Exception e) {
            this.a.zzge().r().a("Throwable caught in onActivityCreated", e);
        }
        this.a.i().a(activity, bundle);
    }

    public final void onActivityDestroyed(Activity activity) {
        this.a.i().c(activity);
    }

    @MainThread
    public final void onActivityPaused(Activity activity) {
        this.a.i().b(activity);
        fn m = this.a.m();
        m.zzgd().a(new hq(m, m.zzbt().elapsedRealtime()));
    }

    @MainThread
    public final void onActivityResumed(Activity activity) {
        this.a.i().a(activity);
        fn m = this.a.m();
        m.zzgd().a(new hp(m, m.zzbt().elapsedRealtime()));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.a.i().b(activity, bundle);
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
