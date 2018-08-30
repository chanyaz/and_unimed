package okhttp3.internal.http2;

import java.io.IOException;
import java.net.SocketTimeoutException;
import okio.a;

class p extends a {
    final /* synthetic */ m a;

    p(m mVar) {
        this.a = mVar;
    }

    protected IOException a(IOException iOException) {
        IOException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    protected void a() {
        this.a.b(ErrorCode.CANCEL);
    }

    public void b() {
        if (k_()) {
            throw a(null);
        }
    }
}
