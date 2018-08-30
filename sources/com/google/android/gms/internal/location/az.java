package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;

final class az extends c {
    private final /* synthetic */ LocationRequest b;
    private final /* synthetic */ PendingIntent c;

    az(ar arVar, GoogleApiClient googleApiClient, LocationRequest locationRequest, PendingIntent pendingIntent) {
        this.b = locationRequest;
        this.c = pendingIntent;
        super(googleApiClient);
    }

    protected final /* synthetic */ void b(AnyClient anyClient) {
        ((v) anyClient).a(this.b, this.c, new d(this));
    }
}
