package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

final class ai extends am {
    private final /* synthetic */ long b;
    private final /* synthetic */ PendingIntent c;

    ai(ah ahVar, GoogleApiClient googleApiClient, long j, PendingIntent pendingIntent) {
        this.b = j;
        this.c = pendingIntent;
        super(googleApiClient);
    }

    protected final /* synthetic */ void b(AnyClient anyClient) {
        ((v) anyClient).a(this.b, this.c);
        setResult(Status.a);
    }
}
