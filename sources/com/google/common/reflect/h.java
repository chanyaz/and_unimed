package com.google.common.reflect;

import com.google.common.base.m;
import com.google.common.base.s;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

final class h {
    private final AtomicInteger a;

    private h() {
        this.a = new AtomicInteger();
    }

    private Type[] a(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            typeArr2[i] = a(typeArr[i]);
        }
        return typeArr2;
    }

    private Type b(@Nullable Type type) {
        return type == null ? null : a(type);
    }

    Type a(Type type) {
        s.a((Object) type);
        if ((type instanceof Class) || (type instanceof TypeVariable)) {
            return type;
        }
        if (type instanceof GenericArrayType) {
            return m.a(a(((GenericArrayType) type).getGenericComponentType()));
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return m.a(b(parameterizedType.getOwnerType()), (Class) parameterizedType.getRawType(), a(parameterizedType.getActualTypeArguments()));
        } else if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            if (wildcardType.getLowerBounds().length != 0) {
                return type;
            }
            return m.a((GenericDeclaration) h.class, "capture#" + this.a.incrementAndGet() + "-of ? extends " + m.a('&').a(wildcardType.getUpperBounds()), wildcardType.getUpperBounds());
        } else {
            throw new AssertionError("must have been one of the known types");
        }
    }
}
