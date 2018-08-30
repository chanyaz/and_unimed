package okhttp3.internal.b;

import java.lang.reflect.Method;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

final class b extends okhttp3.internal.d.b {
    private final Object a;
    private final Method b;

    b(Object obj, Method method) {
        this.a = obj;
        this.b = method;
    }

    public List<Certificate> a(List<Certificate> list, String str) {
        try {
            X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
            return (List) this.b.invoke(this.a, new Object[]{x509CertificateArr, "RSA", str});
        } catch (Throwable e) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
            sSLPeerUnverifiedException.initCause(e);
            throw sSLPeerUnverifiedException;
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        }
    }

    public boolean equals(Object obj) {
        return obj instanceof b;
    }

    public int hashCode() {
        return 0;
    }
}
