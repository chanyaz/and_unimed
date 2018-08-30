package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class afi extends BroadcastReceiver {
    private final /* synthetic */ afh a;

    afi(afh afh) {
        this.a = afh;
    }

    public final void onReceive(Context context, Intent intent) {
        this.a.a(3);
    }
}
