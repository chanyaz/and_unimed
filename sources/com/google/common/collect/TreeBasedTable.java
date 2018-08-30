package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtCompatible(serializable = true)
@Beta
public class TreeBasedTable<R, C, V> extends ij<R, C, V> {
    private static final long serialVersionUID = 0;
    private final Comparator<? super C> c;

    /* renamed from: a */
    public SortedMap<C, V> row(R r) {
        return new jh(this, r);
    }

    Iterator<C> g() {
        final Comparator h = h();
        final Iterator a = er.a(eq.a(this.a.values(), new Function<Map<C, V>, Iterator<C>>() {
            /* renamed from: a */
            public Iterator<C> apply(Map<C, V> map) {
                return map.keySet().iterator();
            }
        }), h);
        return new g<C>() {
            C a;

            protected C a() {
                while (a.hasNext()) {
                    Object obj;
                    Object next = a.next();
                    if (this.a == null || h.compare(next, this.a) != 0) {
                        obj = null;
                        continue;
                    } else {
                        obj = 1;
                        continue;
                    }
                    if (obj == null) {
                        this.a = next;
                        return this.a;
                    }
                }
                this.a = null;
                return b();
            }
        };
    }

    public Comparator<? super C> h() {
        return this.c;
    }

    public SortedSet<R> rowKeySet() {
        return super.rowKeySet();
    }

    public SortedMap<R, Map<C, V>> rowMap() {
        return super.rowMap();
    }
}
