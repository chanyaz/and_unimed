package retrofit2;

import okhttp3.ai;
import okhttp3.v;
import okio.BufferedSource;

final class n extends ai {
    private final v a;
    private final long b;

    n(v vVar, long j) {
        this.a = vVar;
        this.b = j;
    }

    public v a() {
        return this.a;
    }

    public long b() {
        return this.b;
    }

    public BufferedSource c() {
        throw new IllegalStateException("Cannot read raw response body of a converted body.");
    }
}
