package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class akk extends afa implements zzkk {
    akk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoader");
    }

    public final String getMediationAdapterClassName() {
        Parcel a = a(2, a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final boolean isLoading() {
        Parcel a = a(3, a());
        boolean a2 = afc.a(a);
        a.recycle();
        return a2;
    }

    public final void zza(zzjj zzjj, int i) {
        Parcel a = a();
        afc.a(a, (Parcelable) zzjj);
        a.writeInt(i);
        b(5, a);
    }

    public final String zzck() {
        Parcel a = a(4, a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final void zzd(zzjj zzjj) {
        Parcel a = a();
        afc.a(a, (Parcelable) zzjj);
        b(1, a);
    }
}
