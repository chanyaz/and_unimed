package com.google.android.exoplayer.dash;

import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer.BehindLiveWindowException;
import com.google.android.exoplayer.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer.chunk.ChunkSource;
import com.google.android.exoplayer.chunk.FormatEvaluator;
import com.google.android.exoplayer.chunk.f;
import com.google.android.exoplayer.chunk.g;
import com.google.android.exoplayer.chunk.h;
import com.google.android.exoplayer.chunk.i;
import com.google.android.exoplayer.chunk.j;
import com.google.android.exoplayer.dash.mpd.b;
import com.google.android.exoplayer.dash.mpd.d;
import com.google.android.exoplayer.dash.mpd.e;
import com.google.android.exoplayer.drm.a;
import com.google.android.exoplayer.k;
import com.google.android.exoplayer.o;
import com.google.android.exoplayer.p;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.c;
import com.google.android.exoplayer.util.Clock;
import com.google.android.exoplayer.util.ManifestFetcher;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class DashChunkSource implements ChunkSource {
    private IOException A;
    private final Handler a;
    private final EventListener b;
    private final p c;
    private final DataSource d;
    private final FormatEvaluator e;
    private final g f;
    private final Clock g;
    private final StringBuilder h;
    private final long i;
    private final long j;
    private final int k;
    private final int l;
    private final f[] m;
    private final HashMap<String, a> n;
    private final ManifestFetcher<b> o;
    private final int p;
    private final int[] q;
    private b r;
    private boolean s;
    private a t;
    private o u;
    private long[] v;
    private int w;
    private int x;
    private boolean y;
    private boolean z;

    public interface EventListener {
        void onSeekRangeChanged(o oVar);
    }

    public class NoAdaptationSetException extends IOException {
    }

    private long a() {
        return this.j != 0 ? (this.g.elapsedRealtime() * 1000) + this.j : System.currentTimeMillis() * 1000;
    }

    private com.google.android.exoplayer.chunk.b a(a aVar, DataSource dataSource, int i, int i2) {
        e eVar = aVar.a;
        DashSegmentIndex dashSegmentIndex = aVar.c;
        long timeUs = dashSegmentIndex.getTimeUs(i);
        long durationUs = timeUs + dashSegmentIndex.getDurationUs(i);
        int i3 = i + aVar.e;
        boolean z = !this.r.c && i == dashSegmentIndex.getLastSegmentNum();
        d segmentUrl = dashSegmentIndex.getSegmentUrl(i);
        c cVar = new c(segmentUrl.a(), segmentUrl.a, segmentUrl.b, eVar.d());
        long j = (eVar.d * 1000) - eVar.e;
        if (eVar.c.b.equals("text/vtt")) {
            if (aVar.f != j) {
                this.h.setLength(0);
                this.h.append("EXO-HEADER").append("=").append("OFFSET:").append(j).append("\n");
                aVar.g = this.h.toString().getBytes();
                aVar.f = j;
            }
            return new j(dataSource, cVar, 1, eVar.c, timeUs, durationUs, i3, z, k.a("text/vtt"), null, aVar.g);
        }
        return new com.google.android.exoplayer.chunk.d(dataSource, cVar, i2, eVar.c, timeUs, durationUs, i3, z, j, aVar.b, aVar.d, this.t, true);
    }

    private com.google.android.exoplayer.chunk.b a(d dVar, d dVar2, e eVar, ChunkExtractorWrapper chunkExtractorWrapper, DataSource dataSource, int i) {
        if (dVar != null) {
            dVar2 = dVar.a(dVar2);
            if (dVar2 != null) {
                dVar = dVar2;
            }
        } else {
            dVar = dVar2;
        }
        return new h(dataSource, new c(dVar.a(), dVar.a, dVar.b, eVar.d()), i, eVar.c, chunkExtractorWrapper);
    }

    private void a(DashSegmentIndex dashSegmentIndex, long j) {
        int firstSegmentNum = dashSegmentIndex.getFirstSegmentNum();
        int lastSegmentNum = dashSegmentIndex.getLastSegmentNum();
        if (lastSegmentNum == -1) {
            long j2 = j - (this.r.a * 1000);
            if (this.r.e != -1) {
                firstSegmentNum = Math.max(firstSegmentNum, dashSegmentIndex.getSegmentNum(j2 - (this.r.e * 1000)));
            }
            lastSegmentNum = firstSegmentNum;
            firstSegmentNum = dashSegmentIndex.getSegmentNum(j2) - 1;
        } else {
            int i = lastSegmentNum;
            lastSegmentNum = firstSegmentNum;
            firstSegmentNum = i;
        }
        this.w = lastSegmentNum;
        this.x = firstSegmentNum;
    }

    private void a(final o oVar) {
        if (this.a != null && this.b != null) {
            this.a.post(new Runnable() {
                public void run() {
                    DashChunkSource.this.b.onSeekRangeChanged(oVar);
                }
            });
        }
    }

    private static e[] a(b bVar, int i, int[] iArr) {
        int i2 = 0;
        List list = ((com.google.android.exoplayer.dash.mpd.a) ((com.google.android.exoplayer.dash.mpd.c) bVar.g.get(0)).a.get(i)).a;
        if (iArr == null) {
            e[] eVarArr = new e[list.size()];
            list.toArray(eVarArr);
            return eVarArr;
        }
        e[] eVarArr2 = new e[iArr.length];
        while (i2 < iArr.length) {
            eVarArr2[i2] = (e) list.get(iArr[i2]);
            i2++;
        }
        return eVarArr2;
    }

    private void b(DashSegmentIndex dashSegmentIndex, long j) {
        long timeUs = dashSegmentIndex.getTimeUs(this.w);
        long durationUs = dashSegmentIndex.getDurationUs(this.x) + dashSegmentIndex.getTimeUs(this.x);
        if (this.r.c) {
            long j2;
            if (dashSegmentIndex.getLastSegmentNum() == -1) {
                j2 = j - (this.r.a * 1000);
            } else {
                j2 = dashSegmentIndex.getTimeUs(dashSegmentIndex.getLastSegmentNum()) + dashSegmentIndex.getDurationUs(dashSegmentIndex.getLastSegmentNum());
                if (!dashSegmentIndex.isExplicit()) {
                    j2 = Math.min(j2, j - (this.r.a * 1000));
                }
            }
            durationUs = Math.max(timeUs, j2 - this.i);
        }
        o oVar = new o(0, timeUs, durationUs);
        if (this.u == null || !this.u.equals(oVar)) {
            this.u = oVar;
            a(this.u);
        }
    }

    public void continueBuffering(long j) {
        if (this.o != null && this.r.c && this.A == null) {
            long a;
            b bVar = (b) this.o.a();
            if (!(this.r == bVar || bVar == null)) {
                e[] a2 = a(bVar, this.p, this.q);
                for (e eVar : a2) {
                    a aVar = (a) this.n.get(eVar.c.a);
                    DashSegmentIndex dashSegmentIndex = aVar.c;
                    int lastSegmentNum = dashSegmentIndex.getLastSegmentNum();
                    long timeUs = dashSegmentIndex.getTimeUs(lastSegmentNum) + dashSegmentIndex.getDurationUs(lastSegmentNum);
                    DashSegmentIndex c = eVar.c();
                    int firstSegmentNum = c.getFirstSegmentNum();
                    long timeUs2 = c.getTimeUs(firstSegmentNum);
                    if (timeUs < timeUs2) {
                        this.A = new BehindLiveWindowException();
                        return;
                    }
                    aVar.e = ((timeUs == timeUs2 ? dashSegmentIndex.getLastSegmentNum() + 1 : dashSegmentIndex.getSegmentNum(timeUs2)) - firstSegmentNum) + aVar.e;
                    aVar.c = c;
                }
                this.r = bVar;
                this.s = false;
                a = a();
                a(a2[0].c(), a);
                b(a2[0].c(), a);
            }
            a = this.r.d;
            if (a == 0) {
                a = 5000;
            }
            if (this.s && SystemClock.elapsedRealtime() > r0 + this.o.b()) {
                this.o.f();
            }
        }
    }

    public void disable(List<? extends i> list) {
        this.e.disable();
        if (this.o != null) {
            this.o.e();
        }
        this.u = null;
    }

    public void enable() {
        this.A = null;
        this.e.enable();
        if (this.o != null) {
            this.o.d();
        }
        DashSegmentIndex c = ((a) this.n.get(this.m[0].a)).a.c();
        if (c == null) {
            this.u = new o(0, 0, this.r.b * 1000);
            a(this.u);
            return;
        }
        long a = a();
        a(c, a);
        b(c, a);
    }

    public final void getChunkOperation(List<? extends i> list, long j, long j2, com.google.android.exoplayer.chunk.c cVar) {
        if (this.A != null) {
            cVar.b = null;
            return;
        }
        this.f.a = list.size();
        if (this.f.c == null || !this.z) {
            this.e.evaluate(list, j2, this.m, this.f);
        }
        f fVar = this.f.c;
        cVar.a = this.f.a;
        if (fVar == null) {
            cVar.b = null;
        } else if (cVar.a != list.size() || cVar.b == null || !cVar.b.d.equals(fVar)) {
            cVar.b = null;
            a aVar = (a) this.n.get(fVar.a);
            e eVar = aVar.a;
            DashSegmentIndex dashSegmentIndex = aVar.c;
            ChunkExtractorWrapper chunkExtractorWrapper = aVar.b;
            d dVar = null;
            d dVar2 = null;
            if (aVar.d == null) {
                dVar = eVar.a();
            }
            if (dashSegmentIndex == null) {
                dVar2 = eVar.b();
            }
            com.google.android.exoplayer.chunk.b a;
            if (dVar == null && dVar2 == null) {
                int i;
                Object obj = dashSegmentIndex.getLastSegmentNum() == -1 ? 1 : null;
                if (obj != null) {
                    long a2 = a();
                    i = this.w;
                    int i2 = this.x;
                    a(dashSegmentIndex, a2);
                    if (!(i == this.w && i2 == this.x)) {
                        b(dashSegmentIndex, a2);
                    }
                }
                if (list.isEmpty()) {
                    if (this.r.c) {
                        this.v = this.u.a(this.v);
                        if (this.y) {
                            this.y = false;
                            j = this.v[1];
                        } else {
                            j = Math.min(Math.max(j, this.v[0]), this.v[1]);
                        }
                    }
                    i = dashSegmentIndex.getSegmentNum(j);
                    if (obj != null) {
                        i = Math.min(i, this.x);
                    }
                } else {
                    i iVar = (i) list.get(cVar.a - 1);
                    i = iVar.j ? -1 : (iVar.i + 1) - aVar.e;
                }
                if (this.r.c) {
                    if (i < this.w) {
                        this.A = new BehindLiveWindowException();
                        return;
                    } else if (i > this.x) {
                        this.s = obj == null;
                        return;
                    } else if (obj == null && i == this.x) {
                        this.s = true;
                    }
                }
                if (i != -1) {
                    a = a(aVar, this.d, i, this.f.b);
                    this.z = false;
                    cVar.b = a;
                    return;
                }
                return;
            }
            a = a(dVar, dVar2, eVar, chunkExtractorWrapper, this.d, this.f.b);
            this.z = true;
            cVar.b = a;
        }
    }

    public final void getMaxVideoDimensions(k kVar) {
        if (this.c.a.startsWith("video")) {
            kVar.a(this.k, this.l);
        }
    }

    public final p getTrackInfo() {
        return this.c;
    }

    public void maybeThrowError() {
        if (this.A != null) {
            throw this.A;
        } else if (this.o != null) {
            this.o.c();
        }
    }

    public void onChunkLoadCompleted(com.google.android.exoplayer.chunk.b bVar) {
        if (bVar instanceof h) {
            h hVar = (h) bVar;
            a aVar = (a) this.n.get(hVar.d.a);
            if (hVar.a()) {
                aVar.d = hVar.b();
            }
            if (hVar.f()) {
                aVar.c = new b((com.google.android.exoplayer.extractor.a) hVar.g(), hVar.e.a.toString(), aVar.a.d * 1000);
            }
            if (this.t == null && hVar.c()) {
                this.t = hVar.d();
            }
        }
    }

    public void onChunkLoadError(com.google.android.exoplayer.chunk.b bVar, Exception exception) {
    }
}
