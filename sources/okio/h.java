package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.Inflater;

public final class h implements Source {
    private final BufferedSource a;
    private final Inflater b;
    private int c;
    private boolean d;

    h(BufferedSource bufferedSource, Inflater inflater) {
        if (bufferedSource == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        } else {
            this.a = bufferedSource;
            this.b = inflater;
        }
    }

    private void b() {
        if (this.c != 0) {
            int remaining = this.c - this.b.getRemaining();
            this.c -= remaining;
            this.a.skip((long) remaining);
        }
    }

    public boolean a() {
        if (!this.b.needsInput()) {
            return false;
        }
        b();
        if (this.b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.a.exhausted()) {
            return true;
        } else {
            m mVar = this.a.buffer().a;
            this.c = mVar.c - mVar.b;
            this.b.setInput(mVar.a, mVar.b, this.c);
            return false;
        }
    }

    public void close() {
        if (!this.d) {
            this.b.end();
            this.d = true;
            this.a.close();
        }
    }

    public long read(d dVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.d) {
            throw new IllegalStateException("closed");
        } else if (j == 0) {
            return 0;
        } else {
            boolean a;
            do {
                a = a();
                try {
                    m g = dVar.g(1);
                    int inflate = this.b.inflate(g.a, g.c, 8192 - g.c);
                    if (inflate > 0) {
                        g.c += inflate;
                        dVar.b += (long) inflate;
                        return (long) inflate;
                    } else if (this.b.finished() || this.b.needsDictionary()) {
                        b();
                        if (g.b == g.c) {
                            dVar.a = g.a();
                            n.a(g);
                        }
                        return -1;
                    }
                } catch (Throwable e) {
                    throw new IOException(e);
                }
            } while (!a);
            throw new EOFException("source exhausted prematurely");
        }
    }

    public p timeout() {
        return this.a.timeout();
    }
}
