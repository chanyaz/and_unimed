package okhttp3.internal.a;

import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.c;
import okhttp3.s;
import okio.Source;

class d extends b {
    final /* synthetic */ a d;
    private final s e;
    private long f = -1;
    private boolean g = true;

    d(a aVar, s sVar) {
        this.d = aVar;
        super(aVar);
        this.e = sVar;
    }

    private void a() {
        if (this.f != -1) {
            this.d.c.readUtf8LineStrict();
        }
        try {
            this.f = this.d.c.readHexadecimalUnsignedLong();
            String trim = this.d.c.readUtf8LineStrict().trim();
            if (this.f < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f + trim + "\"");
            } else if (this.f == 0) {
                this.g = false;
                okhttp3.internal.http.d.a(this.d.a.g(), this.e, this.d.a());
                a(true);
            }
        } catch (NumberFormatException e) {
            throw new ProtocolException(e.getMessage());
        }
    }

    public void close() {
        if (!this.b) {
            if (this.g && !c.a((Source) this, 100, TimeUnit.MILLISECONDS)) {
                a(false);
            }
            this.b = true;
        }
    }

    public long read(okio.d dVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.b) {
            throw new IllegalStateException("closed");
        } else if (!this.g) {
            return -1;
        } else {
            if (this.f == 0 || this.f == -1) {
                a();
                if (!this.g) {
                    return -1;
                }
            }
            long read = this.d.c.read(dVar, Math.min(j, this.f));
            if (read == -1) {
                a(false);
                throw new ProtocolException("unexpected end of stream");
            }
            this.f -= read;
            return read;
        }
    }
}
