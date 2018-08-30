package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class g implements Source {
    private int a = 0;
    private final BufferedSource b;
    private final Inflater c;
    private final h d;
    private final CRC32 e = new CRC32();

    public g(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.c = new Inflater(true);
        this.b = i.a(source);
        this.d = new h(this.b, this.c);
    }

    private void a() {
        long indexOf;
        this.b.require(10);
        byte a = this.b.buffer().a(3);
        Object obj = ((a >> 1) & 1) == 1 ? 1 : null;
        if (obj != null) {
            a(this.b.buffer(), 0, 10);
        }
        a("ID1ID2", 8075, this.b.readShort());
        this.b.skip(8);
        if (((a >> 2) & 1) == 1) {
            this.b.require(2);
            if (obj != null) {
                a(this.b.buffer(), 0, 2);
            }
            short readShortLe = this.b.buffer().readShortLe();
            this.b.require((long) readShortLe);
            if (obj != null) {
                a(this.b.buffer(), 0, (long) readShortLe);
            }
            this.b.skip((long) readShortLe);
        }
        if (((a >> 3) & 1) == 1) {
            indexOf = this.b.indexOf((byte) 0);
            if (indexOf == -1) {
                throw new EOFException();
            }
            if (obj != null) {
                a(this.b.buffer(), 0, 1 + indexOf);
            }
            this.b.skip(1 + indexOf);
        }
        if (((a >> 4) & 1) == 1) {
            indexOf = this.b.indexOf((byte) 0);
            if (indexOf == -1) {
                throw new EOFException();
            }
            if (obj != null) {
                a(this.b.buffer(), 0, 1 + indexOf);
            }
            this.b.skip(1 + indexOf);
        }
        if (obj != null) {
            a("FHCRC", this.b.readShortLe(), (short) ((int) this.e.getValue()));
            this.e.reset();
        }
    }

    private void a(String str, int i, int i2) {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}));
        }
    }

    private void a(d dVar, long j, long j2) {
        m mVar = dVar.a;
        while (j >= ((long) (mVar.c - mVar.b))) {
            j -= (long) (mVar.c - mVar.b);
            mVar = mVar.f;
        }
        while (j2 > 0) {
            int i = (int) (((long) mVar.b) + j);
            int min = (int) Math.min((long) (mVar.c - i), j2);
            this.e.update(mVar.a, i, min);
            j2 -= (long) min;
            mVar = mVar.f;
            j = 0;
        }
    }

    private void b() {
        a("CRC", this.b.readIntLe(), (int) this.e.getValue());
        a("ISIZE", this.b.readIntLe(), (int) this.c.getBytesWritten());
    }

    public void close() {
        this.d.close();
    }

    public long read(d dVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j == 0) {
            return 0;
        } else {
            if (this.a == 0) {
                a();
                this.a = 1;
            }
            if (this.a == 1) {
                long j2 = dVar.b;
                long read = this.d.read(dVar, j);
                if (read != -1) {
                    a(dVar, j2, read);
                    return read;
                }
                this.a = 2;
            }
            if (this.a == 2) {
                b();
                this.a = 3;
                if (!this.b.exhausted()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    public p timeout() {
        return this.b.timeout();
    }
}
