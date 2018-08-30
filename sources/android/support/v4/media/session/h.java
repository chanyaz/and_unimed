package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompatApi21.Callback;
import android.support.v4.media.session.MediaSessionCompat.QueueItem;
import java.lang.ref.WeakReference;
import java.util.List;

class h implements Callback {
    private final WeakReference<f> a;

    h(f fVar) {
        this.a = new WeakReference(fVar);
    }

    public void onAudioInfoChanged(int i, int i2, int i3, int i4, int i5) {
        f fVar = (f) this.a.get();
        if (fVar != null) {
            fVar.a(new n(i, i2, i3, i4, i5));
        }
    }

    public void onExtrasChanged(Bundle bundle) {
        f fVar = (f) this.a.get();
        if (fVar != null) {
            fVar.a(bundle);
        }
    }

    public void onMetadataChanged(Object obj) {
        f fVar = (f) this.a.get();
        if (fVar != null) {
            fVar.a(MediaMetadataCompat.a(obj));
        }
    }

    public void onPlaybackStateChanged(Object obj) {
        f fVar = (f) this.a.get();
        if (fVar != null && !fVar.b) {
            fVar.a(PlaybackStateCompat.a(obj));
        }
    }

    public void onQueueChanged(List<?> list) {
        f fVar = (f) this.a.get();
        if (fVar != null) {
            fVar.a(QueueItem.a((List) list));
        }
    }

    public void onQueueTitleChanged(CharSequence charSequence) {
        f fVar = (f) this.a.get();
        if (fVar != null) {
            fVar.a(charSequence);
        }
    }

    public void onSessionDestroyed() {
        f fVar = (f) this.a.get();
        if (fVar != null) {
            fVar.b();
        }
    }

    public void onSessionEvent(String str, Bundle bundle) {
        f fVar = (f) this.a.get();
        if (fVar == null) {
            return;
        }
        if (!fVar.b || VERSION.SDK_INT >= 23) {
            fVar.a(str, bundle);
        }
    }
}
