package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map.Entry;

class dj implements Serializable {
    private static final long serialVersionUID = 0;
    private final Object[] a;
    private final Object[] b;

    dj(ImmutableMap<?, ?> immutableMap) {
        this.a = new Object[immutableMap.size()];
        this.b = new Object[immutableMap.size()];
        int i = 0;
        Iterator it = immutableMap.entrySet().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                Entry entry = (Entry) it.next();
                this.a[i2] = entry.getKey();
                this.b[i2] = entry.getValue();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    Object a(di<Object, Object> diVar) {
        for (int i = 0; i < this.a.length; i++) {
            diVar.b(this.a[i], this.b[i]);
        }
        return diVar.b();
    }

    Object readResolve() {
        return a(new di());
    }
}
