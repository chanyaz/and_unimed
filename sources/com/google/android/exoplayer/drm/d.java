package com.google.android.exoplayer.drm;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;

@SuppressLint({"HandlerLeak"})
class d extends Handler {
    final /* synthetic */ StreamingDrmSessionManager a;

    public void handleMessage(Message message) {
        if (this.a.m == 0) {
            return;
        }
        if (this.a.o == 3 || this.a.o == 4) {
            switch (message.what) {
                case 1:
                    this.a.o = 3;
                    this.a.a();
                    return;
                case 2:
                    this.a.b();
                    return;
                case 3:
                    this.a.o = 3;
                    this.a.b(new KeysExpiredException());
                    return;
                default:
                    return;
            }
        }
    }
}
