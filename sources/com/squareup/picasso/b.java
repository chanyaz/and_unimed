package com.squareup.picasso;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

class b<M> extends WeakReference<M> {
    final a a;

    public b(a aVar, M m, ReferenceQueue<? super M> referenceQueue) {
        super(m, referenceQueue);
        this.a = aVar;
    }
}
