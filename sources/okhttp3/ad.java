package okhttp3;

import javax.annotation.Nullable;

public final class ad {
    final s a;
    final String b;
    final q c;
    @Nullable
    final af d;
    final Object e;
    private volatile c f;

    ad(ae aeVar) {
        Object obj;
        this.a = aeVar.a;
        this.b = aeVar.b;
        this.c = aeVar.c.a();
        this.d = aeVar.d;
        if (aeVar.e != null) {
            obj = aeVar.e;
        } else {
            ad obj2 = this;
        }
        this.e = obj2;
    }

    public String a(String str) {
        return this.c.a(str);
    }

    public s a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public q c() {
        return this.c;
    }

    @Nullable
    public af d() {
        return this.d;
    }

    public ae e() {
        return new ae(this);
    }

    public c f() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar;
        }
        cVar = c.a(this.c);
        this.f = cVar;
        return cVar;
    }

    public boolean g() {
        return this.a.c();
    }

    public String toString() {
        return "Request{method=" + this.b + ", url=" + this.a + ", tag=" + (this.e != this ? this.e : null) + '}';
    }
}
