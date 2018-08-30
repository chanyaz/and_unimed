package okhttp3.internal.ws;

import java.io.Closeable;
import okio.BufferedSink;
import okio.BufferedSource;

public abstract class f implements Closeable {
    public final boolean c;
    public final BufferedSource d;
    public final BufferedSink e;

    public f(boolean z, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.c = z;
        this.d = bufferedSource;
        this.e = bufferedSink;
    }
}
