package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.s;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Map;

@Beta
public final class e {
    private final g a;

    public e() {
        this.a = new g();
    }

    private e(g gVar) {
        this.a = gVar;
    }

    /* synthetic */ e(g gVar, AnonymousClass1 anonymousClass1) {
        this(gVar);
    }

    static e a(Type type) {
        return new e().a(f.a(type));
    }

    private ParameterizedType a(ParameterizedType parameterizedType) {
        Type ownerType = parameterizedType.getOwnerType();
        Type b = ownerType == null ? null : b(ownerType);
        ownerType = b(parameterizedType.getRawType());
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Type[] typeArr = new Type[actualTypeArguments.length];
        for (int i = 0; i < actualTypeArguments.length; i++) {
            typeArr[i] = b(actualTypeArguments[i]);
        }
        return m.a(b, (Class) ownerType, typeArr);
    }

    private Type a(GenericArrayType genericArrayType) {
        return m.a(b(genericArrayType.getGenericComponentType()));
    }

    private Type[] a(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            typeArr2[i] = b(typeArr[i]);
        }
        return typeArr2;
    }

    private static <T> T b(Class<T> cls, Object obj) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException(obj + " is not a " + cls.getSimpleName());
        }
    }

    private static void b(final Map<TypeVariable<?>, Type> map, Type type, final Type type2) {
        if (!type.equals(type2)) {
            new l() {
                void a(Class<?> cls) {
                    throw new IllegalArgumentException("No type mapping from " + cls);
                }

                void a(GenericArrayType genericArrayType) {
                    Type e = m.e(type2);
                    s.a(e != null, "%s is not an array type.", type2);
                    e.b(map, genericArrayType.getGenericComponentType(), e);
                }

                void a(ParameterizedType parameterizedType) {
                    int i = 0;
                    ParameterizedType parameterizedType2 = (ParameterizedType) e.b(ParameterizedType.class, type2);
                    s.a(parameterizedType.getRawType().equals(parameterizedType2.getRawType()), "Inconsistent raw type: %s vs. %s", parameterizedType, type2);
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
                    s.a(actualTypeArguments.length == actualTypeArguments2.length, "%s not compatible with %s", parameterizedType, parameterizedType2);
                    while (i < actualTypeArguments.length) {
                        e.b(map, actualTypeArguments[i], actualTypeArguments2[i]);
                        i++;
                    }
                }

                void a(TypeVariable<?> typeVariable) {
                    map.put(typeVariable, type2);
                }

                void a(WildcardType wildcardType) {
                    int i = 0;
                    WildcardType wildcardType2 = (WildcardType) e.b(WildcardType.class, type2);
                    Type[] upperBounds = wildcardType.getUpperBounds();
                    Type[] upperBounds2 = wildcardType2.getUpperBounds();
                    Type[] lowerBounds = wildcardType.getLowerBounds();
                    Type[] lowerBounds2 = wildcardType2.getLowerBounds();
                    boolean z = upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length;
                    s.a(z, "Incompatible type: %s vs. %s", wildcardType, type2);
                    for (int i2 = 0; i2 < upperBounds.length; i2++) {
                        e.b(map, upperBounds[i2], upperBounds2[i2]);
                    }
                    while (i < lowerBounds.length) {
                        e.b(map, lowerBounds[i], lowerBounds2[i]);
                        i++;
                    }
                }
            }.a(type);
        }
    }

    e a(Map<? extends TypeVariable<?>, ? extends Type> map) {
        return new e(this.a.a((Map) map));
    }

    public Type b(Type type) {
        s.a((Object) type);
        if (type instanceof TypeVariable) {
            return this.a.a((TypeVariable) type);
        }
        if (type instanceof ParameterizedType) {
            return a((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return a((GenericArrayType) type);
        }
        if (!(type instanceof WildcardType)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        return new s(a(wildcardType.getLowerBounds()), a(wildcardType.getUpperBounds()));
    }
}
