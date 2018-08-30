package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.a;
import okhttp3.j;

public final class b {
    private final List<j> a;
    private int b = 0;
    private boolean c;
    private boolean d;

    public b(List<j> list) {
        this.a = list;
    }

    private boolean b(SSLSocket sSLSocket) {
        int i = this.b;
        while (true) {
            int i2 = i;
            if (i2 >= this.a.size()) {
                return false;
            }
            if (((j) this.a.get(i2)).a(sSLSocket)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public j a(SSLSocket sSLSocket) {
        j jVar;
        int i = this.b;
        int size = this.a.size();
        for (int i2 = i; i2 < size; i2++) {
            jVar = (j) this.a.get(i2);
            if (jVar.a(sSLSocket)) {
                this.b = i2 + 1;
                break;
            }
        }
        jVar = null;
        if (jVar == null) {
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.d + ", modes=" + this.a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        this.c = b(sSLSocket);
        a.a.a(jVar, sSLSocket, this.d);
        return jVar;
    }

    public boolean a(IOException iOException) {
        this.d = true;
        return (!this.c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) ? false : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : (iOException instanceof SSLHandshakeException) || (iOException instanceof SSLProtocolException);
    }
}
