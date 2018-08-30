package com.google.common.reflect;

import java.lang.reflect.ParameterizedType;
import javax.annotation.Nullable;

enum n {
    OWNED_BY_ENCLOSING_CLASS {
        @Nullable
        Class<?> a(Class<?> cls) {
            return cls.getEnclosingClass();
        }
    },
    LOCAL_CLASS_HAS_NO_OWNER {
        @Nullable
        Class<?> a(Class<?> cls) {
            return cls.isLocalClass() ? null : cls.getEnclosingClass();
        }
    };
    
    static final n c = null;

    class a<T> {
        a() {
        }
    }

    static {
        c = a();
    }

    private static n a() {
        ParameterizedType parameterizedType = (ParameterizedType) new a<String>() {
        }.getClass().getGenericSuperclass();
        for (n nVar : values()) {
            if (nVar.a(a.class) == parameterizedType.getOwnerType()) {
                return nVar;
            }
        }
        throw new AssertionError();
    }

    @Nullable
    abstract Class<?> a(Class<?> cls);
}
