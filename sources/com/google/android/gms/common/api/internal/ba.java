package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

final class ba implements Runnable {
    private final /* synthetic */ ConnectionResult a;
    private final /* synthetic */ f b;

    ba(f fVar, ConnectionResult connectionResult) {
        this.b = fVar;
        this.a = connectionResult;
    }

    public final void run() {
        this.b.onConnectionFailed(this.a);
    }
}
