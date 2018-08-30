package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;

final class aqn implements BaseConnectionCallbacks {
    final /* synthetic */ aql a;
    private final /* synthetic */ lk b;
    private final /* synthetic */ zzsg c;

    aqn(aql aql, lk lkVar, zzsg zzsg) {
        this.a = aql;
        this.b = lkVar;
        this.c = zzsg;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.a.d) {
            if (this.a.b) {
                return;
            }
            this.a.b = true;
            aqh d = this.a.a;
            if (d == null) {
                return;
            }
            this.b.zza(new aqp(this.b, hr.a(new aqo(this, d, this.b, this.c))), lf.b);
        }
    }

    public final void onConnectionSuspended(int i) {
    }
}
