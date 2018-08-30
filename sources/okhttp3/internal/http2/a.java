package okhttp3.internal.http2;

import okhttp3.internal.c;
import okio.ByteString;

public final class a {
    public static final ByteString a = ByteString.a(":");
    public static final ByteString b = ByteString.a(":status");
    public static final ByteString c = ByteString.a(":method");
    public static final ByteString d = ByteString.a(":path");
    public static final ByteString e = ByteString.a(":scheme");
    public static final ByteString f = ByteString.a(":authority");
    public final ByteString g;
    public final ByteString h;
    final int i;

    public a(String str, String str2) {
        this(ByteString.a(str), ByteString.a(str2));
    }

    public a(ByteString byteString, String str) {
        this(byteString, ByteString.a(str));
    }

    public a(ByteString byteString, ByteString byteString2) {
        this.g = byteString;
        this.h = byteString2;
        this.i = (byteString.g() + 32) + byteString2.g();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.g.equals(aVar.g) && this.h.equals(aVar.h);
    }

    public int hashCode() {
        return ((this.g.hashCode() + 527) * 31) + this.h.hashCode();
    }

    public String toString() {
        return c.a("%s: %s", this.g.a(), this.h.a());
    }
}
