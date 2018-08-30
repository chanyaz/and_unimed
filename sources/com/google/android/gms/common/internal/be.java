package com.google.android.gms.common.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;

final class be implements BaseOnConnectionFailedListener {
    private final /* synthetic */ OnConnectionFailedListener a;

    be(OnConnectionFailedListener onConnectionFailedListener) {
        this.a = onConnectionFailedListener;
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.a.onConnectionFailed(connectionResult);
    }
}
