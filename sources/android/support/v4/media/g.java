package android.support.v4.media;

import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.v4.media.MediaBrowserCompat.MediaItem;

class g implements ItemCallback {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public void onError(@NonNull String str) {
        this.a.a(str);
    }

    public void onItemLoaded(Parcel parcel) {
        if (parcel == null) {
            this.a.a(null);
            return;
        }
        parcel.setDataPosition(0);
        MediaItem mediaItem = (MediaItem) MediaItem.CREATOR.createFromParcel(parcel);
        parcel.recycle();
        this.a.a(mediaItem);
    }
}
