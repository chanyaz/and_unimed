package android.support.graphics.drawable;

import android.graphics.Path;
import android.support.v4.graphics.b;
import android.support.v4.graphics.d;

class p {
    protected d[] m = null;
    String n;
    int o;

    public p(p pVar) {
        this.n = pVar.n;
        this.o = pVar.o;
        this.m = b.a(pVar.m);
    }

    public void a(Path path) {
        path.reset();
        if (this.m != null) {
            d.a(this.m, path);
        }
    }

    public boolean a() {
        return false;
    }

    public d[] getPathData() {
        return this.m;
    }

    public String getPathName() {
        return this.n;
    }

    public void setPathData(d[] dVarArr) {
        if (b.a(this.m, dVarArr)) {
            b.b(this.m, dVarArr);
        } else {
            this.m = b.a(dVarArr);
        }
    }
}
