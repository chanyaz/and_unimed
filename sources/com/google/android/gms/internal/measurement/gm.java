package com.google.android.gms.internal.measurement;

import android.os.Bundle;

final class gm implements Runnable {
    private final /* synthetic */ boolean a;
    private final /* synthetic */ gk b;
    private final /* synthetic */ gk c;
    private final /* synthetic */ gl d;

    gm(gl glVar, boolean z, gk gkVar, gk gkVar2) {
        this.d = glVar;
        this.a = z;
        this.b = gkVar;
        this.c = gkVar2;
    }

    public final void run() {
        if (this.a && this.d.a != null) {
            this.d.a(this.d.a);
        }
        boolean z = (this.b != null && this.b.c == this.c.c && ie.b(this.b.b, this.c.b) && ie.b(this.b.a, this.c.a)) ? false : true;
        if (z) {
            Bundle bundle = new Bundle();
            gl.a(this.c, bundle, true);
            if (this.b != null) {
                if (this.b.a != null) {
                    bundle.putString("_pn", this.b.a);
                }
                bundle.putString("_pc", this.b.b);
                bundle.putLong("_pi", this.b.c);
            }
            this.d.e().b("auto", "_vs", bundle);
        }
        this.d.a = this.c;
        this.d.h().a(this.c);
    }
}
