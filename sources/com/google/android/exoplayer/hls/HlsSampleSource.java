package com.google.android.exoplayer.hls;

import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer.LoadControl;
import com.google.android.exoplayer.SampleSource;
import com.google.android.exoplayer.SampleSource.SampleSourceReader;
import com.google.android.exoplayer.chunk.BaseChunkSampleSourceEventListener;
import com.google.android.exoplayer.chunk.b;
import com.google.android.exoplayer.chunk.f;
import com.google.android.exoplayer.k;
import com.google.android.exoplayer.l;
import com.google.android.exoplayer.m;
import com.google.android.exoplayer.p;
import com.google.android.exoplayer.upstream.Loader;
import com.google.android.exoplayer.upstream.Loader.Callback;
import com.google.android.exoplayer.upstream.Loader.Loadable;
import java.io.IOException;
import java.util.LinkedList;

public final class HlsSampleSource implements SampleSource, SampleSourceReader, Callback {
    private IOException A;
    private int B;
    private long C;
    private long D;
    private final HlsChunkSource a;
    private final LinkedList<d> b;
    private final int c;
    private final int d;
    private final int e;
    private final LoadControl f;
    private final Handler g;
    private final EventListener h;
    private int i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private boolean[] n;
    private boolean[] o;
    private p[] p;
    private k[] q;
    private f r;
    private long s;
    private long t;
    private long u;
    private boolean v;
    private b w;
    private m x;
    private m y;
    private Loader z;

    public interface EventListener extends BaseChunkSampleSourceEventListener {
    }

    private d a() {
        d dVar;
        Object first = this.b.getFirst();
        while (true) {
            dVar = (d) first;
            if (this.b.size() <= 1 || a(dVar)) {
                return dVar;
            }
            ((d) this.b.removeFirst()).b();
            first = this.b.getFirst();
        }
        return dVar;
    }

    private void a(long j, int i, int i2, f fVar, long j2, long j3) {
        if (this.g != null && this.h != null) {
            final long j4 = j;
            final int i3 = i;
            final int i4 = i2;
            final f fVar2 = fVar;
            final long j5 = j2;
            final long j6 = j3;
            this.g.post(new Runnable() {
                public void run() {
                    HlsSampleSource.this.h.onLoadStarted(HlsSampleSource.this.e, j4, i3, i4, fVar2, HlsSampleSource.this.a(j5), HlsSampleSource.this.a(j6));
                }
            });
        }
    }

    private void a(long j, int i, int i2, f fVar, long j2, long j3, long j4, long j5) {
        if (this.g != null && this.h != null) {
            final long j6 = j;
            final int i3 = i;
            final int i4 = i2;
            final f fVar2 = fVar;
            final long j7 = j2;
            final long j8 = j3;
            final long j9 = j4;
            final long j10 = j5;
            this.g.post(new Runnable() {
                public void run() {
                    HlsSampleSource.this.h.onLoadCompleted(HlsSampleSource.this.e, j6, i3, i4, fVar2, HlsSampleSource.this.a(j7), HlsSampleSource.this.a(j8), j9, j10);
                }
            });
        }
    }

    private void a(f fVar, int i, long j) {
        if (this.g != null && this.h != null) {
            final f fVar2 = fVar;
            final int i2 = i;
            final long j2 = j;
            this.g.post(new Runnable() {
                public void run() {
                    HlsSampleSource.this.h.onDownstreamFormatChanged(HlsSampleSource.this.e, fVar2, i2, HlsSampleSource.this.a(j2));
                }
            });
        }
    }

    private void a(d dVar, long j) {
        if (dVar.a()) {
            for (int i = 0; i < this.n.length; i++) {
                if (!this.n[i]) {
                    dVar.a(i, j);
                }
            }
        }
    }

    private void a(final IOException iOException) {
        if (this.g != null && this.h != null) {
            this.g.post(new Runnable() {
                public void run() {
                    HlsSampleSource.this.h.onLoadError(HlsSampleSource.this.e, iOException);
                }
            });
        }
    }

    private boolean a(b bVar) {
        return bVar instanceof m;
    }

    private boolean a(d dVar) {
        if (!dVar.a()) {
            return false;
        }
        int i = 0;
        while (i < this.n.length) {
            if (this.n[i] && dVar.b(i)) {
                return true;
            }
            i++;
        }
        return false;
    }

    private void b() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.b.size()) {
                ((d) this.b.get(i2)).b();
                i = i2 + 1;
            } else {
                this.b.clear();
                c();
                this.y = null;
                return;
            }
        }
    }

    private void b(long j) {
        this.u = j;
        this.v = false;
        if (this.z.a()) {
            this.z.b();
            return;
        }
        b();
        d();
    }

    private long c(long j) {
        return Math.min((j - 1) * 1000, 5000);
    }

    private void c() {
        this.x = null;
        this.w = null;
        this.A = null;
        this.B = 0;
    }

    private void d() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long e = e();
        Object obj = this.A != null ? 1 : null;
        boolean z = this.z.a() || obj != null;
        boolean update = this.f.update(this, this.s, e, z);
        if (obj != null) {
            if (elapsedRealtime - this.C >= c((long) this.B)) {
                this.A = null;
                this.z.a(this.w, (Callback) this);
            }
        } else if (!this.z.a() && update) {
            b a = this.a.a(this.y, this.u, this.s);
            if (a != null) {
                this.D = elapsedRealtime;
                this.w = a;
                if (a(this.w)) {
                    m mVar = (m) this.w;
                    if (f()) {
                        this.u = -1;
                    }
                    d dVar = mVar.a;
                    if (this.b.isEmpty() || this.b.getLast() != dVar) {
                        dVar.a(this.f.getAllocator());
                        this.b.addLast(dVar);
                    }
                    a(mVar.e.e, mVar.b, mVar.c, mVar.d, mVar.g, mVar.h);
                    this.x = mVar;
                } else {
                    a(this.w.e.e, this.w.b, this.w.c, this.w.d, -1, -1);
                }
                this.z.a(this.w, (Callback) this);
            }
        }
    }

    private void d(final long j) {
        if (this.g != null && this.h != null) {
            this.g.post(new Runnable() {
                public void run() {
                    HlsSampleSource.this.h.onLoadCanceled(HlsSampleSource.this.e, j);
                }
            });
        }
    }

    private long e() {
        return f() ? this.u : this.x != null ? !this.x.j ? this.x.h : -1 : !this.y.j ? this.y.h : -1;
    }

    private boolean f() {
        return this.u != -1;
    }

    int a(long j) {
        return (int) (j / 1000);
    }

    public boolean continueBuffering(int i, long j) {
        com.google.android.exoplayer.util.b.b(this.j);
        com.google.android.exoplayer.util.b.b(this.n[i]);
        this.s = j;
        if (!this.b.isEmpty()) {
            a(a(), this.s);
        }
        if (this.v) {
            return true;
        }
        d();
        if (f() || this.b.isEmpty()) {
            return false;
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            d dVar = (d) this.b.get(i2);
            if (!dVar.a()) {
                return false;
            }
            if (dVar.b(i)) {
                return true;
            }
        }
        return false;
    }

    public void disable(int i) {
        com.google.android.exoplayer.util.b.b(this.j);
        com.google.android.exoplayer.util.b.b(this.n[i]);
        this.m--;
        this.n[i] = false;
        if (this.m == 0) {
            this.s = Long.MIN_VALUE;
            if (this.k) {
                this.f.unregister(this);
                this.k = false;
            }
            if (this.z.a()) {
                this.z.b();
                return;
            }
            b();
            this.f.trimAllocator();
        }
    }

    public void enable(int i, long j) {
        com.google.android.exoplayer.util.b.b(this.j);
        com.google.android.exoplayer.util.b.b(!this.n[i]);
        this.m++;
        this.n[i] = true;
        this.q[i] = null;
        this.r = null;
        if (!this.k) {
            this.f.register(this, this.d);
            this.k = true;
        }
        if (this.m == 1) {
            seekToUs(j);
        }
        this.o[i] = false;
    }

    public long getBufferedPositionUs() {
        com.google.android.exoplayer.util.b.b(this.j);
        com.google.android.exoplayer.util.b.b(this.m > 0);
        if (f()) {
            return this.u;
        }
        if (this.v) {
            return -3;
        }
        long c = ((d) this.b.getLast()).c();
        return c == Long.MIN_VALUE ? this.s : c;
    }

    public int getTrackCount() {
        com.google.android.exoplayer.util.b.b(this.j);
        return this.l;
    }

    public p getTrackInfo(int i) {
        com.google.android.exoplayer.util.b.b(this.j);
        return this.p[i];
    }

    public void maybeThrowError() {
        if (this.A != null && this.B > this.c) {
            throw this.A;
        }
    }

    public void onLoadCanceled(Loadable loadable) {
        d(this.w.e());
        if (this.m > 0) {
            b(this.u);
            return;
        }
        b();
        this.f.trimAllocator();
    }

    public void onLoadCompleted(Loadable loadable) {
        boolean z = true;
        com.google.android.exoplayer.util.b.b(loadable == this.w);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = elapsedRealtime - this.D;
        this.a.a(this.w);
        if (a(this.w)) {
            if (this.w != this.x) {
                z = false;
            }
            com.google.android.exoplayer.util.b.b(z);
            this.v = this.x.j;
            this.y = this.x;
            a(this.w.e(), this.x.b, this.x.c, this.x.d, this.x.g, this.x.h, elapsedRealtime, j);
        } else {
            a(this.w.e(), this.w.b, this.w.c, this.w.d, -1, -1, elapsedRealtime, j);
        }
        c();
        if (this.m > 0 || !this.j) {
            d();
        }
    }

    public void onLoadError(Loadable loadable, IOException iOException) {
        if (this.a.a(this.w, iOException)) {
            if (this.y == null && !f()) {
                this.u = this.t;
            }
            c();
        } else {
            this.A = iOException;
            this.B++;
            this.C = SystemClock.elapsedRealtime();
        }
        a(iOException);
        d();
    }

    public boolean prepare(long j) {
        int i = 0;
        if (this.j) {
            return true;
        }
        if (!this.b.isEmpty()) {
            d a = a();
            if (a.a()) {
                this.l = a.d();
                this.n = new boolean[this.l];
                this.o = new boolean[this.l];
                this.q = new k[this.l];
                this.p = new p[this.l];
                while (i < this.l) {
                    this.p[i] = new p(a.a(i).a, this.a.a());
                    i++;
                }
                this.j = true;
                return true;
            }
        }
        if (this.z == null) {
            this.z = new Loader("Loader:HLS");
        }
        if (!this.k) {
            this.f.register(this, this.d);
            this.k = true;
        }
        if (!this.z.a()) {
            this.u = j;
            this.s = j;
        }
        d();
        return false;
    }

    public int readData(int i, long j, l lVar, m mVar, boolean z) {
        int i2 = 0;
        com.google.android.exoplayer.util.b.b(this.j);
        this.s = j;
        if (this.o[i]) {
            this.o[i] = false;
            return -5;
        } else if (z) {
            return -2;
        } else {
            if (f()) {
                return -2;
            }
            d a = a();
            if (!a.a()) {
                return -2;
            }
            int i3;
            if (this.r == null || !this.r.equals(a.b)) {
                a(a.b, a.a, a.c);
                this.r = a.b;
            }
            if (this.b.size() > 1) {
                a.a((d) this.b.get(1));
            }
            int i4 = 0;
            while (this.b.size() > i4 + 1 && !a.b(i)) {
                i3 = i4 + 1;
                d dVar = (d) this.b.get(i3);
                if (!dVar.a()) {
                    return -2;
                }
                int i5 = i3;
                a = dVar;
                i4 = i5;
            }
            k a2 = a.a(i);
            if (a2 != null && !a2.a(this.q[i], true)) {
                this.a.a(a2);
                lVar.a = a2;
                this.q[i] = a2;
                return -4;
            } else if (!a.a(i, mVar)) {
                return this.v ? -1 : -2;
            } else {
                boolean z2 = mVar.e < this.t;
                i3 = mVar.d;
                if (z2) {
                    i2 = 134217728;
                }
                mVar.d = i3 | i2;
                return -3;
            }
        }
    }

    public SampleSourceReader register() {
        this.i++;
        return this;
    }

    public void release() {
        com.google.android.exoplayer.util.b.b(this.i > 0);
        int i = this.i - 1;
        this.i = i;
        if (i == 0 && this.z != null) {
            this.z.c();
            this.z = null;
        }
    }

    public void seekToUs(long j) {
        int i = 0;
        com.google.android.exoplayer.util.b.b(this.j);
        com.google.android.exoplayer.util.b.b(this.m > 0);
        long j2 = f() ? this.u : this.s;
        this.s = j;
        this.t = j;
        if (j2 != j) {
            this.s = j;
            while (i < this.o.length) {
                this.o[i] = true;
                i++;
            }
            b(j);
        }
    }
}
