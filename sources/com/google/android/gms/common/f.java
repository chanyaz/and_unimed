package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

@SuppressLint({"HandlerLeak"})
final class f extends Handler {
    private final Context a;
    private final /* synthetic */ e b;

    public f(e eVar, Context context) {
        this.b = eVar;
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.a = context.getApplicationContext();
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                int a = this.b.a(this.a);
                if (this.b.a(a)) {
                    this.b.a(this.a, a);
                    return;
                }
                return;
            default:
                Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + message.what);
                return;
        }
    }
}
