package com.google.common.collect;

import com.google.common.base.t;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class io extends ia<Entry<R, V>> {
    final /* synthetic */ in a;

    private io(in inVar) {
        this.a = inVar;
    }

    public void clear() {
        this.a.a(t.a());
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return this.a.b.a(entry.getKey(), this.a.a, entry.getValue());
    }

    public boolean isEmpty() {
        return !this.a.b.containsColumn(this.a.a);
    }

    public Iterator<Entry<R, V>> iterator() {
        return new ip(this.a, null);
    }

    public boolean remove(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return this.a.b.b(entry.getKey(), this.a.a, entry.getValue());
    }

    public boolean retainAll(Collection<?> collection) {
        return this.a.a(t.a(t.a((Collection) collection)));
    }

    public int size() {
        int i = 0;
        Iterator it = this.a.b.a.values().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = ((Map) it.next()).containsKey(this.a.a) ? i2 + 1 : i2;
        }
    }
}
