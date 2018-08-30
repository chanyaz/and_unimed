package android.support.v4.media;

import android.media.browse.MediaBrowser.ItemCallback;
import android.media.browse.MediaBrowser.MediaItem;
import android.os.Parcel;
import android.support.annotation.NonNull;

class v<T extends ItemCallback> extends ItemCallback {
    protected final T a;

    public v(T t) {
        this.a = t;
    }

    public void onError(@NonNull String str) {
        this.a.onError(str);
    }

    public void onItemLoaded(MediaItem mediaItem) {
        if (mediaItem == null) {
            this.a.onItemLoaded(null);
            return;
        }
        Parcel obtain = Parcel.obtain();
        mediaItem.writeToParcel(obtain, 0);
        this.a.onItemLoaded(obtain);
    }
}
