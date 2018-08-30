package com.google.android.gms.internal.measurement;

public final class ij extends j<ij> {
    private static volatile ij[] g;
    public im c;
    public ik d;
    public Boolean e;
    public String f;

    public ij() {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.a = null;
        this.b = -1;
    }

    public static ij[] e() {
        if (g == null) {
            synchronized (o.b) {
                if (g == null) {
                    g = new ij[0];
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
            this.e.booleanValue();
            a += i.b(3) + 1;
        }
        return this.f != null ? a + i.b(4, this.f) : a;
    }

    public final void a(i iVar) {
        if (this.c != null) {
            iVar.a(1, this.c);
        }
        if (this.d != null) {
            iVar.a(2, this.d);
        }
        if (this.e != null) {
            iVar.a(3, this.e.booleanValue());
        }
        if (this.f != null) {
            iVar.a(4, this.f);
        }
        super.a(iVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ij)) {
            return false;
        }
        ij ijVar = (ij) obj;
        if (this.c == null) {
            if (ijVar.c != null) {
                return false;
            }
        } else if (!this.c.equals(ijVar.c)) {
            return false;
        }
        if (this.d == null) {
            if (ijVar.d != null) {
                return false;
            }
        } else if (!this.d.equals(ijVar.d)) {
            return false;
        }
        if (this.e == null) {
            if (ijVar.e != null) {
                return false;
            }
        } else if (!this.e.equals(ijVar.e)) {
            return false;
        }
        if (this.f == null) {
            if (ijVar.f != null) {
                return false;
            }
        } else if (!this.f.equals(ijVar.f)) {
            return false;
        }
        return (this.a == null || this.a.b()) ? ijVar.a == null || ijVar.a.b() : this.a.equals(ijVar.a);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = getClass().getName().hashCode() + 527;
        im imVar = this.c;
        hashCode = (imVar == null ? 0 : imVar.hashCode()) + (hashCode * 31);
        ik ikVar = this.d;
        hashCode = ((this.f == null ? 0 : this.f.hashCode()) + (((this.e == null ? 0 : this.e.hashCode()) + (((ikVar == null ? 0 : ikVar.hashCode()) + (hashCode * 31)) * 31)) * 31)) * 31;
        if (!(this.a == null || this.a.b())) {
            i = this.a.hashCode();
        }
        return hashCode + i;
    }
}
