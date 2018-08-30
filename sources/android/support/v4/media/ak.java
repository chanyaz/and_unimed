package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;
import android.support.annotation.RequiresApi;

@RequiresApi(23)
class ak extends ai {
    ak() {
    }

    public static Uri h(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }
}
