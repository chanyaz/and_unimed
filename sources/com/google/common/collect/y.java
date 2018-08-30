package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.j$com.google.common.collect.aa;
import com.google.common.collect.j$com.google.common.collect.u;
import java.util.Iterator;
import java.util.NavigableSet;
import javax.annotation.Nullable;

@GwtIncompatible("NavigableSet")
class y extends aa implements NavigableSet<V> {
    final /* synthetic */ j a;

    y(j jVar, @Nullable K k, NavigableSet<V> navigableSet, @Nullable u uVar) {
        this.a = jVar;
        super(jVar, k, navigableSet, uVar);
    }

    private NavigableSet<V> a(NavigableSet<V> navigableSet) {
        u thisR;
        j jVar = this.a;
        Object obj = this.b;
        if (f() != null) {
            thisR = f();
        }
        return new y(jVar, obj, navigableSet, thisR);
    }

    public V ceiling(V v) {
        return h().ceiling(v);
    }

    public Iterator<V> descendingIterator() {
        return new v(this, h().descendingIterator());
    }

    public NavigableSet<V> descendingSet() {
        return a(h().descendingSet());
    }

    public V floor(V v) {
        return h().floor(v);
    }

    /* renamed from: g */
    NavigableSet<V> h() {
        return (NavigableSet) super.h();
    }

    public NavigableSet<V> headSet(V v, boolean z) {
        return a(h().headSet(v, z));
    }

    public V higher(V v) {
        return h().higher(v);
    }

    public V lower(V v) {
        return h().lower(v);
    }

    public V pollFirst() {
        return er.f(iterator());
    }

    public V pollLast() {
        return er.f(descendingIterator());
    }

    public NavigableSet<V> subSet(V v, boolean z, V v2, boolean z2) {
        return a(h().subSet(v, z, v2, z2));
    }

    public NavigableSet<V> tailSet(V v, boolean z) {
        return a(h().tailSet(v, z));
    }
}
