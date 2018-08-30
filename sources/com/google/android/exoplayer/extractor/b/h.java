package com.google.android.exoplayer.extractor.b;

import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.k;
import com.google.android.exoplayer.util.i;

final class h extends d {
    private boolean b;
    private long c;
    private int d;

    public h(TrackOutput trackOutput) {
        super(trackOutput);
        trackOutput.format(k.a("application/id3"));
    }

    public void a() {
        this.b = false;
    }

    public void a(i iVar, long j, boolean z) {
        if (z) {
            this.b = true;
            this.c = j;
            this.d = 0;
        }
        if (this.b) {
            this.d += iVar.b();
            this.a.sampleData(iVar, iVar.b());
        }
    }

    public void b() {
        this.a.sampleMetadata(this.c, 1, this.d, 0, null);
        this.b = false;
    }
}
