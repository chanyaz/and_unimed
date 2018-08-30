package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

final class av extends c {
    private final /* synthetic */ Location b;

    av(ar arVar, GoogleApiClient googleApiClient, Location location) {
        this.b = location;
        super(googleApiClient);
    }

    protected final /* synthetic */ void b(AnyClient anyClient) {
        ((v) anyClient).a(this.b);
        setResult(Status.a);
    }
}
