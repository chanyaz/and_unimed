package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class ar extends Handler {
    private final /* synthetic */ ao a;

    ar(ao aoVar, Looper looper) {
        this.a = aoVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.a.k();
                return;
            case 2:
                this.a.j();
                return;
            default:
                Log.w("GoogleApiClientImpl", "Unknown message id: " + message.what);
                return;
        }
    }
}
