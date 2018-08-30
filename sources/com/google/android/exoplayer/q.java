package com.google.android.exoplayer;

import com.google.android.exoplayer.ExoPlayer.ExoPlayerComponent;
import com.google.android.exoplayer.util.b;

public abstract class q implements ExoPlayerComponent {
    private int a;

    protected MediaClock a() {
        return null;
    }

    protected abstract void a(long j);

    protected abstract void a(long j, long j2);

    protected void a(long j, boolean z) {
    }

    protected abstract int b(long j);

    protected void b() {
    }

    final void b(long j, boolean z) {
        boolean z2 = true;
        if (this.a != 1) {
            z2 = false;
        }
        b.b(z2);
        this.a = 2;
        a(j, z);
    }

    final int c(long j) {
        boolean z = false;
        b.b(this.a == 0);
        this.a = b(j);
        if (this.a == 0 || this.a == 1 || this.a == -1) {
            z = true;
        }
        b.b(z);
        return this.a;
    }

    protected void c() {
    }

    protected abstract boolean d();

    protected abstract boolean e();

    protected void f() {
    }

    public void handleMessage(int i, Object obj) {
    }

    protected void l() {
    }

    protected abstract long m();

    protected abstract long n();

    protected abstract void o();

    protected final int r() {
        return this.a;
    }

    final void s() {
        b.b(this.a == 2);
        this.a = 3;
        b();
    }

    final void t() {
        b.b(this.a == 3);
        this.a = 2;
        c();
    }

    final void u() {
        b.b(this.a == 2);
        this.a = 1;
        f();
    }

    final void v() {
        boolean z = (this.a == 2 || this.a == 3 || this.a == -2) ? false : true;
        b.b(z);
        this.a = -2;
        l();
    }
}
