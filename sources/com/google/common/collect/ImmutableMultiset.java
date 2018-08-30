package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Multiset.Entry;
import com.google.common.primitives.b;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableMultiset<E> extends ImmutableCollection<E> implements Multiset<E> {
    private static final ImmutableMultiset<Object> a = new hp(ImmutableMap.i(), 0);
    private transient ImmutableSet<Entry<E>> b;

    ImmutableMultiset() {
    }

    private static <E> ImmutableMultiset<E> a(Multiset<? extends E> multiset) {
        return a(multiset.entrySet());
    }

    public static <E> ImmutableMultiset<E> a(Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableMultiset) {
            ImmutableMultiset<E> immutableMultiset = (ImmutableMultiset) iterable;
            if (!immutableMultiset.c()) {
                return immutableMultiset;
            }
        }
        return a(iterable instanceof Multiset ? gv.b((Iterable) iterable) : LinkedHashMultiset.a((Iterable) iterable));
    }

    static <E> ImmutableMultiset<E> a(Collection<? extends Entry<? extends E>> collection) {
        di j = ImmutableMap.j();
        long j2 = 0;
        for (Entry entry : collection) {
            long j3;
            int count = entry.getCount();
            if (count > 0) {
                j.b(entry.getElement(), Integer.valueOf(count));
                j3 = ((long) count) + j2;
            } else {
                j3 = j2;
            }
            j2 = j3;
        }
        return j2 == 0 ? d() : new hp(j.b(), b.a(j2));
    }

    public static <E> ImmutableMultiset<E> d() {
        return a;
    }

    private final ImmutableSet<Entry<E>> g() {
        return isEmpty() ? ImmutableSet.g() : new dy(this, null);
    }

    @GwtIncompatible("not present in emulated superclass")
    int a(Object[] objArr, int i) {
        Iterator it = entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            Arrays.fill(objArr, i, entry.getCount() + i, entry.getElement());
            i += entry.getCount();
        }
        return i;
    }

    abstract Entry<E> a(int i);

    @Deprecated
    public final int add(E e, int i) {
        throw new UnsupportedOperationException();
    }

    public boolean contains(@Nullable Object obj) {
        return count(obj) > 0;
    }

    public boolean containsAll(Collection<?> collection) {
        return elementSet().containsAll(collection);
    }

    /* renamed from: e */
    public ImmutableSet<Entry<E>> entrySet() {
        ImmutableSet<Entry<E>> immutableSet = this.b;
        if (immutableSet != null) {
            return immutableSet;
        }
        immutableSet = g();
        this.b = immutableSet;
        return immutableSet;
    }

    public boolean equals(@Nullable Object obj) {
        return gv.a((Multiset) this, obj);
    }

    /* renamed from: h_ */
    public jl<E> iterator() {
        final Iterator h_ = entrySet().iterator();
        return new jl<E>() {
            int a;
            E b;

            public boolean hasNext() {
                return this.a > 0 || h_.hasNext();
            }

            public E next() {
                if (this.a <= 0) {
                    Entry entry = (Entry) h_.next();
                    this.b = entry.getElement();
                    this.a = entry.getCount();
                }
                this.a--;
                return this.b;
            }
        };
    }

    public int hashCode() {
        return hz.a(entrySet());
    }

    @Deprecated
    public final int remove(Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final int setCount(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean setCount(E e, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return entrySet().toString();
    }

    Object writeReplace() {
        return new ea(this);
    }
}
