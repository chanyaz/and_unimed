package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;

@GwtIncompatible("serialization")
class cu implements Serializable {
    private static final long serialVersionUID = 0;
    final ImmutableCollection<?> a;

    cu(ImmutableCollection<?> immutableCollection) {
        this.a = immutableCollection;
    }

    Object readResolve() {
        return this.a.b();
    }
}
