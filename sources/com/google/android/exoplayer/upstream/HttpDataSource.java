package com.google.android.exoplayer.upstream;

import android.text.TextUtils;
import com.google.android.exoplayer.util.Predicate;
import com.google.android.exoplayer.util.m;
import com.mopub.common.AdType;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface HttpDataSource extends UriDataSource {
    public static final Predicate<String> a = new Predicate<String>() {
        /* renamed from: a */
        public boolean evaluate(String str) {
            String b = m.b(str);
            return (TextUtils.isEmpty(b) || ((b.contains("text") && !b.contains("text/vtt")) || b.contains(AdType.HTML) || b.contains("xml"))) ? false : true;
        }
    };

    public class HttpDataSourceException extends IOException {
        public final c a;

        public HttpDataSourceException(IOException iOException, c cVar) {
            super(iOException);
            this.a = cVar;
        }

        public HttpDataSourceException(String str, c cVar) {
            super(str);
            this.a = cVar;
        }

        public HttpDataSourceException(String str, IOException iOException, c cVar) {
            super(str, iOException);
            this.a = cVar;
        }
    }

    public final class InvalidContentTypeException extends HttpDataSourceException {
        public final String b;

        public InvalidContentTypeException(String str, c cVar) {
            super("Invalid content type: " + str, cVar);
            this.b = str;
        }
    }

    public final class InvalidResponseCodeException extends HttpDataSourceException {
        public final int b;
        public final Map<String, List<String>> c;

        public InvalidResponseCodeException(int i, Map<String, List<String>> map, c cVar) {
            super("Response code: " + i, cVar);
            this.b = i;
            this.c = map;
        }
    }

    void clearAllRequestProperties();

    void clearRequestProperty(String str);

    void close();

    Map<String, List<String>> getResponseHeaders();

    long open(c cVar);

    int read(byte[] bArr, int i, int i2);

    void setRequestProperty(String str, String str2);
}
