package okhttp3;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import okhttp3.internal.c;
import okio.BufferedSource;

final class aj extends Reader {
    private final BufferedSource a;
    private final Charset b;
    private boolean c;
    private Reader d;

    aj(BufferedSource bufferedSource, Charset charset) {
        this.a = bufferedSource;
        this.b = charset;
    }

    public void close() {
        this.c = true;
        if (this.d != null) {
            this.d.close();
        } else {
            this.a.close();
        }
    }

    public int read(char[] cArr, int i, int i2) {
        if (this.c) {
            throw new IOException("Stream closed");
        }
        Reader reader = this.d;
        if (reader == null) {
            reader = new InputStreamReader(this.a.inputStream(), c.a(this.a, this.b));
            this.d = reader;
        }
        return reader.read(cArr, i, i2);
    }
}
