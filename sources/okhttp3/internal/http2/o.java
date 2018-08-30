package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import okio.BufferedSource;
import okio.Source;
import okio.d;
import okio.p;

final class o implements Source {
    static final /* synthetic */ boolean c = (!m.class.desiredAssertionStatus());
    boolean a;
    boolean b;
    final /* synthetic */ m d;
    private final d e = new d();
    private final d f = new d();
    private final long g;

    o(m mVar, long j) {
        this.d = mVar;
        this.g = j;
    }

    private void a() {
        this.d.f.c();
        while (this.f.a() == 0 && !this.b && !this.a && this.d.h == null) {
            try {
                this.d.l();
            } catch (Throwable th) {
                this.d.f.b();
            }
        }
        this.d.f.b();
    }

    private void b() {
        if (this.a) {
            throw new IOException("stream closed");
        } else if (this.d.h != null) {
            throw new StreamResetException(this.d.h);
        }
    }

    void a(BufferedSource bufferedSource, long j) {
        if (c || !Thread.holdsLock(this.d)) {
            while (j > 0) {
                boolean z;
                Object obj;
                synchronized (this.d) {
                    z = this.b;
                    obj = this.f.a() + j > this.g ? 1 : null;
                }
                if (obj != null) {
                    bufferedSource.skip(j);
                    this.d.b(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    bufferedSource.skip(j);
                    return;
                } else {
                    long read = bufferedSource.read(this.e, j);
                    if (read == -1) {
                        throw new EOFException();
                    }
                    j -= read;
                    synchronized (this.d) {
                        obj = this.f.a() == 0 ? 1 : null;
                        this.f.writeAll(this.e);
                        if (obj != null) {
                            this.d.notifyAll();
                        }
                    }
                }
            }
            return;
        }
        throw new AssertionError();
    }

    public void close() {
        synchronized (this.d) {
            this.a = true;
            this.f.d();
            this.d.notifyAll();
        }
        this.d.j();
    }

    public long read(d dVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        long j2;
        synchronized (this.d) {
            a();
            b();
            if (this.f.a() == 0) {
                j2 = -1;
            } else {
                j2 = this.f.read(dVar, Math.min(j, this.f.a()));
                m mVar = this.d;
                mVar.a += j2;
                if (this.d.a >= ((long) (this.d.d.l.d() / 2))) {
                    this.d.d.a(this.d.c, this.d.a);
                    this.d.a = 0;
                }
                synchronized (this.d.d) {
                    h hVar = this.d.d;
                    hVar.j += j2;
                    if (this.d.d.j >= ((long) (this.d.d.l.d() / 2))) {
                        this.d.d.a(0, this.d.d.j);
                        this.d.d.j = 0;
                    }
                }
            }
        }
        return j2;
    }

    public p timeout() {
        return this.d.f;
    }
}
