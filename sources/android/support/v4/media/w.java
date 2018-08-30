package android.support.v4.media;

import android.media.browse.MediaBrowser.MediaItem;
import android.os.Bundle;
import android.support.annotation.NonNull;
import java.util.List;

class w<T extends SubscriptionCallback> extends u<T> {
    w(T t) {
        super(t);
    }

    public void onChildrenLoaded(@NonNull String str, List<MediaItem> list, @NonNull Bundle bundle) {
        ((SubscriptionCallback) this.a).onChildrenLoaded(str, list, bundle);
    }

    public void onError(@NonNull String str, @NonNull Bundle bundle) {
        ((SubscriptionCallback) this.a).onError(str, bundle);
    }
}
