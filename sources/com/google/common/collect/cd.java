package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Queue;

@GwtCompatible
public abstract class cd<E> extends bw<E> implements Queue<E> {
    protected cd() {
    }

    /* renamed from: a */
    protected abstract Queue<E> c();

    public E element() {
        return c().element();
    }

    public boolean offer(E e) {
        return c().offer(e);
    }

    public E peek() {
        return c().peek();
    }

    public E poll() {
        return c().poll();
    }

    public E remove() {
        return c().remove();
    }
}
