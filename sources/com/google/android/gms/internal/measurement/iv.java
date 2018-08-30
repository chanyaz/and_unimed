package com.google.android.gms.internal.measurement;

public final class iv extends j<iv> {
    public long[] c;
    public long[] d;

    public iv() {
        this.c = s.b;
        this.d = s.b;
        this.a = null;
        this.b = -1;
    }

    protected final int a() {
        int i;
        int i2;
        int i3 = 0;
        int a = super.a();
        if (this.c == null || this.c.length <= 0) {
            i = a;
        } else {
            i2 = 0;
            for (long a2 : this.c) {
                i2 += i.a(a2);
            }
            i = (a + i2) + (this.c.length * 1);
        }
        if (this.d == null || this.d.length <= 0) {
            return i;
        }
        i2 = 0;
        while (i3 < this.d.length) {
            i2 += i.a(this.d[i3]);
            i3++;
        }
        return (i + i2) + (this.d.length * 1);
    }

    public final void a(i iVar) {
        int i = 0;
        if (this.c != null && this.c.length > 0) {
            for (long a : this.c) {
                iVar.a(1, a);
            }
        }
        if (this.d != null && this.d.length > 0) {
            while (i < this.d.length) {
                iVar.a(2, this.d[i]);
                i++;
            }
        }
        super.a(iVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof iv)) {
            return false;
        }
        iv ivVar = (iv) obj;
        return !o.a(this.c, ivVar.c) ? false : !o.a(this.d, ivVar.d) ? false : (this.a == null || this.a.b()) ? ivVar.a == null || ivVar.a.b() : this.a.equals(ivVar.a);
    }

    public final int hashCode() {
        int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + o.a(this.c)) * 31) + o.a(this.d)) * 31;
        int hashCode2 = (this.a == null || this.a.b()) ? 0 : this.a.hashCode();
        return hashCode2 + hashCode;
    }
}
