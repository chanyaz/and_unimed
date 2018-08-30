package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
final class po implements BaseConnectionCallbacks, BaseOnConnectionFailedListener {
    @VisibleForTesting
    private pp a;
    private final String b;
    private final String c;
    private final LinkedBlockingQueue<wr> d;
    private final HandlerThread e = new HandlerThread("GassClient");

    public po(Context context, String str, String str2) {
        this.b = str;
        this.c = str2;
        this.e.start();
        this.a = new pp(context, this.e.getLooper(), this, this);
        this.d = new LinkedBlockingQueue();
        this.a.g();
    }

    private final zzatx a() {
        try {
            return this.a.r();
        } catch (IllegalStateException e) {
        } catch (DeadObjectException e2) {
        }
        return null;
    }

    private final void b() {
        if (this.a == null) {
            return;
        }
        if (this.a.isConnected() || this.a.isConnecting()) {
            this.a.disconnect();
        }
    }

    @VisibleForTesting
    private static wr c() {
        wr wrVar = new wr();
        wrVar.k = Long.valueOf(32768);
        return wrVar;
    }

    public final wr a(int i) {
        wr wrVar;
        try {
            wrVar = (wr) this.d.poll(5000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            wrVar = null;
        }
        return wrVar == null ? c() : wrVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0038 A:{ExcHandler: all (th java.lang.Throwable), Splitter: B:2:0x0006} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:10:0x0039, code:
            b();
            r4.e.quit();
     */
    public final void onConnected(android.os.Bundle r5) {
        /*
        r4 = this;
        r0 = r4.a();
        if (r0 == 0) goto L_0x0024;
    L_0x0006:
        r1 = new com.google.android.gms.internal.ads.zzatt;	 Catch:{ Throwable -> 0x0025, all -> 0x0038 }
        r2 = r4.b;	 Catch:{ Throwable -> 0x0025, all -> 0x0038 }
        r3 = r4.c;	 Catch:{ Throwable -> 0x0025, all -> 0x0038 }
        r1.<init>(r2, r3);	 Catch:{ Throwable -> 0x0025, all -> 0x0038 }
        r0 = r0.zza(r1);	 Catch:{ Throwable -> 0x0025, all -> 0x0038 }
        r0 = r0.a();	 Catch:{ Throwable -> 0x0025, all -> 0x0038 }
        r1 = r4.d;	 Catch:{ Throwable -> 0x0025, all -> 0x0038 }
        r1.put(r0);	 Catch:{ Throwable -> 0x0025, all -> 0x0038 }
        r4.b();
        r0 = r4.e;
        r0.quit();
    L_0x0024:
        return;
    L_0x0025:
        r0 = move-exception;
        r0 = r4.d;	 Catch:{ InterruptedException -> 0x0042, all -> 0x0038 }
        r1 = c();	 Catch:{ InterruptedException -> 0x0042, all -> 0x0038 }
        r0.put(r1);	 Catch:{ InterruptedException -> 0x0042, all -> 0x0038 }
    L_0x002f:
        r4.b();
        r0 = r4.e;
        r0.quit();
        goto L_0x0024;
    L_0x0038:
        r0 = move-exception;
        r4.b();
        r1 = r4.e;
        r1.quit();
        throw r0;
    L_0x0042:
        r0 = move-exception;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.po.onConnected(android.os.Bundle):void");
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.d.put(c());
        } catch (InterruptedException e) {
        }
    }

    public final void onConnectionSuspended(int i) {
        try {
            this.d.put(c());
        } catch (InterruptedException e) {
        }
    }
}
