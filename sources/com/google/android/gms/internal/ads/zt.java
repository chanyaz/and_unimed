package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zt implements Iterator<Entry<K, V>> {
    private int a;
    private Iterator<Entry<K, V>> b;
    private final /* synthetic */ zr c;

    private zt(zr zrVar) {
        this.c = zrVar;
        this.a = this.c.b.size();
    }

    /* synthetic */ zt(zr zrVar, zs zsVar) {
        this(zrVar);
    }

    private final Iterator<Entry<K, V>> a() {
        if (this.b == null) {
            this.b = this.c.f.entrySet().iterator();
        }
        return this.b;
    }

    public final boolean hasNext() {
        return (this.a > 0 && this.a <= this.c.b.size()) || a().hasNext();
    }

    public final /* synthetic */ Object next() {
        if (a().hasNext()) {
            return (Entry) a().next();
        }
        List b = this.c.b;
        int i = this.a - 1;
        this.a = i;
        return (Entry) b.get(i);
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
