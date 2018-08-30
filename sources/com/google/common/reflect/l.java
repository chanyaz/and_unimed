package com.google.common.reflect;

import com.google.common.collect.hz;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Set;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
abstract class l {
    private final Set<Type> a = hz.a();

    l() {
    }

    void a(Class<?> cls) {
    }

    void a(GenericArrayType genericArrayType) {
    }

    void a(ParameterizedType parameterizedType) {
    }

    void a(TypeVariable<?> typeVariable) {
    }

    void a(WildcardType wildcardType) {
    }

    public final void a(Type... typeArr) {
        for (Object obj : typeArr) {
            if (obj != null && this.a.add(obj)) {
                try {
                    if (obj instanceof TypeVariable) {
                        a((TypeVariable) obj);
                    } else if (obj instanceof WildcardType) {
                        a((WildcardType) obj);
                    } else if (obj instanceof ParameterizedType) {
                        a((ParameterizedType) obj);
                    } else if (obj instanceof Class) {
                        a((Class) obj);
                    } else if (obj instanceof GenericArrayType) {
                        a((GenericArrayType) obj);
                    } else {
                        throw new AssertionError("Unknown type: " + obj);
                    }
                } catch (Throwable th) {
                    this.a.remove(obj);
                }
            }
        }
    }
}
