package com.google.android.gms.internal.measurement;

public final class m implements Cloneable {
    private static final n a = new n();
    private boolean b;
    private int[] c;
    private n[] d;
    private int e;

    m() {
        this(10);
    }

    private m(int i) {
        this.b = false;
        int c = c(i);
        this.c = new int[c];
        this.d = new n[c];
        this.e = 0;
    }

    private static int c(int i) {
        int i2 = i << 2;
        for (int i3 = 4; i3 < 32; i3++) {
            if (i2 <= (1 << i3) - 12) {
                i2 = (1 << i3) - 12;
                break;
            }
        }
        return i2 / 4;
    }

    private final int d(int i) {
        int i2 = 0;
        int i3 = this.e - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.c[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    final int a() {
        return this.e;
    }

    final n a(int i) {
        int d = d(i);
        return (d < 0 || this.d[d] == a) ? null : this.d[d];
    }

    final void a(int i, n nVar) {
        int d = d(i);
        if (d >= 0) {
            this.d[d] = nVar;
            return;
        }
        d ^= -1;
        if (d >= this.e || this.d[d] != a) {
            if (this.e >= this.c.length) {
                int c = c(this.e + 1);
                Object obj = new int[c];
                Object obj2 = new n[c];
                System.arraycopy(this.c, 0, obj, 0, this.c.length);
                System.arraycopy(this.d, 0, obj2, 0, this.d.length);
                this.c = obj;
                this.d = obj2;
            }
            if (this.e - d != 0) {
                System.arraycopy(this.c, d, this.c, d + 1, this.e - d);
                System.arraycopy(this.d, d, this.d, d + 1, this.e - d);
            }
            this.c[d] = i;
            this.d[d] = nVar;
            this.e++;
            return;
        }
        this.c[d] = i;
        this.d[d] = nVar;
    }

    final n b(int i) {
        return this.d[i];
    }

    public final boolean b() {
        return this.e == 0;
    }

    public final /* synthetic */ Object clone() {
        int i = this.e;
        m mVar = new m(i);
        System.arraycopy(this.c, 0, mVar.c, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            if (this.d[i2] != null) {
                mVar.d[i2] = (n) this.d[i2].clone();
            }
        }
        mVar.e = i;
        return mVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (this.e != mVar.e) {
            return false;
        }
        int i;
        boolean z;
        int[] iArr = this.c;
        int[] iArr2 = mVar.c;
        int i2 = this.e;
        for (i = 0; i < i2; i++) {
            if (iArr[i] != iArr2[i]) {
                z = false;
                break;
            }
        }
        z = true;
        if (z) {
            n[] nVarArr = this.d;
            n[] nVarArr2 = mVar.d;
            i2 = this.e;
            for (i = 0; i < i2; i++) {
                if (!nVarArr[i].equals(nVarArr2[i])) {
                    z = false;
                    break;
                }
            }
            z = true;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.e; i2++) {
            i = (((i * 31) + this.c[i2]) * 31) + this.d[i2].hashCode();
        }
        return i;
    }
}
