package com.google.android.gms.internal.ads;

final class wv {
    static int a(int i, byte[] bArr, int i2, int i3, aag aag, ww wwVar) {
        if ((i >>> 3) == 0) {
            throw zzbbu.d();
        }
        int b;
        int i4;
        switch (i & 7) {
            case 0:
                b = b(bArr, i2, wwVar);
                aag.a(i, Long.valueOf(wwVar.b));
                return b;
            case 1:
                aag.a(i, Long.valueOf(b(bArr, i2)));
                return i2 + 8;
            case 2:
                b = a(bArr, i2, wwVar);
                i4 = wwVar.a;
                if (i4 == 0) {
                    aag.a(i, zzbah.a);
                } else {
                    aag.a(i, zzbah.a(bArr, b, i4));
                }
                return b + i4;
            case 3:
                Object b2 = aag.b();
                int i5 = (i & -8) | 4;
                b = 0;
                int i6 = i2;
                while (i6 < i3) {
                    i6 = a(bArr, i6, wwVar);
                    b = wwVar.a;
                    if (b != i5) {
                        i6 = a(b, bArr, i6, i3, (aag) b2, wwVar);
                    } else {
                        i4 = b;
                        b = i6;
                        if (b <= i3 || i4 != i5) {
                            throw zzbbu.g();
                        }
                        aag.a(i, b2);
                        return b;
                    }
                }
                i4 = b;
                b = i6;
                if (b <= i3) {
                }
                throw zzbbu.g();
            case 5:
                aag.a(i, Integer.valueOf(a(bArr, i2)));
                return i2 + 4;
            default:
                throw zzbbu.d();
        }
    }

    static int a(int i, byte[] bArr, int i2, int i3, ww wwVar) {
        if ((i >>> 3) == 0) {
            throw zzbbu.d();
        }
        switch (i & 7) {
            case 0:
                return b(bArr, i2, wwVar);
            case 1:
                return i2 + 8;
            case 2:
                return a(bArr, i2, wwVar) + wwVar.a;
            case 3:
                int i4;
                int i5 = (i & -8) | 4;
                int i6 = 0;
                int i7 = i2;
                while (i7 < i3) {
                    i7 = a(bArr, i7, wwVar);
                    i6 = wwVar.a;
                    if (i6 != i5) {
                        i7 = a(i6, bArr, i7, i3, wwVar);
                    } else {
                        i4 = i6;
                        i6 = i7;
                        i7 = i4;
                        if (i6 > i3 && i7 == i5) {
                            return i6;
                        }
                        throw zzbbu.g();
                    }
                }
                i4 = i6;
                i6 = i7;
                i7 = i4;
                if (i6 > i3) {
                }
                throw zzbbu.g();
            case 5:
                return i2 + 4;
            default:
                throw zzbbu.d();
        }
    }

    static int a(int i, byte[] bArr, int i2, int i3, zzbbt<?> zzbbt, ww wwVar) {
        yj yjVar = (yj) zzbbt;
        int a = a(bArr, i2, wwVar);
        yjVar.b(wwVar.a);
        while (a < i3) {
            int a2 = a(bArr, a, wwVar);
            if (i != wwVar.a) {
                break;
            }
            a = a(bArr, a2, wwVar);
            yjVar.b(wwVar.a);
        }
        return a;
    }

    static int a(int i, byte[] bArr, int i2, ww wwVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= (byte) 0) {
            wwVar.a = i3 | (b << 7);
            return i4;
        }
        int i5 = ((b & 127) << 7) | i3;
        i3 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= (byte) 0) {
            wwVar.a = (b2 << 14) | i5;
            return i3;
        }
        i4 = ((b2 & 127) << 14) | i5;
        i5 = i3 + 1;
        byte b3 = bArr[i3];
        if (b3 >= (byte) 0) {
            wwVar.a = i4 | (b3 << 21);
            return i5;
        }
        i3 = ((b3 & 127) << 21) | i4;
        i4 = i5 + 1;
        b = bArr[i5];
        if (b >= (byte) 0) {
            wwVar.a = i3 | (b << 28);
            return i4;
        }
        i5 = ((b & 127) << 28) | i3;
        while (true) {
            i3 = i4 + 1;
            if (bArr[i4] >= (byte) 0) {
                wwVar.a = i5;
                return i3;
            }
            i4 = i3;
        }
    }

    static int a(byte[] bArr, int i) {
        return (((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 2] & 255) << 16)) | ((bArr[i + 3] & 255) << 24);
    }

    static int a(byte[] bArr, int i, ww wwVar) {
        int i2 = i + 1;
        int i3 = bArr[i];
        if (i3 < (byte) 0) {
            return a(i3, bArr, i2, wwVar);
        }
        wwVar.a = i3;
        return i2;
    }

    static int a(byte[] bArr, int i, zzbbt<?> zzbbt, ww wwVar) {
        yj yjVar = (yj) zzbbt;
        int a = a(bArr, i, wwVar);
        int i2 = wwVar.a + a;
        while (a < i2) {
            a = a(bArr, a, wwVar);
            yjVar.b(wwVar.a);
        }
        if (a == i2) {
            return a;
        }
        throw zzbbu.a();
    }

    static int b(byte[] bArr, int i, ww wwVar) {
        int i2 = 7;
        int i3 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            wwVar.b = j;
        } else {
            j &= 127;
            int i4 = i3 + 1;
            byte b = bArr[i3];
            byte b2 = b;
            i3 = i4;
            long j2 = j | (((long) (b & 127)) << 7);
            byte b3 = b2;
            while (b3 < (byte) 0) {
                int i5 = i3 + 1;
                b3 = bArr[i3];
                i3 = i2 + 7;
                j2 |= ((long) (b3 & 127)) << i3;
                i2 = i3;
                i3 = i5;
            }
            wwVar.b = j2;
        }
        return i3;
    }

    static long b(byte[] bArr, int i) {
        return (((((((((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8)) | ((((long) bArr[i + 2]) & 255) << 16)) | ((((long) bArr[i + 3]) & 255) << 24)) | ((((long) bArr[i + 4]) & 255) << 32)) | ((((long) bArr[i + 5]) & 255) << 40)) | ((((long) bArr[i + 6]) & 255) << 48)) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    static double c(byte[] bArr, int i) {
        return Double.longBitsToDouble(b(bArr, i));
    }

    static int c(byte[] bArr, int i, ww wwVar) {
        int a = a(bArr, i, wwVar);
        int i2 = wwVar.a;
        if (i2 == 0) {
            wwVar.c = "";
            return a;
        }
        wwVar.c = new String(bArr, a, i2, yk.a);
        return a + i2;
    }

    static float d(byte[] bArr, int i) {
        return Float.intBitsToFloat(a(bArr, i));
    }

    static int d(byte[] bArr, int i, ww wwVar) {
        int a = a(bArr, i, wwVar);
        int i2 = wwVar.a;
        if (i2 == 0) {
            wwVar.c = "";
            return a;
        } else if (aar.a(bArr, a, a + i2)) {
            wwVar.c = new String(bArr, a, i2, yk.a);
            return a + i2;
        } else {
            throw zzbbu.h();
        }
    }

    static int e(byte[] bArr, int i, ww wwVar) {
        int a = a(bArr, i, wwVar);
        int i2 = wwVar.a;
        if (i2 == 0) {
            wwVar.c = zzbah.a;
            return a;
        }
        wwVar.c = zzbah.a(bArr, a, i2);
        return a + i2;
    }
}
