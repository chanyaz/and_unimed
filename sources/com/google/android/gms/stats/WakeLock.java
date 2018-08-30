package com.google.android.gms.stats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.providers.PooledExecutorsProvider;
import com.google.android.gms.common.util.r;
import com.google.android.gms.common.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class WakeLock {
    private static ScheduledExecutorService m;
    private static Configuration n = new a();
    private final android.os.PowerManager.WakeLock a;
    private WorkSource b;
    private String c;
    private final int d;
    private final String e;
    private final String f;
    private final String g;
    private final Context h;
    private boolean i;
    private final Map<String, Integer[]> j;
    private int k;
    private AtomicInteger l;

    public interface Configuration {
        long getMaximumTimeout(String str, String str2);

        boolean isWorkChainsEnabled();
    }

    public WakeLock(Context context, int i, @Nonnull String str) {
        this(context, i, str, null, context == null ? null : context.getPackageName());
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public WakeLock(Context context, int i, @Nonnull String str, @Nullable String str2, @Nonnull String str3) {
        this(context, i, str, str2, str3, null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public WakeLock(Context context, int i, @Nonnull String str, @Nullable String str2, @Nonnull String str3, @Nullable String str4) {
        this.i = true;
        this.j = new HashMap();
        this.l = new AtomicInteger(0);
        ar.a(str, (Object) "Wake lock name can NOT be empty");
        this.d = i;
        this.f = str2;
        this.g = str4;
        this.h = context.getApplicationContext();
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.e = str;
        } else {
            String valueOf = String.valueOf("*gcore*:");
            String valueOf2 = String.valueOf(str);
            this.e = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        this.a = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (v.a(context)) {
            if (r.b(str3)) {
                str3 = context.getPackageName();
            }
            if (!n.isWorkChainsEnabled() || str3 == null || str4 == null) {
                this.b = v.a(context, str3);
            } else {
                Log.d("WakeLock", new StringBuilder((String.valueOf(str3).length() + 42) + String.valueOf(str4).length()).append("Using experimental Pi WorkSource chains: ").append(str3).append(",").append(str4).toString());
                this.c = str3;
                this.b = v.a(context, str3, str4);
            }
            a(this.b);
        }
        if (m == null) {
            m = PooledExecutorsProvider.a().newSingleThreadScheduledExecutor();
        }
    }

    private final String a(String str) {
        return this.i ? !TextUtils.isEmpty(str) ? str : this.f : this.f;
    }

    private final void a(int i) {
        if (this.a.isHeld()) {
            try {
                if (VERSION.SDK_INT < 21 || i <= 0) {
                    this.a.release();
                } else {
                    this.a.release(i);
                }
            } catch (Throwable e) {
                if (e.getClass().equals(RuntimeException.class)) {
                    Log.e("WakeLock", String.valueOf(this.e).concat(" was already released!"), e);
                    return;
                }
                throw e;
            }
        }
    }

    private final void a(String str, int i) {
        if (this.l.decrementAndGet() < 0) {
            Log.e("WakeLock", "release without a matched acquire!");
        }
        b(str, i);
    }

    /* JADX WARNING: Missing block: B:15:0x0042, code:
            if (r0 == null) goto L_0x0044;
     */
    /* JADX WARNING: Missing block: B:19:0x004a, code:
            if (r12.k == 0) goto L_0x004c;
     */
    /* JADX WARNING: Missing block: B:20:0x004c, code:
            com.google.android.gms.common.stats.f.a().a(r12.h, com.google.android.gms.common.stats.d.a(r12.a, r6), 7, r12.e, r6, r12.g, r12.d, c(), r14);
            r12.k++;
     */
    @android.annotation.SuppressLint({"WakelockTimeout"})
    private final void a(java.lang.String r13, long r14) {
        /*
        r12 = this;
        r1 = 1;
        r2 = 0;
        r6 = r12.a(r13);
        monitor-enter(r12);
        r0 = r12.j;	 Catch:{ all -> 0x00b9 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x00b9 }
        if (r0 == 0) goto L_0x0013;
    L_0x000f:
        r0 = r12.k;	 Catch:{ all -> 0x00b9 }
        if (r0 <= 0) goto L_0x0023;
    L_0x0013:
        r0 = r12.a;	 Catch:{ all -> 0x00b9 }
        r0 = r0.isHeld();	 Catch:{ all -> 0x00b9 }
        if (r0 != 0) goto L_0x0023;
    L_0x001b:
        r0 = r12.j;	 Catch:{ all -> 0x00b9 }
        r0.clear();	 Catch:{ all -> 0x00b9 }
        r0 = 0;
        r12.k = r0;	 Catch:{ all -> 0x00b9 }
    L_0x0023:
        r0 = r12.i;	 Catch:{ all -> 0x00b9 }
        if (r0 == 0) goto L_0x0044;
    L_0x0027:
        r0 = r12.j;	 Catch:{ all -> 0x00b9 }
        r0 = r0.get(r6);	 Catch:{ all -> 0x00b9 }
        r0 = (java.lang.Integer[]) r0;	 Catch:{ all -> 0x00b9 }
        if (r0 != 0) goto L_0x00a7;
    L_0x0031:
        r0 = r12.j;	 Catch:{ all -> 0x00b9 }
        r2 = 1;
        r2 = new java.lang.Integer[r2];	 Catch:{ all -> 0x00b9 }
        r3 = 0;
        r4 = 1;
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x00b9 }
        r2[r3] = r4;	 Catch:{ all -> 0x00b9 }
        r0.put(r6, r2);	 Catch:{ all -> 0x00b9 }
        r0 = r1;
    L_0x0042:
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r0 = r12.i;	 Catch:{ all -> 0x00b9 }
        if (r0 != 0) goto L_0x006d;
    L_0x0048:
        r0 = r12.k;	 Catch:{ all -> 0x00b9 }
        if (r0 != 0) goto L_0x006d;
    L_0x004c:
        r1 = com.google.android.gms.common.stats.f.a();	 Catch:{ all -> 0x00b9 }
        r2 = r12.h;	 Catch:{ all -> 0x00b9 }
        r0 = r12.a;	 Catch:{ all -> 0x00b9 }
        r3 = com.google.android.gms.common.stats.d.a(r0, r6);	 Catch:{ all -> 0x00b9 }
        r4 = 7;
        r5 = r12.e;	 Catch:{ all -> 0x00b9 }
        r7 = r12.g;	 Catch:{ all -> 0x00b9 }
        r8 = r12.d;	 Catch:{ all -> 0x00b9 }
        r9 = r12.c();	 Catch:{ all -> 0x00b9 }
        r10 = r14;
        r1.a(r2, r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ all -> 0x00b9 }
        r0 = r12.k;	 Catch:{ all -> 0x00b9 }
        r0 = r0 + 1;
        r12.k = r0;	 Catch:{ all -> 0x00b9 }
    L_0x006d:
        monitor-exit(r12);	 Catch:{ all -> 0x00b9 }
        r0 = r12.a;
        r0.acquire();
        r0 = 0;
        r0 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x00a6;
    L_0x0079:
        r0 = m;
        r1 = new com.google.android.gms.stats.b;
        r1.<init>(r12);
        r2 = java.util.concurrent.TimeUnit.MILLISECONDS;
        r0.schedule(r1, r14, r2);
        r0 = com.google.android.gms.common.util.p.b();
        if (r0 != 0) goto L_0x00a6;
    L_0x008b:
        r0 = r12.i;
        if (r0 == 0) goto L_0x00a6;
    L_0x008f:
        r1 = "WakeLock";
        r2 = "Do not acquire with timeout on reference counted wakeLocks before ICS. wakelock: ";
        r0 = r12.e;
        r0 = java.lang.String.valueOf(r0);
        r3 = r0.length();
        if (r3 == 0) goto L_0x00bc;
    L_0x009f:
        r0 = r2.concat(r0);
    L_0x00a3:
        android.util.Log.wtf(r1, r0);
    L_0x00a6:
        return;
    L_0x00a7:
        r1 = 0;
        r3 = 0;
        r3 = r0[r3];	 Catch:{ all -> 0x00b9 }
        r3 = r3.intValue();	 Catch:{ all -> 0x00b9 }
        r3 = r3 + 1;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x00b9 }
        r0[r1] = r3;	 Catch:{ all -> 0x00b9 }
        r0 = r2;
        goto L_0x0042;
    L_0x00b9:
        r0 = move-exception;
        monitor-exit(r12);	 Catch:{ all -> 0x00b9 }
        throw r0;
    L_0x00bc:
        r0 = new java.lang.String;
        r0.<init>(r2);
        goto L_0x00a3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.stats.WakeLock.a(java.lang.String, long):void");
    }

    private final void b(WorkSource workSource) {
        RuntimeException e;
        try {
            this.a.setWorkSource(workSource);
            return;
        } catch (IllegalArgumentException e2) {
            e = e2;
        } catch (ArrayIndexOutOfBoundsException e3) {
            e = e3;
        }
        Log.wtf("WakeLock", e.toString());
    }

    /* JADX WARNING: Missing block: B:8:0x0016, code:
            if (r0 == null) goto L_0x0018;
     */
    /* JADX WARNING: Missing block: B:12:0x001e, code:
            if (r9.k == 1) goto L_0x0020;
     */
    /* JADX WARNING: Missing block: B:13:0x0020, code:
            com.google.android.gms.common.stats.f.a().a(r9.h, com.google.android.gms.common.stats.d.a(r9.a, r5), 8, r9.e, r5, r9.g, r9.d, c());
            r9.k--;
     */
    private final void b(java.lang.String r10, int r11) {
        /*
        r9 = this;
        r2 = 1;
        r1 = 0;
        r5 = r9.a(r10);
        monitor-enter(r9);
        r0 = r9.i;	 Catch:{ all -> 0x0068 }
        if (r0 == 0) goto L_0x0018;
    L_0x000b:
        r0 = r9.j;	 Catch:{ all -> 0x0068 }
        r0 = r0.get(r5);	 Catch:{ all -> 0x0068 }
        r0 = (java.lang.Integer[]) r0;	 Catch:{ all -> 0x0068 }
        if (r0 != 0) goto L_0x0046;
    L_0x0015:
        r0 = r1;
    L_0x0016:
        if (r0 != 0) goto L_0x0020;
    L_0x0018:
        r0 = r9.i;	 Catch:{ all -> 0x0068 }
        if (r0 != 0) goto L_0x0041;
    L_0x001c:
        r0 = r9.k;	 Catch:{ all -> 0x0068 }
        if (r0 != r2) goto L_0x0041;
    L_0x0020:
        r0 = com.google.android.gms.common.stats.f.a();	 Catch:{ all -> 0x0068 }
        r1 = r9.h;	 Catch:{ all -> 0x0068 }
        r2 = r9.a;	 Catch:{ all -> 0x0068 }
        r2 = com.google.android.gms.common.stats.d.a(r2, r5);	 Catch:{ all -> 0x0068 }
        r3 = 8;
        r4 = r9.e;	 Catch:{ all -> 0x0068 }
        r6 = r9.g;	 Catch:{ all -> 0x0068 }
        r7 = r9.d;	 Catch:{ all -> 0x0068 }
        r8 = r9.c();	 Catch:{ all -> 0x0068 }
        r0.a(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x0068 }
        r0 = r9.k;	 Catch:{ all -> 0x0068 }
        r0 = r0 + -1;
        r9.k = r0;	 Catch:{ all -> 0x0068 }
    L_0x0041:
        monitor-exit(r9);	 Catch:{ all -> 0x0068 }
        r9.a(r11);
        return;
    L_0x0046:
        r3 = 0;
        r3 = r0[r3];	 Catch:{ all -> 0x0068 }
        r3 = r3.intValue();	 Catch:{ all -> 0x0068 }
        if (r3 != r2) goto L_0x0056;
    L_0x004f:
        r0 = r9.j;	 Catch:{ all -> 0x0068 }
        r0.remove(r5);	 Catch:{ all -> 0x0068 }
        r0 = r2;
        goto L_0x0016;
    L_0x0056:
        r3 = 0;
        r4 = 0;
        r4 = r0[r4];	 Catch:{ all -> 0x0068 }
        r4 = r4.intValue();	 Catch:{ all -> 0x0068 }
        r4 = r4 + -1;
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x0068 }
        r0[r3] = r4;	 Catch:{ all -> 0x0068 }
        r0 = r1;
        goto L_0x0016;
    L_0x0068:
        r0 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x0068 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.stats.WakeLock.b(java.lang.String, int):void");
    }

    private final List<String> c() {
        Object b = v.b(this.b);
        if (this.c == null) {
            return b;
        }
        List<String> arrayList = new ArrayList(b);
        arrayList.add(this.c);
        return arrayList;
    }

    public void a() {
        a(null, 0);
    }

    public void a(long j) {
        this.l.incrementAndGet();
        a(null, j);
    }

    public void a(WorkSource workSource) {
        if (workSource != null && v.a(this.h)) {
            if (this.b != null) {
                this.b.add(workSource);
            } else {
                this.b = workSource;
            }
            b(this.b);
        }
    }

    public void a(boolean z) {
        this.a.setReferenceCounted(z);
        this.i = z;
    }

    public boolean b() {
        return this.a.isHeld();
    }
}
