package okhttp3.internal.ws;

import java.io.IOException;
import okio.Sink;
import okio.d;
import okio.p;

final class i implements Sink {
    int a;
    long b;
    boolean c;
    boolean d;
    final /* synthetic */ h e;

    i(h hVar) {
        this.e = hVar;
    }

    public void close() {
        if (this.d) {
            throw new IOException("closed");
        }
        synchronized (this.e) {
            this.e.a(this.a, this.e.e.a(), this.c, true);
        }
        this.d = true;
        this.e.g = false;
    }

    public void flush() {
        if (this.d) {
            throw new IOException("closed");
        }
        synchronized (this.e) {
            this.e.a(this.a, this.e.e.a(), this.c, false);
        }
        this.c = false;
    }

    public p timeout() {
        return this.e.c.timeout();
    }

    public void write(d dVar, long j) {
        if (this.d) {
            throw new IOException("closed");
        }
        this.e.e.write(dVar, j);
        boolean z = this.c && this.b != -1 && this.e.e.a() > this.b - 8192;
        long c = this.e.e.c();
        if (c > 0 && !z) {
            synchronized (this.e) {
                this.e.a(this.a, c, this.c, false);
            }
            this.c = false;
        }
    }
}
