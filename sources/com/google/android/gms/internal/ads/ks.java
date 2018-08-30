package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

final /* synthetic */ class ks implements Runnable {
    private final lk a;
    private final zzank b;
    private final zzanz c;

    ks(lk lkVar, zzank zzank, zzanz zzanz) {
        this.a = lkVar;
        this.b = zzank;
        this.c = zzanz;
    }

    public final void run() {
        Throwable e;
        lk lkVar = this.a;
        try {
            lkVar.b(this.b.apply(this.c.get()));
        } catch (CancellationException e2) {
            lkVar.cancel(true);
        } catch (ExecutionException e3) {
            e = e3;
            Throwable cause = e.getCause();
            if (cause != null) {
                e = cause;
            }
            lkVar.a(e);
        } catch (Throwable e4) {
            Thread.currentThread().interrupt();
            lkVar.a(e4);
        } catch (Throwable e42) {
            lkVar.a(e42);
        }
    }
}
