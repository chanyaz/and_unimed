package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;

@GwtIncompatible("serialization")
class dn<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final ImmutableMap<K, V> a;

    dn(ImmutableMap<K, V> immutableMap) {
        this.a = immutableMap;
    }

    Object readResolve() {
        return this.a.entrySet();
    }
}
