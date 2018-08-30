package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.internal.location.v;

final class i extends a<v, Object> {
    i() {
    }

    public final /* synthetic */ Client a(Context context, Looper looper, n nVar, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        return new v(context, looper, connectionCallbacks, onConnectionFailedListener, "activity_recognition");
    }
}
