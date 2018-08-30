package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.g;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.c;
import com.google.android.gms.signin.internal.SignInResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class ac implements zzbc {
    private final at a;
    private final Lock b;
    private final Context c;
    private final g d;
    private ConnectionResult e;
    private int f;
    private int g = 0;
    private int h;
    private final Bundle i = new Bundle();
    private final Set<b> j = new HashSet();
    private SignInClient k;
    private boolean l;
    private boolean m;
    private boolean n;
    private IAccountAccessor o;
    private boolean p;
    private boolean q;
    private final n r;
    private final Map<Api<?>, Boolean> s;
    private final a<? extends SignInClient, c> t;
    private ArrayList<Future<?>> u = new ArrayList();

    public ac(at atVar, n nVar, Map<Api<?>, Boolean> map, g gVar, a<? extends SignInClient, c> aVar, Lock lock, Context context) {
        this.a = atVar;
        this.r = nVar;
        this.s = map;
        this.d = gVar;
        this.t = aVar;
        this.b = lock;
        this.c = context;
    }

    /* JADX WARNING: Missing block: B:5:0x0013, code:
            if (r2 != null) goto L_0x0015;
     */
    /* JADX WARNING: Missing block: B:9:0x001b, code:
            if (r3 >= r5.f) goto L_0x003f;
     */
    /* JADX WARNING: Missing block: B:18:0x003f, code:
            r0 = null;
     */
    @javax.annotation.concurrent.GuardedBy("mLock")
    private final void a(com.google.android.gms.common.ConnectionResult r6, com.google.android.gms.common.api.Api<?> r7, boolean r8) {
        /*
        r5 = this;
        r1 = 0;
        r0 = 1;
        r2 = r7.a();
        r3 = r2.a();
        if (r8 == 0) goto L_0x0015;
    L_0x000c:
        r2 = r6.a();
        if (r2 == 0) goto L_0x002f;
    L_0x0012:
        r2 = r0;
    L_0x0013:
        if (r2 == 0) goto L_0x003f;
    L_0x0015:
        r2 = r5.e;
        if (r2 == 0) goto L_0x001d;
    L_0x0019:
        r2 = r5.f;
        if (r3 >= r2) goto L_0x003f;
    L_0x001d:
        if (r0 == 0) goto L_0x0023;
    L_0x001f:
        r5.e = r6;
        r5.f = r3;
    L_0x0023:
        r0 = r5.a;
        r0 = r0.b;
        r1 = r7.c();
        r0.put(r1, r6);
        return;
    L_0x002f:
        r2 = r5.d;
        r4 = r6.c();
        r2 = r2.b(r4);
        if (r2 == 0) goto L_0x003d;
    L_0x003b:
        r2 = r0;
        goto L_0x0013;
    L_0x003d:
        r2 = r1;
        goto L_0x0013;
    L_0x003f:
        r0 = r1;
        goto L_0x001d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.ac.a(com.google.android.gms.common.ConnectionResult, com.google.android.gms.common.api.Api, boolean):void");
    }

    @GuardedBy("mLock")
    private final void a(SignInResponse signInResponse) {
        if (a(0)) {
            ConnectionResult a = signInResponse.a();
            if (a.b()) {
                ResolveAccountResponse b = signInResponse.b();
                ConnectionResult b2 = b.b();
                if (b2.b()) {
                    this.n = true;
                    this.o = b.a();
                    this.p = b.c();
                    this.q = b.d();
                    b();
                    return;
                }
                String valueOf = String.valueOf(b2);
                Log.wtf("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(valueOf).toString(), new Exception());
                b(b2);
            } else if (a(a)) {
                d();
                b();
            } else {
                b(a);
            }
        }
    }

    private final void a(boolean z) {
        if (this.k != null) {
            if (this.k.isConnected() && z) {
                this.k.clearAccountFromSessionStore();
            }
            this.k.disconnect();
            this.o = null;
        }
    }

    @GuardedBy("mLock")
    private final boolean a() {
        this.h--;
        if (this.h > 0) {
            return false;
        }
        if (this.h < 0) {
            Log.w("GoogleApiClientConnecting", this.a.d.h());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            b(new ConnectionResult(8, null));
            return false;
        } else if (this.e == null) {
            return true;
        } else {
            this.a.c = this.f;
            b(this.e);
            return false;
        }
    }

    @GuardedBy("mLock")
    private final boolean a(int i) {
        if (this.g == i) {
            return true;
        }
        Log.w("GoogleApiClientConnecting", this.a.d.h());
        String valueOf = String.valueOf(this);
        Log.w("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 23).append("Unexpected callback in ").append(valueOf).toString());
        Log.w("GoogleApiClientConnecting", "mRemainingConnections=" + this.h);
        valueOf = b(this.g);
        String b = b(i);
        Log.wtf("GoogleApiClientConnecting", new StringBuilder((String.valueOf(valueOf).length() + 70) + String.valueOf(b).length()).append("GoogleApiClient connecting is in step ").append(valueOf).append(" but received callback for step ").append(b).toString(), new Exception());
        b(new ConnectionResult(8, null));
        return false;
    }

    @GuardedBy("mLock")
    private final boolean a(ConnectionResult connectionResult) {
        return this.l && !connectionResult.a();
    }

    private static String b(int i) {
        switch (i) {
            case 0:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case 1:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    @GuardedBy("mLock")
    private final void b() {
        if (this.h == 0) {
            if (!this.m || this.n) {
                ArrayList arrayList = new ArrayList();
                this.g = 1;
                this.h = this.a.a.size();
                for (b bVar : this.a.a.keySet()) {
                    if (!this.a.b.containsKey(bVar)) {
                        arrayList.add((Client) this.a.a.get(bVar));
                    } else if (a()) {
                        c();
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.u.add(aw.a().submit(new ai(this, arrayList)));
                }
            }
        }
    }

    @GuardedBy("mLock")
    private final void b(ConnectionResult connectionResult) {
        e();
        a(!connectionResult.a());
        this.a.a(connectionResult);
        this.a.e.zzc(connectionResult);
    }

    @GuardedBy("mLock")
    private final void c() {
        this.a.b();
        aw.a().execute(new ad(this));
        if (this.k != null) {
            if (this.p) {
                this.k.saveDefaultAccount(this.o, this.q);
            }
            a(false);
        }
        for (b bVar : this.a.b.keySet()) {
            ((Client) this.a.a.get(bVar)).disconnect();
        }
        this.a.e.zzb(this.i.isEmpty() ? null : this.i);
    }

    @GuardedBy("mLock")
    private final void d() {
        this.m = false;
        this.a.d.c = Collections.emptySet();
        for (b bVar : this.j) {
            if (!this.a.b.containsKey(bVar)) {
                this.a.b.put(bVar, new ConnectionResult(17, null));
            }
        }
    }

    private final void e() {
        ArrayList arrayList = this.u;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((Future) obj).cancel(true);
        }
        this.u.clear();
    }

    private final Set<Scope> f() {
        if (this.r == null) {
            return Collections.emptySet();
        }
        Set<Scope> hashSet = new HashSet(this.r.c());
        Map e = this.r.e();
        for (Api api : e.keySet()) {
            if (!this.a.b.containsKey(api.c())) {
                hashSet.addAll(((p) e.get(api)).a);
            }
        }
        return hashSet;
    }

    public final void begin() {
        this.a.b.clear();
        this.m = false;
        this.e = null;
        this.g = 0;
        this.l = true;
        this.n = false;
        this.p = false;
        Map hashMap = new HashMap();
        int i = 0;
        for (Api api : this.s.keySet()) {
            Client client = (Client) this.a.a.get(api.c());
            int i2 = (api.a().a() == 1 ? 1 : 0) | i;
            boolean booleanValue = ((Boolean) this.s.get(api)).booleanValue();
            if (client.requiresSignIn()) {
                this.m = true;
                if (booleanValue) {
                    this.j.add(api.c());
                } else {
                    this.l = false;
                }
            }
            hashMap.put(client, new ae(this, api, booleanValue));
            i = i2;
        }
        if (i != 0) {
            this.m = false;
        }
        if (this.m) {
            this.r.a(Integer.valueOf(System.identityHashCode(this.a.d)));
            ConnectionCallbacks alVar = new al(this, null);
            this.k = (SignInClient) this.t.a(this.c, this.a.d.a(), this.r, this.r.h(), alVar, alVar);
        }
        this.h = this.a.a.size();
        this.u.add(aw.a().submit(new af(this, hashMap)));
    }

    public final void connect() {
    }

    public final boolean disconnect() {
        e();
        a(true);
        this.a.a(null);
        return true;
    }

    public final <A extends AnyClient, R extends Result, T extends b<R, A>> T enqueue(T t) {
        this.a.d.a.add(t);
        return t;
    }

    public final <A extends AnyClient, T extends b<? extends Result, A>> T execute(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @GuardedBy("mLock")
    public final void onConnected(Bundle bundle) {
        if (a(1)) {
            if (bundle != null) {
                this.i.putAll(bundle);
            }
            if (a()) {
                c();
            }
        }
    }

    @GuardedBy("mLock")
    public final void onConnectionSuspended(int i) {
        b(new ConnectionResult(8, null));
    }

    @GuardedBy("mLock")
    public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
        if (a(1)) {
            a(connectionResult, api, z);
            if (a()) {
                c();
            }
        }
    }
}
