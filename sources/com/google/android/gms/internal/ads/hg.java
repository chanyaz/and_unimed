package com.google.android.gms.internal.ads;

@zzadh
public abstract class hg implements zzalc<zzanz> {
    private final Runnable a = new hh(this);
    private volatile Thread b;
    private boolean c = false;

    public hg(boolean z) {
    }

    public abstract void a();

    public abstract void b();

    public final void cancel() {
        b();
        if (this.b != null) {
            this.b.interrupt();
        }
    }

    public final zzanz f() {
        return this.c ? hr.b(this.a) : hr.a(this.a);
    }

    public final /* synthetic */ Object zznt() {
        return this.c ? hr.b(this.a) : hr.a(this.a);
    }
}
