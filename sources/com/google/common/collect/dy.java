package com.google.common.collect;

import com.google.common.collect.Multiset.Entry;

final class dy extends ImmutableSet<Entry<E>> {
    private static final long serialVersionUID = 0;
    final /* synthetic */ ImmutableMultiset a;

    private dy(ImmutableMultiset immutableMultiset) {
        this.a = immutableMultiset;
    }

    boolean c() {
        return this.a.c();
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return entry.getCount() > 0 && this.a.count(entry.getElement()) == entry.getCount();
    }

    ImmutableList<Entry<E>> f() {
        return new ct<Entry<E>>() {
            /* renamed from: b */
            public Entry<E> get(int i) {
                return dy.this.a.a(i);
            }

            ImmutableCollection<Entry<E>> d() {
                return dy.this;
            }
        };
    }

    /* renamed from: h_ */
    public jl<Entry<E>> iterator() {
        return b().iterator();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public int size() {
        return this.a.elementSet().size();
    }

    Object writeReplace() {
        return new dz(this.a);
    }
}
