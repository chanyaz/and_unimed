package com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

class af extends gs<K, V> {
    final /* synthetic */ ae a;

    private af(ae aeVar) {
        this.a = aeVar;
    }

    Multimap<K, V> a() {
        return this.a;
    }

    public Iterator<Entry<K, V>> iterator() {
        return this.a.h();
    }
}
