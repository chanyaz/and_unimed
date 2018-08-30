package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.a;
import java.util.List;

public final class apd extends afa implements zzqo {
    apd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeContentAd");
    }

    public final void destroy() {
        b(10, a());
    }

    public final String getAdvertiser() {
        Parcel a = a(8, a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final String getBody() {
        Parcel a = a(5, a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final String getCallToAction() {
        Parcel a = a(7, a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final Bundle getExtras() {
        Parcel a = a(9, a());
        Bundle bundle = (Bundle) afc.a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    public final String getHeadline() {
        Parcel a = a(3, a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final List getImages() {
        Parcel a = a(4, a());
        List b = afc.b(a);
        a.recycle();
        return b;
    }

    public final String getMediationAdapterClassName() {
        Parcel a = a(17, a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final zzlo getVideoController() {
        Parcel a = a(11, a());
        zzlo a2 = ald.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final void performClick(Bundle bundle) {
        Parcel a = a();
        afc.a(a, (Parcelable) bundle);
        b(12, a);
    }

    public final boolean recordImpression(Bundle bundle) {
        Parcel a = a();
        afc.a(a, (Parcelable) bundle);
        a = a(13, a);
        boolean a2 = afc.a(a);
        a.recycle();
        return a2;
    }

    public final void reportTouchEvent(Bundle bundle) {
        Parcel a = a();
        afc.a(a, (Parcelable) bundle);
        b(14, a);
    }

    public final IObjectWrapper zzka() {
        Parcel a = a(2, a());
        IObjectWrapper a2 = a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final IObjectWrapper zzke() {
        Parcel a = a(16, a());
        IObjectWrapper a2 = a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final zzps zzkf() {
        zzps zzps;
        Parcel a = a(15, a());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzps = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
            zzps = queryLocalInterface instanceof zzps ? (zzps) queryLocalInterface : new aoo(readStrongBinder);
        }
        a.recycle();
        return zzps;
    }

    public final zzpw zzkg() {
        zzpw zzpw;
        Parcel a = a(6, a());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzpw = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            zzpw = queryLocalInterface instanceof zzpw ? (zzpw) queryLocalInterface : new aor(readStrongBinder);
        }
        a.recycle();
        return zzpw;
    }
}
