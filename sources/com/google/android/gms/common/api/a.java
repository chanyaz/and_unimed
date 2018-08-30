package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepForSdk
@VisibleForTesting
public abstract class a<T extends Client, O> extends c<T, O> {
    @KeepForSdk
    public abstract T a(Context context, Looper looper, n nVar, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener);
}
