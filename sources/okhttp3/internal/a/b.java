package okhttp3.internal.a;

import okio.Source;
import okio.f;
import okio.p;

abstract class b implements Source {
    protected final f a;
    protected boolean b;
    final /* synthetic */ a c;

    private b(a aVar) {
        this.c = aVar;
        this.a = new f(this.c.c.timeout());
    }

    protected final void a(boolean z) {
        if (this.c.e != 6) {
            if (this.c.e != 5) {
                throw new IllegalStateException("state: " + this.c.e);
            }
            this.c.a(this.a);
            this.c.e = 6;
            if (this.c.b != null) {
                this.c.b.a(!z, this.c);
            }
        }
    }

    public p timeout() {
        return this.a;
    }
}
