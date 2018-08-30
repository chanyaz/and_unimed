package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

public final class akm extends afa implements zzkn {
    akm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    public final void zza(PublisherAdViewOptions publisherAdViewOptions) {
        Parcel a = a();
        afc.a(a, (Parcelable) publisherAdViewOptions);
        b(9, a);
    }

    public final void zza(zzpl zzpl) {
        Parcel a = a();
        afc.a(a, (Parcelable) zzpl);
        b(6, a);
    }

    public final void zza(zzqw zzqw) {
        Parcel a = a();
        afc.a(a, (IInterface) zzqw);
        b(3, a);
    }

    public final void zza(zzqz zzqz) {
        Parcel a = a();
        afc.a(a, (IInterface) zzqz);
        b(4, a);
    }

    public final void zza(zzri zzri, zzjn zzjn) {
        Parcel a = a();
        afc.a(a, (IInterface) zzri);
        afc.a(a, (Parcelable) zzjn);
        b(8, a);
    }

    public final void zza(zzrl zzrl) {
        Parcel a = a();
        afc.a(a, (IInterface) zzrl);
        b(10, a);
    }

    public final void zza(String str, zzrf zzrf, zzrc zzrc) {
        Parcel a = a();
        a.writeString(str);
        afc.a(a, (IInterface) zzrf);
        afc.a(a, (IInterface) zzrc);
        b(5, a);
    }

    public final void zzb(zzkh zzkh) {
        Parcel a = a();
        afc.a(a, (IInterface) zzkh);
        b(2, a);
    }

    public final void zzb(zzlg zzlg) {
        Parcel a = a();
        afc.a(a, (IInterface) zzlg);
        b(7, a);
    }

    public final zzkk zzdh() {
        zzkk zzkk;
        Parcel a = a(1, a());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzkk = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoader");
            zzkk = queryLocalInterface instanceof zzkk ? (zzkk) queryLocalInterface : new akk(readStrongBinder);
        }
        a.recycle();
        return zzkk;
    }
}
