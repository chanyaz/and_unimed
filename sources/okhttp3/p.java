package okhttp3;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.c;

public final class p {
    private final TlsVersion a;
    private final h b;
    private final List<Certificate> c;
    private final List<Certificate> d;

    private p(TlsVersion tlsVersion, h hVar, List<Certificate> list, List<Certificate> list2) {
        this.a = tlsVersion;
        this.b = hVar;
        this.c = list;
        this.d = list2;
    }

    public static p a(SSLSession sSLSession) {
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        h a = h.a(cipherSuite);
        cipherSuite = sSLSession.getProtocol();
        if (cipherSuite == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        Object[] peerCertificates;
        TlsVersion a2 = TlsVersion.a(cipherSuite);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException e) {
            peerCertificates = null;
        }
        List a3 = peerCertificates != null ? c.a(peerCertificates) : Collections.emptyList();
        Object[] localCertificates = sSLSession.getLocalCertificates();
        return new p(a2, a, a3, localCertificates != null ? c.a(localCertificates) : Collections.emptyList());
    }

    public h a() {
        return this.b;
    }

    public List<Certificate> b() {
        return this.c;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.a.equals(pVar.a) && this.b.equals(pVar.b) && this.c.equals(pVar.c) && this.d.equals(pVar.d);
    }

    public int hashCode() {
        return ((((((this.a.hashCode() + 527) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }
}
