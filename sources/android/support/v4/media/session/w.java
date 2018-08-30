package android.support.v4.media.session;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class w extends Handler {
    final /* synthetic */ v a;

    w(v vVar, Looper looper) {
        this.a = vVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        if (message.what == 1) {
            this.a.i();
        }
    }
}
