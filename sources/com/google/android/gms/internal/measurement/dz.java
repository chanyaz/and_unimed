package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigInteger;
import java.util.Locale;

final class dz extends fo {
    @VisibleForTesting
    static final Pair<String, Long> a = new Pair("", Long.valueOf(0));
    public ed b;
    public final ec c = new ec(this, "last_upload", 0);
    public final ec d = new ec(this, "last_upload_attempt", 0);
    public final ec e = new ec(this, "backoff", 0);
    public final ec f = new ec(this, "last_delete_stale", 0);
    public final ec g = new ec(this, "midnight_offset", 0);
    public final ec h = new ec(this, "first_open_time", 0);
    public final ec i = new ec(this, "app_install_time", 0);
    public final ee j = new ee(this, "app_instance_id", null);
    public final ec k = new ec(this, "time_before_start", 10000);
    public final ec l = new ec(this, "session_timeout", 1800000);
    public final eb m = new eb(this, "start_new_session", true);
    public final ec n = new ec(this, "last_pause_time", 0);
    public final ec o = new ec(this, "time_active", 0);
    public boolean p;
    private SharedPreferences r;
    private String s;
    private boolean t;
    private long u;
    private String v;
    private long w;
    private final Object x = new Object();

    dz(es esVar) {
        super(esVar);
    }

    @WorkerThread
    private final SharedPreferences y() {
        c();
        B();
        return this.r;
    }

    @WorkerThread
    @NonNull
    final Pair<String, Boolean> a(String str) {
        c();
        long elapsedRealtime = zzbt().elapsedRealtime();
        if (this.s != null && elapsedRealtime < this.u) {
            return new Pair(this.s, Boolean.valueOf(this.t));
        }
        this.u = elapsedRealtime + o().a(str, dg.c);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
            if (advertisingIdInfo != null) {
                this.s = advertisingIdInfo.getId();
                this.t = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.s == null) {
                this.s = "";
            }
        } catch (Exception e) {
            zzge().x().a("Unable to get advertising id", e);
            this.s = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(this.s, Boolean.valueOf(this.t));
    }

    @WorkerThread
    final void a(boolean z) {
        c();
        zzge().y().a("Setting useService", Boolean.valueOf(z));
        Editor edit = y().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    @WorkerThread
    final String b(String str) {
        c();
        String str2 = (String) a(str).first;
        if (ie.f("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, ie.f("MD5").digest(str2.getBytes()))});
    }

    @WorkerThread
    final void b(boolean z) {
        c();
        zzge().y().a("Setting measurementEnabled", Boolean.valueOf(z));
        Editor edit = y().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }

    @WorkerThread
    final void c(String str) {
        c();
        Editor edit = y().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    @WorkerThread
    final boolean c(boolean z) {
        c();
        return y().getBoolean("measurement_enabled", z);
    }

    @WorkerThread
    protected final void c_() {
        this.r = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.p = this.r.getBoolean("has_been_opened", false);
        if (!this.p) {
            Editor edit = this.r.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.b = new ed(this, "health_monitor", Math.max(0, ((Long) dg.d.b()).longValue()), null);
    }

    final void d(String str) {
        synchronized (this.x) {
            this.v = str;
            this.w = zzbt().elapsedRealtime();
        }
    }

    @WorkerThread
    final void d(boolean z) {
        c();
        zzge().y().a("Updating deferred analytics collection", Boolean.valueOf(z));
        Editor edit = y().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    protected final boolean p() {
        return true;
    }

    @WorkerThread
    final String r() {
        c();
        return y().getString("gmp_app_id", null);
    }

    final String s() {
        String str;
        synchronized (this.x) {
            if (Math.abs(zzbt().elapsedRealtime() - this.w) < 1000) {
                str = this.v;
            } else {
                str = null;
            }
        }
        return str;
    }

    @WorkerThread
    final Boolean t() {
        c();
        return !y().contains("use_service") ? null : Boolean.valueOf(y().getBoolean("use_service", false));
    }

    @WorkerThread
    final void u() {
        boolean z = true;
        c();
        zzge().y().a("Clearing collection preferences.");
        boolean contains = y().contains("measurement_enabled");
        if (contains) {
            z = c(true);
        }
        Editor edit = y().edit();
        edit.clear();
        edit.apply();
        if (contains) {
            b(z);
        }
    }

    @WorkerThread
    protected final String v() {
        c();
        String string = y().getString("previous_os_version", null);
        g().B();
        String str = VERSION.RELEASE;
        if (!(TextUtils.isEmpty(str) || str.equals(string))) {
            Editor edit = y().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        return string;
    }

    @WorkerThread
    final boolean w() {
        c();
        return y().getBoolean("deferred_analytics_collection", false);
    }

    @WorkerThread
    final boolean x() {
        return this.r.contains("deferred_analytics_collection");
    }
}
