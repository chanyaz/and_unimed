package com.appnext.base.operations;

import android.os.Bundle;
import com.appnext.base.a.a;
import com.appnext.base.a.c.d;
import com.appnext.base.operations.imp.cd;

public abstract class c extends a {
    public c(com.appnext.base.a.b.c cVar, Bundle bundle) {
        super(cVar, bundle);
    }

    protected abstract String aX();

    protected d bA() {
        return a.aM().aS();
    }

    public void bB() {
        if (bF()) {
            bs();
        }
    }

    protected boolean bE() {
        try {
            com.appnext.base.a.b.c ac = a.aM().aR().ac(cd.class.getSimpleName());
            if (ac != null) {
                return ac.ba().equalsIgnoreCase(com.appnext.base.b.c.jx);
            }
        } catch (Throwable th) {
        }
        return false;
    }

    protected abstract boolean bF();

    protected boolean bz() {
        return false;
    }
}
