package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.util.VisibleForTesting;

@zzadh
public abstract class cj implements zzadx, zzalc<Void> {
    private final zzaol<zzaef> a;
    private final zzadx b;
    private final Object c = new Object();

    public cj(zzaol<zzaef> zzaol, zzadx zzadx) {
        this.a = zzaol;
        this.b = zzadx;
    }

    public abstract void a();

    @VisibleForTesting
    final boolean a(zzaen zzaen, zzaef zzaef) {
        try {
            zzaen.zza(zzaef, new cr(this));
            return true;
        } catch (Throwable th) {
            kk.c("Could not fetch ad response from ad request service due to an Exception.", th);
            au.i().a(th, "AdRequestClientTask.getAdResponseFromService");
            this.b.zza(new zzaej(0));
            return false;
        }
    }

    public abstract zzaen b();

    public final void cancel() {
        a();
    }

    public final void zza(zzaej zzaej) {
        synchronized (this.c) {
            this.b.zza(zzaej);
            a();
        }
    }

    public final /* synthetic */ Object zznt() {
        zzaen b = b();
        if (b == null) {
            this.b.zza(new zzaej(0));
            a();
        } else {
            this.a.zza(new ck(this, b), new cl(this));
        }
        return null;
    }
}
