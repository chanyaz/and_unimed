package com.google.android.exoplayer.extractor.b;

import com.google.android.exoplayer.extractor.Extractor;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.extractor.g;
import com.google.android.exoplayer.util.i;
import com.google.android.exoplayer.util.m;

public final class b implements Extractor {
    private final long a;
    private final i b;
    private c c;
    private boolean d;

    public b() {
        this(0);
    }

    public b(long j) {
        this.a = j;
        this.b = new i(200);
        this.d = true;
    }

    public void init(ExtractorOutput extractorOutput) {
        this.c = new c(extractorOutput.track(0));
        extractorOutput.endTracks();
        extractorOutput.seekMap(SeekMap.f);
    }

    public int read(ExtractorInput extractorInput, g gVar) {
        int read = extractorInput.read(this.b.a, 0, 200);
        if (read == -1) {
            return -1;
        }
        this.b.b(0);
        this.b.a(read);
        this.c.a(this.b, this.a, this.d);
        this.d = false;
        return 0;
    }

    public void seek() {
        this.d = true;
        this.c.a();
    }

    public boolean sniff(ExtractorInput extractorInput) {
        int i;
        i iVar = new i(10);
        extractorInput.peekFully(iVar.a, 0, 10);
        int h = iVar.h();
        if (h != m.c("ID3")) {
            i = h >> 8;
        } else {
            extractorInput.advancePeekPosition(((((iVar.a[6] & 127) << 21) | ((iVar.a[7] & 127) << 14)) | ((iVar.a[8] & 127) << 7)) | (iVar.a[9] & 127));
            extractorInput.peekFully(iVar.a, 0, 2);
            iVar.b(0);
            i = iVar.g();
        }
        return (i & 65526) == 65520;
    }
}
