package com.squareup.picasso;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

class l extends BroadcastReceiver {
    private final i a;

    l(i iVar) {
        this.a = iVar;
    }

    void a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
        if (this.a.o) {
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
        this.a.b.registerReceiver(this, intentFilter);
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                if (intent.hasExtra("state")) {
                    this.a.a(intent.getBooleanExtra("state", false));
                }
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                this.a.a(((ConnectivityManager) ao.a(context, "connectivity")).getActiveNetworkInfo());
            }
        }
    }
}
