package okhttp3.internal.http2;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.c;
import okio.BufferedSink;
import okio.d;

final class q implements Closeable {
    private static final Logger b = Logger.getLogger(e.class.getName());
    final d a = new d(this.e);
    private final BufferedSink c;
    private final boolean d;
    private final d e = new d();
    private int f = 16384;
    private boolean g;

    q(BufferedSink bufferedSink, boolean z) {
        this.c = bufferedSink;
        this.d = z;
    }

    private static void a(BufferedSink bufferedSink, int i) {
        bufferedSink.writeByte((i >>> 16) & 255);
        bufferedSink.writeByte((i >>> 8) & 255);
        bufferedSink.writeByte(i & 255);
    }

    private void b(int i, long j) {
        while (j > 0) {
            int min = (int) Math.min((long) this.f, j);
            j -= (long) min;
            a(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.c.write(this.e, (long) min);
        }
    }

    public synchronized void a() {
        if (this.g) {
            throw new IOException("closed");
        } else if (this.d) {
            if (b.isLoggable(Level.FINE)) {
                b.fine(c.a(">> CONNECTION %s", e.a.e()));
            }
            this.c.write(e.a.h());
            this.c.flush();
        }
    }

    void a(int i, byte b, d dVar, int i2) {
        a(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.c.write(dVar, (long) i2);
        }
    }

    public void a(int i, int i2, byte b, byte b2) {
        if (b.isLoggable(Level.FINE)) {
            b.fine(e.a(false, i, i2, b, b2));
        }
        if (i2 > this.f) {
            throw e.a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(this.f), Integer.valueOf(i2));
        } else if ((Integer.MIN_VALUE & i) != 0) {
            throw e.a("reserved bit set: %s", Integer.valueOf(i));
        } else {
            a(this.c, i2);
            this.c.writeByte(b & 255);
            this.c.writeByte(b2 & 255);
            this.c.writeInt(MoPubClientPositioning.NO_REPEAT & i);
        }
    }

    public synchronized void a(int i, int i2, List<a> list) {
        if (this.g) {
            throw new IOException("closed");
        }
        this.a.a((List) list);
        long a = this.e.a();
        int min = (int) Math.min((long) (this.f - 4), a);
        a(i, min + 4, (byte) 5, a == ((long) min) ? (byte) 4 : (byte) 0);
        this.c.writeInt(MoPubClientPositioning.NO_REPEAT & i2);
        this.c.write(this.e, (long) min);
        if (a > ((long) min)) {
            b(i, a - ((long) min));
        }
    }

    public synchronized void a(int i, long j) {
        if (this.g) {
            throw new IOException("closed");
        } else if (j == 0 || j > 2147483647L) {
            throw e.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        } else {
            a(i, 4, (byte) 8, (byte) 0);
            this.c.writeInt((int) j);
            this.c.flush();
        }
    }

    public synchronized void a(int i, ErrorCode errorCode) {
        if (this.g) {
            throw new IOException("closed");
        } else if (errorCode.g == -1) {
            throw new IllegalArgumentException();
        } else {
            a(i, 4, (byte) 3, (byte) 0);
            this.c.writeInt(errorCode.g);
            this.c.flush();
        }
    }

    public synchronized void a(int i, ErrorCode errorCode, byte[] bArr) {
        if (this.g) {
            throw new IOException("closed");
        } else if (errorCode.g == -1) {
            throw e.a("errorCode.httpCode == -1", new Object[0]);
        } else {
            a(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.c.writeInt(i);
            this.c.writeInt(errorCode.g);
            if (bArr.length > 0) {
                this.c.write(bArr);
            }
            this.c.flush();
        }
    }

    public synchronized void a(u uVar) {
        if (this.g) {
            throw new IOException("closed");
        }
        this.f = uVar.d(this.f);
        if (uVar.c() != -1) {
            this.a.a(uVar.c());
        }
        a(0, 0, (byte) 4, (byte) 1);
        this.c.flush();
    }

    public synchronized void a(boolean z, int i, int i2) {
        byte b = (byte) 0;
        synchronized (this) {
            if (this.g) {
                throw new IOException("closed");
            }
            if (z) {
                b = (byte) 1;
            }
            a(0, 8, (byte) 6, b);
            this.c.writeInt(i);
            this.c.writeInt(i2);
            this.c.flush();
        }
    }

    public synchronized void a(boolean z, int i, int i2, List<a> list) {
        if (this.g) {
            throw new IOException("closed");
        }
        a(z, i, (List) list);
    }

    void a(boolean z, int i, List<a> list) {
        if (this.g) {
            throw new IOException("closed");
        }
        this.a.a((List) list);
        long a = this.e.a();
        int min = (int) Math.min((long) this.f, a);
        byte b = a == ((long) min) ? (byte) 4 : (byte) 0;
        if (z) {
            b = (byte) (b | 1);
        }
        a(i, min, (byte) 1, b);
        this.c.write(this.e, (long) min);
        if (a > ((long) min)) {
            b(i, a - ((long) min));
        }
    }

    public synchronized void a(boolean z, int i, d dVar, int i2) {
        if (this.g) {
            throw new IOException("closed");
        }
        byte b = (byte) 0;
        if (z) {
            b = (byte) 1;
        }
        a(i, b, dVar, i2);
    }

    public synchronized void b() {
        if (this.g) {
            throw new IOException("closed");
        }
        this.c.flush();
    }

    public synchronized void b(u uVar) {
        int i = 0;
        synchronized (this) {
            if (this.g) {
                throw new IOException("closed");
            }
            a(0, uVar.b() * 6, (byte) 4, (byte) 0);
            while (i < 10) {
                if (uVar.a(i)) {
                    int i2 = i == 4 ? 3 : i == 7 ? 4 : i;
                    this.c.writeShort(i2);
                    this.c.writeInt(uVar.b(i));
                }
                i++;
            }
            this.c.flush();
        }
    }

    public int c() {
        return this.f;
    }

    public synchronized void close() {
        this.g = true;
        this.c.close();
    }
}
