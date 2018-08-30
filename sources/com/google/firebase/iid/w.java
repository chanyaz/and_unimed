package com.google.firebase.iid;

import android.util.Log;

final class w implements Runnable {
    private final /* synthetic */ t a;
    private final /* synthetic */ v b;

    w(v vVar, t tVar) {
        this.b = vVar;
        this.a = tVar;
    }

    public final void run() {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "bg processing of the intent starting now");
        }
        this.b.a.b(this.a.a);
        this.a.a();
    }
}
