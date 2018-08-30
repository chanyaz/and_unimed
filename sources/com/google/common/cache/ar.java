package com.google.common.cache;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.o;
import com.google.common.base.s;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible
@Beta
public final class ar<K, V> implements Entry<K, V> {
    @Nullable
    private final K a;
    @Nullable
    private final V b;
    private final RemovalCause c;

    ar(@Nullable K k, @Nullable V v, RemovalCause removalCause) {
        this.a = k;
        this.b = v;
        this.c = (RemovalCause) s.a((Object) removalCause);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return o.a(getKey(), entry.getKey()) && o.a(getValue(), entry.getValue());
    }

    @Nullable
    public K getKey() {
        return this.a;
    }

    @Nullable
    public V getValue() {
        return this.b;
    }

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

    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return getKey() + "=" + getValue();
    }
}
