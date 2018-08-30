package com.google.android.exoplayer.extractor;

import com.google.android.exoplayer.upstream.Allocator;

class f extends c {
    final /* synthetic */ ExtractorSampleSource a;

    public f(ExtractorSampleSource extractorSampleSource, Allocator allocator) {
        this.a = extractorSampleSource;
        super(allocator);
    }

    public void sampleMetadata(long j, int i, int i2, int i3, byte[] bArr) {
        super.sampleMetadata(j, i, i2, i3, bArr);
        this.a.F = this.a.F + 1;
    }
}
