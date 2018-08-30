package okhttp3.internal.http;

import okhttp3.ai;
import okhttp3.q;
import okhttp3.v;
import okio.BufferedSource;

public final class g extends ai {
    private final q a;
    private final BufferedSource b;

    public g(q qVar, BufferedSource bufferedSource) {
        this.a = qVar;
        this.b = bufferedSource;
    }

    public v a() {
        String a = this.a.a("Content-Type");
        return a != null ? v.a(a) : null;
    }

    public long b() {
        return d.a(this.a);
    }

    public BufferedSource c() {
        return this.b;
    }
}
