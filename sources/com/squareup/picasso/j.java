package com.squareup.picasso;

import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class j extends Handler {
    private final i a;

    public j(Looper looper, i iVar) {
        super(looper);
        this.a = iVar;
    }

    public void handleMessage(final Message message) {
        boolean z = true;
        switch (message.what) {
            case 1:
                this.a.c((a) message.obj);
                return;
            case 2:
                this.a.d((a) message.obj);
                return;
            case 4:
                this.a.e((d) message.obj);
                return;
            case 5:
                this.a.d((d) message.obj);
                return;
            case 6:
                this.a.a((d) message.obj, false);
                return;
            case 7:
                this.a.a();
                return;
            case 9:
                this.a.b((NetworkInfo) message.obj);
                return;
            case 10:
                i iVar = this.a;
                if (message.arg1 != 1) {
                    z = false;
                }
                iVar.b(z);
                return;
            case 11:
                this.a.a(message.obj);
                return;
            case 12:
                this.a.b(message.obj);
                return;
            default:
                Picasso.a.post(new Runnable() {
                    public void run() {
                        throw new AssertionError("Unknown handler message received: " + message.what);
                    }
                });
                return;
        }
    }
}
