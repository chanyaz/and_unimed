package okhttp3.internal.http;

import java.net.ProtocolException;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.ad;
import okhttp3.ag;
import okhttp3.ah;
import okhttp3.internal.connection.c;
import okhttp3.internal.connection.f;
import okio.BufferedSink;
import okio.i;

public final class b implements Interceptor {
    private final boolean a;

    public b(boolean z) {
        this.a = z;
    }

    public ag intercept(Chain chain) {
        ah ahVar;
        f fVar = (f) chain;
        HttpCodec b = fVar.b();
        f a = fVar.a();
        c cVar = (c) fVar.connection();
        ad request = fVar.request();
        long currentTimeMillis = System.currentTimeMillis();
        b.writeRequestHeaders(request);
        ah ahVar2 = null;
        if (!e.c(request.b()) || request.d() == null) {
            ahVar = null;
        } else {
            if ("100-continue".equalsIgnoreCase(request.a("Expect"))) {
                b.flushRequest();
                ahVar2 = b.readResponseHeaders(true);
            }
            if (ahVar2 == null) {
                BufferedSink a2 = i.a(b.createRequestBody(request, request.d().b()));
                request.d().a(a2);
                a2.close();
                ahVar = ahVar2;
            } else {
                if (!cVar.b()) {
                    a.d();
                }
                ahVar = ahVar2;
            }
        }
        b.finishRequest();
        if (ahVar == null) {
            ahVar = b.readResponseHeaders(false);
        }
        ag a3 = ahVar.a(request).a(a.b().handshake()).a(currentTimeMillis).b(System.currentTimeMillis()).a();
        int b2 = a3.b();
        a3 = (this.a && b2 == 101) ? a3.h().a(okhttp3.internal.c.c).a() : a3.h().a(b.openResponseBody(a3)).a();
        if ("close".equalsIgnoreCase(a3.a().a("Connection")) || "close".equalsIgnoreCase(a3.b("Connection"))) {
            a.d();
        }
        if ((b2 != 204 && b2 != 205) || a3.g().b() <= 0) {
            return a3;
        }
        throw new ProtocolException("HTTP " + b2 + " had non-zero Content-Length: " + a3.g().b());
    }
}
