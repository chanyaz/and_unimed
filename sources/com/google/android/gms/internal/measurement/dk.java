package com.google.android.gms.internal.measurement;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.a.a;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.j;
import com.google.firebase.iid.FirebaseInstanceId;
import java.math.BigInteger;
import java.util.Locale;

public final class dk extends fo {
    private String a;
    private String b;
    private int c;
    private String d;
    private String e;
    private long f;
    private long g;
    private int h;
    private String i;

    dk(es esVar) {
        super(esVar);
    }

    @WorkerThread
    private final String w() {
        String str = null;
        c();
        if (o().h(this.a) && !this.q.t()) {
            return str;
        }
        try {
            return FirebaseInstanceId.a().c();
        } catch (IllegalStateException e) {
            zzge().u().a("Failed to retrieve Firebase Instance Id");
            return str;
        }
    }

    @WorkerThread
    final zzdz a(String str) {
        c();
        String s = s();
        String t = t();
        B();
        String str2 = this.b;
        long u = (long) u();
        B();
        String str3 = this.d;
        B();
        c();
        if (this.f == 0) {
            this.f = this.q.k().b(getContext(), getContext().getPackageName());
        }
        long j = this.f;
        boolean t2 = this.q.t();
        boolean z = !n().p;
        String w = w();
        B();
        long u2 = this.q.u();
        int v = v();
        Boolean b = o().b("google_analytics_adid_collection_enabled");
        boolean z2 = b == null || b.booleanValue();
        boolean booleanValue = Boolean.valueOf(z2).booleanValue();
        b = o().b("google_analytics_ssaid_collection_enabled");
        z2 = b == null || b.booleanValue();
        return new zzdz(s, t, str2, u, str3, 12451, j, str, t2, z, w, 0, u2, v, booleanValue, Boolean.valueOf(z2).booleanValue(), n().w());
    }

    protected final void c_() {
        int i = 1;
        String str = "unknown";
        String str2 = "Unknown";
        int i2 = Integer.MIN_VALUE;
        String str3 = "Unknown";
        String packageName = getContext().getPackageName();
        PackageManager packageManager = getContext().getPackageManager();
        if (packageManager == null) {
            zzge().r().a("PackageManager is null, app identity information might be inaccurate. appId", dp.a(packageName));
        } else {
            try {
                str = packageManager.getInstallerPackageName(packageName);
            } catch (IllegalArgumentException e) {
                zzge().r().a("Error retrieving app installer package name. appId", dp.a(packageName));
            }
            if (str == null) {
                str = "manual_install";
            } else if ("com.android.vending".equals(str)) {
                str = "";
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(getContext().getPackageName(), 0);
                if (packageInfo != null) {
                    CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                    if (!TextUtils.isEmpty(applicationLabel)) {
                        str3 = applicationLabel.toString();
                    }
                    str2 = packageInfo.versionName;
                    i2 = packageInfo.versionCode;
                }
            } catch (NameNotFoundException e2) {
                zzge().r().a("Error retrieving package info. appId, appName", dp.a(packageName), str3);
            }
        }
        this.a = packageName;
        this.d = str;
        this.b = str2;
        this.c = i2;
        this.e = str3;
        this.f = 0;
        Status a = j.a(getContext());
        int i3 = (a == null || !a.c()) ? 0 : 1;
        if (i3 == 0) {
            if (a == null) {
                zzge().r().a("GoogleService failed to initialize (no status)");
            } else {
                zzge().r().a("GoogleService failed to initialize, status", Integer.valueOf(a.d()), a.a());
            }
        }
        if (i3 != 0) {
            Boolean b = o().b("firebase_analytics_collection_enabled");
            if (o().q()) {
                zzge().w().a("Collection disabled with firebase_analytics_collection_deactivated=1");
                i3 = 0;
            } else if (b != null && !b.booleanValue()) {
                zzge().w().a("Collection disabled with firebase_analytics_collection_enabled=0");
                i3 = 0;
            } else if (b == null && j.b()) {
                zzge().w().a("Collection disabled with google_app_measurement_enable=0");
                i3 = 0;
            } else {
                zzge().y().a("Collection enabled");
                i3 = 1;
            }
        } else {
            i3 = 0;
        }
        this.i = "";
        this.g = 0;
        try {
            String a2 = j.a();
            if (TextUtils.isEmpty(a2)) {
                a2 = "";
            }
            this.i = a2;
            if (i3 != 0) {
                zzge().y().a("App package, google app id", this.a, this.i);
            }
        } catch (IllegalStateException e3) {
            zzge().r().a("getGoogleAppId or isMeasurementEnabled failed with exception. appId", dp.a(packageName), e3);
        }
        if (VERSION.SDK_INT >= 16) {
            if (!a.a(getContext())) {
                i = 0;
            }
            this.h = i;
            return;
        }
        this.h = 0;
    }

    protected final boolean p() {
        return true;
    }

    @WorkerThread
    final String r() {
        l().s().nextBytes(new byte[16]);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, r0)});
    }

    final String s() {
        B();
        return this.a;
    }

    final String t() {
        B();
        return this.i;
    }

    final int u() {
        B();
        return this.c;
    }

    final int v() {
        B();
        return this.h;
    }
}
