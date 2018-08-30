package com.google.common.collect;

import com.google.common.collect.Multiset.Entry;
import javax.annotation.Nullable;

abstract class gy<E> extends ia<Entry<E>> {
    gy() {
    }

    abstract Multiset<E> a();

    public void clear() {
        a().clear();
    }

    public boolean contains(@Nullable Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return entry.getCount() > 0 && a().count(entry.getElement()) == entry.getCount();
    }

    public boolean remove(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        Object element = entry.getElement();
        int count = entry.getCount();
        return count != 0 ? a().setCount(element, count, 0) : false;
    }
}
