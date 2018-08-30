package okhttp3;

import java.io.Closeable;
import java.util.List;
import javax.annotation.Nullable;

public final class ag implements Closeable {
    final ad a;
    final Protocol b;
    final int c;
    final String d;
    @Nullable
    final p e;
    final q f;
    @Nullable
    final ai g;
    @Nullable
    final ag h;
    @Nullable
    final ag i;
    @Nullable
    final ag j;
    final long k;
    final long l;
    private volatile c m;

    ag(ah ahVar) {
        this.a = ahVar.a;
        this.b = ahVar.b;
        this.c = ahVar.c;
        this.d = ahVar.d;
        this.e = ahVar.e;
        this.f = ahVar.f.a();
        this.g = ahVar.g;
        this.h = ahVar.h;
        this.i = ahVar.i;
        this.j = ahVar.j;
        this.k = ahVar.k;
        this.l = ahVar.l;
    }

    @Nullable
    public String a(String str, @Nullable String str2) {
        String a = this.f.a(str);
        return a != null ? a : str2;
    }

    public List<String> a(String str) {
        return this.f.b(str);
    }

    public ad a() {
        return this.a;
    }

    public int b() {
        return this.c;
    }

    @Nullable
    public String b(String str) {
        return a(str, null);
    }

    public boolean c() {
        return this.c >= 200 && this.c < 300;
    }

    public void close() {
        this.g.close();
    }

    public String d() {
        return this.d;
    }

    public p e() {
        return this.e;
    }

    public q f() {
        return this.f;
    }

    @Nullable
    public ai g() {
        return this.g;
    }

    public ah h() {
        return new ah(this);
    }

    public c i() {
        c cVar = this.m;
        if (cVar != null) {
            return cVar;
        }
        cVar = c.a(this.f);
        this.m = cVar;
        return cVar;
    }

    public long j() {
        return this.k;
    }

    public long k() {
        return this.l;
    }

    public String toString() {
        return "Response{protocol=" + this.b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.a.a() + '}';
    }
}
