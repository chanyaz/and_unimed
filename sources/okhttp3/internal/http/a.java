package okhttp3.internal.http;

import java.util.List;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.ad;
import okhttp3.ae;
import okhttp3.af;
import okhttp3.ag;
import okhttp3.ah;
import okhttp3.internal.c;
import okhttp3.internal.d;
import okhttp3.l;
import okhttp3.q;
import okhttp3.v;
import okio.Source;
import okio.g;
import okio.i;

public final class a implements Interceptor {
    private final CookieJar a;

    public a(CookieJar cookieJar) {
        this.a = cookieJar;
    }

    private String a(List<l> list) {
        StringBuilder stringBuilder = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append("; ");
            }
            l lVar = (l) list.get(i);
            stringBuilder.append(lVar.a()).append('=').append(lVar.b());
        }
        return stringBuilder.toString();
    }

    public ag intercept(Chain chain) {
        boolean z = false;
        ad request = chain.request();
        ae e = request.e();
        af d = request.d();
        if (d != null) {
            v a = d.a();
            if (a != null) {
                e.a("Content-Type", a.toString());
            }
            long b = d.b();
            if (b != -1) {
                e.a("Content-Length", Long.toString(b));
                e.a("Transfer-Encoding");
            } else {
                e.a("Transfer-Encoding", "chunked");
                e.a("Content-Length");
            }
        }
        if (request.a("Host") == null) {
            e.a("Host", c.a(request.a(), false));
        }
        if (request.a("Connection") == null) {
            e.a("Connection", "Keep-Alive");
        }
        if (request.a("Accept-Encoding") == null && request.a("Range") == null) {
            z = true;
            e.a("Accept-Encoding", "gzip");
        }
        List loadForRequest = this.a.loadForRequest(request.a());
        if (!loadForRequest.isEmpty()) {
            e.a("Cookie", a(loadForRequest));
        }
        if (request.a("User-Agent") == null) {
            e.a("User-Agent", d.a());
        }
        ag proceed = chain.proceed(e.a());
        d.a(this.a, request.a(), proceed.f());
        ah a2 = proceed.h().a(request);
        if (z && "gzip".equalsIgnoreCase(proceed.b("Content-Encoding")) && d.b(proceed)) {
            Source gVar = new g(proceed.g().c());
            q a3 = proceed.f().b().b("Content-Encoding").b("Content-Length").a();
            a2.a(a3);
            a2.a(new g(a3, i.a(gVar)));
        }
        return a2.a();
    }
}
