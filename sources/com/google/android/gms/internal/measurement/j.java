package com.google.android.gms.internal.measurement;

public abstract class j<M extends j<M>> extends p {
    protected m a;

    protected int a() {
        int i = 0;
        if (this.a == null) {
            return 0;
        }
        int i2 = 0;
        while (i < this.a.a()) {
            i2 += this.a.b(i).a();
            i++;
        }
        return i2;
    }

    public void a(i iVar) {
        if (this.a != null) {
            for (int i = 0; i < this.a.a(); i++) {
                this.a.b(i).a(iVar);
            }
        }
    }

    protected final boolean a(h hVar, int i) {
        int i2 = hVar.i();
        if (!hVar.b(i)) {
            return false;
        }
        int i3 = i >>> 3;
        r rVar = new r(i, hVar.a(i2, hVar.i() - i2));
        n nVar = null;
        if (this.a == null) {
            this.a = new m();
        } else {
            nVar = this.a.a(i3);
        }
        if (nVar == null) {
            nVar = new n();
            this.a.a(i3, nVar);
        }
        nVar.a(rVar);
        return true;
    }

    public final /* synthetic */ p b() {
        return (j) clone();
    }

    public /* synthetic */ Object clone() {
        j jVar = (j) super.clone();
        o.a(this, jVar);
        return jVar;
    }
}
