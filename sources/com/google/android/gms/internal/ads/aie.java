package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

public final class aie implements zzaa {
    private final Executor a;

    public aie(Handler handler) {
        this.a = new ajf(this, handler);
    }

    public final void zza(apk<?> apk, auj<?> auj, Runnable runnable) {
        apk.k();
        apk.b("post-response");
        this.a.execute(new aka(this, apk, auj, runnable));
    }

    public final void zza(apk<?> apk, zzae zzae) {
        apk.b("post-error");
        this.a.execute(new aka(this, apk, auj.a(zzae), null));
    }

    public final void zzb(apk<?> apk, auj<?> auj) {
        zza(apk, auj, null);
    }
}
