package com.appnext.base.operations.imp;

import android.os.Bundle;
import com.appnext.base.a.a;
import com.appnext.base.a.b.b;
import com.appnext.base.a.b.c;
import com.appnext.base.b.l;
import com.appnext.base.operations.e;
import com.appnext.core.g;
import java.util.List;
import org.json.JSONArray;

public class sals extends e {
    public sals(c cVar, Bundle bundle) {
        super(cVar, bundle);
    }

    protected boolean bz() {
        return false;
    }

    protected List<b> getData() {
        try {
            String a = g.a(com.appnext.base.b.c.jj, null, 60000);
            a.aM().aO().delete();
            a.aM().aO().a(new JSONArray(a));
        } catch (Throwable th) {
            l.k("sals", th.getMessage());
            com.appnext.base.b.a(th);
        }
        return null;
    }

    public boolean hasPermission() {
        return true;
    }
}
