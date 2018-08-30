package com.google.firebase.iid;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class m extends Handler {
    private final /* synthetic */ l a;

    m(l lVar, Looper looper) {
        this.a = lVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        this.a.a(message);
    }
}
