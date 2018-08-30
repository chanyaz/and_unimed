package com.google.android.gms.internal.ads;

final class yx implements zzbdn {
    private static final zzbct b = new yy();
    private final zzbct a;

    public yx() {
        this(new yz(yc.a(), a()));
    }

    private yx(zzbct zzbct) {
        this.a = (zzbct) yk.a((Object) zzbct, "messageInfoFactory");
    }

    private static zzbct a() {
        try {
            return (zzbct) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            return b;
        }
    }

    private static boolean a(zzbcs zzbcs) {
        return zzbcs.zzaeh() == yi.h;
    }

    public final <T> zzbdm<T> zzd(Class<T> cls) {
        zq.a((Class) cls);
        zzbcs zzb = this.a.zzb(cls);
        if (zzb.zzaei()) {
            return yd.class.isAssignableFrom(cls) ? zi.a(zq.c(), xw.a(), zzb.zzaej()) : zi.a(zq.a(), xw.b(), zzb.zzaej());
        } else {
            if (yd.class.isAssignableFrom(cls)) {
                if (a(zzb)) {
                    return zf.a((Class) cls, zzb, zk.b(), ys.b(), zq.c(), xw.a(), zd.b());
                }
                return zf.a((Class) cls, zzb, zk.b(), ys.b(), zq.c(), null, zd.b());
            } else if (a(zzb)) {
                return zf.a((Class) cls, zzb, zk.a(), ys.a(), zq.a(), xw.b(), zd.a());
            } else {
                return zf.a((Class) cls, zzb, zk.a(), ys.a(), zq.b(), null, zd.a());
            }
        }
    }
}
