package com.google.android.gms.common.internal;

import android.os.IInterface;
import com.google.android.gms.common.GoogleCertificatesQuery;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface IGoogleCertificatesApi extends IInterface {
    IObjectWrapper getGoogleCertificates();

    IObjectWrapper getGoogleReleaseCertificates();

    boolean isGoogleOrPlatformSigned(GoogleCertificatesQuery googleCertificatesQuery, IObjectWrapper iObjectWrapper);

    boolean isGoogleReleaseSigned(String str, IObjectWrapper iObjectWrapper);

    boolean isGoogleSigned(String str, IObjectWrapper iObjectWrapper);
}
