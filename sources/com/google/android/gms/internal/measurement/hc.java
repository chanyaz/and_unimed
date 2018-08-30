package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.stats.b;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class hc implements ServiceConnection, BaseConnectionCallbacks, BaseOnConnectionFailedListener {
    final /* synthetic */ go a;
    private volatile boolean b;
    private volatile do c;

    protected hc(go goVar) {
        this.a = goVar;
    }

    @WorkerThread
    public final void a() {
        this.a.c();
        Context context = this.a.getContext();
        synchronized (this) {
            if (this.b) {
                this.a.zzge().y().a("Connection attempt already in progress");
            } else if (this.c != null) {
                this.a.zzge().y().a("Already awaiting connection attempt");
            } else {
                this.c = new do(context, Looper.getMainLooper(), this, this);
                this.a.zzge().y().a("Connecting to remote service");
                this.b = true;
                this.c.g();
            }
        }
    }

    @WorkerThread
    public final void a(Intent intent) {
        this.a.c();
        Context context = this.a.getContext();
        b a = b.a();
        synchronized (this) {
            if (this.b) {
                this.a.zzge().y().a("Connection attempt already in progress");
                return;
            }
            this.a.zzge().y().a("Using local app measurement service");
            this.b = true;
            a.a(context, intent, this.a.a, 129);
        }
    }

    @MainThread
    public final void onConnected(@Nullable Bundle bundle) {
        ar.b("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                zzey zzey = (zzey) this.c.o();
                this.c = null;
                this.a.zzgd().a(new hf(this, zzey));
            } catch (DeadObjectException e) {
                this.c = null;
                this.b = false;
            } catch (IllegalStateException e2) {
                this.c = null;
                this.b = false;
            }
        }
    }

    @MainThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        ar.b("MeasurementServiceConnection.onConnectionFailed");
        dp d = this.a.q.d();
        if (d != null) {
            d.u().a("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.b = false;
            this.c = null;
        }
        this.a.zzgd().a(new hh(this));
    }

    @MainThread
    public final void onConnectionSuspended(int i) {
        ar.b("MeasurementServiceConnection.onConnectionSuspended");
        this.a.zzge().x().a("Service connection suspended");
        this.a.zzgd().a(new hg(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x008e A:{SYNTHETIC, Splitter: B:37:0x008e} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008e A:{SYNTHETIC, Splitter: B:37:0x008e} */
    @android.support.annotation.MainThread
    public final void onServiceConnected(android.content.ComponentName r5, android.os.IBinder r6) {
        /*
        r4 = this;
        r1 = 0;
        r0 = "MeasurementServiceConnection.onServiceConnected";
        com.google.android.gms.common.internal.ar.b(r0);
        monitor-enter(r4);
        if (r6 != 0) goto L_0x001d;
    L_0x0009:
        r0 = 0;
        r4.b = r0;	 Catch:{ all -> 0x0055 }
        r0 = r4.a;	 Catch:{ all -> 0x0055 }
        r0 = r0.zzge();	 Catch:{ all -> 0x0055 }
        r0 = r0.r();	 Catch:{ all -> 0x0055 }
        r1 = "Service connected with null binder";
        r0.a(r1);	 Catch:{ all -> 0x0055 }
        monitor-exit(r4);	 Catch:{ all -> 0x0055 }
    L_0x001c:
        return;
    L_0x001d:
        r0 = r6.getInterfaceDescriptor();	 Catch:{ RemoteException -> 0x006b }
        r2 = "com.google.android.gms.measurement.internal.IMeasurementService";
        r2 = r2.equals(r0);	 Catch:{ RemoteException -> 0x006b }
        if (r2 == 0) goto L_0x007d;
    L_0x0029:
        if (r6 != 0) goto L_0x0058;
    L_0x002b:
        r0 = r1;
    L_0x002c:
        r1 = r4.a;	 Catch:{ RemoteException -> 0x009f }
        r1 = r1.zzge();	 Catch:{ RemoteException -> 0x009f }
        r1 = r1.y();	 Catch:{ RemoteException -> 0x009f }
        r2 = "Bound to IMeasurementService interface";
        r1.a(r2);	 Catch:{ RemoteException -> 0x009f }
    L_0x003b:
        if (r0 != 0) goto L_0x008e;
    L_0x003d:
        r0 = 0;
        r4.b = r0;	 Catch:{ all -> 0x0055 }
        r0 = com.google.android.gms.common.stats.b.a();	 Catch:{ IllegalArgumentException -> 0x009d }
        r1 = r4.a;	 Catch:{ IllegalArgumentException -> 0x009d }
        r1 = r1.getContext();	 Catch:{ IllegalArgumentException -> 0x009d }
        r2 = r4.a;	 Catch:{ IllegalArgumentException -> 0x009d }
        r2 = r2.a;	 Catch:{ IllegalArgumentException -> 0x009d }
        r0.a(r1, r2);	 Catch:{ IllegalArgumentException -> 0x009d }
    L_0x0053:
        monitor-exit(r4);	 Catch:{ all -> 0x0055 }
        goto L_0x001c;
    L_0x0055:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0055 }
        throw r0;
    L_0x0058:
        r0 = "com.google.android.gms.measurement.internal.IMeasurementService";
        r0 = r6.queryLocalInterface(r0);	 Catch:{ RemoteException -> 0x006b }
        r2 = r0 instanceof com.google.android.gms.internal.measurement.zzey;	 Catch:{ RemoteException -> 0x006b }
        if (r2 == 0) goto L_0x0065;
    L_0x0062:
        r0 = (com.google.android.gms.internal.measurement.zzey) r0;	 Catch:{ RemoteException -> 0x006b }
        goto L_0x002c;
    L_0x0065:
        r0 = new com.google.android.gms.internal.measurement.dj;	 Catch:{ RemoteException -> 0x006b }
        r0.<init>(r6);	 Catch:{ RemoteException -> 0x006b }
        goto L_0x002c;
    L_0x006b:
        r0 = move-exception;
        r0 = r1;
    L_0x006d:
        r1 = r4.a;	 Catch:{ all -> 0x0055 }
        r1 = r1.zzge();	 Catch:{ all -> 0x0055 }
        r1 = r1.r();	 Catch:{ all -> 0x0055 }
        r2 = "Service connect failed to get IMeasurementService";
        r1.a(r2);	 Catch:{ all -> 0x0055 }
        goto L_0x003b;
    L_0x007d:
        r2 = r4.a;	 Catch:{ RemoteException -> 0x006b }
        r2 = r2.zzge();	 Catch:{ RemoteException -> 0x006b }
        r2 = r2.r();	 Catch:{ RemoteException -> 0x006b }
        r3 = "Got binder with a wrong descriptor";
        r2.a(r3, r0);	 Catch:{ RemoteException -> 0x006b }
        r0 = r1;
        goto L_0x003b;
    L_0x008e:
        r1 = r4.a;	 Catch:{ all -> 0x0055 }
        r1 = r1.zzgd();	 Catch:{ all -> 0x0055 }
        r2 = new com.google.android.gms.internal.measurement.hd;	 Catch:{ all -> 0x0055 }
        r2.<init>(r4, r0);	 Catch:{ all -> 0x0055 }
        r1.a(r2);	 Catch:{ all -> 0x0055 }
        goto L_0x0053;
    L_0x009d:
        r0 = move-exception;
        goto L_0x0053;
    L_0x009f:
        r1 = move-exception;
        goto L_0x006d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.hc.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        ar.b("MeasurementServiceConnection.onServiceDisconnected");
        this.a.zzge().x().a("Service disconnected");
        this.a.zzgd().a(new he(this, componentName));
    }
}
