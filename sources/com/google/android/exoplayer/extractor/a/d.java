package com.google.android.exoplayer.extractor.a;

import android.util.Pair;
import com.google.android.exoplayer.k;
import com.google.android.exoplayer.util.a;
import com.google.android.exoplayer.util.b;
import com.google.android.exoplayer.util.c;
import com.google.android.exoplayer.util.g;
import com.google.android.exoplayer.util.i;
import com.google.android.exoplayer.util.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class d {
    private d() {
    }

    private static long a(i iVar) {
        int i = 8;
        iVar.b(8);
        if (a.a(iVar.j()) != 0) {
            i = 16;
        }
        iVar.c(i);
        return iVar.i();
    }

    private static Pair<List<byte[]>, Integer> a(i iVar, int i) {
        int i2 = 0;
        iVar.b((i + 8) + 4);
        int f = (iVar.f() & 3) + 1;
        if (f == 3) {
            throw new IllegalStateException();
        }
        int i3;
        List arrayList = new ArrayList();
        int f2 = iVar.f() & 31;
        for (i3 = 0; i3 < f2; i3++) {
            arrayList.add(g.a(iVar));
        }
        i3 = iVar.f();
        while (i2 < i3) {
            arrayList.add(g.a(iVar));
            i2++;
        }
        return Pair.create(arrayList, Integer.valueOf(f));
    }

    private static e a(i iVar, long j) {
        iVar.b(12);
        int j2 = iVar.j();
        e eVar = new e(j2);
        for (int i = 0; i < j2; i++) {
            int d = iVar.d();
            int j3 = iVar.j();
            b.a(j3 > 0, "childAtomSize should be positive");
            int j4 = iVar.j();
            if (j4 == a.b || j4 == a.c || j4 == a.N || j4 == a.X || j4 == a.d || j4 == a.e || j4 == a.f) {
                a(iVar, d, j3, j, eVar, i);
            } else if (j4 == a.i || j4 == a.O || j4 == a.j) {
                a(iVar, j4, d, j3, j, eVar, i);
            } else if (j4 == a.U) {
                eVar.b = k.a("application/ttml+xml", j);
            } else if (j4 == a.af) {
                eVar.b = k.a("application/x-quicktime-tx3g", j);
            }
            iVar.b(d + j3);
        }
        return eVar;
    }

    public static l a(b bVar, c cVar) {
        long j = -1;
        b e = bVar.e(a.v);
        int c = c(e.d(a.G).ah);
        if (c != l.b && c != l.a && c != l.c && c != l.d) {
            return null;
        }
        l lVar;
        Pair b = b(bVar.d(a.E).ah);
        int intValue = ((Integer) b.first).intValue();
        long longValue = ((Long) b.second).longValue();
        long a = a(cVar.ah);
        if (longValue != -1) {
            j = m.a(longValue, 1000000, a);
        }
        b e2 = e.e(a.w).e(a.x);
        a = d(e.d(a.F).ah);
        e a2 = a(e2.d(a.H).ah, j);
        if (a2.b == null) {
            lVar = null;
        } else {
            lVar = new l(intValue, c, a, j, a2.b, a2.a, a2.c);
        }
        return lVar;
    }

    private static m a(i iVar, int i, int i2) {
        int i3 = i + 8;
        m mVar = null;
        while (i3 - i < i2) {
            iVar.b(i3);
            int j = iVar.j();
            int j2 = iVar.j();
            if (j2 == a.P) {
                iVar.j();
            } else if (j2 == a.K) {
                iVar.c(4);
                iVar.j();
                iVar.j();
            } else if (j2 == a.L) {
                mVar = b(iVar, i3, j);
            }
            i3 += j;
        }
        return mVar;
    }

    public static o a(l lVar, b bVar) {
        i iVar = bVar.d(a.ac).ah;
        c d = bVar.d(a.ad);
        if (d == null) {
            d = bVar.d(a.ae);
        }
        i iVar2 = d.ah;
        i iVar3 = bVar.d(a.ab).ah;
        i iVar4 = bVar.d(a.Y).ah;
        c d2 = bVar.d(a.Z);
        i iVar5 = d2 != null ? d2.ah : null;
        c d3 = bVar.d(a.aa);
        i iVar6 = d3 != null ? d3.ah : null;
        iVar.b(12);
        int m = iVar.m();
        int m2 = iVar.m();
        long[] jArr = new long[m2];
        int[] iArr = new int[m2];
        long[] jArr2 = new long[m2];
        int[] iArr2 = new int[m2];
        if (m2 == 0) {
            return new o(jArr, iArr, jArr2, iArr2);
        }
        iVar2.b(12);
        int m3 = iVar2.m();
        iVar3.b(12);
        int m4 = iVar3.m() - 1;
        b.b(iVar3.j() == 1, "stsc first chunk must be 1");
        int m5 = iVar3.m();
        iVar3.c(4);
        int i = -1;
        if (m4 > 0) {
            i = iVar3.m() - 1;
        }
        iVar4.b(12);
        int m6 = iVar4.m() - 1;
        int m7 = iVar4.m();
        int m8 = iVar4.m();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        if (iVar6 != null) {
            iVar6.b(12);
            i3 = iVar6.m() - 1;
            i2 = iVar6.m();
            i4 = iVar6.j();
        }
        int i5 = -1;
        int i6 = 0;
        if (iVar5 != null) {
            iVar5.b(12);
            i6 = iVar5.m();
            i5 = iVar5.m() - 1;
        }
        long j = 0;
        int i7 = m7;
        int i8 = m5;
        m7 = i6;
        int i9 = m5;
        int i10 = m4;
        m4 = 0;
        int i11 = i;
        int i12 = m8;
        m8 = m6;
        m6 = i5;
        long i13 = d.ag == a.ad ? iVar2.i() : iVar2.n();
        int i14 = 0;
        int i15 = i4;
        i4 = i3;
        i3 = i2;
        i2 = i12;
        while (m4 < m2) {
            int m9;
            jArr[m4] = i13;
            iArr[m4] = m == 0 ? iVar.m() : m;
            jArr2[m4] = ((long) i15) + j;
            iArr2[m4] = iVar5 == null ? 1 : 0;
            if (m4 == m6) {
                iArr2[m4] = 1;
                i = m7 - 1;
                if (i > 0) {
                    m5 = i;
                    m9 = iVar5.m() - 1;
                } else {
                    m5 = i;
                    m9 = m6;
                }
            } else {
                m5 = m7;
                m9 = m6;
            }
            j += (long) i2;
            i = i7 - 1;
            if (i != 0 || m8 <= 0) {
                m7 = i;
                m6 = m8;
                m8 = i2;
            } else {
                m7 = iVar4.m();
                m6 = m8 - 1;
                m8 = iVar4.m();
            }
            if (iVar6 != null) {
                i = i3 - 1;
                if (i != 0 || i4 <= 0) {
                    i3 = i4;
                    i2 = i;
                    i4 = i15;
                } else {
                    i3 = iVar6.m();
                    i15 = i4 - 1;
                    i4 = iVar6.j();
                    i2 = i3;
                    i3 = i15;
                }
            } else {
                i2 = i3;
                i3 = i4;
                i4 = i15;
            }
            i15 = i8 - 1;
            if (i15 == 0) {
                i14++;
                if (i14 < m3) {
                    i13 = d.ag == a.ad ? iVar2.i() : iVar2.n();
                }
                if (i14 == i11) {
                    i = iVar3.m();
                    iVar3.c(4);
                    i9 = i10 - 1;
                    if (i9 > 0) {
                        i11 = iVar3.m() - 1;
                    }
                } else {
                    i = i9;
                    i9 = i10;
                }
                if (i14 < m3) {
                    i15 = i14;
                    i14 = i11;
                    i11 = i;
                } else {
                    i12 = i15;
                    i15 = i14;
                    i14 = i11;
                    i11 = i;
                    i = i12;
                }
            } else {
                i13 += (long) iArr[m4];
                i = i15;
                i15 = i14;
                i14 = i11;
                i11 = i9;
                i9 = i10;
            }
            m4++;
            i7 = m7;
            i8 = i;
            m7 = m5;
            i10 = i9;
            i9 = i11;
            i11 = i14;
            i14 = i15;
            i15 = i4;
            i4 = i3;
            i3 = i2;
            i2 = m8;
            m8 = m6;
            m6 = m9;
        }
        m.a(jArr2, 1000000, lVar.g);
        b.a(m7 == 0);
        b.a(i7 == 0);
        b.a(i8 == 0);
        b.a(m8 == 0);
        b.a(i4 == 0);
        return new o(jArr, iArr, jArr2, iArr2);
    }

    private static void a(i iVar, int i, int i2, int i3, long j, e eVar, int i4) {
        iVar.b(i2 + 8);
        iVar.c(16);
        int g = iVar.g();
        int g2 = iVar.g();
        iVar.c(4);
        int l = iVar.l();
        String str = null;
        if (i == a.j) {
            str = "audio/ac3";
        } else if (i == a.l) {
            str = "audio/eac3";
        }
        Object obj = null;
        int d = iVar.d();
        while (true) {
            int i5 = d;
            if (i5 - i2 < i3) {
                iVar.b(i5);
                int d2 = iVar.d();
                int j2 = iVar.j();
                b.a(j2 > 0, "childAtomSize should be positive");
                d = iVar.j();
                if (i == a.i || i == a.O) {
                    if (d == a.A) {
                        Pair d3 = d(iVar, d2);
                        String str2 = (String) d3.first;
                        obj = (byte[]) d3.second;
                        if ("audio/mp4a-latm".equals(str2)) {
                            Pair a = c.a(obj);
                            l = ((Integer) a.first).intValue();
                            g = ((Integer) a.second).intValue();
                        }
                        str = str2;
                    } else if (d == a.J) {
                        eVar.a[i4] = a(iVar, d2, j2);
                    }
                } else if (i == a.j && d == a.k) {
                    iVar.b(d2 + 8);
                    eVar.b = a.a(iVar);
                    return;
                } else if (i == a.l && d == a.m) {
                    iVar.b(d2 + 8);
                    eVar.b = a.b(iVar);
                    return;
                }
                d = i5 + j2;
            } else if (str != null) {
                eVar.b = k.b(str, g2, j, g, l, obj == null ? null : Collections.singletonList(obj));
                return;
            } else {
                return;
            }
        }
    }

    private static void a(i iVar, int i, int i2, long j, e eVar, int i3) {
        iVar.b(i + 8);
        iVar.c(24);
        int g = iVar.g();
        int g2 = iVar.g();
        float f = 1.0f;
        iVar.c(50);
        List list = null;
        int d = iVar.d();
        String str = null;
        while (true) {
            int i4 = d;
            if (i4 - i >= i2) {
                break;
            }
            iVar.b(i4);
            int d2 = iVar.d();
            int j2 = iVar.j();
            if (j2 == 0 && iVar.d() - i == i2) {
                break;
            }
            b.a(j2 > 0, "childAtomSize should be positive");
            d = iVar.j();
            Pair a;
            List list2;
            if (d == a.y) {
                b.b(str == null);
                a = a(iVar, d2);
                list2 = (List) a.first;
                eVar.c = ((Integer) a.second).intValue();
                str = "video/avc";
                list = list2;
            } else if (d == a.z) {
                b.b(str == null);
                a = b(iVar, d2);
                list2 = (List) a.first;
                eVar.c = ((Integer) a.second).intValue();
                str = "video/hevc";
                list = list2;
            } else if (d == a.g) {
                b.b(str == null);
                str = "video/3gpp";
            } else if (d == a.A) {
                b.b(str == null);
                Pair d3 = d(iVar, d2);
                str = (String) d3.first;
                list = Collections.singletonList(d3.second);
            } else if (d == a.J) {
                eVar.a[i3] = a(iVar, d2, j2);
            } else if (d == a.T) {
                f = c(iVar, d2);
            }
            d = i4 + j2;
        }
        if (str != null) {
            eVar.b = k.a(str, -1, j, g, g2, f, list);
        }
    }

    private static Pair<Integer, Long> b(i iVar) {
        long j;
        int i = 8;
        iVar.b(8);
        int a = a.a(iVar.j());
        iVar.c(a == 0 ? 8 : 16);
        int j2 = iVar.j();
        iVar.c(4);
        Object obj = 1;
        int d = iVar.d();
        if (a == 0) {
            i = 4;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (iVar.a[d + i2] != (byte) -1) {
                obj = null;
                break;
            }
        }
        if (obj != null) {
            iVar.c(i);
            j = -1;
        } else {
            j = a == 0 ? iVar.i() : iVar.n();
        }
        return Pair.create(Integer.valueOf(j2), Long.valueOf(j));
    }

    private static Pair<List<byte[]>, Integer> b(i iVar, int i) {
        int g;
        int i2;
        int i3;
        iVar.b((i + 8) + 21);
        int f = iVar.f() & 3;
        int f2 = iVar.f();
        int d = iVar.d();
        int i4 = 0;
        int i5 = 0;
        while (i4 < f2) {
            iVar.c(1);
            g = iVar.g();
            i2 = i5;
            for (i3 = 0; i3 < g; i3++) {
                i5 = iVar.g();
                i2 += i5 + 4;
                iVar.c(i5);
            }
            i4++;
            i5 = i2;
        }
        iVar.b(d);
        Object obj = new byte[i5];
        i4 = 0;
        i3 = 0;
        while (i4 < f2) {
            iVar.c(1);
            g = iVar.g();
            i2 = i3;
            for (i3 = 0; i3 < g; i3++) {
                int g2 = iVar.g();
                System.arraycopy(g.a, 0, obj, i2, g.a.length);
                i2 += g.a.length;
                System.arraycopy(iVar.a, iVar.d(), obj, i2, g2);
                i2 += g2;
                iVar.c(g2);
            }
            i4++;
            i3 = i2;
        }
        return Pair.create(i5 == 0 ? null : Collections.singletonList(obj), Integer.valueOf(f + 1));
    }

    private static m b(i iVar, int i, int i2) {
        boolean z = true;
        int i3 = i + 8;
        while (i3 - i < i2) {
            iVar.b(i3);
            int j = iVar.j();
            if (iVar.j() == a.M) {
                iVar.c(4);
                i3 = iVar.j();
                if ((i3 >> 8) != 1) {
                    z = false;
                }
                i3 &= 255;
                byte[] bArr = new byte[16];
                iVar.a(bArr, 0, bArr.length);
                return new m(z, i3, bArr);
            }
            i3 += j;
        }
        return null;
    }

    private static float c(i iVar, int i) {
        iVar.b(i + 8);
        return ((float) iVar.m()) / ((float) iVar.m());
    }

    private static int c(i iVar) {
        iVar.b(16);
        return iVar.j();
    }

    private static long d(i iVar) {
        int i = 8;
        iVar.b(8);
        if (a.a(iVar.j()) != 0) {
            i = 16;
        }
        iVar.c(i);
        return iVar.i();
    }

    private static Pair<String, byte[]> d(i iVar, int i) {
        Object obj = null;
        iVar.b((i + 8) + 4);
        iVar.c(1);
        int f = iVar.f();
        while (f > 127) {
            f = iVar.f();
        }
        iVar.c(2);
        f = iVar.f();
        if ((f & 128) != 0) {
            iVar.c(2);
        }
        if ((f & 64) != 0) {
            iVar.c(iVar.g());
        }
        if ((f & 32) != 0) {
            iVar.c(2);
        }
        iVar.c(1);
        f = iVar.f();
        while (f > 127) {
            f = iVar.f();
        }
        switch (iVar.f()) {
            case 32:
                obj = "video/mp4v-es";
                break;
            case 33:
                obj = "video/avc";
                break;
            case 35:
                obj = "video/hevc";
                break;
            case 64:
                obj = "audio/mp4a-latm";
                break;
            case 107:
                return Pair.create("audio/mpeg", null);
            case 165:
                obj = "audio/ac3";
                break;
            case 166:
                obj = "audio/eac3";
                break;
        }
        iVar.c(12);
        iVar.c(1);
        int f2 = iVar.f();
        f = f2 & 127;
        while (f2 > 127) {
            f2 = iVar.f();
            f = (f << 8) | (f2 & 127);
        }
        Object obj2 = new byte[f];
        iVar.a(obj2, 0, f);
        return Pair.create(obj, obj2);
    }
}
