package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.util.Iterator;
import javax.annotation.Nullable;

final class dw<K, V> extends ImmutableCollection<V> {
    private static final long serialVersionUID = 0;
    private final transient ImmutableMultimap<K, V> a;

    dw(ImmutableMultimap<K, V> immutableMultimap) {
        this.a = immutableMultimap;
    }

    @GwtIncompatible("not present in emulated superclass")
    int a(Object[] objArr, int i) {
        Iterator it = this.a.a.values().iterator();
        while (it.hasNext()) {
            i = ((ImmutableCollection) it.next()).a(objArr, i);
        }
        return i;
    }

    boolean c() {
        return true;
    }

    public boolean contains(@Nullable Object obj) {
        return this.a.containsValue(obj);
    }

    /* renamed from: h_ */
    public jl<V> iterator() {
        return this.a.g();
    }

    public int size() {
        return this.a.size();
    }
}
