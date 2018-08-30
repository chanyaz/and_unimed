package com.google.android.gms.internal.ads;

import android.util.Log;
import java.util.Locale;

public class dc {
    public static boolean a;
    private static String b;

    static {
        String str = "Volley";
        b = str;
        a = Log.isLoggable(str, 2);
    }

    public static void a(String str, Object... objArr) {
        if (a) {
            Log.v(b, d(str, objArr));
        }
    }

    public static void a(Throwable th, String str, Object... objArr) {
        Log.e(b, d(str, objArr), th);
    }

    public static void b(String str, Object... objArr) {
        Log.d(b, d(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(b, d(str, objArr));
    }

    private static String d(String str, Object... objArr) {
        String methodName;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        String str2 = "<unknown>";
        for (int i = 2; i < stackTrace.length; i++) {
            if (!stackTrace[i].getClass().equals(dc.class)) {
                str2 = stackTrace[i].getClassName();
                str2 = str2.substring(str2.lastIndexOf(46) + 1);
                str2 = str2.substring(str2.lastIndexOf(36) + 1);
                methodName = stackTrace[i].getMethodName();
                methodName = new StringBuilder((String.valueOf(str2).length() + 1) + String.valueOf(methodName).length()).append(str2).append(".").append(methodName).toString();
                break;
            }
        }
        methodName = str2;
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), methodName, str});
    }
}
