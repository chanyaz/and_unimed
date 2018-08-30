package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbav.zzb;

final class xl extends zzbav {
    private final byte[] b;
    private final int c;
    private final int d;
    private int e;

    xl(byte[] bArr, int i, int i2) {
        super();
        if (bArr == null) {
            throw new NullPointerException("buffer");
        } else if (((i2 | 0) | (bArr.length - (i2 + 0))) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i2)}));
        } else {
            this.b = bArr;
            this.c = 0;
            this.e = 0;
            this.d = i2 + 0;
        }
    }

    public final int a() {
        return this.d - this.e;
    }

    public final void a(byte b) {
        try {
            byte[] bArr = this.b;
            int i = this.e;
            this.e = i + 1;
            bArr[i] = b;
        } catch (Throwable e) {
            throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.e), Integer.valueOf(this.d), Integer.valueOf(1)}), e);
        }
    }

    public final void a(int i) {
        if (i >= 0) {
            b(i);
        } else {
            a((long) i);
        }
    }

    public final void a(int i, int i2) {
        b((i << 3) | i2);
    }

    public final void a(int i, long j) {
        a(i, 0);
        a(j);
    }

    public final void a(int i, zzbah zzbah) {
        a(i, 2);
        a(zzbah);
    }

    public final void a(int i, zzbcu zzbcu) {
        a(1, 3);
        c(2, i);
        a(3, 2);
        a(zzbcu);
        a(1, 4);
    }

    final void a(int i, zzbcu zzbcu, zzbdm zzbdm) {
        a(i, 2);
        wp wpVar = (wp) zzbcu;
        int h = wpVar.h();
        if (h == -1) {
            h = zzbdm.zzy(wpVar);
            wpVar.a(h);
        }
        b(h);
        zzbdm.zza(zzbcu, this.a);
    }

    public final void a(int i, String str) {
        a(i, 2);
        a(str);
    }

    public final void a(int i, boolean z) {
        int i2 = 0;
        a(i, 0);
        if (z) {
            i2 = 1;
        }
        a((byte) i2);
    }

    public final void a(long j) {
        byte[] bArr;
        int i;
        if (!zzbav.c || a() < 10) {
            while ((j & -128) != 0) {
                try {
                    bArr = this.b;
                    i = this.e;
                    this.e = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                } catch (Throwable e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.e), Integer.valueOf(this.d), Integer.valueOf(1)}), e);
                }
            }
            bArr = this.b;
            i = this.e;
            this.e = i + 1;
            bArr[i] = (byte) ((int) j);
            return;
        }
        while ((j & -128) != 0) {
            bArr = this.b;
            i = this.e;
            this.e = i + 1;
            aal.a(bArr, (long) i, (byte) ((((int) j) & 127) | 128));
            j >>>= 7;
        }
        bArr = this.b;
        i = this.e;
        this.e = i + 1;
        aal.a(bArr, (long) i, (byte) ((int) j));
    }

    public final void a(zzbah zzbah) {
        b(zzbah.a());
        zzbah.a((wy) this);
    }

    public final void a(zzbcu zzbcu) {
        b(zzbcu.zzacw());
        zzbcu.zzb(this);
    }

    public final void a(String str) {
        int i = this.e;
        try {
            int g = zzbav.g(str.length() * 3);
            int g2 = zzbav.g(str.length());
            if (g2 == g) {
                this.e = i + g2;
                g = aar.a(str, this.b, this.e, a());
                this.e = i;
                b((g - i) - g2);
                this.e = g;
                return;
            }
            b(aar.a((CharSequence) str));
            this.e = aar.a(str, this.b, this.e, a());
        } catch (aau e) {
            this.e = i;
            a(str, e);
        } catch (Throwable e2) {
            throw new zzb(e2);
        }
    }

    public final void a(byte[] bArr, int i, int i2) {
        b(bArr, i, i2);
    }

    public final void b(int i) {
        byte[] bArr;
        int i2;
        if (!zzbav.c || a() < 10) {
            while ((i & -128) != 0) {
                try {
                    bArr = this.b;
                    i2 = this.e;
                    this.e = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                } catch (Throwable e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.e), Integer.valueOf(this.d), Integer.valueOf(1)}), e);
                }
            }
            bArr = this.b;
            i2 = this.e;
            this.e = i2 + 1;
            bArr[i2] = (byte) i;
            return;
        }
        while ((i & -128) != 0) {
            bArr = this.b;
            i2 = this.e;
            this.e = i2 + 1;
            aal.a(bArr, (long) i2, (byte) ((i & 127) | 128));
            i >>>= 7;
        }
        bArr = this.b;
        i2 = this.e;
        this.e = i2 + 1;
        aal.a(bArr, (long) i2, (byte) i);
    }

    public final void b(int i, int i2) {
        a(i, 0);
        a(i2);
    }

    public final void b(int i, zzbah zzbah) {
        a(1, 3);
        c(2, i);
        a(3, zzbah);
        a(1, 4);
    }

    public final void b(byte[] bArr, int i, int i2) {
        try {
            System.arraycopy(bArr, i, this.b, this.e, i2);
            this.e += i2;
        } catch (Throwable e) {
            throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.e), Integer.valueOf(this.d), Integer.valueOf(i2)}), e);
        }
    }

    public final void c(int i, int i2) {
        a(i, 0);
        b(i2);
    }

    public final void c(int i, long j) {
        a(i, 1);
        c(j);
    }

    public final void c(long j) {
        try {
            byte[] bArr = this.b;
            int i = this.e;
            this.e = i + 1;
            bArr[i] = (byte) ((int) j);
            bArr = this.b;
            i = this.e;
            this.e = i + 1;
            bArr[i] = (byte) ((int) (j >> 8));
            bArr = this.b;
            i = this.e;
            this.e = i + 1;
            bArr[i] = (byte) ((int) (j >> 16));
            bArr = this.b;
            i = this.e;
            this.e = i + 1;
            bArr[i] = (byte) ((int) (j >> 24));
            bArr = this.b;
            i = this.e;
            this.e = i + 1;
            bArr[i] = (byte) ((int) (j >> 32));
            bArr = this.b;
            i = this.e;
            this.e = i + 1;
            bArr[i] = (byte) ((int) (j >> 40));
            bArr = this.b;
            i = this.e;
            this.e = i + 1;
            bArr[i] = (byte) ((int) (j >> 48));
            bArr = this.b;
            i = this.e;
            this.e = i + 1;
            bArr[i] = (byte) ((int) (j >> 56));
        } catch (Throwable e) {
            throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.e), Integer.valueOf(this.d), Integer.valueOf(1)}), e);
        }
    }

    public final void c(byte[] bArr, int i, int i2) {
        b(i2);
        b(bArr, 0, i2);
    }

    public final void d(int i) {
        try {
            byte[] bArr = this.b;
            int i2 = this.e;
            this.e = i2 + 1;
            bArr[i2] = (byte) i;
            bArr = this.b;
            i2 = this.e;
            this.e = i2 + 1;
            bArr[i2] = (byte) (i >> 8);
            bArr = this.b;
            i2 = this.e;
            this.e = i2 + 1;
            bArr[i2] = (byte) (i >> 16);
            bArr = this.b;
            i2 = this.e;
            this.e = i2 + 1;
            bArr[i2] = i >> 24;
        } catch (Throwable e) {
            throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.e), Integer.valueOf(this.d), Integer.valueOf(1)}), e);
        }
    }

    public final void e(int i, int i2) {
        a(i, 5);
        d(i2);
    }
}
