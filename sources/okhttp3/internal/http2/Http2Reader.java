package okhttp3.internal.http2;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.c;
import okio.BufferedSource;
import okio.ByteString;

final class Http2Reader implements Closeable {
    static final Logger a = Logger.getLogger(e.class.getName());
    final c b = new c(4096, this.d);
    private final BufferedSource c;
    private final l d = new l(this.c);
    private final boolean e;

    interface Handler {
        void ackSettings();

        void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j);

        void data(boolean z, int i, BufferedSource bufferedSource, int i2);

        void goAway(int i, ErrorCode errorCode, ByteString byteString);

        void headers(boolean z, int i, int i2, List<a> list);

        void ping(boolean z, int i, int i2);

        void priority(int i, int i2, int i3, boolean z);

        void pushPromise(int i, int i2, List<a> list);

        void rstStream(int i, ErrorCode errorCode);

        void settings(boolean z, u uVar);

        void windowUpdate(int i, long j);
    }

    Http2Reader(BufferedSource bufferedSource, boolean z) {
        this.c = bufferedSource;
        this.e = z;
    }

    static int a(int i, byte b, short s) {
        short i2;
        if ((b & 8) != 0) {
            i2 = i2 - 1;
        }
        if (s <= i2) {
            return (short) (i2 - s);
        }
        throw e.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i2));
    }

    static int a(BufferedSource bufferedSource) {
        return (((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8)) | (bufferedSource.readByte() & 255);
    }

    private List<a> a(int i, short s, byte b, int i2) {
        l lVar = this.d;
        this.d.d = i;
        lVar.a = i;
        this.d.e = s;
        this.d.b = b;
        this.d.c = i2;
        this.b.a();
        return this.b.b();
    }

    private void a(Handler handler, int i) {
        int readInt = this.c.readInt();
        handler.priority(i, readInt & MoPubClientPositioning.NO_REPEAT, (this.c.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    private void a(Handler handler, int i, byte b, int i2) {
        short s = (short) 0;
        if (i2 == 0) {
            throw e.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        if ((b & 8) != 0) {
            s = (short) (this.c.readByte() & 255);
        }
        if ((b & 32) != 0) {
            a(handler, i2);
            i -= 5;
        }
        handler.headers(z, i2, -1, a(a(i, b, s), s, b, i2));
    }

    private void b(Handler handler, int i, byte b, int i2) {
        short s = (short) 1;
        short s2 = (short) 0;
        if (i2 == 0) {
            throw e.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        if ((b & 32) == 0) {
            s = (short) 0;
        }
        if (s != (short) 0) {
            throw e.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        if ((b & 8) != 0) {
            s2 = (short) (this.c.readByte() & 255);
        }
        handler.data(z, i2, this.c, a(i, b, s2));
        this.c.skip((long) s2);
    }

    private void c(Handler handler, int i, byte b, int i2) {
        if (i != 5) {
            throw e.b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        } else if (i2 == 0) {
            throw e.b("TYPE_PRIORITY streamId == 0", new Object[0]);
        } else {
            a(handler, i2);
        }
    }

    private void d(Handler handler, int i, byte b, int i2) {
        if (i != 4) {
            throw e.b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        } else if (i2 == 0) {
            throw e.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        } else {
            ErrorCode a = ErrorCode.a(this.c.readInt());
            if (a == null) {
                throw e.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(r0));
            } else {
                handler.rstStream(i2, a);
            }
        }
    }

    private void e(Handler handler, int i, byte b, int i2) {
        if (i2 != 0) {
            throw e.b("TYPE_SETTINGS streamId != 0", new Object[0]);
        } else if ((b & 1) != 0) {
            if (i != 0) {
                throw e.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            handler.ackSettings();
        } else if (i % 6 != 0) {
            throw e.b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        } else {
            u uVar = new u();
            for (int i3 = 0; i3 < i; i3 += 6) {
                int readShort = this.c.readShort();
                int readInt = this.c.readInt();
                switch (readShort) {
                    case 2:
                        if (!(readInt == 0 || readInt == 1)) {
                            throw e.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        }
                    case 3:
                        readShort = 4;
                        break;
                    case 4:
                        readShort = 7;
                        if (readInt >= 0) {
                            break;
                        }
                        throw e.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                    case 5:
                        if (readInt >= 16384 && readInt <= 16777215) {
                            break;
                        }
                        throw e.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                    default:
                        break;
                }
                uVar.a(readShort, readInt);
            }
            handler.settings(false, uVar);
        }
    }

    private void f(Handler handler, int i, byte b, int i2) {
        short s = (short) 0;
        if (i2 == 0) {
            throw e.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        if ((b & 8) != 0) {
            s = (short) (this.c.readByte() & 255);
        }
        handler.pushPromise(i2, this.c.readInt() & MoPubClientPositioning.NO_REPEAT, a(a(i - 4, b, s), s, b, i2));
    }

    private void g(Handler handler, int i, byte b, int i2) {
        boolean z = true;
        if (i != 8) {
            throw e.b("TYPE_PING length != 8: %s", Integer.valueOf(i));
        } else if (i2 != 0) {
            throw e.b("TYPE_PING streamId != 0", new Object[0]);
        } else {
            int readInt = this.c.readInt();
            int readInt2 = this.c.readInt();
            if ((b & 1) == 0) {
                z = false;
            }
            handler.ping(z, readInt, readInt2);
        }
    }

    private void h(Handler handler, int i, byte b, int i2) {
        if (i < 8) {
            throw e.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        } else if (i2 != 0) {
            throw e.b("TYPE_GOAWAY streamId != 0", new Object[0]);
        } else {
            int readInt = this.c.readInt();
            int i3 = i - 8;
            ErrorCode a = ErrorCode.a(this.c.readInt());
            if (a == null) {
                throw e.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(r0));
            }
            ByteString byteString = ByteString.b;
            if (i3 > 0) {
                byteString = this.c.readByteString((long) i3);
            }
            handler.goAway(readInt, a, byteString);
        }
    }

    private void i(Handler handler, int i, byte b, int i2) {
        if (i != 4) {
            throw e.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long readInt = ((long) this.c.readInt()) & 2147483647L;
        if (readInt == 0) {
            throw e.b("windowSizeIncrement was 0", Long.valueOf(readInt));
        } else {
            handler.windowUpdate(i2, readInt);
        }
    }

    public void a(Handler handler) {
        if (!this.e) {
            ByteString readByteString = this.c.readByteString((long) e.a.g());
            if (a.isLoggable(Level.FINE)) {
                a.fine(c.a("<< CONNECTION %s", readByteString.e()));
            }
            if (!e.a.equals(readByteString)) {
                throw e.b("Expected a connection header but was %s", readByteString.a());
            }
        } else if (!a(true, handler)) {
            throw e.b("Required SETTINGS preface not received", new Object[0]);
        }
    }

    public boolean a(boolean z, Handler handler) {
        try {
            this.c.require(9);
            int a = a(this.c);
            if (a < 0 || a > 16384) {
                throw e.b("FRAME_SIZE_ERROR: %s", Integer.valueOf(a));
            }
            byte readByte = (byte) (this.c.readByte() & 255);
            if (!z || readByte == (byte) 4) {
                byte readByte2 = (byte) (this.c.readByte() & 255);
                int readInt = this.c.readInt() & MoPubClientPositioning.NO_REPEAT;
                if (a.isLoggable(Level.FINE)) {
                    a.fine(e.a(true, readInt, a, readByte, readByte2));
                }
                switch (readByte) {
                    case (byte) 0:
                        b(handler, a, readByte2, readInt);
                        return true;
                    case (byte) 1:
                        a(handler, a, readByte2, readInt);
                        return true;
                    case (byte) 2:
                        c(handler, a, readByte2, readInt);
                        return true;
                    case (byte) 3:
                        d(handler, a, readByte2, readInt);
                        return true;
                    case (byte) 4:
                        e(handler, a, readByte2, readInt);
                        return true;
                    case (byte) 5:
                        f(handler, a, readByte2, readInt);
                        return true;
                    case (byte) 6:
                        g(handler, a, readByte2, readInt);
                        return true;
                    case (byte) 7:
                        h(handler, a, readByte2, readInt);
                        return true;
                    case (byte) 8:
                        i(handler, a, readByte2, readInt);
                        return true;
                    default:
                        this.c.skip((long) a);
                        return true;
                }
            }
            throw e.b("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
        } catch (IOException e) {
            return false;
        }
    }

    public void close() {
        this.c.close();
    }
}
