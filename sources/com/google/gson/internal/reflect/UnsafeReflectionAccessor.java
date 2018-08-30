package com.google.gson.internal.reflect;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

final class UnsafeReflectionAccessor extends ReflectionAccessor {
    private static Class unsafeClass;
    private final Field overrideField = getOverrideField();
    private final Object theUnsafe = getUnsafeInstance();

    UnsafeReflectionAccessor() {
    }

    private static Field getOverrideField() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException e) {
            return null;
        }
    }

    private static Object getUnsafeInstance() {
        Object obj = null;
        try {
            unsafeClass = Class.forName("sun.misc.Unsafe");
            Field declaredField = unsafeClass.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e) {
            return obj;
        }
    }

    public void makeAccessible(AccessibleObject accessibleObject) {
        if (!makeAccessibleWithUnsafe(accessibleObject)) {
            try {
                accessibleObject.setAccessible(true);
            } catch (Throwable e) {
                throw new JsonIOException("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e);
            }
        }
    }

    boolean makeAccessibleWithUnsafe(AccessibleObject accessibleObject) {
        if (!(this.theUnsafe == null || this.overrideField == null)) {
            try {
                long longValue = ((Long) unsafeClass.getMethod("objectFieldOffset", new Class[]{Field.class}).invoke(this.theUnsafe, new Object[]{this.overrideField})).longValue();
                unsafeClass.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE}).invoke(this.theUnsafe, new Object[]{accessibleObject, Long.valueOf(longValue), Boolean.valueOf(true)});
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }
}
