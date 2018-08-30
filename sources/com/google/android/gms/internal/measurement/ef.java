package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.a.b;
import com.google.android.gms.common.a.c;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;

public final class ef {
    @VisibleForTesting
    volatile zzr a;
    private final es b;
    @VisibleForTesting
    private ServiceConnection c;

    ef(es esVar) {
        this.b = esVar;
    }

    @VisibleForTesting
    private final boolean c() {
        try {
            b b = c.b(this.b.getContext());
            if (b != null) {
                return b.b("com.android.vending", 128).versionCode >= 80837300;
            } else {
                this.b.zzge().w().a("Failed to retrieve Package Manager to check Play Store compatibility");
                return false;
            }
        } catch (Exception e) {
            this.b.zzge().w().a("Failed to retrieve Play Store version", e);
            return false;
        }
    }

    @WorkerThread
    protected final void a() {
        this.b.s();
        if (c()) {
            this.c = new eh(this, null);
            this.b.zzge().w().a("Install Referrer Reporter is initializing");
            this.b.s();
            Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
            intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
            PackageManager packageManager = this.b.getContext().getPackageManager();
            if (packageManager == null) {
                this.b.zzge().u().a("Failed to obtain Package Manager to verify binding conditions");
                return;
            }
            List queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                this.b.zzge().w().a("Play Service for fetching Install Referrer is unavailable on device");
                return;
            }
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentServices.get(0);
            if (resolveInfo.serviceInfo != null) {
                String str = resolveInfo.serviceInfo.packageName;
                if (resolveInfo.serviceInfo.name == null || this.c == null || !"com.android.vending".equals(str) || !c()) {
                    this.b.zzge().w().a("Play Store missing or incompatible. Version 8.3.73 or later required");
                    return;
                }
                try {
                    this.b.zzge().w().a("Install Referrer Service is", com.google.android.gms.common.stats.b.a().a(this.b.getContext(), new Intent(intent), this.c, 1) ? "available" : "not available");
                    return;
                } catch (Exception e) {
                    this.b.zzge().r().a("Exception occurred while binding to Install Referrer Service", e.getMessage());
                    return;
                }
            }
            return;
        }
        this.b.zzge().w().a("Install Referrer Reporter is not available");
        this.c = null;
    }

    @WorkerThread
    @VisibleForTesting
    final void a(Bundle bundle) {
        this.b.s();
        if (bundle != null) {
            long j = bundle.getLong("install_begin_timestamp_seconds", 0) * 1000;
            if (j == 0) {
                this.b.zzge().r().a("Service response is missing Install Referrer install timestamp");
                return;
            }
            String string = bundle.getString("install_referrer");
            if (string == null || string.isEmpty()) {
                this.b.zzge().r().a("No referrer defined in install referrer response");
                return;
            }
            this.b.zzge().y().a("InstallReferrer API result", string);
            ie k = this.b.k();
            String str = "?";
            string = String.valueOf(string);
            Bundle a = k.a(Uri.parse(string.length() != 0 ? str.concat(string) : new String(str)));
            if (a == null) {
                this.b.zzge().r().a("No campaign params defined in install referrer result");
                return;
            }
            string = a.getString("medium");
            Object obj = (string == null || "(not set)".equalsIgnoreCase(string) || "organic".equalsIgnoreCase(string)) ? null : 1;
            if (obj != null) {
                long j2 = bundle.getLong("referrer_click_timestamp_seconds", 0) * 1000;
                if (j2 == 0) {
                    this.b.zzge().r().a("Install Referrer is missing click timestamp for ad campaign");
                    return;
                }
                a.putLong("click_timestamp", j2);
            }
            if (j == this.b.c().i.a()) {
                this.b.zzge().y().a("Campaign has already been logged");
                return;
            }
            a.putString("_cis", "referrer API");
            this.b.c().i.a(j);
            this.b.h().a("auto", "_cmp", a);
            if (this.c != null) {
                com.google.android.gms.common.stats.b.a().a(this.b.getContext(), this.c);
            }
        }
    }

    @Nullable
    @WorkerThread
    @VisibleForTesting
    final Bundle b() {
        this.b.s();
        if (this.a == null) {
            this.b.zzge().u().a("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", this.b.getContext().getPackageName());
        try {
            bundle = this.a.zza(bundle);
            if (bundle != null) {
                return bundle;
            }
            this.b.zzge().r().a("Install Referrer Service returned a null response");
            return null;
        } catch (Exception e) {
            this.b.zzge().r().a("Exception occurred while retrieving the Install Referrer", e.getMessage());
            return null;
        }
    }
}
