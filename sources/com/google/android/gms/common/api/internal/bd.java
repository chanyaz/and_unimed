package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import java.util.Collections;

final class bd implements Runnable {
    private final /* synthetic */ ConnectionResult a;
    private final /* synthetic */ h b;

    bd(h hVar, ConnectionResult connectionResult) {
        this.b = hVar;
        this.a = connectionResult;
    }

    public final void run() {
        if (this.a.b()) {
            this.b.f = true;
            if (this.b.b.requiresSignIn()) {
                this.b.a();
                return;
            } else {
                this.b.b.getRemoteService(null, Collections.emptySet());
                return;
            }
        }
        ((f) this.b.a.m.get(this.b.c)).onConnectionFailed(this.a);
    }
}
