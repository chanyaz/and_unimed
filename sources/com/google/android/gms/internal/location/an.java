package com.google.android.gms.internal.location;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.u;

public class an extends u<zzao> {
    protected final zzbj<zzao> e = new ao(this);
    private final String f;

    public an(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, n nVar) {
        super(context, looper, 23, nVar, connectionCallbacks, onConnectionFailedListener);
        this.f = str;
    }

    protected String a() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    protected String d() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    public int getMinApkVersion() {
        return 11925000;
    }

    protected Bundle m() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.f);
        return bundle;
    }
}
