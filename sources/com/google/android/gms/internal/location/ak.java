package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.location.ActivityTransitionRequest;

final class ak extends am {
    private final /* synthetic */ ActivityTransitionRequest b;
    private final /* synthetic */ PendingIntent c;

    ak(ah ahVar, GoogleApiClient googleApiClient, ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent) {
        this.b = activityTransitionRequest;
        this.c = pendingIntent;
        super(googleApiClient);
    }

    protected final /* synthetic */ void b(AnyClient anyClient) {
        ((v) anyClient).a(this.b, this.c, (ResultHolder) this);
    }
}
