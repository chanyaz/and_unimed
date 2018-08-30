package com.google.android.gms.internal.measurement;

public final class in extends j<in> {
    private static volatile in[] g;
    public String c;
    public Boolean d;
    public Boolean e;
    public Integer f;

    public in() {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.a = null;
        this.b = -1;
    }

    public static in[] e() {
        if (g == null) {
            synchronized (o.b) {
                if (g == null) {
                    g = new in[0];
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
            this.d.booleanValue();
            a += i.b(2) + 1;
        }
        if (this.e != null) {
            this.e.booleanValue();
            a += i.b(3) + 1;
        }
        return this.f != null ? a + i.b(4, this.f.intValue()) : a;
    }

    public final void a(i iVar) {
        if (this.c != null) {
            iVar.a(1, this.c);
        }
        if (this.d != null) {
            iVar.a(2, this.d.booleanValue());
        }
        if (this.e != null) {
            iVar.a(3, this.e.booleanValue());
        }
        if (this.f != null) {
            iVar.a(4, this.f.intValue());
        }
        super.a(iVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof in)) {
            return false;
        }
        in inVar = (in) obj;
        if (this.c == null) {
            if (inVar.c != null) {
                return false;
            }
        } else if (!this.c.equals(inVar.c)) {
            return false;
        }
        if (this.d == null) {
            if (inVar.d != null) {
                return false;
            }
        } else if (!this.d.equals(inVar.d)) {
            return false;
        }
        if (this.e == null) {
            if (inVar.e != null) {
                return false;
            }
        } else if (!this.e.equals(inVar.e)) {
            return false;
        }
        if (this.f == null) {
            if (inVar.f != null) {
                return false;
            }
        } else if (!this.f.equals(inVar.f)) {
            return false;
        }
        return (this.a == null || this.a.b()) ? inVar.a == null || inVar.a.b() : this.a.equals(inVar.a);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.f == null ? 0 : this.f.hashCode()) + (((this.e == null ? 0 : this.e.hashCode()) + (((this.d == null ? 0 : this.d.hashCode()) + (((this.c == null ? 0 : this.c.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31;
        if (!(this.a == null || this.a.b())) {
            i = this.a.hashCode();
        }
        return hashCode + i;
    }
}
