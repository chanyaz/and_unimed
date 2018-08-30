package com.google.android.exoplayer.drm;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;

@SuppressLint({"HandlerLeak"})
class f extends Handler {
    final /* synthetic */ StreamingDrmSessionManager a;

    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.a.a(message.obj);
                return;
            case 1:
                this.a.b(message.obj);
                return;
            default:
                return;
        }
    }
}
