package com.google.common.collect;

import com.google.common.base.s;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class ip extends g<Entry<R, V>> {
    final Iterator<Entry<R, Map<C, V>>> a;
    final /* synthetic */ in b;

    private ip(in inVar) {
        this.b = inVar;
        this.a = this.b.b.a.entrySet().iterator();
    }

    /* renamed from: c */
    protected Entry<R, V> a() {
        while (this.a.hasNext()) {
            final Entry entry = (Entry) this.a.next();
            if (((Map) entry.getValue()).containsKey(this.b.a)) {
                return new ad<R, V>() {
                    public R getKey() {
                        return entry.getKey();
                    }

                    public V getValue() {
                        return ((Map) entry.getValue()).get(ip.this.b.a);
                    }

                    public V setValue(V v) {
                        return ((Map) entry.getValue()).put(ip.this.b.a, s.a((Object) v));
                    }
                };
            }
        }
        return (Entry) b();
    }
}
