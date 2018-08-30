package com.google.android.exoplayer.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.exoplayer.upstream.Loader.Callback;
import com.google.android.exoplayer.upstream.Loader.Loadable;
import com.google.android.exoplayer.upstream.Loader.UnexpectedLoaderException;
import com.google.android.exoplayer.util.b;
import com.google.android.exoplayer.util.k;
import java.io.IOException;

@SuppressLint({"HandlerLeak"})
final class f extends Handler implements Runnable {
    final /* synthetic */ Loader a;
    private final Loadable b;
    private final Callback c;
    private volatile Thread d;

    public f(Loader loader, Looper looper, Loadable loadable, Callback callback) {
        this.a = loader;
        super(looper);
        this.b = loadable;
        this.c = callback;
    }

    private void b() {
        this.a.c = false;
        this.a.b = null;
    }

    public void a() {
        this.b.cancelLoad();
        if (this.d != null) {
            this.d.interrupt();
        }
    }

    public void handleMessage(Message message) {
        if (message.what == 2) {
            throw ((Error) message.obj);
        }
        b();
        if (this.b.isLoadCanceled()) {
            this.c.onLoadCanceled(this.b);
            return;
        }
        switch (message.what) {
            case 0:
                this.c.onLoadCompleted(this.b);
                return;
            case 1:
                this.c.onLoadError(this.b, (IOException) message.obj);
                return;
            default:
                return;
        }
    }

    public void run() {
        try {
            this.d = Thread.currentThread();
            if (!this.b.isLoadCanceled()) {
                k.a(this.b.getClass().getSimpleName() + ".load()");
                this.b.load();
                k.a();
            }
            sendEmptyMessage(0);
        } catch (IOException e) {
            obtainMessage(1, e).sendToTarget();
        } catch (InterruptedException e2) {
            b.b(this.b.isLoadCanceled());
            sendEmptyMessage(0);
        } catch (Throwable e3) {
            Log.e("LoadTask", "Unexpected exception loading stream", e3);
            obtainMessage(1, new UnexpectedLoaderException(e3)).sendToTarget();
        } catch (Throwable e32) {
            Log.e("LoadTask", "Unexpected error loading stream", e32);
            obtainMessage(2, e32).sendToTarget();
            throw e32;
        }
    }
}
