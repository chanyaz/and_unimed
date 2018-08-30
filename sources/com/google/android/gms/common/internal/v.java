package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;

public abstract class v {
    private static final Object a = new Object();
    private static v b;

    public static v a(Context context) {
        synchronized (a) {
            if (b == null) {
                b = new bf(context.getApplicationContext());
            }
        }
        return b;
    }

    protected abstract boolean a(w wVar, ServiceConnection serviceConnection, String str);

    public boolean a(String str, String str2, int i, ServiceConnection serviceConnection, String str3) {
        return a(new w(str, str2, i), serviceConnection, str3);
    }

    protected abstract void b(w wVar, ServiceConnection serviceConnection, String str);

    public void b(String str, String str2, int i, ServiceConnection serviceConnection, String str3) {
        b(new w(str, str2, i), serviceConnection, str3);
    }
}
