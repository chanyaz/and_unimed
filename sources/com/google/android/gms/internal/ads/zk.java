package com.google.android.gms.internal.ads;

final class zk {
    private static final zzbdc a = c();
    private static final zzbdc b = new zj();

    static zzbdc a() {
        return a;
    }

    static zzbdc b() {
        return b;
    }

    private static zzbdc c() {
        try {
            return (zzbdc) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }
}
