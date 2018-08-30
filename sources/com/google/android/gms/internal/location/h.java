package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.location.zzal;

final class h extends i {
    private final /* synthetic */ zzal b;

    h(f fVar, GoogleApiClient googleApiClient, zzal zzal) {
        this.b = zzal;
        super(googleApiClient);
    }

    protected final /* synthetic */ void b(AnyClient anyClient) {
        ((v) anyClient).a(this.b, (ResultHolder) this);
    }
}
