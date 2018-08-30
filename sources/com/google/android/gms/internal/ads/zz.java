package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map.Entry;

final class zz implements Iterator<Entry<K, V>> {
    private int a;
    private boolean b;
    private Iterator<Entry<K, V>> c;
    private final /* synthetic */ zr d;

    private zz(zr zrVar) {
        this.d = zrVar;
        this.a = -1;
    }

    /* synthetic */ zz(zr zrVar, zs zsVar) {
        this(zrVar);
    }

    private final Iterator<Entry<K, V>> a() {
        if (this.c == null) {
            this.c = this.d.c.entrySet().iterator();
        }
        return this.c;
    }

    public final boolean hasNext() {
        return this.a + 1 < this.d.b.size() || (!this.d.c.isEmpty() && a().hasNext());
    }

    public final /* synthetic */ Object next() {
        this.b = true;
        int i = this.a + 1;
        this.a = i;
        return i < this.d.b.size() ? (Entry) this.d.b.get(this.a) : (Entry) a().next();
    }

    public final void remove() {
        if (this.b) {
            this.b = false;
            this.d.f();
            if (this.a < this.d.b.size()) {
                zr zrVar = this.d;
                int i = this.a;
                this.a = i - 1;
                zrVar.c(i);
                return;
            }
            a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
