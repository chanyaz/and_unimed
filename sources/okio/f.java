package okio;

import java.util.concurrent.TimeUnit;

public class f extends p {
    private p a;

    public f(p pVar) {
        if (pVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.a = pVar;
    }

    public final f a(p pVar) {
        if (pVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.a = pVar;
        return this;
    }

    public final p a() {
        return this.a;
    }

    public p a(long j) {
        return this.a.a(j);
    }

    public p a(long j, TimeUnit timeUnit) {
        return this.a.a(j, timeUnit);
    }

    public long d() {
        return this.a.d();
    }

    public p f() {
        return this.a.f();
    }

    public void g() {
        this.a.g();
    }

    public long l_() {
        return this.a.l_();
    }

    public boolean m_() {
        return this.a.m_();
    }

    public p n_() {
        return this.a.n_();
    }
}
