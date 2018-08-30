package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class age extends BroadcastReceiver {
    private final /* synthetic */ agc a;

    age(agc agc) {
        this.a = agc;
    }

    public final void onReceive(Context context, Intent intent) {
        this.a.a(3);
    }
}
