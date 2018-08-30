package com.google.android.gms.internal.location;

import android.os.Looper;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.o;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.d;

final class ay extends c {
    private final /* synthetic */ LocationRequest b;
    private final /* synthetic */ d c;
    private final /* synthetic */ Looper d;

    ay(ar arVar, GoogleApiClient googleApiClient, LocationRequest locationRequest, d dVar, Looper looper) {
        this.b = locationRequest;
        this.c = dVar;
        this.d = looper;
        super(googleApiClient);
    }

    protected final /* synthetic */ void b(AnyClient anyClient) {
        ((v) anyClient).a(zzbd.a(this.b), o.a(this.c, af.a(this.d), d.class.getSimpleName()), new d(this));
    }
}
