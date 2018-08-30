package com.appnext.base.receivers.imp;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.appnext.base.b;
import com.appnext.base.b.c;
import com.appnext.base.b.l;
import com.appnext.base.receivers.a;

public class scror extends a {
    public static final String he = scror.class.getSimpleName();

    public IntentFilter getBRFilter() {
        try {
            return !hasPermission() ? null : new IntentFilter("android.intent.action.CONFIGURATION_CHANGED");
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
            if ("android.intent.action.CONFIGURATION_CHANGED".equals(intent.getAction())) {
                a(he, context.getResources().getConfiguration().orientation == 2 ? "LANDSCAPE" : "PORTRAIT", c.a.String);
            }
        } catch (Throwable th) {
            b.a(th);
        }
    }
}
