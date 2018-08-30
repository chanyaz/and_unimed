package com.google.android.exoplayer.extractor.b;

import android.util.Log;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.util.h;
import com.google.android.exoplayer.util.i;

class n extends p {
    final /* synthetic */ l a;
    private final h b = new h(new byte[9]);
    private final d c;
    private int d = 0;
    private int e;
    private boolean f;
    private boolean g;
    private int h;
    private int i;
    private long j;

    public n(l lVar, d dVar) {
        this.a = lVar;
        super();
        this.c = dVar;
    }

    private void a(int i) {
        this.d = i;
        this.e = 0;
    }

    private boolean a(i iVar, byte[] bArr, int i) {
        int min = Math.min(iVar.b(), i - this.e);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            iVar.c(min);
        } else {
            iVar.a(bArr, this.e, min);
        }
        this.e = min + this.e;
        return this.e == i;
    }

    private boolean b() {
        this.b.a(0);
        int c = this.b.c(24);
        if (c != 1) {
            Log.w("TsExtractor", "Unexpected start code prefix: " + c);
            this.i = -1;
            return false;
        }
        this.b.b(8);
        int c2 = this.b.c(16);
        this.b.b(8);
        this.g = this.b.b();
        this.b.b(7);
        this.h = this.b.c(8);
        if (c2 == 0) {
            this.i = -1;
        } else {
            this.i = ((c2 + 6) - 9) - this.h;
        }
        return true;
    }

    private void c() {
        this.b.a(0);
        this.j = 0;
        if (this.g) {
            this.b.b(4);
            long c = ((long) this.b.c(3)) << 30;
            this.b.b(1);
            c |= (long) (this.b.c(15) << 15);
            this.b.b(1);
            c |= (long) this.b.c(15);
            this.b.b(1);
            this.j = this.a.a(c);
        }
    }

    public void a() {
        this.d = 0;
        this.e = 0;
        this.f = false;
        this.c.a();
    }

    public void a(i iVar, boolean z, ExtractorOutput extractorOutput) {
        if (z) {
            switch (this.d) {
                case 2:
                    Log.w("TsExtractor", "Unexpected start indicator reading extended header");
                    break;
                case 3:
                    if (this.i != -1) {
                        Log.w("TsExtractor", "Unexpected start indicator: expected " + this.i + " more bytes");
                    }
                    if (this.f) {
                        this.c.b();
                        break;
                    }
                    break;
            }
            a(1);
        }
        while (iVar.b() > 0) {
            switch (this.d) {
                case 0:
                    iVar.c(iVar.b());
                    break;
                case 1:
                    if (!a(iVar, this.b.a, 9)) {
                        break;
                    }
                    a(b() ? 2 : 0);
                    break;
                case 2:
                    if (a(iVar, this.b.a, Math.min(5, this.h)) && a(iVar, null, this.h)) {
                        c();
                        this.f = false;
                        a(3);
                        break;
                    }
                case 3:
                    int b = iVar.b();
                    int i = this.i == -1 ? 0 : b - this.i;
                    if (i > 0) {
                        b -= i;
                        iVar.a(iVar.d() + b);
                    }
                    this.c.a(iVar, this.j, !this.f);
                    this.f = true;
                    if (this.i == -1) {
                        break;
                    }
                    this.i -= b;
                    if (this.i != 0) {
                        break;
                    }
                    this.c.b();
                    a(1);
                    break;
                default:
                    break;
            }
        }
    }
}
