package okhttp3;

import javax.annotation.Nullable;
import okhttp3.internal.c;
import okio.BufferedSink;

public abstract class af {
    public static af a(@Nullable v vVar, byte[] bArr) {
        return a(vVar, bArr, 0, bArr.length);
    }

    public static af a(@Nullable final v vVar, final byte[] bArr, final int i, final int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        c.a((long) bArr.length, (long) i, (long) i2);
        return new af() {
            @Nullable
            public v a() {
                return vVar;
            }

            public void a(BufferedSink bufferedSink) {
                bufferedSink.write(bArr, i, i2);
            }

            public long b() {
                return (long) i2;
            }
        };
    }

    @Nullable
    public abstract v a();

    public abstract void a(BufferedSink bufferedSink);

    public long b() {
        return -1;
    }
}
