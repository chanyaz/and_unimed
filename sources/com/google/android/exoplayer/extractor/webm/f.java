package com.google.android.exoplayer.extractor.webm;

import com.google.android.exoplayer.extractor.ExtractorInput;

final class f implements EbmlReaderOutput {
    final /* synthetic */ e a;

    private f(e eVar) {
        this.a = eVar;
    }

    public void binaryElement(int i, int i2, ExtractorInput extractorInput) {
        this.a.a(i, i2, extractorInput);
    }

    public void endMasterElement(int i) {
        this.a.b(i);
    }

    public void floatElement(int i, double d) {
        this.a.a(i, d);
    }

    public int getElementType(int i) {
        return this.a.a(i);
    }

    public void integerElement(int i, long j) {
        this.a.a(i, j);
    }

    public void startMasterElement(int i, long j, long j2) {
        this.a.a(i, j, j2);
    }

    public void stringElement(int i, String str) {
        this.a.a(i, str);
    }
}
