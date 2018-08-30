package com.appnext.core;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.json.JSONArray;
import org.json.JSONObject;

public class n {
    private static int mi = 2;

    public static Object a(Class<?> cls, JSONObject jSONObject) {
        try {
            Object newInstance = cls.newInstance();
            for (Field field : mi == 0 ? cls.getFields() : cls.getDeclaredFields()) {
                if (mi == 2 && Modifier.isPrivate(field.getModifiers())) {
                    field.setAccessible(true);
                }
                try {
                    if (jSONObject.has(field.getName())) {
                        String simpleName = field.getType().getSimpleName();
                        if (simpleName.equalsIgnoreCase("boolean")) {
                            field.setBoolean(newInstance, jSONObject.getBoolean(field.getName()));
                        } else if (simpleName.equalsIgnoreCase("int")) {
                            field.setInt(newInstance, jSONObject.getInt(field.getName()));
                        } else if (simpleName.equalsIgnoreCase("double")) {
                            field.setDouble(newInstance, jSONObject.getDouble(field.getName()));
                        } else if (simpleName.equalsIgnoreCase("float")) {
                            field.setFloat(newInstance, (float) jSONObject.getDouble(field.getName()));
                        } else if (simpleName.equalsIgnoreCase("string")) {
                            field.set(newInstance, jSONObject.getString(field.getName()));
                        } else if (field.getType().isArray()) {
                            field.set(newInstance, Array.newInstance(field.getType().getComponentType(), jSONObject.getJSONArray(field.getName()).length()));
                            a(field.get(newInstance), jSONObject.getJSONArray(field.getName()));
                        } else {
                            field.set(newInstance, a(field.getType(), jSONObject.getJSONObject(field.getName())));
                        }
                    }
                } catch (IllegalArgumentException e) {
                } catch (IllegalAccessException e2) {
                } catch (Throwable th) {
                }
                if (mi == 2 && Modifier.isPrivate(field.getModifiers())) {
                    field.setAccessible(false);
                }
            }
            return newInstance;
        } catch (InstantiationException e3) {
            return null;
        } catch (IllegalAccessException e4) {
            return null;
        }
    }

    public static void a(Object obj, JSONArray jSONArray) {
        Class cls = obj.getClass();
        String simpleName = cls.getComponentType().getSimpleName();
        for (int i = 0; i < jSONArray.length(); i++) {
            if (cls.getComponentType().isArray()) {
                Array.set(obj, i, Array.newInstance(cls.getComponentType().getComponentType(), jSONArray.getJSONArray(i).length()));
                a(Array.get(obj, i), jSONArray.getJSONArray(i));
            } else if (cls.getComponentType().isPrimitive() || simpleName.equalsIgnoreCase("string")) {
                Array.set(obj, i, jSONArray.get(i));
            } else {
                Array.set(obj, i, a(cls.getComponentType(), jSONArray.getJSONObject(i)));
            }
        }
    }

    public static JSONObject b(Object obj) {
        JSONObject jSONObject = new JSONObject();
        Class cls = obj.getClass();
        for (Field field : mi == 0 ? cls.getFields() : cls.getDeclaredFields()) {
            if (mi == 2 && Modifier.isPrivate(field.getModifiers())) {
                field.setAccessible(true);
            }
            try {
                String name = field.getName();
                String simpleName = field.getType().getSimpleName();
                if (field.get(obj) != null) {
                    if (simpleName.equalsIgnoreCase("boolean")) {
                        jSONObject.put(name, field.getBoolean(obj));
                    } else if (simpleName.equalsIgnoreCase("int")) {
                        jSONObject.put(name, field.getInt(obj));
                    } else if (simpleName.equalsIgnoreCase("double")) {
                        jSONObject.put(name, field.getDouble(obj));
                    } else if (simpleName.equalsIgnoreCase("float")) {
                        jSONObject.put(name, (double) field.getFloat(obj));
                    } else if (simpleName.equalsIgnoreCase("long")) {
                        jSONObject.put(name, field.getLong(obj));
                    } else if (simpleName.equalsIgnoreCase("string")) {
                        jSONObject.put(name, (String) field.get(obj));
                    } else if (simpleName.endsWith("]")) {
                        jSONObject.put(name, c(field.get(obj)));
                    } else {
                        jSONObject.put(name, b(field.get(obj)));
                    }
                }
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e2) {
            } catch (Throwable th) {
            }
            if (mi == 2 && Modifier.isPrivate(field.getModifiers())) {
                field.setAccessible(false);
            }
        }
        return jSONObject;
    }

    public static JSONArray c(Object obj) {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < Array.getLength(obj); i++) {
            if (Array.get(obj, i).getClass().isArray()) {
                jSONArray.put(i, c(Array.get(obj, i)));
            } else {
                jSONArray.put(i, Array.get(obj, i));
            }
        }
        return jSONArray;
    }

    public static int dh() {
        return mi;
    }

    public static void h(int i) {
        if (i >= 0 && i <= 2) {
            mi = i;
        }
    }
}
