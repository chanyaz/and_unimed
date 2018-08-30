package com.appnext.base.operations.imp;

import android.os.Build.VERSION;
import android.os.Bundle;
import com.appnext.base.a.b.b;
import com.appnext.base.a.b.c;
import com.appnext.base.b.c.a;
import com.appnext.base.b.d;
import com.appnext.base.b.f;
import com.appnext.base.b.h;
import com.appnext.base.b.k;
import com.appnext.base.operations.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class acap extends e {
    private static final String gT = "noForGroundAPP";
    private static final String gU = "android";

    class CollectedDataModelByDateComparator implements Comparator<b> {
        private CollectedDataModelByDateComparator() {
        }

        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            return bVar.aZ().getTime() > bVar2.aZ().getTime() ? 1 : 0;
        }
    }

    public acap(c cVar, Bundle bundle) {
        super(cVar, bundle);
    }

    private List<String> e(List<String> list) {
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((String) it.next()).equalsIgnoreCase(gU)) {
                it.remove();
            }
        }
        return list;
    }

    protected String bI() {
        return acap.class.getSimpleName();
    }

    protected List<b> c(List<b> list) {
        if (list == null) {
            return null;
        }
        Map hashMap = new HashMap();
        for (b bVar : list) {
            String aC = h.cD().aC(bVar.aY());
            if (!(aC.equals(gT) || hashMap.containsKey(aC))) {
                hashMap.put(aC, bVar);
            }
        }
        if (hashMap.size() == 0) {
            return null;
        }
        List<b> arrayList = new ArrayList(hashMap.values());
        if (arrayList.isEmpty()) {
            return null;
        }
        Collections.sort(arrayList, new CollectedDataModelByDateComparator());
        return arrayList;
    }

    protected List<b> getData() {
        List e = e(k.m(d.getContext()));
        String str = (e == null || e.isEmpty()) ? gT : (String) e.get(e.size() - 1);
        List<b> arrayList = new ArrayList();
        arrayList.add(new b(bI(), str, a.String.toString()));
        return arrayList;
    }

    public boolean hasPermission() {
        return VERSION.SDK_INT < 21 ? f.g(d.getContext(), "android.permission.GET_TASKS") : k.n(d.getContext().getApplicationContext());
    }
}
