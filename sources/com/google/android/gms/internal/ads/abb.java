package com.google.android.gms.internal.ads;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

public final class abb {
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

    private abb(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.b = i;
        int i3 = i + i2;
        this.d = i3;
        this.c = i3;
        this.f = i;
    }

    public static abb a(byte[] bArr, int i, int i2) {
        return new abb(bArr, 0, i2);
    }

    private final void f(int i) {
        if (i < 0) {
            throw zzbfh.b();
        } else if (this.f + i > this.h) {
            f(this.h - this.f);
            throw zzbfh.a();
        } else if (i <= this.d - this.f) {
            this.f += i;
        } else {
            throw zzbfh.a();
        }
    }

    private final void k() {
        this.d += this.e;
        int i = this.d;
        if (i > this.h) {
            this.e = i - this.h;
            this.d -= this.e;
            return;
        }
        this.e = 0;
    }

    private final byte l() {
        if (this.f == this.d) {
            throw zzbfh.a();
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
        this.g = g();
        if (this.g != 0) {
            return this.g;
        }
        throw new zzbfh("Protocol message contained an invalid tag (zero).");
    }

    public final void a(int i) {
        if (this.g != i) {
            throw new zzbfh("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final void a(abj abj) {
        int g = g();
        if (this.i >= this.j) {
            throw new zzbfh("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        g = c(g);
        this.i++;
        abj.a(this);
        a(0);
        this.i--;
        d(g);
    }

    public final byte[] a(int i, int i2) {
        if (i2 == 0) {
            return abm.e;
        }
        Object obj = new byte[i2];
        System.arraycopy(this.a, this.b + i, obj, 0, i2);
        return obj;
    }

    public final long b() {
        return h();
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

    public final boolean b(int i) {
        switch (i & 7) {
            case 0:
                g();
                return true;
            case 1:
                l();
                l();
                l();
                l();
                l();
                l();
                l();
                l();
                return true;
            case 2:
                f(g());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                l();
                l();
                l();
                l();
                return true;
            default:
                throw new zzbfh("Protocol message tag had invalid wire type.");
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

    public final int c() {
        return g();
    }

    public final int c(int i) {
        if (i < 0) {
            throw zzbfh.b();
        }
        int i2 = this.f + i;
        int i3 = this.h;
        if (i2 > i3) {
            throw zzbfh.a();
        }
        this.h = i2;
        k();
        return i3;
    }

    public final void d(int i) {
        this.h = i;
        k();
    }

    public final boolean d() {
        return g() != 0;
    }

    public final String e() {
        int g = g();
        if (g < 0) {
            throw zzbfh.b();
        } else if (g > this.d - this.f) {
            throw zzbfh.a();
        } else {
            String str = new String(this.a, this.f, g, abi.a);
            this.f = g + this.f;
            return str;
        }
    }

    public final void e(int i) {
        b(i, this.g);
    }

    public final byte[] f() {
        int g = g();
        if (g < 0) {
            throw zzbfh.b();
        } else if (g == 0) {
            return abm.e;
        } else {
            if (g > this.d - this.f) {
                throw zzbfh.a();
            }
            Object obj = new byte[g];
            System.arraycopy(this.a, this.f, obj, 0, g);
            this.f = g + this.f;
            return obj;
        }
    }

    public final int g() {
        byte l = l();
        if (l >= (byte) 0) {
            return l;
        }
        int i = l & 127;
        byte l2 = l();
        if (l2 >= (byte) 0) {
            return i | (l2 << 7);
        }
        i |= (l2 & 127) << 7;
        l2 = l();
        if (l2 >= (byte) 0) {
            return i | (l2 << 14);
        }
        i |= (l2 & 127) << 14;
        l2 = l();
        if (l2 >= (byte) 0) {
            return i | (l2 << 21);
        }
        i |= (l2 & 127) << 21;
        l2 = l();
        i |= l2 << 28;
        if (l2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (l() >= (byte) 0) {
                return i;
            }
        }
        throw zzbfh.c();
    }

    public final long h() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte l = l();
            j |= ((long) (l & 127)) << i;
            if ((l & 128) == 0) {
                return j;
            }
        }
        throw zzbfh.c();
    }

    public final int i() {
        if (this.h == MoPubClientPositioning.NO_REPEAT) {
            return -1;
        }
        return this.h - this.f;
    }

    public final int j() {
        return this.f - this.b;
    }
}
