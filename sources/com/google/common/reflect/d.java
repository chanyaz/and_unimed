package com.google.common.reflect;

import com.google.common.base.s;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

abstract class d<T> {
    d() {
    }

    final Type a() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        s.a(genericSuperclass instanceof ParameterizedType, "%s isn't parameterized", genericSuperclass);
        return ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    }
}
