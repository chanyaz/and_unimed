package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;

class xe extends xd {
    protected final byte[] b;

    xe(byte[] bArr) {
        this.b = bArr;
    }

    public byte a(int i) {
        return this.b[i];
    }

    public int a() {
        return this.b.length;
    }

    protected final int a(int i, int i2, int i3) {
        return yk.a(i, this.b, g(), i3);
    }

    public final zzbah a(int i, int i2) {
        int b = zzbah.b(0, i2, a());
        return b == 0 ? zzbah.a : new xb(this.b, g(), b);
    }

    protected final String a(Charset charset) {
        return new String(this.b, g(), a(), charset);
    }

    final void a(wy wyVar) {
        wyVar.a(this.b, g(), a());
    }

    protected void a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.b, 0, bArr, 0, i3);
    }

    final boolean a(zzbah zzbah, int i, int i2) {
        if (i2 > zzbah.a()) {
            throw new IllegalArgumentException("Length too large: " + i2 + a());
        } else if (i2 > zzbah.a()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + i2 + ", " + zzbah.a());
        } else if (!(zzbah instanceof xe)) {
            return zzbah.a(0, i2).equals(a(0, i2));
        } else {
            xe xeVar = (xe) zzbah;
            byte[] bArr = this.b;
            byte[] bArr2 = xeVar.b;
            int g = g() + i2;
            int g2 = g();
            int g3 = xeVar.g();
            while (g2 < g) {
                if (bArr[g2] != bArr2[g3]) {
                    return false;
                }
                g2++;
                g3++;
            }
            return true;
        }
    }

    public final boolean d() {
        int g = g();
        return aar.a(this.b, g, a() + g);
    }

    public final xg e() {
        return xg.a(this.b, g(), a(), true);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbah)) {
            return false;
        }
        if (a() != ((zzbah) obj).a()) {
            return false;
        }
        if (a() == 0) {
            return true;
        }
        if (!(obj instanceof xe)) {
            return obj.equals(this);
        }
        xe xeVar = (xe) obj;
        int f = f();
        int f2 = xeVar.f();
        return (f == 0 || f2 == 0 || f == f2) ? a((xe) obj, 0, a()) : false;
    }

    protected int g() {
        return 0;
    }
}
