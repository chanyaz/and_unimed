package com.google.android.exoplayer.extractor;

import com.google.android.exoplayer.k;
import com.google.android.exoplayer.m;
import com.google.android.exoplayer.upstream.Allocator;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.util.i;

public class c implements TrackOutput {
    private final h a;
    private final m b = new m(0);
    private boolean c = true;
    private long d = Long.MIN_VALUE;
    private long e = Long.MIN_VALUE;
    private volatile long f = Long.MIN_VALUE;
    private volatile k g;

    public c(Allocator allocator) {
        this.a = new h(allocator);
    }

    private boolean h() {
        boolean a = this.a.a(this.b);
        if (this.c) {
            while (a && !this.b.c()) {
                this.a.d();
                a = this.a.a(this.b);
            }
        }
        return !a ? false : this.e == Long.MIN_VALUE || this.b.e < this.e;
    }

    public int a(DataSource dataSource, int i, boolean z) {
        return this.a.a(dataSource, i, z);
    }

    public void a() {
        this.a.a();
        this.c = true;
        this.d = Long.MIN_VALUE;
        this.e = Long.MIN_VALUE;
        this.f = Long.MIN_VALUE;
    }

    public void a(int i) {
        this.a.a(i);
        this.f = this.a.a(this.b) ? this.b.e : Long.MIN_VALUE;
    }

    public void a(long j) {
        while (this.a.a(this.b) && this.b.e < j) {
            this.a.d();
            this.c = true;
        }
        this.d = Long.MIN_VALUE;
    }

    public boolean a(c cVar) {
        if (this.e != Long.MIN_VALUE) {
            return true;
        }
        long j = this.a.a(this.b) ? this.b.e : this.d + 1;
        h hVar = cVar.a;
        while (hVar.a(this.b) && (this.b.e < j || !this.b.c())) {
            hVar.d();
        }
        if (!hVar.a(this.b)) {
            return false;
        }
        this.e = this.b.e;
        return true;
    }

    public boolean a(m mVar) {
        if (!h()) {
            return false;
        }
        this.a.b(mVar);
        this.c = false;
        this.d = mVar.e;
        return true;
    }

    public int b() {
        return this.a.b();
    }

    public boolean b(long j) {
        return this.a.a(j);
    }

    public int c() {
        return this.a.c();
    }

    public boolean d() {
        return this.g != null;
    }

    public k e() {
        return this.g;
    }

    public long f() {
        return this.f;
    }

    public void format(k kVar) {
        this.g = kVar;
    }

    public boolean g() {
        return !h();
    }

    public int sampleData(ExtractorInput extractorInput, int i, boolean z) {
        return this.a.a(extractorInput, i, z);
    }

    public void sampleData(i iVar, int i) {
        this.a.a(iVar, i);
    }

    public void sampleMetadata(long j, int i, int i2, int i3, byte[] bArr) {
        this.f = Math.max(this.f, j);
        this.a.a(j, i, (this.a.e() - ((long) i2)) - ((long) i3), i2, bArr);
    }
}
