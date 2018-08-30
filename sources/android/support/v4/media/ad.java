package android.support.v4.media;

import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.h;
import android.support.v4.os.ResultReceiver;
import android.util.Log;

final class ad extends Handler {
    final /* synthetic */ MediaBrowserServiceCompat a;
    private final ab b = new ab(this.a);

    ad(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        this.a = mediaBrowserServiceCompat;
    }

    public void a(Runnable runnable) {
        if (Thread.currentThread() == getLooper().getThread()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }

    public void handleMessage(Message message) {
        Bundle data = message.getData();
        switch (message.what) {
            case 1:
                this.b.a(data.getString("data_package_name"), data.getInt("data_calling_uid"), data.getBundle("data_root_hints"), new ac(message.replyTo));
                return;
            case 2:
                this.b.a(new ac(message.replyTo));
                return;
            case 3:
                this.b.a(data.getString("data_media_item_id"), h.a(data, "data_callback_token"), data.getBundle("data_options"), new ac(message.replyTo));
                return;
            case 4:
                this.b.a(data.getString("data_media_item_id"), h.a(data, "data_callback_token"), new ac(message.replyTo));
                return;
            case 5:
                this.b.a(data.getString("data_media_item_id"), (ResultReceiver) data.getParcelable("data_result_receiver"), new ac(message.replyTo));
                return;
            case 6:
                this.b.a(new ac(message.replyTo), data.getBundle("data_root_hints"));
                return;
            case 7:
                this.b.b(new ac(message.replyTo));
                return;
            case 8:
                this.b.a(data.getString("data_search_query"), data.getBundle("data_search_extras"), (ResultReceiver) data.getParcelable("data_result_receiver"), new ac(message.replyTo));
                return;
            case 9:
                this.b.b(data.getString("data_custom_action"), data.getBundle("data_custom_action_extras"), (ResultReceiver) data.getParcelable("data_result_receiver"), new ac(message.replyTo));
                return;
            default:
                Log.w("MBServiceCompat", "Unhandled message: " + message + "\n  Service version: " + 2 + "\n  Client version: " + message.arg1);
                return;
        }
    }

    public boolean sendMessageAtTime(Message message, long j) {
        Bundle data = message.getData();
        data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
        data.putInt("data_calling_uid", Binder.getCallingUid());
        return super.sendMessageAtTime(message, j);
    }
}
