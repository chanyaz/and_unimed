package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class GmsClientEventManager implements Callback {
    private final GmsClientEventState a;
    private final ArrayList<ConnectionCallbacks> b = new ArrayList();
    @VisibleForTesting
    private final ArrayList<ConnectionCallbacks> c = new ArrayList();
    private final ArrayList<OnConnectionFailedListener> d = new ArrayList();
    private volatile boolean e = false;
    private final AtomicInteger f = new AtomicInteger(0);
    private boolean g = false;
    private final Handler h;
    private final Object i = new Object();

    @VisibleForTesting
    public interface GmsClientEventState {
        Bundle getConnectionHint();

        boolean isConnected();
    }

    public GmsClientEventManager(Looper looper, GmsClientEventState gmsClientEventState) {
        this.a = gmsClientEventState;
        this.h = new Handler(looper, this);
    }

    public final void a() {
        this.e = false;
        this.f.incrementAndGet();
    }

    @VisibleForTesting
    public final void a(int i) {
        int i2 = 0;
        ar.a(Looper.myLooper() == this.h.getLooper(), (Object) "onUnintentionalDisconnection must only be called on the Handler thread");
        this.h.removeMessages(1);
        synchronized (this.i) {
            this.g = true;
            ArrayList arrayList = new ArrayList(this.b);
            int i3 = this.f.get();
            arrayList = arrayList;
            int size = arrayList.size();
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) obj;
                if (this.e && this.f.get() == i3) {
                    if (this.b.contains(connectionCallbacks)) {
                        connectionCallbacks.onConnectionSuspended(i);
                    }
                }
            }
            this.c.clear();
            this.g = false;
        }
    }

    @VisibleForTesting
    public final void a(Bundle bundle) {
        boolean z = true;
        int i = 0;
        ar.a(Looper.myLooper() == this.h.getLooper(), (Object) "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.i) {
            ar.a(!this.g);
            this.h.removeMessages(1);
            this.g = true;
            if (this.c.size() != 0) {
                z = false;
            }
            ar.a(z);
            ArrayList arrayList = new ArrayList(this.b);
            int i2 = this.f.get();
            arrayList = arrayList;
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) obj;
                if (this.e && this.a.isConnected() && this.f.get() == i2) {
                    if (!this.c.contains(connectionCallbacks)) {
                        connectionCallbacks.onConnected(bundle);
                    }
                }
            }
            this.c.clear();
            this.g = false;
        }
    }

    /* JADX WARNING: Missing block: B:27:?, code:
            return;
     */
    @com.google.android.gms.common.util.VisibleForTesting
    public final void a(com.google.android.gms.common.ConnectionResult r8) {
        /*
        r7 = this;
        r1 = 1;
        r2 = 0;
        r0 = android.os.Looper.myLooper();
        r3 = r7.h;
        r3 = r3.getLooper();
        if (r0 != r3) goto L_0x0047;
    L_0x000e:
        r0 = r1;
    L_0x000f:
        r3 = "onConnectionFailure must only be called on the Handler thread";
        com.google.android.gms.common.internal.ar.a(r0, r3);
        r0 = r7.h;
        r0.removeMessages(r1);
        r3 = r7.i;
        monitor-enter(r3);
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x0055 }
        r1 = r7.d;	 Catch:{ all -> 0x0055 }
        r0.<init>(r1);	 Catch:{ all -> 0x0055 }
        r1 = r7.f;	 Catch:{ all -> 0x0055 }
        r4 = r1.get();	 Catch:{ all -> 0x0055 }
        r0 = (java.util.ArrayList) r0;	 Catch:{ all -> 0x0055 }
        r5 = r0.size();	 Catch:{ all -> 0x0055 }
    L_0x002f:
        if (r2 >= r5) goto L_0x0058;
    L_0x0031:
        r1 = r0.get(r2);	 Catch:{ all -> 0x0055 }
        r2 = r2 + 1;
        r1 = (com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener) r1;	 Catch:{ all -> 0x0055 }
        r6 = r7.e;	 Catch:{ all -> 0x0055 }
        if (r6 == 0) goto L_0x0045;
    L_0x003d:
        r6 = r7.f;	 Catch:{ all -> 0x0055 }
        r6 = r6.get();	 Catch:{ all -> 0x0055 }
        if (r6 == r4) goto L_0x0049;
    L_0x0045:
        monitor-exit(r3);	 Catch:{ all -> 0x0055 }
    L_0x0046:
        return;
    L_0x0047:
        r0 = r2;
        goto L_0x000f;
    L_0x0049:
        r6 = r7.d;	 Catch:{ all -> 0x0055 }
        r6 = r6.contains(r1);	 Catch:{ all -> 0x0055 }
        if (r6 == 0) goto L_0x002f;
    L_0x0051:
        r1.onConnectionFailed(r8);	 Catch:{ all -> 0x0055 }
        goto L_0x002f;
    L_0x0055:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0055 }
        throw r0;
    L_0x0058:
        monitor-exit(r3);	 Catch:{ all -> 0x0055 }
        goto L_0x0046;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.GmsClientEventManager.a(com.google.android.gms.common.ConnectionResult):void");
    }

    public final void a(ConnectionCallbacks connectionCallbacks) {
        ar.a((Object) connectionCallbacks);
        synchronized (this.i) {
            if (this.b.contains(connectionCallbacks)) {
                String valueOf = String.valueOf(connectionCallbacks);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 62).append("registerConnectionCallbacks(): listener ").append(valueOf).append(" is already registered").toString());
            } else {
                this.b.add(connectionCallbacks);
            }
        }
        if (this.a.isConnected()) {
            this.h.sendMessage(this.h.obtainMessage(1, connectionCallbacks));
        }
    }

    public final void a(OnConnectionFailedListener onConnectionFailedListener) {
        ar.a((Object) onConnectionFailedListener);
        synchronized (this.i) {
            if (this.d.contains(onConnectionFailedListener)) {
                String valueOf = String.valueOf(onConnectionFailedListener);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 67).append("registerConnectionFailedListener(): listener ").append(valueOf).append(" is already registered").toString());
            } else {
                this.d.add(onConnectionFailedListener);
            }
        }
    }

    public final void b() {
        this.e = true;
    }

    public final void b(OnConnectionFailedListener onConnectionFailedListener) {
        ar.a((Object) onConnectionFailedListener);
        synchronized (this.i) {
            if (!this.d.remove(onConnectionFailedListener)) {
                String valueOf = String.valueOf(onConnectionFailedListener);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 57).append("unregisterConnectionFailedListener(): listener ").append(valueOf).append(" not found").toString());
            }
        }
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1) {
            ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) message.obj;
            synchronized (this.i) {
                if (this.e && this.a.isConnected() && this.b.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(this.a.getConnectionHint());
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle message: " + message.what, new Exception());
        return false;
    }
}
