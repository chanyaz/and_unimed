package okhttp3.internal.b;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.d.a;
import okhttp3.internal.d.b;
import okhttp3.internal.d.e;
import okhttp3.z;
import okio.d;

public class h {
    private static final h a = a();
    private static final Logger b = Logger.getLogger(z.class.getName());

    public static List<String> a(List<Protocol> list) {
        List<String> arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = (Protocol) list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                arrayList.add(protocol.toString());
            }
        }
        return arrayList;
    }

    private static h a() {
        h a = a.a();
        if (a != null) {
            return a;
        }
        a = d.a();
        if (a != null) {
            return a;
        }
        a = e.a();
        return a == null ? new h() : a;
    }

    public static h b() {
        return a;
    }

    static byte[] b(List<Protocol> list) {
        d dVar = new d();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = (Protocol) list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                dVar.writeByte(protocol.toString().length());
                dVar.writeUtf8(protocol.toString());
            }
        }
        return dVar.readByteArray();
    }

    public Object a(String str) {
        return b.isLoggable(Level.FINE) ? new Throwable(str) : null;
    }

    public String a(SSLSocket sSLSocket) {
        return null;
    }

    public b a(X509TrustManager x509TrustManager) {
        return new a(e.a(x509TrustManager));
    }

    public void a(int i, String str, Throwable th) {
        b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        a(5, str, (Throwable) obj);
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        socket.connect(inetSocketAddress, i);
    }

    public void a(SSLSocket sSLSocket, String str, List<Protocol> list) {
    }

    public void b(SSLSocket sSLSocket) {
    }

    public boolean b(String str) {
        return true;
    }
}
