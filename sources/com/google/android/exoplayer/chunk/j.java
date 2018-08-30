package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.drm.a;
import com.google.android.exoplayer.k;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.c;
import com.google.android.exoplayer.util.i;
import com.google.android.exoplayer.util.m;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

public final class j extends a {
    private final k k;
    private final a l;
    private final byte[] m;
    private boolean n;
    private volatile int o;
    private volatile boolean p;

    public j(DataSource dataSource, c cVar, int i, f fVar, long j, long j2, int i2, boolean z, k kVar, a aVar, byte[] bArr) {
        super(dataSource, cVar, i, fVar, j, j2, i2, z, true);
        this.k = kVar;
        this.l = aVar;
        this.m = bArr;
    }

    public k b() {
        return this.k;
    }

    public a c() {
        return this.l;
    }

    public void cancelLoad() {
        this.p = true;
    }

    public long e() {
        return (long) this.o;
    }

    public boolean isLoadCanceled() {
        return this.p;
    }

    public void load() {
        int i = 0;
        if (!this.n) {
            if (this.m != null) {
                d().sampleData(new i(this.m), this.m.length);
            }
            this.n = true;
        }
        try {
            this.f.open(m.a(this.e, this.o));
            while (i != -1) {
                this.o = i + this.o;
                i = d().a(this.f, MoPubClientPositioning.NO_REPEAT, true);
            }
            int i2 = this.o;
            if (this.m != null) {
                i2 += this.m.length;
            }
            d().sampleMetadata(this.g, 1, i2, 0, null);
        } finally {
            this.f.close();
        }
    }
}
