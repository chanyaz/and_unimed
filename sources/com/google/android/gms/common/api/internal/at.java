package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.g;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class at implements zzbp, zzq {
    final Map<b<?>, Client> a;
    final Map<b<?>, ConnectionResult> b = new HashMap();
    int c;
    final ao d;
    final zzbq e;
    private final Lock f;
    private final Condition g;
    private final Context h;
    private final g i;
    private final av j;
    private final n k;
    private final Map<Api<?>, Boolean> l;
    private final a<? extends SignInClient, c> m;
    private volatile zzbc n;
    private ConnectionResult o = null;

    public at(Context context, ao aoVar, Lock lock, Looper looper, g gVar, Map<b<?>, Client> map, n nVar, Map<Api<?>, Boolean> map2, a<? extends SignInClient, c> aVar, ArrayList<ci> arrayList, zzbq zzbq) {
        this.h = context;
        this.f = lock;
        this.i = gVar;
        this.a = map;
        this.k = nVar;
        this.l = map2;
        this.m = aVar;
        this.d = aoVar;
        this.e = zzbq;
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            ((ci) obj).a(this);
        }
        this.j = new av(this, looper);
        this.g = lock.newCondition();
        this.n = new an(this);
    }

    final void a() {
        this.f.lock();
        try {
            this.n = new ac(this, this.k, this.l, this.i, this.m, this.f, this.h);
            this.n.begin();
            this.g.signalAll();
        } finally {
            this.f.unlock();
        }
    }

    final void a(ConnectionResult connectionResult) {
        this.f.lock();
        try {
            this.o = connectionResult;
            this.n = new an(this);
            this.n.begin();
            this.g.signalAll();
        } finally {
            this.f.unlock();
        }
    }

    final void a(au auVar) {
        this.j.sendMessage(this.j.obtainMessage(1, auVar));
    }

    final void a(RuntimeException runtimeException) {
        this.j.sendMessage(this.j.obtainMessage(2, runtimeException));
    }

    final void b() {
        this.f.lock();
        try {
            this.d.f();
            this.n = new z(this);
            this.n.begin();
            this.g.signalAll();
        } finally {
            this.f.unlock();
        }
    }

    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect() {
        connect();
        while (isConnecting()) {
            try {
                this.g.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        return isConnected() ? ConnectionResult.a : this.o != null ? this.o : new ConnectionResult(13, null);
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
            toNanos = this.g.awaitNanos(toNanos);
        }
        return isConnected() ? ConnectionResult.a : this.o != null ? this.o : new ConnectionResult(13, null);
    }

    @GuardedBy("mLock")
    public final void connect() {
        this.n.connect();
    }

    @GuardedBy("mLock")
    public final void disconnect() {
        if (this.n.disconnect()) {
            this.b.clear();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append(str).append("mState=").println(this.n);
        for (Api api : this.l.keySet()) {
            printWriter.append(str).append(api.d()).println(":");
            ((Client) this.a.get(api.c())).dump(concat, fileDescriptor, printWriter, strArr);
        }
    }

    @GuardedBy("mLock")
    public final <A extends AnyClient, R extends Result, T extends b<R, A>> T enqueue(@NonNull T t) {
        t.h();
        return this.n.enqueue(t);
    }

    @GuardedBy("mLock")
    public final <A extends AnyClient, T extends b<? extends Result, A>> T execute(@NonNull T t) {
        t.h();
        return this.n.execute(t);
    }

    @Nullable
    @GuardedBy("mLock")
    public final ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        b c = api.c();
        if (this.a.containsKey(c)) {
            if (((Client) this.a.get(c)).isConnected()) {
                return ConnectionResult.a;
            }
            if (this.b.containsKey(c)) {
                return (ConnectionResult) this.b.get(c);
            }
        }
        return null;
    }

    public final boolean isConnected() {
        return this.n instanceof z;
    }

    public final boolean isConnecting() {
        return this.n instanceof ac;
    }

    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        return false;
    }

    public final void maybeSignOut() {
    }

    public final void onConnected(@Nullable Bundle bundle) {
        this.f.lock();
        try {
            this.n.onConnected(bundle);
        } finally {
            this.f.unlock();
        }
    }

    public final void onConnectionSuspended(int i) {
        this.f.lock();
        try {
            this.n.onConnectionSuspended(i);
        } finally {
            this.f.unlock();
        }
    }

    public final void zza(@NonNull ConnectionResult connectionResult, @NonNull Api<?> api, boolean z) {
        this.f.lock();
        try {
            this.n.zza(connectionResult, api, z);
        } finally {
            this.f.unlock();
        }
    }

    @GuardedBy("mLock")
    public final void zzz() {
        if (isConnected()) {
            ((z) this.n).a();
        }
    }
}
