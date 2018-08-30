package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.h;
import java.util.List;

public class f {
    private static f a = new f();
    private static Boolean b;
    @VisibleForTesting
    private static boolean c = false;

    public static f a() {
        return a;
    }

    public void a(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list) {
        a(context, str, i, str2, str3, str4, i2, list, 0);
    }

    public void a(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list, long j) {
        if (b == null) {
            b = Boolean.valueOf(false);
        }
        if (!b.booleanValue()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            String str5 = "WakeLockTracker";
            String str6 = "missing wakeLock key. ";
            String valueOf = String.valueOf(str);
            Log.e(str5, valueOf.length() != 0 ? str6.concat(valueOf) : new String(str6));
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (7 == i || 8 == i || 10 == i || 11 == i) {
            List list2;
            if (list == null || list.size() != 1) {
                List<String> list22 = list;
            } else {
                if ("com.google.android.gms".equals(list.get(0))) {
                    list = null;
                }
                list22 = list;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int a = h.a(context);
            String packageName = context.getPackageName();
            if ("com.google.android.gms".equals(packageName)) {
                packageName = null;
            }
            try {
                context.startService(new Intent().setComponent(c.a).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", new WakeLockEvent(currentTimeMillis, i, str2, i2, list22, str, elapsedRealtime, a, str3, packageName, h.b(context), j, str4)));
            } catch (Throwable e) {
                Log.wtf("WakeLockTracker", e);
            }
        }
    }
}
