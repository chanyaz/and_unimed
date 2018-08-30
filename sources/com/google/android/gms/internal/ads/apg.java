package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.a;
import java.util.List;

public final class apg extends afa implements zzqs {
    apg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    public final void destroy() {
        b(8, a());
    }

    public final List<String> getAvailableAssetNames() {
        Parcel a = a(3, a());
        List createStringArrayList = a.createStringArrayList();
        a.recycle();
        return createStringArrayList;
    }

    public final String getCustomTemplateId() {
        Parcel a = a(4, a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final zzlo getVideoController() {
        Parcel a = a(7, a());
        zzlo a2 = ald.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final void performClick(String str) {
        Parcel a = a();
        a.writeString(str);
        b(5, a);
    }

    public final void recordImpression() {
        b(6, a());
    }

    public final String zzao(String str) {
        Parcel a = a();
        a.writeString(str);
        a = a(1, a);
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final zzpw zzap(String str) {
        zzpw zzpw;
        Parcel a = a();
        a.writeString(str);
        Parcel a2 = a(2, a);
        IBinder readStrongBinder = a2.readStrongBinder();
        if (readStrongBinder == null) {
            zzpw = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            zzpw = queryLocalInterface instanceof zzpw ? (zzpw) queryLocalInterface : new aor(readStrongBinder);
        }
        a2.recycle();
        return zzpw;
    }

    public final boolean zzh(IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        a = a(10, a);
        boolean a2 = afc.a(a);
        a.recycle();
        return a2;
    }

    public final IObjectWrapper zzka() {
        Parcel a = a(11, a());
        IObjectWrapper a2 = a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final IObjectWrapper zzkh() {
        Parcel a = a(9, a());
        IObjectWrapper a2 = a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }
}
