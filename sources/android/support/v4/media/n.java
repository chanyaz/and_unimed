package android.support.v4.media;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.app.h;
import android.support.v4.os.ResultReceiver;

class n {
    private Messenger a;
    private Bundle b;

    public n(IBinder iBinder, Bundle bundle) {
        this.a = new Messenger(iBinder);
        this.b = bundle;
    }

    private void a(int i, Bundle bundle, Messenger messenger) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.arg1 = 1;
        obtain.setData(bundle);
        obtain.replyTo = messenger;
        this.a.send(obtain);
    }

    void a(Context context, Messenger messenger) {
        Bundle bundle = new Bundle();
        bundle.putString("data_package_name", context.getPackageName());
        bundle.putBundle("data_root_hints", this.b);
        a(1, bundle, messenger);
    }

    void a(Messenger messenger) {
        a(2, null, messenger);
    }

    void a(String str, Bundle bundle, ResultReceiver resultReceiver, Messenger messenger) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("data_search_query", str);
        bundle2.putBundle("data_search_extras", bundle);
        bundle2.putParcelable("data_result_receiver", resultReceiver);
        a(8, bundle2, messenger);
    }

    void a(String str, IBinder iBinder, Bundle bundle, Messenger messenger) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("data_media_item_id", str);
        h.a(bundle2, "data_callback_token", iBinder);
        bundle2.putBundle("data_options", bundle);
        a(3, bundle2, messenger);
    }

    void a(String str, IBinder iBinder, Messenger messenger) {
        Bundle bundle = new Bundle();
        bundle.putString("data_media_item_id", str);
        h.a(bundle, "data_callback_token", iBinder);
        a(4, bundle, messenger);
    }

    void a(String str, ResultReceiver resultReceiver, Messenger messenger) {
        Bundle bundle = new Bundle();
        bundle.putString("data_media_item_id", str);
        bundle.putParcelable("data_result_receiver", resultReceiver);
        a(5, bundle, messenger);
    }

    void b(Messenger messenger) {
        Bundle bundle = new Bundle();
        bundle.putBundle("data_root_hints", this.b);
        a(6, bundle, messenger);
    }

    void b(String str, Bundle bundle, ResultReceiver resultReceiver, Messenger messenger) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("data_custom_action", str);
        bundle2.putBundle("data_custom_action_extras", bundle);
        bundle2.putParcelable("data_result_receiver", resultReceiver);
        a(9, bundle2, messenger);
    }

    void c(Messenger messenger) {
        a(7, null, messenger);
    }
}
