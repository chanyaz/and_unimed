package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.u;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.c;

public class i extends u<ISignInService> implements SignInClient {
    private final boolean e;
    private final n f;
    private final Bundle g;
    private Integer h;

    public i(Context context, Looper looper, boolean z, n nVar, Bundle bundle, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, nVar, connectionCallbacks, onConnectionFailedListener);
        this.e = z;
        this.f = nVar;
        this.g = bundle;
        this.h = nVar.i();
    }

    public i(Context context, Looper looper, boolean z, n nVar, c cVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, z, nVar, a(nVar), connectionCallbacks, onConnectionFailedListener);
    }

    public static Bundle a(n nVar) {
        c h = nVar.h();
        Integer i = nVar.i();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", nVar.a());
        if (i != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", i.intValue());
        }
        if (h != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", h.a());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", h.b());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", h.c());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", h.d());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", h.e());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", h.f());
            if (h.g() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", h.g().longValue());
            }
            if (h.h() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", h.h().longValue());
            }
        }
        return bundle;
    }

    protected String a() {
        return "com.google.android.gms.signin.service.START";
    }

    /* renamed from: b */
    protected ISignInService a(IBinder iBinder) {
        return f.a(iBinder);
    }

    public void clearAccountFromSessionStore() {
        try {
            ((ISignInService) o()).clearAccountFromSessionStore(this.h.intValue());
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    public void connect() {
        connect(new h(this));
    }

    protected String d() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    public int getMinApkVersion() {
        return 12451000;
    }

    protected Bundle m() {
        if (!h().getPackageName().equals(this.f.f())) {
            this.g.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f.f());
        }
        return this.g;
    }

    public boolean requiresSignIn() {
        return this.e;
    }

    public void saveDefaultAccount(IAccountAccessor iAccountAccessor, boolean z) {
        try {
            ((ISignInService) o()).saveDefaultAccountToSharedPref(iAccountAccessor, this.h.intValue(), z);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    public void signIn(ISignInCallbacks iSignInCallbacks) {
        ar.a((Object) iSignInCallbacks, (Object) "Expecting a valid ISignInCallbacks");
        try {
            Account b = this.f.b();
            GoogleSignInAccount googleSignInAccount = null;
            if ("<<default account>>".equals(b.name)) {
                googleSignInAccount = com.google.android.gms.auth.api.signin.internal.c.a(h()).a();
            }
            ((ISignInService) o()).signIn(new SignInRequest(new ResolveAccountRequest(b, this.h.intValue(), googleSignInAccount)), iSignInCallbacks);
        } catch (Throwable e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                iSignInCallbacks.onSignInComplete(new SignInResponse(8));
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }
}
