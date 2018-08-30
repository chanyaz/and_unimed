package com.google.common.collect;

import com.google.common.base.s;

abstract class cx<E> extends cy<E> {
    Object[] a;
    int b = 0;

    cx(int i) {
        ba.a(i, "initialCapacity");
        this.a = new Object[i];
    }

    private void a(int i) {
        if (this.a.length < i) {
            this.a = hc.b(this.a, cy.a(this.a.length, i));
        }
    }

    /* renamed from: a */
    public cx<E> b(E e) {
        s.a((Object) e);
        a(this.b + 1);
        Object[] objArr = this.a;
        int i = this.b;
        this.b = i + 1;
        objArr[i] = e;
        return this;
    }

    public cy<E> a(E... eArr) {
        hc.a(eArr);
        a(this.b + eArr.length);
        System.arraycopy(eArr, 0, this.a, this.b, eArr.length);
        this.b += eArr.length;
        return this;
    }
}
