package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.a;
import java.util.List;

public abstract class ave extends afb implements zzxz {
    public ave() {
        super("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        String headline;
        IInterface zzjz;
        boolean overrideImpressionRecording;
        switch (i) {
            case 2:
                headline = getHeadline();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            case 3:
                List images = getImages();
                parcel2.writeNoException();
                parcel2.writeList(images);
                break;
            case 4:
                headline = getBody();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            case 5:
                zzjz = zzjz();
                parcel2.writeNoException();
                afc.a(parcel2, zzjz);
                break;
            case 6:
                headline = getCallToAction();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            case 7:
                double starRating = getStarRating();
                parcel2.writeNoException();
                parcel2.writeDouble(starRating);
                break;
            case 8:
                headline = getStore();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            case 9:
                headline = getPrice();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            case 10:
                recordImpression();
                parcel2.writeNoException();
                break;
            case 11:
                zzj(a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 12:
                zzk(a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 13:
                overrideImpressionRecording = getOverrideImpressionRecording();
                parcel2.writeNoException();
                afc.a(parcel2, overrideImpressionRecording);
                break;
            case 14:
                overrideImpressionRecording = getOverrideClickHandling();
                parcel2.writeNoException();
                afc.a(parcel2, overrideImpressionRecording);
                break;
            case 15:
                Parcelable extras = getExtras();
                parcel2.writeNoException();
                afc.b(parcel2, extras);
                break;
            case 16:
                zzl(a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 17:
                zzjz = getVideoController();
                parcel2.writeNoException();
                afc.a(parcel2, zzjz);
                break;
            case 18:
                zzjz = zzmv();
                parcel2.writeNoException();
                afc.a(parcel2, zzjz);
                break;
            case 19:
                zzjz = zzkf();
                parcel2.writeNoException();
                afc.a(parcel2, zzjz);
                break;
            case 20:
                zzjz = zzmw();
                parcel2.writeNoException();
                afc.a(parcel2, zzjz);
                break;
            case 21:
                zzjz = zzke();
                parcel2.writeNoException();
                afc.a(parcel2, zzjz);
                break;
            case 22:
                zzb(a.a(parcel.readStrongBinder()), a.a(parcel.readStrongBinder()), a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
