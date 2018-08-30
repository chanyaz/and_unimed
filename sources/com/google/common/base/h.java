package com.google.common.base;

import java.io.Serializable;

final class h extends Equivalence<Object> implements Serializable {
    static final h a = new h();
    private static final long serialVersionUID = 1;

    h() {
    }

    private Object readResolve() {
        return a;
    }

    public int b(Object obj) {
        return obj.hashCode();
    }

    protected boolean b(Object obj, Object obj2) {
        return obj.equals(obj2);
    }
}
