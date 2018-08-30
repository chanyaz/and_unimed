package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

final class zc implements zzbcp {
    zc() {
    }

    public final int zzb(int i, Object obj, Object obj2) {
        zzbco zzbco = (zzbco) obj;
        if (!zzbco.isEmpty()) {
            Iterator it = zzbco.entrySet().iterator();
            if (it.hasNext()) {
                Entry entry = (Entry) it.next();
                entry.getKey();
                entry.getValue();
                throw new NoSuchMethodError();
            }
        }
        return 0;
    }

    public final Object zzb(Object obj, Object obj2) {
        obj = (zzbco) obj;
        zzbco zzbco = (zzbco) obj2;
        if (!zzbco.isEmpty()) {
            if (!obj.d()) {
                obj = obj.b();
            }
            obj.a(zzbco);
        }
        return obj;
    }

    public final Map<?, ?> zzs(Object obj) {
        return (zzbco) obj;
    }

    public final Map<?, ?> zzt(Object obj) {
        return (zzbco) obj;
    }

    public final boolean zzu(Object obj) {
        return !((zzbco) obj).d();
    }

    public final Object zzv(Object obj) {
        ((zzbco) obj).c();
        return obj;
    }

    public final Object zzw(Object obj) {
        return zzbco.a().b();
    }

    public final zb<?, ?> zzx(Object obj) {
        throw new NoSuchMethodError();
    }
}
