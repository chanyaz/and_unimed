package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.EventListener.Factory;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.d.b;
import okhttp3.internal.d.d;

public final class aa {
    int A;
    m a;
    @Nullable
    Proxy b;
    List<Protocol> c;
    List<j> d;
    final List<Interceptor> e;
    final List<Interceptor> f;
    Factory g;
    ProxySelector h;
    CookieJar i;
    @Nullable
    b j;
    @Nullable
    InternalCache k;
    SocketFactory l;
    @Nullable
    SSLSocketFactory m;
    @Nullable
    b n;
    HostnameVerifier o;
    e p;
    Authenticator q;
    Authenticator r;
    i s;
    Dns t;
    boolean u;
    boolean v;
    boolean w;
    int x;
    int y;
    int z;

    public aa() {
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.a = new m();
        this.c = z.a;
        this.d = z.b;
        this.g = EventListener.a(EventListener.a);
        this.h = ProxySelector.getDefault();
        this.i = CookieJar.a;
        this.l = SocketFactory.getDefault();
        this.o = d.a;
        this.p = e.a;
        this.q = Authenticator.a;
        this.r = Authenticator.a;
        this.s = new i();
        this.t = Dns.a;
        this.u = true;
        this.v = true;
        this.w = true;
        this.x = 10000;
        this.y = 10000;
        this.z = 10000;
        this.A = 0;
    }

    aa(z zVar) {
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.a = zVar.c;
        this.b = zVar.d;
        this.c = zVar.e;
        this.d = zVar.f;
        this.e.addAll(zVar.g);
        this.f.addAll(zVar.h);
        this.g = zVar.i;
        this.h = zVar.j;
        this.i = zVar.k;
        this.k = zVar.m;
        this.j = zVar.l;
        this.l = zVar.n;
        this.m = zVar.o;
        this.n = zVar.p;
        this.o = zVar.q;
        this.p = zVar.r;
        this.q = zVar.s;
        this.r = zVar.t;
        this.s = zVar.u;
        this.t = zVar.v;
        this.u = zVar.w;
        this.v = zVar.x;
        this.w = zVar.y;
        this.x = zVar.z;
        this.y = zVar.A;
        this.z = zVar.B;
        this.A = zVar.C;
    }

    public aa a(List<Protocol> list) {
        List arrayList = new ArrayList(list);
        if (!arrayList.contains(Protocol.HTTP_1_1)) {
            throw new IllegalArgumentException("protocols doesn't contain http/1.1: " + arrayList);
        } else if (arrayList.contains(Protocol.HTTP_1_0)) {
            throw new IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
        } else if (arrayList.contains(null)) {
            throw new IllegalArgumentException("protocols must not contain null");
        } else {
            arrayList.remove(Protocol.SPDY_3);
            this.c = Collections.unmodifiableList(arrayList);
            return this;
        }
    }

    public aa a(Interceptor interceptor) {
        this.e.add(interceptor);
        return this;
    }

    public z a() {
        return new z(this);
    }
}
