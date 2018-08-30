package com.google.common.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

class c<T> extends b<T, Object> {
    final Method a;

    public final TypeVariable<?>[] getTypeParameters() {
        return this.a.getTypeParameters();
    }
}
