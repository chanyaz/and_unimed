package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.ar;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
@KeepForSdk
public abstract class BasePendingResult<R extends Result> extends PendingResult<R> {
    static final ThreadLocal<Boolean> a = new ch();
    private final Object b;
    private final c<R> c;
    private final WeakReference<GoogleApiClient> d;
    private final CountDownLatch e;
    private final ArrayList<StatusListener> f;
    private ResultCallback<? super R> g;
    private final AtomicReference<zzcn> h;
    private R i;
    private Status j;
    private volatile boolean k;
    private boolean l;
    private boolean m;
    @KeepName
    private d mResultGuardian;
    private ICancelToken n;
    private volatile bq<R> o;
    private boolean p;

    @Deprecated
    BasePendingResult() {
        this.b = new Object();
        this.e = new CountDownLatch(1);
        this.f = new ArrayList();
        this.h = new AtomicReference();
        this.p = false;
        this.c = new c(Looper.getMainLooper());
        this.d = new WeakReference(null);
    }

    @KeepForSdk
    protected BasePendingResult(GoogleApiClient googleApiClient) {
        this.b = new Object();
        this.e = new CountDownLatch(1);
        this.f = new ArrayList();
        this.h = new AtomicReference();
        this.p = false;
        this.c = new c(googleApiClient != null ? googleApiClient.a() : Looper.getMainLooper());
        this.d = new WeakReference(googleApiClient);
    }

    private final void a(R r) {
        this.i = r;
        this.n = null;
        this.e.countDown();
        this.j = this.i.getStatus();
        if (this.l) {
            this.g = null;
        } else if (this.g != null) {
            this.c.removeMessages(2);
            this.c.a(this.g, d());
        } else if (this.i instanceof Releasable) {
            this.mResultGuardian = new d(this, null);
        }
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((StatusListener) obj).onComplete(this.j);
        }
        this.f.clear();
    }

    public static void c(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (Throwable e) {
                String valueOf = String.valueOf(result);
                Log.w("BasePendingResult", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    private final R d() {
        R r;
        boolean z = true;
        synchronized (this.b) {
            if (this.k) {
                z = false;
            }
            ar.a(z, (Object) "Result has already been consumed.");
            ar.a(f(), (Object) "Result is not ready.");
            r = this.i;
            this.i = null;
            this.g = null;
            this.k = true;
        }
        zzcn zzcn = (zzcn) this.h.getAndSet(null);
        if (zzcn != null) {
            zzcn.zzc(this);
        }
        return r;
    }

    /* JADX WARNING: Missing block: B:19:?, code:
            return;
     */
    @com.google.android.gms.common.annotation.KeepForSdk
    public void a() {
        /*
        r2 = this;
        r1 = r2.b;
        monitor-enter(r1);
        r0 = r2.l;	 Catch:{ all -> 0x0029 }
        if (r0 != 0) goto L_0x000b;
    L_0x0007:
        r0 = r2.k;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = r2.n;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x0016;
    L_0x0011:
        r0 = r2.n;	 Catch:{ RemoteException -> 0x002c }
        r0.cancel();	 Catch:{ RemoteException -> 0x002c }
    L_0x0016:
        r0 = r2.i;	 Catch:{ all -> 0x0029 }
        c(r0);	 Catch:{ all -> 0x0029 }
        r0 = 1;
        r2.l = r0;	 Catch:{ all -> 0x0029 }
        r0 = com.google.android.gms.common.api.Status.e;	 Catch:{ all -> 0x0029 }
        r0 = r2.b(r0);	 Catch:{ all -> 0x0029 }
        r2.a(r0);	 Catch:{ all -> 0x0029 }
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        goto L_0x000c;
    L_0x0029:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        throw r0;
    L_0x002c:
        r0 = move-exception;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.a():void");
    }

    public final void a(StatusListener statusListener) {
        ar.b(statusListener != null, "Callback cannot be null.");
        synchronized (this.b) {
            if (f()) {
                statusListener.onComplete(this.j);
            } else {
                this.f.add(statusListener);
            }
        }
    }

    /* JADX WARNING: Missing block: B:28:?, code:
            return;
     */
    @com.google.android.gms.common.annotation.KeepForSdk
    public final void a(com.google.android.gms.common.api.ResultCallback<? super R> r6) {
        /*
        r5 = this;
        r0 = 1;
        r1 = 0;
        r3 = r5.b;
        monitor-enter(r3);
        if (r6 != 0) goto L_0x000c;
    L_0x0007:
        r0 = 0;
        r5.g = r0;	 Catch:{ all -> 0x0027 }
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
    L_0x000b:
        return;
    L_0x000c:
        r2 = r5.k;	 Catch:{ all -> 0x0027 }
        if (r2 != 0) goto L_0x002a;
    L_0x0010:
        r2 = r0;
    L_0x0011:
        r4 = "Result has already been consumed.";
        com.google.android.gms.common.internal.ar.a(r2, r4);	 Catch:{ all -> 0x0027 }
        r2 = r5.o;	 Catch:{ all -> 0x0027 }
        if (r2 != 0) goto L_0x002c;
    L_0x001a:
        r1 = "Cannot set callbacks if then() has been called.";
        com.google.android.gms.common.internal.ar.a(r0, r1);	 Catch:{ all -> 0x0027 }
        r0 = r5.b();	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x002e;
    L_0x0025:
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        goto L_0x000b;
    L_0x0027:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        throw r0;
    L_0x002a:
        r2 = r1;
        goto L_0x0011;
    L_0x002c:
        r0 = r1;
        goto L_0x001a;
    L_0x002e:
        r0 = r5.f();	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x003f;
    L_0x0034:
        r0 = r5.c;	 Catch:{ all -> 0x0027 }
        r1 = r5.d();	 Catch:{ all -> 0x0027 }
        r0.a(r6, r1);	 Catch:{ all -> 0x0027 }
    L_0x003d:
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        goto L_0x000b;
    L_0x003f:
        r5.g = r6;	 Catch:{ all -> 0x0027 }
        goto L_0x003d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.a(com.google.android.gms.common.api.ResultCallback):void");
    }

    public final void a(Status status) {
        synchronized (this.b) {
            if (!f()) {
                setResult(b(status));
                this.m = true;
            }
        }
    }

    public final void a(zzcn zzcn) {
        this.h.set(zzcn);
    }

    @KeepForSdk
    @NonNull
    protected abstract R b(Status status);

    @KeepForSdk
    /* renamed from: b */
    public final void setResult(R r) {
        boolean z = true;
        synchronized (this.b) {
            if (this.m || this.l) {
                c(r);
                return;
            }
            if (f()) {
            }
            ar.a(!f(), (Object) "Results have already been set");
            if (this.k) {
                z = false;
            }
            ar.a(z, (Object) "Result has already been consumed");
            a((Result) r);
        }
    }

    public boolean b() {
        boolean z;
        synchronized (this.b) {
            z = this.l;
        }
        return z;
    }

    public final Integer c() {
        return null;
    }

    @KeepForSdk
    public final boolean f() {
        return this.e.getCount() == 0;
    }

    public final boolean g() {
        boolean b;
        synchronized (this.b) {
            if (((GoogleApiClient) this.d.get()) == null || !this.p) {
                a();
            }
            b = b();
        }
        return b;
    }

    public final void h() {
        boolean z = this.p || ((Boolean) a.get()).booleanValue();
        this.p = z;
    }
}
