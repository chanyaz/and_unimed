package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.GmsClientEventManager;
import com.google.android.gms.common.internal.GmsClientEventManager.GmsClientEventState;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class ao extends GoogleApiClient implements zzbq {
    @VisibleForTesting
    final Queue<b<?, ?>> a = new LinkedList();
    final Map<b<?>, Client> b;
    Set<Scope> c = new HashSet();
    Set<bq> d = null;
    final bt e;
    private final Lock f;
    private boolean g;
    private final GmsClientEventManager h;
    private zzbp i = null;
    private final int j;
    private final Context k;
    private final Looper l;
    private volatile boolean m;
    private long n = 120000;
    private long o = 5000;
    private final ar p;
    private final e q;
    @VisibleForTesting
    private GooglePlayServicesUpdatedReceiver r;
    private final n s;
    private final Map<Api<?>, Boolean> t;
    private final a<? extends SignInClient, c> u;
    private final o v = new o();
    private final ArrayList<ci> w;
    private Integer x = null;
    private final GmsClientEventState y = new ap(this);

    public ao(Context context, Lock lock, Looper looper, n nVar, e eVar, a<? extends SignInClient, c> aVar, Map<Api<?>, Boolean> map, List<ConnectionCallbacks> list, List<OnConnectionFailedListener> list2, Map<b<?>, Client> map2, int i, int i2, ArrayList<ci> arrayList, boolean z) {
        this.k = context;
        this.f = lock;
        this.g = false;
        this.h = new GmsClientEventManager(looper, this.y);
        this.l = looper;
        this.p = new ar(this, looper);
        this.q = eVar;
        this.j = i;
        if (this.j >= 0) {
            this.x = Integer.valueOf(i2);
        }
        this.t = map;
        this.b = map2;
        this.w = arrayList;
        this.e = new bt(this.b);
        for (ConnectionCallbacks a : list) {
            this.h.a(a);
        }
        for (OnConnectionFailedListener a2 : list2) {
            this.h.a(a2);
        }
        this.s = nVar;
        this.u = aVar;
    }

    public static int a(Iterable<Client> iterable, boolean z) {
        int i;
        int i2 = 0;
        Iterator it = iterable.iterator();
        int i3 = 0;
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            Client client = (Client) it.next();
            if (client.requiresSignIn()) {
                i = 1;
            }
            i2 = client.providesSignIn() ? 1 : i3;
        }
        return i != 0 ? (i3 == 0 || !z) ? 1 : 2 : 3;
    }

    private final void b(int i) {
        if (this.x == null) {
            this.x = Integer.valueOf(i);
        } else if (this.x.intValue() != i) {
            String c = c(i);
            String c2 = c(this.x.intValue());
            throw new IllegalStateException(new StringBuilder((String.valueOf(c).length() + 51) + String.valueOf(c2).length()).append("Cannot use sign-in mode: ").append(c).append(". Mode was already set to ").append(c2).toString());
        }
        if (this.i == null) {
            boolean z = false;
            boolean z2 = false;
            for (Client client : this.b.values()) {
                if (client.requiresSignIn()) {
                    z2 = true;
                }
                z = client.providesSignIn() ? true : z;
            }
            switch (this.x.intValue()) {
                case 1:
                    if (!z2) {
                        throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                    } else if (z) {
                        throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                    }
                    break;
                case 2:
                    if (z2) {
                        if (this.g) {
                            this.i = new co(this.k, this.f, this.l, this.q, this.b, this.s, this.t, this.u, this.w, this, true);
                            return;
                        } else {
                            this.i = cj.a(this.k, this, this.f, this.l, this.q, this.b, this.s, this.t, this.u, this.w);
                            return;
                        }
                    }
                    break;
            }
            if (!this.g || z) {
                this.i = new at(this.k, this, this.f, this.l, this.q, this.b, this.s, this.t, this.u, this.w, this);
            } else {
                this.i = new co(this.k, this.f, this.l, this.q, this.b, this.s, this.t, this.u, this.w, this, false);
            }
        }
    }

    private static String c(int i) {
        switch (i) {
            case 1:
                return "SIGN_IN_MODE_REQUIRED";
            case 2:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    @GuardedBy("mLock")
    private final void i() {
        this.h.b();
        this.i.connect();
    }

    private final void j() {
        this.f.lock();
        try {
            if (this.m) {
                i();
            }
            this.f.unlock();
        } catch (Throwable th) {
            this.f.unlock();
        }
    }

    private final void k() {
        this.f.lock();
        try {
            if (f()) {
                i();
            }
            this.f.unlock();
        } catch (Throwable th) {
            this.f.unlock();
        }
    }

    public final Looper a() {
        return this.l;
    }

    @NonNull
    public final <C extends Client> C a(@NonNull b<C> bVar) {
        Object obj = (Client) this.b.get(bVar);
        ar.a(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public final <A extends AnyClient, R extends Result, T extends b<R, A>> T a(@NonNull T t) {
        ar.b(t.d() != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        boolean containsKey = this.b.containsKey(t.d());
        String d = t.e() != null ? t.e().d() : "the API";
        ar.b(containsKey, new StringBuilder(String.valueOf(d).length() + 65).append("GoogleApiClient is not configured to use ").append(d).append(" required for this call.").toString());
        this.f.lock();
        try {
            if (this.i == null) {
                this.a.add(t);
            } else {
                t = this.i.enqueue(t);
                this.f.unlock();
            }
            return t;
        } finally {
            this.f.unlock();
        }
    }

    public final void a(int i) {
        boolean z = true;
        this.f.lock();
        if (!(i == 3 || i == 1 || i == 2)) {
            z = false;
        }
        try {
            ar.b(z, "Illegal sign-in mode: " + i);
            b(i);
            i();
        } finally {
            this.f.unlock();
        }
    }

    public final void a(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
        this.h.a(onConnectionFailedListener);
    }

    public final void a(bq bqVar) {
        this.f.lock();
        try {
            if (this.d == null) {
                this.d = new HashSet();
            }
            this.d.add(bqVar);
        } finally {
            this.f.unlock();
        }
    }

    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.k);
        printWriter.append(str).append("mResuming=").print(this.m);
        printWriter.append(" mWorkQueue.size()=").print(this.a.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.e.b.size());
        if (this.i != null) {
            this.i.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final <A extends AnyClient, T extends b<? extends Result, A>> T b(@NonNull T t) {
        ar.b(t.d() != null, "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.b.containsKey(t.d());
        String d = t.e() != null ? t.e().d() : "the API";
        ar.b(containsKey, new StringBuilder(String.valueOf(d).length() + 65).append("GoogleApiClient is not configured to use ").append(d).append(" required for this call.").toString());
        this.f.lock();
        try {
            if (this.i == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (this.m) {
                this.a.add(t);
                while (!this.a.isEmpty()) {
                    b bVar = (b) this.a.remove();
                    this.e.a(bVar);
                    bVar.setFailedResult(Status.c);
                }
            } else {
                t = this.i.execute(t);
                this.f.unlock();
            }
            return t;
        } finally {
            this.f.unlock();
        }
    }

    public final void b() {
        boolean z = false;
        this.f.lock();
        try {
            if (this.j >= 0) {
                if (this.x != null) {
                    z = true;
                }
                ar.a(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.x == null) {
                this.x = Integer.valueOf(a(this.b.values(), false));
            } else if (this.x.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            a(this.x.intValue());
        } finally {
            this.f.unlock();
        }
    }

    public final void b(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
        this.h.b(onConnectionFailedListener);
    }

    public final void b(bq bqVar) {
        this.f.lock();
        try {
            if (this.d == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!this.d.remove(bqVar)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!g()) {
                this.i.zzz();
            }
            this.f.unlock();
        } catch (Throwable th) {
            this.f.unlock();
        }
    }

    public final void c() {
        this.f.lock();
        try {
            this.e.a();
            if (this.i != null) {
                this.i.disconnect();
            }
            this.v.a();
            for (b bVar : this.a) {
                bVar.a(null);
                bVar.a();
            }
            this.a.clear();
            if (this.i != null) {
                f();
                this.h.a();
                this.f.unlock();
            }
        } finally {
            this.f.unlock();
        }
    }

    public final boolean d() {
        return this.i != null && this.i.isConnected();
    }

    @GuardedBy("mLock")
    final boolean f() {
        if (!this.m) {
            return false;
        }
        this.m = false;
        this.p.removeMessages(2);
        this.p.removeMessages(1);
        if (this.r != null) {
            this.r.a();
            this.r = null;
        }
        return true;
    }

    final boolean g() {
        boolean z = false;
        this.f.lock();
        try {
            if (this.d != null) {
                if (!this.d.isEmpty()) {
                    z = true;
                }
                this.f.unlock();
            }
            return z;
        } finally {
            this.f.unlock();
        }
    }

    final String h() {
        Writer stringWriter = new StringWriter();
        a("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    @GuardedBy("mLock")
    public final void zzb(int i, boolean z) {
        if (!(i != 1 || z || this.m)) {
            this.m = true;
            if (this.r == null) {
                this.r = this.q.a(this.k.getApplicationContext(), new as(this));
            }
            this.p.sendMessageDelayed(this.p.obtainMessage(1), this.n);
            this.p.sendMessageDelayed(this.p.obtainMessage(2), this.o);
        }
        this.e.b();
        this.h.a(i);
        this.h.a();
        if (i == 2) {
            i();
        }
    }

    @GuardedBy("mLock")
    public final void zzb(Bundle bundle) {
        while (!this.a.isEmpty()) {
            b((b) this.a.remove());
        }
        this.h.a(bundle);
    }

    @GuardedBy("mLock")
    public final void zzc(ConnectionResult connectionResult) {
        if (!this.q.c(this.k, connectionResult.c())) {
            f();
        }
        if (!this.m) {
            this.h.a(connectionResult);
            this.h.a();
        }
    }
}
