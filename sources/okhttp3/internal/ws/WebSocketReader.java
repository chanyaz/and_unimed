package okhttp3.internal.ws;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import okio.BufferedSource;
import okio.ByteString;
import okio.d;

final class WebSocketReader {
    final boolean a;
    final BufferedSource b;
    final FrameCallback c;
    boolean d;
    int e;
    long f;
    long g;
    boolean h;
    boolean i;
    boolean j;
    final byte[] k = new byte[4];
    final byte[] l = new byte[8192];

    public interface FrameCallback {
        void onReadClose(int i, String str);

        void onReadMessage(String str);

        void onReadMessage(ByteString byteString);

        void onReadPing(ByteString byteString);

        void onReadPong(ByteString byteString);
    }

    WebSocketReader(boolean z, BufferedSource bufferedSource, FrameCallback frameCallback) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        } else if (frameCallback == null) {
            throw new NullPointerException("frameCallback == null");
        } else {
            this.a = z;
            this.b = bufferedSource;
            this.c = frameCallback;
        }
    }

    private void a(d dVar) {
        while (!this.d) {
            long read;
            if (this.g == this.f) {
                if (!this.h) {
                    b();
                    if (this.e != 0) {
                        throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.e));
                    } else if (this.h && this.f == 0) {
                        return;
                    }
                }
                return;
            }
            long j = this.f - this.g;
            if (this.j) {
                read = (long) this.b.read(this.l, 0, (int) Math.min(j, (long) this.l.length));
                if (read == -1) {
                    throw new EOFException();
                }
                g.a(this.l, read, this.k, this.g);
                dVar.write(this.l, 0, (int) read);
            } else {
                read = this.b.read(dVar, j);
                if (read == -1) {
                    throw new EOFException();
                }
            }
            this.g += read;
        }
        throw new IOException("closed");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0077  */
    private void c() {
        /*
        r10 = this;
        r8 = 0;
        r1 = 1;
        r2 = 0;
        r0 = r10.d;
        if (r0 == 0) goto L_0x0010;
    L_0x0008:
        r0 = new java.io.IOException;
        r1 = "closed";
        r0.<init>(r1);
        throw r0;
    L_0x0010:
        r0 = r10.b;
        r0 = r0.timeout();
        r4 = r0.l_();
        r0 = r10.b;
        r0 = r0.timeout();
        r0.n_();
        r0 = r10.b;	 Catch:{ all -> 0x0058 }
        r0 = r0.readByte();	 Catch:{ all -> 0x0058 }
        r6 = r0 & 255;
        r0 = r10.b;
        r0 = r0.timeout();
        r3 = java.util.concurrent.TimeUnit.NANOSECONDS;
        r0.a(r4, r3);
        r0 = r6 & 15;
        r10.e = r0;
        r0 = r6 & 128;
        if (r0 == 0) goto L_0x0065;
    L_0x003e:
        r0 = r1;
    L_0x003f:
        r10.h = r0;
        r0 = r6 & 8;
        if (r0 == 0) goto L_0x0067;
    L_0x0045:
        r0 = r1;
    L_0x0046:
        r10.i = r0;
        r0 = r10.i;
        if (r0 == 0) goto L_0x0069;
    L_0x004c:
        r0 = r10.h;
        if (r0 != 0) goto L_0x0069;
    L_0x0050:
        r0 = new java.net.ProtocolException;
        r1 = "Control frames must be final.";
        r0.<init>(r1);
        throw r0;
    L_0x0058:
        r0 = move-exception;
        r1 = r10.b;
        r1 = r1.timeout();
        r2 = java.util.concurrent.TimeUnit.NANOSECONDS;
        r1.a(r4, r2);
        throw r0;
    L_0x0065:
        r0 = r2;
        goto L_0x003f;
    L_0x0067:
        r0 = r2;
        goto L_0x0046;
    L_0x0069:
        r0 = r6 & 64;
        if (r0 == 0) goto L_0x0086;
    L_0x006d:
        r4 = r1;
    L_0x006e:
        r0 = r6 & 32;
        if (r0 == 0) goto L_0x0088;
    L_0x0072:
        r3 = r1;
    L_0x0073:
        r0 = r6 & 16;
        if (r0 == 0) goto L_0x008a;
    L_0x0077:
        r0 = r1;
    L_0x0078:
        if (r4 != 0) goto L_0x007e;
    L_0x007a:
        if (r3 != 0) goto L_0x007e;
    L_0x007c:
        if (r0 == 0) goto L_0x008c;
    L_0x007e:
        r0 = new java.net.ProtocolException;
        r1 = "Reserved flags are unsupported.";
        r0.<init>(r1);
        throw r0;
    L_0x0086:
        r4 = r2;
        goto L_0x006e;
    L_0x0088:
        r3 = r2;
        goto L_0x0073;
    L_0x008a:
        r0 = r2;
        goto L_0x0078;
    L_0x008c:
        r0 = r10.b;
        r0 = r0.readByte();
        r0 = r0 & 255;
        r3 = r0 & 128;
        if (r3 == 0) goto L_0x00ac;
    L_0x0098:
        r10.j = r1;
        r1 = r10.j;
        r2 = r10.a;
        if (r1 != r2) goto L_0x00b1;
    L_0x00a0:
        r1 = new java.net.ProtocolException;
        r0 = r10.a;
        if (r0 == 0) goto L_0x00ae;
    L_0x00a6:
        r0 = "Server-sent frames must not be masked.";
    L_0x00a8:
        r1.<init>(r0);
        throw r1;
    L_0x00ac:
        r1 = r2;
        goto L_0x0098;
    L_0x00ae:
        r0 = "Client-sent frames must be masked.";
        goto L_0x00a8;
    L_0x00b1:
        r0 = r0 & 127;
        r0 = (long) r0;
        r10.f = r0;
        r0 = r10.f;
        r2 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x00e1;
    L_0x00be:
        r0 = r10.b;
        r0 = r0.readShort();
        r0 = (long) r0;
        r2 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r0 = r0 & r2;
        r10.f = r0;
    L_0x00cb:
        r10.g = r8;
        r0 = r10.i;
        if (r0 == 0) goto L_0x011c;
    L_0x00d1:
        r0 = r10.f;
        r2 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x011c;
    L_0x00d9:
        r0 = new java.net.ProtocolException;
        r1 = "Control frame must be less than 125B.";
        r0.<init>(r1);
        throw r0;
    L_0x00e1:
        r0 = r10.f;
        r2 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x00cb;
    L_0x00e9:
        r0 = r10.b;
        r0 = r0.readLong();
        r10.f = r0;
        r0 = r10.f;
        r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r0 >= 0) goto L_0x00cb;
    L_0x00f7:
        r0 = new java.net.ProtocolException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Frame length 0x";
        r1 = r1.append(r2);
        r2 = r10.f;
        r2 = java.lang.Long.toHexString(r2);
        r1 = r1.append(r2);
        r2 = " > 0x7FFFFFFFFFFFFFFF";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x011c:
        r0 = r10.j;
        if (r0 == 0) goto L_0x0127;
    L_0x0120:
        r0 = r10.b;
        r1 = r10.k;
        r0.readFully(r1);
    L_0x0127:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.WebSocketReader.c():void");
    }

    private void d() {
        d dVar = new d();
        if (this.g < this.f) {
            if (this.a) {
                this.b.readFully(dVar, this.f);
            } else {
                while (this.g < this.f) {
                    int read = this.b.read(this.l, 0, (int) Math.min(this.f - this.g, (long) this.l.length));
                    if (read == -1) {
                        throw new EOFException();
                    }
                    g.a(this.l, (long) read, this.k, this.g);
                    dVar.write(this.l, 0, read);
                    this.g += (long) read;
                }
            }
        }
        switch (this.e) {
            case 8:
                int i = 1005;
                String str = "";
                long a = dVar.a();
                if (a == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (a != 0) {
                    i = dVar.readShort();
                    str = dVar.readUtf8();
                    String a2 = g.a(i);
                    if (a2 != null) {
                        throw new ProtocolException(a2);
                    }
                }
                this.c.onReadClose(i, str);
                this.d = true;
                return;
            case 9:
                this.c.onReadPing(dVar.readByteString());
                return;
            case 10:
                this.c.onReadPong(dVar.readByteString());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.e));
        }
    }

    private void e() {
        int i = this.e;
        if (i == 1 || i == 2) {
            d dVar = new d();
            a(dVar);
            if (i == 1) {
                this.c.onReadMessage(dVar.readUtf8());
                return;
            } else {
                this.c.onReadMessage(dVar.readByteString());
                return;
            }
        }
        throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i));
    }

    void a() {
        c();
        if (this.i) {
            d();
        } else {
            e();
        }
    }

    void b() {
        while (!this.d) {
            c();
            if (this.i) {
                d();
            } else {
                return;
            }
        }
    }
}
