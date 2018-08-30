package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat.QueueItem;
import java.util.List;

public abstract class f implements DeathRecipient {
    g a;
    boolean b;
    private final Object c;

    public f() {
        if (VERSION.SDK_INT >= 21) {
            this.c = MediaControllerCompatApi21.a(new h(this));
        } else {
            this.c = new i(this);
        }
    }

    public void a() {
    }

    public void a(int i) {
    }

    void a(int i, Object obj, Bundle bundle) {
        if (this.a != null) {
            Message obtainMessage = this.a.obtainMessage(i, obj);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
        }
    }

    public void a(Bundle bundle) {
    }

    public void a(MediaMetadataCompat mediaMetadataCompat) {
    }

    public void a(PlaybackStateCompat playbackStateCompat) {
    }

    public void a(n nVar) {
    }

    public void a(CharSequence charSequence) {
    }

    public void a(String str, Bundle bundle) {
    }

    public void a(List<QueueItem> list) {
    }

    public void a(boolean z) {
    }

    public void b() {
    }

    public void b(int i) {
    }
}
