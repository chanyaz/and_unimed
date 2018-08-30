package com.google.android.exoplayer.extractor;

public interface Extractor {
    void init(ExtractorOutput extractorOutput);

    int read(ExtractorInput extractorInput, g gVar);

    void seek();

    boolean sniff(ExtractorInput extractorInput);
}
