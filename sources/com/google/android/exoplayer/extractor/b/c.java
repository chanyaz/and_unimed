package com.google.android.exoplayer.extractor.b;

import android.util.Pair;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.k;
import com.google.android.exoplayer.util.h;
import com.google.android.exoplayer.util.i;
import java.util.Collections;

final class c extends d {
    private final h b = new h(new byte[7]);
    private int c = 0;
    private int d;
    private boolean e;
    private boolean f;
    private boolean g;
    private long h;
    private int i;
    private long j;

    public c(TrackOutput trackOutput) {
        super(trackOutput);
    }

    private boolean a(i iVar) {
        byte[] bArr = iVar.a;
        int d = iVar.d();
        int c = iVar.c();
        for (int i = d; i < c; i++) {
            boolean z = (bArr[i] & 255) == 255;
            boolean z2 = this.e && !z && (bArr[i] & 240) == 240;
            this.e = z;
            if (z2) {
                this.f = (bArr[i] & 1) == 0;
                iVar.b(i + 1);
                this.e = false;
                return true;
            }
        }
        iVar.b(c);
        return false;
    }

    private boolean a(i iVar, byte[] bArr, int i) {
        int min = Math.min(iVar.b(), i - this.d);
        iVar.a(bArr, this.d, min);
        this.d = min + this.d;
        return this.d == i;
    }

    private void c() {
        this.b.a(0);
        if (this.g) {
            this.b.b(10);
        } else {
            int c = this.b.c(2) + 1;
            int c2 = this.b.c(4);
            this.b.b(1);
            Object a = com.google.android.exoplayer.util.c.a(c, c2, this.b.c(3));
            Pair a2 = com.google.android.exoplayer.util.c.a(a);
            k a3 = k.a("audio/mp4a-latm", -1, ((Integer) a2.second).intValue(), ((Integer) a2.first).intValue(), Collections.singletonList(a));
            this.h = 1024000000 / ((long) a3.h);
            this.a.format(a3);
            this.g = true;
        }
        this.b.b(4);
        this.i = (this.b.c(13) - 2) - 5;
        if (this.f) {
            this.i -= 2;
        }
    }

    public void a() {
        this.c = 0;
        this.d = 0;
        this.e = false;
    }

    public void a(i iVar, long j, boolean z) {
        if (z) {
            this.j = j;
        }
        while (iVar.b() > 0) {
            switch (this.c) {
                case 0:
                    if (!a(iVar)) {
                        break;
                    }
                    this.d = 0;
                    this.c = 1;
                    break;
                case 1:
                    if (!a(iVar, this.b.a, this.f ? 7 : 5)) {
                        break;
                    }
                    c();
                    this.d = 0;
                    this.c = 2;
                    break;
                case 2:
                    int min = Math.min(iVar.b(), this.i - this.d);
                    this.a.sampleData(iVar, min);
                    this.d = min + this.d;
                    if (this.d != this.i) {
                        break;
                    }
                    this.a.sampleMetadata(this.j, 1, this.i, 0, null);
                    this.j += this.h;
                    this.d = 0;
                    this.c = 0;
                    break;
                default:
                    break;
            }
        }
    }

    public void b() {
    }
}
