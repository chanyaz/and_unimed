package android.support.v4.media;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v4.media.MediaBrowserCompat.MediaItem;

public abstract class f {
    final Object a;

    public f() {
        if (VERSION.SDK_INT >= 23) {
            this.a = MediaBrowserCompatApi23.a(new g(this));
        } else {
            this.a = null;
        }
    }

    public void a(MediaItem mediaItem) {
    }

    public void a(@NonNull String str) {
    }
}
