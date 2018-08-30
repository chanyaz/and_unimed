package com.google.firebase.iid;

final /* synthetic */ class am implements Runnable {
    private final aj a;

    am(aj ajVar) {
        this.a = ajVar;
    }

    /* JADX WARNING: Missing block: B:17:0x0043, code:
            if (android.util.Log.isLoggable("MessengerIpcClient", 3) == false) goto L_0x006b;
     */
    /* JADX WARNING: Missing block: B:18:0x0045, code:
            r3 = java.lang.String.valueOf(r0);
            android.util.Log.d("MessengerIpcClient", new java.lang.StringBuilder(java.lang.String.valueOf(r3).length() + 8).append("Sending ").append(r3).toString());
     */
    /* JADX WARNING: Missing block: B:19:0x006b, code:
            r2 = r1.f.b;
            r3 = r1.b;
            r4 = android.os.Message.obtain();
            r4.what = r0.c;
            r4.arg1 = r0.a;
            r4.replyTo = r3;
            r3 = new android.os.Bundle();
            r3.putBoolean("oneWay", r0.a());
            r3.putString("pkg", r2.getPackageName());
            r3.putBundle("data", r0.d);
            r4.setData(r3);
     */
    /* JADX WARNING: Missing block: B:21:?, code:
            r1.c.a(r4);
     */
    /* JADX WARNING: Missing block: B:23:0x00a9, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:24:0x00aa, code:
            r1.a(2, r0.getMessage());
     */
    public final void run() {
        /*
        r8 = this;
        r7 = 2;
        r1 = r8.a;
    L_0x0003:
        monitor-enter(r1);
        r0 = r1.a;	 Catch:{ all -> 0x0017 }
        if (r0 == r7) goto L_0x000a;
    L_0x0008:
        monitor-exit(r1);	 Catch:{ all -> 0x0017 }
    L_0x0009:
        return;
    L_0x000a:
        r0 = r1.d;	 Catch:{ all -> 0x0017 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0017 }
        if (r0 == 0) goto L_0x001a;
    L_0x0012:
        r1.a();	 Catch:{ all -> 0x0017 }
        monitor-exit(r1);	 Catch:{ all -> 0x0017 }
        goto L_0x0009;
    L_0x0017:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0017 }
        throw r0;
    L_0x001a:
        r0 = r1.d;	 Catch:{ all -> 0x0017 }
        r0 = r0.poll();	 Catch:{ all -> 0x0017 }
        r0 = (com.google.firebase.iid.d) r0;	 Catch:{ all -> 0x0017 }
        r2 = r1.e;	 Catch:{ all -> 0x0017 }
        r3 = r0.a;	 Catch:{ all -> 0x0017 }
        r2.put(r3, r0);	 Catch:{ all -> 0x0017 }
        r2 = r1.f;	 Catch:{ all -> 0x0017 }
        r2 = r2.c;	 Catch:{ all -> 0x0017 }
        r3 = new com.google.firebase.iid.an;	 Catch:{ all -> 0x0017 }
        r3.<init>(r1, r0);	 Catch:{ all -> 0x0017 }
        r4 = 30;
        r6 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ all -> 0x0017 }
        r2.schedule(r3, r4, r6);	 Catch:{ all -> 0x0017 }
        monitor-exit(r1);	 Catch:{ all -> 0x0017 }
        r2 = "MessengerIpcClient";
        r3 = 3;
        r2 = android.util.Log.isLoggable(r2, r3);
        if (r2 == 0) goto L_0x006b;
    L_0x0045:
        r2 = "MessengerIpcClient";
        r3 = java.lang.String.valueOf(r0);
        r4 = java.lang.String.valueOf(r3);
        r4 = r4.length();
        r4 = r4 + 8;
        r5 = new java.lang.StringBuilder;
        r5.<init>(r4);
        r4 = "Sending ";
        r4 = r5.append(r4);
        r3 = r4.append(r3);
        r3 = r3.toString();
        android.util.Log.d(r2, r3);
    L_0x006b:
        r2 = r1.f;
        r2 = r2.b;
        r3 = r1.b;
        r4 = android.os.Message.obtain();
        r5 = r0.c;
        r4.what = r5;
        r5 = r0.a;
        r4.arg1 = r5;
        r4.replyTo = r3;
        r3 = new android.os.Bundle;
        r3.<init>();
        r5 = "oneWay";
        r6 = r0.a();
        r3.putBoolean(r5, r6);
        r5 = "pkg";
        r2 = r2.getPackageName();
        r3.putString(r5, r2);
        r2 = "data";
        r0 = r0.d;
        r3.putBundle(r2, r0);
        r4.setData(r3);
        r0 = r1.c;	 Catch:{ RemoteException -> 0x00a9 }
        r0.a(r4);	 Catch:{ RemoteException -> 0x00a9 }
        goto L_0x0003;
    L_0x00a9:
        r0 = move-exception;
        r0 = r0.getMessage();
        r1.a(r7, r0);
        goto L_0x0003;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.am.run():void");
    }
}
