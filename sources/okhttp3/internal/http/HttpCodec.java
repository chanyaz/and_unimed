package okhttp3.internal.http;

import okhttp3.ad;
import okhttp3.ag;
import okhttp3.ah;
import okhttp3.ai;
import okio.Sink;

public interface HttpCodec {
    void cancel();

    Sink createRequestBody(ad adVar, long j);

    void finishRequest();

    void flushRequest();

    ai openResponseBody(ag agVar);

    ah readResponseHeaders(boolean z);

    void writeRequestHeaders(ad adVar);
}
