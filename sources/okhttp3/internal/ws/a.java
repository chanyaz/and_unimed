package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Protocol;
import okhttp3.WebSocket;
import okhttp3.ad;
import okhttp3.ag;
import okhttp3.al;
import okhttp3.internal.c;
import okhttp3.internal.connection.f;
import okhttp3.internal.ws.WebSocketReader.FrameCallback;
import okhttp3.z;
import okio.ByteString;

public final class a implements WebSocket, FrameCallback {
    static final /* synthetic */ boolean d = (!a.class.desiredAssertionStatus());
    private static final List<Protocol> e = Collections.singletonList(Protocol.HTTP_1_1);
    final al a;
    int b;
    int c;
    private final ad f;
    private final Random g;
    private final String h;
    private Call i;
    private final Runnable j;
    private WebSocketReader k;
    private h l;
    private ScheduledExecutorService m;
    private f n;
    private final ArrayDeque<ByteString> o = new ArrayDeque();
    private final ArrayDeque<Object> p = new ArrayDeque();
    private long q;
    private boolean r;
    private ScheduledFuture<?> s;
    private int t = -1;
    private String u;
    private boolean v;

    public a(ad adVar, al alVar, Random random) {
        if ("GET".equals(adVar.b())) {
            this.f = adVar;
            this.a = alVar;
            this.g = random;
            byte[] bArr = new byte[16];
            random.nextBytes(bArr);
            this.h = ByteString.a(bArr).b();
            this.j = new Runnable() {
                public void run() {
                    do {
                        try {
                        } catch (Exception e) {
                            a.this.a(e, null);
                            return;
                        }
                    } while (a.this.b());
                }
            };
            return;
        }
        throw new IllegalArgumentException("Request must be GET: " + adVar.b());
    }

    private synchronized boolean a(ByteString byteString, int i) {
        boolean z = false;
        synchronized (this) {
            if (!(this.v || this.r)) {
                if (this.q + ((long) byteString.g()) > 16777216) {
                    close(1001, null);
                } else {
                    this.q += (long) byteString.g();
                    this.p.add(new d(i, byteString));
                    d();
                    z = true;
                }
            }
        }
        return z;
    }

    private void d() {
        if (!d && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (this.m != null) {
            this.m.execute(this.j);
        }
    }

    public void a() {
        while (this.t == -1) {
            this.k.a();
        }
    }

    /* JADX WARNING: Missing block: B:13:?, code:
            r3.a.a((okhttp3.WebSocket) r3, (java.lang.Throwable) r4, r5);
     */
    /* JADX WARNING: Missing block: B:19:0x0030, code:
            okhttp3.internal.c.a(r1);
     */
    public void a(java.lang.Exception r4, okhttp3.ag r5) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.v;	 Catch:{ all -> 0x002c }
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r3);	 Catch:{ all -> 0x002c }
    L_0x0006:
        return;
    L_0x0007:
        r0 = 1;
        r3.v = r0;	 Catch:{ all -> 0x002c }
        r1 = r3.n;	 Catch:{ all -> 0x002c }
        r0 = 0;
        r3.n = r0;	 Catch:{ all -> 0x002c }
        r0 = r3.s;	 Catch:{ all -> 0x002c }
        if (r0 == 0) goto L_0x0019;
    L_0x0013:
        r0 = r3.s;	 Catch:{ all -> 0x002c }
        r2 = 0;
        r0.cancel(r2);	 Catch:{ all -> 0x002c }
    L_0x0019:
        r0 = r3.m;	 Catch:{ all -> 0x002c }
        if (r0 == 0) goto L_0x0022;
    L_0x001d:
        r0 = r3.m;	 Catch:{ all -> 0x002c }
        r0.shutdown();	 Catch:{ all -> 0x002c }
    L_0x0022:
        monitor-exit(r3);	 Catch:{ all -> 0x002c }
        r0 = r3.a;	 Catch:{ all -> 0x002f }
        r0.a(r3, r4, r5);	 Catch:{ all -> 0x002f }
        okhttp3.internal.c.a(r1);
        goto L_0x0006;
    L_0x002c:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002c }
        throw r0;
    L_0x002f:
        r0 = move-exception;
        okhttp3.internal.c.a(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.a.a(java.lang.Exception, okhttp3.ag):void");
    }

    public void a(String str, long j, f fVar) {
        synchronized (this) {
            this.n = fVar;
            this.l = new h(fVar.c, fVar.e, this.g);
            this.m = new ScheduledThreadPoolExecutor(1, c.a(str, false));
            if (j != 0) {
                this.m.scheduleAtFixedRate(new e(this), j, j, TimeUnit.MILLISECONDS);
            }
            if (!this.p.isEmpty()) {
                d();
            }
        }
        this.k = new WebSocketReader(fVar.c, fVar.d, this);
    }

    void a(ag agVar) {
        if (agVar.b() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + agVar.b() + " " + agVar.d() + "'");
        }
        String b = agVar.b("Connection");
        if ("Upgrade".equalsIgnoreCase(b)) {
            b = agVar.b("Upgrade");
            if ("websocket".equalsIgnoreCase(b)) {
                b = agVar.b("Sec-WebSocket-Accept");
                String b2 = ByteString.a(this.h + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").c().b();
                if (!b2.equals(b)) {
                    throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + b2 + "' but was '" + b + "'");
                }
                return;
            }
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + b + "'");
        }
        throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + b + "'");
    }

    public void a(z zVar) {
        z a = zVar.z().a(e).a();
        final int d = a.d();
        final ad a2 = this.f.e().a("Upgrade", "websocket").a("Connection", "Upgrade").a("Sec-WebSocket-Key", this.h).a("Sec-WebSocket-Version", "13").a();
        this.i = okhttp3.internal.a.a.a(a, a2);
        this.i.enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
                a.this.a((Exception) iOException, null);
            }

            public void onResponse(Call call, ag agVar) {
                try {
                    a.this.a(agVar);
                    f a = okhttp3.internal.a.a.a(call);
                    a.d();
                    f a2 = a.b().a(a);
                    try {
                        a.this.a.a(a.this, agVar);
                        a.this.a("OkHttp WebSocket " + a2.a().n(), (long) d, a2);
                        a.b().socket().setSoTimeout(0);
                        a.this.a();
                    } catch (Exception e) {
                        a.this.a(e, null);
                    }
                } catch (Exception e2) {
                    a.this.a(e2, agVar);
                    c.a((Closeable) agVar);
                }
            }
        });
    }

    synchronized boolean a(int i, String str, long j) {
        boolean z = true;
        synchronized (this) {
            g.b(i);
            ByteString byteString = null;
            if (str != null) {
                byteString = ByteString.a(str);
                if (((long) byteString.g()) > 123) {
                    throw new IllegalArgumentException("reason.size() > 123: " + str);
                }
            }
            if (this.v || this.r) {
                z = false;
            } else {
                this.r = true;
                this.p.add(new c(i, byteString, j));
                d();
            }
        }
        return z;
    }

    /* JADX WARNING: Missing block: B:15:0x0037, code:
            if (r2 == null) goto L_0x0063;
     */
    /* JADX WARNING: Missing block: B:17:?, code:
            r9.b(r2);
     */
    /* JADX WARNING: Missing block: B:18:0x003c, code:
            okhttp3.internal.c.a(r4);
     */
    /* JADX WARNING: Missing block: B:29:0x0065, code:
            if ((r3 instanceof okhttp3.internal.ws.d) == false) goto L_0x009a;
     */
    /* JADX WARNING: Missing block: B:30:0x0067, code:
            r2 = ((okhttp3.internal.ws.d) r3).b;
            r3 = okio.i.a(r9.a(((okhttp3.internal.ws.d) r3).a, (long) r2.g()));
            r3.write(r2);
            r3.close();
     */
    /* JADX WARNING: Missing block: B:31:0x0084, code:
            monitor-enter(r15);
     */
    /* JADX WARNING: Missing block: B:33:?, code:
            r15.q -= (long) r2.g();
     */
    /* JADX WARNING: Missing block: B:34:0x0090, code:
            monitor-exit(r15);
     */
    /* JADX WARNING: Missing block: B:40:0x0096, code:
            okhttp3.internal.c.a(r4);
     */
    /* JADX WARNING: Missing block: B:44:0x009c, code:
            if ((r3 instanceof okhttp3.internal.ws.c) == false) goto L_0x00af;
     */
    /* JADX WARNING: Missing block: B:45:0x009e, code:
            r3 = (okhttp3.internal.ws.c) r3;
            r9.a(r3.a, r3.b);
     */
    /* JADX WARNING: Missing block: B:46:0x00a7, code:
            if (r4 == null) goto L_0x003c;
     */
    /* JADX WARNING: Missing block: B:47:0x00a9, code:
            r15.a.b(r15, r6, r5);
     */
    /* JADX WARNING: Missing block: B:49:0x00b4, code:
            throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Missing block: B:53:?, code:
            return true;
     */
    boolean b() {
        /*
        r15 = this;
        r3 = 0;
        r8 = -1;
        r5 = 0;
        monitor-enter(r15);
        r2 = r15.v;	 Catch:{ all -> 0x0060 }
        if (r2 == 0) goto L_0x000b;
    L_0x0008:
        monitor-exit(r15);	 Catch:{ all -> 0x0060 }
        r2 = r3;
    L_0x000a:
        return r2;
    L_0x000b:
        r9 = r15.l;	 Catch:{ all -> 0x0060 }
        r2 = r15.o;	 Catch:{ all -> 0x0060 }
        r2 = r2.poll();	 Catch:{ all -> 0x0060 }
        r2 = (okio.ByteString) r2;	 Catch:{ all -> 0x0060 }
        if (r2 != 0) goto L_0x00ba;
    L_0x0017:
        r4 = r15.p;	 Catch:{ all -> 0x0060 }
        r4 = r4.poll();	 Catch:{ all -> 0x0060 }
        r6 = r4 instanceof okhttp3.internal.ws.c;	 Catch:{ all -> 0x0060 }
        if (r6 == 0) goto L_0x005b;
    L_0x0021:
        r7 = r15.t;	 Catch:{ all -> 0x0060 }
        r6 = r15.u;	 Catch:{ all -> 0x0060 }
        if (r7 == r8) goto L_0x0041;
    L_0x0027:
        r3 = r15.n;	 Catch:{ all -> 0x0060 }
        r5 = 0;
        r15.n = r5;	 Catch:{ all -> 0x0060 }
        r5 = r15.m;	 Catch:{ all -> 0x0060 }
        r5.shutdown();	 Catch:{ all -> 0x0060 }
        r5 = r6;
        r6 = r7;
        r14 = r3;
        r3 = r4;
        r4 = r14;
    L_0x0036:
        monitor-exit(r15);	 Catch:{ all -> 0x0060 }
        if (r2 == 0) goto L_0x0063;
    L_0x0039:
        r9.b(r2);	 Catch:{ all -> 0x0095 }
    L_0x003c:
        r2 = 1;
        okhttp3.internal.c.a(r4);
        goto L_0x000a;
    L_0x0041:
        r8 = r15.m;	 Catch:{ all -> 0x0060 }
        r10 = new okhttp3.internal.ws.b;	 Catch:{ all -> 0x0060 }
        r10.<init>(r15);	 Catch:{ all -> 0x0060 }
        r0 = r4;
        r0 = (okhttp3.internal.ws.c) r0;	 Catch:{ all -> 0x0060 }
        r3 = r0;
        r12 = r3.c;	 Catch:{ all -> 0x0060 }
        r3 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ all -> 0x0060 }
        r3 = r8.schedule(r10, r12, r3);	 Catch:{ all -> 0x0060 }
        r15.s = r3;	 Catch:{ all -> 0x0060 }
        r3 = r4;
        r4 = r5;
        r5 = r6;
        r6 = r7;
        goto L_0x0036;
    L_0x005b:
        if (r4 != 0) goto L_0x00b5;
    L_0x005d:
        monitor-exit(r15);	 Catch:{ all -> 0x0060 }
        r2 = r3;
        goto L_0x000a;
    L_0x0060:
        r2 = move-exception;
        monitor-exit(r15);	 Catch:{ all -> 0x0060 }
        throw r2;
    L_0x0063:
        r2 = r3 instanceof okhttp3.internal.ws.d;	 Catch:{ all -> 0x0095 }
        if (r2 == 0) goto L_0x009a;
    L_0x0067:
        r0 = r3;
        r0 = (okhttp3.internal.ws.d) r0;	 Catch:{ all -> 0x0095 }
        r2 = r0;
        r2 = r2.b;	 Catch:{ all -> 0x0095 }
        r3 = (okhttp3.internal.ws.d) r3;	 Catch:{ all -> 0x0095 }
        r3 = r3.a;	 Catch:{ all -> 0x0095 }
        r5 = r2.g();	 Catch:{ all -> 0x0095 }
        r6 = (long) r5;	 Catch:{ all -> 0x0095 }
        r3 = r9.a(r3, r6);	 Catch:{ all -> 0x0095 }
        r3 = okio.i.a(r3);	 Catch:{ all -> 0x0095 }
        r3.write(r2);	 Catch:{ all -> 0x0095 }
        r3.close();	 Catch:{ all -> 0x0095 }
        monitor-enter(r15);	 Catch:{ all -> 0x0095 }
        r6 = r15.q;	 Catch:{ all -> 0x0092 }
        r2 = r2.g();	 Catch:{ all -> 0x0092 }
        r2 = (long) r2;	 Catch:{ all -> 0x0092 }
        r2 = r6 - r2;
        r15.q = r2;	 Catch:{ all -> 0x0092 }
        monitor-exit(r15);	 Catch:{ all -> 0x0092 }
        goto L_0x003c;
    L_0x0092:
        r2 = move-exception;
        monitor-exit(r15);	 Catch:{ all -> 0x0092 }
        throw r2;	 Catch:{ all -> 0x0095 }
    L_0x0095:
        r2 = move-exception;
        okhttp3.internal.c.a(r4);
        throw r2;
    L_0x009a:
        r2 = r3 instanceof okhttp3.internal.ws.c;	 Catch:{ all -> 0x0095 }
        if (r2 == 0) goto L_0x00af;
    L_0x009e:
        r3 = (okhttp3.internal.ws.c) r3;	 Catch:{ all -> 0x0095 }
        r2 = r3.a;	 Catch:{ all -> 0x0095 }
        r3 = r3.b;	 Catch:{ all -> 0x0095 }
        r9.a(r2, r3);	 Catch:{ all -> 0x0095 }
        if (r4 == 0) goto L_0x003c;
    L_0x00a9:
        r2 = r15.a;	 Catch:{ all -> 0x0095 }
        r2.b(r15, r6, r5);	 Catch:{ all -> 0x0095 }
        goto L_0x003c;
    L_0x00af:
        r2 = new java.lang.AssertionError;	 Catch:{ all -> 0x0095 }
        r2.<init>();	 Catch:{ all -> 0x0095 }
        throw r2;	 Catch:{ all -> 0x0095 }
    L_0x00b5:
        r6 = r8;
        r3 = r4;
        r4 = r5;
        goto L_0x0036;
    L_0x00ba:
        r4 = r5;
        r6 = r8;
        r3 = r5;
        goto L_0x0036;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.a.b():boolean");
    }

    void c() {
        synchronized (this) {
            if (this.v) {
                return;
            }
            h hVar = this.l;
            try {
                hVar.a(ByteString.b);
            } catch (Exception e) {
                a(e, null);
            }
        }
    }

    public void cancel() {
        this.i.cancel();
    }

    public boolean close(int i, String str) {
        return a(i, str, 60000);
    }

    public void onReadClose(int i, String str) {
        if (i == -1) {
            throw new IllegalArgumentException();
        }
        Closeable closeable;
        synchronized (this) {
            if (this.t != -1) {
                throw new IllegalStateException("already closed");
            }
            this.t = i;
            this.u = str;
            if (this.r && this.p.isEmpty()) {
                f fVar = this.n;
                this.n = null;
                if (this.s != null) {
                    this.s.cancel(false);
                }
                this.m.shutdown();
                closeable = fVar;
            } else {
                closeable = null;
            }
        }
        try {
            this.a.a((WebSocket) this, i, str);
            if (closeable != null) {
                this.a.b(this, i, str);
            }
            c.a(closeable);
        } catch (Throwable th) {
            c.a(closeable);
        }
    }

    public void onReadMessage(String str) {
        this.a.a((WebSocket) this, str);
    }

    public void onReadMessage(ByteString byteString) {
        this.a.a((WebSocket) this, byteString);
    }

    public synchronized void onReadPing(ByteString byteString) {
        if (!(this.v || (this.r && this.p.isEmpty()))) {
            this.o.add(byteString);
            d();
            this.b++;
        }
    }

    public synchronized void onReadPong(ByteString byteString) {
        this.c++;
    }

    public synchronized long queueSize() {
        return this.q;
    }

    public ad request() {
        return this.f;
    }

    public boolean send(String str) {
        if (str != null) {
            return a(ByteString.a(str), 1);
        }
        throw new NullPointerException("text == null");
    }

    public boolean send(ByteString byteString) {
        if (byteString != null) {
            return a(byteString, 2);
        }
        throw new NullPointerException("bytes == null");
    }
}
