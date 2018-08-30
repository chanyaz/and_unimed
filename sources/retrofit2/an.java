package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;
import okhttp3.ai;
import okio.d;

final class an {
    static final Type[] a = new Type[0];

    private an() {
    }

    static int a(Object obj) {
        return obj != null ? obj.hashCode() : 0;
    }

    private static int a(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    static Class<?> a(Type type) {
        a((Object) type, "type == null");
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return (Class) rawType;
            }
            throw new IllegalArgumentException();
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(a(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return a(((WildcardType) type).getUpperBounds()[0]);
            }
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + type.getClass().getName());
        }
    }

    private static Class<?> a(TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        return genericDeclaration instanceof Class ? (Class) genericDeclaration : null;
    }

    static <T> T a(@Nullable T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    static Type a(int i, ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (i < 0 || i >= actualTypeArguments.length) {
            throw new IllegalArgumentException("Index " + i + " not in range [0," + actualTypeArguments.length + ") for " + parameterizedType);
        }
        Type type = actualTypeArguments[i];
        return type instanceof WildcardType ? ((WildcardType) type).getUpperBounds()[0] : type;
    }

    static Type a(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                if (interfaces[i] == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(interfaces[i])) {
                    return a(cls.getGenericInterfaces()[i], interfaces[i], (Class) cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            Class cls3;
            while (cls3 != Object.class) {
                Class superclass = cls3.getSuperclass();
                if (superclass == cls2) {
                    return cls3.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return a(cls3.getGenericSuperclass(), superclass, (Class) cls2);
                }
                cls3 = superclass;
            }
        }
        return cls2;
    }

    static Type a(Type type, Class<?> cls, Type type2) {
        while (true) {
            Type type3 = type2;
            Type componentType;
            Type a;
            Type[] actualTypeArguments;
            Type[] typeArr;
            if (type3 instanceof TypeVariable) {
                type3 = (TypeVariable) type3;
                type2 = a(type, (Class) cls, (TypeVariable) type3);
                if (type2 == type3) {
                    return type2;
                }
            } else if ((type3 instanceof Class) && ((Class) type3).isArray()) {
                Class cls2 = (Class) type3;
                componentType = cls2.getComponentType();
                a = a(type, (Class) cls, componentType);
                return componentType != a ? new ao(a) : cls2;
            } else if (type3 instanceof GenericArrayType) {
                GenericArrayType genericArrayType = (GenericArrayType) type3;
                componentType = genericArrayType.getGenericComponentType();
                a = a(type, (Class) cls, componentType);
                return componentType != a ? new ao(a) : genericArrayType;
            } else if (type3 instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type3;
                componentType = parameterizedType.getOwnerType();
                Type a2 = a(type, (Class) cls, componentType);
                int i = a2 != componentType ? 1 : 0;
                actualTypeArguments = parameterizedType.getActualTypeArguments();
                int length = actualTypeArguments.length;
                int i2 = i;
                typeArr = actualTypeArguments;
                for (int i3 = 0; i3 < length; i3++) {
                    Type a3 = a(type, (Class) cls, typeArr[i3]);
                    if (a3 != typeArr[i3]) {
                        if (i2 == 0) {
                            typeArr = (Type[]) typeArr.clone();
                            i2 = 1;
                        }
                        typeArr[i3] = a3;
                    }
                }
                return i2 != 0 ? new ap(a2, parameterizedType.getRawType(), typeArr) : parameterizedType;
            } else if (!(type3 instanceof WildcardType)) {
                return type3;
            } else {
                WildcardType wildcardType = (WildcardType) type3;
                typeArr = wildcardType.getLowerBounds();
                actualTypeArguments = wildcardType.getUpperBounds();
                if (typeArr.length == 1) {
                    if (a(type, (Class) cls, typeArr[0]) == typeArr[0]) {
                        return wildcardType;
                    }
                    return new aq(new Type[]{Object.class}, new Type[]{a(type, (Class) cls, typeArr[0])});
                } else if (actualTypeArguments.length != 1 || a(type, (Class) cls, actualTypeArguments[0]) == actualTypeArguments[0]) {
                    return wildcardType;
                } else {
                    return new aq(new Type[]{a(type, (Class) cls, actualTypeArguments[0])}, a);
                }
            }
        }
    }

    private static Type a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class a = a((TypeVariable) typeVariable);
        if (a == null) {
            return typeVariable;
        }
        Type a2 = a(type, (Class) cls, a);
        if (!(a2 instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) a2).getActualTypeArguments()[a(a.getTypeParameters(), (Object) typeVariable)];
    }

    static ai a(ai aiVar) {
        Object dVar = new d();
        aiVar.c().readAll(dVar);
        return ai.a(aiVar.a(), aiVar.b(), dVar);
    }

    static <T> void a(Class<T> cls) {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        } else if (cls.getInterfaces().length > 0) {
            throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
        }
    }

    private static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static boolean a(Type type, Type type2) {
        boolean z = true;
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            if (!(a(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments()))) {
                z = false;
            }
            return z;
        } else if (type instanceof GenericArrayType) {
            if (!(type2 instanceof GenericArrayType)) {
                return false;
            }
            return a(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
        } else if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            if (!(Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds()))) {
                z = false;
            }
            return z;
        } else if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        } else {
            TypeVariable typeVariable = (TypeVariable) type;
            TypeVariable typeVariable2 = (TypeVariable) type2;
            if (!(typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName()))) {
                z = false;
            }
            return z;
        }
    }

    static boolean a(Annotation[] annotationArr, Class<? extends Annotation> cls) {
        for (Object isInstance : annotationArr) {
            if (cls.isInstance(isInstance)) {
                return true;
            }
        }
        return false;
    }

    static String b(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    static Type b(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return a(type, (Class) cls, a(type, (Class) cls, (Class) cls2));
        }
        throw new IllegalArgumentException();
    }

    static void c(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException();
        }
    }

    static boolean d(Type type) {
        if (type instanceof Class) {
            return false;
        }
        if (type instanceof ParameterizedType) {
            for (Type d : ((ParameterizedType) type).getActualTypeArguments()) {
                if (d(d)) {
                    return true;
                }
            }
            return false;
        } else if (type instanceof GenericArrayType) {
            return d(((GenericArrayType) type).getGenericComponentType());
        } else {
            if (type instanceof TypeVariable) {
                return true;
            }
            if (type instanceof WildcardType) {
                return true;
            }
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
        }
    }

    static Type e(Type type) {
        if (type instanceof ParameterizedType) {
            return a(0, (ParameterizedType) type);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
