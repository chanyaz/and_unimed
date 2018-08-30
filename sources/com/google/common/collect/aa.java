package com.google.common.collect;

import com.google.common.collect.j$com.google.common.collect.u;
import java.util.Comparator;
import java.util.SortedSet;
import javax.annotation.Nullable;

class aa extends u implements SortedSet<V> {
    final /* synthetic */ j g;

    aa(j jVar, @Nullable K k, SortedSet<V> sortedSet, @Nullable u uVar) {
        this.g = jVar;
        super(jVar, k, sortedSet, uVar);
    }

    public Comparator<? super V> comparator() {
        return h().comparator();
    }

    public V first() {
        a();
        return h().first();
    }

    SortedSet<V> h() {
        return (SortedSet) e();
    }

    public SortedSet<V> headSet(V v) {
        u thisR;
        a();
        j jVar = this.g;
        Object c = c();
        SortedSet headSet = h().headSet(v);
        if (f() != null) {
            thisR = f();
        }
        return new aa(jVar, c, headSet, thisR);
    }

    public V last() {
        a();
        return h().last();
    }

    public SortedSet<V> subSet(V v, V v2) {
        u thisR;
        a();
        j jVar = this.g;
        Object c = c();
        SortedSet subSet = h().subSet(v, v2);
        if (f() != null) {
            thisR = f();
        }
        return new aa(jVar, c, subSet, thisR);
    }

    public SortedSet<V> tailSet(V v) {
        u thisR;
        a();
        j jVar = this.g;
        Object c = c();
        SortedSet tailSet = h().tailSet(v);
        if (f() != null) {
            thisR = f();
        }
        return new aa(jVar, c, tailSet, thisR);
    }
}
