package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

final class k implements BufferedSink {
    public final d a = new d();
    public final Sink b;
    boolean c;

    k(Sink sink) {
        if (sink == null) {
            throw new NullPointerException("sink == null");
        }
        this.b = sink;
    }

    public d buffer() {
        return this.a;
    }

    public void close() {
        if (!this.c) {
            Throwable th = null;
            try {
                if (this.a.b > 0) {
                    this.b.write(this.a, this.a.b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.c = true;
            if (th != null) {
                q.a(th);
            }
        }
    }

    public BufferedSink emit() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long a = this.a.a();
        if (a > 0) {
            this.b.write(this.a, a);
        }
        return this;
    }

    public BufferedSink emitCompleteSegments() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long c = this.a.c();
        if (c > 0) {
            this.b.write(this.a, c);
        }
        return this;
    }

    public void flush() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (this.a.b > 0) {
            this.b.write(this.a, this.a.b);
        }
        this.b.flush();
    }

    public OutputStream outputStream() {
        return new OutputStream() {
            public void close() {
                k.this.close();
            }

            public void flush() {
                if (!k.this.c) {
                    k.this.flush();
                }
            }

            public String toString() {
                return k.this + ".outputStream()";
            }

            public void write(int i) {
                if (k.this.c) {
                    throw new IOException("closed");
                }
                k.this.a.writeByte((byte) i);
                k.this.emitCompleteSegments();
            }

            public void write(byte[] bArr, int i, int i2) {
                if (k.this.c) {
                    throw new IOException("closed");
                }
                k.this.a.write(bArr, i, i2);
                k.this.emitCompleteSegments();
            }
        };
    }

    public p timeout() {
        return this.b.timeout();
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }

    public BufferedSink write(ByteString byteString) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.write(byteString);
        return emitCompleteSegments();
    }

    public BufferedSink write(Source source, long j) {
        while (j > 0) {
            long read = source.read(this.a, j);
            if (read == -1) {
                throw new EOFException();
            }
            j -= read;
            emitCompleteSegments();
        }
        return this;
    }

    public BufferedSink write(byte[] bArr) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.write(bArr);
        return emitCompleteSegments();
    }

    public BufferedSink write(byte[] bArr, int i, int i2) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.write(bArr, i, i2);
        return emitCompleteSegments();
    }

    public void write(d dVar, long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.write(dVar, j);
        emitCompleteSegments();
    }

    public long writeAll(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = source.read(this.a, 8192);
            if (read == -1) {
                return j;
            }
            j += read;
            emitCompleteSegments();
        }
    }

    public BufferedSink writeByte(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.writeByte(i);
        return emitCompleteSegments();
    }

    public BufferedSink writeDecimalLong(long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.writeDecimalLong(j);
        return emitCompleteSegments();
    }

    public BufferedSink writeHexadecimalUnsignedLong(long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.writeHexadecimalUnsignedLong(j);
        return emitCompleteSegments();
    }

    public BufferedSink writeInt(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.writeInt(i);
        return emitCompleteSegments();
    }

    public BufferedSink writeIntLe(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.writeIntLe(i);
        return emitCompleteSegments();
    }

    public BufferedSink writeLong(long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.writeLong(j);
        return emitCompleteSegments();
    }

    public BufferedSink writeLongLe(long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.writeLongLe(j);
        return emitCompleteSegments();
    }

    public BufferedSink writeShort(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.writeShort(i);
        return emitCompleteSegments();
    }

    public BufferedSink writeShortLe(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.writeShortLe(i);
        return emitCompleteSegments();
    }

    public BufferedSink writeString(String str, int i, int i2, Charset charset) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.writeString(str, i, i2, charset);
        return emitCompleteSegments();
    }

    public BufferedSink writeString(String str, Charset charset) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.writeString(str, charset);
        return emitCompleteSegments();
    }

    public BufferedSink writeUtf8(String str) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.writeUtf8(str);
        return emitCompleteSegments();
    }

    public BufferedSink writeUtf8(String str, int i, int i2) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.writeUtf8(str, i, i2);
        return emitCompleteSegments();
    }

    public BufferedSink writeUtf8CodePoint(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.writeUtf8CodePoint(i);
        return emitCompleteSegments();
    }
}
