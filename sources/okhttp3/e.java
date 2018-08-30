package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.c;
import okhttp3.internal.d.b;
import okio.ByteString;

public final class e {
    public static final e a = new f().a();
    private final Set<g> b;
    @Nullable
    private final b c;

    e(Set<g> set, @Nullable b bVar) {
        this.b = set;
        this.c = bVar;
    }

    public static String a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + b((X509Certificate) certificate).b();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static ByteString a(X509Certificate x509Certificate) {
        return ByteString.a(x509Certificate.getPublicKey().getEncoded()).c();
    }

    static ByteString b(X509Certificate x509Certificate) {
        return ByteString.a(x509Certificate.getPublicKey().getEncoded()).d();
    }

    List<g> a(String str) {
        List<g> emptyList = Collections.emptyList();
        for (g gVar : this.b) {
            if (gVar.a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList();
                }
                emptyList.add(gVar);
            }
        }
        return emptyList;
    }

    e a(b bVar) {
        return c.a(this.c, (Object) bVar) ? this : new e(this.b, bVar);
    }

    public void a(String str, List<Certificate> list) {
        List a = a(str);
        if (!a.isEmpty()) {
            List list2;
            int i;
            if (this.c != null) {
                list2 = this.c.a(list2, str);
            }
            int size = list2.size();
            for (int i2 = 0; i2 < size; i2++) {
                X509Certificate x509Certificate = (X509Certificate) list2.get(i2);
                int size2 = a.size();
                int i3 = 0;
                Object obj = null;
                Object obj2 = null;
                while (i3 < size2) {
                    g gVar = (g) a.get(i3);
                    if (gVar.c.equals("sha256/")) {
                        if (obj == null) {
                            obj = b(x509Certificate);
                        }
                        if (gVar.d.equals(obj)) {
                            return;
                        }
                    } else if (gVar.c.equals("sha1/")) {
                        if (obj2 == null) {
                            obj2 = a(x509Certificate);
                        }
                        if (gVar.d.equals(obj2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError();
                    }
                    Object obj3 = obj;
                    i3++;
                    obj2 = obj2;
                    obj = obj3;
                }
            }
            StringBuilder append = new StringBuilder().append("Certificate pinning failure!").append("\n  Peer certificate chain:");
            int size3 = list2.size();
            for (i = 0; i < size3; i++) {
                Certificate certificate = (X509Certificate) list2.get(i);
                append.append("\n    ").append(a(certificate)).append(": ").append(certificate.getSubjectDN().getName());
            }
            append.append("\n  Pinned certificates for ").append(str).append(":");
            size3 = a.size();
            for (i = 0; i < size3; i++) {
                append.append("\n    ").append((g) a.get(i));
            }
            throw new SSLPeerUnverifiedException(append.toString());
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        boolean z = (obj instanceof e) && c.a(this.c, ((e) obj).c) && this.b.equals(((e) obj).b);
        return z;
    }

    public int hashCode() {
        return ((this.c != null ? this.c.hashCode() : 0) * 31) + this.b.hashCode();
    }
}
