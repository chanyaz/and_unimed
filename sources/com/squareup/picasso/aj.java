package com.squareup.picasso;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class aj extends Handler {
    private final ai a;

    public aj(Looper looper, ai aiVar) {
        super(looper);
        this.a = aiVar;
    }

    public void handleMessage(final Message message) {
        switch (message.what) {
            case 0:
                this.a.c();
                return;
            case 1:
                this.a.d();
                return;
            case 2:
                this.a.b((long) message.arg1);
                return;
            case 3:
                this.a.c((long) message.arg1);
                return;
            case 4:
                this.a.a((Long) message.obj);
                return;
            default:
                Picasso.a.post(new Runnable() {
                    public void run() {
                        throw new AssertionError("Unhandled stats message." + message.what);
                    }
                });
                return;
        }
    }
}
