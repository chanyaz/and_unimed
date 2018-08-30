package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Result;
import java.util.Collections;

public final class an implements zzbc {
    private final at a;

    public an(at atVar) {
        this.a = atVar;
    }

    public final void begin() {
        for (Client disconnect : this.a.a.values()) {
            disconnect.disconnect();
        }
        this.a.d.c = Collections.emptySet();
    }

    public final void connect() {
        this.a.a();
    }

    public final boolean disconnect() {
        return true;
    }

    public final <A extends AnyClient, R extends Result, T extends b<R, A>> T enqueue(T t) {
        this.a.d.a.add(t);
        return t;
    }

    public final <A extends AnyClient, T extends b<? extends Result, A>> T execute(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final void onConnected(Bundle bundle) {
    }

    public final void onConnectionSuspended(int i) {
    }

    public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }
}
