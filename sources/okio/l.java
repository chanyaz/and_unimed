package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

final class l implements BufferedSource {
    public final d a = new d();
    public final Source b;
    boolean c;

    l(Source source) {
        if (source == null) {
            throw new NullPointerException("source == null");
        }
        this.b = source;
    }

    public d buffer() {
        return this.a;
    }

    public void close() {
        if (!this.c) {
            this.c = true;
            this.b.close();
            this.a.d();
        }
    }

    public boolean exhausted() {
        if (!this.c) {
            return this.a.exhausted() && this.b.read(this.a, 8192) == -1;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public long indexOf(byte b) {
        return indexOf(b, 0, Long.MAX_VALUE);
    }

    public long indexOf(byte b, long j) {
        return indexOf(b, j, Long.MAX_VALUE);
    }

    public long indexOf(byte b, long j, long j2) {
        if (this.c) {
            throw new IllegalStateException("closed");
        } else if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
        } else {
            long j3 = j;
            while (j3 < j2) {
                long indexOf = this.a.indexOf(b, j3, j2);
                if (indexOf != -1) {
                    return indexOf;
                }
                indexOf = this.a.b;
                if (indexOf >= j2 || this.b.read(this.a, 8192) == -1) {
                    return -1;
                }
                j3 = Math.max(j3, indexOf);
            }
            return -1;
        }
    }

    public long indexOf(ByteString byteString) {
        return indexOf(byteString, 0);
    }

    public long indexOf(ByteString byteString, long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long indexOf = this.a.indexOf(byteString, j);
            if (indexOf != -1) {
                return indexOf;
            }
            indexOf = this.a.b;
            if (this.b.read(this.a, 8192) == -1) {
                return -1;
            }
            j = Math.max(j, (indexOf - ((long) byteString.g())) + 1);
        }
    }

    public long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0);
    }

    public long indexOfElement(ByteString byteString, long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long indexOfElement = this.a.indexOfElement(byteString, j);
            if (indexOfElement != -1) {
                return indexOfElement;
            }
            indexOfElement = this.a.b;
            if (this.b.read(this.a, 8192) == -1) {
                return -1;
            }
            j = Math.max(j, indexOfElement);
        }
    }

    public InputStream inputStream() {
        return new InputStream() {
            public int available() {
                if (!l.this.c) {
                    return (int) Math.min(l.this.a.b, 2147483647L);
                }
                throw new IOException("closed");
            }

            public void close() {
                l.this.close();
            }

            public int read() {
                if (!l.this.c) {
                    return (l.this.a.b == 0 && l.this.b.read(l.this.a, 8192) == -1) ? -1 : l.this.a.readByte() & 255;
                } else {
                    throw new IOException("closed");
                }
            }

            public int read(byte[] bArr, int i, int i2) {
                if (l.this.c) {
                    throw new IOException("closed");
                }
                q.a((long) bArr.length, (long) i, (long) i2);
                return (l.this.a.b == 0 && l.this.b.read(l.this.a, 8192) == -1) ? -1 : l.this.a.read(bArr, i, i2);
            }

            public String toString() {
                return l.this + ".inputStream()";
            }
        };
    }

    public boolean rangeEquals(long j, ByteString byteString) {
        return rangeEquals(j, byteString, 0, byteString.g());
    }

    public boolean rangeEquals(long j, ByteString byteString, int i, int i2) {
        if (this.c) {
            throw new IllegalStateException("closed");
        } else if (j < 0 || i < 0 || i2 < 0 || byteString.g() - i < i2) {
            return false;
        } else {
            int i3 = 0;
            while (i3 < i2) {
                long j2 = ((long) i3) + j;
                if (!request(1 + j2) || this.a.a(j2) != byteString.a(i + i3)) {
                    return false;
                }
                i3++;
            }
            return true;
        }
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        q.a((long) bArr.length, (long) i, (long) i2);
        if (this.a.b == 0 && this.b.read(this.a, 8192) == -1) {
            return -1;
        }
        return this.a.read(bArr, i, (int) Math.min((long) i2, this.a.b));
    }

    public long read(d dVar, long j) {
        if (dVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.c) {
            throw new IllegalStateException("closed");
        } else if (this.a.b == 0 && this.b.read(this.a, 8192) == -1) {
            return -1;
        } else {
            return this.a.read(dVar, Math.min(j, this.a.b));
        }
    }

    public long readAll(Sink sink) {
        if (sink == null) {
            throw new IllegalArgumentException("sink == null");
        }
        long j = 0;
        while (this.b.read(this.a, 8192) != -1) {
            long c = this.a.c();
            if (c > 0) {
                j += c;
                sink.write(this.a, c);
            }
        }
        if (this.a.a() <= 0) {
            return j;
        }
        j += this.a.a();
        sink.write(this.a, this.a.a());
        return j;
    }

    public byte readByte() {
        require(1);
        return this.a.readByte();
    }

    public byte[] readByteArray() {
        this.a.writeAll(this.b);
        return this.a.readByteArray();
    }

    public byte[] readByteArray(long j) {
        require(j);
        return this.a.readByteArray(j);
    }

    public ByteString readByteString() {
        this.a.writeAll(this.b);
        return this.a.readByteString();
    }

    public ByteString readByteString(long j) {
        require(j);
        return this.a.readByteString(j);
    }

    public long readDecimalLong() {
        require(1);
        int i = 0;
        while (request((long) (i + 1))) {
            byte a = this.a.a((long) i);
            if ((a < (byte) 48 || a > (byte) 57) && !(i == 0 && a == (byte) 45)) {
                if (i == 0) {
                    throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", new Object[]{Byte.valueOf(a)}));
                }
                return this.a.readDecimalLong();
            }
            i++;
        }
        return this.a.readDecimalLong();
    }

    public void readFully(d dVar, long j) {
        try {
            require(j);
            this.a.readFully(dVar, j);
        } catch (EOFException e) {
            dVar.writeAll(this.a);
            throw e;
        }
    }

    public void readFully(byte[] bArr) {
        try {
            require((long) bArr.length);
            this.a.readFully(bArr);
        } catch (EOFException e) {
            EOFException eOFException = e;
            int i = 0;
            while (this.a.b > 0) {
                int read = this.a.read(bArr, i, (int) this.a.b);
                if (read == -1) {
                    throw new AssertionError();
                }
                i += read;
            }
            throw eOFException;
        }
    }

    public long readHexadecimalUnsignedLong() {
        require(1);
        for (int i = 0; request((long) (i + 1)); i++) {
            byte a = this.a.a((long) i);
            if ((a < (byte) 48 || a > (byte) 57) && ((a < (byte) 97 || a > (byte) 102) && (a < (byte) 65 || a > (byte) 70))) {
                if (i == 0) {
                    throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(a)}));
                }
                return this.a.readHexadecimalUnsignedLong();
            }
        }
        return this.a.readHexadecimalUnsignedLong();
    }

    public int readInt() {
        require(4);
        return this.a.readInt();
    }

    public int readIntLe() {
        require(4);
        return this.a.readIntLe();
    }

    public long readLong() {
        require(8);
        return this.a.readLong();
    }

    public long readLongLe() {
        require(8);
        return this.a.readLongLe();
    }

    public short readShort() {
        require(2);
        return this.a.readShort();
    }

    public short readShortLe() {
        require(2);
        return this.a.readShortLe();
    }

    public String readString(long j, Charset charset) {
        require(j);
        if (charset != null) {
            return this.a.readString(j, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public String readString(Charset charset) {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.a.writeAll(this.b);
        return this.a.readString(charset);
    }

    public String readUtf8() {
        this.a.writeAll(this.b);
        return this.a.readUtf8();
    }

    public String readUtf8(long j) {
        require(j);
        return this.a.readUtf8(j);
    }

    public int readUtf8CodePoint() {
        require(1);
        byte a = this.a.a(0);
        if ((a & 224) == 192) {
            require(2);
        } else if ((a & 240) == 224) {
            require(3);
        } else if ((a & 248) == 240) {
            require(4);
        }
        return this.a.readUtf8CodePoint();
    }

    @Nullable
    public String readUtf8Line() {
        long indexOf = indexOf((byte) 10);
        return indexOf == -1 ? this.a.b != 0 ? readUtf8(this.a.b) : null : this.a.b(indexOf);
    }

    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    public String readUtf8LineStrict(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long indexOf = indexOf((byte) 10, 0, j2);
        if (indexOf != -1) {
            return this.a.b(indexOf);
        }
        if (j2 < Long.MAX_VALUE && request(j2) && this.a.a(j2 - 1) == (byte) 13 && request(1 + j2) && this.a.a(j2) == (byte) 10) {
            return this.a.b(j2);
        }
        d dVar = new d();
        this.a.a(dVar, 0, Math.min(32, this.a.a()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.a.a(), j) + " content=" + dVar.readByteString().e() + 8230);
    }

    public boolean request(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.c) {
            throw new IllegalStateException("closed");
        } else {
            while (this.a.b < j) {
                if (this.b.read(this.a, 8192) == -1) {
                    return false;
                }
            }
            return true;
        }
    }

    public void require(long j) {
        if (!request(j)) {
            throw new EOFException();
        }
    }

    public int select(j jVar) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        do {
            int a = this.a.a(jVar);
            if (a == -1) {
                return -1;
            }
            int g = jVar.a[a].g();
            if (((long) g) <= this.a.b) {
                this.a.skip((long) g);
                return a;
            }
        } while (this.b.read(this.a, 8192) != -1);
        return -1;
    }

    public void skip(long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.a.b == 0 && this.b.read(this.a, 8192) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.a.a());
            this.a.skip(min);
            j -= min;
        }
    }

    public p timeout() {
        return this.b.timeout();
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }
}
