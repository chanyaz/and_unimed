package com.google.android.gms.common.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Process;
import android.os.WorkSource;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.a.c;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class v {
    private static final int a = Process.myUid();
    private static final Method b = a();
    private static final Method c = b();
    private static final Method d = c();
    private static final Method e = d();
    private static final Method f = e();
    private static final Method g = f();
    private static final Method h = g();

    private v() {
    }

    public static int a(WorkSource workSource) {
        if (d != null) {
            try {
                return ((Integer) d.invoke(workSource, new Object[0])).intValue();
            } catch (Throwable e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        }
        return 0;
    }

    public static WorkSource a(int i, String str) {
        WorkSource workSource = new WorkSource();
        a(workSource, i, str);
        return workSource;
    }

    @Nullable
    public static WorkSource a(Context context, @Nullable String str) {
        if (context == null || context.getPackageManager() == null || str == null) {
            return null;
        }
        String str2;
        String str3;
        String valueOf;
        try {
            ApplicationInfo a = c.b(context).a(str, 0);
            if (a != null) {
                return a(a.uid, str);
            }
            str2 = "WorkSourceUtil";
            str3 = "Could not get applicationInfo from package: ";
            valueOf = String.valueOf(str);
            Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return null;
        } catch (NameNotFoundException e) {
            str2 = "WorkSourceUtil";
            str3 = "Could not find package: ";
            valueOf = String.valueOf(str);
            Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return null;
        }
    }

    public static WorkSource a(Context context, String str, String str2) {
        WorkSource workSource = null;
        if (context == null || context.getPackageManager() == null || str2 == null || str == null) {
            Log.w("WorkSourceUtil", "Unexpected null arguments");
        } else {
            int b = b(context, str);
            if (b >= 0) {
                workSource = new WorkSource();
                if (g == null || h == null) {
                    a(workSource, b, str);
                } else {
                    try {
                        Object invoke = g.invoke(workSource, new Object[0]);
                        if (b != a) {
                            h.invoke(invoke, new Object[]{Integer.valueOf(b), str});
                        }
                        h.invoke(invoke, new Object[]{Integer.valueOf(a), str2});
                    } catch (Throwable e) {
                        Log.w("WorkSourceUtil", "Unable to assign chained blame through WorkSource", e);
                    }
                }
            }
        }
        return workSource;
    }

    @Nullable
    public static String a(WorkSource workSource, int i) {
        if (f != null) {
            try {
                return (String) f.invoke(workSource, new Object[]{Integer.valueOf(i)});
            } catch (Throwable e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        }
        return null;
    }

    private static Method a() {
        Method method = null;
        try {
            return WorkSource.class.getMethod("add", new Class[]{Integer.TYPE});
        } catch (Exception e) {
            return method;
        }
    }

    public static void a(WorkSource workSource, int i, @Nullable String str) {
        if (c != null) {
            if (str == null) {
                str = "";
            }
            try {
                c.invoke(workSource, new Object[]{Integer.valueOf(i), str});
            } catch (Throwable e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        } else if (b != null) {
            try {
                b.invoke(workSource, new Object[]{Integer.valueOf(i)});
            } catch (Throwable e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        }
    }

    public static boolean a(Context context) {
        return (context == null || context.getPackageManager() == null || c.b(context).a("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) ? false : true;
    }

    private static int b(Context context, String str) {
        String str2;
        String str3;
        String valueOf;
        try {
            ApplicationInfo a = c.b(context).a(str, 0);
            if (a != null) {
                return a.uid;
            }
            str2 = "WorkSourceUtil";
            str3 = "Could not get applicationInfo from package: ";
            valueOf = String.valueOf(str);
            Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return -1;
        } catch (NameNotFoundException e) {
            str2 = "WorkSourceUtil";
            str3 = "Could not find package: ";
            valueOf = String.valueOf(str);
            Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return -1;
        }
    }

    private static Method b() {
        Method method = null;
        if (!p.f()) {
            return method;
        }
        try {
            return WorkSource.class.getMethod("add", new Class[]{Integer.TYPE, String.class});
        } catch (Exception e) {
            return method;
        }
    }

    public static List<String> b(@Nullable WorkSource workSource) {
        int i = 0;
        int a = workSource == null ? 0 : a(workSource);
        if (a == 0) {
            return Collections.emptyList();
        }
        List<String> arrayList = new ArrayList();
        while (i < a) {
            String a2 = a(workSource, i);
            if (!r.b(a2)) {
                arrayList.add(a2);
            }
            i++;
        }
        return arrayList;
    }

    private static Method c() {
        Method method = null;
        try {
            return WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception e) {
            return method;
        }
    }

    private static Method d() {
        Method method = null;
        try {
            return WorkSource.class.getMethod("get", new Class[]{Integer.TYPE});
        } catch (Exception e) {
            return method;
        }
    }

    private static Method e() {
        Method method = null;
        if (!p.f()) {
            return method;
        }
        try {
            return WorkSource.class.getMethod("getName", new Class[]{Integer.TYPE});
        } catch (Exception e) {
            return method;
        }
    }

    private static final Method f() {
        Method method = null;
        if (!p.m()) {
            return method;
        }
        try {
            return WorkSource.class.getMethod("createWorkChain", new Class[0]);
        } catch (Throwable e) {
            Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", e);
            return method;
        }
    }

    @SuppressLint({"PrivateApi"})
    private static final Method g() {
        Method method = null;
        if (!p.m()) {
            return method;
        }
        try {
            return Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", new Class[]{Integer.TYPE, String.class});
        } catch (Throwable e) {
            Log.w("WorkSourceUtil", "Missing WorkChain class", e);
            return method;
        }
    }
}
