package com.google.android.gms.internal.measurement;

public final class il extends j<il> {
    private static volatile il[] f;
    public Integer c;
    public String d;
    public ij e;

    public il() {
        this.c = null;
        this.d = null;
        this.e = null;
        this.a = null;
        this.b = -1;
    }

    public static il[] e() {
        if (f == null) {
            synchronized (o.b) {
                if (f == null) {
                    f = new il[0];
                }
            }
        }
        return f;
    }

    protected final int a() {
        int a = super.a();
        if (this.c != null) {
            a += i.b(1, this.c.intValue());
        }
        if (this.d != null) {
            a += i.b(2, this.d);
        }
        return this.e != null ? a + i.b(3, this.e) : a;
    }

    public final void a(i iVar) {
        if (this.c != null) {
            iVar.a(1, this.c.intValue());
        }
        if (this.d != null) {
            iVar.a(2, this.d);
        }
        if (this.e != null) {
            iVar.a(3, this.e);
        }
        super.a(iVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof il)) {
            return false;
        }
        il ilVar = (il) obj;
        if (this.c == null) {
            if (ilVar.c != null) {
                return false;
            }
        } else if (!this.c.equals(ilVar.c)) {
            return false;
        }
        if (this.d == null) {
            if (ilVar.d != null) {
                return false;
            }
        } else if (!this.d.equals(ilVar.d)) {
            return false;
        }
        if (this.e == null) {
            if (ilVar.e != null) {
                return false;
            }
        } else if (!this.e.equals(ilVar.e)) {
            return false;
        }
        return (this.a == null || this.a.b()) ? ilVar.a == null || ilVar.a.b() : this.a.equals(ilVar.a);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (this.d == null ? 0 : this.d.hashCode()) + (((this.c == null ? 0 : this.c.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31);
        ij ijVar = this.e;
        hashCode = ((ijVar == null ? 0 : ijVar.hashCode()) + (hashCode * 31)) * 31;
        if (!(this.a == null || this.a.b())) {
            i = this.a.hashCode();
        }
        return hashCode + i;
    }
}
