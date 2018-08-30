package com.google.android.exoplayer.extractor.b;

import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.k;
import com.google.android.exoplayer.util.h;
import com.google.android.exoplayer.util.i;

final class a extends d {
    private final h b = new h(new byte[8]);
    private final i c = new i(this.b.a);
    private int d = 0;
    private int e;
    private boolean f;
    private long g;
    private k h;
    private int i;
    private int j;
    private long k;

    public a(TrackOutput trackOutput) {
        super(trackOutput);
    }

    private boolean a(i iVar) {
        while (iVar.b() > 0) {
            if (this.f) {
                int f = iVar.f();
                if (f == 119) {
                    this.f = false;
                    return true;
                }
                this.f = f == 11;
            } else {
                this.f = iVar.f() == 11;
            }
        }
        return false;
    }

    private boolean a(i iVar, byte[] bArr, int i) {
        int min = Math.min(iVar.b(), i - this.e);
        iVar.a(bArr, this.e, min);
        this.e = min + this.e;
        return this.e == i;
    }

    private void c() {
        this.b.a(0);
        this.i = com.google.android.exoplayer.util.a.b(this.b);
        if (this.h == null) {
            this.b.a(0);
            this.h = com.google.android.exoplayer.util.a.a(this.b);
            this.a.format(this.h);
            this.j = com.google.android.exoplayer.util.a.a(this.i, this.h.h);
        }
        this.g = (long) ((int) ((8000 * ((long) this.i)) / ((long) this.j)));
    }

    public void a() {
        this.d = 0;
        this.e = 0;
        this.f = false;
    }

    public void a(i iVar, long j, boolean z) {
        if (z) {
            this.k = j;
        }
        while (iVar.b() > 0) {
            switch (this.d) {
                case 0:
                    if (!a(iVar)) {
                        break;
                    }
                    this.d = 1;
                    this.c.a[0] = (byte) 11;
                    this.c.a[1] = (byte) 119;
                    this.e = 2;
                    break;
                case 1:
                    if (!a(iVar, this.c.a, 8)) {
                        break;
                    }
                    c();
                    this.c.b(0);
                    this.a.sampleData(this.c, 8);
                    this.d = 2;
                    break;
                case 2:
                    int min = Math.min(iVar.b(), this.i - this.e);
                    this.a.sampleData(iVar, min);
                    this.e = min + this.e;
                    if (this.e != this.i) {
                        break;
                    }
                    this.a.sampleMetadata(this.k, 1, this.i, 0, null);
                    this.k += this.g;
                    this.d = 0;
                    break;
                default:
                    break;
            }
        }
    }

    public void b() {
    }
}
