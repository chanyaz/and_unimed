package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call.Factory;
import okhttp3.internal.a;
import okhttp3.internal.c;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.connection.d;
import okhttp3.internal.connection.f;
import okhttp3.internal.d.b;

public class z implements Cloneable, Factory, WebSocket.Factory {
    static final List<Protocol> a = c.a(Protocol.HTTP_2, Protocol.HTTP_1_1);
    static final List<j> b = c.a(j.a, j.c);
    final int A;
    final int B;
    final int C;
    final m c;
    @Nullable
    final Proxy d;
    final List<Protocol> e;
    final List<j> f;
    final List<Interceptor> g;
    final List<Interceptor> h;
    final EventListener.Factory i;
    final ProxySelector j;
    final CookieJar k;
    @Nullable
    final b l;
    @Nullable
    final InternalCache m;
    final SocketFactory n;
    @Nullable
    final SSLSocketFactory o;
    @Nullable
    final b p;
    final HostnameVerifier q;
    final e r;
    final Authenticator s;
    final Authenticator t;
    final i u;
    final Dns v;
    final boolean w;
    final boolean x;
    final boolean y;
    final int z;

    static {
        a.a = new a() {
            public int a(ah ahVar) {
                return ahVar.c;
            }

            public Socket a(i iVar, a aVar, f fVar) {
                return iVar.a(aVar, fVar);
            }

            public Call a(z zVar, ad adVar) {
                return new ab(zVar, adVar, true);
            }

            public okhttp3.internal.connection.c a(i iVar, a aVar, f fVar, ak akVar) {
                return iVar.a(aVar, fVar, akVar);
            }

            public d a(i iVar) {
                return iVar.a;
            }

            public f a(Call call) {
                return ((ab) call).b();
            }

            public void a(j jVar, SSLSocket sSLSocket, boolean z) {
                jVar.a(sSLSocket, z);
            }

            public void a(r rVar, String str) {
                rVar.a(str);
            }

            public void a(r rVar, String str, String str2) {
                rVar.b(str, str2);
            }

            public boolean a(a aVar, a aVar2) {
                return aVar.a(aVar2);
            }

            public boolean a(i iVar, okhttp3.internal.connection.c cVar) {
                return iVar.b(cVar);
            }

            public void b(i iVar, okhttp3.internal.connection.c cVar) {
                iVar.a(cVar);
            }
        };
    }

    public z() {
        this(new aa());
    }

    z(aa aaVar) {
        this.c = aaVar.a;
        this.d = aaVar.b;
        this.e = aaVar.c;
        this.f = aaVar.d;
        this.g = c.a(aaVar.e);
        this.h = c.a(aaVar.f);
        this.i = aaVar.g;
        this.j = aaVar.h;
        this.k = aaVar.i;
        this.l = aaVar.j;
        this.m = aaVar.k;
        this.n = aaVar.l;
        Object obj = null;
        for (j a : this.f) {
            Object obj2 = (obj != null || a.a()) ? 1 : null;
            obj = obj2;
        }
        if (aaVar.m != null || obj == null) {
            this.o = aaVar.m;
            this.p = aaVar.n;
        } else {
            X509TrustManager A = A();
            this.o = a(A);
            this.p = b.a(A);
        }
        this.q = aaVar.o;
        this.r = aaVar.p.a(this.p);
        this.s = aaVar.q;
        this.t = aaVar.r;
        this.u = aaVar.s;
        this.v = aaVar.t;
        this.w = aaVar.u;
        this.x = aaVar.v;
        this.y = aaVar.w;
        this.z = aaVar.x;
        this.A = aaVar.y;
        this.B = aaVar.z;
        this.C = aaVar.A;
    }

    private X509TrustManager A() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e) {
            throw new AssertionError();
        }
    }

    private SSLSocketFactory a(X509TrustManager x509TrustManager) {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, new TrustManager[]{x509TrustManager}, null);
            return instance.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw new AssertionError();
        }
    }

    public int a() {
        return this.z;
    }

    public int b() {
        return this.A;
    }

    public int c() {
        return this.B;
    }

    public int d() {
        return this.C;
    }

    public Proxy e() {
        return this.d;
    }

    public ProxySelector f() {
        return this.j;
    }

    public CookieJar g() {
        return this.k;
    }

    InternalCache h() {
        return this.l != null ? this.l.a : this.m;
    }

    public Dns i() {
        return this.v;
    }

    public SocketFactory j() {
        return this.n;
    }

    public SSLSocketFactory k() {
        return this.o;
    }

    public HostnameVerifier l() {
        return this.q;
    }

    public e m() {
        return this.r;
    }

    public Authenticator n() {
        return this.t;
    }

    public Call newCall(ad adVar) {
        return new ab(this, adVar, false);
    }

    public WebSocket newWebSocket(ad adVar, al alVar) {
        WebSocket aVar = new okhttp3.internal.ws.a(adVar, alVar, new Random());
        aVar.a(this);
        return aVar;
    }

    public Authenticator o() {
        return this.s;
    }

    public i p() {
        return this.u;
    }

    public boolean q() {
        return this.w;
    }

    public boolean r() {
        return this.x;
    }

    public boolean s() {
        return this.y;
    }

    public m t() {
        return this.c;
    }

    public List<Protocol> u() {
        return this.e;
    }

    public List<j> v() {
        return this.f;
    }

    public List<Interceptor> w() {
        return this.g;
    }

    public List<Interceptor> x() {
        return this.h;
    }

    EventListener.Factory y() {
        return this.i;
    }

    public aa z() {
        return new aa(this);
    }
}
