package com.google.android.exoplayer.extractor.b;

import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.k;
import com.google.android.exoplayer.util.f;

final class i extends d {
    private final com.google.android.exoplayer.util.i b = new com.google.android.exoplayer.util.i(4);
    private final f c;
    private int d = 0;
    private int e;
    private boolean f;
    private boolean g;
    private long h;
    private int i;
    private long j;

    public i(TrackOutput trackOutput) {
        super(trackOutput);
        this.b.a[0] = (byte) -1;
        this.c = new f();
    }

    private void a(com.google.android.exoplayer.util.i iVar) {
        byte[] bArr = iVar.a;
        int d = iVar.d();
        int c = iVar.c();
        int i = d;
        while (i < c) {
            int i2;
            boolean z = (bArr[i] & 255) == 255;
            if (this.g && (bArr[i] & 224) == 224) {
                i2 = 1;
            } else {
                boolean i22 = false;
            }
            this.g = z;
            if (i22 != 0) {
                iVar.b(i + 1);
                this.g = false;
                this.b.a[1] = bArr[i];
                this.e = 2;
                this.d = 1;
                return;
            }
            i++;
        }
        iVar.b(c);
    }

    private void b(com.google.android.exoplayer.util.i iVar) {
        int min = Math.min(iVar.b(), 4 - this.e);
        iVar.a(this.b.a, this.e, min);
        this.e = min + this.e;
        if (this.e >= 4) {
            this.b.b(0);
            if (f.a(this.b.j(), this.c)) {
                this.i = this.c.c;
                if (!this.f) {
                    this.h = (1000000 * ((long) this.c.g)) / ((long) this.c.d);
                    this.a.format(k.b(this.c.b, 4096, -1, this.c.e, this.c.d, null));
                    this.f = true;
                }
                this.b.b(0);
                this.a.sampleData(this.b, 4);
                this.d = 2;
                return;
            }
            this.e = 0;
            this.d = 1;
        }
    }

    private void c(com.google.android.exoplayer.util.i iVar) {
        int min = Math.min(iVar.b(), this.i - this.e);
        this.a.sampleData(iVar, min);
        this.e = min + this.e;
        if (this.e >= this.i) {
            this.a.sampleMetadata(this.j, 1, this.i, 0, null);
            this.j += this.h;
            this.e = 0;
            this.d = 0;
        }
    }

    public void a() {
        this.d = 0;
        this.e = 0;
        this.g = false;
    }

    public void a(com.google.android.exoplayer.util.i iVar, long j, boolean z) {
        if (z) {
            this.j = j;
        }
        while (iVar.b() > 0) {
            switch (this.d) {
                case 0:
                    a(iVar);
                    break;
                case 1:
                    b(iVar);
                    break;
                case 2:
                    c(iVar);
                    break;
                default:
                    break;
            }
        }
    }

    public void b() {
    }
}
