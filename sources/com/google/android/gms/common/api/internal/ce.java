package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ar;

final class ce {
    private final int a;
    private final ConnectionResult b;

    ce(ConnectionResult connectionResult, int i) {
        ar.a((Object) connectionResult);
        this.b = connectionResult;
        this.a = i;
    }

    final int a() {
        return this.a;
    }

    final ConnectionResult b() {
        return this.b;
    }
}
