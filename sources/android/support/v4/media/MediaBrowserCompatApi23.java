package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

@RequiresApi(23)
class MediaBrowserCompatApi23 {

    interface ItemCallback {
        void onError(@NonNull String str);

        void onItemLoaded(Parcel parcel);
    }

    MediaBrowserCompatApi23() {
    }

    public static Object a(ItemCallback itemCallback) {
        return new v(itemCallback);
    }

    public static void a(Object obj, String str, Object obj2) {
        ((MediaBrowser) obj).getItem(str, (android.media.browse.MediaBrowser.ItemCallback) obj2);
    }
}
