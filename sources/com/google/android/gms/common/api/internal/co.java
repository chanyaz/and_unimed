package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.g;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class co implements zzbp {
    private final Map<b<?>, cn<?>> a = new HashMap();
    private final Map<b<?>, cn<?>> b = new HashMap();
    private final Map<Api<?>, Boolean> c;
    private final e d;
    private final ao e;
    private final Lock f;
    private final Looper g;
    private final g h;
    private final Condition i;
    private final n j;
    private final boolean k;
    private final boolean l;
    private final Queue<b<?, ?>> m = new LinkedList();
    @GuardedBy("mLock")
    private boolean n;
    @GuardedBy("mLock")
    private Map<bz<?>, ConnectionResult> o;
    @GuardedBy("mLock")
    private Map<bz<?>, ConnectionResult> p;
    @GuardedBy("mLock")
    private cr q;
    @GuardedBy("mLock")
    private ConnectionResult r;

    public co(Context context, Lock lock, Looper looper, g gVar, Map<b<?>, Client> map, n nVar, Map<Api<?>, Boolean> map2, a<? extends SignInClient, c> aVar, ArrayList<ci> arrayList, ao aoVar, boolean z) {
        this.f = lock;
        this.g = looper;
        this.i = lock.newCondition();
        this.h = gVar;
        this.e = aoVar;
        this.c = map2;
        this.j = nVar;
        this.k = z;
        Map hashMap = new HashMap();
        for (Api api : map2.keySet()) {
            hashMap.put(api.c(), api);
        }
        Map hashMap2 = new HashMap();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            ci ciVar = (ci) obj;
            hashMap2.put(ciVar.a, ciVar);
        }
        Object obj2 = 1;
        Object obj3 = null;
        Object obj4 = null;
        for (Entry entry : map.entrySet()) {
            Object obj5;
            Object obj6;
            Object obj7;
            Api api2 = (Api) hashMap.get(entry.getKey());
            Client client = (Client) entry.getValue();
            if (client.requiresGooglePlayServices()) {
                obj5 = 1;
                if (((Boolean) this.c.get(api2)).booleanValue()) {
                    obj6 = obj2;
                    obj7 = obj3;
                } else {
                    obj6 = obj2;
                    obj7 = 1;
                }
            } else {
                obj5 = obj4;
                obj6 = null;
                obj7 = obj3;
            }
            cn cnVar = new cn(context, api2, looper, client, (ci) hashMap2.get(api2), nVar, aVar);
            this.a.put((b) entry.getKey(), cnVar);
            if (client.requiresSignIn()) {
                this.b.put((b) entry.getKey(), cnVar);
            }
            obj4 = obj5;
            obj2 = obj6;
            obj3 = obj7;
        }
        boolean z2 = obj4 != null && obj2 == null && obj3 == null;
        this.l = z2;
        this.d = e.a();
    }

    @Nullable
    private final ConnectionResult a(@NonNull b<?> bVar) {
        this.f.lock();
        try {
            cn cnVar = (cn) this.a.get(bVar);
            if (this.o == null || cnVar == null) {
                this.f.unlock();
                return null;
            }
            ConnectionResult connectionResult = (ConnectionResult) this.o.get(cnVar.b());
            return connectionResult;
        } finally {
            this.f.unlock();
        }
    }

    private final boolean a() {
        this.f.lock();
        try {
            if (this.n && this.k) {
                for (b a : this.b.keySet()) {
                    ConnectionResult a2 = a(a);
                    if (a2 != null) {
                        if (!a2.b()) {
                        }
                    }
                    this.f.unlock();
                    return false;
                }
                this.f.unlock();
                return true;
            }
            this.f.unlock();
            return false;
        } catch (Throwable th) {
            this.f.unlock();
        }
    }

    private final <T extends b<? extends Result, ? extends AnyClient>> boolean a(@NonNull T t) {
        b d = t.d();
        ConnectionResult a = a(d);
        if (a == null || a.c() != 4) {
            return false;
        }
        t.setFailedResult(new Status(4, null, this.d.a(((cn) this.a.get(d)).b(), System.identityHashCode(this.e))));
        return true;
    }

    private final boolean a(cn<?> cnVar, ConnectionResult connectionResult) {
        return !connectionResult.b() && !connectionResult.a() && ((Boolean) this.c.get(cnVar.a())).booleanValue() && cnVar.f().requiresGooglePlayServices() && this.h.a(connectionResult.c());
    }

    @GuardedBy("mLock")
    private final void b() {
        if (this.j == null) {
            this.e.c = Collections.emptySet();
            return;
        }
        Set hashSet = new HashSet(this.j.c());
        Map e = this.j.e();
        for (Api api : e.keySet()) {
            ConnectionResult connectionResult = getConnectionResult(api);
            if (connectionResult != null && connectionResult.b()) {
                hashSet.addAll(((p) e.get(api)).a);
            }
        }
        this.e.c = hashSet;
    }

    @GuardedBy("mLock")
    private final void c() {
        while (!this.m.isEmpty()) {
            execute((b) this.m.remove());
        }
        this.e.zzb(null);
    }

    @Nullable
    @GuardedBy("mLock")
    private final ConnectionResult d() {
        int i = 0;
        ConnectionResult connectionResult = null;
        int i2 = 0;
        ConnectionResult connectionResult2 = null;
        for (cn cnVar : this.a.values()) {
            Api a = cnVar.a();
            ConnectionResult connectionResult3 = (ConnectionResult) this.o.get(cnVar.b());
            if (!connectionResult3.b() && (!((Boolean) this.c.get(a)).booleanValue() || connectionResult3.a() || this.h.a(connectionResult3.c()))) {
                int a2;
                if (connectionResult3.c() == 4 && this.k) {
                    a2 = a.a().a();
                    if (connectionResult == null || i > a2) {
                        i = a2;
                        connectionResult = connectionResult3;
                    }
                } else {
                    ConnectionResult connectionResult4;
                    int i3;
                    a2 = a.a().a();
                    if (connectionResult2 == null || i2 > a2) {
                        int i4 = a2;
                        connectionResult4 = connectionResult3;
                        i3 = i4;
                    } else {
                        i3 = i2;
                        connectionResult4 = connectionResult2;
                    }
                    i2 = i3;
                    connectionResult2 = connectionResult4;
                }
            }
        }
        return (connectionResult2 == null || connectionResult == null || i2 <= i) ? connectionResult2 : connectionResult;
    }

    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect() {
        connect();
        while (isConnecting()) {
            try {
                this.i.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        return isConnected() ? ConnectionResult.a : this.r != null ? this.r : new ConnectionResult(13, null);
    }

    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        connect();
        long toNanos = timeUnit.toNanos(j);
        while (isConnecting()) {
            if (toNanos <= 0) {
                try {
                    disconnect();
                    return new ConnectionResult(14, null);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return new ConnectionResult(15, null);
                }
            }
            toNanos = this.i.awaitNanos(toNanos);
        }
        return isConnected() ? ConnectionResult.a : this.r != null ? this.r : new ConnectionResult(13, null);
    }

    public final void connect() {
        this.f.lock();
        try {
            if (!this.n) {
                this.n = true;
                this.o = null;
                this.p = null;
                this.q = null;
                this.r = null;
                this.d.c();
                this.d.a(this.a.values()).a(new com.google.android.gms.common.util.a.a(this.g), new cq(this, null));
                this.f.unlock();
            }
        } finally {
            this.f.unlock();
        }
    }

    public final void disconnect() {
        this.f.lock();
        try {
            this.n = false;
            this.o = null;
            this.p = null;
            if (this.q != null) {
                this.q.a();
                this.q = null;
            }
            this.r = null;
            while (!this.m.isEmpty()) {
                b bVar = (b) this.m.remove();
                bVar.a(null);
                bVar.a();
            }
            this.i.signalAll();
        } finally {
            this.f.unlock();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public final <A extends AnyClient, R extends Result, T extends b<R, A>> T enqueue(@NonNull T t) {
        if (this.k && a((b) t)) {
            return t;
        }
        if (isConnected()) {
            this.e.e.a(t);
            return ((cn) this.a.get(t.d())).a(t);
        }
        this.m.add(t);
        return t;
    }

    public final <A extends AnyClient, T extends b<? extends Result, A>> T execute(@NonNull T t) {
        b d = t.d();
        if (this.k && a((b) t)) {
            return t;
        }
        this.e.e.a(t);
        return ((cn) this.a.get(d)).b(t);
    }

    @Nullable
    public final ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        return a(api.c());
    }

    public final boolean isConnected() {
        this.f.lock();
        try {
            boolean z = this.o != null && this.r == null;
            this.f.unlock();
            return z;
        } catch (Throwable th) {
            this.f.unlock();
        }
    }

    public final boolean isConnecting() {
        this.f.lock();
        try {
            boolean z = this.o == null && this.n;
            this.f.unlock();
            return z;
        } catch (Throwable th) {
            this.f.unlock();
        }
    }

    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        this.f.lock();
        try {
            if (!this.n || a()) {
                this.f.unlock();
                return false;
            }
            this.d.c();
            this.q = new cr(this, signInConnectionListener);
            this.d.a(this.b.values()).a(new com.google.android.gms.common.util.a.a(this.g), this.q);
            return true;
        } finally {
            this.f.unlock();
        }
    }

    public final void maybeSignOut() {
        this.f.lock();
        try {
            this.d.d();
            if (this.q != null) {
                this.q.a();
                this.q = null;
            }
            if (this.p == null) {
                this.p = new android.support.v4.util.a(this.b.size());
            }
            ConnectionResult connectionResult = new ConnectionResult(4);
            for (cn b : this.b.values()) {
                this.p.put(b.b(), connectionResult);
            }
            if (this.o != null) {
                this.o.putAll(this.p);
            }
            this.f.unlock();
        } catch (Throwable th) {
            this.f.unlock();
        }
    }

    public final void zzz() {
    }
}
