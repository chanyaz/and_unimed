package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.s;
import java.io.Serializable;

@GwtCompatible(serializable = true)
final class hv extends hd<Comparable> implements Serializable {
    static final hv a = new hv();
    private static final long serialVersionUID = 0;

    private hv() {
    }

    private Object readResolve() {
        return a;
    }

    /* renamed from: a */
    public int compare(Comparable comparable, Comparable comparable2) {
        s.a((Object) comparable);
        return comparable == comparable2 ? 0 : comparable2.compareTo(comparable);
    }

    public <S extends Comparable> hd<S> a() {
        return hd.b();
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }
}
