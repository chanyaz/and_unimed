package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okhttp3.internal.c;
import okio.BufferedSource;
import okio.d;

public abstract class ai implements Closeable {
    private Reader a;

    public static ai a(@Nullable final v vVar, final long j, final BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            return new ai() {
                @Nullable
                public v a() {
                    return vVar;
                }

                public long b() {
                    return j;
                }

                public BufferedSource c() {
                    return bufferedSource;
                }
            };
        }
        throw new NullPointerException("source == null");
    }

    public static ai a(@Nullable v vVar, byte[] bArr) {
        return a(vVar, (long) bArr.length, new d().write(bArr));
    }

    private Charset g() {
        v a = a();
        return a != null ? a.a(c.e) : c.e;
    }

    @Nullable
    public abstract v a();

    public abstract long b();

    public abstract BufferedSource c();

    public void close() {
        c.a(c());
    }

    public final byte[] d() {
        long b = b();
        if (b > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + b);
        }
        Closeable c = c();
        try {
            byte[] readByteArray = c.readByteArray();
            if (b == -1 || b == ((long) readByteArray.length)) {
                return readByteArray;
            }
            throw new IOException("Content-Length (" + b + ") and stream length (" + readByteArray.length + ") disagree");
        } finally {
            c.a(c);
        }
    }

    public final Reader e() {
        Reader reader = this.a;
        if (reader != null) {
            return reader;
        }
        reader = new aj(c(), g());
        this.a = reader;
        return reader;
    }

    public final String f() {
        Closeable c = c();
        try {
            String readString = c.readString(c.a((BufferedSource) c, g()));
            return readString;
        } finally {
            c.a(c);
        }
    }
}
