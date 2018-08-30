package com.google.android.exoplayer.extractor;

import com.google.android.exoplayer.extractor.ExtractorSampleSource.UnrecognizedInputFormatException;
import java.io.EOFException;

final class e {
    private final Extractor[] a;
    private final ExtractorOutput b;
    private Extractor c;

    public e(Extractor[] extractorArr, ExtractorOutput extractorOutput) {
        this.a = extractorArr;
        this.b = extractorOutput;
    }

    public Extractor a(ExtractorInput extractorInput) {
        if (this.c != null) {
            return this.c;
        }
        Extractor[] extractorArr = this.a;
        int length = extractorArr.length;
        int i = 0;
        while (i < length) {
            Extractor extractor = extractorArr[i];
            try {
                if (extractor.sniff(extractorInput)) {
                    this.c = extractor;
                    break;
                }
                extractorInput.resetPeekPosition();
                i++;
            } catch (EOFException e) {
            }
        }
        if (this.c == null) {
            throw new UnrecognizedInputFormatException(this.a);
        }
        this.c.init(this.b);
        return this.c;
    }
}
