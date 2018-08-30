package com.appnext.base.operations;

import android.os.Bundle;
import com.appnext.base.a.b.c;
import com.appnext.base.b;
import com.appnext.base.b.c.a;
import com.appnext.base.b.k;

public abstract class e extends a {
    public e(c cVar, Bundle bundle) {
        super(cVar, bundle);
    }

    public void bB() {
        Object obj = null;
        Object a = k.a(com.appnext.base.b.c.jH, a.Boolean);
        if (a != null && (a instanceof Boolean)) {
            obj = !((Boolean) a).booleanValue() ? 1 : null;
        }
        try {
            if (hasPermission() && obj == null) {
                bs();
            }
        } catch (Throwable th) {
            b.a(th);
        }
    }

    public void bC() {
    }

    protected a bD() {
        return a.String;
    }
}
