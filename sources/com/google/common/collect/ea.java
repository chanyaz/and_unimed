package com.google.common.collect;

import com.google.common.collect.Multiset.Entry;
import java.io.Serializable;
import java.util.Iterator;

class ea implements Serializable {
    private static final long serialVersionUID = 0;
    final Object[] a;
    final int[] b;

    ea(Multiset<?> multiset) {
        int size = multiset.entrySet().size();
        this.a = new Object[size];
        this.b = new int[size];
        size = 0;
        Iterator it = multiset.entrySet().iterator();
        while (true) {
            int i = size;
            if (it.hasNext()) {
                Entry entry = (Entry) it.next();
                this.a[i] = entry.getElement();
                this.b[i] = entry.getCount();
                size = i + 1;
            } else {
                return;
            }
        }
    }

    Object readResolve() {
        Iterable a = LinkedHashMultiset.a(this.a.length);
        for (int i = 0; i < this.a.length; i++) {
            a.add(this.a[i], this.b[i]);
        }
        return ImmutableMultiset.a(a);
    }
}
