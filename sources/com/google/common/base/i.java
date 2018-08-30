package com.google.common.base;

import java.io.Serializable;

final class i extends Equivalence<Object> implements Serializable {
    static final i a = new i();
    private static final long serialVersionUID = 1;

    i() {
    }

    private Object readResolve() {
        return a;
    }

    protected int b(Object obj) {
        return System.identityHashCode(obj);
    }

    protected boolean b(Object obj, Object obj2) {
        return false;
    }
}
