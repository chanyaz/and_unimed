package com.google.android.gms.internal.measurement;

public final class ii extends j<ii> {
    private static volatile ii[] g;
    public Integer c;
    public String d;
    public ij[] e;
    public ik f;
    private Boolean h;

    public ii() {
        this.c = null;
        this.d = null;
        this.e = ij.e();
        this.h = null;
        this.f = null;
        this.a = null;
        this.b = -1;
    }

    public static ii[] e() {
        if (g == null) {
            synchronized (o.b) {
                if (g == null) {
                    g = new ii[0];
                }
            }
        }
        return g;
    }

    protected final int a() {
        int a = super.a();
        if (this.c != null) {
            a += i.b(1, this.c.intValue());
        }
        if (this.d != null) {
            a += i.b(2, this.d);
        }
        if (this.e != null && this.e.length > 0) {
            int i = a;
            for (p pVar : this.e) {
                if (pVar != null) {
                    i += i.b(3, pVar);
                }
            }
            a = i;
        }
        if (this.h != null) {
            this.h.booleanValue();
            a += i.b(4) + 1;
        }
        return this.f != null ? a + i.b(5, this.f) : a;
    }

    public final void a(i iVar) {
        if (this.c != null) {
            iVar.a(1, this.c.intValue());
        }
        if (this.d != null) {
            iVar.a(2, this.d);
        }
        if (this.e != null && this.e.length > 0) {
            for (p pVar : this.e) {
                if (pVar != null) {
                    iVar.a(3, pVar);
                }
            }
        }
        if (this.h != null) {
            iVar.a(4, this.h.booleanValue());
        }
        if (this.f != null) {
            iVar.a(5, this.f);
        }
        super.a(iVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ii)) {
            return false;
        }
        ii iiVar = (ii) obj;
        if (this.c == null) {
            if (iiVar.c != null) {
                return false;
            }
        } else if (!this.c.equals(iiVar.c)) {
            return false;
        }
        if (this.d == null) {
            if (iiVar.d != null) {
                return false;
            }
        } else if (!this.d.equals(iiVar.d)) {
            return false;
        }
        if (!o.a(this.e, iiVar.e)) {
            return false;
        }
        if (this.h == null) {
            if (iiVar.h != null) {
                return false;
            }
        } else if (!this.h.equals(iiVar.h)) {
            return false;
        }
        if (this.f == null) {
            if (iiVar.f != null) {
                return false;
            }
        } else if (!this.f.equals(iiVar.f)) {
            return false;
        }
        return (this.a == null || this.a.b()) ? iiVar.a == null || iiVar.a.b() : this.a.equals(iiVar.a);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (this.h == null ? 0 : this.h.hashCode()) + (((((this.d == null ? 0 : this.d.hashCode()) + (((this.c == null ? 0 : this.c.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + o.a(this.e)) * 31);
        ik ikVar = this.f;
        hashCode = ((ikVar == null ? 0 : ikVar.hashCode()) + (hashCode * 31)) * 31;
        if (!(this.a == null || this.a.b())) {
            i = this.a.hashCode();
        }
        return hashCode + i;
    }
}
