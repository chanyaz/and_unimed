package com.google.android.gms.internal.ads;

import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;

final class aqq implements BaseOnConnectionFailedListener {
    private final /* synthetic */ lk a;
    private final /* synthetic */ aql b;

    aqq(aql aql, lk lkVar) {
        this.b = aql;
        this.a = lkVar;
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        synchronized (this.b.d) {
            this.a.a(new RuntimeException("Connection failed."));
        }
    }
}
