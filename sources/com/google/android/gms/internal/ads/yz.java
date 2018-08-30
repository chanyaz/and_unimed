package com.google.android.gms.internal.ads;

final class yz implements zzbct {
    private zzbct[] a;

    yz(zzbct... zzbctArr) {
        this.a = zzbctArr;
    }

    public final boolean zza(Class<?> cls) {
        for (zzbct zza : this.a) {
            if (zza.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzbcs zzb(Class<?> cls) {
        for (zzbct zzbct : this.a) {
            if (zzbct.zza(cls)) {
                return zzbct.zzb(cls);
            }
        }
        String str = "No factory is available for message type: ";
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }
}
