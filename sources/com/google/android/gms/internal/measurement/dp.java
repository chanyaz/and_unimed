package com.google.android.gms.internal.measurement;

import android.support.annotation.GuardedBy;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;

public final class dp extends fo {
    private char a = 0;
    private long b = -1;
    @GuardedBy("this")
    private String c;
    private final dr d = new dr(this, 6, false, false);
    private final dr e = new dr(this, 6, true, false);
    private final dr f = new dr(this, 6, false, true);
    private final dr g = new dr(this, 5, false, false);
    private final dr h = new dr(this, 5, true, false);
    private final dr i = new dr(this, 5, false, true);
    private final dr j = new dr(this, 4, false, false);
    private final dr k = new dr(this, 3, false, false);
    private final dr l = new dr(this, 2, false, false);

    dp(es esVar) {
        super(esVar);
    }

    private final String E() {
        String str;
        synchronized (this) {
            if (this.c == null) {
                this.c = (String) dg.b.b();
            }
            str = this.c;
        }
        return str;
    }

    protected static Object a(String str) {
        return str == null ? null : new ds(str);
    }

    @VisibleForTesting
    private static String a(boolean z, Object obj) {
        if (obj == null) {
            return "";
        }
        Object valueOf = obj instanceof Integer ? Long.valueOf((long) ((Integer) obj).intValue()) : obj;
        if (valueOf instanceof Long) {
            if (!z) {
                return String.valueOf(valueOf);
            }
            if (Math.abs(((Long) valueOf).longValue()) < 100) {
                return String.valueOf(valueOf);
            }
            String str = String.valueOf(valueOf).charAt(0) == '-' ? "-" : "";
            String valueOf2 = String.valueOf(Math.abs(((Long) valueOf).longValue()));
            return new StringBuilder((String.valueOf(str).length() + 43) + String.valueOf(str).length()).append(str).append(Math.round(Math.pow(10.0d, (double) (valueOf2.length() - 1)))).append("...").append(str).append(Math.round(Math.pow(10.0d, (double) valueOf2.length()) - 1.0d)).toString();
        } else if (valueOf instanceof Boolean) {
            return String.valueOf(valueOf);
        } else {
            if (!(valueOf instanceof Throwable)) {
                return valueOf instanceof ds ? ((ds) valueOf).a : z ? "-" : String.valueOf(valueOf);
            } else {
                Throwable th = (Throwable) valueOf;
                StringBuilder stringBuilder = new StringBuilder(z ? th.getClass().getName() : th.toString());
                String b = b(AppMeasurement.class.getCanonicalName());
                String b2 = b(es.class.getCanonicalName());
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (!stackTraceElement.isNativeMethod()) {
                        String className = stackTraceElement.getClassName();
                        if (className != null) {
                            className = b(className);
                            if (className.equals(b) || className.equals(b2)) {
                                stringBuilder.append(": ");
                                stringBuilder.append(stackTraceElement);
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                return stringBuilder.toString();
            }
        }
    }

    static String a(boolean z, String str, Object obj, Object obj2, Object obj3) {
        Object str2;
        if (str2 == null) {
            str2 = "";
        }
        Object a = a(z, obj);
        Object a2 = a(z, obj2);
        Object a3 = a(z, obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str3 = "";
        if (!TextUtils.isEmpty(str2)) {
            stringBuilder.append(str2);
            str3 = ": ";
        }
        if (!TextUtils.isEmpty(a)) {
            stringBuilder.append(str3);
            stringBuilder.append(a);
            str3 = ", ";
        }
        if (!TextUtils.isEmpty(a2)) {
            stringBuilder.append(str3);
            stringBuilder.append(a2);
            str3 = ", ";
        }
        if (!TextUtils.isEmpty(a3)) {
            stringBuilder.append(str3);
            stringBuilder.append(a3);
        }
        return stringBuilder.toString();
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf != -1 ? str.substring(0, lastIndexOf) : str;
    }

    @VisibleForTesting
    protected final void a(int i, String str) {
        Log.println(i, E(), str);
    }

    protected final void a(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        int i2 = 0;
        if (!z && a(i)) {
            a(i, a(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            ar.a((Object) str);
            fo g = this.q.g();
            if (g == null) {
                a(6, "Scheduler not set. Not logging error/warn");
            } else if (g.A()) {
                if (i >= 0) {
                    i2 = i;
                }
                if (i2 >= 9) {
                    i2 = 8;
                }
                g.a(new dq(this, i2, str, obj, obj2, obj3));
            } else {
                a(6, "Scheduler not initialized. Not logging error/warn");
            }
        }
    }

    @VisibleForTesting
    protected final boolean a(int i) {
        return Log.isLoggable(E(), i);
    }

    protected final boolean p() {
        return false;
    }

    public final dr r() {
        return this.d;
    }

    public final dr s() {
        return this.e;
    }

    public final dr t() {
        return this.f;
    }

    public final dr u() {
        return this.g;
    }

    public final dr v() {
        return this.i;
    }

    public final dr w() {
        return this.j;
    }

    public final dr x() {
        return this.k;
    }

    public final dr y() {
        return this.l;
    }

    public final String z() {
        Pair a = n().b.a();
        if (a == null || a == dz.a) {
            return null;
        }
        String valueOf = String.valueOf(a.second);
        String str = (String) a.first;
        return new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(str).length()).append(valueOf).append(":").append(str).toString();
    }
}
