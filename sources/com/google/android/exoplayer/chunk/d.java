package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.chunk.ChunkExtractorWrapper.SingleTrackOutput;
import com.google.android.exoplayer.drm.a;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.extractor.b;
import com.google.android.exoplayer.k;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.c;
import com.google.android.exoplayer.util.i;
import com.google.android.exoplayer.util.m;

public class d extends a implements SingleTrackOutput {
    private final ChunkExtractorWrapper k;
    private final long l;
    private k m;
    private a n;
    private volatile int o;
    private volatile boolean p;

    public d(DataSource dataSource, c cVar, int i, f fVar, long j, long j2, int i2, boolean z, long j3, ChunkExtractorWrapper chunkExtractorWrapper, k kVar, a aVar, boolean z2) {
        super(dataSource, cVar, i, fVar, j, j2, i2, z, z2);
        this.k = chunkExtractorWrapper;
        this.l = j3;
        this.m = kVar;
        this.n = aVar;
    }

    public final k b() {
        return this.m;
    }

    public final a c() {
        return this.n;
    }

    public final void cancelLoad() {
        this.p = true;
    }

    public final void drmInitData(a aVar) {
        this.n = aVar;
    }

    public final long e() {
        return (long) this.o;
    }

    public final void format(k kVar) {
        this.m = kVar;
    }

    public final boolean isLoadCanceled() {
        return this.p;
    }

    public final void load() {
        c a = m.a(this.e, this.o);
        ExtractorInput bVar;
        try {
            bVar = new b(this.f, a.c, this.f.open(a));
            if (this.o == 0) {
                this.k.a((SingleTrackOutput) this);
            }
            int i = 0;
            while (i == 0) {
                if (!this.p) {
                    i = this.k.a(bVar);
                }
            }
            this.o = (int) (bVar.getPosition() - this.e.c);
            this.f.close();
        } catch (Throwable th) {
            this.f.close();
        }
    }

    public final int sampleData(ExtractorInput extractorInput, int i, boolean z) {
        return d().sampleData(extractorInput, i, z);
    }

    public final void sampleData(i iVar, int i) {
        d().sampleData(iVar, i);
    }

    public final void sampleMetadata(long j, int i, int i2, int i3, byte[] bArr) {
        d().sampleMetadata(this.l + j, i, i2, i3, bArr);
    }

    public final void seekMap(SeekMap seekMap) {
    }
}
