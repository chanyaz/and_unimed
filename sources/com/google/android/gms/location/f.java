package com.google.android.gms.location;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.b;
import com.google.android.gms.internal.location.v;

public abstract class f<R extends Result> extends b<R, v> {
    public f(GoogleApiClient googleApiClient) {
        super(e.a, googleApiClient);
    }
}
