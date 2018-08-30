package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.c;
import com.google.android.gms.signin.internal.SignInResponse;
import com.google.android.gms.signin.internal.b;
import java.util.Set;

public final class bl extends b implements ConnectionCallbacks, OnConnectionFailedListener {
    private static a<? extends SignInClient, c> a = com.google.android.gms.signin.a.c;
    private final Context b;
    private final Handler c;
    private final a<? extends SignInClient, c> d;
    private Set<Scope> e;
    private n f;
    private SignInClient g;
    private zzcb h;

    @WorkerThread
    public bl(Context context, Handler handler, @NonNull n nVar) {
        this(context, handler, nVar, a);
    }

    @WorkerThread
    public bl(Context context, Handler handler, @NonNull n nVar, a<? extends SignInClient, c> aVar) {
        this.b = context;
        this.c = handler;
        this.f = (n) ar.a((Object) nVar, (Object) "ClientSettings must not be null");
        this.e = nVar.c();
        this.d = aVar;
    }

    @WorkerThread
    private final void a(SignInResponse signInResponse) {
        ConnectionResult a = signInResponse.a();
        if (a.b()) {
            ResolveAccountResponse b = signInResponse.b();
            ConnectionResult b2 = b.b();
            if (b2.b()) {
                this.h.zza(b.a(), this.e);
            } else {
                String valueOf = String.valueOf(b2);
                Log.wtf("SignInCoordinator", new StringBuilder(String.valueOf(valueOf).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(valueOf).toString(), new Exception());
                this.h.zzg(b2);
                this.g.disconnect();
                return;
            }
        }
        this.h.zzg(a);
        this.g.disconnect();
    }

    public final SignInClient a() {
        return this.g;
    }

    @WorkerThread
    public final void a(zzcb zzcb) {
        if (this.g != null) {
            this.g.disconnect();
        }
        this.f.a(Integer.valueOf(System.identityHashCode(this)));
        this.g = (SignInClient) this.d.a(this.b, this.c.getLooper(), this.f, this.f.h(), this, this);
        this.h = zzcb;
        if (this.e == null || this.e.isEmpty()) {
            this.c.post(new bm(this));
        } else {
            this.g.connect();
        }
    }

    public final void b() {
        if (this.g != null) {
            this.g.disconnect();
        }
    }

    @WorkerThread
    public final void onConnected(@Nullable Bundle bundle) {
        this.g.signIn(this);
    }

    @WorkerThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.h.zzg(connectionResult);
    }

    @WorkerThread
    public final void onConnectionSuspended(int i) {
        this.g.disconnect();
    }

    @BinderThread
    public final void onSignInComplete(SignInResponse signInResponse) {
        this.c.post(new bo(this, signInResponse));
    }
}
