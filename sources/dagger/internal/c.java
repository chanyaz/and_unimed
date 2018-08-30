package dagger.internal;

import dagger.Lazy;
import dagger.MembersInjector;
import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Set;
import javax.inject.Provider;
import javax.inject.Qualifier;

public final class c {
    private static final String a = (Provider.class.getCanonicalName() + "<");
    private static final String b = (MembersInjector.class.getCanonicalName() + "<");
    private static final String c = (Lazy.class.getCanonicalName() + "<");
    private static final String d = (Set.class.getCanonicalName() + "<");
    private static final h<Class<? extends Annotation>, Boolean> e = new h<Class<? extends Annotation>, Boolean>() {
        protected Boolean a(Class<? extends Annotation> cls) {
            return Boolean.valueOf(cls.isAnnotationPresent(Qualifier.class));
        }
    };

    c() {
    }

    public static String a(Class<?> cls) {
        return "members/".concat(cls.getName());
    }

    static String a(String str) {
        int f = f(str);
        return a(str, f, a) ? a(str, f, str.substring(0, f), a) : a(str, f, b) ? a(str, f, "members/", b) : null;
    }

    private static String a(String str, int i, String str2, String str3) {
        return str2 + str.substring(str3.length() + i, str.length() - 1);
    }

    public static String a(Type type) {
        return a(type, null);
    }

    private static String a(Type type, Annotation annotation) {
        Type b = b(type);
        if (annotation == null && (b instanceof Class) && !((Class) b).isArray()) {
            return ((Class) b).getName();
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (annotation != null) {
            stringBuilder.append(annotation).append("/");
        }
        a(b, stringBuilder, true);
        return stringBuilder.toString();
    }

    public static String a(Type type, Annotation[] annotationArr, Object obj) {
        return a(type, a(annotationArr, obj));
    }

    private static Annotation a(Annotation[] annotationArr, Object obj) {
        Annotation annotation = null;
        int length = annotationArr.length;
        int i = 0;
        while (i < length) {
            Annotation annotation2;
            Annotation annotation3 = annotationArr[i];
            if (!((Boolean) e.b(annotation3.annotationType())).booleanValue()) {
                annotation2 = annotation;
            } else if (annotation != null) {
                throw new IllegalArgumentException("Too many qualifier annotations on " + obj);
            } else {
                annotation2 = annotation3;
            }
            i++;
            annotation = annotation2;
        }
        return annotation;
    }

    private static void a(Type type, StringBuilder stringBuilder, boolean z) {
        int i = 0;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                a(cls.getComponentType(), stringBuilder, false);
                stringBuilder.append("[]");
            } else if (!cls.isPrimitive()) {
                stringBuilder.append(cls.getName());
            } else if (z) {
                throw new UnsupportedOperationException("Uninjectable type " + cls.getName());
            } else {
                stringBuilder.append(cls.getName());
            }
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            a(parameterizedType.getRawType(), stringBuilder, true);
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            stringBuilder.append("<");
            while (i < actualTypeArguments.length) {
                if (i != 0) {
                    stringBuilder.append(", ");
                }
                a(actualTypeArguments[i], stringBuilder, true);
                i++;
            }
            stringBuilder.append(">");
        } else if (type instanceof GenericArrayType) {
            a(((GenericArrayType) type).getGenericComponentType(), stringBuilder, false);
            stringBuilder.append("[]");
        } else {
            throw new UnsupportedOperationException("Uninjectable type " + type);
        }
    }

    private static boolean a(String str, int i, String str2) {
        return str.regionMatches(i, str2, 0, str2.length());
    }

    static String b(String str) {
        int f = f(str);
        return a(str, f, c) ? a(str, f, str.substring(0, f), c) : null;
    }

    private static Type b(Type type) {
        return type == Byte.TYPE ? Byte.class : type == Short.TYPE ? Short.class : type == Integer.TYPE ? Integer.class : type == Long.TYPE ? Long.class : type == Character.TYPE ? Character.class : type == Boolean.TYPE ? Boolean.class : type == Float.TYPE ? Float.class : type == Double.TYPE ? Double.class : type == Void.TYPE ? Void.class : type;
    }

    public static boolean c(String str) {
        return str.startsWith("@");
    }

    public static String d(String str) {
        int i = 0;
        if (str.startsWith("@") || str.startsWith("members/")) {
            i = str.lastIndexOf(47) + 1;
        }
        return (str.indexOf(60, i) == -1 && str.indexOf(91, i) == -1) ? str.substring(i) : null;
    }

    public static boolean e(String str) {
        return str.startsWith("java.") || str.startsWith("javax.") || str.startsWith("android.");
    }

    private static int f(String str) {
        return str.startsWith("@") ? str.lastIndexOf(47) + 1 : 0;
    }
}
