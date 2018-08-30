package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.support.annotation.BinderThread;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

public final class j extends k {
    private final /* synthetic */ BaseGmsClient a;

    @BinderThread
    public j(BaseGmsClient baseGmsClient, int i, @Nullable Bundle bundle) {
        this.a = baseGmsClient;
        super(baseGmsClient, i, bundle);
    }

    protected final void a(ConnectionResult connectionResult) {
        this.a.b.onReportServiceBinding(connectionResult);
        this.a.a(connectionResult);
    }

    protected final boolean e() {
        this.a.b.onReportServiceBinding(ConnectionResult.a);
        return true;
    }
}
