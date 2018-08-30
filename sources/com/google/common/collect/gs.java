package com.google.common.collect;

import java.util.AbstractCollection;
import java.util.Map.Entry;
import javax.annotation.Nullable;

abstract class gs<K, V> extends AbstractCollection<Entry<K, V>> {
    gs() {
    }

    abstract Multimap<K, V> a();

    public void clear() {
        a().clear();
    }

    public boolean contains(@Nullable Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return a().containsEntry(entry.getKey(), entry.getValue());
    }

    public boolean remove(@Nullable Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return a().remove(entry.getKey(), entry.getValue());
    }

    public int size() {
        return a().size();
    }
}
