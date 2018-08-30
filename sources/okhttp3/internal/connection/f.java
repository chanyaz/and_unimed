package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Socket;
import okhttp3.a;
import okhttp3.ak;
import okhttp3.i;
import okhttp3.internal.c;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.z;

public final class f {
    static final /* synthetic */ boolean b = (!f.class.desiredAssertionStatus());
    public final a a;
    private ak c;
    private final i d;
    private final Object e;
    private final e f;
    private int g;
    private c h;
    private boolean i;
    private boolean j;
    private HttpCodec k;

    public f(i iVar, a aVar, Object obj) {
        this.d = iVar;
        this.a = aVar;
        this.f = new e(aVar, g());
        this.e = obj;
    }

    private Socket a(boolean z, boolean z2, boolean z3) {
        if (b || Thread.holdsLock(this.d)) {
            if (z3) {
                this.k = null;
            }
            if (z2) {
                this.i = true;
            }
            if (this.h == null) {
                return null;
            }
            if (z) {
                this.h.a = true;
            }
            if (this.k != null) {
                return null;
            }
            if (!this.i && !this.h.a) {
                return null;
            }
            Socket socket;
            c(this.h);
            if (this.h.d.isEmpty()) {
                this.h.e = System.nanoTime();
                if (okhttp3.internal.a.a.a(this.d, this.h)) {
                    socket = this.h.socket();
                    this.h = null;
                    return socket;
                }
            }
            socket = null;
            this.h = null;
            return socket;
        }
        throw new AssertionError();
    }

    private c a(int i, int i2, int i3, boolean z) {
        c cVar;
        Socket socket = null;
        synchronized (this.d) {
            if (this.i) {
                throw new IllegalStateException("released");
            } else if (this.k != null) {
                throw new IllegalStateException("codec != null");
            } else if (this.j) {
                throw new IOException("Canceled");
            } else {
                cVar = this.h;
                if (cVar == null || cVar.a) {
                    okhttp3.internal.a.a.a(this.d, this.a, this, null);
                    if (this.h != null) {
                        cVar = this.h;
                    } else {
                        ak akVar = this.c;
                        if (akVar == null) {
                            akVar = this.f.b();
                        }
                        synchronized (this.d) {
                            if (this.j) {
                                throw new IOException("Canceled");
                            }
                            okhttp3.internal.a.a.a(this.d, this.a, this, akVar);
                            if (this.h != null) {
                                cVar = this.h;
                            } else {
                                this.c = akVar;
                                this.g = 0;
                                c cVar2 = new c(this.d, akVar);
                                a(cVar2);
                                cVar2.a(i, i2, i3, z);
                                g().b(cVar2.route());
                                synchronized (this.d) {
                                    okhttp3.internal.a.a.b(this.d, cVar2);
                                    if (cVar2.b()) {
                                        Socket a = okhttp3.internal.a.a.a(this.d, this.a, this);
                                        cVar = this.h;
                                        socket = a;
                                    } else {
                                        cVar = cVar2;
                                    }
                                }
                                c.a(socket);
                            }
                        }
                    }
                }
            }
        }
        return cVar;
    }

    private c a(int i, int i2, int i3, boolean z, boolean z2) {
        c a;
        while (true) {
            a = a(i, i2, i3, z);
            synchronized (this.d) {
                if (a.b != 0) {
                    if (a.a(z2)) {
                        break;
                    }
                    d();
                } else {
                    break;
                }
            }
        }
        return a;
    }

    private void c(c cVar) {
        int size = cVar.d.size();
        for (int i = 0; i < size; i++) {
            if (((Reference) cVar.d.get(i)).get() == this) {
                cVar.d.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private d g() {
        return okhttp3.internal.a.a.a(this.d);
    }

    public HttpCodec a() {
        HttpCodec httpCodec;
        synchronized (this.d) {
            httpCodec = this.k;
        }
        return httpCodec;
    }

    public HttpCodec a(z zVar, boolean z) {
        try {
            HttpCodec a = a(zVar.a(), zVar.b(), zVar.c(), zVar.s(), z).a(zVar, this);
            synchronized (this.d) {
                this.k = a;
            }
            return a;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    public void a(IOException iOException) {
        Socket a;
        boolean z = false;
        synchronized (this.d) {
            if (iOException instanceof StreamResetException) {
                StreamResetException streamResetException = (StreamResetException) iOException;
                if (streamResetException.a == ErrorCode.REFUSED_STREAM) {
                    this.g++;
                }
                if (streamResetException.a != ErrorCode.REFUSED_STREAM || this.g > 1) {
                    this.c = null;
                }
                a = a(z, false, true);
            } else {
                if (this.h != null && (!this.h.b() || (iOException instanceof ConnectionShutdownException))) {
                    if (this.h.b == 0) {
                        if (!(this.c == null || iOException == null)) {
                            this.f.a(this.c, iOException);
                        }
                        this.c = null;
                    }
                }
                a = a(z, false, true);
            }
            z = true;
            a = a(z, false, true);
        }
        c.a(a);
    }

    public void a(c cVar) {
        if (!b && !Thread.holdsLock(this.d)) {
            throw new AssertionError();
        } else if (this.h != null) {
            throw new IllegalStateException();
        } else {
            this.h = cVar;
            cVar.d.add(new g(this, this.e));
        }
    }

    public void a(boolean z, HttpCodec httpCodec) {
        Socket a;
        synchronized (this.d) {
            if (httpCodec != null) {
                if (httpCodec == this.k) {
                    if (!z) {
                        c cVar = this.h;
                        cVar.b++;
                    }
                    a = a(z, false, true);
                }
            }
            throw new IllegalStateException("expected " + this.k + " but was " + httpCodec);
        }
        c.a(a);
    }

    public Socket b(c cVar) {
        if (!b && !Thread.holdsLock(this.d)) {
            throw new AssertionError();
        } else if (this.k == null && this.h.d.size() == 1) {
            Reference reference = (Reference) this.h.d.get(0);
            Socket a = a(true, false, false);
            this.h = cVar;
            cVar.d.add(reference);
            return a;
        } else {
            throw new IllegalStateException();
        }
    }

    public synchronized c b() {
        return this.h;
    }

    public void c() {
        Socket a;
        synchronized (this.d) {
            a = a(false, true, false);
        }
        c.a(a);
    }

    public void d() {
        Socket a;
        synchronized (this.d) {
            a = a(true, false, false);
        }
        c.a(a);
    }

    public void e() {
        HttpCodec httpCodec;
        c cVar;
        synchronized (this.d) {
            this.j = true;
            httpCodec = this.k;
            cVar = this.h;
        }
        if (httpCodec != null) {
            httpCodec.cancel();
        } else if (cVar != null) {
            cVar.a();
        }
    }

    public boolean f() {
        return this.c != null || this.f.a();
    }

    public String toString() {
        c b = b();
        return b != null ? b.toString() : this.a.toString();
    }
}
