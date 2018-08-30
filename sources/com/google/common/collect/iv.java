package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.s;
import com.google.common.collect.il.com/google/common/collect/jb;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class iv extends com/google/common/collect/jb<Entry<C, Map<R, V>>> {
    final /* synthetic */ iu a;

    iv(iu iuVar) {
        this.a = iuVar;
        super(iuVar.a);
    }

    public boolean contains(Object obj) {
        if (obj instanceof Entry) {
            Entry entry = (Entry) obj;
            if (this.a.a.containsColumn(entry.getKey())) {
                return this.a.get(entry.getKey()).equals(entry.getValue());
            }
        }
        return false;
    }

    public Iterator<Entry<C, Map<R, V>>> iterator() {
        return Maps.a(this.a.a.columnKeySet(), new Function<C, Map<R, V>>() {
            /* renamed from: a */
            public Map<R, V> apply(C c) {
                return iv.this.a.a.column(c);
            }
        });
    }

    public boolean remove(Object obj) {
        if (!contains(obj)) {
            return false;
        }
        this.a.a.b(((Entry) obj).getKey());
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        s.a((Object) collection);
        return hz.a((Set) this, collection.iterator());
    }

    public boolean retainAll(Collection<?> collection) {
        s.a((Object) collection);
        boolean z = false;
        Iterator it = fb.a(this.a.a.columnKeySet().iterator()).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (!collection.contains(Maps.a(next, this.a.a.column(next)))) {
                this.a.a.b(next);
                z = true;
            }
        }
        return z;
    }

    public int size() {
        return this.a.a.columnKeySet().size();
    }
}
