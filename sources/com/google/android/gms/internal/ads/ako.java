package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

public abstract class ako extends afb implements zzks {
    public ako() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static zzks a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        return queryLocalInterface instanceof zzks ? (zzks) queryLocalInterface : new akp(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzkx zzkx = null;
        IInterface zzbj;
        boolean isReady;
        IBinder readStrongBinder;
        Parcelable zzbk;
        String mediationAdapterClassName;
        switch (i) {
            case 1:
                zzbj = zzbj();
                parcel2.writeNoException();
                afc.a(parcel2, zzbj);
                break;
            case 2:
                destroy();
                parcel2.writeNoException();
                break;
            case 3:
                isReady = isReady();
                parcel2.writeNoException();
                afc.a(parcel2, isReady);
                break;
            case 4:
                isReady = zzb((zzjj) afc.a(parcel, zzjj.CREATOR));
                parcel2.writeNoException();
                afc.a(parcel2, isReady);
                break;
            case 5:
                pause();
                parcel2.writeNoException();
                break;
            case 6:
                resume();
                parcel2.writeNoException();
                break;
            case 7:
                zzkh aki;
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    zzbj = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    aki = zzbj instanceof zzkh ? (zzkh) zzbj : new aki(readStrongBinder);
                }
                zza(aki);
                parcel2.writeNoException();
                break;
            case 8:
                zzla akv;
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    zzbj = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
                    akv = zzbj instanceof zzla ? (zzla) zzbj : new akv(readStrongBinder);
                }
                zza(akv);
                parcel2.writeNoException();
                break;
            case 9:
                showInterstitial();
                parcel2.writeNoException();
                break;
            case 10:
                stopLoading();
                parcel2.writeNoException();
                break;
            case 11:
                zzbm();
                parcel2.writeNoException();
                break;
            case 12:
                zzbk = zzbk();
                parcel2.writeNoException();
                afc.b(parcel2, zzbk);
                break;
            case 13:
                zza((zzjn) afc.a(parcel, zzjn.CREATOR));
                parcel2.writeNoException();
                break;
            case 14:
                zza(s.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 15:
                zza(w.a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                break;
            case 18:
                mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                break;
            case 19:
                zza(anf.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 20:
                zzke akg;
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    zzbj = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdClickListener");
                    akg = zzbj instanceof zzke ? (zzke) zzbj : new akg(readStrongBinder);
                }
                zza(akg);
                parcel2.writeNoException();
                break;
            case 21:
                zzlg akz;
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    zzbj = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    akz = zzbj instanceof zzlg ? (zzlg) zzbj : new akz(readStrongBinder);
                }
                zza(akz);
                parcel2.writeNoException();
                break;
            case 22:
                setManualImpressionsEnabled(afc.a(parcel));
                parcel2.writeNoException();
                break;
            case 23:
                isReady = isLoading();
                parcel2.writeNoException();
                afc.a(parcel2, isReady);
                break;
            case 24:
                zza(fb.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 25:
                setUserId(parcel.readString());
                parcel2.writeNoException();
                break;
            case 26:
                zzbj = getVideoController();
                parcel2.writeNoException();
                afc.a(parcel2, zzbj);
                break;
            case 29:
                zza((zzmu) afc.a(parcel, zzmu.CREATOR));
                parcel2.writeNoException();
                break;
            case 30:
                zza((zzlu) afc.a(parcel, zzlu.CREATOR));
                parcel2.writeNoException();
                break;
            case 31:
                mediationAdapterClassName = getAdUnitId();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                break;
            case 32:
                zzbj = zzbw();
                parcel2.writeNoException();
                afc.a(parcel2, zzbj);
                break;
            case 33:
                zzbj = zzbx();
                parcel2.writeNoException();
                afc.a(parcel2, zzbj);
                break;
            case 34:
                setImmersiveMode(afc.a(parcel));
                parcel2.writeNoException();
                break;
            case 35:
                mediationAdapterClassName = zzck();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                break;
            case 36:
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    zzbj = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener");
                    zzkx = zzbj instanceof zzkx ? (zzkx) zzbj : new aks(readStrongBinder);
                }
                zza(zzkx);
                parcel2.writeNoException();
                break;
            case 37:
                zzbk = zzba();
                parcel2.writeNoException();
                afc.b(parcel2, zzbk);
                break;
            default:
                return false;
        }
        return true;
    }
}
