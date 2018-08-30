package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.GuardedBy;

@zzadh
public final class gj {
    private final AtomicReference<ThreadPoolExecutor> a = new AtomicReference(null);
    private final Object b = new Object();
    @Nullable
    @GuardedBy("mGmpAppIdLock")
    private String c = null;
    @VisibleForTesting
    private final AtomicBoolean d = new AtomicBoolean(false);
    @VisibleForTesting
    private final AtomicInteger e = new AtomicInteger(-1);
    private final AtomicReference<Object> f = new AtomicReference(null);
    private final AtomicReference<Object> g = new AtomicReference(null);
    private ConcurrentMap<String, Method> h = new ConcurrentHashMap(9);

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0010  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x0010  */
    private static android.os.Bundle a(android.content.Context r6, java.lang.String r7, boolean r8) {
        /*
        r2 = new android.os.Bundle;
        r2.<init>();
        r0 = "_aeid";
        r4 = java.lang.Long.parseLong(r7);	 Catch:{ NullPointerException -> 0x0017, NumberFormatException -> 0x0032 }
        r2.putLong(r0, r4);	 Catch:{ NullPointerException -> 0x0017, NumberFormatException -> 0x0032 }
    L_0x000e:
        if (r8 == 0) goto L_0x0016;
    L_0x0010:
        r0 = "_r";
        r1 = 1;
        r2.putInt(r0, r1);
    L_0x0016:
        return r2;
    L_0x0017:
        r0 = move-exception;
    L_0x0018:
        r3 = "Invalid event ID: ";
        r1 = java.lang.String.valueOf(r7);
        r4 = r1.length();
        if (r4 == 0) goto L_0x002c;
    L_0x0024:
        r1 = r3.concat(r1);
    L_0x0028:
        com.google.android.gms.internal.ads.kk.b(r1, r0);
        goto L_0x000e;
    L_0x002c:
        r1 = new java.lang.String;
        r1.<init>(r3);
        goto L_0x0028;
    L_0x0032:
        r0 = move-exception;
        goto L_0x0018;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.gj.a(android.content.Context, java.lang.String, boolean):android.os.Bundle");
    }

    private final Object a(String str, Context context) {
        Object obj = null;
        if (!a(context, "com.google.android.gms.measurement.AppMeasurement", this.f, true)) {
            return obj;
        }
        try {
            return h(context, str).invoke(this.f.get(), new Object[0]);
        } catch (Exception e) {
            a(e, str, true);
            return obj;
        }
    }

    private final void a(Context context, String str, Bundle bundle) {
        if (a(context) && a(context, "com.google.android.gms.measurement.AppMeasurement", this.f, true)) {
            Method l = l(context);
            try {
                l.invoke(this.f.get(), new Object[]{"am", str, bundle});
            } catch (Exception e) {
                a(e, "logEventInternal", true);
            }
        }
    }

    private final void a(Exception exception, String str, boolean z) {
        if (!this.d.get()) {
            kk.e(new StringBuilder(String.valueOf(str).length() + 30).append("Invoke Firebase method ").append(str).append(" error.").toString());
            if (z) {
                kk.e("The Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires the latest Firebase SDK jar, but Firebase SDK is either missing or out of date");
                this.d.set(true);
            }
        }
    }

    private final boolean a(Context context, String str, AtomicReference<Object> atomicReference, boolean z) {
        if (atomicReference.get() == null) {
            try {
                atomicReference.compareAndSet(null, context.getClassLoader().loadClass(str).getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{context}));
            } catch (Exception e) {
                a(e, "getInstance", z);
                return false;
            }
        }
        return true;
    }

    private final void b(Context context, String str, String str2) {
        if (a(context, "com.google.android.gms.measurement.AppMeasurement", this.f, true)) {
            Method g = g(context, str2);
            try {
                g.invoke(this.f.get(), new Object[]{str});
                hl.a(new StringBuilder((String.valueOf(str2).length() + 37) + String.valueOf(str).length()).append("Invoke Firebase method ").append(str2).append(", Ad Unit Id: ").append(str).toString());
            } catch (Exception e) {
                a(e, str2, false);
            }
        }
    }

    private final Method g(Context context, String str) {
        Method method = (Method) this.h.get(str);
        if (method != null) {
            return method;
        }
        try {
            method = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[]{String.class});
            this.h.put(str, method);
            return method;
        } catch (Exception e) {
            a(e, str, false);
            return null;
        }
    }

    private final Method h(Context context, String str) {
        Method method = (Method) this.h.get(str);
        if (method != null) {
            return method;
        }
        try {
            method = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[0]);
            this.h.put(str, method);
            return method;
        } catch (Exception e) {
            a(e, str, false);
            return null;
        }
    }

    private final Method i(Context context, String str) {
        Method method = (Method) this.h.get(str);
        if (method != null) {
            return method;
        }
        try {
            method = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod(str, new Class[]{Activity.class, String.class, String.class});
            this.h.put(str, method);
            return method;
        } catch (Exception e) {
            a(e, str, false);
            return null;
        }
    }

    private final Method l(Context context) {
        Method method = (Method) this.h.get("logEventInternal");
        if (method != null) {
            return method;
        }
        try {
            method = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod("logEventInternal", new Class[]{String.class, String.class, Bundle.class});
            this.h.put("logEventInternal", method);
            return method;
        } catch (Exception e) {
            a(e, "logEventInternal", true);
            return null;
        }
    }

    public final void a(Context context, String str) {
        if (a(context)) {
            b(context, str, "beginAdUnitExposure");
        }
    }

    public final void a(Context context, String str, String str2) {
        if (a(context)) {
            a(context, str, a(context, str2, "_ac".equals(str)));
        }
    }

    public final void a(Context context, String str, String str2, String str3, int i) {
        if (a(context)) {
            Bundle a = a(context, str, false);
            a.putString("_ai", str2);
            a.putString("type", str3);
            a.putInt("value", i);
            a(context, "_ar", a);
            hl.a(new StringBuilder(String.valueOf(str3).length() + 75).append("Log a Firebase reward video event, reward type: ").append(str3).append(", reward value: ").append(i).toString());
        }
    }

    public final boolean a(Context context) {
        if (!((Boolean) akc.f().a(amn.al)).booleanValue() || this.d.get()) {
            return false;
        }
        if (this.e.get() == -1) {
            akc.a();
            if (!kb.c(context)) {
                akc.a();
                if (kb.f(context)) {
                    kk.e("Google Play Service is out of date, the Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires updated Google Play Service.");
                    this.e.set(0);
                }
            }
            this.e.set(1);
        }
        return this.e.get() == 1;
    }

    public final void b(Context context, String str) {
        if (a(context)) {
            b(context, str, "endAdUnitExposure");
        }
    }

    public final boolean b(Context context) {
        return ((Boolean) akc.f().a(amn.am)).booleanValue() && a(context);
    }

    public final void c(Context context, String str) {
        if (a(context) && (context instanceof Activity) && a(context, "com.google.firebase.analytics.FirebaseAnalytics", this.g, false)) {
            Method i = i(context, "setCurrentScreen");
            try {
                Activity activity = (Activity) context;
                i.invoke(this.g.get(), new Object[]{activity, str, context.getPackageName()});
            } catch (Exception e) {
                a(e, "setCurrentScreen", false);
            }
        }
    }

    public final boolean c(Context context) {
        return ((Boolean) akc.f().a(amn.an)).booleanValue() && a(context);
    }

    public final void d(Context context, String str) {
        a(context, "_ac", str);
    }

    public final boolean d(Context context) {
        return ((Boolean) akc.f().a(amn.ao)).booleanValue() && a(context);
    }

    public final void e(Context context, String str) {
        a(context, "_ai", str);
    }

    public final boolean e(Context context) {
        return ((Boolean) akc.f().a(amn.ap)).booleanValue() && a(context);
    }

    public final void f(Context context, String str) {
        a(context, "_aq", str);
    }

    public final boolean f(Context context) {
        return ((Boolean) akc.f().a(amn.as)).booleanValue() && a(context);
    }

    public final String g(Context context) {
        if (!a(context)) {
            return "";
        }
        if (!a(context, "com.google.android.gms.measurement.AppMeasurement", this.f, true)) {
            return "";
        }
        try {
            String str = (String) h(context, "getCurrentScreenName").invoke(this.f.get(), new Object[0]);
            if (str == null) {
                str = (String) h(context, "getCurrentScreenClass").invoke(this.f.get(), new Object[0]);
            }
            return str == null ? "" : str;
        } catch (Exception e) {
            a(e, "getCurrentScreenName", false);
            return "";
        }
    }

    @Nullable
    public final String h(Context context) {
        if (!a(context)) {
            return null;
        }
        synchronized (this.b) {
            String str;
            if (this.c != null) {
                str = this.c;
                return str;
            }
            this.c = (String) a("getGmpAppId", context);
            str = this.c;
            return str;
        }
    }

    @Nullable
    public final String i(Context context) {
        if (!a(context)) {
            return null;
        }
        long longValue = ((Long) akc.f().a(amn.av)).longValue();
        if (longValue < 0) {
            return (String) a("getAppInstanceId", context);
        }
        if (this.a.get() == null) {
            this.a.compareAndSet(null, new ThreadPoolExecutor(((Integer) akc.f().a(amn.aw)).intValue(), ((Integer) akc.f().a(amn.aw)).intValue(), 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), new gm(this)));
        }
        Future submit = ((ThreadPoolExecutor) this.a.get()).submit(new gk(this, context));
        try {
            return (String) submit.get(longValue, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            submit.cancel(true);
            return e instanceof TimeoutException ? "TIME_OUT" : null;
        }
    }

    @Nullable
    public final String j(Context context) {
        if (!a(context)) {
            return null;
        }
        Object a = a("generateEventId", context);
        return a != null ? a.toString() : null;
    }

    final /* synthetic */ String k(Context context) {
        return (String) a("getAppInstanceId", context);
    }
}
