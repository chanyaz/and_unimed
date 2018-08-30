package com.google.android.exoplayer.extractor;

import com.google.android.exoplayer.m;
import com.google.android.exoplayer.upstream.Allocator;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.a;
import com.google.android.exoplayer.util.i;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingDeque;

final class h {
    private final Allocator a;
    private final int b;
    private final i c = new i();
    private final LinkedBlockingDeque<a> d = new LinkedBlockingDeque();
    private final j e = new j();
    private final i f = new i(32);
    private long g;
    private long h;
    private a i;
    private int j = this.b;

    public h(Allocator allocator) {
        this.a = allocator;
        this.b = allocator.getIndividualAllocationLength();
    }

    private void a(long j, ByteBuffer byteBuffer, int i) {
        while (i > 0) {
            c(j);
            int i2 = (int) (j - this.g);
            int min = Math.min(i, this.b - i2);
            a aVar = (a) this.d.peek();
            byteBuffer.put(aVar.a, aVar.a(i2), min);
            j += (long) min;
            i -= min;
        }
    }

    private void a(long j, byte[] bArr, int i) {
        int i2 = 0;
        while (i2 < i) {
            c(j);
            int i3 = (int) (j - this.g);
            int min = Math.min(i - i2, this.b - i3);
            a aVar = (a) this.d.peek();
            System.arraycopy(aVar.a, aVar.a(i3), bArr, i2, min);
            j += (long) min;
            i2 += min;
        }
    }

    private void a(m mVar, j jVar) {
        long j;
        int i = 0;
        long j2 = jVar.a;
        a(j2, this.f.a, 1);
        long j3 = 1 + j2;
        byte b = this.f.a[0];
        int i2 = (b & 128) != 0 ? 1 : 0;
        int i3 = b & 127;
        if (mVar.a.a == null) {
            mVar.a.a = new byte[16];
        }
        a(j3, mVar.a.a, i3);
        j3 += (long) i3;
        if (i2 != 0) {
            a(j3, this.f.a, 2);
            j3 += 2;
            this.f.b(0);
            i3 = this.f.g();
            j = j3;
        } else {
            i3 = 1;
            j = j3;
        }
        int[] iArr = mVar.a.d;
        if (iArr == null || iArr.length < i3) {
            iArr = new int[i3];
        }
        int[] iArr2 = mVar.a.e;
        if (iArr2 == null || iArr2.length < i3) {
            iArr2 = new int[i3];
        }
        if (i2 != 0) {
            i2 = i3 * 6;
            b(this.f, i2);
            a(j, this.f.a, i2);
            j += (long) i2;
            this.f.b(0);
            while (i < i3) {
                iArr[i] = this.f.g();
                iArr2[i] = this.f.m();
                i++;
            }
        } else {
            iArr[0] = 0;
            iArr2[0] = mVar.c - ((int) (j - jVar.a));
        }
        mVar.a.a(i3, iArr, iArr2, jVar.b, mVar.a.a, 1);
        i2 = (int) (j - jVar.a);
        jVar.a += (long) i2;
        mVar.c -= i2;
    }

    private int b(int i) {
        if (this.j == this.b) {
            this.j = 0;
            this.i = this.a.allocate();
            this.d.add(this.i);
        }
        return Math.min(i, this.b - this.j);
    }

    private void b(long j) {
        int i = (int) (j - this.g);
        int i2 = i % this.b;
        i = (this.d.size() - (i / this.b)) - 1;
        int i3 = i2 == 0 ? i + 1 : i;
        for (int i4 = 0; i4 < i3; i4++) {
            this.a.release((a) this.d.removeLast());
        }
        this.i = (a) this.d.peekLast();
        this.j = i2 == 0 ? this.b : i2;
    }

    private static void b(i iVar, int i) {
        if (iVar.c() < i) {
            iVar.a(new byte[i], i);
        }
    }

    private void c(long j) {
        int i = ((int) (j - this.g)) / this.b;
        for (int i2 = 0; i2 < i; i2++) {
            this.a.release((a) this.d.remove());
            this.g += (long) this.b;
        }
    }

    public int a(ExtractorInput extractorInput, int i, boolean z) {
        int read = extractorInput.read(this.i.a, this.i.a(this.j), b(i));
        if (read != -1) {
            this.j += read;
            this.h += (long) read;
            return read;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public int a(DataSource dataSource, int i, boolean z) {
        int read = dataSource.read(this.i.a, this.i.a(this.j), b(i));
        if (read != -1) {
            this.j += read;
            this.h += (long) read;
            return read;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public void a() {
        this.c.a();
        while (!this.d.isEmpty()) {
            this.a.release((a) this.d.remove());
        }
        this.g = 0;
        this.h = 0;
        this.i = null;
        this.j = this.b;
    }

    public void a(int i) {
        this.h = this.c.a(i);
        b(this.h);
    }

    public void a(long j, int i, long j2, int i2, byte[] bArr) {
        this.c.a(j, i, j2, i2, bArr);
    }

    public void a(i iVar, int i) {
        while (i > 0) {
            int b = b(i);
            iVar.a(this.i.a, this.i.a(this.j), b);
            this.j += b;
            this.h += (long) b;
            i -= b;
        }
    }

    public boolean a(long j) {
        long a = this.c.a(j);
        if (a == -1) {
            return false;
        }
        c(a);
        return true;
    }

    public boolean a(m mVar) {
        return this.c.a(mVar, this.e);
    }

    public int b() {
        return this.c.b();
    }

    public boolean b(m mVar) {
        if (!this.c.a(mVar, this.e)) {
            return false;
        }
        if (mVar.a()) {
            a(mVar, this.e);
        }
        if (mVar.b == null || mVar.b.capacity() < mVar.c) {
            mVar.a(mVar.c);
        }
        if (mVar.b != null) {
            a(this.e.a, mVar.b, mVar.c);
        }
        c(this.c.d());
        return true;
    }

    public int c() {
        return this.c.c();
    }

    public void d() {
        c(this.c.d());
    }

    public long e() {
        return this.h;
    }
}
