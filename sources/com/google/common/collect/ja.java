package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.il.com/google/common/collect/jb;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class ja extends com/google/common/collect/jb<Entry<R, Map<C, V>>> {
    final /* synthetic */ iz a;

    ja(iz izVar) {
        this.a = izVar;
        super(izVar.b);
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        obj = (Entry) obj;
        return obj.getKey() != null && (obj.getValue() instanceof Map) && bb.a(this.a.b.a.entrySet(), obj);
    }

    public Iterator<Entry<R, Map<C, V>>> iterator() {
        return Maps.a(this.a.b.a.keySet(), new Function<R, Map<C, V>>() {
            /* renamed from: a */
            public Map<C, V> apply(R r) {
                return ja.this.a.b.row(r);
            }
        });
    }

    public boolean remove(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return entry.getKey() != null && (entry.getValue() instanceof Map) && this.a.b.a.entrySet().remove(entry);
    }

    public int size() {
        return this.a.b.a.size();
    }
}
