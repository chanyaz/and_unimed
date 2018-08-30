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

public final class h extends b implements SingleTrackOutput {
    private final ChunkExtractorWrapper a;
    private k g;
    private a h;
    private SeekMap i;
    private volatile int j;
    private volatile boolean k;

    public h(DataSource dataSource, c cVar, int i, f fVar, ChunkExtractorWrapper chunkExtractorWrapper) {
        super(dataSource, cVar, 2, i, fVar);
        this.a = chunkExtractorWrapper;
    }

    public boolean a() {
        return this.g != null;
    }

    public k b() {
        return this.g;
    }

    public boolean c() {
        return this.h != null;
    }

    public void cancelLoad() {
        this.k = true;
    }

    public a d() {
        return this.h;
    }

    public void drmInitData(a aVar) {
        this.h = aVar;
    }

    public long e() {
        return (long) this.j;
    }

    public boolean f() {
        return this.i != null;
    }

    public void format(k kVar) {
        this.g = kVar;
    }

    public SeekMap g() {
        return this.i;
    }

    public boolean isLoadCanceled() {
        return this.k;
    }

    public void load() {
        c a = m.a(this.e, this.j);
        ExtractorInput bVar;
        try {
            bVar = new b(this.f, a.c, this.f.open(a));
            if (this.j == 0) {
                this.a.a((SingleTrackOutput) this);
            }
            int i = 0;
            while (i == 0) {
                if (!this.k) {
                    i = this.a.a(bVar);
                }
            }
            this.j = (int) (bVar.getPosition() - this.e.c);
            this.f.close();
        } catch (Throwable th) {
            this.f.close();
        }
    }

    public int sampleData(ExtractorInput extractorInput, int i, boolean z) {
        throw new IllegalStateException("Unexpected sample data in initialization chunk");
    }

    public void sampleData(i iVar, int i) {
        throw new IllegalStateException("Unexpected sample data in initialization chunk");
    }

    public void sampleMetadata(long j, int i, int i2, int i3, byte[] bArr) {
        throw new IllegalStateException("Unexpected sample data in initialization chunk");
    }

    public void seekMap(SeekMap seekMap) {
        this.i = seekMap;
    }
}
