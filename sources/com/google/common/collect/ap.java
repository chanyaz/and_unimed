package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.s;
import com.google.common.collect.Multiset.Entry;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
abstract class ap<E> extends ai<E> implements SortedMultiset<E> {
    @GwtTransient
    final Comparator<? super E> a;
    private transient SortedMultiset<E> b;

    ap() {
        this(hd.b());
    }

    ap(Comparator<? super E> comparator) {
        this.a = (Comparator) s.a((Object) comparator);
    }

    public Comparator<? super E> comparator() {
        return this.a;
    }

    public SortedMultiset<E> descendingMultiset() {
        SortedMultiset<E> sortedMultiset = this.b;
        if (sortedMultiset != null) {
            return sortedMultiset;
        }
        sortedMultiset = h();
        this.b = sortedMultiset;
        return sortedMultiset;
    }

    /* renamed from: e */
    NavigableSet<E> c() {
        return new ii(this);
    }

    public NavigableSet<E> elementSet() {
        return (NavigableSet) super.elementSet();
    }

    abstract Iterator<Entry<E>> f();

    public Entry<E> firstEntry() {
        Iterator a = a();
        return a.hasNext() ? (Entry) a.next() : null;
    }

    Iterator<E> g() {
        return gv.a(descendingMultiset());
    }

    SortedMultiset<E> h() {
        return new bp<E>() {
            SortedMultiset<E> a() {
                return ap.this;
            }

            Iterator<Entry<E>> d() {
                return ap.this.f();
            }

            public Iterator<E> iterator() {
                return ap.this.g();
            }
        };
    }

    public Entry<E> lastEntry() {
        Iterator f = f();
        return f.hasNext() ? (Entry) f.next() : null;
    }

    public Entry<E> pollFirstEntry() {
        Iterator a = a();
        if (!a.hasNext()) {
            return null;
        }
        Entry entry = (Entry) a.next();
        Entry<E> a2 = gv.a(entry.getElement(), entry.getCount());
        a.remove();
        return a2;
    }

    public Entry<E> pollLastEntry() {
        Iterator f = f();
        if (!f.hasNext()) {
            return null;
        }
        Entry entry = (Entry) f.next();
        Entry<E> a = gv.a(entry.getElement(), entry.getCount());
        f.remove();
        return a;
    }

    public SortedMultiset<E> subMultiset(@Nullable E e, BoundType boundType, @Nullable E e2, BoundType boundType2) {
        s.a((Object) boundType);
        s.a((Object) boundType2);
        return tailMultiset(e, boundType).headMultiset(e2, boundType2);
    }
}
