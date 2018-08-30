package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;

final class u implements Runnable {
    private final /* synthetic */ Intent a;
    private final /* synthetic */ t b;

    u(t tVar, Intent intent) {
        this.b = tVar;
        this.a = intent;
    }

    public final void run() {
        String action = this.a.getAction();
        Log.w("EnhancedIntentService", new StringBuilder(String.valueOf(action).length() + 61).append("Service took too long to process intent: ").append(action).append(" App may get closed.").toString());
        this.b.a();
    }
}
