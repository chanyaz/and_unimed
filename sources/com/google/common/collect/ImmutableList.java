package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.s;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {
    private static final ImmutableList<Object> a = new hl(hc.a);

    ImmutableList() {
    }

    public static <E> ImmutableList<E> a(E e) {
        return new id(e);
    }

    public static <E> ImmutableList<E> a(E[] eArr) {
        switch (eArr.length) {
            case 0:
                return e();
            case 1:
                return new id(eArr[0]);
            default:
                return new hl(hc.a((Object[]) eArr.clone()));
        }
    }

    static <E> ImmutableList<E> b(Object[] objArr) {
        return b(objArr, objArr.length);
    }

    static <E> ImmutableList<E> b(Object[] objArr, int i) {
        switch (i) {
            case 0:
                return e();
            case 1:
                return new id(objArr[0]);
            default:
                if (i < objArr.length) {
                    objArr = hc.b(objArr, i);
                }
                return new hl(objArr);
        }
    }

    public static <E> ImmutableList<E> e() {
        return a;
    }

    public static <E> de<E> i() {
        return new de();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    int a(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    /* renamed from: a */
    public ImmutableList<E> subList(int i, int i2) {
        s.a(i, i2, size());
        switch (i2 - i) {
            case 0:
                return e();
            case 1:
                return a(get(i));
            default:
                return b(i, i2);
        }
    }

    /* renamed from: a */
    public jm<E> listIterator(int i) {
        return new f<E>(size(), i) {
            protected E a(int i) {
                return ImmutableList.this.get(i);
            }
        };
    }

    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public final ImmutableList<E> b() {
        return this;
    }

    ImmutableList<E> b(int i, int i2) {
        return new dh(this, i, i2 - i);
    }

    public boolean contains(@Nullable Object obj) {
        return indexOf(obj) >= 0;
    }

    public boolean equals(@Nullable Object obj) {
        return fb.a((List) this, obj);
    }

    /* renamed from: g */
    public jm<E> listIterator() {
        return listIterator(0);
    }

    public ImmutableList<E> h() {
        return new df(this);
    }

    /* renamed from: h_ */
    public jl<E> iterator() {
        return listIterator();
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < size(); i2++) {
            i = (((i * 31) + get(i2).hashCode()) ^ -1) ^ -1;
        }
        return i;
    }

    public int indexOf(@Nullable Object obj) {
        return obj == null ? -1 : fb.b(this, obj);
    }

    public int lastIndexOf(@Nullable Object obj) {
        return obj == null ? -1 : fb.c(this, obj);
    }

    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    Object writeReplace() {
        return new dg(toArray());
    }
}
