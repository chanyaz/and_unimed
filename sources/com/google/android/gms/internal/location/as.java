package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.o;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;

final class as extends c {
    private final /* synthetic */ LocationRequest b;
    private final /* synthetic */ LocationListener c;

    as(ar arVar, GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener) {
        this.b = locationRequest;
        this.c = locationListener;
        super(googleApiClient);
    }

    protected final /* synthetic */ void b(AnyClient anyClient) {
        ((v) anyClient).a(this.b, o.a(this.c, af.a(), LocationListener.class.getSimpleName()), new d(this));
    }
}
