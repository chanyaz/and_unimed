package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.s;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

public final class n {
    private static n b;
    @VisibleForTesting
    final Queue<Intent> a = new ArrayDeque();
    @GuardedBy("serviceClassNames")
    private final s<String, String> c = new s();
    private Boolean d = null;
    @VisibleForTesting
    private final Queue<Intent> e = new ArrayDeque();

    private n() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c A:{Catch:{ SecurityException -> 0x0115, IllegalStateException -> 0x0124 }} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0108 A:{SYNTHETIC, Splitter: B:57:0x0108} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043 A:{Catch:{ SecurityException -> 0x0115, IllegalStateException -> 0x0124 }} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0049 A:{Catch:{ SecurityException -> 0x0115, IllegalStateException -> 0x0124 }} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c A:{Catch:{ SecurityException -> 0x0115, IllegalStateException -> 0x0124 }} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043 A:{Catch:{ SecurityException -> 0x0115, IllegalStateException -> 0x0124 }} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0108 A:{SYNTHETIC, Splitter: B:57:0x0108} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0049 A:{Catch:{ SecurityException -> 0x0115, IllegalStateException -> 0x0124 }} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0121  */
    private final int a(android.content.Context r7, android.content.Intent r8) {
        /*
        r6 = this;
        r2 = 0;
        r1 = r6.c;
        monitor-enter(r1);
        r0 = r6.c;	 Catch:{ all -> 0x0053 }
        r3 = r8.getAction();	 Catch:{ all -> 0x0053 }
        r0 = r0.get(r3);	 Catch:{ all -> 0x0053 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0053 }
        monitor-exit(r1);	 Catch:{ all -> 0x0053 }
        if (r0 != 0) goto L_0x00cf;
    L_0x0013:
        r0 = r7.getPackageManager();
        r0 = r0.resolveService(r8, r2);
        if (r0 == 0) goto L_0x0021;
    L_0x001d:
        r1 = r0.serviceInfo;
        if (r1 != 0) goto L_0x0056;
    L_0x0021:
        r0 = "FirebaseInstanceId";
        r1 = "Failed to resolve target intent service, skipping classname enforcement";
        android.util.Log.e(r0, r1);
    L_0x0028:
        r0 = r6.d;	 Catch:{ SecurityException -> 0x0115, IllegalStateException -> 0x0124 }
        if (r0 != 0) goto L_0x003b;
    L_0x002c:
        r0 = "android.permission.WAKE_LOCK";
        r0 = r7.checkCallingOrSelfPermission(r0);	 Catch:{ SecurityException -> 0x0115, IllegalStateException -> 0x0124 }
        if (r0 != 0) goto L_0x0105;
    L_0x0034:
        r0 = 1;
    L_0x0035:
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ SecurityException -> 0x0115, IllegalStateException -> 0x0124 }
        r6.d = r0;	 Catch:{ SecurityException -> 0x0115, IllegalStateException -> 0x0124 }
    L_0x003b:
        r0 = r6.d;	 Catch:{ SecurityException -> 0x0115, IllegalStateException -> 0x0124 }
        r0 = r0.booleanValue();	 Catch:{ SecurityException -> 0x0115, IllegalStateException -> 0x0124 }
        if (r0 == 0) goto L_0x0108;
    L_0x0043:
        r0 = android.support.v4.content.WakefulBroadcastReceiver.a(r7, r8);	 Catch:{ SecurityException -> 0x0115, IllegalStateException -> 0x0124 }
    L_0x0047:
        if (r0 != 0) goto L_0x0121;
    L_0x0049:
        r0 = "FirebaseInstanceId";
        r1 = "Error while delivering the message: ServiceIntent not found.";
        android.util.Log.e(r0, r1);	 Catch:{ SecurityException -> 0x0115, IllegalStateException -> 0x0124 }
        r0 = 404; // 0x194 float:5.66E-43 double:1.996E-321;
    L_0x0052:
        return r0;
    L_0x0053:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0053 }
        throw r0;
    L_0x0056:
        r0 = r0.serviceInfo;
        r1 = r7.getPackageName();
        r3 = r0.packageName;
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x0068;
    L_0x0064:
        r1 = r0.name;
        if (r1 != 0) goto L_0x00a2;
    L_0x0068:
        r1 = "FirebaseInstanceId";
        r3 = r0.packageName;
        r0 = r0.name;
        r4 = java.lang.String.valueOf(r3);
        r4 = r4.length();
        r4 = r4 + 94;
        r5 = java.lang.String.valueOf(r0);
        r5 = r5.length();
        r4 = r4 + r5;
        r5 = new java.lang.StringBuilder;
        r5.<init>(r4);
        r4 = "Error resolving target intent service, skipping classname enforcement. Resolved service was: ";
        r4 = r5.append(r4);
        r3 = r4.append(r3);
        r4 = "/";
        r3 = r3.append(r4);
        r0 = r3.append(r0);
        r0 = r0.toString();
        android.util.Log.e(r1, r0);
        goto L_0x0028;
    L_0x00a2:
        r0 = r0.name;
        r1 = ".";
        r1 = r0.startsWith(r1);
        if (r1 == 0) goto L_0x00c2;
    L_0x00ac:
        r1 = r7.getPackageName();
        r1 = java.lang.String.valueOf(r1);
        r0 = java.lang.String.valueOf(r0);
        r3 = r0.length();
        if (r3 == 0) goto L_0x00f6;
    L_0x00be:
        r0 = r1.concat(r0);
    L_0x00c2:
        r1 = r6.c;
        monitor-enter(r1);
        r3 = r6.c;	 Catch:{ all -> 0x00fc }
        r4 = r8.getAction();	 Catch:{ all -> 0x00fc }
        r3.put(r4, r0);	 Catch:{ all -> 0x00fc }
        monitor-exit(r1);	 Catch:{ all -> 0x00fc }
    L_0x00cf:
        r1 = "FirebaseInstanceId";
        r3 = 3;
        r1 = android.util.Log.isLoggable(r1, r3);
        if (r1 == 0) goto L_0x00ed;
    L_0x00d8:
        r3 = "FirebaseInstanceId";
        r4 = "Restricting intent to a specific service: ";
        r1 = java.lang.String.valueOf(r0);
        r5 = r1.length();
        if (r5 == 0) goto L_0x00ff;
    L_0x00e6:
        r1 = r4.concat(r1);
    L_0x00ea:
        android.util.Log.d(r3, r1);
    L_0x00ed:
        r1 = r7.getPackageName();
        r8.setClassName(r1, r0);
        goto L_0x0028;
    L_0x00f6:
        r0 = new java.lang.String;
        r0.<init>(r1);
        goto L_0x00c2;
    L_0x00fc:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00fc }
        throw r0;
    L_0x00ff:
        r1 = new java.lang.String;
        r1.<init>(r4);
        goto L_0x00ea;
    L_0x0105:
        r0 = r2;
        goto L_0x0035;
    L_0x0108:
        r0 = r7.startService(r8);	 Catch:{ SecurityException -> 0x0115, IllegalStateException -> 0x0124 }
        r1 = "FirebaseInstanceId";
        r2 = "Missing wake lock permission, service start may be delayed";
        android.util.Log.d(r1, r2);	 Catch:{ SecurityException -> 0x0115, IllegalStateException -> 0x0124 }
        goto L_0x0047;
    L_0x0115:
        r0 = move-exception;
        r1 = "FirebaseInstanceId";
        r2 = "Error while delivering the message to the serviceIntent";
        android.util.Log.e(r1, r2, r0);
        r0 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        goto L_0x0052;
    L_0x0121:
        r0 = -1;
        goto L_0x0052;
    L_0x0124:
        r0 = move-exception;
        r1 = "FirebaseInstanceId";
        r0 = java.lang.String.valueOf(r0);
        r2 = java.lang.String.valueOf(r0);
        r2 = r2.length();
        r2 = r2 + 45;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "Failed to start service while in background: ";
        r2 = r3.append(r2);
        r0 = r2.append(r0);
        r0 = r0.toString();
        android.util.Log.e(r1, r0);
        r0 = 402; // 0x192 float:5.63E-43 double:1.986E-321;
        goto L_0x0052;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.n.a(android.content.Context, android.content.Intent):int");
    }

    public static PendingIntent a(Context context, int i, Intent intent, int i2) {
        Intent intent2 = new Intent(context, FirebaseInstanceIdReceiver.class);
        intent2.setAction("com.google.firebase.MESSAGING_EVENT");
        intent2.putExtra("wrapped_intent", intent);
        return PendingIntent.getBroadcast(context, i, intent2, 1073741824);
    }

    public static synchronized n a() {
        n nVar;
        synchronized (n.class) {
            if (b == null) {
                b = new n();
            }
            nVar = b;
        }
        return nVar;
    }

    public final int a(Context context, String str, Intent intent) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -842411455:
                if (str.equals("com.google.firebase.INSTANCE_ID_EVENT")) {
                    obj = null;
                    break;
                }
                break;
            case 41532704:
                if (str.equals("com.google.firebase.MESSAGING_EVENT")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                this.a.offer(intent);
                break;
            case 1:
                this.e.offer(intent);
                break;
            default:
                String str2 = "FirebaseInstanceId";
                String str3 = "Unknown service action: ";
                String valueOf = String.valueOf(str);
                Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                return 500;
        }
        Intent intent2 = new Intent(str);
        intent2.setPackage(context.getPackageName());
        return a(context, intent2);
    }

    public final Intent b() {
        return (Intent) this.e.poll();
    }
}
