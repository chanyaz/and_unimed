package com.google.android.gms.internal.measurement;

public final class ir extends j<ir> {
    private static volatile ir[] h;
    public is[] c;
    public String d;
    public Long e;
    public Long f;
    public Integer g;

    public ir() {
        this.c = is.e();
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.a = null;
        this.b = -1;
    }

    public static ir[] e() {
        if (h == null) {
            synchronized (o.b) {
                if (h == null) {
                    h = new ir[0];
                }
            }
        }
        return h;
    }

    protected final int a() {
        int a = super.a();
        if (this.c != null && this.c.length > 0) {
            for (p pVar : this.c) {
                if (pVar != null) {
                    a += i.b(1, pVar);
                }
            }
        }
        if (this.d != null) {
            a += i.b(2, this.d);
        }
        if (this.e != null) {
            a += i.c(3, this.e.longValue());
        }
        if (this.f != null) {
            a += i.c(4, this.f.longValue());
        }
        return this.g != null ? a + i.b(5, this.g.intValue()) : a;
    }

    public final void a(i iVar) {
        if (this.c != null && this.c.length > 0) {
            for (p pVar : this.c) {
                if (pVar != null) {
                    iVar.a(1, pVar);
                }
            }
        }
        if (this.d != null) {
            iVar.a(2, this.d);
        }
        if (this.e != null) {
            iVar.b(3, this.e.longValue());
        }
        if (this.f != null) {
            iVar.b(4, this.f.longValue());
        }
        if (this.g != null) {
            iVar.a(5, this.g.intValue());
        }
        super.a(iVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ir)) {
            return false;
        }
        ir irVar = (ir) obj;
        if (!o.a(this.c, irVar.c)) {
            return false;
        }
        if (this.d == null) {
            if (irVar.d != null) {
                return false;
            }
        } else if (!this.d.equals(irVar.d)) {
            return false;
        }
        if (this.e == null) {
            if (irVar.e != null) {
                return false;
            }
        } else if (!this.e.equals(irVar.e)) {
            return false;
        }
        if (this.f == null) {
            if (irVar.f != null) {
                return false;
            }
        } else if (!this.f.equals(irVar.f)) {
            return false;
        }
        if (this.g == null) {
            if (irVar.g != null) {
                return false;
            }
        } else if (!this.g.equals(irVar.g)) {
            return false;
        }
        return (this.a == null || this.a.b()) ? irVar.a == null || irVar.a.b() : this.a.equals(irVar.a);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.g == null ? 0 : this.g.hashCode()) + (((this.f == null ? 0 : this.f.hashCode()) + (((this.e == null ? 0 : this.e.hashCode()) + (((this.d == null ? 0 : this.d.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + o.a(this.c)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (!(this.a == null || this.a.b())) {
            i = this.a.hashCode();
        }
        return hashCode + i;
    }
}
