package com.google.android.gms.internal.location;

import android.os.Looper;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.o;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;

final class ax extends c {
    private final /* synthetic */ LocationRequest b;
    private final /* synthetic */ LocationListener c;
    private final /* synthetic */ Looper d;

    ax(ar arVar, GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener, Looper looper) {
        this.b = locationRequest;
        this.c = locationListener;
        this.d = looper;
        super(googleApiClient);
    }

    protected final /* synthetic */ void b(AnyClient anyClient) {
        ((v) anyClient).a(this.b, o.a(this.c, af.a(this.d), LocationListener.class.getSimpleName()), new d(this));
    }
}
