package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;

final /* synthetic */ class kr implements Runnable {
    private final zzanl a;
    private final zzanz b;

    kr(zzanl zzanl, zzanz zzanz) {
        this.a = zzanl;
        this.b = zzanz;
    }

    public final void run() {
        Throwable e;
        zzanl zzanl = this.a;
        try {
            zzanl.zzh(this.b.get());
            return;
        } catch (ExecutionException e2) {
            e = e2.getCause();
        } catch (InterruptedException e3) {
            e = e3;
            Thread.currentThread().interrupt();
        } catch (Exception e4) {
            e = e4;
        }
        zzanl.zzb(e);
    }
}
