package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.s;
import java.io.Serializable;
import java.util.Collection;
import java.util.Queue;

@GwtIncompatible("java.util.ArrayDeque")
@Beta
public final class EvictingQueue<E> extends cd<E> implements Serializable {
    private static final long serialVersionUID = 0;
    @VisibleForTesting
    final int a;
    private final Queue<E> b;

    /* renamed from: a */
    protected Queue<E> c() {
        return this.b;
    }

    public boolean add(E e) {
        s.a((Object) e);
        if (this.a != 0) {
            if (size() == this.a) {
                this.b.remove();
            }
            this.b.add(e);
        }
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        return b(collection);
    }

    public boolean contains(Object obj) {
        return c().contains(s.a(obj));
    }

    public boolean offer(E e) {
        return add(e);
    }

    public boolean remove(Object obj) {
        return c().remove(s.a(obj));
    }
}
