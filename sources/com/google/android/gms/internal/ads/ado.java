package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class ado extends BroadcastReceiver {
    private final /* synthetic */ adn a;

    private ado(adn adn) {
        this.a = adn;
    }

    /* synthetic */ ado(adn adn, adq adq) {
        this(adn);
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            this.a.r = true;
        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.a.r = false;
        }
    }
}
