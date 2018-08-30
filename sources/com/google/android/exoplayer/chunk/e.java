package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.c;
import java.util.Arrays;

public abstract class e extends b {
    private byte[] a;
    private int g;
    private volatile boolean h;

    public e(DataSource dataSource, c cVar, int i, int i2, f fVar, byte[] bArr) {
        super(dataSource, cVar, i, i2, fVar);
        this.a = bArr;
    }

    private void b() {
        if (this.a == null) {
            this.a = new byte[16384];
        } else if (this.a.length < this.g + 16384) {
            this.a = Arrays.copyOf(this.a, this.a.length + 16384);
        }
    }

    protected abstract void a(byte[] bArr, int i);

    public byte[] a() {
        return this.a;
    }

    public final void cancelLoad() {
        this.h = true;
    }

    public long e() {
        return (long) this.g;
    }

    public final boolean isLoadCanceled() {
        return this.h;
    }

    public final void load() {
        int i = 0;
        try {
            this.f.open(this.e);
            this.g = 0;
            while (i != -1 && !this.h) {
                b();
                i = this.f.read(this.a, this.g, 16384);
                if (i != -1) {
                    this.g += i;
                }
            }
            if (!this.h) {
                a(this.a, this.g);
            }
            this.f.close();
        } catch (Throwable th) {
            this.f.close();
        }
    }
}
