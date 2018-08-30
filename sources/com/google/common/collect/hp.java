package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset.Entry;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(serializable = true)
class hp<E> extends ImmutableMultiset<E> {
    private final transient ImmutableMap<E, Integer> a;
    private final transient int b;

    hp(ImmutableMap<E, Integer> immutableMap, int i) {
        this.a = immutableMap;
        this.b = i;
    }

    Entry<E> a(int i) {
        Map.Entry entry = (Map.Entry) this.a.entrySet().b().get(i);
        return gv.a(entry.getKey(), ((Integer) entry.getValue()).intValue());
    }

    boolean c() {
        return this.a.e();
    }

    public boolean contains(@Nullable Object obj) {
        return this.a.containsKey(obj);
    }

    public int count(@Nullable Object obj) {
        Integer num = (Integer) this.a.get(obj);
        return num == null ? 0 : num.intValue();
    }

    /* renamed from: g */
    public ImmutableSet<E> elementSet() {
        return this.a.keySet();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public int size() {
        return this.b;
    }
}
