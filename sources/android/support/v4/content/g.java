package android.support.v4.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class g extends Handler {
    g() {
        super(Looper.getMainLooper());
    }

    public void handleMessage(Message message) {
        f fVar = (f) message.obj;
        switch (message.what) {
            case 1:
                fVar.a.e(fVar.b[0]);
                return;
            case 2:
                fVar.a.b(fVar.b);
                return;
            default:
                return;
        }
    }
}
