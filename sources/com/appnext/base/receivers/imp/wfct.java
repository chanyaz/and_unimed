package com.appnext.base.receivers.imp;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.appnext.base.b;
import com.appnext.base.b.c;
import com.appnext.base.b.d;
import com.appnext.base.b.f;
import com.appnext.base.receivers.a;

public class wfct extends a {
    public static final String he = wfct.class.getSimpleName();

    public IntentFilter getBRFilter() {
        try {
            return !hasPermission() ? null : new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED");
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }

    public boolean hasPermission() {
        return f.g(d.getContext().getApplicationContext(), "android.permission.ACCESS_WIFI_STATE");
    }

    public void onReceive(Context context, Intent intent) {
        boolean z = true;
        try {
            super.onReceive(context, intent);
            if (hasPermission()) {
                int intExtra = intent.getIntExtra("wifi_state", 4);
                if (intExtra != 3) {
                    if (intExtra == 1) {
                        z = false;
                    } else {
                        return;
                    }
                }
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        wfct.this.a(wfct.he, String.valueOf(z), c.a.Boolean);
                    }
                }, 15000);
            }
        } catch (Throwable th) {
            b.a(th);
        }
    }
}
