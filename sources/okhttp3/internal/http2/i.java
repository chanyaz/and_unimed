package okhttp3.internal.http2;

import java.net.Socket;
import okio.BufferedSink;
import okio.BufferedSource;

public class i {
    Socket a;
    String b;
    BufferedSource c;
    BufferedSink d;
    j e = j.f;
    PushObserver f = PushObserver.a;
    boolean g;

    public i(boolean z) {
        this.g = z;
    }

    public h a() {
        return new h(this);
    }

    public i a(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.a = socket;
        this.b = str;
        this.c = bufferedSource;
        this.d = bufferedSink;
        return this;
    }

    public i a(j jVar) {
        this.e = jVar;
        return this;
    }
}
