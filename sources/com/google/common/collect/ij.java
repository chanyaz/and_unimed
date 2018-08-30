package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtCompatible
class ij<R, C, V> extends il<R, C, V> implements RowSortedTable<R, C, V> {
    private static final long serialVersionUID = 0;

    ij(SortedMap<R, Map<C, V>> sortedMap, Supplier<? extends Map<C, V>> supplier) {
        super(sortedMap, supplier);
    }

    private SortedMap<R, Map<C, V>> h() {
        return (SortedMap) this.a;
    }

    /* renamed from: e */
    SortedMap<R, Map<C, V>> f() {
        return new ik(this, null);
    }

    public SortedSet<R> rowKeySet() {
        return (SortedSet) rowMap().keySet();
    }

    public SortedMap<R, Map<C, V>> rowMap() {
        return (SortedMap) super.rowMap();
    }
}
