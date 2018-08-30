package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

final class ga implements Runnable {
    private final /* synthetic */ Bitmap a;
    private final /* synthetic */ fx b;

    ga(fx fxVar, Bitmap bitmap) {
        this.b = fxVar;
        this.a = bitmap;
    }

    public final void run() {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.a.compress(CompressFormat.PNG, 0, byteArrayOutputStream);
        synchronized (this.b.l) {
            this.b.c.g = new abu();
            this.b.c.g.c = byteArrayOutputStream.toByteArray();
            this.b.c.g.b = "image/png";
            this.b.c.g.a = Integer.valueOf(1);
        }
    }
}
