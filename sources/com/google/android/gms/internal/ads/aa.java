package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.SystemClock;
import javax.annotation.concurrent.GuardedBy;

@zzadh
public abstract class aa extends hg {
    protected final zzabm a;
    protected final Context b;
    protected final Object c = new Object();
    protected final Object d = new Object();
    protected final gs e;
    @GuardedBy("mLock")
    protected zzaej f;

    protected aa(Context context, gs gsVar, zzabm zzabm) {
        super(true);
        this.b = context;
        this.e = gsVar;
        this.f = gsVar.b;
        this.a = zzabm;
    }

    protected abstract gr a(int i);

    public final void a() {
        synchronized (this.c) {
            kk.b("AdRendererBackgroundTask started.");
            int i = this.e.e;
            try {
                a(SystemClock.elapsedRealtime());
            } catch (zzabk e) {
                int a = e.a();
                if (a == 3 || a == -1) {
                    kk.d(e.getMessage());
                } else {
                    kk.e(e.getMessage());
                }
                if (this.f == null) {
                    this.f = new zzaej(a);
                } else {
                    this.f = new zzaej(a, this.f.j);
                }
                ht.a.post(new ab(this));
                i = a;
            }
            ht.a.post(new ac(this, a(i)));
        }
    }

    protected abstract void a(long j);

    public void b() {
    }
}
