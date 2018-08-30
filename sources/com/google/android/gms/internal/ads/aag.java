package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class aag {
    private static final aag a = new aag(0, new int[0], new Object[0], false);
    private int b;
    private int[] c;
    private Object[] d;
    private int e;
    private boolean f;

    private aag() {
        this(0, new int[8], new Object[8], true);
    }

    private aag(int i, int[] iArr, Object[] objArr, boolean z) {
        this.e = -1;
        this.b = i;
        this.c = iArr;
        this.d = objArr;
        this.f = z;
    }

    public static aag a() {
        return a;
    }

    static aag a(aag aag, aag aag2) {
        int i = aag.b + aag2.b;
        Object copyOf = Arrays.copyOf(aag.c, i);
        System.arraycopy(aag2.c, 0, copyOf, aag.b, aag2.b);
        Object copyOf2 = Arrays.copyOf(aag.d, i);
        System.arraycopy(aag2.d, 0, copyOf2, aag.b, aag2.b);
        return new aag(i, copyOf, copyOf2, true);
    }

    private static void a(int i, Object obj, zzbey zzbey) {
        int i2 = i >>> 3;
        switch (i & 7) {
            case 0:
                zzbey.zzi(i2, ((Long) obj).longValue());
                return;
            case 1:
                zzbey.zzc(i2, ((Long) obj).longValue());
                return;
            case 2:
                zzbey.zza(i2, (zzbah) obj);
                return;
            case 3:
                if (zzbey.zzacn() == yi.j) {
                    zzbey.zzcm(i2);
                    ((aag) obj).b(zzbey);
                    zzbey.zzcn(i2);
                    return;
                }
                zzbey.zzcn(i2);
                ((aag) obj).b(zzbey);
                zzbey.zzcm(i2);
                return;
            case 5:
                zzbey.zzp(i2, ((Integer) obj).intValue());
                return;
            default:
                throw new RuntimeException(zzbbu.f());
        }
    }

    static aag b() {
        return new aag();
    }

    final void a(int i, Object obj) {
        if (this.f) {
            if (this.b == this.c.length) {
                int i2 = (this.b < 4 ? 8 : this.b >> 1) + this.b;
                this.c = Arrays.copyOf(this.c, i2);
                this.d = Arrays.copyOf(this.d, i2);
            }
            this.c[this.b] = i;
            this.d[this.b] = obj;
            this.b++;
            return;
        }
        throw new UnsupportedOperationException();
    }

    final void a(zzbey zzbey) {
        int i;
        if (zzbey.zzacn() == yi.k) {
            for (i = this.b - 1; i >= 0; i--) {
                zzbey.zza(this.c[i] >>> 3, this.d[i]);
            }
            return;
        }
        for (i = 0; i < this.b; i++) {
            zzbey.zza(this.c[i] >>> 3, this.d[i]);
        }
    }

    final void a(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 < this.b; i2++) {
            ze.a(stringBuilder, i, String.valueOf(this.c[i2] >>> 3), this.d[i2]);
        }
    }

    public final void b(zzbey zzbey) {
        if (this.b != 0) {
            int i;
            if (zzbey.zzacn() == yi.j) {
                for (i = 0; i < this.b; i++) {
                    a(this.c[i], this.d[i], zzbey);
                }
                return;
            }
            for (i = this.b - 1; i >= 0; i--) {
                a(this.c[i], this.d[i], zzbey);
            }
        }
    }

    public final void c() {
        this.f = false;
    }

    public final int d() {
        int i = 0;
        int i2 = this.e;
        if (i2 == -1) {
            int i3 = 0;
            while (true) {
                i2 = i;
                if (i3 >= this.b) {
                    break;
                }
                i2 += zzbav.d(this.c[i3] >>> 3, (zzbah) this.d[i3]);
                i = i3 + 1;
            }
            this.e = i2;
        }
        return i2;
    }

    public final int e() {
        int i = 0;
        int i2 = this.e;
        if (i2 == -1) {
            int i3 = 0;
            while (true) {
                i2 = i;
                if (i3 < this.b) {
                    i = this.c[i3];
                    int i4 = i >>> 3;
                    switch (i & 7) {
                        case 0:
                            i = zzbav.e(i4, ((Long) this.d[i3]).longValue());
                            break;
                        case 1:
                            i = zzbav.g(i4, ((Long) this.d[i3]).longValue());
                            break;
                        case 2:
                            i = zzbav.c(i4, (zzbah) this.d[i3]);
                            break;
                        case 3:
                            i = ((aag) this.d[i3]).e() + (zzbav.e(i4) << 1);
                            break;
                        case 5:
                            i = zzbav.i(i4, ((Integer) this.d[i3]).intValue());
                            break;
                        default:
                            throw new IllegalStateException(zzbbu.f());
                    }
                    i2 += i;
                    i = i3 + 1;
                } else {
                    this.e = i2;
                }
            }
        }
        return i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof aag)) {
            return false;
        }
        aag aag = (aag) obj;
        if (this.b == aag.b) {
            int i;
            boolean z;
            int[] iArr = this.c;
            int[] iArr2 = aag.c;
            int i2 = this.b;
            for (i = 0; i < i2; i++) {
                if (iArr[i] != iArr2[i]) {
                    z = false;
                    break;
                }
            }
            z = true;
            if (z) {
                Object[] objArr = this.d;
                Object[] objArr2 = aag.d;
                i2 = this.b;
                for (i = 0; i < i2; i++) {
                    if (!objArr[i].equals(objArr2[i])) {
                        z = false;
                        break;
                    }
                }
                z = true;
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int i2 = 17;
        int i3 = 0;
        int i4 = (this.b + 527) * 31;
        int[] iArr = this.c;
        int i5 = 17;
        for (i = 0; i < this.b; i++) {
            i5 = (i5 * 31) + iArr[i];
        }
        i = (i4 + i5) * 31;
        Object[] objArr = this.d;
        while (i3 < this.b) {
            i2 = (i2 * 31) + objArr[i3].hashCode();
            i3++;
        }
        return i + i2;
    }
}
