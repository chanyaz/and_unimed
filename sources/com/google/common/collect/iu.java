package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class iu extends gl<C, Map<R, V>> {
    final /* synthetic */ il a;

    private iu(il ilVar) {
        this.a = ilVar;
    }

    /* renamed from: a */
    public Map<R, V> get(Object obj) {
        return this.a.containsColumn(obj) ? this.a.column(obj) : null;
    }

    public Set<Entry<C, Map<R, V>>> a() {
        return new iv(this);
    }

    /* renamed from: b */
    public Map<R, V> remove(Object obj) {
        return this.a.containsColumn(obj) ? this.a.b(obj) : null;
    }

    public boolean containsKey(Object obj) {
        return this.a.containsColumn(obj);
    }

    Collection<Map<R, V>> i() {
        return new iw(this);
    }

    public Set<C> keySet() {
        return this.a.columnKeySet();
    }
}
