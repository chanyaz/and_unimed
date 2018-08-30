package com.appnext.base.receivers.imp;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.appnext.base.b;
import com.appnext.base.b.c;
import com.appnext.base.b.l;
import com.appnext.base.receivers.a;

public class earcon extends a {
    public static final String he = earcon.class.getSimpleName();

    public IntentFilter getBRFilter() {
        try {
            return !hasPermission() ? null : new IntentFilter("android.intent.action.HEADSET_PLUG");
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
            if ("android.intent.action.HEADSET_PLUG".equals(intent.getAction())) {
                a(he, intent.getIntExtra("state", -1) == 0 ? "false" : "true", c.a.Boolean);
            }
        } catch (Throwable th) {
            b.a(th);
        }
    }
}
