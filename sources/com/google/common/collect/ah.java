package com.google.common.collect;

import java.util.AbstractCollection;
import java.util.Iterator;
import javax.annotation.Nullable;

class ah extends AbstractCollection<V> {
    final /* synthetic */ ae a;

    ah(ae aeVar) {
        this.a = aeVar;
    }

    public void clear() {
        this.a.clear();
    }

    public boolean contains(@Nullable Object obj) {
        return this.a.containsValue(obj);
    }

    public Iterator<V> iterator() {
        return this.a.g();
    }

    public int size() {
        return this.a.size();
    }
}
