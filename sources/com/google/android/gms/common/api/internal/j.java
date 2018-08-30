package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ao;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.internal.ax;
import com.google.android.gms.common.n;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
@Deprecated
public final class j {
    private static final Object a = new Object();
    @GuardedBy("sLock")
    private static j b;
    private final String c;
    private final Status d;
    private final boolean e;
    private final boolean f;

    @KeepForSdk
    @VisibleForTesting
    j(Context context) {
        boolean z = true;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(n.common_google_play_services_unknown_issue));
        if (identifier != 0) {
            boolean z2 = resources.getInteger(identifier) != 0;
            if (z2) {
                z = false;
            }
            this.f = z;
            z = z2;
        } else {
            this.f = false;
        }
        this.e = z;
        Object a = ao.a(context);
        if (a == null) {
            a = new ax(context).a("google_app_id");
        }
        if (TextUtils.isEmpty(a)) {
            this.d = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.c = null;
            return;
        }
        this.c = a;
        this.d = Status.a;
    }

    @KeepForSdk
    public static Status a(Context context) {
        Status status;
        ar.a((Object) context, (Object) "Context must not be null.");
        synchronized (a) {
            if (b == null) {
                b = new j(context);
            }
            status = b.d;
        }
        return status;
    }

    @KeepForSdk
    private static j a(String str) {
        j jVar;
        synchronized (a) {
            if (b == null) {
                throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 34).append("Initialize must be called before ").append(str).append(".").toString());
            }
            jVar = b;
        }
        return jVar;
    }

    @KeepForSdk
    public static String a() {
        return a("getGoogleAppId").c;
    }

    @KeepForSdk
    public static boolean b() {
        return a("isMeasurementExplicitlyDisabled").f;
    }
}
