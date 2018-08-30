package com.squareup.picasso;

import android.graphics.Bitmap;
import java.io.InputStream;

public class m {
    final InputStream a;
    final Bitmap b;
    final boolean c;
    final long d;

    public m(InputStream inputStream, boolean z, long j) {
        if (inputStream == null) {
            throw new IllegalArgumentException("Stream may not be null.");
        }
        this.a = inputStream;
        this.b = null;
        this.c = z;
        this.d = j;
    }

    public InputStream a() {
        return this.a;
    }

    @Deprecated
    public Bitmap b() {
        return this.b;
    }

    public long c() {
        return this.d;
    }
}
