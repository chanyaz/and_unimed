package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;

@GwtIncompatible("serialization")
class dr<V> implements Serializable {
    private static final long serialVersionUID = 0;
    final ImmutableMap<?, V> a;

    dr(ImmutableMap<?, V> immutableMap) {
        this.a = immutableMap;
    }

    Object readResolve() {
        return this.a.values();
    }
}
