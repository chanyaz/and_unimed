package com.appnext.base.a;

import com.appnext.base.a.c.b;
import com.appnext.base.a.c.c;
import com.appnext.base.a.c.f;
import com.appnext.base.a.c.g;

public class a {
    private static volatile a fR;
    private com.appnext.base.a.c.a fM;
    private b fN;
    private g fO;
    private c fP;
    private f fQ;

    private a() {
        aN();
    }

    public static a aM() {
        if (fR == null) {
            synchronized (a.class) {
                if (fR == null) {
                    fR = new a();
                }
            }
        }
        return fR;
    }

    private void aN() {
        this.fM = new com.appnext.base.a.c.a();
        this.fN = new b();
        this.fO = new g();
        this.fP = new c();
        this.fQ = new f();
    }

    public com.appnext.base.a.c.a aO() {
        return this.fM;
    }

    public b aP() {
        return this.fN;
    }

    public g aQ() {
        return this.fO;
    }

    public c aR() {
        return this.fP;
    }

    public f aS() {
        return this.fQ;
    }
}
