package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.internal.aw;

public final class z implements zzbc {
    private final at a;
    private boolean b = false;

    public z(at atVar) {
        this.a = atVar;
    }

    final void a() {
        if (this.b) {
            this.b = false;
            this.a.d.e.a();
            disconnect();
        }
    }

    public final void begin() {
    }

    public final void connect() {
        if (this.b) {
            this.b = false;
            this.a.a(new ab(this, this));
        }
    }

    public final boolean disconnect() {
        if (this.b) {
            return false;
        }
        if (this.a.d.g()) {
            this.b = true;
            for (bq a : this.a.d.d) {
                a.a();
            }
            return false;
        }
        this.a.a(null);
        return true;
    }

    public final <A extends AnyClient, R extends Result, T extends b<R, A>> T enqueue(T t) {
        return execute(t);
    }

    public final <A extends AnyClient, T extends b<? extends Result, A>> T execute(T t) {
        try {
            this.a.d.e.a(t);
            ao aoVar = this.a.d;
            AnyClient anyClient = (Client) aoVar.b.get(t.d());
            ar.a((Object) anyClient, (Object) "Appropriate Api was not requested.");
            if (anyClient.isConnected() || !this.a.b.containsKey(t.d())) {
                if (anyClient instanceof aw) {
                    anyClient = ((aw) anyClient).r();
                }
                t.a(anyClient);
                return t;
            }
            t.setFailedResult(new Status(17));
            return t;
        } catch (DeadObjectException e) {
            this.a.a(new aa(this, this));
        }
    }

    public final void onConnected(Bundle bundle) {
    }

    public final void onConnectionSuspended(int i) {
        this.a.a(null);
        this.a.e.zzb(i, this.b);
    }

    public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }
}
