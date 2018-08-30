package com.google.android.gms.internal.measurement;

public final class iw extends j<iw> {
    private static volatile iw[] h;
    public Long c;
    public String d;
    public String e;
    public Long f;
    public Double g;
    private Float i;

    public iw() {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.i = null;
        this.g = null;
        this.a = null;
        this.b = -1;
    }

    public static iw[] e() {
        if (h == null) {
            synchronized (o.b) {
                if (h == null) {
                    h = new iw[0];
                }
            }
        }
        return h;
    }

    protected final int a() {
        int a = super.a();
        if (this.c != null) {
            a += i.c(1, this.c.longValue());
        }
        if (this.d != null) {
            a += i.b(2, this.d);
        }
        if (this.e != null) {
            a += i.b(3, this.e);
        }
        if (this.f != null) {
            a += i.c(4, this.f.longValue());
        }
        if (this.i != null) {
            this.i.floatValue();
            a += i.b(5) + 4;
        }
        if (this.g == null) {
            return a;
        }
        this.g.doubleValue();
        return a + (i.b(6) + 8);
    }

    public final void a(i iVar) {
        if (this.c != null) {
            iVar.b(1, this.c.longValue());
        }
        if (this.d != null) {
            iVar.a(2, this.d);
        }
        if (this.e != null) {
            iVar.a(3, this.e);
        }
        if (this.f != null) {
            iVar.b(4, this.f.longValue());
        }
        if (this.i != null) {
            iVar.a(5, this.i.floatValue());
        }
        if (this.g != null) {
            iVar.a(6, this.g.doubleValue());
        }
        super.a(iVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof iw)) {
            return false;
        }
        iw iwVar = (iw) obj;
        if (this.c == null) {
            if (iwVar.c != null) {
                return false;
            }
        } else if (!this.c.equals(iwVar.c)) {
            return false;
        }
        if (this.d == null) {
            if (iwVar.d != null) {
                return false;
            }
        } else if (!this.d.equals(iwVar.d)) {
            return false;
        }
        if (this.e == null) {
            if (iwVar.e != null) {
                return false;
            }
        } else if (!this.e.equals(iwVar.e)) {
            return false;
        }
        if (this.f == null) {
            if (iwVar.f != null) {
                return false;
            }
        } else if (!this.f.equals(iwVar.f)) {
            return false;
        }
        if (this.i == null) {
            if (iwVar.i != null) {
                return false;
            }
        } else if (!this.i.equals(iwVar.i)) {
            return false;
        }
        if (this.g == null) {
            if (iwVar.g != null) {
                return false;
            }
        } else if (!this.g.equals(iwVar.g)) {
            return false;
        }
        return (this.a == null || this.a.b()) ? iwVar.a == null || iwVar.a.b() : this.a.equals(iwVar.a);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.g == null ? 0 : this.g.hashCode()) + (((this.i == null ? 0 : this.i.hashCode()) + (((this.f == null ? 0 : this.f.hashCode()) + (((this.e == null ? 0 : this.e.hashCode()) + (((this.d == null ? 0 : this.d.hashCode()) + (((this.c == null ? 0 : this.c.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (!(this.a == null || this.a.b())) {
            i = this.a.hashCode();
        }
        return hashCode + i;
    }
}
