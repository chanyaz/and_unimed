package com.google.android.gms.internal.measurement;

public final class ik extends j<ik> {
    public Integer c;
    public Boolean d;
    public String e;
    public String f;
    public String g;

    public ik() {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.a = null;
        this.b = -1;
    }

    private final ik b(h hVar) {
        while (true) {
            int a = hVar.a();
            switch (a) {
                case 0:
                    break;
                case 8:
                    int i = hVar.i();
                    try {
                        int d = hVar.d();
                        if (d < 0 || d > 4) {
                            throw new IllegalArgumentException(d + " is not a valid enum ComparisonType");
                        }
                        this.c = Integer.valueOf(d);
                        continue;
                    } catch (IllegalArgumentException e) {
                        hVar.e(i);
                        a(hVar, a);
                        break;
                    }
                case 16:
                    this.d = Boolean.valueOf(hVar.b());
                    continue;
                case 26:
                    this.e = hVar.c();
                    continue;
                case 34:
                    this.f = hVar.c();
                    continue;
                case 42:
                    this.g = hVar.c();
                    continue;
                default:
                    if (!super.a(hVar, a)) {
                        break;
                    }
                    continue;
            }
        }
        return this;
    }

    protected final int a() {
        int a = super.a();
        if (this.c != null) {
            a += i.b(1, this.c.intValue());
        }
        if (this.d != null) {
            this.d.booleanValue();
            a += i.b(2) + 1;
        }
        if (this.e != null) {
            a += i.b(3, this.e);
        }
        if (this.f != null) {
            a += i.b(4, this.f);
        }
        return this.g != null ? a + i.b(5, this.g) : a;
    }

    public final void a(i iVar) {
        if (this.c != null) {
            iVar.a(1, this.c.intValue());
        }
        if (this.d != null) {
            iVar.a(2, this.d.booleanValue());
        }
        if (this.e != null) {
            iVar.a(3, this.e);
        }
        if (this.f != null) {
            iVar.a(4, this.f);
        }
        if (this.g != null) {
            iVar.a(5, this.g);
        }
        super.a(iVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ik)) {
            return false;
        }
        ik ikVar = (ik) obj;
        if (this.c == null) {
            if (ikVar.c != null) {
                return false;
            }
        } else if (!this.c.equals(ikVar.c)) {
            return false;
        }
        if (this.d == null) {
            if (ikVar.d != null) {
                return false;
            }
        } else if (!this.d.equals(ikVar.d)) {
            return false;
        }
        if (this.e == null) {
            if (ikVar.e != null) {
                return false;
            }
        } else if (!this.e.equals(ikVar.e)) {
            return false;
        }
        if (this.f == null) {
            if (ikVar.f != null) {
                return false;
            }
        } else if (!this.f.equals(ikVar.f)) {
            return false;
        }
        if (this.g == null) {
            if (ikVar.g != null) {
                return false;
            }
        } else if (!this.g.equals(ikVar.g)) {
            return false;
        }
        return (this.a == null || this.a.b()) ? ikVar.a == null || ikVar.a.b() : this.a.equals(ikVar.a);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.g == null ? 0 : this.g.hashCode()) + (((this.f == null ? 0 : this.f.hashCode()) + (((this.e == null ? 0 : this.e.hashCode()) + (((this.d == null ? 0 : this.d.hashCode()) + (((this.c == null ? 0 : this.c.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (!(this.a == null || this.a.b())) {
            i = this.a.hashCode();
        }
        return hashCode + i;
    }
}
