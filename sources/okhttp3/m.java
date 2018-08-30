package okhttp3;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.c;

public final class m {
    private int a = 64;
    private int b = 5;
    @Nullable
    private Runnable c;
    @Nullable
    private ExecutorService d;
    private final Deque<ac> e = new ArrayDeque();
    private final Deque<ac> f = new ArrayDeque();
    private final Deque<ab> g = new ArrayDeque();

    private <T> void a(Deque<T> deque, T t, boolean z) {
        int b;
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                if (z) {
                    c();
                }
                b = b();
                runnable = this.c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (b == 0 && runnable != null) {
            runnable.run();
        }
    }

    private int c(ac acVar) {
        int i = 0;
        Iterator it = this.f.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = ((ac) it.next()).a().equals(acVar.a()) ? i2 + 1 : i2;
        }
    }

    private void c() {
        if (this.f.size() < this.a && !this.e.isEmpty()) {
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                ac acVar = (ac) it.next();
                if (c(acVar) < this.b) {
                    it.remove();
                    this.f.add(acVar);
                    a().execute(acVar);
                }
                if (this.f.size() >= this.a) {
                    return;
                }
            }
        }
    }

    public synchronized ExecutorService a() {
        if (this.d == null) {
            this.d = new ThreadPoolExecutor(0, MoPubClientPositioning.NO_REPEAT, 60, TimeUnit.SECONDS, new SynchronousQueue(), c.a("OkHttp Dispatcher", false));
        }
        return this.d;
    }

    synchronized void a(ab abVar) {
        this.g.add(abVar);
    }

    synchronized void a(ac acVar) {
        if (this.f.size() >= this.a || c(acVar) >= this.b) {
            this.e.add(acVar);
        } else {
            this.f.add(acVar);
            a().execute(acVar);
        }
    }

    public synchronized int b() {
        return this.f.size() + this.g.size();
    }

    void b(ab abVar) {
        a(this.g, abVar, false);
    }

    void b(ac acVar) {
        a(this.f, acVar, true);
    }
}
