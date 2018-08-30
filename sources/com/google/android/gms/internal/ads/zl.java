package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zl {
    private static final zl a = new zl();
    private final zzbdn b;
    private final ConcurrentMap<Class<?>, zzbdm<?>> c = new ConcurrentHashMap();

    private zl() {
        zzbdn zzbdn = null;
        String[] strArr = new String[]{"com.google.protobuf.AndroidProto3SchemaFactory"};
        for (int i = 0; i <= 0; i++) {
            zzbdn = a(strArr[0]);
            if (zzbdn != null) {
                break;
            }
        }
        if (zzbdn == null) {
            zzbdn = new yx();
        }
        this.b = zzbdn;
    }

    public static zl a() {
        return a;
    }

    private static zzbdn a(String str) {
        try {
            return (zzbdn) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            return null;
        }
    }

    public final <T> zzbdm<T> a(Class<T> cls) {
        yk.a((Object) cls, "messageType");
        zzbdm<T> zzbdm = (zzbdm) this.c.get(cls);
        if (zzbdm != null) {
            return zzbdm;
        }
        zzbdm<T> zzd = this.b.zzd(cls);
        yk.a((Object) cls, "messageType");
        yk.a((Object) zzd, "schema");
        zzbdm = (zzbdm) this.c.putIfAbsent(cls, zzd);
        return zzbdm != null ? zzbdm : zzd;
    }

    public final <T> zzbdm<T> a(T t) {
        return a(t.getClass());
    }
}
