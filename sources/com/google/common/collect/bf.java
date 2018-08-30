package com.google.common.collect;

import com.google.common.collect.ConcurrentHashMultiset.AnonymousClass1;
import com.google.common.collect.Multiset.Entry;
import com.google.common.collect.ai$com.google.common.collect.ak;
import java.util.Collection;
import java.util.List;

class bf extends ak {
    final /* synthetic */ ConcurrentHashMultiset b;

    private bf(ConcurrentHashMultiset concurrentHashMultiset) {
        this.b = concurrentHashMultiset;
        super(concurrentHashMultiset);
    }

    /* synthetic */ bf(ConcurrentHashMultiset concurrentHashMultiset, AnonymousClass1 anonymousClass1) {
        this(concurrentHashMultiset);
    }

    private List<Entry<E>> c() {
        Collection c = fb.c(size());
        er.a(c, iterator());
        return c;
    }

    /* renamed from: b */
    ConcurrentHashMultiset<E> a() {
        return this.b;
    }

    public Object[] toArray() {
        return c().toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return c().toArray(tArr);
    }
}
