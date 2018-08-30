package okhttp3.internal.connection;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import okhttp3.Connection;
import okhttp3.Protocol;
import okhttp3.ad;
import okhttp3.ae;
import okhttp3.ag;
import okhttp3.ak;
import okhttp3.e;
import okhttp3.i;
import okhttp3.internal.a.a;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.d;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.f;
import okhttp3.internal.http2.h;
import okhttp3.internal.http2.j;
import okhttp3.internal.http2.m;
import okhttp3.p;
import okhttp3.s;
import okhttp3.z;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Source;

public final class c extends j implements Connection {
    public boolean a;
    public int b;
    public int c = 1;
    public final List<Reference<f>> d = new ArrayList();
    public long e = Long.MAX_VALUE;
    private final i g;
    private final ak h;
    private Socket i;
    private Socket j;
    private p k;
    private Protocol l;
    private h m;
    private BufferedSource n;
    private BufferedSink o;

    public c(i iVar, ak akVar) {
        this.g = iVar;
        this.h = akVar;
    }

    private ad a(int i, int i2, ad adVar, s sVar) {
        String str = "CONNECT " + okhttp3.internal.c.a(sVar, true) + " HTTP/1.1";
        ag a;
        do {
            a aVar = new a(null, null, this.n, this.o);
            this.n.timeout().a((long) i, TimeUnit.MILLISECONDS);
            this.o.timeout().a((long) i2, TimeUnit.MILLISECONDS);
            aVar.a(adVar.c(), str);
            aVar.finishRequest();
            a = aVar.readResponseHeaders(false).a(adVar).a();
            long a2 = d.a(a);
            if (a2 == -1) {
                a2 = 0;
            }
            Source b = aVar.b(a2);
            okhttp3.internal.c.b(b, (int) MoPubClientPositioning.NO_REPEAT, TimeUnit.MILLISECONDS);
            b.close();
            switch (a.b()) {
                case 200:
                    if (this.n.buffer().exhausted() && this.o.buffer().exhausted()) {
                        return null;
                    }
                    throw new IOException("TLS tunnel buffered too many bytes!");
                case 407:
                    adVar = this.h.a().d().authenticate(this.h, a);
                    if (adVar != null) {
                        break;
                    }
                    throw new IOException("Failed to authenticate with proxy");
                default:
                    throw new IOException("Unexpected response code for CONNECT: " + a.b());
            }
        } while (!"close".equalsIgnoreCase(a.b("Connection")));
        return adVar;
    }

    private void a(int i, int i2) {
        Proxy b = this.h.b();
        Socket createSocket = (b.type() == Type.DIRECT || b.type() == Type.HTTP) ? this.h.a().c().createSocket() : new Socket(b);
        this.i = createSocket;
        this.i.setSoTimeout(i2);
        try {
            okhttp3.internal.b.h.b().a(this.i, this.h.c(), i);
            try {
                this.n = okio.i.a(okio.i.b(this.i));
                this.o = okio.i.a(okio.i.a(this.i));
            } catch (Throwable e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (Throwable e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.h.c());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private void a(int i, int i2, int i3) {
        ad c = c();
        s a = c.a();
        int i4 = 0;
        while (true) {
            i4++;
            if (i4 > 21) {
                throw new ProtocolException("Too many tunnel connections attempted: " + 21);
            }
            a(i, i2);
            c = a(i2, i3, c, a);
            if (c != null) {
                okhttp3.internal.c.a(this.i);
                this.i = null;
                this.o = null;
                this.n = null;
            } else {
                return;
            }
        }
    }

    private void a(b bVar) {
        if (this.h.a().i() == null) {
            this.l = Protocol.HTTP_1_1;
            this.j = this.i;
            return;
        }
        b(bVar);
        if (this.l == Protocol.HTTP_2) {
            this.j.setSoTimeout(0);
            this.m = new okhttp3.internal.http2.i(true).a(this.j, this.h.a().a().f(), this.n, this.o).a(this).a();
            this.m.c();
        }
    }

    private void b(b bVar) {
        Throwable th;
        Socket socket;
        AssertionError e;
        Throwable th2;
        String str = null;
        okhttp3.a a = this.h.a();
        try {
            Socket socket2 = (SSLSocket) a.i().createSocket(this.i, a.a().f(), a.a().g(), true);
            try {
                okhttp3.j a2 = bVar.a((SSLSocket) socket2);
                if (a2.d()) {
                    okhttp3.internal.b.h.b().a((SSLSocket) socket2, a.a().f(), a.e());
                }
                socket2.startHandshake();
                p a3 = p.a(socket2.getSession());
                if (a.j().verify(a.a().f(), socket2.getSession())) {
                    a.k().a(a.a().f(), a3.b());
                    if (a2.d()) {
                        str = okhttp3.internal.b.h.b().a((SSLSocket) socket2);
                    }
                    this.j = socket2;
                    this.n = okio.i.a(okio.i.b(this.j));
                    this.o = okio.i.a(okio.i.a(this.j));
                    this.k = a3;
                    this.l = str != null ? Protocol.a(str) : Protocol.HTTP_1_1;
                    if (socket2 != null) {
                        okhttp3.internal.b.h.b().b((SSLSocket) socket2);
                        return;
                    }
                    return;
                }
                Certificate certificate = (X509Certificate) a3.b().get(0);
                throw new SSLPeerUnverifiedException("Hostname " + a.a().f() + " not verified:\n    certificate: " + e.a(certificate) + "\n    DN: " + certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + okhttp3.internal.d.d.a(certificate));
            } catch (Throwable e2) {
                th = e2;
                socket = socket2;
                e = th;
            } catch (Throwable e22) {
                th = e22;
                socket = socket2;
                th2 = th;
                if (socket != null) {
                    okhttp3.internal.b.h.b().b((SSLSocket) socket);
                }
                okhttp3.internal.c.a(socket);
                throw th2;
            }
        } catch (AssertionError e3) {
            e = e3;
            try {
                if (okhttp3.internal.c.a(e)) {
                    throw new IOException(e);
                }
                throw e;
            } catch (Throwable th3) {
                th2 = th3;
            }
        }
    }

    private ad c() {
        return new ae().a(this.h.a().a()).a("Host", okhttp3.internal.c.a(this.h.a().a(), true)).a("Proxy-Connection", "Keep-Alive").a("User-Agent", okhttp3.internal.d.a()).a();
    }

    public HttpCodec a(z zVar, f fVar) {
        if (this.m != null) {
            return new f(zVar, fVar, this.m);
        }
        this.j.setSoTimeout(zVar.b());
        this.n.timeout().a((long) zVar.b(), TimeUnit.MILLISECONDS);
        this.o.timeout().a((long) zVar.c(), TimeUnit.MILLISECONDS);
        return new a(zVar, fVar, this.n, this.o);
    }

    public okhttp3.internal.ws.f a(f fVar) {
        final f fVar2 = fVar;
        return new okhttp3.internal.ws.f(true, this.n, this.o) {
            public void close() {
                fVar2.a(true, fVar2.a());
            }
        };
    }

    public void a() {
        okhttp3.internal.c.a(this.i);
    }

    public void a(int i, int i2, int i3, boolean z) {
        if (this.l != null) {
            throw new IllegalStateException("already connected");
        }
        List f = this.h.a().f();
        b bVar = new b(f);
        if (this.h.a().i() == null) {
            if (f.contains(okhttp3.j.c)) {
                String f2 = this.h.a().a().f();
                if (!okhttp3.internal.b.h.b().b(f2)) {
                    throw new RouteException(new UnknownServiceException("CLEARTEXT communication to " + f2 + " not permitted by network security policy"));
                }
            }
            throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
        }
        RouteException routeException = null;
        do {
            try {
                if (this.h.d()) {
                    a(i, i2, i3);
                } else {
                    a(i, i2);
                }
                a(bVar);
                if (this.m != null) {
                    synchronized (this.g) {
                        this.c = this.m.a();
                    }
                    return;
                }
                return;
            } catch (IOException e) {
                okhttp3.internal.c.a(this.j);
                okhttp3.internal.c.a(this.i);
                this.j = null;
                this.i = null;
                this.n = null;
                this.o = null;
                this.k = null;
                this.l = null;
                this.m = null;
                if (routeException == null) {
                    routeException = new RouteException(e);
                } else {
                    routeException.a(e);
                }
                if (!z) {
                    break;
                } else if (!bVar.a(e)) {
                }
                throw routeException;
            }
        } while (bVar.a(e));
        throw routeException;
    }

    public void a(h hVar) {
        synchronized (this.g) {
            this.c = hVar.a();
        }
    }

    public void a(m mVar) {
        mVar.a(ErrorCode.REFUSED_STREAM);
    }

    public boolean a(okhttp3.a aVar, @Nullable ak akVar) {
        if (this.d.size() >= this.c || this.a || !okhttp3.internal.a.a.a(this.h.a(), aVar)) {
            return false;
        }
        if (aVar.a().f().equals(route().a().a().f())) {
            return true;
        }
        if (this.m == null || akVar == null || akVar.b().type() != Type.DIRECT || this.h.b().type() != Type.DIRECT || !this.h.c().equals(akVar.c()) || akVar.a().j() != okhttp3.internal.d.d.a || !a(aVar.a())) {
            return false;
        }
        try {
            aVar.k().a(aVar.a().f(), handshake().b());
            return true;
        } catch (SSLPeerUnverifiedException e) {
            return false;
        }
    }

    public boolean a(s sVar) {
        if (sVar.g() != this.h.a().a().g()) {
            return false;
        }
        if (sVar.f().equals(this.h.a().a().f())) {
            return true;
        }
        boolean z = this.k != null && okhttp3.internal.d.d.a.a(sVar.f(), (X509Certificate) this.k.b().get(0));
        return z;
    }

    public boolean a(boolean z) {
        if (this.j.isClosed() || this.j.isInputShutdown() || this.j.isOutputShutdown()) {
            return false;
        }
        if (this.m != null) {
            return !this.m.d();
        } else {
            if (!z) {
                return true;
            }
            int soTimeout;
            try {
                soTimeout = this.j.getSoTimeout();
                this.j.setSoTimeout(1);
                if (this.n.exhausted()) {
                    this.j.setSoTimeout(soTimeout);
                    return false;
                }
                this.j.setSoTimeout(soTimeout);
                return true;
            } catch (SocketTimeoutException e) {
                return true;
            } catch (IOException e2) {
                return false;
            } catch (Throwable th) {
                this.j.setSoTimeout(soTimeout);
            }
        }
    }

    public boolean b() {
        return this.m != null;
    }

    public p handshake() {
        return this.k;
    }

    public Protocol protocol() {
        return this.l;
    }

    public ak route() {
        return this.h;
    }

    public Socket socket() {
        return this.j;
    }

    public String toString() {
        return "Connection{" + this.h.a().a().f() + ":" + this.h.a().a().g() + ", proxy=" + this.h.b() + " hostAddress=" + this.h.c() + " cipherSuite=" + (this.k != null ? this.k.a() : "none") + " protocol=" + this.l + '}';
    }
}
