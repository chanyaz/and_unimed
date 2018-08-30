package com.google.common.collect;

import com.google.common.base.o;
import com.google.common.base.s;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class gk<K, V> extends ia<Entry<K, V>> {
    gk() {
    }

    abstract Map<K, V> a();

    public void clear() {
        a().clear();
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        Object key = entry.getKey();
        Object a = Maps.a(a(), key);
        return o.a(a, entry.getValue()) ? a != null || a().containsKey(key) : false;
    }

    public boolean isEmpty() {
        return a().isEmpty();
    }

    public boolean remove(Object obj) {
        if (!contains(obj)) {
            return false;
        }
        return a().keySet().remove(((Entry) obj).getKey());
    }

    public boolean removeAll(Collection<?> collection) {
        try {
            return super.removeAll((Collection) s.a((Object) collection));
        } catch (UnsupportedOperationException e) {
            return hz.a((Set) this, collection.iterator());
        }
    }

    public boolean retainAll(Collection<?> collection) {
        try {
            return super.retainAll((Collection) s.a((Object) collection));
        } catch (UnsupportedOperationException e) {
            Collection a = hz.a(collection.size());
            for (Object next : collection) {
                if (contains(next)) {
                    a.add(((Entry) next).getKey());
                }
            }
            return a().keySet().retainAll(a);
        }
    }

    public int size() {
        return a().size();
    }
}
