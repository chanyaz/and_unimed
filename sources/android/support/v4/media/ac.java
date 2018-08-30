package android.support.v4.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import android.support.v4.media.session.MediaSessionCompat.Token;
import java.util.ArrayList;
import java.util.List;

class ac implements ServiceCallbacks {
    final Messenger a;

    ac(Messenger messenger) {
        this.a = messenger;
    }

    private void a(int i, Bundle bundle) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.arg1 = 2;
        obtain.setData(bundle);
        this.a.send(obtain);
    }

    public IBinder asBinder() {
        return this.a.getBinder();
    }

    public void onConnect(String str, Token token, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("extra_service_version", 2);
        Bundle bundle2 = new Bundle();
        bundle2.putString("data_media_item_id", str);
        bundle2.putParcelable("data_media_session_token", token);
        bundle2.putBundle("data_root_hints", bundle);
        a(1, bundle2);
    }

    public void onConnectFailed() {
        a(2, null);
    }

    public void onLoadChildren(String str, List<MediaItem> list, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("data_media_item_id", str);
        bundle2.putBundle("data_options", bundle);
        if (list != null) {
            bundle2.putParcelableArrayList("data_media_item_list", list instanceof ArrayList ? (ArrayList) list : new ArrayList(list));
        }
        a(3, bundle2);
    }
}
