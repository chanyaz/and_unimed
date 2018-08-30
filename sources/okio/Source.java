package okio;

import java.io.Closeable;

public interface Source extends Closeable {
    void close();

    long read(d dVar, long j);

    p timeout();
}
