package com.google.android.exoplayer.hls;

import android.util.SparseArray;
import com.google.android.exoplayer.chunk.f;
import com.google.android.exoplayer.drm.a;
import com.google.android.exoplayer.extractor.Extractor;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.extractor.c;
import com.google.android.exoplayer.k;
import com.google.android.exoplayer.m;
import com.google.android.exoplayer.upstream.Allocator;
import com.google.android.exoplayer.util.b;

public final class d implements ExtractorOutput {
    public final int a;
    public final f b;
    public final long c;
    private final Extractor d;
    private final SparseArray<c> e = new SparseArray();
    private final boolean f;
    private Allocator g;
    private volatile boolean h;
    private boolean i;
    private boolean j;

    public d(int i, f fVar, long j, Extractor extractor, boolean z) {
        this.a = i;
        this.b = fVar;
        this.c = j;
        this.d = extractor;
        this.f = z;
    }

    public int a(ExtractorInput extractorInput) {
        boolean z = true;
        int read = this.d.read(extractorInput, null);
        if (read == 1) {
            z = false;
        }
        b.b(z);
        return read;
    }

    public k a(int i) {
        b.b(a());
        return ((c) this.e.valueAt(i)).e();
    }

    public void a(int i, long j) {
        b.b(a());
        ((c) this.e.valueAt(i)).a(j);
    }

    public final void a(d dVar) {
        b.b(a());
        if (!this.j && dVar.f && dVar.a()) {
            int i = 0;
            boolean z = true;
            while (i < d()) {
                boolean a = z & ((c) this.e.valueAt(i)).a((c) dVar.e.valueAt(i));
                i++;
                z = a;
            }
            this.j = z;
        }
    }

    public void a(Allocator allocator) {
        this.g = allocator;
        this.d.init(this);
    }

    public boolean a() {
        if (!this.i && this.h) {
            for (int i = 0; i < this.e.size(); i++) {
                if (!((c) this.e.valueAt(i)).d()) {
                    return false;
                }
            }
            this.i = true;
        }
        return this.i;
    }

    public boolean a(int i, m mVar) {
        b.b(a());
        return ((c) this.e.valueAt(i)).a(mVar);
    }

    public void b() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.e.size()) {
                ((c) this.e.valueAt(i2)).a();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public boolean b(int i) {
        b.b(a());
        return !((c) this.e.valueAt(i)).g();
    }

    public long c() {
        long j = Long.MIN_VALUE;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.e.size()) {
                return j;
            }
            j = Math.max(j, ((c) this.e.valueAt(i2)).f());
            i = i2 + 1;
        }
    }

    public int d() {
        b.b(a());
        return this.e.size();
    }

    public void drmInitData(a aVar) {
    }

    public void endTracks() {
        this.h = true;
    }

    public void seekMap(SeekMap seekMap) {
    }

    public TrackOutput track(int i) {
        TrackOutput cVar = new c(this.g);
        this.e.put(i, cVar);
        return cVar;
    }
}
