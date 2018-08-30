package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class ald extends afb implements zzlo {
    public ald() {
        super("com.google.android.gms.ads.internal.client.IVideoController");
    }

    public static zzlo a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
        return queryLocalInterface instanceof zzlo ? (zzlo) queryLocalInterface : new ale(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        boolean isMuted;
        float zzim;
        IInterface queryLocalInterface;
        switch (i) {
            case 1:
                play();
                parcel2.writeNoException();
                break;
            case 2:
                pause();
                parcel2.writeNoException();
                break;
            case 3:
                mute(afc.a(parcel));
                parcel2.writeNoException();
                break;
            case 4:
                isMuted = isMuted();
                parcel2.writeNoException();
                afc.a(parcel2, isMuted);
                break;
            case 5:
                int playbackState = getPlaybackState();
                parcel2.writeNoException();
                parcel2.writeInt(playbackState);
                break;
            case 6:
                zzim = zzim();
                parcel2.writeNoException();
                parcel2.writeFloat(zzim);
                break;
            case 7:
                zzim = zzin();
                parcel2.writeNoException();
                parcel2.writeFloat(zzim);
                break;
            case 8:
                zzlr zzlr;
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzlr = null;
                } else {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
                    zzlr = queryLocalInterface instanceof zzlr ? (zzlr) queryLocalInterface : new alg(readStrongBinder);
                }
                zza(zzlr);
                parcel2.writeNoException();
                break;
            case 9:
                zzim = getAspectRatio();
                parcel2.writeNoException();
                parcel2.writeFloat(zzim);
                break;
            case 10:
                isMuted = isCustomControlsEnabled();
                parcel2.writeNoException();
                afc.a(parcel2, isMuted);
                break;
            case 11:
                queryLocalInterface = zzio();
                parcel2.writeNoException();
                afc.a(parcel2, queryLocalInterface);
                break;
            case 12:
                isMuted = isClickToExpandEnabled();
                parcel2.writeNoException();
                afc.a(parcel2, isMuted);
                break;
            default:
                return false;
        }
        return true;
    }
}
