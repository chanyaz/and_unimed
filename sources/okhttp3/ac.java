package okhttp3;

import java.io.IOException;
import okhttp3.internal.b;
import okhttp3.internal.b.h;

final class ac extends b {
    final /* synthetic */ ab a;
    private final Callback c;

    ac(ab abVar, Callback callback) {
        this.a = abVar;
        super("OkHttp %s", abVar.d());
        this.c = callback;
    }

    String a() {
        return this.a.d.a().f();
    }

    protected void b() {
        Throwable e;
        Object obj = 1;
        Object obj2 = null;
        try {
            ag e2 = this.a.e();
            if (this.a.b.b()) {
                try {
                    this.c.onFailure(this.a, new IOException("Canceled"));
                } catch (IOException e3) {
                    e = e3;
                }
            } else {
                this.c.onResponse(this.a, e2);
            }
            this.a.a.t().b(this);
            return;
        } catch (IOException e4) {
            e = e4;
            obj = obj2;
        }
        if (obj != null) {
            try {
                h.b().a(4, "Callback failure for " + this.a.c(), e);
            } catch (Throwable th) {
                this.a.a.t().b(this);
            }
        } else {
            this.c.onFailure(this.a, e);
        }
        this.a.a.t().b(this);
    }
}
