package okhttp3;

import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.c;
import okio.BufferedSink;
import okio.ByteString;
import okio.d;

public final class w extends af {
    public static final v a = v.a("multipart/mixed");
    public static final v b = v.a("multipart/alternative");
    public static final v c = v.a("multipart/digest");
    public static final v d = v.a("multipart/parallel");
    public static final v e = v.a("multipart/form-data");
    private static final byte[] f = new byte[]{(byte) 58, (byte) 32};
    private static final byte[] g = new byte[]{(byte) 13, (byte) 10};
    private static final byte[] h = new byte[]{(byte) 45, (byte) 45};
    private final ByteString i;
    private final v j;
    private final v k;
    private final List<y> l;
    private long m = -1;

    w(ByteString byteString, v vVar, List<y> list) {
        this.i = byteString;
        this.j = vVar;
        this.k = v.a(vVar + "; boundary=" + byteString.a());
        this.l = c.a((List) list);
    }

    private long a(@Nullable BufferedSink bufferedSink, boolean z) {
        d dVar;
        long j = 0;
        if (z) {
            d dVar2 = new d();
            dVar = dVar2;
            bufferedSink = dVar2;
        } else {
            dVar = null;
        }
        int size = this.l.size();
        for (int i = 0; i < size; i++) {
            y yVar = (y) this.l.get(i);
            q qVar = yVar.a;
            af afVar = yVar.b;
            bufferedSink.write(h);
            bufferedSink.write(this.i);
            bufferedSink.write(g);
            if (qVar != null) {
                int a = qVar.a();
                for (int i2 = 0; i2 < a; i2++) {
                    bufferedSink.writeUtf8(qVar.a(i2)).write(f).writeUtf8(qVar.b(i2)).write(g);
                }
            }
            v a2 = afVar.a();
            if (a2 != null) {
                bufferedSink.writeUtf8("Content-Type: ").writeUtf8(a2.toString()).write(g);
            }
            long b = afVar.b();
            if (b != -1) {
                bufferedSink.writeUtf8("Content-Length: ").writeDecimalLong(b).write(g);
            } else if (z) {
                dVar.d();
                return -1;
            }
            bufferedSink.write(g);
            if (z) {
                j += b;
            } else {
                afVar.a(bufferedSink);
            }
            bufferedSink.write(g);
        }
        bufferedSink.write(h);
        bufferedSink.write(this.i);
        bufferedSink.write(h);
        bufferedSink.write(g);
        if (!z) {
            return j;
        }
        j += dVar.a();
        dVar.d();
        return j;
    }

    public v a() {
        return this.k;
    }

    public void a(BufferedSink bufferedSink) {
        a(bufferedSink, false);
    }

    public long b() {
        long j = this.m;
        if (j != -1) {
            return j;
        }
        j = a(null, true);
        this.m = j;
        return j;
    }
}
