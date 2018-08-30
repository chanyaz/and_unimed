package com.google.android.exoplayer.extractor.b;

import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.util.h;
import com.google.android.exoplayer.util.i;

class m extends p {
    final /* synthetic */ l a;
    private final h b = new h(new byte[4]);

    public m(l lVar) {
        this.a = lVar;
        super();
    }

    public void a() {
    }

    public void a(i iVar, boolean z, ExtractorOutput extractorOutput) {
        if (z) {
            iVar.c(iVar.f());
        }
        iVar.a(this.b, 3);
        this.b.b(12);
        int c = this.b.c(12);
        iVar.c(5);
        int i = (c - 9) / 4;
        for (c = 0; c < i; c++) {
            iVar.a(this.b, 4);
            this.b.b(19);
            this.a.c.put(this.b.c(13), new o(this.a));
        }
    }
}
