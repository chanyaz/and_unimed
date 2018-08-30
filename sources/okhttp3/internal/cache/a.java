package okhttp3.internal.cache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Protocol;
import okhttp3.ad;
import okhttp3.ag;
import okhttp3.ah;
import okhttp3.internal.c;
import okhttp3.internal.http.e;
import okhttp3.internal.http.g;
import okhttp3.q;
import okhttp3.r;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.d;
import okio.i;
import okio.p;

public final class a implements Interceptor {
    final InternalCache a;

    public a(InternalCache internalCache) {
        this.a = internalCache;
    }

    private static ag a(ag agVar) {
        return (agVar == null || agVar.g() == null) ? agVar : agVar.h().a(null).a();
    }

    private ag a(final CacheRequest cacheRequest, ag agVar) {
        if (cacheRequest == null) {
            return agVar;
        }
        Sink body = cacheRequest.body();
        if (body == null) {
            return agVar;
        }
        final BufferedSource c = agVar.g().c();
        final BufferedSink a = i.a(body);
        return agVar.h().a(new g(agVar.f(), i.a(new Source() {
            boolean a;

            public void close() {
                if (!(this.a || c.a((Source) this, 100, TimeUnit.MILLISECONDS))) {
                    this.a = true;
                    cacheRequest.abort();
                }
                c.close();
            }

            public long read(d dVar, long j) {
                try {
                    long read = c.read(dVar, j);
                    if (read == -1) {
                        if (!this.a) {
                            this.a = true;
                            a.close();
                        }
                        return -1;
                    }
                    dVar.a(a.buffer(), dVar.a() - read, read);
                    a.emitCompleteSegments();
                    return read;
                } catch (IOException e) {
                    if (!this.a) {
                        this.a = true;
                        cacheRequest.abort();
                    }
                    throw e;
                }
            }

            public p timeout() {
                return c.timeout();
            }
        }))).a();
    }

    private static q a(q qVar, q qVar2) {
        int i;
        int i2 = 0;
        r rVar = new r();
        int a = qVar.a();
        for (i = 0; i < a; i++) {
            String a2 = qVar.a(i);
            String b = qVar.b(i);
            if (!("Warning".equalsIgnoreCase(a2) && b.startsWith("1")) && (!a(a2) || qVar2.a(a2) == null)) {
                okhttp3.internal.a.a.a(rVar, a2, b);
            }
        }
        i = qVar2.a();
        while (i2 < i) {
            String a3 = qVar2.a(i2);
            if (!"Content-Length".equalsIgnoreCase(a3) && a(a3)) {
                okhttp3.internal.a.a.a(rVar, a3, qVar2.b(i2));
            }
            i2++;
        }
        return rVar.a();
    }

    static boolean a(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    public ag intercept(Chain chain) {
        ag agVar = null;
        ag agVar2 = this.a != null ? this.a.get(chain.request()) : agVar;
        b a = new c(System.currentTimeMillis(), chain.request(), agVar2).a();
        ad adVar = a.a;
        ag agVar3 = a.b;
        if (this.a != null) {
            this.a.trackResponse(a);
        }
        if (agVar2 != null && agVar3 == null) {
            c.a(agVar2.g());
        }
        if (adVar == null && agVar3 == null) {
            return new ah().a(chain.request()).a(Protocol.HTTP_1_1).a(504).a("Unsatisfiable Request (only-if-cached)").a(c.c).a(-1).b(System.currentTimeMillis()).a();
        }
        if (adVar == null) {
            return agVar3.h().b(a(agVar3)).a();
        }
        try {
            agVar = chain.proceed(adVar);
            if (agVar3 != null) {
                if (agVar.b() == 304) {
                    agVar2 = agVar3.h().a(a(agVar3.f(), agVar.f())).a(agVar.j()).b(agVar.k()).b(a(agVar3)).a(a(agVar)).a();
                    agVar.g().close();
                    this.a.trackConditionalCacheHit();
                    this.a.update(agVar3, agVar2);
                    return agVar2;
                }
                c.a(agVar3.g());
            }
            agVar2 = agVar.h().b(a(agVar3)).a(a(agVar)).a();
            if (this.a == null) {
                return agVar2;
            }
            if (okhttp3.internal.http.d.b(agVar2) && b.a(agVar2, adVar)) {
                return a(this.a.put(agVar2), agVar2);
            }
            if (!e.a(adVar.b())) {
                return agVar2;
            }
            try {
                this.a.remove(adVar);
                return agVar2;
            } catch (IOException e) {
                return agVar2;
            }
        } finally {
            if (agVar == null && agVar2 != null) {
                c.a(agVar2.g());
            }
        }
    }
}
