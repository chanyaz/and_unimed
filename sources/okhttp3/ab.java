package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.EventListener.Factory;
import okhttp3.internal.b.h;
import okhttp3.internal.connection.f;
import okhttp3.internal.http.a;
import okhttp3.internal.http.b;
import okhttp3.internal.http.i;

final class ab implements Call {
    final z a;
    final i b;
    final EventListener c;
    final ad d;
    final boolean e;
    private boolean f;

    ab(z zVar, ad adVar, boolean z) {
        Factory y = zVar.y();
        this.a = zVar;
        this.d = adVar;
        this.e = z;
        this.b = new i(zVar, z);
        this.c = y.create(this);
    }

    private void f() {
        this.b.a(h.b().a("response.body().close()"));
    }

    /* renamed from: a */
    public ab clone() {
        return new ab(this.a, this.d, this.e);
    }

    f b() {
        return this.b.c();
    }

    String c() {
        return (isCanceled() ? "canceled " : "") + (this.e ? "web socket" : "call") + " to " + d();
    }

    public void cancel() {
        this.b.a();
    }

    String d() {
        return this.d.a().n();
    }

    ag e() {
        List arrayList = new ArrayList();
        arrayList.addAll(this.a.w());
        arrayList.add(this.b);
        arrayList.add(new a(this.a.g()));
        arrayList.add(new okhttp3.internal.cache.a(this.a.h()));
        arrayList.add(new okhttp3.internal.connection.a(this.a));
        if (!this.e) {
            arrayList.addAll(this.a.x());
        }
        arrayList.add(new b(this.e));
        return new okhttp3.internal.http.f(arrayList, null, null, null, 0, this.d).proceed(this.d);
    }

    public void enqueue(Callback callback) {
        synchronized (this) {
            if (this.f) {
                throw new IllegalStateException("Already Executed");
            }
            this.f = true;
        }
        f();
        this.a.t().a(new ac(this, callback));
    }

    public ag execute() {
        synchronized (this) {
            if (this.f) {
                throw new IllegalStateException("Already Executed");
            }
            this.f = true;
        }
        f();
        try {
            this.a.t().a(this);
            ag e = e();
            if (e != null) {
                return e;
            }
            throw new IOException("Canceled");
        } finally {
            this.a.t().b(this);
        }
    }

    public boolean isCanceled() {
        return this.b.b();
    }

    public synchronized boolean isExecuted() {
        return this.f;
    }

    public ad request() {
        return this.d;
    }
}
