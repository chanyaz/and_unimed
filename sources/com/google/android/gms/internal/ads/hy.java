package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class hy extends BroadcastReceiver {
    private final /* synthetic */ ht a;

    private hy(ht htVar) {
        this.a = htVar;
    }

    /* synthetic */ hy(ht htVar, hu huVar) {
        this(htVar);
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            this.a.c = true;
        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.a.c = false;
        }
    }
}
