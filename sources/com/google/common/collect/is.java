package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class is extends g<C> {
    final Map<C, V> a;
    final Iterator<Map<C, V>> b;
    Iterator<Entry<C, V>> c;
    final /* synthetic */ il d;

    private is(il ilVar) {
        this.d = ilVar;
        this.a = (Map) this.d.b.get();
        this.b = this.d.a.values().iterator();
        this.c = er.a();
    }

    protected C a() {
        while (true) {
            if (this.c.hasNext()) {
                Entry entry = (Entry) this.c.next();
                if (!this.a.containsKey(entry.getKey())) {
                    this.a.put(entry.getKey(), entry.getValue());
                    return entry.getKey();
                }
            } else if (!this.b.hasNext()) {
                return b();
            } else {
                this.c = ((Map) this.b.next()).entrySet().iterator();
            }
        }
    }
}
