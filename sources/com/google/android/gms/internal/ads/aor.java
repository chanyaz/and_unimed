package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.a;

public final class aor extends afa implements zzpw {
    aor(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public final double getScale() {
        Parcel a = a(3, a());
        double readDouble = a.readDouble();
        a.recycle();
        return readDouble;
    }

    public final Uri getUri() {
        Parcel a = a(2, a());
        Uri uri = (Uri) afc.a(a, Uri.CREATOR);
        a.recycle();
        return uri;
    }

    public final IObjectWrapper zzjy() {
        Parcel a = a(1, a());
        IObjectWrapper a2 = a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }
}
