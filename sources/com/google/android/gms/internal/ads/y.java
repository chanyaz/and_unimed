package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.internal.ar;
import java.util.concurrent.atomic.AtomicBoolean;

@zzadh
public abstract class y implements zzalc<Void>, zzasd {
    protected final Context a;
    protected final zzaqw b;
    protected zzaej c;
    private final zzabm d;
    private final gs e;
    private Runnable f;
    private final Object g = new Object();
    private AtomicBoolean h = new AtomicBoolean(true);

    protected y(Context context, gs gsVar, zzaqw zzaqw, zzabm zzabm) {
        this.a = context;
        this.e = gsVar;
        this.c = this.e.b;
        this.b = zzaqw;
        this.d = zzabm;
    }

    protected abstract void a();

    protected void a(int i) {
        if (i != -2) {
            this.c = new zzaej(i, this.c.j);
        }
        this.b.zztz();
        zzabm zzabm = this.d;
        zzaef zzaef = this.e.a;
        zzabm zzabm2 = zzabm;
        zzabm2.zzb(new gr(zzaef.c, this.b, this.c.c, i, this.c.e, this.c.i, this.c.k, this.c.j, zzaef.i, this.c.g, null, null, null, null, null, this.c.h, this.e.d, this.c.f, this.e.f, this.c.m, this.c.n, this.e.h, null, this.c.A, this.c.B, this.c.C, this.c.D, this.c.E, null, this.c.H, this.c.L, this.e.i, this.e.b.O, this.e.j, this.e.b.Q, this.c.R, this.e.b.S, this.e.b.T));
    }

    public void cancel() {
        if (this.h.getAndSet(false)) {
            this.b.stopLoading();
            au.g();
            hz.a(this.b);
            a(-1);
            ht.a.removeCallbacks(this.f);
        }
    }

    public final void zze(boolean z) {
        int i = 0;
        kk.b("WebView finished loading.");
        if (this.h.getAndSet(false)) {
            if (z) {
                i = -2;
            }
            a(i);
            ht.a.removeCallbacks(this.f);
        }
    }

    public final /* synthetic */ Object zznt() {
        ar.b("Webview render task needs to be called on UI thread.");
        this.f = new z(this);
        ht.a.postDelayed(this.f, ((Long) akc.f().a(amn.bB)).longValue());
        a();
        return null;
    }
}
