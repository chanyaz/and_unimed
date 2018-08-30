package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public final class dj extends ix implements zzey {
    dj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final List<zzjx> zza(zzdz zzdz, boolean z) {
        Parcel a = a();
        iz.a(a, (Parcelable) zzdz);
        iz.a(a, z);
        a = a(7, a);
        List createTypedArrayList = a.createTypedArrayList(zzjx.CREATOR);
        a.recycle();
        return createTypedArrayList;
    }

    public final List<zzed> zza(String str, String str2, zzdz zzdz) {
        Parcel a = a();
        a.writeString(str);
        a.writeString(str2);
        iz.a(a, (Parcelable) zzdz);
        a = a(16, a);
        List createTypedArrayList = a.createTypedArrayList(zzed.CREATOR);
        a.recycle();
        return createTypedArrayList;
    }

    public final List<zzjx> zza(String str, String str2, String str3, boolean z) {
        Parcel a = a();
        a.writeString(str);
        a.writeString(str2);
        a.writeString(str3);
        iz.a(a, z);
        a = a(15, a);
        List createTypedArrayList = a.createTypedArrayList(zzjx.CREATOR);
        a.recycle();
        return createTypedArrayList;
    }

    public final List<zzjx> zza(String str, String str2, boolean z, zzdz zzdz) {
        Parcel a = a();
        a.writeString(str);
        a.writeString(str2);
        iz.a(a, z);
        iz.a(a, (Parcelable) zzdz);
        a = a(14, a);
        List createTypedArrayList = a.createTypedArrayList(zzjx.CREATOR);
        a.recycle();
        return createTypedArrayList;
    }

    public final void zza(long j, String str, String str2, String str3) {
        Parcel a = a();
        a.writeLong(j);
        a.writeString(str);
        a.writeString(str2);
        a.writeString(str3);
        b(10, a);
    }

    public final void zza(zzdz zzdz) {
        Parcel a = a();
        iz.a(a, (Parcelable) zzdz);
        b(4, a);
    }

    public final void zza(zzed zzed, zzdz zzdz) {
        Parcel a = a();
        iz.a(a, (Parcelable) zzed);
        iz.a(a, (Parcelable) zzdz);
        b(12, a);
    }

    public final void zza(zzeu zzeu, zzdz zzdz) {
        Parcel a = a();
        iz.a(a, (Parcelable) zzeu);
        iz.a(a, (Parcelable) zzdz);
        b(1, a);
    }

    public final void zza(zzeu zzeu, String str, String str2) {
        Parcel a = a();
        iz.a(a, (Parcelable) zzeu);
        a.writeString(str);
        a.writeString(str2);
        b(5, a);
    }

    public final void zza(zzjx zzjx, zzdz zzdz) {
        Parcel a = a();
        iz.a(a, (Parcelable) zzjx);
        iz.a(a, (Parcelable) zzdz);
        b(2, a);
    }

    public final byte[] zza(zzeu zzeu, String str) {
        Parcel a = a();
        iz.a(a, (Parcelable) zzeu);
        a.writeString(str);
        a = a(9, a);
        byte[] createByteArray = a.createByteArray();
        a.recycle();
        return createByteArray;
    }

    public final void zzb(zzdz zzdz) {
        Parcel a = a();
        iz.a(a, (Parcelable) zzdz);
        b(6, a);
    }

    public final void zzb(zzed zzed) {
        Parcel a = a();
        iz.a(a, (Parcelable) zzed);
        b(13, a);
    }

    public final String zzc(zzdz zzdz) {
        Parcel a = a();
        iz.a(a, (Parcelable) zzdz);
        a = a(11, a);
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final void zzd(zzdz zzdz) {
        Parcel a = a();
        iz.a(a, (Parcelable) zzdz);
        b(18, a);
    }

    public final List<zzed> zze(String str, String str2, String str3) {
        Parcel a = a();
        a.writeString(str);
        a.writeString(str2);
        a.writeString(str3);
        a = a(17, a);
        List createTypedArrayList = a.createTypedArrayList(zzed.CREATOR);
        a.recycle();
        return createTypedArrayList;
    }
}
