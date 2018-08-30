package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.a;
import java.util.List;

public abstract class avg extends afb implements zzyc {
    public avg() {
        super("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        String headline;
        IInterface zzkg;
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
                zzkg = zzkg();
                parcel2.writeNoException();
                afc.a(parcel2, zzkg);
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
                recordImpression();
                parcel2.writeNoException();
                break;
            case 9:
                zzj(a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 10:
                zzk(a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 11:
                overrideImpressionRecording = getOverrideImpressionRecording();
                parcel2.writeNoException();
                afc.a(parcel2, overrideImpressionRecording);
                break;
            case 12:
                overrideImpressionRecording = getOverrideClickHandling();
                parcel2.writeNoException();
                afc.a(parcel2, overrideImpressionRecording);
                break;
            case 13:
                Parcelable extras = getExtras();
                parcel2.writeNoException();
                afc.b(parcel2, extras);
                break;
            case 14:
                zzl(a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 15:
                zzkg = zzmv();
                parcel2.writeNoException();
                afc.a(parcel2, zzkg);
                break;
            case 16:
                zzkg = getVideoController();
                parcel2.writeNoException();
                afc.a(parcel2, zzkg);
                break;
            case 19:
                zzkg = zzkf();
                parcel2.writeNoException();
                afc.a(parcel2, zzkg);
                break;
            case 20:
                zzkg = zzmw();
                parcel2.writeNoException();
                afc.a(parcel2, zzkg);
                break;
            case 21:
                zzkg = zzke();
                parcel2.writeNoException();
                afc.a(parcel2, zzkg);
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
