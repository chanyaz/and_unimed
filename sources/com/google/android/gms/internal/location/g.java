package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.location.GeofencingRequest;

final class g extends i {
    private final /* synthetic */ GeofencingRequest b;
    private final /* synthetic */ PendingIntent c;

    g(f fVar, GoogleApiClient googleApiClient, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        this.b = geofencingRequest;
        this.c = pendingIntent;
        super(googleApiClient);
    }

    protected final /* synthetic */ void b(AnyClient anyClient) {
        ((v) anyClient).a(this.b, this.c, (ResultHolder) this);
    }
}
