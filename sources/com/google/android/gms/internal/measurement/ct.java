package com.google.android.gms.internal.measurement;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.a.c;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.reflect.InvocationTargetException;

public final class ct extends fn {
    @NonNull
    private zzeh a = cu.a;
    private Boolean b;

    ct(es esVar) {
        super(esVar);
    }

    public static long r() {
        return ((Long) dg.E.b()).longValue();
    }

    public static long s() {
        return ((Long) dg.e.b()).longValue();
    }

    public static boolean u() {
        return ((Boolean) dg.a.b()).booleanValue();
    }

    @WorkerThread
    public final int a(@Size(min = 1) String str) {
        return b(str, dg.p);
    }

    @WorkerThread
    public final long a(String str, @NonNull dh<Long> dhVar) {
        if (str == null) {
            return ((Long) dhVar.b()).longValue();
        }
        Object zze = this.a.zze(str, dhVar.a());
        if (TextUtils.isEmpty(zze)) {
            return ((Long) dhVar.b()).longValue();
        }
        try {
            return ((Long) dhVar.a(Long.valueOf(Long.parseLong(zze)))).longValue();
        } catch (NumberFormatException e) {
            return ((Long) dhVar.b()).longValue();
        }
    }

    final void a(@NonNull zzeh zzeh) {
        this.a = zzeh;
    }

    @WorkerThread
    public final int b(String str, @NonNull dh<Integer> dhVar) {
        if (str == null) {
            return ((Integer) dhVar.b()).intValue();
        }
        Object zze = this.a.zze(str, dhVar.a());
        if (TextUtils.isEmpty(zze)) {
            return ((Integer) dhVar.b()).intValue();
        }
        try {
            return ((Integer) dhVar.a(Integer.valueOf(Integer.parseInt(zze)))).intValue();
        } catch (NumberFormatException e) {
            return ((Integer) dhVar.b()).intValue();
        }
    }

    @Nullable
    @VisibleForTesting
    final Boolean b(@Size(min = 1) String str) {
        ar.a(str);
        try {
            if (getContext().getPackageManager() == null) {
                zzge().r().a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo a = c.b(getContext()).a(getContext().getPackageName(), 128);
            if (a == null) {
                zzge().r().a("Failed to load metadata: ApplicationInfo is null");
                return null;
            } else if (a.metaData != null) {
                return a.metaData.containsKey(str) ? Boolean.valueOf(a.metaData.getBoolean(str)) : null;
            } else {
                zzge().r().a("Failed to load metadata: Metadata bundle is null");
                return null;
            }
        } catch (NameNotFoundException e) {
            zzge().r().a("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    @WorkerThread
    public final double c(String str, @NonNull dh<Double> dhVar) {
        if (str == null) {
            return ((Double) dhVar.b()).doubleValue();
        }
        Object zze = this.a.zze(str, dhVar.a());
        if (TextUtils.isEmpty(zze)) {
            return ((Double) dhVar.b()).doubleValue();
        }
        try {
            return ((Double) dhVar.a(Double.valueOf(Double.parseDouble(zze)))).doubleValue();
        } catch (NumberFormatException e) {
            return ((Double) dhVar.b()).doubleValue();
        }
    }

    public final boolean c(String str) {
        return "1".equals(this.a.zze(str, "gaia_collection_enabled"));
    }

    public final boolean d(String str) {
        return "1".equals(this.a.zze(str, "measurement.event_sampling_enabled"));
    }

    @WorkerThread
    public final boolean d(String str, @NonNull dh<Boolean> dhVar) {
        if (str == null) {
            return ((Boolean) dhVar.b()).booleanValue();
        }
        Object zze = this.a.zze(str, dhVar.a());
        return TextUtils.isEmpty(zze) ? ((Boolean) dhVar.b()).booleanValue() : ((Boolean) dhVar.a(Boolean.valueOf(Boolean.parseBoolean(zze)))).booleanValue();
    }

    @WorkerThread
    final boolean e(String str) {
        return d(str, dg.N);
    }

    @WorkerThread
    final boolean f(String str) {
        return d(str, dg.P);
    }

    @WorkerThread
    final boolean g(String str) {
        return d(str, dg.Q);
    }

    final boolean h(String str) {
        return d(str, dg.R);
    }

    @WorkerThread
    final boolean i(String str) {
        return d(str, dg.S);
    }

    @WorkerThread
    final boolean j(String str) {
        return d(str, dg.U);
    }

    public final boolean p() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    ApplicationInfo applicationInfo = getContext().getApplicationInfo();
                    String a = ProcessUtils.a();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = str != null && str.equals(a);
                        this.b = Boolean.valueOf(z);
                    }
                    if (this.b == null) {
                        this.b = Boolean.TRUE;
                        zzge().r().a("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.b.booleanValue();
    }

    public final boolean q() {
        Boolean b = b("firebase_analytics_collection_deactivated");
        return b != null && b.booleanValue();
    }

    public final String t() {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{"debug.firebase.analytics.app", ""});
        } catch (ClassNotFoundException e) {
            zzge().r().a("Could not find SystemProperties class", e);
        } catch (NoSuchMethodException e2) {
            zzge().r().a("Could not find SystemProperties.get() method", e2);
        } catch (IllegalAccessException e3) {
            zzge().r().a("Could not access SystemProperties.get()", e3);
        } catch (InvocationTargetException e4) {
            zzge().r().a("SystemProperties.get() threw an exception", e4);
        }
        return "";
    }

    @WorkerThread
    final boolean v() {
        return d(f().s(), dg.I);
    }

    @WorkerThread
    final String w() {
        String s = f().s();
        dh dhVar = dg.J;
        return s == null ? (String) dhVar.b() : (String) dhVar.a(this.a.zze(s, dhVar.a()));
    }
}
