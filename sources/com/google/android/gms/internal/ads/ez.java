package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class ez extends afa implements zzagz {
    ez(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    public final void destroy() {
        b(8, a());
    }

    public final String getMediationAdapterClassName() {
        Parcel a = a(12, a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final boolean isLoaded() {
        Parcel a = a(5, a());
        boolean a2 = afc.a(a);
        a.recycle();
        return a2;
    }

    public final void pause() {
        b(6, a());
    }

    public final void resume() {
        b(7, a());
    }

    public final void setImmersiveMode(boolean z) {
        Parcel a = a();
        afc.a(a, z);
        b(34, a);
    }

    public final void setUserId(String str) {
        Parcel a = a();
        a.writeString(str);
        b(13, a);
    }

    public final void show() {
        b(2, a());
    }

    public final void zza(zzagx zzagx) {
        Parcel a = a();
        afc.a(a, (IInterface) zzagx);
        b(16, a);
    }

    public final void zza(zzahe zzahe) {
        Parcel a = a();
        afc.a(a, (IInterface) zzahe);
        b(3, a);
    }

    public final void zza(zzahk zzahk) {
        Parcel a = a();
        afc.a(a, (Parcelable) zzahk);
        b(1, a);
    }

    public final void zza(zzkx zzkx) {
        Parcel a = a();
        afc.a(a, (IInterface) zzkx);
        b(14, a);
    }

    public final Bundle zzba() {
        Parcel a = a(15, a());
        Bundle bundle = (Bundle) afc.a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    public final void zzd(IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        b(9, a);
    }

    public final void zze(IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        b(10, a);
    }

    public final void zzf(IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        b(11, a);
    }
}
