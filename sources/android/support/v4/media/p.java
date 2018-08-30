package android.support.v4.media;

import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import java.lang.ref.WeakReference;
import java.util.List;

public abstract class p {
    WeakReference<o> a;
    private final Object b;
    private final IBinder c = new Binder();

    public p() {
        if (VERSION.SDK_INT >= 26) {
            this.b = MediaBrowserCompatApi26.a(new r(this));
        } else if (VERSION.SDK_INT >= 21) {
            this.b = MediaBrowserCompatApi21.a(new q(this));
        } else {
            this.b = null;
        }
    }

    private void a(o oVar) {
        this.a = new WeakReference(oVar);
    }

    public void a(@NonNull String str) {
    }

    public void a(@NonNull String str, @NonNull Bundle bundle) {
    }

    public void a(@NonNull String str, @NonNull List<MediaItem> list) {
    }

    public void a(@NonNull String str, @NonNull List<MediaItem> list, @NonNull Bundle bundle) {
    }
}
