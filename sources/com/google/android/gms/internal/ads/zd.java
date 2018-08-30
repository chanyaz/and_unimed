package com.google.android.gms.internal.ads;

final class zd {
    private static final zzbcp a = c();
    private static final zzbcp b = new zc();

    static zzbcp a() {
        return a;
    }

    static zzbcp b() {
        return b;
    }

    private static zzbcp c() {
        try {
            return (zzbcp) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }
}
