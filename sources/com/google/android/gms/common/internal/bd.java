package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;

final class bd implements BaseConnectionCallbacks {
    private final /* synthetic */ ConnectionCallbacks a;

    bd(ConnectionCallbacks connectionCallbacks) {
        this.a = connectionCallbacks;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        this.a.onConnected(bundle);
    }

    public final void onConnectionSuspended(int i) {
        this.a.onConnectionSuspended(i);
    }
}
