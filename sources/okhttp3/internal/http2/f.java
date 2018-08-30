package okhttp3.internal.http2;

import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.ad;
import okhttp3.ag;
import okhttp3.ah;
import okhttp3.ai;
import okhttp3.internal.a;
import okhttp3.internal.c;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.g;
import okhttp3.internal.http.h;
import okhttp3.internal.http.j;
import okhttp3.q;
import okhttp3.r;
import okhttp3.z;
import okio.ByteString;
import okio.Sink;
import okio.i;

public final class f implements HttpCodec {
    private static final ByteString b = ByteString.a("connection");
    private static final ByteString c = ByteString.a("host");
    private static final ByteString d = ByteString.a("keep-alive");
    private static final ByteString e = ByteString.a("proxy-connection");
    private static final ByteString f = ByteString.a("transfer-encoding");
    private static final ByteString g = ByteString.a("te");
    private static final ByteString h = ByteString.a("encoding");
    private static final ByteString i = ByteString.a("upgrade");
    private static final List<ByteString> j = c.a(b, c, d, e, g, f, h, i, a.c, a.d, a.e, a.f);
    private static final List<ByteString> k = c.a(b, c, d, e, g, f, h, i);
    final okhttp3.internal.connection.f a;
    private final z l;
    private final h m;
    private m n;

    public f(z zVar, okhttp3.internal.connection.f fVar, h hVar) {
        this.l = zVar;
        this.a = fVar;
        this.m = hVar;
    }

    public static List<a> a(ad adVar) {
        q c = adVar.c();
        List<a> arrayList = new ArrayList(c.a() + 4);
        arrayList.add(new a(a.c, adVar.b()));
        arrayList.add(new a(a.d, h.a(adVar.a())));
        String a = adVar.a("Host");
        if (a != null) {
            arrayList.add(new a(a.f, a));
        }
        arrayList.add(new a(a.e, adVar.a().b()));
        int a2 = c.a();
        for (int i = 0; i < a2; i++) {
            ByteString a3 = ByteString.a(c.a(i).toLowerCase(Locale.US));
            if (!j.contains(a3)) {
                arrayList.add(new a(a3, c.b(i)));
            }
        }
        return arrayList;
    }

    public static ah a(List<a> list) {
        r rVar = new r();
        int size = list.size();
        int i = 0;
        j jVar = null;
        while (i < size) {
            r rVar2;
            j jVar2;
            a aVar = (a) list.get(i);
            if (aVar == null) {
                if (jVar != null && jVar.b == 100) {
                    rVar2 = new r();
                    jVar2 = null;
                }
                rVar2 = rVar;
                jVar2 = jVar;
            } else {
                ByteString byteString = aVar.g;
                String a = aVar.h.a();
                if (byteString.equals(a.b)) {
                    r rVar3 = rVar;
                    jVar2 = j.a("HTTP/1.1 " + a);
                    rVar2 = rVar3;
                } else {
                    if (!k.contains(byteString)) {
                        a.a.a(rVar, byteString.a(), a);
                    }
                    rVar2 = rVar;
                    jVar2 = jVar;
                }
            }
            i++;
            jVar = jVar2;
            rVar = rVar2;
        }
        if (jVar != null) {
            return new ah().a(Protocol.HTTP_2).a(jVar.b).a(jVar.c).a(rVar.a());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public void cancel() {
        if (this.n != null) {
            this.n.b(ErrorCode.CANCEL);
        }
    }

    public Sink createRequestBody(ad adVar, long j) {
        return this.n.h();
    }

    public void finishRequest() {
        this.n.h().close();
    }

    public void flushRequest() {
        this.m.b();
    }

    public ai openResponseBody(ag agVar) {
        return new g(agVar.f(), i.a(new g(this, this.n.g())));
    }

    public ah readResponseHeaders(boolean z) {
        ah a = a(this.n.d());
        return (z && a.a.a(a) == 100) ? null : a;
    }

    public void writeRequestHeaders(ad adVar) {
        if (this.n == null) {
            this.n = this.m.a(a(adVar), adVar.d() != null);
            this.n.e().a((long) this.l.b(), TimeUnit.MILLISECONDS);
            this.n.f().a((long) this.l.c(), TimeUnit.MILLISECONDS);
        }
    }
}
