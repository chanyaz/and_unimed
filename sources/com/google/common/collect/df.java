package com.google.common.collect;

import com.google.common.base.s;
import javax.annotation.Nullable;

class df<E> extends ImmutableList<E> {
    private final transient ImmutableList<E> a;

    df(ImmutableList<E> immutableList) {
        this.a = immutableList;
    }

    private int b(int i) {
        return (size() - 1) - i;
    }

    private int c(int i) {
        return size() - i;
    }

    /* renamed from: a */
    public ImmutableList<E> subList(int i, int i2) {
        s.a(i, i2, size());
        return this.a.subList(c(i2), c(i)).h();
    }

    boolean c() {
        return this.a.c();
    }

    public boolean contains(@Nullable Object obj) {
        return this.a.contains(obj);
    }

    public E get(int i) {
        s.a(i, size());
        return this.a.get(b(i));
    }

    public ImmutableList<E> h() {
        return this.a;
    }

    public int indexOf(@Nullable Object obj) {
        int lastIndexOf = this.a.lastIndexOf(obj);
        return lastIndexOf >= 0 ? b(lastIndexOf) : -1;
    }

    public int lastIndexOf(@Nullable Object obj) {
        int indexOf = this.a.indexOf(obj);
        return indexOf >= 0 ? b(indexOf) : -1;
    }

    public int size() {
        return this.a.size();
    }
}
