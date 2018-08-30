package com.google.android.gms.internal.measurement;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

public final class h {
    private final byte[] a;
    private final int b;
    private final int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h = MoPubClientPositioning.NO_REPEAT;
    private int i;
    private int j = 64;
    private int k = 67108864;

    private h(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.b = i;
        int i3 = i + i2;
        this.d = i3;
        this.c = i3;
        this.f = i;
    }

    public static h a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static h a(byte[] bArr, int i, int i2) {
        return new h(bArr, 0, i2);
    }

    private final void f(int i) {
        if (i < 0) {
            throw zzacd.b();
        } else if (this.f + i > this.h) {
            f(this.h - this.f);
            throw zzacd.a();
        } else if (i <= this.d - this.f) {
            this.f += i;
        } else {
            throw zzacd.a();
        }
    }

    private final void j() {
        this.d += this.e;
        int i = this.d;
        if (i > this.h) {
            this.e = i - this.h;
            this.d -= this.e;
            return;
        }
        this.e = 0;
    }

    private final byte k() {
        if (this.f == this.d) {
            throw zzacd.a();
        }
        byte[] bArr = this.a;
        int i = this.f;
        this.f = i + 1;
        return bArr[i];
    }

    public final int a() {
        if (this.f == this.d) {
            this.g = 0;
            return 0;
        }
        this.g = d();
        if (this.g != 0) {
            return this.g;
        }
        throw new zzacd("Protocol message contained an invalid tag (zero).");
    }

    public final void a(int i) {
        if (this.g != i) {
            throw new zzacd("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final void a(p pVar) {
        int d = d();
        if (this.i >= this.j) {
            throw zzacd.d();
        }
        d = c(d);
        this.i++;
        pVar.a(this);
        a(0);
        this.i--;
        d(d);
    }

    public final void a(p pVar, int i) {
        if (this.i >= this.j) {
            throw zzacd.d();
        }
        this.i++;
        pVar.a(this);
        a((i << 3) | 4);
        this.i--;
    }

    public final byte[] a(int i, int i2) {
        if (i2 == 0) {
            return s.d;
        }
        Object obj = new byte[i2];
        System.arraycopy(this.a, this.b + i, obj, 0, i2);
        return obj;
    }

    final void b(int i, int i2) {
        if (i > this.f - this.b) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.f - this.b));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.f = this.b + i;
            this.g = i2;
        }
    }

    public final boolean b() {
        return d() != 0;
    }

    public final boolean b(int i) {
        switch (i & 7) {
            case 0:
                d();
                return true;
            case 1:
                g();
                return true;
            case 2:
                f(d());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                f();
                return true;
            default:
                throw new zzacd("Protocol message tag had invalid wire type.");
        }
        int a;
        do {
            a = a();
            if (a != 0) {
            }
            a(((i >>> 3) << 3) | 4);
            return true;
        } while (b(a));
        a(((i >>> 3) << 3) | 4);
        return true;
    }

    public final int c(int i) {
        if (i < 0) {
            throw zzacd.b();
        }
        int i2 = this.f + i;
        int i3 = this.h;
        if (i2 > i3) {
            throw zzacd.a();
        }
        this.h = i2;
        j();
        return i3;
    }

    public final String c() {
        int d = d();
        if (d < 0) {
            throw zzacd.b();
        } else if (d > this.d - this.f) {
            throw zzacd.a();
        } else {
            String str = new String(this.a, this.f, d, o.a);
            this.f = d + this.f;
            return str;
        }
    }

    public final int d() {
        byte k = k();
        if (k >= (byte) 0) {
            return k;
        }
        int i = k & 127;
        byte k2 = k();
        if (k2 >= (byte) 0) {
            return i | (k2 << 7);
        }
        i |= (k2 & 127) << 7;
        k2 = k();
        if (k2 >= (byte) 0) {
            return i | (k2 << 14);
        }
        i |= (k2 & 127) << 14;
        k2 = k();
        if (k2 >= (byte) 0) {
            return i | (k2 << 21);
        }
        i |= (k2 & 127) << 21;
        k2 = k();
        i |= k2 << 28;
        if (k2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (k() >= (byte) 0) {
                return i;
            }
        }
        throw zzacd.c();
    }

    public final void d(int i) {
        this.h = i;
        j();
    }

    public final long e() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte k = k();
            j |= ((long) (k & 127)) << i;
            if ((k & 128) == 0) {
                return j;
            }
        }
        throw zzacd.c();
    }

    public final void e(int i) {
        b(i, this.g);
    }

    public final int f() {
        return (((k() & 255) | ((k() & 255) << 8)) | ((k() & 255) << 16)) | ((k() & 255) << 24);
    }

    public final long g() {
        byte k = k();
        byte k2 = k();
        return ((((((((((long) k2) & 255) << 8) | (((long) k) & 255)) | ((((long) k()) & 255) << 16)) | ((((long) k()) & 255) << 24)) | ((((long) k()) & 255) << 32)) | ((((long) k()) & 255) << 40)) | ((((long) k()) & 255) << 48)) | ((((long) k()) & 255) << 56);
    }

    public final int h() {
        if (this.h == MoPubClientPositioning.NO_REPEAT) {
            return -1;
        }
        return this.h - this.f;
    }

    public final int i() {
        return this.f - this.b;
    }
}
