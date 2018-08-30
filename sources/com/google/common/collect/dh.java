package com.google.common.collect;

import com.google.common.base.s;

class dh extends ImmutableList<E> {
    final transient int a;
    final transient int b;
    final /* synthetic */ ImmutableList c;

    dh(ImmutableList immutableList, int i, int i2) {
        this.c = immutableList;
        this.a = i;
        this.b = i2;
    }

    /* renamed from: a */
    public ImmutableList<E> subList(int i, int i2) {
        s.a(i, i2, this.b);
        return this.c.subList(this.a + i, this.a + i2);
    }

    boolean c() {
        return true;
    }

    public E get(int i) {
        s.a(i, this.b);
        return this.c.get(this.a + i);
    }

    public int size() {
        return this.b;
    }
}
