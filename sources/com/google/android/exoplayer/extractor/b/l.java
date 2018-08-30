package com.google.android.exoplayer.extractor.b;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer.audio.a;
import com.google.android.exoplayer.extractor.Extractor;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.extractor.g;
import com.google.android.exoplayer.util.h;
import com.google.android.exoplayer.util.i;

public final class l implements Extractor {
    final SparseBooleanArray a;
    final SparseBooleanArray b;
    final SparseArray<p> c;
    h d;
    private final i e;
    private final h f;
    private final boolean g;
    private final long h;
    private ExtractorOutput i;
    private long j;
    private long k;

    public l() {
        this(0);
    }

    public l(long j) {
        this(j, null);
    }

    public l(long j, a aVar) {
        this(j, aVar, true);
    }

    public l(long j, a aVar, boolean z) {
        this.h = j;
        this.g = z;
        this.f = new h(new byte[3]);
        this.e = new i(188);
        this.a = new SparseBooleanArray();
        this.b = a(aVar);
        this.c = new SparseArray();
        this.c.put(0, new m(this));
        this.k = Long.MIN_VALUE;
    }

    private static SparseBooleanArray a(a aVar) {
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        if (aVar != null) {
            if (aVar.a(5)) {
                sparseBooleanArray.put(129, true);
            }
            if (aVar.a(6)) {
            }
        }
        return sparseBooleanArray;
    }

    long a(long j) {
        long j2;
        long j3;
        if (this.k != Long.MIN_VALUE) {
            j2 = (this.k + 4294967295L) / 8589934591L;
            j3 = ((j2 - 1) * 8589934591L) + j;
            j2 = (j2 * 8589934591L) + j;
            if (Math.abs(j3 - this.k) >= Math.abs(j2 - this.k)) {
                j3 = j2;
            }
        } else {
            j3 = j;
        }
        j2 = (1000000 * j3) / 90000;
        if (this.k == Long.MIN_VALUE) {
            this.j = this.h - j2;
        }
        this.k = j3;
        return this.j + j2;
    }

    public void init(ExtractorOutput extractorOutput) {
        this.i = extractorOutput;
        extractorOutput.seekMap(SeekMap.f);
    }

    public int read(ExtractorInput extractorInput, g gVar) {
        if (!extractorInput.readFully(this.e.a, 0, 188, true)) {
            return -1;
        }
        this.e.b(0);
        this.e.a(188);
        if (this.e.f() != 71) {
            return 0;
        }
        this.e.a(this.f, 3);
        this.f.b(1);
        boolean b = this.f.b();
        this.f.b(1);
        int c = this.f.c(13);
        this.f.b(2);
        boolean b2 = this.f.b();
        boolean b3 = this.f.b();
        if (b2) {
            this.e.c(this.e.f());
        }
        if (b3) {
            p pVar = (p) this.c.get(c);
            if (pVar != null) {
                pVar.a(this.e, b, this.i);
            }
        }
        return 0;
    }

    public void seek() {
        this.j = 0;
        this.k = Long.MIN_VALUE;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.c.size()) {
                ((p) this.c.valueAt(i2)).a();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public boolean sniff(ExtractorInput extractorInput) {
        byte[] bArr = new byte[1];
        for (int i = 0; i < 5; i++) {
            extractorInput.peekFully(bArr, 0, 1);
            if ((bArr[0] & 255) != 71) {
                return false;
            }
            extractorInput.advancePeekPosition(187);
        }
        return true;
    }
}
