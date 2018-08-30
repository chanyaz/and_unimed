package com.google.android.gms.signin;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.signin.internal.i;

final class f extends a<i, b> {
    f() {
    }

    public final /* synthetic */ Client a(Context context, Looper looper, n nVar, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        return new i(context, looper, false, nVar, ((b) obj).a(), connectionCallbacks, onConnectionFailedListener);
    }
}
