package com.google.common.collect;

import com.google.common.base.s;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

final class iy extends gk<C, V> {
    final /* synthetic */ ix a;

    private iy(ix ixVar) {
        this.a = ixVar;
    }

    Map<C, V> a() {
        return this.a;
    }

    public Iterator<Entry<C, V>> iterator() {
        Map b = this.a.b();
        if (b == null) {
            return er.c();
        }
        final Iterator it = b.entrySet().iterator();
        return new Iterator<Entry<C, V>>() {
            /* renamed from: a */
            public Entry<C, V> next() {
                final Entry entry = (Entry) it.next();
                return new ca<C, V>() {
                    /* renamed from: a */
                    protected Entry<C, V> b() {
                        return entry;
                    }

                    public boolean equals(Object obj) {
                        return a(obj);
                    }

                    public V setValue(V v) {
                        return super.setValue(s.a((Object) v));
                    }
                };
            }

            public boolean hasNext() {
                return it.hasNext();
            }

            public void remove() {
                it.remove();
                iy.this.a.d();
            }
        };
    }

    public int size() {
        Map b = this.a.b();
        return b == null ? 0 : b.size();
    }
}
