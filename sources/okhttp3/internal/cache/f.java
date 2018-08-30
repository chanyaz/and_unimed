package okhttp3.internal.cache;

import java.io.File;
import okio.BufferedSink;

final class f {
    final String a;
    final long[] b;
    final File[] c;
    final File[] d;
    boolean e;
    e f;
    long g;

    void a(BufferedSink bufferedSink) {
        for (long writeDecimalLong : this.b) {
            bufferedSink.writeByte(32).writeDecimalLong(writeDecimalLong);
        }
    }
}
