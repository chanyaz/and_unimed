package com.google.android.gms.ads;

import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.internal.ads.alx;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzlo;
import javax.annotation.concurrent.GuardedBy;

@zzadh
public final class k {
    private final Object a = new Object();
    @Nullable
    @GuardedBy("mLock")
    private zzlo b;
    @Nullable
    @GuardedBy("mLock")
    private l c;

    public final zzlo a() {
        zzlo zzlo;
        synchronized (this.a) {
            zzlo = this.b;
        }
        return zzlo;
    }

    public final void a(l lVar) {
        ar.a((Object) lVar, (Object) "VideoLifecycleCallbacks may not be null.");
        synchronized (this.a) {
            this.c = lVar;
            if (this.b == null) {
                return;
            }
            try {
                this.b.zza(new alx(lVar));
            } catch (Throwable e) {
                kk.b("Unable to call setVideoLifecycleCallbacks on video controller.", e);
            }
            return;
        }
    }

    public final void a(zzlo zzlo) {
        synchronized (this.a) {
            this.b = zzlo;
            if (this.c != null) {
                a(this.c);
            }
        }
    }
}
