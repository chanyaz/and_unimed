package com.google.common.collect;

import com.google.common.collect.Table.Cell;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class im implements Iterator<Cell<R, C, V>> {
    final Iterator<Entry<R, Map<C, V>>> a;
    Entry<R, Map<C, V>> b;
    Iterator<Entry<C, V>> c;
    final /* synthetic */ il d;

    private im(il ilVar) {
        this.d = ilVar;
        this.a = this.d.a.entrySet().iterator();
        this.c = er.c();
    }

    /* renamed from: a */
    public Cell<R, C, V> next() {
        if (!this.c.hasNext()) {
            this.b = (Entry) this.a.next();
            this.c = ((Map) this.b.getValue()).entrySet().iterator();
        }
        Entry entry = (Entry) this.c.next();
        return jc.a(this.b.getKey(), entry.getKey(), entry.getValue());
    }

    public boolean hasNext() {
        return this.a.hasNext() || this.c.hasNext();
    }

    public void remove() {
        this.c.remove();
        if (((Map) this.b.getValue()).isEmpty()) {
            this.a.remove();
        }
    }
}
