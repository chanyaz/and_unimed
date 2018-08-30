package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.s;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
    private transient ImmutableList<E> a;

    ImmutableCollection() {
    }

    int a(Object[] objArr, int i) {
        Iterator it = iterator();
        while (it.hasNext()) {
            int i2 = i + 1;
            objArr[i] = it.next();
            i = i2;
        }
        return i;
    }

    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> b() {
        ImmutableList<E> immutableList = this.a;
        if (immutableList != null) {
            return immutableList;
        }
        immutableList = f();
        this.a = immutableList;
        return immutableList;
    }

    abstract boolean c();

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean contains(@Nullable Object obj) {
        return obj != null && super.contains(obj);
    }

    ImmutableList<E> f() {
        switch (size()) {
            case 0:
                return ImmutableList.e();
            case 1:
                return ImmutableList.a(iterator().next());
            default:
                return new hf(this, toArray());
        }
    }

    /* renamed from: h_ */
    public abstract jl<E> iterator();

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public final Object[] toArray() {
        if (size() == 0) {
            return hc.a;
        }
        Object[] objArr = new Object[size()];
        a(objArr, 0);
        return objArr;
    }

    public final <T> T[] toArray(T[] tArr) {
        s.a((Object) tArr);
        int size = size();
        if (tArr.length < size) {
            tArr = hc.a((Object[]) tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        a(tArr, 0);
        return tArr;
    }

    Object writeReplace() {
        return new dg(toArray());
    }
}
