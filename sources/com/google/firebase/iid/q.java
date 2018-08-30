package com.google.firebase.iid;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.google.android.gms.common.util.VisibleForTesting;

final class q implements Runnable {
    private final long a;
    private final WakeLock b = ((PowerManager) a().getSystemService("power")).newWakeLock(1, "fiid-sync");
    private final FirebaseInstanceId c;
    private final f d;

    @VisibleForTesting
    q(FirebaseInstanceId firebaseInstanceId, f fVar, long j) {
        this.c = firebaseInstanceId;
        this.d = fVar;
        this.a = j;
        this.b.setReferenceCounted(false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0056  */
    private final boolean a(java.lang.String r7) {
        /*
        r6 = this;
        r0 = 1;
        r1 = 0;
        r2 = "!";
        r2 = r7.split(r2);
        r3 = r2.length;
        r4 = 2;
        if (r3 != r4) goto L_0x001b;
    L_0x000c:
        r3 = r2[r1];
        r4 = r2[r0];
        r2 = -1;
        r5 = r3.hashCode();	 Catch:{ IOException -> 0x0043 }
        switch(r5) {
            case 83: goto L_0x001c;
            case 84: goto L_0x0018;
            case 85: goto L_0x0026;
            default: goto L_0x0018;
        };	 Catch:{ IOException -> 0x0043 }
    L_0x0018:
        switch(r2) {
            case 0: goto L_0x0030;
            case 1: goto L_0x005f;
            default: goto L_0x001b;
        };	 Catch:{ IOException -> 0x0043 }
    L_0x001b:
        return r0;
    L_0x001c:
        r5 = "S";
        r3 = r3.equals(r5);	 Catch:{ IOException -> 0x0043 }
        if (r3 == 0) goto L_0x0018;
    L_0x0024:
        r2 = r1;
        goto L_0x0018;
    L_0x0026:
        r5 = "U";
        r3 = r3.equals(r5);	 Catch:{ IOException -> 0x0043 }
        if (r3 == 0) goto L_0x0018;
    L_0x002e:
        r2 = r0;
        goto L_0x0018;
    L_0x0030:
        r2 = r6.c;	 Catch:{ IOException -> 0x0043 }
        r2.b(r4);	 Catch:{ IOException -> 0x0043 }
        r2 = com.google.firebase.iid.FirebaseInstanceId.i();	 Catch:{ IOException -> 0x0043 }
        if (r2 == 0) goto L_0x001b;
    L_0x003b:
        r2 = "FirebaseInstanceId";
        r3 = "subscribe operation succeeded";
        android.util.Log.d(r2, r3);	 Catch:{ IOException -> 0x0043 }
        goto L_0x001b;
    L_0x0043:
        r0 = move-exception;
        r2 = "FirebaseInstanceId";
        r3 = "Topic sync failed: ";
        r0 = r0.getMessage();
        r0 = java.lang.String.valueOf(r0);
        r4 = r0.length();
        if (r4 == 0) goto L_0x0072;
    L_0x0056:
        r0 = r3.concat(r0);
    L_0x005a:
        android.util.Log.e(r2, r0);
        r0 = r1;
        goto L_0x001b;
    L_0x005f:
        r2 = r6.c;	 Catch:{ IOException -> 0x0043 }
        r2.c(r4);	 Catch:{ IOException -> 0x0043 }
        r2 = com.google.firebase.iid.FirebaseInstanceId.i();	 Catch:{ IOException -> 0x0043 }
        if (r2 == 0) goto L_0x001b;
    L_0x006a:
        r2 = "FirebaseInstanceId";
        r3 = "unsubscribe operation succeeded";
        android.util.Log.d(r2, r3);	 Catch:{ IOException -> 0x0043 }
        goto L_0x001b;
    L_0x0072:
        r0 = new java.lang.String;
        r0.<init>(r3);
        goto L_0x005a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.q.a(java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0077  */
    @com.google.android.gms.common.util.VisibleForTesting
    private final boolean c() {
        /*
        r6 = this;
        r0 = 1;
        r1 = 0;
        r2 = r6.c;
        r2 = r2.f();
        if (r2 == 0) goto L_0x0017;
    L_0x000a:
        r3 = r6.d;
        r3 = r3.b();
        r3 = r2.b(r3);
        if (r3 != 0) goto L_0x0017;
    L_0x0016:
        return r0;
    L_0x0017:
        r3 = r6.c;	 Catch:{ IOException -> 0x0064, SecurityException -> 0x0086 }
        r3 = r3.g();	 Catch:{ IOException -> 0x0064, SecurityException -> 0x0086 }
        if (r3 != 0) goto L_0x0028;
    L_0x001f:
        r0 = "FirebaseInstanceId";
        r2 = "Token retrieval failed: null";
        android.util.Log.e(r0, r2);	 Catch:{ IOException -> 0x0064, SecurityException -> 0x0086 }
        r0 = r1;
        goto L_0x0016;
    L_0x0028:
        r4 = "FirebaseInstanceId";
        r5 = 3;
        r4 = android.util.Log.isLoggable(r4, r5);	 Catch:{ IOException -> 0x0064, SecurityException -> 0x0086 }
        if (r4 == 0) goto L_0x0038;
    L_0x0031:
        r4 = "FirebaseInstanceId";
        r5 = "Token successfully retrieved";
        android.util.Log.d(r4, r5);	 Catch:{ IOException -> 0x0064, SecurityException -> 0x0086 }
    L_0x0038:
        if (r2 == 0) goto L_0x0044;
    L_0x003a:
        if (r2 == 0) goto L_0x0016;
    L_0x003c:
        r2 = r2.a;	 Catch:{ IOException -> 0x0064, SecurityException -> 0x0086 }
        r2 = r3.equals(r2);	 Catch:{ IOException -> 0x0064, SecurityException -> 0x0086 }
        if (r2 != 0) goto L_0x0016;
    L_0x0044:
        r2 = r6.a();	 Catch:{ IOException -> 0x0064, SecurityException -> 0x0086 }
        r3 = new android.content.Intent;	 Catch:{ IOException -> 0x0064, SecurityException -> 0x0086 }
        r4 = "com.google.firebase.iid.TOKEN_REFRESH";
        r3.<init>(r4);	 Catch:{ IOException -> 0x0064, SecurityException -> 0x0086 }
        r4 = new android.content.Intent;	 Catch:{ IOException -> 0x0064, SecurityException -> 0x0086 }
        r5 = "com.google.firebase.INSTANCE_ID_EVENT";
        r4.<init>(r5);	 Catch:{ IOException -> 0x0064, SecurityException -> 0x0086 }
        r5 = com.google.firebase.iid.FirebaseInstanceIdReceiver.class;
        r4.setClass(r2, r5);	 Catch:{ IOException -> 0x0064, SecurityException -> 0x0086 }
        r5 = "wrapped_intent";
        r4.putExtra(r5, r3);	 Catch:{ IOException -> 0x0064, SecurityException -> 0x0086 }
        r2.sendBroadcast(r4);	 Catch:{ IOException -> 0x0064, SecurityException -> 0x0086 }
        goto L_0x0016;
    L_0x0064:
        r0 = move-exception;
    L_0x0065:
        r2 = "FirebaseInstanceId";
        r3 = "Token retrieval failed: ";
        r0 = r0.getMessage();
        r0 = java.lang.String.valueOf(r0);
        r4 = r0.length();
        if (r4 == 0) goto L_0x0080;
    L_0x0077:
        r0 = r3.concat(r0);
    L_0x007b:
        android.util.Log.e(r2, r0);
        r0 = r1;
        goto L_0x0016;
    L_0x0080:
        r0 = new java.lang.String;
        r0.<init>(r3);
        goto L_0x007b;
    L_0x0086:
        r0 = move-exception;
        goto L_0x0065;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.q.c():boolean");
    }

    /* JADX WARNING: Missing block: B:9:0x001c, code:
            if (a(r0) != false) goto L_0x0023;
     */
    /* JADX WARNING: Missing block: B:22:?, code:
            return false;
     */
    @com.google.android.gms.common.util.VisibleForTesting
    private final boolean d() {
        /*
        r3 = this;
    L_0x0000:
        r1 = r3.c;
        monitor-enter(r1);
        r0 = com.google.firebase.iid.FirebaseInstanceId.h();	 Catch:{ all -> 0x0020 }
        r0 = r0.a();	 Catch:{ all -> 0x0020 }
        if (r0 != 0) goto L_0x0017;
    L_0x000d:
        r0 = "FirebaseInstanceId";
        r2 = "topic sync succeeded";
        android.util.Log.d(r0, r2);	 Catch:{ all -> 0x0020 }
        r0 = 1;
        monitor-exit(r1);	 Catch:{ all -> 0x0020 }
    L_0x0016:
        return r0;
    L_0x0017:
        monitor-exit(r1);	 Catch:{ all -> 0x0020 }
        r1 = r3.a(r0);
        if (r1 != 0) goto L_0x0023;
    L_0x001e:
        r0 = 0;
        goto L_0x0016;
    L_0x0020:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0020 }
        throw r0;
    L_0x0023:
        r1 = com.google.firebase.iid.FirebaseInstanceId.h();
        r1.b(r0);
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.q.d():boolean");
    }

    final Context a() {
        return this.c.b().a();
    }

    final boolean b() {
        ConnectivityManager connectivityManager = (ConnectivityManager) a().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final void run() {
        Object obj = 1;
        this.b.acquire();
        try {
            this.c.a(true);
            if (this.d.a() == 0) {
                obj = null;
            }
            if (obj == null) {
                this.c.a(false);
            } else if (b()) {
                if (c() && d()) {
                    this.c.a(false);
                } else {
                    this.c.a(this.a);
                }
                this.b.release();
            } else {
                new r(this).a();
                this.b.release();
            }
        } finally {
            this.b.release();
        }
    }
}
