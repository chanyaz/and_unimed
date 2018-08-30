package com.google.common.collect;

import com.google.common.base.t;
import java.util.Collection;

class iq extends gm<R, V> {
    final /* synthetic */ in a;

    iq(in inVar) {
        this.a = inVar;
        super(inVar);
    }

    public boolean contains(Object obj) {
        return this.a.b.contains(obj, this.a.a);
    }

    public boolean remove(Object obj) {
        return this.a.b.remove(obj, this.a.a) != null;
    }

    public boolean retainAll(Collection<?> collection) {
        return this.a.a(Maps.a(t.a(t.a((Collection) collection))));
    }
}
