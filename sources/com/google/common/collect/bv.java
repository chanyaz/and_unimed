package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import com.google.common.base.s;
import java.util.Iterator;
import javax.annotation.CheckReturnValue;

@GwtCompatible(emulated = true)
public abstract class bv<E> implements Iterable<E> {
    private final Iterable<E> a;

    protected bv() {
        this.a = this;
    }

    bv(Iterable<E> iterable) {
        this.a = (Iterable) s.a((Object) iterable);
    }

    public static <E> bv<E> a(final Iterable<E> iterable) {
        return iterable instanceof bv ? (bv) iterable : new bv<E>(iterable) {
            public Iterator<E> iterator() {
                return iterable.iterator();
            }
        };
    }

    public final ImmutableSet<E> a() {
        return ImmutableSet.a(this.a);
    }

    @CheckReturnValue
    public final bv<E> a(Predicate<? super E> predicate) {
        return a(eq.a(this.a, (Predicate) predicate));
    }

    public String toString() {
        return eq.a(this.a);
    }
}
