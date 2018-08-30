package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.d;
import java.util.Collections;
import java.util.List;

public class b {
    private static final Object a = new Object();
    private static volatile b b;
    @VisibleForTesting
    private static boolean c = false;
    private final List<String> d = Collections.EMPTY_LIST;
    private final List<String> e = Collections.EMPTY_LIST;
    private final List<String> f = Collections.EMPTY_LIST;
    private final List<String> g = Collections.EMPTY_LIST;

    private b() {
    }

    public static b a() {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    @SuppressLint({"UntrackedBindService"})
    private static boolean a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i, boolean z) {
        if (z) {
            ComponentName component = intent.getComponent();
            if (component == null ? false : d.c(context, component.getPackageName())) {
                Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                return false;
            }
        }
        return context.bindService(intent, serviceConnection, i);
    }

    @SuppressLint({"UntrackedBindService"})
    public void a(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
    }

    public void a(Context context, ServiceConnection serviceConnection, String str, Intent intent) {
    }

    public boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return a(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    public boolean a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        return a(context, str, intent, serviceConnection, i, true);
    }

    public void b(Context context, ServiceConnection serviceConnection) {
    }
}
