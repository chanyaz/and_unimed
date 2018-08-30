package com.google.common.collect;

import com.google.common.base.s;
import com.google.common.collect.il.com/google/common/collect/jb;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

class it extends com/google/common/collect/jb<C> {
    final /* synthetic */ il a;

    private it(il ilVar) {
        this.a = ilVar;
        super(ilVar);
    }

    public boolean contains(Object obj) {
        return this.a.containsColumn(obj);
    }

    public Iterator<C> iterator() {
        return this.a.g();
    }

    public boolean remove(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        Iterator it = this.a.a.values().iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            Map map = (Map) it.next();
            if (map.keySet().remove(obj)) {
                z2 = true;
                if (map.isEmpty()) {
                    it.remove();
                }
            }
            z = z2;
        }
    }

    public boolean removeAll(Collection<?> collection) {
        s.a((Object) collection);
        boolean z = false;
        Iterator it = this.a.a.values().iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            Map map = (Map) it.next();
            if (er.a(map.keySet().iterator(), (Collection) collection)) {
                z2 = true;
                if (map.isEmpty()) {
                    it.remove();
                }
            }
            z = z2;
        }
    }

    public boolean retainAll(Collection<?> collection) {
        s.a((Object) collection);
        boolean z = false;
        Iterator it = this.a.a.values().iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            Map map = (Map) it.next();
            if (map.keySet().retainAll(collection)) {
                z2 = true;
                if (map.isEmpty()) {
                    it.remove();
                }
            }
            z = z2;
        }
    }

    public int size() {
        return er.b(iterator());
    }
}
