package com.google.common.reflect;

import java.lang.reflect.Type;

final class i<T> extends TypeToken<T> {
    private static final long serialVersionUID = 0;

    i(Type type) {
        super(type, null);
    }
}
