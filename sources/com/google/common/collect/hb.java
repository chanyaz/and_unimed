package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.s;
import java.io.Serializable;

@GwtCompatible(serializable = true)
final class hb extends hd<Comparable> implements Serializable {
    static final hb a = new hb();
    private static final long serialVersionUID = 0;

    private hb() {
    }

    private Object readResolve() {
        return a;
    }

    /* renamed from: a */
    public int compare(Comparable comparable, Comparable comparable2) {
        s.a((Object) comparable);
        s.a((Object) comparable2);
        return comparable.compareTo(comparable2);
    }

    public <S extends Comparable> hd<S> a() {
        return hv.a;
    }

    public String toString() {
        return "Ordering.natural()";
    }
}
