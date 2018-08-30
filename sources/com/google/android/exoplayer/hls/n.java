package com.google.android.exoplayer.hls;

import com.google.android.exoplayer.chunk.FormatWrapper;
import com.google.android.exoplayer.chunk.f;

public final class n implements FormatWrapper {
    public final String a;
    public final f b;

    public n(int i, String str, int i2, String str2, int i3, int i4) {
        this.a = str;
        this.b = new f(Integer.toString(i), "application/x-mpegURL", i3, i4, -1.0f, -1, -1, i2, null, str2);
    }

    public f getFormat() {
        return this.b;
    }
}
