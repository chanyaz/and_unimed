package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import sun.misc.Unsafe;

final class zf<T> implements zzbdm<T> {
    private static final Unsafe a = aal.c();
    private final int[] b;
    private final Object[] c;
    private final int d;
    private final int e;
    private final int f;
    private final zzbcu g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final int[] l;
    private final int[] m;
    private final int[] n;
    private final zzbdc o;
    private final ys p;
    private final aaf<?, ?> q;
    private final xu<?> r;
    private final zzbcp s;

    private zf(int[] iArr, Object[] objArr, int i, int i2, int i3, zzbcu zzbcu, boolean z, boolean z2, int[] iArr2, int[] iArr3, int[] iArr4, zzbdc zzbdc, ys ysVar, aaf<?, ?> aaf, xu<?> xuVar, zzbcp zzbcp) {
        this.b = iArr;
        this.c = objArr;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.i = zzbcu instanceof yd;
        this.j = z;
        boolean z3 = xuVar != null && xuVar.a(zzbcu);
        this.h = z3;
        this.k = false;
        this.l = iArr2;
        this.m = iArr3;
        this.n = iArr4;
        this.o = zzbdc;
        this.p = ysVar;
        this.q = aaf;
        this.r = xuVar;
        this.g = zzbcu;
        this.s = zzbcp;
    }

    private static int a(int i, byte[] bArr, int i2, int i3, Object obj, ww wwVar) {
        return wv.a(i, bArr, i2, i3, a(obj), wwVar);
    }

    private static <UT, UB> int a(aaf<UT, UB> aaf, T t) {
        return aaf.f(aaf.b(t));
    }

    private static int a(zzbdm<?> zzbdm, int i, byte[] bArr, int i2, int i3, zzbbt<?> zzbbt, ww wwVar) {
        int a = a(zzbdm, bArr, i2, i3, wwVar);
        zzbbt.add(wwVar.c);
        while (a < i3) {
            int a2 = wv.a(bArr, a, wwVar);
            if (i != wwVar.a) {
                break;
            }
            a = a(zzbdm, bArr, a2, i3, wwVar);
            zzbbt.add(wwVar.c);
        }
        return a;
    }

    private static int a(zzbdm zzbdm, byte[] bArr, int i, int i2, int i3, ww wwVar) {
        zf zfVar = (zf) zzbdm;
        Object newInstance = zfVar.newInstance();
        int a = zfVar.a(newInstance, bArr, i, i2, i3, wwVar);
        zfVar.zzo(newInstance);
        wwVar.c = newInstance;
        return a;
    }

    private static int a(zzbdm zzbdm, byte[] bArr, int i, int i2, ww wwVar) {
        int i3;
        int i4 = i + 1;
        int i5 = bArr[i];
        if (i5 < (byte) 0) {
            i4 = wv.a(i5, bArr, i4, wwVar);
            i3 = wwVar.a;
        } else {
            i3 = i5;
        }
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzbbu.a();
        }
        Object newInstance = zzbdm.newInstance();
        zzbdm.zza(newInstance, bArr, i4, i4 + i3, wwVar);
        zzbdm.zzo(newInstance);
        wwVar.c = newInstance;
        return i4 + i3;
    }

    private final int a(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, ww wwVar) {
        int i9;
        Unsafe unsafe = a;
        long j2 = (long) (this.b[i8 + 2] & 1048575);
        int b;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(wv.c(bArr, i)));
                    i9 = i + 8;
                    break;
                }
                return i;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(wv.d(bArr, i)));
                    i9 = i + 4;
                    break;
                }
                return i;
            case 53:
            case 54:
                if (i5 == 0) {
                    i9 = wv.b(bArr, i, wwVar);
                    unsafe.putObject(t, j, Long.valueOf(wwVar.b));
                    break;
                }
                return i;
            case 55:
            case 62:
                if (i5 == 0) {
                    i9 = wv.a(bArr, i, wwVar);
                    unsafe.putObject(t, j, Integer.valueOf(wwVar.a));
                    break;
                }
                return i;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(wv.b(bArr, i)));
                    i9 = i + 8;
                    break;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(wv.a(bArr, i)));
                    i9 = i + 4;
                    break;
                }
                return i;
            case 58:
                if (i5 == 0) {
                    b = wv.b(bArr, i, wwVar);
                    unsafe.putObject(t, j, Boolean.valueOf(wwVar.b != 0));
                    i9 = b;
                    break;
                }
                return i;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                i9 = wv.a(bArr, i, wwVar);
                b = wwVar.a;
                if (b == 0) {
                    unsafe.putObject(t, j, "");
                } else if ((536870912 & i6) == 0 || aar.a(bArr, i9, i9 + b)) {
                    unsafe.putObject(t, j, new String(bArr, i9, b, yk.a));
                    i9 += b;
                } else {
                    throw zzbbu.h();
                }
                unsafe.putInt(t, j2, i4);
                return i9;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                i = a(a(i8), bArr, i, i2, wwVar);
                Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                if (object == null) {
                    unsafe.putObject(t, j, wwVar.c);
                } else {
                    unsafe.putObject(t, j, yk.a(object, wwVar.c));
                }
                unsafe.putInt(t, j2, i4);
                return i;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                i9 = wv.a(bArr, i, wwVar);
                b = wwVar.a;
                if (b == 0) {
                    unsafe.putObject(t, j, zzbah.a);
                } else {
                    unsafe.putObject(t, j, zzbah.a(bArr, i9, b));
                    i9 += b;
                }
                unsafe.putInt(t, j2, i4);
                return i9;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                i9 = wv.a(bArr, i, wwVar);
                b = wwVar.a;
                zzbbs c = c(i8);
                if (c == null || c.zzq(b) != null) {
                    unsafe.putObject(t, j, Integer.valueOf(b));
                    break;
                }
                a((Object) t).a(i3, Long.valueOf((long) b));
                return i9;
            case 66:
                if (i5 == 0) {
                    i9 = wv.a(bArr, i, wwVar);
                    unsafe.putObject(t, j, Integer.valueOf(xg.f(wwVar.a)));
                    break;
                }
                return i;
            case 67:
                if (i5 == 0) {
                    i9 = wv.b(bArr, i, wwVar);
                    unsafe.putObject(t, j, Long.valueOf(xg.a(wwVar.b)));
                    break;
                }
                return i;
            case 68:
                if (i5 == 3) {
                    i9 = a(a(i8), bArr, i, i2, (i3 & -8) | 4, wwVar);
                    Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object2 != null) {
                        unsafe.putObject(t, j, yk.a(object2, wwVar.c));
                        break;
                    }
                    unsafe.putObject(t, j, wwVar.c);
                    break;
                }
                return i;
            default:
                return i;
        }
        unsafe.putInt(t, j2, i4);
        return i9;
    }

    private final int a(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, ww wwVar) {
        zzbbt zzbbt;
        int size;
        zzbbt zzbbt2 = (zzbbt) a.getObject(t, j2);
        if (zzbbt2.zzaay()) {
            zzbbt = zzbbt2;
        } else {
            size = zzbbt2.size();
            zzbbt = zzbbt2.zzbm(size == 0 ? 10 : size << 1);
            a.putObject(t, j2, zzbbt);
        }
        int i8;
        yw ywVar;
        yj yjVar;
        switch (i7) {
            case 18:
            case 35:
                xo xoVar;
                if (i5 == 2) {
                    xoVar = (xo) zzbbt;
                    i = wv.a(bArr, i, wwVar);
                    i8 = wwVar.a + i;
                    while (i < i8) {
                        xoVar.a(wv.c(bArr, i));
                        i += 8;
                    }
                    if (i == i8) {
                        return i;
                    }
                    throw zzbbu.a();
                } else if (i5 != 1) {
                    return i;
                } else {
                    xoVar = (xo) zzbbt;
                    xoVar.a(wv.c(bArr, i));
                    i += 8;
                    while (i < i2) {
                        i8 = wv.a(bArr, i, wwVar);
                        if (i3 != wwVar.a) {
                            return i;
                        }
                        xoVar.a(wv.c(bArr, i8));
                        i = i8 + 8;
                    }
                    return i;
                }
            case 19:
            case 36:
                yb ybVar;
                if (i5 == 2) {
                    ybVar = (yb) zzbbt;
                    i = wv.a(bArr, i, wwVar);
                    i8 = wwVar.a + i;
                    while (i < i8) {
                        ybVar.a(wv.d(bArr, i));
                        i += 4;
                    }
                    if (i == i8) {
                        return i;
                    }
                    throw zzbbu.a();
                } else if (i5 != 5) {
                    return i;
                } else {
                    ybVar = (yb) zzbbt;
                    ybVar.a(wv.d(bArr, i));
                    i += 4;
                    while (i < i2) {
                        i8 = wv.a(bArr, i, wwVar);
                        if (i3 != wwVar.a) {
                            return i;
                        }
                        ybVar.a(wv.d(bArr, i8));
                        i = i8 + 4;
                    }
                    return i;
                }
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    ywVar = (yw) zzbbt;
                    i = wv.a(bArr, i, wwVar);
                    i8 = wwVar.a + i;
                    while (i < i8) {
                        i = wv.b(bArr, i, wwVar);
                        ywVar.a(wwVar.b);
                    }
                    if (i == i8) {
                        return i;
                    }
                    throw zzbbu.a();
                } else if (i5 != 0) {
                    return i;
                } else {
                    ywVar = (yw) zzbbt;
                    i = wv.b(bArr, i, wwVar);
                    ywVar.a(wwVar.b);
                    while (i < i2) {
                        i8 = wv.a(bArr, i, wwVar);
                        if (i3 != wwVar.a) {
                            return i;
                        }
                        i = wv.b(bArr, i8, wwVar);
                        ywVar.a(wwVar.b);
                    }
                    return i;
                }
            case 22:
            case 29:
            case 39:
            case 43:
                return i5 == 2 ? wv.a(bArr, i, zzbbt, wwVar) : i5 == 0 ? wv.a(i3, bArr, i, i2, zzbbt, wwVar) : i;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    ywVar = (yw) zzbbt;
                    i = wv.a(bArr, i, wwVar);
                    i8 = wwVar.a + i;
                    while (i < i8) {
                        ywVar.a(wv.b(bArr, i));
                        i += 8;
                    }
                    if (i == i8) {
                        return i;
                    }
                    throw zzbbu.a();
                } else if (i5 != 1) {
                    return i;
                } else {
                    ywVar = (yw) zzbbt;
                    ywVar.a(wv.b(bArr, i));
                    i += 8;
                    while (i < i2) {
                        i8 = wv.a(bArr, i, wwVar);
                        if (i3 != wwVar.a) {
                            return i;
                        }
                        ywVar.a(wv.b(bArr, i8));
                        i = i8 + 8;
                    }
                    return i;
                }
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    yjVar = (yj) zzbbt;
                    i = wv.a(bArr, i, wwVar);
                    i8 = wwVar.a + i;
                    while (i < i8) {
                        yjVar.b(wv.a(bArr, i));
                        i += 4;
                    }
                    if (i == i8) {
                        return i;
                    }
                    throw zzbbu.a();
                } else if (i5 != 5) {
                    return i;
                } else {
                    yjVar = (yj) zzbbt;
                    yjVar.b(wv.a(bArr, i));
                    i += 4;
                    while (i < i2) {
                        i8 = wv.a(bArr, i, wwVar);
                        if (i3 != wwVar.a) {
                            return i;
                        }
                        yjVar.b(wv.a(bArr, i8));
                        i = i8 + 4;
                    }
                    return i;
                }
            case 25:
            case 42:
                wx wxVar;
                if (i5 == 2) {
                    wxVar = (wx) zzbbt;
                    i = wv.a(bArr, i, wwVar);
                    size = i + wwVar.a;
                    while (i < size) {
                        i = wv.b(bArr, i, wwVar);
                        wxVar.a(wwVar.b != 0);
                    }
                    if (i == size) {
                        return i;
                    }
                    throw zzbbu.a();
                } else if (i5 != 0) {
                    return i;
                } else {
                    wxVar = (wx) zzbbt;
                    i = wv.b(bArr, i, wwVar);
                    wxVar.a(wwVar.b != 0);
                    while (i < i2) {
                        i8 = wv.a(bArr, i, wwVar);
                        if (i3 != wwVar.a) {
                            return i;
                        }
                        i = wv.b(bArr, i8, wwVar);
                        wxVar.a(wwVar.b != 0);
                    }
                    return i;
                }
            case 26:
                if (i5 != 2) {
                    return i;
                }
                if ((536870912 & j) == 0) {
                    i = wv.a(bArr, i, wwVar);
                    i8 = wwVar.a;
                    if (i8 == 0) {
                        zzbbt.add("");
                    } else {
                        zzbbt.add(new String(bArr, i, i8, yk.a));
                        i += i8;
                    }
                    while (i < i2) {
                        i8 = wv.a(bArr, i, wwVar);
                        if (i3 != wwVar.a) {
                            return i;
                        }
                        i = wv.a(bArr, i8, wwVar);
                        i8 = wwVar.a;
                        if (i8 == 0) {
                            zzbbt.add("");
                        } else {
                            zzbbt.add(new String(bArr, i, i8, yk.a));
                            i += i8;
                        }
                    }
                    return i;
                }
                i = wv.a(bArr, i, wwVar);
                i8 = wwVar.a;
                if (i8 == 0) {
                    zzbbt.add("");
                } else {
                    if (aar.a(bArr, i, i + i8)) {
                        zzbbt.add(new String(bArr, i, i8, yk.a));
                        i += i8;
                    } else {
                        throw zzbbu.h();
                    }
                }
                while (i < i2) {
                    i8 = wv.a(bArr, i, wwVar);
                    if (i3 != wwVar.a) {
                        return i;
                    }
                    i = wv.a(bArr, i8, wwVar);
                    i8 = wwVar.a;
                    if (i8 == 0) {
                        zzbbt.add("");
                    } else {
                        if (aar.a(bArr, i, i + i8)) {
                            zzbbt.add(new String(bArr, i, i8, yk.a));
                            i += i8;
                        } else {
                            throw zzbbu.h();
                        }
                    }
                }
                return i;
            case 27:
                return i5 == 2 ? a(a(i6), i3, bArr, i, i2, zzbbt, wwVar) : i;
            case 28:
                if (i5 != 2) {
                    return i;
                }
                i = wv.a(bArr, i, wwVar);
                i8 = wwVar.a;
                if (i8 == 0) {
                    zzbbt.add(zzbah.a);
                } else {
                    zzbbt.add(zzbah.a(bArr, i, i8));
                    i += i8;
                }
                while (i < i2) {
                    i8 = wv.a(bArr, i, wwVar);
                    if (i3 != wwVar.a) {
                        return i;
                    }
                    i = wv.a(bArr, i8, wwVar);
                    i8 = wwVar.a;
                    if (i8 == 0) {
                        zzbbt.add(zzbah.a);
                    } else {
                        zzbbt.add(zzbah.a(bArr, i, i8));
                        i += i8;
                    }
                }
                return i;
            case 30:
            case 44:
                if (i5 == 2) {
                    size = wv.a(bArr, i, zzbbt, wwVar);
                } else if (i5 != 0) {
                    return i;
                } else {
                    size = wv.a(i3, bArr, i, i2, zzbbt, wwVar);
                }
                Object obj = ((yd) t).zzdtt;
                if (obj == aag.a()) {
                    obj = null;
                }
                aag aag = (aag) zq.a(i4, zzbbt, c(i6), obj, this.q);
                if (aag == null) {
                    return size;
                }
                ((yd) t).zzdtt = aag;
                return size;
            case 33:
            case 47:
                if (i5 == 2) {
                    yjVar = (yj) zzbbt;
                    i = wv.a(bArr, i, wwVar);
                    i8 = wwVar.a + i;
                    while (i < i8) {
                        i = wv.a(bArr, i, wwVar);
                        yjVar.b(xg.f(wwVar.a));
                    }
                    if (i == i8) {
                        return i;
                    }
                    throw zzbbu.a();
                } else if (i5 != 0) {
                    return i;
                } else {
                    yjVar = (yj) zzbbt;
                    i = wv.a(bArr, i, wwVar);
                    yjVar.b(xg.f(wwVar.a));
                    while (i < i2) {
                        i8 = wv.a(bArr, i, wwVar);
                        if (i3 != wwVar.a) {
                            return i;
                        }
                        i = wv.a(bArr, i8, wwVar);
                        yjVar.b(xg.f(wwVar.a));
                    }
                    return i;
                }
            case 34:
            case 48:
                if (i5 == 2) {
                    ywVar = (yw) zzbbt;
                    i = wv.a(bArr, i, wwVar);
                    i8 = wwVar.a + i;
                    while (i < i8) {
                        i = wv.b(bArr, i, wwVar);
                        ywVar.a(xg.a(wwVar.b));
                    }
                    if (i == i8) {
                        return i;
                    }
                    throw zzbbu.a();
                } else if (i5 != 0) {
                    return i;
                } else {
                    ywVar = (yw) zzbbt;
                    i = wv.b(bArr, i, wwVar);
                    ywVar.a(xg.a(wwVar.b));
                    while (i < i2) {
                        i8 = wv.a(bArr, i, wwVar);
                        if (i3 != wwVar.a) {
                            return i;
                        }
                        i = wv.b(bArr, i8, wwVar);
                        ywVar.a(xg.a(wwVar.b));
                    }
                    return i;
                }
            case 49:
                if (i5 != 3) {
                    return i;
                }
                zzbdm a = a(i6);
                int i9 = (i3 & -8) | 4;
                i = a(a, bArr, i, i2, i9, wwVar);
                zzbbt.add(wwVar.c);
                while (i < i2) {
                    int a2 = wv.a(bArr, i, wwVar);
                    if (i3 != wwVar.a) {
                        return i;
                    }
                    i = a(a, bArr, a2, i2, i9, wwVar);
                    zzbbt.add(wwVar.c);
                }
                return i;
            default:
                return i;
        }
    }

    private final <K, V> int a(T r14, byte[] r15, int r16, int r17, int r18, int r19, long r20, com.google.android.gms.internal.ads.ww r22) {
        /*
        r13 = this;
        r4 = a;
        r0 = r18;
        r5 = r13.b(r0);
        r0 = r20;
        r3 = r4.getObject(r14, r0);
        r2 = r13.s;
        r2 = r2.zzu(r3);
        if (r2 == 0) goto L_0x00ba;
    L_0x0016:
        r2 = r13.s;
        r2 = r2.zzw(r5);
        r6 = r13.s;
        r6.zzb(r2, r3);
        r0 = r20;
        r4.putObject(r14, r0, r2);
    L_0x0026:
        r3 = r13.s;
        r10 = r3.zzx(r5);
        r3 = r13.s;
        r11 = r3.zzs(r2);
        r0 = r16;
        r1 = r22;
        r4 = com.google.android.gms.internal.ads.wv.a(r15, r0, r1);
        r0 = r22;
        r2 = r0.a;
        if (r2 < 0) goto L_0x0044;
    L_0x0040:
        r3 = r17 - r4;
        if (r2 <= r3) goto L_0x0049;
    L_0x0044:
        r2 = com.google.android.gms.internal.ads.zzbbu.a();
        throw r2;
    L_0x0049:
        r12 = r4 + r2;
        r3 = r10.b;
        r2 = r10.d;
        r8 = r2;
        r9 = r3;
        r2 = r4;
    L_0x0052:
        if (r2 >= r12) goto L_0x00af;
    L_0x0054:
        r3 = r2 + 1;
        r2 = r15[r2];
        if (r2 >= 0) goto L_0x0064;
    L_0x005a:
        r0 = r22;
        r3 = com.google.android.gms.internal.ads.wv.a(r2, r15, r3, r0);
        r0 = r22;
        r2 = r0.a;
    L_0x0064:
        r4 = r2 >>> 3;
        r5 = r2 & 7;
        switch(r4) {
            case 1: goto L_0x0074;
            case 2: goto L_0x008f;
            default: goto L_0x006b;
        };
    L_0x006b:
        r0 = r17;
        r1 = r22;
        r2 = com.google.android.gms.internal.ads.wv.a(r2, r15, r3, r0, r1);
        goto L_0x0052;
    L_0x0074:
        r4 = r10.a;
        r4 = r4.b();
        if (r5 != r4) goto L_0x006b;
    L_0x007c:
        r5 = r10.a;
        r6 = 0;
        r2 = r15;
        r4 = r17;
        r7 = r22;
        r3 = a(r2, r3, r4, r5, r6, r7);
        r0 = r22;
        r2 = r0.c;
        r9 = r2;
        r2 = r3;
        goto L_0x0052;
    L_0x008f:
        r4 = r10.c;
        r4 = r4.b();
        if (r5 != r4) goto L_0x006b;
    L_0x0097:
        r5 = r10.c;
        r2 = r10.d;
        r6 = r2.getClass();
        r2 = r15;
        r4 = r17;
        r7 = r22;
        r3 = a(r2, r3, r4, r5, r6, r7);
        r0 = r22;
        r2 = r0.c;
        r8 = r2;
        r2 = r3;
        goto L_0x0052;
    L_0x00af:
        if (r2 == r12) goto L_0x00b6;
    L_0x00b1:
        r2 = com.google.android.gms.internal.ads.zzbbu.g();
        throw r2;
    L_0x00b6:
        r11.put(r9, r8);
        return r12;
    L_0x00ba:
        r2 = r3;
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zf.a(java.lang.Object, byte[], int, int, int, int, long, com.google.android.gms.internal.ads.ww):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x008d A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008d A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008d A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0336  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0342  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x037b  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0370  */
    private final int a(T r42, byte[] r43, int r44, int r45, int r46, com.google.android.gms.internal.ads.ww r47) {
        /*
        r41 = this;
        r4 = a;
        r39 = -1;
        r38 = 0;
        r17 = 0;
        r19 = r44;
    L_0x000a:
        r0 = r19;
        r1 = r45;
        if (r0 >= r1) goto L_0x032f;
    L_0x0010:
        r10 = r19 + 1;
        r17 = r43[r19];
        if (r17 >= 0) goto L_0x0026;
    L_0x0016:
        r0 = r17;
        r1 = r43;
        r2 = r47;
        r10 = com.google.android.gms.internal.ads.wv.a(r0, r1, r10, r2);
        r0 = r47;
        r0 = r0.a;
        r17 = r0;
    L_0x0026:
        r18 = r17 >>> 3;
        r19 = r17 & 7;
        r0 = r41;
        r1 = r18;
        r20 = r0.g(r1);
        r5 = -1;
        r0 = r20;
        if (r0 == r5) goto L_0x038d;
    L_0x0037:
        r0 = r41;
        r5 = r0.b;
        r6 = r20 + 1;
        r32 = r5[r6];
        r5 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        r5 = r5 & r32;
        r23 = r5 >>> 20;
        r5 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r5 = r5 & r32;
        r6 = (long) r5;
        r5 = 17;
        r0 = r23;
        if (r0 > r5) goto L_0x0275;
    L_0x0051:
        r0 = r41;
        r5 = r0.b;
        r8 = r20 + 2;
        r5 = r5[r8];
        r8 = 1;
        r9 = r5 >>> 20;
        r14 = r8 << r9;
        r8 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r5 = r5 & r8;
        r0 = r39;
        if (r5 == r0) goto L_0x007e;
    L_0x0066:
        r8 = -1;
        r0 = r39;
        if (r0 == r8) goto L_0x0075;
    L_0x006b:
        r0 = r39;
        r8 = (long) r0;
        r0 = r42;
        r1 = r38;
        r4.putInt(r0, r8, r1);
    L_0x0075:
        r8 = (long) r5;
        r0 = r42;
        r38 = r4.getInt(r0, r8);
        r39 = r5;
    L_0x007e:
        switch(r23) {
            case 0: goto L_0x00a1;
            case 1: goto L_0x00b7;
            case 2: goto L_0x00cd;
            case 3: goto L_0x00cd;
            case 4: goto L_0x00e4;
            case 5: goto L_0x00fb;
            case 6: goto L_0x0111;
            case 7: goto L_0x0127;
            case 8: goto L_0x0147;
            case 9: goto L_0x0172;
            case 10: goto L_0x01ae;
            case 11: goto L_0x00e4;
            case 12: goto L_0x01c8;
            case 13: goto L_0x0111;
            case 14: goto L_0x00fb;
            case 15: goto L_0x01ff;
            case 16: goto L_0x021a;
            case 17: goto L_0x0235;
            default: goto L_0x0081;
        };
    L_0x0081:
        r5 = r38;
        r6 = r39;
        r19 = r10;
    L_0x0087:
        r0 = r17;
        r1 = r46;
        if (r0 != r1) goto L_0x008f;
    L_0x008d:
        if (r46 != 0) goto L_0x0333;
    L_0x008f:
        r18 = r43;
        r20 = r45;
        r21 = r42;
        r22 = r47;
        r19 = a(r17, r18, r19, r20, r21, r22);
        r38 = r5;
        r39 = r6;
        goto L_0x000a;
    L_0x00a1:
        r5 = 1;
        r0 = r19;
        if (r0 != r5) goto L_0x0081;
    L_0x00a6:
        r0 = r43;
        r8 = com.google.android.gms.internal.ads.wv.c(r0, r10);
        r0 = r42;
        com.google.android.gms.internal.ads.aal.a(r0, r6, r8);
        r19 = r10 + 8;
        r38 = r38 | r14;
        goto L_0x000a;
    L_0x00b7:
        r5 = 5;
        r0 = r19;
        if (r0 != r5) goto L_0x0081;
    L_0x00bc:
        r0 = r43;
        r5 = com.google.android.gms.internal.ads.wv.d(r0, r10);
        r0 = r42;
        com.google.android.gms.internal.ads.aal.a(r0, r6, r5);
        r19 = r10 + 4;
        r38 = r38 | r14;
        goto L_0x000a;
    L_0x00cd:
        if (r19 != 0) goto L_0x0081;
    L_0x00cf:
        r0 = r43;
        r1 = r47;
        r19 = com.google.android.gms.internal.ads.wv.b(r0, r10, r1);
        r0 = r47;
        r8 = r0.b;
        r5 = r42;
        r4.putLong(r5, r6, r8);
        r38 = r38 | r14;
        goto L_0x000a;
    L_0x00e4:
        if (r19 != 0) goto L_0x0081;
    L_0x00e6:
        r0 = r43;
        r1 = r47;
        r19 = com.google.android.gms.internal.ads.wv.a(r0, r10, r1);
        r0 = r47;
        r5 = r0.a;
        r0 = r42;
        r4.putInt(r0, r6, r5);
        r38 = r38 | r14;
        goto L_0x000a;
    L_0x00fb:
        r5 = 1;
        r0 = r19;
        if (r0 != r5) goto L_0x0081;
    L_0x0100:
        r0 = r43;
        r8 = com.google.android.gms.internal.ads.wv.b(r0, r10);
        r5 = r42;
        r4.putLong(r5, r6, r8);
        r19 = r10 + 8;
        r38 = r38 | r14;
        goto L_0x000a;
    L_0x0111:
        r5 = 5;
        r0 = r19;
        if (r0 != r5) goto L_0x0081;
    L_0x0116:
        r0 = r43;
        r5 = com.google.android.gms.internal.ads.wv.a(r0, r10);
        r0 = r42;
        r4.putInt(r0, r6, r5);
        r19 = r10 + 4;
        r38 = r38 | r14;
        goto L_0x000a;
    L_0x0127:
        if (r19 != 0) goto L_0x0081;
    L_0x0129:
        r0 = r43;
        r1 = r47;
        r19 = com.google.android.gms.internal.ads.wv.b(r0, r10, r1);
        r0 = r47;
        r8 = r0.b;
        r10 = 0;
        r5 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r5 == 0) goto L_0x0145;
    L_0x013b:
        r5 = 1;
    L_0x013c:
        r0 = r42;
        com.google.android.gms.internal.ads.aal.a(r0, r6, r5);
        r38 = r38 | r14;
        goto L_0x000a;
    L_0x0145:
        r5 = 0;
        goto L_0x013c;
    L_0x0147:
        r5 = 2;
        r0 = r19;
        if (r0 != r5) goto L_0x0081;
    L_0x014c:
        r5 = 536870912; // 0x20000000 float:1.0842022E-19 double:2.652494739E-315;
        r5 = r5 & r32;
        if (r5 != 0) goto L_0x0169;
    L_0x0152:
        r0 = r43;
        r1 = r47;
        r5 = com.google.android.gms.internal.ads.wv.c(r0, r10, r1);
    L_0x015a:
        r0 = r47;
        r8 = r0.c;
        r0 = r42;
        r4.putObject(r0, r6, r8);
        r38 = r38 | r14;
        r19 = r5;
        goto L_0x000a;
    L_0x0169:
        r0 = r43;
        r1 = r47;
        r5 = com.google.android.gms.internal.ads.wv.d(r0, r10, r1);
        goto L_0x015a;
    L_0x0172:
        r5 = 2;
        r0 = r19;
        if (r0 != r5) goto L_0x0081;
    L_0x0177:
        r0 = r41;
        r1 = r20;
        r5 = r0.a(r1);
        r0 = r43;
        r1 = r45;
        r2 = r47;
        r19 = a(r5, r0, r10, r1, r2);
        r5 = r38 & r14;
        if (r5 != 0) goto L_0x019a;
    L_0x018d:
        r0 = r47;
        r5 = r0.c;
        r0 = r42;
        r4.putObject(r0, r6, r5);
    L_0x0196:
        r38 = r38 | r14;
        goto L_0x000a;
    L_0x019a:
        r0 = r42;
        r5 = r4.getObject(r0, r6);
        r0 = r47;
        r8 = r0.c;
        r5 = com.google.android.gms.internal.ads.yk.a(r5, r8);
        r0 = r42;
        r4.putObject(r0, r6, r5);
        goto L_0x0196;
    L_0x01ae:
        r5 = 2;
        r0 = r19;
        if (r0 != r5) goto L_0x0081;
    L_0x01b3:
        r0 = r43;
        r1 = r47;
        r19 = com.google.android.gms.internal.ads.wv.e(r0, r10, r1);
        r0 = r47;
        r5 = r0.c;
        r0 = r42;
        r4.putObject(r0, r6, r5);
        r38 = r38 | r14;
        goto L_0x000a;
    L_0x01c8:
        if (r19 != 0) goto L_0x0081;
    L_0x01ca:
        r0 = r43;
        r1 = r47;
        r19 = com.google.android.gms.internal.ads.wv.a(r0, r10, r1);
        r0 = r47;
        r5 = r0.a;
        r0 = r41;
        r1 = r20;
        r8 = r0.c(r1);
        if (r8 == 0) goto L_0x01e6;
    L_0x01e0:
        r8 = r8.zzq(r5);
        if (r8 == 0) goto L_0x01ef;
    L_0x01e6:
        r0 = r42;
        r4.putInt(r0, r6, r5);
        r38 = r38 | r14;
        goto L_0x000a;
    L_0x01ef:
        r6 = a(r42);
        r8 = (long) r5;
        r5 = java.lang.Long.valueOf(r8);
        r0 = r17;
        r6.a(r0, r5);
        goto L_0x000a;
    L_0x01ff:
        if (r19 != 0) goto L_0x0081;
    L_0x0201:
        r0 = r43;
        r1 = r47;
        r19 = com.google.android.gms.internal.ads.wv.a(r0, r10, r1);
        r0 = r47;
        r5 = r0.a;
        r5 = com.google.android.gms.internal.ads.xg.f(r5);
        r0 = r42;
        r4.putInt(r0, r6, r5);
        r38 = r38 | r14;
        goto L_0x000a;
    L_0x021a:
        if (r19 != 0) goto L_0x0081;
    L_0x021c:
        r0 = r43;
        r1 = r47;
        r19 = com.google.android.gms.internal.ads.wv.b(r0, r10, r1);
        r0 = r47;
        r8 = r0.b;
        r8 = com.google.android.gms.internal.ads.xg.a(r8);
        r5 = r42;
        r4.putLong(r5, r6, r8);
        r38 = r38 | r14;
        goto L_0x000a;
    L_0x0235:
        r5 = 3;
        r0 = r19;
        if (r0 != r5) goto L_0x0081;
    L_0x023a:
        r5 = r18 << 3;
        r12 = r5 | 4;
        r0 = r41;
        r1 = r20;
        r8 = r0.a(r1);
        r9 = r43;
        r11 = r45;
        r13 = r47;
        r19 = a(r8, r9, r10, r11, r12, r13);
        r5 = r38 & r14;
        if (r5 != 0) goto L_0x0261;
    L_0x0254:
        r0 = r47;
        r5 = r0.c;
        r0 = r42;
        r4.putObject(r0, r6, r5);
    L_0x025d:
        r38 = r38 | r14;
        goto L_0x000a;
    L_0x0261:
        r0 = r42;
        r5 = r4.getObject(r0, r6);
        r0 = r47;
        r8 = r0.c;
        r5 = com.google.android.gms.internal.ads.yk.a(r5, r8);
        r0 = r42;
        r4.putObject(r0, r6, r5);
        goto L_0x025d;
    L_0x0275:
        r5 = 27;
        r0 = r23;
        if (r0 != r5) goto L_0x02b8;
    L_0x027b:
        r5 = 2;
        r0 = r19;
        if (r0 != r5) goto L_0x038d;
    L_0x0280:
        r0 = r42;
        r5 = r4.getObject(r0, r6);
        r5 = (com.google.android.gms.internal.ads.zzbbt) r5;
        r8 = r5.zzaay();
        if (r8 != 0) goto L_0x0395;
    L_0x028e:
        r8 = r5.size();
        if (r8 != 0) goto L_0x02b5;
    L_0x0294:
        r8 = 10;
    L_0x0296:
        r12 = r5.zzbm(r8);
        r0 = r42;
        r4.putObject(r0, r6, r12);
    L_0x029f:
        r0 = r41;
        r1 = r20;
        r7 = r0.a(r1);
        r8 = r17;
        r9 = r43;
        r11 = r45;
        r13 = r47;
        r19 = a(r7, r8, r9, r10, r11, r12, r13);
        goto L_0x000a;
    L_0x02b5:
        r8 = r8 << 1;
        goto L_0x0296;
    L_0x02b8:
        r5 = 49;
        r0 = r23;
        if (r0 > r5) goto L_0x02de;
    L_0x02be:
        r0 = r32;
        r0 = (long) r0;
        r21 = r0;
        r12 = r41;
        r13 = r42;
        r14 = r43;
        r15 = r10;
        r16 = r45;
        r24 = r6;
        r26 = r47;
        r19 = r12.a(r13, r14, r15, r16, r17, r18, r19, r20, r21, r23, r24, r26);
        r0 = r19;
        if (r0 != r10) goto L_0x000a;
    L_0x02d8:
        r5 = r38;
        r6 = r39;
        goto L_0x0087;
    L_0x02de:
        r5 = 50;
        r0 = r23;
        if (r0 != r5) goto L_0x0309;
    L_0x02e4:
        r5 = 2;
        r0 = r19;
        if (r0 != r5) goto L_0x038d;
    L_0x02e9:
        r21 = r41;
        r22 = r42;
        r23 = r43;
        r24 = r10;
        r25 = r45;
        r26 = r20;
        r27 = r18;
        r28 = r6;
        r30 = r47;
        r19 = r21.a(r22, r23, r24, r25, r26, r27, r28, r30);
        r0 = r19;
        if (r0 != r10) goto L_0x000a;
    L_0x0303:
        r5 = r38;
        r6 = r39;
        goto L_0x0087;
    L_0x0309:
        r24 = r41;
        r25 = r42;
        r26 = r43;
        r27 = r10;
        r28 = r45;
        r29 = r17;
        r30 = r18;
        r31 = r19;
        r33 = r23;
        r34 = r6;
        r36 = r20;
        r37 = r47;
        r19 = r24.a(r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r36, r37);
        r0 = r19;
        if (r0 != r10) goto L_0x000a;
    L_0x0329:
        r5 = r38;
        r6 = r39;
        goto L_0x0087;
    L_0x032f:
        r5 = r38;
        r6 = r39;
    L_0x0333:
        r7 = -1;
        if (r6 == r7) goto L_0x033c;
    L_0x0336:
        r6 = (long) r6;
        r0 = r42;
        r4.putInt(r0, r6, r5);
    L_0x033c:
        r0 = r41;
        r4 = r0.m;
        if (r4 == 0) goto L_0x036e;
    L_0x0342:
        r5 = 0;
        r0 = r41;
        r6 = r0.m;
        r7 = r6.length;
        r4 = 0;
        r40 = r4;
        r4 = r5;
        r5 = r40;
    L_0x034e:
        if (r5 >= r7) goto L_0x0363;
    L_0x0350:
        r8 = r6[r5];
        r0 = r41;
        r9 = r0.q;
        r0 = r41;
        r1 = r42;
        r4 = r0.a(r1, r8, r4, r9);
        r4 = (com.google.android.gms.internal.ads.aag) r4;
        r5 = r5 + 1;
        goto L_0x034e;
    L_0x0363:
        if (r4 == 0) goto L_0x036e;
    L_0x0365:
        r0 = r41;
        r5 = r0.q;
        r0 = r42;
        r5.b(r0, r4);
    L_0x036e:
        if (r46 != 0) goto L_0x037b;
    L_0x0370:
        r0 = r19;
        r1 = r45;
        if (r0 == r1) goto L_0x038c;
    L_0x0376:
        r4 = com.google.android.gms.internal.ads.zzbbu.g();
        throw r4;
    L_0x037b:
        r0 = r19;
        r1 = r45;
        if (r0 > r1) goto L_0x0387;
    L_0x0381:
        r0 = r17;
        r1 = r46;
        if (r0 == r1) goto L_0x038c;
    L_0x0387:
        r4 = com.google.android.gms.internal.ads.zzbbu.g();
        throw r4;
    L_0x038c:
        return r19;
    L_0x038d:
        r5 = r38;
        r6 = r39;
        r19 = r10;
        goto L_0x0087;
    L_0x0395:
        r12 = r5;
        goto L_0x029f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zf.a(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.ads.ww):int");
    }

    private static int a(byte[] bArr, int i, int i2, zzbes zzbes, Class<?> cls, ww wwVar) {
        int a;
        switch (zg.a[zzbes.ordinal()]) {
            case 1:
                int b = wv.b(bArr, i, wwVar);
                wwVar.c = Boolean.valueOf(wwVar.b != 0);
                return b;
            case 2:
                return wv.e(bArr, i, wwVar);
            case 3:
                wwVar.c = Double.valueOf(wv.c(bArr, i));
                return i + 8;
            case 4:
            case 5:
                wwVar.c = Integer.valueOf(wv.a(bArr, i));
                return i + 4;
            case 6:
            case 7:
                wwVar.c = Long.valueOf(wv.b(bArr, i));
                return i + 8;
            case 8:
                wwVar.c = Float.valueOf(wv.d(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                a = wv.a(bArr, i, wwVar);
                wwVar.c = Integer.valueOf(wwVar.a);
                return a;
            case 12:
            case 13:
                a = wv.b(bArr, i, wwVar);
                wwVar.c = Long.valueOf(wwVar.b);
                return a;
            case 14:
                return a(zl.a().a((Class) cls), bArr, i, i2, wwVar);
            case 15:
                a = wv.a(bArr, i, wwVar);
                wwVar.c = Integer.valueOf(xg.f(wwVar.a));
                return a;
            case 16:
                a = wv.b(bArr, i, wwVar);
                wwVar.c = Long.valueOf(xg.a(wwVar.b));
                return a;
            case 17:
                return wv.d(bArr, i, wwVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static aag a(Object obj) {
        aag aag = ((yd) obj).zzdtt;
        if (aag != aag.a()) {
            return aag;
        }
        aag = aag.b();
        ((yd) obj).zzdtt = aag;
        return aag;
    }

    static <T> zf<T> a(Class<T> cls, zzbcs zzbcs, zzbdc zzbdc, ys ysVar, aaf<?, ?> aaf, xu<?> xuVar, zzbcp zzbcp) {
        if (zzbcs instanceof zn) {
            int i;
            int i2;
            int i3;
            zn znVar = (zn) zzbcs;
            boolean z = znVar.zzaeh() == yi.i;
            if (znVar.d() == 0) {
                i = 0;
                i2 = 0;
                i3 = 0;
            } else {
                i = znVar.b();
                i2 = znVar.c();
                i3 = znVar.h();
            }
            int[] iArr = new int[(i3 << 2)];
            Object[] objArr = new Object[(i3 << 1)];
            int[] iArr2 = znVar.e() > 0 ? new int[znVar.e()] : null;
            int[] iArr3 = znVar.f() > 0 ? new int[znVar.f()] : null;
            int i4 = 0;
            int i5 = 0;
            zo a = znVar.a();
            if (a.a()) {
                int b = a.b();
                i3 = 0;
                while (true) {
                    int i6;
                    if (b >= znVar.i() || i3 >= ((b - i) << 2)) {
                        int a2;
                        if (a.d()) {
                            a2 = (int) aal.a(a.e());
                            b = (int) aal.a(a.f());
                            i6 = 0;
                        } else {
                            a2 = (int) aal.a(a.g());
                            if (a.h()) {
                                b = (int) aal.a(a.i());
                                i6 = a.j();
                            } else {
                                b = 0;
                                i6 = 0;
                            }
                        }
                        iArr[i3] = a.b();
                        iArr[i3 + 1] = a2 | (((a.l() ? 536870912 : 0) | (a.k() ? 268435456 : 0)) | (a.c() << 20));
                        iArr[i3 + 2] = b | (i6 << 20);
                        if (a.o() != null) {
                            objArr[(i3 / 4) << 1] = a.o();
                            if (a.m() != null) {
                                objArr[((i3 / 4) << 1) + 1] = a.m();
                            } else if (a.n() != null) {
                                objArr[((i3 / 4) << 1) + 1] = a.n();
                            }
                        } else if (a.m() != null) {
                            objArr[((i3 / 4) << 1) + 1] = a.m();
                        } else if (a.n() != null) {
                            objArr[((i3 / 4) << 1) + 1] = a.n();
                        }
                        b = a.c();
                        if (b == zzbbj.MAP.ordinal()) {
                            b = i4 + 1;
                            iArr2[i4] = i3;
                            i4 = b;
                        } else if (b >= 18 && b <= 49) {
                            b = i5 + 1;
                            iArr3[i5] = iArr[i3 + 1] & 1048575;
                            i5 = b;
                        }
                        if (!a.a()) {
                            break;
                        }
                        b = a.b();
                    } else {
                        for (i6 = 0; i6 < 4; i6++) {
                            iArr[i3 + i6] = -1;
                        }
                    }
                    i3 += 4;
                }
            }
            return new zf(iArr, objArr, i, i2, znVar.i(), znVar.zzaej(), z, false, znVar.g(), iArr2, iArr3, zzbdc, ysVar, aaf, xuVar, zzbcp);
        }
        ((aab) zzbcs).zzaeh();
        throw new NoSuchMethodError();
    }

    private final zzbdm a(int i) {
        int i2 = (i / 4) << 1;
        zzbdm zzbdm = (zzbdm) this.c[i2];
        if (zzbdm != null) {
            return zzbdm;
        }
        zzbdm = zl.a().a((Class) this.c[i2 + 1]);
        this.c[i2] = zzbdm;
        return zzbdm;
    }

    private final <K, V, UT, UB> UB a(int i, int i2, Map<K, V> map, zzbbs<?> zzbbs, UB ub, aaf<UT, UB> aaf) {
        zb zzx = this.s.zzx(b(i));
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (zzbbs.zzq(((Integer) entry.getValue()).intValue()) == null) {
                if (ub == null) {
                    ub = aaf.a();
                }
                xc b = zzbah.b(za.a(zzx, entry.getKey(), entry.getValue()));
                try {
                    za.a(b.b(), zzx, entry.getKey(), entry.getValue());
                    aaf.a((Object) ub, i2, b.a());
                    it.remove();
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private final <UT, UB> UB a(Object obj, int i, UB ub, aaf<UT, UB> aaf) {
        int i2 = this.b[i];
        Object f = aal.f(obj, (long) (d(i) & 1048575));
        if (f == null) {
            return ub;
        }
        zzbbs c = c(i);
        if (c == null) {
            return ub;
        }
        return a(i, i2, this.s.zzs(f), c, (Object) ub, (aaf) aaf);
    }

    private static <E> List<E> a(Object obj, long j) {
        return (List) aal.f(obj, j);
    }

    private static void a(int i, Object obj, zzbey zzbey) {
        if (obj instanceof String) {
            zzbey.zzf(i, (String) obj);
        } else {
            zzbey.zza(i, (zzbah) obj);
        }
    }

    private static <UT, UB> void a(aaf<UT, UB> aaf, T t, zzbey zzbey) {
        aaf.a(aaf.b(t), zzbey);
    }

    private final <K, V> void a(zzbey zzbey, int i, Object obj, int i2) {
        if (obj != null) {
            zzbey.zza(i, this.s.zzx(b(i2)), this.s.zzt(obj));
        }
    }

    private final void a(Object obj, int i, zzbdl zzbdl) {
        if (f(i)) {
            aal.a(obj, (long) (i & 1048575), zzbdl.zzabr());
        } else if (this.i) {
            aal.a(obj, (long) (i & 1048575), zzbdl.readString());
        } else {
            aal.a(obj, (long) (i & 1048575), zzbdl.zzabs());
        }
    }

    private final void a(T t, zzbey zzbey) {
        Iterator it = null;
        Entry entry = null;
        if (this.h) {
            xx a = this.r.a((Object) t);
            if (!a.b()) {
                it = a.e();
                entry = (Entry) it.next();
            }
        }
        int length = this.b.length;
        Unsafe unsafe = a;
        int i = 0;
        int i2 = -1;
        Entry entry2 = entry;
        int i3 = 0;
        while (i < length) {
            Entry entry3;
            int i4;
            int d = d(i);
            int i5 = this.b[i];
            int i6 = (267386880 & d) >>> 20;
            int i7 = 0;
            if (this.j || i6 > 17) {
                entry3 = entry2;
                i4 = i2;
                i2 = i3;
            } else {
                int i8 = this.b[i + 2];
                i7 = 1048575 & i8;
                if (i7 != i2) {
                    i3 = unsafe.getInt(t, (long) i7);
                } else {
                    i7 = i2;
                }
                i2 = 1 << (i8 >>> 20);
                entry3 = entry2;
                i4 = i7;
                i7 = i2;
                i2 = i3;
            }
            while (entry3 != null && this.r.a(entry3) <= i5) {
                this.r.a(zzbey, entry3);
                entry3 = it.hasNext() ? (Entry) it.next() : null;
            }
            long j = (long) (1048575 & d);
            switch (i6) {
                case 0:
                    if ((i2 & i7) == 0) {
                        break;
                    }
                    zzbey.zza(i5, aal.e(t, j));
                    break;
                case 1:
                    if ((i2 & i7) == 0) {
                        break;
                    }
                    zzbey.zza(i5, aal.d(t, j));
                    break;
                case 2:
                    if ((i2 & i7) == 0) {
                        break;
                    }
                    zzbey.zzi(i5, unsafe.getLong(t, j));
                    break;
                case 3:
                    if ((i2 & i7) == 0) {
                        break;
                    }
                    zzbey.zza(i5, unsafe.getLong(t, j));
                    break;
                case 4:
                    if ((i2 & i7) == 0) {
                        break;
                    }
                    zzbey.zzm(i5, unsafe.getInt(t, j));
                    break;
                case 5:
                    if ((i2 & i7) == 0) {
                        break;
                    }
                    zzbey.zzc(i5, unsafe.getLong(t, j));
                    break;
                case 6:
                    if ((i2 & i7) == 0) {
                        break;
                    }
                    zzbey.zzp(i5, unsafe.getInt(t, j));
                    break;
                case 7:
                    if ((i2 & i7) == 0) {
                        break;
                    }
                    zzbey.zzf(i5, aal.c(t, j));
                    break;
                case 8:
                    if ((i2 & i7) == 0) {
                        break;
                    }
                    a(i5, unsafe.getObject(t, j), zzbey);
                    break;
                case 9:
                    if ((i2 & i7) == 0) {
                        break;
                    }
                    zzbey.zza(i5, unsafe.getObject(t, j), a(i));
                    break;
                case 10:
                    if ((i2 & i7) == 0) {
                        break;
                    }
                    zzbey.zza(i5, (zzbah) unsafe.getObject(t, j));
                    break;
                case 11:
                    if ((i2 & i7) == 0) {
                        break;
                    }
                    zzbey.zzn(i5, unsafe.getInt(t, j));
                    break;
                case 12:
                    if ((i2 & i7) == 0) {
                        break;
                    }
                    zzbey.zzx(i5, unsafe.getInt(t, j));
                    break;
                case 13:
                    if ((i2 & i7) == 0) {
                        break;
                    }
                    zzbey.zzw(i5, unsafe.getInt(t, j));
                    break;
                case 14:
                    if ((i2 & i7) == 0) {
                        break;
                    }
                    zzbey.zzj(i5, unsafe.getLong(t, j));
                    break;
                case 15:
                    if ((i2 & i7) == 0) {
                        break;
                    }
                    zzbey.zzo(i5, unsafe.getInt(t, j));
                    break;
                case 16:
                    if ((i2 & i7) == 0) {
                        break;
                    }
                    zzbey.zzb(i5, unsafe.getLong(t, j));
                    break;
                case 17:
                    if ((i2 & i7) == 0) {
                        break;
                    }
                    zzbey.zzb(i5, unsafe.getObject(t, j), a(i));
                    break;
                case 18:
                    zq.a(this.b[i], (List) unsafe.getObject(t, j), zzbey, false);
                    break;
                case 19:
                    zq.b(this.b[i], (List) unsafe.getObject(t, j), zzbey, false);
                    break;
                case 20:
                    zq.c(this.b[i], (List) unsafe.getObject(t, j), zzbey, false);
                    break;
                case 21:
                    zq.d(this.b[i], (List) unsafe.getObject(t, j), zzbey, false);
                    break;
                case 22:
                    zq.h(this.b[i], (List) unsafe.getObject(t, j), zzbey, false);
                    break;
                case 23:
                    zq.f(this.b[i], (List) unsafe.getObject(t, j), zzbey, false);
                    break;
                case 24:
                    zq.k(this.b[i], (List) unsafe.getObject(t, j), zzbey, false);
                    break;
                case 25:
                    zq.n(this.b[i], (List) unsafe.getObject(t, j), zzbey, false);
                    break;
                case 26:
                    zq.a(this.b[i], (List) unsafe.getObject(t, j), zzbey);
                    break;
                case 27:
                    zq.a(this.b[i], (List) unsafe.getObject(t, j), zzbey, a(i));
                    break;
                case 28:
                    zq.b(this.b[i], (List) unsafe.getObject(t, j), zzbey);
                    break;
                case 29:
                    zq.i(this.b[i], (List) unsafe.getObject(t, j), zzbey, false);
                    break;
                case 30:
                    zq.m(this.b[i], (List) unsafe.getObject(t, j), zzbey, false);
                    break;
                case 31:
                    zq.l(this.b[i], (List) unsafe.getObject(t, j), zzbey, false);
                    break;
                case 32:
                    zq.g(this.b[i], (List) unsafe.getObject(t, j), zzbey, false);
                    break;
                case 33:
                    zq.j(this.b[i], (List) unsafe.getObject(t, j), zzbey, false);
                    break;
                case 34:
                    zq.e(this.b[i], (List) unsafe.getObject(t, j), zzbey, false);
                    break;
                case 35:
                    zq.a(this.b[i], (List) unsafe.getObject(t, j), zzbey, true);
                    break;
                case 36:
                    zq.b(this.b[i], (List) unsafe.getObject(t, j), zzbey, true);
                    break;
                case 37:
                    zq.c(this.b[i], (List) unsafe.getObject(t, j), zzbey, true);
                    break;
                case 38:
                    zq.d(this.b[i], (List) unsafe.getObject(t, j), zzbey, true);
                    break;
                case 39:
                    zq.h(this.b[i], (List) unsafe.getObject(t, j), zzbey, true);
                    break;
                case 40:
                    zq.f(this.b[i], (List) unsafe.getObject(t, j), zzbey, true);
                    break;
                case 41:
                    zq.k(this.b[i], (List) unsafe.getObject(t, j), zzbey, true);
                    break;
                case 42:
                    zq.n(this.b[i], (List) unsafe.getObject(t, j), zzbey, true);
                    break;
                case 43:
                    zq.i(this.b[i], (List) unsafe.getObject(t, j), zzbey, true);
                    break;
                case 44:
                    zq.m(this.b[i], (List) unsafe.getObject(t, j), zzbey, true);
                    break;
                case 45:
                    zq.l(this.b[i], (List) unsafe.getObject(t, j), zzbey, true);
                    break;
                case 46:
                    zq.g(this.b[i], (List) unsafe.getObject(t, j), zzbey, true);
                    break;
                case 47:
                    zq.j(this.b[i], (List) unsafe.getObject(t, j), zzbey, true);
                    break;
                case 48:
                    zq.e(this.b[i], (List) unsafe.getObject(t, j), zzbey, true);
                    break;
                case 49:
                    zq.b(this.b[i], (List) unsafe.getObject(t, j), zzbey, a(i));
                    break;
                case 50:
                    a(zzbey, i5, unsafe.getObject(t, j), i);
                    break;
                case 51:
                    if (!a((Object) t, i5, i)) {
                        break;
                    }
                    zzbey.zza(i5, b((Object) t, j));
                    break;
                case 52:
                    if (!a((Object) t, i5, i)) {
                        break;
                    }
                    zzbey.zza(i5, c(t, j));
                    break;
                case 53:
                    if (!a((Object) t, i5, i)) {
                        break;
                    }
                    zzbey.zzi(i5, e(t, j));
                    break;
                case 54:
                    if (!a((Object) t, i5, i)) {
                        break;
                    }
                    zzbey.zza(i5, e(t, j));
                    break;
                case 55:
                    if (!a((Object) t, i5, i)) {
                        break;
                    }
                    zzbey.zzm(i5, d(t, j));
                    break;
                case 56:
                    if (!a((Object) t, i5, i)) {
                        break;
                    }
                    zzbey.zzc(i5, e(t, j));
                    break;
                case 57:
                    if (!a((Object) t, i5, i)) {
                        break;
                    }
                    zzbey.zzp(i5, d(t, j));
                    break;
                case 58:
                    if (!a((Object) t, i5, i)) {
                        break;
                    }
                    zzbey.zzf(i5, f(t, j));
                    break;
                case 59:
                    if (!a((Object) t, i5, i)) {
                        break;
                    }
                    a(i5, unsafe.getObject(t, j), zzbey);
                    break;
                case 60:
                    if (!a((Object) t, i5, i)) {
                        break;
                    }
                    zzbey.zza(i5, unsafe.getObject(t, j), a(i));
                    break;
                case 61:
                    if (!a((Object) t, i5, i)) {
                        break;
                    }
                    zzbey.zza(i5, (zzbah) unsafe.getObject(t, j));
                    break;
                case 62:
                    if (!a((Object) t, i5, i)) {
                        break;
                    }
                    zzbey.zzn(i5, d(t, j));
                    break;
                case 63:
                    if (!a((Object) t, i5, i)) {
                        break;
                    }
                    zzbey.zzx(i5, d(t, j));
                    break;
                case 64:
                    if (!a((Object) t, i5, i)) {
                        break;
                    }
                    zzbey.zzw(i5, d(t, j));
                    break;
                case 65:
                    if (!a((Object) t, i5, i)) {
                        break;
                    }
                    zzbey.zzj(i5, e(t, j));
                    break;
                case 66:
                    if (!a((Object) t, i5, i)) {
                        break;
                    }
                    zzbey.zzo(i5, d(t, j));
                    break;
                case 67:
                    if (!a((Object) t, i5, i)) {
                        break;
                    }
                    zzbey.zzb(i5, e(t, j));
                    break;
                case 68:
                    if (!a((Object) t, i5, i)) {
                        break;
                    }
                    zzbey.zzb(i5, unsafe.getObject(t, j), a(i));
                    break;
                default:
                    break;
            }
            i += 4;
            i3 = i2;
            i2 = i4;
            entry2 = entry3;
        }
        for (entry = entry2; entry != null; entry = it.hasNext() ? (Entry) it.next() : null) {
            this.r.a(zzbey, entry);
        }
        a(this.q, (Object) t, zzbey);
    }

    private final void a(T t, T t2, int i) {
        long d = (long) (d(i) & 1048575);
        if (a((Object) t2, i)) {
            Object f = aal.f(t, d);
            Object f2 = aal.f(t2, d);
            if (f != null && f2 != null) {
                aal.a((Object) t, d, yk.a(f, f2));
                b((Object) t, i);
            } else if (f2 != null) {
                aal.a((Object) t, d, f2);
                b((Object) t, i);
            }
        }
    }

    private final boolean a(T t, int i) {
        int d;
        if (this.j) {
            d = d(i);
            long j = (long) (d & 1048575);
            switch ((d & 267386880) >>> 20) {
                case 0:
                    return aal.e(t, j) != 0.0d;
                case 1:
                    return aal.d(t, j) != 0.0f;
                case 2:
                    return aal.b(t, j) != 0;
                case 3:
                    return aal.b(t, j) != 0;
                case 4:
                    return aal.a((Object) t, j) != 0;
                case 5:
                    return aal.b(t, j) != 0;
                case 6:
                    return aal.a((Object) t, j) != 0;
                case 7:
                    return aal.c(t, j);
                case 8:
                    Object f = aal.f(t, j);
                    if (f instanceof String) {
                        return !((String) f).isEmpty();
                    } else {
                        if (f instanceof zzbah) {
                            return !zzbah.a.equals(f);
                        } else {
                            throw new IllegalArgumentException();
                        }
                    }
                case 9:
                    return aal.f(t, j) != null;
                case 10:
                    return !zzbah.a.equals(aal.f(t, j));
                case 11:
                    return aal.a((Object) t, j) != 0;
                case 12:
                    return aal.a((Object) t, j) != 0;
                case 13:
                    return aal.a((Object) t, j) != 0;
                case 14:
                    return aal.b(t, j) != 0;
                case 15:
                    return aal.a((Object) t, j) != 0;
                case 16:
                    return aal.b(t, j) != 0;
                case 17:
                    return aal.f(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        }
        d = e(i);
        return (aal.a((Object) t, (long) (d & 1048575)) & (1 << (d >>> 20))) != 0;
    }

    private final boolean a(T t, int i, int i2) {
        return aal.a((Object) t, (long) (e(i2) & 1048575)) == i;
    }

    private final boolean a(T t, int i, int i2, int i3) {
        return this.j ? a((Object) t, i) : (i2 & i3) != 0;
    }

    private static boolean a(Object obj, int i, zzbdm zzbdm) {
        return zzbdm.zzaa(aal.f(obj, (long) (1048575 & i)));
    }

    private static <T> double b(T t, long j) {
        return ((Double) aal.f(t, j)).doubleValue();
    }

    private final Object b(int i) {
        return this.c[(i / 4) << 1];
    }

    private final void b(T t, int i) {
        if (!this.j) {
            int e = e(i);
            long j = (long) (e & 1048575);
            aal.a((Object) t, j, aal.a((Object) t, j) | (1 << (e >>> 20)));
        }
    }

    private final void b(T t, int i, int i2) {
        aal.a((Object) t, (long) (e(i2) & 1048575), i);
    }

    private final void b(T t, T t2, int i) {
        int d = d(i);
        int i2 = this.b[i];
        long j = (long) (d & 1048575);
        if (a((Object) t2, i2, i)) {
            Object f = aal.f(t, j);
            Object f2 = aal.f(t2, j);
            if (f != null && f2 != null) {
                aal.a((Object) t, j, yk.a(f, f2));
                b((Object) t, i2, i);
            } else if (f2 != null) {
                aal.a((Object) t, j, f2);
                b((Object) t, i2, i);
            }
        }
    }

    private static <T> float c(T t, long j) {
        return ((Float) aal.f(t, j)).floatValue();
    }

    private final zzbbs<?> c(int i) {
        return (zzbbs) this.c[((i / 4) << 1) + 1];
    }

    private final boolean c(T t, T t2, int i) {
        return a((Object) t, i) == a((Object) t2, i);
    }

    private final int d(int i) {
        return this.b[i + 1];
    }

    private static <T> int d(T t, long j) {
        return ((Integer) aal.f(t, j)).intValue();
    }

    private final int e(int i) {
        return this.b[i + 2];
    }

    private static <T> long e(T t, long j) {
        return ((Long) aal.f(t, j)).longValue();
    }

    private static boolean f(int i) {
        return (536870912 & i) != 0;
    }

    private static <T> boolean f(T t, long j) {
        return ((Boolean) aal.f(t, j)).booleanValue();
    }

    private final int g(int i) {
        if (i >= this.d) {
            int i2;
            if (i < this.f) {
                i2 = (i - this.d) << 2;
                return this.b[i2] == i ? i2 : -1;
            } else if (i <= this.e) {
                int i3 = this.f - this.d;
                int length = (this.b.length / 4) - 1;
                while (i3 <= length) {
                    int i4 = (length + i3) >>> 1;
                    i2 = i4 << 2;
                    int i5 = this.b[i2];
                    if (i == i5) {
                        return i2;
                    }
                    if (i < i5) {
                        length = i4 - 1;
                    } else {
                        i3 = i4 + 1;
                    }
                }
                return -1;
            }
        }
        return -1;
    }

    public final boolean equals(T r12, T r13) {
        /*
        r11 = this;
        r1 = 1;
        r10 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r0 = 0;
        r2 = r11.b;
        r4 = r2.length;
        r3 = r0;
    L_0x0009:
        if (r3 >= r4) goto L_0x01cf;
    L_0x000b:
        r2 = r11.d(r3);
        r5 = r2 & r10;
        r6 = (long) r5;
        r5 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        r2 = r2 & r5;
        r2 = r2 >>> 20;
        switch(r2) {
            case 0: goto L_0x001e;
            case 1: goto L_0x0032;
            case 2: goto L_0x0044;
            case 3: goto L_0x0058;
            case 4: goto L_0x006c;
            case 5: goto L_0x007e;
            case 6: goto L_0x0092;
            case 7: goto L_0x00a5;
            case 8: goto L_0x00b8;
            case 9: goto L_0x00cf;
            case 10: goto L_0x00e6;
            case 11: goto L_0x00fd;
            case 12: goto L_0x0110;
            case 13: goto L_0x0123;
            case 14: goto L_0x0136;
            case 15: goto L_0x014b;
            case 16: goto L_0x015e;
            case 17: goto L_0x0173;
            case 18: goto L_0x018a;
            case 19: goto L_0x018a;
            case 20: goto L_0x018a;
            case 21: goto L_0x018a;
            case 22: goto L_0x018a;
            case 23: goto L_0x018a;
            case 24: goto L_0x018a;
            case 25: goto L_0x018a;
            case 26: goto L_0x018a;
            case 27: goto L_0x018a;
            case 28: goto L_0x018a;
            case 29: goto L_0x018a;
            case 30: goto L_0x018a;
            case 31: goto L_0x018a;
            case 32: goto L_0x018a;
            case 33: goto L_0x018a;
            case 34: goto L_0x018a;
            case 35: goto L_0x018a;
            case 36: goto L_0x018a;
            case 37: goto L_0x018a;
            case 38: goto L_0x018a;
            case 39: goto L_0x018a;
            case 40: goto L_0x018a;
            case 41: goto L_0x018a;
            case 42: goto L_0x018a;
            case 43: goto L_0x018a;
            case 44: goto L_0x018a;
            case 45: goto L_0x018a;
            case 46: goto L_0x018a;
            case 47: goto L_0x018a;
            case 48: goto L_0x018a;
            case 49: goto L_0x018a;
            case 50: goto L_0x0198;
            case 51: goto L_0x01a6;
            case 52: goto L_0x01a6;
            case 53: goto L_0x01a6;
            case 54: goto L_0x01a6;
            case 55: goto L_0x01a6;
            case 56: goto L_0x01a6;
            case 57: goto L_0x01a6;
            case 58: goto L_0x01a6;
            case 59: goto L_0x01a6;
            case 60: goto L_0x01a6;
            case 61: goto L_0x01a6;
            case 62: goto L_0x01a6;
            case 63: goto L_0x01a6;
            case 64: goto L_0x01a6;
            case 65: goto L_0x01a6;
            case 66: goto L_0x01a6;
            case 67: goto L_0x01a6;
            case 68: goto L_0x01a6;
            default: goto L_0x001a;
        };
    L_0x001a:
        r2 = r1;
    L_0x001b:
        if (r2 != 0) goto L_0x01ca;
    L_0x001d:
        return r0;
    L_0x001e:
        r2 = r11.c(r12, r13, r3);
        if (r2 == 0) goto L_0x0030;
    L_0x0024:
        r8 = com.google.android.gms.internal.ads.aal.b(r12, r6);
        r6 = com.google.android.gms.internal.ads.aal.b(r13, r6);
        r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
        if (r2 == 0) goto L_0x001a;
    L_0x0030:
        r2 = r0;
        goto L_0x001b;
    L_0x0032:
        r2 = r11.c(r12, r13, r3);
        if (r2 == 0) goto L_0x0042;
    L_0x0038:
        r2 = com.google.android.gms.internal.ads.aal.a(r12, r6);
        r5 = com.google.android.gms.internal.ads.aal.a(r13, r6);
        if (r2 == r5) goto L_0x001a;
    L_0x0042:
        r2 = r0;
        goto L_0x001b;
    L_0x0044:
        r2 = r11.c(r12, r13, r3);
        if (r2 == 0) goto L_0x0056;
    L_0x004a:
        r8 = com.google.android.gms.internal.ads.aal.b(r12, r6);
        r6 = com.google.android.gms.internal.ads.aal.b(r13, r6);
        r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
        if (r2 == 0) goto L_0x001a;
    L_0x0056:
        r2 = r0;
        goto L_0x001b;
    L_0x0058:
        r2 = r11.c(r12, r13, r3);
        if (r2 == 0) goto L_0x006a;
    L_0x005e:
        r8 = com.google.android.gms.internal.ads.aal.b(r12, r6);
        r6 = com.google.android.gms.internal.ads.aal.b(r13, r6);
        r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
        if (r2 == 0) goto L_0x001a;
    L_0x006a:
        r2 = r0;
        goto L_0x001b;
    L_0x006c:
        r2 = r11.c(r12, r13, r3);
        if (r2 == 0) goto L_0x007c;
    L_0x0072:
        r2 = com.google.android.gms.internal.ads.aal.a(r12, r6);
        r5 = com.google.android.gms.internal.ads.aal.a(r13, r6);
        if (r2 == r5) goto L_0x001a;
    L_0x007c:
        r2 = r0;
        goto L_0x001b;
    L_0x007e:
        r2 = r11.c(r12, r13, r3);
        if (r2 == 0) goto L_0x0090;
    L_0x0084:
        r8 = com.google.android.gms.internal.ads.aal.b(r12, r6);
        r6 = com.google.android.gms.internal.ads.aal.b(r13, r6);
        r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
        if (r2 == 0) goto L_0x001a;
    L_0x0090:
        r2 = r0;
        goto L_0x001b;
    L_0x0092:
        r2 = r11.c(r12, r13, r3);
        if (r2 == 0) goto L_0x00a2;
    L_0x0098:
        r2 = com.google.android.gms.internal.ads.aal.a(r12, r6);
        r5 = com.google.android.gms.internal.ads.aal.a(r13, r6);
        if (r2 == r5) goto L_0x001a;
    L_0x00a2:
        r2 = r0;
        goto L_0x001b;
    L_0x00a5:
        r2 = r11.c(r12, r13, r3);
        if (r2 == 0) goto L_0x00b5;
    L_0x00ab:
        r2 = com.google.android.gms.internal.ads.aal.c(r12, r6);
        r5 = com.google.android.gms.internal.ads.aal.c(r13, r6);
        if (r2 == r5) goto L_0x001a;
    L_0x00b5:
        r2 = r0;
        goto L_0x001b;
    L_0x00b8:
        r2 = r11.c(r12, r13, r3);
        if (r2 == 0) goto L_0x00cc;
    L_0x00be:
        r2 = com.google.android.gms.internal.ads.aal.f(r12, r6);
        r5 = com.google.android.gms.internal.ads.aal.f(r13, r6);
        r2 = com.google.android.gms.internal.ads.zq.a(r2, r5);
        if (r2 != 0) goto L_0x001a;
    L_0x00cc:
        r2 = r0;
        goto L_0x001b;
    L_0x00cf:
        r2 = r11.c(r12, r13, r3);
        if (r2 == 0) goto L_0x00e3;
    L_0x00d5:
        r2 = com.google.android.gms.internal.ads.aal.f(r12, r6);
        r5 = com.google.android.gms.internal.ads.aal.f(r13, r6);
        r2 = com.google.android.gms.internal.ads.zq.a(r2, r5);
        if (r2 != 0) goto L_0x001a;
    L_0x00e3:
        r2 = r0;
        goto L_0x001b;
    L_0x00e6:
        r2 = r11.c(r12, r13, r3);
        if (r2 == 0) goto L_0x00fa;
    L_0x00ec:
        r2 = com.google.android.gms.internal.ads.aal.f(r12, r6);
        r5 = com.google.android.gms.internal.ads.aal.f(r13, r6);
        r2 = com.google.android.gms.internal.ads.zq.a(r2, r5);
        if (r2 != 0) goto L_0x001a;
    L_0x00fa:
        r2 = r0;
        goto L_0x001b;
    L_0x00fd:
        r2 = r11.c(r12, r13, r3);
        if (r2 == 0) goto L_0x010d;
    L_0x0103:
        r2 = com.google.android.gms.internal.ads.aal.a(r12, r6);
        r5 = com.google.android.gms.internal.ads.aal.a(r13, r6);
        if (r2 == r5) goto L_0x001a;
    L_0x010d:
        r2 = r0;
        goto L_0x001b;
    L_0x0110:
        r2 = r11.c(r12, r13, r3);
        if (r2 == 0) goto L_0x0120;
    L_0x0116:
        r2 = com.google.android.gms.internal.ads.aal.a(r12, r6);
        r5 = com.google.android.gms.internal.ads.aal.a(r13, r6);
        if (r2 == r5) goto L_0x001a;
    L_0x0120:
        r2 = r0;
        goto L_0x001b;
    L_0x0123:
        r2 = r11.c(r12, r13, r3);
        if (r2 == 0) goto L_0x0133;
    L_0x0129:
        r2 = com.google.android.gms.internal.ads.aal.a(r12, r6);
        r5 = com.google.android.gms.internal.ads.aal.a(r13, r6);
        if (r2 == r5) goto L_0x001a;
    L_0x0133:
        r2 = r0;
        goto L_0x001b;
    L_0x0136:
        r2 = r11.c(r12, r13, r3);
        if (r2 == 0) goto L_0x0148;
    L_0x013c:
        r8 = com.google.android.gms.internal.ads.aal.b(r12, r6);
        r6 = com.google.android.gms.internal.ads.aal.b(r13, r6);
        r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
        if (r2 == 0) goto L_0x001a;
    L_0x0148:
        r2 = r0;
        goto L_0x001b;
    L_0x014b:
        r2 = r11.c(r12, r13, r3);
        if (r2 == 0) goto L_0x015b;
    L_0x0151:
        r2 = com.google.android.gms.internal.ads.aal.a(r12, r6);
        r5 = com.google.android.gms.internal.ads.aal.a(r13, r6);
        if (r2 == r5) goto L_0x001a;
    L_0x015b:
        r2 = r0;
        goto L_0x001b;
    L_0x015e:
        r2 = r11.c(r12, r13, r3);
        if (r2 == 0) goto L_0x0170;
    L_0x0164:
        r8 = com.google.android.gms.internal.ads.aal.b(r12, r6);
        r6 = com.google.android.gms.internal.ads.aal.b(r13, r6);
        r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
        if (r2 == 0) goto L_0x001a;
    L_0x0170:
        r2 = r0;
        goto L_0x001b;
    L_0x0173:
        r2 = r11.c(r12, r13, r3);
        if (r2 == 0) goto L_0x0187;
    L_0x0179:
        r2 = com.google.android.gms.internal.ads.aal.f(r12, r6);
        r5 = com.google.android.gms.internal.ads.aal.f(r13, r6);
        r2 = com.google.android.gms.internal.ads.zq.a(r2, r5);
        if (r2 != 0) goto L_0x001a;
    L_0x0187:
        r2 = r0;
        goto L_0x001b;
    L_0x018a:
        r2 = com.google.android.gms.internal.ads.aal.f(r12, r6);
        r5 = com.google.android.gms.internal.ads.aal.f(r13, r6);
        r2 = com.google.android.gms.internal.ads.zq.a(r2, r5);
        goto L_0x001b;
    L_0x0198:
        r2 = com.google.android.gms.internal.ads.aal.f(r12, r6);
        r5 = com.google.android.gms.internal.ads.aal.f(r13, r6);
        r2 = com.google.android.gms.internal.ads.zq.a(r2, r5);
        goto L_0x001b;
    L_0x01a6:
        r2 = r11.e(r3);
        r5 = r2 & r10;
        r8 = (long) r5;
        r5 = com.google.android.gms.internal.ads.aal.a(r12, r8);
        r2 = r2 & r10;
        r8 = (long) r2;
        r2 = com.google.android.gms.internal.ads.aal.a(r13, r8);
        if (r5 != r2) goto L_0x01c7;
    L_0x01b9:
        r2 = com.google.android.gms.internal.ads.aal.f(r12, r6);
        r5 = com.google.android.gms.internal.ads.aal.f(r13, r6);
        r2 = com.google.android.gms.internal.ads.zq.a(r2, r5);
        if (r2 != 0) goto L_0x001a;
    L_0x01c7:
        r2 = r0;
        goto L_0x001b;
    L_0x01ca:
        r2 = r3 + 4;
        r3 = r2;
        goto L_0x0009;
    L_0x01cf:
        r2 = r11.q;
        r2 = r2.b(r12);
        r3 = r11.q;
        r3 = r3.b(r13);
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x001d;
    L_0x01e1:
        r0 = r11.h;
        if (r0 == 0) goto L_0x01f7;
    L_0x01e5:
        r0 = r11.r;
        r0 = r0.a(r12);
        r1 = r11.r;
        r1 = r1.a(r13);
        r0 = r0.equals(r1);
        goto L_0x001d;
    L_0x01f7:
        r0 = r1;
        goto L_0x001d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zf.equals(java.lang.Object, java.lang.Object):boolean");
    }

    public final int hashCode(T r10) {
        /*
        r9 = this;
        r1 = 37;
        r0 = 0;
        r2 = r9.b;
        r4 = r2.length;
        r3 = r0;
        r2 = r0;
    L_0x0008:
        if (r3 >= r4) goto L_0x0255;
    L_0x000a:
        r0 = r9.d(r3);
        r5 = r9.b;
        r5 = r5[r3];
        r6 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r6 = r6 & r0;
        r6 = (long) r6;
        r8 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        r0 = r0 & r8;
        r0 = r0 >>> 20;
        switch(r0) {
            case 0: goto L_0x0025;
            case 1: goto L_0x0035;
            case 2: goto L_0x0041;
            case 3: goto L_0x004d;
            case 4: goto L_0x0059;
            case 5: goto L_0x0061;
            case 6: goto L_0x006d;
            case 7: goto L_0x0075;
            case 8: goto L_0x0081;
            case 9: goto L_0x008f;
            case 10: goto L_0x009d;
            case 11: goto L_0x00aa;
            case 12: goto L_0x00b3;
            case 13: goto L_0x00bc;
            case 14: goto L_0x00c5;
            case 15: goto L_0x00d2;
            case 16: goto L_0x00db;
            case 17: goto L_0x00e8;
            case 18: goto L_0x00f7;
            case 19: goto L_0x00f7;
            case 20: goto L_0x00f7;
            case 21: goto L_0x00f7;
            case 22: goto L_0x00f7;
            case 23: goto L_0x00f7;
            case 24: goto L_0x00f7;
            case 25: goto L_0x00f7;
            case 26: goto L_0x00f7;
            case 27: goto L_0x00f7;
            case 28: goto L_0x00f7;
            case 29: goto L_0x00f7;
            case 30: goto L_0x00f7;
            case 31: goto L_0x00f7;
            case 32: goto L_0x00f7;
            case 33: goto L_0x00f7;
            case 34: goto L_0x00f7;
            case 35: goto L_0x00f7;
            case 36: goto L_0x00f7;
            case 37: goto L_0x00f7;
            case 38: goto L_0x00f7;
            case 39: goto L_0x00f7;
            case 40: goto L_0x00f7;
            case 41: goto L_0x00f7;
            case 42: goto L_0x00f7;
            case 43: goto L_0x00f7;
            case 44: goto L_0x00f7;
            case 45: goto L_0x00f7;
            case 46: goto L_0x00f7;
            case 47: goto L_0x00f7;
            case 48: goto L_0x00f7;
            case 49: goto L_0x00f7;
            case 50: goto L_0x0104;
            case 51: goto L_0x0111;
            case 52: goto L_0x0128;
            case 53: goto L_0x013b;
            case 54: goto L_0x014e;
            case 55: goto L_0x0161;
            case 56: goto L_0x0170;
            case 57: goto L_0x0183;
            case 58: goto L_0x0192;
            case 59: goto L_0x01a5;
            case 60: goto L_0x01ba;
            case 61: goto L_0x01cd;
            case 62: goto L_0x01e0;
            case 63: goto L_0x01ef;
            case 64: goto L_0x01fe;
            case 65: goto L_0x020d;
            case 66: goto L_0x0220;
            case 67: goto L_0x022f;
            case 68: goto L_0x0242;
            default: goto L_0x001f;
        };
    L_0x001f:
        r0 = r2;
    L_0x0020:
        r2 = r3 + 4;
        r3 = r2;
        r2 = r0;
        goto L_0x0008;
    L_0x0025:
        r0 = r2 * 53;
        r6 = com.google.android.gms.internal.ads.aal.e(r10, r6);
        r6 = java.lang.Double.doubleToLongBits(r6);
        r2 = com.google.android.gms.internal.ads.yk.a(r6);
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x0035:
        r0 = r2 * 53;
        r2 = com.google.android.gms.internal.ads.aal.d(r10, r6);
        r2 = java.lang.Float.floatToIntBits(r2);
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x0041:
        r0 = r2 * 53;
        r6 = com.google.android.gms.internal.ads.aal.b(r10, r6);
        r2 = com.google.android.gms.internal.ads.yk.a(r6);
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x004d:
        r0 = r2 * 53;
        r6 = com.google.android.gms.internal.ads.aal.b(r10, r6);
        r2 = com.google.android.gms.internal.ads.yk.a(r6);
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x0059:
        r0 = r2 * 53;
        r2 = com.google.android.gms.internal.ads.aal.a(r10, r6);
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x0061:
        r0 = r2 * 53;
        r6 = com.google.android.gms.internal.ads.aal.b(r10, r6);
        r2 = com.google.android.gms.internal.ads.yk.a(r6);
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x006d:
        r0 = r2 * 53;
        r2 = com.google.android.gms.internal.ads.aal.a(r10, r6);
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x0075:
        r0 = r2 * 53;
        r2 = com.google.android.gms.internal.ads.aal.c(r10, r6);
        r2 = com.google.android.gms.internal.ads.yk.a(r2);
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x0081:
        r2 = r2 * 53;
        r0 = com.google.android.gms.internal.ads.aal.f(r10, r6);
        r0 = (java.lang.String) r0;
        r0 = r0.hashCode();
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x008f:
        r0 = com.google.android.gms.internal.ads.aal.f(r10, r6);
        if (r0 == 0) goto L_0x0277;
    L_0x0095:
        r0 = r0.hashCode();
    L_0x0099:
        r2 = r2 * 53;
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x009d:
        r0 = r2 * 53;
        r2 = com.google.android.gms.internal.ads.aal.f(r10, r6);
        r2 = r2.hashCode();
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x00aa:
        r0 = r2 * 53;
        r2 = com.google.android.gms.internal.ads.aal.a(r10, r6);
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x00b3:
        r0 = r2 * 53;
        r2 = com.google.android.gms.internal.ads.aal.a(r10, r6);
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x00bc:
        r0 = r2 * 53;
        r2 = com.google.android.gms.internal.ads.aal.a(r10, r6);
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x00c5:
        r0 = r2 * 53;
        r6 = com.google.android.gms.internal.ads.aal.b(r10, r6);
        r2 = com.google.android.gms.internal.ads.yk.a(r6);
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x00d2:
        r0 = r2 * 53;
        r2 = com.google.android.gms.internal.ads.aal.a(r10, r6);
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x00db:
        r0 = r2 * 53;
        r6 = com.google.android.gms.internal.ads.aal.b(r10, r6);
        r2 = com.google.android.gms.internal.ads.yk.a(r6);
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x00e8:
        r0 = com.google.android.gms.internal.ads.aal.f(r10, r6);
        if (r0 == 0) goto L_0x0274;
    L_0x00ee:
        r0 = r0.hashCode();
    L_0x00f2:
        r2 = r2 * 53;
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x00f7:
        r0 = r2 * 53;
        r2 = com.google.android.gms.internal.ads.aal.f(r10, r6);
        r2 = r2.hashCode();
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x0104:
        r0 = r2 * 53;
        r2 = com.google.android.gms.internal.ads.aal.f(r10, r6);
        r2 = r2.hashCode();
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x0111:
        r0 = r9.a(r10, r5, r3);
        if (r0 == 0) goto L_0x001f;
    L_0x0117:
        r0 = r2 * 53;
        r6 = b(r10, r6);
        r6 = java.lang.Double.doubleToLongBits(r6);
        r2 = com.google.android.gms.internal.ads.yk.a(r6);
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x0128:
        r0 = r9.a(r10, r5, r3);
        if (r0 == 0) goto L_0x001f;
    L_0x012e:
        r0 = r2 * 53;
        r2 = c(r10, r6);
        r2 = java.lang.Float.floatToIntBits(r2);
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x013b:
        r0 = r9.a(r10, r5, r3);
        if (r0 == 0) goto L_0x001f;
    L_0x0141:
        r0 = r2 * 53;
        r6 = e(r10, r6);
        r2 = com.google.android.gms.internal.ads.yk.a(r6);
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x014e:
        r0 = r9.a(r10, r5, r3);
        if (r0 == 0) goto L_0x001f;
    L_0x0154:
        r0 = r2 * 53;
        r6 = e(r10, r6);
        r2 = com.google.android.gms.internal.ads.yk.a(r6);
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x0161:
        r0 = r9.a(r10, r5, r3);
        if (r0 == 0) goto L_0x001f;
    L_0x0167:
        r0 = r2 * 53;
        r2 = d(r10, r6);
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x0170:
        r0 = r9.a(r10, r5, r3);
        if (r0 == 0) goto L_0x001f;
    L_0x0176:
        r0 = r2 * 53;
        r6 = e(r10, r6);
        r2 = com.google.android.gms.internal.ads.yk.a(r6);
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x0183:
        r0 = r9.a(r10, r5, r3);
        if (r0 == 0) goto L_0x001f;
    L_0x0189:
        r0 = r2 * 53;
        r2 = d(r10, r6);
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x0192:
        r0 = r9.a(r10, r5, r3);
        if (r0 == 0) goto L_0x001f;
    L_0x0198:
        r0 = r2 * 53;
        r2 = f(r10, r6);
        r2 = com.google.android.gms.internal.ads.yk.a(r2);
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x01a5:
        r0 = r9.a(r10, r5, r3);
        if (r0 == 0) goto L_0x001f;
    L_0x01ab:
        r2 = r2 * 53;
        r0 = com.google.android.gms.internal.ads.aal.f(r10, r6);
        r0 = (java.lang.String) r0;
        r0 = r0.hashCode();
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x01ba:
        r0 = r9.a(r10, r5, r3);
        if (r0 == 0) goto L_0x001f;
    L_0x01c0:
        r0 = com.google.android.gms.internal.ads.aal.f(r10, r6);
        r2 = r2 * 53;
        r0 = r0.hashCode();
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x01cd:
        r0 = r9.a(r10, r5, r3);
        if (r0 == 0) goto L_0x001f;
    L_0x01d3:
        r0 = r2 * 53;
        r2 = com.google.android.gms.internal.ads.aal.f(r10, r6);
        r2 = r2.hashCode();
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x01e0:
        r0 = r9.a(r10, r5, r3);
        if (r0 == 0) goto L_0x001f;
    L_0x01e6:
        r0 = r2 * 53;
        r2 = d(r10, r6);
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x01ef:
        r0 = r9.a(r10, r5, r3);
        if (r0 == 0) goto L_0x001f;
    L_0x01f5:
        r0 = r2 * 53;
        r2 = d(r10, r6);
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x01fe:
        r0 = r9.a(r10, r5, r3);
        if (r0 == 0) goto L_0x001f;
    L_0x0204:
        r0 = r2 * 53;
        r2 = d(r10, r6);
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x020d:
        r0 = r9.a(r10, r5, r3);
        if (r0 == 0) goto L_0x001f;
    L_0x0213:
        r0 = r2 * 53;
        r6 = e(r10, r6);
        r2 = com.google.android.gms.internal.ads.yk.a(r6);
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x0220:
        r0 = r9.a(r10, r5, r3);
        if (r0 == 0) goto L_0x001f;
    L_0x0226:
        r0 = r2 * 53;
        r2 = d(r10, r6);
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x022f:
        r0 = r9.a(r10, r5, r3);
        if (r0 == 0) goto L_0x001f;
    L_0x0235:
        r0 = r2 * 53;
        r6 = e(r10, r6);
        r2 = com.google.android.gms.internal.ads.yk.a(r6);
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x0242:
        r0 = r9.a(r10, r5, r3);
        if (r0 == 0) goto L_0x001f;
    L_0x0248:
        r0 = com.google.android.gms.internal.ads.aal.f(r10, r6);
        r2 = r2 * 53;
        r0 = r0.hashCode();
        r0 = r0 + r2;
        goto L_0x0020;
    L_0x0255:
        r0 = r2 * 53;
        r1 = r9.q;
        r1 = r1.b(r10);
        r1 = r1.hashCode();
        r0 = r0 + r1;
        r1 = r9.h;
        if (r1 == 0) goto L_0x0273;
    L_0x0266:
        r0 = r0 * 53;
        r1 = r9.r;
        r1 = r1.a(r10);
        r1 = r1.hashCode();
        r0 = r0 + r1;
    L_0x0273:
        return r0;
    L_0x0274:
        r0 = r1;
        goto L_0x00f2;
    L_0x0277:
        r0 = r1;
        goto L_0x0099;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zf.hashCode(java.lang.Object):int");
    }

    public final T newInstance() {
        return this.o.newInstance(this.g);
    }

    public final void zza(T r13, com.google.android.gms.internal.ads.zzbdl r14, com.google.android.gms.internal.ads.xs r15) {
        /*
        r12 = this;
        if (r15 != 0) goto L_0x0008;
    L_0x0002:
        r0 = new java.lang.NullPointerException;
        r0.<init>();
        throw r0;
    L_0x0008:
        r6 = r12.q;
        r0 = r12.r;
        r5 = 0;
        r4 = 0;
    L_0x000e:
        r1 = r14.zzaci();	 Catch:{ all -> 0x00e9 }
        r2 = r12.g(r1);	 Catch:{ all -> 0x00e9 }
        if (r2 >= 0) goto L_0x0079;
    L_0x0018:
        r2 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        if (r1 != r2) goto L_0x0036;
    L_0x001d:
        r0 = r12.m;
        if (r0 == 0) goto L_0x0030;
    L_0x0021:
        r1 = r12.m;
        r2 = r1.length;
        r0 = 0;
    L_0x0025:
        if (r0 >= r2) goto L_0x0030;
    L_0x0027:
        r3 = r1[r0];
        r5 = r12.a(r13, r3, r5, r6);
        r0 = r0 + 1;
        goto L_0x0025;
    L_0x0030:
        if (r5 == 0) goto L_0x0035;
    L_0x0032:
        r6.b(r13, r5);
    L_0x0035:
        return;
    L_0x0036:
        r2 = r12.h;	 Catch:{ all -> 0x00e9 }
        if (r2 != 0) goto L_0x004a;
    L_0x003a:
        r2 = 0;
    L_0x003b:
        if (r2 == 0) goto L_0x0051;
    L_0x003d:
        if (r4 != 0) goto L_0x0043;
    L_0x003f:
        r4 = r0.b(r13);	 Catch:{ all -> 0x00e9 }
    L_0x0043:
        r1 = r14;
        r3 = r15;
        r5 = r0.a(r1, r2, r3, r4, r5, r6);	 Catch:{ all -> 0x00e9 }
        goto L_0x000e;
    L_0x004a:
        r2 = r12.g;	 Catch:{ all -> 0x00e9 }
        r2 = r0.a(r15, r2, r1);	 Catch:{ all -> 0x00e9 }
        goto L_0x003b;
    L_0x0051:
        r6.a(r14);	 Catch:{ all -> 0x00e9 }
        if (r5 != 0) goto L_0x005a;
    L_0x0056:
        r5 = r6.c(r13);	 Catch:{ all -> 0x00e9 }
    L_0x005a:
        r1 = r6.a(r5, r14);	 Catch:{ all -> 0x00e9 }
        if (r1 != 0) goto L_0x000e;
    L_0x0060:
        r0 = r12.m;
        if (r0 == 0) goto L_0x0073;
    L_0x0064:
        r1 = r12.m;
        r2 = r1.length;
        r0 = 0;
    L_0x0068:
        if (r0 >= r2) goto L_0x0073;
    L_0x006a:
        r3 = r1[r0];
        r5 = r12.a(r13, r3, r5, r6);
        r0 = r0 + 1;
        goto L_0x0068;
    L_0x0073:
        if (r5 == 0) goto L_0x0035;
    L_0x0075:
        r6.b(r13, r5);
        goto L_0x0035;
    L_0x0079:
        r3 = r12.d(r2);	 Catch:{ all -> 0x00e9 }
        r7 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        r7 = r7 & r3;
        r7 = r7 >>> 20;
        switch(r7) {
            case 0: goto L_0x00a4;
            case 1: goto L_0x00d8;
            case 2: goto L_0x00fd;
            case 3: goto L_0x010e;
            case 4: goto L_0x011f;
            case 5: goto L_0x0130;
            case 6: goto L_0x0141;
            case 7: goto L_0x0152;
            case 8: goto L_0x0163;
            case 9: goto L_0x016b;
            case 10: goto L_0x01a5;
            case 11: goto L_0x01b6;
            case 12: goto L_0x01c7;
            case 13: goto L_0x01ea;
            case 14: goto L_0x01fb;
            case 15: goto L_0x020c;
            case 16: goto L_0x021d;
            case 17: goto L_0x022e;
            case 18: goto L_0x0268;
            case 19: goto L_0x0278;
            case 20: goto L_0x0288;
            case 21: goto L_0x0298;
            case 22: goto L_0x02a8;
            case 23: goto L_0x02b8;
            case 24: goto L_0x02c8;
            case 25: goto L_0x02d8;
            case 26: goto L_0x02e8;
            case 27: goto L_0x030e;
            case 28: goto L_0x0322;
            case 29: goto L_0x0332;
            case 30: goto L_0x0342;
            case 31: goto L_0x035a;
            case 32: goto L_0x036a;
            case 33: goto L_0x037a;
            case 34: goto L_0x038a;
            case 35: goto L_0x039a;
            case 36: goto L_0x03aa;
            case 37: goto L_0x03ba;
            case 38: goto L_0x03ca;
            case 39: goto L_0x03da;
            case 40: goto L_0x03ea;
            case 41: goto L_0x03fa;
            case 42: goto L_0x040a;
            case 43: goto L_0x041a;
            case 44: goto L_0x042a;
            case 45: goto L_0x0442;
            case 46: goto L_0x0452;
            case 47: goto L_0x0462;
            case 48: goto L_0x0472;
            case 49: goto L_0x0482;
            case 50: goto L_0x0496;
            case 51: goto L_0x04da;
            case 52: goto L_0x04ef;
            case 53: goto L_0x0504;
            case 54: goto L_0x0519;
            case 55: goto L_0x052e;
            case 56: goto L_0x0543;
            case 57: goto L_0x0558;
            case 58: goto L_0x056d;
            case 59: goto L_0x0582;
            case 60: goto L_0x058a;
            case 61: goto L_0x05c6;
            case 62: goto L_0x05d7;
            case 63: goto L_0x05ec;
            case 64: goto L_0x0613;
            case 65: goto L_0x0628;
            case 66: goto L_0x063d;
            case 67: goto L_0x0652;
            case 68: goto L_0x0667;
            default: goto L_0x0085;
        };
    L_0x0085:
        if (r5 != 0) goto L_0x008b;
    L_0x0087:
        r5 = r6.a();	 Catch:{ zzbbv -> 0x00b5 }
    L_0x008b:
        r1 = r6.a(r5, r14);	 Catch:{ zzbbv -> 0x00b5 }
        if (r1 != 0) goto L_0x000e;
    L_0x0091:
        r0 = r12.m;
        if (r0 == 0) goto L_0x067c;
    L_0x0095:
        r1 = r12.m;
        r2 = r1.length;
        r0 = 0;
    L_0x0099:
        if (r0 >= r2) goto L_0x067c;
    L_0x009b:
        r3 = r1[r0];
        r5 = r12.a(r13, r3, r5, r6);
        r0 = r0 + 1;
        goto L_0x0099;
    L_0x00a4:
        r1 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r1 = r1 & r3;
        r8 = (long) r1;
        r10 = r14.readDouble();	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r10);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x00b5:
        r1 = move-exception;
        r6.a(r14);	 Catch:{ all -> 0x00e9 }
        if (r5 != 0) goto L_0x00bf;
    L_0x00bb:
        r5 = r6.c(r13);	 Catch:{ all -> 0x00e9 }
    L_0x00bf:
        r1 = r6.a(r5, r14);	 Catch:{ all -> 0x00e9 }
        if (r1 != 0) goto L_0x000e;
    L_0x00c5:
        r0 = r12.m;
        if (r0 == 0) goto L_0x0683;
    L_0x00c9:
        r1 = r12.m;
        r2 = r1.length;
        r0 = 0;
    L_0x00cd:
        if (r0 >= r2) goto L_0x0683;
    L_0x00cf:
        r3 = r1[r0];
        r5 = r12.a(r13, r3, r5, r6);
        r0 = r0 + 1;
        goto L_0x00cd;
    L_0x00d8:
        r1 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r1 = r1 & r3;
        r8 = (long) r1;
        r1 = r14.readFloat();	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r1);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x00e9:
        r0 = move-exception;
        r1 = r12.m;
        if (r1 == 0) goto L_0x068a;
    L_0x00ee:
        r2 = r12.m;
        r3 = r2.length;
        r1 = 0;
    L_0x00f2:
        if (r1 >= r3) goto L_0x068a;
    L_0x00f4:
        r4 = r2[r1];
        r5 = r12.a(r13, r4, r5, r6);
        r1 = r1 + 1;
        goto L_0x00f2;
    L_0x00fd:
        r1 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r1 = r1 & r3;
        r8 = (long) r1;
        r10 = r14.zzabm();	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r10);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x010e:
        r1 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r1 = r1 & r3;
        r8 = (long) r1;	 Catch:{ zzbbv -> 0x00b5 }
        r10 = r14.zzabl();	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r10);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x011f:
        r1 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r1 = r1 & r3;
        r8 = (long) r1;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r14.zzabn();	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r1);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x0130:
        r1 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r1 = r1 & r3;
        r8 = (long) r1;	 Catch:{ zzbbv -> 0x00b5 }
        r10 = r14.zzabo();	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r10);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x0141:
        r1 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r1 = r1 & r3;
        r8 = (long) r1;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r14.zzabp();	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r1);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x0152:
        r1 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r1 = r1 & r3;
        r8 = (long) r1;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r14.zzabq();	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r1);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x0163:
        r12.a(r13, r3, r14);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x016b:
        r1 = r12.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        if (r1 == 0) goto L_0x0190;
    L_0x0171:
        r1 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r1 = r1 & r3;
        r8 = (long) r1;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = com.google.android.gms.internal.ads.aal.f(r13, r8);	 Catch:{ zzbbv -> 0x00b5 }
        r2 = r12.a(r2);	 Catch:{ zzbbv -> 0x00b5 }
        r2 = r14.zza(r2, r15);	 Catch:{ zzbbv -> 0x00b5 }
        r1 = com.google.android.gms.internal.ads.yk.a(r1, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r2, r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x0190:
        r1 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r1 = r1 & r3;
        r8 = (long) r1;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r12.a(r2);	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r14.zza(r1, r15);	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r1);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x01a5:
        r1 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r1 = r1 & r3;
        r8 = (long) r1;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r14.zzabs();	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r1);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x01b6:
        r1 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r1 = r1 & r3;
        r8 = (long) r1;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r14.zzabt();	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r1);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x01c7:
        r7 = r14.zzabu();	 Catch:{ zzbbv -> 0x00b5 }
        r8 = r12.c(r2);	 Catch:{ zzbbv -> 0x00b5 }
        if (r8 == 0) goto L_0x01d7;
    L_0x01d1:
        r8 = r8.zzq(r7);	 Catch:{ zzbbv -> 0x00b5 }
        if (r8 == 0) goto L_0x01e4;
    L_0x01d7:
        r1 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r1 = r1 & r3;
        r8 = (long) r1;	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r7);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x01e4:
        r5 = com.google.android.gms.internal.ads.zq.a(r1, r7, r5, r6);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x01ea:
        r1 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r1 = r1 & r3;
        r8 = (long) r1;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r14.zzabv();	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r1);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x01fb:
        r1 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r1 = r1 & r3;
        r8 = (long) r1;	 Catch:{ zzbbv -> 0x00b5 }
        r10 = r14.zzabw();	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r10);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x020c:
        r1 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r1 = r1 & r3;
        r8 = (long) r1;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r14.zzabx();	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r1);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x021d:
        r1 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r1 = r1 & r3;
        r8 = (long) r1;	 Catch:{ zzbbv -> 0x00b5 }
        r10 = r14.zzaby();	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r10);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x022e:
        r1 = r12.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        if (r1 == 0) goto L_0x0253;
    L_0x0234:
        r1 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r1 = r1 & r3;
        r8 = (long) r1;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = com.google.android.gms.internal.ads.aal.f(r13, r8);	 Catch:{ zzbbv -> 0x00b5 }
        r2 = r12.a(r2);	 Catch:{ zzbbv -> 0x00b5 }
        r2 = r14.zzb(r2, r15);	 Catch:{ zzbbv -> 0x00b5 }
        r1 = com.google.android.gms.internal.ads.yk.a(r1, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r2, r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x0253:
        r1 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r1 = r1 & r3;
        r8 = (long) r1;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r12.a(r2);	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r14.zzb(r1, r15);	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r1);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x0268:
        r1 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzp(r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x0278:
        r1 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzq(r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x0288:
        r1 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzs(r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x0298:
        r1 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzr(r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x02a8:
        r1 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzt(r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x02b8:
        r1 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzu(r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x02c8:
        r1 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzv(r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x02d8:
        r1 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzw(r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x02e8:
        r1 = f(r3);	 Catch:{ zzbbv -> 0x00b5 }
        if (r1 == 0) goto L_0x02fe;
    L_0x02ee:
        r1 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzx(r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x02fe:
        r1 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r14.readStringList(r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x030e:
        r1 = r12.a(r2);	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        r7 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = r7.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zza(r2, r1, r15);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x0322:
        r1 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzy(r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x0332:
        r1 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzz(r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x0342:
        r7 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r8 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r3 = r3 & r8;
        r8 = (long) r3;	 Catch:{ zzbbv -> 0x00b5 }
        r3 = r7.a(r13, r8);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzaa(r3);	 Catch:{ zzbbv -> 0x00b5 }
        r2 = r12.c(r2);	 Catch:{ zzbbv -> 0x00b5 }
        r5 = com.google.android.gms.internal.ads.zq.a(r1, r3, r2, r5, r6);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x035a:
        r1 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzab(r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x036a:
        r1 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzac(r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x037a:
        r1 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzad(r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x038a:
        r1 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzae(r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x039a:
        r1 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzp(r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x03aa:
        r1 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzq(r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x03ba:
        r1 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzs(r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x03ca:
        r1 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzr(r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x03da:
        r1 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzt(r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x03ea:
        r1 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzu(r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x03fa:
        r1 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzv(r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x040a:
        r1 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzw(r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x041a:
        r1 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzz(r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x042a:
        r7 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r8 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r3 = r3 & r8;
        r8 = (long) r3;	 Catch:{ zzbbv -> 0x00b5 }
        r3 = r7.a(r13, r8);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzaa(r3);	 Catch:{ zzbbv -> 0x00b5 }
        r2 = r12.c(r2);	 Catch:{ zzbbv -> 0x00b5 }
        r5 = com.google.android.gms.internal.ads.zq.a(r1, r3, r2, r5, r6);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x0442:
        r1 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzab(r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x0452:
        r1 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzac(r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x0462:
        r1 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzad(r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x0472:
        r1 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r3;
        r2 = (long) r2;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.a(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzae(r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x0482:
        r1 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r1 = r1 & r3;
        r8 = (long) r1;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r12.a(r2);	 Catch:{ zzbbv -> 0x00b5 }
        r2 = r12.p;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = r2.a(r13, r8);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zzb(r2, r1, r15);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x0496:
        r3 = r12.b(r2);	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r12.d(r2);	 Catch:{ zzbbv -> 0x00b5 }
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r1 = r1 & r2;
        r8 = (long) r1;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = com.google.android.gms.internal.ads.aal.f(r13, r8);	 Catch:{ zzbbv -> 0x00b5 }
        if (r2 != 0) goto L_0x04c3;
    L_0x04a9:
        r1 = r12.s;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.zzw(r3);	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r1);	 Catch:{ zzbbv -> 0x00b5 }
    L_0x04b2:
        r2 = r12.s;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r2.zzs(r1);	 Catch:{ zzbbv -> 0x00b5 }
        r2 = r12.s;	 Catch:{ zzbbv -> 0x00b5 }
        r2 = r2.zzx(r3);	 Catch:{ zzbbv -> 0x00b5 }
        r14.zza(r1, r2, r15);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x04c3:
        r1 = r12.s;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.zzu(r2);	 Catch:{ zzbbv -> 0x00b5 }
        if (r1 == 0) goto L_0x0690;
    L_0x04cb:
        r1 = r12.s;	 Catch:{ zzbbv -> 0x00b5 }
        r1 = r1.zzw(r3);	 Catch:{ zzbbv -> 0x00b5 }
        r7 = r12.s;	 Catch:{ zzbbv -> 0x00b5 }
        r7.zzb(r1, r2);	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r1);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x04b2;
    L_0x04da:
        r7 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r3 = r3 & r7;
        r8 = (long) r3;	 Catch:{ zzbbv -> 0x00b5 }
        r10 = r14.readDouble();	 Catch:{ zzbbv -> 0x00b5 }
        r3 = java.lang.Double.valueOf(r10);	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r3);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r1, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x04ef:
        r7 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r3 = r3 & r7;
        r8 = (long) r3;	 Catch:{ zzbbv -> 0x00b5 }
        r3 = r14.readFloat();	 Catch:{ zzbbv -> 0x00b5 }
        r3 = java.lang.Float.valueOf(r3);	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r3);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r1, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x0504:
        r7 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r3 = r3 & r7;
        r8 = (long) r3;	 Catch:{ zzbbv -> 0x00b5 }
        r10 = r14.zzabm();	 Catch:{ zzbbv -> 0x00b5 }
        r3 = java.lang.Long.valueOf(r10);	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r3);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r1, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x0519:
        r7 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r3 = r3 & r7;
        r8 = (long) r3;	 Catch:{ zzbbv -> 0x00b5 }
        r10 = r14.zzabl();	 Catch:{ zzbbv -> 0x00b5 }
        r3 = java.lang.Long.valueOf(r10);	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r3);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r1, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x052e:
        r7 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r3 = r3 & r7;
        r8 = (long) r3;	 Catch:{ zzbbv -> 0x00b5 }
        r3 = r14.zzabn();	 Catch:{ zzbbv -> 0x00b5 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r3);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r1, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x0543:
        r7 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r3 = r3 & r7;
        r8 = (long) r3;	 Catch:{ zzbbv -> 0x00b5 }
        r10 = r14.zzabo();	 Catch:{ zzbbv -> 0x00b5 }
        r3 = java.lang.Long.valueOf(r10);	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r3);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r1, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x0558:
        r7 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r3 = r3 & r7;
        r8 = (long) r3;	 Catch:{ zzbbv -> 0x00b5 }
        r3 = r14.zzabp();	 Catch:{ zzbbv -> 0x00b5 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r3);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r1, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x056d:
        r7 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r3 = r3 & r7;
        r8 = (long) r3;	 Catch:{ zzbbv -> 0x00b5 }
        r3 = r14.zzabq();	 Catch:{ zzbbv -> 0x00b5 }
        r3 = java.lang.Boolean.valueOf(r3);	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r3);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r1, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x0582:
        r12.a(r13, r3, r14);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r1, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x058a:
        r7 = r12.a(r13, r1, r2);	 Catch:{ zzbbv -> 0x00b5 }
        if (r7 == 0) goto L_0x05b2;
    L_0x0590:
        r7 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r7 = r7 & r3;
        r8 = (long) r7;	 Catch:{ zzbbv -> 0x00b5 }
        r7 = com.google.android.gms.internal.ads.aal.f(r13, r8);	 Catch:{ zzbbv -> 0x00b5 }
        r8 = r12.a(r2);	 Catch:{ zzbbv -> 0x00b5 }
        r8 = r14.zza(r8, r15);	 Catch:{ zzbbv -> 0x00b5 }
        r7 = com.google.android.gms.internal.ads.yk.a(r7, r8);	 Catch:{ zzbbv -> 0x00b5 }
        r8 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r3 = r3 & r8;
        r8 = (long) r3;	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r7);	 Catch:{ zzbbv -> 0x00b5 }
    L_0x05ad:
        r12.b(r13, r1, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x05b2:
        r7 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r3 = r3 & r7;
        r8 = (long) r3;	 Catch:{ zzbbv -> 0x00b5 }
        r3 = r12.a(r2);	 Catch:{ zzbbv -> 0x00b5 }
        r3 = r14.zza(r3, r15);	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r3);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x05ad;
    L_0x05c6:
        r7 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r3 = r3 & r7;
        r8 = (long) r3;	 Catch:{ zzbbv -> 0x00b5 }
        r3 = r14.zzabs();	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r3);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r1, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x05d7:
        r7 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r3 = r3 & r7;
        r8 = (long) r3;	 Catch:{ zzbbv -> 0x00b5 }
        r3 = r14.zzabt();	 Catch:{ zzbbv -> 0x00b5 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r3);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r1, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x05ec:
        r7 = r14.zzabu();	 Catch:{ zzbbv -> 0x00b5 }
        r8 = r12.c(r2);	 Catch:{ zzbbv -> 0x00b5 }
        if (r8 == 0) goto L_0x05fc;
    L_0x05f6:
        r8 = r8.zzq(r7);	 Catch:{ zzbbv -> 0x00b5 }
        if (r8 == 0) goto L_0x060d;
    L_0x05fc:
        r8 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r3 = r3 & r8;
        r8 = (long) r3;	 Catch:{ zzbbv -> 0x00b5 }
        r3 = java.lang.Integer.valueOf(r7);	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r3);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r1, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x060d:
        r5 = com.google.android.gms.internal.ads.zq.a(r1, r7, r5, r6);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x0613:
        r7 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r3 = r3 & r7;
        r8 = (long) r3;	 Catch:{ zzbbv -> 0x00b5 }
        r3 = r14.zzabv();	 Catch:{ zzbbv -> 0x00b5 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r3);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r1, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x0628:
        r7 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r3 = r3 & r7;
        r8 = (long) r3;	 Catch:{ zzbbv -> 0x00b5 }
        r10 = r14.zzabw();	 Catch:{ zzbbv -> 0x00b5 }
        r3 = java.lang.Long.valueOf(r10);	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r3);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r1, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x063d:
        r7 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r3 = r3 & r7;
        r8 = (long) r3;	 Catch:{ zzbbv -> 0x00b5 }
        r3 = r14.zzabx();	 Catch:{ zzbbv -> 0x00b5 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r3);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r1, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x0652:
        r7 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r3 = r3 & r7;
        r8 = (long) r3;	 Catch:{ zzbbv -> 0x00b5 }
        r10 = r14.zzaby();	 Catch:{ zzbbv -> 0x00b5 }
        r3 = java.lang.Long.valueOf(r10);	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r3);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r1, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x0667:
        r7 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r3 = r3 & r7;
        r8 = (long) r3;	 Catch:{ zzbbv -> 0x00b5 }
        r3 = r12.a(r2);	 Catch:{ zzbbv -> 0x00b5 }
        r3 = r14.zzb(r3, r15);	 Catch:{ zzbbv -> 0x00b5 }
        com.google.android.gms.internal.ads.aal.a(r13, r8, r3);	 Catch:{ zzbbv -> 0x00b5 }
        r12.b(r13, r1, r2);	 Catch:{ zzbbv -> 0x00b5 }
        goto L_0x000e;
    L_0x067c:
        if (r5 == 0) goto L_0x0035;
    L_0x067e:
        r6.b(r13, r5);
        goto L_0x0035;
    L_0x0683:
        if (r5 == 0) goto L_0x0035;
    L_0x0685:
        r6.b(r13, r5);
        goto L_0x0035;
    L_0x068a:
        if (r5 == 0) goto L_0x068f;
    L_0x068c:
        r6.b(r13, r5);
    L_0x068f:
        throw r0;
    L_0x0690:
        r1 = r2;
        goto L_0x04b2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zf.zza(java.lang.Object, com.google.android.gms.internal.ads.zzbdl, com.google.android.gms.internal.ads.xs):void");
    }

    public final void zza(T t, zzbey zzbey) {
        Iterator it;
        Entry entry;
        xx a;
        int length;
        int d;
        int i;
        Entry entry2;
        if (zzbey.zzacn() == yi.k) {
            a(this.q, (Object) t, zzbey);
            it = null;
            entry = null;
            if (this.h) {
                a = this.r.a((Object) t);
                if (!a.b()) {
                    it = a.f();
                    entry = (Entry) it.next();
                }
            }
            length = this.b.length - 4;
            while (length >= 0) {
                d = d(length);
                i = this.b[length];
                entry2 = entry;
                while (entry2 != null && this.r.a(entry2) > i) {
                    this.r.a(zzbey, entry2);
                    entry2 = it.hasNext() ? (Entry) it.next() : null;
                }
                switch ((267386880 & d) >>> 20) {
                    case 0:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zza(i, aal.e(t, (long) (1048575 & d)));
                        break;
                    case 1:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zza(i, aal.d(t, (long) (1048575 & d)));
                        break;
                    case 2:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zzi(i, aal.b(t, (long) (1048575 & d)));
                        break;
                    case 3:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zza(i, aal.b(t, (long) (1048575 & d)));
                        break;
                    case 4:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zzm(i, aal.a((Object) t, (long) (1048575 & d)));
                        break;
                    case 5:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zzc(i, aal.b(t, (long) (1048575 & d)));
                        break;
                    case 6:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zzp(i, aal.a((Object) t, (long) (1048575 & d)));
                        break;
                    case 7:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zzf(i, aal.c(t, (long) (1048575 & d)));
                        break;
                    case 8:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        a(i, aal.f(t, (long) (1048575 & d)), zzbey);
                        break;
                    case 9:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zza(i, aal.f(t, (long) (1048575 & d)), a(length));
                        break;
                    case 10:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zza(i, (zzbah) aal.f(t, (long) (1048575 & d)));
                        break;
                    case 11:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zzn(i, aal.a((Object) t, (long) (1048575 & d)));
                        break;
                    case 12:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zzx(i, aal.a((Object) t, (long) (1048575 & d)));
                        break;
                    case 13:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zzw(i, aal.a((Object) t, (long) (1048575 & d)));
                        break;
                    case 14:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zzj(i, aal.b(t, (long) (1048575 & d)));
                        break;
                    case 15:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zzo(i, aal.a((Object) t, (long) (1048575 & d)));
                        break;
                    case 16:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zzb(i, aal.b(t, (long) (1048575 & d)));
                        break;
                    case 17:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zzb(i, aal.f(t, (long) (1048575 & d)), a(length));
                        break;
                    case 18:
                        zq.a(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey, false);
                        break;
                    case 19:
                        zq.b(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey, false);
                        break;
                    case 20:
                        zq.c(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey, false);
                        break;
                    case 21:
                        zq.d(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey, false);
                        break;
                    case 22:
                        zq.h(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey, false);
                        break;
                    case 23:
                        zq.f(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey, false);
                        break;
                    case 24:
                        zq.k(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey, false);
                        break;
                    case 25:
                        zq.n(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey, false);
                        break;
                    case 26:
                        zq.a(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey);
                        break;
                    case 27:
                        zq.a(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey, a(length));
                        break;
                    case 28:
                        zq.b(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey);
                        break;
                    case 29:
                        zq.i(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey, false);
                        break;
                    case 30:
                        zq.m(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey, false);
                        break;
                    case 31:
                        zq.l(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey, false);
                        break;
                    case 32:
                        zq.g(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey, false);
                        break;
                    case 33:
                        zq.j(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey, false);
                        break;
                    case 34:
                        zq.e(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey, false);
                        break;
                    case 35:
                        zq.a(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey, true);
                        break;
                    case 36:
                        zq.b(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey, true);
                        break;
                    case 37:
                        zq.c(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey, true);
                        break;
                    case 38:
                        zq.d(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey, true);
                        break;
                    case 39:
                        zq.h(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey, true);
                        break;
                    case 40:
                        zq.f(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey, true);
                        break;
                    case 41:
                        zq.k(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey, true);
                        break;
                    case 42:
                        zq.n(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey, true);
                        break;
                    case 43:
                        zq.i(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey, true);
                        break;
                    case 44:
                        zq.m(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey, true);
                        break;
                    case 45:
                        zq.l(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey, true);
                        break;
                    case 46:
                        zq.g(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey, true);
                        break;
                    case 47:
                        zq.j(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey, true);
                        break;
                    case 48:
                        zq.e(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey, true);
                        break;
                    case 49:
                        zq.b(this.b[length], (List) aal.f(t, (long) (1048575 & d)), zzbey, a(length));
                        break;
                    case 50:
                        a(zzbey, i, aal.f(t, (long) (1048575 & d)), length);
                        break;
                    case 51:
                        if (!a((Object) t, i, length)) {
                            break;
                        }
                        zzbey.zza(i, b((Object) t, (long) (1048575 & d)));
                        break;
                    case 52:
                        if (!a((Object) t, i, length)) {
                            break;
                        }
                        zzbey.zza(i, c(t, (long) (1048575 & d)));
                        break;
                    case 53:
                        if (!a((Object) t, i, length)) {
                            break;
                        }
                        zzbey.zzi(i, e(t, (long) (1048575 & d)));
                        break;
                    case 54:
                        if (!a((Object) t, i, length)) {
                            break;
                        }
                        zzbey.zza(i, e(t, (long) (1048575 & d)));
                        break;
                    case 55:
                        if (!a((Object) t, i, length)) {
                            break;
                        }
                        zzbey.zzm(i, d(t, (long) (1048575 & d)));
                        break;
                    case 56:
                        if (!a((Object) t, i, length)) {
                            break;
                        }
                        zzbey.zzc(i, e(t, (long) (1048575 & d)));
                        break;
                    case 57:
                        if (!a((Object) t, i, length)) {
                            break;
                        }
                        zzbey.zzp(i, d(t, (long) (1048575 & d)));
                        break;
                    case 58:
                        if (!a((Object) t, i, length)) {
                            break;
                        }
                        zzbey.zzf(i, f(t, (long) (1048575 & d)));
                        break;
                    case 59:
                        if (!a((Object) t, i, length)) {
                            break;
                        }
                        a(i, aal.f(t, (long) (1048575 & d)), zzbey);
                        break;
                    case 60:
                        if (!a((Object) t, i, length)) {
                            break;
                        }
                        zzbey.zza(i, aal.f(t, (long) (1048575 & d)), a(length));
                        break;
                    case 61:
                        if (!a((Object) t, i, length)) {
                            break;
                        }
                        zzbey.zza(i, (zzbah) aal.f(t, (long) (1048575 & d)));
                        break;
                    case 62:
                        if (!a((Object) t, i, length)) {
                            break;
                        }
                        zzbey.zzn(i, d(t, (long) (1048575 & d)));
                        break;
                    case 63:
                        if (!a((Object) t, i, length)) {
                            break;
                        }
                        zzbey.zzx(i, d(t, (long) (1048575 & d)));
                        break;
                    case 64:
                        if (!a((Object) t, i, length)) {
                            break;
                        }
                        zzbey.zzw(i, d(t, (long) (1048575 & d)));
                        break;
                    case 65:
                        if (!a((Object) t, i, length)) {
                            break;
                        }
                        zzbey.zzj(i, e(t, (long) (1048575 & d)));
                        break;
                    case 66:
                        if (!a((Object) t, i, length)) {
                            break;
                        }
                        zzbey.zzo(i, d(t, (long) (1048575 & d)));
                        break;
                    case 67:
                        if (!a((Object) t, i, length)) {
                            break;
                        }
                        zzbey.zzb(i, e(t, (long) (1048575 & d)));
                        break;
                    case 68:
                        if (!a((Object) t, i, length)) {
                            break;
                        }
                        zzbey.zzb(i, aal.f(t, (long) (1048575 & d)), a(length));
                        break;
                    default:
                        break;
                }
                length -= 4;
                entry = entry2;
            }
            while (entry != null) {
                this.r.a(zzbey, entry);
                entry = it.hasNext() ? (Entry) it.next() : null;
            }
        } else if (this.j) {
            it = null;
            entry = null;
            if (this.h) {
                a = this.r.a((Object) t);
                if (!a.b()) {
                    it = a.e();
                    entry = (Entry) it.next();
                }
            }
            d = this.b.length;
            length = 0;
            while (length < d) {
                i = d(length);
                int i2 = this.b[length];
                entry2 = entry;
                while (entry2 != null && this.r.a(entry2) <= i2) {
                    this.r.a(zzbey, entry2);
                    entry2 = it.hasNext() ? (Entry) it.next() : null;
                }
                switch ((267386880 & i) >>> 20) {
                    case 0:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zza(i2, aal.e(t, (long) (1048575 & i)));
                        break;
                    case 1:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zza(i2, aal.d(t, (long) (1048575 & i)));
                        break;
                    case 2:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zzi(i2, aal.b(t, (long) (1048575 & i)));
                        break;
                    case 3:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zza(i2, aal.b(t, (long) (1048575 & i)));
                        break;
                    case 4:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zzm(i2, aal.a((Object) t, (long) (1048575 & i)));
                        break;
                    case 5:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zzc(i2, aal.b(t, (long) (1048575 & i)));
                        break;
                    case 6:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zzp(i2, aal.a((Object) t, (long) (1048575 & i)));
                        break;
                    case 7:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zzf(i2, aal.c(t, (long) (1048575 & i)));
                        break;
                    case 8:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        a(i2, aal.f(t, (long) (1048575 & i)), zzbey);
                        break;
                    case 9:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zza(i2, aal.f(t, (long) (1048575 & i)), a(length));
                        break;
                    case 10:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zza(i2, (zzbah) aal.f(t, (long) (1048575 & i)));
                        break;
                    case 11:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zzn(i2, aal.a((Object) t, (long) (1048575 & i)));
                        break;
                    case 12:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zzx(i2, aal.a((Object) t, (long) (1048575 & i)));
                        break;
                    case 13:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zzw(i2, aal.a((Object) t, (long) (1048575 & i)));
                        break;
                    case 14:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zzj(i2, aal.b(t, (long) (1048575 & i)));
                        break;
                    case 15:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zzo(i2, aal.a((Object) t, (long) (1048575 & i)));
                        break;
                    case 16:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zzb(i2, aal.b(t, (long) (1048575 & i)));
                        break;
                    case 17:
                        if (!a((Object) t, length)) {
                            break;
                        }
                        zzbey.zzb(i2, aal.f(t, (long) (1048575 & i)), a(length));
                        break;
                    case 18:
                        zq.a(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey, false);
                        break;
                    case 19:
                        zq.b(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey, false);
                        break;
                    case 20:
                        zq.c(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey, false);
                        break;
                    case 21:
                        zq.d(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey, false);
                        break;
                    case 22:
                        zq.h(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey, false);
                        break;
                    case 23:
                        zq.f(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey, false);
                        break;
                    case 24:
                        zq.k(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey, false);
                        break;
                    case 25:
                        zq.n(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey, false);
                        break;
                    case 26:
                        zq.a(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey);
                        break;
                    case 27:
                        zq.a(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey, a(length));
                        break;
                    case 28:
                        zq.b(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey);
                        break;
                    case 29:
                        zq.i(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey, false);
                        break;
                    case 30:
                        zq.m(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey, false);
                        break;
                    case 31:
                        zq.l(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey, false);
                        break;
                    case 32:
                        zq.g(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey, false);
                        break;
                    case 33:
                        zq.j(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey, false);
                        break;
                    case 34:
                        zq.e(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey, false);
                        break;
                    case 35:
                        zq.a(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey, true);
                        break;
                    case 36:
                        zq.b(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey, true);
                        break;
                    case 37:
                        zq.c(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey, true);
                        break;
                    case 38:
                        zq.d(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey, true);
                        break;
                    case 39:
                        zq.h(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey, true);
                        break;
                    case 40:
                        zq.f(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey, true);
                        break;
                    case 41:
                        zq.k(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey, true);
                        break;
                    case 42:
                        zq.n(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey, true);
                        break;
                    case 43:
                        zq.i(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey, true);
                        break;
                    case 44:
                        zq.m(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey, true);
                        break;
                    case 45:
                        zq.l(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey, true);
                        break;
                    case 46:
                        zq.g(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey, true);
                        break;
                    case 47:
                        zq.j(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey, true);
                        break;
                    case 48:
                        zq.e(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey, true);
                        break;
                    case 49:
                        zq.b(this.b[length], (List) aal.f(t, (long) (1048575 & i)), zzbey, a(length));
                        break;
                    case 50:
                        a(zzbey, i2, aal.f(t, (long) (1048575 & i)), length);
                        break;
                    case 51:
                        if (!a((Object) t, i2, length)) {
                            break;
                        }
                        zzbey.zza(i2, b((Object) t, (long) (1048575 & i)));
                        break;
                    case 52:
                        if (!a((Object) t, i2, length)) {
                            break;
                        }
                        zzbey.zza(i2, c(t, (long) (1048575 & i)));
                        break;
                    case 53:
                        if (!a((Object) t, i2, length)) {
                            break;
                        }
                        zzbey.zzi(i2, e(t, (long) (1048575 & i)));
                        break;
                    case 54:
                        if (!a((Object) t, i2, length)) {
                            break;
                        }
                        zzbey.zza(i2, e(t, (long) (1048575 & i)));
                        break;
                    case 55:
                        if (!a((Object) t, i2, length)) {
                            break;
                        }
                        zzbey.zzm(i2, d(t, (long) (1048575 & i)));
                        break;
                    case 56:
                        if (!a((Object) t, i2, length)) {
                            break;
                        }
                        zzbey.zzc(i2, e(t, (long) (1048575 & i)));
                        break;
                    case 57:
                        if (!a((Object) t, i2, length)) {
                            break;
                        }
                        zzbey.zzp(i2, d(t, (long) (1048575 & i)));
                        break;
                    case 58:
                        if (!a((Object) t, i2, length)) {
                            break;
                        }
                        zzbey.zzf(i2, f(t, (long) (1048575 & i)));
                        break;
                    case 59:
                        if (!a((Object) t, i2, length)) {
                            break;
                        }
                        a(i2, aal.f(t, (long) (1048575 & i)), zzbey);
                        break;
                    case 60:
                        if (!a((Object) t, i2, length)) {
                            break;
                        }
                        zzbey.zza(i2, aal.f(t, (long) (1048575 & i)), a(length));
                        break;
                    case 61:
                        if (!a((Object) t, i2, length)) {
                            break;
                        }
                        zzbey.zza(i2, (zzbah) aal.f(t, (long) (1048575 & i)));
                        break;
                    case 62:
                        if (!a((Object) t, i2, length)) {
                            break;
                        }
                        zzbey.zzn(i2, d(t, (long) (1048575 & i)));
                        break;
                    case 63:
                        if (!a((Object) t, i2, length)) {
                            break;
                        }
                        zzbey.zzx(i2, d(t, (long) (1048575 & i)));
                        break;
                    case 64:
                        if (!a((Object) t, i2, length)) {
                            break;
                        }
                        zzbey.zzw(i2, d(t, (long) (1048575 & i)));
                        break;
                    case 65:
                        if (!a((Object) t, i2, length)) {
                            break;
                        }
                        zzbey.zzj(i2, e(t, (long) (1048575 & i)));
                        break;
                    case 66:
                        if (!a((Object) t, i2, length)) {
                            break;
                        }
                        zzbey.zzo(i2, d(t, (long) (1048575 & i)));
                        break;
                    case 67:
                        if (!a((Object) t, i2, length)) {
                            break;
                        }
                        zzbey.zzb(i2, e(t, (long) (1048575 & i)));
                        break;
                    case 68:
                        if (!a((Object) t, i2, length)) {
                            break;
                        }
                        zzbey.zzb(i2, aal.f(t, (long) (1048575 & i)), a(length));
                        break;
                    default:
                        break;
                }
                length += 4;
                entry = entry2;
            }
            while (entry != null) {
                this.r.a(zzbey, entry);
                entry = it.hasNext() ? (Entry) it.next() : null;
            }
            a(this.q, (Object) t, zzbey);
        } else {
            a((Object) t, zzbey);
        }
    }

    public final void zza(T t, byte[] bArr, int i, int i2, ww wwVar) {
        if (this.j) {
            Unsafe unsafe = a;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                int i5 = bArr[i3];
                if (i5 < 0) {
                    i4 = wv.a(i5, bArr, i4, wwVar);
                    i5 = wwVar.a;
                }
                int i6 = i5 >>> 3;
                i3 = i5 & 7;
                int g = g(i6);
                if (g >= 0) {
                    int i7 = this.b[g + 1];
                    int i8 = (267386880 & i7) >>> 20;
                    long j = (long) (1048575 & i7);
                    if (i8 <= 17) {
                        switch (i8) {
                            case 0:
                                if (i3 == 1) {
                                    aal.a((Object) t, j, wv.c(bArr, i4));
                                    i3 = i4 + 8;
                                    continue;
                                }
                                break;
                            case 1:
                                if (i3 == 5) {
                                    aal.a((Object) t, j, wv.d(bArr, i4));
                                    i3 = i4 + 4;
                                    continue;
                                }
                                break;
                            case 2:
                            case 3:
                                if (i3 == 0) {
                                    i3 = wv.b(bArr, i4, wwVar);
                                    unsafe.putLong(t, j, wwVar.b);
                                    continue;
                                }
                                break;
                            case 4:
                            case 11:
                                if (i3 == 0) {
                                    i3 = wv.a(bArr, i4, wwVar);
                                    unsafe.putInt(t, j, wwVar.a);
                                    continue;
                                }
                                break;
                            case 5:
                            case 14:
                                if (i3 == 1) {
                                    unsafe.putLong(t, j, wv.b(bArr, i4));
                                    i3 = i4 + 8;
                                    continue;
                                }
                                break;
                            case 6:
                            case 13:
                                if (i3 == 5) {
                                    unsafe.putInt(t, j, wv.a(bArr, i4));
                                    i3 = i4 + 4;
                                    continue;
                                }
                                break;
                            case 7:
                                if (i3 == 0) {
                                    i3 = wv.b(bArr, i4, wwVar);
                                    aal.a((Object) t, j, wwVar.b != 0);
                                    continue;
                                }
                                break;
                            case 8:
                                if (i3 == 2) {
                                    int c = (536870912 & i7) == 0 ? wv.c(bArr, i4, wwVar) : wv.d(bArr, i4, wwVar);
                                    unsafe.putObject(t, j, wwVar.c);
                                    i3 = c;
                                    continue;
                                }
                                break;
                            case 9:
                                if (i3 == 2) {
                                    i3 = a(a(g), bArr, i4, i2, wwVar);
                                    Object object = unsafe.getObject(t, j);
                                    if (object != null) {
                                        unsafe.putObject(t, j, yk.a(object, wwVar.c));
                                        break;
                                    } else {
                                        unsafe.putObject(t, j, wwVar.c);
                                        continue;
                                    }
                                }
                                break;
                            case 10:
                                if (i3 == 2) {
                                    i3 = wv.e(bArr, i4, wwVar);
                                    unsafe.putObject(t, j, wwVar.c);
                                    continue;
                                }
                                break;
                            case 12:
                                if (i3 == 0) {
                                    i3 = wv.a(bArr, i4, wwVar);
                                    unsafe.putInt(t, j, wwVar.a);
                                    continue;
                                }
                                break;
                            case 15:
                                if (i3 == 0) {
                                    i3 = wv.a(bArr, i4, wwVar);
                                    unsafe.putInt(t, j, xg.f(wwVar.a));
                                    continue;
                                }
                                break;
                            case 16:
                                if (i3 == 0) {
                                    i3 = wv.b(bArr, i4, wwVar);
                                    unsafe.putLong(t, j, xg.a(wwVar.b));
                                    continue;
                                }
                                break;
                            default:
                                i3 = i4;
                                break;
                        }
                    } else if (i8 == 27) {
                        if (i3 == 2) {
                            zzbbt zzbbt;
                            zzbbt zzbbt2 = (zzbbt) unsafe.getObject(t, j);
                            if (zzbbt2.zzaay()) {
                                zzbbt = zzbbt2;
                            } else {
                                int size = zzbbt2.size();
                                zzbbt = zzbbt2.zzbm(size == 0 ? 10 : size << 1);
                                unsafe.putObject(t, j, zzbbt);
                            }
                            i3 = a(a(g), i5, bArr, i4, i2, zzbbt, wwVar);
                        }
                    } else if (i8 <= 49) {
                        i3 = a((Object) t, bArr, i4, i2, i5, i6, i3, g, (long) i7, i8, j, wwVar);
                        if (i3 != i4) {
                        }
                        i3 = a(i5, bArr, i3, i2, (Object) t, wwVar);
                    } else if (i8 != 50) {
                        i3 = a((Object) t, bArr, i4, i2, i5, i6, i3, i7, i8, j, g, wwVar);
                        if (i3 != i4) {
                        }
                        i3 = a(i5, bArr, i3, i2, (Object) t, wwVar);
                    } else if (i3 == 2) {
                        i3 = a(t, bArr, i4, i2, g, i6, j, wwVar);
                        if (i3 != i4) {
                        }
                        i3 = a(i5, bArr, i3, i2, (Object) t, wwVar);
                    }
                }
                i3 = i4;
                i3 = a(i5, bArr, i3, i2, (Object) t, wwVar);
            }
            if (i3 != i2) {
                throw zzbbu.g();
            }
            return;
        }
        a((Object) t, bArr, i, i2, 0, wwVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:77:0x0058 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0098 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0058 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0106 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0058 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a0  */
    public final boolean zzaa(T r13) {
        /*
        r12 = this;
        r0 = r12.l;
        if (r0 == 0) goto L_0x0009;
    L_0x0004:
        r0 = r12.l;
        r0 = r0.length;
        if (r0 != 0) goto L_0x000b;
    L_0x0009:
        r0 = 1;
    L_0x000a:
        return r0;
    L_0x000b:
        r3 = -1;
        r1 = 0;
        r5 = r12.l;
        r6 = r5.length;
        r0 = 0;
        r4 = r0;
    L_0x0012:
        if (r4 >= r6) goto L_0x010b;
    L_0x0014:
        r7 = r5[r4];
        r8 = r12.g(r7);
        r9 = r12.d(r8);
        r0 = 0;
        r2 = r12.j;
        if (r2 != 0) goto L_0x0121;
    L_0x0023:
        r0 = r12.b;
        r2 = r8 + 2;
        r0 = r0[r2];
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r0;
        r10 = 1;
        r0 = r0 >>> 20;
        r0 = r10 << r0;
        if (r2 == r3) goto L_0x0121;
    L_0x0034:
        r1 = a;
        r10 = (long) r2;
        r1 = r1.getInt(r13, r10);
        r3 = r2;
        r2 = r1;
        r1 = r0;
    L_0x003e:
        r0 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r0 = r0 & r9;
        if (r0 == 0) goto L_0x004e;
    L_0x0043:
        r0 = 1;
    L_0x0044:
        if (r0 == 0) goto L_0x0050;
    L_0x0046:
        r0 = r12.a(r13, r8, r2, r1);
        if (r0 != 0) goto L_0x0050;
    L_0x004c:
        r0 = 0;
        goto L_0x000a;
    L_0x004e:
        r0 = 0;
        goto L_0x0044;
    L_0x0050:
        r0 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        r0 = r0 & r9;
        r0 = r0 >>> 20;
        switch(r0) {
            case 9: goto L_0x005d;
            case 17: goto L_0x005d;
            case 27: goto L_0x006f;
            case 49: goto L_0x006f;
            case 50: goto L_0x00b3;
            case 60: goto L_0x00a0;
            case 68: goto L_0x00a0;
            default: goto L_0x0058;
        };
    L_0x0058:
        r0 = r4 + 1;
        r4 = r0;
        r1 = r2;
        goto L_0x0012;
    L_0x005d:
        r0 = r12.a(r13, r8, r2, r1);
        if (r0 == 0) goto L_0x0058;
    L_0x0063:
        r0 = r12.a(r8);
        r0 = a(r13, r9, r0);
        if (r0 != 0) goto L_0x0058;
    L_0x006d:
        r0 = 0;
        goto L_0x000a;
    L_0x006f:
        r0 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r0 = r0 & r9;
        r0 = (long) r0;
        r0 = com.google.android.gms.internal.ads.aal.f(r13, r0);
        r0 = (java.util.List) r0;
        r1 = r0.isEmpty();
        if (r1 != 0) goto L_0x009e;
    L_0x0080:
        r7 = r12.a(r8);
        r1 = 0;
    L_0x0085:
        r8 = r0.size();
        if (r1 >= r8) goto L_0x009e;
    L_0x008b:
        r8 = r0.get(r1);
        r8 = r7.zzaa(r8);
        if (r8 != 0) goto L_0x009b;
    L_0x0095:
        r0 = 0;
    L_0x0096:
        if (r0 != 0) goto L_0x0058;
    L_0x0098:
        r0 = 0;
        goto L_0x000a;
    L_0x009b:
        r1 = r1 + 1;
        goto L_0x0085;
    L_0x009e:
        r0 = 1;
        goto L_0x0096;
    L_0x00a0:
        r0 = r12.a(r13, r7, r8);
        if (r0 == 0) goto L_0x0058;
    L_0x00a6:
        r0 = r12.a(r8);
        r0 = a(r13, r9, r0);
        if (r0 != 0) goto L_0x0058;
    L_0x00b0:
        r0 = 0;
        goto L_0x000a;
    L_0x00b3:
        r0 = r12.s;
        r1 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r1 = r1 & r9;
        r10 = (long) r1;
        r1 = com.google.android.gms.internal.ads.aal.f(r13, r10);
        r1 = r0.zzt(r1);
        r0 = r1.isEmpty();
        if (r0 != 0) goto L_0x0109;
    L_0x00c8:
        r0 = r12.b(r8);
        r7 = r12.s;
        r0 = r7.zzx(r0);
        r0 = r0.c;
        r0 = r0.a();
        r7 = com.google.android.gms.internal.ads.zzbex.MESSAGE;
        if (r0 != r7) goto L_0x0109;
    L_0x00dc:
        r0 = 0;
        r1 = r1.values();
        r1 = r1.iterator();
    L_0x00e5:
        r7 = r1.hasNext();
        if (r7 == 0) goto L_0x0109;
    L_0x00eb:
        r7 = r1.next();
        if (r0 != 0) goto L_0x00fd;
    L_0x00f1:
        r0 = com.google.android.gms.internal.ads.zl.a();
        r8 = r7.getClass();
        r0 = r0.a(r8);
    L_0x00fd:
        r7 = r0.zzaa(r7);
        if (r7 != 0) goto L_0x00e5;
    L_0x0103:
        r0 = 0;
    L_0x0104:
        if (r0 != 0) goto L_0x0058;
    L_0x0106:
        r0 = 0;
        goto L_0x000a;
    L_0x0109:
        r0 = 1;
        goto L_0x0104;
    L_0x010b:
        r0 = r12.h;
        if (r0 == 0) goto L_0x011e;
    L_0x010f:
        r0 = r12.r;
        r0 = r0.a(r13);
        r0 = r0.g();
        if (r0 != 0) goto L_0x011e;
    L_0x011b:
        r0 = 0;
        goto L_0x000a;
    L_0x011e:
        r0 = 1;
        goto L_0x000a;
    L_0x0121:
        r2 = r1;
        r1 = r0;
        goto L_0x003e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zf.zzaa(java.lang.Object):boolean");
    }

    public final void zzc(T t, T t2) {
        if (t2 == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < this.b.length; i += 4) {
            int d = d(i);
            long j = (long) (1048575 & d);
            int i2 = this.b[i];
            switch ((d & 267386880) >>> 20) {
                case 0:
                    if (!a((Object) t2, i)) {
                        break;
                    }
                    aal.a((Object) t, j, aal.e(t2, j));
                    b((Object) t, i);
                    break;
                case 1:
                    if (!a((Object) t2, i)) {
                        break;
                    }
                    aal.a((Object) t, j, aal.d(t2, j));
                    b((Object) t, i);
                    break;
                case 2:
                    if (!a((Object) t2, i)) {
                        break;
                    }
                    aal.a((Object) t, j, aal.b(t2, j));
                    b((Object) t, i);
                    break;
                case 3:
                    if (!a((Object) t2, i)) {
                        break;
                    }
                    aal.a((Object) t, j, aal.b(t2, j));
                    b((Object) t, i);
                    break;
                case 4:
                    if (!a((Object) t2, i)) {
                        break;
                    }
                    aal.a((Object) t, j, aal.a((Object) t2, j));
                    b((Object) t, i);
                    break;
                case 5:
                    if (!a((Object) t2, i)) {
                        break;
                    }
                    aal.a((Object) t, j, aal.b(t2, j));
                    b((Object) t, i);
                    break;
                case 6:
                    if (!a((Object) t2, i)) {
                        break;
                    }
                    aal.a((Object) t, j, aal.a((Object) t2, j));
                    b((Object) t, i);
                    break;
                case 7:
                    if (!a((Object) t2, i)) {
                        break;
                    }
                    aal.a((Object) t, j, aal.c(t2, j));
                    b((Object) t, i);
                    break;
                case 8:
                    if (!a((Object) t2, i)) {
                        break;
                    }
                    aal.a((Object) t, j, aal.f(t2, j));
                    b((Object) t, i);
                    break;
                case 9:
                    a((Object) t, (Object) t2, i);
                    break;
                case 10:
                    if (!a((Object) t2, i)) {
                        break;
                    }
                    aal.a((Object) t, j, aal.f(t2, j));
                    b((Object) t, i);
                    break;
                case 11:
                    if (!a((Object) t2, i)) {
                        break;
                    }
                    aal.a((Object) t, j, aal.a((Object) t2, j));
                    b((Object) t, i);
                    break;
                case 12:
                    if (!a((Object) t2, i)) {
                        break;
                    }
                    aal.a((Object) t, j, aal.a((Object) t2, j));
                    b((Object) t, i);
                    break;
                case 13:
                    if (!a((Object) t2, i)) {
                        break;
                    }
                    aal.a((Object) t, j, aal.a((Object) t2, j));
                    b((Object) t, i);
                    break;
                case 14:
                    if (!a((Object) t2, i)) {
                        break;
                    }
                    aal.a((Object) t, j, aal.b(t2, j));
                    b((Object) t, i);
                    break;
                case 15:
                    if (!a((Object) t2, i)) {
                        break;
                    }
                    aal.a((Object) t, j, aal.a((Object) t2, j));
                    b((Object) t, i);
                    break;
                case 16:
                    if (!a((Object) t2, i)) {
                        break;
                    }
                    aal.a((Object) t, j, aal.b(t2, j));
                    b((Object) t, i);
                    break;
                case 17:
                    a((Object) t, (Object) t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.p.a(t, t2, j);
                    break;
                case 50:
                    zq.a(this.s, (Object) t, (Object) t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!a((Object) t2, i2, i)) {
                        break;
                    }
                    aal.a((Object) t, j, aal.f(t2, j));
                    b((Object) t, i2, i);
                    break;
                case 60:
                    b((Object) t, (Object) t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!a((Object) t2, i2, i)) {
                        break;
                    }
                    aal.a((Object) t, j, aal.f(t2, j));
                    b((Object) t, i2, i);
                    break;
                case 68:
                    b((Object) t, (Object) t2, i);
                    break;
                default:
                    break;
            }
        }
        if (!this.j) {
            zq.a(this.q, (Object) t, (Object) t2);
            if (this.h) {
                zq.a(this.r, (Object) t, (Object) t2);
            }
        }
    }

    public final void zzo(T t) {
        int i = 0;
        if (this.m != null) {
            for (int d : this.m) {
                long d2 = (long) (d(d) & 1048575);
                Object f = aal.f(t, d2);
                if (f != null) {
                    aal.a((Object) t, d2, this.s.zzv(f));
                }
            }
        }
        if (this.n != null) {
            int[] iArr = this.n;
            int length = iArr.length;
            while (i < length) {
                this.p.b(t, (long) iArr[i]);
                i++;
            }
        }
        this.q.d(t);
        if (this.h) {
            this.r.c(t);
        }
    }

    public final int zzy(T t) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Object f;
        if (this.j) {
            Unsafe unsafe = a;
            i = 0;
            i2 = 0;
            while (true) {
                i3 = i;
                if (i3 >= this.b.length) {
                    return a(this.q, (Object) t) + i2;
                }
                i = d(i3);
                i4 = (267386880 & i) >>> 20;
                i5 = this.b[i3];
                long j = (long) (i & 1048575);
                i6 = (i4 < zzbbj.DOUBLE_LIST_PACKED.a() || i4 > zzbbj.SINT64_LIST_PACKED.a()) ? 0 : this.b[i3 + 2] & 1048575;
                switch (i4) {
                    case 0:
                        if (!a((Object) t, i3)) {
                            break;
                        }
                        i2 += zzbav.b(i5, 0.0d);
                        break;
                    case 1:
                        if (!a((Object) t, i3)) {
                            break;
                        }
                        i2 += zzbav.b(i5, 0.0f);
                        break;
                    case 2:
                        if (!a((Object) t, i3)) {
                            break;
                        }
                        i2 += zzbav.d(i5, aal.b(t, j));
                        break;
                    case 3:
                        if (!a((Object) t, i3)) {
                            break;
                        }
                        i2 += zzbav.e(i5, aal.b(t, j));
                        break;
                    case 4:
                        if (!a((Object) t, i3)) {
                            break;
                        }
                        i2 += zzbav.f(i5, aal.a((Object) t, j));
                        break;
                    case 5:
                        if (!a((Object) t, i3)) {
                            break;
                        }
                        i2 += zzbav.g(i5, 0);
                        break;
                    case 6:
                        if (!a((Object) t, i3)) {
                            break;
                        }
                        i2 += zzbav.i(i5, 0);
                        break;
                    case 7:
                        if (!a((Object) t, i3)) {
                            break;
                        }
                        i2 += zzbav.b(i5, true);
                        break;
                    case 8:
                        if (!a((Object) t, i3)) {
                            break;
                        }
                        f = aal.f(t, j);
                        if (!(f instanceof zzbah)) {
                            i2 += zzbav.b(i5, (String) f);
                            break;
                        }
                        i2 += zzbav.c(i5, (zzbah) f);
                        break;
                    case 9:
                        if (!a((Object) t, i3)) {
                            break;
                        }
                        i2 += zq.a(i5, aal.f(t, j), a(i3));
                        break;
                    case 10:
                        if (!a((Object) t, i3)) {
                            break;
                        }
                        i2 += zzbav.c(i5, (zzbah) aal.f(t, j));
                        break;
                    case 11:
                        if (!a((Object) t, i3)) {
                            break;
                        }
                        i2 += zzbav.g(i5, aal.a((Object) t, j));
                        break;
                    case 12:
                        if (!a((Object) t, i3)) {
                            break;
                        }
                        i2 += zzbav.k(i5, aal.a((Object) t, j));
                        break;
                    case 13:
                        if (!a((Object) t, i3)) {
                            break;
                        }
                        i2 += zzbav.j(i5, 0);
                        break;
                    case 14:
                        if (!a((Object) t, i3)) {
                            break;
                        }
                        i2 += zzbav.h(i5, 0);
                        break;
                    case 15:
                        if (!a((Object) t, i3)) {
                            break;
                        }
                        i2 += zzbav.h(i5, aal.a((Object) t, j));
                        break;
                    case 16:
                        if (!a((Object) t, i3)) {
                            break;
                        }
                        i2 += zzbav.f(i5, aal.b(t, j));
                        break;
                    case 17:
                        if (!a((Object) t, i3)) {
                            break;
                        }
                        i2 += zzbav.c(i5, (zzbcu) aal.f(t, j), a(i3));
                        break;
                    case 18:
                        i2 += zq.i(i5, a((Object) t, j), false);
                        break;
                    case 19:
                        i2 += zq.h(i5, a((Object) t, j), false);
                        break;
                    case 20:
                        i2 += zq.a(i5, a((Object) t, j), false);
                        break;
                    case 21:
                        i2 += zq.b(i5, a((Object) t, j), false);
                        break;
                    case 22:
                        i2 += zq.e(i5, a((Object) t, j), false);
                        break;
                    case 23:
                        i2 += zq.i(i5, a((Object) t, j), false);
                        break;
                    case 24:
                        i2 += zq.h(i5, a((Object) t, j), false);
                        break;
                    case 25:
                        i2 += zq.j(i5, a((Object) t, j), false);
                        break;
                    case 26:
                        i2 += zq.a(i5, a((Object) t, j));
                        break;
                    case 27:
                        i2 += zq.a(i5, a((Object) t, j), a(i3));
                        break;
                    case 28:
                        i2 += zq.b(i5, a((Object) t, j));
                        break;
                    case 29:
                        i2 += zq.f(i5, a((Object) t, j), false);
                        break;
                    case 30:
                        i2 += zq.d(i5, a((Object) t, j), false);
                        break;
                    case 31:
                        i2 += zq.h(i5, a((Object) t, j), false);
                        break;
                    case 32:
                        i2 += zq.i(i5, a((Object) t, j), false);
                        break;
                    case 33:
                        i2 += zq.g(i5, a((Object) t, j), false);
                        break;
                    case 34:
                        i2 += zq.c(i5, a((Object) t, j), false);
                        break;
                    case 35:
                        i = zq.i((List) unsafe.getObject(t, j));
                        if (i > 0) {
                            if (this.k) {
                                unsafe.putInt(t, (long) i6, i);
                            }
                            i2 += i + (zzbav.e(i5) + zzbav.g(i));
                            break;
                        }
                        break;
                    case 36:
                        i = zq.h((List) unsafe.getObject(t, j));
                        if (i > 0) {
                            if (this.k) {
                                unsafe.putInt(t, (long) i6, i);
                            }
                            i2 += i + (zzbav.e(i5) + zzbav.g(i));
                            break;
                        }
                        break;
                    case 37:
                        i = zq.a((List) unsafe.getObject(t, j));
                        if (i > 0) {
                            if (this.k) {
                                unsafe.putInt(t, (long) i6, i);
                            }
                            i2 += i + (zzbav.e(i5) + zzbav.g(i));
                            break;
                        }
                        break;
                    case 38:
                        i = zq.b((List) unsafe.getObject(t, j));
                        if (i > 0) {
                            if (this.k) {
                                unsafe.putInt(t, (long) i6, i);
                            }
                            i2 += i + (zzbav.e(i5) + zzbav.g(i));
                            break;
                        }
                        break;
                    case 39:
                        i = zq.e((List) unsafe.getObject(t, j));
                        if (i > 0) {
                            if (this.k) {
                                unsafe.putInt(t, (long) i6, i);
                            }
                            i2 += i + (zzbav.e(i5) + zzbav.g(i));
                            break;
                        }
                        break;
                    case 40:
                        i = zq.i((List) unsafe.getObject(t, j));
                        if (i > 0) {
                            if (this.k) {
                                unsafe.putInt(t, (long) i6, i);
                            }
                            i2 += i + (zzbav.e(i5) + zzbav.g(i));
                            break;
                        }
                        break;
                    case 41:
                        i = zq.h((List) unsafe.getObject(t, j));
                        if (i > 0) {
                            if (this.k) {
                                unsafe.putInt(t, (long) i6, i);
                            }
                            i2 += i + (zzbav.e(i5) + zzbav.g(i));
                            break;
                        }
                        break;
                    case 42:
                        i = zq.j((List) unsafe.getObject(t, j));
                        if (i > 0) {
                            if (this.k) {
                                unsafe.putInt(t, (long) i6, i);
                            }
                            i2 += i + (zzbav.e(i5) + zzbav.g(i));
                            break;
                        }
                        break;
                    case 43:
                        i = zq.f((List) unsafe.getObject(t, j));
                        if (i > 0) {
                            if (this.k) {
                                unsafe.putInt(t, (long) i6, i);
                            }
                            i2 += i + (zzbav.e(i5) + zzbav.g(i));
                            break;
                        }
                        break;
                    case 44:
                        i = zq.d((List) unsafe.getObject(t, j));
                        if (i > 0) {
                            if (this.k) {
                                unsafe.putInt(t, (long) i6, i);
                            }
                            i2 += i + (zzbav.e(i5) + zzbav.g(i));
                            break;
                        }
                        break;
                    case 45:
                        i = zq.h((List) unsafe.getObject(t, j));
                        if (i > 0) {
                            if (this.k) {
                                unsafe.putInt(t, (long) i6, i);
                            }
                            i2 += i + (zzbav.e(i5) + zzbav.g(i));
                            break;
                        }
                        break;
                    case 46:
                        i = zq.i((List) unsafe.getObject(t, j));
                        if (i > 0) {
                            if (this.k) {
                                unsafe.putInt(t, (long) i6, i);
                            }
                            i2 += i + (zzbav.e(i5) + zzbav.g(i));
                            break;
                        }
                        break;
                    case 47:
                        i = zq.g((List) unsafe.getObject(t, j));
                        if (i > 0) {
                            if (this.k) {
                                unsafe.putInt(t, (long) i6, i);
                            }
                            i2 += i + (zzbav.e(i5) + zzbav.g(i));
                            break;
                        }
                        break;
                    case 48:
                        i = zq.c((List) unsafe.getObject(t, j));
                        if (i > 0) {
                            if (this.k) {
                                unsafe.putInt(t, (long) i6, i);
                            }
                            i2 += i + (zzbav.e(i5) + zzbav.g(i));
                            break;
                        }
                        break;
                    case 49:
                        i2 += zq.b(i5, a((Object) t, j), a(i3));
                        break;
                    case 50:
                        i2 += this.s.zzb(i5, aal.f(t, j), b(i3));
                        break;
                    case 51:
                        if (!a((Object) t, i5, i3)) {
                            break;
                        }
                        i2 += zzbav.b(i5, 0.0d);
                        break;
                    case 52:
                        if (!a((Object) t, i5, i3)) {
                            break;
                        }
                        i2 += zzbav.b(i5, 0.0f);
                        break;
                    case 53:
                        if (!a((Object) t, i5, i3)) {
                            break;
                        }
                        i2 += zzbav.d(i5, e(t, j));
                        break;
                    case 54:
                        if (!a((Object) t, i5, i3)) {
                            break;
                        }
                        i2 += zzbav.e(i5, e(t, j));
                        break;
                    case 55:
                        if (!a((Object) t, i5, i3)) {
                            break;
                        }
                        i2 += zzbav.f(i5, d(t, j));
                        break;
                    case 56:
                        if (!a((Object) t, i5, i3)) {
                            break;
                        }
                        i2 += zzbav.g(i5, 0);
                        break;
                    case 57:
                        if (!a((Object) t, i5, i3)) {
                            break;
                        }
                        i2 += zzbav.i(i5, 0);
                        break;
                    case 58:
                        if (!a((Object) t, i5, i3)) {
                            break;
                        }
                        i2 += zzbav.b(i5, true);
                        break;
                    case 59:
                        if (!a((Object) t, i5, i3)) {
                            break;
                        }
                        f = aal.f(t, j);
                        if (!(f instanceof zzbah)) {
                            i2 += zzbav.b(i5, (String) f);
                            break;
                        }
                        i2 += zzbav.c(i5, (zzbah) f);
                        break;
                    case 60:
                        if (!a((Object) t, i5, i3)) {
                            break;
                        }
                        i2 += zq.a(i5, aal.f(t, j), a(i3));
                        break;
                    case 61:
                        if (!a((Object) t, i5, i3)) {
                            break;
                        }
                        i2 += zzbav.c(i5, (zzbah) aal.f(t, j));
                        break;
                    case 62:
                        if (!a((Object) t, i5, i3)) {
                            break;
                        }
                        i2 += zzbav.g(i5, d(t, j));
                        break;
                    case 63:
                        if (!a((Object) t, i5, i3)) {
                            break;
                        }
                        i2 += zzbav.k(i5, d(t, j));
                        break;
                    case 64:
                        if (!a((Object) t, i5, i3)) {
                            break;
                        }
                        i2 += zzbav.j(i5, 0);
                        break;
                    case 65:
                        if (!a((Object) t, i5, i3)) {
                            break;
                        }
                        i2 += zzbav.h(i5, 0);
                        break;
                    case 66:
                        if (!a((Object) t, i5, i3)) {
                            break;
                        }
                        i2 += zzbav.h(i5, d(t, j));
                        break;
                    case 67:
                        if (!a((Object) t, i5, i3)) {
                            break;
                        }
                        i2 += zzbav.f(i5, e(t, j));
                        break;
                    case 68:
                        if (!a((Object) t, i5, i3)) {
                            break;
                        }
                        i2 += zzbav.c(i5, (zzbcu) aal.f(t, j), a(i3));
                        break;
                    default:
                        break;
                }
                i = i3 + 4;
            }
        } else {
            Unsafe unsafe2 = a;
            i2 = -1;
            int i7 = 0;
            i3 = 0;
            i = 0;
            while (i3 < this.b.length) {
                int d = d(i3);
                int i8 = this.b[i3];
                int i9 = (267386880 & d) >>> 20;
                i4 = 0;
                if (i9 <= 17) {
                    i5 = this.b[i3 + 2];
                    i6 = 1048575 & i5;
                    i4 = 1 << (i5 >>> 20);
                    if (i6 != i2) {
                        i = unsafe2.getInt(t, (long) i6);
                        i2 = i6;
                    }
                    i6 = i2;
                    i2 = i;
                    i = i4;
                    i4 = i5;
                } else if (!this.k || i9 < zzbbj.DOUBLE_LIST_PACKED.a() || i9 > zzbbj.SINT64_LIST_PACKED.a()) {
                    i6 = i2;
                    i2 = i;
                    i = 0;
                } else {
                    i4 = this.b[i3 + 2] & 1048575;
                    i6 = i2;
                    i2 = i;
                    i = 0;
                }
                long j2 = (long) (1048575 & d);
                switch (i9) {
                    case 0:
                        if ((i & i2) == 0) {
                            break;
                        }
                        i7 += zzbav.b(i8, 0.0d);
                        break;
                    case 1:
                        if ((i & i2) == 0) {
                            break;
                        }
                        i7 += zzbav.b(i8, 0.0f);
                        break;
                    case 2:
                        if ((i & i2) == 0) {
                            break;
                        }
                        i7 += zzbav.d(i8, unsafe2.getLong(t, j2));
                        break;
                    case 3:
                        if ((i & i2) == 0) {
                            break;
                        }
                        i7 += zzbav.e(i8, unsafe2.getLong(t, j2));
                        break;
                    case 4:
                        if ((i & i2) == 0) {
                            break;
                        }
                        i7 += zzbav.f(i8, unsafe2.getInt(t, j2));
                        break;
                    case 5:
                        if ((i & i2) == 0) {
                            break;
                        }
                        i7 += zzbav.g(i8, 0);
                        break;
                    case 6:
                        if ((i & i2) == 0) {
                            break;
                        }
                        i7 += zzbav.i(i8, 0);
                        break;
                    case 7:
                        if ((i & i2) == 0) {
                            break;
                        }
                        i7 += zzbav.b(i8, true);
                        break;
                    case 8:
                        if ((i & i2) == 0) {
                            break;
                        }
                        f = unsafe2.getObject(t, j2);
                        if (!(f instanceof zzbah)) {
                            i7 += zzbav.b(i8, (String) f);
                            break;
                        }
                        i7 += zzbav.c(i8, (zzbah) f);
                        break;
                    case 9:
                        if ((i & i2) == 0) {
                            break;
                        }
                        i7 += zq.a(i8, unsafe2.getObject(t, j2), a(i3));
                        break;
                    case 10:
                        if ((i & i2) == 0) {
                            break;
                        }
                        i7 += zzbav.c(i8, (zzbah) unsafe2.getObject(t, j2));
                        break;
                    case 11:
                        if ((i & i2) == 0) {
                            break;
                        }
                        i7 += zzbav.g(i8, unsafe2.getInt(t, j2));
                        break;
                    case 12:
                        if ((i & i2) == 0) {
                            break;
                        }
                        i7 += zzbav.k(i8, unsafe2.getInt(t, j2));
                        break;
                    case 13:
                        if ((i & i2) == 0) {
                            break;
                        }
                        i7 += zzbav.j(i8, 0);
                        break;
                    case 14:
                        if ((i & i2) == 0) {
                            break;
                        }
                        i7 += zzbav.h(i8, 0);
                        break;
                    case 15:
                        if ((i & i2) == 0) {
                            break;
                        }
                        i7 += zzbav.h(i8, unsafe2.getInt(t, j2));
                        break;
                    case 16:
                        if ((i & i2) == 0) {
                            break;
                        }
                        i7 += zzbav.f(i8, unsafe2.getLong(t, j2));
                        break;
                    case 17:
                        if ((i & i2) == 0) {
                            break;
                        }
                        i7 += zzbav.c(i8, (zzbcu) unsafe2.getObject(t, j2), a(i3));
                        break;
                    case 18:
                        i7 += zq.i(i8, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 19:
                        i7 += zq.h(i8, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 20:
                        i7 += zq.a(i8, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 21:
                        i7 += zq.b(i8, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 22:
                        i7 += zq.e(i8, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 23:
                        i7 += zq.i(i8, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 24:
                        i7 += zq.h(i8, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 25:
                        i7 += zq.j(i8, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 26:
                        i7 += zq.a(i8, (List) unsafe2.getObject(t, j2));
                        break;
                    case 27:
                        i7 += zq.a(i8, (List) unsafe2.getObject(t, j2), a(i3));
                        break;
                    case 28:
                        i7 += zq.b(i8, (List) unsafe2.getObject(t, j2));
                        break;
                    case 29:
                        i7 += zq.f(i8, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 30:
                        i7 += zq.d(i8, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 31:
                        i7 += zq.h(i8, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 32:
                        i7 += zq.i(i8, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 33:
                        i7 += zq.g(i8, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 34:
                        i7 += zq.c(i8, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 35:
                        i = zq.i((List) unsafe2.getObject(t, j2));
                        if (i > 0) {
                            if (this.k) {
                                unsafe2.putInt(t, (long) i4, i);
                            }
                            i7 += i + (zzbav.e(i8) + zzbav.g(i));
                            break;
                        }
                        break;
                    case 36:
                        i = zq.h((List) unsafe2.getObject(t, j2));
                        if (i > 0) {
                            if (this.k) {
                                unsafe2.putInt(t, (long) i4, i);
                            }
                            i7 += i + (zzbav.e(i8) + zzbav.g(i));
                            break;
                        }
                        break;
                    case 37:
                        i = zq.a((List) unsafe2.getObject(t, j2));
                        if (i > 0) {
                            if (this.k) {
                                unsafe2.putInt(t, (long) i4, i);
                            }
                            i7 += i + (zzbav.e(i8) + zzbav.g(i));
                            break;
                        }
                        break;
                    case 38:
                        i = zq.b((List) unsafe2.getObject(t, j2));
                        if (i > 0) {
                            if (this.k) {
                                unsafe2.putInt(t, (long) i4, i);
                            }
                            i7 += i + (zzbav.e(i8) + zzbav.g(i));
                            break;
                        }
                        break;
                    case 39:
                        i = zq.e((List) unsafe2.getObject(t, j2));
                        if (i > 0) {
                            if (this.k) {
                                unsafe2.putInt(t, (long) i4, i);
                            }
                            i7 += i + (zzbav.e(i8) + zzbav.g(i));
                            break;
                        }
                        break;
                    case 40:
                        i = zq.i((List) unsafe2.getObject(t, j2));
                        if (i > 0) {
                            if (this.k) {
                                unsafe2.putInt(t, (long) i4, i);
                            }
                            i7 += i + (zzbav.e(i8) + zzbav.g(i));
                            break;
                        }
                        break;
                    case 41:
                        i = zq.h((List) unsafe2.getObject(t, j2));
                        if (i > 0) {
                            if (this.k) {
                                unsafe2.putInt(t, (long) i4, i);
                            }
                            i7 += i + (zzbav.e(i8) + zzbav.g(i));
                            break;
                        }
                        break;
                    case 42:
                        i = zq.j((List) unsafe2.getObject(t, j2));
                        if (i > 0) {
                            if (this.k) {
                                unsafe2.putInt(t, (long) i4, i);
                            }
                            i7 += i + (zzbav.e(i8) + zzbav.g(i));
                            break;
                        }
                        break;
                    case 43:
                        i = zq.f((List) unsafe2.getObject(t, j2));
                        if (i > 0) {
                            if (this.k) {
                                unsafe2.putInt(t, (long) i4, i);
                            }
                            i7 += i + (zzbav.e(i8) + zzbav.g(i));
                            break;
                        }
                        break;
                    case 44:
                        i = zq.d((List) unsafe2.getObject(t, j2));
                        if (i > 0) {
                            if (this.k) {
                                unsafe2.putInt(t, (long) i4, i);
                            }
                            i7 += i + (zzbav.e(i8) + zzbav.g(i));
                            break;
                        }
                        break;
                    case 45:
                        i = zq.h((List) unsafe2.getObject(t, j2));
                        if (i > 0) {
                            if (this.k) {
                                unsafe2.putInt(t, (long) i4, i);
                            }
                            i7 += i + (zzbav.e(i8) + zzbav.g(i));
                            break;
                        }
                        break;
                    case 46:
                        i = zq.i((List) unsafe2.getObject(t, j2));
                        if (i > 0) {
                            if (this.k) {
                                unsafe2.putInt(t, (long) i4, i);
                            }
                            i7 += i + (zzbav.e(i8) + zzbav.g(i));
                            break;
                        }
                        break;
                    case 47:
                        i = zq.g((List) unsafe2.getObject(t, j2));
                        if (i > 0) {
                            if (this.k) {
                                unsafe2.putInt(t, (long) i4, i);
                            }
                            i7 += i + (zzbav.e(i8) + zzbav.g(i));
                            break;
                        }
                        break;
                    case 48:
                        i = zq.c((List) unsafe2.getObject(t, j2));
                        if (i > 0) {
                            if (this.k) {
                                unsafe2.putInt(t, (long) i4, i);
                            }
                            i7 += i + (zzbav.e(i8) + zzbav.g(i));
                            break;
                        }
                        break;
                    case 49:
                        i7 += zq.b(i8, (List) unsafe2.getObject(t, j2), a(i3));
                        break;
                    case 50:
                        i7 += this.s.zzb(i8, unsafe2.getObject(t, j2), b(i3));
                        break;
                    case 51:
                        if (!a((Object) t, i8, i3)) {
                            break;
                        }
                        i7 += zzbav.b(i8, 0.0d);
                        break;
                    case 52:
                        if (!a((Object) t, i8, i3)) {
                            break;
                        }
                        i7 += zzbav.b(i8, 0.0f);
                        break;
                    case 53:
                        if (!a((Object) t, i8, i3)) {
                            break;
                        }
                        i7 += zzbav.d(i8, e(t, j2));
                        break;
                    case 54:
                        if (!a((Object) t, i8, i3)) {
                            break;
                        }
                        i7 += zzbav.e(i8, e(t, j2));
                        break;
                    case 55:
                        if (!a((Object) t, i8, i3)) {
                            break;
                        }
                        i7 += zzbav.f(i8, d(t, j2));
                        break;
                    case 56:
                        if (!a((Object) t, i8, i3)) {
                            break;
                        }
                        i7 += zzbav.g(i8, 0);
                        break;
                    case 57:
                        if (!a((Object) t, i8, i3)) {
                            break;
                        }
                        i7 += zzbav.i(i8, 0);
                        break;
                    case 58:
                        if (!a((Object) t, i8, i3)) {
                            break;
                        }
                        i7 += zzbav.b(i8, true);
                        break;
                    case 59:
                        if (!a((Object) t, i8, i3)) {
                            break;
                        }
                        f = unsafe2.getObject(t, j2);
                        if (!(f instanceof zzbah)) {
                            i7 += zzbav.b(i8, (String) f);
                            break;
                        }
                        i7 += zzbav.c(i8, (zzbah) f);
                        break;
                    case 60:
                        if (!a((Object) t, i8, i3)) {
                            break;
                        }
                        i7 += zq.a(i8, unsafe2.getObject(t, j2), a(i3));
                        break;
                    case 61:
                        if (!a((Object) t, i8, i3)) {
                            break;
                        }
                        i7 += zzbav.c(i8, (zzbah) unsafe2.getObject(t, j2));
                        break;
                    case 62:
                        if (!a((Object) t, i8, i3)) {
                            break;
                        }
                        i7 += zzbav.g(i8, d(t, j2));
                        break;
                    case 63:
                        if (!a((Object) t, i8, i3)) {
                            break;
                        }
                        i7 += zzbav.k(i8, d(t, j2));
                        break;
                    case 64:
                        if (!a((Object) t, i8, i3)) {
                            break;
                        }
                        i7 += zzbav.j(i8, 0);
                        break;
                    case 65:
                        if (!a((Object) t, i8, i3)) {
                            break;
                        }
                        i7 += zzbav.h(i8, 0);
                        break;
                    case 66:
                        if (!a((Object) t, i8, i3)) {
                            break;
                        }
                        i7 += zzbav.h(i8, d(t, j2));
                        break;
                    case 67:
                        if (!a((Object) t, i8, i3)) {
                            break;
                        }
                        i7 += zzbav.f(i8, e(t, j2));
                        break;
                    case 68:
                        if (!a((Object) t, i8, i3)) {
                            break;
                        }
                        i7 += zzbav.c(i8, (zzbcu) unsafe2.getObject(t, j2), a(i3));
                        break;
                    default:
                        break;
                }
                i3 += 4;
                i = i2;
                i2 = i6;
            }
            i = a(this.q, (Object) t) + i7;
            return this.h ? i + this.r.a((Object) t).h() : i;
        }
    }
}
