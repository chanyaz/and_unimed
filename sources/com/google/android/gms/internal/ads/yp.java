package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map.Entry;

final class yp<K> implements Iterator<Entry<K, Object>> {
    private Iterator<Entry<K, Object>> a;

    public yp(Iterator<Entry<K, Object>> it) {
        this.a = it;
    }

    public final boolean hasNext() {
        return this.a.hasNext();
    }

    public final /* synthetic */ Object next() {
        Entry entry = (Entry) this.a.next();
        return entry.getValue() instanceof yl ? new yn(entry) : entry;
    }

    public final void remove() {
        this.a.remove();
    }
}
