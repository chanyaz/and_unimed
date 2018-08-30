package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.s;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

class fd<F, T> extends AbstractSequentialList<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final List<F> a;
    final Function<? super F, ? extends T> b;

    fd(List<F> list, Function<? super F, ? extends T> function) {
        this.a = (List) s.a((Object) list);
        this.b = (Function) s.a((Object) function);
    }

    public void clear() {
        this.a.clear();
    }

    public ListIterator<T> listIterator(int i) {
        return new jg<F, T>(this.a.listIterator(i)) {
            T a(F f) {
                return fd.this.b.apply(f);
            }
        };
    }

    public int size() {
        return this.a.size();
    }
}
