package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

class es<T> extends jl<T> {
    final Queue<PeekingIterator<T>> a;

    public es(Iterable<? extends Iterator<? extends T>> iterable, final Comparator<? super T> comparator) {
        this.a = new PriorityQueue(2, new Comparator<PeekingIterator<T>>() {
            /* renamed from: a */
            public int compare(PeekingIterator<T> peekingIterator, PeekingIterator<T> peekingIterator2) {
                return comparator.compare(peekingIterator.peek(), peekingIterator2.peek());
            }
        });
        for (Iterator it : iterable) {
            if (it.hasNext()) {
                this.a.add(er.h(it));
            }
        }
    }

    public boolean hasNext() {
        return !this.a.isEmpty();
    }

    public T next() {
        PeekingIterator peekingIterator = (PeekingIterator) this.a.remove();
        T next = peekingIterator.next();
        if (peekingIterator.hasNext()) {
            this.a.add(peekingIterator);
        }
        return next;
    }
}
