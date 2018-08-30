package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

final class al implements ConnectionCallbacks, OnConnectionFailedListener {
    private final /* synthetic */ ac a;

    private al(ac acVar) {
        this.a = acVar;
    }

    /* synthetic */ al(ac acVar, ad adVar) {
        this(acVar);
    }

    public final void onConnected(Bundle bundle) {
        this.a.k.signIn(new aj(this.a));
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.a.b.lock();
        try {
            if (this.a.a(connectionResult)) {
                this.a.d();
                this.a.b();
            } else {
                this.a.b(connectionResult);
            }
            this.a.b.unlock();
        } catch (Throwable th) {
            this.a.b.unlock();
        }
    }

    public final void onConnectionSuspended(int i) {
    }
}
