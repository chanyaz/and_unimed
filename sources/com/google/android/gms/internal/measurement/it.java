package com.google.android.gms.internal.measurement;

public final class it extends j<it> {
    public iu[] c;

    public it() {
        this.c = iu.e();
        this.a = null;
        this.b = -1;
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
        return a;
    }

    public final void a(i iVar) {
        if (this.c != null && this.c.length > 0) {
            for (p pVar : this.c) {
                if (pVar != null) {
                    iVar.a(1, pVar);
                }
            }
        }
        super.a(iVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof it)) {
            return false;
        }
        it itVar = (it) obj;
        return !o.a(this.c, itVar.c) ? false : (this.a == null || this.a.b()) ? itVar.a == null || itVar.a.b() : this.a.equals(itVar.a);
    }

    public final int hashCode() {
        int hashCode = (((getClass().getName().hashCode() + 527) * 31) + o.a(this.c)) * 31;
        int hashCode2 = (this.a == null || this.a.b()) ? 0 : this.a.hashCode();
        return hashCode2 + hashCode;
    }
}
