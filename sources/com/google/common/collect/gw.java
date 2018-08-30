package com.google.common.collect;

import com.google.common.base.o;
import com.google.common.collect.Multiset.Entry;
import javax.annotation.Nullable;

abstract class gw<E> implements Entry<E> {
    gw() {
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return getCount() == entry.getCount() && o.a(getElement(), entry.getElement());
    }

    public int hashCode() {
        Object element = getElement();
        return (element == null ? 0 : element.hashCode()) ^ getCount();
    }

    public String toString() {
        String valueOf = String.valueOf(getElement());
        int count = getCount();
        return count == 1 ? valueOf : valueOf + " x " + count;
    }
}
