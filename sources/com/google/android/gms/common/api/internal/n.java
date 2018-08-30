package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.internal.ListenerHolder.Notifier;
import com.google.android.gms.common.internal.ar;

final class n extends Handler {
    private final /* synthetic */ ListenerHolder a;

    public n(ListenerHolder listenerHolder, Looper looper) {
        this.a = listenerHolder;
        super(looper);
    }

    public final void handleMessage(Message message) {
        boolean z = true;
        if (message.what != 1) {
            z = false;
        }
        ar.b(z);
        this.a.b((Notifier) message.obj);
    }
}
