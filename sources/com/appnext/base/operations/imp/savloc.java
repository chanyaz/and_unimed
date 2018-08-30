package com.appnext.base.operations.imp;

import android.location.Location;
import android.os.Bundle;
import com.appnext.base.a.b.b;
import com.appnext.base.a.b.c;
import com.appnext.base.b.c.a;
import com.appnext.base.b.d;
import com.appnext.base.b.f;
import com.appnext.base.b.j;
import com.appnext.base.operations.e;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class savloc extends e {
    private static final String he = savloc.class.getSimpleName();
    private long hf = 0;

    public savloc(c cVar, Bundle bundle) {
        super(cVar, bundle);
    }

    protected List<b> getData() {
        try {
            Location cG = j.cG();
            if (cG == null) {
                return null;
            }
            this.hf = cG.getTime();
            String str = cG.getLatitude() + "," + cG.getLongitude();
            List<b> arrayList = new ArrayList();
            arrayList.add(new b(he, he, str, new Date(this.hf), a.String.getType()));
            return arrayList;
        } catch (Throwable th) {
            com.appnext.base.b.a(th);
            return null;
        }
    }

    protected Date getDate() {
        return new Date(this.hf);
    }

    public boolean hasPermission() {
        return f.g(d.getContext(), "android.permission.ACCESS_FINE_LOCATION") || f.g(d.getContext(), "android.permission.ACCESS_COARSE_LOCATION");
    }
}
