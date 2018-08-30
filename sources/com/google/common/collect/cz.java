package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible(serializable = true)
class cz<K, V> extends ad<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final K e;
    final V f;

    cz(@Nullable K k, @Nullable V v) {
        this.e = k;
        this.f = v;
    }

    @Nullable
    public final K getKey() {
        return this.e;
    }

    @Nullable
    public final V getValue() {
        return this.f;
    }

    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }
}
