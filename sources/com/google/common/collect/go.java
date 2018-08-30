package com.google.common.collect;

import com.google.common.base.o;
import com.google.common.base.s;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

class go<K, V> extends AbstractCollection<V> {
    final Map<K, V> a;

    go(Map<K, V> map) {
        this.a = (Map) s.a((Object) map);
    }

    final Map<K, V> a() {
        return this.a;
    }

    public void clear() {
        a().clear();
    }

    public boolean contains(@Nullable Object obj) {
        return a().containsValue(obj);
    }

    public boolean isEmpty() {
        return a().isEmpty();
    }

    public Iterator<V> iterator() {
        return Maps.b(a().entrySet().iterator());
    }

    public boolean remove(Object obj) {
        try {
            return super.remove(obj);
        } catch (UnsupportedOperationException e) {
            for (Entry entry : a().entrySet()) {
                if (o.a(obj, entry.getValue())) {
                    a().remove(entry.getKey());
                    return true;
                }
            }
            return false;
        }
    }

    public boolean removeAll(Collection<?> collection) {
        try {
            return super.removeAll((Collection) s.a((Object) collection));
        } catch (UnsupportedOperationException e) {
            Collection a = hz.a();
            for (Entry entry : a().entrySet()) {
                if (collection.contains(entry.getValue())) {
                    a.add(entry.getKey());
                }
            }
            return a().keySet().removeAll(a);
        }
    }

    public boolean retainAll(Collection<?> collection) {
        try {
            return super.retainAll((Collection) s.a((Object) collection));
        } catch (UnsupportedOperationException e) {
            Collection a = hz.a();
            for (Entry entry : a().entrySet()) {
                if (collection.contains(entry.getValue())) {
                    a.add(entry.getKey());
                }
            }
            return a().keySet().retainAll(a);
        }
    }

    public int size() {
        return a().size();
    }
}
