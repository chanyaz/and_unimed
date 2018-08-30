package com.google.android.gms.internal.ads;

import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@zzadh
@ParametersAreNonnullByDefault
public final class atv {
    private final Object a = new Object();
    @GuardedBy("mLock")
    private atz b;

    public final atz a(Context context, zzang zzang) {
        atz atz;
        synchronized (this.a) {
            if (this.b == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    context = applicationContext;
                }
                this.b = new atz(context, zzang, (String) akc.f().a(amn.a));
            }
            atz = this.b;
        }
        return atz;
    }
}
