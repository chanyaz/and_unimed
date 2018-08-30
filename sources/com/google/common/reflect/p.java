package com.google.common.reflect;

import com.google.common.base.s;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.de;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

enum p {
    JAVA6 {
        Type b(Type type) {
            s.a((Object) type);
            if (!(type instanceof Class)) {
                return type;
            }
            Class cls = (Class) type;
            return cls.isArray() ? new o(cls.getComponentType()) : type;
        }

        /* renamed from: c */
        GenericArrayType a(Type type) {
            return new o(type);
        }
    },
    JAVA7 {
        Type a(Type type) {
            return type instanceof Class ? m.a((Class) type) : new o(type);
        }

        Type b(Type type) {
            return (Type) s.a((Object) type);
        }
    };
    
    static final p c = null;

    final ImmutableList<Type> a(Type[] typeArr) {
        de i = ImmutableList.i();
        for (Type b : typeArr) {
            i.b(b(b));
        }
        return i.a();
    }

    abstract Type a(Type type);

    abstract Type b(Type type);
}
