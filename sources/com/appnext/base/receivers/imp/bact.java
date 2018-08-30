package com.appnext.base.receivers.imp;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.appnext.base.b;
import com.appnext.base.b.c;
import com.appnext.base.b.d;
import com.appnext.base.b.f;
import com.appnext.base.b.l;
import com.appnext.base.receivers.a;

public class bact extends a {
    public static final String he = bact.class.getSimpleName();

    public IntentFilter getBRFilter() {
        try {
            if (!hasPermission()) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            return intentFilter;
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }

    public boolean hasPermission() {
        return f.g(d.getContext(), "android.permission.BLUETOOTH");
    }

    public void onReceive(Context context, final Intent intent) {
        try {
            l.k("Receiver", getClass().getSimpleName());
            super.onReceive(context, intent);
            new Thread(new Runnable() {
                public void run() {
                    String str = null;
                    if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
                        intent.getExtras();
                        int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                        if (intExtra == 10 || intExtra == 13) {
                            str = "false";
                        } else if (intExtra == 12 || intExtra == 11) {
                            str = "true";
                        }
                    }
                    bact.this.a(bact.he, str, c.a.Boolean);
                }
            }).start();
        } catch (Throwable th) {
            b.a(th);
        }
    }
}
