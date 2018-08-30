package okhttp3.internal.a;

import java.io.IOException;
import okhttp3.ad;
import okhttp3.ag;
import okhttp3.ah;
import okhttp3.ai;
import okhttp3.internal.connection.c;
import okhttp3.internal.connection.f;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.d;
import okhttp3.internal.http.g;
import okhttp3.internal.http.h;
import okhttp3.internal.http.j;
import okhttp3.q;
import okhttp3.r;
import okhttp3.s;
import okhttp3.z;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.i;
import okio.p;

public final class a implements HttpCodec {
    final z a;
    final f b;
    final BufferedSource c;
    final BufferedSink d;
    int e = 0;

    public a(z zVar, f fVar, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.a = zVar;
        this.b = fVar;
        this.c = bufferedSource;
        this.d = bufferedSink;
    }

    private Source a(ag agVar) {
        if (!d.b(agVar)) {
            return b(0);
        }
        if ("chunked".equalsIgnoreCase(agVar.b("Transfer-Encoding"))) {
            return a(agVar.a().a());
        }
        long a = d.a(agVar);
        return a != -1 ? b(a) : c();
    }

    public q a() {
        r rVar = new r();
        while (true) {
            String readUtf8LineStrict = this.c.readUtf8LineStrict();
            if (readUtf8LineStrict.length() == 0) {
                return rVar.a();
            }
            okhttp3.internal.a.a.a(rVar, readUtf8LineStrict);
        }
    }

    public Sink a(long j) {
        if (this.e != 1) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.e = 2;
        return new e(this, j);
    }

    public Source a(s sVar) {
        if (this.e != 4) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.e = 5;
        return new d(this, sVar);
    }

    public void a(q qVar, String str) {
        if (this.e != 0) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.d.writeUtf8(str).writeUtf8("\r\n");
        int a = qVar.a();
        for (int i = 0; i < a; i++) {
            this.d.writeUtf8(qVar.a(i)).writeUtf8(": ").writeUtf8(qVar.b(i)).writeUtf8("\r\n");
        }
        this.d.writeUtf8("\r\n");
        this.e = 1;
    }

    void a(okio.f fVar) {
        p a = fVar.a();
        fVar.a(p.c);
        a.f();
        a.n_();
    }

    public Sink b() {
        if (this.e != 1) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.e = 2;
        return new c(this);
    }

    public Source b(long j) {
        if (this.e != 4) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.e = 5;
        return new f(this, j);
    }

    public Source c() {
        if (this.e != 4) {
            throw new IllegalStateException("state: " + this.e);
        } else if (this.b == null) {
            throw new IllegalStateException("streamAllocation == null");
        } else {
            this.e = 5;
            this.b.d();
            return new g(this);
        }
    }

    public void cancel() {
        c b = this.b.b();
        if (b != null) {
            b.a();
        }
    }

    public Sink createRequestBody(ad adVar, long j) {
        if ("chunked".equalsIgnoreCase(adVar.a("Transfer-Encoding"))) {
            return b();
        }
        if (j != -1) {
            return a(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public void finishRequest() {
        this.d.flush();
    }

    public void flushRequest() {
        this.d.flush();
    }

    public ai openResponseBody(ag agVar) {
        return new g(agVar.f(), i.a(a(agVar)));
    }

    public ah readResponseHeaders(boolean z) {
        if (this.e == 1 || this.e == 3) {
            try {
                j a = j.a(this.c.readUtf8LineStrict());
                ah a2 = new ah().a(a.a).a(a.b).a(a.c).a(a());
                if (z && a.b == 100) {
                    return null;
                }
                this.e = 4;
                return a2;
            } catch (Throwable e) {
                IOException iOException = new IOException("unexpected end of stream on " + this.b);
                iOException.initCause(e);
                throw iOException;
            }
        }
        throw new IllegalStateException("state: " + this.e);
    }

    public void writeRequestHeaders(ad adVar) {
        a(adVar.c(), h.a(adVar, this.b.b().route().b().type()));
    }
}
