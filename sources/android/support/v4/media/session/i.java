package android.support.v4.media.session;

import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat.QueueItem;
import java.lang.ref.WeakReference;
import java.util.List;

class i extends a {
    private final WeakReference<f> a;

    i(f fVar) {
        this.a = new WeakReference(fVar);
    }

    public void onCaptioningEnabledChanged(boolean z) {
        f fVar = (f) this.a.get();
        if (fVar != null) {
            fVar.a(11, Boolean.valueOf(z), null);
        }
    }

    public void onEvent(String str, Bundle bundle) {
        f fVar = (f) this.a.get();
        if (fVar != null) {
            fVar.a(1, str, bundle);
        }
    }

    public void onExtrasChanged(Bundle bundle) {
        f fVar = (f) this.a.get();
        if (fVar != null) {
            fVar.a(7, bundle, null);
        }
    }

    public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
        f fVar = (f) this.a.get();
        if (fVar != null) {
            fVar.a(3, mediaMetadataCompat, null);
        }
    }

    public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
        f fVar = (f) this.a.get();
        if (fVar != null) {
            fVar.a(2, playbackStateCompat, null);
        }
    }

    public void onQueueChanged(List<QueueItem> list) {
        f fVar = (f) this.a.get();
        if (fVar != null) {
            fVar.a(5, list, null);
        }
    }

    public void onQueueTitleChanged(CharSequence charSequence) {
        f fVar = (f) this.a.get();
        if (fVar != null) {
            fVar.a(6, charSequence, null);
        }
    }

    public void onRepeatModeChanged(int i) {
        f fVar = (f) this.a.get();
        if (fVar != null) {
            fVar.a(9, Integer.valueOf(i), null);
        }
    }

    public void onSessionDestroyed() {
        f fVar = (f) this.a.get();
        if (fVar != null) {
            fVar.a(8, null, null);
        }
    }

    public void onSessionReady() {
        f fVar = (f) this.a.get();
        if (fVar != null) {
            fVar.a(13, null, null);
        }
    }

    public void onShuffleModeChanged(int i) {
        f fVar = (f) this.a.get();
        if (fVar != null) {
            fVar.a(12, Integer.valueOf(i), null);
        }
    }

    public void onShuffleModeChangedRemoved(boolean z) {
    }

    public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) {
        f fVar = (f) this.a.get();
        if (fVar != null) {
            fVar.a(4, parcelableVolumeInfo != null ? new n(parcelableVolumeInfo.a, parcelableVolumeInfo.b, parcelableVolumeInfo.c, parcelableVolumeInfo.d, parcelableVolumeInfo.e) : null, null);
        }
    }
}
