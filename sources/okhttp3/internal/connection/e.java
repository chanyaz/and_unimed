package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.a;
import okhttp3.ak;
import okhttp3.internal.c;
import okhttp3.s;

public final class e {
    private final a a;
    private final d b;
    private Proxy c;
    private InetSocketAddress d;
    private List<Proxy> e = Collections.emptyList();
    private int f;
    private List<InetSocketAddress> g = Collections.emptyList();
    private int h;
    private final List<ak> i = new ArrayList();

    public e(a aVar, d dVar) {
        this.a = aVar;
        this.b = dVar;
        a(aVar.a(), aVar.h());
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    private void a(Proxy proxy) {
        int g;
        String str;
        this.g = new ArrayList();
        String f;
        if (proxy.type() == Type.DIRECT || proxy.type() == Type.SOCKS) {
            f = this.a.a().f();
            g = this.a.a().g();
            str = f;
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                f = a(inetSocketAddress);
                g = inetSocketAddress.getPort();
                str = f;
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        }
        if (g < 1 || g > 65535) {
            throw new SocketException("No route to " + str + ":" + g + "; port is out of range");
        }
        if (proxy.type() == Type.SOCKS) {
            this.g.add(InetSocketAddress.createUnresolved(str, g));
        } else {
            List lookup = this.a.b().lookup(str);
            if (lookup.isEmpty()) {
                throw new UnknownHostException(this.a.b() + " returned no addresses for " + str);
            }
            int size = lookup.size();
            for (int i = 0; i < size; i++) {
                this.g.add(new InetSocketAddress((InetAddress) lookup.get(i), g));
            }
        }
        this.h = 0;
    }

    private void a(s sVar, Proxy proxy) {
        if (proxy != null) {
            this.e = Collections.singletonList(proxy);
        } else {
            List select = this.a.g().select(sVar.a());
            if (select == null || select.isEmpty()) {
                select = c.a(Proxy.NO_PROXY);
            } else {
                select = c.a(select);
            }
            this.e = select;
        }
        this.f = 0;
    }

    private boolean c() {
        return this.f < this.e.size();
    }

    private Proxy d() {
        if (c()) {
            List list = this.e;
            int i = this.f;
            this.f = i + 1;
            Proxy proxy = (Proxy) list.get(i);
            a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.a.a().f() + "; exhausted proxy configurations: " + this.e);
    }

    private boolean e() {
        return this.h < this.g.size();
    }

    private InetSocketAddress f() {
        if (e()) {
            List list = this.g;
            int i = this.h;
            this.h = i + 1;
            return (InetSocketAddress) list.get(i);
        }
        throw new SocketException("No route to " + this.a.a().f() + "; exhausted inet socket addresses: " + this.g);
    }

    private boolean g() {
        return !this.i.isEmpty();
    }

    private ak h() {
        return (ak) this.i.remove(0);
    }

    public void a(ak akVar, IOException iOException) {
        if (!(akVar.b().type() == Type.DIRECT || this.a.g() == null)) {
            this.a.g().connectFailed(this.a.a().a(), akVar.b().address(), iOException);
        }
        this.b.a(akVar);
    }

    public boolean a() {
        return e() || c() || g();
    }

    public ak b() {
        if (!e()) {
            if (c()) {
                this.c = d();
            } else if (g()) {
                return h();
            } else {
                throw new NoSuchElementException();
            }
        }
        this.d = f();
        ak akVar = new ak(this.a, this.c, this.d);
        if (!this.b.c(akVar)) {
            return akVar;
        }
        this.i.add(akVar);
        return b();
    }
}
