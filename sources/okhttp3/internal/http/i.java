package okhttp3.internal.http;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy.Type;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.a;
import okhttp3.ad;
import okhttp3.ae;
import okhttp3.af;
import okhttp3.ag;
import okhttp3.ak;
import okhttp3.e;
import okhttp3.internal.c;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.f;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.s;
import okhttp3.z;

public final class i implements Interceptor {
    private final z a;
    private final boolean b;
    private f c;
    private Object d;
    private volatile boolean e;

    public i(z zVar, boolean z) {
        this.a = zVar;
        this.b = z;
    }

    private a a(s sVar) {
        SSLSocketFactory k;
        HostnameVerifier l;
        e eVar = null;
        if (sVar.c()) {
            k = this.a.k();
            l = this.a.l();
            eVar = this.a.m();
        } else {
            l = null;
            k = null;
        }
        return new a(sVar.f(), sVar.g(), this.a.i(), this.a.j(), k, l, eVar, this.a.o(), this.a.e(), this.a.u(), this.a.v(), this.a.f());
    }

    private ad a(ag agVar) {
        af afVar = null;
        if (agVar == null) {
            throw new IllegalStateException();
        }
        Connection b = this.c.b();
        ak route = b != null ? b.route() : null;
        int b2 = agVar.b();
        String b3 = agVar.a().b();
        switch (b2) {
            case 300:
            case 301:
            case 302:
            case 303:
                break;
            case 307:
            case 308:
                if (!(b3.equals("GET") || b3.equals("HEAD"))) {
                    return null;
                }
            case 401:
                return this.a.n().authenticate(route, agVar);
            case 407:
                if ((route != null ? route.b() : this.a.e()).type() == Type.HTTP) {
                    return this.a.o().authenticate(route, agVar);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            case 408:
                return !(agVar.a().d() instanceof UnrepeatableRequestBody) ? agVar.a() : null;
            default:
                return null;
        }
        if (!this.a.r()) {
            return null;
        }
        String b4 = agVar.b("Location");
        if (b4 == null) {
            return null;
        }
        s c = agVar.a().a().c(b4);
        if (c == null) {
            return null;
        }
        if (!c.b().equals(agVar.a().a().b()) && !this.a.q()) {
            return null;
        }
        ae e = agVar.a().e();
        if (e.c(b3)) {
            boolean d = e.d(b3);
            if (e.e(b3)) {
                e.a("GET", null);
            } else {
                if (d) {
                    afVar = agVar.a().d();
                }
                e.a(b3, afVar);
            }
            if (!d) {
                e.a("Transfer-Encoding");
                e.a("Content-Length");
                e.a("Content-Type");
            }
        }
        if (!a(agVar, c)) {
            e.a("Authorization");
        }
        return e.a(c).a();
    }

    private boolean a(IOException iOException, boolean z) {
        boolean z2 = true;
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (!(iOException instanceof InterruptedIOException)) {
            return (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
        } else {
            if (!(iOException instanceof SocketTimeoutException) || z) {
                z2 = false;
            }
            return z2;
        }
    }

    private boolean a(IOException iOException, boolean z, ad adVar) {
        this.c.a(iOException);
        return !this.a.s() ? false : !(z && (adVar.d() instanceof UnrepeatableRequestBody)) && a(iOException, z) && this.c.f();
    }

    private boolean a(ag agVar, s sVar) {
        s a = agVar.a().a();
        return a.f().equals(sVar.f()) && a.g() == sVar.g() && a.b().equals(sVar.b());
    }

    public void a() {
        this.e = true;
        f fVar = this.c;
        if (fVar != null) {
            fVar.e();
        }
    }

    public void a(Object obj) {
        this.d = obj;
    }

    public boolean b() {
        return this.e;
    }

    public f c() {
        return this.c;
    }

    public ag intercept(Chain chain) {
        ad request = chain.request();
        this.c = new f(this.a.p(), a(request.a()), this.d);
        ag agVar = null;
        int i = 0;
        ad adVar = request;
        while (!this.e) {
            try {
                ag a = ((f) chain).a(adVar, this.c, null, null);
                if (agVar != null) {
                    a = a.h().c(agVar.h().a(null).a()).a();
                }
                adVar = a(a);
                if (adVar == null) {
                    if (!this.b) {
                        this.c.c();
                    }
                    return a;
                }
                c.a(a.g());
                int i2 = i + 1;
                if (i2 > 20) {
                    this.c.c();
                    throw new ProtocolException("Too many follow-up requests: " + i2);
                } else if (adVar.d() instanceof UnrepeatableRequestBody) {
                    this.c.c();
                    throw new HttpRetryException("Cannot retry streamed HTTP body", a.b());
                } else {
                    if (!a(a, adVar.a())) {
                        this.c.c();
                        this.c = new f(this.a.p(), a(adVar.a()), this.d);
                    } else if (this.c.a() != null) {
                        throw new IllegalStateException("Closing the body of " + a + " didn't close its backing stream. Bad interceptor?");
                    }
                    i = i2;
                    agVar = a;
                }
            } catch (RouteException e) {
                if (!a(e.a(), false, adVar)) {
                    throw e.a();
                }
            } catch (IOException e2) {
                if (!a(e2, !(e2 instanceof ConnectionShutdownException), adVar)) {
                    throw e2;
                }
            } catch (Throwable th) {
                this.c.a(null);
                this.c.c();
            }
        }
        this.c.c();
        throw new IOException("Canceled");
    }
}
