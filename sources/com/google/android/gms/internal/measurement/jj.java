package com.google.android.gms.internal.measurement;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Build.VERSION;
import android.support.v4.content.PermissionChecker;
import android.util.Log;
import javax.annotation.Nullable;

public abstract class jj<T> {
    private static final Object b = new Object();
    @SuppressLint({"StaticFieldLeak"})
    private static Context c = null;
    private static boolean d = false;
    private static volatile Boolean e = null;
    private static volatile Boolean f = null;
    final String a;
    private final jt g;
    private final String h;
    private final T i;
    private T j;
    private volatile jh k;
    private volatile SharedPreferences l;

    private jj(jt jtVar, String str, T t) {
        this.j = null;
        this.k = null;
        this.l = null;
        if (jtVar.b == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.g = jtVar;
        String valueOf = String.valueOf(jtVar.c);
        String valueOf2 = String.valueOf(str);
        this.h = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        valueOf = String.valueOf(jtVar.d);
        valueOf2 = String.valueOf(str);
        this.a = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        this.i = t;
    }

    /* synthetic */ jj(jt jtVar, String str, Object obj, jn jnVar) {
        this(jtVar, str, obj);
    }

    private static <V> V a(zzxb<V> zzxb) {
        long clearCallingIdentity;
        try {
            return zzxb.zzsc();
        } catch (SecurityException e) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            V zzsc = zzxb.zzsc();
            return zzsc;
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    public static void a(Context context) {
        synchronized (b) {
            if (VERSION.SDK_INT < 24 || !context.isDeviceProtectedStorage()) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    context = applicationContext;
                }
            }
            if (c != context) {
                e = null;
            }
            c = context;
        }
        d = false;
    }

    static boolean a(String str, boolean z) {
        try {
            return e() ? ((Boolean) a(new jm(str, false))).booleanValue() : false;
        } catch (Throwable e) {
            Log.e("PhenotypeFlag", "Unable to read GServices, returning default value.", e);
            return false;
        }
    }

    private static jj<Double> b(jt jtVar, String str, double d) {
        return new jq(jtVar, str, Double.valueOf(d));
    }

    private static jj<Integer> b(jt jtVar, String str, int i) {
        return new jo(jtVar, str, Integer.valueOf(i));
    }

    private static jj<Long> b(jt jtVar, String str, long j) {
        return new jn(jtVar, str, Long.valueOf(j));
    }

    private static jj<String> b(jt jtVar, String str, String str2) {
        return new js(jtVar, str, str2);
    }

    private static jj<Boolean> b(jt jtVar, String str, boolean z) {
        return new jp(jtVar, str, Boolean.valueOf(z));
    }

    @TargetApi(24)
    @Nullable
    private final T c() {
        String valueOf;
        if (a("gms:phenotype:phenotype_flag:debug_bypass_phenotype", false)) {
            String str = "PhenotypeFlag";
            String str2 = "Bypass reading Phenotype values for flag: ";
            valueOf = String.valueOf(this.a);
            Log.w(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        } else if (this.g.b != null) {
            if (this.k == null) {
                this.k = jh.a(c.getContentResolver(), this.g.b);
            }
            valueOf = (String) a(new jk(this, this.k));
            if (valueOf != null) {
                return a(valueOf);
            }
        } else {
            jt jtVar = this.g;
        }
        return null;
    }

    @Nullable
    private final T d() {
        jt jtVar = this.g;
        if (e()) {
            String str;
            try {
                str = (String) a(new jl(this));
                if (str != null) {
                    return a(str);
                }
            } catch (Throwable e) {
                Throwable th = e;
                String str2 = "PhenotypeFlag";
                String str3 = "Unable to read GServices for flag: ";
                str = String.valueOf(this.a);
                Log.e(str2, str.length() != 0 ? str3.concat(str) : new String(str3), th);
            }
        }
        return null;
    }

    private static boolean e() {
        boolean z = false;
        if (e == null) {
            if (c == null) {
                return false;
            }
            if (PermissionChecker.b(c, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                z = true;
            }
            e = Boolean.valueOf(z);
        }
        return e.booleanValue();
    }

    public final T a() {
        if (c == null) {
            throw new IllegalStateException("Must call PhenotypeFlag.init() first");
        }
        jt jtVar = this.g;
        T c = c();
        if (c != null) {
            return c;
        }
        c = d();
        return c == null ? this.i : c;
    }

    protected abstract T a(String str);

    final /* synthetic */ String b() {
        return jf.a(c.getContentResolver(), this.h, null);
    }
}
