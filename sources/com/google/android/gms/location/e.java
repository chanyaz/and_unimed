package com.google.android.gms.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.internal.location.ad;
import com.google.android.gms.internal.location.ar;
import com.google.android.gms.internal.location.f;
import com.google.android.gms.internal.location.v;

public class e {
    public static final Api<Object> a = new Api("LocationServices.API", f, e);
    @Deprecated
    public static final FusedLocationProviderApi b = new ar();
    @Deprecated
    public static final GeofencingApi c = new f();
    @Deprecated
    public static final SettingsApi d = new ad();
    private static final d<v> e = new d();
    private static final a<v, Object> f = new m();

    private e() {
    }

    public static v a(GoogleApiClient googleApiClient) {
        boolean z = true;
        com.google.android.gms.common.internal.ar.b(googleApiClient != null, "GoogleApiClient parameter is required.");
        v vVar = (v) googleApiClient.a(e);
        if (vVar == null) {
            z = false;
        }
        com.google.android.gms.common.internal.ar.a(z, (Object) "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return vVar;
    }
}
