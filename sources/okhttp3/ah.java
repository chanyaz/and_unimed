package okhttp3;

import javax.annotation.Nullable;

public class ah {
    ad a;
    Protocol b;
    int c;
    String d;
    @Nullable
    p e;
    r f;
    ai g;
    ag h;
    ag i;
    ag j;
    long k;
    long l;

    public ah() {
        this.c = -1;
        this.f = new r();
    }

    ah(ag agVar) {
        this.c = -1;
        this.a = agVar.a;
        this.b = agVar.b;
        this.c = agVar.c;
        this.d = agVar.d;
        this.e = agVar.e;
        this.f = agVar.f.b();
        this.g = agVar.g;
        this.h = agVar.h;
        this.i = agVar.i;
        this.j = agVar.j;
        this.k = agVar.k;
        this.l = agVar.l;
    }

    private void a(String str, ag agVar) {
        if (agVar.g != null) {
            throw new IllegalArgumentException(str + ".body != null");
        } else if (agVar.h != null) {
            throw new IllegalArgumentException(str + ".networkResponse != null");
        } else if (agVar.i != null) {
            throw new IllegalArgumentException(str + ".cacheResponse != null");
        } else if (agVar.j != null) {
            throw new IllegalArgumentException(str + ".priorResponse != null");
        }
    }

    private void d(ag agVar) {
        if (agVar.g != null) {
            throw new IllegalArgumentException("priorResponse.body != null");
        }
    }

    public ag a() {
        if (this.a == null) {
            throw new IllegalStateException("request == null");
        } else if (this.b == null) {
            throw new IllegalStateException("protocol == null");
        } else if (this.c < 0) {
            throw new IllegalStateException("code < 0: " + this.c);
        } else if (this.d != null) {
            return new ag(this);
        } else {
            throw new IllegalStateException("message == null");
        }
    }

    public ah a(int i) {
        this.c = i;
        return this;
    }

    public ah a(long j) {
        this.k = j;
        return this;
    }

    public ah a(String str) {
        this.d = str;
        return this;
    }

    public ah a(String str, String str2) {
        this.f.a(str, str2);
        return this;
    }

    public ah a(Protocol protocol) {
        this.b = protocol;
        return this;
    }

    public ah a(ad adVar) {
        this.a = adVar;
        return this;
    }

    public ah a(@Nullable ag agVar) {
        if (agVar != null) {
            a("networkResponse", agVar);
        }
        this.h = agVar;
        return this;
    }

    public ah a(@Nullable ai aiVar) {
        this.g = aiVar;
        return this;
    }

    public ah a(@Nullable p pVar) {
        this.e = pVar;
        return this;
    }

    public ah a(q qVar) {
        this.f = qVar.b();
        return this;
    }

    public ah b(long j) {
        this.l = j;
        return this;
    }

    public ah b(@Nullable ag agVar) {
        if (agVar != null) {
            a("cacheResponse", agVar);
        }
        this.i = agVar;
        return this;
    }

    public ah c(@Nullable ag agVar) {
        if (agVar != null) {
            d(agVar);
        }
        this.j = agVar;
        return this;
    }
}
