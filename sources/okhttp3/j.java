package okhttp3;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.c;

public final class j {
    public static final j a = new k(true).a(h).a(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).a(true).a();
    public static final j b = new k(a).a(TlsVersion.TLS_1_0).a(true).a();
    public static final j c = new k(false).a();
    private static final h[] h = new h[]{h.aX, h.bb, h.aY, h.bc, h.bi, h.bh, h.ay, h.aI, h.az, h.aJ, h.ag, h.ah, h.E, h.I, h.i};
    final boolean d;
    final boolean e;
    @Nullable
    final String[] f;
    @Nullable
    final String[] g;

    j(k kVar) {
        this.d = kVar.a;
        this.f = kVar.b;
        this.g = kVar.c;
        this.e = kVar.d;
    }

    private j b(SSLSocket sSLSocket, boolean z) {
        String[] a = this.f != null ? c.a(h.a, sSLSocket.getEnabledCipherSuites(), this.f) : sSLSocket.getEnabledCipherSuites();
        String[] a2 = this.g != null ? c.a(c.g, sSLSocket.getEnabledProtocols(), this.g) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int a3 = c.a(h.a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && a3 != -1) {
            a = c.a(a, supportedCipherSuites[a3]);
        }
        return new k(this).a(a).b(a2).a();
    }

    void a(SSLSocket sSLSocket, boolean z) {
        j b = b(sSLSocket, z);
        if (b.g != null) {
            sSLSocket.setEnabledProtocols(b.g);
        }
        if (b.f != null) {
            sSLSocket.setEnabledCipherSuites(b.f);
        }
    }

    public boolean a() {
        return this.d;
    }

    public boolean a(SSLSocket sSLSocket) {
        return !this.d ? false : (this.g == null || c.b(c.g, this.g, sSLSocket.getEnabledProtocols())) ? this.f == null || c.b(h.a, this.f, sSLSocket.getEnabledCipherSuites()) : false;
    }

    @Nullable
    public List<h> b() {
        return this.f != null ? h.a(this.f) : null;
    }

    @Nullable
    public List<TlsVersion> c() {
        return this.g != null ? TlsVersion.a(this.g) : null;
    }

    public boolean d() {
        return this.e;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        j jVar = (j) obj;
        return this.d == jVar.d ? !this.d || (Arrays.equals(this.f, jVar.f) && Arrays.equals(this.g, jVar.g) && this.e == jVar.e) : false;
    }

    public int hashCode() {
        if (!this.d) {
            return 17;
        }
        return (this.e ? 0 : 1) + ((((Arrays.hashCode(this.f) + 527) * 31) + Arrays.hashCode(this.g)) * 31);
    }

    public String toString() {
        if (!this.d) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.f != null ? b().toString() : "[all enabled]") + ", tlsVersions=" + (this.g != null ? c().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.e + ")";
    }
}
