package com.google.common.reflect;

import com.google.common.base.s;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Map;

final class f extends l {
    private static final h a = new h();
    private final Map<TypeVariable<?>, Type> b = Maps.c();

    private f() {
    }

    static ImmutableMap<TypeVariable<?>, Type> a(Type type) {
        f fVar = new f();
        fVar.a(a.a(type));
        return ImmutableMap.a(fVar.b);
    }

    private void a(TypeVariable<?> typeVariable, Type type) {
        if (!this.b.containsKey(typeVariable)) {
            Object obj = type;
            while (obj != null) {
                if (typeVariable.equals(obj)) {
                    while (type != null) {
                        type = (Type) this.b.remove(type);
                    }
                    return;
                }
                Type obj2 = (Type) this.b.get(obj2);
            }
            this.b.put(typeVariable, type);
        }
    }

    void a(Class<?> cls) {
        a(cls.getGenericSuperclass());
        a(cls.getGenericInterfaces());
    }

    void a(ParameterizedType parameterizedType) {
        TypeVariable[] typeParameters = ((Class) parameterizedType.getRawType()).getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        s.b(typeParameters.length == actualTypeArguments.length);
        for (int i = 0; i < typeParameters.length; i++) {
            a(typeParameters[i], actualTypeArguments[i]);
        }
        a(r0);
        a(parameterizedType.getOwnerType());
    }

    void a(TypeVariable<?> typeVariable) {
        a(typeVariable.getBounds());
    }

    void a(WildcardType wildcardType) {
        a(wildcardType.getUpperBounds());
    }
}
