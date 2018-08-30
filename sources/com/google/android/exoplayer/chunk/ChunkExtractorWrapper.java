package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.drm.a;
import com.google.android.exoplayer.extractor.Extractor;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.k;
import com.google.android.exoplayer.util.b;
import com.google.android.exoplayer.util.i;

public final class ChunkExtractorWrapper implements ExtractorOutput, TrackOutput {
    private final Extractor a;
    private boolean b;
    private SingleTrackOutput c;
    private boolean d;

    public interface SingleTrackOutput extends TrackOutput {
        void drmInitData(a aVar);

        void seekMap(SeekMap seekMap);
    }

    public int a(ExtractorInput extractorInput) {
        boolean z = true;
        int read = this.a.read(extractorInput, null);
        if (read == 1) {
            z = false;
        }
        b.b(z);
        return read;
    }

    public void a(SingleTrackOutput singleTrackOutput) {
        this.c = singleTrackOutput;
        if (this.b) {
            this.a.seek();
            return;
        }
        this.a.init(this);
        this.b = true;
    }

    public void drmInitData(a aVar) {
        this.c.drmInitData(aVar);
    }

    public void endTracks() {
        b.b(this.d);
    }

    public void format(k kVar) {
        this.c.format(kVar);
    }

    public int sampleData(ExtractorInput extractorInput, int i, boolean z) {
        return this.c.sampleData(extractorInput, i, z);
    }

    public void sampleData(i iVar, int i) {
        this.c.sampleData(iVar, i);
    }

    public void sampleMetadata(long j, int i, int i2, int i3, byte[] bArr) {
        this.c.sampleMetadata(j, i, i2, i3, bArr);
    }

    public void seekMap(SeekMap seekMap) {
        this.c.seekMap(seekMap);
    }

    public TrackOutput track(int i) {
        b.b(!this.d);
        this.d = true;
        return this;
    }
}
