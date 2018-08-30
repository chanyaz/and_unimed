package com.google.android.gms.internal.ads;

import android.os.Parcel;

public abstract class alf extends afb implements zzlr {
    public alf() {
        super("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                onVideoStart();
                break;
            case 2:
                onVideoPlay();
                break;
            case 3:
                onVideoPause();
                break;
            case 4:
                onVideoEnd();
                break;
            case 5:
                onVideoMute(afc.a(parcel));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
