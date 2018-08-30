package com.google.android.gms.internal.measurement;

import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashSet;
import java.util.Set;

public final class bd {
    private final ah a;
    private volatile Boolean b;
    private String c;
    private Set<Integer> d;

    protected bd(ah ahVar) {
        ar.a((Object) ahVar);
        this.a = ahVar;
    }

    public static boolean b() {
        return ((Boolean) bk.a.a()).booleanValue();
    }

    public static int c() {
        return ((Integer) bk.r.a()).intValue();
    }

    public static long d() {
        return ((Long) bk.f.a()).longValue();
    }

    public static long e() {
        return ((Long) bk.g.a()).longValue();
    }

    public static int f() {
        return ((Integer) bk.i.a()).intValue();
    }

    public static int g() {
        return ((Integer) bk.j.a()).intValue();
    }

    @VisibleForTesting
    public static String h() {
        return (String) bk.l.a();
    }

    @VisibleForTesting
    public static String i() {
        return (String) bk.k.a();
    }

    public static String j() {
        return (String) bk.m.a();
    }

    public static long l() {
        return ((Long) bk.y.a()).longValue();
    }

    public final boolean a() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    ApplicationInfo applicationInfo = this.a.a().getApplicationInfo();
                    String a = ProcessUtils.a();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = str != null && str.equals(a);
                        this.b = Boolean.valueOf(z);
                    }
                    if ((this.b == null || !this.b.booleanValue()) && "com.google.android.gms.analytics".equals(a)) {
                        this.b = Boolean.TRUE;
                    }
                    if (this.b == null) {
                        this.b = Boolean.TRUE;
                        this.a.e().f("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.b.booleanValue();
    }

    public final Set<Integer> k() {
        String str = (String) bk.u.a();
        if (this.d == null || this.c == null || !this.c.equals(str)) {
            String[] split = TextUtils.split(str, ",");
            Set hashSet = new HashSet();
            for (String parseInt : split) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(parseInt)));
                } catch (NumberFormatException e) {
                }
            }
            this.c = str;
            this.d = hashSet;
        }
        return this.d;
    }
}
