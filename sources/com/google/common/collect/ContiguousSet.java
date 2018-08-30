package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.s;

@GwtCompatible(emulated = true)
@Beta
public abstract class ContiguousSet<C extends Comparable> extends ImmutableSortedSet<C> {
    /* renamed from: a */
    public ContiguousSet<C> headSet(C c) {
        return b((Comparable) s.a((Object) c), false);
    }

    /* renamed from: a */
    public ContiguousSet<C> subSet(C c, C c2) {
        s.a((Object) c);
        s.a((Object) c2);
        s.a(comparator().compare(c, c2) <= 0);
        return a((Comparable) c, true, (Comparable) c2, false);
    }

    @GwtIncompatible("NavigableSet")
    /* renamed from: a */
    public ContiguousSet<C> headSet(C c, boolean z) {
        return b((Comparable) s.a((Object) c), z);
    }

    @GwtIncompatible("NavigableSet")
    /* renamed from: a */
    public ContiguousSet<C> subSet(C c, boolean z, C c2, boolean z2) {
        s.a((Object) c);
        s.a((Object) c2);
        s.a(comparator().compare(c, c2) <= 0);
        return a((Comparable) c, z, (Comparable) c2, z2);
    }

    /* renamed from: b */
    public ContiguousSet<C> tailSet(C c) {
        return a((Comparable) s.a((Object) c), true);
    }

    @GwtIncompatible("NavigableSet")
    /* renamed from: b */
    public ContiguousSet<C> tailSet(C c, boolean z) {
        return a((Comparable) s.a((Object) c), z);
    }

    /* renamed from: b */
    abstract ContiguousSet<C> a(C c, boolean z, C c2, boolean z2);

    /* renamed from: c */
    abstract ContiguousSet<C> b(C c, boolean z);

    /* renamed from: d */
    abstract ContiguousSet<C> a(C c, boolean z);

    public abstract Range<C> d_();

    public String toString() {
        return d_().toString();
    }
}
