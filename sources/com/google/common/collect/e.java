package com.google.common.collect;

import java.util.Iterator;
import java.util.Set;

class e extends ce<V> {
    final Set<V> a;
    final /* synthetic */ a b;

    private e(a aVar) {
        this.b = aVar;
        this.a = this.b.a.keySet();
    }

    /* renamed from: a */
    protected Set<V> c() {
        return this.a;
    }

    public Iterator<V> iterator() {
        return Maps.b(this.b.entrySet().iterator());
    }

    public Object[] toArray() {
        return h();
    }

    public <T> T[] toArray(T[] tArr) {
        return a((Object[]) tArr);
    }

    public String toString() {
        return g();
    }
}
