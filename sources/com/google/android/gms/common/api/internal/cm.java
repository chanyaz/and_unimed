package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

final class cm implements zzbq {
    private final /* synthetic */ cj a;

    private cm(cj cjVar) {
        this.a = cjVar;
    }

    /* synthetic */ cm(cj cjVar, ck ckVar) {
        this(cjVar);
    }

    public final void zzb(int i, boolean z) {
        this.a.m.lock();
        try {
            if (this.a.l) {
                this.a.l = false;
                this.a.a(i, z);
                return;
            }
            this.a.l = true;
            this.a.d.onConnectionSuspended(i);
            this.a.m.unlock();
        } finally {
            this.a.m.unlock();
        }
    }

    public final void zzb(@Nullable Bundle bundle) {
        this.a.m.lock();
        try {
            this.a.k = ConnectionResult.a;
            this.a.a();
        } finally {
            this.a.m.unlock();
        }
    }

    public final void zzc(@NonNull ConnectionResult connectionResult) {
        this.a.m.lock();
        try {
            this.a.k = connectionResult;
            this.a.a();
        } finally {
            this.a.m.unlock();
        }
    }
}
