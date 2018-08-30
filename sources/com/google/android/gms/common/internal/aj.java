package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.GoogleCertificatesQuery;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.stable.a;
import com.google.android.gms.internal.stable.c;

public class aj extends a implements IGoogleCertificatesApi {
    aj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    public IObjectWrapper getGoogleCertificates() {
        Parcel a = a(1, a());
        IObjectWrapper a2 = com.google.android.gms.dynamic.a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public IObjectWrapper getGoogleReleaseCertificates() {
        Parcel a = a(2, a());
        IObjectWrapper a2 = com.google.android.gms.dynamic.a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public boolean isGoogleOrPlatformSigned(GoogleCertificatesQuery googleCertificatesQuery, IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        c.a(a, (Parcelable) googleCertificatesQuery);
        c.a(a, (IInterface) iObjectWrapper);
        a = a(5, a);
        boolean a2 = c.a(a);
        a.recycle();
        return a2;
    }

    public boolean isGoogleReleaseSigned(String str, IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        a.writeString(str);
        c.a(a, (IInterface) iObjectWrapper);
        a = a(3, a);
        boolean a2 = c.a(a);
        a.recycle();
        return a2;
    }

    public boolean isGoogleSigned(String str, IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        a.writeString(str);
        c.a(a, (IInterface) iObjectWrapper);
        a = a(4, a);
        boolean a2 = c.a(a);
        a.recycle();
        return a2;
    }
}
