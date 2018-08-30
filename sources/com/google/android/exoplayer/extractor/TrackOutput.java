package com.google.android.exoplayer.extractor;

import com.google.android.exoplayer.k;
import com.google.android.exoplayer.util.i;

public interface TrackOutput {
    void format(k kVar);

    int sampleData(ExtractorInput extractorInput, int i, boolean z);

    void sampleData(i iVar, int i);

    void sampleMetadata(long j, int i, int i2, int i3, byte[] bArr);
}
