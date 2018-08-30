package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.util.a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.internal.aw;
import com.google.android.gms.common.util.b;
import com.google.android.gms.signin.SignInClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class f<O extends ApiOptions> implements ConnectionCallbacks, OnConnectionFailedListener, zzq {
    final /* synthetic */ e a;
    private final Queue<aq> b = new LinkedList();
    private final Client c;
    private final AnyClient d;
    private final bz<O> e;
    private final t f;
    private final Set<cc> g = new HashSet();
    private final Map<m<?>, bi> h = new HashMap();
    private final int i;
    private final bl j;
    private boolean k;
    private final List<g> l = new ArrayList();
    private ConnectionResult m = null;

    @WorkerThread
    public f(e eVar, h<O> hVar) {
        this.a = eVar;
        this.c = hVar.a(eVar.q.getLooper(), this);
        if (this.c instanceof aw) {
            this.d = ((aw) this.c).r();
        } else {
            this.d = this.c;
        }
        this.e = hVar.b();
        this.f = new t();
        this.i = hVar.c();
        if (this.c.requiresSignIn()) {
            this.j = hVar.a(eVar.h, eVar.q);
        } else {
            this.j = null;
        }
    }

    @WorkerThread
    private final void a(g gVar) {
        if (!this.l.contains(gVar) || this.k) {
            return;
        }
        if (this.c.isConnected()) {
            p();
        } else {
            i();
        }
    }

    @WorkerThread
    private final boolean a(boolean z) {
        ar.a(this.a.q);
        if (!this.c.isConnected() || this.h.size() != 0) {
            return false;
        }
        if (!this.f.a()) {
            this.c.disconnect();
            return true;
        } else if (!z) {
            return false;
        } else {
            r();
            return false;
        }
    }

    @WorkerThread
    private final void b(g gVar) {
        if (this.l.remove(gVar)) {
            this.a.q.removeMessages(15, gVar);
            this.a.q.removeMessages(16, gVar);
            Feature b = gVar.b;
            ArrayList arrayList = new ArrayList(this.b.size());
            for (aq aqVar : this.b) {
                if (aqVar instanceof bx) {
                    Feature[] a = ((bx) aqVar).a();
                    if (a != null && b.b(a, b)) {
                        arrayList.add(aqVar);
                    }
                }
            }
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                aq aqVar2 = (aq) obj;
                this.b.remove(aqVar2);
                aqVar2.a(new UnsupportedApiCallException(b));
            }
        }
    }

    @WorkerThread
    private final boolean b(@NonNull ConnectionResult connectionResult) {
        boolean z;
        synchronized (e.f) {
            if (this.a.n == null || !this.a.o.contains(this.e)) {
                z = false;
            } else {
                this.a.n.b(connectionResult, this.i);
                z = true;
            }
        }
        return z;
    }

    @WorkerThread
    private final boolean b(aq aqVar) {
        if (aqVar instanceof bx) {
            bx bxVar = (bx) aqVar;
            Feature[] a = bxVar.a();
            if (a == null || a.length == 0) {
                c(aqVar);
                return true;
            }
            Feature[] availableFeatures = this.c.getAvailableFeatures();
            if (availableFeatures == null) {
                availableFeatures = new Feature[0];
            }
            Map aVar = new a(availableFeatures.length);
            for (Feature feature : availableFeatures) {
                aVar.put(feature.a(), Long.valueOf(feature.b()));
            }
            for (Feature feature2 : a) {
                if (!aVar.containsKey(feature2.a()) || ((Long) aVar.get(feature2.a())).longValue() < feature2.b()) {
                    if (bxVar.b()) {
                        g gVar = new g(this.e, feature2, null);
                        int indexOf = this.l.indexOf(gVar);
                        if (indexOf >= 0) {
                            gVar = (g) this.l.get(indexOf);
                            this.a.q.removeMessages(15, gVar);
                            this.a.q.sendMessageDelayed(Message.obtain(this.a.q, 15, gVar), this.a.c);
                        } else {
                            this.l.add(gVar);
                            this.a.q.sendMessageDelayed(Message.obtain(this.a.q, 15, gVar), this.a.c);
                            this.a.q.sendMessageDelayed(Message.obtain(this.a.q, 16, gVar), this.a.d);
                            ConnectionResult connectionResult = new ConnectionResult(2, null);
                            if (!b(connectionResult)) {
                                this.a.a(connectionResult, this.i);
                            }
                        }
                    } else {
                        bxVar.a(new UnsupportedApiCallException(feature2));
                    }
                    return false;
                }
                this.l.remove(new g(this.e, feature2, null));
            }
            c(aqVar);
            return true;
        }
        c(aqVar);
        return true;
    }

    @WorkerThread
    private final void c(ConnectionResult connectionResult) {
        for (cc ccVar : this.g) {
            String str = null;
            if (ap.a(connectionResult, ConnectionResult.a)) {
                str = this.c.getEndpointPackageName();
            }
            ccVar.a(this.e, connectionResult, str);
        }
        this.g.clear();
    }

    @WorkerThread
    private final void c(aq aqVar) {
        aqVar.a(this.f, k());
        try {
            aqVar.a(this);
        } catch (DeadObjectException e) {
            onConnectionSuspended(1);
            this.c.disconnect();
        }
    }

    @WorkerThread
    private final void n() {
        d();
        c(ConnectionResult.a);
        q();
        for (bi biVar : this.h.values()) {
            try {
                biVar.a.a(this.d, new com.google.android.gms.tasks.b());
            } catch (DeadObjectException e) {
                onConnectionSuspended(1);
                this.c.disconnect();
            } catch (RemoteException e2) {
            }
        }
        p();
        r();
    }

    @WorkerThread
    private final void o() {
        d();
        this.k = true;
        this.f.c();
        this.a.q.sendMessageDelayed(Message.obtain(this.a.q, 9, this.e), this.a.c);
        this.a.q.sendMessageDelayed(Message.obtain(this.a.q, 11, this.e), this.a.d);
        this.a.j.a();
    }

    @WorkerThread
    private final void p() {
        ArrayList arrayList = new ArrayList(this.b);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            aq aqVar = (aq) obj;
            if (!this.c.isConnected()) {
                return;
            }
            if (b(aqVar)) {
                this.b.remove(aqVar);
            }
        }
    }

    @WorkerThread
    private final void q() {
        if (this.k) {
            this.a.q.removeMessages(11, this.e);
            this.a.q.removeMessages(9, this.e);
            this.k = false;
        }
    }

    private final void r() {
        this.a.q.removeMessages(12, this.e);
        this.a.q.sendMessageDelayed(this.a.q.obtainMessage(12, this.e), this.a.e);
    }

    @WorkerThread
    public final void a() {
        ar.a(this.a.q);
        a(e.a);
        this.f.b();
        for (m byVar : (m[]) this.h.keySet().toArray(new m[this.h.size()])) {
            a(new by(byVar, new com.google.android.gms.tasks.b()));
        }
        c(new ConnectionResult(4));
        if (this.c.isConnected()) {
            this.c.onUserSignOut(new bb(this));
        }
    }

    @WorkerThread
    public final void a(@NonNull ConnectionResult connectionResult) {
        ar.a(this.a.q);
        this.c.disconnect();
        onConnectionFailed(connectionResult);
    }

    @WorkerThread
    public final void a(Status status) {
        ar.a(this.a.q);
        for (aq a : this.b) {
            a.a(status);
        }
        this.b.clear();
    }

    @WorkerThread
    public final void a(aq aqVar) {
        ar.a(this.a.q);
        if (!this.c.isConnected()) {
            this.b.add(aqVar);
            if (this.m == null || !this.m.a()) {
                i();
            } else {
                onConnectionFailed(this.m);
            }
        } else if (b(aqVar)) {
            r();
        } else {
            this.b.add(aqVar);
        }
    }

    @WorkerThread
    public final void a(cc ccVar) {
        ar.a(this.a.q);
        this.g.add(ccVar);
    }

    public final Client b() {
        return this.c;
    }

    public final Map<m<?>, bi> c() {
        return this.h;
    }

    @WorkerThread
    public final void d() {
        ar.a(this.a.q);
        this.m = null;
    }

    @WorkerThread
    public final ConnectionResult e() {
        ar.a(this.a.q);
        return this.m;
    }

    @WorkerThread
    public final void f() {
        ar.a(this.a.q);
        if (this.k) {
            i();
        }
    }

    @WorkerThread
    public final void g() {
        ar.a(this.a.q);
        if (this.k) {
            q();
            a(this.a.i.a(this.a.h) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
            this.c.disconnect();
        }
    }

    @WorkerThread
    public final boolean h() {
        return a(true);
    }

    @WorkerThread
    public final void i() {
        ar.a(this.a.q);
        if (!this.c.isConnected() && !this.c.isConnecting()) {
            int a = this.a.j.a(this.a.h, this.c);
            if (a != 0) {
                onConnectionFailed(new ConnectionResult(a, null));
                return;
            }
            zzcb hVar = new h(this.a, this.c, this.e);
            if (this.c.requiresSignIn()) {
                this.j.a(hVar);
            }
            this.c.connect(hVar);
        }
    }

    final boolean j() {
        return this.c.isConnected();
    }

    public final boolean k() {
        return this.c.requiresSignIn();
    }

    public final int l() {
        return this.i;
    }

    final SignInClient m() {
        return this.j == null ? null : this.j.a();
    }

    public final void onConnected(@Nullable Bundle bundle) {
        if (Looper.myLooper() == this.a.q.getLooper()) {
            n();
        } else {
            this.a.q.post(new ay(this));
        }
    }

    @WorkerThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        ar.a(this.a.q);
        if (this.j != null) {
            this.j.b();
        }
        d();
        this.a.j.a();
        c(connectionResult);
        if (connectionResult.c() == 4) {
            a(e.b);
        } else if (this.b.isEmpty()) {
            this.m = connectionResult;
        } else if (!b(connectionResult) && !this.a.a(connectionResult, this.i)) {
            if (connectionResult.c() == 18) {
                this.k = true;
            }
            if (this.k) {
                this.a.q.sendMessageDelayed(Message.obtain(this.a.q, 9, this.e), this.a.c);
                return;
            }
            String a = this.e.a();
            a(new Status(17, new StringBuilder(String.valueOf(a).length() + 38).append("API: ").append(a).append(" is not available on this device.").toString()));
        }
    }

    public final void onConnectionSuspended(int i) {
        if (Looper.myLooper() == this.a.q.getLooper()) {
            o();
        } else {
            this.a.q.post(new az(this));
        }
    }

    public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
        if (Looper.myLooper() == this.a.q.getLooper()) {
            onConnectionFailed(connectionResult);
        } else {
            this.a.q.post(new ba(this, connectionResult));
        }
    }
}
