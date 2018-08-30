package com.google.android.gms.internal.measurement;

public final class ih extends j<ih> {
    private static volatile ih[] f;
    public Integer c;
    public il[] d;
    public ii[] e;

    public ih() {
        this.c = null;
        this.d = il.e();
        this.e = ii.e();
        this.a = null;
        this.b = -1;
    }

    public static ih[] e() {
        if (f == null) {
            synchronized (o.b) {
                if (f == null) {
                    f = new ih[0];
                }
            }
        }
        return f;
    }

    protected final int a() {
        int i = 0;
        int a = super.a();
        if (this.c != null) {
            a += i.b(1, this.c.intValue());
        }
        if (this.d != null && this.d.length > 0) {
            int i2 = a;
            for (p pVar : this.d) {
                if (pVar != null) {
                    i2 += i.b(2, pVar);
                }
            }
            a = i2;
        }
        if (this.e != null && this.e.length > 0) {
            while (i < this.e.length) {
                p pVar2 = this.e[i];
                if (pVar2 != null) {
                    a += i.b(3, pVar2);
                }
                i++;
            }
        }
        return a;
    }

    public final void a(i iVar) {
        int i = 0;
        if (this.c != null) {
            iVar.a(1, this.c.intValue());
        }
        if (this.d != null && this.d.length > 0) {
            for (p pVar : this.d) {
                if (pVar != null) {
                    iVar.a(2, pVar);
                }
            }
        }
        if (this.e != null && this.e.length > 0) {
            while (i < this.e.length) {
                p pVar2 = this.e[i];
                if (pVar2 != null) {
                    iVar.a(3, pVar2);
                }
                i++;
            }
        }
        super.a(iVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ih)) {
            return false;
        }
        ih ihVar = (ih) obj;
        if (this.c == null) {
            if (ihVar.c != null) {
                return false;
            }
        } else if (!this.c.equals(ihVar.c)) {
            return false;
        }
        return !o.a(this.d, ihVar.d) ? false : !o.a(this.e, ihVar.e) ? false : (this.a == null || this.a.b()) ? ihVar.a == null || ihVar.a.b() : this.a.equals(ihVar.a);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((this.c == null ? 0 : this.c.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + o.a(this.d)) * 31) + o.a(this.e)) * 31;
        if (!(this.a == null || this.a.b())) {
            i = this.a.hashCode();
        }
        return hashCode + i;
    }
}
