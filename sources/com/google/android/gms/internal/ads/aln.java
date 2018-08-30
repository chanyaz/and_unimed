package com.google.android.gms.internal.ads;

import javax.annotation.concurrent.GuardedBy;

@zzadh
public final class aln {
    @GuardedBy("sLock")
    private static aln a;
    private static final Object b = new Object();
    private zzlj c;

    private aln() {
    }

    public static aln a() {
        aln aln;
        synchronized (b) {
            if (a == null) {
                a = new aln();
            }
            aln = a;
        }
        return aln;
    }

    public final float b() {
        float f = 1.0f;
        if (this.c == null) {
            return f;
        }
        try {
            return this.c.zzdo();
        } catch (Throwable e) {
            kk.b("Unable to get app volume.", e);
            return f;
        }
    }

    public final boolean c() {
        boolean z = false;
        if (this.c == null) {
            return z;
        }
        try {
            return this.c.zzdp();
        } catch (Throwable e) {
            kk.b("Unable to get app mute state.", e);
            return z;
        }
    }
}
