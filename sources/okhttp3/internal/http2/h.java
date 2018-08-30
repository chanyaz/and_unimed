package okhttp3.internal.http2;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.b;
import okhttp3.internal.c;
import okio.BufferedSource;
import okio.d;

public final class h implements Closeable {
    static final ExecutorService a = new ThreadPoolExecutor(0, MoPubClientPositioning.NO_REPEAT, 60, TimeUnit.SECONDS, new SynchronousQueue(), c.a("OkHttp Http2Connection", true));
    static final /* synthetic */ boolean s = (!h.class.desiredAssertionStatus());
    final boolean b;
    final j c;
    final Map<Integer, m> d = new LinkedHashMap();
    final String e;
    int f;
    int g;
    boolean h;
    final PushObserver i;
    long j = 0;
    long k;
    u l = new u();
    final u m = new u();
    boolean n = false;
    final Socket o;
    final q p;
    final k q;
    final Set<Integer> r = new LinkedHashSet();
    private final ExecutorService t;
    private Map<Integer, t> u;
    private int v;

    h(i iVar) {
        int i = 2;
        this.i = iVar.f;
        this.b = iVar.g;
        this.c = iVar.e;
        this.g = iVar.g ? 1 : 2;
        if (iVar.g) {
            this.g += 2;
        }
        if (iVar.g) {
            i = 1;
        }
        this.v = i;
        if (iVar.g) {
            this.l.a(7, 16777216);
        }
        this.e = iVar.b;
        this.t = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), c.a(c.a("OkHttp %s Push Observer", this.e), true));
        this.m.a(7, 65535);
        this.m.a(5, 16384);
        this.k = (long) this.m.d();
        this.o = iVar.a;
        this.p = new q(iVar.d, this.b);
        this.q = new k(this, new Http2Reader(iVar.c, this.b));
    }

    private m b(int i, List<a> list, boolean z) {
        m mVar;
        Object obj = null;
        boolean z2 = !z;
        synchronized (this.p) {
            int i2;
            synchronized (this) {
                if (this.h) {
                    throw new ConnectionShutdownException();
                }
                i2 = this.g;
                this.g += 2;
                mVar = new m(i2, this, z2, false, list);
                if (!z || this.k == 0 || mVar.b == 0) {
                    obj = 1;
                }
                if (mVar.b()) {
                    this.d.put(Integer.valueOf(i2), mVar);
                }
            }
            if (i == 0) {
                this.p.a(z2, i2, i, (List) list);
            } else if (this.b) {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            } else {
                this.p.a(i, i2, (List) list);
            }
        }
        if (obj != null) {
            this.p.b();
        }
        return mVar;
    }

    public synchronized int a() {
        return this.m.c(MoPubClientPositioning.NO_REPEAT);
    }

    synchronized m a(int i) {
        return (m) this.d.get(Integer.valueOf(i));
    }

    public m a(List<a> list, boolean z) {
        return b(0, list, z);
    }

    void a(int i, long j) {
        final int i2 = i;
        final long j2 = j;
        a.execute(new b("OkHttp Window Update %s stream %d", new Object[]{this.e, Integer.valueOf(i)}) {
            public void b() {
                try {
                    h.this.p.a(i2, j2);
                } catch (IOException e) {
                }
            }
        });
    }

    void a(int i, List<a> list) {
        synchronized (this) {
            if (this.r.contains(Integer.valueOf(i))) {
                a(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.r.add(Integer.valueOf(i));
            final int i2 = i;
            final List<a> list2 = list;
            this.t.execute(new b("OkHttp %s Push Request[%s]", new Object[]{this.e, Integer.valueOf(i)}) {
                public void b() {
                    if (h.this.i.onRequest(i2, list2)) {
                        try {
                            h.this.p.a(i2, ErrorCode.CANCEL);
                            synchronized (h.this) {
                                h.this.r.remove(Integer.valueOf(i2));
                            }
                        } catch (IOException e) {
                        }
                    }
                }
            });
        }
    }

    void a(int i, List<a> list, boolean z) {
        final int i2 = i;
        final List<a> list2 = list;
        final boolean z2 = z;
        this.t.execute(new b("OkHttp %s Push Headers[%s]", new Object[]{this.e, Integer.valueOf(i)}) {
            public void b() {
                boolean onHeaders = h.this.i.onHeaders(i2, list2, z2);
                if (onHeaders) {
                    try {
                        h.this.p.a(i2, ErrorCode.CANCEL);
                    } catch (IOException e) {
                        return;
                    }
                }
                if (onHeaders || z2) {
                    synchronized (h.this) {
                        h.this.r.remove(Integer.valueOf(i2));
                    }
                }
            }
        });
    }

    void a(int i, ErrorCode errorCode) {
        final int i2 = i;
        final ErrorCode errorCode2 = errorCode;
        a.execute(new b("OkHttp %s stream %d", new Object[]{this.e, Integer.valueOf(i)}) {
            public void b() {
                try {
                    h.this.b(i2, errorCode2);
                } catch (IOException e) {
                }
            }
        });
    }

    void a(int i, BufferedSource bufferedSource, int i2, boolean z) {
        final d dVar = new d();
        bufferedSource.require((long) i2);
        bufferedSource.read(dVar, (long) i2);
        if (dVar.a() != ((long) i2)) {
            throw new IOException(dVar.a() + " != " + i2);
        }
        final int i3 = i;
        final int i4 = i2;
        final boolean z2 = z;
        this.t.execute(new b("OkHttp %s Push Data[%s]", new Object[]{this.e, Integer.valueOf(i)}) {
            public void b() {
                try {
                    boolean onData = h.this.i.onData(i3, dVar, i4, z2);
                    if (onData) {
                        h.this.p.a(i3, ErrorCode.CANCEL);
                    }
                    if (onData || z2) {
                        synchronized (h.this) {
                            h.this.r.remove(Integer.valueOf(i3));
                        }
                    }
                } catch (IOException e) {
                }
            }
        });
    }

    public void a(int i, boolean z, d dVar, long j) {
        if (j == 0) {
            this.p.a(z, i, dVar, 0);
            return;
        }
        while (j > 0) {
            int min;
            synchronized (this) {
                while (this.k <= 0) {
                    try {
                        if (this.d.containsKey(Integer.valueOf(i))) {
                            wait();
                        } else {
                            throw new IOException("stream closed");
                        }
                    } catch (InterruptedException e) {
                        throw new InterruptedIOException();
                    }
                }
                min = Math.min((int) Math.min(j, this.k), this.p.c());
                this.k -= (long) min;
            }
            j -= (long) min;
            q qVar = this.p;
            boolean z2 = z && j == 0;
            qVar.a(z2, i, dVar, min);
        }
    }

    void a(long j) {
        this.k += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void a(ErrorCode errorCode) {
        synchronized (this.p) {
            synchronized (this) {
                if (this.h) {
                    return;
                }
                this.h = true;
                int i = this.f;
                this.p.a(i, errorCode, c.a);
            }
        }
    }

    void a(ErrorCode errorCode, ErrorCode errorCode2) {
        IOException e;
        if (s || !Thread.holdsLock(this)) {
            IOException iOException;
            m[] mVarArr;
            t[] tVarArr;
            try {
                a(errorCode);
                iOException = null;
            } catch (IOException e2) {
                iOException = e2;
            }
            synchronized (this) {
                if (this.d.isEmpty()) {
                    mVarArr = null;
                } else {
                    m[] mVarArr2 = (m[]) this.d.values().toArray(new m[this.d.size()]);
                    this.d.clear();
                    mVarArr = mVarArr2;
                }
                if (this.u != null) {
                    t[] tVarArr2 = (t[]) this.u.values().toArray(new t[this.u.size()]);
                    this.u = null;
                    tVarArr = tVarArr2;
                } else {
                    tVarArr = null;
                }
            }
            if (mVarArr != null) {
                e2 = iOException;
                for (m a : mVarArr) {
                    try {
                        a.a(errorCode2);
                    } catch (IOException iOException2) {
                        if (e2 != null) {
                            e2 = iOException2;
                        }
                    }
                }
                iOException2 = e2;
            }
            if (tVarArr != null) {
                for (t c : tVarArr) {
                    c.c();
                }
            }
            try {
                this.p.close();
                e2 = iOException2;
            } catch (IOException e3) {
                e2 = e3;
                if (iOException2 != null) {
                    e2 = iOException2;
                }
            }
            try {
                this.o.close();
            } catch (IOException e4) {
                e2 = e4;
            }
            if (e2 != null) {
                throw e2;
            }
            return;
        }
        throw new AssertionError();
    }

    void a(boolean z) {
        if (z) {
            this.p.a();
            this.p.b(this.l);
            int d = this.l.d();
            if (d != 65535) {
                this.p.a(0, (long) (d - 65535));
            }
        }
        new Thread(this.q).start();
    }

    void a(boolean z, int i, int i2, t tVar) {
        final boolean z2 = z;
        final int i3 = i;
        final int i4 = i2;
        final t tVar2 = tVar;
        a.execute(new b("OkHttp %s ping %08x%08x", new Object[]{this.e, Integer.valueOf(i), Integer.valueOf(i2)}) {
            public void b() {
                try {
                    h.this.b(z2, i3, i4, tVar2);
                } catch (IOException e) {
                }
            }
        });
    }

    synchronized m b(int i) {
        m mVar;
        mVar = (m) this.d.remove(Integer.valueOf(i));
        notifyAll();
        return mVar;
    }

    public void b() {
        this.p.b();
    }

    void b(int i, ErrorCode errorCode) {
        this.p.a(i, errorCode);
    }

    void b(boolean z, int i, int i2, t tVar) {
        synchronized (this.p) {
            if (tVar != null) {
                tVar.a();
            }
            this.p.a(z, i, i2);
        }
    }

    synchronized t c(int i) {
        return this.u != null ? (t) this.u.remove(Integer.valueOf(i)) : null;
    }

    public void c() {
        a(true);
    }

    void c(int i, ErrorCode errorCode) {
        final int i2 = i;
        final ErrorCode errorCode2 = errorCode;
        this.t.execute(new b("OkHttp %s Push Reset[%s]", new Object[]{this.e, Integer.valueOf(i)}) {
            public void b() {
                h.this.i.onReset(i2, errorCode2);
                synchronized (h.this) {
                    h.this.r.remove(Integer.valueOf(i2));
                }
            }
        });
    }

    public void close() {
        a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    public synchronized boolean d() {
        return this.h;
    }

    boolean d(int i) {
        return i != 0 && (i & 1) == 0;
    }
}
