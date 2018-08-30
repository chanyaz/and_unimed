package com.appnext.base.operations.imp;

import android.os.Bundle;
import com.appnext.base.a.b.b;
import com.appnext.base.b.c.a;
import com.appnext.base.b.d;
import com.appnext.base.b.f;
import com.appnext.base.operations.c;
import java.util.ArrayList;
import java.util.List;

public class fs extends c {
    private String[] gY = new String[]{"esfs", "ess", "isfs", "iss", "esfp", "isfp"};

    public fs(com.appnext.base.a.b.c cVar, Bundle bundle) {
        super(cVar, bundle);
    }

    protected String aX() {
        return fs.class.getSimpleName();
    }

    public void bC() {
    }

    protected a bD() {
        return a.Long;
    }

    protected boolean bF() {
        return true;
    }

    protected List<b> getData() {
        try {
            if (hasPermission()) {
                List<b> arrayList = new ArrayList();
                for (String str : this.gY) {
                    arrayList.add(new b(fs.class.getSimpleName(), str, String.valueOf(f.aw(str)), a.Long.getType()));
                }
                return arrayList;
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public boolean hasPermission() {
        return bE() && f.g(d.getContext(), "android.permission.READ_EXTERNAL_STORAGE");
    }
}
