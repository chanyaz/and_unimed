package okio;

import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

public final class d implements Cloneable, BufferedSink, BufferedSource {
    private static final byte[] c = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102};
    @Nullable
    m a;
    long b;

    private boolean a(m mVar, int i, ByteString byteString, int i2, int i3) {
        int i4 = mVar.c;
        byte[] bArr = mVar.a;
        int i5 = i;
        m mVar2 = mVar;
        while (i2 < i3) {
            if (i5 == i4) {
                mVar2 = mVar2.f;
                bArr = mVar2.a;
                i5 = mVar2.b;
                i4 = mVar2.c;
            }
            if (bArr[i5] != byteString.a(i2)) {
                return false;
            }
            i5++;
            i2++;
        }
        return true;
    }

    public byte a(long j) {
        q.a(this.b, j, 1);
        m mVar = this.a;
        while (true) {
            int i = mVar.c - mVar.b;
            if (j < ((long) i)) {
                return mVar.a[mVar.b + ((int) j)];
            }
            j -= (long) i;
            mVar = mVar.f;
        }
    }

    int a(j jVar) {
        m mVar = this.a;
        ByteString[] byteStringArr = jVar.a;
        int length = byteStringArr.length;
        int i = 0;
        while (i < length) {
            ByteString byteString = byteStringArr[i];
            int min = (int) Math.min(this.b, (long) byteString.g());
            if (min != 0) {
                if (!a(mVar, mVar.b, byteString, 0, min)) {
                    i++;
                }
            }
            return i;
        }
        return -1;
    }

    public long a() {
        return this.b;
    }

    /* renamed from: a */
    public d writeUtf8CodePoint(int i) {
        if (i < 128) {
            writeByte(i);
        } else if (i < 2048) {
            writeByte((i >> 6) | 192);
            writeByte((i & 63) | 128);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                writeByte((i >> 12) | 224);
                writeByte(((i >> 6) & 63) | 128);
                writeByte((i & 63) | 128);
            } else {
                writeByte(63);
            }
        } else if (i <= 1114111) {
            writeByte((i >> 18) | 240);
            writeByte(((i >> 12) & 63) | 128);
            writeByte(((i >> 6) & 63) | 128);
            writeByte((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    /* renamed from: a */
    public d writeUtf8(String str) {
        return writeUtf8(str, 0, str.length());
    }

    /* renamed from: a */
    public d writeUtf8(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else {
            while (i < i2) {
                int i3;
                char charAt = str.charAt(i);
                if (charAt < 128) {
                    int i4;
                    m g = g(1);
                    byte[] bArr = g.a;
                    int i5 = g.c - i;
                    int min = Math.min(i2, 8192 - i5);
                    i3 = i + 1;
                    bArr[i5 + i] = (byte) charAt;
                    while (i3 < min) {
                        char charAt2 = str.charAt(i3);
                        if (charAt2 >= 128) {
                            break;
                        }
                        i4 = i3 + 1;
                        bArr[i3 + i5] = (byte) charAt2;
                        i3 = i4;
                    }
                    i4 = (i3 + i5) - g.c;
                    g.c += i4;
                    this.b += (long) i4;
                } else if (charAt < 2048) {
                    writeByte((charAt >> 6) | 192);
                    writeByte((charAt & 63) | 128);
                    i3 = i + 1;
                } else if (charAt < 55296 || charAt > 57343) {
                    writeByte((charAt >> 12) | 224);
                    writeByte(((charAt >> 6) & 63) | 128);
                    writeByte((charAt & 63) | 128);
                    i3 = i + 1;
                } else {
                    i3 = i + 1 < i2 ? str.charAt(i + 1) : 0;
                    if (charAt > 56319 || i3 < 56320 || i3 > 57343) {
                        writeByte(63);
                        i++;
                    } else {
                        i3 = ((i3 & -56321) | ((charAt & -55297) << 10)) + 65536;
                        writeByte((i3 >> 18) | 240);
                        writeByte(((i3 >> 12) & 63) | 128);
                        writeByte(((i3 >> 6) & 63) | 128);
                        writeByte((i3 & 63) | 128);
                        i3 = i + 2;
                    }
                }
                i = i3;
            }
            return this;
        }
    }

    /* renamed from: a */
    public d writeString(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(q.a)) {
            return writeUtf8(str, i, i2);
        } else {
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            return write(bytes, 0, bytes.length);
        }
    }

    /* renamed from: a */
    public d writeString(String str, Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }

    /* renamed from: a */
    public d write(ByteString byteString) {
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.a(this);
        return this;
    }

    public d a(d dVar, long j, long j2) {
        if (dVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        q.a(this.b, j, j2);
        if (j2 != 0) {
            dVar.b += j2;
            m mVar = this.a;
            while (j >= ((long) (mVar.c - mVar.b))) {
                j -= (long) (mVar.c - mVar.b);
                mVar = mVar.f;
            }
            while (j2 > 0) {
                m mVar2 = new m(mVar);
                mVar2.b = (int) (((long) mVar2.b) + j);
                mVar2.c = Math.min(mVar2.b + ((int) j2), mVar2.c);
                if (dVar.a == null) {
                    mVar2.g = mVar2;
                    mVar2.f = mVar2;
                    dVar.a = mVar2;
                } else {
                    dVar.a.g.a(mVar2);
                }
                j2 -= (long) (mVar2.c - mVar2.b);
                mVar = mVar.f;
                j = 0;
            }
        }
        return this;
    }

    /* renamed from: a */
    public d write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: a */
    public d write(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        q.a((long) bArr.length, (long) i, (long) i2);
        int i3 = i + i2;
        while (i < i3) {
            m g = g(1);
            int min = Math.min(i3 - i, 8192 - g.c);
            System.arraycopy(bArr, i, g.a, g.c, min);
            i += min;
            g.c = min + g.c;
        }
        this.b += (long) i2;
        return this;
    }

    String b(long j) {
        String readUtf8;
        if (j <= 0 || a(j - 1) != (byte) 13) {
            readUtf8 = readUtf8(j);
            skip(1);
            return readUtf8;
        }
        readUtf8 = readUtf8(j - 1);
        skip(2);
        return readUtf8;
    }

    /* renamed from: b */
    public d emitCompleteSegments() {
        return this;
    }

    /* renamed from: b */
    public d writeByte(int i) {
        m g = g(1);
        byte[] bArr = g.a;
        int i2 = g.c;
        g.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.b++;
        return this;
    }

    public d buffer() {
        return this;
    }

    public long c() {
        long j = this.b;
        if (j == 0) {
            return 0;
        }
        m mVar = this.a.g;
        return (mVar.c >= 8192 || !mVar.e) ? j : j - ((long) (mVar.c - mVar.b));
    }

    /* renamed from: c */
    public d writeShort(int i) {
        m g = g(2);
        byte[] bArr = g.a;
        int i2 = g.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & 255);
        g.c = i2;
        this.b += 2;
        return this;
    }

    /* renamed from: c */
    public d writeLong(long j) {
        m g = g(8);
        byte[] bArr = g.a;
        int i = g.c;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 56) & 255));
        i = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 48) & 255));
        i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 40) & 255));
        i = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 32) & 255));
        i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 24) & 255));
        i = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 16) & 255));
        i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 8) & 255));
        i = i2 + 1;
        bArr[i2] = (byte) ((int) (j & 255));
        g.c = i;
        this.b += 8;
        return this;
    }

    public void close() {
    }

    /* renamed from: d */
    public d writeShortLe(int i) {
        return writeShort(q.a((short) i));
    }

    /* renamed from: d */
    public d writeLongLe(long j) {
        return writeLong(q.a(j));
    }

    public void d() {
        try {
            skip(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: e */
    public d clone() {
        d dVar = new d();
        if (this.b == 0) {
            return dVar;
        }
        dVar.a = new m(this.a);
        m mVar = dVar.a;
        m mVar2 = dVar.a;
        m mVar3 = dVar.a;
        mVar2.g = mVar3;
        mVar.f = mVar3;
        for (mVar = this.a.f; mVar != this.a; mVar = mVar.f) {
            dVar.a.g.a(new m(mVar));
        }
        dVar.b = this.b;
        return dVar;
    }

    /* renamed from: e */
    public d writeInt(int i) {
        m g = g(4);
        byte[] bArr = g.a;
        int i2 = g.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & 255);
        g.c = i2;
        this.b += 4;
        return this;
    }

    /* renamed from: e */
    public d writeDecimalLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        long j2;
        Object obj;
        if (j < 0) {
            j2 = -j;
            if (j2 < 0) {
                return writeUtf8("-9223372036854775808");
            }
            obj = 1;
        } else {
            obj = null;
            j2 = j;
        }
        int i = j2 < 100000000 ? j2 < 10000 ? j2 < 100 ? j2 < 10 ? 1 : 2 : j2 < 1000 ? 3 : 4 : j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8 : j2 < 1000000000000L ? j2 < 10000000000L ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        if (obj != null) {
            i++;
        }
        m g = g(i);
        byte[] bArr = g.a;
        int i2 = g.c + i;
        while (j2 != 0) {
            i2--;
            bArr[i2] = c[(int) (j2 % 10)];
            j2 /= 10;
        }
        if (obj != null) {
            bArr[i2 - 1] = (byte) 45;
        }
        g.c += i;
        this.b = ((long) i) + this.b;
        return this;
    }

    public BufferedSink emit() {
        return this;
    }

    public boolean equals(Object obj) {
        long j = 0;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.b != dVar.b) {
            return false;
        }
        if (this.b == 0) {
            return true;
        }
        m mVar = this.a;
        m mVar2 = dVar.a;
        int i = mVar.b;
        int i2 = mVar2.b;
        while (j < this.b) {
            long min = (long) Math.min(mVar.c - i, mVar2.c - i2);
            int i3 = 0;
            while (((long) i3) < min) {
                int i4 = i + 1;
                byte b = mVar.a[i];
                i = i2 + 1;
                if (b != mVar2.a[i2]) {
                    return false;
                }
                i3++;
                i2 = i;
                i = i4;
            }
            if (i == mVar.c) {
                mVar = mVar.f;
                i = mVar.b;
            }
            if (i2 == mVar2.c) {
                mVar2 = mVar2.f;
                i2 = mVar2.b;
            }
            j += min;
        }
        return true;
    }

    public boolean exhausted() {
        return this.b == 0;
    }

    public ByteString f() {
        if (this.b <= 2147483647L) {
            return h((int) this.b);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.b);
    }

    /* renamed from: f */
    public d writeIntLe(int i) {
        return writeInt(q.a(i));
    }

    /* renamed from: f */
    public d writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        m g = g(numberOfTrailingZeros);
        byte[] bArr = g.a;
        int i = g.c;
        for (int i2 = (g.c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = c[(int) (15 & j)];
            j >>>= 4;
        }
        g.c += numberOfTrailingZeros;
        this.b = ((long) numberOfTrailingZeros) + this.b;
        return this;
    }

    public void flush() {
    }

    m g(int i) {
        m mVar;
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        } else if (this.a == null) {
            this.a = n.a();
            m mVar2 = this.a;
            m mVar3 = this.a;
            mVar = this.a;
            mVar3.g = mVar;
            mVar2.f = mVar;
            return mVar;
        } else {
            mVar = this.a.g;
            return (mVar.c + i > 8192 || !mVar.e) ? mVar.a(n.a()) : mVar;
        }
    }

    public ByteString h(int i) {
        return i == 0 ? ByteString.b : new o(this, i);
    }

    public int hashCode() {
        m mVar = this.a;
        if (mVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = mVar.b;
            while (i2 < mVar.c) {
                int i3 = mVar.a[i2] + (i * 31);
                i2++;
                i = i3;
            }
            mVar = mVar.f;
        } while (mVar != this.a);
        return i;
    }

    public long indexOf(byte b) {
        return indexOf(b, 0, Long.MAX_VALUE);
    }

    public long indexOf(byte b, long j) {
        return indexOf(b, j, Long.MAX_VALUE);
    }

    public long indexOf(byte b, long j, long j2) {
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.b), Long.valueOf(j), Long.valueOf(j2)}));
        }
        if (j2 > this.b) {
            j2 = this.b;
        }
        if (j == j2) {
            return -1;
        }
        m mVar = this.a;
        if (mVar == null) {
            return -1;
        }
        long j3;
        m mVar2;
        long j4;
        if (this.b - j >= j) {
            j3 = 0;
            mVar2 = mVar;
            while (true) {
                j4 = ((long) (mVar2.c - mVar2.b)) + j3;
                if (j4 >= j) {
                    break;
                }
                mVar2 = mVar2.f;
                j3 = j4;
            }
        } else {
            j3 = this.b;
            mVar2 = mVar;
            while (true) {
                j4 = (j3 > j ? 1 : (j3 == j ? 0 : -1));
                if (j4 <= null) {
                    break;
                }
                mVar2 = mVar2.g;
                j3 -= (long) (mVar2.c - mVar2.b);
            }
        }
        while (true) {
            j = j3;
            if (j4 >= j2) {
                return -1;
            }
            byte[] bArr = mVar2.a;
            int min = (int) Math.min((long) mVar2.c, (((long) mVar2.b) + j2) - j4);
            for (int i = (int) ((((long) mVar2.b) + j) - j4); i < min; i++) {
                if (bArr[i] == b) {
                    return ((long) (i - mVar2.b)) + j4;
                }
            }
            j3 = ((long) (mVar2.c - mVar2.b)) + j4;
            mVar2 = mVar2.f;
            j4 = j3;
        }
    }

    public long indexOf(ByteString byteString) {
        return indexOf(byteString, 0);
    }

    public long indexOf(ByteString byteString, long j) {
        if (byteString.g() == 0) {
            throw new IllegalArgumentException("bytes is empty");
        } else if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        } else {
            m mVar = this.a;
            if (mVar == null) {
                return -1;
            }
            long j2;
            m mVar2;
            long j3;
            if (this.b - j >= j) {
                j2 = 0;
                mVar2 = mVar;
                while (true) {
                    j3 = ((long) (mVar2.c - mVar2.b)) + j2;
                    if (j3 >= j) {
                        break;
                    }
                    mVar2 = mVar2.f;
                    j2 = j3;
                }
            } else {
                j2 = this.b;
                mVar2 = mVar;
                while (j2 > j) {
                    mVar2 = mVar2.g;
                    j2 -= (long) (mVar2.c - mVar2.b);
                }
            }
            byte a = byteString.a(0);
            int g = byteString.g();
            long j4 = (this.b - ((long) g)) + 1;
            long j5 = j2;
            m mVar3 = mVar2;
            while (j5 < j4) {
                byte[] bArr = mVar3.a;
                int min = (int) Math.min((long) mVar3.c, (((long) mVar3.b) + j4) - j5);
                for (int i = (int) ((((long) mVar3.b) + j) - j5); i < min; i++) {
                    if (bArr[i] == a) {
                        if (a(mVar3, i + 1, byteString, 1, g)) {
                            return ((long) (i - mVar3.b)) + j5;
                        }
                    }
                }
                j3 = ((long) (mVar3.c - mVar3.b)) + j5;
                mVar3 = mVar3.f;
                j5 = j3;
                j = j3;
            }
            return -1;
        }
    }

    public long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0);
    }

    public long indexOfElement(ByteString byteString, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        m mVar = this.a;
        if (mVar == null) {
            return -1;
        }
        long j2;
        m mVar2;
        if (this.b - j >= j) {
            j2 = 0;
            mVar2 = mVar;
            while (true) {
                long j3 = ((long) (mVar2.c - mVar2.b)) + j2;
                if (j3 >= j) {
                    break;
                }
                mVar2 = mVar2.f;
                j2 = j3;
            }
        } else {
            j2 = this.b;
            mVar2 = mVar;
            while (j2 > j) {
                mVar2 = mVar2.g;
                j2 -= (long) (mVar2.c - mVar2.b);
            }
        }
        byte[] bArr;
        int i;
        int i2;
        byte b;
        if (byteString.g() == 2) {
            byte a = byteString.a(0);
            byte a2 = byteString.a(1);
            while (j2 < this.b) {
                bArr = mVar2.a;
                i = mVar2.c;
                for (i2 = (int) ((((long) mVar2.b) + j) - j2); i2 < i; i2++) {
                    b = bArr[i2];
                    if (b == a || b == a2) {
                        return j2 + ((long) (i2 - mVar2.b));
                    }
                }
                j2 += (long) (mVar2.c - mVar2.b);
                mVar2 = mVar2.f;
                j = j2;
            }
        } else {
            byte[] i3 = byteString.i();
            while (j2 < this.b) {
                bArr = mVar2.a;
                i2 = (int) ((((long) mVar2.b) + j) - j2);
                i = mVar2.c;
                for (int i4 = i2; i4 < i; i4++) {
                    b = bArr[i4];
                    for (byte b2 : i3) {
                        if (b == b2) {
                            return j2 + ((long) (i4 - mVar2.b));
                        }
                    }
                }
                j2 += (long) (mVar2.c - mVar2.b);
                mVar2 = mVar2.f;
                j = j2;
            }
        }
        return -1;
    }

    public InputStream inputStream() {
        return new InputStream() {
            public int available() {
                return (int) Math.min(d.this.b, 2147483647L);
            }

            public void close() {
            }

            public int read() {
                return d.this.b > 0 ? d.this.readByte() & 255 : -1;
            }

            public int read(byte[] bArr, int i, int i2) {
                return d.this.read(bArr, i, i2);
            }

            public String toString() {
                return d.this + ".inputStream()";
            }
        };
    }

    public OutputStream outputStream() {
        return new OutputStream() {
            public void close() {
            }

            public void flush() {
            }

            public String toString() {
                return d.this + ".outputStream()";
            }

            public void write(int i) {
                d.this.writeByte((byte) i);
            }

            public void write(byte[] bArr, int i, int i2) {
                d.this.write(bArr, i, i2);
            }
        };
    }

    public boolean rangeEquals(long j, ByteString byteString) {
        return rangeEquals(j, byteString, 0, byteString.g());
    }

    public boolean rangeEquals(long j, ByteString byteString, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.b - j < ((long) i2) || byteString.g() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (a(((long) i3) + j) != byteString.a(i + i3)) {
                return false;
            }
        }
        return true;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        q.a((long) bArr.length, (long) i, (long) i2);
        m mVar = this.a;
        if (mVar == null) {
            return -1;
        }
        int min = Math.min(i2, mVar.c - mVar.b);
        System.arraycopy(mVar.a, mVar.b, bArr, i, min);
        mVar.b += min;
        this.b -= (long) min;
        if (mVar.b != mVar.c) {
            return min;
        }
        this.a = mVar.a();
        n.a(mVar);
        return min;
    }

    public long read(d dVar, long j) {
        if (dVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.b == 0) {
            return -1;
        } else {
            if (j > this.b) {
                j = this.b;
            }
            dVar.write(this, j);
            return j;
        }
    }

    public long readAll(Sink sink) {
        long j = this.b;
        if (j > 0) {
            sink.write(this, j);
        }
        return j;
    }

    public byte readByte() {
        if (this.b == 0) {
            throw new IllegalStateException("size == 0");
        }
        m mVar = this.a;
        int i = mVar.b;
        int i2 = mVar.c;
        int i3 = i + 1;
        byte b = mVar.a[i];
        this.b--;
        if (i3 == i2) {
            this.a = mVar.a();
            n.a(mVar);
        } else {
            mVar.b = i3;
        }
        return b;
    }

    public byte[] readByteArray() {
        try {
            return readByteArray(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public byte[] readByteArray(long j) {
        q.a(this.b, 0, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[((int) j)];
        readFully(bArr);
        return bArr;
    }

    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    public ByteString readByteString(long j) {
        return new ByteString(readByteArray(j));
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cd A:{SYNTHETIC, EDGE_INSN: B:41:0x00cd->B:37:0x00cd ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c7  */
    public long readDecimalLong() {
        /*
        r20 = this;
        r0 = r20;
        r2 = r0.b;
        r4 = 0;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x0012;
    L_0x000a:
        r2 = new java.lang.IllegalStateException;
        r3 = "size == 0";
        r2.<init>(r3);
        throw r2;
    L_0x0012:
        r8 = 0;
        r6 = 0;
        r5 = 0;
        r4 = 0;
        r10 = -922337203685477580; // 0xf333333333333334 float:4.1723254E-8 double:-8.390303882365713E246;
        r2 = -7;
    L_0x001e:
        r0 = r20;
        r12 = r0.a;
        r13 = r12.a;
        r7 = r12.b;
        r14 = r12.c;
    L_0x0028:
        if (r7 >= r14) goto L_0x00b8;
    L_0x002a:
        r15 = r13[r7];
        r16 = 48;
        r0 = r16;
        if (r15 < r0) goto L_0x008a;
    L_0x0032:
        r16 = 57;
        r0 = r16;
        if (r15 > r0) goto L_0x008a;
    L_0x0038:
        r16 = 48 - r15;
        r17 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r17 < 0) goto L_0x004b;
    L_0x003e:
        r17 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r17 != 0) goto L_0x007a;
    L_0x0042:
        r0 = r16;
        r0 = (long) r0;
        r18 = r0;
        r17 = (r18 > r2 ? 1 : (r18 == r2 ? 0 : -1));
        if (r17 >= 0) goto L_0x007a;
    L_0x004b:
        r2 = new okio.d;
        r2.<init>();
        r2 = r2.writeDecimalLong(r8);
        r2 = r2.writeByte(r15);
        if (r5 != 0) goto L_0x005d;
    L_0x005a:
        r2.readByte();
    L_0x005d:
        r3 = new java.lang.NumberFormatException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Number too large: ";
        r4 = r4.append(r5);
        r2 = r2.readUtf8();
        r2 = r4.append(r2);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x007a:
        r18 = 10;
        r8 = r8 * r18;
        r0 = r16;
        r0 = (long) r0;
        r16 = r0;
        r8 = r8 + r16;
    L_0x0085:
        r7 = r7 + 1;
        r6 = r6 + 1;
        goto L_0x0028;
    L_0x008a:
        r16 = 45;
        r0 = r16;
        if (r15 != r0) goto L_0x0098;
    L_0x0090:
        if (r6 != 0) goto L_0x0098;
    L_0x0092:
        r5 = 1;
        r16 = 1;
        r2 = r2 - r16;
        goto L_0x0085;
    L_0x0098:
        if (r6 != 0) goto L_0x00b7;
    L_0x009a:
        r2 = new java.lang.NumberFormatException;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Expected leading [0-9] or '-' character but was 0x";
        r3 = r3.append(r4);
        r4 = java.lang.Integer.toHexString(r15);
        r3 = r3.append(r4);
        r3 = r3.toString();
        r2.<init>(r3);
        throw r2;
    L_0x00b7:
        r4 = 1;
    L_0x00b8:
        if (r7 != r14) goto L_0x00da;
    L_0x00ba:
        r7 = r12.a();
        r0 = r20;
        r0.a = r7;
        okio.n.a(r12);
    L_0x00c5:
        if (r4 != 0) goto L_0x00cd;
    L_0x00c7:
        r0 = r20;
        r7 = r0.a;
        if (r7 != 0) goto L_0x001e;
    L_0x00cd:
        r0 = r20;
        r2 = r0.b;
        r6 = (long) r6;
        r2 = r2 - r6;
        r0 = r20;
        r0.b = r2;
        if (r5 == 0) goto L_0x00dd;
    L_0x00d9:
        return r8;
    L_0x00da:
        r12.b = r7;
        goto L_0x00c5;
    L_0x00dd:
        r8 = -r8;
        goto L_0x00d9;
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.d.readDecimalLong():long");
    }

    public void readFully(d dVar, long j) {
        if (this.b < j) {
            dVar.write(this, this.b);
            throw new EOFException();
        } else {
            dVar.write(this, j);
        }
    }

    public void readFully(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            int read = read(bArr, i, bArr.length - i);
            if (read == -1) {
                throw new EOFException();
            }
            i += read;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b1 A:{SYNTHETIC, EDGE_INSN: B:39:0x00b1->B:35:0x00b1 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ab  */
    public long readHexadecimalUnsignedLong() {
        /*
        r18 = this;
        r0 = r18;
        r2 = r0.b;
        r4 = 0;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x0012;
    L_0x000a:
        r2 = new java.lang.IllegalStateException;
        r3 = "size == 0";
        r2.<init>(r3);
        throw r2;
    L_0x0012:
        r4 = 0;
        r3 = 0;
        r2 = 0;
    L_0x0016:
        r0 = r18;
        r10 = r0.a;
        r11 = r10.a;
        r6 = r10.b;
        r12 = r10.c;
        r7 = r6;
    L_0x0021:
        if (r7 >= r12) goto L_0x009c;
    L_0x0023:
        r8 = r11[r7];
        r6 = 48;
        if (r8 < r6) goto L_0x0062;
    L_0x0029:
        r6 = 57;
        if (r8 > r6) goto L_0x0062;
    L_0x002d:
        r6 = r8 + -48;
    L_0x002f:
        r14 = -1152921504606846976; // 0xf000000000000000 float:0.0 double:-3.105036184601418E231;
        r14 = r14 & r4;
        r16 = 0;
        r9 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));
        if (r9 == 0) goto L_0x00bd;
    L_0x0038:
        r2 = new okio.d;
        r2.<init>();
        r2 = r2.writeHexadecimalUnsignedLong(r4);
        r2 = r2.writeByte(r8);
        r3 = new java.lang.NumberFormatException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Number too large: ";
        r4 = r4.append(r5);
        r2 = r2.readUtf8();
        r2 = r4.append(r2);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x0062:
        r6 = 97;
        if (r8 < r6) goto L_0x006f;
    L_0x0066:
        r6 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        if (r8 > r6) goto L_0x006f;
    L_0x006a:
        r6 = r8 + -97;
        r6 = r6 + 10;
        goto L_0x002f;
    L_0x006f:
        r6 = 65;
        if (r8 < r6) goto L_0x007c;
    L_0x0073:
        r6 = 70;
        if (r8 > r6) goto L_0x007c;
    L_0x0077:
        r6 = r8 + -65;
        r6 = r6 + 10;
        goto L_0x002f;
    L_0x007c:
        if (r3 != 0) goto L_0x009b;
    L_0x007e:
        r2 = new java.lang.NumberFormatException;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Expected leading [0-9a-fA-F] character but was 0x";
        r3 = r3.append(r4);
        r4 = java.lang.Integer.toHexString(r8);
        r3 = r3.append(r4);
        r3 = r3.toString();
        r2.<init>(r3);
        throw r2;
    L_0x009b:
        r2 = 1;
    L_0x009c:
        if (r7 != r12) goto L_0x00c9;
    L_0x009e:
        r6 = r10.a();
        r0 = r18;
        r0.a = r6;
        okio.n.a(r10);
    L_0x00a9:
        if (r2 != 0) goto L_0x00b1;
    L_0x00ab:
        r0 = r18;
        r6 = r0.a;
        if (r6 != 0) goto L_0x0016;
    L_0x00b1:
        r0 = r18;
        r6 = r0.b;
        r2 = (long) r3;
        r2 = r6 - r2;
        r0 = r18;
        r0.b = r2;
        return r4;
    L_0x00bd:
        r8 = 4;
        r4 = r4 << r8;
        r8 = (long) r6;
        r8 = r8 | r4;
        r4 = r7 + 1;
        r3 = r3 + 1;
        r7 = r4;
        r4 = r8;
        goto L_0x0021;
    L_0x00c9:
        r10.b = r7;
        goto L_0x00a9;
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.d.readHexadecimalUnsignedLong():long");
    }

    public int readInt() {
        if (this.b < 4) {
            throw new IllegalStateException("size < 4: " + this.b);
        }
        m mVar = this.a;
        int i = mVar.b;
        int i2 = mVar.c;
        if (i2 - i < 4) {
            return ((((readByte() & 255) << 24) | ((readByte() & 255) << 16)) | ((readByte() & 255) << 8)) | (readByte() & 255);
        }
        byte[] bArr = mVar.a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        i = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        i3 = i4 + 1;
        i |= (bArr[i4] & 255) << 8;
        i4 = i3 + 1;
        i |= bArr[i3] & 255;
        this.b -= 4;
        if (i4 == i2) {
            this.a = mVar.a();
            n.a(mVar);
            return i;
        }
        mVar.b = i4;
        return i;
    }

    public int readIntLe() {
        return q.a(readInt());
    }

    public long readLong() {
        if (this.b < 8) {
            throw new IllegalStateException("size < 8: " + this.b);
        }
        m mVar = this.a;
        int i = mVar.b;
        int i2 = mVar.c;
        if (i2 - i < 8) {
            return ((((long) readInt()) & 4294967295L) << 32) | (((long) readInt()) & 4294967295L);
        }
        byte[] bArr = mVar.a;
        int i3 = i + 1;
        long j = (((long) bArr[i]) & 255) << 56;
        i = i3 + 1;
        long j2 = ((((long) bArr[i3]) & 255) << 48) | j;
        int i4 = i + 1;
        i = i4 + 1;
        j2 = (j2 | ((((long) bArr[i]) & 255) << 40)) | ((((long) bArr[i4]) & 255) << 32);
        i4 = i + 1;
        i = i4 + 1;
        j2 = (j2 | ((((long) bArr[i]) & 255) << 24)) | ((((long) bArr[i4]) & 255) << 16);
        i4 = i + 1;
        int i5 = i4 + 1;
        long j3 = (((long) bArr[i4]) & 255) | (j2 | ((((long) bArr[i]) & 255) << 8));
        this.b -= 8;
        if (i5 == i2) {
            this.a = mVar.a();
            n.a(mVar);
            return j3;
        }
        mVar.b = i5;
        return j3;
    }

    public long readLongLe() {
        return q.a(readLong());
    }

    public short readShort() {
        if (this.b < 2) {
            throw new IllegalStateException("size < 2: " + this.b);
        }
        m mVar = this.a;
        int i = mVar.b;
        int i2 = mVar.c;
        if (i2 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = mVar.a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        i = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.b -= 2;
        if (i4 == i2) {
            this.a = mVar.a();
            n.a(mVar);
        } else {
            mVar.b = i4;
        }
        return (short) i;
    }

    public short readShortLe() {
        return q.a(readShort());
    }

    public String readString(long j, Charset charset) {
        q.a(this.b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return "";
        } else {
            m mVar = this.a;
            if (((long) mVar.b) + j > ((long) mVar.c)) {
                return new String(readByteArray(j), charset);
            }
            String str = new String(mVar.a, mVar.b, (int) j, charset);
            mVar.b = (int) (((long) mVar.b) + j);
            this.b -= j;
            if (mVar.b != mVar.c) {
                return str;
            }
            this.a = mVar.a();
            n.a(mVar);
            return str;
        }
    }

    public String readString(Charset charset) {
        try {
            return readString(this.b, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String readUtf8() {
        try {
            return readString(this.b, q.a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String readUtf8(long j) {
        return readString(j, q.a);
    }

    public int readUtf8CodePoint() {
        if (this.b == 0) {
            throw new EOFException();
        }
        int i;
        int i2;
        int i3;
        byte a = a(0);
        if ((a & 128) == 0) {
            i = 0;
            i2 = a & 127;
            i3 = 1;
        } else if ((a & 224) == 192) {
            i2 = a & 31;
            i3 = 2;
            i = 128;
        } else if ((a & 240) == 224) {
            i2 = a & 15;
            i3 = 3;
            i = 2048;
        } else if ((a & 248) == 240) {
            i2 = a & 7;
            i3 = 4;
            i = 65536;
        } else {
            skip(1);
            return 65533;
        }
        if (this.b < ((long) i3)) {
            throw new EOFException("size < " + i3 + ": " + this.b + " (to read code point prefixed 0x" + Integer.toHexString(a) + ")");
        }
        int i4 = i2;
        i2 = 1;
        while (i2 < i3) {
            a = a((long) i2);
            if ((a & 192) == 128) {
                i2++;
                i4 = (a & 63) | (i4 << 6);
            } else {
                skip((long) i2);
                return 65533;
            }
        }
        skip((long) i3);
        return i4 > 1114111 ? 65533 : (i4 < 55296 || i4 > 57343) ? i4 < i ? 65533 : i4 : 65533;
    }

    @Nullable
    public String readUtf8Line() {
        long indexOf = indexOf((byte) 10);
        return indexOf == -1 ? this.b != 0 ? readUtf8(this.b) : null : b(indexOf);
    }

    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    public String readUtf8LineStrict(long j) {
        long j2 = Long.MAX_VALUE;
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        if (j != Long.MAX_VALUE) {
            j2 = j + 1;
        }
        long indexOf = indexOf((byte) 10, 0, j2);
        if (indexOf != -1) {
            return b(indexOf);
        }
        if (j2 < a() && a(j2 - 1) == (byte) 13 && a(j2) == (byte) 10) {
            return b(j2);
        }
        d dVar = new d();
        a(dVar, 0, Math.min(32, a()));
        throw new EOFException("\\n not found: limit=" + Math.min(a(), j) + " content=" + dVar.readByteString().e() + 8230);
    }

    public boolean request(long j) {
        return this.b >= j;
    }

    public void require(long j) {
        if (this.b < j) {
            throw new EOFException();
        }
    }

    public int select(j jVar) {
        m mVar = this.a;
        if (mVar == null) {
            return jVar.indexOf(ByteString.b);
        }
        ByteString[] byteStringArr = jVar.a;
        int length = byteStringArr.length;
        for (int i = 0; i < length; i++) {
            ByteString byteString = byteStringArr[i];
            if (this.b >= ((long) byteString.g())) {
                if (a(mVar, mVar.b, byteString, 0, byteString.g())) {
                    try {
                        skip((long) byteString.g());
                        return i;
                    } catch (EOFException e) {
                        throw new AssertionError(e);
                    }
                }
            }
        }
        return -1;
    }

    public void skip(long j) {
        while (j > 0) {
            if (this.a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, (long) (this.a.c - this.a.b));
            this.b -= (long) min;
            j -= (long) min;
            m mVar = this.a;
            mVar.b = min + mVar.b;
            if (this.a.b == this.a.c) {
                m mVar2 = this.a;
                this.a = mVar2.a();
                n.a(mVar2);
            }
        }
    }

    public p timeout() {
        return p.c;
    }

    public String toString() {
        return f().toString();
    }

    public BufferedSink write(Source source, long j) {
        while (j > 0) {
            long read = source.read(this, j);
            if (read == -1) {
                throw new EOFException();
            }
            j -= read;
        }
        return this;
    }

    public void write(d dVar, long j) {
        if (dVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (dVar == this) {
            throw new IllegalArgumentException("source == this");
        } else {
            q.a(dVar.b, 0, j);
            while (j > 0) {
                m mVar;
                if (j < ((long) (dVar.a.c - dVar.a.b))) {
                    mVar = this.a != null ? this.a.g : null;
                    if (mVar != null && mVar.e) {
                        if ((((long) mVar.c) + j) - ((long) (mVar.d ? 0 : mVar.b)) <= 8192) {
                            dVar.a.a(mVar, (int) j);
                            dVar.b -= j;
                            this.b += j;
                            return;
                        }
                    }
                    dVar.a = dVar.a.a((int) j);
                }
                m mVar2 = dVar.a;
                long j2 = (long) (mVar2.c - mVar2.b);
                dVar.a = mVar2.a();
                if (this.a == null) {
                    this.a = mVar2;
                    mVar2 = this.a;
                    mVar = this.a;
                    m mVar3 = this.a;
                    mVar.g = mVar3;
                    mVar2.f = mVar3;
                } else {
                    this.a.g.a(mVar2).b();
                }
                dVar.b -= j2;
                this.b += j2;
                j -= j2;
            }
        }
    }

    public long writeAll(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = source.read(this, 8192);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }
}
