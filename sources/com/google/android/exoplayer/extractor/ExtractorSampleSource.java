package com.google.android.exoplayer.extractor;

import android.net.Uri;
import android.os.SystemClock;
import android.util.SparseArray;
import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.SampleSource;
import com.google.android.exoplayer.SampleSource.SampleSourceReader;
import com.google.android.exoplayer.drm.a;
import com.google.android.exoplayer.k;
import com.google.android.exoplayer.l;
import com.google.android.exoplayer.p;
import com.google.android.exoplayer.upstream.Allocator;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.Loader;
import com.google.android.exoplayer.upstream.Loader.Callback;
import com.google.android.exoplayer.upstream.Loader.Loadable;
import com.google.android.exoplayer.util.b;
import com.google.android.exoplayer.util.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class ExtractorSampleSource implements SampleSource, SampleSourceReader, ExtractorOutput, Callback {
    private static final List<Class<? extends Extractor>> a = new ArrayList();
    private d A;
    private IOException B;
    private int C;
    private long D;
    private boolean E;
    private int F;
    private int G;
    private final e b;
    private final Allocator c;
    private final int d;
    private final SparseArray<f> e;
    private final int f;
    private final Uri g;
    private final DataSource h;
    private volatile boolean i;
    private volatile SeekMap j;
    private volatile a k;
    private boolean l;
    private int m;
    private p[] n;
    private long o;
    private boolean[] p;
    private boolean[] q;
    private boolean[] r;
    private int s;
    private long t;
    private long u;
    private long v;
    private boolean w;
    private long x;
    private long y;
    private Loader z;

    public final class UnrecognizedInputFormatException extends ParserException {
        public UnrecognizedInputFormatException(Extractor[] extractorArr) {
            super("None of the available extractors (" + m.a((Object[]) extractorArr) + ") could read the stream.");
        }
    }

    static {
        try {
            a.add(Class.forName("com.google.android.exoplayer.extractor.webm.e").asSubclass(Extractor.class));
        } catch (ClassNotFoundException e) {
        }
        try {
            a.add(Class.forName("com.google.android.exoplayer.extractor.a.g").asSubclass(Extractor.class));
        } catch (ClassNotFoundException e2) {
        }
        try {
            a.add(Class.forName("com.google.android.exoplayer.extractor.a.h").asSubclass(Extractor.class));
        } catch (ClassNotFoundException e3) {
        }
        try {
            a.add(Class.forName("com.google.android.exoplayer.extractor.mp3.Mp3Extractor").asSubclass(Extractor.class));
        } catch (ClassNotFoundException e4) {
        }
        try {
            a.add(Class.forName("com.google.android.exoplayer.extractor.b.b").asSubclass(Extractor.class));
        } catch (ClassNotFoundException e5) {
        }
        try {
            a.add(Class.forName("com.google.android.exoplayer.extractor.b.l").asSubclass(Extractor.class));
        } catch (ClassNotFoundException e6) {
        }
    }

    public ExtractorSampleSource(Uri uri, DataSource dataSource, Allocator allocator, int i, int i2, Extractor... extractorArr) {
        this.g = uri;
        this.h = dataSource;
        this.c = allocator;
        this.d = i;
        this.f = i2;
        if (extractorArr == null || extractorArr.length == 0) {
            extractorArr = new Extractor[a.size()];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= extractorArr.length) {
                    break;
                }
                try {
                    extractorArr[i4] = (Extractor) ((Class) a.get(i4)).newInstance();
                    i3 = i4 + 1;
                } catch (Throwable e) {
                    throw new IllegalStateException("Unexpected error creating default extractor", e);
                } catch (Throwable e2) {
                    throw new IllegalStateException("Unexpected error creating default extractor", e2);
                }
            }
        }
        this.b = new e(extractorArr, this);
        this.e = new SparseArray();
        this.v = -1;
    }

    public ExtractorSampleSource(Uri uri, DataSource dataSource, Allocator allocator, int i, Extractor... extractorArr) {
        this(uri, dataSource, allocator, i, -1, extractorArr);
    }

    private void a() {
        int i = 0;
        if (!this.E && !this.z.a()) {
            if (this.B == null) {
                this.y = 0;
                this.w = false;
                if (this.l) {
                    b.b(e());
                    if (this.o == -1 || this.v < this.o) {
                        this.A = b(this.v);
                        this.v = -1;
                    } else {
                        this.E = true;
                        this.v = -1;
                        return;
                    }
                }
                this.A = b();
                this.G = this.F;
                this.z.a(this.A, (Callback) this);
            } else if (!f()) {
                b.b(this.A != null);
                if (SystemClock.elapsedRealtime() - this.D >= d((long) this.C)) {
                    this.B = null;
                    if (!this.l) {
                        while (i < this.e.size()) {
                            ((f) this.e.valueAt(i)).a();
                            i++;
                        }
                        this.A = b();
                    } else if (!this.j.isSeekable()) {
                        while (i < this.e.size()) {
                            ((f) this.e.valueAt(i)).a();
                            i++;
                        }
                        this.A = b();
                        this.x = this.t;
                        this.w = true;
                    }
                    this.G = this.F;
                    this.z.a(this.A, (Callback) this);
                }
            }
        }
    }

    private void a(long j) {
        this.v = j;
        this.E = false;
        if (this.z.a()) {
            this.z.b();
            return;
        }
        d();
        a();
    }

    private d b() {
        return new d(this.g, this.h, this.b, this.c, this.d, 0);
    }

    private d b(long j) {
        return new d(this.g, this.h, this.b, this.c, this.d, this.j.getPosition(j));
    }

    private void c(long j) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.r.length) {
                if (!this.r[i2]) {
                    ((f) this.e.valueAt(i2)).a(j);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private boolean c() {
        for (int i = 0; i < this.e.size(); i++) {
            if (!((f) this.e.valueAt(i)).d()) {
                return false;
            }
        }
        return true;
    }

    private long d(long j) {
        return Math.min((j - 1) * 1000, 5000);
    }

    private void d() {
        for (int i = 0; i < this.e.size(); i++) {
            ((f) this.e.valueAt(i)).a();
        }
        this.A = null;
        this.B = null;
        this.C = 0;
    }

    private boolean e() {
        return this.v != -1;
    }

    private boolean f() {
        return this.B instanceof UnrecognizedInputFormatException;
    }

    public boolean continueBuffering(int i, long j) {
        b.b(this.l);
        b.b(this.r[i]);
        this.t = j;
        c(this.t);
        if (this.E) {
            return true;
        }
        a();
        if (e()) {
            return false;
        }
        return !((f) this.e.valueAt(i)).g();
    }

    public void disable(int i) {
        b.b(this.l);
        b.b(this.r[i]);
        this.m--;
        this.r[i] = false;
        if (this.m == 0) {
            this.t = Long.MIN_VALUE;
            if (this.z.a()) {
                this.z.b();
                return;
            }
            d();
            this.c.trim(0);
        }
    }

    public void drmInitData(a aVar) {
        this.k = aVar;
    }

    public void enable(int i, long j) {
        b.b(this.l);
        b.b(!this.r[i]);
        this.m++;
        this.r[i] = true;
        this.p[i] = true;
        if (this.m == 1) {
            seekToUs(j);
        }
        this.q[i] = false;
    }

    public void endTracks() {
        this.i = true;
    }

    public long getBufferedPositionUs() {
        if (this.E) {
            return -3;
        }
        if (e()) {
            return this.v;
        }
        long j = Long.MIN_VALUE;
        for (int i = 0; i < this.e.size(); i++) {
            j = Math.max(j, ((f) this.e.valueAt(i)).f());
        }
        return j == Long.MIN_VALUE ? this.t : j;
    }

    public int getTrackCount() {
        return this.e.size();
    }

    public p getTrackInfo(int i) {
        b.b(this.l);
        return this.n[i];
    }

    public void maybeThrowError() {
        if (this.B != null) {
            if (f()) {
                throw this.B;
            }
            int i = this.f != -1 ? this.f : (this.j == null || this.j.isSeekable()) ? 3 : 6;
            if (this.C > i) {
                throw this.B;
            }
        }
    }

    public void onLoadCanceled(Loadable loadable) {
        if (this.m > 0) {
            a(this.v);
            return;
        }
        d();
        this.c.trim(0);
    }

    public void onLoadCompleted(Loadable loadable) {
        this.E = true;
    }

    public void onLoadError(Loadable loadable, IOException iOException) {
        this.B = iOException;
        this.C = this.F > this.G ? 1 : this.C + 1;
        this.D = SystemClock.elapsedRealtime();
        a();
    }

    public boolean prepare(long j) {
        if (this.l) {
            return true;
        }
        if (this.z == null) {
            this.z = new Loader("Loader:ExtractorSampleSource");
        }
        a();
        if (this.j == null || !this.i || !c()) {
            return false;
        }
        int size = this.e.size();
        this.r = new boolean[size];
        this.q = new boolean[size];
        this.p = new boolean[size];
        this.n = new p[size];
        this.o = -1;
        for (int i = 0; i < size; i++) {
            k e = ((f) this.e.valueAt(i)).e();
            this.n[i] = new p(e.a, e.c);
            if (e.c != -1 && e.c > this.o) {
                this.o = e.c;
            }
        }
        this.l = true;
        return true;
    }

    public int readData(int i, long j, l lVar, com.google.android.exoplayer.m mVar, boolean z) {
        this.t = j;
        if (this.q[i]) {
            this.q[i] = false;
            return -5;
        } else if (z || e()) {
            return -2;
        } else {
            f fVar = (f) this.e.valueAt(i);
            if (this.p[i]) {
                lVar.a = fVar.e();
                lVar.b = this.k;
                this.p[i] = false;
                return -4;
            } else if (!fVar.a(mVar)) {
                return this.E ? -1 : -2;
            } else {
                mVar.d = ((mVar.e > this.u ? 1 : (mVar.e == this.u ? 0 : -1)) < 0 ? 134217728 : 0) | mVar.d;
                if (this.w) {
                    this.y = this.x - mVar.e;
                    this.w = false;
                }
                mVar.e += this.y;
                return -3;
            }
        }
    }

    public SampleSourceReader register() {
        this.s++;
        return this;
    }

    public void release() {
        b.b(this.s > 0);
        int i = this.s - 1;
        this.s = i;
        if (i == 0 && this.z != null) {
            this.z.c();
            this.z = null;
        }
    }

    public void seekMap(SeekMap seekMap) {
        this.j = seekMap;
    }

    public void seekToUs(long j) {
        int i = 0;
        b.b(this.l);
        b.b(this.m > 0);
        if (!this.j.isSeekable()) {
            j = 0;
        }
        long j2 = e() ? this.v : this.t;
        this.t = j;
        this.u = j;
        if (j2 != j) {
            int i2 = 0;
            int i3 = !e();
            while (i3 != 0 && i2 < this.e.size()) {
                i3 &= ((f) this.e.valueAt(i2)).b(j);
                i2++;
            }
            if (i3 == 0) {
                a(j);
            }
            while (i < this.q.length) {
                this.q[i] = true;
                i++;
            }
        }
    }

    public TrackOutput track(int i) {
        f fVar = (f) this.e.get(i);
        if (fVar != null) {
            return fVar;
        }
        TrackOutput fVar2 = new f(this, this.c);
        this.e.put(i, fVar2);
        return fVar2;
    }
}
