package com.google.android.gms.internal.measurement;

class kb extends ka {
    protected final byte[] b;

    kb(byte[] bArr) {
        this.b = bArr;
    }

    public byte a(int i) {
        return this.b[i];
    }

    public int a() {
        return this.b.length;
    }

    protected final int a(int i, int i2, int i3) {
        return kg.a(i, this.b, c(), i3);
    }

    public final zzyw a(int i, int i2) {
        int b = zzyw.b(0, i2, a());
        return b == 0 ? zzyw.a : new jy(this.b, c(), b);
    }

    final boolean a(zzyw zzyw, int i, int i2) {
        if (i2 > zzyw.a()) {
            throw new IllegalArgumentException("Length too large: " + i2 + a());
        } else if (i2 > zzyw.a()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + i2 + ", " + zzyw.a());
        } else if (!(zzyw instanceof kb)) {
            return zzyw.a(0, i2).equals(a(0, i2));
        } else {
            kb kbVar = (kb) zzyw;
            byte[] bArr = this.b;
            byte[] bArr2 = kbVar.b;
            int c = c() + i2;
            int c2 = c();
            int c3 = kbVar.c();
            while (c2 < c) {
                if (bArr[c2] != bArr2[c3]) {
                    return false;
                }
                c2++;
                c3++;
            }
            return true;
        }
    }

    protected int c() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzyw)) {
            return false;
        }
        if (a() != ((zzyw) obj).a()) {
            return false;
        }
        if (a() == 0) {
            return true;
        }
        if (!(obj instanceof kb)) {
            return obj.equals(this);
        }
        kb kbVar = (kb) obj;
        int b = b();
        int b2 = kbVar.b();
        return (b == 0 || b2 == 0 || b == b2) ? a((kb) obj, 0, a()) : false;
    }
}
