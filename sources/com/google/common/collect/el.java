package com.google.common.collect;

import com.google.common.collect.Multiset.Entry;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;

final class el<E> implements Serializable {
    Comparator<? super E> a;
    E[] b;
    int[] c;

    el(SortedMultiset<E> sortedMultiset) {
        this.a = sortedMultiset.comparator();
        int size = sortedMultiset.entrySet().size();
        this.b = new Object[size];
        this.c = new int[size];
        int i = 0;
        Iterator it = sortedMultiset.entrySet().iterator();
        while (true) {
            size = i;
            if (it.hasNext()) {
                Entry entry = (Entry) it.next();
                this.b[size] = entry.getElement();
                this.c[size] = entry.getCount();
                i = size + 1;
            } else {
                return;
            }
        }
    }

    Object readResolve() {
        int length = this.b.length;
        ek ekVar = new ek(this.a);
        for (int i = 0; i < length; i++) {
            ekVar.a(this.b[i], this.c[i]);
        }
        return ekVar.a();
    }
}
