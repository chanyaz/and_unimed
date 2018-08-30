package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Table.Cell;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
abstract class ar<R, C, V> implements Table<R, C, V> {
    private transient Set<Cell<R, C, V>> a;
    private transient Collection<V> b;

    ar() {
    }

    Set<Cell<R, C, V>> a() {
        return new as(this);
    }

    abstract Iterator<Cell<R, C, V>> b();

    Collection<V> c() {
        return new at(this);
    }

    public Set<Cell<R, C, V>> cellSet() {
        Set<Cell<R, C, V>> set = this.a;
        if (set != null) {
            return set;
        }
        set = a();
        this.a = set;
        return set;
    }

    public void clear() {
        er.g(cellSet().iterator());
    }

    public Set<C> columnKeySet() {
        return columnMap().keySet();
    }

    public boolean contains(@Nullable Object obj, @Nullable Object obj2) {
        Map map = (Map) Maps.a(rowMap(), obj);
        return map != null && Maps.b(map, obj2);
    }

    public boolean containsColumn(@Nullable Object obj) {
        return Maps.b(columnMap(), obj);
    }

    public boolean containsRow(@Nullable Object obj) {
        return Maps.b(rowMap(), obj);
    }

    public boolean containsValue(@Nullable Object obj) {
        for (Map containsValue : rowMap().values()) {
            if (containsValue.containsValue(obj)) {
                return true;
            }
        }
        return false;
    }

    Iterator<V> d() {
        return new jf<Cell<R, C, V>, V>(cellSet().iterator()) {
            V a(Cell<R, C, V> cell) {
                return cell.getValue();
            }
        };
    }

    public boolean equals(@Nullable Object obj) {
        return jc.a(this, obj);
    }

    public V get(@Nullable Object obj, @Nullable Object obj2) {
        Map map = (Map) Maps.a(rowMap(), obj);
        return map == null ? null : Maps.a(map, obj2);
    }

    public int hashCode() {
        return cellSet().hashCode();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public V put(R r, C c, V v) {
        return row(r).put(c, v);
    }

    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        for (Cell cell : table.cellSet()) {
            put(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
        }
    }

    public V remove(@Nullable Object obj, @Nullable Object obj2) {
        Map map = (Map) Maps.a(rowMap(), obj);
        return map == null ? null : Maps.c(map, obj2);
    }

    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    public String toString() {
        return rowMap().toString();
    }

    public Collection<V> values() {
        Collection<V> collection = this.b;
        if (collection != null) {
            return collection;
        }
        collection = c();
        this.b = collection;
        return collection;
    }
}
