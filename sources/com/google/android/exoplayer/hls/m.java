package com.google.android.exoplayer.hls;

import com.google.android.exoplayer.chunk.f;
import com.google.android.exoplayer.chunk.i;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.b;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.c;

public final class m extends i {
    public final d a;
    private final boolean k = (this.f instanceof a);
    private int l;
    private volatile boolean m;

    public m(DataSource dataSource, c cVar, int i, f fVar, long j, long j2, int i2, boolean z, d dVar, byte[] bArr, byte[] bArr2) {
        super(a(dataSource, bArr, bArr2), cVar, i, fVar, j, j2, i2, z);
        this.a = dVar;
    }

    private static DataSource a(DataSource dataSource, byte[] bArr, byte[] bArr2) {
        return (bArr == null || bArr2 == null) ? dataSource : new a(dataSource, bArr, bArr2);
    }

    public void cancelLoad() {
        this.m = true;
    }

    public long e() {
        return (long) this.l;
    }

    public boolean isLoadCanceled() {
        return this.m;
    }

    public void load() {
        int i;
        c cVar;
        int i2 = 0;
        if (this.k) {
            i = this.l != 0 ? 1 : 0;
            cVar = this.e;
        } else {
            i = 0;
            cVar = com.google.android.exoplayer.util.m.a(this.e, this.l);
        }
        ExtractorInput bVar;
        try {
            bVar = new b(this.f, cVar.c, this.f.open(cVar));
            if (i != 0) {
                bVar.skipFully(this.l);
            }
            while (i2 == 0) {
                if (!this.m) {
                    i2 = this.a.a(bVar);
                }
            }
            this.l = (int) (bVar.getPosition() - this.e.c);
            this.f.close();
        } catch (Throwable th) {
            this.f.close();
        }
    }
}
