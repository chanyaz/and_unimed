package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.a;
import java.util.List;

public final class auz extends afa implements zzxq {
    auz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    public final void destroy() {
        b(5, a());
    }

    public final Bundle getInterstitialAdapterInfo() {
        Parcel a = a(18, a());
        Bundle bundle = (Bundle) afc.a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    public final zzlo getVideoController() {
        Parcel a = a(26, a());
        zzlo a2 = ald.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final IObjectWrapper getView() {
        Parcel a = a(2, a());
        IObjectWrapper a2 = a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final boolean isInitialized() {
        Parcel a = a(13, a());
        boolean a2 = afc.a(a);
        a.recycle();
        return a2;
    }

    public final void pause() {
        b(8, a());
    }

    public final void resume() {
        b(9, a());
    }

    public final void setImmersiveMode(boolean z) {
        Parcel a = a();
        afc.a(a, z);
        b(25, a);
    }

    public final void showInterstitial() {
        b(4, a());
    }

    public final void showVideo() {
        b(12, a());
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzaic zzaic, List<String> list) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        afc.a(a, (IInterface) zzaic);
        a.writeStringList(list);
        b(23, a);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzjj zzjj, String str, zzaic zzaic, String str2) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        afc.a(a, (Parcelable) zzjj);
        a.writeString(str);
        afc.a(a, (IInterface) zzaic);
        a.writeString(str2);
        b(10, a);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzjj zzjj, String str, zzxt zzxt) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        afc.a(a, (Parcelable) zzjj);
        a.writeString(str);
        afc.a(a, (IInterface) zzxt);
        b(3, a);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzjj zzjj, String str, String str2, zzxt zzxt) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        afc.a(a, (Parcelable) zzjj);
        a.writeString(str);
        a.writeString(str2);
        afc.a(a, (IInterface) zzxt);
        b(7, a);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzjj zzjj, String str, String str2, zzxt zzxt, zzpl zzpl, List<String> list) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        afc.a(a, (Parcelable) zzjj);
        a.writeString(str);
        a.writeString(str2);
        afc.a(a, (IInterface) zzxt);
        afc.a(a, (Parcelable) zzpl);
        a.writeStringList(list);
        b(14, a);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzjn zzjn, zzjj zzjj, String str, zzxt zzxt) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        afc.a(a, (Parcelable) zzjn);
        afc.a(a, (Parcelable) zzjj);
        a.writeString(str);
        afc.a(a, (IInterface) zzxt);
        b(1, a);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzjn zzjn, zzjj zzjj, String str, String str2, zzxt zzxt) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        afc.a(a, (Parcelable) zzjn);
        afc.a(a, (Parcelable) zzjj);
        a.writeString(str);
        a.writeString(str2);
        afc.a(a, (IInterface) zzxt);
        b(6, a);
    }

    public final void zza(zzjj zzjj, String str, String str2) {
        Parcel a = a();
        afc.a(a, (Parcelable) zzjj);
        a.writeString(str);
        a.writeString(str2);
        b(20, a);
    }

    public final void zzc(zzjj zzjj, String str) {
        Parcel a = a();
        afc.a(a, (Parcelable) zzjj);
        a.writeString(str);
        b(11, a);
    }

    public final void zzi(IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        b(21, a);
    }

    public final zzxz zzmo() {
        zzxz zzxz;
        Parcel a = a(15, a());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzxz = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            zzxz = queryLocalInterface instanceof zzxz ? (zzxz) queryLocalInterface : new avf(readStrongBinder);
        }
        a.recycle();
        return zzxz;
    }

    public final zzyc zzmp() {
        zzyc zzyc;
        Parcel a = a(16, a());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzyc = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            zzyc = queryLocalInterface instanceof zzyc ? (zzyc) queryLocalInterface : new avh(readStrongBinder);
        }
        a.recycle();
        return zzyc;
    }

    public final Bundle zzmq() {
        Parcel a = a(17, a());
        Bundle bundle = (Bundle) afc.a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    public final Bundle zzmr() {
        Parcel a = a(19, a());
        Bundle bundle = (Bundle) afc.a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    public final boolean zzms() {
        Parcel a = a(22, a());
        boolean a2 = afc.a(a);
        a.recycle();
        return a2;
    }

    public final zzqs zzmt() {
        Parcel a = a(24, a());
        zzqs a2 = apf.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final zzyf zzmu() {
        zzyf zzyf;
        Parcel a = a(27, a());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzyf = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
            zzyf = queryLocalInterface instanceof zzyf ? (zzyf) queryLocalInterface : new avj(readStrongBinder);
        }
        a.recycle();
        return zzyf;
    }
}
