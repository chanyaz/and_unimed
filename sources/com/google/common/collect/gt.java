package com.google.common.collect;

import com.google.common.collect.Multiset.Entry;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class gt<K, V> extends ai<K> {
    final Multimap<K, V> a;

    gt(Multimap<K, V> multimap) {
        this.a = multimap;
    }

    Iterator<Entry<K>> a() {
        return new jf<Map.Entry<K, Collection<V>>, Entry<K>>(this.a.asMap().entrySet().iterator()) {
            Entry<K> a(final Map.Entry<K, Collection<V>> entry) {
                return new gw<K>() {
                    public int getCount() {
                        return ((Collection) entry.getValue()).size();
                    }

                    public K getElement() {
                        return entry.getKey();
                    }
                };
            }
        };
    }

    int b() {
        return this.a.asMap().size();
    }

    public void clear() {
        this.a.clear();
    }

    public boolean contains(@Nullable Object obj) {
        return this.a.containsKey(obj);
    }

    public int count(@Nullable Object obj) {
        Collection collection = (Collection) Maps.a(this.a.asMap(), obj);
        return collection == null ? 0 : collection.size();
    }

    Set<Entry<K>> d() {
        return new gu(this);
    }

    public Set<K> elementSet() {
        return this.a.keySet();
    }

    public Iterator<K> iterator() {
        return Maps.a(this.a.entries().iterator());
    }

    public int remove(@Nullable Object obj, int i) {
        int i2 = 0;
        ba.a(i, "occurrences");
        if (i == 0) {
            return count(obj);
        }
        Collection collection = (Collection) Maps.a(this.a.asMap(), obj);
        if (collection == null) {
            return 0;
        }
        int size = collection.size();
        if (i >= size) {
            collection.clear();
        } else {
            Iterator it = collection.iterator();
            while (i2 < i) {
                it.next();
                it.remove();
                i2++;
            }
        }
        return size;
    }
}
