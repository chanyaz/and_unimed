package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

@zzadh
public final class lf {
    public static final Executor a = new lg();
    public static final Executor b = new lh();
    private static final zzaod c = a(a);
    private static final zzaod d = a(b);

    public static zzaod a(Executor executor) {
        return new li(executor, null);
    }
}
