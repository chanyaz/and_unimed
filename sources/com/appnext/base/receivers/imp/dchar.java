package com.appnext.base.receivers.imp;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.appnext.base.b;
import com.appnext.base.b.c;
import com.appnext.base.b.f;
import com.appnext.base.b.l;
import com.appnext.base.receivers.a;

public class dchar extends a {
    public static final String he = dchar.class.getSimpleName();

    public IntentFilter getBRFilter() {
        try {
            if (!hasPermission()) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
            return intentFilter;
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }

    public boolean hasPermission() {
        return true;
    }

    public void onReceive(Context context, Intent intent) {
        try {
            super.onReceive(context, intent);
            l.k("Receiver", he);
            a(he, String.valueOf(Boolean.valueOf(f.k(context.getApplicationContext()))), c.a.Boolean);
        } catch (Throwable th) {
            b.a(th);
        }
    }
}
