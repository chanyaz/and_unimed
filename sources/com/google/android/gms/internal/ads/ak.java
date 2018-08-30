package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.ac;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzadh
public final class ak extends hg {
    private final zzabm a;
    private final zzaej b;
    private final gs c;
    private final am d;
    private final Object e;
    private Future<gr> f;

    public ak(Context context, ac acVar, gs gsVar, ada ada, zzabm zzabm, ana ana) {
        this(gsVar, zzabm, new am(context, acVar, new jb(context), ada, gsVar, ana));
    }

    private ak(gs gsVar, zzabm zzabm, am amVar) {
        this.e = new Object();
        this.c = gsVar;
        this.b = gsVar.b;
        this.a = zzabm;
        this.d = amVar;
    }

    public final void a() {
        gr grVar;
        int i = -2;
        try {
            synchronized (this.e) {
                this.f = hr.a(this.d);
            }
            grVar = (gr) this.f.get(60000, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            kk.e("Timed out waiting for native ad.");
            i = 2;
            this.f.cancel(true);
            grVar = null;
        } catch (ExecutionException e2) {
            i = 0;
            grVar = null;
        } catch (InterruptedException e3) {
            i = 0;
            grVar = null;
        } catch (CancellationException e4) {
            i = 0;
            grVar = null;
        }
        if (grVar == null) {
            grVar = new gr(this.c.a.c, null, null, i, null, null, this.b.k, this.b.j, this.c.a.i, false, null, null, null, null, null, this.b.h, this.c.d, this.b.f, this.c.f, this.b.m, this.b.n, this.c.h, null, null, null, null, this.c.b.D, this.c.b.E, null, null, this.b.L, this.c.i, this.c.b.O, false, this.c.b.Q, null, this.c.b.S, this.c.b.T);
        }
        ht.a.post(new al(this, grVar));
    }

    public final void b() {
        synchronized (this.e) {
            if (this.f != null) {
                this.f.cancel(true);
            }
        }
    }
}
