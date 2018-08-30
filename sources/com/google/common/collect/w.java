package com.google.common.collect;

import com.google.common.collect.j$com.google.common.collect.u;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.Nullable;

class w extends u implements List<V> {
    final /* synthetic */ j g;

    w(j jVar, @Nullable K k, List<V> list, @Nullable u uVar) {
        this.g = jVar;
        super(jVar, k, list, uVar);
    }

    public void add(int i, V v) {
        a();
        boolean isEmpty = e().isEmpty();
        g().add(i, v);
        this.g.b = this.g.b + 1;
        if (isEmpty) {
            d();
        }
    }

    public boolean addAll(int i, Collection<? extends V> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = g().addAll(i, collection);
        if (!addAll) {
            return addAll;
        }
        j.a(this.g, e().size() - size);
        if (size != 0) {
            return addAll;
        }
        d();
        return addAll;
    }

    List<V> g() {
        return (List) e();
    }

    public V get(int i) {
        a();
        return g().get(i);
    }

    public int indexOf(Object obj) {
        a();
        return g().indexOf(obj);
    }

    public int lastIndexOf(Object obj) {
        a();
        return g().lastIndexOf(obj);
    }

    public ListIterator<V> listIterator() {
        a();
        return new x(this);
    }

    public ListIterator<V> listIterator(int i) {
        a();
        return new x(this, i);
    }

    public V remove(int i) {
        a();
        V remove = g().remove(i);
        this.g.b = this.g.b - 1;
        b();
        return remove;
    }

    public V set(int i, V v) {
        a();
        return g().set(i, v);
    }

    public List<V> subList(int i, int i2) {
        u thisR;
        a();
        j jVar = this.g;
        Object c = c();
        List subList = g().subList(i, i2);
        if (f() != null) {
            thisR = f();
        }
        return jVar.a(c, subList, thisR);
    }
}
