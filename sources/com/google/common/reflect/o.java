package com.google.common.reflect;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

final class o implements Serializable, GenericArrayType {
    private static final long serialVersionUID = 0;
    private final Type a;

    o(Type type) {
        this.a = p.c.b(type);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GenericArrayType)) {
            return false;
        }
        return com.google.common.base.o.a(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
    }

    public Type getGenericComponentType() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return m.d(this.a) + "[]";
    }
}
