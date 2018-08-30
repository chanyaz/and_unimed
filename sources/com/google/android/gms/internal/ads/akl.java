package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

public abstract class akl extends afb implements zzkn {
    public akl() {
        super("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzlg zzlg = null;
        IInterface zzdh;
        IBinder readStrongBinder;
        switch (i) {
            case 1:
                zzdh = zzdh();
                parcel2.writeNoException();
                afc.a(parcel2, zzdh);
                break;
            case 2:
                zzkh aki;
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    zzdh = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    aki = zzdh instanceof zzkh ? (zzkh) zzdh : new aki(readStrongBinder);
                }
                zzb(aki);
                parcel2.writeNoException();
                break;
            case 3:
                zza(api.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 4:
                zza(apl.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 5:
                zza(parcel.readString(), app.a(parcel.readStrongBinder()), apn.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 6:
                zza((zzpl) afc.a(parcel, zzpl.CREATOR));
                parcel2.writeNoException();
                break;
            case 7:
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    zzdh = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    zzlg = zzdh instanceof zzlg ? (zzlg) zzdh : new akz(readStrongBinder);
                }
                zzb(zzlg);
                parcel2.writeNoException();
                break;
            case 8:
                zza(apr.a(parcel.readStrongBinder()), (zzjn) afc.a(parcel, zzjn.CREATOR));
                parcel2.writeNoException();
                break;
            case 9:
                zza((PublisherAdViewOptions) afc.a(parcel, PublisherAdViewOptions.CREATOR));
                parcel2.writeNoException();
                break;
            case 10:
                zza(apt.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
