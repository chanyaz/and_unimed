package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.s;
import com.google.common.collect.Multiset.Entry;
import com.google.common.primitives.b;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible
public final class gv {
    private static final hd<Entry<?>> a = new hd<Entry<?>>() {
        /* renamed from: a */
        public int compare(Entry<?> entry, Entry<?> entry2) {
            return b.a(entry2.getCount(), entry.getCount());
        }
    };

    private gv() {
    }

    static <E> int a(Multiset<E> multiset, E e, int i) {
        ba.a(i, "count");
        int count = multiset.count(e);
        int i2 = i - count;
        if (i2 > 0) {
            multiset.add(e, i2);
        } else if (i2 < 0) {
            multiset.remove(e, -i2);
        }
        return count;
    }

    static int a(Iterable<?> iterable) {
        return iterable instanceof Multiset ? ((Multiset) iterable).elementSet().size() : 11;
    }

    public static <E> Entry<E> a(@Nullable E e, int i) {
        return new gz(e, i);
    }

    static <E> Iterator<E> a(Multiset<E> multiset) {
        return new ha(multiset, multiset.entrySet().iterator());
    }

    static boolean a(Multiset<?> multiset, @Nullable Object obj) {
        if (obj == multiset) {
            return true;
        }
        if (!(obj instanceof Multiset)) {
            return false;
        }
        Multiset multiset2 = (Multiset) obj;
        if (multiset.size() != multiset2.size() || multiset.entrySet().size() != multiset2.entrySet().size()) {
            return false;
        }
        for (Entry entry : multiset2.entrySet()) {
            if (multiset.count(entry.getElement()) != entry.getCount()) {
                return false;
            }
        }
        return true;
    }

    static <E> boolean a(Multiset<E> multiset, E e, int i, int i2) {
        ba.a(i, "oldCount");
        ba.a(i2, "newCount");
        if (multiset.count(e) != i) {
            return false;
        }
        multiset.setCount(e, i2);
        return true;
    }

    static <E> boolean a(Multiset<E> multiset, Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        if (collection instanceof Multiset) {
            for (Entry entry : b((Iterable) collection).entrySet()) {
                multiset.add(entry.getElement(), entry.getCount());
            }
        } else {
            er.a((Collection) multiset, collection.iterator());
        }
        return true;
    }

    static int b(Multiset<?> multiset) {
        long j = 0;
        Iterator it = multiset.entrySet().iterator();
        while (true) {
            long j2 = j;
            if (!it.hasNext()) {
                return b.a(j2);
            }
            j = ((long) ((Entry) it.next()).getCount()) + j2;
        }
    }

    static <T> Multiset<T> b(Iterable<T> iterable) {
        return (Multiset) iterable;
    }

    static boolean b(Multiset<?> multiset, Collection<?> collection) {
        Collection collection2;
        if (collection2 instanceof Multiset) {
            collection2 = ((Multiset) collection2).elementSet();
        }
        return multiset.elementSet().removeAll(collection2);
    }

    static boolean c(Multiset<?> multiset, Collection<?> collection) {
        Collection collection2;
        s.a((Object) collection2);
        if (collection2 instanceof Multiset) {
            collection2 = ((Multiset) collection2).elementSet();
        }
        return multiset.elementSet().retainAll(collection2);
    }
}
