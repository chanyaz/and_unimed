package com.google.android.gms.internal.ads;

final class yc implements zzbct {
    private static final yc a = new yc();

    private yc() {
    }

    public static yc a() {
        return a;
    }

    public final boolean zza(Class<?> cls) {
        return yd.class.isAssignableFrom(cls);
    }

    public final zzbcs zzb(Class<?> cls) {
        String valueOf;
        if (yd.class.isAssignableFrom(cls)) {
            try {
                return (zzbcs) yd.a(cls.asSubclass(yd.class)).a(yi.c, null, null);
            } catch (Throwable e) {
                Throwable th = e;
                String str = "Unable to get message info for ";
                valueOf = String.valueOf(cls.getName());
                throw new RuntimeException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), th);
            }
        }
        String str2 = "Unsupported message type: ";
        valueOf = String.valueOf(cls.getName());
        throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
    }
}
