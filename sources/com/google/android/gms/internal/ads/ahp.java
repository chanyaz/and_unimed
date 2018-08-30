package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;

final class ahp implements BaseConnectionCallbacks {
    private final /* synthetic */ ahm a;

    ahp(ahm ahm) {
        this.a = ahm;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.a.b) {
            try {
                if (this.a.c != null) {
                    this.a.e = this.a.c.r();
                }
            } catch (Throwable e) {
                kk.b("Unable to obtain a cache service instance.", e);
                this.a.c();
            }
            this.a.b.notifyAll();
        }
    }

    public final void onConnectionSuspended(int i) {
        synchronized (this.a.b) {
            this.a.e = null;
            this.a.b.notifyAll();
        }
    }
}
