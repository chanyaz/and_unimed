package com.google.android.gms.internal.ads;

final class aum implements Runnable {
    private final /* synthetic */ auk a;
    private final /* synthetic */ aul b;

    aum(aul aul, auk auk) {
        this.b = aul;
        this.a = auk;
    }

    public final void run() {
        synchronized (this.b.i) {
            if (this.b.s != -2) {
                return;
            }
            this.b.r = this.b.d();
            if (this.b.r == null) {
                this.b.zzx(4);
            } else if (!this.b.e() || this.b.a(1)) {
                this.a.a(this.b);
                this.b.a(this.a);
            } else {
                String f = this.b.a;
                kk.e(new StringBuilder(String.valueOf(f).length() + 56).append("Ignoring adapter ").append(f).append(" as delayed impression is not supported").toString());
                this.b.zzx(2);
            }
        }
    }
}
