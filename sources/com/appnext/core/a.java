package com.appnext.core;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;

public class a {
    private ArrayList<?> aL = null;
    private Long kC = Long.valueOf(0);
    private ArrayList<com.appnext.core.c.a> kD = new ArrayList();
    private String placementID;
    private int state = 0;

    public void a(a aVar) {
        if (aVar != null && aVar.kD != null) {
            this.kD.addAll(aVar.kD);
        }
    }

    public void a(com.appnext.core.c.a aVar) {
        if (aVar != null) {
            this.kD.add(aVar);
        }
    }

    public void a(Long l) {
        this.kC = l;
    }

    public void a(ArrayList<?> arrayList, boolean z) {
        this.aL = arrayList;
        if (z) {
            a(Long.valueOf(System.currentTimeMillis()));
        }
    }

    public synchronized void aH(final String str) {
        new Handler().post(new Runnable() {
            public void run() {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a.this.kD);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.appnext.core.c.a aVar = (com.appnext.core.c.a) it.next();
                    if (aVar != null) {
                        aVar.error(str);
                    }
                }
                a.this.kD.clear();
            }
        });
    }

    public void b(com.appnext.core.c.a aVar) {
        if (aVar != null) {
            this.kD.remove(aVar);
        }
    }

    public Long cP() {
        return this.kC;
    }

    public ArrayList<?> cQ() {
        if (this.aL == null) {
            return null;
        }
        ArrayList<?> arrayList = new ArrayList();
        Iterator it = this.aL.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public String getPlacementID() {
        return this.placementID;
    }

    public int getState() {
        return this.state;
    }

    public void h(ArrayList<?> arrayList) {
        a(arrayList, true);
    }

    public synchronized void i(final ArrayList<?> arrayList) {
        new Handler().post(new Runnable() {
            public void run() {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a.this.kD);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.appnext.core.c.a aVar = (com.appnext.core.c.a) it.next();
                    if (aVar != null) {
                        aVar.a(arrayList);
                    }
                }
                a.this.kD.clear();
            }
        });
    }

    public void setPlacementID(String str) {
        this.placementID = str;
    }

    public void setState(int i) {
        this.state = i;
    }
}
