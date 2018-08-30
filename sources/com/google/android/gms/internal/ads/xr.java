package com.google.android.gms.internal.ads;

final class xr {
    private static final Class<?> a = b();

    public static xs a() {
        if (a != null) {
            try {
                return (xs) a.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception e) {
            }
        }
        return xs.a;
    }

    private static Class<?> b() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}
