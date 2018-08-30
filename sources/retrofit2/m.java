package retrofit2;

import java.io.IOException;
import okhttp3.ai;
import okhttp3.v;
import okio.BufferedSource;
import okio.d;
import okio.e;
import okio.i;

final class m extends ai {
    IOException a;
    private final ai b;

    m(ai aiVar) {
        this.b = aiVar;
    }

    public v a() {
        return this.b.a();
    }

    public long b() {
        return this.b.b();
    }

    public BufferedSource c() {
        return i.a(new e(this.b.c()) {
            public long read(d dVar, long j) {
                try {
                    return super.read(dVar, j);
                } catch (IOException e) {
                    m.this.a = e;
                    throw e;
                }
            }
        });
    }

    public void close() {
        this.b.close();
    }

    void g() {
        if (this.a != null) {
            throw this.a;
        }
    }
}
