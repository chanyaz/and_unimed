package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.common.internal.c;
import java.util.concurrent.CountDownLatch;

final class b implements Runnable {
    private final Uri a;
    private final ParcelFileDescriptor b;
    private final /* synthetic */ ImageManager c;

    public b(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
        this.c = imageManager;
        this.a = uri;
        this.b = parcelFileDescriptor;
    }

    public final void run() {
        c.b("LoadBitmapFromDiskRunnable can't be executed in the main thread");
        boolean z = false;
        Bitmap bitmap = null;
        if (this.b != null) {
            try {
                bitmap = BitmapFactory.decodeFileDescriptor(this.b.getFileDescriptor());
            } catch (Throwable e) {
                String valueOf = String.valueOf(this.a);
                Log.e("ImageManager", new StringBuilder(String.valueOf(valueOf).length() + 34).append("OOM while loading bitmap for uri: ").append(valueOf).toString(), e);
                z = true;
            }
            try {
                this.b.close();
            } catch (Throwable e2) {
                Log.e("ImageManager", "closed failed", e2);
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.c.d.post(new c(this.c, this.a, bitmap, z, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e3) {
            String valueOf2 = String.valueOf(this.a);
            Log.w("ImageManager", new StringBuilder(String.valueOf(valueOf2).length() + 32).append("Latch interrupted while posting ").append(valueOf2).toString());
        }
    }
}
