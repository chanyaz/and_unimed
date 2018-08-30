package com.google.android.gms.internal.ads;

final class xw {
    private static final xu<?> a = new xv();
    private static final xu<?> b = c();

    static xu<?> a() {
        return a;
    }

    static xu<?> b() {
        if (b != null) {
            return b;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    private static xu<?> c() {
        try {
            return (xu) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }
}
