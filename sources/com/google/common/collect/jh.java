package com.google.common.collect;

import com.google.common.base.s;
import com.google.common.collect.il$com.google.common.collect.ix;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.Nullable;

class jh extends ix implements SortedMap<C, V> {
    @Nullable
    final C d;
    @Nullable
    final C e;
    transient SortedMap<C, V> f;
    final /* synthetic */ TreeBasedTable g;

    jh(TreeBasedTable treeBasedTable, R r) {
        this(treeBasedTable, r, null, null);
    }

    jh(TreeBasedTable treeBasedTable, R r, @Nullable C c, @Nullable C c2) {
        this.g = treeBasedTable;
        super(treeBasedTable, r);
        this.d = c;
        this.e = c2;
        boolean z = c == null || c2 == null || a(c, c2) <= 0;
        s.a(z);
    }

    int a(Object obj, Object obj2) {
        return comparator().compare(obj, obj2);
    }

    boolean a(@Nullable Object obj) {
        return obj != null && ((this.d == null || a(this.d, obj) <= 0) && (this.e == null || a(this.e, obj) > 0));
    }

    public Comparator<? super C> comparator() {
        return this.g.h();
    }

    public boolean containsKey(Object obj) {
        return a(obj) && super.containsKey(obj);
    }

    void d() {
        if (f() != null && this.f.isEmpty()) {
            this.g.a.remove(this.a);
            this.f = null;
            this.b = null;
        }
    }

    /* renamed from: e */
    public SortedSet<C> keySet() {
        return new gn(this);
    }

    SortedMap<C, V> f() {
        if (this.f == null || (this.f.isEmpty() && this.g.a.containsKey(this.a))) {
            this.f = (SortedMap) this.g.a.get(this.a);
        }
        return this.f;
    }

    public C firstKey() {
        if (b() != null) {
            return b().firstKey();
        }
        throw new NoSuchElementException();
    }

    /* renamed from: g */
    SortedMap<C, V> b() {
        return (SortedMap) super.b();
    }

    public SortedMap<C, V> headMap(C c) {
        s.a(a(s.a((Object) c)));
        return new jh(this.g, this.a, this.d, c);
    }

    /* renamed from: j */
    SortedMap<C, V> c() {
        SortedMap<C, V> f = f();
        if (f == null) {
            return null;
        }
        if (this.d != null) {
            f = f.tailMap(this.d);
        }
        return this.e != null ? f.headMap(this.e) : f;
    }

    public C lastKey() {
        if (b() != null) {
            return b().lastKey();
        }
        throw new NoSuchElementException();
    }

    public V put(C c, V v) {
        s.a(a(s.a((Object) c)));
        return super.put(c, v);
    }

    public SortedMap<C, V> subMap(C c, C c2) {
        boolean z = a(s.a((Object) c)) && a(s.a((Object) c2));
        s.a(z);
        return new jh(this.g, this.a, c, c2);
    }

    public SortedMap<C, V> tailMap(C c) {
        s.a(a(s.a((Object) c)));
        return new jh(this.g, this.a, c, this.e);
    }
}
