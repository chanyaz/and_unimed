package com.google.android.exoplayer.extractor.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class b extends a {
    public final long ah;
    public final List<c> ai = new ArrayList();
    public final List<b> aj = new ArrayList();

    public b(int i, long j) {
        super(i);
        this.ah = j;
    }

    public void a(b bVar) {
        this.aj.add(bVar);
    }

    public void a(c cVar) {
        this.ai.add(cVar);
    }

    public c d(int i) {
        int size = this.ai.size();
        for (int i2 = 0; i2 < size; i2++) {
            c cVar = (c) this.ai.get(i2);
            if (cVar.ag == i) {
                return cVar;
            }
        }
        return null;
    }

    public b e(int i) {
        int size = this.aj.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) this.aj.get(i2);
            if (bVar.ag == i) {
                return bVar;
            }
        }
        return null;
    }

    public String toString() {
        return a.c(this.ag) + " leaves: " + Arrays.toString(this.ai.toArray(new c[0])) + " containers: " + Arrays.toString(this.aj.toArray(new b[0]));
    }
}
