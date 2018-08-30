package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import okhttp3.internal.b;
import okhttp3.internal.c;
import okio.BufferedSource;
import okio.ByteString;

class k extends b implements Handler {
    final Http2Reader a;
    final /* synthetic */ h c;

    k(h hVar, Http2Reader http2Reader) {
        this.c = hVar;
        super("OkHttp %s", hVar.e);
        this.a = http2Reader;
    }

    private void a(final u uVar) {
        h.a.execute(new b("OkHttp %s ACK Settings", new Object[]{this.c.e}) {
            public void b() {
                try {
                    k.this.c.p.a(uVar);
                } catch (IOException e) {
                }
            }
        });
    }

    public void ackSettings() {
    }

    public void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j) {
    }

    protected void b() {
        ErrorCode errorCode;
        Throwable th;
        ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
        ErrorCode errorCode3 = ErrorCode.INTERNAL_ERROR;
        try {
            this.a.a((Handler) this);
            do {
            } while (this.a.a(false, (Handler) this));
            try {
                this.c.a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
            } catch (IOException e) {
            }
            c.a(this.a);
        } catch (IOException e2) {
            errorCode = ErrorCode.PROTOCOL_ERROR;
            try {
                this.c.a(errorCode, ErrorCode.PROTOCOL_ERROR);
            } catch (IOException e3) {
            }
            c.a(this.a);
        } catch (Throwable th2) {
            th = th2;
            this.c.a(errorCode, errorCode3);
            c.a(this.a);
            throw th;
        }
    }

    public void data(boolean z, int i, BufferedSource bufferedSource, int i2) {
        if (this.c.d(i)) {
            this.c.a(i, bufferedSource, i2, z);
            return;
        }
        m a = this.c.a(i);
        if (a == null) {
            this.c.a(i, ErrorCode.PROTOCOL_ERROR);
            bufferedSource.skip((long) i2);
            return;
        }
        a.a(bufferedSource, i2);
        if (z) {
            a.i();
        }
    }

    public void goAway(int i, ErrorCode errorCode, ByteString byteString) {
        if (byteString.g() > 0) {
        }
        synchronized (this.c) {
            m[] mVarArr = (m[]) this.c.d.values().toArray(new m[this.c.d.size()]);
            this.c.h = true;
        }
        for (m mVar : mVarArr) {
            if (mVar.a() > i && mVar.c()) {
                mVar.c(ErrorCode.REFUSED_STREAM);
                this.c.b(mVar.a());
            }
        }
    }

    /* JADX WARNING: Missing block: B:24:0x0072, code:
            r0.a((java.util.List) r12);
     */
    /* JADX WARNING: Missing block: B:25:0x0075, code:
            if (r9 == false) goto L_?;
     */
    /* JADX WARNING: Missing block: B:26:0x0077, code:
            r0.i();
     */
    /* JADX WARNING: Missing block: B:28:?, code:
            return;
     */
    /* JADX WARNING: Missing block: B:29:?, code:
            return;
     */
    public void headers(boolean r9, int r10, int r11, java.util.List<okhttp3.internal.http2.a> r12) {
        /*
        r8 = this;
        r0 = r8.c;
        r0 = r0.d(r10);
        if (r0 == 0) goto L_0x000e;
    L_0x0008:
        r0 = r8.c;
        r0.a(r10, r12, r9);
    L_0x000d:
        return;
    L_0x000e:
        r6 = r8.c;
        monitor-enter(r6);
        r0 = r8.c;	 Catch:{ all -> 0x0019 }
        r0 = r0.h;	 Catch:{ all -> 0x0019 }
        if (r0 == 0) goto L_0x001c;
    L_0x0017:
        monitor-exit(r6);	 Catch:{ all -> 0x0019 }
        goto L_0x000d;
    L_0x0019:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0019 }
        throw r0;
    L_0x001c:
        r0 = r8.c;	 Catch:{ all -> 0x0019 }
        r0 = r0.a(r10);	 Catch:{ all -> 0x0019 }
        if (r0 != 0) goto L_0x0071;
    L_0x0024:
        r0 = r8.c;	 Catch:{ all -> 0x0019 }
        r0 = r0.f;	 Catch:{ all -> 0x0019 }
        if (r10 > r0) goto L_0x002c;
    L_0x002a:
        monitor-exit(r6);	 Catch:{ all -> 0x0019 }
        goto L_0x000d;
    L_0x002c:
        r0 = r10 % 2;
        r1 = r8.c;	 Catch:{ all -> 0x0019 }
        r1 = r1.g;	 Catch:{ all -> 0x0019 }
        r1 = r1 % 2;
        if (r0 != r1) goto L_0x0038;
    L_0x0036:
        monitor-exit(r6);	 Catch:{ all -> 0x0019 }
        goto L_0x000d;
    L_0x0038:
        r0 = new okhttp3.internal.http2.m;	 Catch:{ all -> 0x0019 }
        r2 = r8.c;	 Catch:{ all -> 0x0019 }
        r3 = 0;
        r1 = r10;
        r4 = r9;
        r5 = r12;
        r0.<init>(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x0019 }
        r1 = r8.c;	 Catch:{ all -> 0x0019 }
        r1.f = r10;	 Catch:{ all -> 0x0019 }
        r1 = r8.c;	 Catch:{ all -> 0x0019 }
        r1 = r1.d;	 Catch:{ all -> 0x0019 }
        r2 = java.lang.Integer.valueOf(r10);	 Catch:{ all -> 0x0019 }
        r1.put(r2, r0);	 Catch:{ all -> 0x0019 }
        r1 = okhttp3.internal.http2.h.a;	 Catch:{ all -> 0x0019 }
        r2 = new okhttp3.internal.http2.k$1;	 Catch:{ all -> 0x0019 }
        r3 = "OkHttp %s stream %d";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0019 }
        r5 = 0;
        r7 = r8.c;	 Catch:{ all -> 0x0019 }
        r7 = r7.e;	 Catch:{ all -> 0x0019 }
        r4[r5] = r7;	 Catch:{ all -> 0x0019 }
        r5 = 1;
        r7 = java.lang.Integer.valueOf(r10);	 Catch:{ all -> 0x0019 }
        r4[r5] = r7;	 Catch:{ all -> 0x0019 }
        r2.<init>(r3, r4, r0);	 Catch:{ all -> 0x0019 }
        r1.execute(r2);	 Catch:{ all -> 0x0019 }
        monitor-exit(r6);	 Catch:{ all -> 0x0019 }
        goto L_0x000d;
    L_0x0071:
        monitor-exit(r6);	 Catch:{ all -> 0x0019 }
        r0.a(r12);
        if (r9 == 0) goto L_0x000d;
    L_0x0077:
        r0.i();
        goto L_0x000d;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.k.headers(boolean, int, int, java.util.List):void");
    }

    public void ping(boolean z, int i, int i2) {
        if (z) {
            t c = this.c.c(i);
            if (c != null) {
                c.b();
                return;
            }
            return;
        }
        this.c.a(true, i, i2, null);
    }

    public void priority(int i, int i2, int i3, boolean z) {
    }

    public void pushPromise(int i, int i2, List<a> list) {
        this.c.a(i2, (List) list);
    }

    public void rstStream(int i, ErrorCode errorCode) {
        if (this.c.d(i)) {
            this.c.c(i, errorCode);
            return;
        }
        m b = this.c.b(i);
        if (b != null) {
            b.c(errorCode);
        }
    }

    public void settings(boolean z, u uVar) {
        int d;
        m[] mVarArr;
        long j;
        synchronized (this.c) {
            int d2 = this.c.m.d();
            if (z) {
                this.c.m.a();
            }
            this.c.m.a(uVar);
            a(uVar);
            d = this.c.m.d();
            if (d == -1 || d == d2) {
                mVarArr = null;
                j = 0;
            } else {
                long j2 = (long) (d - d2);
                if (!this.c.n) {
                    this.c.a(j2);
                    this.c.n = true;
                }
                if (this.c.d.isEmpty()) {
                    j = j2;
                    mVarArr = null;
                } else {
                    j = j2;
                    mVarArr = (m[]) this.c.d.values().toArray(new m[this.c.d.size()]);
                }
            }
            h.a.execute(new b("OkHttp %s settings", this.c.e) {
                public void b() {
                    k.this.c.c.a(k.this.c);
                }
            });
        }
        if (mVarArr != null && j != 0) {
            for (m mVar : mVarArr) {
                synchronized (mVar) {
                    mVar.a(j);
                }
            }
        }
    }

    public void windowUpdate(int i, long j) {
        if (i == 0) {
            synchronized (this.c) {
                h hVar = this.c;
                hVar.k += j;
                this.c.notifyAll();
            }
            return;
        }
        m a = this.c.a(i);
        if (a != null) {
            synchronized (a) {
                a.a(j);
            }
        }
    }
}
