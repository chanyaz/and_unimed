package com.google.common.collect;

import java.util.Map.Entry;
import javax.annotation.Nullable;

final class hh extends ImmutableBiMap<V, K> {
    final /* synthetic */ hg a;

    private hh(hg hgVar) {
        this.a = hgVar;
    }

    ImmutableSet<Entry<V, K>> c() {
        return new hi(this);
    }

    boolean e() {
        return false;
    }

    public K get(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        for (dk dkVar = this.a.b[cs.a(obj.hashCode()) & this.a.d]; dkVar != null; dkVar = dkVar.b()) {
            if (obj.equals(dkVar.getValue())) {
                return dkVar.getKey();
            }
        }
        return null;
    }

    /* renamed from: i_ */
    public ImmutableBiMap<K, V> inverse() {
        return this.a;
    }

    public int size() {
        return inverse().size();
    }

    Object writeReplace() {
        return new hj(this.a);
    }
}
