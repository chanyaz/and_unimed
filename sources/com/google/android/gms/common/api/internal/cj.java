package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.g;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

final class cj implements zzbp {
    private final Context a;
    private final ao b;
    private final Looper c;
    private final at d;
    private final at e;
    private final Map<b<?>, at> f;
    private final Set<SignInConnectionListener> g = Collections.newSetFromMap(new WeakHashMap());
    private final Client h;
    private Bundle i;
    private ConnectionResult j = null;
    private ConnectionResult k = null;
    private boolean l = false;
    private final Lock m;
    @GuardedBy("mLock")
    private int n = 0;

    private cj(Context context, ao aoVar, Lock lock, Looper looper, g gVar, Map<b<?>, Client> map, Map<b<?>, Client> map2, n nVar, a<? extends SignInClient, c> aVar, Client client, ArrayList<ci> arrayList, ArrayList<ci> arrayList2, Map<Api<?>, Boolean> map3, Map<Api<?>, Boolean> map4) {
        this.a = context;
        this.b = aoVar;
        this.m = lock;
        this.c = looper;
        this.h = client;
        this.d = new at(context, this.b, lock, looper, gVar, map2, null, map4, null, arrayList2, new cl(this, null));
        this.e = new at(context, this.b, lock, looper, gVar, map, nVar, map3, aVar, arrayList, new cm(this, null));
        Map aVar2 = new android.support.v4.util.a();
        for (b put : map2.keySet()) {
            aVar2.put(put, this.d);
        }
        for (b put2 : map.keySet()) {
            aVar2.put(put2, this.e);
        }
        this.f = Collections.unmodifiableMap(aVar2);
    }

    public static cj a(Context context, ao aoVar, Lock lock, Looper looper, g gVar, Map<b<?>, Client> map, n nVar, Map<Api<?>, Boolean> map2, a<? extends SignInClient, c> aVar, ArrayList<ci> arrayList) {
        Client client = null;
        Map aVar2 = new android.support.v4.util.a();
        Map aVar3 = new android.support.v4.util.a();
        for (Entry entry : map.entrySet()) {
            Client client2 = (Client) entry.getValue();
            if (client2.providesSignIn()) {
                client = client2;
            }
            if (client2.requiresSignIn()) {
                aVar2.put((b) entry.getKey(), client2);
            } else {
                aVar3.put((b) entry.getKey(), client2);
            }
        }
        ar.a(!aVar2.isEmpty(), (Object) "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        Map aVar4 = new android.support.v4.util.a();
        Map aVar5 = new android.support.v4.util.a();
        for (Api api : map2.keySet()) {
            b c = api.c();
            if (aVar2.containsKey(c)) {
                aVar4.put(api, (Boolean) map2.get(api));
            } else if (aVar3.containsKey(c)) {
                aVar5.put(api, (Boolean) map2.get(api));
            } else {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList;
        int size = arrayList4.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList4.get(i);
            i++;
            ci ciVar = (ci) obj;
            if (aVar4.containsKey(ciVar.a)) {
                arrayList2.add(ciVar);
            } else if (aVar5.containsKey(ciVar.a)) {
                arrayList3.add(ciVar);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            }
        }
        return new cj(context, aoVar, lock, looper, gVar, aVar2, aVar3, nVar, aVar, client, arrayList2, arrayList3, aVar4, aVar5);
    }

    @GuardedBy("mLock")
    private final void a() {
        if (b(this.j)) {
            if (b(this.k) || c()) {
                switch (this.n) {
                    case 1:
                        break;
                    case 2:
                        this.b.zzb(this.i);
                        break;
                    default:
                        Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                        break;
                }
                b();
                this.n = 0;
            } else if (this.k == null) {
            } else {
                if (this.n == 1) {
                    b();
                    return;
                }
                a(this.k);
                this.d.disconnect();
            }
        } else if (this.j != null && b(this.k)) {
            this.e.disconnect();
            a(this.j);
        } else if (this.j != null && this.k != null) {
            ConnectionResult connectionResult = this.j;
            if (this.e.c < this.d.c) {
                connectionResult = this.k;
            }
            a(connectionResult);
        }
    }

    @GuardedBy("mLock")
    private final void a(int i, boolean z) {
        this.b.zzb(i, z);
        this.k = null;
        this.j = null;
    }

    private final void a(Bundle bundle) {
        if (this.i == null) {
            this.i = bundle;
        } else if (bundle != null) {
            this.i.putAll(bundle);
        }
    }

    @GuardedBy("mLock")
    private final void a(ConnectionResult connectionResult) {
        switch (this.n) {
            case 1:
                break;
            case 2:
                this.b.zzc(connectionResult);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        b();
        this.n = 0;
    }

    private final boolean a(b<? extends Result, ? extends AnyClient> bVar) {
        b d = bVar.d();
        ar.b(this.f.containsKey(d), "GoogleApiClient is not configured to use the API required for this call.");
        return ((at) this.f.get(d)).equals(this.e);
    }

    @GuardedBy("mLock")
    private final void b() {
        for (SignInConnectionListener onComplete : this.g) {
            onComplete.onComplete();
        }
        this.g.clear();
    }

    private static boolean b(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.b();
    }

    @GuardedBy("mLock")
    private final boolean c() {
        return this.k != null && this.k.c() == 4;
    }

    @Nullable
    private final PendingIntent d() {
        return this.h == null ? null : PendingIntent.getActivity(this.a, System.identityHashCode(this.b), this.h.getSignInIntent(), 134217728);
    }

    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException();
    }

    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @GuardedBy("mLock")
    public final void connect() {
        this.n = 2;
        this.l = false;
        this.k = null;
        this.j = null;
        this.d.connect();
        this.e.connect();
    }

    @GuardedBy("mLock")
    public final void disconnect() {
        this.k = null;
        this.j = null;
        this.n = 0;
        this.d.disconnect();
        this.e.disconnect();
        b();
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        this.e.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(":");
        this.d.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    @GuardedBy("mLock")
    public final <A extends AnyClient, R extends Result, T extends b<R, A>> T enqueue(@NonNull T t) {
        if (!a((b) t)) {
            return this.d.enqueue(t);
        }
        if (!c()) {
            return this.e.enqueue(t);
        }
        t.setFailedResult(new Status(4, null, d()));
        return t;
    }

    @GuardedBy("mLock")
    public final <A extends AnyClient, T extends b<? extends Result, A>> T execute(@NonNull T t) {
        if (!a((b) t)) {
            return this.d.execute(t);
        }
        if (!c()) {
            return this.e.execute(t);
        }
        t.setFailedResult(new Status(4, null, d()));
        return t;
    }

    @Nullable
    @GuardedBy("mLock")
    public final ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        return ((at) this.f.get(api.c())).equals(this.e) ? c() ? new ConnectionResult(4, d()) : this.e.getConnectionResult(api) : this.d.getConnectionResult(api);
    }

    public final boolean isConnected() {
        boolean z = true;
        this.m.lock();
        try {
            if (!(this.d.isConnected() && (this.e.isConnected() || c() || this.n == 1))) {
                z = false;
            }
            this.m.unlock();
            return z;
        } catch (Throwable th) {
            this.m.unlock();
        }
    }

    public final boolean isConnecting() {
        this.m.lock();
        try {
            boolean z = this.n == 2;
            this.m.unlock();
            return z;
        } catch (Throwable th) {
            this.m.unlock();
        }
    }

    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        this.m.lock();
        try {
            if ((isConnecting() || isConnected()) && !this.e.isConnected()) {
                this.g.add(signInConnectionListener);
                if (this.n == 0) {
                    this.n = 1;
                }
                this.k = null;
                this.e.connect();
                return true;
            }
            this.m.unlock();
            return false;
        } finally {
            this.m.unlock();
        }
    }

    public final void maybeSignOut() {
        this.m.lock();
        try {
            boolean isConnecting = isConnecting();
            this.e.disconnect();
            this.k = new ConnectionResult(4);
            if (isConnecting) {
                new Handler(this.c).post(new ck(this));
            } else {
                b();
            }
            this.m.unlock();
        } catch (Throwable th) {
            this.m.unlock();
        }
    }

    @GuardedBy("mLock")
    public final void zzz() {
        this.d.zzz();
        this.e.zzz();
    }
}
