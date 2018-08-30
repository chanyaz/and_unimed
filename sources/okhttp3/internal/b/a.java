package okhttp3.internal.b;

import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.c;
import okhttp3.internal.d.b;

class a extends h {
    private final Class<?> a;
    private final g<Socket> b;
    private final g<Socket> c;
    private final g<Socket> d;
    private final g<Socket> e;
    private final c f = c.a();

    a(Class<?> cls, g<Socket> gVar, g<Socket> gVar2, g<Socket> gVar3, g<Socket> gVar4) {
        this.a = cls;
        this.b = gVar;
        this.c = gVar2;
        this.d = gVar3;
        this.e = gVar4;
    }

    public static h a() {
        Class cls;
        g gVar;
        g gVar2;
        try {
            cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
        } catch (ClassNotFoundException e) {
            cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
        }
        try {
            g gVar3 = new g(null, "setUseSessionTickets", Boolean.TYPE);
            g gVar4 = new g(null, "setHostname", String.class);
            g gVar5;
            try {
                Class.forName("android.net.Network");
                gVar5 = new g(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                try {
                    gVar = new g(null, "setAlpnProtocols", byte[].class);
                    gVar2 = gVar5;
                } catch (ClassNotFoundException e2) {
                    gVar = null;
                    gVar2 = gVar5;
                    return new a(cls, gVar3, gVar4, gVar2, gVar);
                }
            } catch (ClassNotFoundException e3) {
                gVar5 = null;
                gVar = null;
                gVar2 = gVar5;
                return new a(cls, gVar3, gVar4, gVar2, gVar);
            }
            return new a(cls, gVar3, gVar4, gVar2, gVar);
        } catch (ClassNotFoundException e4) {
            return null;
        }
    }

    public Object a(String str) {
        return this.f.a(str);
    }

    public String a(SSLSocket sSLSocket) {
        if (this.d == null || !this.d.a((Object) sSLSocket)) {
            return null;
        }
        byte[] bArr = (byte[]) this.d.d(sSLSocket, new Object[0]);
        return bArr != null ? new String(bArr, c.e) : null;
    }

    public b a(X509TrustManager x509TrustManager) {
        try {
            Class cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new b(cls.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{x509TrustManager}), cls.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, String.class, String.class}));
        } catch (Exception e) {
            return super.a(x509TrustManager);
        }
    }

    public void a(int i, String str, Throwable th) {
        int i2 = i == 5 ? 5 : 3;
        if (th != null) {
            str = str + 10 + Log.getStackTraceString(th);
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int min;
            int indexOf = str.indexOf(10, i3);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i3 + 4000);
                Log.println(i2, "OkHttp", str.substring(i3, min));
                if (min >= indexOf) {
                    break;
                }
                i3 = min;
            }
            i3 = min + 1;
        }
    }

    public void a(String str, Object obj) {
        if (!this.f.a(obj)) {
            a(5, str, null);
        }
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (c.a(e)) {
                throw new IOException(e);
            }
            throw e;
        } catch (Throwable e2) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e2);
            throw iOException;
        }
    }

    public void a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        if (str != null) {
            this.b.b(sSLSocket, Boolean.valueOf(true));
            this.c.b(sSLSocket, str);
        }
        if (this.e != null && this.e.a((Object) sSLSocket)) {
            this.e.d(sSLSocket, h.b((List) list));
        }
    }

    public boolean b(String str) {
        try {
            Class cls = Class.forName("android.security.NetworkSecurityPolicy");
            Object invoke = cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(invoke, new Object[]{str})).booleanValue();
        } catch (ClassNotFoundException e) {
        } catch (NoSuchMethodException e2) {
        } catch (IllegalAccessException e3) {
            throw new AssertionError();
        } catch (IllegalArgumentException e4) {
            throw new AssertionError();
        } catch (InvocationTargetException e5) {
            throw new AssertionError();
        }
        return super.b(str);
    }
}
