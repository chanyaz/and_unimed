package android.support.v4.media;

import android.os.Parcel;
import android.support.annotation.RequiresApi;

@RequiresApi(23)
class MediaBrowserServiceCompatApi23 {

    public interface ServiceCompatProxy extends android.support.v4.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy {
        void onLoadItem(String str, af<Parcel> afVar);
    }

    MediaBrowserServiceCompatApi23() {
    }
}
