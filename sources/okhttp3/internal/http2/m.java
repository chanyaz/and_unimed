package okhttp3.internal.http2;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.p;

public final class m {
    static final /* synthetic */ boolean i = (!m.class.desiredAssertionStatus());
    long a = 0;
    long b;
    final int c;
    final h d;
    final n e;
    final p f = new p(this);
    final p g = new p(this);
    ErrorCode h = null;
    private final List<a> j;
    private List<a> k;
    private boolean l;
    private final o m;

    m(int i, h hVar, boolean z, boolean z2, List<a> list) {
        if (hVar == null) {
            throw new NullPointerException("connection == null");
        } else if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        } else {
            this.c = i;
            this.d = hVar;
            this.b = (long) hVar.m.d();
            this.m = new o(this, (long) hVar.l.d());
            this.e = new n(this);
            this.m.b = z2;
            this.e.b = z;
            this.j = list;
        }
    }

    private boolean d(ErrorCode errorCode) {
        if (i || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.h != null) {
                    return false;
                } else if (this.m.b && this.e.b) {
                    return false;
                } else {
                    this.h = errorCode;
                    notifyAll();
                    this.d.b(this.c);
                    return true;
                }
            }
        }
        throw new AssertionError();
    }

    public int a() {
        return this.c;
    }

    void a(long j) {
        this.b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    void a(List<a> list) {
        boolean z = true;
        if (i || !Thread.holdsLock(this)) {
            synchronized (this) {
                this.l = true;
                if (this.k == null) {
                    this.k = list;
                    z = b();
                    notifyAll();
                } else {
                    List arrayList = new ArrayList();
                    arrayList.addAll(this.k);
                    arrayList.add(null);
                    arrayList.addAll(list);
                    this.k = arrayList;
                }
            }
            if (!z) {
                this.d.b(this.c);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    public void a(ErrorCode errorCode) {
        if (d(errorCode)) {
            this.d.b(this.c, errorCode);
        }
    }

    void a(BufferedSource bufferedSource, int i) {
        if (i || !Thread.holdsLock(this)) {
            this.m.a(bufferedSource, (long) i);
            return;
        }
        throw new AssertionError();
    }

    public void b(ErrorCode errorCode) {
        if (d(errorCode)) {
            this.d.a(this.c, errorCode);
        }
    }

    public synchronized boolean b() {
        boolean z = false;
        synchronized (this) {
            if (this.h == null) {
                if (!((this.m.b || this.m.a) && ((this.e.b || this.e.a) && this.l))) {
                    z = true;
                }
            }
        }
        return z;
    }

    synchronized void c(ErrorCode errorCode) {
        if (this.h == null) {
            this.h = errorCode;
            notifyAll();
        }
    }

    public boolean c() {
        return this.d.b == ((this.c & 1) == 1);
    }

    public synchronized List<a> d() {
        List<a> list;
        if (c()) {
            this.f.c();
            while (this.k == null && this.h == null) {
                try {
                    l();
                } catch (Throwable th) {
                    this.f.b();
                }
            }
            this.f.b();
            list = this.k;
            if (list != null) {
                this.k = null;
            } else {
                throw new StreamResetException(this.h);
            }
        }
        throw new IllegalStateException("servers cannot read response headers");
        return list;
    }

    public p e() {
        return this.f;
    }

    public p f() {
        return this.g;
    }

    public Source g() {
        return this.m;
    }

    public Sink h() {
        synchronized (this) {
            if (this.l || c()) {
            } else {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.e;
    }

    void i() {
        if (i || !Thread.holdsLock(this)) {
            boolean b;
            synchronized (this) {
                this.m.b = true;
                b = b();
                notifyAll();
            }
            if (!b) {
                this.d.b(this.c);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    void j() {
        if (i || !Thread.holdsLock(this)) {
            Object obj;
            boolean b;
            synchronized (this) {
                obj = (!this.m.b && this.m.a && (this.e.b || this.e.a)) ? 1 : null;
                b = b();
            }
            if (obj != null) {
                a(ErrorCode.CANCEL);
                return;
            } else if (!b) {
                this.d.b(this.c);
                return;
            } else {
                return;
            }
        }
        throw new AssertionError();
    }

    void k() {
        if (this.e.a) {
            throw new IOException("stream closed");
        } else if (this.e.b) {
            throw new IOException("stream finished");
        } else if (this.h != null) {
            throw new StreamResetException(this.h);
        }
    }

    void l() {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new InterruptedIOException();
        }
    }
}
