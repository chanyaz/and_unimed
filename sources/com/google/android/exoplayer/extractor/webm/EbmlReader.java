package com.google.android.exoplayer.extractor.webm;

import com.google.android.exoplayer.extractor.ExtractorInput;

interface EbmlReader {
    void init(EbmlReaderOutput ebmlReaderOutput);

    boolean read(ExtractorInput extractorInput);

    void reset();
}
