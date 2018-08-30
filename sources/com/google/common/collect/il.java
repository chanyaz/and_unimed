package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import com.google.common.base.s;
import com.google.common.collect.Table.Cell;
import com.google.common.collect.il$com.google.common.collect.iu;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
class il<R, C, V> extends ar<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    @GwtTransient
    final Map<R, Map<C, V>> a;
    @GwtTransient
    final Supplier<? extends Map<C, V>> b;
    private transient Set<C> c;
    private transient Map<R, Map<C, V>> d;
    private transient iu e;

    il(Map<R, Map<C, V>> map, Supplier<? extends Map<C, V>> supplier) {
        this.a = map;
        this.b = supplier;
    }

    private Map<C, V> a(R r) {
        Map<C, V> map = (Map) this.a.get(r);
        if (map != null) {
            return map;
        }
        map = (Map) this.b.get();
        this.a.put(r, map);
        return map;
    }

    private boolean a(Object obj, Object obj2, Object obj3) {
        return obj3 != null && obj3.equals(get(obj, obj2));
    }

    private Map<R, V> b(Object obj) {
        Map<R, V> linkedHashMap = new LinkedHashMap();
        Iterator it = this.a.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            Object remove = ((Map) entry.getValue()).remove(obj);
            if (remove != null) {
                linkedHashMap.put(entry.getKey(), remove);
                if (((Map) entry.getValue()).isEmpty()) {
                    it.remove();
                }
            }
        }
        return linkedHashMap;
    }

    private boolean b(Object obj, Object obj2, Object obj3) {
        if (!a(obj, obj2, obj3)) {
            return false;
        }
        remove(obj, obj2);
        return true;
    }

    Iterator<Cell<R, C, V>> b() {
        return new im(this, null);
    }

    public Set<Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }

    public void clear() {
        this.a.clear();
    }

    public Map<R, V> column(C c) {
        return new in(this, c);
    }

    public Set<C> columnKeySet() {
        Set<C> set = this.c;
        if (set != null) {
            return set;
        }
        it itVar = new it(this);
        this.c = itVar;
        return itVar;
    }

    public Map<C, Map<R, V>> columnMap() {
        Map map = this.e;
        if (map != null) {
            return map;
        }
        map = new iu(this, null);
        this.e = map;
        return map;
    }

    public boolean contains(@Nullable Object obj, @Nullable Object obj2) {
        return (obj == null || obj2 == null || !super.contains(obj, obj2)) ? false : true;
    }

    public boolean containsColumn(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        for (Map b : this.a.values()) {
            if (Maps.b(b, obj)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsRow(@Nullable Object obj) {
        return obj != null && Maps.b(this.a, obj);
    }

    public boolean containsValue(@Nullable Object obj) {
        return obj != null && super.containsValue(obj);
    }

    Map<R, Map<C, V>> f() {
        return new iz(this);
    }

    Iterator<C> g() {
        return new is(this, null);
    }

    public V get(@Nullable Object obj, @Nullable Object obj2) {
        return (obj == null || obj2 == null) ? null : super.get(obj, obj2);
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public V put(R r, C c, V v) {
        s.a((Object) r);
        s.a((Object) c);
        s.a((Object) v);
        return a(r).put(c, v);
    }

    public V remove(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null || obj2 == null) {
            return null;
        }
        Map map = (Map) Maps.a(this.a, obj);
        if (map == null) {
            return null;
        }
        V remove = map.remove(obj2);
        if (map.isEmpty()) {
            this.a.remove(obj);
        }
        return remove;
    }

    public Map<C, V> row(R r) {
        return new ix(this, r);
    }

    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    public Map<R, Map<C, V>> rowMap() {
        Map<R, Map<C, V>> map = this.d;
        if (map != null) {
            return map;
        }
        map = f();
        this.d = map;
        return map;
    }

    public int size() {
        int i = 0;
        Iterator it = this.a.values().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = ((Map) it.next()).size() + i2;
        }
    }

    public Collection<V> values() {
        return super.values();
    }
}
