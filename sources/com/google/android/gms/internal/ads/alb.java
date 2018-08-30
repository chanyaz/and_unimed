package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class alb extends afa implements zzlj {
    alb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    public final void setAppMuted(boolean z) {
        Parcel a = a();
        afc.a(a, z);
        b(4, a);
    }

    public final void setAppVolume(float f) {
        Parcel a = a();
        a.writeFloat(f);
        b(2, a);
    }

    public final void zza() {
        b(1, a());
    }

    public final void zza(String str, IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        a.writeString(str);
        afc.a(a, (IInterface) iObjectWrapper);
        b(6, a);
    }

    public final void zzb(IObjectWrapper iObjectWrapper, String str) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        a.writeString(str);
        b(5, a);
    }

    public final float zzdo() {
        Parcel a = a(7, a());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    public final boolean zzdp() {
        Parcel a = a(8, a());
        boolean a2 = afc.a(a);
        a.recycle();
        return a2;
    }

    public final void zzt(String str) {
        Parcel a = a();
        a.writeString(str);
        b(3, a);
    }
}
