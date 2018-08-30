package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import javax.annotation.concurrent.GuardedBy;

final class ag extends au {
    private final /* synthetic */ ConnectionResult a;
    private final /* synthetic */ af b;

    ag(af afVar, zzbc zzbc, ConnectionResult connectionResult) {
        this.b = afVar;
        this.a = connectionResult;
        super(zzbc);
    }

    @GuardedBy("mLock")
    public final void a() {
        this.b.a.b(this.a);
    }
}
