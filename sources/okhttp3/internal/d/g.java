package okhttp3.internal.d;

import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

final class g extends e {
    private final Map<X500Principal, Set<X509Certificate>> a = new LinkedHashMap();

    g(X509Certificate... x509CertificateArr) {
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Set set = (Set) this.a.get(subjectX500Principal);
            if (set == null) {
                set = new LinkedHashSet(1);
                this.a.put(subjectX500Principal, set);
            }
            set.add(x509Certificate);
        }
    }

    public X509Certificate a(X509Certificate x509Certificate) {
        Set<X509Certificate> set = (Set) this.a.get(x509Certificate.getIssuerX500Principal());
        if (set == null) {
            return null;
        }
        for (X509Certificate x509Certificate2 : set) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return x509Certificate2;
            } catch (Exception e) {
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        return obj == this ? true : (obj instanceof g) && ((g) obj).a.equals(this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
