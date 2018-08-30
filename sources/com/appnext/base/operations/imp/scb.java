package com.appnext.base.operations.imp;

import android.os.Bundle;
import android.provider.Settings.System;
import com.appnext.base.a.b.b;
import com.appnext.base.a.b.c;
import com.appnext.base.b.c.a;
import com.appnext.base.b.d;
import com.appnext.base.operations.e;
import java.util.ArrayList;
import java.util.List;

public class scb extends e {
    public scb(c cVar, Bundle bundle) {
        super(cVar, bundle);
    }

    protected List<b> getData() {
        try {
            int i = System.getInt(d.getContext().getContentResolver(), "screen_brightness");
            if (i == 0) {
                return null;
            }
            List<b> arrayList = new ArrayList();
            arrayList.add(new b(scb.class.getSimpleName(), "" + i, a.Integer.getType()));
            return arrayList;
        } catch (Throwable th) {
            return null;
        }
    }

    public boolean hasPermission() {
        return true;
    }
}
