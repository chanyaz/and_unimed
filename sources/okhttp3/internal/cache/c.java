package okhttp3.internal.cache;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import okhttp3.ad;
import okhttp3.ag;
import okhttp3.ah;
import okhttp3.internal.a;
import okhttp3.internal.http.d;
import okhttp3.q;
import okhttp3.r;

public class c {
    final long a;
    final ad b;
    final ag c;
    private Date d;
    private String e;
    private Date f;
    private String g;
    private Date h;
    private long i;
    private long j;
    private String k;
    private int l = -1;

    public c(long j, ad adVar, ag agVar) {
        this.a = j;
        this.b = adVar;
        this.c = agVar;
        if (agVar != null) {
            this.i = agVar.j();
            this.j = agVar.k();
            q f = agVar.f();
            int a = f.a();
            for (int i = 0; i < a; i++) {
                String a2 = f.a(i);
                String b = f.b(i);
                if ("Date".equalsIgnoreCase(a2)) {
                    this.d = okhttp3.internal.http.c.a(b);
                    this.e = b;
                } else if ("Expires".equalsIgnoreCase(a2)) {
                    this.h = okhttp3.internal.http.c.a(b);
                } else if ("Last-Modified".equalsIgnoreCase(a2)) {
                    this.f = okhttp3.internal.http.c.a(b);
                    this.g = b;
                } else if ("ETag".equalsIgnoreCase(a2)) {
                    this.k = b;
                } else if ("Age".equalsIgnoreCase(a2)) {
                    this.l = d.b(b, -1);
                }
            }
        }
    }

    private static boolean a(ad adVar) {
        return (adVar.a("If-Modified-Since") == null && adVar.a("If-None-Match") == null) ? false : true;
    }

    private b b() {
        long j = 0;
        if (this.c == null) {
            return new b(this.b, null);
        }
        if (this.b.g() && this.c.e() == null) {
            return new b(this.b, null);
        }
        if (!b.a(this.c, this.b)) {
            return new b(this.b, null);
        }
        okhttp3.c f = this.b.f();
        if (f.a() || a(this.b)) {
            return new b(this.b, null);
        }
        long d = d();
        long c = c();
        if (f.c() != -1) {
            c = Math.min(c, TimeUnit.SECONDS.toMillis((long) f.c()));
        }
        long toMillis = f.h() != -1 ? TimeUnit.SECONDS.toMillis((long) f.h()) : 0;
        okhttp3.c i = this.c.i();
        if (!(i.f() || f.g() == -1)) {
            j = TimeUnit.SECONDS.toMillis((long) f.g());
        }
        if (i.a() || d + toMillis >= j + c) {
            String str;
            String str2;
            if (this.k != null) {
                str = "If-None-Match";
                str2 = this.k;
            } else if (this.f != null) {
                str = "If-Modified-Since";
                str2 = this.g;
            } else if (this.d == null) {
                return new b(this.b, null);
            } else {
                str = "If-Modified-Since";
                str2 = this.e;
            }
            r b = this.b.c().b();
            a.a.a(b, str, str2);
            return new b(this.b.e().a(b.a()).a(), this.c);
        }
        ah h = this.c.h();
        if (toMillis + d >= c) {
            h.a("Warning", "110 HttpURLConnection \"Response is stale\"");
        }
        if (d > 86400000 && e()) {
            h.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
        }
        return new b(null, h.a());
    }

    private long c() {
        okhttp3.c i = this.c.i();
        if (i.c() != -1) {
            return TimeUnit.SECONDS.toMillis((long) i.c());
        }
        long time;
        if (this.h != null) {
            time = this.h.getTime() - (this.d != null ? this.d.getTime() : this.j);
            if (time <= 0) {
                time = 0;
            }
            return time;
        } else if (this.f == null || this.c.a().a().l() != null) {
            return 0;
        } else {
            time = (this.d != null ? this.d.getTime() : this.i) - this.f.getTime();
            return time > 0 ? time / 10 : 0;
        }
    }

    private long d() {
        long j = 0;
        if (this.d != null) {
            j = Math.max(0, this.j - this.d.getTime());
        }
        if (this.l != -1) {
            j = Math.max(j, TimeUnit.SECONDS.toMillis((long) this.l));
        }
        return (j + (this.j - this.i)) + (this.a - this.j);
    }

    private boolean e() {
        return this.c.i().c() == -1 && this.h == null;
    }

    public b a() {
        b b = b();
        return (b.a == null || !this.b.f().i()) ? b : new b(null, null);
    }
}
