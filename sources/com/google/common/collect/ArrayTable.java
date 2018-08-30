package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.o;
import com.google.common.base.s;
import com.google.common.collect.ArrayTable$com.google.common.collect.aw;
import com.google.common.collect.ArrayTable$com.google.common.collect.ay;
import com.google.common.collect.Table.Cell;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
@Beta
public final class ArrayTable<R, C, V> extends ar<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    private final ImmutableList<R> a;
    private final ImmutableList<C> b;
    private final ImmutableMap<R, Integer> c;
    private final ImmutableMap<C, Integer> d;
    private final V[][] e;
    private transient aw f;
    private transient ay g;

    public V a(int i, int i2) {
        s.a(i, this.a.size());
        s.a(i2, this.b.size());
        return this.e[i][i2];
    }

    public V a(int i, int i2, @Nullable V v) {
        s.a(i, this.a.size());
        s.a(i2, this.b.size());
        V v2 = this.e[i][i2];
        this.e[i][i2] = v;
        return v2;
    }

    Iterator<Cell<R, C, V>> b() {
        return new f<Cell<R, C, V>>(size()) {
            /* renamed from: b */
            protected Cell<R, C, V> a(final int i) {
                return new jd<R, C, V>() {
                    final int a = (i / ArrayTable.this.b.size());
                    final int b = (i % ArrayTable.this.b.size());

                    public C getColumnKey() {
                        return ArrayTable.this.b.get(this.b);
                    }

                    public R getRowKey() {
                        return ArrayTable.this.a.get(this.a);
                    }

                    public V getValue() {
                        return ArrayTable.this.a(this.a, this.b);
                    }
                };
            }
        };
    }

    public Set<Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    public Map<R, V> column(C c) {
        s.a((Object) c);
        Integer num = (Integer) this.d.get(c);
        return num == null ? ImmutableMap.i() : new av(this, num.intValue());
    }

    public Map<C, Map<R, V>> columnMap() {
        Map map = this.f;
        if (map != null) {
            return map;
        }
        map = new aw(this, null);
        this.f = map;
        return map;
    }

    public boolean contains(@Nullable Object obj, @Nullable Object obj2) {
        return containsRow(obj) && containsColumn(obj2);
    }

    public boolean containsColumn(@Nullable Object obj) {
        return this.d.containsKey(obj);
    }

    public boolean containsRow(@Nullable Object obj) {
        return this.c.containsKey(obj);
    }

    public boolean containsValue(@Nullable Object obj) {
        for (Object[] objArr : this.e) {
            for (Object a : r3[r2]) {
                if (o.a(obj, a)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: e */
    public ImmutableSet<C> columnKeySet() {
        return this.d.keySet();
    }

    /* renamed from: f */
    public ImmutableSet<R> rowKeySet() {
        return this.c.keySet();
    }

    public V get(@Nullable Object obj, @Nullable Object obj2) {
        Integer num = (Integer) this.c.get(obj);
        Integer num2 = (Integer) this.d.get(obj2);
        return (num == null || num2 == null) ? null : a(num.intValue(), num2.intValue());
    }

    public boolean isEmpty() {
        return false;
    }

    public V put(R r, C c, @Nullable V v) {
        s.a((Object) r);
        s.a((Object) c);
        Integer num = (Integer) this.c.get(r);
        s.a(num != null, "Row %s not in %s", r, this.a);
        Integer num2 = (Integer) this.d.get(c);
        s.a(num2 != null, "Column %s not in %s", c, this.b);
        return a(num.intValue(), num2.intValue(), v);
    }

    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        super.putAll(table);
    }

    @Deprecated
    public V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    public Map<C, V> row(R r) {
        s.a((Object) r);
        Integer num = (Integer) this.c.get(r);
        return num == null ? ImmutableMap.i() : new ax(this, num.intValue());
    }

    public Map<R, Map<C, V>> rowMap() {
        Map map = this.g;
        if (map != null) {
            return map;
        }
        map = new ay(this, null);
        this.g = map;
        return map;
    }

    public int size() {
        return this.a.size() * this.b.size();
    }

    public Collection<V> values() {
        return super.values();
    }
}
