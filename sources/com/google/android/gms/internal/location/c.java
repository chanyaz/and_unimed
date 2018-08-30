package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.f;

abstract class c extends f<Status> {
    public c(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result b(Status status) {
        return status;
    }
}
