package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

final class au extends c {
    private final /* synthetic */ boolean b;

    au(ar arVar, GoogleApiClient googleApiClient, boolean z) {
        this.b = z;
        super(googleApiClient);
    }

    protected final /* synthetic */ void b(AnyClient anyClient) {
        ((v) anyClient).a(this.b);
        setResult(Status.a);
    }
}
