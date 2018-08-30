package com.google.android.exoplayer.dash.mpd;

import android.os.SystemClock;
import com.google.android.exoplayer.upstream.Loader;
import com.google.android.exoplayer.upstream.Loader.Callback;
import com.google.android.exoplayer.upstream.Loader.Loadable;
import com.google.android.exoplayer.upstream.UriLoadable;
import java.io.IOException;
import java.util.concurrent.CancellationException;

public final class UtcTimingElementResolver implements Callback {
    private final f a;
    private final UtcTimingCallback b;
    private Loader c;
    private UriLoadable<Long> d;

    public interface UtcTimingCallback {
        void onTimestampError(f fVar, IOException iOException);

        void onTimestampResolved(f fVar, long j);
    }

    private void a() {
        this.c.c();
    }

    public void onLoadCanceled(Loadable loadable) {
        onLoadError(loadable, new IOException("Load cancelled", new CancellationException()));
    }

    public void onLoadCompleted(Loadable loadable) {
        a();
        this.b.onTimestampResolved(this.a, ((Long) this.d.a()).longValue() - SystemClock.elapsedRealtime());
    }

    public void onLoadError(Loadable loadable, IOException iOException) {
        a();
        this.b.onTimestampError(this.a, iOException);
    }
}
