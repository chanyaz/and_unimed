package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

class o extends gm<K, Collection<V>> {
    final /* synthetic */ j a;

    o(j jVar, Map<K, Collection<V>> map) {
        this.a = jVar;
        super(map);
    }

    public void clear() {
        er.g(iterator());
    }

    public boolean containsAll(Collection<?> collection) {
        return c().keySet().containsAll(collection);
    }

    public boolean equals(@Nullable Object obj) {
        return this == obj || c().keySet().equals(obj);
    }

    public int hashCode() {
        return c().keySet().hashCode();
    }

    public Iterator<K> iterator() {
        final Iterator it = c().entrySet().iterator();
        return new Iterator<K>() {
            Entry<K, Collection<V>> a;

            public boolean hasNext() {
                return it.hasNext();
            }

            public K next() {
                this.a = (Entry) it.next();
                return this.a.getKey();
            }

            public void remove() {
                ba.a(this.a != null);
                Collection collection = (Collection) this.a.getValue();
                it.remove();
                j.b(o.this.a, collection.size());
                collection.clear();
            }
        };
    }

    public boolean remove(Object obj) {
        int i;
        Collection collection = (Collection) c().remove(obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            j.b(this.a, size);
            i = size;
        } else {
            i = 0;
        }
        return i > 0;
    }
}
