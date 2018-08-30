package okhttp3;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.b.h;
import okhttp3.internal.c;
import okhttp3.internal.connection.d;
import okhttp3.internal.connection.f;
import okhttp3.internal.connection.g;

public final class i {
    static final /* synthetic */ boolean c = (!i.class.desiredAssertionStatus());
    private static final Executor d = new ThreadPoolExecutor(0, MoPubClientPositioning.NO_REPEAT, 60, TimeUnit.SECONDS, new SynchronousQueue(), c.a("OkHttp ConnectionPool", true));
    final d a;
    boolean b;
    private final int e;
    private final long f;
    private final Runnable g;
    private final Deque<okhttp3.internal.connection.c> h;

    public i() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public i(int i, long j, TimeUnit timeUnit) {
        this.g = new Runnable() {
            public void run() {
                while (true) {
                    long a = i.this.a(System.nanoTime());
                    if (a != -1) {
                        if (a > 0) {
                            long j = a / 1000000;
                            a -= j * 1000000;
                            synchronized (i.this) {
                                try {
                                    i.this.wait(j, (int) a);
                                } catch (InterruptedException e) {
                                }
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
        };
        this.h = new ArrayDeque();
        this.a = new d();
        this.e = i;
        this.f = timeUnit.toNanos(j);
        if (j <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
        }
    }

    private int a(okhttp3.internal.connection.c cVar, long j) {
        List list = cVar.d;
        int i = 0;
        while (i < list.size()) {
            Reference reference = (Reference) list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                g gVar = (g) reference;
                h.b().a("A connection to " + cVar.route().a().a() + " was leaked. Did you forget to close a response body?", gVar.a);
                list.remove(i);
                cVar.a = true;
                if (list.isEmpty()) {
                    cVar.e = j - this.f;
                    return 0;
                }
            }
        }
        return list.size();
    }

    long a(long j) {
        okhttp3.internal.connection.c cVar = null;
        long j2 = Long.MIN_VALUE;
        synchronized (this) {
            long j3;
            int i = 0;
            int i2 = 0;
            for (okhttp3.internal.connection.c cVar2 : this.h) {
                if (a(cVar2, j) > 0) {
                    i2++;
                } else {
                    okhttp3.internal.connection.c cVar3;
                    int i3 = i + 1;
                    long j4 = j - cVar2.e;
                    if (j4 > j2) {
                        long j5 = j4;
                        cVar3 = cVar2;
                        j3 = j5;
                    } else {
                        cVar3 = cVar;
                        j3 = j2;
                    }
                    j2 = j3;
                    cVar = cVar3;
                    i = i3;
                }
            }
            if (j2 >= this.f || i > this.e) {
                this.h.remove(cVar);
                c.a(cVar.socket());
                return 0;
            } else if (i > 0) {
                j3 = this.f - j2;
                return j3;
            } else if (i2 > 0) {
                j3 = this.f;
                return j3;
            } else {
                this.b = false;
                return -1;
            }
        }
    }

    @Nullable
    Socket a(a aVar, f fVar) {
        if (c || Thread.holdsLock(this)) {
            for (okhttp3.internal.connection.c cVar : this.h) {
                if (cVar.a(aVar, null) && cVar.b() && cVar != fVar.b()) {
                    return fVar.b(cVar);
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    @Nullable
    okhttp3.internal.connection.c a(a aVar, f fVar, ak akVar) {
        if (c || Thread.holdsLock(this)) {
            for (okhttp3.internal.connection.c cVar : this.h) {
                if (cVar.a(aVar, akVar)) {
                    fVar.a(cVar);
                    return cVar;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    void a(okhttp3.internal.connection.c cVar) {
        if (c || Thread.holdsLock(this)) {
            if (!this.b) {
                this.b = true;
                d.execute(this.g);
            }
            this.h.add(cVar);
            return;
        }
        throw new AssertionError();
    }

    boolean b(okhttp3.internal.connection.c cVar) {
        if (!c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (cVar.a || this.e == 0) {
            this.h.remove(cVar);
            return true;
        } else {
            notifyAll();
            return false;
        }
    }
}
