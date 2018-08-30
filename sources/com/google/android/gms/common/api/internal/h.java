package com.google.android.gms.common.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.Set;

final class h implements zzcb, ConnectionProgressReportCallbacks {
    final /* synthetic */ e a;
    private final Client b;
    private final bz<?> c;
    private IAccountAccessor d = null;
    private Set<Scope> e = null;
    private boolean f = false;

    public h(e eVar, Client client, bz<?> bzVar) {
        this.a = eVar;
        this.b = client;
        this.c = bzVar;
    }

    @WorkerThread
    private final void a() {
        if (this.f && this.d != null) {
            this.b.getRemoteService(this.d, this.e);
        }
    }

    public final void onReportServiceBinding(@NonNull ConnectionResult connectionResult) {
        this.a.q.post(new bd(this, connectionResult));
    }

    @WorkerThread
    public final void zza(IAccountAccessor iAccountAccessor, Set<Scope> set) {
        if (iAccountAccessor == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            zzg(new ConnectionResult(4));
            return;
        }
        this.d = iAccountAccessor;
        this.e = set;
        a();
    }

    @WorkerThread
    public final void zzg(ConnectionResult connectionResult) {
        ((f) this.a.m.get(this.c)).a(connectionResult);
    }
}
