package com.squareup.picasso;

import android.graphics.Bitmap;
import com.squareup.picasso.Picasso.LoadedFrom;
import java.io.InputStream;

public final class ag {
    private final LoadedFrom a;
    private final Bitmap b;
    private final InputStream c;
    private final int d;

    public ag(Bitmap bitmap, LoadedFrom loadedFrom) {
        this((Bitmap) ao.a((Object) bitmap, "bitmap == null"), null, loadedFrom, 0);
    }

    ag(Bitmap bitmap, InputStream inputStream, LoadedFrom loadedFrom, int i) {
        int i2 = 1;
        int i3 = bitmap != null ? 1 : 0;
        if (inputStream == null) {
            i2 = 0;
        }
        if ((i2 ^ i3) == 0) {
            throw new AssertionError();
        }
        this.b = bitmap;
        this.c = inputStream;
        this.a = (LoadedFrom) ao.a((Object) loadedFrom, "loadedFrom == null");
        this.d = i;
    }

    public ag(InputStream inputStream, LoadedFrom loadedFrom) {
        this(null, (InputStream) ao.a((Object) inputStream, "stream == null"), loadedFrom, 0);
    }

    public Bitmap a() {
        return this.b;
    }

    public InputStream b() {
        return this.c;
    }

    public LoadedFrom c() {
        return this.a;
    }

    int d() {
        return this.d;
    }
}
