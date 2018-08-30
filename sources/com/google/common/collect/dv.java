package com.google.common.collect;

import com.google.common.collect.Multiset.Entry;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class dv extends ImmutableMultiset<K> {
    final /* synthetic */ ImmutableMultimap a;

    dv(ImmutableMultimap immutableMultimap) {
        this.a = immutableMultimap;
    }

    Entry<K> a(int i) {
        Map.Entry entry = (Map.Entry) this.a.a.entrySet().b().get(i);
        return gv.a(entry.getKey(), ((Collection) entry.getValue()).size());
    }

    boolean c() {
        return true;
    }

    public boolean contains(@Nullable Object obj) {
        return this.a.containsKey(obj);
    }

    public int count(@Nullable Object obj) {
        Collection collection = (Collection) this.a.a.get(obj);
        return collection == null ? 0 : collection.size();
    }

    public Set<K> elementSet() {
        return this.a.keySet();
    }

    public int size() {
        return this.a.size();
    }
}
