package com.google.android.gms.internal.measurement;

public final class is extends j<is> {
    private static volatile is[] g;
    public String c;
    public String d;
    public Long e;
    public Double f;
    private Float h;

    public is() {
        this.c = null;
        this.d = null;
        this.e = null;
        this.h = null;
        this.f = null;
        this.a = null;
        this.b = -1;
    }

    public static is[] e() {
        if (g == null) {
            synchronized (o.b) {
                if (g == null) {
                    g = new is[0];
                }
            }
        }
        return g;
    }

    protected final int a() {
        int a = super.a();
        if (this.c != null) {
            a += i.b(1, this.c);
        }
        if (this.d != null) {
            a += i.b(2, this.d);
        }
        if (this.e != null) {
            a += i.c(3, this.e.longValue());
        }
        if (this.h != null) {
            this.h.floatValue();
            a += i.b(4) + 4;
        }
        if (this.f == null) {
            return a;
        }
        this.f.doubleValue();
        return a + (i.b(5) + 8);
    }

    public final void a(i iVar) {
        if (this.c != null) {
            iVar.a(1, this.c);
        }
        if (this.d != null) {
            iVar.a(2, this.d);
        }
        if (this.e != null) {
            iVar.b(3, this.e.longValue());
        }
        if (this.h != null) {
            iVar.a(4, this.h.floatValue());
        }
        if (this.f != null) {
            iVar.a(5, this.f.doubleValue());
        }
        super.a(iVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof is)) {
            return false;
        }
        is isVar = (is) obj;
        if (this.c == null) {
            if (isVar.c != null) {
                return false;
            }
        } else if (!this.c.equals(isVar.c)) {
            return false;
        }
        if (this.d == null) {
            if (isVar.d != null) {
                return false;
            }
        } else if (!this.d.equals(isVar.d)) {
            return false;
        }
        if (this.e == null) {
            if (isVar.e != null) {
                return false;
            }
        } else if (!this.e.equals(isVar.e)) {
            return false;
        }
        if (this.h == null) {
            if (isVar.h != null) {
                return false;
            }
        } else if (!this.h.equals(isVar.h)) {
            return false;
        }
        if (this.f == null) {
            if (isVar.f != null) {
                return false;
            }
        } else if (!this.f.equals(isVar.f)) {
            return false;
        }
        return (this.a == null || this.a.b()) ? isVar.a == null || isVar.a.b() : this.a.equals(isVar.a);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.f == null ? 0 : this.f.hashCode()) + (((this.h == null ? 0 : this.h.hashCode()) + (((this.e == null ? 0 : this.e.hashCode()) + (((this.d == null ? 0 : this.d.hashCode()) + (((this.c == null ? 0 : this.c.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (!(this.a == null || this.a.b())) {
            i = this.a.hashCode();
        }
        return hashCode + i;
    }
}
