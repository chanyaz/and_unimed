package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.util.a;
import android.view.View;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NotRequiredOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.internal.ao;
import com.google.android.gms.common.api.internal.ca;
import com.google.android.gms.common.api.internal.ci;
import com.google.android.gms.common.api.internal.l;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

@KeepForSdk
public final class i {
    private Account a;
    private final Set<Scope> b = new HashSet();
    private final Set<Scope> c = new HashSet();
    private int d;
    private View e;
    private String f;
    private String g;
    private final Map<Api<?>, p> h = new a();
    private final Context i;
    private final Map<Api<?>, ApiOptions> j = new a();
    private l k;
    private int l = -1;
    private OnConnectionFailedListener m;
    private Looper n;
    private e o = e.a();
    private a<? extends SignInClient, c> p = com.google.android.gms.signin.a.c;
    private final ArrayList<ConnectionCallbacks> q = new ArrayList();
    private final ArrayList<OnConnectionFailedListener> r = new ArrayList();
    private boolean s = false;

    @KeepForSdk
    public i(@NonNull Context context) {
        this.i = context;
        this.n = context.getMainLooper();
        this.f = context.getPackageName();
        this.g = context.getClass().getName();
    }

    public final i a(@NonNull Api<? extends NotRequiredOptions> api) {
        ar.a((Object) api, (Object) "Api must not be null");
        this.j.put(api, null);
        Collection a = api.a().a(null);
        this.c.addAll(a);
        this.b.addAll(a);
        return this;
    }

    public final i a(@NonNull ConnectionCallbacks connectionCallbacks) {
        ar.a((Object) connectionCallbacks, (Object) "Listener must not be null");
        this.q.add(connectionCallbacks);
        return this;
    }

    public final i a(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
        ar.a((Object) onConnectionFailedListener, (Object) "Listener must not be null");
        this.r.add(onConnectionFailedListener);
        return this;
    }

    @KeepForSdk
    @VisibleForTesting
    public final n a() {
        c cVar = c.a;
        if (this.j.containsKey(com.google.android.gms.signin.a.f)) {
            cVar = (c) this.j.get(com.google.android.gms.signin.a.f);
        }
        return new n(this.a, this.b, this.h, this.d, this.e, this.f, this.g, cVar);
    }

    public final GoogleApiClient b() {
        String d;
        ar.b(!this.j.isEmpty(), "must call addApi() to add at least one API");
        n a = a();
        Api api = null;
        Map e = a.e();
        Map aVar = new a();
        Map aVar2 = new a();
        ArrayList arrayList = new ArrayList();
        Object obj = null;
        for (Api api2 : this.j.keySet()) {
            Api api22;
            Object obj2 = this.j.get(api22);
            boolean z = e.get(api22) != null;
            aVar.put(api22, Boolean.valueOf(z));
            ConnectionCallbacks ciVar = new ci(api22, z);
            arrayList.add(ciVar);
            c b = api22.b();
            Client a2 = b.a(this.i, this.n, a, obj2, ciVar, ciVar);
            aVar2.put(api22.c(), a2);
            Object obj3 = b.a() == 1 ? obj2 != null ? 1 : null : obj;
            if (!a2.providesSignIn()) {
                api22 = api;
            } else if (api != null) {
                d = api22.d();
                String d2 = api.d();
                throw new IllegalStateException(new StringBuilder((String.valueOf(d).length() + 21) + String.valueOf(d2).length()).append(d).append(" cannot be used with ").append(d2).toString());
            }
            obj = obj3;
            api = api22;
        }
        if (api != null) {
            if (obj != null) {
                d = api.d();
                throw new IllegalStateException(new StringBuilder(String.valueOf(d).length() + 82).append("With using ").append(d).append(", GamesOptions can only be specified within GoogleSignInOptions.Builder").toString());
            }
            ar.a(this.a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api.d());
            ar.a(this.b.equals(this.c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api.d());
        }
        GoogleApiClient aoVar = new ao(this.i, new ReentrantLock(), this.n, a, this.o, this.p, aVar, this.q, this.r, aVar2, this.l, ao.a(aVar2.values(), true), arrayList, false);
        synchronized (GoogleApiClient.a) {
            GoogleApiClient.a.add(aoVar);
        }
        if (this.l >= 0) {
            ca.b(this.k).a(this.l, aoVar, this.m);
        }
        return aoVar;
    }
}
