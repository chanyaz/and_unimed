package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.o;
import com.google.android.gms.location.d;

final class at extends c {
    private final /* synthetic */ d b;

    at(ar arVar, GoogleApiClient googleApiClient, d dVar) {
        this.b = dVar;
        super(googleApiClient);
    }

    protected final /* synthetic */ void b(AnyClient anyClient) {
        ((v) anyClient).b(o.a(this.b, d.class.getSimpleName()), new d(this));
    }
}
