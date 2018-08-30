package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;

public class BeanUtil {
    protected static boolean isCglibGetCallbacks(AnnotatedMethod annotatedMethod) {
        Class rawType = annotatedMethod.getRawType();
        if (rawType == null || !rawType.isArray()) {
            return false;
        }
        String packageName = ClassUtil.getPackageName(rawType.getComponentType());
        return (packageName == null || !packageName.contains(".cglib")) ? false : packageName.startsWith("net.sf.cglib") || packageName.startsWith("org.hibernate.repackage.cglib") || packageName.startsWith("org.springframework.cglib");
    }

    protected static boolean isGroovyMetaClassGetter(AnnotatedMethod annotatedMethod) {
        Class rawType = annotatedMethod.getRawType();
        if (rawType == null || rawType.isArray()) {
            return false;
        }
        String packageName = ClassUtil.getPackageName(rawType);
        return packageName != null && packageName.startsWith("groovy.lang");
    }

    protected static String legacyManglePropertyName(String str, int i) {
        int length = str.length();
        if (length == i) {
            return null;
        }
        char charAt = str.charAt(i);
        char toLowerCase = Character.toLowerCase(charAt);
        if (charAt == toLowerCase) {
            return str.substring(i);
        }
        StringBuilder stringBuilder = new StringBuilder(length - i);
        stringBuilder.append(toLowerCase);
        for (int i2 = i + 1; i2 < length; i2++) {
            toLowerCase = str.charAt(i2);
            char toLowerCase2 = Character.toLowerCase(toLowerCase);
            if (toLowerCase == toLowerCase2) {
                stringBuilder.append(str, i2, length);
                break;
            }
            stringBuilder.append(toLowerCase2);
        }
        return stringBuilder.toString();
    }

    public static String okNameForGetter(AnnotatedMethod annotatedMethod, boolean z) {
        String name = annotatedMethod.getName();
        String okNameForIsGetter = okNameForIsGetter(annotatedMethod, name, z);
        return okNameForIsGetter == null ? okNameForRegularGetter(annotatedMethod, name, z) : okNameForIsGetter;
    }

    public static String okNameForIsGetter(AnnotatedMethod annotatedMethod, String str, boolean z) {
        if (str.startsWith("is")) {
            Class rawType = annotatedMethod.getRawType();
            if (rawType == Boolean.class || rawType == Boolean.TYPE) {
                return z ? stdManglePropertyName(str, 2) : legacyManglePropertyName(str, 2);
            }
        }
        return null;
    }

    public static String okNameForMutator(AnnotatedMethod annotatedMethod, String str, boolean z) {
        String name = annotatedMethod.getName();
        return name.startsWith(str) ? z ? stdManglePropertyName(name, str.length()) : legacyManglePropertyName(name, str.length()) : null;
    }

    public static String okNameForRegularGetter(AnnotatedMethod annotatedMethod, String str, boolean z) {
        if (!str.startsWith("get")) {
            return null;
        }
        if ("getCallbacks".equals(str)) {
            if (isCglibGetCallbacks(annotatedMethod)) {
                return null;
            }
        } else if ("getMetaClass".equals(str) && isGroovyMetaClassGetter(annotatedMethod)) {
            return null;
        }
        return z ? stdManglePropertyName(str, 3) : legacyManglePropertyName(str, 3);
    }

    protected static String stdManglePropertyName(String str, int i) {
        int length = str.length();
        if (length == i) {
            return null;
        }
        char charAt = str.charAt(i);
        char toLowerCase = Character.toLowerCase(charAt);
        if (charAt == toLowerCase) {
            return str.substring(i);
        }
        if (i + 1 < length && Character.isUpperCase(str.charAt(i + 1))) {
            return str.substring(i);
        }
        StringBuilder stringBuilder = new StringBuilder(length - i);
        stringBuilder.append(toLowerCase);
        stringBuilder.append(str, i + 1, length);
        return stringBuilder.toString();
    }
}
