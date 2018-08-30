package okhttp3.internal.http2;

import okio.Sink;
import okio.d;
import okio.p;

final class n implements Sink {
    static final /* synthetic */ boolean c = (!m.class.desiredAssertionStatus());
    boolean a;
    boolean b;
    final /* synthetic */ m d;
    private final d e = new d();

    n(m mVar) {
        this.d = mVar;
    }

    private void a(boolean z) {
        long min;
        synchronized (this.d) {
            this.d.g.c();
            while (this.d.b <= 0 && !this.b && !this.a && this.d.h == null) {
                try {
                    this.d.l();
                } catch (Throwable th) {
                    this.d.g.b();
                }
            }
            this.d.g.b();
            this.d.k();
            min = Math.min(this.d.b, this.e.a());
            m mVar = this.d;
            mVar.b -= min;
        }
        this.d.g.c();
        try {
            h hVar = this.d.d;
            int i = this.d.c;
            boolean z2 = z && min == this.e.a();
            hVar.a(i, z2, this.e, min);
        } finally {
            this.d.g.b();
        }
    }

    /* JADX WARNING: Missing block: B:14:0x0025, code:
            if (r6.d.e.b != false) goto L_0x004e;
     */
    /* JADX WARNING: Missing block: B:16:0x002f, code:
            if (r6.e.a() <= 0) goto L_0x0042;
     */
    /* JADX WARNING: Missing block: B:18:0x0039, code:
            if (r6.e.a() <= 0) goto L_0x004e;
     */
    /* JADX WARNING: Missing block: B:19:0x003b, code:
            a(true);
     */
    /* JADX WARNING: Missing block: B:24:0x0042, code:
            r6.d.d.a(r6.d.c, true, null, 0);
     */
    /* JADX WARNING: Missing block: B:25:0x004e, code:
            r1 = r6.d;
     */
    /* JADX WARNING: Missing block: B:26:0x0050, code:
            monitor-enter(r1);
     */
    /* JADX WARNING: Missing block: B:29:?, code:
            r6.a = true;
     */
    /* JADX WARNING: Missing block: B:30:0x0054, code:
            monitor-exit(r1);
     */
    /* JADX WARNING: Missing block: B:31:0x0055, code:
            r6.d.d.b();
            r6.d.j();
     */
    /* JADX WARNING: Missing block: B:44:?, code:
            return;
     */
    public void close() {
        /*
        r6 = this;
        r4 = 0;
        r2 = 1;
        r0 = c;
        if (r0 != 0) goto L_0x0015;
    L_0x0007:
        r0 = r6.d;
        r0 = java.lang.Thread.holdsLock(r0);
        if (r0 == 0) goto L_0x0015;
    L_0x000f:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x0015:
        r1 = r6.d;
        monitor-enter(r1);
        r0 = r6.a;	 Catch:{ all -> 0x003f }
        if (r0 == 0) goto L_0x001e;
    L_0x001c:
        monitor-exit(r1);	 Catch:{ all -> 0x003f }
    L_0x001d:
        return;
    L_0x001e:
        monitor-exit(r1);	 Catch:{ all -> 0x003f }
        r0 = r6.d;
        r0 = r0.e;
        r0 = r0.b;
        if (r0 != 0) goto L_0x004e;
    L_0x0027:
        r0 = r6.e;
        r0 = r0.a();
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 <= 0) goto L_0x0042;
    L_0x0031:
        r0 = r6.e;
        r0 = r0.a();
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 <= 0) goto L_0x004e;
    L_0x003b:
        r6.a(r2);
        goto L_0x0031;
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003f }
        throw r0;
    L_0x0042:
        r0 = r6.d;
        r0 = r0.d;
        r1 = r6.d;
        r1 = r1.c;
        r3 = 0;
        r0.a(r1, r2, r3, r4);
    L_0x004e:
        r1 = r6.d;
        monitor-enter(r1);
        r0 = 1;
        r6.a = r0;	 Catch:{ all -> 0x0062 }
        monitor-exit(r1);	 Catch:{ all -> 0x0062 }
        r0 = r6.d;
        r0 = r0.d;
        r0.b();
        r0 = r6.d;
        r0.j();
        goto L_0x001d;
    L_0x0062:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0062 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.n.close():void");
    }

    public void flush() {
        if (c || !Thread.holdsLock(this.d)) {
            synchronized (this.d) {
                this.d.k();
            }
            while (this.e.a() > 0) {
                a(false);
                this.d.d.b();
            }
            return;
        }
        throw new AssertionError();
    }

    public p timeout() {
        return this.d.g;
    }

    public void write(d dVar, long j) {
        if (c || !Thread.holdsLock(this.d)) {
            this.e.write(dVar, j);
            while (this.e.a() >= 16384) {
                a(false);
            }
            return;
        }
        throw new AssertionError();
    }
}
