package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public abstract class apc extends afb implements zzqo {
    public apc() {
        super("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        IInterface zzka;
        String headline;
        switch (i) {
            case 2:
                zzka = zzka();
                parcel2.writeNoException();
                afc.a(parcel2, zzka);
                break;
            case 3:
                headline = getHeadline();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            case 4:
                List images = getImages();
                parcel2.writeNoException();
                parcel2.writeList(images);
                break;
            case 5:
                headline = getBody();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            case 6:
                zzka = zzkg();
                parcel2.writeNoException();
                afc.a(parcel2, zzka);
                break;
            case 7:
                headline = getCallToAction();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            case 8:
                headline = getAdvertiser();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            case 9:
                Parcelable extras = getExtras();
                parcel2.writeNoException();
                afc.b(parcel2, extras);
                break;
            case 10:
                destroy();
                parcel2.writeNoException();
                break;
            case 11:
                zzka = getVideoController();
                parcel2.writeNoException();
                afc.a(parcel2, zzka);
                break;
            case 12:
                performClick((Bundle) afc.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 13:
                boolean recordImpression = recordImpression((Bundle) afc.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                afc.a(parcel2, recordImpression);
                break;
            case 14:
                reportTouchEvent((Bundle) afc.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 15:
                zzka = zzkf();
                parcel2.writeNoException();
                afc.a(parcel2, zzka);
                break;
            case 16:
                zzka = zzke();
                parcel2.writeNoException();
                afc.a(parcel2, zzka);
                break;
            case 17:
                headline = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            default:
                return false;
        }
        return true;
    }
}
