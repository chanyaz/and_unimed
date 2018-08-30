package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;

final class b extends c {
    private final /* synthetic */ PendingIntent b;

    b(ar arVar, GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        this.b = pendingIntent;
        super(googleApiClient);
    }

    protected final /* synthetic */ void b(AnyClient anyClient) {
        ((v) anyClient).a(this.b, new d(this));
    }
}
