package com.appnext.base.receivers.imp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.appnext.base.b;
import com.appnext.base.b.d;
import com.appnext.base.b.k;
import com.appnext.base.b.l;

public class bootreceiver extends BroadcastReceiver {
    public static final String TAG = bootreceiver.class.getSimpleName();

    public void onReceive(Context context, Intent intent) {
        try {
            l.k("Receiver", getClass().getSimpleName());
            if (context != null && intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
                d.init(context);
                k.o(context);
            }
        } catch (Throwable th) {
            b.a(th);
        }
    }
}
