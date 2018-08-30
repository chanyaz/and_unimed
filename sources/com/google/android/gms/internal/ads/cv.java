package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

public final class cv extends afa implements zzaen {
    cv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    public final void zza(zzaef zzaef, zzaeq zzaeq) {
        Parcel a = a();
        afc.a(a, (Parcelable) zzaef);
        afc.a(a, (IInterface) zzaeq);
        b(2, a);
    }

    public final void zza(zzaey zzaey, zzaet zzaet) {
        Parcel a = a();
        afc.a(a, (Parcelable) zzaey);
        afc.a(a, (IInterface) zzaet);
        b(4, a);
    }

    public final zzaej zzb(zzaef zzaef) {
        Parcel a = a();
        afc.a(a, (Parcelable) zzaef);
        Parcel a2 = a(1, a);
        zzaej zzaej = (zzaej) afc.a(a2, zzaej.CREATOR);
        a2.recycle();
        return zzaej;
    }

    public final void zzb(zzaey zzaey, zzaet zzaet) {
        Parcel a = a();
        afc.a(a, (Parcelable) zzaey);
        afc.a(a, (IInterface) zzaet);
        b(5, a);
    }
}
