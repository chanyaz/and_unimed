package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ar;

public final class ci implements ConnectionCallbacks, OnConnectionFailedListener {
    public final Api<?> a;
    private final boolean b;
    private zzq c;

    public ci(Api<?> api, boolean z) {
        this.a = api;
        this.b = z;
    }

    private final void a() {
        ar.a(this.c, (Object) "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
    }

    public final void a(zzq zzq) {
        this.c = zzq;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        a();
        this.c.onConnected(bundle);
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        a();
        this.c.zza(connectionResult, this.a, this.b);
    }

    public final void onConnectionSuspended(int i) {
        a();
        this.c.onConnectionSuspended(i);
    }
}
