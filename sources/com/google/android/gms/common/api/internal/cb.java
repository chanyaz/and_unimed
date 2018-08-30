package com.google.android.gms.common.api.internal;

import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

final class cb implements OnConnectionFailedListener {
    public final int a;
    public final GoogleApiClient b;
    public final OnConnectionFailedListener c;
    private final /* synthetic */ ca d;

    public cb(ca caVar, int i, GoogleApiClient googleApiClient, OnConnectionFailedListener onConnectionFailedListener) {
        this.d = caVar;
        this.a = i;
        this.b = googleApiClient;
        this.c = onConnectionFailedListener;
        googleApiClient.a((OnConnectionFailedListener) this);
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        String valueOf = String.valueOf(connectionResult);
        Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 27).append("beginFailureResolution for ").append(valueOf).toString());
        this.d.b(connectionResult, this.a);
    }
}
