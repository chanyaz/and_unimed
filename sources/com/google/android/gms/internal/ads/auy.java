package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.a;

public abstract class auy extends afb implements zzxq {
    public auy() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzxt zzxt = null;
        IObjectWrapper a;
        zzjn zzjn;
        zzjj zzjj;
        String readString;
        IBinder readStrongBinder;
        zzxt zzxt2;
        IInterface queryLocalInterface;
        String readString2;
        zzjj zzjj2;
        boolean isInitialized;
        Parcelable zzmq;
        switch (i) {
            case 1:
                a = a.a(parcel.readStrongBinder());
                zzjn = (zzjn) afc.a(parcel, zzjn.CREATOR);
                zzjj = (zzjj) afc.a(parcel, zzjj.CREATOR);
                readString = parcel.readString();
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzxt2 = null;
                } else {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzxt2 = queryLocalInterface instanceof zzxt ? (zzxt) queryLocalInterface : new avb(readStrongBinder);
                }
                zza(a, zzjn, zzjj, readString, zzxt2);
                parcel2.writeNoException();
                break;
            case 2:
                queryLocalInterface = getView();
                parcel2.writeNoException();
                afc.a(parcel2, queryLocalInterface);
                break;
            case 3:
                IObjectWrapper a2 = a.a(parcel.readStrongBinder());
                zzjj zzjj3 = (zzjj) afc.a(parcel, zzjj.CREATOR);
                readString2 = parcel.readString();
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzxt = queryLocalInterface2 instanceof zzxt ? (zzxt) queryLocalInterface2 : new avb(readStrongBinder2);
                }
                zza(a2, zzjj3, readString2, zzxt);
                parcel2.writeNoException();
                break;
            case 4:
                showInterstitial();
                parcel2.writeNoException();
                break;
            case 5:
                destroy();
                parcel2.writeNoException();
                break;
            case 6:
                a = a.a(parcel.readStrongBinder());
                zzjn = (zzjn) afc.a(parcel, zzjn.CREATOR);
                zzjj = (zzjj) afc.a(parcel, zzjj.CREATOR);
                readString = parcel.readString();
                String readString3 = parcel.readString();
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzxt = queryLocalInterface instanceof zzxt ? (zzxt) queryLocalInterface : new avb(readStrongBinder);
                }
                zza(a, zzjn, zzjj, readString, readString3, zzxt);
                parcel2.writeNoException();
                break;
            case 7:
                a = a.a(parcel.readStrongBinder());
                zzjj2 = (zzjj) afc.a(parcel, zzjj.CREATOR);
                readString2 = parcel.readString();
                readString = parcel.readString();
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzxt2 = null;
                } else {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzxt2 = queryLocalInterface instanceof zzxt ? (zzxt) queryLocalInterface : new avb(readStrongBinder);
                }
                zza(a, zzjj2, readString2, readString, zzxt2);
                parcel2.writeNoException();
                break;
            case 8:
                pause();
                parcel2.writeNoException();
                break;
            case 9:
                resume();
                parcel2.writeNoException();
                break;
            case 10:
                zza(a.a(parcel.readStrongBinder()), (zzjj) afc.a(parcel, zzjj.CREATOR), parcel.readString(), ft.a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                break;
            case 11:
                zzc((zzjj) afc.a(parcel, zzjj.CREATOR), parcel.readString());
                parcel2.writeNoException();
                break;
            case 12:
                showVideo();
                parcel2.writeNoException();
                break;
            case 13:
                isInitialized = isInitialized();
                parcel2.writeNoException();
                afc.a(parcel2, isInitialized);
                break;
            case 14:
                a = a.a(parcel.readStrongBinder());
                zzjj2 = (zzjj) afc.a(parcel, zzjj.CREATOR);
                readString2 = parcel.readString();
                readString = parcel.readString();
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzxt2 = null;
                } else {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzxt2 = queryLocalInterface instanceof zzxt ? (zzxt) queryLocalInterface : new avb(readStrongBinder);
                }
                zza(a, zzjj2, readString2, readString, zzxt2, (zzpl) afc.a(parcel, zzpl.CREATOR), parcel.createStringArrayList());
                parcel2.writeNoException();
                break;
            case 15:
                queryLocalInterface = zzmo();
                parcel2.writeNoException();
                afc.a(parcel2, queryLocalInterface);
                break;
            case 16:
                queryLocalInterface = zzmp();
                parcel2.writeNoException();
                afc.a(parcel2, queryLocalInterface);
                break;
            case 17:
                zzmq = zzmq();
                parcel2.writeNoException();
                afc.b(parcel2, zzmq);
                break;
            case 18:
                zzmq = getInterstitialAdapterInfo();
                parcel2.writeNoException();
                afc.b(parcel2, zzmq);
                break;
            case 19:
                zzmq = zzmr();
                parcel2.writeNoException();
                afc.b(parcel2, zzmq);
                break;
            case 20:
                zza((zzjj) afc.a(parcel, zzjj.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                break;
            case 21:
                zzi(a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 22:
                isInitialized = zzms();
                parcel2.writeNoException();
                afc.a(parcel2, isInitialized);
                break;
            case 23:
                zza(a.a(parcel.readStrongBinder()), ft.a(parcel.readStrongBinder()), parcel.createStringArrayList());
                parcel2.writeNoException();
                break;
            case 24:
                queryLocalInterface = zzmt();
                parcel2.writeNoException();
                afc.a(parcel2, queryLocalInterface);
                break;
            case 25:
                setImmersiveMode(afc.a(parcel));
                parcel2.writeNoException();
                break;
            case 26:
                queryLocalInterface = getVideoController();
                parcel2.writeNoException();
                afc.a(parcel2, queryLocalInterface);
                break;
            case 27:
                queryLocalInterface = zzmu();
                parcel2.writeNoException();
                afc.a(parcel2, queryLocalInterface);
                break;
            default:
                return false;
        }
        return true;
    }
}
