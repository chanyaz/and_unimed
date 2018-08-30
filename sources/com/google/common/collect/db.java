package com.google.common.collect;

import java.io.Serializable;
import java.util.EnumMap;

class db<K extends Enum<K>, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final EnumMap<K, V> a;

    db(EnumMap<K, V> enumMap) {
        this.a = enumMap;
    }

    Object readResolve() {
        return new da(this.a, null);
    }
}
