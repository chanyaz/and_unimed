package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.RequiresApi;
import java.util.List;

@RequiresApi(21)
class MediaBrowserServiceCompatApi21 {

    public interface ServiceCompatProxy {
        ae onGetRoot(String str, int i, Bundle bundle);

        void onLoadChildren(String str, af<List<Parcel>> afVar);
    }

    MediaBrowserServiceCompatApi21() {
    }
}
