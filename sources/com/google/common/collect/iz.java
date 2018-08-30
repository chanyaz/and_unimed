package com.google.common.collect;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class iz extends gl<R, Map<C, V>> {
    final /* synthetic */ il b;

    iz(il ilVar) {
        this.b = ilVar;
    }

    /* renamed from: a */
    public Map<C, V> get(Object obj) {
        return this.b.containsRow(obj) ? this.b.row(obj) : null;
    }

    protected Set<Entry<R, Map<C, V>>> a() {
        return new ja(this);
    }

    /* renamed from: b */
    public Map<C, V> remove(Object obj) {
        return obj == null ? null : (Map) this.b.a.remove(obj);
    }

    public boolean containsKey(Object obj) {
        return this.b.containsRow(obj);
    }
}
