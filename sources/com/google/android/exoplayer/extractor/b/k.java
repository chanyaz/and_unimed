package com.google.android.exoplayer.extractor.b;

import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.text.a.a;
import com.google.android.exoplayer.util.i;

final class k extends d {
    public k(TrackOutput trackOutput) {
        super(trackOutput);
        trackOutput.format(com.google.android.exoplayer.k.a("application/eia-608"));
    }

    public void a() {
    }

    public void a(i iVar, long j, boolean z) {
        while (iVar.b() > 1) {
            int f;
            int i = 0;
            do {
                f = iVar.f();
                i += f;
            } while (f == 255);
            int i2 = 0;
            do {
                f = iVar.f();
                i2 += f;
            } while (f == 255);
            if (a.a(i, i2, iVar)) {
                this.a.sampleData(iVar, i2);
                this.a.sampleMetadata(j, 1, i2, 0, null);
            } else {
                iVar.c(i2);
            }
        }
    }

    public void b() {
    }
}
