package com.google.common.collect;

import com.google.common.base.s;
import com.google.common.collect.il$com.google.common.collect.iz;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

class ik extends iz implements SortedMap<R, Map<C, V>> {
    final /* synthetic */ ij a;

    private ik(ij ijVar) {
        this.a = ijVar;
        super(ijVar);
    }

    /* renamed from: b */
    public SortedSet<R> keySet() {
        return (SortedSet) super.keySet();
    }

    /* renamed from: c */
    SortedSet<R> h() {
        return new gn(this);
    }

    public Comparator<? super R> comparator() {
        return this.a.h().comparator();
    }

    public R firstKey() {
        return this.a.h().firstKey();
    }

    public SortedMap<R, Map<C, V>> headMap(R r) {
        s.a((Object) r);
        return new ij(this.a.h().headMap(r), this.a.b).rowMap();
    }

    public R lastKey() {
        return this.a.h().lastKey();
    }

    public SortedMap<R, Map<C, V>> subMap(R r, R r2) {
        s.a((Object) r);
        s.a((Object) r2);
        return new ij(this.a.h().subMap(r, r2), this.a.b).rowMap();
    }

    public SortedMap<R, Map<C, V>> tailMap(R r) {
        s.a((Object) r);
        return new ij(this.a.h().tailMap(r), this.a.b).rowMap();
    }
}
