package android.support.v7.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

final class g extends Handler {
    private WeakReference<DialogInterface> a;

    public g(DialogInterface dialogInterface) {
        this.a = new WeakReference(dialogInterface);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case -3:
            case -2:
            case -1:
                ((OnClickListener) message.obj).onClick((DialogInterface) this.a.get(), message.what);
                return;
            case 1:
                ((DialogInterface) message.obj).dismiss();
                return;
            default:
                return;
        }
    }
}
