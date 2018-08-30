package com.google.android.exoplayer.smoothstreaming;

import com.google.android.exoplayer.chunk.FormatWrapper;
import com.google.android.exoplayer.chunk.f;

public class d implements FormatWrapper {
    public final f a;
    public final byte[][] b;

    public d(int i, int i2, String str, byte[][] bArr, int i3, int i4, int i5, int i6) {
        this.b = bArr;
        this.a = new f(String.valueOf(i), str, i3, i4, -1.0f, i6, i5, i2);
    }

    public f getFormat() {
        return this.a;
    }
}
