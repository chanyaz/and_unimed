package com.appnext.base.operations;

import android.os.Bundle;
import com.appnext.base.a.b.c;
import com.appnext.base.b;
import java.util.ArrayList;
import java.util.List;

public class d {
    private static final String gQ = "com.appnext.base.operations.imp";
    private static volatile d gR;
    private List<a> gS = new ArrayList();

    private d() {
    }

    public static d bG() {
        if (gR == null) {
            synchronized (d.class) {
                if (gR == null) {
                    gR = new d();
                }
            }
        }
        return gR;
    }

    public static String getOperationClassName(String str) {
        return "com.appnext.base.operations.imp." + str;
    }

    public void a(a aVar) {
        if (aVar != null) {
            aVar.bC();
            synchronized (this) {
                this.gS.remove(aVar);
            }
        }
    }

    public void a(String str, c cVar, Bundle bundle) {
        if (cVar != null) {
            try {
                Object newInstance = Class.forName(getOperationClassName(str)).getConstructor(new Class[]{c.class, Bundle.class}).newInstance(new Object[]{cVar, bundle});
                if (newInstance instanceof a) {
                    a aVar = (a) newInstance;
                    synchronized (this) {
                        this.gS.add(aVar);
                    }
                    aVar.bB();
                }
            } catch (ClassNotFoundException e) {
            } catch (Throwable th) {
                b.a(th);
            }
        }
    }

    public void bH() {
        synchronized (this) {
            for (a bC : this.gS) {
                bC.bC();
            }
            this.gS.clear();
        }
    }
}
