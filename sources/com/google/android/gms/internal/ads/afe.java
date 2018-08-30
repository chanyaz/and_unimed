package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class afe extends afa implements zzen {
    afe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.clearcut.IClearcut");
    }

    public final void zza(IObjectWrapper iObjectWrapper, String str) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        a.writeString(str);
        b(2, a);
    }

    public final void zza(IObjectWrapper iObjectWrapper, String str, String str2) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        a.writeString(str);
        a.writeString(null);
        b(8, a);
    }

    public final void zza(int[] iArr) {
        Parcel a = a();
        a.writeIntArray(null);
        b(4, a);
    }

    public final void zzbd() {
        b(3, a());
    }

    public final void zzc(byte[] bArr) {
        Parcel a = a();
        a.writeByteArray(bArr);
        b(5, a);
    }

    public final void zzg(int i) {
        Parcel a = a();
        a.writeInt(i);
        b(6, a);
    }

    public final void zzh(int i) {
        Parcel a = a();
        a.writeInt(i);
        b(7, a);
    }
}
