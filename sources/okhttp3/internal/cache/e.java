package okhttp3.internal.cache;

import java.io.IOException;

public final class e {
    final f a;
    final boolean[] b;
    final /* synthetic */ d c;
    private boolean d;

    void a() {
        if (this.a.f == this) {
            for (int i = 0; i < this.c.c; i++) {
                try {
                    this.c.b.delete(this.a.d[i]);
                } catch (IOException e) {
                }
            }
            this.a.f = null;
        }
    }

    public void b() {
        synchronized (this.c) {
            if (this.d) {
                throw new IllegalStateException();
            }
            if (this.a.f == this) {
                this.c.a(this, false);
            }
            this.d = true;
        }
    }
}
