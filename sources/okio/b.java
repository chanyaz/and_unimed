package okio;

final class b extends Thread {
    b() {
        super("Okio Watchdog");
        setDaemon(true);
    }

    /* JADX WARNING: Missing block: B:22:?, code:
            r0.a();
     */
    public void run() {
        /*
        r3 = this;
    L_0x0000:
        r1 = okio.a.class;
        monitor-enter(r1);	 Catch:{ InterruptedException -> 0x000e }
        r0 = okio.a.e();	 Catch:{ all -> 0x000b }
        if (r0 != 0) goto L_0x0010;
    L_0x0009:
        monitor-exit(r1);	 Catch:{ all -> 0x000b }
        goto L_0x0000;
    L_0x000b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x000b }
        throw r0;	 Catch:{ InterruptedException -> 0x000e }
    L_0x000e:
        r0 = move-exception;
        goto L_0x0000;
    L_0x0010:
        r2 = okio.a.b;	 Catch:{ all -> 0x000b }
        if (r0 != r2) goto L_0x0019;
    L_0x0014:
        r0 = 0;
        okio.a.b = r0;	 Catch:{ all -> 0x000b }
        monitor-exit(r1);	 Catch:{ all -> 0x000b }
        return;
    L_0x0019:
        monitor-exit(r1);	 Catch:{ all -> 0x000b }
        r0.a();	 Catch:{ InterruptedException -> 0x000e }
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.b.run():void");
    }
}
