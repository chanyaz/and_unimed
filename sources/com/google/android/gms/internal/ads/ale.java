package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class ale extends afa implements zzlo {
    ale(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    public final float getAspectRatio() {
        Parcel a = a(9, a());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    public final int getPlaybackState() {
        Parcel a = a(5, a());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    public final boolean isClickToExpandEnabled() {
        Parcel a = a(12, a());
        boolean a2 = afc.a(a);
        a.recycle();
        return a2;
    }

    public final boolean isCustomControlsEnabled() {
        Parcel a = a(10, a());
        boolean a2 = afc.a(a);
        a.recycle();
        return a2;
    }

    public final boolean isMuted() {
        Parcel a = a(4, a());
        boolean a2 = afc.a(a);
        a.recycle();
        return a2;
    }

    public final void mute(boolean z) {
        Parcel a = a();
        afc.a(a, z);
        b(3, a);
    }

    public final void pause() {
        b(2, a());
    }

    public final void play() {
        b(1, a());
    }

    public final void zza(zzlr zzlr) {
        Parcel a = a();
        afc.a(a, (IInterface) zzlr);
        b(8, a);
    }

    public final float zzim() {
        Parcel a = a(6, a());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    public final float zzin() {
        Parcel a = a(7, a());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    public final zzlr zzio() {
        zzlr zzlr;
        Parcel a = a(11, a());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzlr = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
            zzlr = queryLocalInterface instanceof zzlr ? (zzlr) queryLocalInterface : new alg(readStrongBinder);
        }
        a.recycle();
        return zzlr;
    }
}
