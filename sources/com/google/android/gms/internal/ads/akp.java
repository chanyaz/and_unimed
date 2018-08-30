package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.a;

public final class akp extends afa implements zzks {
    akp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    public final void destroy() {
        b(2, a());
    }

    public final String getAdUnitId() {
        Parcel a = a(31, a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final String getMediationAdapterClassName() {
        Parcel a = a(18, a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final zzlo getVideoController() {
        zzlo zzlo;
        Parcel a = a(26, a());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzlo = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
            zzlo = queryLocalInterface instanceof zzlo ? (zzlo) queryLocalInterface : new ale(readStrongBinder);
        }
        a.recycle();
        return zzlo;
    }

    public final boolean isLoading() {
        Parcel a = a(23, a());
        boolean a2 = afc.a(a);
        a.recycle();
        return a2;
    }

    public final boolean isReady() {
        Parcel a = a(3, a());
        boolean a2 = afc.a(a);
        a.recycle();
        return a2;
    }

    public final void pause() {
        b(5, a());
    }

    public final void resume() {
        b(6, a());
    }

    public final void setImmersiveMode(boolean z) {
        Parcel a = a();
        afc.a(a, z);
        b(34, a);
    }

    public final void setManualImpressionsEnabled(boolean z) {
        Parcel a = a();
        afc.a(a, z);
        b(22, a);
    }

    public final void setUserId(String str) {
        Parcel a = a();
        a.writeString(str);
        b(25, a);
    }

    public final void showInterstitial() {
        b(9, a());
    }

    public final void stopLoading() {
        b(10, a());
    }

    public final void zza(zzaaw zzaaw) {
        Parcel a = a();
        afc.a(a, (IInterface) zzaaw);
        b(14, a);
    }

    public final void zza(zzabc zzabc, String str) {
        Parcel a = a();
        afc.a(a, (IInterface) zzabc);
        a.writeString(str);
        b(15, a);
    }

    public final void zza(zzahe zzahe) {
        Parcel a = a();
        afc.a(a, (IInterface) zzahe);
        b(24, a);
    }

    public final void zza(zzjn zzjn) {
        Parcel a = a();
        afc.a(a, (Parcelable) zzjn);
        b(13, a);
    }

    public final void zza(zzke zzke) {
        Parcel a = a();
        afc.a(a, (IInterface) zzke);
        b(20, a);
    }

    public final void zza(zzkh zzkh) {
        Parcel a = a();
        afc.a(a, (IInterface) zzkh);
        b(7, a);
    }

    public final void zza(zzkx zzkx) {
        Parcel a = a();
        afc.a(a, (IInterface) zzkx);
        b(36, a);
    }

    public final void zza(zzla zzla) {
        Parcel a = a();
        afc.a(a, (IInterface) zzla);
        b(8, a);
    }

    public final void zza(zzlg zzlg) {
        Parcel a = a();
        afc.a(a, (IInterface) zzlg);
        b(21, a);
    }

    public final void zza(zzlu zzlu) {
        Parcel a = a();
        afc.a(a, (Parcelable) zzlu);
        b(30, a);
    }

    public final void zza(zzmu zzmu) {
        Parcel a = a();
        afc.a(a, (Parcelable) zzmu);
        b(29, a);
    }

    public final void zza(zzod zzod) {
        Parcel a = a();
        afc.a(a, (IInterface) zzod);
        b(19, a);
    }

    public final boolean zzb(zzjj zzjj) {
        Parcel a = a();
        afc.a(a, (Parcelable) zzjj);
        a = a(4, a);
        boolean a2 = afc.a(a);
        a.recycle();
        return a2;
    }

    public final Bundle zzba() {
        Parcel a = a(37, a());
        Bundle bundle = (Bundle) afc.a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    public final IObjectWrapper zzbj() {
        Parcel a = a(1, a());
        IObjectWrapper a2 = a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final zzjn zzbk() {
        Parcel a = a(12, a());
        zzjn zzjn = (zzjn) afc.a(a, zzjn.CREATOR);
        a.recycle();
        return zzjn;
    }

    public final void zzbm() {
        b(11, a());
    }

    public final zzla zzbw() {
        zzla zzla;
        Parcel a = a(32, a());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzla = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            zzla = queryLocalInterface instanceof zzla ? (zzla) queryLocalInterface : new akv(readStrongBinder);
        }
        a.recycle();
        return zzla;
    }

    public final zzkh zzbx() {
        zzkh zzkh;
        Parcel a = a(33, a());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzkh = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
            zzkh = queryLocalInterface instanceof zzkh ? (zzkh) queryLocalInterface : new aki(readStrongBinder);
        }
        a.recycle();
        return zzkh;
    }

    public final String zzck() {
        Parcel a = a(35, a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }
}
