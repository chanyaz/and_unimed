package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;

@GwtIncompatible("serialization")
class dp<K> implements Serializable {
    private static final long serialVersionUID = 0;
    final ImmutableMap<K, ?> a;

    dp(ImmutableMap<K, ?> immutableMap) {
        this.a = immutableMap;
    }

    Object readResolve() {
        return this.a.keySet();
    }
}
