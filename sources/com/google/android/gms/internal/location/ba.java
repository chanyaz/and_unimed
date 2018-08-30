package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.o;
import com.google.android.gms.location.LocationListener;

final class ba extends c {
    private final /* synthetic */ LocationListener b;

    ba(ar arVar, GoogleApiClient googleApiClient, LocationListener locationListener) {
        this.b = locationListener;
        super(googleApiClient);
    }

    protected final /* synthetic */ void b(AnyClient anyClient) {
        ((v) anyClient).a(o.a(this.b, LocationListener.class.getSimpleName()), new d(this));
    }
}
