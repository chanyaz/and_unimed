package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.a;
import java.util.List;

public final class avh extends afa implements zzyc {
    avh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
    }

    public final String getAdvertiser() {
        Parcel a = a(7, a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final String getBody() {
        Parcel a = a(4, a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final String getCallToAction() {
        Parcel a = a(6, a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final Bundle getExtras() {
        Parcel a = a(13, a());
        Bundle bundle = (Bundle) afc.a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    public final String getHeadline() {
        Parcel a = a(2, a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final List getImages() {
        Parcel a = a(3, a());
        List b = afc.b(a);
        a.recycle();
        return b;
    }

    public final boolean getOverrideClickHandling() {
        Parcel a = a(12, a());
        boolean a2 = afc.a(a);
        a.recycle();
        return a2;
    }

    public final boolean getOverrideImpressionRecording() {
        Parcel a = a(11, a());
        boolean a2 = afc.a(a);
        a.recycle();
        return a2;
    }

    public final zzlo getVideoController() {
        Parcel a = a(16, a());
        zzlo a2 = ald.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final void recordImpression() {
        b(8, a());
    }

    public final void zzb(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        afc.a(a, (IInterface) iObjectWrapper2);
        afc.a(a, (IInterface) iObjectWrapper3);
        b(22, a);
    }

    public final void zzj(IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        b(9, a);
    }

    public final void zzk(IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        b(10, a);
    }

    public final IObjectWrapper zzke() {
        Parcel a = a(21, a());
        IObjectWrapper a2 = a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final zzps zzkf() {
        Parcel a = a(19, a());
        zzps a2 = aon.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final zzpw zzkg() {
        Parcel a = a(5, a());
        zzpw a2 = aoq.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final void zzl(IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        b(14, a);
    }

    public final IObjectWrapper zzmv() {
        Parcel a = a(15, a());
        IObjectWrapper a2 = a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final IObjectWrapper zzmw() {
        Parcel a = a(20, a());
        IObjectWrapper a2 = a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }
}
