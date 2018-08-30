package com.google.common.collect;

import com.google.common.base.t;
import java.util.Collection;

class ir extends go<R, V> {
    final /* synthetic */ in b;

    ir(in inVar) {
        this.b = inVar;
        super(inVar);
    }

    public boolean remove(Object obj) {
        return obj != null && this.b.a(Maps.b(t.a(obj)));
    }

    public boolean removeAll(Collection<?> collection) {
        return this.b.a(Maps.b(t.a((Collection) collection)));
    }

    public boolean retainAll(Collection<?> collection) {
        return this.b.a(Maps.b(t.a(t.a((Collection) collection))));
    }
}
