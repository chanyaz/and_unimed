package com.appnext.base.operations.imp;

import android.os.Bundle;
import com.appnext.base.a.b.b;
import com.appnext.base.a.b.c;
import com.appnext.base.b.c.a;
import com.appnext.base.b.k;
import com.appnext.base.operations.e;
import java.util.ArrayList;
import java.util.List;

public class ulve extends e {
    public ulve(c cVar, Bundle bundle) {
        super(cVar, bundle);
    }

    protected List<b> getData() {
        try {
            Object a = k.a(wpul.class.getSimpleName() + com.appnext.base.b.c.ju, a.Long);
            long longValue = (a == null || !(a instanceof Long)) ? 0 : ((Long) a).longValue();
            k.e(wpul.class.getSimpleName() + com.appnext.base.b.c.ju, String.valueOf(longValue + System.currentTimeMillis()), a.Long);
            List<b> arrayList = new ArrayList();
            arrayList.add(new b(ulve.class.getSimpleName(), "true", a.String.getType()));
            return arrayList;
        } catch (Throwable th) {
            return null;
        }
    }

    public boolean hasPermission() {
        return true;
    }
}
