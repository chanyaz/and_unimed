package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class jy extends BroadcastReceiver {
    private final /* synthetic */ jx a;

    jy(jx jxVar) {
        this.a = jxVar;
    }

    public final void onReceive(Context context, Intent intent) {
        this.a.a(context, intent);
    }
}
