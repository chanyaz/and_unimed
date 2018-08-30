package android.support.v4.media.session;

import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat.QueueItem;
import java.util.List;

class j extends i {
    j(f fVar) {
        super(fVar);
    }

    public void onExtrasChanged(Bundle bundle) {
        throw new AssertionError();
    }

    public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
        throw new AssertionError();
    }

    public void onQueueChanged(List<QueueItem> list) {
        throw new AssertionError();
    }

    public void onQueueTitleChanged(CharSequence charSequence) {
        throw new AssertionError();
    }

    public void onSessionDestroyed() {
        throw new AssertionError();
    }

    public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) {
        throw new AssertionError();
    }
}
