package okhttp3.internal.ws;

import java.io.IOException;
import java.util.Random;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.d;

final class h {
    static final /* synthetic */ boolean j = (!h.class.desiredAssertionStatus());
    final boolean a;
    final Random b;
    final BufferedSink c;
    boolean d;
    final d e = new d();
    final i f = new i(this);
    boolean g;
    final byte[] h;
    final byte[] i;

    h(boolean z, BufferedSink bufferedSink, Random random) {
        byte[] bArr = null;
        if (bufferedSink == null) {
            throw new NullPointerException("sink == null");
        } else if (random == null) {
            throw new NullPointerException("random == null");
        } else {
            this.a = z;
            this.c = bufferedSink;
            this.b = random;
            this.h = z ? new byte[4] : null;
            if (z) {
                bArr = new byte[8192];
            }
            this.i = bArr;
        }
    }

    private void b(int i, ByteString byteString) {
        if (!j && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (this.d) {
            throw new IOException("closed");
        } else {
            int g = byteString.g();
            if (((long) g) > 125) {
                throw new IllegalArgumentException("Payload size must be less than or equal to 125");
            }
            this.c.writeByte(i | 128);
            if (this.a) {
                this.c.writeByte(g | 128);
                this.b.nextBytes(this.h);
                this.c.write(this.h);
                byte[] h = byteString.h();
                g.a(h, (long) h.length, this.h, 0);
                this.c.write(h);
            } else {
                this.c.writeByte(g);
                this.c.write(byteString);
            }
            this.c.flush();
        }
    }

    Sink a(int i, long j) {
        if (this.g) {
            throw new IllegalStateException("Another message writer is active. Did you call close()?");
        }
        this.g = true;
        this.f.a = i;
        this.f.b = j;
        this.f.c = true;
        this.f.d = false;
        return this.f;
    }

    void a(int i, long j, boolean z, boolean z2) {
        if (!j && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (this.d) {
            throw new IOException("closed");
        } else {
            int i2 = z ? i : 0;
            if (z2) {
                i2 |= 128;
            }
            this.c.writeByte(i2);
            i2 = this.a ? 128 : 0;
            if (j <= 125) {
                this.c.writeByte(i2 | ((int) j));
            } else if (j <= 65535) {
                this.c.writeByte(i2 | 126);
                this.c.writeShort((int) j);
            } else {
                this.c.writeByte(i2 | 127);
                this.c.writeLong(j);
            }
            if (this.a) {
                this.b.nextBytes(this.h);
                this.c.write(this.h);
                long j2 = 0;
                while (j2 < j) {
                    int read = this.e.read(this.i, 0, (int) Math.min(j, (long) this.i.length));
                    if (read == -1) {
                        throw new AssertionError();
                    }
                    g.a(this.i, (long) read, this.h, j2);
                    this.c.write(this.i, 0, read);
                    j2 += (long) read;
                }
            } else {
                this.c.write(this.e, j);
            }
            this.c.emit();
        }
    }

    void a(int i, ByteString byteString) {
        ByteString byteString2 = ByteString.b;
        if (!(i == 0 && byteString == null)) {
            if (i != 0) {
                g.b(i);
            }
            d dVar = new d();
            dVar.writeShort(i);
            if (byteString != null) {
                dVar.write(byteString);
            }
            byteString2 = dVar.readByteString();
        }
        synchronized (this) {
            try {
                b(8, byteString2);
                this.d = true;
            } catch (Throwable th) {
                this.d = true;
            }
        }
    }

    void a(ByteString byteString) {
        synchronized (this) {
            b(9, byteString);
        }
    }

    void b(ByteString byteString) {
        synchronized (this) {
            b(10, byteString);
        }
    }
}
