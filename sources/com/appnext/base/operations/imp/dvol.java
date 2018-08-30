package com.appnext.base.operations.imp;

import android.os.Bundle;
import com.appnext.base.a.b.b;
import com.appnext.base.b.c.a;
import com.appnext.base.b.d;
import com.appnext.base.b.f;
import com.appnext.base.operations.c;
import java.util.ArrayList;
import java.util.List;

public class dvol extends c {
    private static final String KEY = dvol.class.getSimpleName();
    private String[] gX = new String[]{"dvola", "dvolc", "dvolm", "dvoln", "dvolr"};

    public dvol(com.appnext.base.a.b.c cVar, Bundle bundle) {
        super(cVar, bundle);
    }

    protected String aX() {
        return dvol.class.getSimpleName();
    }

    public void bC() {
    }

    protected boolean bF() {
        return true;
    }

    protected List<b> getData() {
        try {
            List<b> arrayList = new ArrayList();
            for (String str : this.gX) {
                arrayList.add(new b(KEY, str, String.valueOf(f.f(d.getContext().getApplicationContext(), str)), a.Integer.getType()));
            }
            return arrayList;
        } catch (Throwable th) {
            return null;
        }
    }

    public boolean hasPermission() {
        return bE();
    }
}
