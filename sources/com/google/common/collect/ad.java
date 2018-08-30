package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.o;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible
abstract class ad<K, V> implements Entry<K, V> {
    ad() {
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return o.a(getKey(), entry.getKey()) && o.a(getValue(), entry.getValue());
    }

    public abstract K getKey();

    public abstract V getValue();

    public int hashCode() {
        int i = 0;
        Object key = getKey();
        Object value = getValue();
        int hashCode = key == null ? 0 : key.hashCode();
        if (value != null) {
            i = value.hashCode();
        }
        return i ^ hashCode;
    }

    public V setValue(V v) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return getKey() + "=" + getValue();
    }
}
