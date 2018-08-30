package com.google.common.collect;

import com.google.common.collect.j$com.google.common.collect.u;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

class z extends u implements Set<V> {
    final /* synthetic */ j a;

    z(j jVar, @Nullable K k, Set<V> set) {
        this.a = jVar;
        super(jVar, k, set, null);
    }

    public boolean removeAll(Collection<?> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean a = hz.a((Set) this.c, (Collection) collection);
        if (!a) {
            return a;
        }
        j.a(this.a, this.c.size() - size);
        b();
        return a;
    }
}
