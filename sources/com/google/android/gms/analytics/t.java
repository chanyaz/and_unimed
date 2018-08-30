package com.google.android.gms.analytics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.cj;
import com.google.android.gms.internal.measurement.jc;
import com.google.android.gms.internal.measurement.jz;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

@SuppressLint({"StaticFieldLeak"})
@VisibleForTesting
public final class t {
    private static volatile t a;
    private final Context b;
    private final List<zzn> c = new CopyOnWriteArrayList();
    private final o d = new o();
    private final u e = new u(this);
    private volatile jc f;
    private UncaughtExceptionHandler g;

    @VisibleForTesting
    private t(Context context) {
        Object applicationContext = context.getApplicationContext();
        ar.a(applicationContext);
        this.b = applicationContext;
    }

    public static t a(Context context) {
        ar.a((Object) context);
        if (a == null) {
            synchronized (t.class) {
                if (a == null) {
                    a = new t(context);
                }
            }
        }
        return a;
    }

    private static void b(q qVar) {
        ar.c("deliver should be called from worker thread");
        ar.b(qVar.f(), "Measurement must be submitted");
        List<zzo> c = qVar.c();
        if (!c.isEmpty()) {
            Set hashSet = new HashSet();
            for (zzo zzo : c) {
                Uri zzk = zzo.zzk();
                if (!hashSet.contains(zzk)) {
                    hashSet.add(zzk);
                    zzo.zzb(qVar);
                }
            }
        }
    }

    public static void d() {
        if (!(Thread.currentThread() instanceof w)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final jc a() {
        if (this.f == null) {
            synchronized (this) {
                if (this.f == null) {
                    jc jcVar = new jc();
                    PackageManager packageManager = this.b.getPackageManager();
                    String packageName = this.b.getPackageName();
                    jcVar.c(packageName);
                    jcVar.d(packageManager.getInstallerPackageName(packageName));
                    String str = null;
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(this.b.getPackageName(), 0);
                        if (packageInfo != null) {
                            CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                            if (!TextUtils.isEmpty(applicationLabel)) {
                                packageName = applicationLabel.toString();
                            }
                            str = packageInfo.versionName;
                        }
                    } catch (NameNotFoundException e) {
                        String str2 = "GAv4";
                        String str3 = "Error retrieving package info: appName set to ";
                        String valueOf = String.valueOf(packageName);
                        Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                    }
                    jcVar.a(packageName);
                    jcVar.b(str);
                    this.f = jcVar;
                }
            }
        }
        return this.f;
    }

    public final <V> Future<V> a(Callable<V> callable) {
        ar.a((Object) callable);
        if (!(Thread.currentThread() instanceof w)) {
            return this.e.submit(callable);
        }
        Future futureTask = new FutureTask(callable);
        futureTask.run();
        return futureTask;
    }

    final void a(q qVar) {
        if (qVar.i()) {
            throw new IllegalStateException("Measurement prototype can't be submitted");
        } else if (qVar.f()) {
            throw new IllegalStateException("Measurement can only be submitted once");
        } else {
            q a = qVar.a();
            a.g();
            this.e.execute(new x(this, a));
        }
    }

    public final void a(Runnable runnable) {
        ar.a((Object) runnable);
        this.e.submit(runnable);
    }

    public final void a(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.g = uncaughtExceptionHandler;
    }

    public final jz b() {
        DisplayMetrics displayMetrics = this.b.getResources().getDisplayMetrics();
        jz jzVar = new jz();
        jzVar.a(cj.a(Locale.getDefault()));
        jzVar.b = displayMetrics.widthPixels;
        jzVar.c = displayMetrics.heightPixels;
        return jzVar;
    }

    public final Context c() {
        return this.b;
    }
}
