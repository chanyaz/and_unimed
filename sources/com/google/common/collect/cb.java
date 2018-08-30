package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset.Entry;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class cb<E> extends bw<E> implements Multiset<E> {
    protected cb() {
    }

    public int add(E e, int i) {
        return c().add(e, i);
    }

    @Beta
    protected boolean b(Collection<? extends E> collection) {
        return gv.a((Multiset) this, (Collection) collection);
    }

    protected boolean c(Collection<?> collection) {
        return gv.b(this, collection);
    }

    public int count(Object obj) {
        return c().count(obj);
    }

    protected boolean d(Collection<?> collection) {
        return gv.c(this, collection);
    }

    /* renamed from: e */
    protected abstract Multiset<E> c();

    public Set<E> elementSet() {
        return c().elementSet();
    }

    public Set<Entry<E>> entrySet() {
        return c().entrySet();
    }

    public boolean equals(@Nullable Object obj) {
        return obj == this || c().equals(obj);
    }

    protected String g() {
        return entrySet().toString();
    }

    public int hashCode() {
        return c().hashCode();
    }

    public int remove(Object obj, int i) {
        return c().remove(obj, i);
    }

    public int setCount(E e, int i) {
        return c().setCount(e, i);
    }

    public boolean setCount(E e, int i, int i2) {
        return c().setCount(e, i, i2);
    }
}
