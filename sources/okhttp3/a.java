package okhttp3;

import com.mopub.common.Constants;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.internal.c;

public final class a {
    final s a;
    final Dns b;
    final SocketFactory c;
    final Authenticator d;
    final List<Protocol> e;
    final List<j> f;
    final ProxySelector g;
    @Nullable
    final Proxy h;
    @Nullable
    final SSLSocketFactory i;
    @Nullable
    final HostnameVerifier j;
    @Nullable
    final e k;

    public a(String str, int i, Dns dns, SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable e eVar, Authenticator authenticator, @Nullable Proxy proxy, List<Protocol> list, List<j> list2, ProxySelector proxySelector) {
        this.a = new t().a(sSLSocketFactory != null ? Constants.HTTPS : Constants.HTTP).d(str).a(i).c();
        if (dns == null) {
            throw new NullPointerException("dns == null");
        }
        this.b = dns;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.c = socketFactory;
        if (authenticator == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.d = authenticator;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.e = c.a((List) list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f = c.a((List) list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.g = proxySelector;
        this.h = proxy;
        this.i = sSLSocketFactory;
        this.j = hostnameVerifier;
        this.k = eVar;
    }

    public s a() {
        return this.a;
    }

    boolean a(a aVar) {
        return this.b.equals(aVar.b) && this.d.equals(aVar.d) && this.e.equals(aVar.e) && this.f.equals(aVar.f) && this.g.equals(aVar.g) && c.a(this.h, aVar.h) && c.a(this.i, aVar.i) && c.a(this.j, aVar.j) && c.a(this.k, aVar.k) && a().g() == aVar.a().g();
    }

    public Dns b() {
        return this.b;
    }

    public SocketFactory c() {
        return this.c;
    }

    public Authenticator d() {
        return this.d;
    }

    public List<Protocol> e() {
        return this.e;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof a) && this.a.equals(((a) obj).a) && a((a) obj);
    }

    public List<j> f() {
        return this.f;
    }

    public ProxySelector g() {
        return this.g;
    }

    @Nullable
    public Proxy h() {
        return this.h;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.j != null ? this.j.hashCode() : 0) + (((this.i != null ? this.i.hashCode() : 0) + (((this.h != null ? this.h.hashCode() : 0) + ((((((((((((this.a.hashCode() + 527) * 31) + this.b.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31)) * 31)) * 31)) * 31;
        if (this.k != null) {
            i = this.k.hashCode();
        }
        return hashCode + i;
    }

    @Nullable
    public SSLSocketFactory i() {
        return this.i;
    }

    @Nullable
    public HostnameVerifier j() {
        return this.j;
    }

    @Nullable
    public e k() {
        return this.k;
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append("Address{").append(this.a.f()).append(":").append(this.a.g());
        if (this.h != null) {
            append.append(", proxy=").append(this.h);
        } else {
            append.append(", proxySelector=").append(this.g);
        }
        append.append("}");
        return append.toString();
    }
}
