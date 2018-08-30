package okhttp3.internal.d;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class a extends b {
    private final e a;

    public a(e eVar) {
        this.a = eVar;
    }

    private boolean a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException e) {
            return false;
        }
    }

    public List<Certificate> a(List<Certificate> list, String str) {
        Object obj = null;
        Deque arrayDeque = new ArrayDeque(list);
        List<Certificate> arrayList = new ArrayList();
        arrayList.add(arrayDeque.removeFirst());
        int i = 0;
        while (true) {
            Object obj2 = obj;
            if (i < 9) {
                X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
                X509Certificate a = this.a.a(x509Certificate);
                if (a != null) {
                    if (arrayList.size() > 1 || !x509Certificate.equals(a)) {
                        arrayList.add(a);
                    }
                    if (a(a, a)) {
                        return arrayList;
                    }
                    obj = 1;
                } else {
                    Iterator it = arrayDeque.iterator();
                    while (it.hasNext()) {
                        a = (X509Certificate) it.next();
                        if (a(x509Certificate, a)) {
                            it.remove();
                            arrayList.add(a);
                            obj = obj2;
                        }
                    }
                    if (obj2 != null) {
                        return arrayList;
                    }
                    throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
                }
                i++;
            } else {
                throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
            }
        }
    }

    public boolean equals(Object obj) {
        return obj == this ? true : (obj instanceof a) && ((a) obj).a.equals(this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
