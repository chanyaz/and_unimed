package com.google.android.gms.internal.measurement;

public final class io extends j<io> {
    public Long c;
    public String d;
    public ip[] e;
    public in[] f;
    public ih[] g;
    private Integer h;

    public io() {
        this.c = null;
        this.d = null;
        this.h = null;
        this.e = ip.e();
        this.f = in.e();
        this.g = ih.e();
        this.a = null;
        this.b = -1;
    }

    protected final int a() {
        int i;
        int i2 = 0;
        int a = super.a();
        if (this.c != null) {
            a += i.c(1, this.c.longValue());
        }
        if (this.d != null) {
            a += i.b(2, this.d);
        }
        if (this.h != null) {
            a += i.b(3, this.h.intValue());
        }
        if (this.e != null && this.e.length > 0) {
            i = a;
            for (p pVar : this.e) {
                if (pVar != null) {
                    i += i.b(4, pVar);
                }
            }
            a = i;
        }
        if (this.f != null && this.f.length > 0) {
            i = a;
            for (p pVar2 : this.f) {
                if (pVar2 != null) {
                    i += i.b(5, pVar2);
                }
            }
            a = i;
        }
        if (this.g != null && this.g.length > 0) {
            while (i2 < this.g.length) {
                p pVar3 = this.g[i2];
                if (pVar3 != null) {
                    a += i.b(6, pVar3);
                }
                i2++;
            }
        }
        return a;
    }

    public final void a(i iVar) {
        int i = 0;
        if (this.c != null) {
            iVar.b(1, this.c.longValue());
        }
        if (this.d != null) {
            iVar.a(2, this.d);
        }
        if (this.h != null) {
            iVar.a(3, this.h.intValue());
        }
        if (this.e != null && this.e.length > 0) {
            for (p pVar : this.e) {
                if (pVar != null) {
                    iVar.a(4, pVar);
                }
            }
        }
        if (this.f != null && this.f.length > 0) {
            for (p pVar2 : this.f) {
                if (pVar2 != null) {
                    iVar.a(5, pVar2);
                }
            }
        }
        if (this.g != null && this.g.length > 0) {
            while (i < this.g.length) {
                p pVar3 = this.g[i];
                if (pVar3 != null) {
                    iVar.a(6, pVar3);
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
        if (!(obj instanceof io)) {
            return false;
        }
        io ioVar = (io) obj;
        if (this.c == null) {
            if (ioVar.c != null) {
                return false;
            }
        } else if (!this.c.equals(ioVar.c)) {
            return false;
        }
        if (this.d == null) {
            if (ioVar.d != null) {
                return false;
            }
        } else if (!this.d.equals(ioVar.d)) {
            return false;
        }
        if (this.h == null) {
            if (ioVar.h != null) {
                return false;
            }
        } else if (!this.h.equals(ioVar.h)) {
            return false;
        }
        return !o.a(this.e, ioVar.e) ? false : !o.a(this.f, ioVar.f) ? false : !o.a(this.g, ioVar.g) ? false : (this.a == null || this.a.b()) ? ioVar.a == null || ioVar.a.b() : this.a.equals(ioVar.a);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((((this.h == null ? 0 : this.h.hashCode()) + (((this.d == null ? 0 : this.d.hashCode()) + (((this.c == null ? 0 : this.c.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31) + o.a(this.e)) * 31) + o.a(this.f)) * 31) + o.a(this.g)) * 31;
        if (!(this.a == null || this.a.b())) {
            i = this.a.hashCode();
        }
        return hashCode + i;
    }
}
