package com.google.android.gms.internal.ads;

import com.appnext.base.a.c.c;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

final class ze {
    static String a(zzbcu zzbcu, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("# ").append(str);
        a(zzbcu, stringBuilder, 0);
        return stringBuilder.toString();
    }

    private static final String a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                stringBuilder.append("_");
            }
            stringBuilder.append(Character.toLowerCase(charAt));
        }
        return stringBuilder.toString();
    }

    private static void a(zzbcu zzbcu, StringBuilder stringBuilder, int i) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        Set<String> treeSet = new TreeSet();
        for (Method method : zzbcu.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String valueOf;
            String valueOf2;
            Method method2;
            String replaceFirst = str.replaceFirst("get", "");
            if (!(!replaceFirst.endsWith("List") || replaceFirst.endsWith("OrBuilderList") || replaceFirst.equals("List"))) {
                valueOf = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                valueOf2 = String.valueOf(replaceFirst.substring(1, replaceFirst.length() - 4));
                valueOf = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                method2 = (Method) hashMap.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    a(stringBuilder, i, a(valueOf), yd.a(method2, (Object) zzbcu, new Object[0]));
                }
            }
            if (replaceFirst.endsWith("Map") && !replaceFirst.equals("Map")) {
                valueOf = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                valueOf2 = String.valueOf(replaceFirst.substring(1, replaceFirst.length() - 3));
                valueOf = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                method2 = (Method) hashMap.get(str);
                if (method2 != null && method2.getReturnType().equals(Map.class) && !method2.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method2.getModifiers())) {
                    a(stringBuilder, i, a(valueOf), yd.a(method2, (Object) zzbcu, new Object[0]));
                }
            }
            String str2 = "set";
            valueOf2 = String.valueOf(replaceFirst);
            if (((Method) hashMap2.get(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2))) != null) {
                if (replaceFirst.endsWith("Bytes")) {
                    str2 = "get";
                    valueOf2 = String.valueOf(replaceFirst.substring(0, replaceFirst.length() - 5));
                    if (hashMap.containsKey(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2))) {
                    }
                }
                str2 = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                valueOf2 = String.valueOf(replaceFirst.substring(1));
                String concat = valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2);
                str2 = "get";
                valueOf2 = String.valueOf(replaceFirst);
                method2 = (Method) hashMap.get(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
                valueOf = "has";
                str2 = String.valueOf(replaceFirst);
                Method method3 = (Method) hashMap.get(str2.length() != 0 ? valueOf.concat(str2) : new String(valueOf));
                if (method2 != null) {
                    boolean equals;
                    zzbcu a = yd.a(method2, (Object) zzbcu, new Object[0]);
                    if (method3 == null) {
                        equals = a instanceof Boolean ? !((Boolean) a).booleanValue() : a instanceof Integer ? ((Integer) a).intValue() == 0 : a instanceof Float ? ((Float) a).floatValue() == 0.0f : a instanceof Double ? ((Double) a).doubleValue() == 0.0d : a instanceof String ? a.equals("") : a instanceof zzbah ? a.equals(zzbah.a) : a instanceof zzbcu ? a == ((zzbcu) a).zzadg() : a instanceof Enum ? ((Enum) a).ordinal() == 0 : false;
                        equals = !equals;
                    } else {
                        equals = ((Boolean) yd.a(method3, (Object) zzbcu, new Object[0])).booleanValue();
                    }
                    if (equals) {
                        a(stringBuilder, i, a(concat), a);
                    }
                }
            }
        }
        if (zzbcu instanceof yg) {
            Iterator e = ((yg) zzbcu).zzdtz.e();
            if (e.hasNext()) {
                ((Entry) e.next()).getKey();
                throw new NoSuchMethodError();
            }
        }
        if (((yd) zzbcu).zzdtt != null) {
            ((yd) zzbcu).zzdtt.a(stringBuilder, i);
        }
    }

    static final void a(StringBuilder stringBuilder, int i, String str, Object obj) {
        int i2 = 0;
        if (obj instanceof List) {
            for (Object a : (List) obj) {
                a(stringBuilder, i, str, a);
            }
        } else if (obj instanceof Map) {
            for (Entry a2 : ((Map) obj).entrySet()) {
                a(stringBuilder, i, str, a2);
            }
        } else {
            stringBuilder.append(10);
            for (int i3 = 0; i3 < i; i3++) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(str);
            if (obj instanceof String) {
                stringBuilder.append(": \"").append(aad.a(zzbah.a((String) obj))).append('\"');
            } else if (obj instanceof zzbah) {
                stringBuilder.append(": \"").append(aad.a((zzbah) obj)).append('\"');
            } else if (obj instanceof yd) {
                stringBuilder.append(" {");
                a((yd) obj, stringBuilder, i + 2);
                stringBuilder.append("\n");
                while (i2 < i) {
                    stringBuilder.append(' ');
                    i2++;
                }
                stringBuilder.append("}");
            } else if (obj instanceof Entry) {
                stringBuilder.append(" {");
                Entry entry = (Entry) obj;
                a(stringBuilder, i + 2, c.gv, entry.getKey());
                a(stringBuilder, i + 2, "value", entry.getValue());
                stringBuilder.append("\n");
                while (i2 < i) {
                    stringBuilder.append(' ');
                    i2++;
                }
                stringBuilder.append("}");
            } else {
                stringBuilder.append(": ").append(obj.toString());
            }
        }
    }
}
