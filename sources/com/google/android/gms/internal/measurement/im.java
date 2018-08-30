package com.google.android.gms.internal.measurement;

public final class im extends j<im> {
    public Integer c;
    public String d;
    public Boolean e;
    public String[] f;

    public im() {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = s.c;
        this.a = null;
        this.b = -1;
    }

    private final im b(h hVar) {
        int i;
        while (true) {
            int a = hVar.a();
            switch (a) {
                case 0:
                    break;
                case 8:
                    i = hVar.i();
                    try {
                        int d = hVar.d();
                        if (d < 0 || d > 6) {
                            throw new IllegalArgumentException(d + " is not a valid enum MatchType");
                        }
                        this.c = Integer.valueOf(d);
                        continue;
                    } catch (IllegalArgumentException e) {
                        hVar.e(i);
                        a(hVar, a);
                        break;
                    }
                case 18:
                    this.d = hVar.c();
                    continue;
                case 24:
                    this.e = Boolean.valueOf(hVar.b());
                    continue;
                case 34:
                    i = s.a(hVar, 34);
                    a = this.f == null ? 0 : this.f.length;
                    Object obj = new String[(i + a)];
                    if (a != 0) {
                        System.arraycopy(this.f, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = hVar.c();
                        hVar.a();
                        a++;
                    }
                    obj[a] = hVar.c();
                    this.f = obj;
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
        int i = 0;
        int a = super.a();
        if (this.c != null) {
            a += i.b(1, this.c.intValue());
        }
        if (this.d != null) {
            a += i.b(2, this.d);
        }
        if (this.e != null) {
            this.e.booleanValue();
            a += i.b(3) + 1;
        }
        if (this.f == null || this.f.length <= 0) {
            return a;
        }
        int i2 = 0;
        int i3 = 0;
        while (i < this.f.length) {
            String str = this.f[i];
            if (str != null) {
                i3++;
                i2 += i.a(str);
            }
            i++;
        }
        return (a + i2) + (i3 * 1);
    }

    public final void a(i iVar) {
        if (this.c != null) {
            iVar.a(1, this.c.intValue());
        }
        if (this.d != null) {
            iVar.a(2, this.d);
        }
        if (this.e != null) {
            iVar.a(3, this.e.booleanValue());
        }
        if (this.f != null && this.f.length > 0) {
            for (String str : this.f) {
                if (str != null) {
                    iVar.a(4, str);
                }
            }
        }
        super.a(iVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof im)) {
            return false;
        }
        im imVar = (im) obj;
        if (this.c == null) {
            if (imVar.c != null) {
                return false;
            }
        } else if (!this.c.equals(imVar.c)) {
            return false;
        }
        if (this.d == null) {
            if (imVar.d != null) {
                return false;
            }
        } else if (!this.d.equals(imVar.d)) {
            return false;
        }
        if (this.e == null) {
            if (imVar.e != null) {
                return false;
            }
        } else if (!this.e.equals(imVar.e)) {
            return false;
        }
        return !o.a(this.f, imVar.f) ? false : (this.a == null || this.a.b()) ? imVar.a == null || imVar.a.b() : this.a.equals(imVar.a);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((this.e == null ? 0 : this.e.hashCode()) + (((this.d == null ? 0 : this.d.hashCode()) + (((this.c == null ? 0 : this.c.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31) + o.a(this.f)) * 31;
        if (!(this.a == null || this.a.b())) {
            i = this.a.hashCode();
        }
        return hashCode + i;
    }
}
