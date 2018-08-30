package com.google.common.collect;

import com.google.common.base.s;
import com.google.common.collect.Multiset.Entry;
import com.google.common.primitives.b;
import javax.annotation.Nullable;

final class ht<E> extends ImmutableSortedMultiset<E> {
    private final transient hu<E> b;
    private final transient int[] c;
    private final transient long[] d;
    private final transient int e;
    private final transient int f;

    ht(hu<E> huVar, int[] iArr, long[] jArr, int i, int i2) {
        this.b = huVar;
        this.c = iArr;
        this.d = jArr;
        this.e = i;
        this.f = i2;
    }

    ImmutableSortedMultiset<E> a(int i, int i2) {
        s.a(i, i2, this.f);
        return i == i2 ? ImmutableSortedMultiset.a(comparator()) : (i == 0 && i2 == this.f) ? this : new ht((hu) this.b.a(i, i2), this.c, this.d, this.e + i, i2 - i);
    }

    /* renamed from: a */
    public ImmutableSortedMultiset<E> headMultiset(E e, BoundType boundType) {
        return a(0, this.b.e(e, s.a((Object) boundType) == BoundType.CLOSED));
    }

    /* renamed from: a */
    public ImmutableSortedSet<E> elementSet() {
        return this.b;
    }

    Entry<E> a(int i) {
        return gv.a(this.b.b().get(i), this.c[this.e + i]);
    }

    /* renamed from: b */
    public ImmutableSortedMultiset<E> tailMultiset(E e, BoundType boundType) {
        return a(this.b.f(e, s.a((Object) boundType) == BoundType.CLOSED), this.f);
    }

    boolean c() {
        return this.e > 0 || this.f < this.c.length;
    }

    public int count(@Nullable Object obj) {
        int c = this.b.c(obj);
        return c == -1 ? 0 : this.c[c + this.e];
    }

    public Entry<E> firstEntry() {
        return a(0);
    }

    public Entry<E> lastEntry() {
        return a(this.f - 1);
    }

    public int size() {
        return b.a(this.d[this.e + this.f] - this.d[this.e]);
    }
}
