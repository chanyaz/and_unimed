package com.google.common.reflect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.s;
import com.google.common.base.t;
import com.google.common.collect.eq;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

final class m {
    private static final Function<Type, String> a = new Function<Type, String>() {
        /* renamed from: a */
        public String apply(Type type) {
            return m.d(type);
        }
    };
    private static final com.google.common.base.m b = com.google.common.base.m.a(", ").b("null");

    private m() {
    }

    static Class<?> a(Class<?> cls) {
        return Array.newInstance(cls, 0).getClass();
    }

    static ParameterizedType a(Class<?> cls, Type... typeArr) {
        return new q(n.c.a(cls), cls, typeArr);
    }

    static ParameterizedType a(@Nullable Type type, Class<?> cls, Type... typeArr) {
        if (type == null) {
            return a((Class) cls, typeArr);
        }
        s.a((Object) typeArr);
        s.a(cls.getEnclosingClass() != null, "Owner type for unenclosed %s", cls);
        return new q(type, cls, typeArr);
    }

    static Type a(Type type) {
        boolean z = true;
        if (!(type instanceof WildcardType)) {
            return p.c.a(type);
        }
        WildcardType wildcardType = (WildcardType) type;
        Type[] lowerBounds = wildcardType.getLowerBounds();
        s.a(lowerBounds.length <= 1, (Object) "Wildcard cannot have more than one lower bounds.");
        if (lowerBounds.length == 1) {
            return c(a(lowerBounds[0]));
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        if (upperBounds.length != 1) {
            z = false;
        }
        s.a(z, (Object) "Wildcard should have only one upper bound.");
        return b(a(upperBounds[0]));
    }

    static <D extends GenericDeclaration> TypeVariable<D> a(D d, String str, Type... typeArr) {
        if (typeArr.length == 0) {
            typeArr = new Type[]{Object.class};
        }
        return new r(d, str, typeArr);
    }

    private static Iterable<Type> b(Iterable<Type> iterable) {
        return eq.a((Iterable) iterable, t.a(t.a((Object) Object.class)));
    }

    @Nullable
    private static Type b(Type[] typeArr) {
        for (Type e : typeArr) {
            Type e2 = e(e2);
            if (e2 != null) {
                if (e2 instanceof Class) {
                    Class cls = (Class) e2;
                    if (cls.isPrimitive()) {
                        return cls;
                    }
                }
                return b(e2);
            }
        }
        return null;
    }

    @VisibleForTesting
    static WildcardType b(Type type) {
        return new s(new Type[0], new Type[]{type});
    }

    private static void b(Type[] typeArr, String str) {
        for (Type type : typeArr) {
            if (type instanceof Class) {
                s.a(!((Class) type).isPrimitive(), "Primitive type '%s' used as %s", (Class) type, str);
            }
        }
    }

    private static Type[] b(Collection<Type> collection) {
        return (Type[]) collection.toArray(new Type[collection.size()]);
    }

    @VisibleForTesting
    static WildcardType c(Type type) {
        return new s(new Type[]{type}, new Type[]{Object.class});
    }

    static String d(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    @Nullable
    static Type e(Type type) {
        s.a((Object) type);
        final AtomicReference atomicReference = new AtomicReference();
        new l() {
            void a(Class<?> cls) {
                atomicReference.set(cls.getComponentType());
            }

            void a(GenericArrayType genericArrayType) {
                atomicReference.set(genericArrayType.getGenericComponentType());
            }

            void a(TypeVariable<?> typeVariable) {
                atomicReference.set(m.b(typeVariable.getBounds()));
            }

            void a(WildcardType wildcardType) {
                atomicReference.set(m.b(wildcardType.getUpperBounds()));
            }
        }.a(type);
        return (Type) atomicReference.get();
    }
}
