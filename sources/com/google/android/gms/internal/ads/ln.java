package com.google.android.gms.internal.ads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@zzadh
public class ln<T> implements zzaol<T> {
    private final Object a = new Object();
    private int b = 0;
    private final BlockingQueue<lo> c = new LinkedBlockingQueue();
    private T d;

    public final void a() {
        synchronized (this.a) {
            if (this.b != 0) {
                throw new UnsupportedOperationException();
            }
            this.b = -1;
            for (lo loVar : this.c) {
                loVar.b.run();
            }
            this.c.clear();
        }
    }

    public final int b() {
        return this.b;
    }

    public final void zza(zzaoo<T> zzaoo, zzaom zzaom) {
        synchronized (this.a) {
            if (this.b == 1) {
                zzaoo.zze(this.d);
            } else if (this.b == -1) {
                zzaom.run();
            } else if (this.b == 0) {
                this.c.add(new lo(this, zzaoo, zzaom));
            }
        }
    }

    public final void zzk(T t) {
        synchronized (this.a) {
            if (this.b != 0) {
                throw new UnsupportedOperationException();
            }
            this.d = t;
            this.b = 1;
            for (lo loVar : this.c) {
                loVar.a.zze(t);
            }
            this.c.clear();
        }
    }
}
