package okhttp3.internal.http2;

import com.mopub.common.Constants;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import okio.ByteString;

final class b {
    static final a[] a = new a[]{new a(a.f, ""), new a(a.c, "GET"), new a(a.c, "POST"), new a(a.d, "/"), new a(a.d, "/index.html"), new a(a.e, Constants.HTTP), new a(a.e, Constants.HTTPS), new a(a.b, "200"), new a(a.b, "204"), new a(a.b, "206"), new a(a.b, "304"), new a(a.b, "400"), new a(a.b, "404"), new a(a.b, "500"), new a("accept-charset", ""), new a("accept-encoding", "gzip, deflate"), new a("accept-language", ""), new a("accept-ranges", ""), new a("accept", ""), new a("access-control-allow-origin", ""), new a("age", ""), new a("allow", ""), new a("authorization", ""), new a("cache-control", ""), new a("content-disposition", ""), new a("content-encoding", ""), new a("content-language", ""), new a("content-length", ""), new a("content-location", ""), new a("content-range", ""), new a("content-type", ""), new a("cookie", ""), new a("date", ""), new a("etag", ""), new a("expect", ""), new a("expires", ""), new a("from", ""), new a("host", ""), new a("if-match", ""), new a("if-modified-since", ""), new a("if-none-match", ""), new a("if-range", ""), new a("if-unmodified-since", ""), new a("last-modified", ""), new a("link", ""), new a("location", ""), new a("max-forwards", ""), new a("proxy-authenticate", ""), new a("proxy-authorization", ""), new a("range", ""), new a("referer", ""), new a("refresh", ""), new a("retry-after", ""), new a("server", ""), new a("set-cookie", ""), new a("strict-transport-security", ""), new a("transfer-encoding", ""), new a("user-agent", ""), new a("vary", ""), new a("via", ""), new a("www-authenticate", "")};
    static final Map<ByteString, Integer> b = a();

    private b() {
    }

    private static Map<ByteString, Integer> a() {
        Map linkedHashMap = new LinkedHashMap(a.length);
        for (int i = 0; i < a.length; i++) {
            if (!linkedHashMap.containsKey(a[i].g)) {
                linkedHashMap.put(a[i].g, Integer.valueOf(i));
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    static ByteString a(ByteString byteString) {
        int i = 0;
        int g = byteString.g();
        while (i < g) {
            byte a = byteString.a(i);
            if (a < (byte) 65 || a > (byte) 90) {
                i++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.a());
            }
        }
        return byteString;
    }
}
