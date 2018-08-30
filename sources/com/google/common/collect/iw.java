package com.google.common.collect;

import com.google.common.base.s;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class iw extends go<C, Map<R, V>> {
    final /* synthetic */ iu b;

    iw(iu iuVar) {
        this.b = iuVar;
        super(iuVar);
    }

    public boolean remove(Object obj) {
        for (Entry entry : this.b.entrySet()) {
            if (((Map) entry.getValue()).equals(obj)) {
                this.b.a.b(entry.getKey());
                return true;
            }
        }
        return false;
    }

    public boolean removeAll(Collection<?> collection) {
        s.a((Object) collection);
        boolean z = false;
        Iterator it = fb.a(this.b.a.columnKeySet().iterator()).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (collection.contains(this.b.a.column(next))) {
                this.b.a.b(next);
                z = true;
            }
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        s.a((Object) collection);
        boolean z = false;
        Iterator it = fb.a(this.b.a.columnKeySet().iterator()).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (!collection.contains(this.b.a.column(next))) {
                this.b.a.b(next);
                z = true;
            }
        }
        return z;
    }
}
