package com.google.android.exoplayer.upstream;

import android.os.Looper;
import com.google.android.exoplayer.util.b;
import com.google.android.exoplayer.util.m;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class Loader {
    private final ExecutorService a;
    private f b;
    private boolean c;

    public interface Callback {
        void onLoadCanceled(Loadable loadable);

        void onLoadCompleted(Loadable loadable);

        void onLoadError(Loadable loadable, IOException iOException);
    }

    public interface Loadable {
        void cancelLoad();

        boolean isLoadCanceled();

        void load();
    }

    public final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Exception exception) {
            super("Unexpected " + exception.getClass().getSimpleName() + ": " + exception.getMessage(), exception);
        }
    }

    public Loader(String str) {
        this.a = m.a(str);
    }

    public void a(Looper looper, Loadable loadable, Callback callback) {
        b.b(!this.c);
        this.c = true;
        this.b = new f(this, looper, loadable, callback);
        this.a.submit(this.b);
    }

    public void a(Loadable loadable, Callback callback) {
        Looper myLooper = Looper.myLooper();
        b.b(myLooper != null);
        a(myLooper, loadable, callback);
    }

    public boolean a() {
        return this.c;
    }

    public void b() {
        b.b(this.c);
        this.b.a();
    }

    public void c() {
        if (this.c) {
            b();
        }
        this.a.shutdown();
    }
}
