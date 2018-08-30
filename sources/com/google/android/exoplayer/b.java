package com.google.android.exoplayer;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo;
import com.google.android.exoplayer.util.m;

public final class b {
    public byte[] a;
    public byte[] b;
    public int c;
    public int[] d;
    public int[] e;
    public int f;
    private final CryptoInfo g;

    public b() {
        this.g = m.a >= 16 ? b() : null;
    }

    @TargetApi(16)
    private CryptoInfo b() {
        return new CryptoInfo();
    }

    @TargetApi(16)
    private void c() {
        this.g.set(this.f, this.d, this.e, this.b, this.a, this.c);
    }

    @TargetApi(16)
    public CryptoInfo a() {
        return this.g;
    }

    public void a(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2) {
        this.f = i;
        this.d = iArr;
        this.e = iArr2;
        this.b = bArr;
        this.a = bArr2;
        this.c = i2;
        if (m.a >= 16) {
            c();
        }
    }
}
