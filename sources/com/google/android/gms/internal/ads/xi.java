package com.google.android.gms.internal.ads;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.Arrays;

final class xi extends xg {
    private final byte[] d;
    private final boolean e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;

    private xi(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.k = MoPubClientPositioning.NO_REPEAT;
        this.d = bArr;
        this.f = i + i2;
        this.h = i;
        this.i = this.h;
        this.e = z;
    }

    private final byte A() {
        if (this.h == this.f) {
            throw zzbbu.a();
        }
        byte[] bArr = this.d;
        int i = this.h;
        this.h = i + 1;
        return bArr[i];
    }

    /* JADX WARNING: Missing block: B:28:0x006a, code:
            if (r3[r2] < (byte) 0) goto L_0x006c;
     */
    private final int v() {
        /*
        r5 = this;
        r0 = r5.h;
        r1 = r5.f;
        if (r1 == r0) goto L_0x006c;
    L_0x0006:
        r3 = r5.d;
        r2 = r0 + 1;
        r0 = r3[r0];
        if (r0 < 0) goto L_0x0011;
    L_0x000e:
        r5.h = r2;
    L_0x0010:
        return r0;
    L_0x0011:
        r1 = r5.f;
        r1 = r1 - r2;
        r4 = 9;
        if (r1 < r4) goto L_0x006c;
    L_0x0018:
        r1 = r2 + 1;
        r2 = r3[r2];
        r2 = r2 << 7;
        r0 = r0 ^ r2;
        if (r0 >= 0) goto L_0x0026;
    L_0x0021:
        r0 = r0 ^ -128;
    L_0x0023:
        r5.h = r1;
        goto L_0x0010;
    L_0x0026:
        r2 = r1 + 1;
        r1 = r3[r1];
        r1 = r1 << 14;
        r0 = r0 ^ r1;
        if (r0 < 0) goto L_0x0033;
    L_0x002f:
        r0 = r0 ^ 16256;
        r1 = r2;
        goto L_0x0023;
    L_0x0033:
        r1 = r2 + 1;
        r2 = r3[r2];
        r2 = r2 << 21;
        r0 = r0 ^ r2;
        if (r0 >= 0) goto L_0x0041;
    L_0x003c:
        r2 = -2080896; // 0xffffffffffe03f80 float:NaN double:NaN;
        r0 = r0 ^ r2;
        goto L_0x0023;
    L_0x0041:
        r2 = r1 + 1;
        r1 = r3[r1];
        r4 = r1 << 28;
        r0 = r0 ^ r4;
        r4 = 266354560; // 0xfe03f80 float:2.2112565E-29 double:1.315966377E-315;
        r0 = r0 ^ r4;
        if (r1 >= 0) goto L_0x0072;
    L_0x004e:
        r1 = r2 + 1;
        r2 = r3[r2];
        if (r2 >= 0) goto L_0x0023;
    L_0x0054:
        r2 = r1 + 1;
        r1 = r3[r1];
        if (r1 >= 0) goto L_0x0072;
    L_0x005a:
        r1 = r2 + 1;
        r2 = r3[r2];
        if (r2 >= 0) goto L_0x0023;
    L_0x0060:
        r2 = r1 + 1;
        r1 = r3[r1];
        if (r1 >= 0) goto L_0x0072;
    L_0x0066:
        r1 = r2 + 1;
        r2 = r3[r2];
        if (r2 >= 0) goto L_0x0023;
    L_0x006c:
        r0 = r5.s();
        r0 = (int) r0;
        goto L_0x0010;
    L_0x0072:
        r1 = r2;
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.xi.v():int");
    }

    /* JADX WARNING: Missing block: B:32:0x00b2, code:
            if (((long) r4[r3]) < 0) goto L_0x00b4;
     */
    private final long w() {
        /*
        r10 = this;
        r8 = 0;
        r0 = r10.h;
        r1 = r10.f;
        if (r1 == r0) goto L_0x00b4;
    L_0x0008:
        r4 = r10.d;
        r1 = r0 + 1;
        r0 = r4[r0];
        if (r0 < 0) goto L_0x0014;
    L_0x0010:
        r10.h = r1;
        r0 = (long) r0;
    L_0x0013:
        return r0;
    L_0x0014:
        r2 = r10.f;
        r2 = r2 - r1;
        r3 = 9;
        if (r2 < r3) goto L_0x00b4;
    L_0x001b:
        r2 = r1 + 1;
        r1 = r4[r1];
        r1 = r1 << 7;
        r0 = r0 ^ r1;
        if (r0 >= 0) goto L_0x002a;
    L_0x0024:
        r0 = r0 ^ -128;
        r0 = (long) r0;
    L_0x0027:
        r10.h = r2;
        goto L_0x0013;
    L_0x002a:
        r3 = r2 + 1;
        r1 = r4[r2];
        r1 = r1 << 14;
        r0 = r0 ^ r1;
        if (r0 < 0) goto L_0x0038;
    L_0x0033:
        r0 = r0 ^ 16256;
        r0 = (long) r0;
        r2 = r3;
        goto L_0x0027;
    L_0x0038:
        r2 = r3 + 1;
        r1 = r4[r3];
        r1 = r1 << 21;
        r0 = r0 ^ r1;
        if (r0 >= 0) goto L_0x0047;
    L_0x0041:
        r1 = -2080896; // 0xffffffffffe03f80 float:NaN double:NaN;
        r0 = r0 ^ r1;
        r0 = (long) r0;
        goto L_0x0027;
    L_0x0047:
        r0 = (long) r0;
        r3 = r2 + 1;
        r2 = r4[r2];
        r6 = (long) r2;
        r2 = 28;
        r6 = r6 << r2;
        r0 = r0 ^ r6;
        r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r2 < 0) goto L_0x005b;
    L_0x0055:
        r4 = 266354560; // 0xfe03f80 float:2.2112565E-29 double:1.315966377E-315;
        r0 = r0 ^ r4;
        r2 = r3;
        goto L_0x0027;
    L_0x005b:
        r2 = r3 + 1;
        r3 = r4[r3];
        r6 = (long) r3;
        r3 = 35;
        r6 = r6 << r3;
        r0 = r0 ^ r6;
        r3 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r3 >= 0) goto L_0x006f;
    L_0x0068:
        r4 = -34093383808; // 0xfffffff80fe03f80 float:2.2112565E-29 double:NaN;
        r0 = r0 ^ r4;
        goto L_0x0027;
    L_0x006f:
        r3 = r2 + 1;
        r2 = r4[r2];
        r6 = (long) r2;
        r2 = 42;
        r6 = r6 << r2;
        r0 = r0 ^ r6;
        r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r2 < 0) goto L_0x0084;
    L_0x007c:
        r4 = 4363953127296; // 0x3f80fe03f80 float:2.2112565E-29 double:2.1560793202584E-311;
        r0 = r0 ^ r4;
        r2 = r3;
        goto L_0x0027;
    L_0x0084:
        r2 = r3 + 1;
        r3 = r4[r3];
        r6 = (long) r3;
        r3 = 49;
        r6 = r6 << r3;
        r0 = r0 ^ r6;
        r3 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r3 >= 0) goto L_0x0098;
    L_0x0091:
        r4 = -558586000294016; // 0xfffe03f80fe03f80 float:2.2112565E-29 double:NaN;
        r0 = r0 ^ r4;
        goto L_0x0027;
    L_0x0098:
        r3 = r2 + 1;
        r2 = r4[r2];
        r6 = (long) r2;
        r2 = 56;
        r6 = r6 << r2;
        r0 = r0 ^ r6;
        r6 = 71499008037633920; // 0xfe03f80fe03f80 float:2.2112565E-29 double:6.838959413692434E-304;
        r0 = r0 ^ r6;
        r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r2 >= 0) goto L_0x00ba;
    L_0x00ab:
        r2 = r3 + 1;
        r3 = r4[r3];
        r4 = (long) r3;
        r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r3 >= 0) goto L_0x0027;
    L_0x00b4:
        r0 = r10.s();
        goto L_0x0013;
    L_0x00ba:
        r2 = r3;
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.xi.w():long");
    }

    private final int x() {
        int i = this.h;
        if (this.f - i < 4) {
            throw zzbbu.a();
        }
        byte[] bArr = this.d;
        this.h = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 2] & 255) << 16));
    }

    private final long y() {
        int i = this.h;
        if (this.f - i < 8) {
            throw zzbbu.a();
        }
        byte[] bArr = this.d;
        this.h = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((((((((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8)) | ((((long) bArr[i + 2]) & 255) << 16)) | ((((long) bArr[i + 3]) & 255) << 24)) | ((((long) bArr[i + 4]) & 255) << 32)) | ((((long) bArr[i + 5]) & 255) << 40)) | ((((long) bArr[i + 6]) & 255) << 48));
    }

    private final void z() {
        this.f += this.g;
        int i = this.f - this.i;
        if (i > this.k) {
            this.g = i - this.k;
            this.f -= this.g;
            return;
        }
        this.g = 0;
    }

    public final int a() {
        if (t()) {
            this.j = 0;
            return 0;
        }
        this.j = v();
        if ((this.j >>> 3) != 0) {
            return this.j;
        }
        throw zzbbu.d();
    }

    public final void a(int i) {
        if (this.j != i) {
            throw zzbbu.e();
        }
    }

    public final double b() {
        return Double.longBitsToDouble(y());
    }

    public final boolean b(int i) {
        int i2 = 0;
        switch (i & 7) {
            case 0:
                if (this.f - this.h >= 10) {
                    while (i2 < 10) {
                        byte[] bArr = this.d;
                        int i3 = this.h;
                        this.h = i3 + 1;
                        if (bArr[i3] >= (byte) 0) {
                            return true;
                        }
                        i2++;
                    }
                    throw zzbbu.c();
                }
                while (i2 < 10) {
                    if (A() >= (byte) 0) {
                        return true;
                    }
                    i2++;
                }
                throw zzbbu.c();
            case 1:
                e(8);
                return true;
            case 2:
                e(v());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                e(4);
                return true;
            default:
                throw zzbbu.f();
        }
        do {
            i2 = a();
            if (i2 != 0) {
            }
            a(((i >>> 3) << 3) | 4);
            return true;
        } while (b(i2));
        a(((i >>> 3) << 3) | 4);
        return true;
    }

    public final float c() {
        return Float.intBitsToFloat(x());
    }

    public final int c(int i) {
        if (i < 0) {
            throw zzbbu.b();
        }
        int u = u() + i;
        int i2 = this.k;
        if (u > i2) {
            throw zzbbu.a();
        }
        this.k = u;
        z();
        return i2;
    }

    public final long d() {
        return w();
    }

    public final void d(int i) {
        this.k = i;
        z();
    }

    public final long e() {
        return w();
    }

    public final void e(int i) {
        if (i >= 0 && i <= this.f - this.h) {
            this.h += i;
        } else if (i < 0) {
            throw zzbbu.b();
        } else {
            throw zzbbu.a();
        }
    }

    public final int f() {
        return v();
    }

    public final long g() {
        return y();
    }

    public final int h() {
        return x();
    }

    public final boolean i() {
        return w() != 0;
    }

    public final String j() {
        int v = v();
        if (v > 0 && v <= this.f - this.h) {
            String str = new String(this.d, this.h, v, yk.a);
            this.h = v + this.h;
            return str;
        } else if (v == 0) {
            return "";
        } else {
            if (v < 0) {
                throw zzbbu.b();
            }
            throw zzbbu.a();
        }
    }

    public final String k() {
        int v = v();
        if (v <= 0 || v > this.f - this.h) {
            if (v == 0) {
                return "";
            }
            if (v <= 0) {
                throw zzbbu.b();
            }
            throw zzbbu.a();
        } else if (aar.a(this.d, this.h, this.h + v)) {
            int i = this.h;
            this.h += v;
            return new String(this.d, i, v, yk.a);
        } else {
            throw zzbbu.h();
        }
    }

    public final zzbah l() {
        int v = v();
        if (v > 0 && v <= this.f - this.h) {
            zzbah a = zzbah.a(this.d, this.h, v);
            this.h = v + this.h;
            return a;
        } else if (v == 0) {
            return zzbah.a;
        } else {
            byte[] copyOfRange;
            if (v > 0 && v <= this.f - this.h) {
                int i = this.h;
                this.h = v + this.h;
                copyOfRange = Arrays.copyOfRange(this.d, i, this.h);
            } else if (v > 0) {
                throw zzbbu.a();
            } else if (v == 0) {
                copyOfRange = yk.b;
            } else {
                throw zzbbu.b();
            }
            return zzbah.b(copyOfRange);
        }
    }

    public final int m() {
        return v();
    }

    public final int n() {
        return v();
    }

    public final int o() {
        return x();
    }

    public final long p() {
        return y();
    }

    public final int q() {
        return xg.f(v());
    }

    public final long r() {
        return xg.a(w());
    }

    final long s() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte A = A();
            j |= ((long) (A & 127)) << i;
            if ((A & 128) == 0) {
                return j;
            }
        }
        throw zzbbu.c();
    }

    public final boolean t() {
        return this.h == this.f;
    }

    public final int u() {
        return this.h - this.i;
    }
}
