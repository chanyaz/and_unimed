package okhttp3.internal.a;

import okio.Sink;
import okio.d;
import okio.f;
import okio.p;

final class c implements Sink {
    final /* synthetic */ a a;
    private final f b = new f(this.a.d.timeout());
    private boolean c;

    c(a aVar) {
        this.a = aVar;
    }

    public synchronized void close() {
        if (!this.c) {
            this.c = true;
            this.a.d.writeUtf8("0\r\n\r\n");
            this.a.a(this.b);
            this.a.e = 3;
        }
    }

    public synchronized void flush() {
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
        } else if (j != 0) {
            this.a.d.writeHexadecimalUnsignedLong(j);
            this.a.d.writeUtf8("\r\n");
            this.a.d.write(dVar, j);
            this.a.d.writeUtf8("\r\n");
        }
    }
}
