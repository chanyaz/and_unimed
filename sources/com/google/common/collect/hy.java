package com.google.common.collect;

import java.lang.reflect.Field;

final class hy<T> {
    private final Field a;

    private hy(Field field) {
        this.a = field;
        field.setAccessible(true);
    }

    void a(T t, int i) {
        try {
            this.a.set(t, Integer.valueOf(i));
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

    void a(T t, Object obj) {
        try {
            this.a.set(t, obj);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
