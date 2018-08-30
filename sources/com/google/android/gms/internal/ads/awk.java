package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class awk extends afa implements zzzj {
    awk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public final zzlo getVideoController() {
        Parcel a = a(5, a());
        zzlo a2 = ald.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final void showInterstitial() {
        b(7, a());
    }

    public final void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, zzzm zzzm) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        a.writeString(str);
        afc.a(a, (Parcelable) bundle);
        afc.a(a, (IInterface) zzzm);
        b(1, a);
    }

    public final void zza(byte[] bArr, String str, Bundle bundle, IObjectWrapper iObjectWrapper, zzzf zzzf, zzxt zzxt, zzjn zzjn) {
        Parcel a = a();
        a.writeByteArray(bArr);
        a.writeString(str);
        afc.a(a, (Parcelable) bundle);
        afc.a(a, (IInterface) iObjectWrapper);
        afc.a(a, (IInterface) zzzf);
        afc.a(a, (IInterface) zzxt);
        afc.a(a, (Parcelable) zzjn);
        b(4, a);
    }

    public final void zza(byte[] bArr, String str, Bundle bundle, IObjectWrapper iObjectWrapper, zzzh zzzh, zzxt zzxt) {
        Parcel a = a();
        a.writeByteArray(bArr);
        a.writeString(str);
        afc.a(a, (Parcelable) bundle);
        afc.a(a, (IInterface) iObjectWrapper);
        afc.a(a, (IInterface) zzzh);
        afc.a(a, (IInterface) zzxt);
        b(6, a);
    }

    public final zzzt zznc() {
        Parcel a = a(2, a());
        zzzt zzzt = (zzzt) afc.a(a, zzzt.CREATOR);
        a.recycle();
        return zzzt;
    }

    public final zzzt zznd() {
        Parcel a = a(3, a());
        zzzt zzzt = (zzzt) afc.a(a, zzzt.CREATOR);
        a.recycle();
        return zzzt;
    }
}
