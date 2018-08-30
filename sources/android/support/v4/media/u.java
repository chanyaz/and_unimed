package android.support.v4.media;

import android.media.browse.MediaBrowser.MediaItem;
import android.media.browse.MediaBrowser.SubscriptionCallback;
import android.support.annotation.NonNull;
import java.util.List;

class u<T extends SubscriptionCallback> extends SubscriptionCallback {
    protected final T a;

    public u(T t) {
        this.a = t;
    }

    public void onChildrenLoaded(@NonNull String str, List<MediaItem> list) {
        this.a.onChildrenLoaded(str, list);
    }

    public void onError(@NonNull String str) {
        this.a.onError(str);
    }
}
