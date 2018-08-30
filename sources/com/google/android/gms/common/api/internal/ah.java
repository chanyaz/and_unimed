package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import javax.annotation.concurrent.GuardedBy;

final class ah extends au {
    private final /* synthetic */ ConnectionProgressReportCallbacks a;

    ah(af afVar, zzbc zzbc, ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        this.a = connectionProgressReportCallbacks;
        super(zzbc);
    }

    @GuardedBy("mLock")
    public final void a() {
        this.a.onReportServiceBinding(new ConnectionResult(16, null));
    }
}
