package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.GoogleCertificatesQuery;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.internal.stable.b;
import com.google.android.gms.internal.stable.c;

public abstract class ai extends b implements IGoogleCertificatesApi {
    public ai() {
        super("com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    public static IGoogleCertificatesApi a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        return queryLocalInterface instanceof IGoogleCertificatesApi ? (IGoogleCertificatesApi) queryLocalInterface : new aj(iBinder);
    }

    protected boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        IInterface googleCertificates;
        boolean isGoogleReleaseSigned;
        switch (i) {
            case 1:
                googleCertificates = getGoogleCertificates();
                parcel2.writeNoException();
                c.a(parcel2, googleCertificates);
                break;
            case 2:
                googleCertificates = getGoogleReleaseCertificates();
                parcel2.writeNoException();
                c.a(parcel2, googleCertificates);
                break;
            case 3:
                isGoogleReleaseSigned = isGoogleReleaseSigned(parcel.readString(), a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                c.a(parcel2, isGoogleReleaseSigned);
                break;
            case 4:
                isGoogleReleaseSigned = isGoogleSigned(parcel.readString(), a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                c.a(parcel2, isGoogleReleaseSigned);
                break;
            case 5:
                isGoogleReleaseSigned = isGoogleOrPlatformSigned((GoogleCertificatesQuery) c.a(parcel, GoogleCertificatesQuery.CREATOR), a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                c.a(parcel2, isGoogleReleaseSigned);
                break;
            default:
                return false;
        }
        return true;
    }
}
