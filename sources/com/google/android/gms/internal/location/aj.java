package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

final class aj extends am {
    private final /* synthetic */ PendingIntent b;

    aj(ah ahVar, GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        this.b = pendingIntent;
        super(googleApiClient);
    }

    protected final /* synthetic */ void b(AnyClient anyClient) {
        ((v) anyClient).a(this.b);
        setResult(Status.a);
    }
}
