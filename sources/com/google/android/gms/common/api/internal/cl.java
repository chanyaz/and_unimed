package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

final class cl implements zzbq {
    private final /* synthetic */ cj a;

    private cl(cj cjVar) {
        this.a = cjVar;
    }

    /* synthetic */ cl(cj cjVar, ck ckVar) {
        this(cjVar);
    }

    public final void zzb(int i, boolean z) {
        this.a.m.lock();
        try {
            if (this.a.l || this.a.k == null || !this.a.k.b()) {
                this.a.l = false;
                this.a.a(i, z);
                return;
            }
            this.a.l = true;
            this.a.e.onConnectionSuspended(i);
            this.a.m.unlock();
        } finally {
            this.a.m.unlock();
        }
    }

    public final void zzb(@Nullable Bundle bundle) {
        this.a.m.lock();
        try {
            this.a.a(bundle);
            this.a.j = ConnectionResult.a;
            this.a.a();
        } finally {
            this.a.m.unlock();
        }
    }

    public final void zzc(@NonNull ConnectionResult connectionResult) {
        this.a.m.lock();
        try {
            this.a.j = connectionResult;
            this.a.a();
        } finally {
            this.a.m.unlock();
        }
    }
}
