package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.o;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ca<K, V> extends cc implements Entry<K, V> {
    protected ca() {
    }

    /* renamed from: a */
    protected abstract Entry<K, V> b();

    protected boolean a(@Nullable Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return o.a(getKey(), entry.getKey()) && o.a(getValue(), entry.getValue());
    }

    public boolean equals(@Nullable Object obj) {
        return b().equals(obj);
    }

    public K getKey() {
        return b().getKey();
    }

    public V getValue() {
        return b().getValue();
    }

    public int hashCode() {
        return b().hashCode();
    }

    public V setValue(V v) {
        return b().setValue(v);
    }
}
