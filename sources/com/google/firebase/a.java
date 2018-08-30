package com.google.firebase;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.atomic.AtomicReference;

@TargetApi(24)
final class a extends BroadcastReceiver {
    private static AtomicReference<a> a = new AtomicReference();
    private final Context b;

    private a(Context context) {
        this.b = context;
    }

    private static void b(Context context) {
        if (a.get() == null) {
            BroadcastReceiver aVar = new a(context);
            if (a.compareAndSet(null, aVar)) {
                context.registerReceiver(aVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
            }
        }
    }

    public final void onReceive(Context context, Intent intent) {
        synchronized (FirebaseApp.g) {
            for (FirebaseApp a : FirebaseApp.a.values()) {
                a.h();
            }
        }
        this.b.unregisterReceiver(this);
    }
}
