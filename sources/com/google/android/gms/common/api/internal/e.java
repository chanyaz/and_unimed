package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.support.v4.util.b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.internal.z;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.tasks.a;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public class e implements Callback {
    public static final Status a = new Status(4, "Sign-out occurred while this API call was in progress.");
    private static final Status b = new Status(4, "The user must be signed in to make this API call.");
    private static final Object f = new Object();
    @GuardedBy("lock")
    private static e g;
    private long c = 5000;
    private long d = 120000;
    private long e = 10000;
    private final Context h;
    private final com.google.android.gms.common.e i;
    private final z j;
    private final AtomicInteger k = new AtomicInteger(1);
    private final AtomicInteger l = new AtomicInteger(0);
    private final Map<bz<?>, f<?>> m = new ConcurrentHashMap(5, 0.75f, 1);
    @GuardedBy("lock")
    private w n = null;
    @GuardedBy("lock")
    private final Set<bz<?>> o = new b();
    private final Set<bz<?>> p = new b();
    private final Handler q;

    @KeepForSdk
    private e(Context context, Looper looper, com.google.android.gms.common.e eVar) {
        this.h = context;
        this.q = new Handler(looper, this);
        this.i = eVar;
        this.j = new z(eVar);
        this.q.sendMessage(this.q.obtainMessage(6));
    }

    public static e a() {
        e eVar;
        synchronized (f) {
            ar.a(g, (Object) "Must guarantee manager is non-null before using getInstance");
            eVar = g;
        }
        return eVar;
    }

    public static e a(Context context) {
        e eVar;
        synchronized (f) {
            if (g == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                g = new e(context.getApplicationContext(), handlerThread.getLooper(), com.google.android.gms.common.e.a());
            }
            eVar = g;
        }
        return eVar;
    }

    @WorkerThread
    private final void b(h<?> hVar) {
        bz b = hVar.b();
        f fVar = (f) this.m.get(b);
        if (fVar == null) {
            fVar = new f(this, hVar);
            this.m.put(b, fVar);
        }
        if (fVar.k()) {
            this.p.add(b);
        }
        fVar.i();
    }

    final PendingIntent a(bz<?> bzVar, int i) {
        f fVar = (f) this.m.get(bzVar);
        if (fVar == null) {
            return null;
        }
        SignInClient m = fVar.m();
        return m == null ? null : PendingIntent.getActivity(this.h, i, m.getSignInIntent(), 134217728);
    }

    public final a<Map<bz<?>, String>> a(Iterable<? extends h<?>> iterable) {
        cc ccVar = new cc(iterable);
        this.q.sendMessage(this.q.obtainMessage(2, ccVar));
        return ccVar.b();
    }

    public final void a(h<?> hVar) {
        this.q.sendMessage(this.q.obtainMessage(7, hVar));
    }

    public final <O extends ApiOptions> void a(h<O> hVar, int i, b<? extends Result, AnyClient> bVar) {
        this.q.sendMessage(this.q.obtainMessage(4, new bh(new bw(i, bVar), this.l.get(), hVar)));
    }

    public final void a(@NonNull w wVar) {
        synchronized (f) {
            if (this.n != wVar) {
                this.n = wVar;
                this.o.clear();
            }
            this.o.addAll(wVar.g());
        }
    }

    final boolean a(ConnectionResult connectionResult, int i) {
        return this.i.a(this.h, connectionResult, i);
    }

    public final int b() {
        return this.k.getAndIncrement();
    }

    public final void b(ConnectionResult connectionResult, int i) {
        if (!a(connectionResult, i)) {
            this.q.sendMessage(this.q.obtainMessage(5, i, 0, connectionResult));
        }
    }

    final void b(@NonNull w wVar) {
        synchronized (f) {
            if (this.n == wVar) {
                this.n = null;
                this.o.clear();
            }
        }
    }

    public final void c() {
        this.q.sendMessage(this.q.obtainMessage(3));
    }

    final void d() {
        this.l.incrementAndGet();
        this.q.sendMessage(this.q.obtainMessage(10));
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0143  */
    @android.support.annotation.WorkerThread
    public boolean handleMessage(android.os.Message r10) {
        /*
        r9 = this;
        r2 = 300000; // 0x493e0 float:4.2039E-40 double:1.482197E-318;
        r8 = 12;
        r5 = 1;
        r6 = 0;
        r4 = 0;
        r0 = r10.what;
        switch(r0) {
            case 1: goto L_0x002b;
            case 2: goto L_0x0064;
            case 3: goto L_0x00b8;
            case 4: goto L_0x00d5;
            case 5: goto L_0x011f;
            case 6: goto L_0x01b4;
            case 7: goto L_0x01e9;
            case 8: goto L_0x00d5;
            case 9: goto L_0x01f2;
            case 10: goto L_0x020b;
            case 11: goto L_0x0230;
            case 12: goto L_0x0249;
            case 13: goto L_0x00d5;
            case 14: goto L_0x0262;
            case 15: goto L_0x0298;
            case 16: goto L_0x02b9;
            default: goto L_0x000d;
        };
    L_0x000d:
        r0 = "GoogleApiManager";
        r1 = r10.what;
        r2 = 31;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "Unknown message id: ";
        r2 = r3.append(r2);
        r1 = r2.append(r1);
        r1 = r1.toString();
        android.util.Log.w(r0, r1);
        r0 = r4;
    L_0x002a:
        return r0;
    L_0x002b:
        r0 = r10.obj;
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x0062;
    L_0x0035:
        r0 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
    L_0x0037:
        r9.e = r0;
        r0 = r9.q;
        r0.removeMessages(r8);
        r0 = r9.m;
        r0 = r0.keySet();
        r1 = r0.iterator();
    L_0x0048:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0090;
    L_0x004e:
        r0 = r1.next();
        r0 = (com.google.android.gms.common.api.internal.bz) r0;
        r2 = r9.q;
        r3 = r9.q;
        r0 = r3.obtainMessage(r8, r0);
        r6 = r9.e;
        r2.sendMessageDelayed(r0, r6);
        goto L_0x0048;
    L_0x0062:
        r0 = r2;
        goto L_0x0037;
    L_0x0064:
        r0 = r10.obj;
        r0 = (com.google.android.gms.common.api.internal.cc) r0;
        r1 = r0.a();
        r3 = r1.iterator();
    L_0x0070:
        r1 = r3.hasNext();
        if (r1 == 0) goto L_0x0090;
    L_0x0076:
        r1 = r3.next();
        r1 = (com.google.android.gms.common.api.internal.bz) r1;
        r2 = r9.m;
        r2 = r2.get(r1);
        r2 = (com.google.android.gms.common.api.internal.f) r2;
        if (r2 != 0) goto L_0x0092;
    L_0x0086:
        r2 = new com.google.android.gms.common.ConnectionResult;
        r3 = 13;
        r2.<init>(r3);
        r0.a(r1, r2, r6);
    L_0x0090:
        r0 = r5;
        goto L_0x002a;
    L_0x0092:
        r4 = r2.j();
        if (r4 == 0) goto L_0x00a6;
    L_0x0098:
        r4 = com.google.android.gms.common.ConnectionResult.a;
        r2 = r2.b();
        r2 = r2.getEndpointPackageName();
        r0.a(r1, r4, r2);
        goto L_0x0070;
    L_0x00a6:
        r4 = r2.e();
        if (r4 == 0) goto L_0x00b4;
    L_0x00ac:
        r2 = r2.e();
        r0.a(r1, r2, r6);
        goto L_0x0070;
    L_0x00b4:
        r2.a(r0);
        goto L_0x0070;
    L_0x00b8:
        r0 = r9.m;
        r0 = r0.values();
        r1 = r0.iterator();
    L_0x00c2:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0090;
    L_0x00c8:
        r0 = r1.next();
        r0 = (com.google.android.gms.common.api.internal.f) r0;
        r0.d();
        r0.i();
        goto L_0x00c2;
    L_0x00d5:
        r0 = r10.obj;
        r0 = (com.google.android.gms.common.api.internal.bh) r0;
        r1 = r9.m;
        r2 = r0.c;
        r2 = r2.b();
        r1 = r1.get(r2);
        r1 = (com.google.android.gms.common.api.internal.f) r1;
        if (r1 != 0) goto L_0x00fc;
    L_0x00e9:
        r1 = r0.c;
        r9.b(r1);
        r1 = r9.m;
        r2 = r0.c;
        r2 = r2.b();
        r1 = r1.get(r2);
        r1 = (com.google.android.gms.common.api.internal.f) r1;
    L_0x00fc:
        r2 = r1.k();
        if (r2 == 0) goto L_0x0118;
    L_0x0102:
        r2 = r9.l;
        r2 = r2.get();
        r3 = r0.b;
        if (r2 == r3) goto L_0x0118;
    L_0x010c:
        r0 = r0.a;
        r2 = a;
        r0.a(r2);
        r1.a();
        goto L_0x0090;
    L_0x0118:
        r0 = r0.a;
        r1.a(r0);
        goto L_0x0090;
    L_0x011f:
        r2 = r10.arg1;
        r0 = r10.obj;
        r0 = (com.google.android.gms.common.ConnectionResult) r0;
        r1 = r9.m;
        r1 = r1.values();
        r3 = r1.iterator();
    L_0x012f:
        r1 = r3.hasNext();
        if (r1 == 0) goto L_0x02da;
    L_0x0135:
        r1 = r3.next();
        r1 = (com.google.android.gms.common.api.internal.f) r1;
        r4 = r1.l();
        if (r4 != r2) goto L_0x012f;
    L_0x0141:
        if (r1 == 0) goto L_0x018d;
    L_0x0143:
        r2 = new com.google.android.gms.common.api.Status;
        r3 = 17;
        r4 = r9.i;
        r6 = r0.c();
        r4 = r4.c(r6);
        r0 = r0.e();
        r6 = java.lang.String.valueOf(r4);
        r6 = r6.length();
        r6 = r6 + 69;
        r7 = java.lang.String.valueOf(r0);
        r7 = r7.length();
        r6 = r6 + r7;
        r7 = new java.lang.StringBuilder;
        r7.<init>(r6);
        r6 = "Error resolution was canceled by the user, original error message: ";
        r6 = r7.append(r6);
        r4 = r6.append(r4);
        r6 = ": ";
        r4 = r4.append(r6);
        r0 = r4.append(r0);
        r0 = r0.toString();
        r2.<init>(r3, r0);
        r1.a(r2);
        goto L_0x0090;
    L_0x018d:
        r0 = "GoogleApiManager";
        r1 = 76;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r1);
        r1 = "Could not find API instance ";
        r1 = r3.append(r1);
        r1 = r1.append(r2);
        r2 = " while trying to fail enqueued calls.";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r2 = new java.lang.Exception;
        r2.<init>();
        android.util.Log.wtf(r0, r1, r2);
        goto L_0x0090;
    L_0x01b4:
        r0 = com.google.android.gms.common.util.p.b();
        if (r0 == 0) goto L_0x0090;
    L_0x01ba:
        r0 = r9.h;
        r0 = r0.getApplicationContext();
        r0 = r0 instanceof android.app.Application;
        if (r0 == 0) goto L_0x0090;
    L_0x01c4:
        r0 = r9.h;
        r0 = r0.getApplicationContext();
        r0 = (android.app.Application) r0;
        com.google.android.gms.common.api.internal.BackgroundDetector.a(r0);
        r0 = com.google.android.gms.common.api.internal.BackgroundDetector.a();
        r1 = new com.google.android.gms.common.api.internal.ax;
        r1.<init>(r9);
        r0.a(r1);
        r0 = com.google.android.gms.common.api.internal.BackgroundDetector.a();
        r0 = r0.a(r5);
        if (r0 != 0) goto L_0x0090;
    L_0x01e5:
        r9.e = r2;
        goto L_0x0090;
    L_0x01e9:
        r0 = r10.obj;
        r0 = (com.google.android.gms.common.api.h) r0;
        r9.b(r0);
        goto L_0x0090;
    L_0x01f2:
        r0 = r9.m;
        r1 = r10.obj;
        r0 = r0.containsKey(r1);
        if (r0 == 0) goto L_0x0090;
    L_0x01fc:
        r0 = r9.m;
        r1 = r10.obj;
        r0 = r0.get(r1);
        r0 = (com.google.android.gms.common.api.internal.f) r0;
        r0.f();
        goto L_0x0090;
    L_0x020b:
        r0 = r9.p;
        r1 = r0.iterator();
    L_0x0211:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0229;
    L_0x0217:
        r0 = r1.next();
        r0 = (com.google.android.gms.common.api.internal.bz) r0;
        r2 = r9.m;
        r0 = r2.remove(r0);
        r0 = (com.google.android.gms.common.api.internal.f) r0;
        r0.a();
        goto L_0x0211;
    L_0x0229:
        r0 = r9.p;
        r0.clear();
        goto L_0x0090;
    L_0x0230:
        r0 = r9.m;
        r1 = r10.obj;
        r0 = r0.containsKey(r1);
        if (r0 == 0) goto L_0x0090;
    L_0x023a:
        r0 = r9.m;
        r1 = r10.obj;
        r0 = r0.get(r1);
        r0 = (com.google.android.gms.common.api.internal.f) r0;
        r0.g();
        goto L_0x0090;
    L_0x0249:
        r0 = r9.m;
        r1 = r10.obj;
        r0 = r0.containsKey(r1);
        if (r0 == 0) goto L_0x0090;
    L_0x0253:
        r0 = r9.m;
        r1 = r10.obj;
        r0 = r0.get(r1);
        r0 = (com.google.android.gms.common.api.internal.f) r0;
        r0.h();
        goto L_0x0090;
    L_0x0262:
        r0 = r10.obj;
        r0 = (com.google.android.gms.common.api.internal.x) r0;
        r1 = r0.a();
        r2 = r9.m;
        r2 = r2.containsKey(r1);
        if (r2 != 0) goto L_0x027f;
    L_0x0272:
        r0 = r0.b();
        r1 = java.lang.Boolean.valueOf(r4);
        r0.a(r1);
        goto L_0x0090;
    L_0x027f:
        r2 = r9.m;
        r1 = r2.get(r1);
        r1 = (com.google.android.gms.common.api.internal.f) r1;
        r1 = r1.a(false);
        r0 = r0.b();
        r1 = java.lang.Boolean.valueOf(r1);
        r0.a(r1);
        goto L_0x0090;
    L_0x0298:
        r0 = r10.obj;
        r0 = (com.google.android.gms.common.api.internal.g) r0;
        r1 = r9.m;
        r2 = r0.a;
        r1 = r1.containsKey(r2);
        if (r1 == 0) goto L_0x0090;
    L_0x02a8:
        r1 = r9.m;
        r2 = r0.a;
        r1 = r1.get(r2);
        r1 = (com.google.android.gms.common.api.internal.f) r1;
        r1.a(r0);
        goto L_0x0090;
    L_0x02b9:
        r0 = r10.obj;
        r0 = (com.google.android.gms.common.api.internal.g) r0;
        r1 = r9.m;
        r2 = r0.a;
        r1 = r1.containsKey(r2);
        if (r1 == 0) goto L_0x0090;
    L_0x02c9:
        r1 = r9.m;
        r2 = r0.a;
        r1 = r1.get(r2);
        r1 = (com.google.android.gms.common.api.internal.f) r1;
        r1.b(r0);
        goto L_0x0090;
    L_0x02da:
        r1 = r6;
        goto L_0x0141;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.e.handleMessage(android.os.Message):boolean");
    }
}
