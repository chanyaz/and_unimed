package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

final class c implements Runnable {
    private final Uri a;
    private final Bitmap b;
    private final CountDownLatch c;
    private boolean d;
    private final /* synthetic */ ImageManager e;

    public c(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
        this.e = imageManager;
        this.a = uri;
        this.b = bitmap;
        this.d = z;
        this.c = countDownLatch;
    }

    public final void run() {
        com.google.android.gms.common.internal.c.a("OnBitmapLoadedRunnable must be executed in the main thread");
        boolean z = this.b != null;
        if (this.e.f != null) {
            if (this.d) {
                this.e.f.evictAll();
                System.gc();
                this.d = false;
                this.e.d.post(this);
                return;
            } else if (z) {
                this.e.f.put(new f(this.a), this.b);
            }
        }
        ImageReceiver imageReceiver = (ImageReceiver) this.e.i.remove(this.a);
        if (imageReceiver != null) {
            ArrayList a = imageReceiver.b;
            int size = a.size();
            for (int i = 0; i < size; i++) {
                d dVar = (d) a.get(i);
                if (z) {
                    dVar.a(this.e.c, this.b, false);
                } else {
                    this.e.j.put(this.a, Long.valueOf(SystemClock.elapsedRealtime()));
                    dVar.a(this.e.c, this.e.g, false);
                }
                if (!(dVar instanceof e)) {
                    this.e.h.remove(dVar);
                }
            }
        }
        this.c.countDown();
        synchronized (ImageManager.a) {
            ImageManager.b.remove(this.a);
        }
    }
}
