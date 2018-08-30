package com.google.android.exoplayer.util;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.exoplayer.upstream.Loader;
import com.google.android.exoplayer.upstream.Loader.Callback;
import com.google.android.exoplayer.upstream.Loader.Loadable;
import com.google.android.exoplayer.upstream.UriDataSource;
import com.google.android.exoplayer.upstream.UriLoadable;
import com.google.android.exoplayer.upstream.UriLoadable.Parser;
import java.io.IOException;

public class ManifestFetcher<T> implements Callback {
    volatile String a;
    private final Parser<T> b;
    private final UriDataSource c;
    private final Handler d;
    private final EventListener e;
    private int f;
    private Loader g;
    private UriLoadable<T> h;
    private long i;
    private int j;
    private long k;
    private IOException l;
    private volatile T m;
    private volatile long n;
    private volatile long o;

    public interface RedirectingManifest {
        String getNextManifestUri();
    }

    public interface EventListener {
        void onManifestError(IOException iOException);

        void onManifestRefreshStarted();

        void onManifestRefreshed();
    }

    public interface ManifestCallback<T> {
        void onSingleManifest(T t);

        void onSingleManifestError(IOException iOException);
    }

    private long a(long j) {
        return Math.min((j - 1) * 1000, 5000);
    }

    private void a(final IOException iOException) {
        if (this.d != null && this.e != null) {
            this.d.post(new Runnable() {
                public void run() {
                    ManifestFetcher.this.e.onManifestError(iOException);
                }
            });
        }
    }

    private void g() {
        if (this.d != null && this.e != null) {
            this.d.post(new Runnable() {
                public void run() {
                    ManifestFetcher.this.e.onManifestRefreshStarted();
                }
            });
        }
    }

    private void h() {
        if (this.d != null && this.e != null) {
            this.d.post(new Runnable() {
                public void run() {
                    ManifestFetcher.this.e.onManifestRefreshed();
                }
            });
        }
    }

    public T a() {
        return this.m;
    }

    public long b() {
        return this.n;
    }

    public void c() {
        if (this.l != null && this.j > 1) {
            throw this.l;
        }
    }

    public void d() {
        int i = this.f;
        this.f = i + 1;
        if (i == 0) {
            this.j = 0;
            this.l = null;
        }
    }

    public void e() {
        int i = this.f - 1;
        this.f = i;
        if (i == 0 && this.g != null) {
            this.g.c();
            this.g = null;
        }
    }

    public void f() {
        if (this.l == null || SystemClock.elapsedRealtime() >= this.k + a((long) this.j)) {
            if (this.g == null) {
                this.g = new Loader("manifestLoader");
            }
            if (!this.g.a()) {
                this.h = new UriLoadable(this.a, this.c, this.b);
                this.i = SystemClock.elapsedRealtime();
                this.g.a(this.h, (Callback) this);
                g();
            }
        }
    }

    public void onLoadCanceled(Loadable loadable) {
    }

    public void onLoadCompleted(Loadable loadable) {
        if (this.h == loadable) {
            this.m = this.h.a();
            this.n = this.i;
            this.o = SystemClock.elapsedRealtime();
            this.j = 0;
            this.l = null;
            if (this.m instanceof RedirectingManifest) {
                Object nextManifestUri = ((RedirectingManifest) this.m).getNextManifestUri();
                if (!TextUtils.isEmpty(nextManifestUri)) {
                    this.a = nextManifestUri;
                }
            }
            h();
        }
    }

    public void onLoadError(Loadable loadable, IOException iOException) {
        if (this.h == loadable) {
            this.j++;
            this.k = SystemClock.elapsedRealtime();
            this.l = new IOException(iOException);
            a(this.l);
        }
    }
}
