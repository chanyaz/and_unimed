package okhttp3.internal.a;

import java.net.ProtocolException;
import okhttp3.internal.c;
import okio.Sink;
import okio.d;
import okio.f;
import okio.p;

final class e implements Sink {
    final /* synthetic */ a a;
    private final f b = new f(this.a.d.timeout());
    private boolean c;
    private long d;

    e(a aVar, long j) {
        this.a = aVar;
        this.d = j;
    }

    public void close() {
        if (!this.c) {
            this.c = true;
            if (this.d > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            this.a.a(this.b);
            this.a.e = 3;
        }
    }

    public void flush() {
        if (!this.c) {
            this.a.d.flush();
        }
    }

    public p timeout() {
        return this.b;
    }

    public void write(d dVar, long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        c.a(dVar.a(), 0, j);
        if (j > this.d) {
            throw new ProtocolException("expected " + this.d + " bytes but received " + j);
        }
        this.a.d.write(dVar, j);
        this.d -= j;
    }
}
