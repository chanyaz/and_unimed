package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.a;
import java.util.List;

public abstract class avi extends afb implements zzyf {
    public avi() {
        super("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
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
                headline = getAdvertiser();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            case 8:
                double starRating = getStarRating();
                parcel2.writeNoException();
                parcel2.writeDouble(starRating);
                break;
            case 9:
                headline = getStore();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            case 10:
                headline = getPrice();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            case 11:
                zzjz = getVideoController();
                parcel2.writeNoException();
                afc.a(parcel2, zzjz);
                break;
            case 12:
                zzjz = zzkf();
                parcel2.writeNoException();
                afc.a(parcel2, zzjz);
                break;
            case 13:
                zzjz = zzmv();
                parcel2.writeNoException();
                afc.a(parcel2, zzjz);
                break;
            case 14:
                zzjz = zzmw();
                parcel2.writeNoException();
                afc.a(parcel2, zzjz);
                break;
            case 15:
                zzjz = zzke();
                parcel2.writeNoException();
                afc.a(parcel2, zzjz);
                break;
            case 16:
                Parcelable extras = getExtras();
                parcel2.writeNoException();
                afc.b(parcel2, extras);
                break;
            case 17:
                overrideImpressionRecording = getOverrideImpressionRecording();
                parcel2.writeNoException();
                afc.a(parcel2, overrideImpressionRecording);
                break;
            case 18:
                overrideImpressionRecording = getOverrideClickHandling();
                parcel2.writeNoException();
                afc.a(parcel2, overrideImpressionRecording);
                break;
            case 19:
                recordImpression();
                parcel2.writeNoException();
                break;
            case 20:
                zzj(a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 21:
                zzb(a.a(parcel.readStrongBinder()), a.a(parcel.readStrongBinder()), a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 22:
                zzl(a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
