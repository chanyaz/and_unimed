package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class fu extends afa implements zzaic {
    fu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzaig zzaig) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        afc.a(a, (Parcelable) zzaig);
        b(7, a);
    }

    public final void zzc(Bundle bundle) {
        Parcel a = a();
        afc.a(a, (Parcelable) bundle);
        b(12, a);
    }

    public final void zzc(IObjectWrapper iObjectWrapper, int i) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        a.writeInt(i);
        b(2, a);
    }

    public final void zzd(IObjectWrapper iObjectWrapper, int i) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        a.writeInt(i);
        b(9, a);
    }

    public final void zzq(IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        b(1, a);
    }

    public final void zzr(IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        b(3, a);
    }

    public final void zzs(IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        b(4, a);
    }

    public final void zzt(IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        b(5, a);
    }

    public final void zzu(IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        b(6, a);
    }

    public final void zzv(IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        b(8, a);
    }

    public final void zzw(IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        b(10, a);
    }

    public final void zzx(IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        b(11, a);
    }
}
