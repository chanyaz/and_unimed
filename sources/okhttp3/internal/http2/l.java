package okhttp3.internal.http2;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.logging.Level;
import okio.BufferedSource;
import okio.Source;
import okio.d;
import okio.p;

final class l implements Source {
    int a;
    byte b;
    int c;
    int d;
    short e;
    private final BufferedSource f;

    l(BufferedSource bufferedSource) {
        this.f = bufferedSource;
    }

    private void a() {
        int i = this.c;
        int a = Http2Reader.a(this.f);
        this.d = a;
        this.a = a;
        byte readByte = (byte) (this.f.readByte() & 255);
        this.b = (byte) (this.f.readByte() & 255);
        if (Http2Reader.a.isLoggable(Level.FINE)) {
            Http2Reader.a.fine(e.a(true, this.c, this.a, readByte, this.b));
        }
        this.c = this.f.readInt() & MoPubClientPositioning.NO_REPEAT;
        if (readByte != (byte) 9) {
            throw e.b("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
        } else if (this.c != i) {
            throw e.b("TYPE_CONTINUATION streamId changed", new Object[0]);
        }
    }

    public void close() {
    }

    public long read(d dVar, long j) {
        while (this.d == 0) {
            this.f.skip((long) this.e);
            this.e = (short) 0;
            if ((this.b & 4) != 0) {
                return -1;
            }
            a();
        }
        long read = this.f.read(dVar, Math.min(j, (long) this.d));
        if (read == -1) {
            return -1;
        }
        this.d = (int) (((long) this.d) - read);
        return read;
    }

    public p timeout() {
        return this.f.timeout();
    }
}
