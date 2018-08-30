package com.google.common.collect;

import java.io.Serializable;
import java.util.EnumSet;

class dd<E extends Enum<E>> implements Serializable {
    private static final long serialVersionUID = 0;
    final EnumSet<E> a;

    dd(EnumSet<E> enumSet) {
        this.a = enumSet;
    }

    Object readResolve() {
        return new dc(this.a.clone());
    }
}
