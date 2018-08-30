package com.google.android.gms.internal.measurement;

public final class iq extends j<iq> {
    private static volatile iq[] g;
    public Integer c;
    public iv d;
    public iv e;
    public Boolean f;

    public iq() {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.a = null;
        this.b = -1;
    }

    public static iq[] e() {
        if (g == null) {
            synchronized (o.b) {
                if (g == null) {
                    g = new iq[0];
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
        if (this.e != null) {
            a += i.b(3, this.e);
        }
        if (this.f == null) {
            return a;
        }
        this.f.booleanValue();
        return a + (i.b(4) + 1);
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
        if (this.f != null) {
            iVar.a(4, this.f.booleanValue());
        }
        super.a(iVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof iq)) {
            return false;
        }
        iq iqVar = (iq) obj;
        if (this.c == null) {
            if (iqVar.c != null) {
                return false;
            }
        } else if (!this.c.equals(iqVar.c)) {
            return false;
        }
        if (this.d == null) {
            if (iqVar.d != null) {
                return false;
            }
        } else if (!this.d.equals(iqVar.d)) {
            return false;
        }
        if (this.e == null) {
            if (iqVar.e != null) {
                return false;
            }
        } else if (!this.e.equals(iqVar.e)) {
            return false;
        }
        if (this.f == null) {
            if (iqVar.f != null) {
                return false;
            }
        } else if (!this.f.equals(iqVar.f)) {
            return false;
        }
        return (this.a == null || this.a.b()) ? iqVar.a == null || iqVar.a.b() : this.a.equals(iqVar.a);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (this.c == null ? 0 : this.c.hashCode()) + ((getClass().getName().hashCode() + 527) * 31);
        iv ivVar = this.d;
        hashCode = (ivVar == null ? 0 : ivVar.hashCode()) + (hashCode * 31);
        ivVar = this.e;
        hashCode = ((this.f == null ? 0 : this.f.hashCode()) + (((ivVar == null ? 0 : ivVar.hashCode()) + (hashCode * 31)) * 31)) * 31;
        if (!(this.a == null || this.a.b())) {
            i = this.a.hashCode();
        }
        return hashCode + i;
    }
}
