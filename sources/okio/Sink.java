package okio;

import java.io.Closeable;
import java.io.Flushable;

public interface Sink extends Closeable, Flushable {
    void close();

    void flush();

    p timeout();

    void write(d dVar, long j);
}
