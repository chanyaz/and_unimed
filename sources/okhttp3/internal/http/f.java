package okhttp3.internal.http;

import java.util.List;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.ad;
import okhttp3.ag;
import okhttp3.internal.connection.c;

public final class f implements Chain {
    private final List<Interceptor> a;
    private final okhttp3.internal.connection.f b;
    private final HttpCodec c;
    private final c d;
    private final int e;
    private final ad f;
    private int g;

    public f(List<Interceptor> list, okhttp3.internal.connection.f fVar, HttpCodec httpCodec, c cVar, int i, ad adVar) {
        this.a = list;
        this.d = cVar;
        this.b = fVar;
        this.c = httpCodec;
        this.e = i;
        this.f = adVar;
    }

    public ag a(ad adVar, okhttp3.internal.connection.f fVar, HttpCodec httpCodec, c cVar) {
        if (this.e >= this.a.size()) {
            throw new AssertionError();
        }
        this.g++;
        if (this.c != null && !this.d.a(adVar.a())) {
            throw new IllegalStateException("network interceptor " + this.a.get(this.e - 1) + " must retain the same host and port");
        } else if (this.c == null || this.g <= 1) {
            Object fVar2 = new f(this.a, fVar, httpCodec, cVar, this.e + 1, adVar);
            Interceptor interceptor = (Interceptor) this.a.get(this.e);
            ag intercept = interceptor.intercept(fVar2);
            if (httpCodec != null && this.e + 1 < this.a.size() && fVar2.g != 1) {
                throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
            } else if (intercept != null) {
                return intercept;
            } else {
                throw new NullPointerException("interceptor " + interceptor + " returned null");
            }
        } else {
            throw new IllegalStateException("network interceptor " + this.a.get(this.e - 1) + " must call proceed() exactly once");
        }
    }

    public okhttp3.internal.connection.f a() {
        return this.b;
    }

    public HttpCodec b() {
        return this.c;
    }

    public Connection connection() {
        return this.d;
    }

    public ag proceed(ad adVar) {
        return a(adVar, this.b, this.c, this.d);
    }

    public ad request() {
        return this.f;
    }
}
