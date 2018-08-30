package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.a;
import com.google.firebase.FirebaseApp;
import java.io.IOException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

public class FirebaseInstanceId {
    private static final long a = TimeUnit.HOURS.toSeconds(8);
    private static o b;
    @GuardedBy("FirebaseInstanceId.class")
    @VisibleForTesting
    private static ScheduledThreadPoolExecutor c;
    private final FirebaseApp d;
    private final f e;
    private final zzo f;
    private final i g;
    @GuardedBy("this")
    private boolean h;
    @GuardedBy("this")
    private boolean i;

    FirebaseInstanceId(FirebaseApp firebaseApp) {
        this(firebaseApp, new f(firebaseApp.a()));
    }

    private FirebaseInstanceId(FirebaseApp firebaseApp, f fVar) {
        this.g = new i();
        this.h = false;
        if (f.a(firebaseApp) == null) {
            throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
        }
        synchronized (FirebaseInstanceId.class) {
            if (b == null) {
                b = new o(firebaseApp.a());
            }
        }
        this.d = firebaseApp;
        this.e = fVar;
        this.f = new ab(firebaseApp, this, fVar);
        this.i = o();
        if (l()) {
            m();
        }
    }

    public static FirebaseInstanceId a() {
        return getInstance(FirebaseApp.d());
    }

    private static <T> T a(a<T> aVar) {
        try {
            return Tasks.a((a) aVar);
        } catch (Throwable e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw new IOException(cause);
            } else {
                throw new IOException(e);
            }
        } catch (InterruptedException e2) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
    }

    private final String a(String str, String str2, Bundle bundle) {
        return ((ab) this.f).a(str, str2, bundle);
    }

    static void a(Runnable runnable, long j) {
        synchronized (FirebaseInstanceId.class) {
            if (c == null) {
                c = new ScheduledThreadPoolExecutor(1);
            }
            c.schedule(runnable, j, TimeUnit.SECONDS);
        }
    }

    static String d() {
        return f.a(b.c("").a());
    }

    private static String d(String str) {
        return (str.isEmpty() || str.equalsIgnoreCase(AppMeasurement.FCM_ORIGIN) || str.equalsIgnoreCase("gcm")) ? "*" : str;
    }

    @Keep
    public static synchronized FirebaseInstanceId getInstance(@NonNull FirebaseApp firebaseApp) {
        FirebaseInstanceId firebaseInstanceId;
        synchronized (FirebaseInstanceId.class) {
            firebaseInstanceId = (FirebaseInstanceId) firebaseApp.a(FirebaseInstanceId.class);
        }
        return firebaseInstanceId;
    }

    static o h() {
        return b;
    }

    static boolean i() {
        return Log.isLoggable("FirebaseInstanceId", 3) || (VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3));
    }

    private final void m() {
        p f = f();
        if (f == null || f.b(this.e.b()) || b.a() != null) {
            n();
        }
    }

    private final synchronized void n() {
        if (!this.h) {
            a(0);
        }
    }

    private final boolean o() {
        Context a = this.d.a();
        SharedPreferences sharedPreferences = a.getSharedPreferences("com.google.firebase.messaging", 0);
        if (sharedPreferences.contains("auto_init")) {
            return sharedPreferences.getBoolean("auto_init", true);
        }
        try {
            PackageManager packageManager = a.getPackageManager();
            if (packageManager != null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(a.getPackageName(), 128);
                if (!(applicationInfo == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("firebase_messaging_auto_init_enabled"))) {
                    return applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled");
                }
            }
        } catch (NameNotFoundException e) {
        }
        return p();
    }

    private final boolean p() {
        try {
            Class.forName("com.google.firebase.messaging.a");
            return true;
        } catch (ClassNotFoundException e) {
            Context a = this.d.a();
            Intent intent = new Intent("com.google.firebase.MESSAGING_EVENT");
            intent.setPackage(a.getPackageName());
            ResolveInfo resolveService = a.getPackageManager().resolveService(intent, 0);
            return (resolveService == null || resolveService.serviceInfo == null) ? false : true;
        }
    }

    @WorkerThread
    public String a(String str, String str2) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        String d = d(str2);
        p a = b.a("", str, d);
        return (a == null || a.b(this.e.b())) ? this.g.a(str, d, new aa(this, str, d)) : a.a;
    }

    final synchronized void a(long j) {
        a(new q(this, this.e, Math.min(Math.max(30, j << 1), a)), j);
        this.h = true;
    }

    public final synchronized void a(String str) {
        b.a(str);
        n();
    }

    final synchronized void a(boolean z) {
        this.h = z;
    }

    final FirebaseApp b() {
        return this.d;
    }

    final /* synthetic */ String b(String str, String str2) {
        String str3 = (String) a(this.f.zzb(str, str2));
        b.a("", str, str2, str3, this.e.b());
        return str3;
    }

    final void b(String str) {
        p f = f();
        if (f == null || f.b(this.e.b())) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String str2 = "gcm.topic";
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str);
        bundle.putString(str2, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        String str3 = f.a;
        str2 = String.valueOf("/topics/");
        valueOf2 = String.valueOf(str);
        a(str3, valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2), bundle);
    }

    @WorkerThread
    public String c() {
        m();
        return d();
    }

    final void c(String str) {
        p f = f();
        if (f == null || f.b(this.e.b())) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String str2 = "gcm.topic";
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str);
        bundle.putString(str2, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        bundle.putString("delete", "1");
        String str3 = f.a;
        str2 = String.valueOf("/topics/");
        valueOf2 = String.valueOf(str);
        a(str3, valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2), bundle);
    }

    @Nullable
    public String e() {
        p f = f();
        if (f == null || f.b(this.e.b())) {
            n();
        }
        return f != null ? f.a : null;
    }

    @Nullable
    final p f() {
        return b.a("", f.a(this.d), "*");
    }

    final String g() {
        return a(f.a(this.d), "*");
    }

    final synchronized void j() {
        b.b();
        if (l()) {
            n();
        }
    }

    final void k() {
        b.d("");
        n();
    }

    @VisibleForTesting
    public final synchronized boolean l() {
        return this.i;
    }
}
