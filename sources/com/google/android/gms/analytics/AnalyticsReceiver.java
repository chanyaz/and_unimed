package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.internal.measurement.ca;

public final class AnalyticsReceiver extends BroadcastReceiver {
    private ca a;

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final void onReceive(Context context, Intent intent) {
        if (this.a == null) {
            this.a = new ca();
        }
        ca.a(context, intent);
    }
}
