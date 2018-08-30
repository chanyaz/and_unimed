package android.support.v4.media;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import java.util.List;

class r extends q implements SubscriptionCallback {
    final /* synthetic */ p b;

    r(p pVar) {
        this.b = pVar;
        super(pVar);
    }

    public void onChildrenLoaded(@NonNull String str, List<?> list, @NonNull Bundle bundle) {
        this.b.a(str, MediaItem.a((List) list), bundle);
    }

    public void onError(@NonNull String str, @NonNull Bundle bundle) {
        this.b.a(str, bundle);
    }
}
