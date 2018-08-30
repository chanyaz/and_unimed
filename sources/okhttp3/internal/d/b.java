package okhttp3.internal.d;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.b.h;

public abstract class b {
    public static b a(X509TrustManager x509TrustManager) {
        return h.b().a(x509TrustManager);
    }

    public abstract List<Certificate> a(List<Certificate> list, String str);
}
