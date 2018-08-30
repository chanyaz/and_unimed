package okhttp3.internal.a;

import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.c;
import okio.Source;
import okio.d;

class f extends b {
    final /* synthetic */ a d;
    private long e;

    f(a aVar, long j) {
        this.d = aVar;
        super(aVar);
        this.e = j;
        if (this.e == 0) {
            a(true);
        }
    }

    public void close() {
        if (!this.b) {
            if (!(this.e == 0 || c.a((Source) this, 100, TimeUnit.MILLISECONDS))) {
                a(false);
            }
            this.b = true;
        }
    }

    public long read(d dVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.b) {
            throw new IllegalStateException("closed");
        } else if (this.e == 0) {
            return -1;
        } else {
            long read = this.d.c.read(dVar, Math.min(this.e, j));
            if (read == -1) {
                a(false);
                throw new ProtocolException("unexpected end of stream");
            }
            this.e -= read;
            if (this.e == 0) {
                a(true);
            }
            return read;
        }
    }
}
