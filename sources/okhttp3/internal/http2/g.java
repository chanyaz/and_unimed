package okhttp3.internal.http2;

import okio.Source;
import okio.e;

class g extends e {
    final /* synthetic */ f a;

    g(f fVar, Source source) {
        this.a = fVar;
        super(source);
    }

    public void close() {
        this.a.a.a(false, this.a);
        super.close();
    }
}
