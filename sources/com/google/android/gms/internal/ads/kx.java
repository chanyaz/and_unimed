package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;

final /* synthetic */ class kx implements Runnable {
    private final lk a;
    private final zzanz b;

    kx(lk lkVar, zzanz zzanz) {
        this.a = lkVar;
        this.b = zzanz;
    }

    public final void run() {
        lk lkVar = this.a;
        try {
            lkVar.b(this.b.get());
        } catch (ExecutionException e) {
            lkVar.a(e.getCause());
        } catch (Throwable e2) {
            Thread.currentThread().interrupt();
            lkVar.a(e2);
        } catch (Throwable e22) {
            lkVar.a(e22);
        }
    }
}
