package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;

public final class aqk extends afa implements zzsk {
    aqk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    public final ParcelFileDescriptor zza(zzsg zzsg) {
        Parcel a = a();
        afc.a(a, (Parcelable) zzsg);
        Parcel a2 = a(1, a);
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) afc.a(a2, ParcelFileDescriptor.CREATOR);
        a2.recycle();
        return parcelFileDescriptor;
    }
}
