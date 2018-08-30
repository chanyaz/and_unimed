package okhttp3;

import java.io.Closeable;
import java.io.Flushable;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.cache.d;

public final class b implements Closeable, Flushable {
    final InternalCache a;
    final d b;

    public void close() {
        this.b.close();
    }

    public void flush() {
        this.b.flush();
    }
}
