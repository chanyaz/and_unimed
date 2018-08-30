package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.base.s;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class in extends gl<R, V> {
    final C a;
    final /* synthetic */ il b;

    in(il ilVar, C c) {
        this.b = ilVar;
        this.a = s.a((Object) c);
    }

    Set<Entry<R, V>> a() {
        return new io(this, null);
    }

    boolean a(Predicate<? super Entry<R, V>> predicate) {
        boolean z = false;
        Iterator it = this.b.a.entrySet().iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            Entry entry = (Entry) it.next();
            Map map = (Map) entry.getValue();
            Object obj = map.get(this.a);
            if (obj != null && predicate.apply(Maps.a(entry.getKey(), obj))) {
                map.remove(this.a);
                z2 = true;
                if (map.isEmpty()) {
                    it.remove();
                }
            }
            z = z2;
        }
    }

    public boolean containsKey(Object obj) {
        return this.b.contains(obj, this.a);
    }

    public V get(Object obj) {
        return this.b.get(obj, this.a);
    }

    Set<R> h() {
        return new iq(this);
    }

    Collection<V> i() {
        return new ir(this);
    }

    public V put(R r, V v) {
        return this.b.put(r, this.a, v);
    }

    public V remove(Object obj) {
        return this.b.remove(obj, this.a);
    }
}
