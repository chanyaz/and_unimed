package com.google.common.collect;

import com.google.common.collect.ae$com.google.common.collect.af;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class ag extends af implements Set<Entry<K, V>> {
    final /* synthetic */ ae b;

    private ag(ae aeVar) {
        this.b = aeVar;
        super(aeVar);
    }

    public boolean equals(@Nullable Object obj) {
        return hz.a((Set) this, obj);
    }

    public int hashCode() {
        return hz.a((Set) this);
    }
}
