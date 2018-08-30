package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class a extends p {
    private static final long a = TimeUnit.SECONDS.toMillis(60);
    @Nullable
    static a b;
    private static final long d = TimeUnit.MILLISECONDS.toNanos(a);
    private boolean e;
    @Nullable
    private a f;
    private long g;

    private static synchronized void a(a aVar, long j, boolean z) {
        synchronized (a.class) {
            if (b == null) {
                b = new a();
                new b().start();
            }
            long nanoTime = System.nanoTime();
            if (j != 0 && z) {
                aVar.g = Math.min(j, aVar.d() - nanoTime) + nanoTime;
            } else if (j != 0) {
                aVar.g = nanoTime + j;
            } else if (z) {
                aVar.g = aVar.d();
            } else {
                throw new AssertionError();
            }
            long b = aVar.b(nanoTime);
            a aVar2 = b;
            while (aVar2.f != null && b >= aVar2.f.b(nanoTime)) {
                aVar2 = aVar2.f;
            }
            aVar.f = aVar2.f;
            aVar2.f = aVar;
            if (aVar2 == b) {
                a.class.notify();
            }
        }
    }

    private static synchronized boolean a(a aVar) {
        boolean z;
        synchronized (a.class) {
            for (a aVar2 = b; aVar2 != null; aVar2 = aVar2.f) {
                if (aVar2.f == aVar) {
                    aVar2.f = aVar.f;
                    aVar.f = null;
                    z = false;
                    break;
                }
            }
            z = true;
        }
        return z;
    }

    private long b(long j) {
        return this.g - j;
    }

    @Nullable
    static a e() {
        a aVar = b.f;
        long nanoTime;
        if (aVar == null) {
            nanoTime = System.nanoTime();
            a.class.wait(a);
            return (b.f != null || System.nanoTime() - nanoTime < d) ? null : b;
        } else {
            nanoTime = aVar.b(System.nanoTime());
            if (nanoTime > 0) {
                long j = nanoTime / 1000000;
                a.class.wait(j, (int) (nanoTime - (1000000 * j)));
                return null;
            }
            b.f = aVar.f;
            aVar.f = null;
            return aVar;
        }
    }

    protected IOException a(@Nullable IOException iOException) {
        IOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final Sink a(final Sink sink) {
        return new Sink() {
            public void close() {
                a.this.c();
                try {
                    sink.close();
                    a.this.a(true);
                } catch (IOException e) {
                    throw a.this.b(e);
                } catch (Throwable th) {
                    a.this.a(false);
                }
            }

            public void flush() {
                a.this.c();
                try {
                    sink.flush();
                    a.this.a(true);
                } catch (IOException e) {
                    throw a.this.b(e);
                } catch (Throwable th) {
                    a.this.a(false);
                }
            }

            public p timeout() {
                return a.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + sink + ")";
            }

            public void write(d dVar, long j) {
                q.a(dVar.b, 0, j);
                long j2 = j;
                while (j2 > 0) {
                    m mVar = dVar.a;
                    long j3 = 0;
                    while (j3 < 65536) {
                        long j4 = ((long) (dVar.a.c - dVar.a.b)) + j3;
                        if (j4 >= j2) {
                            j3 = j2;
                            break;
                        } else {
                            mVar = mVar.f;
                            j3 = j4;
                        }
                    }
                    a.this.c();
                    try {
                        sink.write(dVar, j3);
                        j2 -= j3;
                        a.this.a(true);
                    } catch (IOException e) {
                        throw a.this.b(e);
                    } catch (Throwable th) {
                        a.this.a(false);
                    }
                }
            }
        };
    }

    public final Source a(final Source source) {
        return new Source() {
            public void close() {
                try {
                    source.close();
                    a.this.a(true);
                } catch (IOException e) {
                    throw a.this.b(e);
                } catch (Throwable th) {
                    a.this.a(false);
                }
            }

            public long read(d dVar, long j) {
                a.this.c();
                try {
                    long read = source.read(dVar, j);
                    a.this.a(true);
                    return read;
                } catch (IOException e) {
                    throw a.this.b(e);
                } catch (Throwable th) {
                    a.this.a(false);
                }
            }

            public p timeout() {
                return a.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + source + ")";
            }
        };
    }

    protected void a() {
    }

    final void a(boolean z) {
        if (k_() && z) {
            throw a(null);
        }
    }

    final IOException b(IOException iOException) {
        return !k_() ? iOException : a(iOException);
    }

    public final void c() {
        if (this.e) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long l_ = l_();
        boolean m_ = m_();
        if (l_ != 0 || m_) {
            this.e = true;
            a(this, l_, m_);
        }
    }

    public final boolean k_() {
        if (!this.e) {
            return false;
        }
        this.e = false;
        return a(this);
    }
}
