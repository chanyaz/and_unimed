package com.google.android.exoplayer.chunk;

import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer.LoadControl;
import com.google.android.exoplayer.SampleSource;
import com.google.android.exoplayer.SampleSource.SampleSourceReader;
import com.google.android.exoplayer.extractor.c;
import com.google.android.exoplayer.k;
import com.google.android.exoplayer.l;
import com.google.android.exoplayer.m;
import com.google.android.exoplayer.p;
import com.google.android.exoplayer.upstream.Loader;
import com.google.android.exoplayer.upstream.Loader.Callback;
import com.google.android.exoplayer.upstream.Loader.Loadable;
import com.google.android.exoplayer.util.b;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ChunkSampleSource implements SampleSource, SampleSourceReader, Callback {
    private final int a;
    private final LoadControl b;
    private final ChunkSource c;
    private final c d;
    private final LinkedList<a> e;
    private final List<a> f;
    private final c g;
    private final int h;
    private final Handler i;
    private final EventListener j;
    private final int k;
    private int l;
    private long m;
    private long n;
    private long o;
    private long p;
    private boolean q;
    private Loader r;
    private boolean s;
    private IOException t;
    private int u;
    private long v;
    private long w;
    private k x;
    private f y;

    public interface EventListener extends BaseChunkSampleSourceEventListener {
    }

    private void a() {
        this.d.b = null;
        b();
    }

    private void a(long j, int i, int i2, f fVar, long j2, long j3) {
        if (this.i != null && this.j != null) {
            final long j4 = j;
            final int i3 = i;
            final int i4 = i2;
            final f fVar2 = fVar;
            final long j5 = j2;
            final long j6 = j3;
            this.i.post(new Runnable() {
                public void run() {
                    ChunkSampleSource.this.j.onLoadStarted(ChunkSampleSource.this.a, j4, i3, i4, fVar2, ChunkSampleSource.this.a(j5), ChunkSampleSource.this.a(j6));
                }
            });
        }
    }

    private void a(long j, int i, int i2, f fVar, long j2, long j3, long j4, long j5) {
        if (this.i != null && this.j != null) {
            final long j6 = j;
            final int i3 = i;
            final int i4 = i2;
            final f fVar2 = fVar;
            final long j7 = j2;
            final long j8 = j3;
            final long j9 = j4;
            final long j10 = j5;
            this.i.post(new Runnable() {
                public void run() {
                    ChunkSampleSource.this.j.onLoadCompleted(ChunkSampleSource.this.a, j6, i3, i4, fVar2, ChunkSampleSource.this.a(j7), ChunkSampleSource.this.a(j8), j9, j10);
                }
            });
        }
    }

    private void a(long j, long j2) {
        if (this.i != null && this.j != null) {
            final long j3 = j;
            final long j4 = j2;
            this.i.post(new Runnable() {
                public void run() {
                    ChunkSampleSource.this.j.onUpstreamDiscarded(ChunkSampleSource.this.a, ChunkSampleSource.this.a(j3), ChunkSampleSource.this.a(j4));
                }
            });
        }
    }

    private void a(f fVar, int i, long j) {
        if (this.i != null && this.j != null) {
            final f fVar2 = fVar;
            final int i2 = i;
            final long j2 = j;
            this.i.post(new Runnable() {
                public void run() {
                    ChunkSampleSource.this.j.onDownstreamFormatChanged(ChunkSampleSource.this.a, fVar2, i2, ChunkSampleSource.this.a(j2));
                }
            });
        }
    }

    private void a(final IOException iOException) {
        if (this.i != null && this.j != null) {
            this.i.post(new Runnable() {
                public void run() {
                    ChunkSampleSource.this.j.onLoadError(ChunkSampleSource.this.a, iOException);
                }
            });
        }
    }

    private boolean a(int i) {
        if (this.e.size() <= i) {
            return false;
        }
        long j = 0;
        long j2 = ((a) this.e.getLast()).h;
        a aVar = null;
        while (this.e.size() > i) {
            aVar = (a) this.e.removeLast();
            j = aVar.g;
        }
        this.g.a(aVar.a());
        a(j, j2);
        return true;
    }

    private boolean a(b bVar) {
        return bVar instanceof a;
    }

    private void b() {
        this.t = null;
        this.u = 0;
    }

    private void b(long j) {
        this.o = j;
        this.s = false;
        if (this.r.a()) {
            this.r.b();
            return;
        }
        this.g.a();
        this.e.clear();
        a();
        c();
    }

    private long c(long j) {
        return Math.min((j - 1) * 1000, 5000);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0067  */
    private void c() {
        /*
        r14 = this;
        r12 = android.os.SystemClock.elapsedRealtime();
        r8 = r14.d();
        r0 = r14.t;
        if (r0 == 0) goto L_0x007a;
    L_0x000c:
        r0 = 1;
        r7 = r0;
    L_0x000e:
        r0 = r14.r;
        r0 = r0.a();
        if (r0 != 0) goto L_0x0018;
    L_0x0016:
        if (r7 == 0) goto L_0x007d;
    L_0x0018:
        r0 = 1;
        r10 = r0;
    L_0x001a:
        if (r10 != 0) goto L_0x0095;
    L_0x001c:
        r0 = r14.d;
        r0 = r0.b;
        if (r0 != 0) goto L_0x0028;
    L_0x0022:
        r0 = -1;
        r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1));
        if (r0 != 0) goto L_0x0032;
    L_0x0028:
        r0 = r14.p;
        r0 = r12 - r0;
        r2 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x0095;
    L_0x0032:
        r14.p = r12;
        r0 = r14.d;
        r1 = r14.f;
        r1 = r1.size();
        r0.a = r1;
        r0 = r14.c;
        r1 = r14.f;
        r2 = r14.o;
        r4 = r14.m;
        r6 = r14.d;
        r0.getChunkOperation(r1, r2, r4, r6);
        r0 = r14.d;
        r0 = r0.a;
        r0 = r14.a(r0);
        r1 = r14.d;
        r1 = r1.b;
        if (r1 != 0) goto L_0x0080;
    L_0x0059:
        r4 = -1;
    L_0x005b:
        r0 = r14.b;
        r2 = r14.m;
        r1 = r14;
        r6 = r10;
        r0 = r0.update(r1, r2, r4, r6);
        if (r7 == 0) goto L_0x0087;
    L_0x0067:
        r0 = r14.v;
        r0 = r12 - r0;
        r2 = r14.u;
        r2 = (long) r2;
        r2 = r14.c(r2);
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 < 0) goto L_0x0079;
    L_0x0076:
        r14.e();
    L_0x0079:
        return;
    L_0x007a:
        r0 = 0;
        r7 = r0;
        goto L_0x000e;
    L_0x007d:
        r0 = 0;
        r10 = r0;
        goto L_0x001a;
    L_0x0080:
        if (r0 == 0) goto L_0x0095;
    L_0x0082:
        r4 = r14.d();
        goto L_0x005b;
    L_0x0087:
        r1 = r14.r;
        r1 = r1.a();
        if (r1 != 0) goto L_0x0079;
    L_0x008f:
        if (r0 == 0) goto L_0x0079;
    L_0x0091:
        r14.f();
        goto L_0x0079;
    L_0x0095:
        r4 = r8;
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer.chunk.ChunkSampleSource.c():void");
    }

    private long d() {
        if (g()) {
            return this.o;
        }
        a aVar = (a) this.e.getLast();
        return aVar.j ? -1 : aVar.h;
    }

    private void d(final long j) {
        if (this.i != null && this.j != null) {
            this.i.post(new Runnable() {
                public void run() {
                    ChunkSampleSource.this.j.onLoadCanceled(ChunkSampleSource.this.a, j);
                }
            });
        }
    }

    private void e() {
        this.t = null;
        Loadable loadable = this.d.b;
        if (!a((b) loadable)) {
            this.d.a = this.f.size();
            this.c.getChunkOperation(this.f, this.o, this.m, this.d);
            a(this.d.a);
            if (this.d.b == loadable) {
                this.r.a(loadable, (Callback) this);
                return;
            }
            d(loadable.e());
            f();
        } else if (loadable == this.e.getFirst()) {
            this.r.a(loadable, (Callback) this);
        } else {
            Loadable loadable2 = (a) this.e.removeLast();
            b.b(loadable == loadable2);
            this.d.a = this.f.size();
            this.c.getChunkOperation(this.f, this.o, this.m, this.d);
            this.e.add(loadable2);
            if (this.d.b == loadable) {
                this.r.a(loadable, (Callback) this);
                return;
            }
            d(loadable.e());
            a(this.d.a);
            b();
            f();
        }
    }

    private void f() {
        Loadable loadable = this.d.b;
        if (loadable != null) {
            this.w = SystemClock.elapsedRealtime();
            if (a((b) loadable)) {
                a aVar = (a) loadable;
                aVar.a(this.g);
                this.e.add(aVar);
                if (g()) {
                    this.o = -1;
                }
                a(aVar.e.e, aVar.b, aVar.c, aVar.d, aVar.g, aVar.h);
            } else {
                a(loadable.e.e, loadable.b, loadable.c, loadable.d, -1, -1);
            }
            this.r.a(loadable, (Callback) this);
        }
    }

    private boolean g() {
        return this.o != -1;
    }

    protected final int a(long j) {
        return (int) (j / 1000);
    }

    protected void a(i iVar, m mVar) {
    }

    public boolean continueBuffering(int i, long j) {
        b.b(this.l == 3);
        b.b(i == 0);
        this.m = j;
        this.c.continueBuffering(j);
        c();
        return this.s || !this.g.g();
    }

    public void disable(int i) {
        boolean z = true;
        b.b(this.l == 3);
        if (i != 0) {
            z = false;
        }
        b.b(z);
        this.l = 2;
        try {
            this.c.disable(this.e);
        } finally {
            this.b.unregister(this);
            if (this.r.a()) {
                this.r.b();
            } else {
                this.g.a();
                this.e.clear();
                a();
                this.b.trimAllocator();
            }
        }
    }

    public void enable(int i, long j) {
        boolean z = true;
        b.b(this.l == 2);
        if (i != 0) {
            z = false;
        }
        b.b(z);
        this.l = 3;
        this.c.enable();
        this.b.register(this, this.h);
        this.y = null;
        this.x = null;
        this.m = j;
        this.n = j;
        this.q = false;
        b(j);
    }

    public long getBufferedPositionUs() {
        b.b(this.l == 3);
        if (g()) {
            return this.o;
        }
        if (this.s) {
            return -3;
        }
        long f = this.g.f();
        return f == Long.MIN_VALUE ? this.m : f;
    }

    public int getTrackCount() {
        boolean z = this.l == 2 || this.l == 3;
        b.b(z);
        return 1;
    }

    public p getTrackInfo(int i) {
        boolean z = true;
        boolean z2 = this.l == 2 || this.l == 3;
        b.b(z2);
        if (i != 0) {
            z = false;
        }
        b.b(z);
        return this.c.getTrackInfo();
    }

    public void maybeThrowError() {
        if (this.t != null && this.u > this.k) {
            throw this.t;
        } else if (this.d.b == null) {
            this.c.maybeThrowError();
        }
    }

    public void onLoadCanceled(Loadable loadable) {
        d(this.d.b.e());
        a();
        if (this.l == 3) {
            b(this.o);
            return;
        }
        this.g.a();
        this.e.clear();
        a();
        this.b.trimAllocator();
    }

    public void onLoadCompleted(Loadable loadable) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = elapsedRealtime - this.w;
        b bVar = this.d.b;
        this.c.onChunkLoadCompleted(bVar);
        if (a(bVar)) {
            i iVar = (i) bVar;
            a(bVar.e(), iVar.b, iVar.c, iVar.d, iVar.g, iVar.h, elapsedRealtime, j);
            this.s = ((a) bVar).j;
        } else {
            a(bVar.e(), bVar.b, bVar.c, bVar.d, -1, -1, elapsedRealtime, j);
        }
        a();
        c();
    }

    public void onLoadError(Loadable loadable, IOException iOException) {
        this.t = iOException;
        this.u++;
        this.v = SystemClock.elapsedRealtime();
        a(iOException);
        this.c.onChunkLoadError(this.d.b, iOException);
        c();
    }

    public boolean prepare(long j) {
        boolean z = this.l == 1 || this.l == 2;
        b.b(z);
        if (this.l != 2) {
            this.r = new Loader("Loader:" + this.c.getTrackInfo().a);
            this.l = 2;
        }
        return true;
    }

    public int readData(int i, long j, l lVar, m mVar, boolean z) {
        b.b(this.l == 3);
        b.b(i == 0);
        this.m = j;
        if (this.q) {
            this.q = false;
            return -5;
        } else if (z) {
            return -2;
        } else {
            if (g()) {
                return -2;
            }
            Object obj = !this.g.g() ? 1 : null;
            i iVar = (a) this.e.getFirst();
            while (obj != null && this.e.size() > 1 && ((a) this.e.get(1)).a() == this.g.c()) {
                this.e.removeFirst();
                iVar = (a) this.e.getFirst();
            }
            if (this.y == null || !this.y.equals(iVar.d)) {
                a(iVar.d, iVar.c, iVar.g);
                this.y = iVar.d;
            }
            if (obj != null || iVar.a) {
                k b = iVar.b();
                if (!b.a(this.x, true)) {
                    this.c.getMaxVideoDimensions(b);
                    lVar.a = b;
                    lVar.b = iVar.c();
                    this.x = b;
                    return -4;
                }
            }
            if (obj == null) {
                return this.s ? -1 : -2;
            } else {
                if (!this.g.a(mVar)) {
                    return -2;
                }
                Object obj2 = mVar.e < this.n ? 1 : null;
                mVar.d = (obj2 != null ? 134217728 : 0) | mVar.d;
                a(iVar, mVar);
                return -3;
            }
        }
    }

    public SampleSourceReader register() {
        b.b(this.l == 0);
        this.l = 1;
        return this;
    }

    public void release() {
        b.b(this.l != 3);
        if (this.r != null) {
            this.r.c();
            this.r = null;
        }
        this.l = 0;
    }

    public void seekToUs(long j) {
        boolean z = false;
        b.b(this.l == 3);
        long j2 = g() ? this.o : this.m;
        this.m = j;
        this.n = j;
        if (j2 != j) {
            boolean z2 = !g() && this.g.b(j);
            if (z2) {
                if (!this.g.g()) {
                    z = true;
                }
                while (z && this.e.size() > 1 && ((a) this.e.get(1)).a() <= this.g.c()) {
                    this.e.removeFirst();
                }
            } else {
                b(j);
            }
            this.q = true;
        }
    }
}
